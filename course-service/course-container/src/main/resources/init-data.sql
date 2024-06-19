INSERT INTO public.organization(id, description, name, created_at, updated_at, is_deleted, moodle_url)
VALUES
	 ('cb69c0bf-c454-4f15-be10-791f6749dac7','Moodle description','Moodle 2','2024-04-15 18:09:29.488151+07','2024-04-15 18:09:29.488151+07',false, 'http://localhost:3001');
INSERT INTO public.organization
(id, description, "name", api_key, moodle_url, created_at, updated_at, is_deleted)
VALUES ('08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'moodle', 'Moodle', 'cdf90b5bf53bcae577c60419702dbee7',
        'http://62.171.185.208:8081/webservice/rest/server.php', '2024-04-15 18:09:29.488', '2024-04-15 18:09:29.488',
        false);

INSERT INTO public.role_moodle(id, name) VALUES (1,'Quản lý'), (2,'Người tạo khóa học'), (3,'Giảng viên 1'), (4,'Giảng viên'), (5,'Học sinh'), (6,'Guest');
INSERT INTO public."user" (id,user_id_moodle,role_moodle_id,org_id,username,email,dob,first_name,last_name,phone,address,avatar_url,last_login,is_deleted,created_at,updated_at) VALUES
	 ('b029f559-52a8-4699-b595-71161498ed8c',0,NULL,NULL,NULL,'dcthong852@gmail.com','2002-04-29','Thong','Duong','+8412365478',NULL,NULL,'2024-06-04 19:54:04.349854+07',false,'2024-04-15 18:07:20.891115+07','2024-04-15 18:07:20.891115+07'),
	 ('8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7',0,NULL,NULL,NULL,'nthoang852@gmail.com','2002-03-29','Hoang','Nguyen Thanh','+8412365478',NULL,NULL,'2024-06-04 19:54:04.349854+07',false,'2024-04-15 18:07:41.151759+07','2024-04-15 18:07:41.151759+07'),
	 ('39328bcf-8af6-44fc-9ae9-247f953ee2a2',0,NULL,NULL,NULL,'ndqkhanh852@gmail.com','2002-03-29','Khanh','Nguyen Dinh','+8412365478',NULL,NULL,'2024-06-04 19:54:04.349854+07',false,'2024-04-15 18:07:41.151759+07','2024-04-15 18:07:41.151759+07'),
	 ('8edbc0aa-0b91-480e-a428-23abf2109df9',0,NULL,NULL,NULL,'tgtien852@gmail.com','2002-03-29','Tien','Truong Gia','+8412365478',NULL,NULL,'2024-06-04 19:54:04.349854+07',false,'2024-04-15 18:07:41.151759+07','2024-04-15 18:07:41.151759+07'),
	 ('05dbdfde-1eae-47ba-8ebb-6c4cdc4f6510',0,NULL,NULL,NULL,'dntien852@gmail.com','2002-03-29','Tien','Dang Ngoc','+8412365478',NULL,NULL,'2024-06-04 19:54:04.349854+07',false,'2024-04-15 18:07:41.151759+07','2024-04-15 18:07:41.151759+07'),
	 ('c6bd2565-a6bd-4f98-af43-d974a6302f36',1,1,'08b65a39-394f-4977-a5fa-3fe145b620f8','guest','root@localhost',NULL,'Guest user',' ',NULL,NULL,NULL,'2024-06-04 19:54:23.474857+07',false,'2024-06-04 19:54:23.474857+07','2024-06-04 19:54:23.474857+07'),
	 ('64412e27-169e-44ea-a101-74ebf8cb82d9',2,3,'08b65a39-394f-4977-a5fa-3fe145b620f8','admin','kayonkiu@gmail.com',NULL,'Tien','Ngoc',NULL,NULL,NULL,'2024-06-04 19:54:23.636865+07',false,'2024-06-04 19:54:23.636865+07','2024-06-04 19:54:23.637867+07'),
	 ('cb2c22ac-87de-44e4-9638-35979f6af667',3,5,'08b65a39-394f-4977-a5fa-3fe145b620f8','chithong2002','duongchithong2002@gmail.com',NULL,'Dương','Chí Thông',NULL,NULL,NULL,'2024-06-04 19:54:23.664571+07',false,'2024-06-04 19:54:23.664571+07','2024-06-04 19:54:23.664571+07'),
	 ('2d7ed5a0-fb21-4927-9a25-647c17d29668',4,5,'08b65a39-394f-4977-a5fa-3fe145b620f8','tien','dntienes@gmail.com',NULL,'Tiến','Đặng Ngọc','0993331110',NULL,NULL,'2024-06-04 19:54:23.690581+07',false,'2024-06-04 19:54:23.690581+07','2024-06-04 19:54:23.690581+07');
INSERT INTO public."user" (id,user_id_moodle,role_moodle_id,org_id,username,email,dob,first_name,last_name,phone,address,avatar_url,last_login,is_deleted,created_at,updated_at) VALUES
	 ('2d3c1e66-1835-457f-93e9-265fe483feee',5,5,'08b65a39-394f-4977-a5fa-3fe145b620f8','ngocthu','dt.ngocthw@gmail.com',NULL,'Thư','Ngọc',NULL,NULL,NULL,'2024-06-04 19:54:23.712124+07',false,'2024-06-04 19:54:23.712124+07','2024-06-04 19:54:23.712124+07'),
	 ('a9f5487e-c0b1-4fa4-b93a-6f16bde90583',6,3,'08b65a39-394f-4977-a5fa-3fe145b620f8','giaovien','ktpm4t@gmail.com',NULL,'giáo','vien',NULL,NULL,NULL,'2024-06-04 19:54:23.73386+07',false,'2024-06-04 19:54:23.73386+07','2024-06-04 19:54:23.73386+07'),
	 ('9ba179ed-d26d-4828-a0f6-8836c2063992',7,5,'08b65a39-394f-4977-a5fa-3fe145b620f8','quoctuan2002','nguyenquoctuan385@gmail.com',NULL,'Nguyễn','Quốc Tuấn',NULL,NULL,NULL,'2024-06-04 19:54:23.75895+07',false,'2024-06-04 19:54:23.759506+07','2024-06-04 19:54:23.759506+07'),
	 ('ca3040f2-e173-40a5-aab7-6ef15965ce43',8,5,'08b65a39-394f-4977-a5fa-3fe145b620f8','tgt2002','truonggiatien123@gmail.com',NULL,'Trương','Gia Tiến',NULL,NULL,NULL,'2024-06-04 19:54:23.789236+07',false,'2024-06-04 19:54:23.789748+07','2024-06-04 19:54:23.789748+07');

