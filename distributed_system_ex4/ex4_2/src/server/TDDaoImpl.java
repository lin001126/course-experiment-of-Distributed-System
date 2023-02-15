package server;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class TDDaoImpl implements Serializable, TDDao {

    private List<TD> TDList = new ArrayList<>();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");

    /**
     * add the TD for the user
     * @param username user name
     * @param password user password
     * @param begin begin date
     * @param end end date
     * @param title TD title
     * @return the TD id
     * @throws ParseException ParseException
     */
    @Override
    public String addTD(String username, String password, Date begin, Date end, String title) throws ParseException {

        String TDId = getUUID();
        TD TD = new TD(TDId, begin, end, title, new User(username, password));
        TDList.add(TD);
        return TD.getTDId();

    }

    /**
     * delete the TD for the user
     * @param TDId TD id
     * @return the deleted TD
     */
    @Override
    public TD deleteTD(String TDId) {
        TD TD = getTDById(TDId);

        if(TD != null) {
            TDList.remove(TD);
        }
        return TD;
    }

    /**
     * clear all the TD
     * @param oldTD oldTD
     */
    @Override
    public void clearTD(List<TD> oldTD) {
        if(oldTD == null || oldTD.size() == 0)return;
        for(TD TD : oldTD){
            TDList.remove(TD);
        }
    }

    /**
     * get all the TD
     * @return TD list
     */
    @Override
    public List<TD> getTDList() {
        return TDList;
    }

    /**
     * find TD by TD id
     * @param TDId TD id
     * @return TD
     */
    public TD getTDById(String TDId){
        if(TDList == null) return null;
        for(TD TD : TDList){
            if(TD.getTDId().equals(TDId))return TD;
        }
        return null;
    }

    /**
     * find TDs by user name
     * @param username user name
     * @return the TD list belonged to user
     */
    public List<TD> getTDsByUser(String username){
        if(TDList == null) return null;
        List<TD> res = new ArrayList<>();

        for(TD TD : TDList){
            if(TD.getCreator().getName().equals(username))res.add(TD);
        }

        return res;
    }


    /**
     * generate the identity id
     * @return the id
     */
    public static String getUUID() {

        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
