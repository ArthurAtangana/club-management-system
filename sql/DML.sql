delete from certificates;
delete from participants;
delete from timeslots;
delete from classes;
delete from room;
delete from fitness_stats;
delete from payments;
delete from equipment;
delete from members;
delete from admins;
delete from trainers;
delete from users;

INSERT INTO users (first_name, last_name, email, password) VALUES
('John', 'Smith', 'john.smith@example.com', 'password'),
('Jane', 'Doe', 'jane.doe@example.com', 'password'),
('Tom', 'Black', 'tom.black@example.com', 'password');

INSERT INTO admins (user_id, salary) VALUES
((SELECT user_id FROM users WHERE first_name='John' AND last_name='Smith' ), 70000);

INSERT INTO trainers (user_id, salary) VALUES
((SELECT user_id FROM users WHERE first_name='Jane' AND last_name='Doe' ), 80000);

INSERT INTO members (user_id) VALUES
((SELECT user_id FROM users WHERE first_name='Tom' AND last_name='Black' ));

INSERT INTO certificates (trainer_id, name) VALUES
((SELECT trainer_id FROM trainers WHERE user_id=(SELECT user_id FROM users WHERE first_name='Jane' AND last_name='Doe' )), 'General Fitness');

INSERT INTO equipment (name, recurrence, date_of_last_maintenance) VALUES
('Kettle Bell', 1000, '2024-01-01');

INSERT INTO classes (class_name) VALUES ('Yoga');

INSERT INTO payments (member_id, class_id, amount) VALUES ((SELECT member_id FROM members WHERE user_id=(SELECT user_id FROM users WHERE first_name='Tom' AND last_name='Black')),
 (SELECT class_id FROM classes ORDER BY class_id LIMIT 1), 100);

INSERT INTO fitness_stats (member_id, goal_or_current, weight, hours, flexibility) VALUES
((SELECT member_id FROM members WHERE user_id=(SELECT user_id FROM users WHERE first_name='Tom' AND last_name='Black')),'goal', 150, 2, -1);

INSERT INTO participants (member_id, class_id) VALUES ((SELECT member_id FROM members ORDER BY member_id LIMIT 1), (SELECT class_id FROM classes ORDER BY class_id LIMIT 1));

INSERT INTO room (capacity) VALUES (20);

INSERT INTO timeslots (class_id, trainer_id, room_id, day_of_week, time) VALUES (
(SELECT class_id FROM classes ORDER BY class_id LIMIT 1),
(SELECT trainer_id FROM trainers ORDER BY trainer_id LIMIT 1),
(SELECT room_id FROM room ORDER BY room_id LIMIT 1),
'monday',
'12:00:00');