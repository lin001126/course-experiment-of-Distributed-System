package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.text.ParseException;

public interface UserService extends Remote {


    String registry(String... info)throws RemoteException;


    String addTD(String... info) throws ParseException, RemoteException;

    String queryTD(String... info) throws RemoteException,ParseException;

    String deleteTD (String... info)throws RemoteException;

    String clearTD(String... info)throws RemoteException;

    String getTDList()throws RemoteException;

    boolean checkId(String... info) throws RemoteException;


}