INSERT INTO public.course_type (id,moodle_id,name,org_id) VALUES
	 ('56b844c6-b59a-4135-b028-f8b1a7b68eea',3,'Tiên Tiến','08b65a39-394f-4977-a5fa-3fe145b620f8'),
	 ('c18999a8-df4b-4690-8342-a254c66a5929',4,'CLC','08b65a39-394f-4977-a5fa-3fe145b620f8');

INSERT INTO public.course (id,course_id_moodle,course_type_id,org_id,name,visible,created_by,updated_by,created_at,updated_at) VALUES
	 ('983942d9-3366-4004-9f9a-c4e7e7760cc0',2,'c18999a8-df4b-4690-8342-a254c66a5929','08b65a39-394f-4977-a5fa-3fe145b620f8','Nhập môn lập trình',true,'64412e27-169e-44ea-a101-74ebf8cb82d9','64412e27-169e-44ea-a101-74ebf8cb82d9','2024-06-04 19:54:28.102871+07','2024-06-04 19:54:28.102871+07'),
	 ('c061d55e-a8b0-433f-b6a3-ae9d5601422e',3,'56b844c6-b59a-4135-b028-f8b1a7b68eea','08b65a39-394f-4977-a5fa-3fe145b620f8','Cấu trúc dữ liệu và giải thuật',true,'64412e27-169e-44ea-a101-74ebf8cb82d9','64412e27-169e-44ea-a101-74ebf8cb82d9','2024-06-04 19:54:28.123993+07','2024-06-04 19:54:28.12405+07'),
	 ('62943cbb-5bc5-4cef-b9a9-e33c82ecf984',4,'c18999a8-df4b-4690-8342-a254c66a5929','08b65a39-394f-4977-a5fa-3fe145b620f8','Khóa học lập trình Python',true,'64412e27-169e-44ea-a101-74ebf8cb82d9','64412e27-169e-44ea-a101-74ebf8cb82d9','2024-06-04 19:54:28.136606+07','2024-06-04 19:54:28.136606+07'),
	 ('0888fabf-acd7-4ffa-9978-51558e5a0ee1',5,'56b844c6-b59a-4135-b028-f8b1a7b68eea','08b65a39-394f-4977-a5fa-3fe145b620f8','Kỹ thuật lập trình',true,'64412e27-169e-44ea-a101-74ebf8cb82d9','64412e27-169e-44ea-a101-74ebf8cb82d9','2024-06-04 19:54:28.148098+07','2024-06-04 19:54:28.148098+07'),
	 ('c31382b2-2fbd-43ae-89de-12b6614fc8ab',6,'56b844c6-b59a-4135-b028-f8b1a7b68eea','08b65a39-394f-4977-a5fa-3fe145b620f8','HEHE',true,'64412e27-169e-44ea-a101-74ebf8cb82d9','64412e27-169e-44ea-a101-74ebf8cb82d9','2024-06-04 19:54:28.161833+07','2024-06-04 19:54:28.161833+07');

INSERT INTO public.course_user (id,user_id,course_id,role_id) VALUES
	 ('cb0ed88c-2026-4326-a696-d0f9537c2040','64412e27-169e-44ea-a101-74ebf8cb82d9','983942d9-3366-4004-9f9a-c4e7e7760cc0',3),
	 ('923c7732-3b1e-48d9-a624-7506d6b81437','cb2c22ac-87de-44e4-9638-35979f6af667','983942d9-3366-4004-9f9a-c4e7e7760cc0',5),
	 ('817b5efd-040d-4c05-854c-6002c7da7889','2d3c1e66-1835-457f-93e9-265fe483feee','983942d9-3366-4004-9f9a-c4e7e7760cc0',5),
	 ('1df08f3b-b6ea-4f8e-bc5a-dec66aba57b1','ca3040f2-e173-40a5-aab7-6ef15965ce43','983942d9-3366-4004-9f9a-c4e7e7760cc0',3),
	 ('5ecb102e-8623-413a-8b85-7f393aaac95b','64412e27-169e-44ea-a101-74ebf8cb82d9','c061d55e-a8b0-433f-b6a3-ae9d5601422e',3),
	 ('986aa426-1794-4c9e-9a36-079d0f7e8947','cb2c22ac-87de-44e4-9638-35979f6af667','c061d55e-a8b0-433f-b6a3-ae9d5601422e',5),
	 ('67633940-1113-470d-8516-fe35a5cf6944','2d7ed5a0-fb21-4927-9a25-647c17d29668','c061d55e-a8b0-433f-b6a3-ae9d5601422e',5),
	 ('f1a98c8d-9218-4bcf-8453-03c0e84e0516','9ba179ed-d26d-4828-a0f6-8836c2063992','c061d55e-a8b0-433f-b6a3-ae9d5601422e',5),
	 ('441b9962-ff25-4398-940c-81fc267d599f','64412e27-169e-44ea-a101-74ebf8cb82d9','62943cbb-5bc5-4cef-b9a9-e33c82ecf984',3),
	 ('11f47469-4833-40d7-944d-a88e9c8b693a','ca3040f2-e173-40a5-aab7-6ef15965ce43','62943cbb-5bc5-4cef-b9a9-e33c82ecf984',5);
INSERT INTO public.course_user (id,user_id,course_id,role_id) VALUES
	 ('c0b733e9-bbc0-4d65-b546-6688bd970157','64412e27-169e-44ea-a101-74ebf8cb82d9','0888fabf-acd7-4ffa-9978-51558e5a0ee1',3),
	 ('80cb9f8f-2336-4dd7-93ce-435fb690df09','64412e27-169e-44ea-a101-74ebf8cb82d9','c31382b2-2fbd-43ae-89de-12b6614fc8ab',3);

