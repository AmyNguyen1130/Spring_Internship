INSERT INTO roles (roleid, rolename) VALUES (1, 'Admin');
INSERT INTO roles (roleid, rolename) VALUES (2, 'Teacher');
INSERT INTO roles (roleid, rolename) VALUES (3, 'Student');

INSERT INTO questiontypes (questiontypeid, questiontypecode, questiontypename) VALUES (1, 'MULTIPLE', 'Multiple question');
INSERT INTO questiontypes (questiontypeid, questiontypecode, questiontypename) VALUES (2, 'YESNO', 'Yes/No question');
INSERT INTO questiontypes (questiontypeid, questiontypecode, questiontypename) VALUES (3, 'INPUT', 'Input type');

INSERT INTO users (userid, username, password, firstname, lastname, email, enabled, roleid) VALUES (10000, 'admin', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Administrator', 'Administrator', 'admin@elearning.com', true, 1);

INSERT INTO users (userid, username, password, firstname, lastname, email, gender, enabled, roleid) VALUES (10001, 'DinhCong', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Dinh', 'Vo Cong', 'dinh.cong@elearning.com','Female', true, 2);
INSERT INTO users (userid, username, password, firstname, lastname, email, gender, enabled, roleid) VALUES (10002, 'TrucTran', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Truc', 'Tran Thi', 'truc.tran@elearning.com','Male', true, 2);
INSERT INTO users (userid, username, password, firstname, lastname, email, gender, enabled, roleid) VALUES (10003, 'PhuongDang', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Phuong', 'Nguyen Dang Nguyen', 'phuong.dang@elearning.com','Male', true, 2);
INSERT INTO users (userid, username, password, firstname, lastname, email, gender, enabled, roleid) VALUES (10004, 'NguyenTran', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Nguyen', 'Tran Dong', 'nguyen.tran@elearning.com','Female', true, 2);
INSERT INTO users (userid, username, password, firstname, lastname, email, gender, enabled, roleid) VALUES (10005, 'DuyDoan', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Duy', 'Doan Anh', 'duy.doan@elearning.com','Female', true, 2);
INSERT INTO users (userid, username, password, firstname, lastname, email, gender, enabled, roleid) VALUES (10006, 'Arthur', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Arthur', 'Aubrée', 'arthur.aubree@elearning.com','Female', true, 2);
INSERT INTO users (userid, username, password, firstname, lastname, email, gender, enabled, roleid) VALUES (10007, 'ThuyLe', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Thuy', 'Le Thi Hong', 'thuy.le@elearning.com','Male', true, 2);
INSERT INTO users (userid, username, password, firstname, lastname, email, gender, enabled, roleid) VALUES (10008, 'LinhPhan', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Linh', 'Phan Van', 'linh.phan@elearning.com','Female', true, 2);
INSERT INTO users (userid, username, password, firstname, lastname, email, gender, enabled, roleid) VALUES (10009, 'HuyenNguyen', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Huyen', 'Nguyen Thi Dieu', 'huyen.nguyen@elearning.com','Male', true, 2);
INSERT INTO users (userid, username, password, firstname, lastname, email, gender, enabled, roleid) VALUES (10010, 'NhaiNguyen', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Nhai', 'Nguyen Thi', 'nhai.nguyen@elearning.com','Male', true, 2);



INSERT INTO users (userid, username, password, firstname, lastname, email, gender, enabled, roleid) VALUES (10011, 'TrangVo', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Trang', 'Vo Thi', 'trang.vo@elearning.com','Male', true, 3);
INSERT INTO users (userid, username, password, firstname, lastname, email, gender, enabled, roleid) VALUES (10012, 'DuyTruong', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Duy', 'Truong Van', 'duy.truong@elearning.com','Female', true, 3);
INSERT INTO users (userid, username, password, firstname, lastname, email, gender, enabled, roleid) VALUES (10013, 'OanhBui', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Oanh', 'Bui Thi Kim', 'oanh.bui@elearning.com','Male', true, 3);
INSERT INTO users (userid, username, password, firstname, lastname, email, gender, enabled, roleid) VALUES (10014, 'NamNguyen', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Nam', 'Nguyen Thanh', 'nam.nguyen@elearning.com','Female', true, 3);
INSERT INTO users (userid, username, password, firstname, lastname, email, gender, enabled, roleid) VALUES (10015, 'PhuTran', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Phu', 'Tran Quang', 'phu.tran@elearning.com','Female', true, 3);
INSERT INTO users (userid, username, password, firstname, lastname, email, gender, enabled, roleid) VALUES (10016, 'HienVo', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Hien', 'Vo Van', 'hien.vo@elearning.com','Female', true, 3);
INSERT INTO users (userid, username, password, firstname, lastname, email, gender, enabled, roleid) VALUES (10017, 'HoangLe', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Hoang', 'Le Xuan', 'hoang.le@elearning.com','Female', true, 3);
INSERT INTO users (userid, username, password, firstname, lastname, email, gender, enabled, roleid) VALUES (10018, 'ThongTruong', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Thong', 'Truong Van', 'thong.truong@elearning.com','Female', true, 3);
INSERT INTO users (userid, username, password, firstname, lastname, email, gender, enabled, roleid) VALUES (10019, 'DuyPham', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Duy', 'Pham Xuan', 'duy.pham@elearning.com','Female', true, 3);
INSERT INTO users (userid, username, password, firstname, lastname, email, gender, enabled, roleid) VALUES (10020, 'KhoaNguyen', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Khoa', 'Nguyen Huu Anh', 'khoa.nguyen@elearning.com','Female', true, 3);
INSERT INTO users (userid, username, password, firstname, lastname, email, gender, enabled, roleid) VALUES (10021, 'LanNguyen', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Lan', 'Nguyen Thi Ngoc', 'lan.nguyen@elearning.com','Male', true, 3);
INSERT INTO users (userid, username, password, firstname, lastname, email, gender, enabled, roleid) VALUES (10022, 'HoangPham', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Hoang', 'Pham Vu Huy', 'hoang.pham@elearning.com','Female', true, 3);
INSERT INTO users (userid, username, password, firstname, lastname, email, gender, enabled, roleid) VALUES (10023, 'DieuVu', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Dieu', 'Vu Nhat', 'dieu.vu@elearning.com','Male', true, 3);
INSERT INTO users (userid, username, password, firstname, lastname, email, gender, enabled, roleid) VALUES (10024, 'CanhKhac', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Canh', 'Khac Tran', 'canh.khac@elearning.com','Female', true, 3);
INSERT INTO users (userid, username, password, firstname, lastname, email, gender, enabled, roleid) VALUES (10025, 'ManhPham', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Manh', 'Pham Nguyen', 'manh.pham@elearning.com','Female', true, 3);
INSERT INTO users (userid, username, password, firstname, lastname, email, gender, enabled, roleid) VALUES (10026, 'CongTa', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Cong', 'Ta Chi', 'cong.ta@elearning.com','Female', true, 3);
INSERT INTO users (userid, username, password, firstname, lastname, email, gender, enabled, roleid) VALUES (10027, 'AnHo', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'An', 'Ho Thi Duyen', 'an.ho@elearning.com','Male', true, 3);
INSERT INTO users (userid, username, password, firstname, lastname, email, gender, enabled, roleid) VALUES (10028, 'BonBui', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Bon', 'Bui Thi', 'bon.bui@elearning.com','Male', true, 3);
INSERT INTO users (userid, username, password, firstname, lastname, email, gender, enabled, roleid) VALUES (10029, 'LocTruong', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Loc', 'Truong Thi Thanh', 'loc.truong@elearning.com','Male', true, 3);
INSERT INTO users (userid, username, password, firstname, lastname, email, gender, enabled, roleid) VALUES (10030, 'ViNguyen', '$2a$11$tUilnpRbUmpBxKWap3oUP..fNsY19D6n/WrdcXc94YnF4yCgXVJty', 'Vi', 'Nguyen Duc', 'vi.nguyen@elearning.com','Female', true, 3);

INSERT INTO classes (classid, classname, status, teacherid) VALUES (101, 'Elementary A', true, 10001);
INSERT INTO classes (classid, classname, status, teacherid) VALUES (102, 'Elementary B', false, 10001);
INSERT INTO classes (classid, classname,  status, teacherid) VALUES (103, 'Elementary C', true, 10001);
INSERT INTO classes (classid, classname, status, teacherid) VALUES (104, 'Elementary D', true, 10001);
INSERT INTO classes (classid, classname, status, teacherid) VALUES (105, 'Elementary E', false, 10001);
INSERT INTO classes (classid, classname,  status, teacherid) VALUES (106, 'Elementary F', true, 10001);

INSERT INTO class_students (idrow, classid, studentid) VALUES (100, 101, 10011);
INSERT INTO class_students (idrow, classid, studentid) VALUES (101, 101, 10012);
INSERT INTO class_students (idrow, classid, studentid) VALUES (102, 101, 10013);
INSERT INTO class_students (idrow, classid, studentid) VALUES (103, 101, 10014);
INSERT INTO class_students (idrow, classid, studentid) VALUES (104, 101, 10015);
INSERT INTO class_students (idrow, classid, studentid) VALUES (105, 101, 10016);
INSERT INTO class_students (idrow, classid, studentid) VALUES (106, 101, 10017);
INSERT INTO class_students (idrow, classid, studentid) VALUES (107, 101, 10019);
INSERT INTO class_students (idrow, classid, studentid) VALUES (108, 101, 10020);
INSERT INTO class_students (idrow, classid, studentid) VALUES (109, 101, 10021);
INSERT INTO class_students (idrow, classid, studentid) VALUES (110, 101, 10022);
INSERT INTO class_students (idrow, classid, studentid) VALUES (111, 101, 10023);
INSERT INTO class_students (idrow, classid, studentid) VALUES (112, 101, 10025);
INSERT INTO class_students (idrow, classid, studentid) VALUES (113, 101, 10026);
INSERT INTO class_students (idrow, classid, studentid) VALUES (114, 101, 10028);
INSERT INTO class_students (idrow, classid, studentid) VALUES (115, 101, 10029);
INSERT INTO class_students (idrow, classid, studentid) VALUES (116, 101, 10030);

INSERT INTO assessments (assessmentid, assessmentname, classid, startdate, expireddate, status) VALUES (101, 'Numbers', '101', '2020/6/10', '2020/10/15', true);
INSERT INTO assessments (assessmentid, assessmentname, classid, startdate, expireddate, status) VALUES (102, 'Addition word', '101', '2020/6/10', '2020/10/15', true);
INSERT INTO assessments (assessmentid, assessmentname, classid, startdate, expireddate, status) VALUES (103, 'Roman Numeral', '101', '2020/6/10', '2020/10/15', true);
INSERT INTO assessments (assessmentid, assessmentname, classid, startdate, expireddate, status) VALUES (104, 'Sum', '101', '2020/6/10', '2020/6/15', true);
INSERT INTO assessments (assessmentid, assessmentname, classid, startdate, expireddate, status) VALUES (105, 'Fractions 1', '101', '2020/6/10', '2020/8/15', true);
INSERT INTO assessments (assessmentid, assessmentname, classid, startdate, expireddate, status) VALUES (106, 'Fractions 2', '101', '2020/6/10', '2020/6/15', true);
INSERT INTO assessments (assessmentid, assessmentname, classid, startdate, expireddate, status) VALUES (107, 'Probability', '102', '2020/6/10', '2020/6/15', false);
INSERT INTO assessments (assessmentid, assessmentname, classid, startdate, expireddate, status) VALUES (108, 'Sum Ups 3', '102', '2020/6/10', '2020/6/15', false);
INSERT INTO assessments (assessmentid, assessmentname, classid, startdate, expireddate, status) VALUES (109, 'Counting', '103', '2020/6/10', '2020/6/15', false);
INSERT INTO assessments (assessmentid, assessmentname, classid, startdate, expireddate, status) VALUES (110, 'Comparisons ', '103', '2020/6/10', '2020/6/15', false);



INSERT INTO questions (questionid, numericalorder, content, options, correctanswer, score, questiontypeid, assessmentid) VALUES (1001, 1, 'Mary has a garden in which are 3 mango trees, 2 papaya trees and 4 avocado trees. How many trees are in her garden ?', '[{"name":"A","value":"9"},{"name":"B","value":"6"},{"name":"C","value":"5"},{"name":"D","value":"3"}]', 'A', 10, 1, 102);

INSERT INTO questions (questionid, numericalorder, content, options, correctanswer, score, questiontypeid, assessmentid) VALUES (1005, 5, 'While going to town, I stopped at the supermarket and the bakery. On return I stopped at school to pick Peter up. How many places did I make a stop at?', '[{"name":"A","value":"5"},{"name":"B","value":"6"},{"name":"C","value":"3"},{"name":"D","value":"2"}]', 'C', 10, 1, 102);

INSERT INTO questions (questionid, numericalorder, content, options, correctanswer, score, questiontypeid, assessmentid) VALUES (1003, 3, 'At the olympic games, Linda won 3 gold medals in swimming and silver medals in high jump. How many medals did she win at the olympics ?', '[{"name":"A","value":"5"},{"name":"B","value":"6"},{"name":"C","value":"3"},{"name":"D","value":"2"}]', 'A', 10, 1, 102);

INSERT INTO questions (questionid, numericalorder, content, options, correctanswer, score, questiontypeid, assessmentid) VALUES (1002, 2, 'Pauls mother took him to the toy shop; he admired 3 toys but his mother Becky ended up buying only 2, to add to the three at home which she bought the previous year. How many toys did Paul end up having?', null, '5', 10, 3, 102);

INSERT INTO questions (questionid, numericalorder, content, options, correctanswer, score, questiontypeid, assessmentid) VALUES (1004, 4, 'Dorins house has 3 rooms with each of them having 2 windows. How many windows are in Dorins house ?', '[{"name":"A","value":"True"},{"name":"B","value":"False"}]', 'A', 10, 2, 102);




INSERT INTO questions (questionid, numericalorder, content, options, correctanswer, score, questiontypeid, assessmentid) VALUES (1007, 1, 'Eight is one more than ___ ?', '[{"name":"A","value":"Six"},{"name":"B","value":"Seven"},{"name":"C","value":"Eight"},{"name":"D","value":"Nine"}]', 'B', 10, 1, 101);

INSERT INTO questions (questionid, numericalorder, content, options, correctanswer, score, questiontypeid, assessmentid) VALUES (1006, 2, 'Two comes after three ?', '[{"name":"A","value":"True"},{"name":"B","value":"False"}]', 'B', 10, 2, 101);

INSERT INTO questions (questionid, numericalorder, content, options, correctanswer, score, questiontypeid, assessmentid) VALUES (1008, 4, 'Four comes between ___ and ___ ?', null, 'Three and Five', 10, 3, 101);

INSERT INTO questions (questionid, numericalorder, content, options, correctanswer, score, questiontypeid, assessmentid) VALUES (1009, 3, 'Eight comes before ___ ?', '[{"name":"A","value":"Nine"},{"name":"B","value":"Ten"}, {"name":"C","value":"Seven"}, {"name":"D","value":"Six"}]', 'A', 10, 1, 101);

INSERT INTO questions (questionid, numericalorder, content, options, correctanswer, score, questiontypeid, assessmentid) VALUES (1010, 5, 'Seven is two less than ___ ?', '[{"name":"A","value":"Ten"},{"name":"B","value":"Five"}, {"name":"C","value":"Nine"}, {"name":"D","value":"Eight"}]', 'C', 10, 1, 101);

INSERT INTO questions (questionid, numericalorder, content, options, correctanswer, score, questiontypeid, assessmentid) VALUES (1011, 6, 'Eleven is between ___ and ___ ?', , null, 'Ten  and Twelve', 10, 3, 101);

INSERT INTO questions (questionid, numericalorder, content, options, correctanswer, score, questiontypeid, assessmentid) VALUES (1012, 7, 'Which number comes after nine ?', '[{"name":"A","value":"Ten"},{"name":"B","value":"Eight"}]', 'A', 10, 1, 101);



INSERT INTO questions (questionid, numericalorder, content, options, correctanswer, score, questiontypeid, assessmentid) VALUES (1013, 1, 'Which number equals XII ?', '[{"name":"A","value":"Ten"}, {"name":"B","value":"Eleven"},{"name":"C","value":"Twelve"},{"name":"D","value":"Thirteen"}]', 'C', 10, 1, 103);

INSERT INTO questions (questionid, numericalorder, content, options, correctanswer, score, questiontypeid, assessmentid) VALUES (1014, 2, 'VII comes after VI ?', '[{"name":"A","value":"True"}, {"name":"B","value":"False"}]', 'A', 10, 2, 103);

INSERT INTO questions (questionid, numericalorder, content, options, correctanswer, score, questiontypeid, assessmentid) VALUES (1015, 4, 'Is XXVIII equal XIV + XIV ?', '[{"name":"A","value":"True"}, {"name":"B","value":"False"}]', 'A', 10, 2, 103);

INSERT INTO questions (questionid, numericalorder, content, options, correctanswer, score, questiontypeid, assessmentid) VALUES (1016, 3, 'VI comes before ___ ?', '[{"name":"A","value":"VII"},{"name":"B","value":"IV"}, {"name":"C","value":"V"}, {"name":"D","value":"III"}]', 'A', 10, 1, 103);

INSERT INTO questions (questionid, numericalorder, content, options, correctanswer, score, questiontypeid, assessmentid) VALUES (1017, 5, 'Which number equals XII and XVII combine?', null, 'XXIX', 10, 3, 103);

INSERT INTO questions (questionid, numericalorder, content, options, correctanswer, score, questiontypeid, assessmentid) VALUES (1018, 6, 'XXIV is between ___ and ___ ?', , null, 'XXIII  and XXV', 10, 3, 103);



INSERT INTO questions (questionid, numericalorder, content, options, correctanswer, score, questiontypeid, assessmentid) VALUES (1019, 1, 'Mary has a garden in which are 3 mango trees, 2 papaya trees and 4 avocado trees. Write the fraction of the mango trees', '[{"name":"A","value":"2/9"},{"name":"B","value":"3/9"},{"name":"C","value":"4/9"},{"name":"D","value":"9/9"}]', 'A', 10, 1, 105);

INSERT INTO questions (questionid, numericalorder, content, options, correctanswer, score, questiontypeid, assessmentid) VALUES (1020, 2, 'Peter has 4 candies, he gives Arthur 2 candies. Write fractions of the candies you gave Arthur?', null, '2/4', 10, 3, 105);

INSERT INTO questions (questionid, numericalorder, content, options, correctanswer, score, questiontypeid, assessmentid) VALUES (1021, 3, 'Peter has 4 candies, he gives Arthur 2 candies and Elysa gives Peter 3 more candies. How many candies does Peter have?', '[{"name":"A","value":"4"},{"name":"B","value":"3"},{"name":"C","value":"2"},{"name":"D","value":"5"}]', 'D', 10, 1, 105);

INSERT INTO questions (questionid, numericalorder, content, options, correctanswer, score, questiontypeid, assessmentid) VALUES (1022, 4, 'Peter has 4 candies, he gives Arthur 2 candies. Write fractions of the candies you gave Arthur?', null, '2/4', 10, 3, 105);



INSERT INTO questions (questionid, numericalorder, content, options, correctanswer, score, questiontypeid, assessmentid) VALUES (1023, 1, 'Which number equals Two and Seven combine?', '[{"name":"A","value":"Eight"},{"name":"B","value":"Nine"}, {"name":"C","value":"Ten"}, {"name":"D","value":"Elevan"}]', 'B', 10, 1, 104);

INSERT INTO questions (questionid, numericalorder, content, options, correctanswer, score, questiontypeid, assessmentid) VALUES (1024, 2, 'Two and Seven combines are more than Ten', '[{"name":"A","value":"True"},{"name":"B","value":"False"}]', 'B', 10, 2, 104);

INSERT INTO questions (questionid, numericalorder, content, options, correctanswer, score, questiontypeid, assessmentid) VALUES (1025, 3, 'Eight equals Which number combines with Two ?', null, '6', 10, 3, 104);

INSERT INTO questions (questionid, numericalorder, content, options, correctanswer, score, questiontypeid, assessmentid) VALUES (1026, 4, 'Which number equals XII and XVII combine?', null, '29', 10, 3, 104);

INSERT INTO questions (questionid, numericalorder, content, options, correctanswer, score, questiontypeid, assessmentid) VALUES (1027, 5, 'Six equals Which number combines with Four ?', '[{"name":"A","value":"One"},{"name":"B","value":"Two"}, {"name":"C","value":"Three"}, {"name":"D","value":"Four"}]', 'B', 10, 1, 104);



INSERT INTO results (id, answerchoice, score, startdate, updatedate, assessmentid, questionid, studentid) VALUES (100, 'A', 10 , '2020/6/10', '2020/7/15', 105, 1019, 10012);
INSERT INTO results (id, answerchoice, score, startdate, updatedate, assessmentid, questionid, studentid) VALUES (101, '2/4', 10 , '2020/6/10', '2020/7/15', 105, 1020, 10012);
INSERT INTO results (id, answerchoice, score, startdate, updatedate, assessmentid, questionid, studentid) VALUES (102, 'D', 10 , '2020/6/10', '2020/7/20', 105, 1021, 10012);
INSERT INTO results (id, answerchoice, score, startdate, updatedate, assessmentid, questionid, studentid) VALUES (101, '2/6', 10 , '2020/6/10', '2020/7/15', 105, 1022, 10012);






