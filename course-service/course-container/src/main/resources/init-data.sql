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
    ('56f0980c-3944-40b1-9cb6-1b9b46891de6', 15, '62943cbb-5bc5-4cef-b9a9-e33c82ecf984', 'bt 5', 'bt 3', NULL, 100.0, '2024-05-28 00:00:00+07', '2024-06-04 00:00:00+07', '1970-01-01 08:00:00+08', 'FILE', false, NULL, '40', '40000',true),
    ('e1a6c218-1a45-4d2e-9020-1f3e8d5f098c', 16, 'c061d55e-a8b0-433f-b6a3-ae9d5601422e', 'Câu hỏi lập trình 1', '<p dir="ltr" style="text-align: left;">Giải thích khái niệm "biến" trong lập trình và các loại biến phổ biến.</p>', NULL, 100.0, '2024-07-01 00:00:00+07', '2024-07-08 00:00:00+07', '1970-01-01 08:00:00+08', 'TEXT_ONLINE', false, NULL, '40', '40000', true),
    ('b24d3df4-3f8e-4d23-b18f-8d82ff37cda9', 17, 'c061d55e-a8b0-433f-b6a3-ae9d5601422e', 'Câu hỏi lập trình 2', '<p dir="ltr" style="text-align: left;">Trình bày sự khác biệt giữa "hàm" và "phương thức" trong lập trình.</p>', NULL, 100.0, '2024-07-01 00:00:00+07', '2024-07-08 00:00:00+07', '1970-01-01 08:00:00+08', 'TEXT_ONLINE', false, NULL, '40', '40000', true),
    ('f58e95a8-799c-4d2e-b5f3-d9b9d5566eec', 18, 'c061d55e-a8b0-433f-b6a3-ae9d5601422e', 'Câu hỏi lập trình 3', '<p dir="ltr" style="text-align: left;">Mô tả các kiểu dữ liệu cơ bản trong lập trình và ví dụ cho từng loại.</p>', NULL, 100.0, '2024-07-01 00:00:00+07', '2024-07-08 00:00:00+07', '1970-01-01 08:00:00+08', 'TEXT_ONLINE', false, NULL, '40', '40000', true),
    ('c12f49db-074f-4e5c-9c19-9dffcdf9a6b4', 19, 'c061d55e-a8b0-433f-b6a3-ae9d5601422e', 'Câu hỏi lập trình 4', '<p dir="ltr" style="text-align: left;">Nêu các nguyên lý lập trình hướng đối tượng và giải thích từng nguyên lý.</p>', NULL, 100.0, '2024-07-01 00:00:00+07', '2024-07-08 00:00:00+07', '1970-01-01 08:00:00+08', 'TEXT_ONLINE', false, NULL, '40', '40000', true);


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
('13bc8451-f836-455d-9a36-fc0e00596443', '9ba179ed-d26d-4828-a0f6-8836c2063992', '8c6d9aa1-f157-49ca-bfae-bc8a14570c81', false, -1.0, null, '', '2024-05-08 02:08:36', '2024-05-08 09:12:00+07'),
-- Câu hỏi lập trình 1
('8c6dd82d-7886-4378-ac13-d0781d6440a5', 'cb2c22ac-87de-44e4-9638-35979f6af667', 'e1a6c218-1a45-4d2e-9020-1f3e8d5f098c', false, -1.0, '<p>Biến là một vùng nhớ dùng để lưu trữ dữ liệu và có thể thay đổi trong quá trình thực thi chương trình. Trong lập trình, biến có các loại phổ biến như biến cục bộ, biến toàn cục và biến tĩnh. Biến cục bộ là biến được khai báo trong một hàm hoặc một khối mã và chỉ có thể được sử dụng trong phạm vi đó. Biến toàn cục là biến được khai báo bên ngoài các hàm và có thể được truy cập từ bất kỳ đâu trong chương trình. Biến tĩnh là biến giữ nguyên giá trị của nó trong suốt quá trình thực thi chương trình, ngay cả khi đã ra khỏi phạm vi của nó.</p>', '', '2024-07-03 14:00:00', '2024-07-03 14:00:00'),
('aa45447a-836f-40de-8737-b1478bc80a18', '2d7ed5a0-fb21-4927-9a25-647c17d29668', 'e1a6c218-1a45-4d2e-9020-1f3e8d5f098c', false, -1.0, '<p>Biến là một nơi lưu trữ dữ liệu có thể thay đổi trong chương trình. Có nhiều loại biến như biến cục bộ và biến toàn cục. Biến cục bộ chỉ có thể được sử dụng trong phạm vi hàm mà nó được khai báo. Biến toàn cục có thể được sử dụng ở bất kỳ đâu trong chương trình.</p>', '', '2024-07-03 14:00:00', '2024-07-03 14:00:00'),
('ad32ef95-b182-4935-8f0e-3b88d5896ad1', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'e1a6c218-1a45-4d2e-9020-1f3e8d5f098c', false, -1.0, '<p>Biến là một nơi lưu trữ dữ liệu trong chương trình. Có biến cục bộ và biến toàn cục.</p>', '', '2024-07-03 14:00:00', '2024-07-03 14:00:00'),

