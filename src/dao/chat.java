package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class chat {
    // 채팅 내용
    public void chatMake(Connection con, int room_id, int talker_id, String content, String date){
        String sql = "INSERT INTO meetings(room_id,talker_id,content, create_at) " +
                     "VALUES(?,?,?,?)";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, room_id);
            pst.setInt(2, talker_id);
            pst.setString(3, content);
            pst.setDate(2, Date.valueOf(date));

            int rows = pst.executeUpdate();   
            System.out.println("채팅 추가 성공!!");
        } catch (SQLException e) {
            System.out.println("채팅중 예외 발생 : " +  e.getMessage());
        }
    }
}