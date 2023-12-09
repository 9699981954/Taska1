package jm.task.core.jdbc.service;

import jm.task.core.jdbc.model.User;

import java.util.List;

public interface UserService {
    void createUsersTable();



    void saveUser(String name, String lastName, byte age);

   void removeUserById(long id);

    List<User> getAllUsers();
    void dropUsersTable();
    void cleanUsersTable();
}
