package ma.enset.exam_mohammed_elbadry.dao;

import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnexionDB {
    public static java.sql.Connection connection ;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/EXAM_JAVA", "root", "");

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static java.sql.Connection getConnection() {
        return connection;
    }
}
