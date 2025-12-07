package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class users {
    // 회원가입
    public void signup(Connection con, int id, String username, String email){
        String sql = "INSERT INTO users(id,username,email) " +
                     "VALUES(?,?,?)";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, username);
            pst.setString(3, email);
            int rows = pst.executeUpdate(); 
            System.out.println("회원가입이 완료되었습니다.");
        } catch (SQLException e) {
            System.out.println("회원가입 중 발생 : " +  e.getMessage());
        }
    }

    public void login(Connection con, String username){
        String sql = "SELECT * FROM users WHERE username = ?";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
             
            if(rs.next()){
                System.out.println("로그인 성공: " + rs.getString("username") + "님 환영합니다.");
            } else {
                System.out.println("로그인 실패: 사용자 정보를 찾을 수 없습니다.");
            }
        } catch (SQLException e){
            System.out.println("로그인 중 에러 발생 : " +  e.getMessage());
        } 
    }
}