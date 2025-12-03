package db;
import java.sql.*;

public class DBUtil {
    private static String url = "jdbc:mariadb://localhost:3310/meeting_db";
    private static String user = "root";
    private static String password = "1111";
    private static Connection conn =  null;
    
     public static Connection getConnection() throws SQLException{
        try {
             if( conn == null){
                 conn = DriverManager.getConnection(url, user,password);
             }else{
                 conn.close();
                 conn = DriverManager.getConnection(url, user,password);
             }

         } catch (SQLException e) {
             throw new SQLException(e);
         }
         return conn;
     }
}