-- Câu hỏi lập trình 2
('9f011388-31b4-4630-ac11-975febff1942', 'cb2c22ac-87de-44e4-9638-35979f6af667', 'b24d3df4-3f8e-4d23-b18f-8d82ff37cda9', false, -1.0, '<p>Hàm là một đoạn mã thực hiện một nhiệm vụ cụ thể và có thể trả về một giá trị. Hàm có thể tồn tại độc lập và không thuộc về bất kỳ đối tượng nào. Phương thức là một hàm nhưng thuộc về một đối tượng hoặc một lớp. Phương thức có thể tương tác với các thuộc tính của đối tượng mà nó thuộc về và có thể truy cập các phương thức khác của cùng đối tượng.</p>', '', '2024-07-03 14:00:00', '2024-07-03 14:00:00'),
('8478c536-e657-408c-acbb-55905eeead25', '2d7ed5a0-fb21-4927-9a25-647c17d29668', 'b24d3df4-3f8e-4d23-b18f-8d82ff37cda9', false, -1.0, '<p>Hàm là một đoạn mã thực hiện một nhiệm vụ và có thể trả về một giá trị. Nó không thuộc về bất kỳ đối tượng nào. Phương thức là một hàm nhưng thuộc về một đối tượng hoặc lớp và có thể truy cập các thuộc tính và phương thức khác của đối tượng đó.</p>', '', '2024-07-03 14:00:00', '2024-07-03 14:00:00'),
('b85df3d3-86ce-449f-8ed3-6ecafcad4c56', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'b24d3df4-3f8e-4d23-b18f-8d82ff37cda9', false, -1.0, '<p>Hàm là một đoạn mã thực hiện một nhiệm vụ. Phương thức là hàm thuộc về một đối tượng.</p>', '', '2024-07-03 14:00:00', '2024-07-03 14:00:00'),

-- Câu hỏi lập trình 3
('29d83061-2aac-4bb4-9e41-6344dad72265', 'cb2c22ac-87de-44e4-9638-35979f6af667', 'f58e95a8-799c-4d2e-b5f3-d9b9d5566eec', false, -1.0, '<p>Các kiểu dữ liệu cơ bản trong lập trình gồm: Số nguyên (int): Lưu trữ số nguyên, ví dụ: `int age = 25;` Số thực (float, double): Lưu trữ số thập phân, ví dụ: `float height = 5.8;` Ký tự (char): Lưu trữ một ký tự, ví dụ: `char grade = A;` Chuỗi (string): Lưu trữ chuỗi ký tự, ví dụ: `string name = "John";` Boolean (bool): Lưu trữ giá trị đúng hoặc sai, ví dụ: `bool isStudent = true;`</p>', '', '2024-07-03 14:00:00', '2024-07-03 14:00:00'),
('8c6dd82d-7886-4378-ac13-d0781d6440a9', '2d7ed5a0-fb21-4927-9a25-647c17d29668', 'f58e95a8-799c-4d2e-b5f3-d9b9d5566eec', false, -1.0, '<p>Các kiểu dữ liệu cơ bản gồm: Số nguyên: `int age = 25;` Số thực: `float height = 5.8;` Ký tự: `char grade = A;` Chuỗi: `string name = "John";` Boolean: `bool isStudent = true;`</p>', '', '2024-07-03 14:00:00', '2024-07-03 14:00:00'),
('8c6dd82d-7886-4378-ac13-d0781d6440a2', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'f58e95a8-799c-4d2e-b5f3-d9b9d5566eec', false, -1.0, '<p>Các kiểu dữ liệu cơ bản là số nguyên, số thực, ký tự, chuỗi và boolean. Ví dụ: `int age = 25;`, `float height = 5.8;`, `char grade = A;`, `string name = "John";`, `bool isStudent = true;`</p>', '', '2024-07-03 14:00:00', '2024-07-03 14:00:00'),