INSERT INTO public.assignment (id, assignment_id_moodle, course_id, title, intro, activity, max_score, time_open, time_close, time_limit, type, visible, word_limit, max_upload_files, max_file_size,allow_submit_late) VALUES
    ('577e118d-604b-450c-a02c-cf8e9f35f8ee', 3, '983942d9-3366-4004-9f9a-c4e7e7760cc0', 'Đây là bài tập 11', '<p dir="ltr" style="text-align: left;">Bì tập 11</p>', NULL, 100.0, '2024-05-06 00:00:00+07', '2024-05-13 00:00:00+07', '1970-01-01 08:00:00+08', 'FILE', false, NULL, '40', '40000',true),
    ('b1b3e215-2450-4819-9aa6-3aea9f87e604', 2, 'c061d55e-a8b0-433f-b6a3-ae9d5601422e', 'bài tập 2', '<p dir="ltr" style="text-align: left;">DDaaay laaf bai tap 2</p>', NULL, 100.0, '2024-05-06 00:00:00+07', '2024-05-13 00:00:00+07', '1970-01-01 08:00:00+08', 'FILE', false, NULL, '40', '40000',true),
    ('f37edb09-e0f6-4e96-8469-d6eff5378c9d', 4, 'c061d55e-a8b0-433f-b6a3-ae9d5601422e', 'baaif tạp cuối', '<p dir="ltr" style="text-align: left;">mô tả bâif</p>', NULL, 100.0, '2024-05-08 17:16:00+07', '2024-05-17 18:19:00+07', '1970-01-01 08:00:00+08', 'FILE', false, NULL, '40', '40000',true),
    ('3926bcb3-6415-458d-b449-6e2b464732d7', 5, 'c061d55e-a8b0-433f-b6a3-ae9d5601422e', 'baafi online tẽt', '<p dir="ltr" style="text-align: left;">vccc</p>', NULL, 100.0, '2024-05-06 00:00:00+07', '2024-05-13 00:00:00+07', '1970-01-01 08:00:00+08', 'BOTH', false, NULL, '40', '40000',true),
    ('8c6d9aa1-f157-49ca-bfae-bc8a14570c81', 6, 'c061d55e-a8b0-433f-b6a3-ae9d5601422e', 'Bài taapj 1', '<p dir="ltr" style="text-align: left;">hello</p>', NULL, 100.0, '2024-05-06 00:00:00+07', '2024-05-13 00:00:00+07', '1970-01-01 08:00:00+08', 'FILE', false, NULL, '40', '40000',true),
    ('124c9619-cd26-43fb-8ea4-610b164925ad', 7, 'c061d55e-a8b0-433f-b6a3-ae9d5601422e', 'hehe', '<p dir="ltr" style="text-align: left;">đây hehe</p>', NULL, 100.0, '2024-05-06 00:00:00+07', '2024-05-13 00:00:00+07', '1970-01-01 08:00:00+08', 'BOTH', false, NULL, '40', '40000',true),
    ('fbe31ca6-ddc9-49ef-87f3-c472958a52c0', 8, 'c061d55e-a8b0-433f-b6a3-ae9d5601422e', 'Baaif tập 10', '<p dir="ltr" style="text-align: left;">Mô tả bài tập 10</p>', NULL, 100.0, '2024-05-06 00:00:00+07', '2024-05-13 00:00:00+07', '1970-01-01 08:00:00+08', 'TEXT_ONLINE', false, NULL, '40', '40000',true),
    ('0ffc63bf-c1b9-4676-9612-65ab6a24ce5b', 10, 'c061d55e-a8b0-433f-b6a3-ae9d5601422e', 'Bài tập module', '<p dir="ltr" style="text-align: left;">đây là bài tập moduile</p>', NULL, 100.0, '2024-05-12 00:00:00+07', '2024-05-19 00:00:00+07', '1970-01-01 08:00:00+08', 'FILE', false, NULL, '40', '40000',true),
    ('438413fa-ac31-496a-becb-709505ea990a', 9, '62943cbb-5bc5-4cef-b9a9-e33c82ecf984', 'bài 1', '<p dir="ltr" style="text-align: left;">ddaaay lầ bài 1</p>', NULL, 100.0, '2024-05-07 00:00:00+07', '2024-05-14 00:00:00+07', '1970-01-01 08:00:00+08', 'FILE', false, NULL, '40', '40000',true),
    ('7055f5fd-29ce-48f9-b1d1-cd11a95ce931', 11, '62943cbb-5bc5-4cef-b9a9-e33c82ecf984', 'Bài tập 2', '<p dir="ltr" style="text-align: left;"></p><p dir="ltr">Viết hàm main: Cho trước 3 biến ngày tháng năm</p><p dir="ltr">int day = 9;</p><p dir="ltr">int month = 10;</p><p dir="ltr">int year = 2023;</p><p dir="ltr">Nếu ba biến này tạo thành ngày tháng năm hợp lệ thì in ra ngày kế.</p><p dir="ltr">Nộp lại mã nguồn sử dụng Visual Studio hoặc nộp link onlinegdb.com</p><p dir="ltr">Thực hiện nhóm 1-3 người.</p><br><p></p>', NULL, 100.0, '2024-05-22 00:00:00+07', '2024-05-29 00:00:00+07', '1970-01-01 08:00:00+08', 'FILE', false, NULL, '40', '40000',true),
    ('b3108f5a-c769-42ab-84c9-80a6d80f5821', 13, '62943cbb-5bc5-4cef-b9a9-e33c82ecf984', 'Bài tập 3', '<p dir="ltr" style="text-align: left;"><a href="http://62.171.185.208/webservice/pluginfile.php/67/mod_assign/intro/assignment.svg">http://62.171.185.208/webservice/pluginfile.php/67/mod_assign/intro/assignment.svg</a><br></p>', '<p dir="ltr" style="text-align:left;"><a href="http://62.171.185.208/webservice/pluginfile.php/67/mod_assign/activityattachment/0/2024-04-28T06-36%20Giao%20d%E1%BB%87%20%C4%91%E1%BB%99ng%20file%20Image.svg">2024-04-28T06-36 Giao d%E1%BB%87%20%C4%91%E1%BB%99ng%20file%20Image.svg</a></p>', 100.0, '2024-05-25 00:00:00+07', '2024-06-02 00:00:00+07', '1970-01-01 08:00:00+08', 'FILE', false, NULL, '40', '40000',true),
    ('5b82b228-aef2-494f-8622-2be74966106d', 14, '62943cbb-5bc5-4cef-b9a9-e33c82ecf984', 'Bài tập 4', '', '<p dir="ltr" style="text-align:left;"></p><p dir="ltr">Viết hàm main: Cho trước 3 biến ngày tháng năm</p><p dir="ltr">int day = 9;</p><p dir="ltr">int month = 10;</p><p dir="ltr">int year = 2023;</p><p dir="ltr">Nếu ba biến này tạo thành ngày tháng năm hợp lệ thì in ra ngày kế.</p><p dir="ltr">Nộp lại mã nguồn sử dụng Visual Studio hoặc nộp link onlinegdb.com</p><p dir="ltr">Thực hiện nhóm 1-3 người.</p><br /><p></p>', 100.0, '2024-05-22 00:00:00+07', '2024-05-29 00:00:00+07', '1970-01-01 08:00:00+08', 'FILE', false, NULL, '40', '40000',true),
    ('56f0980c-3944-40b1-9cb6-1b9b46891de6', 15, '62943cbb-5bc5-4cef-b9a9-e33c82ecf984', 'bt 5', 'bt 3', NULL, 100.0, '2024-05-28 00:00:00+07', '2024-06-04 00:00:00+07', '1970-01-01 08:00:00+08', 'FILE', false, NULL, '40', '40000',true);

