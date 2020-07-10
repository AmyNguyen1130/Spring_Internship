INSERT INTO roles (roleid, rolename) VALUES (1, 'Admin');
INSERT INTO roles (roleid, rolename) VALUES (2, 'Teacher');
INSERT INTO roles (roleid, rolename) VALUES (3, 'Student');

INSERT INTO users (userid, username, password, firstname, email, enabled, roleid) VALUES (10000, 'admin', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Administrator1', 'admin@codeenginestudio.com', true, 1);

INSERT INTO users (userid, username, password, firstname, email, enabled, roleid) VALUES (10001, 'teacher', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'teacher1', 'teacher@codeenginestudio.com', true, 2);

INSERT INTO questiontypes (questiontypeid, questiontypename) VALUES (1, 'Multiple question');
INSERT INTO questiontypes (questiontypeid, questiontypename) VALUES (2, 'Yes/No question');

INSERT INTO classes (classid, classname, teacherid, status) VALUES (100, 'PNV20A', 1000018, true);

INSERT INTO assessments (assessmentid, assessmentname, classid, startdate, expireddate, status, totalquestion) VALUES (100, 'toan hoc', '100', '2020/6/10', '2020/6/15', true, 2);
