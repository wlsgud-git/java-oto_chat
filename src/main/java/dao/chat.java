package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class chat {
    // 채팅 내용
    public void chatMake(int room_id, int talker_id, String content){
        String sql = "INSERT INTO conversation(room_id,talker_id,content, created_at) " +
                     "VALUES(?,?,?,?)";
        try {
            Connection con = db.DBUtil.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, room_id);
            pst.setInt(2, talker_id);
            pst.setString(3, content);
            pst.setDate(4, new java.sql.Date(System.currentTimeMillis()));

            int rows = pst.executeUpdate();   
            System.out.println("채팅 추가 성공!!");
        } catch (SQLException e) {
            System.out.println("채팅중 예외 발생 : " +  e.getMessage());
        }
    }
}