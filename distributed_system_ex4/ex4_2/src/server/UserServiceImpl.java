package server;


import javax.jws.WebService;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@WebService
public class UserServiceImpl extends UnicastRemoteObject implements Serializable, UserService {

    private UserDaoImpl userDao;
    private TDDaoImpl TDDao;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");

    public UserServiceImpl() throws RemoteException {
        userDao = new UserDaoImpl();
        TDDao = new TDDaoImpl();

    }


    @Override
    public String registry(String[] info) throws RemoteException {
        return registry(info[0],info[1]);
    }

    @Override
    public String addTD(String[] info) throws RemoteException {
        return addTD(info[0],info[1],info[2],info[3],info[4]);
    }

    @Override
    public String queryTD(String[] info) throws RemoteException {
        try {
            return queryTD(info[0], info[2],info[3]);
        }catch (ParseException p){
            return "输入时间格式有误";
        }
    }

    @Override
    public String deleteTD(String[] info) throws RemoteException {
        return deleteTD(info[0], info[2]);
    }

    @Override
    public String clearTD(String[] info) throws RemoteException {
        return clearTD(info[0]);
    }


    /**
     * for user registry
     * @param username user name
     * @param password uer password
     * @return response information
     * @throws RemoteException RemoteException
     */
    private String registry(String username, String password) throws RemoteException {

        User user = userDao.addUser(username,password);
        if(user != null)return username+",您已注册成功";
        return "该账号已被注册..";

    }

    /**
     * add a TD to the TDList linked with user
     * @param username user name
     * @param password uer password
     * @param begin TD begin time
     * @param end TD end time
     * @param title TD title
     * @return response information
     * @throws RemoteException RemoteException
     */
    private String addTD(String username, String password , String begin,
                            String end, String title) throws RemoteException {


        Date b;
        Date e;

        try{
            b = simpleDateFormat.parse(DateParse(begin));
            e = simpleDateFormat.parse(DateParse(end));
            if(b.after(e))return "时间反了";

            if (!hasMeet(username,b, e)) {
                String meeId = TDDao.addTD(username,password,b,e,title);
                System.out.println("[新事件注册]：" + meeId);
                return "事件添加成功！";
            }
        }catch (ParseException p){
            p.printStackTrace();
            return "输入时间格式有误";
        }
        return "时间冲突";
    }

    /**
     * parse the time to the required format
     * @param begin begin date
     * @return the required format date
     * @throws ParseException ParseException
     */
    private String DateParse(String begin) throws ParseException {
        StringBuilder res = new StringBuilder(begin);
        if(begin.contains("今")){
            int length = begin.length();
            String hour = begin.substring(2,length-1);
//            System.out.println(hour);
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            res = new StringBuilder(sdf.format(d) + "-" + hour + ":00:00");
        }
        else if(begin.split("-").length != 4){
            res.append("-").append("00:00:00");
        }
        else if(begin.split(":").length != 3){
            for(int i =0;i<3-begin.split(":").length;i++) res.append(":00");
        }
//        System.out.println(res.toString());
        return res.toString();
    }

    /**
     * has the meet or not ?
     * @param username user name
     * @param begin begin date
     * @param end end date
     * @return has the meet or not?
     * @throws RemoteException RemoteException
     */
    private boolean hasMeet(String username,Date begin, Date end)throws RemoteException {

        List<TD> oldTD = TDDao.getTDsByUser(username);
        if (oldTD == null || oldTD.size() == 0) return false;

        oldTD.sort((o1, o2) -> {
            if (o1.getBegin().before(o2.getBegin())) return 1;
            else if(o1.getBegin().after(o2.getBegin()))return 0;
            else return -1;
        });

        System.out.println(Arrays.toString(oldTD.toArray()));
        int n = oldTD.size();
        if (end.before(oldTD.get(0).getBegin()) || begin.after(oldTD.get(n - 1).getEnd()))
            return false;

        for (int i = 0; i < n - 1; i++) {
            if (begin.after(oldTD.get(i).getEnd()) &&
                    end.before(oldTD.get(i + 1).getBegin()))
                return false;
        }
        return true;
    }

    /**
     *
     * @param username user name
     * @param b begin date
     * @param e end date
     * @return the result of meet list
     * @throws RemoteException RemoteException
     * @throws ParseException ParseException
     */
    private String queryTD(String username, String b, String e) throws RemoteException,ParseException {

        List<TD> oldTD = TDDao.getTDsByUser(username);
        if (oldTD == null || oldTD.size() == 0)return "待办事件为空";
        Date begin = simpleDateFormat.parse(DateParse(b));
        Date end = simpleDateFormat.parse(DateParse(e));

        List<TD> res = new ArrayList<>();
        for (TD TD : oldTD) {
            if (TD.getBegin().after(begin) && TD.getEnd().before(end)) {
                res.add(TD);
            }
        }
        return res.toString();
    }

    /**
     *
     * @param username user name
     * @param TDId the TD id
     * @return the response information
     * @throws RemoteException RemoteException
     */
    private String deleteTD(String username, String TDId)throws RemoteException {

        TD TD = TDDao.getTDById(TDId);

        if(TD != null){
            if(TD.getCreator().getName().equals(username)){

                TDDao.deleteTD(TDId);
                System.out.println("[事件删除：]" + TDId);
                return "已成功删除";
            }
            else return "您没有权限删除此事件";
        }
        return username+"！您的待办列表中并没有此事件";
    }

    /**
     * clear all meets of user
     * @param username user name
     * @return the response information
     * @throws RemoteException RemoteException
     */
    private String clearTD(String username)throws RemoteException {

        List<TD> oldTD = TDDao.getTDsByUser(username);
        TDDao.clearTD(oldTD);

        return username+"！您的事件已全部清空！";
    }


    public String getTDList() throws RemoteException{
        return "所有事件：\n"+ TDDao.getTDList().toString()+"\n用户列表：" + userDao.getUserDaoList().toString();
    }

    /**
     * check the user is registered.
     * @param info contains the username and password.
     * @return the result
     * @throws RemoteException RemoteException
     */
    public boolean checkId(String[] info) throws RemoteException {
        //info[0]对应账号，info[1]对应密码
        System.out.println(info[0]+info[1]);
        return userDao.hasUser(info[0]) && userDao.getUserById(info[0]).getPassword().equals(info[1]);
    }


}
