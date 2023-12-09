package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl extends UserDaoJDBCImpl /* UserDaoHibernateImpl */implements UserService {
   UserDao userDao = new UserDaoJDBCImpl();
 //  UserDao userDao = new UserDaoHibernateImpl();
    public void createUsersTable() {
        userDao.createUsersTable();
    }
    public List<User> getAllUsers() {
        List<User> userList = userDao.getAllUsers();
        return userList;
    }

    public void dropUsersTable() {
        userDao.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userDao.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        userDao.removeUserById(id);
    }


    public void cleanUsersTable() {
        userDao.cleanUsersTable();
    }
}
