package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String sql = "CREATE TABLE userss (id SERIAL PRIMARY KEY , name VARCHAR(50), last_name VARCHAR(50), age SMALLINT);";
        try {
            Connection connection = Util.getConnection();

            Statement statement = connection.createStatement();

            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println("База данных уже существует.");
        }
        System.out.println("База создана");
    }


    public void saveUser(String name, String lastName, byte age) {
      String sql = "INSERT INTO userss (name, last_name, age) VALUES (?, ?, ?)";
        try {
            Connection connection = Util.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
            System.out.println("Пользователь с именем " + name + " добавлен");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка при добавлении");
        }
    }



    public void dropUsersTable() {
       String sql = "DROP TABLE IF EXISTS userss;";
        try{
            Connection connection = Util.getConnection();
            Statement statement = connection.createStatement();
            statement.execute(sql);

        }catch(SQLException e){
            System.out.println("Базы данных не существует с данным именем");
        }
        System.out.println("БД удалена.");
    }
     public void removeUserById(long id) {
   String sql = "DELETE from userss where id =?";
   try {
       Connection connection = Util.getConnection();

        PreparedStatement preparedStatement =connection.prepareStatement(sql);
       preparedStatement.setLong(1, id);
       preparedStatement.executeUpdate();
       System.out.println("Пользователь с id " + id + "удален. ");
        } catch(SQLException e){
       System.out.println("Ошибка при удалении");
        }
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
       String sql = "SELECT * FROM userss";
        try {
            Connection connection = Util.getConnection();
           Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setAge(resultSet.getByte("age"));
                userList.add(user);
            }
            System.out.println("Список пользователей получен ");
        } catch (SQLException e) {
            e.printStackTrace();

            System.out.println(" Ошибка при получении списка");

        }

        return userList;
    }

    public void cleanUsersTable() {
       String sql = "TRUNCATE TABLE userss";
       try {
           Connection connection = Util.getConnection();

           Statement statement = Util.getConnection().createStatement();
           statement.executeUpdate(sql);
           System.out.println("Таблица пользователей очищена");
       } catch (SQLException e) {
           System.out.println("Ошибка при очистке таблицы");
       }

   }
    }