INSERT INTO public.intro_file (id,assignment_id,file_name,file_size,file_url,timemodified,mimetype) VALUES
	 ('db904e87-f1b7-423b-81cf-a822724d0392','b3108f5a-c769-42ab-84c9-80a6d80f5821','assignment.svg',1130,'http://62.171.185.208/webservice/pluginfile.php/67/mod_assign/intro/assignment.svg','2024-05-22 09:18:13+07','image/svg+xml');

INSERT INTO public.intro_attachment (id,assignment_id,file_name,file_size,file_url,timemodified,mimetype) VALUES
	 ('d2ae79dd-ff69-435a-b487-840c0841da07','b3108f5a-c769-42ab-84c9-80a6d80f5821','DeCuongDeTaiTN (1).pdf',227177,'http://62.171.185.208/webservice/pluginfile.php/67/mod_assign/introattachment/0/DeCuongDeTaiTN%20%281%29.pdf','2024-05-22 09:18:13+07','application/pdf'),
	 ('a67f8044-ad92-423e-a94a-ede9074ae458','b3108f5a-c769-42ab-84c9-80a6d80f5821','file.svg',3494,'http://62.171.185.208/webservice/pluginfile.php/67/mod_assign/introattachment/0/file.svg','2024-05-22 09:18:13+07','image/svg+xml');

INSERT INTO public.activity_attachment (id,assignment_id,file_name,file_size,file_url,timemodified,mimetype) VALUES
	 ('43eb677a-af62-4496-ae4e-b03f3de1663c','b3108f5a-c769-42ab-84c9-80a6d80f5821','2024-04-28T06-36 Giao dịch số 7503068499806565-14511976 (1).pdf',1059934,'http://62.171.185.208/webservice/pluginfile.php/67/mod_assign/activityattachment/0/2024-04-28T06-36%20Giao%20d%E1%BB%8Bch%20s%E1%BB%91%207503068499806565-14511976%20%281%29.pdf','2024-05-22 09:18:13+07','application/pdf');

INSERT INTO public.submission_assignment (id, user_id, assignment_id, is_graded, grade, "content", feedback, submit_time, timemodified) VALUES
('8c6dd82d-7886-4378-ac13-d0781d6440a4', '2d3c1e66-1835-457f-93e9-265fe483feee', '577e118d-604b-450c-a02c-cf8e9f35f8ee', false, -1.0, null, '', '2024-05-06 14:20:25', '2024-05-06 21:20:25+07'),
('aa45447a-836f-40de-8737-b1478bc80a19', 'cb2c22ac-87de-44e4-9638-35979f6af667', '577e118d-604b-450c-a02c-cf8e9f35f8ee', false, -1.0, null, '', '2024-05-24 02:53:17', '2024-05-28 14:10:04+07'),
('ad32ef95-b182-4935-8f0e-3b88d5896adc', '2d7ed5a0-fb21-4927-9a25-647c17d29668', 'b1b3e215-2450-4819-9aa6-3aea9f87e604', false, -1.0, null, '', '2024-05-07 08:43:42', '2024-05-07 15:43:42+07'),
('9f011388-31b4-4630-ac11-975febff1948', 'cb2c22ac-87de-44e4-9638-35979f6af667', 'b1b3e215-2450-4819-9aa6-3aea9f87e604', true, 100.0, null, '', '2024-05-06 07:35:10', '2024-05-06 14:39:26+07'),
('8478c536-e657-408c-acbb-55905eeead13', '2d7ed5a0-fb21-4927-9a25-647c17d29668', '3926bcb3-6415-458d-b449-6e2b464732d7', true, 4.5, null, '<p dir="ltr" style="text-align:left;">Quá xuất sắc</p>', '2024-05-27 05:11:08', '2024-05-27 12:11:08+07'),
('b85df3d3-86ce-449f-8ed3-6ecafcad4cf9', 'cb2c22ac-87de-44e4-9638-35979f6af667', '3926bcb3-6415-458d-b449-6e2b464732d7', true, 85.0, null, '<p dir="ltr" style="text-align:left;">Qua xuất sắc<img src="http://62.171.185.208/webservice/pluginfile.php/41/assignfeedback_comments/feedback/6/242549690_4573384179372457_7212491116034148251_n.png" alt="hehe" width="600" height="600" class="img-fluid atto_image_button_text-bottom" /></p>', '2024-05-06 07:31:38', '2024-05-26 11:52:48+07'),
('29d83061-2aac-4bb4-9e41-6344dad72264', '9ba179ed-d26d-4828-a0f6-8836c2063992', '3926bcb3-6415-458d-b449-6e2b464732d7', true, 100.0, '<p dir="ltr" style="text-align:left;">hehe</p>', '<p dir="ltr" style="text-align:left;">Quá giỏi</p>', '2024-05-08 02:27:03', '2024-05-08 09:27:37+07'),
('5dece352-1ce6-4159-a23e-80437d9f15ec', '2d7ed5a0-fb21-4927-9a25-647c17d29668', '8c6d9aa1-f157-49ca-bfae-bc8a14570c81', false, -1.0, null, '', '2024-05-28 08:09:33', '2024-05-28 15:09:33+07'),
('e8500189-218e-4420-95fd-0ba98b4fbddd', 'cb2c22ac-87de-44e4-9638-35979f6af667', '8c6d9aa1-f157-49ca-bfae-bc8a14570c81', false, -1.0, null, '', '2024-05-06 08:11:48', '2024-05-07 17:25:05+07'),
('13bc8451-f836-455d-9a36-fc0e00596443', '9ba179ed-d26d-4828-a0f6-8836c2063992', '8c6d9aa1-f157-49ca-bfae-bc8a14570c81', false, -1.0, null, '', '2024-05-08 02:08:36', '2024-05-08 09:12:00+07');

