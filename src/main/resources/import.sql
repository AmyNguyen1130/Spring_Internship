INSERT INTO roles (roleid, rolename) VALUES (1, 'Admin');
INSERT INTO roles (roleid, rolename) VALUES (2, 'Teacher');
INSERT INTO roles (roleid, rolename) VALUES (3, 'Student');

INSERT INTO users (userid, username, password, firstname, email, enabled, roleid) VALUES (10000, 'admin', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Administrator1', 'admin@codeenginestudio.com', true, 1);

INSERT INTO questiontypes (questiontypeid, questiontypename) VALUES (1, 'Multiple question');
INSERT INTO questiontypes (questiontypeid, questiontypename) VALUES (2, 'Yes/No question');