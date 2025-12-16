package main;

// dao
import dao.users;
import dao.chatroom;
import dao.chat;
// db
import db.DBUtil;
// sql
import java.sql.*;

public class MainTest {
   public static void main(String[] args){
        // 유저 관련
        users userDao = new users();
        userDao.signup(1, "Alice", "aaa@naver.com"); // 회원가입
        // userDao.signup(2, "Bob", "bbb@naver.com"); // 회원가입
        // userDao.login("Alice"); // 로그인

        // 채팅방 관련
        chatroom chatroomDao = new chatroom();
        // chatroomDao.getMyChatrooms(1); // 내 채팅방 가져오기
        // chatroomDao.getChatroomById(1); // 특정 채팅방 내용 가져오기
        // chatroomDao.createRoom(1, 1, 2); // 채팅방 생성
        // chatroomDao.deleteRoom(1); // 채팅방 삭제

        // 대화 내용 관련
        chat chatDao = new chat();
        // chatDao.chatMake(1, 1, "hello", null); // 대화 생성
   } 
}