INSERT INTO public.submission_assignment (id,user_id,assignment_id,is_graded,grade,"content",feedback,submit_time,timemodified) VALUES
	 ('40b37e96-5960-4484-97fe-a3d207c4f5c9','ca3040f2-e173-40a5-aab7-6ef15965ce43','438413fa-ac31-496a-becb-709505ea990a',true,65.0,null,'<p dir="ltr" style="text-align:left;">Tốt</p>','2024-05-13 03:32:09','2024-05-13 10:32:40+07');

INSERT INTO submission_assignment_file (id, submission_assignment_id, file_name, file_size, file_url, timemodified, mimetype) VALUES
    ('70c12ca5-e76a-47a9-aefd-2117f0c9f8f0', 'aa45447a-836f-40de-8737-b1478bc80a19', 'DeCuongDeTaiTN (1).pdf', 227177, 'http://62.171.185.208/webservice/pluginfile.php/39/assignsubmission_file/submission_files/21/DeCuongDeTaiTN%20%281%29.pdf', '2024-05-28 14:10:04+07', 'application/pdf'),
    ('2e81be32-b6b4-47e6-9659-dd4dad461ae5', '9f011388-31b4-4630-ac11-975febff1948', 'f662213566f63d19a90770676f0941ee.jpg', 44665, 'http://62.171.185.208/webservice/pluginfile.php/38/assignsubmission_file/submission_files/5/f662213566f63d19a90770676f0941ee.jpg', '2024-05-06 14:39:26+07', 'image/jpeg'),
    ('f52878c4-ec12-4f2b-846c-fa8e3849da56', 'b85df3d3-86ce-449f-8ed3-6ecafcad4cf9', 'DeCuongDeTaiTN (1).pdf', 227177, 'http://62.171.185.208/webservice/pluginfile.php/41/assignsubmission_file/submission_files/4/DeCuongDeTaiTN%20%281%29.pdf', '2024-05-26 08:58:16+07', 'application/pdf'),
    ('14a9db27-30d2-45b6-ac89-4ee45f0d2844', '29d83061-2aac-4bb4-9e41-6344dad72264', '65864c8f201a9b2b1b6ca4405906b6de.jpg', 6616, 'http://62.171.185.208/webservice/pluginfile.php/41/assignsubmission_file/submission_files/15/65864c8f201a9b2b1b6ca4405906b6de.jpg', '2024-05-08 09:27:37+07', 'image/jpeg'),
    ('779f5d26-82d7-4161-a2d6-83b145c7f6b8', 'e8500189-218e-4420-95fd-0ba98b4fbddd', '1f449.png', 9852, 'http://62.171.185.208/webservice/pluginfile.php/42/assignsubmission_file/submission_files/6/1f449.png', '2024-05-06 15:13:42+07', 'image/png'),
    ('779f5d26-82d7-4161-a2d6-83b145c7f6b2', 'e8500189-218e-4420-95fd-0ba98b4fbddd', 'test1.jpg', 60887, 'http://62.171.185.208/webservice/pluginfile.php/42/assignsubmission_file/submission_files/6/test1.jpg', '2024-05-07 17:25:05+07', 'image/jpeg'),
    ('d7da73d7-76d1-448f-9d7c-cfcdf2045deb', '13bc8451-f836-455d-9a36-fc0e00596443', '438255262_122148182144103154_1065002638849796416_n.jpg', 59292, 'http://62.171.185.208/webservice/pluginfile.php/42/assignsubmission_file/submission_files/14/438255262_122148182144103154_1065002638849796416_n.jpg', '2024-05-08 09:12:00+07', 'image/jpeg'),
    ('7c4727d4-ce7d-4659-9979-496219958a26', '40b37e96-5960-4484-97fe-a3d207c4f5c9', '2024-04-26T07-00 Giao dịch số 7331655503614525-14503349 (1).pdf', 1059932, 'http://62.171.185.208/webservice/pluginfile.php/48/assignsubmission_file/submission_files/16/2024-04-26T07-00%20Giao%20d%E1%BB%8Bch%20s%E1%BB%91%207331655503614525-14503349%20%281%29.pdf', '2024-05-13 10:32:40+07', 'application/pdf');


INSERT INTO public.submission_assignment_onlinetext (id,submission_assignment_id,"content") VALUES
	 ('ebd4b942-bf89-4a25-b297-4943fd8ed783','b85df3d3-86ce-449f-8ed3-6ecafcad4cf9','<p dir="ltr" style="text-align:left;">hello sieu nhan</p><p dir="ltr" style="text-align:left;"><br /></p><p dir="ltr" style="text-align:left;"></p><ol><li>hihi</li><li>huhu<img src="http://62.171.185.208/webservice/pluginfile.php/41/assignsubmission_onlinetext/submissions_onlinetext/4/b0f87d036752d9f959db778873df9d59.jpg" alt="huhu" width="736" height="737" class="img-fluid atto_image_button_text-bottom" /></li></ol>'),
	 ('1db25399-7fb1-4e60-a73f-fb5370e8b719','29d83061-2aac-4bb4-9e41-6344dad72264','<p dir="ltr" style="text-align:left;">hehe</p>');


