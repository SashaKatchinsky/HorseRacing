package by.epam.java.horse_racing.service;

import by.epam.java.horse_racing.action.PasswordHasher;
import by.epam.java.horse_racing.bean.Access;
import by.epam.java.horse_racing.bean.User;
import by.epam.java.horse_racing.dao.UserDaoMySql;
import by.epam.java.horse_racing.dao.exceptions.DaoException;
import by.epam.java.horse_racing.service.exceptions.CheckLoginPasswordException;
import by.epam.java.horse_racing.service.exceptions.UpdateUserException;
import by.epam.java.horse_racing.service.impl.Service;

import java.util.Arrays;

/**
 * The type User service.
 */
public class UserService implements Service {
    private static class UserServiceHolder {
        private static final UserService INSTANCE = new UserService();
    }

    private UserService() {

    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static UserService getInstance() {
        return UserServiceHolder.INSTANCE;
    }

    /**
     * Check login and password for compliance in db.
     *
     * @param login    the login
     * @param password the password
     * @return the boolean
     * @throws CheckLoginPasswordException the check login password exception
     */
    public boolean checkLoginPassword(String login , char[] password) {
        boolean isExists;
        char[] actualPassword;
        try {
            isExists = UserDaoMySql.getInstance().isExists(login);
            actualPassword = UserDaoMySql.getInstance().getUserByLogin(login).getPassword();
        } catch (DaoException e) {
            return false;
        }
        if (isExists) {
            char[] hashPassword = PasswordHasher.getInstance().hash(password).toCharArray();
            return Arrays.equals(actualPassword, hashPassword);
        } else {
            return false;
        }
    }

    /**
     * Update user.
     *
     * @param login   the login
     * @param name    the name
     * @param balance the balance
     * @param access  the access
     * @throws UpdateUserException the update user exception
     */
    public void updateUser(String login , String name , double balance , Access access) throws UpdateUserException {
        try {
            User updatedUser = UserDaoMySql.getInstance().getUserByLogin(login);
            updatedUser.setName(name);
            updatedUser.setBalance(balance);
            updatedUser.setAccess(access);
            UserDaoMySql.getInstance().updateUser(login, updatedUser);
        } catch (DaoException e) {
            throw new UpdateUserException(e);
        }
    }
}