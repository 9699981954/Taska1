package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        UserServiceImpl userService = new UserServiceImpl();
        userService.dropUsersTable();

        userService.createUsersTable();
        userService.saveUser("Дональд", "Трамп", (byte) 65);
        userService.saveUser("Илон", "Маск", (byte) 40);
        userService.saveUser("Леонардо", "Дикаприо", (byte) 50);
        userService.saveUser("Брэд", "Питт", (byte) 60);


        List<User> userList =  userService.getAllUsers();
        for(User user:userList) {
            System.out.println(user);



     /*       List<User> userList = userService.getAllUsers();
            userList.stream().forEach(System.out::println);

            Util.closeSession();*/


        userService.removeUserById(3);


        }

       userService.cleanUsersTable();

    }

}
