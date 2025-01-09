// File: src/main/java/ma/enset/exam_mohammed_elbadry/dao/SingletonConnexionDB.java
package ma.enset.exam_mohammed_elbadry.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnexionDB {
    public static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/EXAM_JAVA", "root", "");
            System.out.println("Connection to the database established successfully.");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        return connection;
    }
}