-- Câu hỏi lập trình 4
('13bc8451-f836-455d-9a36-fc0e00596453', 'cb2c22ac-87de-44e4-9638-35979f6af667', 'c12f49db-074f-4e5c-9c19-9dffcdf9a6b4', false, -1.0, '<p>Các nguyên lý lập trình hướng đối tượng gồm: Tính đóng gói: Đóng gói dữ liệu và các phương thức liên quan vào một đối tượng. Tính kế thừa: Một lớp có thể kế thừa các thuộc tính và phương thức từ một lớp khác. Tính đa hình: Cho phép một phương thức có thể có nhiều cách cài đặt khác nhau. Tính trừu tượng: Ẩn giấu các chi tiết cài đặt và chỉ hiển thị các tính năng của đối tượng.</p>', '', '2024-07-03 14:00:00', '2024-07-03 14:00:00'),
('8c6dd82d-7886-4378-ac13-d0781d6440a6', '2d7ed5a0-fb21-4927-9a25-647c17d29668', 'c12f49db-074f-4e5c-9c19-9dffcdf9a6b4', false, -1.0, '<p>Các nguyên lý lập trình hướng đối tượng gồm: Đóng gói: Đóng gói dữ liệu và phương thức vào một đối tượng. Kế thừa: Kế thừa thuộc tính và phương thức từ lớp khác. Đa hình: Một phương thức có thể có nhiều cách cài đặt. Trừu tượng: Ẩn chi tiết cài đặt, chỉ hiển thị tính năng.</p>', '', '2024-07-03 14:00:00', '2024-07-03 14:00:00'),
('aa45447a-836f-40de-8737-b1478bc80a67', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'c12f49db-074f-4e5c-9c19-9dffcdf9a6b4', false, -1.0, '<p>Các nguyên lý lập trình hướng đối tượng gồm đóng gói, kế thừa, đa hình và trừu tượng. Mỗi nguyên lý có vai trò khác nhau trong lập trình.</p>', '', '2024-07-03 14:00:00', '2024-07-03 14:00:00');


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


INSERT INTO public.exam
(id, course_id, "name", intro, score, max_score, time_open, time_close, time_limit, time_limit_unit, unit, "overdue_handling", can_redo_questions, max_attempts, shuffle_questions, "grade_method", max_page, created_at, updated_at)
VALUES('86600cfb-7b48-4e81-8e05-8fa29d49d7a6'::uuid, 'c061d55e-a8b0-433f-b6a3-ae9d5601422e'::uuid, 'Kiểm tra chương 1', '<p>bài kiểm tra chương 1</p>', 10.0, 10.0, '2024-06-20 20:12:27.031', '2024-07-30 20:12:27.000', 6000, 100, 'minutes', 'AUTOSUBMIT'::public."overdue_handling", true, 0, false, 'QUIZ_GRADEHIGHEST'::public."grade_method", 0, '2024-06-20 20:14:49.484', '2024-06-20 20:14:49.484');


