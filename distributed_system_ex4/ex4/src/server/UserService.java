package server;



import javax.jws.WebService;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.Date;

public interface UserService extends Remote {


    String registry(String... info)throws RemoteException;
//    Event registry(String... info)throws RemoteException;

    String addMeet(String... info) throws ParseException, RemoteException;

    String queryMeet(String... info) throws RemoteException,ParseException;

    String deleteMeet (String... info)throws RemoteException;

    String clearMeet(String... info)throws RemoteException;

    String getMeetingList()throws RemoteException;

    boolean checkId(String... info) throws RemoteException;


}
