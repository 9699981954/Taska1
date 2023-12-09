package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    private static final String DB_DRIVER = "org.postgresql.Driver";

    private static final String DB_URL = "jdbc:postgresql://localhost:5433/postgres";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "admin";

 // private static final String DB_DIALECT = "org.hibernate.dialect.PostgreSQL94Dialect";


   public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER);
           connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Соединение установлено");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Ошибка соединения с БД");
            return null;
        }
            return connection;
        }



 /*  private static SessionFactory sessionFactory;
    public static SessionFactory getSession(){
        if(sessionFactory == null){
            try{
                Configuration configuration = new Configuration();

                Properties settings = new Properties();
                settings.put(Environment.DRIVER, DB_DRIVER);
                settings.put(Environment.URL, DB_URL);
                settings.put(Environment.USER, DB_USER);
                settings.put(Environment.PASS, DB_PASSWORD);
                settings.put(Environment.DIALECT, DB_DIALECT);

                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "create-drop");

                configuration.setProperties(settings);
                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry =  new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            }catch (Exception ex){
                System.out.println("Ошибка при подключении к базе данных");
            }
        }return sessionFactory;
    }
//    public static void closeConnect() {
//        Connection connect = Util.getConnect();
//        try {
//            connect.close();
//        } catch (SQLException e) {
//            System.out.println("Не удалось закрыть соединение");
//        }
//    }

    public static void closeSession() {
        SessionFactory sessionFactory = Util.getSession();
        sessionFactory.close();
    }*/

    }




