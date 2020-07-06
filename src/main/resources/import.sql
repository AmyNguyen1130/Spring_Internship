INSERT INTO users (userid, username, password, firstname, email, enabled, roleid) VALUES (10000, 'admin', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Administrator1', 'admin@codeenginestudio.com', true, 1);
INSERT INTO users (userid, username, password, firstname, email, enabled, roleid) VALUES (100001, 'admin1', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Administrator2', 'admin@codeenginestudio.com', true, 1);
INSERT INTO users (userid, username, password, firstname, email, enabled, roleid) VALUES (100002, 'admin2', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Administrator3', 'admin@codeenginestudio.com', true, 1);
INSERT INTO users (userid, username, password, firstname, email, enabled, roleid) VALUES (100003, 'admin3', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Administrator4', 'admin@codeenginestudio.com', true, 1);
INSERT INTO users (userid, username, password, firstname, email, enabled, roleid) VALUES (100004, 'admin4', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Administrator5', 'admin@codeenginestudio.com', true, 1);
INSERT INTO users (userid, username, password, firstname, email, enabled, roleid) VALUES (100005, 'admin5', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Administrator6', 'admin@codeenginestudio.com', true, 1);
INSERT INTO users (userid, username, password, firstname, email, enabled, roleid) VALUES (100006, 'admin6', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Administrator7', 'admin@codeenginestudio.com', true, 1);
INSERT INTO users (userid, username, password, firstname, email, enabled, roleid) VALUES (100007, 'admin7', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Administrator8', 'admin@codeenginestudio.com', true, 1);
INSERT INTO users (userid, username, password, firstname, email, enabled, roleid) VALUES (100008, 'admin8', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Administrator9', 'admin@codeenginestudio.com', true, 1);
INSERT INTO users (userid, username, password, firstname, email, enabled, roleid) VALUES (1000010, 'admin10', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Administrator10', 'admin@codeenginestudio.com', true, 1);
INSERT INTO users (userid, username, password, firstname, email, enabled, roleid) VALUES (1000011, 'admin11', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Administrator12', 'admin@codeenginestudio.com', true, 1);
INSERT INTO users (userid, username, password, firstname, email, enabled, roleid) VALUES (1000012, 'admin12', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Administrator13', 'admin@codeenginestudio.com', true, 1);
INSERT INTO users (userid, username, password, firstname, email, enabled, roleid) VALUES (1000013, 'admin13', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Administrator14', 'admin@codeenginestudio.com', true, 1);
INSERT INTO users (userid, username, password, firstname, email, enabled, roleid) VALUES (1000014, 'admin14', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Administrator15', 'admin@codeenginestudio.com', true, 1);
INSERT INTO users (userid, username, password, firstname, email, enabled, roleid) VALUES (1000015, 'admin15', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Administrator16', 'admin@codeenginestudio.com', true, 2);
INSERT INTO users (userid, username, password, firstname, email, enabled, roleid) VALUES (1000016, 'admin16', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Administrator17', 'admin@codeenginestudio.com', true, 2);
INSERT INTO users (userid, username, password, firstname, email, enabled, roleid) VALUES (1000017, 'admin17', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Administrator18', 'admin@codeenginestudio.com', true, 2);
INSERT INTO users (userid, username, password, firstname, email, enabled, roleid) VALUES (1000018, 'admin18', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Administrator19', 'admin@codeenginestudio.com', true, 2);

INSERT INTO roles (roleid, rolename) VALUES (1, 'Admin');
INSERT INTO roles (roleid, rolename) VALUES (2, 'Teacher');
INSERT INTO roles (roleid, rolename) VALUES (3, 'Student');

INSERT INTO classes (classid, classname, teacherid) VALUES (100, 'PNV20A', 1000018);
INSERT INTO classes (classid, classname, teacherid) VALUES (200, 'PNV20B', 1000018);
INSERT INTO classes (classid, classname, teacherid) VALUES (300, 'PNv20C', 1000018);

INSERT INTO assessments (assessmentid, assessmentname, classid, startdate, expireddate, status, totalquestion) VALUES (100, 'toan hoc', '100', '2020/6/10', '2020/6/15', true, 2);

INSERT INTO assessments (assessmentid, assessmentname, classid, startdate, expireddate, status, totalquestion) VALUES (105, 'van hoc', '100', '2020/6/10', '2020/6/15', true, 2);

INSERT INTO assessments (assessmentid, assessmentname, classid, startdate, expireddate, status, totalquestion) VALUES (101, 'lop 1', '100', '2020/6/10', '2020/6/15', true, 2);
INSERT INTO assessments (assessmentid, assessmentname, classid, startdate, expireddate, status, totalquestion) VALUES (102, 'lop 2', '100', '2020/6/10', '2020/6/15', true, 2);
INSERT INTO assessments (assessmentid, assessmentname, classid, startdate, expireddate, status, totalquestion) VALUES (103, 'lop 3', '100', '2020/6/10', '2020/6/15', true, 2);
INSERT INTO assessments (assessmentid, assessmentname, classid, startdate, expireddate, status, totalquestion) VALUES (104, 'lop 5', '100', '2020/6/10', '2020/6/15', true, 2);

INSERT INTO assessments (assessmentid, assessmentname, classid, startdate, expireddate, status, totalquestion) VALUES (107, 'lop 1', '100', '2020/6/10', '2020/6/15', true, 2);
INSERT INTO assessments (assessmentid, assessmentname, classid, startdate, expireddate, status, totalquestion) VALUES (108, 'lop 2', '100', '2020/6/10', '2020/6/15', true, 2);
INSERT INTO assessments (assessmentid, assessmentname, classid, startdate, expireddate, status, totalquestion) VALUES (109, 'lop 3', '100', '2020/6/10', '2020/6/15', true, 2);
INSERT INTO assessments (assessmentid, assessmentname, classid, startdate, expireddate, status, totalquestion) VALUES (110, 'lop 5', '100', '2020/6/10', '2020/6/15', true, 2);
INSERT INTO assessments (assessmentid, assessmentname, classid, startdate, expireddate, status, totalquestion) VALUES (111, 'lop 2', '100', '2020/6/10', '2020/6/15', true, 2);
INSERT INTO assessments (assessmentid, assessmentname, classid, startdate, expireddate, status, totalquestion) VALUES (112, 'lop 3', '100', '2020/6/10', '2020/6/15', true, 2);
INSERT INTO assessments (assessmentid, assessmentname, classid, startdate, expireddate, status, totalquestion) VALUES (113, 'lop 5', '100', '2020/6/10', '2020/6/15', true, 2);
