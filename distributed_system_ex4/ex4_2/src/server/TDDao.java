package server;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface TDDao {

    String addTD(String username, String password, Date begin,
                           Date end, String title) throws ParseException, RemoteException;



    TD deleteTD(String TDId)throws RemoteException;

    void clearTD(List<TD> oldTD)throws RemoteException;

    List<TD> getTDList()throws RemoteException;
}
