package server;

import java.rmi.RemoteException;

public interface UserDao {

    User addUser(String username,String password)throws RemoteException;

    User getUserById(String username) throws RemoteException;

    boolean hasUser(String username) throws RemoteException;

    boolean deleteUser(String username) throws RuntimeException;







}
