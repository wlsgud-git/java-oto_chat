package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DBUtil;

public class chatroom {
    // 내 채팅방 가져오기
    public void getMyChatrooms(int userId){
        String sql = "SELECT * FROM chatroom WHERE inviter_id = ? OR invitee_id = ?";

        try{
            Connection con = DBUtil.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, userId);
            pst.setInt(2, userId);
            int rows = pst.executeUpdate(); 
        }catch (SQLException e) {
            System.out.println("채팅방 생성중 예외 발생 : " +  e.getMessage());
        }
    }

    // 특정 채팅방 내용 가져오기
    public void getChatroomById(int roomId){
        String sql = "SELECT * FROM chatroom LEFT JOIN coversation ON chatroom.id = coversation.room_id WHERE chatroom.id = ? ORDER BY coversation.create_at DESC";
        try{
            Connection con = DBUtil.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, roomId);
            int rows = pst.executeUpdate(); 
        }catch (SQLException e) {
            System.out.println("채팅방 생성중 예외 발생 : " +  e.getMessage());
        }
    }

    // 채팅방 생성
    public void createRoom(int roomId, int inviterId, int inviteeId){
        String sql = "INSERT INTO chatroom(id,inviter_id,invitee_id) " +
                     "VALUES(?,?,?)";
        try{
            Connection con = DBUtil.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, roomId);
            pst.setInt(2, inviterId);
            pst.setInt(3, inviteeId);
            int rows = pst.executeUpdate(); 
            System.out.println("채팅방 생성이 완료되었습니다.");
        }catch (SQLException e) {
            System.out.println("채팅방 생성중 예외 발생 : " +  e.getMessage());
        }
    };
    
    // 채팅방 삭제
    public void deleteRoom(int roomId){
        Connection con = null;
        String sql = "DELETE FROM meetings WHERE id = ?";
        try{
            con = DBUtil.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, roomId);
            int rows = pst.executeUpdate();  // 1 or 0
            if(rows > 0){
                System.out.println("채팅방 삭제 성공: " +  roomId+ " 삭제 완료");
            }else{
                System.out.println("채팅방 삭제 불가: "+ roomId + " 정보 없음.");
            }

        } catch (SQLException e) {
            System.out.println("채팅방 삭제 중에 SQL예외 발생: "+ e.getMessage());
        }
    };
}
