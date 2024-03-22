CREATE DATABASE club;

CREATE TABLE users
(
    user_id    SERIAL PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name  VARCHAR(255) NOT NULL,
    email      TEXT         NOT NULL UNIQUE,
    password   text         NOT NULL
);

CREATE TABLE admins
(
    admin_id SERIAL PRIMARY KEY,
    user_id  INT REFERENCES users (user_id),
    salary   INT
);

CREATE TABLE trainers
(
    trainer_id SERIAL PRIMARY KEY,
    user_id    INT REFERENCES users (user_id),
    salary     INT
);

CREATE TABLE certificates
(
    certificate_id SERIAL PRIMARY KEY,
    trainer_id     INT REFERENCES trainers (trainer_id),
    name           VARCHAR(255)
);


CREATE TABLE members
(
    member_id SERIAL PRIMARY KEY,
    user_id   INT REFERENCES users (user_id)
);

CREATE TABLE classes
(
    class_id   SERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE rooms
(
    room_id  SERIAL PRIMARY KEY,
    capacity INT NOT NULL
);

CREATE TABLE participants
(
    member_id INT REFERENCES members (member_id),
    class_id  INT REFERENCES classes (class_id),
    PRIMARY KEY (member_id, class_id)
);

CREATE TYPE d_o_w AS ENUM ('monday','tuesday','wednesday','thursday','friday','saturday','sunday');
CREATE TYPE time_slot as ENUM ('09:00:00','10:00:00','11:00:00','12:00:00','13:00:00','14:00:00','15:00:00','16:00:00');
CREATE TABLE timeslots
(
    timeslot_id SERIAL PRIMARY KEY,
    class_id    INT REFERENCES classes (class_id),
    trainer_id  INT REFERENCES trainers (trainer_id),
    room_id     INT REFERENCES rooms (room_id),
    day_of_week D_O_W     NOT NULL,
    time        TIME_SLOT NOT NULL
);

CREATE TYPE stat_type AS ENUM ('goal','current');

CREATE TABLE fitness_stats
(
    member_id       INT REFERENCES members (member_id),
    goal_or_current STAT_TYPE,
    weight          REAL NOT NULL,
    hours           INT  NOT NULL,
    flexibility     INT  NOT NULL,
    PRIMARY KEY (member_id, goal_or_current)
);

CREATE TABLE payments
(
    payment_id SERIAL PRIMARY KEY,
    member_id  INT REFERENCES members (member_id),
    class_id   INT REFERENCES classes (class_id),
    amount     REAL NOT NULL
);

CREATE TABLE equipment
(
    equipment_id             SERIAL PRIMARY KEY,
    name                     VARCHAR(255) NOT NULL,
    recurrence               INT          NOT NULL,
    date_of_last_maintenance DATE
);