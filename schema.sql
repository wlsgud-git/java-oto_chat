-- USE meeting_db

CREATE TABLE users (  -- 유저 정보
    id serial PRIMARY KEY NOT NULL,
    name VARCHAR(50),
    email VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE chatroom (  -- 채팅방 정보
    id serial PRIMARY KEY NOT NULL,
    inviter_id INT NOT NULL,
    invitee_id INT NOT NULL,

    FOREIGN KEY (inviter_id) REFERENCES users(id),
    FOREIGN KEY (invitee_id) REFERENCES users(id)
);


CREATE TABLE conversation (   -- 채딩방 대화 내용
    room_id INT NOT NULL,
    talker_id INT NOT NULL,
    content TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,

    FOREIGN KEY (talker_id) REFERENCES users(id),
    FOREIGN KEY (room_id) REFERENCES chatroom(id)
);

-- ERD Diagram --------------------------------------------

Table users {
  id integer [pk,increment, not null]
  username varchar [not null]
  email varchar(30) [not null]
}

Table chatroom {
  id integer [pk, increment,not null ]
  inviter_id integer [not null]
  invitee_id integer [not null]
}

Table conversation {
  room_id integer [not null]
  talker_id integer [not null]
  content text
  created_at timestamp [default: `now()`, not null]
}

Ref: chatroom.inviter_id > users.id //초대자 
Ref: chatroom.invitee_id > users.id // 초대당한자

Ref: chatroom.id < conversation.room_id //방 아이디
Ref: users.id < conversation.talker_id //토커 아이디

