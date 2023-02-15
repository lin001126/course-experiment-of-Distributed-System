package server;


import javax.jws.WebService;
import javax.xml.ws.BindingType;
import javax.xml.ws.soap.SOAPBinding;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@WebService
//@BindingType(value= SOAPBinding.SOAP12HTTP_BINDING)
public class UserServiceImpl extends UnicastRemoteObject implements Serializable, UserService {

    private UserDaoImpl userDao;
    private EventDaoImpl eventDao;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");

    public UserServiceImpl() throws RemoteException {
        userDao = new UserDaoImpl();
        eventDao = new EventDaoImpl();

    }


    @Override
    public String registry(String[] info) throws RemoteException {
        return registry(info[0],info[1]);
    }

    @Override
    public String addMeet(String[] info) throws RemoteException {
        return addEvent(info[0],info[1],info[2],info[3],info[4]);
    }

    @Override
    public String queryMeet(String[] info) throws RemoteException, ParseException {
        try {
            return queryMeet(info[0],info[1],info[2],info[3]);
        }catch (ParseException p){
            return "输入时间格式有误";
        }
    }

    @Override
    public String deleteMeet(String[] info) throws RemoteException {
        return deleteMeet(info[0],info[1],info[2]);
    }

    @Override
    public String clearMeet(String[] info) throws RemoteException {
        return clearMeet(info[0],info[1]);
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
        if(user != null)return "您好！"+username+",您已注册成功";
        return "该账号已被注册..";

    }

    /**
     * add a event to the eventList linked with user
     * @param username user name
     * @param password uer password
     * @param begin event begin time
     * @param end event end time
     * @param title event title
     * @return response information
     * @throws RemoteException RemoteException
     */
    private String addEvent(String username, String password , String begin,
                            String end, String title) throws RemoteException {


        Date b;
        Date e;

        try{
            b = simpleDateFormat.parse(DateParse(begin));
            e = simpleDateFormat.parse(DateParse(end));
            if(b.after(e))return "时间反了吧！";

            if (!hasMeet(username,b, e)) {
                String meeId = eventDao.addEvent(username,password,b,e,title);
                System.out.println("[新事件注册]：" + meeId);
                return "事件添加成功！";
            }
        }catch (ParseException p){
            p.printStackTrace();
            return "输入时间格式有误";
        }
        return "您的时间冲突啦";
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

        List<Event> oldEvent = eventDao.getEventsByUser(username);
        if (oldEvent == null || oldEvent.size() == 0) return false;

        oldEvent.sort(new Comparator<Event>() {
            @Override
            public int compare(Event o1, Event o2) {
                if (o1.getBegin().before(o2.getBegin())) return 1;
                else if(o1.getBegin().after(o2.getBegin()))return 0;
                else return -1;
            }
        });

        System.out.println(oldEvent.toArray().toString());
        int n = oldEvent.size();
        if (end.before(oldEvent.get(0).getBegin()) || begin.after(oldEvent.get(n - 1).getEnd()))
            return false;

        for (int i = 0; i < n - 1; i++) {
            if (begin.after(oldEvent.get(i).getEnd()) &&
                    end.before(oldEvent.get(i + 1).getBegin()))
                return false;
        }
        return true;
    }

    /**
     *
     * @param username user name
     * @param password user password
     * @param b begin date
     * @param e end date
     * @return the result of meet list
     * @throws RemoteException RemoteException
     * @throws ParseException ParseException
     */
    private String queryMeet(String username, String password, String b, String e) throws RemoteException,ParseException {

        List<Event> oldEvent = eventDao.getEventsByUser(username);
        if (oldEvent == null || oldEvent.size() == 0)return "您当前还没有任何待办事件哦！";
        Date begin = simpleDateFormat.parse(DateParse(b));
        Date end = simpleDateFormat.parse(DateParse(e));

        List<Event> res = new ArrayList<>();
        for (Event event : oldEvent) {
            if (event.getBegin().after(begin) && event.getEnd().before(end)) {
                res.add(event);
            }
        }
        return res.toString();
    }

    /**
     *
     * @param username user name
     * @param password user password
     * @param eventId the event id
     * @return the response information
     * @throws RemoteException RemoteException
     */
    private String deleteMeet(String username, String password, String eventId)throws RemoteException {

        Event event = eventDao.getEventById(eventId);

        if(event != null){
            if(event.getCreator().getName().equals(username)){

                eventDao.deleteEvent(eventId);
                System.out.println("[事件删除：]" + eventId);
                return "已成功删除";
            }
            else return "您没有权限删除此事件";
        }
        return username+"！您的待办列表中并没有此事件呀！";
    }

    /**
     * clear all meets of user
     * @param username user name
     * @param password user password
     * @return the response information
     * @throws RemoteException RemoteException
     */
    private String clearMeet(String username, String password)throws RemoteException {

        List<Event> oldEvent = eventDao.getEventsByUser(username);
        eventDao.clearEvent(oldEvent);

        return username+"！您的事件已全部清空！";
    }


    public String getMeetingList() throws RemoteException{
        return "所有事件：\n"+ eventDao.getEventList().toString()+"\n用户列表：" + userDao.getUserDaoList().toString();
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