INSERT INTO public.submission_grade (id,submission_assignment_id,grade,time_created,time_modified) VALUES
	 ('d393472f-51e7-44cc-ab66-b7924f06cc70','9f011388-31b4-4630-ac11-975febff1948',100.0,'2024-05-07 15:41:52+07','2024-05-07 15:43:41+07'),
	 ('ba856634-b455-406f-ac3f-c9f81d7e90cb','b85df3d3-86ce-449f-8ed3-6ecafcad4cf9',85.0,'2024-05-27 12:10:38+07','2024-05-28 08:50:19+07'),
	 ('197fc2c8-42e8-4fcf-927d-cb0500923973','29d83061-2aac-4bb4-9e41-6344dad72264',100.0,'2024-05-27 12:11:19+07','2024-05-27 12:11:34+07'),
	 ('20c2d520-8543-474b-b186-51d288497f7b','40b37e96-5960-4484-97fe-a3d207c4f5c9',65.0,'2024-05-24 10:22:55+07','2024-05-24 10:23:14+07');

INSERT INTO public."section" (id,course_id,section_moodle_id,name,visible) VALUES
	 ('ed07ff8d-d5a4-4edc-8bb6-b3cf59aa7cc3','983942d9-3366-4004-9f9a-c4e7e7760cc0',1,'General',1),
	 ('d8814d8f-0202-4633-873a-bad722505a56','983942d9-3366-4004-9f9a-c4e7e7760cc0',2,'Topic 1',1),
	 ('df66055f-cbce-4d33-839c-3a61d87a4d04','983942d9-3366-4004-9f9a-c4e7e7760cc0',3,'Topic 2',1),
	 ('b39bb68c-0f50-435d-bc54-2a383f916543','983942d9-3366-4004-9f9a-c4e7e7760cc0',4,'Topic 3',1),
	 ('e6a2684c-4a28-40a5-bba9-653e82f6cbcc','983942d9-3366-4004-9f9a-c4e7e7760cc0',5,'Topic 4',1),
	 ('f68a5db2-8e45-4d7e-ad3f-a2723f03a4ae','c061d55e-a8b0-433f-b6a3-ae9d5601422e',6,'General',1),
	 ('7e89a8d4-5137-4457-81aa-1828265fc5ef','c061d55e-a8b0-433f-b6a3-ae9d5601422e',7,'Topic 1',1),
	 ('28509ef2-650b-412d-9798-1acc8c09b1a0','c061d55e-a8b0-433f-b6a3-ae9d5601422e',8,'Topic 2',1),
	 ('52417058-676b-4552-a36b-ccbcbcd3327e','c061d55e-a8b0-433f-b6a3-ae9d5601422e',9,'Topic 3',1),
	 ('a48b5285-0813-4ee5-a639-40d778a4351b','c061d55e-a8b0-433f-b6a3-ae9d5601422e',10,'Topic 4',1);
INSERT INTO public."section" (id,course_id,section_moodle_id,name,visible) VALUES
	 ('70bb8281-5c4a-44a6-a745-0d72dd1abe20','62943cbb-5bc5-4cef-b9a9-e33c82ecf984',12,'General',1),
	 ('545b9d6f-ac3a-45bc-9f17-b2a1bc1ecc22','62943cbb-5bc5-4cef-b9a9-e33c82ecf984',13,'Topic 1',1),
	 ('924b15c9-6ab5-4198-9370-63d7c8e5cb26','62943cbb-5bc5-4cef-b9a9-e33c82ecf984',14,'Topic 2',1),
	 ('a85f65c0-b968-411b-88c5-58c1cfa194fe','62943cbb-5bc5-4cef-b9a9-e33c82ecf984',15,'Topic 3',1),
	 ('b8c1b3ca-cde6-4f24-9ea6-92c13d0d1d28','62943cbb-5bc5-4cef-b9a9-e33c82ecf984',16,'Topic 4',1),
	 ('8cdaadce-b3c0-40e0-8aaa-435f4eaade54','0888fabf-acd7-4ffa-9978-51558e5a0ee1',17,'General',1),
	 ('1d0c710c-8052-4e75-9c8b-b830f93fbd75','0888fabf-acd7-4ffa-9978-51558e5a0ee1',18,'Topic 1',1),
	 ('57eb81c4-a730-4d00-abba-32b53a8072bc','0888fabf-acd7-4ffa-9978-51558e5a0ee1',19,'Topic 2',1),
	 ('5d4475f9-5add-471a-9b4d-093d8db48cdb','0888fabf-acd7-4ffa-9978-51558e5a0ee1',20,'Topic 3',1),
	 ('5d8b41da-babe-4a24-b90c-ba4457d269e2','0888fabf-acd7-4ffa-9978-51558e5a0ee1',21,'Topic 4',1);
INSERT INTO public."section" (id,course_id,section_moodle_id,name,visible) VALUES
	 ('a0760a47-5977-49de-a400-8fde361523b5','c31382b2-2fbd-43ae-89de-12b6614fc8ab',22,'General',1),
	 ('99588883-9906-4b24-ad99-3c8e24e277f5','c31382b2-2fbd-43ae-89de-12b6614fc8ab',23,'Topic 1',1),
	 ('83a14cf8-8ff7-4630-94f5-813d4307e83e','c31382b2-2fbd-43ae-89de-12b6614fc8ab',24,'Topic 2',1),
	 ('fb02fb82-4ddb-4ef2-bf61-5ed1a9f37fd2','c31382b2-2fbd-43ae-89de-12b6614fc8ab',25,'Topic 3',1),
	 ('33be7f98-01b8-4a9f-866b-2bc18f75acf8','c31382b2-2fbd-43ae-89de-12b6614fc8ab',26,'Topic 4',1);