INSERT INTO public.question
(id, org_id, "name", question_text, general_feedback, default_mark, created_by, updated_by, created_at, updated_at, question_bank_category_id, is_org_question_bank, "qtype", "difficulty")
VALUES('20d06a81-f597-41bc-a60c-480d5c38eb80'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'Câu 1', '<p><span style="color: rgb(51, 51, 51);">Hãy cho biết ý tưởng nào sau đây nói về phương pháp sắp xếp chọn tăng dần (select sort)?</span></p>', '', 1.0, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-06-20 21:22:33.943', '2024-06-20 21:22:33.943', NULL, false, 'MULTIPLE_CHOICE'::public."qtype", 'EASY'::public."difficulty");
INSERT INTO public.question
(id, org_id, "name", question_text, general_feedback, default_mark, created_by, updated_by, created_at, updated_at, question_bank_category_id, is_org_question_bank, "qtype", "difficulty")
VALUES('82a72f33-69d1-417a-bc4a-54e4a3f42a06'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'Câu 2', '<h4><a href="https://khoahoc.vietjack.com/question/958165/phuong-phap-nao-sau-day-chinh-la-phuong-phap-sap-xep-nhanh-quick-sort" rel="noopener noreferrer" target="_blank" style="color: rgb(0, 0, 0); background-color: transparent;">Phương pháp nào sau đây chính là phương pháp sắp xếp nhanh (Quick sort)?</a></h4><p><br></p>', '', 1.0, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-06-20 21:24:18.255', '2024-06-20 21:24:18.255', NULL, false, 'MULTIPLE_CHOICE'::public."qtype", 'EASY'::public."difficulty");
INSERT INTO public.question
(id, org_id, "name", question_text, general_feedback, default_mark, created_by, updated_by, created_at, updated_at, question_bank_category_id, is_org_question_bank, "qtype", "difficulty")
VALUES('fe65d7df-69ac-4a17-805c-f1f2b65b9972'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'Câu 3', '<h4><a href="https://khoahoc.vietjack.com/question/958164/hay-cho-biet-y-tuong-nao-sau-day-noi-ve-phuong-phap-sap-xep-nhanh-quick-sort" rel="noopener noreferrer" target="_blank" style="color: rgb(0, 0, 0); background-color: transparent;">Hãy cho biết ý tưởng nào sau đây nói về phương pháp sắp xếp nhanh (Quick sort)?</a></h4><p><br></p>', '', 1.0, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-06-20 21:25:56.678', '2024-06-20 21:25:56.678', NULL, false, 'MULTIPLE_CHOICE'::public."qtype", 'EASY'::public."difficulty");
INSERT INTO public.question
(id, org_id, "name", question_text, general_feedback, default_mark, created_by, updated_by, created_at, updated_at, question_bank_category_id, is_org_question_bank, "qtype", "difficulty")
VALUES('53ce35a7-9dcf-4741-a4ed-872874daf829'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'Câu 4', '<p><a href="https://vietjack.online/cau-hoi/958554/giai-thuat-de-quy-la-a-trong-giai-thuat-cua-no-co-loi-goi-toi-chinh-no" rel="noopener noreferrer" target="_blank" style="color: rgb(0, 0, 0); background-color: transparent;">Giải thuật đệ quy là:</a></p>', '', 1.0, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-06-20 21:28:17.404', '2024-06-20 21:28:17.404', NULL, false, 'MULTIPLE_CHOICE'::public."qtype", 'EASY'::public."difficulty");
INSERT INTO public.question
(id, org_id, "name", question_text, general_feedback, default_mark, created_by, updated_by, created_at, updated_at, question_bank_category_id, is_org_question_bank, "qtype", "difficulty")
VALUES('0fe5d2ee-6892-4f62-a6e6-83284f2430bc'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'Câu 5', '<p>QUEUE hoạt động như thế nào?</p>', '', 1.0, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-06-20 21:29:19.651', '2024-06-20 21:29:19.651', NULL, false, 'SHORT_ANSWER'::public."qtype", 'EASY'::public."difficulty");
INSERT INTO public.question
(id, org_id, "name", question_text, general_feedback, default_mark, created_by, updated_by, created_at, updated_at, question_bank_category_id, is_org_question_bank, "qtype", "difficulty")
VALUES('513a7e58-00d0-450b-8f0d-78af23898b81'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'Câu 6', '<p>Sinh viên IT mới ra trường lương nghìn $ ?</p>', '', 1.0, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-06-20 21:30:30.013', '2024-06-20 21:30:30.013', NULL, false, 'TRUE_FALSE'::public."qtype", 'EASY'::public."difficulty");
INSERT INTO public.question
(id, org_id, "name", question_text, general_feedback, default_mark, created_by, updated_by, created_at, updated_at, question_bank_category_id, is_org_question_bank, "qtype", "difficulty")
VALUES('1168fba1-8391-4294-b1cb-2c108f96af1f'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'Câu 7', '<p>Trường HCMUS top 1 IT?</p>', '', 1.0, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-06-20 21:31:56.412', '2024-06-20 21:31:56.412', NULL, false, 'TRUE_FALSE'::public."qtype", 'EASY'::public."difficulty");
INSERT INTO public.question
(id, org_id, "name", question_text, general_feedback, default_mark, created_by, updated_by, created_at, updated_at, question_bank_category_id, is_org_question_bank, "qtype", "difficulty")
VALUES('c4b3219f-9d83-4497-ad15-d46772141bd5'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'Câu 8', '<p>STACK hoạt động như nào?</p>', '', 1.0, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-06-20 21:33:16.858', '2024-06-20 21:33:16.858', NULL, false, 'SHORT_ANSWER'::public."qtype", 'EASY'::public."difficulty");
INSERT INTO public.question
(id, org_id, "name", question_text, general_feedback, default_mark, created_by, updated_by, created_at, updated_at, question_bank_category_id, is_org_question_bank, "qtype", "difficulty")
VALUES('29a71c20-290b-471d-acc8-4c5c929f96a8'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'Câu 9', '<p>Đầu vào trường Ú rất dễ?</p>', '', 1.0, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-06-20 21:34:57.337', '2024-06-20 21:34:57.337', NULL, false, 'TRUE_FALSE'::public."qtype", 'EASY'::public."difficulty");
INSERT INTO public.question
(id, org_id, "name", question_text, general_feedback, default_mark, created_by, updated_by, created_at, updated_at, question_bank_category_id, is_org_question_bank, "qtype", "difficulty")
VALUES('1ca8c89a-1bd0-41b2-adf0-4f7b55f8b256'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'Câu 10', '<p>Thầy cô trường Ú dễ thương</p>', '', 1.0, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-06-20 21:35:23.436', '2024-06-20 21:35:23.436', NULL, false, 'TRUE_FALSE'::public."qtype", 'EASY'::public."difficulty");



INSERT INTO public.exam_question
(id, exam_id, question_id, page)
VALUES('c29ccb3f-2429-4d49-9cbb-ba348164be58'::uuid, '86600cfb-7b48-4e81-8e05-8fa29d49d7a6'::uuid, '82a72f33-69d1-417a-bc4a-54e4a3f42a06'::uuid, 0),
             ('c29ccb3f-2429-4d49-9cbb-ba348164be59'::uuid, '86600cfb-7b48-4e81-8e05-8fa29d49d7a6'::uuid, 'b6484e21-6937-489c-b031-b71767994233'::uuid, 0),
             ('c29ccb3f-2429-4d49-9cbb-ba348164be60'::uuid, '86600cfb-7b48-4e81-8e05-8fa29d49d7a6'::uuid, 'b6484e21-6937-489c-b031-b71767994221'::uuid, 0);


INSERT INTO public.exam_question
(id, exam_id, question_id, page)
VALUES('291494a8-1527-4fa3-aff7-67c0406849a9'::uuid, '86600cfb-7b48-4e81-8e05-8fa29d49d7a6'::uuid, '53ce35a7-9dcf-4741-a4ed-872874daf829'::uuid, 1);
INSERT INTO public.exam_question
(id, exam_id, question_id, page)
VALUES('b8afcdb5-b8e4-4ee3-8708-48865787454c'::uuid, '86600cfb-7b48-4e81-8e05-8fa29d49d7a6'::uuid, '0fe5d2ee-6892-4f62-a6e6-83284f2430bc'::uuid, 1);
INSERT INTO public.exam_question
(id, exam_id, question_id, page)
VALUES('0d043280-4256-48b8-8792-5aca115b7b14'::uuid, '86600cfb-7b48-4e81-8e05-8fa29d49d7a6'::uuid, '1ca8c89a-1bd0-41b2-adf0-4f7b55f8b256'::uuid, 0);
INSERT INTO public.exam_question
(id, exam_id, question_id, page)
VALUES('72cb08d5-dfc7-40d5-910f-1b04eb9378ff'::uuid, '86600cfb-7b48-4e81-8e05-8fa29d49d7a6'::uuid, '513a7e58-00d0-450b-8f0d-78af23898b81'::uuid, 1);
INSERT INTO public.exam_question
(id, exam_id, question_id, page)
VALUES('b4b22535-6990-4197-aa9f-5c8b917baf13'::uuid, '86600cfb-7b48-4e81-8e05-8fa29d49d7a6'::uuid, 'fe65d7df-69ac-4a17-805c-f1f2b65b9972'::uuid, 2);
INSERT INTO public.exam_question
(id, exam_id, question_id, page)
VALUES('d132fdaa-3435-43c4-9e98-1fe2117e89ad'::uuid, '86600cfb-7b48-4e81-8e05-8fa29d49d7a6'::uuid, 'c4b3219f-9d83-4497-ad15-d46772141bd5'::uuid, 0);
INSERT INTO public.exam_question
(id, exam_id, question_id, page)
VALUES('aeca96c8-d678-4899-a275-0f64368ef85e'::uuid, '86600cfb-7b48-4e81-8e05-8fa29d49d7a6'::uuid, '1168fba1-8391-4294-b1cb-2c108f96af1f'::uuid, 0);
INSERT INTO public.exam_question
(id, exam_id, question_id, page)
VALUES('1887af1a-a0c2-4caa-82e9-f71ae7516752'::uuid, '86600cfb-7b48-4e81-8e05-8fa29d49d7a6'::uuid, '29a71c20-290b-471d-acc8-4c5c929f96a8'::uuid, 0);
INSERT INTO public.exam_question
(id, exam_id, question_id, page)
VALUES('e2176cc8-41b8-435f-8b39-d63ef2bbe495'::uuid, '86600cfb-7b48-4e81-8e05-8fa29d49d7a6'::uuid, '20d06a81-f597-41bc-a60c-480d5c38eb80'::uuid, 0);


INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('f13af228-9d17-45b1-b3e5-7a34f590b145'::uuid, '20d06a81-f597-41bc-a60c-480d5c38eb80'::uuid, '<p><span style="color: rgb(63, 63, 63);">Phân đoạn dãy thành nhiều dãy con và lần lượt trộn hai dãy con thành dãy lớn hơn, cho đến khi thu được dãy ban đầu đã được sắp xếp</span></p>', '<p><span style="color: rgb(63, 63, 63);">Phân đoạn dãy thành nhiều dãy con và lần lượt trộn hai dãy con thành dãy lớn hơn, cho đến khi thu được dãy ban đầu đã được sắp xếp</span></p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('da47f572-a86b-4250-9596-fabf92ffb150'::uuid, '20d06a81-f597-41bc-a60c-480d5c38eb80'::uuid, '<p><span style="color: rgb(63, 63, 63);">Lần lượt lấy phần tử của danh sách chèn vị trí thích hợp của nó trong dãy</span></p>', '<p><span style="color: rgb(63, 63, 63);">Lần lượt lấy phần tử của danh sách chèn vị trí thích hợp của nó trong dãy</span></p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('20ba7b11-9b6a-48d6-96e5-5b49a4127bf7'::uuid, '20d06a81-f597-41bc-a60c-480d5c38eb80'::uuid, '<p><span style="color: rgb(63, 63, 63);">Chọn phần tử bé nhất xếp vào vị trí thứ nhất bằng cách đổi chổ phần tử bé nhất với phần tử thứ nhất; Tương tự đối với phần tử nhỏ thứ hai cho đến phần tử cuối cùng</span></p>', '<p><span style="color: rgb(63, 63, 63);">Chọn phần tử bé nhất xếp vào vị trí thứ nhất bằng cách đổi chổ phần tử bé nhất với phần tử thứ nhất; Tương tự đối với phần tử nhỏ thứ hai cho đến phần tử cuối cùng</span></p>', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('797744cf-8e04-486c-a3ef-778b71ab4303'::uuid, '20d06a81-f597-41bc-a60c-480d5c38eb80'::uuid, '<p><span style="color: rgb(63, 63, 63);">Bắt đầu từ cuối dãy đến đầu dãy, ta lần lượt so sánh hai phần tử kế tiếp nhau, nếu phần tử nào bé hơn được cho lên vị trí trên</span></p>', '<p><span style="color: rgb(63, 63, 63);">Bắt đầu từ cuối dãy đến đầu dãy, ta lần lượt so sánh hai phần tử kế tiếp nhau, nếu phần tử nào bé hơn được cho lên vị trí trên</span></p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('c057f9a7-29f2-4510-bda6-20282e084548'::uuid, '82a72f33-69d1-417a-bc4a-54e4a3f42a06'::uuid, '<p><span style="color: rgb(63, 63, 63);">Phương phap trộn</span></p>', '<p><span style="color: rgb(63, 63, 63);">Phương phap trộn</span></p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('73dce995-e874-4839-a4ed-b024534adb68'::uuid, '82a72f33-69d1-417a-bc4a-54e4a3f42a06'::uuid, '<p><span style="color: rgb(63, 63, 63);">Phương pháp vun đống</span></p>', '<p><span style="color: rgb(63, 63, 63);">Phương pháp vun đống</span></p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('b35e54ea-7b0d-4ed6-a1e5-3a24c1296670'::uuid, '82a72f33-69d1-417a-bc4a-54e4a3f42a06'::uuid, '<p><span style="color: rgb(63, 63, 63);">Phương pháp chèn</span></p>', '<p><span style="color: rgb(63, 63, 63);">Phương pháp chèn</span></p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('1350a0b1-43c6-43c5-a9e1-34bce3e6759e'::uuid, '82a72f33-69d1-417a-bc4a-54e4a3f42a06'::uuid, '<p><span style="color: rgb(63, 63, 63);">Phương pháp phân đoạn</span></p>', '<p><span style="color: rgb(63, 63, 63);">Phương pháp phân đoạn</span></p>', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('d64eda1d-8a47-4d01-9396-2362d55621d5'::uuid, 'fe65d7df-69ac-4a17-805c-f1f2b65b9972'::uuid, '<p><span style="color: rgb(63, 63, 63);">Chọn phần tử bé nhất xếp vào vị trí thứ nhất bằng cách đổi chổ phần tử bé nhất với phần tử thứ nhất; Tương tự đối với phần tử nhỏ thứ hai cho đến phần tử cuối cùng</span></p>', '<p><span style="color: rgb(63, 63, 63);">Chọn phần tử bé nhất xếp vào vị trí thứ nhất bằng cách đổi chổ phần tử bé nhất với phần tử thứ nhất; Tương tự đối với phần tử nhỏ thứ hai cho đến phần tử cuối cùng</span></p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('a0444c51-ede9-4c42-a821-e9e3b6124761'::uuid, 'fe65d7df-69ac-4a17-805c-f1f2b65b9972'::uuid, '<p><span style="color: rgb(63, 63, 63);">Bắt đầu từ cuối dãy đến đầu dãy, ta lần lượt so sánh hai phần tử kế tiếpnh u, nếu phần tử nào nhỏ hơn được đứng vị trí trên</span></p>', '<p><span style="color: rgb(63, 63, 63);">Bắt đầu từ cuối dãy đến đầu dãy, ta lần lượt so sánh hai phần tử kế tiếpnh u, nếu phần tử nào nhỏ hơn được đứng vị trí trên</span></p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('ca665a4c-0f11-4144-9f52-025fd9887870'::uuid, 'fe65d7df-69ac-4a17-805c-f1f2b65b9972'::uuid, '<p><span style="color: rgb(63, 63, 63);">Phân đoạn dãy thành nhiều dãy con và lần lượt trộn hai dãy con thành dãy lớn hơn, cho đến khi thu được dãy ban đầu đã được sắp xếp</span></p>', '<p><span style="color: rgb(63, 63, 63);">Phân đoạn dãy thành nhiều dãy con và lần lượt trộn hai dãy con thành dãy lớn hơn, cho đến khi thu được dãy ban đầu đã được sắp xếp</span></p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('e7a9f1de-b7bb-48d4-a7d9-c41c805c112a'::uuid, 'fe65d7df-69ac-4a17-805c-f1f2b65b9972'::uuid, '<p><span style="color: rgb(63, 63, 63);">Lần lượt chia dãy phần tử thành hai dãy con bởi một phần tử khoá (dãy con trước khoá gồm các phần tử nhỏ hơn khoá và dãy còn lại gồm các phần tử lớn hơn khoá)</span></p>', '<p><span style="color: rgb(63, 63, 63);">Lần lượt chia dãy phần tử thành hai dãy con bởi một phần tử khoá (dãy con trước khoá gồm các phần tử nhỏ hơn khoá và dãy còn lại gồm các phần tử lớn hơn khoá)</span></p>', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('7d39a4d4-a392-4929-9e0f-9317aa079a89'::uuid, '53ce35a7-9dcf-4741-a4ed-872874daf829'::uuid, '<p><span style="color: rgb(63, 63, 63);">Trong giải thuật của nó có lời gọi tới chính nó</span></p>', '<p><span style="color: rgb(63, 63, 63);">Trong giải thuật của nó có lời gọi tới chính nó</span></p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('b8eb7450-9483-4b7f-a42c-a74c13db3842'::uuid, '53ce35a7-9dcf-4741-a4ed-872874daf829'::uuid, '<p><span style="color: rgb(63, 63, 63);">Trong giải thuật của nó có lời gọi tới chính nó nhưng với phạm vi lớn hơn</span></p>', '<p><span style="color: rgb(63, 63, 63);">Trong giải thuật của nó có lời gọi tới chính nó nhưng với phạm vi lớn hơn</span></p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('085c69a6-858c-4c79-aa19-2308f04844ce'::uuid, '53ce35a7-9dcf-4741-a4ed-872874daf829'::uuid, '<p><span style="color: rgb(63, 63, 63);">Trong giải thuật của nó có lời gọi tới chính nó nhưng với phạm vi nhỏ hơn</span></p>', '<p><span style="color: rgb(63, 63, 63);">Trong giải thuật của nó có lời gọi tới chính nó nhưng với phạm vi nhỏ hơn</span></p>', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('8b9b49af-f8da-4df7-b1dc-039dc7d94e2a'::uuid, '53ce35a7-9dcf-4741-a4ed-872874daf829'::uuid, '<p><span style="color: rgb(63, 63, 63);">Trong giải thuật của nó có lời gọi tới một giải thuật khác đã biết kết quả</span></p>', '<p><span style="color: rgb(63, 63, 63);">Trong giải thuật của nó có lời gọi tới một giải thuật khác đã biết kết quả</span></p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('ee0be7d0-c592-4e40-8bba-871b6c9f7272'::uuid, '0fe5d2ee-6892-4f62-a6e6-83284f2430bc'::uuid, '<p>FILO</p>', 'FILO', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('c791aa62-c177-45de-b015-44b0679654d2'::uuid, '513a7e58-00d0-450b-8f0d-78af23898b81'::uuid, 'Correct', 'true', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('80c171ab-25c9-4371-ae3d-f6de0b36c505'::uuid, '1168fba1-8391-4294-b1cb-2c108f96af1f'::uuid, 'Correct', 'true', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('b06ddec2-cbe0-4488-8cde-228c55e43a26'::uuid, 'c4b3219f-9d83-4497-ad15-d46772141bd5'::uuid, '<p>FIFO</p>', 'FIFO', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('022472ef-31ab-4876-8509-8f1108ae9dbb'::uuid, '29a71c20-290b-471d-acc8-4c5c929f96a8'::uuid, 'Correct', 'true', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('c85f2ef4-5cb6-4e4a-a8d0-01947ae1007e'::uuid, '1ca8c89a-1bd0-41b2-adf0-4f7b55f8b256'::uuid, 'Correct', 'true', 1.00);

INSERT INTO public.rubric_user(id, name, description, content, user_id)
VALUES
    ('31fed2d0-c774-4b5d-a131-070fd0979ae4', 'Rubric 1', 'Rubric 1 description','[{"criteriaName":"Content","criteriaDescription":"","scale":[{"score":1,"description":"The essay is incomplete, inaccurate, illogical, and uses sources inappropriately"},{"score":2,"description":"The essay is complete, accurate, but lacks logic, and uses sources somewhat appropriately"},{"score":3,"description":"The essay is complete, accurate, and logical, and uses sources appropriately"},{"score":4,"description":"The essay is complete, accurate, logical, creative, and uses sources appropriately"}]},{"criteriaName":"Form","criteriaDescription":"","scale":[{"score":1,"description":"The essay has many errors in grammar, spelling, or punctuation, uses limited vocabulary, and has an unclear layout."},{"score":2,"description":"The essay has several errors in grammar, spelling, or punctuation, uses somewhat varied and rich vocabulary, and has a somewhat clear layout."},{"score":3,"description":"The essay has few errors in grammar, spelling, or punctuation, uses varied, rich, and appropriate vocabulary, and has a relatively clear layout."},{"score":4,"description":"The essay has no errors in grammar, spelling, or punctuation, and uses varied, rich, and appropriate vocabulary with a clear layout"}]},{"criteriaName":"Style","criteriaDescription":"","scale":[{"score":1,"description":"The essay is unclear, not engaging, and not appropriate for the topic, purpose, and audience."},{"score":2,"description":"The essay is unclear, lacks engagement, and is somewhat appropriate for the topic, purpose, and audience."},{"score":3,"description":"The essay is relatively clear, engaging, and appropriate for the topic, purpose, and audience."},{"score":4,"description":"The essay is clear, engaging, and appropriate for the topic, purpose, and audience."}]}]', '64412e27-169e-44ea-a101-74ebf8cb82d9'),
    ('e15e0a60-6893-48f9-9fbd-0bdb671e1c84', 'Rubric 2', 'Rubric 2 description','[{"criteriaName":"Ideas and content","scale":[{"score":1,"description":"The opinion and support for it is buried, confused and/or undear."},{"score":2,"description":"An opinion is given. The reasons given tend to be weak or inaccurate. May get off topic."},{"score":3,"description":"An opinion is given. One reason may be unclear or lack detail."},{"score":4,"description":"The paper clearly states an opinion and gives 3 clear, detailed reasons in support of it"}]},{"criteriaName":"Organization","scale":[{"score":1,"description":"There is no real beginning or ending. The ideas seem loosely strung together. No paragraph formatting"},{"score":2,"description":"The paper has an attempt at a beginning &/or ending. Some ideas may seem out of order. Some problems with paragraphs."},{"score":3,"description":"The paper has a beginning, middle and end. The order makes sense. Paragraphs are indented; some have topic and closing sentences"},{"score":4,"description":"The paper has a beginning with an interesting lead, a middle, and an ending. It is in an order that makes sense. Paragraphs are indented and have topic and closing sentences and main ideas."}]},{"criteriaName":"Voice & tone","scale":[{"score":1,"description":"The writing is bland and sounds like the writer doesn`t like the topic. No thoughts or feelings."},{"score":2,"description":"The paper could have been written by anyone. It shows very little about what the writer thought and felt."},{"score":3,"description":"The writing seems sincere but not enthusiastic. The writer`s voice fades in and out."},{"score":4,"description":"The writing shows what the writer thinks and feels. It sounds like the writer cares about the topic."}]},{"criteriaName":"Word choice","scale":[{"score":1,"description":"The same words are used over and over. Some words are used incorrectly.\n"},{"score":2,"description":"The words areordinary but generally correct.\n"},{"score":3,"description":"The words are mostly ordinary, with a few attempts at descriptive words."},{"score":4,"description":"Descriptive words are used (`helpful`) instead of `good` or `destructive` instead of `bad`."}]},{"criteriaName":"Sentence fluency","scale":[{"score":1,"description":"The essay is hard to read because of incomplete and run-on sentences.\n"},{"score":2,"description":"There are many incomplete sentences and run-ons.\n"},{"score":3,"description":"The sentences are usually correct."},{"score":4,"description":"The sentences are complete, clear, and begin in different ways."}]},{"criteriaName":"Conventions","scale":[{"score":1,"description":"The writing is almost impossible to read because of errors."},{"score":2,"description":"There are enough errors to make the writing hard to read and understand."},{"score":3,"description":"Spelling, punctuation and caps are usually correct_ Some problems with grammar."},{"score":4,"description":"Spelling, punctuation, capitalization, and grammar are correct. Only minor edits are needed."}]}]', '64412e27-169e-44ea-a101-74ebf8cb82d9');
