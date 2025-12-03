
-- USE meeting_db

CREATE TABLE users (  -- 유저 정보
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    email VARCHAR(100)
);


CREATE TABLE chatroom (  -- 채팅방 정보
    id INT PRIMARY KEY AUTO_INCREMENT,
    inviter_id INT
    invitee_id INT
);

CREATE TABLE conversation (   -- 채딩방 대화 내용
    room_id INT
    talker_id INT,
    content TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (talker_id) REFERENCES users(id),
    FOREIGN KEY (room_id) REFERENCES chatroom(id)
);