INSERT INTO public."module" (id, cmid, section_id, name, visible, content, type_module, time_open, time_close, assignment_id) VALUES
    ('d21b508d-ddfb-4f0e-a49b-60597cb432b3', 6, 'd8814d8f-0202-4633-873a-bad722505a56', 'Đây là bài tập 11', 1, NULL, 'ASSIGNMENT', '2024-05-06 00:00:00+07', '2024-05-13 00:00:00+07', '577e118d-604b-450c-a02c-cf8e9f35f8ee'),
    ('ff221787-624f-40c6-b6c1-0a7ff2909bf6', 5, '7e89a8d4-5137-4457-81aa-1828265fc5ef', 'bài tập 2', 1, NULL, 'ASSIGNMENT', '2024-05-06 00:00:00+07', '2024-05-13 00:00:00+07', 'b1b3e215-2450-4819-9aa6-3aea9f87e604'),
    ('09c0bd11-468a-4c73-b5b2-4cfb01e25b74', 7, '7e89a8d4-5137-4457-81aa-1828265fc5ef', 'baaif tạp cuối', 1, NULL, 'ASSIGNMENT', '2024-05-08 17:16:00+07', '2024-05-17 18:19:00+07', 'f37edb09-e0f6-4e96-8469-d6eff5378c9d'),
    ('d946a443-be55-495c-b545-9c5ef157064c', 8, '7e89a8d4-5137-4457-81aa-1828265fc5ef', 'baafi online tẽt', 1, NULL, 'ASSIGNMENT', '2024-05-06 00:00:00+07', '2024-05-13 00:00:00+07', '3926bcb3-6415-458d-b449-6e2b464732d7'),
    ('846a625b-6d7d-4cda-bf4e-ef8ef9549af7', 9, '7e89a8d4-5137-4457-81aa-1828265fc5ef', 'Bài taapj 1', 1, NULL, 'ASSIGNMENT', '2024-05-06 00:00:00+07', '2024-05-13 00:00:00+07', '8c6d9aa1-f157-49ca-bfae-bc8a14570c81'),
    ('ff57ea21-fa77-4fc5-8047-915391df5824', 10, '7e89a8d4-5137-4457-81aa-1828265fc5ef', 'hehe', 1, NULL, 'ASSIGNMENT', '2024-05-06 00:00:00+07', '2024-05-13 00:00:00+07', '124c9619-cd26-43fb-8ea4-610b164925ad'),
    ('32f7e6b8-f4d0-46cf-b461-62d5328e2540', 11, '7e89a8d4-5137-4457-81aa-1828265fc5ef', 'Baaif tập 10', 0, NULL, 'ASSIGNMENT', '2024-05-06 00:00:00+07', '2024-05-13 00:00:00+07', 'fbe31ca6-ddc9-49ef-87f3-c472958a52c0'),
    ('0e843862-201b-4593-8e67-134790252295', 18, '7e89a8d4-5137-4457-81aa-1828265fc5ef', 'Bài tập module', 1, NULL, 'ASSIGNMENT', '2024-05-12 00:00:00+07', '2024-05-19 00:00:00+07', '0ffc63bf-c1b9-4676-9612-65ab6a24ce5b'),
    ('d9ee7356-3cc0-4780-b5f2-5b5e02570c38', 14, '70bb8281-5c4a-44a6-a745-0d72dd1abe20', 'bài 1', 1, NULL, 'ASSIGNMENT', '2024-05-07 00:00:00+07', '2024-05-14 00:00:00+07', '438413fa-ac31-496a-becb-709505ea990a'),
    ('8758ec8e-6322-4f6a-b68d-1c4a3c1e824a', 20, '70bb8281-5c4a-44a6-a745-0d72dd1abe20', 'Bài tập 2', 1, NULL, 'ASSIGNMENT', '2024-05-22 00:00:00+07', '2024-05-29 00:00:00+07', '7055f5fd-29ce-48f9-b1d1-cd11a95ce931'),
    ('caca48ad-21c5-414d-94c1-b324c25fe8c8', 22, '70bb8281-5c4a-44a6-a745-0d72dd1abe20', 'Bài tập 3', 1, NULL, 'ASSIGNMENT', '2024-05-22 00:00:00+07', '2024-05-29 00:00:00+07', 'b3108f5a-c769-42ab-84c9-80a6d80f5821'),
    ('2c8c1590-3e17-46bb-ac93-fb3d3b293544', 23, '70bb8281-5c4a-44a6-a745-0d72dd1abe20', 'Bài tập 4', 1, NULL, 'ASSIGNMENT', '2024-05-22 00:00:00+07', '2024-05-29 00:00:00+07', '5b82b228-aef2-494f-8622-2be74966106d'),
    ('be09f62d-6d6f-4239-9b6b-08b784717788', 24, '70bb8281-5c4a-44a6-a745-0d72dd1abe20', 'bt 5', 1, NULL, 'ASSIGNMENT', '2024-05-28 00:00:00+07', '2024-06-04 00:00:00+07', '56f0980c-3944-40b1-9cb6-1b9b46891de6');



