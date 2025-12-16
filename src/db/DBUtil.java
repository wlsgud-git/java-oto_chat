package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static String url = "jdbc:postgresql://localhost:5432/ono_chat";
    private static String user = "ono_chat_user";
    private static String password = "1111";
    private static Connection conn =  null;
    
    public static Connection getConnection() throws SQLException {
         try {
             if(conn == null || conn.isClosed()){
                 conn = DriverManager.getConnection(url, user,password);
             }
         } catch (SQLException e) {
             throw new SQLException("DB 연결 중 에러 발생 : " + e.getMessage());
         }
         return conn;
     }
}