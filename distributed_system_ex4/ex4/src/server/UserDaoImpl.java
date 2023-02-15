package server;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements Serializable,UserDao{

    private List<User> userDaoList = new ArrayList<>();

    public UserDaoImpl() {

        userDaoList.add(new User("zjj", "zjj"));

    }

    /**
     * add a specific user into the list
     * @param username user name
     * @param password user password
     * @return the added user entity
     * @throws RemoteException RemoteException
     */
    @Override
    public User addUser(String username, String password) throws RemoteException {
        if (!hasUser(username)) {
            User user = new User(username, password);
            userDaoList.add(user);
            System.out.println("[ÐÂÓÃ»§×¢²á]:" + username);

            return user;
        }
        return null;
    }

    /**
     * find user by user id
     * @param username user name
     * @return the found user
     * @throws RemoteException RemoteException
     */
    @Override
    public User getUserById(String username) throws RemoteException {

        for (User user : userDaoList) {
            if (user.getName().equals(username)) return user;
        }
        return null;
    }

    /**
     * has the user been in the list?
     * @param username user name
     * @return if the user is in the list,return true,otherwise,return false.
     * @throws RemoteException RemoteException
     */
    @Override
    public boolean hasUser(String username) throws RemoteException {
        for (User user : userDaoList) {
            if (user.getName().equals(username)) return true;
        }
        return false;
    }

    @Override
    public boolean deleteUser(String username) throws RuntimeException {
        return false;
    }




    public List<User> getUserDaoList() {
        return userDaoList;
    }
}