INSERT INTO public.question(id, org_id, difficulty, name, question_text, general_feedback, default_mark, qtype, created_by, updated_by)
VALUES
   ('b6484e21-6937-489c-b031-b71767994221', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'HARD', 'Question Pants', 'Question Mouse Text', 'Question Tuna feedback', 1, 'CODE', 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c'),
   ('b6484e21-6937-489c-b031-b71767994233', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'EASY', 'Question Handle', 'Question Wire Text', 'Question Gold feedback', 1, 'ESSAY', 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c'),
   ('b6484e21-6937-489c-b031-b71767994132', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'MEDIUM', 'Question hihi', 'Question Wow Text', 'Question Amazing feedback', 1, 'SHORT_ANSWER', 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c'),
   ('b6484e21-6937-489c-b031-b71767994735', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'HARD', 'Question haha', 'Question Speaker Text', 'Question Good Job feedback', 1, 'MULTIPLE_CHOICE', 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c');

--INSERT INTO public.course(id, name, course_type_id,org_id, created_by, updated_by, created_at, updated_at)
--VALUES
--    ('b6484e21-6937-489c-b031-b71767994736', 'CSC001 - Nhập môn lập trình', null,'08b65a39-394f-4977-a5fa-3fe145b620f8', 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-04-15 18:07:41.151759+07', '2024-04-15 18:07:41.151759+07'),
--    ('b6484e21-6937-489c-b031-b71767994737', 'CSC002 - Lập trình hướng đối tượng', null,'08b65a39-394f-4977-a5fa-3fe145b620f8', 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-04-15 18:07:41.151759+07', '2024-04-15 18:07:41.151759+07'),
--    ('b6484e21-6937-489c-b031-b71767994738', 'CSC003 - Lập trình web', null,'08b65a39-394f-4977-a5fa-3fe145b620f8', 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-04-15 18:07:41.151759+07', '2024-04-15 18:07:41.151759+07');
--
--INSERT INTO public.exam(id, course_id, name, intro, time_open, time_close, time_limit)
--VALUES
--    ('b6484e21-6937-489c-b031-b71767994739', 'b6484e21-6937-489c-b031-b71767994736', 'Kiểm tra giữa kỳ', 'Intro 1', '2024-04-15 18:07:41.151759+07', '2024-04-16 18:07:41.151759+07', 3600),
--    ('b6484e21-6937-489c-b031-b71767994740', 'b6484e21-6937-489c-b031-b71767994737', 'Kiểm tra cuối kỳ', 'Intro 2', '2024-04-15 18:07:41.151759+07', '2024-04-16 18:07:41.151759+07', 3600),
--    ('b6484e21-6937-489c-b031-b71767994741', 'b6484e21-6937-489c-b031-b71767994738', 'Kiểm tra đầu buổi 1', 'Intro 3', '2024-04-15 18:07:41.151759+07', '2024-04-16 18:07:41.151759+07', 3600);
--
--INSERT INTO public.exam_question(id, exam_id, question_id)
--VALUES
--    ('b6484e21-6937-489c-b031-b71767994742', 'b6484e21-6937-489c-b031-b71767994739', 'b6484e21-6937-489c-b031-b71767994221'),
--    ('b6484e21-6937-489c-b031-b71767994743', 'b6484e21-6937-489c-b031-b71767994740', 'b6484e21-6937-489c-b031-b71767994233'),
--    ('b6484e21-6937-489c-b031-b71767994744', 'b6484e21-6937-489c-b031-b71767994741', 'b6484e21-6937-489c-b031-b71767994132');

INSERT INTO public.webhook_api_function(id, name, description)
VALUES
    ('b6484e21-6937-489c-b031-b71767991741', '\\core\\event\\course_created', 'Course created'),
    ('b6484e21-6937-489c-b031-b71767992742', '\\core\\event\\course_deleted', 'Course deleted'),
    ('b6484e21-6937-489c-b031-b71767993743', '\\core\\event\\course_updated', 'Course updated'),
    ('b6484e21-6937-489c-b031-b71767994735', '\\core\\event\\course_section_created', 'Course section created'),
    ('b6484e21-6937-489c-b031-b71767994736', '\\core\\event\\course_section_deleted', 'Course section deleted'),
    ('b6484e21-6937-489c-b031-b71767994737', '\\core\\event\\course_section_updated', 'Course section updated'),
    ('b6484e21-6937-489c-b031-b71767994738', '\\core\\event\\course_module_created', 'Course module created'),
    ('b6484e21-6937-489c-b031-b71767994739', '\\core\\event\\course_module_deleted', 'Course module deleted'),
    ('b6484e21-6937-489c-b031-b71767994740', '\\core\\event\\course_module_updated', 'Course module updated'),
    ('b6484e21-6937-489c-b031-b71767994741', '\\core\\event\\user_created', 'User created'),
    ('b6484e21-6937-489c-b031-b71767994742', '\\core\\event\\user_deleted', 'User deleted'),
    ('b6484e21-6937-489c-b031-b71767994743', '\\core\\event\\user_updated', 'User updated');


INSERT INTO public.webhook_function_organization(id, webhook_api_function_id, org_id)
VALUES
    ('b6484e21-6937-489c-b031-b71767994744', 'b6484e21-6937-489c-b031-b71767991741', '08b65a39-394f-4977-a5fa-3fe145b620f8'),
    ('b6484e21-6937-489c-b031-b71767994745', 'b6484e21-6937-489c-b031-b71767992742', '08b65a39-394f-4977-a5fa-3fe145b620f8'),
    ('b6484e21-6937-489c-b031-b71767994746', 'b6484e21-6937-489c-b031-b71767993743', '08b65a39-394f-4977-a5fa-3fe145b620f8');

--INSERT INTO public.course_type(id, moodle_id, name)
--VALUES
--    ('b6484e21-6937-489c-b031-b71767994747', '0', 'CLC'),
--    ('b6484e21-6937-489c-b031-b71767994748', '1', 'VP'),
--    ('b6484e21-6937-489c-b031-b71767994749', '2', 'APCS');
--INSERT INTO public.answer_of_question(id, question_id, feedback, answer, fraction)
--VALUES
--    ('d215b5f8-0249-4dc5-89a3-51fd148cfb15', 'b6484e21-6937-489c-b031-b71767994221', 'Correct', 'print(Hello World)', 1),
--    ('d215b5f8-0249-4dc5-89a3-51fd148cfb64', 'b6484e21-6937-489c-b031-b71767994233', 'Wrong', 'Essat 1', 1),
--    ('d215b5f8-0249-4dc5-89a3-51fd148cfb86', 'b6484e21-6937-489c-b031-b71767994233', 'Wow', 'p p p)', 1),
--    ('d215b5f8-0249-4dc5-89a3-51fd148cfb25', 'b6484e21-6937-489c-b031-b71767994233', 'Good', 'essay t12', 1),
--    ('d215b5f8-0249-4dc5-89a3-51fd148cfb69', 'b6484e21-6937-489c-b031-b71767994132', 'Bad', 'short answer t12', 1),
--    ('d215b5f8-0249-4dc5-89a3-51fd148cfe63', 'b6484e21-6937-489c-b031-b71767994735', 'Hihi', 'multi 1', 1),
--    ('d215b5f8-0249-4dc5-89a3-51fd148cff62', 'b6484e21-6937-489c-b031-b71767994735', 'huhu', 'multi 2', 1),
--    ('d215b5f8-0249-4dc5-89a3-51fd148cff20', 'b6484e21-6937-489c-b031-b71767994735', 'haha', 'multi 3', 1);

