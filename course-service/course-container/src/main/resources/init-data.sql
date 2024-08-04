-- Records of organization
-- ----------------------------
INSERT INTO "public"."organization" VALUES ('cb69c0bf-c454-4f15-be10-791f6749dac7', 'Moodle description', 'Moodle 2', '9db5726ffba9f26d155880d77b414cf0', 'http://20.2.248.138/webservice/rest/server.php', '2024-04-15 18:09:29.488151+07', '2024-04-15 18:09:29.488151+07', 'f');
INSERT INTO "public"."organization" VALUES ('08b65a39-394f-4977-a5fa-3fe145b620f8', 'moodle', 'Moodle', 'cdf90b5bf53bcae577c60419702dbee7', 'http://62.171.185.208:8081/webservice/rest/server.php', '2024-04-15 18:09:29.488+07', '2024-04-15 18:09:29.488+07', 'f');

-- Records of role_moodle
-- ----------------------------
INSERT INTO "public"."role_moodle" VALUES (1, 'Quản lý');
INSERT INTO "public"."role_moodle" VALUES (2, 'Người tạo khóa học');
INSERT INTO "public"."role_moodle" VALUES (3, 'Giảng viên 1');
INSERT INTO "public"."role_moodle" VALUES (4, 'Giảng viên');
INSERT INTO "public"."role_moodle" VALUES (5, 'Học sinh');
INSERT INTO "public"."role_moodle" VALUES (6, 'Guest');

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO "public"."user" VALUES ('b029f559-52a8-4699-b595-71161498ed8c', 0, NULL, NULL, NULL, 'dcthong852@gmail.com', '2002-04-29', 'Thong', 'Duong', '+8412365478', NULL, NULL, '2024-06-04 19:54:04.349854+07', 'f', '2024-04-15 18:07:20.891115+07', '2024-04-15 18:07:20.891115+07');
INSERT INTO "public"."user" VALUES ('8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', 0, NULL, NULL, NULL, 'nthoang852@gmail.com', '2002-03-29', 'Hoang', 'Nguyen Thanh', '+8412365478', NULL, NULL, '2024-06-04 19:54:04.349854+07', 'f', '2024-04-15 18:07:41.151759+07', '2024-04-15 18:07:41.151759+07');
INSERT INTO "public"."user" VALUES ('39328bcf-8af6-44fc-9ae9-247f953ee2a2', 0, NULL, NULL, NULL, 'ndqkhanh852@gmail.com', '2002-03-29', 'Khanh', 'Nguyen Dinh', '+8412365478', NULL, NULL, '2024-06-04 19:54:04.349854+07', 'f', '2024-04-15 18:07:41.151759+07', '2024-04-15 18:07:41.151759+07');
INSERT INTO "public"."user" VALUES ('8edbc0aa-0b91-480e-a428-23abf2109df9', 0, NULL, NULL, NULL, 'tgtien852@gmail.com', '2002-03-29', 'Tien', 'Truong Gia', '+8412365478', NULL, NULL, '2024-06-04 19:54:04.349854+07', 'f', '2024-04-15 18:07:41.151759+07', '2024-04-15 18:07:41.151759+07');
INSERT INTO "public"."user" VALUES ('05dbdfde-1eae-47ba-8ebb-6c4cdc4f6510', 0, NULL, NULL, NULL, 'dntien852@gmail.com', '2002-03-29', 'Tien', 'Dang Ngoc', '+8412365478', NULL, NULL, '2024-06-04 19:54:04.349854+07', 'f', '2024-04-15 18:07:41.151759+07', '2024-04-15 18:07:41.151759+07');
INSERT INTO "public"."user" VALUES ('c6bd2565-a6bd-4f98-af43-d974a6302f36', 1, '08b65a39-394f-4977-a5fa-3fe145b620f8', 1, 'guest', 'root@localhost', NULL, 'Guest user', ' ', NULL, NULL, NULL, '2024-06-04 19:54:23.474857+07', 'f', '2024-06-04 19:54:23.474857+07', '2024-06-04 19:54:23.474857+07');
INSERT INTO "public"."user" VALUES ('64412e27-169e-44ea-a101-74ebf8cb82d9', 2, '08b65a39-394f-4977-a5fa-3fe145b620f8', 3, 'admin', 'kayonkiu@gmail.com', NULL, 'Tien', 'Ngoc', NULL, NULL, NULL, '2024-06-04 19:54:23.636865+07', 'f', '2024-06-04 19:54:23.636865+07', '2024-06-04 19:54:23.637867+07');
INSERT INTO "public"."user" VALUES ('cb2c22ac-87de-44e4-9638-35979f6af667', 3, '08b65a39-394f-4977-a5fa-3fe145b620f8', 5, 'chithong2002', 'duongchithong2002@gmail.com', NULL, 'Thông', 'Dương Chí', NULL, NULL, NULL, '2024-06-04 19:54:23.664571+07', 'f', '2024-06-04 19:54:23.664571+07', '2024-06-04 19:54:23.664571+07');
INSERT INTO "public"."user" VALUES ('2d7ed5a0-fb21-4927-9a25-647c17d29668', 4, '08b65a39-394f-4977-a5fa-3fe145b620f8', 5, 'tien', 'dntienes@gmail.com', NULL, 'Tiến', 'Đặng Ngọc', '0993331110', NULL, NULL, '2024-06-04 19:54:23.690581+07', 'f', '2024-06-04 19:54:23.690581+07', '2024-06-04 19:54:23.690581+07');
INSERT INTO "public"."user" VALUES ('2d3c1e66-1835-457f-93e9-265fe483feee', 5, '08b65a39-394f-4977-a5fa-3fe145b620f8', 5, 'ngocthu', 'dt.ngocthw@gmail.com', NULL, 'Thư', 'Ngọc', NULL, NULL, NULL, '2024-06-04 19:54:23.712124+07', 'f', '2024-06-04 19:54:23.712124+07', '2024-06-04 19:54:23.712124+07');
INSERT INTO "public"."user" VALUES ('9ba179ed-d26d-4828-a0f6-8836c2063992', 7, '08b65a39-394f-4977-a5fa-3fe145b620f8', 5, 'quoctuan2002', 'nguyenquoctuan385@gmail.com', NULL, 'Tuấn', 'Nguyễn Quốc', NULL, NULL, NULL, '2024-06-04 19:54:23.75895+07', 'f', '2024-06-04 19:54:23.759506+07', '2024-06-04 19:54:23.759506+07');
INSERT INTO "public"."user" VALUES ('ca3040f2-e173-40a5-aab7-6ef15965ce43', 8, '08b65a39-394f-4977-a5fa-3fe145b620f8', 5, 'tgt2002', 'truonggiatien123@gmail.com', NULL, 'Tiến', 'Trương Gia', NULL, NULL, NULL, '2024-06-04 19:54:23.789236+07', 'f', '2024-06-04 19:54:23.789748+07', '2024-06-04 19:54:23.789748+07');
INSERT INTO "public"."user" VALUES ('1e327a63-b0d6-476f-bb99-8c594560f971', NULL, 'cb69c0bf-c454-4f15-be10-791f6749dac7', NULL, 'truonggiatien456@gmail.com', 'truonggiatien456@gmail.com', NULL, 'Tiến', 'Trương Gia', NULL, NULL, NULL, '2024-06-04 19:54:23.789236+07', 'f', '2024-06-04 19:54:23.789748+07', '2024-06-04 19:54:23.789748+07');
INSERT INTO "public"."user" VALUES ('a9f5487e-c0b1-4fa4-b93a-6f16bde90583', 6, '08b65a39-394f-4977-a5fa-3fe145b620f8', 3, 'giaovien', 'ktpm4t@gmail.com', NULL, 'giáo', 'vien', '+8412365478', NULL, 'http://62.171.185.208:8081/theme/image.php?theme=classic&component=core&image=u%2Ff1', '2024-06-04 19:54:23.73386+07', 'f', '2024-06-04 19:54:23.73386+07', '2024-08-04 14:16:29.763+07');
INSERT INTO "public"."user" VALUES ('8cbf0aa4-f707-4cd3-8258-0c72f8fb4db0', 10, '08b65a39-394f-4977-a5fa-3fe145b620f8', 5, 'pamela', 'haiduong@gmail.com', NULL, 'Pam', 'Hải Đường', NULL, NULL, NULL, NULL, 'f', '2024-08-04 14:16:29.978+07', '2024-08-04 14:16:29.978+07');
INSERT INTO "public"."user" VALUES ('a4cd3cac-3b49-4b36-93e7-13fbb14ce76f', 9, '08b65a39-394f-4977-a5fa-3fe145b620f8', 5, 'kaitokid2002', 'kaitokid23454@gmail.com', NULL, 'Mai', 'Tô Kiệt', NULL, NULL, NULL, NULL, 'f', '2024-08-04 14:16:29.729+07', '2024-08-04 14:16:29.729+07');
INSERT INTO "public"."user" VALUES ('ad3c4eb3-8ddb-45a0-9df2-d6ec5d14fbbc', 11, '08b65a39-394f-4977-a5fa-3fe145b620f8', 5, 'hailong', 'hailong@gmail.com', NULL, 'Hải', 'Long', NULL, NULL, NULL, NULL, 'f', '2024-08-04 14:16:29.729+07', '2024-08-04 14:16:29.729+07');
INSERT INTO "public"."user" VALUES ('444bbc7d-86f8-4258-9429-e73ce69a9e41', 12, '08b65a39-394f-4977-a5fa-3fe145b620f8', 3, 'kimngan', 'kimngan@gmail.com', NULL, 'Hoàng', 'Kim Ngân', NULL, NULL, NULL, NULL, 'f', '2024-08-04 14:16:34.991+07', '2024-08-04 14:16:34.991+07');
INSERT INTO "public"."user" VALUES ('853b8f16-20c9-42e9-a04d-daa0237823ca', 19, '08b65a39-394f-4977-a5fa-3fe145b620f8', 5, '20127574', '20127574@student.hcmus.edu.vn', NULL, 'Hoàng Phước Gia', 'Nguyên', NULL, NULL, NULL, NULL, 'f', '2024-08-04 14:16:35.049+07', '2024-08-04 14:16:35.049+07');
INSERT INTO "public"."user" VALUES ('87031f89-d9b0-449f-84f4-c9b6dff15a9a', 15, '08b65a39-394f-4977-a5fa-3fe145b620f8', 3, 'builequanghuy', 'Huydtw@gmail.com', NULL, 'Bùi Lê Quang', 'Huy', NULL, NULL, NULL, NULL, 'f', '2024-08-04 14:16:34.881+07', '2024-08-04 14:16:34.881+07');
INSERT INTO "public"."user" VALUES ('994ebe5b-db43-4cd3-a1ee-693c2ef681ef', 14, '08b65a39-394f-4977-a5fa-3fe145b620f8', 5, '20127329', '20127329@student.hcmus.edu.vn', NULL, 'Bùi', 'Quang Thành', NULL, NULL, NULL, NULL, 'f', '2024-08-04 14:16:38.488+07', '2024-08-04 14:16:38.488+07');
INSERT INTO "public"."user" VALUES ('baddeb10-3f99-4843-859c-50cc51659153', 25, '08b65a39-394f-4977-a5fa-3fe145b620f8', 5, '20127281', '20127281@student.hcmus.edu.vn', NULL, 'Lê Đình', 'Phúc', NULL, NULL, NULL, NULL, 'f', '2024-08-04 14:16:37.058+07', '2024-08-04 14:16:37.058+07');
INSERT INTO "public"."user" VALUES ('fcf62145-e196-4777-a201-77f6693810c4', 16, '08b65a39-394f-4977-a5fa-3fe145b620f8', 5, '20127597', '20127597@student.hcmus.edu.vn', NULL, 'Bùi Tấn', 'Phương', NULL, NULL, NULL, NULL, 'f', '2024-08-04 14:16:36.885+07', '2024-08-04 14:16:36.885+07');
INSERT INTO "public"."user" VALUES ('c2f39b5b-6aeb-4b82-8541-d25920314339', 13, '08b65a39-394f-4977-a5fa-3fe145b620f8', 5, '20127447', '20127447@student.hcmus.edu.vn', NULL, 'Ngô', 'Đức Bảo', NULL, NULL, NULL, NULL, 'f', '2024-08-04 14:16:36.935+07', '2024-08-04 14:16:36.935+07');
INSERT INTO "public"."user" VALUES ('4526d150-cfcf-4b04-ab54-12789b788829', 18, '08b65a39-394f-4977-a5fa-3fe145b620f8', 3, 'nglhdung', 'nlhdung@fit.hcmus.edu.vn', NULL, 'Nguyễn Lê Hoàng', 'Dũng', NULL, NULL, NULL, NULL, 'f', '2024-08-04 14:16:40.095+07', '2024-08-04 14:16:40.095+07');
INSERT INTO "public"."user" VALUES ('b887e221-2edd-4a37-9b65-209c92b8997d', 29, '08b65a39-394f-4977-a5fa-3fe145b620f8', 5, '20127116', '20127116@student.hcmus.edu.vn', NULL, 'Nguyễn Gia', 'Bảo', NULL, NULL, NULL, NULL, 'f', '2024-08-04 14:16:40.058+07', '2024-08-04 14:16:40.058+07');
INSERT INTO "public"."user" VALUES ('87076e41-40fd-4832-bbbc-1e5211878264', 17, '08b65a39-394f-4977-a5fa-3fe145b620f8', 5, '20127161', '20127161@student.hcmus.edu.vn', NULL, 'Bùi Thị Thanh', 'Hoa', NULL, NULL, NULL, NULL, 'f', '2024-08-04 14:16:38.653+07', '2024-08-04 14:16:38.653+07');
INSERT INTO "public"."user" VALUES ('2df936cc-f04a-4269-85ca-5dcf8099e184', 27, '08b65a39-394f-4977-a5fa-3fe145b620f8', 3, 'ltphat', 'ltphat20@clc.fitus.edu.vn', NULL, 'Lưu Tấn', 'Phát', NULL, NULL, NULL, NULL, 'f', '2024-08-04 14:16:38.665+07', '2024-08-04 14:16:38.665+07');
INSERT INTO "public"."user" VALUES ('2d5137ae-9d77-4a12-94ea-fda383a8db10', 21, '08b65a39-394f-4977-a5fa-3fe145b620f8', 5, '20127291', '20127291@student.hcmus.edu.vn', NULL, 'Lâm Quang Anh', 'Quân', NULL, NULL, NULL, NULL, 'f', '2024-08-04 14:16:39.187+07', '2024-08-04 14:16:39.187+07');
INSERT INTO "public"."user" VALUES ('2c4e42ab-be60-439f-95dc-28ccd7c75411', 20, '08b65a39-394f-4977-a5fa-3fe145b620f8', 5, '20127666', '20127666@student.hcmus.edu.vn', NULL, 'Huỳnh Tấn', 'Vinh', NULL, NULL, NULL, NULL, 'f', '2024-08-04 14:16:41.119+07', '2024-08-04 14:16:41.119+07');
INSERT INTO "public"."user" VALUES ('205b0afa-3efa-4bdf-9bc0-3f6449ff5c1a', 22, '08b65a39-394f-4977-a5fa-3fe145b620f8', 5, '20127358', '20127358@student.hcmus.edu.vn', NULL, 'Lê Châu', 'Toàn', NULL, NULL, NULL, NULL, 'f', '2024-08-04 14:16:42.293+07', '2024-08-04 14:16:42.293+07');
INSERT INTO "public"."user" VALUES ('9e9e9485-bbad-4aa4-9e2d-f8362dbbbba1', 23, '08b65a39-394f-4977-a5fa-3fe145b620f8', 5, '20127275', '20127275@student.hcmus.edu.vn', NULL, 'Lê Nhất', 'Duy', NULL, NULL, NULL, NULL, 'f', '2024-08-04 14:16:40.745+07', '2024-08-04 14:16:40.745+07');
INSERT INTO "public"."user" VALUES ('4a182d8b-a553-455c-8485-f834da6de4e9', 28, '08b65a39-394f-4977-a5fa-3fe145b620f8', 5, '20127252', '20127252@student.hcmus.edu.vn', NULL, 'Ngô Gia', 'Ngân', NULL, NULL, NULL, NULL, 'f', '2024-08-04 14:16:41.97+07', '2024-08-04 14:16:41.97+07');
INSERT INTO "public"."user" VALUES ('ee83822a-75aa-4b08-8772-c2cd40443532', 36, '08b65a39-394f-4977-a5fa-3fe145b620f8', 5, '20127043', '20127043@student.hcmus.edu.vn', NULL, 'Nguyễn Thoại Đăng', 'Khoa', NULL, NULL, NULL, NULL, 'f', '2024-08-04 14:16:41.091+07', '2024-08-04 14:16:41.091+07');
INSERT INTO "public"."user" VALUES ('097ad133-9434-44d0-ad2f-16db49f0be9c', 37, '08b65a39-394f-4977-a5fa-3fe145b620f8', 5, '20127064', '20127064@student.hcmus.edu.vn', NULL, 'Nguyễn Trần Mai', 'Phương', NULL, NULL, NULL, NULL, 'f', '2024-08-04 14:16:42.351+07', '2024-08-04 14:16:42.351+07');
INSERT INTO "public"."user" VALUES ('db95956f-786e-46c7-87c1-ad5ebaacf355', 24, '08b65a39-394f-4977-a5fa-3fe145b620f8', 5, '20127090', '20127090@student.hcmus.edu.vn', NULL, 'Lê Thanh', 'Tú', NULL, NULL, NULL, NULL, 'f', '2024-08-04 14:16:43.178+07', '2024-08-04 14:16:43.178+07');
INSERT INTO "public"."user" VALUES ('0bea60a7-9789-42bb-a217-22d142cf3b1b', 33, '08b65a39-394f-4977-a5fa-3fe145b620f8', 5, '20127334', '20127334@student.hcmus.edu.vn', NULL, 'Nguyễn Phát', 'Thịnh', NULL, NULL, NULL, NULL, 'f', '2024-08-04 14:16:42.906+07', '2024-08-04 14:16:42.906+07');
INSERT INTO "public"."user" VALUES ('fff06898-5361-4464-9e75-8b1435e46d15', 43, '08b65a39-394f-4977-a5fa-3fe145b620f8', 5, '20127318', '20127318@student.hcmus.edu.vn', NULL, 'Phan Trí', 'Tài', NULL, NULL, NULL, NULL, 'f', '2024-08-04 14:16:43.267+07', '2024-08-04 14:16:43.267+07');
INSERT INTO "public"."user" VALUES ('ffed4ce4-53b7-497e-a449-e3dee93aec1d', 34, '08b65a39-394f-4977-a5fa-3fe145b620f8', 5, '20127069', '20127069@student.hcmus.edu.vn', NULL, 'Nguyễn Sanh', 'Tài', NULL, NULL, NULL, NULL, 'f', '2024-08-04 14:16:44.564+07', '2024-08-04 14:16:44.564+07');
INSERT INTO "public"."user" VALUES ('182709ef-635b-40a4-9ccd-774dd39b380f', 26, '08b65a39-394f-4977-a5fa-3fe145b620f8', 5, '20120052', '20120052@student.hcmus.edu.vn', NULL, 'Lê Đức', 'Đạt', NULL, NULL, NULL, NULL, 'f', '2024-08-04 14:16:45.244+07', '2024-08-04 14:16:45.244+07');
INSERT INTO "public"."user" VALUES ('e45e5e33-d62e-47cb-9d54-cee790fc6b5f', 45, '08b65a39-394f-4977-a5fa-3fe145b620f8', 5, '20127323', '20127323@student.hcmus.edu.vn', NULL, 'Võ Nhật', 'Tân', NULL, NULL, NULL, NULL, 'f', '2024-08-04 14:16:45.647+07', '2024-08-04 14:16:45.647+07');
INSERT INTO "public"."user" VALUES ('58b79c83-ba88-430b-a9c9-d549d43b3600', 30, '08b65a39-394f-4977-a5fa-3fe145b620f8', 5, '20127633', '20127633@student.hcmus.edu.vn', NULL, 'Nguyễn Hoàng', 'Thịnh', NULL, NULL, NULL, NULL, 'f', '2024-08-04 14:16:49.317+07', '2024-08-04 14:16:49.317+07');
INSERT INTO "public"."user" VALUES ('06ccbc31-e870-41c9-9293-b54aef58de21', 35, '08b65a39-394f-4977-a5fa-3fe145b620f8', 5, '20127573', '20127573@student.hcmus.edu.vn', NULL, 'Nguyễn Thị Hồng', 'Ngọc', NULL, NULL, NULL, NULL, 'f', '2024-08-04 14:16:47.06+07', '2024-08-04 14:16:47.06+07');
INSERT INTO "public"."user" VALUES ('a1845f87-cece-4cb0-91c7-7bd68f439063', 41, '08b65a39-394f-4977-a5fa-3fe145b620f8', 5, '20127143', '20127143@student.hcmus.edu.vn', NULL, 'Phạm Giang Thái', 'Dương', NULL, NULL, NULL, NULL, 'f', '2024-08-04 14:16:49.876+07', '2024-08-04 14:16:49.876+07');
INSERT INTO "public"."user" VALUES ('62973440-0374-4c2c-a49b-b771b7640912', 50, '08b65a39-394f-4977-a5fa-3fe145b620f8', 3, 'tmhieu', 'tmhieu2024@gmail.com', NULL, 'Hiếu', 'Trần Minh', NULL, NULL, NULL, NULL, 'f', '2024-08-04 14:16:49.06+07', '2024-08-04 14:16:49.06+07');
INSERT INTO "public"."user" VALUES ('d7c3523c-d595-44f0-ad72-ddf8ae299cbb', 32, '08b65a39-394f-4977-a5fa-3fe145b620f8', 5, '20127456', '20127456@student.hcmus.edu.vn', NULL, 'Nguyễn Mạnh', 'Cường', NULL, NULL, NULL, NULL, 'f', '2024-08-04 14:16:51.877+07', '2024-08-04 14:16:51.877+07');
INSERT INTO "public"."user" VALUES ('c2efd8b2-7ab2-45b8-b7c9-425ac7d36b56', 31, '08b65a39-394f-4977-a5fa-3fe145b620f8', 5, '20127644', '20127644@student.hcmus.edu.vn', NULL, 'Nguyễn Khắc', 'Tiệp', NULL, NULL, NULL, NULL, 'f', '2024-08-04 14:16:50.691+07', '2024-08-04 14:16:50.691+07');
INSERT INTO "public"."user" VALUES ('6c44fd5e-560d-4b8a-9d61-03c3e66872ef', 42, '08b65a39-394f-4977-a5fa-3fe145b620f8', 5, '20127607', '20127607@student.hcmus.edu.vn', NULL, 'Phạm Việt', 'Quang', NULL, NULL, NULL, NULL, 'f', '2024-08-04 14:16:51.109+07', '2024-08-04 14:16:51.109+07');
INSERT INTO "public"."user" VALUES ('d2befc26-a318-4ae1-a1c6-c71dd7e7d79d', 38, '08b65a39-394f-4977-a5fa-3fe145b620f8', 5, '20127277', '20127277@student.hcmus.edu.vn', NULL, 'Nguyễn Triệu', 'Phú', NULL, NULL, NULL, NULL, 'f', '2024-08-04 14:16:53.252+07', '2024-08-04 14:16:53.252+07');
INSERT INTO "public"."user" VALUES ('730f379c-986b-4274-8b88-3e90e5bbba25', 46, '08b65a39-394f-4977-a5fa-3fe145b620f8', 5, '20127556', '20127556@student.hcmus.edu.vn', NULL, 'Tăng Kim', 'Long', NULL, NULL, NULL, NULL, 'f', '2024-08-04 14:16:52.555+07', '2024-08-04 14:16:52.555+07');
INSERT INTO "public"."user" VALUES ('75dd8ca8-14aa-4dbb-aac0-c16bcb1ef61f', 48, '08b65a39-394f-4977-a5fa-3fe145b620f8', 5, 'nnpbao', '20127600@student.hcmus.edu.vn', NULL, 'Bảo', 'Nguyễn Ngọc Phi', NULL, NULL, NULL, NULL, 'f', '2024-08-04 14:16:53.748+07', '2024-08-04 14:16:53.748+07');
INSERT INTO "public"."user" VALUES ('dd81de86-7f96-482a-b967-2e8e4cd9d910', 39, '08b65a39-394f-4977-a5fa-3fe145b620f8', 5, '20127595', '20127595@student.hcmus.edu.vn', NULL, 'Nguyễn Trọng', 'Phúc', NULL, NULL, NULL, NULL, 'f', '2024-08-04 14:16:54.576+07', '2024-08-04 14:16:54.576+07');
INSERT INTO "public"."user" VALUES ('2c5ab7ea-f37f-4917-bec2-202b20d25ff0', 49, '08b65a39-394f-4977-a5fa-3fe145b620f8', 3, 'sontungmtp', 'nttung2024@gmail.com', NULL, 'Tùng', 'Nguyễn Thanh', NULL, NULL, NULL, NULL, 'f', '2024-08-04 14:16:54.911+07', '2024-08-04 14:16:54.911+07');
INSERT INTO "public"."user" VALUES ('bfca2841-ee2c-4981-9c74-3ef605fc1c3d', 40, '08b65a39-394f-4977-a5fa-3fe145b620f8', 5, '20127562', '20127562@student.hcmus.edu.vn', NULL, 'Nguyễn Đăng', 'Minh', NULL, NULL, NULL, NULL, 'f', '2024-08-04 14:16:55.984+07', '2024-08-04 14:16:55.984+07');
INSERT INTO "public"."user" VALUES ('7179898a-c353-4917-8dbd-62e10ea3249e', 51, '08b65a39-394f-4977-a5fa-3fe145b620f8', 3, 'tmhung', 'tmhung2024@gmail.com', NULL, 'Hùng', 'Trần Mạnh', NULL, NULL, NULL, NULL, 'f', '2024-08-04 14:16:57.431+07', '2024-08-04 14:16:57.431+07');
INSERT INTO "public"."user" VALUES ('588636d6-7193-4a2b-be5f-cafe112d3bf5', 47, '08b65a39-394f-4977-a5fa-3fe145b620f8', 5, '20127569', '20127569@student.hcmus.edu.vn', NULL, 'Tô Đình Phương', 'Nam', NULL, NULL, NULL, NULL, 'f', '2024-08-04 14:16:56.841+07', '2024-08-04 14:16:56.841+07');
INSERT INTO "public"."user" VALUES ('e1ac8c3c-1c60-4c14-8143-84c3c8c66934', 44, '08b65a39-394f-4977-a5fa-3fe145b620f8', 5, '20127681', '20127681@student.hcmus.edu.vn', NULL, 'Nguyễn Thiên', 'Phúc', NULL, NULL, NULL, NULL, 'f', '2024-08-04 14:16:56.425+07', '2024-08-04 14:16:56.425+07');

INSERT INTO "public"."question_bank_category" VALUES ('a54cf2f7-294c-4b1a-a8c7-6e8c34fb5f51', 'Lập trình C/C++', '<p>Câu hỏi lập trình C/C++</p>', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'f', '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-07-13 21:16:01.246+07', '2024-07-13 21:16:01.246+07');
INSERT INTO "public"."question_bank_category" VALUES ('a69c5276-4f35-469d-94b1-b2df3f3f2707', 'Lập trình hướng đối tượng', '<p>Câu hỏi lập trình hướng đối tượng</p>', '08b65a39-394f-4977-a5fa-3fe145b620f8', 't', '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-07-13 21:16:41.894+07', '2024-07-13 21:16:41.894+07');
INSERT INTO "public"."question_bank_category" VALUES ('b8d5995f-0cf9-4ad4-967c-f94f2187deb9', 'Lập trình Java', '<p>Câu hỏi lập trình java </p>', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'f', '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-07-13 21:17:35.585+07', '2024-07-13 21:17:35.585+07');
INSERT INTO "public"."question_bank_category" VALUES ('d8fed7b0-bd98-436e-9c4d-36b8fe9f372e', 'Cấu trúc dữ liệu và giải thuật', '<p>Câu hỏi cấu trúc dữ liệu và giải thuật</p>', '08b65a39-394f-4977-a5fa-3fe145b620f8', 't', '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-07-13 21:13:14.701+07', '2024-07-13 21:13:14.701+07');
INSERT INTO "public"."question_bank_category" VALUES ('94f340b3-fb05-4e3a-8cb5-44ef5d936a9b', 'Mạng máy tính', '<p>Câu hỏi Mạng máy tính</p>', '08b65a39-394f-4977-a5fa-3fe145b620f8', 't', '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-07-13 21:14:17.528+07', '2024-07-13 21:14:17.528+07');

INSERT INTO "public"."question" VALUES ('b6484e21-6937-489c-b031-b71767994233', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Khái niệm và ứng dụng của con trỏ', 'Hãy giải thích khái niệm con trỏ trong ngôn ngữ lập trình C/C++. Tại sao con trỏ lại quan trọng trong lập trình?', 'Question Gold feedback', 1, '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', '2024-08-04 14:14:27.681623+07', '2024-08-04 14:14:27.681623+07', NULL, 'f', 'ESSAY', 'EASY');
INSERT INTO "public"."question" VALUES ('b6484e21-6937-489c-b031-b71767994132', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Question hihi', 'Question Wow Text', 'Question Amazing feedback', 1, '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', '2024-08-04 14:14:27.681623+07', '2024-08-04 14:14:27.681623+07', NULL, 'f', 'SHORT_ANSWER', 'MEDIUM');
INSERT INTO "public"."question" VALUES ('b6484e21-6937-489c-b031-b71767994735', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Question haha', 'Question Speaker Text', 'Good Job', 1, '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', '2024-08-04 14:14:27.681623+07', '2024-08-04 14:14:27.681623+07', NULL, 'f', 'MULTIPLE_CHOICE', 'HARD');
INSERT INTO "public"."question" VALUES ('b6484e21-6937-489c-b031-b71767994752', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'K Divisible Elements Subarrays', 'Question Wow Text', 'Question Amazing feedback', 1, '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', '2024-08-04 14:14:27.681623+07', '2024-08-04 14:14:27.681623+07', NULL, 'f', 'SHORT_ANSWER', 'MEDIUM');
INSERT INTO "public"."question" VALUES ('b6484e21-6937-489c-b031-b71767994753', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Total Appeal of A String', 'Question Speaker Text', 'Good Job', 1, '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', '2024-08-04 14:14:27.681623+07', '2024-08-04 14:14:27.681623+07', NULL, 'f', 'MULTIPLE_CHOICE', 'HARD');
INSERT INTO "public"."question" VALUES ('b6484e21-6937-489c-b031-b71767994751', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Minimum Consecutive Cards to Pick Up', 'Question Wire Text', 'Question Gold feedback', 1, '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', '2024-08-04 14:14:27.681623+07', '2024-08-04 14:14:27.681623+07', NULL, 'f', 'ESSAY', 'EASY');
INSERT INTO "public"."question" VALUES ('b6484e21-6937-489c-b031-b71767994221', null, 'Sum of two integer', '<div class="elfjS" data-track-load="description_content"><p>Given two integer number A and B.</p><p>Calculate the sum of A and B.</p><p>&nbsp;</p><p><strong class="example">Example 1:</strong></p><pre>
Input:
1
1
Output: 2
</pre><p><strong class="example">Example 2:</strong></p><pre>
Input:
13
10
Output: 23 
</pre><p>&nbsp;</p></div>', 'Good Job', 10, 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-08-04 14:14:27.681623+07', '2024-08-04 14:14:27.681623+07', NULL, 'f', 'CODE', 'EASY');
INSERT INTO "public"."question" VALUES ('b6484e21-6937-489c-b031-b71767994736', null, 'Sum of an array', '<p>Write a function that takes an array of numbers as input and returns the sum of all the elements in the array.</p><blockquote>Example:</blockquote><pre class="ql-syntax" spellcheck="false"> Input:
 3
 1 2 3
 Output: 6    
</pre><p><br></p>', 'Good Job', 10, 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-08-04 14:14:27.681623+07', '2024-08-04 14:14:27.681623+07', NULL, 'f', 'CODE', 'EASY');
INSERT INTO "public"."question" VALUES ('b6484e21-6937-489c-b031-b71767994737', null, 'FizzBuzz', '<p>Write a program that prints the numbers from 1 to n. But for multiples of three, print "Fizz" instead of the number, and for the multiples of five, print "Buzz". For numbers that are multiples of both three and five, print "FizzBuzz".</p><p>Example:</p><pre class="ql-syntax" spellcheck="false">Input: 15
Output:
1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz
</pre>', 'Good Job', 10, 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-08-04 14:14:27.681623+07', '2024-08-04 14:14:27.681623+07', NULL, 'f', 'CODE', 'EASY');
INSERT INTO "public"."question" VALUES ('b6484e21-6937-489c-b031-b71767994738', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Robber', '<p>You are given a list of non-negative integers representing the amount of money of each house in a row of houses. Each house has a certain amount of money stashed, but you cannot rob two adjacent houses at the same time because the police will be alerted. Your task is to determine the maximum amount of money you can rob tonight without alerting the police.</p><p>Example 1:</p><pre class="ql-syntax" spellcheck="false">Input: 
4
1 2 3 1
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3). Total amount = 1 + 3 = 4.
</pre>', 'Good Job', 10, 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-08-04 14:14:27.681623+07', '2024-08-04 14:14:27.681623+07', NULL, 'f', 'CODE', 'MEDIUM');
INSERT INTO "public"."question" VALUES ('b6484e21-6937-489c-b031-b71767994739', null, 'Three sum closest', '<p>You are given an array <code>nums</code> of integers. Write a function to find three numbers in <code>nums</code> such that the sum is closest to a given target <code>target</code>. Return the sum of the three integers. You may assume that each input would have exactly one solution.</p><p>Example:</p><pre class="ql-syntax" spellcheck="false">Input:
4
-1 2 1 -4
1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
</pre>', 'Good Job', 10, 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-08-04 14:14:27.681623+07', '2024-08-04 14:14:27.681623+07', NULL, 'f', 'CODE', 'MEDIUM');
INSERT INTO "public"."question" VALUES ('b6484e21-6937-489c-b031-b71767994740', null, 'List divisor', '<p>List all divisor of number <code>n</code></p><p>Example:</p><pre class="ql-syntax" spellcheck="false">Input:
10
Output:
1 2 5 10
</pre>', 'Good Job', 10, 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-08-04 14:14:27.681623+07', '2024-08-04 14:14:27.681623+07', NULL, 'f', 'CODE', 'EASY');
INSERT INTO "public"."question" VALUES ('b6484e21-6937-489c-b031-b71767994741', null, 'List odd divisor', '<p>List all odd divisor of number <code>n</code></p><p>Example:</p><pre class="ql-syntax" spellcheck="false">Input: 9
Output:
1, 3, 9
</pre>', 'Good Job', 10, 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-08-04 14:14:27.681623+07', '2024-08-04 14:14:27.681623+07', NULL, 'f', 'CODE', 'EASY');
INSERT INTO "public"."question" VALUES ('b6484e21-6937-489c-b031-b71767994742', null, 'Entirely odd digit', '<p>Check if the positive integer <code>n</code> consists entirely of odd digits.</p><p>Example:</p><pre class="ql-syntax" spellcheck="false">Input:
11
Output:
true
</pre>', 'Good Job', 10, 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-08-04 14:14:27.681623+07', '2024-08-04 14:14:27.681623+07', NULL, 'f', 'CODE', 'EASY');
INSERT INTO "public"."question" VALUES ('b6484e21-6937-489c-b031-b71767994743', null, 'Palindrome integer', '<p>Check if the positive integer n is a palindrome or not</p><p>Example:</p><pre class="ql-syntax" spellcheck="false">Input:
11
Output:
true
</pre>', 'Good Job', 10, 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-08-04 14:14:27.681623+07', '2024-08-04 14:14:27.681623+07', NULL, 'f', 'CODE', 'MEDIUM');
INSERT INTO "public"."question" VALUES ('b6484e21-6937-489c-b031-b71767994744', null, 'Finding maximum sum k less than n', '<p>Given <code>n</code> is a positive integer. Find the largest positive integer <code>k</code> such that S(k)&lt;n, where S(k) is defined as follows: S(k)=1+2+3+…+k.</p><p>Example:</p><pre class="ql-syntax" spellcheck="false">Input:
15
Output:
4
</pre>', 'Good Job', 10, 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-08-04 14:14:27.681623+07', '2024-08-04 14:14:27.681623+07', NULL, 'f', 'CODE', 'MEDIUM');
INSERT INTO "public"."question" VALUES ('b6484e21-6937-489c-b031-b71767994745', null, 'Check 2^k', '<p>Check if a 4-byte integer is of the form 2^k</p><p>Example:</p><pre class="ql-syntax" spellcheck="false">Input:
4
Output:
true
</pre>', 'Good Job', 10, 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-08-04 14:14:27.681623+07', '2024-08-04 14:14:27.681623+07', NULL, 'f', 'CODE', 'MEDIUM');
INSERT INTO "public"."question" VALUES ('b6484e21-6937-489c-b031-b71767994746', null, 'Check 3^k', '<p>Check if a 4-byte integer is of the form 3^k</p><p>Example:</p><pre class="ql-syntax" spellcheck="false">Input:
4
Output:
false
</pre>', 'Good Job', 10, 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-08-04 14:14:27.681623+07', '2024-08-04 14:14:27.681623+07', NULL, 'f', 'CODE', 'MEDIUM');
INSERT INTO "public"."question" VALUES ('b6484e21-6937-489c-b031-b71767994747', null, 'Calculate S(n, x) with Summation and Exponential Series', '<p>Calculate&nbsp;<span class="ql-formula" data-value="S(n, x) = x + \frac{x^2}{1 + 2} + \frac{x^3}{1 + 2 + 3} + \cdots + \frac{x^n}{1 + 2 + 3 + \cdots + n}">﻿<span contenteditable="false"><span class="katex"><span class="katex-mathml"><math xmlns="http://www.w3.org/1998/Math/MathML"><semantics><mrow><mi>S</mi><mo stretchy="false">(</mo><mi>n</mi><mo separator="true">,</mo><mi>x</mi><mo stretchy="false">)</mo><mo>=</mo><mi>x</mi><mo>+</mo><mfrac><msup><mi>x</mi><mn>2</mn></msup><mrow><mn>1</mn><mo>+</mo><mn>2</mn></mrow></mfrac><mo>+</mo><mfrac><msup><mi>x</mi><mn>3</mn></msup><mrow><mn>1</mn><mo>+</mo><mn>2</mn><mo>+</mo><mn>3</mn></mrow></mfrac><mo>+</mo><mo>⋯</mo><mo>+</mo><mfrac><msup><mi>x</mi><mi>n</mi></msup><mrow><mn>1</mn><mo>+</mo><mn>2</mn><mo>+</mo><mn>3</mn><mo>+</mo><mo>⋯</mo><mo>+</mo><mi>n</mi></mrow></mfrac></mrow><annotation encoding="application/x-tex">S(n, x) = x + \frac{x^2}{1 + 2} + \frac{x^3}{1 + 2 + 3} + \cdots + \frac{x^n}{1 + 2 + 3 + \cdots + n}</annotation></semantics></math></span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.0576em;">S</span><span class="mopen">(</span><span class="mord mathnormal">n</span><span class="mpunct">,</span><span class="mspace" style="margin-right: 0.1667em;"></span><span class="mord mathnormal">x</span><span class="mclose">)</span><span class="mspace" style="margin-right: 0.2778em;"></span><span class="mrel">=</span><span class="mspace" style="margin-right: 0.2778em;"></span></span><span class="base"><span class="strut" style="height: 0.6667em; vertical-align: -0.0833em;"></span><span class="mord mathnormal">x</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">+</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 1.4213em; vertical-align: -0.4033em;"></span><span class="mord"><span class="mopen nulldelimiter"></span><span class="mfrac"><span class="vlist-t vlist-t2"><span class="vlist-r"><span class="vlist" style="height: 1.0179em;"><span class="" style="top: -2.655em;"><span class="pstrut" style="height: 3em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight"><span class="mord mtight">1</span><span class="mbin mtight">+</span><span class="mord mtight">2</span></span></span></span><span class="" style="top: -3.23em;"><span class="pstrut" style="height: 3em;"></span><span class="frac-line" style="border-bottom-width: 0.04em;"></span></span><span class="" style="top: -3.394em;"><span class="pstrut" style="height: 3em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight"><span class="mord mtight"><span class="mord mathnormal mtight">x</span><span class="msupsub"><span class="vlist-t"><span class="vlist-r"><span class="vlist" style="height: 0.8913em;"><span class="" style="top: -2.931em; margin-right: 0.0714em;"><span class="pstrut" style="height: 2.5em;"></span><span class="sizing reset-size3 size1 mtight"><span class="mord mtight">2</span></span></span></span></span></span></span></span></span></span></span></span><span class="vlist-s">​</span></span><span class="vlist-r"><span class="vlist" style="height: 0.4033em;"><span class=""></span></span></span></span></span><span class="mclose nulldelimiter"></span></span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">+</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 1.4213em; vertical-align: -0.4033em;"></span><span class="mord"><span class="mopen nulldelimiter"></span><span class="mfrac"><span class="vlist-t vlist-t2"><span class="vlist-r"><span class="vlist" style="height: 1.0179em;"><span class="" style="top: -2.655em;"><span class="pstrut" style="height: 3em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight"><span class="mord mtight">1</span><span class="mbin mtight">+</span><span class="mord mtight">2</span><span class="mbin mtight">+</span><span class="mord mtight">3</span></span></span></span><span class="" style="top: -3.23em;"><span class="pstrut" style="height: 3em;"></span><span class="frac-line" style="border-bottom-width: 0.04em;"></span></span><span class="" style="top: -3.394em;"><span class="pstrut" style="height: 3em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight"><span class="mord mtight"><span class="mord mathnormal mtight">x</span><span class="msupsub"><span class="vlist-t"><span class="vlist-r"><span class="vlist" style="height: 0.8913em;"><span class="" style="top: -2.931em; margin-right: 0.0714em;"><span class="pstrut" style="height: 2.5em;"></span><span class="sizing reset-size3 size1 mtight"><span class="mord mtight">3</span></span></span></span></span></span></span></span></span></span></span></span><span class="vlist-s">​</span></span><span class="vlist-r"><span class="vlist" style="height: 0.4033em;"><span class=""></span></span></span></span></span><span class="mclose nulldelimiter"></span></span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">+</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 0.6667em; vertical-align: -0.0833em;"></span><span class="minner">⋯</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">+</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 1.3143em; vertical-align: -0.4033em;"></span><span class="mord"><span class="mopen nulldelimiter"></span><span class="mfrac"><span class="vlist-t vlist-t2"><span class="vlist-r"><span class="vlist" style="height: 0.911em;"><span class="" style="top: -2.655em;"><span class="pstrut" style="height: 3em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight"><span class="mord mtight">1</span><span class="mbin mtight">+</span><span class="mord mtight">2</span><span class="mbin mtight">+</span><span class="mord mtight">3</span><span class="mbin mtight">+</span><span class="minner mtight">⋯</span><span class="mbin mtight">+</span><span class="mord mathnormal mtight">n</span></span></span></span><span class="" style="top: -3.23em;"><span class="pstrut" style="height: 3em;"></span><span class="frac-line" style="border-bottom-width: 0.04em;"></span></span><span class="" style="top: -3.394em;"><span class="pstrut" style="height: 3em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight"><span class="mord mtight"><span class="mord mathnormal mtight">x</span><span class="msupsub"><span class="vlist-t"><span class="vlist-r"><span class="vlist" style="height: 0.7385em;"><span class="" style="top: -2.931em; margin-right: 0.0714em;"><span class="pstrut" style="height: 2.5em;"></span><span class="sizing reset-size3 size1 mtight"><span class="mord mathnormal mtight">n</span></span></span></span></span></span></span></span></span></span></span></span><span class="vlist-s">​</span></span><span class="vlist-r"><span class="vlist" style="height: 0.4033em;"><span class=""></span></span></span></span></span><span class="mclose nulldelimiter"></span></span></span></span></span></span>﻿</span> , rounded to three decimal places.</p><p>Example:</p><pre class="ql-syntax" spellcheck="false">Input:
2 1.5
Output:
2.250
</pre>', 'Good Job', 10, 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-08-04 14:14:27.681623+07', '2024-08-04 14:14:27.681623+07', NULL, 'f', 'CODE', 'MEDIUM');
INSERT INTO "public"."question" VALUES ('b6484e21-6937-489c-b031-b71767994748', null, 'Check square number', 'Given an integer number n, check if it is a square number', 'Good Job', 10, 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-08-04 14:14:27.681623+07', '2024-08-04 14:14:27.681623+07', NULL, 'f', 'CODE', 'EASY');
INSERT INTO "public"."question" VALUES ('b6484e21-6937-489c-b031-b71767994749', null, 'Find the nax number from the set of float number a, b, c', 'A line with three number separated by a space character', 'Good Job', 10, 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-08-04 14:14:27.681623+07', '2024-08-04 14:14:27.681623+07', NULL, 'f', 'CODE', 'EASY');
INSERT INTO "public"."question" VALUES ('b6484e21-6937-489c-b031-b71767994750', null, 'Same sign number', 'Check if Two Real Numbers Have the Same Sign', 'Good Job', 10, 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-08-04 14:14:27.681623+07', '2024-08-04 14:14:27.681623+07', NULL, 'f', 'CODE', 'EASY');
INSERT INTO "public"."question" VALUES ('b6484e21-6937-489c-b031-b71767994754', null, 'Solve ax+b=0', '<p>Write a program to solve the linear equation <span class="ql-formula" data-value="ax + b = 0">﻿<span contenteditable="false"><span class="katex"><span class="katex-mathml"><math xmlns="http://www.w3.org/1998/Math/MathML"><semantics><mrow><mi>a</mi><mi>x</mi><mo>+</mo><mi>b</mi><mo>=</mo><mn>0</mn></mrow><annotation encoding="application/x-tex">ax + b = 0</annotation></semantics></math></span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 0.6667em; vertical-align: -0.0833em;"></span><span class="mord mathnormal">a</span><span class="mord mathnormal">x</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">+</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 0.6944em;"></span><span class="mord mathnormal">b</span><span class="mspace" style="margin-right: 0.2778em;"></span><span class="mrel">=</span><span class="mspace" style="margin-right: 0.2778em;"></span></span><span class="base"><span class="strut" style="height: 0.6444em;"></span><span class="mord">0</span></span></span></span></span>﻿</span> </p><p>Example 1:</p><pre class="ql-syntax" spellcheck="false">Input:
0 0
Output:
Infinite solutions
</pre><p>Example 2:</p><pre class="ql-syntax" spellcheck="false">Input:
0 5
Output:
No solution
</pre><p>Example 3:</p><pre class="ql-syntax" spellcheck="false">Input:
3 0
Output:
0
</pre>', 'Good Job', 10, 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-08-04 14:14:27.681623+07', '2024-08-04 14:14:27.681623+07', NULL, 'f', 'CODE', 'MEDIUM');
INSERT INTO "public"."question" VALUES ('b6484e21-6937-489c-b031-b71767994755', null, 'Determine the Quarter of a Given Month', '<p>Input a month of a year. Determine which quarter the month belongs to</p><p>Example:</p><pre class="ql-syntax" spellcheck="false">Input:
1
Output:
Quarter 1
</pre>', 'Good Job', 10, 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-08-04 14:14:27.681623+07', '2024-08-04 14:14:27.681623+07', NULL, 'f', 'CODE', 'EASY');
INSERT INTO "public"."question" VALUES ('b6484e21-6937-489c-b031-b71767994756', null, 'Calculate sum of cubes', '<p>Calculate <span class="ql-formula" data-value="S(n) = 1^3 + 2^3 + \ldots + n^3">﻿<span contenteditable="false"><span class="katex"><span class="katex-mathml"><math xmlns="http://www.w3.org/1998/Math/MathML"><semantics><mrow><mi>S</mi><mo stretchy="false">(</mo><mi>n</mi><mo stretchy="false">)</mo><mo>=</mo><msup><mn>1</mn><mn>3</mn></msup><mo>+</mo><msup><mn>2</mn><mn>3</mn></msup><mo>+</mo><mo>…</mo><mo>+</mo><msup><mi>n</mi><mn>3</mn></msup></mrow><annotation encoding="application/x-tex">S(n) = 1^3 + 2^3 + \ldots + n^3</annotation></semantics></math></span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord mathnormal" style="margin-right: 0.0576em;">S</span><span class="mopen">(</span><span class="mord mathnormal">n</span><span class="mclose">)</span><span class="mspace" style="margin-right: 0.2778em;"></span><span class="mrel">=</span><span class="mspace" style="margin-right: 0.2778em;"></span></span><span class="base"><span class="strut" style="height: 0.8974em; vertical-align: -0.0833em;"></span><span class="mord"><span class="mord">1</span><span class="msupsub"><span class="vlist-t"><span class="vlist-r"><span class="vlist" style="height: 0.8141em;"><span class="" style="top: -3.063em; margin-right: 0.05em;"><span class="pstrut" style="height: 2.7em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight">3</span></span></span></span></span></span></span></span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">+</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 0.8974em; vertical-align: -0.0833em;"></span><span class="mord"><span class="mord">2</span><span class="msupsub"><span class="vlist-t"><span class="vlist-r"><span class="vlist" style="height: 0.8141em;"><span class="" style="top: -3.063em; margin-right: 0.05em;"><span class="pstrut" style="height: 2.7em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight">3</span></span></span></span></span></span></span></span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">+</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 0.6667em; vertical-align: -0.0833em;"></span><span class="minner">…</span><span class="mspace" style="margin-right: 0.2222em;"></span><span class="mbin">+</span><span class="mspace" style="margin-right: 0.2222em;"></span></span><span class="base"><span class="strut" style="height: 0.8141em;"></span><span class="mord"><span class="mord mathnormal">n</span><span class="msupsub"><span class="vlist-t"><span class="vlist-r"><span class="vlist" style="height: 0.8141em;"><span class="" style="top: -3.063em; margin-right: 0.05em;"><span class="pstrut" style="height: 2.7em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight">3</span></span></span></span></span></span></span></span></span></span></span></span>﻿</span> </p><p>Example:</p><pre class="ql-syntax" spellcheck="false">Input:
2
Output:
9
</pre>', 'Good Job', 10, 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-08-04 14:14:27.681623+07', '2024-08-04 14:14:27.681623+07', NULL, 'f', 'CODE', 'EASY');
INSERT INTO "public"."question" VALUES ('b6484e21-6937-489c-b031-b71767994757', null, 'English alphabet printing', 'Print from A to the nth character in the English alphabet', 'Good Job', 10, 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-08-04 14:14:27.681623+07', '2024-08-04 14:14:27.681623+07', NULL, 'f', 'CODE', 'EASY');
INSERT INTO "public"."question" VALUES ('b6484e21-6937-489c-b031-b71767994758', null, 'Check prime number', 'Check if n is a prime number or not', 'Good Job', 10, 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-08-04 14:14:27.681623+07', '2024-08-04 14:14:27.681623+07', NULL, 'f', 'CODE', 'MEDIUM');
INSERT INTO "public"."question" VALUES ('b6484e21-6937-489c-b031-b71767994759', null, 'Replace negative number', '<p>Write a program to input three real numbers. Replace all negative numbers with their absolute values</p><p>Example:</p><pre class="ql-syntax" spellcheck="false">Input:
1 -1.1 -2
Output:
1 1.1 2
</pre>', 'Good Job', 10, 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-08-04 14:14:27.681623+07', '2024-08-04 14:14:27.681623+07', NULL, 'f', 'CODE', 'EASY');
INSERT INTO "public"."question" VALUES ('b6484e21-6937-489c-b031-b71767994760', null, 'Check triangle from side length', '<p>Write a program to input the lengths of the three sides of a triangle and determine the type of triangle</p><p>Example:</p><pre class="ql-syntax" spellcheck="false">Input:
1 1 1
Output:
Equilateral triangle
</pre>', 'Good Job', 10, 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-08-04 14:14:27.681623+07', '2024-08-04 14:14:27.681623+07', NULL, 'f', 'CODE', 'HARD');
INSERT INTO "public"."question" VALUES ('b6484e21-6937-489c-b031-b71767994761', null, 'Determine number of days in a month', '<p>Write a program to input a month and a year. Determine the number of days in that month</p><p>Example:</p><pre class="ql-syntax" spellcheck="false">Input:
1 2020
Output:
31
</pre>', 'Good Job', 10, 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-08-04 14:14:27.681623+07', '2024-08-04 14:14:27.681623+07', NULL, 'f', 'CODE', 'EASY');
INSERT INTO "public"."question" VALUES ('b6484e21-6937-489c-b031-b71767994762', null, 'Previous and next day', '<p>Write a program to input a date, find the previous day and the next day</p><p>Example:</p><pre class="ql-syntax" spellcheck="false">Input:
2024 6 26
Output:
2024-06-25, 2024-06-27
</pre>', 'Good Job', 10, 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-08-04 14:14:27.681623+07', '2024-08-04 14:14:27.681623+07', NULL, 'f', 'CODE', 'MEDIUM');
INSERT INTO "public"."question" VALUES ('b6484e21-6937-489c-b031-b71767994763', null, 'Determine the Day of the Week from a Given Date', '<p>Write a program to input a day, month, and year. Determine the day of the week for that date</p><p>Example:</p><pre class="ql-syntax" spellcheck="false">Input:
2024-03-01
Output:
Friday
</pre>', 'Good Job', 10, 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-08-04 14:14:27.681623+07', '2024-08-04 14:14:27.681623+07', NULL, 'f', 'CODE', 'HARD');
INSERT INTO "public"."question" VALUES ('b6484e21-6937-489c-b031-b71767994764', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'List divisor', '<p>List all divisor of number <code>n</code></p><p>Example:</p><pre class="ql-syntax" spellcheck="false">Input:
10
Output:
1 2 5 10
</pre>', 'Good Job', 10, '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-08-04 14:14:27.688013+07', '2024-08-04 14:14:27.688013+07', 'd8fed7b0-bd98-436e-9c4d-36b8fe9f372e', 'f', 'CODE', 'EASY');
INSERT INTO "public"."question" VALUES ('b6484e21-6937-489c-b031-b71767994765', null, 'Count words', '', 'Good Job', 10, 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-08-04 14:14:27.688013+07', '2024-08-04 14:14:27.688013+07', null, 'f', 'CODE', 'EASY');
INSERT INTO "public"."question" VALUES ('b6484e21-6937-489c-b031-b71767994766', null, 'Reverse string', '', 'Good Job', 10, 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-08-04 14:14:27.688013+07', '2024-08-04 14:14:27.688013+07', null, 'f', 'CODE', 'EASY');
INSERT INTO "public"."question" VALUES ('b6484e21-6937-489c-b031-b71767994767', null, 'Palindrome string', '', 'Good Job', 10, 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-08-04 14:14:27.688013+07', '2024-08-04 14:14:27.688013+07', null, 'f', 'CODE', 'MEDIUM');
INSERT INTO "public"."question" VALUES ('b6484e21-6937-489c-b031-b71767994768', null, 'Delete consecutive duplicate characters', '', 'Good Job', 10, 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-08-04 14:14:27.688013+07', '2024-08-04 14:14:27.688013+07', null, 'f', 'CODE', 'MEDIUM');
INSERT INTO "public"."question" VALUES ('b6484e21-6937-489c-b031-b71767994769', null, 'Count the number of times a character appears', '', 'Good Job', 10, 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-08-04 14:14:27.688013+07', '2024-08-04 14:14:27.688013+07', null, 'f', 'CODE', 'EASY');
INSERT INTO "public"."question" VALUES ('b6484e21-6937-489c-b031-b71767994770', null, 'Find the first non-repeating character', '', 'Good Job', 10, 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-08-04 14:14:27.688013+07', '2024-08-04 14:14:27.688013+07', null, 'f', 'CODE', 'MEDIUM');
INSERT INTO "public"."question" VALUES ('b6484e21-6937-489c-b031-b71767994771', null, 'Count the vowels in the string', '', 'Good Job', 10, 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-08-04 14:14:27.688013+07', '2024-08-04 14:14:27.688013+07', null, 'f', 'CODE', 'EASY');
INSERT INTO "public"."question" VALUES ('b6484e21-6937-489c-b031-b71767994772', null, 'Find the longest word in the string', '', 'Good Job', 10, 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-08-04 14:14:27.688013+07', '2024-08-04 14:14:27.688013+07', null, 'f', 'CODE', 'MEDIUM');
INSERT INTO "public"."question" VALUES ('b6484e21-6937-489c-b031-b71767994773', null, 'Check string contains prime number', '', 'Good Job', 10, 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-08-04 14:14:27.688013+07', '2024-08-04 14:14:27.688013+07', null, 'f', 'CODE', 'HARD');
INSERT INTO "public"."question" VALUES ('b6484e21-6937-489c-b031-b71767994774', null, 'Find the substring with the greatest length that does not contain repeated characters', '', 'Good Job', 10, 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-08-04 14:14:27.688013+07', '2024-08-04 14:14:27.688013+07', null, 'f', 'CODE', 'HARD');


INSERT INTO "public"."question" VALUES ('20d06a81-f597-41bc-a60c-480d5c38eb80', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Câu 1', '<p><span style="color: rgb(51, 51, 51);">Hãy cho biết ý tưởng nào sau đây nói về phương pháp sắp xếp chọn tăng dần (select sort)?</span></p>', '', 1, '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-06-20 21:22:33.943+07', '2024-06-20 21:22:33.943+07', NULL, 'f', 'MULTIPLE_CHOICE', 'EASY');
INSERT INTO "public"."question" VALUES ('82a72f33-69d1-417a-bc4a-54e4a3f42a06', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Câu 2', '<h4><a href="https://khoahoc.vietjack.com/question/958165/phuong-phap-nao-sau-day-chinh-la-phuong-phap-sap-xep-nhanh-quick-sort" rel="noopener noreferrer" target="_blank" style="color: rgb(0, 0, 0); background-color: transparent;">Phương pháp nào sau đây chính là phương pháp sắp xếp nhanh (Quick sort)?</a></h4><p><br></p>', '', 1, '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-06-20 21:24:18.255+07', '2024-06-20 21:24:18.255+07', NULL, 'f', 'MULTIPLE_CHOICE', 'EASY');
INSERT INTO "public"."question" VALUES ('fe65d7df-69ac-4a17-805c-f1f2b65b9972', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Câu 3', '<h4><a href="https://khoahoc.vietjack.com/question/958164/hay-cho-biet-y-tuong-nao-sau-day-noi-ve-phuong-phap-sap-xep-nhanh-quick-sort" rel="noopener noreferrer" target="_blank" style="color: rgb(0, 0, 0); background-color: transparent;">Hãy cho biết ý tưởng nào sau đây nói về phương pháp sắp xếp nhanh (Quick sort)?</a></h4><p><br></p>', '', 1, '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-06-20 21:25:56.678+07', '2024-06-20 21:25:56.678+07', NULL, 'f', 'MULTIPLE_CHOICE', 'EASY');
INSERT INTO "public"."question" VALUES ('53ce35a7-9dcf-4741-a4ed-872874daf829', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Câu 4', '<p><a href="https://vietjack.online/cau-hoi/958554/giai-thuat-de-quy-la-a-trong-giai-thuat-cua-no-co-loi-goi-toi-chinh-no" rel="noopener noreferrer" target="_blank" style="color: rgb(0, 0, 0); background-color: transparent;">Giải thuật đệ quy là:</a></p>', '', 1, '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-06-20 21:28:17.404+07', '2024-06-20 21:28:17.404+07', NULL, 'f', 'MULTIPLE_CHOICE', 'EASY');
INSERT INTO "public"."question" VALUES ('0fe5d2ee-6892-4f62-a6e6-83284f2430bc', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Câu 5', '<p>QUEUE hoạt động như thế nào?</p>', '', 1, '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-06-20 21:29:19.651+07', '2024-06-20 21:29:19.651+07', NULL, 'f', 'SHORT_ANSWER', 'EASY');
INSERT INTO "public"."question" VALUES ('513a7e58-00d0-450b-8f0d-78af23898b81', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Câu 6', '<p>Có thể gán NULL cho con trỏ nhằm chỉ định rằng nó không trỏ tới bất kỳ vùng nhớ nào</p>', '', 1, '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-06-20 21:30:30.013+07', '2024-06-20 21:30:30.013+07', NULL, 'f', 'TRUE_FALSE', 'EASY');
INSERT INTO "public"."question" VALUES ('1168fba1-8391-4294-b1cb-2c108f96af1f', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Câu 7', '<p>%ld là xâu định dạng để in ra một số nguyên dài</p>', '', 1, '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-06-20 21:31:56.412+07', '2024-06-20 21:31:56.412+07', NULL, 'f', 'TRUE_FALSE', 'EASY');
INSERT INTO "public"."question" VALUES ('c4b3219f-9d83-4497-ad15-d46772141bd5', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Câu 8', '<p>STACK hoạt động như nào?</p>', '', 1, '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-06-20 21:33:16.858+07', '2024-06-20 21:33:16.858+07', NULL, 'f', 'SHORT_ANSWER', 'EASY');
INSERT INTO "public"."question" VALUES ('29a71c20-290b-471d-acc8-4c5c929f96a8', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Câu 9', '<p>* là ký tự dùng để biểu diễn con trỏ trong C/C++</p>', '', 1, '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-06-20 21:34:57.337+07', '2024-06-20 21:34:57.337+07', NULL, 'f', 'TRUE_FALSE', 'EASY');
INSERT INTO "public"."question" VALUES ('1ca8c89a-1bd0-41b2-adf0-4f7b55f8b256', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Câu 10', '<p>Con trỏ là một biến dùng để lưu địa chỉ nhớ của một biến khác</p>', '', 1, '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-06-20 21:35:23.436+07', '2024-06-20 21:35:23.436+07', NULL, 'f', 'TRUE_FALSE', 'EASY');
INSERT INTO "public"."question" VALUES ('fe7f0a71-d3c5-4d2b-be25-2faff42c6b5c', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Router có chức năng gì trong mạng máy tính?', '<p>Router có chức năng gì trong mạng máy tính?</p>', '', 1, '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-07-16 21:10:00.373+07', '2024-07-16 21:10:00.373+07', NULL, 'f', 'SHORT_ANSWER', 'EASY');
INSERT INTO "public"."question" VALUES ('e64fc118-1ae3-413d-9524-3e1dd1702ab5', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Giao thức nào sau đây thường được sử dụng cho truyền thông trong mạng Internet?', '<p>Giao thức nào sau đây thường được sử dụng cho truyền thông trong mạng Internet?</p>', '', 1, '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-07-16 21:10:58.485+07', '2024-07-16 21:10:58.485+07', NULL, 'f', 'MULTIPLE_CHOICE', 'EASY');
INSERT INTO "public"."question" VALUES ('c434f3a9-986e-4522-bbdc-d9c58e0380ed', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Thiết bị nào được sử dụng để kết nối các thiết bị trong một mạng cục bộ (LAN)?', '<p>Thiết bị nào được sử dụng để kết nối các thiết bị trong một mạng cục bộ (LAN)?</p>', '', 1, '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-07-16 21:12:26.919+07', '2024-07-16 21:12:26.919+07', NULL, 'f', 'MULTIPLE_CHOICE', 'EASY');
INSERT INTO "public"."question" VALUES ('514843c5-8814-4406-af5c-9bf55fdf9ec8', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'IP (Internet Protocol) là một giao thức thuộc tầng 4 trong mô hình OSI.', '<p>IP (Internet Protocol) là một giao thức thuộc tầng 4 trong mô hình OSI.</p>', '', 1, '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-07-16 21:12:51.027+07', '2024-07-16 21:12:51.027+07', NULL, 'f', 'TRUE_FALSE', 'EASY');
INSERT INTO "public"."question" VALUES ('e3ac5475-462e-457a-9e00-f37a6217135c', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'IP (Internet Protocol) là một giao thức thuộc tầng 4 trong mô hình OSI.', '<p>IP (Internet Protocol) là một giao thức thuộc tầng 4 trong mô hình OSI.</p>', '', 1, '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-07-16 21:13:07.104+07', '2024-07-16 21:13:07.104+07', NULL, 'f', 'TRUE_FALSE', 'EASY');
INSERT INTO "public"."question" VALUES ('4a8afa92-ad7c-4bd4-8bfc-d699f616a80d', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Mạng LAN (Local Area Network) chỉ hoạt động trong phạm vi nhỏ như một phòng hoặc tòa nhà.', '<p>Mạng LAN (Local Area Network) chỉ hoạt động trong phạm vi nhỏ như một phòng hoặc tòa nhà.</p>', '', 1, '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-07-16 21:15:03.696+07', '2024-07-16 21:15:03.696+07', NULL, 'f', 'TRUE_FALSE', 'EASY');
INSERT INTO "public"."question" VALUES ('1592dc84-c95f-45d6-9a65-6c1ac5e2e413', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Tất cả các thiết bị mạng đều phải sử dụng cáp để kết nối với nhau.', '<p>Tất cả các thiết bị mạng đều phải sử dụng cáp để kết nối với nhau.</p>', '', 1, '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-07-16 21:15:25.769+07', '2024-07-16 21:15:25.769+07', NULL, 'f', 'TRUE_FALSE', 'EASY');
INSERT INTO "public"."question" VALUES ('9de30d16-41ac-4451-9947-2b2088dd6afa', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Đóng gói (encapsulation) là gì?', '<p>Đóng gói (encapsulation) là gì?</p>', '', 1, '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-07-16 21:19:20.895+07', '2024-07-16 21:19:20.895+07', NULL, 'f', 'SHORT_ANSWER', 'EASY');
INSERT INTO "public"."question" VALUES ('8de957d4-92df-4f94-997b-1e1275afdc2f', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Khái niệm nào sau đây không thuộc về lập trình hướng đối tượng?', '<p>Khái niệm nào sau đây không thuộc về lập trình hướng đối tượng?</p>', '', 1, '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-07-16 21:20:19.241+07', '2024-07-16 21:20:19.241+07', NULL, 'f', 'MULTIPLE_CHOICE', 'EASY');
INSERT INTO "public"."question" VALUES ('b387b570-5b99-4f82-83be-292c969db99f', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Tính chất nào của lập trình hướng đối tượng cho phép một lớp con kế thừa các thuộc tính và phương thức từ lớp cha?', '<p>Tính chất nào của lập trình hướng đối tượng cho phép một lớp con kế thừa các thuộc tính và phương thức từ lớp cha?</p>', '', 1, '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-07-16 21:21:17.495+07', '2024-07-16 21:21:17.495+07', NULL, 'f', 'MULTIPLE_CHOICE', 'EASY');
INSERT INTO "public"."question" VALUES ('4fa387a6-db86-48bb-85f4-fcbb43c8eeb0', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Lớp trừu tượng (Abstract class) không thể tạo được đối tượng trực tiếp.', '<p>Lớp trừu tượng (Abstract class) không thể tạo được đối tượng trực tiếp.</p>', '', 1, '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-07-16 21:21:41.598+07', '2024-07-16 21:21:41.598+07', NULL, 'f', 'TRUE_FALSE', 'EASY');
INSERT INTO "public"."question" VALUES ('b48fbf09-4b3f-4def-bfb8-4cfb65da1f27', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Một lớp con có thể kế thừa nhiều lớp cha trong ngôn ngữ lập trình Java.', '<p>Một lớp con có thể kế thừa nhiều lớp cha trong ngôn ngữ lập trình Java.</p>', '', 1, '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-07-16 21:21:57.662+07', '2024-07-16 21:21:57.662+07', NULL, 'f', 'TRUE_FALSE', 'EASY');
INSERT INTO "public"."question" VALUES ('c5e675a1-50a3-400c-a232-968413d0ebf2', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Trong lập trình hướng đối tượng, phương thức khởi tạo (constructor) không thể bị ghi đè (override).', '<p>Trong lập trình hướng đối tượng, phương thức khởi tạo (constructor) không thể bị ghi đè (override).</p>', '', 1, '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-07-16 21:22:13.755+07', '2024-07-16 21:22:13.755+07', NULL, 'f', 'TRUE_FALSE', 'EASY');
INSERT INTO "public"."question" VALUES ('306eaa8b-4054-4ad7-b6ed-b847a2d53b63', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Interface chỉ định nghĩa các phương thức nhưng không cung cấp hiện thực của chúng.', '<p>Interface chỉ định nghĩa các phương thức nhưng không cung cấp hiện thực của chúng.</p>', '', 1, '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-07-16 21:22:27.836+07', '2024-07-16 21:22:27.836+07', NULL, 'f', 'TRUE_FALSE', 'EASY');
INSERT INTO "public"."question" VALUES ('1f0daa04-6462-4eb5-9fc4-883f68e78b7c', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Giải thuật (thuật toán) là gì?', '<p>Giải thuật (thuật toán) là gì?</p>', '', 1, '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-07-16 21:23:40.261+07', '2024-07-16 21:23:40.261+07', NULL, 'f', 'SHORT_ANSWER', 'EASY');
INSERT INTO "public"."question" VALUES ('1c054e46-a127-448d-a6a8-8c9be65cfded', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Cấu trúc dữ liệu nào sau đây là một dạng danh sách liên kết mà mỗi phần tử chứa một con trỏ đến phần tử tiếp theo và phần tử trước đó?', '<p>Cấu trúc dữ liệu nào sau đây là một dạng danh sách liên kết mà mỗi phần tử chứa một con trỏ đến phần tử tiếp theo và phần tử trước đó?</p>', '', 1, '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-07-16 21:24:30.558+07', '2024-07-16 21:24:30.558+07', NULL, 'f', 'MULTIPLE_CHOICE', 'EASY');
INSERT INTO "public"."question" VALUES ('c88dfd4d-b102-4412-9127-17d68ec3a5e1', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Giải thuật tìm kiếm nhị phân yêu cầu cấu trúc dữ liệu đầu vào phải là gì?', '<p>Giải thuật tìm kiếm nhị phân yêu cầu cấu trúc dữ liệu đầu vào phải là gì?</p>', '', 1, '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-07-16 21:25:38.954+07', '2024-07-16 21:25:38.954+07', NULL, 'f', 'MULTIPLE_CHOICE', 'EASY');
INSERT INTO "public"."question" VALUES ('eb74ae25-bfd1-4c3c-8d19-f29872f6b858', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Stack là một cấu trúc dữ liệu theo nguyên tắc LIFO (Last In, First Out).', '<p>Stack là một cấu trúc dữ liệu theo nguyên tắc LIFO (Last In, First Out).</p>', '', 1, '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-07-16 21:26:03.085+07', '2024-07-16 21:26:03.085+07', NULL, 'f', 'TRUE_FALSE', 'EASY');
INSERT INTO "public"."question" VALUES ('9002af16-7252-421a-b8ab-c0f4944a1e89', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Độ phức tạp thời gian trung bình của giải thuật tìm kiếm nhị phân là O(n).', '<p>Độ phức tạp thời gian trung bình của giải thuật tìm kiếm nhị phân là O(n).</p>', '', 1, '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-07-16 21:26:49.312+07', '2024-07-16 21:26:49.312+07', NULL, 'f', 'TRUE_FALSE', 'EASY');
INSERT INTO "public"."question" VALUES ('a411cc44-f924-445c-bd00-f605f7533dcf', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Độ phức tạp thời gian trung bình của giải thuật sắp xếp Quick Sort là O(n log n).', '<p>Độ phức tạp thời gian trung bình của giải thuật sắp xếp Quick Sort là O(n log n).</p>', '', 1, '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-07-16 21:27:07.421+07', '2024-07-16 21:27:07.421+07', NULL, 'f', 'TRUE_FALSE', 'EASY');
INSERT INTO "public"."question" VALUES ('05d5cd7c-968b-49a6-acf3-c839f2d04243', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Trong cấu trúc dữ liệu Heap, phần tử lớn nhất luôn nằm ở gốc (root) trong một Max Heap.', '<p>Trong cấu trúc dữ liệu Heap, phần tử lớn nhất luôn nằm ở gốc (root) trong một Max Heap.</p>', '', 1, '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-07-16 21:27:25.494+07', '2024-07-16 21:27:25.494+07', NULL, 'f', 'TRUE_FALSE', 'EASY');
INSERT INTO "public"."question" VALUES ('4faf36f7-aa0b-43db-b830-aff5c0337996', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Con trỏ (pointer) trong C/C++ là gì?', '<p>Con trỏ (pointer) trong C/C++ là gì?</p>', '', 1, '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-07-16 21:28:48+07', '2024-07-16 21:28:48+07', NULL, 'f', 'SHORT_ANSWER', 'EASY');
INSERT INTO "public"."question" VALUES ('175441dd-3023-480a-880a-4b9a93570c1d', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Trong C++, từ khóa nào được sử dụng để khai báo một lớp (class)?', '<p>Trong C++, từ khóa nào được sử dụng để khai báo một lớp (class)?</p>', '', 1, '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-07-16 21:29:50.331+07', '2024-07-16 21:29:50.331+07', NULL, 'f', 'MULTIPLE_CHOICE', 'EASY');
INSERT INTO "public"."question" VALUES ('4981ef9b-2355-4ee7-acb6-6f72d549f50d', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Phương thức nào sau đây được sử dụng để giải phóng bộ nhớ đã cấp phát động trong C++?', '<p>Phương thức nào sau đây được sử dụng để giải phóng bộ nhớ đã cấp phát động trong C++?</p>', '', 1, '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-07-16 21:30:44.597+07', '2024-07-16 21:30:44.597+07', NULL, 'f', 'MULTIPLE_CHOICE', 'EASY');
INSERT INTO "public"."question" VALUES ('643c9a5f-c96e-4a1a-be18-0c3758002e3d', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Trong C++, bạn có thể sử dụng từ khóa ''new'' để cấp phát bộ nhớ động.', '<p>Trong C++, bạn có thể sử dụng từ khóa <code>new</code> để cấp phát bộ nhớ động.</p>', '', 1, '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-07-16 21:31:20.761+07', '2024-07-16 21:31:20.761+07', NULL, 'f', 'TRUE_FALSE', 'EASY');
INSERT INTO "public"."question" VALUES ('d0470328-32a5-4b28-8dd6-49a8c3a0b9c4', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Trong C, hàm scanf có thể được sử dụng để nhập dữ liệu từ người dùng.', '<p>Trong C, hàm <code>scanf</code> có thể được sử dụng để nhập dữ liệu từ người dùng.</p>', '', 1, '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-07-16 21:31:38.817+07', '2024-07-16 21:31:38.817+07', NULL, 'f', 'TRUE_FALSE', 'EASY');
INSERT INTO "public"."question" VALUES ('ce2dda6f-1448-4cf8-932e-17deedee80a6', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Trong C++, hàm bạn định nghĩa bên trong một lớp được gọi là phương thức (method).', '<p>Trong C++, hàm bạn định nghĩa bên trong một lớp được gọi là phương thức (method).</p>', '', 1, '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-07-16 21:31:56.917+07', '2024-07-16 21:31:56.917+07', NULL, 'f', 'TRUE_FALSE', 'EASY');
INSERT INTO "public"."question" VALUES ('886e4b8a-6c84-40ee-8b16-d80ffdd06f8b', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Trong C++, bạn không thể nạp chồng (overload) toán tử.', '<p>Trong C++, bạn không thể nạp chồng (overload) toán tử.</p>', '', 1, '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-07-16 21:32:11.023+07', '2024-07-16 21:32:11.023+07', NULL, 'f', 'TRUE_FALSE', 'EASY');
INSERT INTO "public"."question" VALUES ('bfece9c7-3f02-43e1-bb7e-4317b3658641', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Sự khác biệt giữa == và equals() trong Java là gì?', '<p>Sự khác biệt giữa <code>==</code> và <code>equals()</code> trong Java là gì?</p>', '', 1, '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-07-16 21:33:27.488+07', '2024-07-16 21:33:27.488+07', NULL, 'f', 'SHORT_ANSWER', 'EASY');
INSERT INTO "public"."question" VALUES ('d6b8b467-f21a-4957-a58f-ad58c4015b2e', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Trong Java, một lớp chỉ có thể kế thừa từ một lớp khác.', '<p>Trong Java, một lớp chỉ có thể kế thừa từ một lớp khác.</p>', '', 1, '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-07-16 21:34:17.738+07', '2024-07-16 21:34:17.738+07', NULL, 'f', 'TRUE_FALSE', 'EASY');
INSERT INTO "public"."question" VALUES ('f1de8ed8-5721-4260-b019-d3ae2852f048', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Trong Java, tất cả các lớp đều là con của lớp Object.', '<p>Trong Java, tất cả các lớp đều là con của lớp Object.</p>', '', 1, '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-07-16 21:34:31.83+07', '2024-07-16 21:34:31.83+07', NULL, 'f', 'TRUE_FALSE', 'EASY');
INSERT INTO "public"."question" VALUES ('56aa0b87-83b7-42cf-9e90-0f075ad8c53b', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Java hỗ trợ lập trình hàm (functional programming) từ phiên bản Java 8 trở đi với sự ra đời của lambda expressions.', '<p>&nbsp;Java hỗ trợ lập trình hàm (functional programming) từ phiên bản Java 8 trở đi với sự ra đời của lambda expressions.</p>', '', 1, '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-07-16 21:34:47.878+07', '2024-07-16 21:34:47.878+07', NULL, 'f', 'TRUE_FALSE', 'EASY');
INSERT INTO "public"."question" VALUES ('b0edc4d7-713a-48df-a9a7-8a8b411c3379', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Trong Java, bạn có thể tạo một đối tượng từ một lớp trừu tượng (abstract class).', '<p>Trong Java, bạn có thể tạo một đối tượng từ một lớp trừu tượng (abstract class).</p>', '', 1, '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2024-07-16 21:35:07.996+07', '2024-07-16 21:35:07.996+07', NULL, 'f', 'TRUE_FALSE', 'EASY');

INSERT INTO "public"."answer_of_question" VALUES ('f13af228-9d17-45b1-b3e5-7a34f590b145', '20d06a81-f597-41bc-a60c-480d5c38eb80', '<p><span style="color: rgb(63, 63, 63);">Phân đoạn dãy thành nhiều dãy con và lần lượt trộn hai dãy con thành dãy lớn hơn, cho đến khi thu được dãy ban đầu đã được sắp xếp</span></p>', '<p><span style="color: rgb(63, 63, 63);">Phân đoạn dãy thành nhiều dãy con và lần lượt trộn hai dãy con thành dãy lớn hơn, cho đến khi thu được dãy ban đầu đã được sắp xếp</span></p>', 0.00);
INSERT INTO "public"."answer_of_question" VALUES ('da47f572-a86b-4250-9596-fabf92ffb150', '20d06a81-f597-41bc-a60c-480d5c38eb80', '<p><span style="color: rgb(63, 63, 63);">Lần lượt lấy phần tử của danh sách chèn vị trí thích hợp của nó trong dãy</span></p>', '<p><span style="color: rgb(63, 63, 63);">Lần lượt lấy phần tử của danh sách chèn vị trí thích hợp của nó trong dãy</span></p>', 0.00);
INSERT INTO "public"."answer_of_question" VALUES ('20ba7b11-9b6a-48d6-96e5-5b49a4127bf7', '20d06a81-f597-41bc-a60c-480d5c38eb80', '<p><span style="color: rgb(63, 63, 63);">Chọn phần tử bé nhất xếp vào vị trí thứ nhất bằng cách đổi chổ phần tử bé nhất với phần tử thứ nhất; Tương tự đối với phần tử nhỏ thứ hai cho đến phần tử cuối cùng</span></p>', '<p><span style="color: rgb(63, 63, 63);">Chọn phần tử bé nhất xếp vào vị trí thứ nhất bằng cách đổi chổ phần tử bé nhất với phần tử thứ nhất; Tương tự đối với phần tử nhỏ thứ hai cho đến phần tử cuối cùng</span></p>', 1.00);
INSERT INTO "public"."answer_of_question" VALUES ('797744cf-8e04-486c-a3ef-778b71ab4303', '20d06a81-f597-41bc-a60c-480d5c38eb80', '<p><span style="color: rgb(63, 63, 63);">Bắt đầu từ cuối dãy đến đầu dãy, ta lần lượt so sánh hai phần tử kế tiếp nhau, nếu phần tử nào bé hơn được cho lên vị trí trên</span></p>', '<p><span style="color: rgb(63, 63, 63);">Bắt đầu từ cuối dãy đến đầu dãy, ta lần lượt so sánh hai phần tử kế tiếp nhau, nếu phần tử nào bé hơn được cho lên vị trí trên</span></p>', 0.00);
INSERT INTO "public"."answer_of_question" VALUES ('c057f9a7-29f2-4510-bda6-20282e084548', '82a72f33-69d1-417a-bc4a-54e4a3f42a06', '<p><span style="color: rgb(63, 63, 63);">Phương phap trộn</span></p>', '<p><span style="color: rgb(63, 63, 63);">Phương phap trộn</span></p>', 0.00);
INSERT INTO "public"."answer_of_question" VALUES ('73dce995-e874-4839-a4ed-b024534adb68', '82a72f33-69d1-417a-bc4a-54e4a3f42a06', '<p><span style="color: rgb(63, 63, 63);">Phương pháp vun đống</span></p>', '<p><span style="color: rgb(63, 63, 63);">Phương pháp vun đống</span></p>', 0.00);
INSERT INTO "public"."answer_of_question" VALUES ('b35e54ea-7b0d-4ed6-a1e5-3a24c1296670', '82a72f33-69d1-417a-bc4a-54e4a3f42a06', '<p><span style="color: rgb(63, 63, 63);">Phương pháp chèn</span></p>', '<p><span style="color: rgb(63, 63, 63);">Phương pháp chèn</span></p>', 0.00);
INSERT INTO "public"."answer_of_question" VALUES ('1350a0b1-43c6-43c5-a9e1-34bce3e6759e', '82a72f33-69d1-417a-bc4a-54e4a3f42a06', '<p><span style="color: rgb(63, 63, 63);">Phương pháp phân đoạn</span></p>', '<p><span style="color: rgb(63, 63, 63);">Phương pháp phân đoạn</span></p>', 1.00);
INSERT INTO "public"."answer_of_question" VALUES ('d64eda1d-8a47-4d01-9396-2362d55621d5', 'fe65d7df-69ac-4a17-805c-f1f2b65b9972', '<p><span style="color: rgb(63, 63, 63);">Chọn phần tử bé nhất xếp vào vị trí thứ nhất bằng cách đổi chổ phần tử bé nhất với phần tử thứ nhất; Tương tự đối với phần tử nhỏ thứ hai cho đến phần tử cuối cùng</span></p>', '<p><span style="color: rgb(63, 63, 63);">Chọn phần tử bé nhất xếp vào vị trí thứ nhất bằng cách đổi chổ phần tử bé nhất với phần tử thứ nhất; Tương tự đối với phần tử nhỏ thứ hai cho đến phần tử cuối cùng</span></p>', 0.00);
INSERT INTO "public"."answer_of_question" VALUES ('a0444c51-ede9-4c42-a821-e9e3b6124761', 'fe65d7df-69ac-4a17-805c-f1f2b65b9972', '<p><span style="color: rgb(63, 63, 63);">Bắt đầu từ cuối dãy đến đầu dãy, ta lần lượt so sánh hai phần tử kế tiếpnh u, nếu phần tử nào nhỏ hơn được đứng vị trí trên</span></p>', '<p><span style="color: rgb(63, 63, 63);">Bắt đầu từ cuối dãy đến đầu dãy, ta lần lượt so sánh hai phần tử kế tiếpnh u, nếu phần tử nào nhỏ hơn được đứng vị trí trên</span></p>', 0.00);
INSERT INTO "public"."answer_of_question" VALUES ('ca665a4c-0f11-4144-9f52-025fd9887870', 'fe65d7df-69ac-4a17-805c-f1f2b65b9972', '<p><span style="color: rgb(63, 63, 63);">Phân đoạn dãy thành nhiều dãy con và lần lượt trộn hai dãy con thành dãy lớn hơn, cho đến khi thu được dãy ban đầu đã được sắp xếp</span></p>', '<p><span style="color: rgb(63, 63, 63);">Phân đoạn dãy thành nhiều dãy con và lần lượt trộn hai dãy con thành dãy lớn hơn, cho đến khi thu được dãy ban đầu đã được sắp xếp</span></p>', 0.00);
INSERT INTO "public"."answer_of_question" VALUES ('e7a9f1de-b7bb-48d4-a7d9-c41c805c112a', 'fe65d7df-69ac-4a17-805c-f1f2b65b9972', '<p><span style="color: rgb(63, 63, 63);">Lần lượt chia dãy phần tử thành hai dãy con bởi một phần tử khoá (dãy con trước khoá gồm các phần tử nhỏ hơn khoá và dãy còn lại gồm các phần tử lớn hơn khoá)</span></p>', '<p><span style="color: rgb(63, 63, 63);">Lần lượt chia dãy phần tử thành hai dãy con bởi một phần tử khoá (dãy con trước khoá gồm các phần tử nhỏ hơn khoá và dãy còn lại gồm các phần tử lớn hơn khoá)</span></p>', 1.00);
INSERT INTO "public"."answer_of_question" VALUES ('7d39a4d4-a392-4929-9e0f-9317aa079a89', '53ce35a7-9dcf-4741-a4ed-872874daf829', '<p><span style="color: rgb(63, 63, 63);">Trong giải thuật của nó có lời gọi tới chính nó</span></p>', '<p><span style="color: rgb(63, 63, 63);">Trong giải thuật của nó có lời gọi tới chính nó</span></p>', 0.00);
INSERT INTO "public"."answer_of_question" VALUES ('b8eb7450-9483-4b7f-a42c-a74c13db3842', '53ce35a7-9dcf-4741-a4ed-872874daf829', '<p><span style="color: rgb(63, 63, 63);">Trong giải thuật của nó có lời gọi tới chính nó nhưng với phạm vi lớn hơn</span></p>', '<p><span style="color: rgb(63, 63, 63);">Trong giải thuật của nó có lời gọi tới chính nó nhưng với phạm vi lớn hơn</span></p>', 0.00);
INSERT INTO "public"."answer_of_question" VALUES ('085c69a6-858c-4c79-aa19-2308f04844ce', '53ce35a7-9dcf-4741-a4ed-872874daf829', '<p><span style="color: rgb(63, 63, 63);">Trong giải thuật của nó có lời gọi tới chính nó nhưng với phạm vi nhỏ hơn</span></p>', '<p><span style="color: rgb(63, 63, 63);">Trong giải thuật của nó có lời gọi tới chính nó nhưng với phạm vi nhỏ hơn</span></p>', 1.00);
INSERT INTO "public"."answer_of_question" VALUES ('8b9b49af-f8da-4df7-b1dc-039dc7d94e2a', '53ce35a7-9dcf-4741-a4ed-872874daf829', '<p><span style="color: rgb(63, 63, 63);">Trong giải thuật của nó có lời gọi tới một giải thuật khác đã biết kết quả</span></p>', '<p><span style="color: rgb(63, 63, 63);">Trong giải thuật của nó có lời gọi tới một giải thuật khác đã biết kết quả</span></p>', 0.00);
INSERT INTO "public"."answer_of_question" VALUES ('ee0be7d0-c592-4e40-8bba-871b6c9f7272', '0fe5d2ee-6892-4f62-a6e6-83284f2430bc', '<p>FILO</p>', 'FILO', 1.00);
INSERT INTO "public"."answer_of_question" VALUES ('c791aa62-c177-45de-b015-44b0679654d2', '513a7e58-00d0-450b-8f0d-78af23898b81', 'Correct', 'true', 1.00);
INSERT INTO "public"."answer_of_question" VALUES ('80c171ab-25c9-4371-ae3d-f6de0b36c505', '1168fba1-8391-4294-b1cb-2c108f96af1f', 'Correct', 'true', 1.00);
INSERT INTO "public"."answer_of_question" VALUES ('b06ddec2-cbe0-4488-8cde-228c55e43a26', 'c4b3219f-9d83-4497-ad15-d46772141bd5', '<p>FIFO</p>', 'FIFO', 1.00);
INSERT INTO "public"."answer_of_question" VALUES ('022472ef-31ab-4876-8509-8f1108ae9dbb', '29a71c20-290b-471d-acc8-4c5c929f96a8', 'Correct', 'true', 1.00);
INSERT INTO "public"."answer_of_question" VALUES ('c85f2ef4-5cb6-4e4a-a8d0-01947ae1007e', '1ca8c89a-1bd0-41b2-adf0-4f7b55f8b256', 'Correct', 'true', 1.00);
INSERT INTO "public"."answer_of_question" VALUES ('c88f9871-2cc8-476e-afcd-db2c03455ae6', 'fe7f0a71-d3c5-4d2b-be25-2faff42c6b5c', '<p>Router có chức năng chuyển tiếp gói tin giữa các mạng khác nhau, định tuyến và quản lý luồng dữ liệu.</p>', 'Router có chức năng chuyển tiếp gói tin giữa các mạng khác nhau, định tuyến và quản lý luồng dữ liệu.', 1.00);
INSERT INTO "public"."answer_of_question" VALUES ('33d9b3bb-fffc-46b2-9312-1f5d57feaff9', 'e64fc118-1ae3-413d-9524-3e1dd1702ab5', '<p>HTTP</p>', '<p>HTTP</p>', 0.00);
INSERT INTO "public"."answer_of_question" VALUES ('fbdc889c-ea57-48ec-8e59-868cfcc8a472', 'e64fc118-1ae3-413d-9524-3e1dd1702ab5', '<p>FTP</p>', '<p>FTP</p>', 0.00);
INSERT INTO "public"."answer_of_question" VALUES ('32f89200-8f3e-467f-bc77-74aa3ad733db', 'e64fc118-1ae3-413d-9524-3e1dd1702ab5', '<p>SMTP</p>', '<p>SMTP</p>', 0.00);
INSERT INTO "public"."answer_of_question" VALUES ('3890c6c4-2b8a-43e3-a82b-785713f2c6f4', 'e64fc118-1ae3-413d-9524-3e1dd1702ab5', '<p>TCP/IP</p>', '<p>TCP/IP</p>', 1.00);
INSERT INTO "public"."answer_of_question" VALUES ('3dfd0458-6678-4328-9b4c-3132b8b32382', 'c434f3a9-986e-4522-bbdc-d9c58e0380ed', '<p>Router</p>', '<p>Router</p>', 0.00);
INSERT INTO "public"."answer_of_question" VALUES ('981085a7-ec44-4619-a979-9b3401852fa7', 'c434f3a9-986e-4522-bbdc-d9c58e0380ed', '<p>Switch</p>', '<p>Switch</p>', 1.00);
INSERT INTO "public"."answer_of_question" VALUES ('b8a262ca-d882-4550-b644-4528ff5efd64', 'c434f3a9-986e-4522-bbdc-d9c58e0380ed', '<p>Modem</p>', '<p>Modem</p>', 0.00);
INSERT INTO "public"."answer_of_question" VALUES ('1d8623ec-c3ee-4ed6-86a2-45f11a0e73f1', 'c434f3a9-986e-4522-bbdc-d9c58e0380ed', '<p>Hub</p>', '<p>Hub</p>', 0.00);
INSERT INTO "public"."answer_of_question" VALUES ('1e15ced7-3b2e-4165-9e84-f17873c12e20', '514843c5-8814-4406-af5c-9bf55fdf9ec8', 'Correct', 'false', 1.00);
INSERT INTO "public"."answer_of_question" VALUES ('d5387266-02bc-4454-b863-2bc6c2c16d6d', 'e3ac5475-462e-457a-9e00-f37a6217135c', 'Correct', 'true', 1.00);
INSERT INTO "public"."answer_of_question" VALUES ('63b158bf-6c48-4c9d-bf58-e237ade8b990', '4a8afa92-ad7c-4bd4-8bfc-d699f616a80d', 'Correct', 'true', 1.00);
INSERT INTO "public"."answer_of_question" VALUES ('29d5f2d0-e448-4687-b6e2-cb068248b263', '1592dc84-c95f-45d6-9a65-6c1ac5e2e413', 'Correct', 'false', 1.00);
INSERT INTO "public"."answer_of_question" VALUES ('fd776b92-4530-4f5c-bd5e-7dcacc6397b8', '9de30d16-41ac-4451-9947-2b2088dd6afa', '<p>Đóng gói là cơ chế ẩn giấu dữ liệu của một đối tượng và chỉ cho phép truy cập thông qua các phương thức của đối tượng đó.</p>', 'Đóng gói là cơ chế ẩn giấu dữ liệu của một đối tượng và chỉ cho phép truy cập thông qua các phương thức của đối tượng đó.', 1.00);
INSERT INTO "public"."answer_of_question" VALUES ('71db4b92-d4c1-4f50-9146-eb2227144723', '8de957d4-92df-4f94-997b-1e1275afdc2f', '<p>Kế thừa (Inheritance)</p>', '<p>Kế thừa (Inheritance)</p>', 0.00);
INSERT INTO "public"."answer_of_question" VALUES ('ae4e6e70-1ffd-46ba-b2fd-cb23a9a25cf6', '8de957d4-92df-4f94-997b-1e1275afdc2f', '<p>Đa hình (Polymorphism)</p>', '<p>Đa hình (Polymorphism)</p>', 0.00);
INSERT INTO "public"."answer_of_question" VALUES ('ecb79aab-c247-4559-aaa4-81adb366543b', '8de957d4-92df-4f94-997b-1e1275afdc2f', '<p>Biến toàn cục (Global Variable)</p>', '<p>Biến toàn cục (Global Variable)</p>', 1.00);
INSERT INTO "public"."answer_of_question" VALUES ('df670dd3-b304-4de7-9c49-435a5f1bfacf', '8de957d4-92df-4f94-997b-1e1275afdc2f', '<p>Đóng gói (Encapsulation)</p>', '<p>Đóng gói (Encapsulation)</p>', 0.00);
INSERT INTO "public"."answer_of_question" VALUES ('3f6cad54-a123-46a0-a12a-ccf3f5f380c0', 'b387b570-5b99-4f82-83be-292c969db99f', '<p>Đóng gói (Encapsulation)</p>', '<p>Đóng gói (Encapsulation)</p>', 0.00);
INSERT INTO "public"."answer_of_question" VALUES ('c58fb769-3574-44e2-8b88-0291d533df93', 'b387b570-5b99-4f82-83be-292c969db99f', '<p>Trừu tượng hóa (Abstraction)</p>', '<p>Trừu tượng hóa (Abstraction)</p>', 0.00);
INSERT INTO "public"."answer_of_question" VALUES ('2f204fe1-a67f-46e2-9837-0472cd4d6850', 'b387b570-5b99-4f82-83be-292c969db99f', '<p>Kế thừa (Inheritance)</p>', '<p>Kế thừa (Inheritance)</p>', 1.00);
INSERT INTO "public"."answer_of_question" VALUES ('d02d7a22-6e1a-488e-bb4d-1f3f474ebf3e', 'b387b570-5b99-4f82-83be-292c969db99f', '<p>Đa hình (Polymorphism)</p>', '<p>Đa hình (Polymorphism)</p>', 0.00);
INSERT INTO "public"."answer_of_question" VALUES ('4ae4f038-ec55-410f-b12e-b346941e9e99', '4fa387a6-db86-48bb-85f4-fcbb43c8eeb0', 'Correct', 'true', 1.00);
INSERT INTO "public"."answer_of_question" VALUES ('dce5ee63-4384-4547-a4a7-38236009be0d', 'b48fbf09-4b3f-4def-bfb8-4cfb65da1f27', 'Correct', 'false', 1.00);
INSERT INTO "public"."answer_of_question" VALUES ('dac69827-303a-4a11-b46f-698be40c73b7', 'c5e675a1-50a3-400c-a232-968413d0ebf2', 'Correct', 'true', 1.00);
INSERT INTO "public"."answer_of_question" VALUES ('69e8c753-bf53-42dd-8ae5-68b771fb51f3', '306eaa8b-4054-4ad7-b6ed-b847a2d53b63', 'Correct', 'true', 1.00);
INSERT INTO "public"."answer_of_question" VALUES ('d2c9bb4b-a8d7-4e59-9602-34ea079e4de1', '1f0daa04-6462-4eb5-9fc4-883f68e78b7c', '<p>Giải thuật là một tập hợp các bước cụ thể và hữu hạn để giải quyết một vấn đề hoặc thực hiện một tác vụ.</p>', 'Giải thuật là một tập hợp các bước cụ thể và hữu hạn để giải quyết một vấn đề hoặc thực hiện một tác vụ.', 1.00);
INSERT INTO "public"."answer_of_question" VALUES ('f3d13cab-0d0d-48bf-8c32-a83699bd38c0', '1c054e46-a127-448d-a6a8-8c9be65cfded', '<p>Danh sách liên kết đơn (Singly Linked List)</p>', '<p>Danh sách liên kết đơn (Singly Linked List)</p>', 0.00);
INSERT INTO "public"."answer_of_question" VALUES ('6fbe5289-62a6-49ff-baaa-c524466d8966', '1c054e46-a127-448d-a6a8-8c9be65cfded', '<p>Danh sách liên kết kép (Doubly Linked List)</p>', '<p>Danh sách liên kết kép (Doubly Linked List)</p>', 1.00);
INSERT INTO "public"."answer_of_question" VALUES ('e0b84f6f-ad13-4016-9bd1-d9938c400673', '1c054e46-a127-448d-a6a8-8c9be65cfded', '<p>Danh sách liên kết vòng (Circular Linked List)</p>', '<p>Danh sách liên kết vòng (Circular Linked List)</p>', 0.00);
INSERT INTO "public"."answer_of_question" VALUES ('2846c9af-6b6d-45ac-8b6a-61bf797df9ef', '1c054e46-a127-448d-a6a8-8c9be65cfded', '<p>Mảng (Array)</p>', '<p>Mảng (Array)</p>', 0.00);
INSERT INTO "public"."answer_of_question" VALUES ('2463db37-999f-49ec-a684-bee2e66aed95', 'c88dfd4d-b102-4412-9127-17d68ec3a5e1', '<p>Danh sách liên kết đơn</p>', '<p>Danh sách liên kết đơn</p>', 0.00);
INSERT INTO "public"."answer_of_question" VALUES ('d4539ec8-38ac-4af1-b8df-b977eac039dd', 'c88dfd4d-b102-4412-9127-17d68ec3a5e1', '<p>Danh sách liên kết kép</p>', '<p>Danh sách liên kết kép</p>', 0.00);
INSERT INTO "public"."answer_of_question" VALUES ('2116d00c-caa5-4ef4-87d7-5021d2c7883b', 'c88dfd4d-b102-4412-9127-17d68ec3a5e1', '<p>Mảng đã sắp xếp</p>', '<p>Mảng đã sắp xếp</p>', 1.00);
INSERT INTO "public"."answer_of_question" VALUES ('48d6b372-b486-4f09-a89b-cdae884b6a5f', 'c88dfd4d-b102-4412-9127-17d68ec3a5e1', '<p>Mảng chưa sắp xếp</p>', '<p>Mảng chưa sắp xếp</p>', 0.00);
INSERT INTO "public"."answer_of_question" VALUES ('7cbe35b2-8f0e-4131-9ac0-427e583fe88c', 'eb74ae25-bfd1-4c3c-8d19-f29872f6b858', 'Correct', 'true', 1.00);
INSERT INTO "public"."answer_of_question" VALUES ('b4f62a78-805e-4377-9ef5-ba0e54c61355', '9002af16-7252-421a-b8ab-c0f4944a1e89', 'Correct', 'false', 1.00);
INSERT INTO "public"."answer_of_question" VALUES ('166b2711-8d26-4cc3-8ea6-9a8281467b50', 'a411cc44-f924-445c-bd00-f605f7533dcf', 'Correct', 'true', 1.00);
INSERT INTO "public"."answer_of_question" VALUES ('520f3d3a-b639-490f-9ffd-1f4089e30033', '05d5cd7c-968b-49a6-acf3-c839f2d04243', 'Correct', 'true', 1.00);
INSERT INTO "public"."answer_of_question" VALUES ('f7f6b8b7-36df-4d7c-b06c-20abb78b5173', '4faf36f7-aa0b-43db-b830-aff5c0337996', '<p>Con trỏ là một biến lưu trữ địa chỉ của một biến khác trong bộ nhớ.</p>', 'Con trỏ là một biến lưu trữ địa chỉ của một biến khác trong bộ nhớ.', 1.00);
INSERT INTO "public"."answer_of_question" VALUES ('33ae0d75-a406-4ead-b30e-5f07931668b1', '175441dd-3023-480a-880a-4b9a93570c1d', '<p>struct</p>', '<p>struct</p>', 0.00);
INSERT INTO "public"."answer_of_question" VALUES ('66beaffa-b41a-4618-8541-e2cd599c9272', '175441dd-3023-480a-880a-4b9a93570c1d', '<p>class</p>', '<p>class</p>', 1.00);
INSERT INTO "public"."answer_of_question" VALUES ('188bcd0c-e9ef-4384-affa-48d162f37545', '175441dd-3023-480a-880a-4b9a93570c1d', '<p>union</p>', '<p>union</p>', 0.00);
INSERT INTO "public"."answer_of_question" VALUES ('508df0ac-fd12-4041-9f74-b12966d7a79d', '175441dd-3023-480a-880a-4b9a93570c1d', '<p>namespace</p>', '<p>namespace</p>', 0.00);
INSERT INTO "public"."answer_of_question" VALUES ('532ac08e-800b-493e-b5e6-532070921a8c', '4981ef9b-2355-4ee7-acb6-6f72d549f50d', '<p>delete</p>', '<p>delete</p>', 1.00);
INSERT INTO "public"."answer_of_question" VALUES ('66527d50-7123-436b-9866-9505c9596df5', '4981ef9b-2355-4ee7-acb6-6f72d549f50d', '<p>free</p>', '<p>free</p>', 0.00);
INSERT INTO "public"."answer_of_question" VALUES ('60c2751d-72c5-4fea-b8f9-5f58256ca9dc', '4981ef9b-2355-4ee7-acb6-6f72d549f50d', '<p>malloc</p>', '<p>malloc</p>', 0.00);
INSERT INTO "public"."answer_of_question" VALUES ('230eb79e-3be9-4336-b315-800c7b2a8ee4', '4981ef9b-2355-4ee7-acb6-6f72d549f50d', '<p>new</p>', '<p>new</p>', 0.00);
INSERT INTO "public"."answer_of_question" VALUES ('180f1ed6-3079-469f-a313-f6707220dbb3', '643c9a5f-c96e-4a1a-be18-0c3758002e3d', 'Correct', 'true', 1.00);
INSERT INTO "public"."answer_of_question" VALUES ('687afdf5-90d8-4e74-83ca-d3b0fa2ac68e', 'd0470328-32a5-4b28-8dd6-49a8c3a0b9c4', 'Correct', 'true', 1.00);
INSERT INTO "public"."answer_of_question" VALUES ('9ca6ac06-c9f8-4873-a7ee-9f9dcfc82ff0', 'ce2dda6f-1448-4cf8-932e-17deedee80a6', 'Correct', 'true', 1.00);
INSERT INTO "public"."answer_of_question" VALUES ('d2207c09-ece6-4453-87a6-72a70d947933', '886e4b8a-6c84-40ee-8b16-d80ffdd06f8b', 'Correct', 'false', 1.00);
INSERT INTO "public"."answer_of_question" VALUES ('d87f8b5d-0b39-4a25-96d3-03389e6bfe3b', 'bfece9c7-3f02-43e1-bb7e-4317b3658641', '<p><code>==</code> so sánh địa chỉ bộ nhớ của hai đối tượng, còn <code>equals()</code> so sánh nội dung của hai đối tượng.</p>', ' == so sánh địa chỉ bộ nhớ của hai đối tượng, còn equals() so sánh nội dung của hai đối tượng.', 1.00);
INSERT INTO "public"."answer_of_question" VALUES ('37e75761-3d6d-465a-aadc-ef3f450577b2', 'd6b8b467-f21a-4957-a58f-ad58c4015b2e', 'Correct', 'true', 1.00);
INSERT INTO "public"."answer_of_question" VALUES ('a54485ae-3e69-4c35-80fe-8b378c7b3677', 'f1de8ed8-5721-4260-b019-d3ae2852f048', 'Correct', 'true', 1.00);
INSERT INTO "public"."answer_of_question" VALUES ('0a255d54-c5f6-4845-b712-8aa5674d82c0', '56aa0b87-83b7-42cf-9e90-0f075ad8c53b', 'Correct', 'true', 1.00);
INSERT INTO "public"."answer_of_question" VALUES ('43ab2d6b-a60f-4b3b-8a08-7bbab52daf19', 'b0edc4d7-713a-48df-a9a7-8a8b411c3379', 'Correct', 'false', 1.00);

-- ----------------------------
-- Table structure for course_type

-- ----------------------------
-- Records of course_type
-- ----------------------------
INSERT INTO "public"."course_type" VALUES ('c18999a8-df4b-4690-8342-a254c66a5929', 4, 'CHƯƠNG TRÌNH CHẤT LƯỢNG CAO (CLC)', '08b65a39-394f-4977-a5fa-3fe145b620f8');
INSERT INTO "public"."course_type" VALUES ('56b844c6-b59a-4135-b028-f8b1a7b68eea', 3, 'CHƯƠNG TRÌNH TIÊN TIẾN (APCS)', '08b65a39-394f-4977-a5fa-3fe145b620f8');
INSERT INTO "public"."course_type" VALUES ('9990d63b-dc4d-4c2d-86b8-bf47fc2f5ba9', 5, 'CHƯƠNG TRÌNH VIỆT PHÁP (CTVP)', '08b65a39-394f-4977-a5fa-3fe145b620f8');

INSERT INTO "public"."course" VALUES ('983942d9-3366-4004-9f9a-c4e7e7760cc0', NULL, 'c18999a8-df4b-4690-8342-a254c66a5929', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Nhập môn lập trình', 't', '2024-06-04 19:54:28.102871+07', '2024-06-04 19:54:28.102871+07');
INSERT INTO "public"."course" VALUES ('c061d55e-a8b0-433f-b6a3-ae9d5601422e', NULL, '56b844c6-b59a-4135-b028-f8b1a7b68eea', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Cấu trúc dữ liệu và giải thuật', 't', '2024-06-04 19:54:28.123993+07', '2024-06-04 19:54:28.12405+07');
INSERT INTO "public"."course" VALUES ('62943cbb-5bc5-4cef-b9a9-e33c82ecf984', NULL, 'c18999a8-df4b-4690-8342-a254c66a5929', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Khóa học lập trình Python', 't', '2024-06-04 19:54:28.136606+07', '2024-06-04 19:54:28.136606+07');
INSERT INTO "public"."course" VALUES ('0888fabf-acd7-4ffa-9978-51558e5a0ee1', NULL, '56b844c6-b59a-4135-b028-f8b1a7b68eea', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Kỹ thuật lập trình', 't', '2024-06-04 19:54:28.148098+07', '2024-06-04 19:54:28.148098+07');
INSERT INTO "public"."course" VALUES ('c31382b2-2fbd-43ae-89de-12b6614fc8ab', NULL, '56b844c6-b59a-4135-b028-f8b1a7b68eea', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'HEHE', 't', '2024-06-04 19:54:28.161833+07', '2024-06-04 19:54:28.161833+07');
INSERT INTO "public"."course" VALUES ('f2c54cc7-41e1-4567-9c2c-47eb5b4ab153', 2, 'c18999a8-df4b-4690-8342-a254c66a5929', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Nhập môn lập trình - 20CLC01', 't', '2024-08-04 14:16:57.920953+07', '2024-08-04 14:16:57.920953+07');
INSERT INTO "public"."course" VALUES ('2478cb4a-0fc7-4bf4-a50c-e8f05c2aaa13', 8, 'c18999a8-df4b-4690-8342-a254c66a5929', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Nhập môn lập trình - 20CLC03', 't', '2024-08-04 14:16:57.932887+07', '2024-08-04 14:16:57.932887+07');
INSERT INTO "public"."course" VALUES ('a7a2fd76-64cf-41e1-be53-0ebc172b605a', 9, 'c18999a8-df4b-4690-8342-a254c66a5929', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Kỹ thuật lập trình - 20CLC01', 't', '2024-08-04 14:16:57.944491+07', '2024-08-04 14:16:57.944491+07');
INSERT INTO "public"."course" VALUES ('9cf07484-c7b4-453c-acd7-e763f3ccc98f', 10, 'c18999a8-df4b-4690-8342-a254c66a5929', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Kỹ thuật lập trình - 20CLC02', 't', '2024-08-04 14:16:57.955343+07', '2024-08-04 14:16:57.955343+07');
INSERT INTO "public"."course" VALUES ('a388ef91-e5ce-45ec-becb-c6cc54b4e616', 11, 'c18999a8-df4b-4690-8342-a254c66a5929', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Kỹ thuật lập trình - 20CLC03', 't', '2024-08-04 14:16:57.964345+07', '2024-08-04 14:16:57.964345+07');
INSERT INTO "public"."course" VALUES ('4076715f-9263-494e-8dbf-7a9024c9aa30', 12, 'c18999a8-df4b-4690-8342-a254c66a5929', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Cấu trúc dữ liệu &amp; giải thuật - 20CLC01', 't', '2024-08-04 14:16:57.972812+07', '2024-08-04 14:16:57.972812+07');
INSERT INTO "public"."course" VALUES ('0ab93253-b022-4706-8e47-75934c3f084c', 13, 'c18999a8-df4b-4690-8342-a254c66a5929', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Cấu trúc dữ liệu &amp; giải thuật - 20CLC02', 't', '2024-08-04 14:16:57.981762+07', '2024-08-04 14:16:57.981762+07');
INSERT INTO "public"."course" VALUES ('802b5d84-e898-4077-b2d2-45a04d17e4e4', 14, 'c18999a8-df4b-4690-8342-a254c66a5929', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Cấu trúc dữ liệu &amp; giải thuật - 20CLC03', 't', '2024-08-04 14:16:57.989093+07', '2024-08-04 14:16:57.989093+07');
INSERT INTO "public"."course" VALUES ('28cb6008-bddc-4894-83de-7919a02db956', 15, '56b844c6-b59a-4135-b028-f8b1a7b68eea', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Nhập môn lập trình - 20CTTT01', 't', '2024-08-04 14:16:57.995321+07', '2024-08-04 14:16:57.995321+07');
INSERT INTO "public"."course" VALUES ('2b549267-2f56-4fa1-ba24-bdebc6b7e89c', 16, '56b844c6-b59a-4135-b028-f8b1a7b68eea', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Nhập môn lập trình - 20CTTT02', 't', '2024-08-04 14:16:58.001302+07', '2024-08-04 14:16:58.001302+07');
INSERT INTO "public"."course" VALUES ('5aa6ffd0-b35b-41c0-8bdd-9c618c27579e', 17, '56b844c6-b59a-4135-b028-f8b1a7b68eea', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Nhập môn lập trình - 20CTTT03', 't', '2024-08-04 14:16:58.010184+07', '2024-08-04 14:16:58.010184+07');
INSERT INTO "public"."course" VALUES ('45b7f477-0ce1-4b46-bccb-5f80b508da35', 18, '56b844c6-b59a-4135-b028-f8b1a7b68eea', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Kỹ thuật lập trình - 20CTTT01', 't', '2024-08-04 14:16:58.017502+07', '2024-08-04 14:16:58.017502+07');
INSERT INTO "public"."course" VALUES ('547b7170-078e-4d3a-a702-178d22490cf9', 19, '56b844c6-b59a-4135-b028-f8b1a7b68eea', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Kỹ thuật lập trình - 20CTTT02', 't', '2024-08-04 14:16:58.024892+07', '2024-08-04 14:16:58.024892+07');
INSERT INTO "public"."course" VALUES ('6c1be796-e383-4344-80eb-1d24392eb0a8', 20, '56b844c6-b59a-4135-b028-f8b1a7b68eea', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Kỹ thuật lập trình - 20CTTT03', 't', '2024-08-04 14:16:58.030943+07', '2024-08-04 14:16:58.030943+07');
INSERT INTO "public"."course" VALUES ('e2559476-b848-4bae-bce9-fdcbdf95c2e7', 21, '56b844c6-b59a-4135-b028-f8b1a7b68eea', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Cấu trúc dữ liệu &amp; giải thuật - 20CTTT01', 't', '2024-08-04 14:16:58.036369+07', '2024-08-04 14:16:58.036369+07');
INSERT INTO "public"."course" VALUES ('f4eaeacd-e560-4839-a473-e92e7197a8bb', 22, '56b844c6-b59a-4135-b028-f8b1a7b68eea', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Cấu trúc dữ liệu &amp; giải thuật - 20CTTT02', 't', '2024-08-04 14:16:58.041369+07', '2024-08-04 14:16:58.041369+07');
INSERT INTO "public"."course" VALUES ('10d4cf23-afb3-448b-be5f-893dc4058444', 23, '56b844c6-b59a-4135-b028-f8b1a7b68eea', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Cấu trúc dữ liệu &amp; giải thuật - 20CTTT03', 't', '2024-08-04 14:16:58.047942+07', '2024-08-04 14:16:58.047942+07');
INSERT INTO "public"."course" VALUES ('a9946969-f2a0-461d-a6e5-9de47426d352', 24, '9990d63b-dc4d-4c2d-86b8-bf47fc2f5ba9', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Nhập môn lập trình - 20VP01', 't', '2024-08-04 14:16:58.054238+07', '2024-08-04 14:16:58.054238+07');
INSERT INTO "public"."course" VALUES ('f8c020b8-5eae-491e-83b7-e8327b6f5ec9', 25, '9990d63b-dc4d-4c2d-86b8-bf47fc2f5ba9', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Nhập môn lập trình - 20VP02', 't', '2024-08-04 14:16:58.060255+07', '2024-08-04 14:16:58.060255+07');
INSERT INTO "public"."course" VALUES ('c6d45de3-900b-4ac5-b080-de222ac3bebd', 26, '9990d63b-dc4d-4c2d-86b8-bf47fc2f5ba9', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Nhập môn lập trình - 20VP03', 't', '2024-08-04 14:16:58.06794+07', '2024-08-04 14:16:58.06794+07');
INSERT INTO "public"."course" VALUES ('8b5ab515-a9ab-4e9f-a9c4-efe58c6970f7', 27, '9990d63b-dc4d-4c2d-86b8-bf47fc2f5ba9', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Kỹ thuật lập trình - 20VP01', 't', '2024-08-04 14:16:58.074345+07', '2024-08-04 14:16:58.074345+07');
INSERT INTO "public"."course" VALUES ('d34ea986-3f58-4947-81fa-2a67cc57818f', 28, '9990d63b-dc4d-4c2d-86b8-bf47fc2f5ba9', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Kỹ thuật lập trình - 20VP02', 't', '2024-08-04 14:16:58.080908+07', '2024-08-04 14:16:58.080908+07');
INSERT INTO "public"."course" VALUES ('c52c2f4c-b403-47f3-a22c-4c14c4528b9d', 29, '9990d63b-dc4d-4c2d-86b8-bf47fc2f5ba9', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Kỹ thuật lập trình - 20VP03', 't', '2024-08-04 14:16:58.088718+07', '2024-08-04 14:16:58.088718+07');
INSERT INTO "public"."course" VALUES ('48a4d599-9cda-4301-8a4c-5b72ca78ee8d', 30, '9990d63b-dc4d-4c2d-86b8-bf47fc2f5ba9', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Cấu trúc dữ liệu &amp; giải thuật - 20VP01', 't', '2024-08-04 14:16:58.096408+07', '2024-08-04 14:16:58.096408+07');
INSERT INTO "public"."course" VALUES ('59c2efd4-a0a7-4d95-8fb1-455a7fb413c6', 31, '9990d63b-dc4d-4c2d-86b8-bf47fc2f5ba9', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Cấu trúc dữ liệu &amp; giải thuật - 20VP02', 't', '2024-08-04 14:16:58.103794+07', '2024-08-04 14:16:58.103794+07');
INSERT INTO "public"."course" VALUES ('30fc358d-b78f-40cb-ad67-51ca279e649b', 32, '9990d63b-dc4d-4c2d-86b8-bf47fc2f5ba9', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Cấu trúc dữ liệu &amp; giải thuật - 20VP03', 't', '2024-08-04 14:16:58.111222+07', '2024-08-04 14:16:58.111222+07');
INSERT INTO "public"."course" VALUES ('eb71854b-2850-45e0-bece-7728aaecb035', 34, 'c18999a8-df4b-4690-8342-a254c66a5929', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'Nhập môn lập trình - 20CLC02', 't', '2024-08-04 14:16:58.118166+07', '2024-08-04 14:16:58.118166+07');

INSERT INTO "public"."assignment" VALUES ('577e118d-604b-450c-a02c-cf8e9f35f8ee', 3, '983942d9-3366-4004-9f9a-c4e7e7760cc0', 'Đây là bài tập 11', '<p dir="ltr" style="text-align: left;">Bì tập 11</p>', NULL, NULL, '40', '40000', 't', 100, '2024-05-06 00:00:00+07', '2024-05-13 00:00:00+07', '1970-01-01 07:00:00+07', 'FILE', 'f', '2024-08-04 14:14:27.624143+07');
INSERT INTO "public"."assignment" VALUES ('b1b3e215-2450-4819-9aa6-3aea9f87e604', 2, 'c061d55e-a8b0-433f-b6a3-ae9d5601422e', 'bài tập 2', '<p dir="ltr" style="text-align: left;">Đây là bai tap 2</p>', NULL, NULL, '40', '40000', 't', 100, '2024-05-06 00:00:00+07', '2024-05-13 00:00:00+07', '1970-01-01 07:00:00+07', 'FILE', 'f', '2024-08-04 14:14:27.624143+07');
INSERT INTO "public"."assignment" VALUES ('f37edb09-e0f6-4e96-8469-d6eff5378c9d', 4, 'c061d55e-a8b0-433f-b6a3-ae9d5601422e', 'bài tập cuối', '<p dir="ltr" style="text-align: left;">mô tả bài tập</p>', NULL, NULL, '40', '40000', 't', 100, '2024-05-08 17:16:00+07', '2024-05-17 18:19:00+07', '1970-01-01 07:00:00+07', 'FILE', 'f', '2024-08-04 14:14:27.624143+07');
INSERT INTO "public"."assignment" VALUES ('3926bcb3-6415-458d-b449-6e2b464732d7', 5, 'c061d55e-a8b0-433f-b6a3-ae9d5601422e', 'bài online tết', '<p dir="ltr" style="text-align: left;">mô tả bài tập cuối</p>', NULL, NULL, '40', '40000', 't', 100, '2024-05-06 00:00:00+07', '2024-05-13 00:00:00+07', '1970-01-01 07:00:00+07', 'BOTH', 'f', '2024-08-04 14:14:27.624143+07');
INSERT INTO "public"."assignment" VALUES ('8c6d9aa1-f157-49ca-bfae-bc8a14570c81', 6, 'c061d55e-a8b0-433f-b6a3-ae9d5601422e', 'Bài tập 1', '<p dir="ltr" style="text-align: left;">>mô tả bài tập</p>', NULL, NULL, '40', '40000', 't', 100, '2024-05-06 00:00:00+07', '2024-05-13 00:00:00+07', '1970-01-01 07:00:00+07', 'FILE', 'f', '2024-08-04 14:14:27.624143+07');
INSERT INTO "public"."assignment" VALUES ('124c9619-cd26-43fb-8ea4-610b164925ad', 7, 'c061d55e-a8b0-433f-b6a3-ae9d5601422e', 'hehe', '<p dir="ltr" style="text-align: left;">>mô tả bài tập</p>', NULL, NULL, '40', '40000', 't', 100, '2024-05-06 00:00:00+07', '2024-05-13 00:00:00+07', '1970-01-01 07:00:00+07', 'BOTH', 'f', '2024-08-04 14:14:27.624143+07');
INSERT INTO "public"."assignment" VALUES ('fbe31ca6-ddc9-49ef-87f3-c472958a52c0', 8, 'c061d55e-a8b0-433f-b6a3-ae9d5601422e', 'Bài tập 10', '<p dir="ltr" style="text-align: left;">Mô tả bài tập 10</p>', NULL, NULL, '40', '40000', 't', 100, '2024-05-06 00:00:00+07', '2024-05-13 00:00:00+07', '1970-01-01 07:00:00+07', 'TEXT_ONLINE', 'f', '2024-08-04 14:14:27.624143+07');
INSERT INTO "public"."assignment" VALUES ('0ffc63bf-c1b9-4676-9612-65ab6a24ce5b', 10, 'c061d55e-a8b0-433f-b6a3-ae9d5601422e', 'Bài tập module', '<p dir="ltr" style="text-align: left;">đây là bài tập module</p>', NULL, NULL, '40', '40000', 't', 100, '2024-05-12 00:00:00+07', '2024-05-19 00:00:00+07', '1970-01-01 07:00:00+07', 'FILE', 'f', '2024-08-04 14:14:27.624143+07');
INSERT INTO "public"."assignment" VALUES ('438413fa-ac31-496a-becb-709505ea990a', 9, '62943cbb-5bc5-4cef-b9a9-e33c82ecf984', 'bài 1', '<p dir="ltr" style="text-align: left;">Đây là bài 1</p>', NULL, NULL, '40', '40000', 't', 100, '2024-05-07 00:00:00+07', '2024-05-14 00:00:00+07', '1970-01-01 07:00:00+07', 'FILE', 'f', '2024-08-04 14:14:27.624143+07');
INSERT INTO "public"."assignment" VALUES ('7055f5fd-29ce-48f9-b1d1-cd11a95ce931', 11, '62943cbb-5bc5-4cef-b9a9-e33c82ecf984', 'Bài tập 2', '<p dir="ltr" style="text-align: left;"></p><p dir="ltr">Viết hàm main: Cho trước 3 biến ngày tháng năm</p><p dir="ltr">int day = 9;</p><p dir="ltr">int month = 10;</p><p dir="ltr">int year = 2023;</p><p dir="ltr">Nếu ba biến này tạo thành ngày tháng năm hợp lệ thì in ra ngày kế.</p><p dir="ltr">Nộp lại mã nguồn sử dụng Visual Studio hoặc nộp link onlinegdb.com</p><p dir="ltr">Thực hiện nhóm 1-3 người.</p><br><p></p>', NULL, NULL, '40', '40000', 't', 100, '2024-05-22 00:00:00+07', '2024-05-29 00:00:00+07', '1970-01-01 07:00:00+07', 'FILE', 'f', '2024-08-04 14:14:27.624143+07');
INSERT INTO "public"."assignment" VALUES ('b3108f5a-c769-42ab-84c9-80a6d80f5821', 13, '62943cbb-5bc5-4cef-b9a9-e33c82ecf984', 'Bài tập 3', '<p dir="ltr" style="text-align: left;"><a href="http://62.171.185.208/webservice/pluginfile.php/67/mod_assign/intro/assignment.svg">http://62.171.185.208/webservice/pluginfile.php/67/mod_assign/intro/assignment.svg</a><br></p>', '<p dir="ltr" style="text-align:left;"><a href="http://62.171.185.208/webservice/pluginfile.php/67/mod_assign/activityattachment/0/2024-04-28T06-36%20Giao%20d%E1%BB%87%20%C4%91%E1%BB%99ng%20file%20Image.svg">2024-04-28T06-36 Giao d%E1%BB%87%20%C4%91%E1%BB%99ng%20file%20Image.svg</a></p>', NULL, '40', '40000', 't', 100, '2024-05-25 00:00:00+07', '2024-06-02 00:00:00+07', '1970-01-01 07:00:00+07', 'FILE', 'f', '2024-08-04 14:14:27.624143+07');
INSERT INTO "public"."assignment" VALUES ('5b82b228-aef2-494f-8622-2be74966106d', 14, '62943cbb-5bc5-4cef-b9a9-e33c82ecf984', 'Bài tập 4', '', '<p dir="ltr" style="text-align:left;"></p><p dir="ltr">Viết hàm main: Cho trước 3 biến ngày tháng năm</p><p dir="ltr">int day = 9;</p><p dir="ltr">int month = 10;</p><p dir="ltr">int year = 2023;</p><p dir="ltr">Nếu ba biến này tạo thành ngày tháng năm hợp lệ thì in ra ngày kế.</p><p dir="ltr">Nộp lại mã nguồn sử dụng Visual Studio hoặc nộp link onlinegdb.com</p><p dir="ltr">Thực hiện nhóm 1-3 người.</p><br /><p></p>', NULL, '40', '40000', 't', 100, '2024-05-22 00:00:00+07', '2024-05-29 00:00:00+07', '1970-01-01 07:00:00+07', 'FILE', 'f', '2024-08-04 14:14:27.624143+07');
INSERT INTO "public"."assignment" VALUES ('56f0980c-3944-40b1-9cb6-1b9b46891de6', 15, '62943cbb-5bc5-4cef-b9a9-e33c82ecf984', 'bt 5', 'bt 3', NULL, NULL, '40', '40000', 't', 100, '2024-05-28 00:00:00+07', '2024-06-04 00:00:00+07', '1970-01-01 07:00:00+07', 'FILE', 'f', '2024-08-04 14:14:27.624143+07');
INSERT INTO "public"."assignment" VALUES ('e1a6c218-1a45-4d2e-9020-1f3e8d5f098c', 16, 'c061d55e-a8b0-433f-b6a3-ae9d5601422e', 'Câu hỏi lập trình 1', '<p dir="ltr" style="text-align: left;">Giải thích khái niệm "biến" trong lập trình và các loại biến phổ biến.</p>', NULL, NULL, '40', '40000', 't', 100, '2024-07-01 00:00:00+07', '2024-07-08 00:00:00+07', '1970-01-01 07:00:00+07', 'TEXT_ONLINE', 'f', '2024-08-04 14:14:27.624143+07');
INSERT INTO "public"."assignment" VALUES ('b24d3df4-3f8e-4d23-b18f-8d82ff37cda9', 17, 'c061d55e-a8b0-433f-b6a3-ae9d5601422e', 'Câu hỏi lập trình 2', '<p dir="ltr" style="text-align: left;">Trình bày sự khác biệt giữa "hàm" và "phương thức" trong lập trình.</p>', NULL, NULL, '40', '40000', 't', 100, '2024-07-01 00:00:00+07', '2024-07-08 00:00:00+07', '1970-01-01 07:00:00+07', 'TEXT_ONLINE', 'f', '2024-08-04 14:14:27.624143+07');
INSERT INTO "public"."assignment" VALUES ('f58e95a8-799c-4d2e-b5f3-d9b9d5566eec', 18, 'c061d55e-a8b0-433f-b6a3-ae9d5601422e', 'Câu hỏi lập trình 3', '<p dir="ltr" style="text-align: left;">Mô tả các kiểu dữ liệu cơ bản trong lập trình và ví dụ cho từng loại.</p>', NULL, NULL, '40', '40000', 't', 100, '2024-07-01 00:00:00+07', '2024-07-08 00:00:00+07', '1970-01-01 07:00:00+07', 'TEXT_ONLINE', 'f', '2024-08-04 14:14:27.624143+07');
INSERT INTO "public"."assignment" VALUES ('c12f49db-074f-4e5c-9c19-9dffcdf9a6b4', 19, 'c061d55e-a8b0-433f-b6a3-ae9d5601422e', 'Câu hỏi lập trình 4', '<p dir="ltr" style="text-align: left;">Nêu các nguyên lý lập trình hướng đối tượng và giải thích từng nguyên lý.</p>', NULL, NULL, '40', '40000', 't', 100, '2024-07-01 00:00:00+07', '2024-07-08 00:00:00+07', '1970-01-01 07:00:00+07', 'TEXT_ONLINE', 'f', '2024-08-04 14:14:27.624143+07');
INSERT INTO "public"."assignment" VALUES ('9f657578-ee3a-445a-a065-d656f6e056de', NULL, 'c061d55e-a8b0-433f-b6a3-ae9d5601422e', 'Câu hỏi lập trình 4', '<p dir="ltr" style="text-align: left;">Nêu các nguyên lý lập trình hướng đối tượng và giải thích từng nguyên lý.</p>', NULL, NULL, '40', '40000', 't', 100, '2024-07-01 00:00:00+07', '2024-07-08 00:00:00+07', '1970-01-01 07:00:00+07', 'TEXT_ONLINE', 'f', '2024-08-04 14:14:27.624143+07');
INSERT INTO "public"."assignment" VALUES ('a3ef363c-6043-4084-be7e-3562f91bbf54', 61, 'f2c54cc7-41e1-4567-9c2c-47eb5b4ab153', 'Link nộp bài tuần 01 (đặt tiêu đề bài nộp MSSV1_MSSV2_..._MSSVn.cpp)', '', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-01 00:00:00+07', '2024-08-08 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:26.975103+07');
INSERT INTO "public"."assignment" VALUES ('25940ad0-3f73-45b3-94b7-4eefd2fc38fb', 62, 'f2c54cc7-41e1-4567-9c2c-47eb5b4ab153', 'Link nộp bài tuần 02 (đặt tiêu đề bài nộp MSSV1_MSSV2_..._MSSVn.cpp)', '', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-08 00:00:00+07', '2024-08-16 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:27.333414+07');
INSERT INTO "public"."assignment" VALUES ('433922df-240f-4272-b73c-c900aa33d111', 63, 'f2c54cc7-41e1-4567-9c2c-47eb5b4ab153', 'Link nộp bài tuần 03 (đặt tiêu đề bài nộp MSSV1_MSSV2_..._MSSVn.cpp)', '', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-16 00:00:00+07', '2024-08-24 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:27.677189+07');
INSERT INTO "public"."assignment" VALUES ('9ba90f72-6bc4-463f-a3c8-a5d530039aa0', 64, 'f2c54cc7-41e1-4567-9c2c-47eb5b4ab153', 'Link nộp bài tuần 04 (đặt tiêu đề bài nộp MSSV1_MSSV2_..._MSSVn.cpp)', '', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-24 00:00:00+07', '2024-09-08 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:27.963137+07');
INSERT INTO "public"."assignment" VALUES ('4b4f6b35-69ae-449b-8c3b-0573c35ae959', 65, 'f2c54cc7-41e1-4567-9c2c-47eb5b4ab153', 'H01 (YY: 10)', '<p dir="ltr" style="text-align: left;"><a href="https://drive.google.com/drive/folders/1GZZ-xIJTp7y7Atu9EMmtvRhkY3sxghwT">W01-Algorithm - Google Drive</a><br></p>', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-01 00:00:00+07', '2024-08-08 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:28.226664+07');
INSERT INTO "public"."assignment" VALUES ('c1f2b086-121b-4ec1-8738-1d697f63a925', 66, 'f2c54cc7-41e1-4567-9c2c-47eb5b4ab153', 'H02 (YY: 10)', '<p dir="ltr" style="text-align: left;"><a href="https://drive.google.com/drive/folders/1KQbFYpKSr_5e6XDc97PgdRrGlEqkXWnQ">W02-Input Output Statement - Google Drive</a><br></p>', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-08 00:00:00+07', '2024-08-16 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:28.489252+07');
INSERT INTO "public"."assignment" VALUES ('2a6d3dde-d04e-42d9-b88a-bb97d784fc4b', 67, 'f2c54cc7-41e1-4567-9c2c-47eb5b4ab153', 'H03 (YY:10)', '<p dir="ltr" style="text-align: left;"><a href="https://drive.google.com/drive/folders/1azLqoctAbXRRyeRvUD6CNGmWNjlDk7SY">W03-Conditional Statements - Google Drive</a><br></p>', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-16 00:00:00+07', '2024-08-24 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:28.752876+07');
INSERT INTO "public"."assignment" VALUES ('bcf9e719-9112-4c10-8033-4f0e759a0259', 68, '2478cb4a-0fc7-4bf4-a50c-e8f05c2aaa13', 'Week 1', '', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-01 00:00:00+07', '2024-08-08 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:29.346437+07');
INSERT INTO "public"."assignment" VALUES ('38740ad8-0261-43ca-8a23-01af4fc7e16d', 69, '2478cb4a-0fc7-4bf4-a50c-e8f05c2aaa13', 'Biến là gì? Tại sao chúng ta cần sử dụng biến trong lập trình?', '', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-01 00:00:00+07', '2024-08-08 00:00:00+07', NULL, 'TEXT_ONLINE', 'f', '2024-08-04 14:17:29.630476+07');
INSERT INTO "public"."assignment" VALUES ('6eaed1b6-2ef8-4db4-8165-a6184b2cbf3e', 70, '2478cb4a-0fc7-4bf4-a50c-e8f05c2aaa13', 'Câu lệnh điều kiện là gì? Tại sao chúng ta cần sử dụng câu lệnh điều kiện trong lập trình?', '', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-01 00:00:00+07', '2024-08-08 00:00:00+07', NULL, 'TEXT_ONLINE', 'f', '2024-08-04 14:17:29.907753+07');
INSERT INTO "public"."assignment" VALUES ('908590a0-5200-4a8e-93b4-7ed647a3b96e', 71, '2478cb4a-0fc7-4bf4-a50c-e8f05c2aaa13', 'Week 2', '<p dir="ltr" style="text-align: left;"></p><p><br></p><br><p></p>', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-01 00:00:00+07', '2024-08-08 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:30.174552+07');
INSERT INTO "public"."assignment" VALUES ('7ae51e73-9f91-4eb8-805c-cf62a79907cf', 72, '2478cb4a-0fc7-4bf4-a50c-e8f05c2aaa13', 'Week 3', '<p dir="ltr" style="text-align: left;"></p><p><br></p><br><p></p>', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-01 00:00:00+07', '2024-08-08 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:30.443884+07');
INSERT INTO "public"."assignment" VALUES ('084adde0-595a-4194-97f5-362bc819fa6c', 81, 'a388ef91-e5ce-45ec-becb-c6cc54b4e616', 'Lab 01', '', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-01 00:00:00+07', '2024-08-08 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:31.525169+07');
INSERT INTO "public"."assignment" VALUES ('a3afe6fd-e101-4410-9ec6-33c9266bda85', 82, 'a388ef91-e5ce-45ec-becb-c6cc54b4e616', 'Lab 02', '', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-08 00:00:00+07', '2024-08-16 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:31.784259+07');
INSERT INTO "public"."assignment" VALUES ('03117b29-e805-48d8-86a0-e8ece7f32458', 83, '0ab93253-b022-4706-8e47-75934c3f084c', 'Complete project video (deadline Aug 22, 2024)', '', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-01 00:00:00+07', '2024-08-22 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:32.63756+07');
INSERT INTO "public"."assignment" VALUES ('a7fe8936-f7fa-462b-a114-a06a96c18f7e', 84, '0ab93253-b022-4706-8e47-75934c3f084c', 'Class submission (1-1-&gt;1-3)', '', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-01 10:00:00+07', '2024-08-01 12:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:32.904348+07');
INSERT INTO "public"."assignment" VALUES ('e2307abe-a57f-4e30-9fe5-ae795d0e0950', 85, '0ab93253-b022-4706-8e47-75934c3f084c', 'Home submission (1-4-&gt;1-8)', '', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-01 00:00:00+07', '2024-08-08 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:33.178068+07');
INSERT INTO "public"."assignment" VALUES ('dab8009a-64e6-4b73-97f7-3e52e393859c', 86, '0ab93253-b022-4706-8e47-75934c3f084c', 'Class Submission (1-1, 1-2)', '', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-09 10:00:00+07', '2024-08-16 13:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:33.448303+07');
INSERT INTO "public"."assignment" VALUES ('29fc7af2-b5b6-48bd-8cd9-1502b6516581', 87, '0ab93253-b022-4706-8e47-75934c3f084c', 'Home Submission (1-3, 1-4)', '', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-17 00:00:00+07', '2024-08-24 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:33.716041+07');
INSERT INTO "public"."assignment" VALUES ('cbea3e1f-64b5-407f-b56b-496d801e79c2', 93, '2b549267-2f56-4fa1-ba24-bdebc6b7e89c', '[PR1] Link nộp mẫu báo cáo 1', '', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-02 00:00:00+07', '2024-08-09 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:34.82763+07');
INSERT INTO "public"."assignment" VALUES ('0b938dd7-37a3-4d02-ace4-c77cf1f1192d', 94, '2b549267-2f56-4fa1-ba24-bdebc6b7e89c', '[PR1] Link nộp mẫu báo cáo 2', '', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-02 00:00:00+07', '2024-08-09 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:35.110574+07');
INSERT INTO "public"."assignment" VALUES ('e1dc6482-84cf-418a-8130-537150ed4795', 88, '5aa6ffd0-b35b-41c0-8bdd-9c618c27579e', 'In-class Exercise 1', '<p dir="ltr" style="text-align: left;">Write a simple code to print "Hello World" on the screen and explain each line of the code in detail.<br></p>', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-02 00:00:00+07', '2024-08-09 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:35.770436+07');
INSERT INTO "public"."assignment" VALUES ('ddd96019-ae43-4958-b3c6-03041abd0b57', 89, '5aa6ffd0-b35b-41c0-8bdd-9c618c27579e', 'In-class Exercise 2', '<p dir="ltr" style="text-align: left;">Write a program to calculate the sum of two numbers entered from the keyboard and display the result. Provide a detailed explanation of each step.<br></p>', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-02 00:00:00+07', '2024-08-09 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:36.098399+07');
INSERT INTO "public"."assignment" VALUES ('c1b1096b-3575-4f89-b5a0-6b8a0b15bb5c', 90, '5aa6ffd0-b35b-41c0-8bdd-9c618c27579e', 'Lab Exercise 1', '<p dir="ltr" style="text-align: left;">Write a program to print "Hello World" on the screen and submit the source code.<br></p>', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-02 00:00:00+07', '2024-08-09 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:36.421023+07');
INSERT INTO "public"."assignment" VALUES ('04c3c126-2632-42f2-846a-afd1b2f03a41', 91, '5aa6ffd0-b35b-41c0-8bdd-9c618c27579e', 'Lab Exercise 2', '<p dir="ltr" style="text-align: left;">Write a program that performs basic arithmetic operations (addition, subtraction, multiplication, division) between two numbers entered from the keyboard and submit the source code.<br></p>', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-02 00:00:00+07', '2024-08-09 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:36.779283+07');
INSERT INTO "public"."assignment" VALUES ('0acb3ab4-c428-4e08-9650-5f817961bf27', 92, '5aa6ffd0-b35b-41c0-8bdd-9c618c27579e', 'Lab Exercise 3', '<p dir="ltr" style="text-align: left;">Write a program that asks the user to enter their age and prints a message corresponding to their age group (child, teenager, adult, senior). Submit the source code and a report on the results.<br></p>', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-02 00:00:00+07', '2024-08-09 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:37.139325+07');
INSERT INTO "public"."assignment" VALUES ('03c54d23-8c21-4163-b910-d2093cc70e49', 95, '45b7f477-0ce1-4b46-bccb-5f80b508da35', 'NỘP ĐỒ ÁN CUỐI KÌ (DEADLINE: 10/09/2024)', '', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-02 00:00:00+07', '2024-09-10 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:37.854911+07');
INSERT INTO "public"."assignment" VALUES ('6efa02e8-e8ec-42f1-9ee5-0c7472f9651f', 96, '547b7170-078e-4d3a-a702-178d22490cf9', 'WEEK 1', '', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-02 00:00:00+07', '2024-08-09 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:38.611578+07');
INSERT INTO "public"."assignment" VALUES ('fb444fe7-cdb1-4654-b852-c4fb03b37892', 97, '547b7170-078e-4d3a-a702-178d22490cf9', 'WEEK 2', '', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-02 00:00:00+07', '2024-08-09 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:38.941392+07');
INSERT INTO "public"."assignment" VALUES ('7e4e811a-993d-43bd-ac30-237516313375', 98, '547b7170-078e-4d3a-a702-178d22490cf9', 'WEEK 3', '', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-02 00:00:00+07', '2024-08-09 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:39.230029+07');
INSERT INTO "public"."assignment" VALUES ('d2695af4-2212-45ae-94ff-90b5e30a8a69', 99, '547b7170-078e-4d3a-a702-178d22490cf9', 'WEEK 4', '', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-02 00:00:00+07', '2024-08-09 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:39.525298+07');
INSERT INTO "public"."assignment" VALUES ('e8a247d5-e261-473b-a66d-c48941e05433', 100, '547b7170-078e-4d3a-a702-178d22490cf9', 'Introduction to Programming Language', '', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-02 00:00:00+07', '2024-08-09 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:39.809192+07');
INSERT INTO "public"."assignment" VALUES ('41ee1eeb-84ed-4790-b223-9db693ba50eb', 106, 'e2559476-b848-4bae-bce9-fdcbdf95c2e7', 'WEEK 1', '', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-02 00:00:00+07', '2024-08-09 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:40.673029+07');
INSERT INTO "public"."assignment" VALUES ('b998491b-8d2b-420b-997a-f285d5a8531d', 107, 'e2559476-b848-4bae-bce9-fdcbdf95c2e7', 'Sorting Algorithms', '', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-02 00:00:00+07', '2024-08-09 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:40.939166+07');
INSERT INTO "public"."assignment" VALUES ('ba3098ea-e4ee-4081-ade9-d889993e4955', 105, 'f4eaeacd-e560-4839-a473-e92e7197a8bb', 'SUBMIT FINAL PROJECT', '', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-02 00:00:00+07', '2024-08-31 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:41.48542+07');
INSERT INTO "public"."assignment" VALUES ('2b7e7876-3010-40cf-88af-e7733000a318', 101, '10d4cf23-afb3-448b-be5f-893dc4058444', 'Introduction to Data Structures and Algorithms', '<p dir="ltr" style="text-align: left;">Write a short essay on the importance of learning data structures and algorithms in computer science.<br></p>', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-02 00:00:00+07', '2024-08-09 00:00:00+07', NULL, 'TEXT_ONLINE', 'f', '2024-08-04 14:17:42.058593+07');
INSERT INTO "public"."assignment" VALUES ('688d06bf-4f15-4848-ac87-1b4bd8b98c1f', 102, '10d4cf23-afb3-448b-be5f-893dc4058444', 'Arrays and Linked Lists', 'Implement a singly linked list and write functions for insertion and deletion.', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-02 00:00:00+07', '2024-08-09 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:42.318352+07');
INSERT INTO "public"."assignment" VALUES ('1f5a4279-82cf-4ad0-a8df-66e1c6424585', 103, '10d4cf23-afb3-448b-be5f-893dc4058444', 'Stacks and Queues', '<p dir="ltr" style="text-align: left;"></p><p>Implement a stack using arrays and linked lists.<br><br></p><br><p></p>', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-02 00:00:00+07', '2024-08-09 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:42.578428+07');
INSERT INTO "public"."assignment" VALUES ('4fb997a3-0fb9-4122-9ff2-ed4b9546edf7', 104, '10d4cf23-afb3-448b-be5f-893dc4058444', 'Trees', '<p dir="ltr" style="text-align: left;"></p><p></p><p>Implement a binary tree and write functions for inorder, preorder, and postorder traversal<br><br></p><br><p></p><br><p></p>', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-02 00:00:00+07', '2024-08-09 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:42.841016+07');
INSERT INTO "public"."assignment" VALUES ('bdf40153-7672-4f76-b4f3-6f8aafa859c2', 108, 'a9946969-f2a0-461d-a6e5-9de47426d352', 'Basics of Programming', '<p dir="ltr" style="text-align: left;">Explore the foundational concepts of programming. Prepare a short essay on the significance of learning programming.<br></p>', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-02 00:00:00+07', '2024-08-09 00:00:00+07', NULL, 'TEXT_ONLINE', 'f', '2024-08-04 14:17:43.409351+07');
INSERT INTO "public"."assignment" VALUES ('7ea2099b-99d0-4ff8-9fe0-34df53f5dd00', 109, 'a9946969-f2a0-461d-a6e5-9de47426d352', 'In-class Exercise 1', '<p dir="ltr" style="text-align: left;">Create a simple program to output "Hello World!" and describe the purpose of each line in the program.<br></p>', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-02 00:00:00+07', '2024-08-09 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:43.679272+07');
INSERT INTO "public"."assignment" VALUES ('8b869ba4-2809-4c0a-b27e-1f73fffa60a7', 110, 'a9946969-f2a0-461d-a6e5-9de47426d352', 'Lab Exercise 1', '<p dir="ltr" style="text-align: left;">Write a "Hello World!" program and submit the code.<br></p>', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-02 00:00:00+07', '2024-08-09 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:43.941536+07');
INSERT INTO "public"."assignment" VALUES ('6aca7f31-824c-4425-ab66-647747c86281', 111, 'a9946969-f2a0-461d-a6e5-9de47426d352', 'Understanding Data Types', '<p dir="ltr" style="text-align: left;">Learn about different data types in programming. Write a program demonstrating the usage of various data types.<br></p>', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-02 00:00:00+07', '2024-08-09 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:44.205017+07');
INSERT INTO "public"."assignment" VALUES ('eb1a10a5-2523-45c7-98c1-75a6f78b7506', 112, 'a9946969-f2a0-461d-a6e5-9de47426d352', 'In-class Exercise 2', '<p dir="ltr" style="text-align: left;">Write a program that takes two user inputs, performs addition, and displays the result. Explain the logic used in the program.<br></p>', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-02 00:00:00+07', '2024-08-09 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:44.471222+07');
INSERT INTO "public"."assignment" VALUES ('8ec4728f-d7bd-4161-ba2d-3ea52bf84420', 113, 'f8c020b8-5eae-491e-83b7-e8327b6f5ec9', 'SUBMIT FINAL PROJECT', '', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-02 00:00:00+07', '2024-08-31 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:45.009176+07');
INSERT INTO "public"."assignment" VALUES ('5111ab38-4087-4c6c-8e7f-f9d7d01e53a9', 114, '8b5ab515-a9ab-4e9f-a9c4-efe58c6970f7', 'In-class Exercise 1', '<p dir="ltr" style="text-align: left;">Write a program to implement a simple algorithm for finding the largest number in an array. Explain each step of the algorithm.<br></p>', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-02 00:00:00+07', '2024-08-09 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:45.829188+07');
INSERT INTO "public"."assignment" VALUES ('7a3181ad-15eb-4ae0-929f-a22d137cd958', 115, '8b5ab515-a9ab-4e9f-a9c4-efe58c6970f7', 'In-class Exercise 2', '<p dir="ltr" style="text-align: left;">implement a stack data structure using arrays. Provide an explanation of the operations performed (push, pop, peek).</p>', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-02 00:00:00+07', '2024-08-09 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:46.092844+07');
INSERT INTO "public"."assignment" VALUES ('cc8c98ff-ac29-4c2e-98aa-793184163432', 116, '8b5ab515-a9ab-4e9f-a9c4-efe58c6970f7', 'Final Project', '', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-02 00:00:00+07', '2024-08-31 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:46.357779+07');
INSERT INTO "public"."assignment" VALUES ('79dc7533-5ad9-4593-acb6-b96c8ddc5d23', 117, 'd34ea986-3f58-4947-81fa-2a67cc57818f', 'Backtracking Algorithms', '', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-02 00:00:00+07', '2024-08-09 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:46.926584+07');
INSERT INTO "public"."assignment" VALUES ('b82d777a-41c6-4185-b10c-14f6d0129da7', 118, 'c52c2f4c-b403-47f3-a22c-4c14c4528b9d', 'Exercise 3', '<p dir="ltr" style="text-align: left;">Develop a program to implement the Bellman-Ford algorithm for finding the shortest path in a weighted graph. Submit the source code and a report.<br></p>', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-02 00:00:00+07', '2024-08-09 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:47.722745+07');
INSERT INTO "public"."assignment" VALUES ('221119dc-cac6-47ed-9615-aafafb9329ef', 119, '48a4d599-9cda-4301-8a4c-5b72ca78ee8d', 'Introduction to Data Structures', '<p dir="ltr" style="text-align: left;">Discuss the importance of data structures in programming. Write a short essay on different types of data structures and their applications.<br></p>', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-02 00:00:00+07', '2024-08-09 00:00:00+07', NULL, 'TEXT_ONLINE', 'f', '2024-08-04 14:17:48.314945+07');
INSERT INTO "public"."assignment" VALUES ('d08e67d8-d59c-4426-91e8-1a2dd78c1b3c', 120, '48a4d599-9cda-4301-8a4c-5b72ca78ee8d', 'In-class Exercise 1', '<p dir="ltr" style="text-align: left;">Implement a simple array-based list. Write a program to perform basic operations like insert, delete, and search on the list.<br></p>', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-02 00:00:00+07', '2024-08-09 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:48.574026+07');
INSERT INTO "public"."assignment" VALUES ('ba311cd5-204e-4dd6-85d9-76fbc4eb07da', 121, '48a4d599-9cda-4301-8a4c-5b72ca78ee8d', 'Linked Lists', '<p dir="ltr" style="text-align: left;"></p><p></p><p>Learn about linked lists, their types, and applications. Write a program to implement a singly linked list.<br><br></p><br><p></p>', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-02 00:00:00+07', '2024-08-09 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:48.831268+07');
INSERT INTO "public"."assignment" VALUES ('ff6ff525-b0e0-421b-9f3c-76a01e2598dd', 122, '48a4d599-9cda-4301-8a4c-5b72ca78ee8d', 'Sorting Algorithms', '<p dir="ltr" style="text-align: left;">Discuss various sorting algorithms. Write a program to implement bubble sort, selection sort, and insertion sort.<br></p>', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-02 00:00:00+07', '2024-08-09 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:49.092079+07');
INSERT INTO "public"."assignment" VALUES ('30bada2b-5184-47b5-9f85-6cab9a70ffc0', 123, '48a4d599-9cda-4301-8a4c-5b72ca78ee8d', 'WEEK 1', '<p dir="ltr" style="text-align: left;">Write a program to implement a doubly linked list with operations like insert, delete, and display. Submit the source code.<br></p>', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-02 00:00:00+07', '2024-08-09 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:49.361162+07');
INSERT INTO "public"."assignment" VALUES ('6003f642-be65-444b-997f-54f45ce38c40', 124, '48a4d599-9cda-4301-8a4c-5b72ca78ee8d', 'Week 2', '<p dir="ltr" style="text-align: left;">Develop a program to implement a priority queue using a heap. Submit the source code and a brief report.<br></p>', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-02 00:00:00+07', '2024-08-09 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:49.632032+07');
INSERT INTO "public"."assignment" VALUES ('8dee17a1-218c-41c1-9ec3-eb4c343ed1e7', 125, '48a4d599-9cda-4301-8a4c-5b72ca78ee8d', 'Week 3', '<p dir="ltr" style="text-align: left;"></p><p></p><p></p><p></p><p></p><ul><li>Write a program to perform Dijkstra''s algorithm for finding the shortest path in a weighted graph. Submit the source code and a report explaining the algorithm.</li></ul><br><p></p><br><p></p><br><p></p><br><p></p><br><p></p>', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-02 00:00:00+07', '2024-08-09 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:49.899331+07');
INSERT INTO "public"."assignment" VALUES ('155cb319-26b5-4bdc-a8cc-c38e15712279', 126, '59c2efd4-a0a7-4d95-8fb1-455a7fb413c6', 'FINAL PROJECT', '', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-02 00:00:00+07', '2024-08-31 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:50.461292+07');
INSERT INTO "public"."assignment" VALUES ('f05ff45a-ed64-4f67-a7e3-cd4da586c1e0', 73, 'eb71854b-2850-45e0-bece-7728aaecb035', 'Link nộp bài tuần 01 (đặt tiêu đề bài nộp MSSV1_MSSV2_..._MSSVn.cpp)', '', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-01 00:00:00+07', '2024-08-08 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:51.292894+07');
INSERT INTO "public"."assignment" VALUES ('959afefb-9568-43e3-a3ea-b5cc9cd94a14', 74, 'eb71854b-2850-45e0-bece-7728aaecb035', 'Link nộp bài tuần 03 (đặt tiêu đề bài nộp MSSV1_MSSV2_..._MSSVn.cpp)', '', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-01 00:00:00+07', '2024-08-08 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:51.549518+07');
INSERT INTO "public"."assignment" VALUES ('0f35b5e9-fe86-4501-b813-6975347c821d', 75, 'eb71854b-2850-45e0-bece-7728aaecb035', 'Link nộp bài tuần 02 (đặt tiêu đề bài nộp MSSV1_MSSV2_..._MSSVn.cpp)', '', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-01 00:00:00+07', '2024-08-08 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:51.809296+07');
INSERT INTO "public"."assignment" VALUES ('a6984dbe-9d6a-4563-8170-db23b87b07ea', 76, 'eb71854b-2850-45e0-bece-7728aaecb035', 'H01 (YY: 10)', '<p dir="ltr" style="text-align: left;"><a href="https://drive.google.com/drive/folders/1GZZ-xIJTp7y7Atu9EMmtvRhkY3sxghwT">W01-Algorithm - Google Drive</a><br></p>', NULL, NULL, NULL, NULL, NULL, 100, '2024-08-01 00:00:00+07', '2024-08-08 00:00:00+07', NULL, 'FILE', 'f', '2024-08-04 14:17:52.070887+07');

INSERT INTO "public"."exam" VALUES ('86600cfb-7b48-4e81-8e05-8fa29d49d7a6', 'c061d55e-a8b0-433f-b6a3-ae9d5601422e', 'Kiểm tra chương 1', '<p>bài kiểm tra chương 1</p>', 10, 10, '2024-06-20 20:12:27.031+07', '2024-07-30 20:12:27+07', 6000, 100, 'minutes', 'AUTOSUBMIT', 't', 0, 'f', 'QUIZ_GRADEHIGHEST', 0, '2024-06-20 20:14:49.484+07', '2024-06-20 20:14:49.484+07');
INSERT INTO "public"."exam" VALUES ('86600cfb-7b48-4e81-8e05-8fa29d49d7a9', 'c061d55e-a8b0-433f-b6a3-ae9d5601422e', 'Programming exam', '<p>Programming exam for chapter 1</p>', 10, 10, '2024-06-20 20:12:27.031+07', '2024-07-30 20:12:27+07', 6000, 100, 'minutes', 'AUTOSUBMIT', 't', 0, 'f', 'QUIZ_GRADEHIGHEST', 0, '2024-06-20 20:14:49.484+07', '2024-06-20 20:14:49.484+07');

INSERT INTO "public"."section" VALUES ('ed07ff8d-d5a4-4edc-8bb6-b3cf59aa7cc3', '983942d9-3366-4004-9f9a-c4e7e7760cc0', 1, 'General', 1);
INSERT INTO "public"."section" VALUES ('d8814d8f-0202-4633-873a-bad722505a56', '983942d9-3366-4004-9f9a-c4e7e7760cc0', 2, 'Topic 1', 1);
INSERT INTO "public"."section" VALUES ('df66055f-cbce-4d33-839c-3a61d87a4d04', '983942d9-3366-4004-9f9a-c4e7e7760cc0', 3, 'Topic 2', 1);
INSERT INTO "public"."section" VALUES ('b39bb68c-0f50-435d-bc54-2a383f916543', '983942d9-3366-4004-9f9a-c4e7e7760cc0', 4, 'Topic 3', 1);
INSERT INTO "public"."section" VALUES ('e6a2684c-4a28-40a5-bba9-653e82f6cbcc', '983942d9-3366-4004-9f9a-c4e7e7760cc0', 5, 'Topic 4', 1);
INSERT INTO "public"."section" VALUES ('f68a5db2-8e45-4d7e-ad3f-a2723f03a4ae', 'c061d55e-a8b0-433f-b6a3-ae9d5601422e', 6, 'General', 1);
INSERT INTO "public"."section" VALUES ('7e89a8d4-5137-4457-81aa-1828265fc5ef', 'c061d55e-a8b0-433f-b6a3-ae9d5601422e', 7, 'Topic 1', 1);
INSERT INTO "public"."section" VALUES ('28509ef2-650b-412d-9798-1acc8c09b1a0', 'c061d55e-a8b0-433f-b6a3-ae9d5601422e', 8, 'Topic 2', 1);
INSERT INTO "public"."section" VALUES ('52417058-676b-4552-a36b-ccbcbcd3327e', 'c061d55e-a8b0-433f-b6a3-ae9d5601422e', 9, 'Topic 3', 1);
INSERT INTO "public"."section" VALUES ('a48b5285-0813-4ee5-a639-40d778a4351b', 'c061d55e-a8b0-433f-b6a3-ae9d5601422e', 10, 'Topic 4', 1);
INSERT INTO "public"."section" VALUES ('70bb8281-5c4a-44a6-a745-0d72dd1abe20', '62943cbb-5bc5-4cef-b9a9-e33c82ecf984', 12, 'General', 1);
INSERT INTO "public"."section" VALUES ('545b9d6f-ac3a-45bc-9f17-b2a1bc1ecc22', '62943cbb-5bc5-4cef-b9a9-e33c82ecf984', 13, 'Topic 1', 1);
INSERT INTO "public"."section" VALUES ('924b15c9-6ab5-4198-9370-63d7c8e5cb26', '62943cbb-5bc5-4cef-b9a9-e33c82ecf984', 14, 'Topic 2', 1);
INSERT INTO "public"."section" VALUES ('a85f65c0-b968-411b-88c5-58c1cfa194fe', '62943cbb-5bc5-4cef-b9a9-e33c82ecf984', 15, 'Topic 3', 1);
INSERT INTO "public"."section" VALUES ('b8c1b3ca-cde6-4f24-9ea6-92c13d0d1d28', '62943cbb-5bc5-4cef-b9a9-e33c82ecf984', 16, 'Topic 4', 1);
INSERT INTO "public"."section" VALUES ('8cdaadce-b3c0-40e0-8aaa-435f4eaade54', '0888fabf-acd7-4ffa-9978-51558e5a0ee1', 17, 'General', 1);
INSERT INTO "public"."section" VALUES ('1d0c710c-8052-4e75-9c8b-b830f93fbd75', '0888fabf-acd7-4ffa-9978-51558e5a0ee1', 18, 'Topic 1', 1);
INSERT INTO "public"."section" VALUES ('57eb81c4-a730-4d00-abba-32b53a8072bc', '0888fabf-acd7-4ffa-9978-51558e5a0ee1', 19, 'Topic 2', 1);
INSERT INTO "public"."section" VALUES ('5d4475f9-5add-471a-9b4d-093d8db48cdb', '0888fabf-acd7-4ffa-9978-51558e5a0ee1', 20, 'Topic 3', 1);
INSERT INTO "public"."section" VALUES ('5d8b41da-babe-4a24-b90c-ba4457d269e2', '0888fabf-acd7-4ffa-9978-51558e5a0ee1', 21, 'Topic 4', 1);
INSERT INTO "public"."section" VALUES ('a0760a47-5977-49de-a400-8fde361523b5', 'c31382b2-2fbd-43ae-89de-12b6614fc8ab', 22, 'General', 1);
INSERT INTO "public"."section" VALUES ('99588883-9906-4b24-ad99-3c8e24e277f5', 'c31382b2-2fbd-43ae-89de-12b6614fc8ab', 23, 'Topic 1', 1);
INSERT INTO "public"."section" VALUES ('83a14cf8-8ff7-4630-94f5-813d4307e83e', 'c31382b2-2fbd-43ae-89de-12b6614fc8ab', 24, 'Topic 2', 1);
INSERT INTO "public"."section" VALUES ('fb02fb82-4ddb-4ef2-bf61-5ed1a9f37fd2', 'c31382b2-2fbd-43ae-89de-12b6614fc8ab', 25, 'Topic 3', 1);
INSERT INTO "public"."section" VALUES ('33be7f98-01b8-4a9f-866b-2bc18f75acf8', 'c31382b2-2fbd-43ae-89de-12b6614fc8ab', 26, 'Topic 4', 1);
INSERT INTO "public"."section" VALUES ('a5b36791-ae0b-44fd-9175-b219b176ca80', 'f2c54cc7-41e1-4567-9c2c-47eb5b4ab153', 1, 'General', 1);
INSERT INTO "public"."section" VALUES ('846ed62f-0058-48f3-b1ef-f153f9b4ffc1', 'f2c54cc7-41e1-4567-9c2c-47eb5b4ab153', 5, 'LECTURER NOTES', 1);
INSERT INTO "public"."section" VALUES ('c73b0573-cb54-4220-bf0c-f26dfc5ebabb', 'f2c54cc7-41e1-4567-9c2c-47eb5b4ab153', 177, 'LABS', 1);
INSERT INTO "public"."section" VALUES ('09c56241-478a-4624-8f05-f67588b10777', '2478cb4a-0fc7-4bf4-a50c-e8f05c2aaa13', 52, 'General', 1);
INSERT INTO "public"."section" VALUES ('ab30dda6-e6a0-4c11-91cd-3b310eecc440', '2478cb4a-0fc7-4bf4-a50c-e8f05c2aaa13', 53, 'Introduction to Programing', 1);
INSERT INTO "public"."section" VALUES ('fdffcd49-8810-460c-a2ab-0da45d399aa7', '2478cb4a-0fc7-4bf4-a50c-e8f05c2aaa13', 54, 'Labs', 1);
INSERT INTO "public"."section" VALUES ('63c3e731-3455-4031-8ccb-3a018abff04b', 'a7a2fd76-64cf-41e1-be53-0ebc172b605a', 57, 'General', 1);
INSERT INTO "public"."section" VALUES ('33d88bca-8b61-4409-a9cd-ce32bd2ec128', 'a7a2fd76-64cf-41e1-be53-0ebc172b605a', 58, 'Lecturer', 1);
INSERT INTO "public"."section" VALUES ('0cef2360-dbb8-4ab2-9526-a2ed87f42ecc', 'a7a2fd76-64cf-41e1-be53-0ebc172b605a', 59, 'Lab', 1);
INSERT INTO "public"."section" VALUES ('34e58924-7b2e-4fe8-b89e-74ccde16a139', '9cf07484-c7b4-453c-acd7-e763f3ccc98f', 62, 'General', 1);
INSERT INTO "public"."section" VALUES ('2aa8dcc8-5264-4cc5-bdca-a6657d7ecb78', '9cf07484-c7b4-453c-acd7-e763f3ccc98f', 63, 'Topic 1', 1);
INSERT INTO "public"."section" VALUES ('0a73b030-0ea3-4e94-9403-4ebd2ff06b85', '9cf07484-c7b4-453c-acd7-e763f3ccc98f', 64, 'Topic 2', 1);
INSERT INTO "public"."section" VALUES ('68950b46-878f-4694-b99e-4bd571575970', '9cf07484-c7b4-453c-acd7-e763f3ccc98f', 65, 'Topic 3', 1);
INSERT INTO "public"."section" VALUES ('79159a3a-0e52-4fc1-8840-fcaec3c3b4d4', '9cf07484-c7b4-453c-acd7-e763f3ccc98f', 66, 'Topic 4', 1);
INSERT INTO "public"."section" VALUES ('9d444718-a64c-4539-bc25-70352242f742', 'a388ef91-e5ce-45ec-becb-c6cc54b4e616', 67, 'General', 1);
INSERT INTO "public"."section" VALUES ('7a395dd8-afec-45fb-ab12-793eebc092f5', 'a388ef91-e5ce-45ec-becb-c6cc54b4e616', 68, 'Lecturer', 1);
INSERT INTO "public"."section" VALUES ('3baa59d3-a192-4e21-9169-6f24c972609d', 'a388ef91-e5ce-45ec-becb-c6cc54b4e616', 69, 'Lab', 1);
INSERT INTO "public"."section" VALUES ('47f9a17e-4385-48c1-abc4-3ddda5a30e11', '4076715f-9263-494e-8dbf-7a9024c9aa30', 72, 'General', 1);
INSERT INTO "public"."section" VALUES ('7c7aebb5-ef38-463c-a03c-88ecaf77812a', '4076715f-9263-494e-8dbf-7a9024c9aa30', 73, 'Topic 1', 1);
INSERT INTO "public"."section" VALUES ('88e81661-d160-4653-80ac-485c0b14fb58', '4076715f-9263-494e-8dbf-7a9024c9aa30', 74, 'Topic 2', 1);
INSERT INTO "public"."section" VALUES ('794835f8-5207-4f8d-8935-9821cb0c725d', '4076715f-9263-494e-8dbf-7a9024c9aa30', 75, 'Topic 3', 1);
INSERT INTO "public"."section" VALUES ('23ce7126-8a4c-4d94-9b5e-b776ab2addb4', '4076715f-9263-494e-8dbf-7a9024c9aa30', 76, 'Topic 4', 1);
INSERT INTO "public"."section" VALUES ('aa42229b-a415-45ce-a998-25024e294574', '0ab93253-b022-4706-8e47-75934c3f084c', 77, 'General', 1);
INSERT INTO "public"."section" VALUES ('50d219e2-5abe-4990-b253-8ac3a4c70311', '0ab93253-b022-4706-8e47-75934c3f084c', 78, 'Lecture', 1);
INSERT INTO "public"."section" VALUES ('faed6f7e-0a8d-4db2-b2a7-1d7c104d2b07', '0ab93253-b022-4706-8e47-75934c3f084c', 79, 'Lab', 1);
INSERT INTO "public"."section" VALUES ('57af6515-1877-49e6-a39a-89c33be6b31b', '802b5d84-e898-4077-b2d2-45a04d17e4e4', 82, 'General', 1);
INSERT INTO "public"."section" VALUES ('cba0f51f-f711-44a1-bc5b-448f4d8e4963', '802b5d84-e898-4077-b2d2-45a04d17e4e4', 83, 'Topic 1', 1);
INSERT INTO "public"."section" VALUES ('d03f3201-5807-4023-86dd-3f1818aa9bc8', '802b5d84-e898-4077-b2d2-45a04d17e4e4', 84, 'Topic 2', 1);
INSERT INTO "public"."section" VALUES ('d24cf82f-d273-4e8b-9ae1-3c005d3e3371', '802b5d84-e898-4077-b2d2-45a04d17e4e4', 85, 'Topic 3', 1);
INSERT INTO "public"."section" VALUES ('c5ab80e3-aa3d-4007-aaf4-c26c1e4f27fb', '802b5d84-e898-4077-b2d2-45a04d17e4e4', 86, 'Topic 4', 1);
INSERT INTO "public"."section" VALUES ('0f309ba4-ab4e-4fc5-a2ec-a339670b7280', '28cb6008-bddc-4894-83de-7919a02db956', 87, 'General', 1);
INSERT INTO "public"."section" VALUES ('5c0c780d-c464-4bb6-b2f4-4505aca035b9', '28cb6008-bddc-4894-83de-7919a02db956', 88, 'Topic 1', 1);
INSERT INTO "public"."section" VALUES ('18ddfbe4-eec8-4a68-b06c-99357e72788c', '28cb6008-bddc-4894-83de-7919a02db956', 89, 'Topic 2', 1);
INSERT INTO "public"."section" VALUES ('8aef99aa-74a0-480a-b282-6f3b5f7991d3', '28cb6008-bddc-4894-83de-7919a02db956', 90, 'Topic 3', 1);
INSERT INTO "public"."section" VALUES ('31fd7b82-2f54-464a-b108-5cfd84d28247', '28cb6008-bddc-4894-83de-7919a02db956', 91, 'Topic 4', 1);
INSERT INTO "public"."section" VALUES ('8fe11dd4-3a29-46a0-a985-1080d8ce6b5f', '2b549267-2f56-4fa1-ba24-bdebc6b7e89c', 92, 'General', 1);
INSERT INTO "public"."section" VALUES ('de8953e6-96b9-48aa-a361-2272373b933e', '2b549267-2f56-4fa1-ba24-bdebc6b7e89c', 93, 'Project', 1);
INSERT INTO "public"."section" VALUES ('b2cbe4c5-369e-4c38-a7e5-09b40e2331e0', '5aa6ffd0-b35b-41c0-8bdd-9c618c27579e', 97, 'General', 1);
INSERT INTO "public"."section" VALUES ('603972b4-e607-4704-8ab0-32417f7ba697', '5aa6ffd0-b35b-41c0-8bdd-9c618c27579e', 98, 'LECTURER', 1);
INSERT INTO "public"."section" VALUES ('aeffa889-eba0-460f-bd57-62d0d7e9ce63', '5aa6ffd0-b35b-41c0-8bdd-9c618c27579e', 99, 'LABS', 1);
INSERT INTO "public"."section" VALUES ('383b08e5-1a44-4b13-a257-0e6d5172515f', '45b7f477-0ce1-4b46-bccb-5f80b508da35', 102, 'General', 1);
INSERT INTO "public"."section" VALUES ('29acebd6-2bfb-4404-92c4-f7e8a2193f53', '45b7f477-0ce1-4b46-bccb-5f80b508da35', 103, 'Project', 1);
INSERT INTO "public"."section" VALUES ('448ebbad-5619-4e74-9609-b64bd86b3362', '547b7170-078e-4d3a-a702-178d22490cf9', 107, 'General', 1);
INSERT INTO "public"."section" VALUES ('21e04d88-14fb-4ec3-bbbc-3ecb79f5a2d2', '547b7170-078e-4d3a-a702-178d22490cf9', 185, 'LECTURE', 1);
INSERT INTO "public"."section" VALUES ('d82e3057-c164-4a41-bbd8-044a2c8914fa', '547b7170-078e-4d3a-a702-178d22490cf9', 108, 'LABS', 1);
INSERT INTO "public"."section" VALUES ('04d964a5-cf1f-41f5-ae43-3278c02584f1', '6c1be796-e383-4344-80eb-1d24392eb0a8', 112, 'General', 1);
INSERT INTO "public"."section" VALUES ('7bcda2ab-c04c-42c7-9549-1a5443cdd7e8', '6c1be796-e383-4344-80eb-1d24392eb0a8', 113, 'Topic 1', 1);
INSERT INTO "public"."section" VALUES ('6f97dc81-6c20-4a0c-87ae-5d9291c2022d', '6c1be796-e383-4344-80eb-1d24392eb0a8', 114, 'Topic 2', 1);
INSERT INTO "public"."section" VALUES ('b51ff3d8-742f-40c5-9c06-1b3f296ca7aa', '6c1be796-e383-4344-80eb-1d24392eb0a8', 115, 'Topic 3', 1);
INSERT INTO "public"."section" VALUES ('58ebeddc-c2a6-4af5-b9e0-328fd42e63dd', '6c1be796-e383-4344-80eb-1d24392eb0a8', 116, 'Topic 4', 1);
INSERT INTO "public"."section" VALUES ('cf57ec7a-6587-4ff7-b382-f8c90b383443', 'e2559476-b848-4bae-bce9-fdcbdf95c2e7', 117, 'General', 1);
INSERT INTO "public"."section" VALUES ('024691d0-d9f5-425e-bdf9-fdf75a6d6c0c', 'e2559476-b848-4bae-bce9-fdcbdf95c2e7', 118, 'LABS', 1);
INSERT INTO "public"."section" VALUES ('91bfd902-bca0-4dc2-bd85-149aa4e7e0bf', 'f4eaeacd-e560-4839-a473-e92e7197a8bb', 122, 'General', 1);
INSERT INTO "public"."section" VALUES ('ac750d17-8671-41d0-8a61-6fa99aec8a9e', 'f4eaeacd-e560-4839-a473-e92e7197a8bb', 123, 'PROJECT', 1);
INSERT INTO "public"."section" VALUES ('765d022f-9a61-4366-abdc-b2fd59f23296', '10d4cf23-afb3-448b-be5f-893dc4058444', 127, 'General', 1);
INSERT INTO "public"."section" VALUES ('74162108-c782-486f-a75b-19b09b55469f', '10d4cf23-afb3-448b-be5f-893dc4058444', 128, 'LECTURE', 1);
INSERT INTO "public"."section" VALUES ('77bc8b25-be26-49a7-b6f5-8b177e422b65', '10d4cf23-afb3-448b-be5f-893dc4058444', 129, 'LABS', 1);
INSERT INTO "public"."section" VALUES ('260a8842-2124-4fef-a94b-76a4de16c537', 'a9946969-f2a0-461d-a6e5-9de47426d352', 132, 'General', 1);
INSERT INTO "public"."section" VALUES ('4c0068eb-9241-4e1f-8abb-28d3caa4e4e7', 'a9946969-f2a0-461d-a6e5-9de47426d352', 133, 'LECTURE', 1);
INSERT INTO "public"."section" VALUES ('490742f7-5470-4d84-8996-c01dc5b71689', 'a9946969-f2a0-461d-a6e5-9de47426d352', 134, 'LABS', 1);
INSERT INTO "public"."section" VALUES ('9d5d62af-3c86-4354-9bbd-da4a947e2848', 'f8c020b8-5eae-491e-83b7-e8327b6f5ec9', 137, 'General', 1);
INSERT INTO "public"."section" VALUES ('5db80d07-b1c2-4b1d-8987-dbc1f41e6003', 'f8c020b8-5eae-491e-83b7-e8327b6f5ec9', 138, 'PROJECT', 1);
INSERT INTO "public"."section" VALUES ('7e09bdfe-8123-404c-81ec-21cbe083e448', 'c6d45de3-900b-4ac5-b080-de222ac3bebd', 142, 'General', 1);
INSERT INTO "public"."section" VALUES ('e0f33f81-a9b4-4f3c-8f28-ec42345a735b', 'c6d45de3-900b-4ac5-b080-de222ac3bebd', 143, 'LECTURE', 1);
INSERT INTO "public"."section" VALUES ('d74afc78-56f0-48c7-81c5-18afe102a6ad', '8b5ab515-a9ab-4e9f-a9c4-efe58c6970f7', 147, 'General', 1);
INSERT INTO "public"."section" VALUES ('c2d26139-10cf-4992-a41f-83e64580ca04', '8b5ab515-a9ab-4e9f-a9c4-efe58c6970f7', 148, 'LECTURE', 1);
INSERT INTO "public"."section" VALUES ('07de72e7-b5a5-4a67-99d5-2013220ce26e', '8b5ab515-a9ab-4e9f-a9c4-efe58c6970f7', 149, 'LABS', 1);
INSERT INTO "public"."section" VALUES ('41f92fdd-bc4c-429e-9e52-dd8449503903', '8b5ab515-a9ab-4e9f-a9c4-efe58c6970f7', 151, 'PROJECT', 1);
INSERT INTO "public"."section" VALUES ('07b4dcba-6ccd-48cc-bd97-05c7e9d6b028', 'd34ea986-3f58-4947-81fa-2a67cc57818f', 152, 'General', 1);
INSERT INTO "public"."section" VALUES ('c3ad8a5d-b5e9-4760-b5a4-24719b2d9d6a', 'd34ea986-3f58-4947-81fa-2a67cc57818f', 153, 'LECTURE', 1);
INSERT INTO "public"."section" VALUES ('00a742d2-1f47-429f-8a2a-941e4f967677', 'd34ea986-3f58-4947-81fa-2a67cc57818f', 154, 'LABS', 1);
INSERT INTO "public"."section" VALUES ('dc609ecc-9adc-4a0c-b110-e4eefdad273c', 'c52c2f4c-b403-47f3-a22c-4c14c4528b9d', 157, 'General', 1);
INSERT INTO "public"."section" VALUES ('08e6d41f-786a-4f5a-be16-befb69bb0db0', 'c52c2f4c-b403-47f3-a22c-4c14c4528b9d', 158, 'LABS', 1);
INSERT INTO "public"."section" VALUES ('673a34a7-22e7-45be-aa81-1e74b32bc5f7', '48a4d599-9cda-4301-8a4c-5b72ca78ee8d', 162, 'General', 1);
INSERT INTO "public"."section" VALUES ('83da9160-b382-4a66-9990-6638afbc1a06', '48a4d599-9cda-4301-8a4c-5b72ca78ee8d', 163, 'LECTURE', 1);
INSERT INTO "public"."section" VALUES ('f8dbae7c-a9b5-4e9b-829a-5b20c32fc05d', '48a4d599-9cda-4301-8a4c-5b72ca78ee8d', 164, 'LABS', 1);
INSERT INTO "public"."section" VALUES ('6fb4918b-cbf0-4780-9874-d0b6e1b8d745', '59c2efd4-a0a7-4d95-8fb1-455a7fb413c6', 167, 'General', 1);
INSERT INTO "public"."section" VALUES ('e72e348b-5d44-4e3b-84dc-7e5abccf7d87', '59c2efd4-a0a7-4d95-8fb1-455a7fb413c6', 168, 'PROJECT', 1);
INSERT INTO "public"."section" VALUES ('26b3451b-1da4-4d51-97f7-9947f829f869', '30fc358d-b78f-40cb-ad67-51ca279e649b', 172, 'General', 1);
INSERT INTO "public"."section" VALUES ('06c81027-5e1a-4758-ab57-b25545524f30', '30fc358d-b78f-40cb-ad67-51ca279e649b', 173, 'Topic 1', 1);
INSERT INTO "public"."section" VALUES ('76a0115c-c469-4211-90e9-31792c0dbd23', '30fc358d-b78f-40cb-ad67-51ca279e649b', 174, 'Topic 2', 1);
INSERT INTO "public"."section" VALUES ('4b0854aa-3108-4671-ba4e-2e213a283243', '30fc358d-b78f-40cb-ad67-51ca279e649b', 175, 'Topic 3', 1);
INSERT INTO "public"."section" VALUES ('fdbf36ee-0351-43fc-9eba-907ef0589a74', '30fc358d-b78f-40cb-ad67-51ca279e649b', 176, 'Topic 4', 1);
INSERT INTO "public"."section" VALUES ('00051a12-c51a-46b0-b62d-533eaf0f0244', 'eb71854b-2850-45e0-bece-7728aaecb035', 178, 'General', 1);
INSERT INTO "public"."section" VALUES ('ed6c5ce6-ac73-4d44-909e-9c7a1d911794', 'eb71854b-2850-45e0-bece-7728aaecb035', 179, 'LECTURER NOTES', 1);
INSERT INTO "public"."section" VALUES ('18e44fb6-7d8c-4897-95d0-995dfc8055b8', 'eb71854b-2850-45e0-bece-7728aaecb035', 180, 'LABS', 1);

-- Records of module
-- ----------------------------
INSERT INTO "public"."module" VALUES ('d21b508d-ddfb-4f0e-a49b-60597cb432b3', '577e118d-604b-450c-a02c-cf8e9f35f8ee', NULL, 6, 'd8814d8f-0202-4633-873a-bad722505a56', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('ff221787-624f-40c6-b6c1-0a7ff2909bf6', 'b1b3e215-2450-4819-9aa6-3aea9f87e604', NULL, 5, '7e89a8d4-5137-4457-81aa-1828265fc5ef', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('09c0bd11-468a-4c73-b5b2-4cfb01e25b74', 'f37edb09-e0f6-4e96-8469-d6eff5378c9d', NULL, 7, '7e89a8d4-5137-4457-81aa-1828265fc5ef', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('d946a443-be55-495c-b545-9c5ef157064c', '3926bcb3-6415-458d-b449-6e2b464732d7', NULL, 8, '7e89a8d4-5137-4457-81aa-1828265fc5ef', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('846a625b-6d7d-4cda-bf4e-ef8ef9549af7', '8c6d9aa1-f157-49ca-bfae-bc8a14570c81', NULL, 9, '7e89a8d4-5137-4457-81aa-1828265fc5ef', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('ff57ea21-fa77-4fc5-8047-915391df5824', '124c9619-cd26-43fb-8ea4-610b164925ad', NULL, 10, '7e89a8d4-5137-4457-81aa-1828265fc5ef', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('32f7e6b8-f4d0-46cf-b461-62d5328e2540', 'fbe31ca6-ddc9-49ef-87f3-c472958a52c0', NULL, 11, '7e89a8d4-5137-4457-81aa-1828265fc5ef', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('0e843862-201b-4593-8e67-134790252295', '0ffc63bf-c1b9-4676-9612-65ab6a24ce5b', NULL, 18, '7e89a8d4-5137-4457-81aa-1828265fc5ef', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('d9ee7356-3cc0-4780-b5f2-5b5e02570c38', '438413fa-ac31-496a-becb-709505ea990a', NULL, 14, '70bb8281-5c4a-44a6-a745-0d72dd1abe20', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('8758ec8e-6322-4f6a-b68d-1c4a3c1e824a', '7055f5fd-29ce-48f9-b1d1-cd11a95ce931', NULL, 20, '70bb8281-5c4a-44a6-a745-0d72dd1abe20', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('caca48ad-21c5-414d-94c1-b324c25fe8c8', 'b3108f5a-c769-42ab-84c9-80a6d80f5821', NULL, 22, '70bb8281-5c4a-44a6-a745-0d72dd1abe20', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('2c8c1590-3e17-46bb-ac93-fb3d3b293544', '5b82b228-aef2-494f-8622-2be74966106d', NULL, 23, '70bb8281-5c4a-44a6-a745-0d72dd1abe20', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('be09f62d-6d6f-4239-9b6b-08b784717788', NULL, '86600cfb-7b48-4e81-8e05-8fa29d49d7a9', 24, '7e89a8d4-5137-4457-81aa-1828265fc5ef', 'QUIZ');
INSERT INTO "public"."module" VALUES ('10658ec1-f997-4ef7-b361-ef2122afc071', 'e1a6c218-1a45-4d2e-9020-1f3e8d5f098c', NULL, NULL, '7e89a8d4-5137-4457-81aa-1828265fc5ef', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('1f546ca5-f220-4bc4-a5be-8f221d968732', 'b24d3df4-3f8e-4d23-b18f-8d82ff37cda9', NULL, NULL, '7e89a8d4-5137-4457-81aa-1828265fc5ef', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('54316111-eb21-4660-a23c-358c605c9fd1', 'f58e95a8-799c-4d2e-b5f3-d9b9d5566eec', NULL, NULL, '7e89a8d4-5137-4457-81aa-1828265fc5ef', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('aef3efed-dc13-4242-8c55-1d43fb192d95', 'c12f49db-074f-4e5c-9c19-9dffcdf9a6b4', NULL, NULL, '7e89a8d4-5137-4457-81aa-1828265fc5ef', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('ac9ba506-61ce-4766-9bcc-c774beb4759f', NULL, '86600cfb-7b48-4e81-8e05-8fa29d49d7a6', 24, '7e89a8d4-5137-4457-81aa-1828265fc5ef', 'QUIZ');
INSERT INTO "public"."module" VALUES ('ec5a5a6e-a61d-4ac1-9443-9d8103be7fdc', 'a3ef363c-6043-4084-be7e-3562f91bbf54', NULL, 99, '846ed62f-0058-48f3-b1ef-f153f9b4ffc1', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('bca062a9-ab45-4a6f-b675-ca07b0739a3d', '25940ad0-3f73-45b3-94b7-4eefd2fc38fb', NULL, 100, '846ed62f-0058-48f3-b1ef-f153f9b4ffc1', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('7f5122ad-8011-4956-a489-4457d950d9db', '433922df-240f-4272-b73c-c900aa33d111', NULL, 101, '846ed62f-0058-48f3-b1ef-f153f9b4ffc1', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('3422f07f-f826-4557-82ee-4a06dad35db6', '9ba90f72-6bc4-463f-a3c8-a5d530039aa0', NULL, 102, '846ed62f-0058-48f3-b1ef-f153f9b4ffc1', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('a4cf5056-a5fd-4a99-bbcc-58b39972350c', '4b4f6b35-69ae-449b-8c3b-0573c35ae959', NULL, 103, 'c73b0573-cb54-4220-bf0c-f26dfc5ebabb', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('0f6383d9-bc6c-4f9a-9507-252d4b02f759', 'c1f2b086-121b-4ec1-8738-1d697f63a925', NULL, 104, 'c73b0573-cb54-4220-bf0c-f26dfc5ebabb', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('a3a07ec7-3fc4-4437-812d-1daa80e5b2f4', '2a6d3dde-d04e-42d9-b88a-bb97d784fc4b', NULL, 105, 'c73b0573-cb54-4220-bf0c-f26dfc5ebabb', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('87c4e91d-8831-4f5a-b124-f3c17a856ca2', '38740ad8-0261-43ca-8a23-01af4fc7e16d', NULL, 107, 'ab30dda6-e6a0-4c11-91cd-3b310eecc440', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('195b6286-40bd-47fa-b24e-2e923cb7f526', '6eaed1b6-2ef8-4db4-8165-a6184b2cbf3e', NULL, 108, 'ab30dda6-e6a0-4c11-91cd-3b310eecc440', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('270e570d-3800-4e5c-b3cf-56d5802750c3', 'bcf9e719-9112-4c10-8033-4f0e759a0259', NULL, 106, 'fdffcd49-8810-460c-a2ab-0da45d399aa7', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('b2091c96-75ea-46bb-b069-360e4ead7f3f', '908590a0-5200-4a8e-93b4-7ed647a3b96e', NULL, 109, 'fdffcd49-8810-460c-a2ab-0da45d399aa7', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('c083e4ca-cb8a-4e41-ae00-72fc8c192bab', '7ae51e73-9f91-4eb8-805c-cf62a79907cf', NULL, 110, 'fdffcd49-8810-460c-a2ab-0da45d399aa7', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('c9b3f187-d1ee-4858-b7b7-49a5a3137abc', '084adde0-595a-4194-97f5-362bc819fa6c', NULL, 122, '3baa59d3-a192-4e21-9169-6f24c972609d', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('e9103b51-cb28-4cbf-b06a-da025abd1079', 'a3afe6fd-e101-4410-9ec6-33c9266bda85', NULL, 123, '3baa59d3-a192-4e21-9169-6f24c972609d', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('1571a144-97ee-459c-9865-bca8925823c8', '03117b29-e805-48d8-86a0-e8ece7f32458', NULL, 124, '50d219e2-5abe-4990-b253-8ac3a4c70311', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('1aab4ca2-1708-40a4-a81d-425b795aae3d', 'a7fe8936-f7fa-462b-a114-a06a96c18f7e', NULL, 125, 'faed6f7e-0a8d-4db2-b2a7-1d7c104d2b07', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('6fc20c25-c950-4bc6-8f97-e303a65965db', 'e2307abe-a57f-4e30-9fe5-ae795d0e0950', NULL, 126, 'faed6f7e-0a8d-4db2-b2a7-1d7c104d2b07', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('ded79cb3-5e88-4687-91cb-a56f683cd673', 'dab8009a-64e6-4b73-97f7-3e52e393859c', NULL, 127, 'faed6f7e-0a8d-4db2-b2a7-1d7c104d2b07', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('6c9c91b8-20d6-4fc4-ae6a-8cf5faf286a8', '29fc7af2-b5b6-48bd-8cd9-1502b6516581', NULL, 128, 'faed6f7e-0a8d-4db2-b2a7-1d7c104d2b07', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('09d731ba-9388-4230-b61d-c2e6b0bdb1ca', 'cbea3e1f-64b5-407f-b56b-496d801e79c2', NULL, 134, 'de8953e6-96b9-48aa-a361-2272373b933e', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('a0ea31ce-3b35-4094-bfe5-d2e7af7070ed', '0b938dd7-37a3-4d02-ace4-c77cf1f1192d', NULL, 135, 'de8953e6-96b9-48aa-a361-2272373b933e', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('a11d29f7-f603-411d-bee8-7d06d5a9fcaa', 'e1dc6482-84cf-418a-8130-537150ed4795', NULL, 129, '603972b4-e607-4704-8ab0-32417f7ba697', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('0b592a89-8e7f-455a-a5e2-6fbb54ef07cb', 'ddd96019-ae43-4958-b3c6-03041abd0b57', NULL, 130, '603972b4-e607-4704-8ab0-32417f7ba697', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('da370fb0-df44-41c1-8d34-e9ba5ac1218b', 'c1b1096b-3575-4f89-b5a0-6b8a0b15bb5c', NULL, 131, 'aeffa889-eba0-460f-bd57-62d0d7e9ce63', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('bb0e314a-25e2-4a79-87d0-73fd9c8e1ef6', '04c3c126-2632-42f2-846a-afd1b2f03a41', NULL, 132, 'aeffa889-eba0-460f-bd57-62d0d7e9ce63', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('0d15861c-6fe7-4a4a-a585-7afa0e91a94d', '0acb3ab4-c428-4e08-9650-5f817961bf27', NULL, 133, 'aeffa889-eba0-460f-bd57-62d0d7e9ce63', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('02b0c227-b168-43b2-a2b4-ade608340fea', '03c54d23-8c21-4163-b910-d2093cc70e49', NULL, 136, '29acebd6-2bfb-4404-92c4-f7e8a2193f53', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('943cd264-c38c-41f7-a6b2-bf02de5a5945', 'e8a247d5-e261-473b-a66d-c48941e05433', NULL, 141, '21e04d88-14fb-4ec3-bbbc-3ecb79f5a2d2', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('9cb6df7b-2f21-4a49-bec6-ccb07aba0d18', '6efa02e8-e8ec-42f1-9ee5-0c7472f9651f', NULL, 137, 'd82e3057-c164-4a41-bbd8-044a2c8914fa', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('76d68345-3b29-463d-9734-d28ad40a9814', 'fb444fe7-cdb1-4654-b852-c4fb03b37892', NULL, 138, 'd82e3057-c164-4a41-bbd8-044a2c8914fa', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('4d3fb860-4f61-45d8-ad1f-d83c8df05803', '7e4e811a-993d-43bd-ac30-237516313375', NULL, 139, 'd82e3057-c164-4a41-bbd8-044a2c8914fa', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('8865400d-24db-4cad-ae1f-e4aa281f527f', 'd2695af4-2212-45ae-94ff-90b5e30a8a69', NULL, 140, 'd82e3057-c164-4a41-bbd8-044a2c8914fa', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('fd790771-100b-4114-96de-976b2401d6ad', '41ee1eeb-84ed-4790-b223-9db693ba50eb', NULL, 147, '024691d0-d9f5-425e-bdf9-fdf75a6d6c0c', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('da66c5fa-1286-4465-8da0-3c643e61e6fb', 'b998491b-8d2b-420b-997a-f285d5a8531d', NULL, 148, '024691d0-d9f5-425e-bdf9-fdf75a6d6c0c', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('59ed30ea-4b3b-49a2-a9a0-9f7f4a3821bd', 'ba3098ea-e4ee-4081-ade9-d889993e4955', NULL, 146, 'ac750d17-8671-41d0-8a61-6fa99aec8a9e', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('d554ad83-7479-459e-ab74-526258e12ba4', '2b7e7876-3010-40cf-88af-e7733000a318', NULL, 142, '77bc8b25-be26-49a7-b6f5-8b177e422b65', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('95fdec11-fce0-41c0-aabb-884833422431', '688d06bf-4f15-4848-ac87-1b4bd8b98c1f', NULL, 143, '77bc8b25-be26-49a7-b6f5-8b177e422b65', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('ca30b56f-3caf-4980-bbae-61f21467b7b7', '1f5a4279-82cf-4ad0-a8df-66e1c6424585', NULL, 144, '77bc8b25-be26-49a7-b6f5-8b177e422b65', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('c4c0699a-3e35-4e2a-a2a0-a3d812c27c74', '4fb997a3-0fb9-4122-9ff2-ed4b9546edf7', NULL, 145, '77bc8b25-be26-49a7-b6f5-8b177e422b65', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('1e915dec-a2fd-4ef6-97a2-e6229d68fb08', 'bdf40153-7672-4f76-b4f3-6f8aafa859c2', NULL, 149, '4c0068eb-9241-4e1f-8abb-28d3caa4e4e7', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('6fb92250-6df8-441a-a16f-05d17f426000', '7ea2099b-99d0-4ff8-9fe0-34df53f5dd00', NULL, 150, '4c0068eb-9241-4e1f-8abb-28d3caa4e4e7', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('a59ced4b-e75b-4c01-ba80-a034c05b7cf7', '6aca7f31-824c-4425-ab66-647747c86281', NULL, 152, '4c0068eb-9241-4e1f-8abb-28d3caa4e4e7', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('d1d44de2-f53d-4cf6-81d8-e72bba445f98', 'eb1a10a5-2523-45c7-98c1-75a6f78b7506', NULL, 153, '4c0068eb-9241-4e1f-8abb-28d3caa4e4e7', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('8c8ec542-3c69-4a6e-910e-8c57577bc8b9', '8b869ba4-2809-4c0a-b27e-1f73fffa60a7', NULL, 151, '490742f7-5470-4d84-8996-c01dc5b71689', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('658681e5-ef01-4883-9384-d80091a854e4', '8ec4728f-d7bd-4161-ba2d-3ea52bf84420', NULL, 154, '5db80d07-b1c2-4b1d-8987-dbc1f41e6003', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('0d883e10-c9ff-42e1-974d-b3744f4d134b', '5111ab38-4087-4c6c-8e7f-f9d7d01e53a9', NULL, 155, '07de72e7-b5a5-4a67-99d5-2013220ce26e', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('dfdeaa99-7ede-4e23-bcb3-26ab99e9d0e7', '7a3181ad-15eb-4ae0-929f-a22d137cd958', NULL, 156, '07de72e7-b5a5-4a67-99d5-2013220ce26e', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('98efa4a2-aa08-4e38-abf6-e2644bd53f65', 'cc8c98ff-ac29-4c2e-98aa-793184163432', NULL, 157, '41f92fdd-bc4c-429e-9e52-dd8449503903', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('d02028cb-401f-4387-8637-b5b25a42b795', '79dc7533-5ad9-4593-acb6-b96c8ddc5d23', NULL, 158, 'c3ad8a5d-b5e9-4760-b5a4-24719b2d9d6a', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('1dfe9593-0842-4d64-b1f9-36719475ae92', 'b82d777a-41c6-4185-b10c-14f6d0129da7', NULL, 159, '08e6d41f-786a-4f5a-be16-befb69bb0db0', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('8707f076-27e2-46ed-b670-8b88c45f39fd', '221119dc-cac6-47ed-9615-aafafb9329ef', NULL, 160, '83da9160-b382-4a66-9990-6638afbc1a06', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('2cd47b7e-d656-4ba4-a9ef-24ebe8856e4d', 'd08e67d8-d59c-4426-91e8-1a2dd78c1b3c', NULL, 161, '83da9160-b382-4a66-9990-6638afbc1a06', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('fd9b5537-c9e8-4c67-acce-6b6aaa17fdd9', 'ba311cd5-204e-4dd6-85d9-76fbc4eb07da', NULL, 162, '83da9160-b382-4a66-9990-6638afbc1a06', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('fb071578-7191-4881-999a-35776dfffc02', 'ff6ff525-b0e0-421b-9f3c-76a01e2598dd', NULL, 163, 'f8dbae7c-a9b5-4e9b-829a-5b20c32fc05d', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('6b4e3cce-6aa9-4ab0-b6d3-960b13fa57bb', '30bada2b-5184-47b5-9f85-6cab9a70ffc0', NULL, 164, 'f8dbae7c-a9b5-4e9b-829a-5b20c32fc05d', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('3d642940-434b-4ddb-ba0f-13fd7df2799a', '6003f642-be65-444b-997f-54f45ce38c40', NULL, 165, 'f8dbae7c-a9b5-4e9b-829a-5b20c32fc05d', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('e7305260-1897-468c-8244-c97961086535', '8dee17a1-218c-41c1-9ec3-eb4c343ed1e7', NULL, 166, 'f8dbae7c-a9b5-4e9b-829a-5b20c32fc05d', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('2eeffeeb-53f0-409b-805f-77baf29c4d7c', '155cb319-26b5-4bdc-a8cc-c38e15712279', NULL, 167, 'e72e348b-5d44-4e3b-84dc-7e5abccf7d87', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('ea7446e6-95b2-47d8-9af2-103cc0588612', 'f05ff45a-ed64-4f67-a7e3-cd4da586c1e0', NULL, 113, 'ed6c5ce6-ac73-4d44-909e-9c7a1d911794', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('583a01e4-6490-4956-b94a-7a48226fd03e', '0f35b5e9-fe86-4501-b813-6975347c821d', NULL, 115, 'ed6c5ce6-ac73-4d44-909e-9c7a1d911794', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('30cb3652-9688-47b7-b972-9e5f7e6886e2', '959afefb-9568-43e3-a3ea-b5cc9cd94a14', NULL, 114, 'ed6c5ce6-ac73-4d44-909e-9c7a1d911794', 'ASSIGNMENT');
INSERT INTO "public"."module" VALUES ('e99ca1b1-b906-429d-847d-c8aa1a7f9f70', 'a6984dbe-9d6a-4563-8170-db23b87b07ea', NULL, 116, '18e44fb6-7d8c-4897-95d0-995dfc8055b8', 'ASSIGNMENT');


INSERT INTO "public"."course_user" VALUES ('cb0ed88c-2026-4326-a696-d0f9537c2040', '64412e27-169e-44ea-a101-74ebf8cb82d9', '983942d9-3366-4004-9f9a-c4e7e7760cc0', 3, '2024-08-04 14:14:27.616122+07');
INSERT INTO "public"."course_user" VALUES ('923c7732-3b1e-48d9-a624-7506d6b81437', 'cb2c22ac-87de-44e4-9638-35979f6af667', '983942d9-3366-4004-9f9a-c4e7e7760cc0', 5, '2024-08-04 14:14:27.616122+07');
INSERT INTO "public"."course_user" VALUES ('817b5efd-040d-4c05-854c-6002c7da7889', '2d3c1e66-1835-457f-93e9-265fe483feee', '983942d9-3366-4004-9f9a-c4e7e7760cc0', 5, '2024-08-04 14:14:27.616122+07');
INSERT INTO "public"."course_user" VALUES ('1df08f3b-b6ea-4f8e-bc5a-dec66aba57b1', 'ca3040f2-e173-40a5-aab7-6ef15965ce43', '983942d9-3366-4004-9f9a-c4e7e7760cc0', 3, '2024-08-04 14:14:27.616122+07');
INSERT INTO "public"."course_user" VALUES ('5ecb102e-8623-413a-8b85-7f393aaac95b', '64412e27-169e-44ea-a101-74ebf8cb82d9', 'c061d55e-a8b0-433f-b6a3-ae9d5601422e', 3, '2024-08-04 14:14:27.616122+07');
INSERT INTO "public"."course_user" VALUES ('986aa426-1794-4c9e-9a36-079d0f7e8947', 'cb2c22ac-87de-44e4-9638-35979f6af667', 'c061d55e-a8b0-433f-b6a3-ae9d5601422e', 5, '2024-08-04 14:14:27.616122+07');
INSERT INTO "public"."course_user" VALUES ('67633940-1113-470d-8516-fe35a5cf6944', '2d7ed5a0-fb21-4927-9a25-647c17d29668', 'c061d55e-a8b0-433f-b6a3-ae9d5601422e', 5, '2024-08-04 14:14:27.616122+07');
INSERT INTO "public"."course_user" VALUES ('f1a98c8d-9218-4bcf-8453-03c0e84e0516', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'c061d55e-a8b0-433f-b6a3-ae9d5601422e', 5, '2024-08-04 14:14:27.616122+07');
INSERT INTO "public"."course_user" VALUES ('441b9962-ff25-4398-940c-81fc267d599f', '64412e27-169e-44ea-a101-74ebf8cb82d9', '62943cbb-5bc5-4cef-b9a9-e33c82ecf984', 3, '2024-08-04 14:14:27.616122+07');
INSERT INTO "public"."course_user" VALUES ('11f47469-4833-40d7-944d-a88e9c8b693a', 'ca3040f2-e173-40a5-aab7-6ef15965ce43', '62943cbb-5bc5-4cef-b9a9-e33c82ecf984', 5, '2024-08-04 14:14:27.616122+07');
INSERT INTO "public"."course_user" VALUES ('c0b733e9-bbc0-4d65-b546-6688bd970157', '64412e27-169e-44ea-a101-74ebf8cb82d9', '0888fabf-acd7-4ffa-9978-51558e5a0ee1', 3, '2024-08-04 14:14:27.621045+07');
INSERT INTO "public"."course_user" VALUES ('80cb9f8f-2336-4dd7-93ce-435fb690df09', '64412e27-169e-44ea-a101-74ebf8cb82d9', 'c31382b2-2fbd-43ae-89de-12b6614fc8ab', 3, '2024-08-04 14:14:27.621045+07');
INSERT INTO "public"."course_user" VALUES ('69b831e8-7e35-48c4-bcce-20811569be49', '64412e27-169e-44ea-a101-74ebf8cb82d9', 'f4eaeacd-e560-4839-a473-e92e7197a8bb', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('450e19f4-08ba-4306-aaef-fa65624a51b2', 'cb2c22ac-87de-44e4-9638-35979f6af667', 'f4eaeacd-e560-4839-a473-e92e7197a8bb', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('8923bc82-1ecd-4592-9915-806df18361bc', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'f4eaeacd-e560-4839-a473-e92e7197a8bb', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('9337351f-9171-4754-8dc3-1ec6404d607b', '8cbf0aa4-f707-4cd3-8258-0c72f8fb4db0', 'f4eaeacd-e560-4839-a473-e92e7197a8bb', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('f1b31b15-63f2-4ef5-a16e-e5e0f7c5efc5', '444bbc7d-86f8-4258-9429-e73ce69a9e41', 'f4eaeacd-e560-4839-a473-e92e7197a8bb', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('1fe9d6ba-0d73-440f-b23a-749b916b4480', 'c2f39b5b-6aeb-4b82-8541-d25920314339', 'f4eaeacd-e560-4839-a473-e92e7197a8bb', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('e3c5fbe2-2d41-4586-adec-29ad20ca77a9', '994ebe5b-db43-4cd3-a1ee-693c2ef681ef', 'f4eaeacd-e560-4839-a473-e92e7197a8bb', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('df3f0771-0d5b-4b9f-9eb7-f7770b98cca9', 'fcf62145-e196-4777-a201-77f6693810c4', 'f4eaeacd-e560-4839-a473-e92e7197a8bb', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('904cc8c1-bd1d-4006-bbb0-a4ba043de465', '87076e41-40fd-4832-bbbc-1e5211878264', 'f4eaeacd-e560-4839-a473-e92e7197a8bb', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('e2cf4f6d-d053-457d-96ff-a882ae823652', '2df936cc-f04a-4269-85ca-5dcf8099e184', 'f4eaeacd-e560-4839-a473-e92e7197a8bb', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('3150d63b-3498-4e25-bb0d-abe02725e504', 'b887e221-2edd-4a37-9b65-209c92b8997d', 'f4eaeacd-e560-4839-a473-e92e7197a8bb', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('06bea5cc-a69e-4f6c-ab10-d7781fc49ad7', 'ee83822a-75aa-4b08-8772-c2cd40443532', 'f4eaeacd-e560-4839-a473-e92e7197a8bb', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('73c6afc4-94cd-49fd-a495-b6d29564f4d0', '6c44fd5e-560d-4b8a-9d61-03c3e66872ef', 'f4eaeacd-e560-4839-a473-e92e7197a8bb', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('05a0ae23-c09d-4249-8a2e-7e490b96d520', 'fff06898-5361-4464-9e75-8b1435e46d15', 'f4eaeacd-e560-4839-a473-e92e7197a8bb', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('e7871db1-1c86-40df-b12f-ec2f6e4925fc', '75dd8ca8-14aa-4dbb-aac0-c16bcb1ef61f', 'f4eaeacd-e560-4839-a473-e92e7197a8bb', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('7223bcdc-d9ee-4aa2-83a5-2c38de34802c', '64412e27-169e-44ea-a101-74ebf8cb82d9', '10d4cf23-afb3-448b-be5f-893dc4058444', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('40eff8f3-ef77-4e34-ad3e-37bb71f19a8e', 'cb2c22ac-87de-44e4-9638-35979f6af667', '10d4cf23-afb3-448b-be5f-893dc4058444', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('dddedac4-cfcc-4bbb-b596-6b72d3e4d39b', 'a4cd3cac-3b49-4b36-93e7-13fbb14ce76f', '10d4cf23-afb3-448b-be5f-893dc4058444', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('a17ef002-6759-4ad0-8524-6e5fd1586c29', 'c2f39b5b-6aeb-4b82-8541-d25920314339', '10d4cf23-afb3-448b-be5f-893dc4058444', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('11c65e2e-cf57-4595-803d-8599551362b4', '182709ef-635b-40a4-9ccd-774dd39b380f', '10d4cf23-afb3-448b-be5f-893dc4058444', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('cbfc1cb3-a3ab-45f4-bc5f-7a0542945fda', '4a182d8b-a553-455c-8485-f834da6de4e9', '10d4cf23-afb3-448b-be5f-893dc4058444', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('6285cd85-b61c-49ce-8de2-4eab168ff081', 'b887e221-2edd-4a37-9b65-209c92b8997d', '10d4cf23-afb3-448b-be5f-893dc4058444', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('60cd9152-e8fc-4860-936f-97eda04c79bb', 'c2efd8b2-7ab2-45b8-b7c9-425ac7d36b56', '10d4cf23-afb3-448b-be5f-893dc4058444', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('27f1ddcd-238a-4efa-9570-650c04972d7c', 'd7c3523c-d595-44f0-ad72-ddf8ae299cbb', '10d4cf23-afb3-448b-be5f-893dc4058444', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('5f3cacdc-717d-4a61-9735-32e33abd77fc', 'ffed4ce4-53b7-497e-a449-e3dee93aec1d', '10d4cf23-afb3-448b-be5f-893dc4058444', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('ab79939c-d8a9-460f-b546-5a83985077a5', '06ccbc31-e870-41c9-9293-b54aef58de21', '10d4cf23-afb3-448b-be5f-893dc4058444', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('29b306ac-bf50-45e8-a6a9-e9665d6c6df8', 'ee83822a-75aa-4b08-8772-c2cd40443532', '10d4cf23-afb3-448b-be5f-893dc4058444', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('ca0e55bc-3b66-458e-a26c-e91ca8e79e35', 'bfca2841-ee2c-4981-9c74-3ef605fc1c3d', '10d4cf23-afb3-448b-be5f-893dc4058444', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('63b1a055-a11d-423d-8a09-eeb13bf17105', '6c44fd5e-560d-4b8a-9d61-03c3e66872ef', '10d4cf23-afb3-448b-be5f-893dc4058444', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('c874549c-1983-434c-ba4f-64ce047ce5c0', 'fff06898-5361-4464-9e75-8b1435e46d15', '10d4cf23-afb3-448b-be5f-893dc4058444', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('97fed459-b69c-4713-994d-8695da223d81', 'e45e5e33-d62e-47cb-9d54-cee790fc6b5f', '10d4cf23-afb3-448b-be5f-893dc4058444', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('824dc0c2-317b-478e-ad4a-79fcebad35e1', '730f379c-986b-4274-8b88-3e90e5bbba25', '10d4cf23-afb3-448b-be5f-893dc4058444', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('f0888fa2-c3fc-4cb2-bfe9-3c840a3da4d8', '75dd8ca8-14aa-4dbb-aac0-c16bcb1ef61f', '10d4cf23-afb3-448b-be5f-893dc4058444', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('ae4ec71d-3d52-4800-8e5d-3794221725cc', '2c5ab7ea-f37f-4917-bec2-202b20d25ff0', '10d4cf23-afb3-448b-be5f-893dc4058444', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('8c763e10-8ae6-4565-a192-c28ffc09766b', '62973440-0374-4c2c-a49b-b771b7640912', '10d4cf23-afb3-448b-be5f-893dc4058444', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('fb6bfaf9-209f-48e0-a9b8-35b868597814', '7179898a-c353-4917-8dbd-62e10ea3249e', '10d4cf23-afb3-448b-be5f-893dc4058444', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('96ae65b2-f78b-48b0-9b08-767419daf27f', '64412e27-169e-44ea-a101-74ebf8cb82d9', 'a9946969-f2a0-461d-a6e5-9de47426d352', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('dd1e8dc5-34d4-4dbf-8691-f1fdba440057', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'a9946969-f2a0-461d-a6e5-9de47426d352', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('bfadf84b-416c-4498-bd13-1ea6c3458ede', 'a4cd3cac-3b49-4b36-93e7-13fbb14ce76f', 'a9946969-f2a0-461d-a6e5-9de47426d352', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('2245bc0e-ee36-43d0-bb9a-7672b0a6cf17', '8cbf0aa4-f707-4cd3-8258-0c72f8fb4db0', 'a9946969-f2a0-461d-a6e5-9de47426d352', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('49f08274-5e5a-4ba4-8bad-7f0f2c2688c5', '444bbc7d-86f8-4258-9429-e73ce69a9e41', 'a9946969-f2a0-461d-a6e5-9de47426d352', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('83bb00bf-774b-4f20-98fc-11f8b5974844', 'fcf62145-e196-4777-a201-77f6693810c4', 'a9946969-f2a0-461d-a6e5-9de47426d352', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('aa3e96b8-681b-436a-9b21-59c83b8339ae', '853b8f16-20c9-42e9-a04d-daa0237823ca', 'a9946969-f2a0-461d-a6e5-9de47426d352', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('1261dff3-02a8-48fe-b18d-c5702ce5d562', 'baddeb10-3f99-4843-859c-50cc51659153', 'a9946969-f2a0-461d-a6e5-9de47426d352', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('12537adb-5f34-4fdf-a1ec-0d4e249d86ae', 'c2efd8b2-7ab2-45b8-b7c9-425ac7d36b56', 'a9946969-f2a0-461d-a6e5-9de47426d352', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('d3e2ef99-f158-4a2c-8837-f7824f99758a', '06ccbc31-e870-41c9-9293-b54aef58de21', 'a9946969-f2a0-461d-a6e5-9de47426d352', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('9f45e883-3c68-4cf2-b901-2d2e6ad75037', 'ee83822a-75aa-4b08-8772-c2cd40443532', 'a9946969-f2a0-461d-a6e5-9de47426d352', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('89669fdb-253c-4a7c-aa93-2425b66abe4c', '097ad133-9434-44d0-ad2f-16db49f0be9c', 'a9946969-f2a0-461d-a6e5-9de47426d352', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('d89409b8-b773-4b8c-b82c-a991ad96ff93', 'd2befc26-a318-4ae1-a1c6-c71dd7e7d79d', 'a9946969-f2a0-461d-a6e5-9de47426d352', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('193f35df-9bd1-4726-9ed0-61c88501e995', 'dd81de86-7f96-482a-b967-2e8e4cd9d910', 'a9946969-f2a0-461d-a6e5-9de47426d352', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('20b7e82a-ace4-4412-b897-8f46b90cbfca', 'a1845f87-cece-4cb0-91c7-7bd68f439063', 'a9946969-f2a0-461d-a6e5-9de47426d352', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('cb5f0f5e-0b97-48c5-b44d-758c6a29cfef', '6c44fd5e-560d-4b8a-9d61-03c3e66872ef', 'a9946969-f2a0-461d-a6e5-9de47426d352', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('504307b3-0d1a-4e0e-b00d-d52c885830b9', 'fff06898-5361-4464-9e75-8b1435e46d15', 'a9946969-f2a0-461d-a6e5-9de47426d352', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('8f6f0b85-c528-4225-8ea6-a0f0adfec25c', 'e1ac8c3c-1c60-4c14-8143-84c3c8c66934', 'a9946969-f2a0-461d-a6e5-9de47426d352', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('b1023771-63f8-4b7e-b056-8095cb483ee9', '730f379c-986b-4274-8b88-3e90e5bbba25', 'a9946969-f2a0-461d-a6e5-9de47426d352', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('d0a5f71e-1bf0-4480-9c4f-25e1be9aa29b', '588636d6-7193-4a2b-be5f-cafe112d3bf5', 'a9946969-f2a0-461d-a6e5-9de47426d352', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('4582d6ea-63e9-405d-9dfa-e77942264eb3', '75dd8ca8-14aa-4dbb-aac0-c16bcb1ef61f', 'a9946969-f2a0-461d-a6e5-9de47426d352', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('9aff6fea-1091-45df-8a2a-cef27d713b1f', '2c5ab7ea-f37f-4917-bec2-202b20d25ff0', 'a9946969-f2a0-461d-a6e5-9de47426d352', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('f6850b5a-e4e1-4125-8945-f574174d4d24', '62973440-0374-4c2c-a49b-b771b7640912', 'a9946969-f2a0-461d-a6e5-9de47426d352', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('2e68f073-edbe-4206-ad8c-beb57b0bd7be', '64412e27-169e-44ea-a101-74ebf8cb82d9', 'f8c020b8-5eae-491e-83b7-e8327b6f5ec9', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('f303ab3e-30d7-495b-957c-2e5fe7240004', 'cb2c22ac-87de-44e4-9638-35979f6af667', 'f8c020b8-5eae-491e-83b7-e8327b6f5ec9', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('f47a2655-3663-4c2d-87a8-623af7736f4b', 'a4cd3cac-3b49-4b36-93e7-13fbb14ce76f', 'f8c020b8-5eae-491e-83b7-e8327b6f5ec9', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('40a2caba-5c67-4c01-840b-5d38c29cb4ff', '8cbf0aa4-f707-4cd3-8258-0c72f8fb4db0', 'f8c020b8-5eae-491e-83b7-e8327b6f5ec9', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('ec9dc8dc-81d7-4b1a-8916-7184b02e80ac', 'ad3c4eb3-8ddb-45a0-9df2-d6ec5d14fbbc', 'f8c020b8-5eae-491e-83b7-e8327b6f5ec9', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('da51b34a-1a24-4331-9a33-b8b92b82f87c', 'c2f39b5b-6aeb-4b82-8541-d25920314339', 'f8c020b8-5eae-491e-83b7-e8327b6f5ec9', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('d6e151f4-e123-4a3e-a7da-2e8cb62e0579', 'fcf62145-e196-4777-a201-77f6693810c4', 'f8c020b8-5eae-491e-83b7-e8327b6f5ec9', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('b6ef2244-6b0b-4c0c-bb48-0d2d9cadec2a', '87076e41-40fd-4832-bbbc-1e5211878264', 'f8c020b8-5eae-491e-83b7-e8327b6f5ec9', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('870db9c0-2a3b-42c2-961f-fee46a27da53', 'b887e221-2edd-4a37-9b65-209c92b8997d', 'f8c020b8-5eae-491e-83b7-e8327b6f5ec9', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('5e9b0896-0c32-4f12-bb6f-ceeada3324d8', 'c2efd8b2-7ab2-45b8-b7c9-425ac7d36b56', 'f8c020b8-5eae-491e-83b7-e8327b6f5ec9', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('20339a21-fef9-4ced-849e-5df6ec067d98', '06ccbc31-e870-41c9-9293-b54aef58de21', 'f8c020b8-5eae-491e-83b7-e8327b6f5ec9', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('687498f1-b033-4f97-8c8a-0f6cff0a5398', 'ee83822a-75aa-4b08-8772-c2cd40443532', 'f8c020b8-5eae-491e-83b7-e8327b6f5ec9', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('1267f9a2-a59b-41b6-8688-fb9794059271', 'dd81de86-7f96-482a-b967-2e8e4cd9d910', 'f8c020b8-5eae-491e-83b7-e8327b6f5ec9', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('4a8214a9-a91c-479f-9fbe-4c06d4e7c688', 'a1845f87-cece-4cb0-91c7-7bd68f439063', 'f8c020b8-5eae-491e-83b7-e8327b6f5ec9', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('df3b12cf-e8ff-4ee1-8830-794041cfe3ef', '6c44fd5e-560d-4b8a-9d61-03c3e66872ef', 'f8c020b8-5eae-491e-83b7-e8327b6f5ec9', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('9dab077e-c746-412d-9542-623a728c0eb6', '730f379c-986b-4274-8b88-3e90e5bbba25', 'f8c020b8-5eae-491e-83b7-e8327b6f5ec9', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('5cf848d8-1ad9-4d60-bada-88d4244569f2', '588636d6-7193-4a2b-be5f-cafe112d3bf5', 'f8c020b8-5eae-491e-83b7-e8327b6f5ec9', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('ecd43026-b80d-4a6c-93a5-f4f41b4be070', '75dd8ca8-14aa-4dbb-aac0-c16bcb1ef61f', 'f8c020b8-5eae-491e-83b7-e8327b6f5ec9', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('2ec34d64-6851-4889-a890-6e50e78233e8', '62973440-0374-4c2c-a49b-b771b7640912', 'f8c020b8-5eae-491e-83b7-e8327b6f5ec9', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('e2689bc8-96e4-4a5f-938d-8168fd48d349', '7179898a-c353-4917-8dbd-62e10ea3249e', 'f8c020b8-5eae-491e-83b7-e8327b6f5ec9', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('cbe59aef-a085-448f-b10d-ddbf59b839bb', '64412e27-169e-44ea-a101-74ebf8cb82d9', 'c6d45de3-900b-4ac5-b080-de222ac3bebd', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('e6377909-e343-40b6-8fc3-6ba689c67c52', 'cb2c22ac-87de-44e4-9638-35979f6af667', 'c6d45de3-900b-4ac5-b080-de222ac3bebd', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('3ad04eb1-b015-4fed-ba20-2a3f431a627c', '2d3c1e66-1835-457f-93e9-265fe483feee', 'c6d45de3-900b-4ac5-b080-de222ac3bebd', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('f41f0eae-f31e-4986-8b3e-084736d82ad1', 'a4cd3cac-3b49-4b36-93e7-13fbb14ce76f', 'c6d45de3-900b-4ac5-b080-de222ac3bebd', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('e0f615ca-2f00-4b1c-827c-a3af14f7c1d1', '8cbf0aa4-f707-4cd3-8258-0c72f8fb4db0', 'c6d45de3-900b-4ac5-b080-de222ac3bebd', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('56653f25-0910-40af-9144-e7891cf8b35e', 'ad3c4eb3-8ddb-45a0-9df2-d6ec5d14fbbc', 'c6d45de3-900b-4ac5-b080-de222ac3bebd', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('8e4e0316-9e14-45ff-a11f-612920a2b776', 'c2f39b5b-6aeb-4b82-8541-d25920314339', 'c6d45de3-900b-4ac5-b080-de222ac3bebd', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('07234125-90d6-4829-8b29-0a35617176a8', '994ebe5b-db43-4cd3-a1ee-693c2ef681ef', 'c6d45de3-900b-4ac5-b080-de222ac3bebd', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('10f47d3a-f7f3-4f41-9784-82305dbcf557', '4526d150-cfcf-4b04-ab54-12789b788829', 'c6d45de3-900b-4ac5-b080-de222ac3bebd', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('c6283e94-e1d8-4fe9-8229-860555bb5e39', '853b8f16-20c9-42e9-a04d-daa0237823ca', 'c6d45de3-900b-4ac5-b080-de222ac3bebd', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('0878a947-648b-4c15-aa98-02fb3c314642', '9e9e9485-bbad-4aa4-9e2d-f8362dbbbba1', 'c6d45de3-900b-4ac5-b080-de222ac3bebd', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('019734c0-2a83-4293-9de7-d48f99092c14', '182709ef-635b-40a4-9ccd-774dd39b380f', 'c6d45de3-900b-4ac5-b080-de222ac3bebd', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('c8b70483-1ea4-4e08-8e8a-1d63a4d9554b', 'b887e221-2edd-4a37-9b65-209c92b8997d', 'c6d45de3-900b-4ac5-b080-de222ac3bebd', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('848b3497-3453-461e-adbe-e177fe1e8338', 'c2efd8b2-7ab2-45b8-b7c9-425ac7d36b56', 'c6d45de3-900b-4ac5-b080-de222ac3bebd', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('1ff3744b-986d-4e29-a981-4424465eeaec', 'd7c3523c-d595-44f0-ad72-ddf8ae299cbb', 'c6d45de3-900b-4ac5-b080-de222ac3bebd', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('f3302084-93f5-4025-bd40-bbe3e6e7e9f3', '06ccbc31-e870-41c9-9293-b54aef58de21', 'c6d45de3-900b-4ac5-b080-de222ac3bebd', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('f87959ae-709d-46cb-a169-3695482c7565', 'ee83822a-75aa-4b08-8772-c2cd40443532', 'c6d45de3-900b-4ac5-b080-de222ac3bebd', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('239ce38f-14d6-4e9b-8f66-ffb5e3e19621', 'a1845f87-cece-4cb0-91c7-7bd68f439063', 'c6d45de3-900b-4ac5-b080-de222ac3bebd', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('377e85ec-1929-4b1b-b21f-b57168e9efe0', '730f379c-986b-4274-8b88-3e90e5bbba25', 'c6d45de3-900b-4ac5-b080-de222ac3bebd', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('0a217bec-6cac-4838-a289-6eab9aa2d5ad', '588636d6-7193-4a2b-be5f-cafe112d3bf5', 'c6d45de3-900b-4ac5-b080-de222ac3bebd', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('cb398bac-3780-4abf-a3da-309e70d065f9', '2c5ab7ea-f37f-4917-bec2-202b20d25ff0', 'c6d45de3-900b-4ac5-b080-de222ac3bebd', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('3f14aa6c-73d7-41f3-b169-35e4b62f92d8', '64412e27-169e-44ea-a101-74ebf8cb82d9', '8b5ab515-a9ab-4e9f-a9c4-efe58c6970f7', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('c7c2e9d0-0fe3-4994-bdff-37c5fed7d308', 'cb2c22ac-87de-44e4-9638-35979f6af667', '8b5ab515-a9ab-4e9f-a9c4-efe58c6970f7', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('bd6a588f-077d-471d-a77e-856162e044ff', 'a4cd3cac-3b49-4b36-93e7-13fbb14ce76f', '8b5ab515-a9ab-4e9f-a9c4-efe58c6970f7', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('56df779f-ece2-41fb-8909-59ac03bce904', '8cbf0aa4-f707-4cd3-8258-0c72f8fb4db0', '8b5ab515-a9ab-4e9f-a9c4-efe58c6970f7', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('3c39c7a5-287c-4872-bce7-d1d5fa936e86', '444bbc7d-86f8-4258-9429-e73ce69a9e41', '8b5ab515-a9ab-4e9f-a9c4-efe58c6970f7', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('8c7f82a7-39a2-4845-afa4-832e346cdc02', '9e9e9485-bbad-4aa4-9e2d-f8362dbbbba1', '8b5ab515-a9ab-4e9f-a9c4-efe58c6970f7', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('c33a53de-508a-44ae-a6fc-7403793f5623', 'baddeb10-3f99-4843-859c-50cc51659153', '8b5ab515-a9ab-4e9f-a9c4-efe58c6970f7', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('3fcc2a94-ff41-4d37-ac7b-1554bb21d962', 'b887e221-2edd-4a37-9b65-209c92b8997d', '8b5ab515-a9ab-4e9f-a9c4-efe58c6970f7', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('03de6c68-8175-4f98-93b1-e6514f53c582', 'c2efd8b2-7ab2-45b8-b7c9-425ac7d36b56', '8b5ab515-a9ab-4e9f-a9c4-efe58c6970f7', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('81bac593-648e-4236-a88f-1d5acd1ecd31', 'ee83822a-75aa-4b08-8772-c2cd40443532', '8b5ab515-a9ab-4e9f-a9c4-efe58c6970f7', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('baee53ae-3bfe-4c06-8668-dad18894e998', 'd2befc26-a318-4ae1-a1c6-c71dd7e7d79d', '8b5ab515-a9ab-4e9f-a9c4-efe58c6970f7', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('9a84a198-b735-4c5b-9364-d02dab15cd70', 'a1845f87-cece-4cb0-91c7-7bd68f439063', '8b5ab515-a9ab-4e9f-a9c4-efe58c6970f7', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('4784b6e1-f965-4815-a1df-7eaa10a034e7', '6c44fd5e-560d-4b8a-9d61-03c3e66872ef', '8b5ab515-a9ab-4e9f-a9c4-efe58c6970f7', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('dc424835-9955-4d21-98d8-292d0b296b13', 'fff06898-5361-4464-9e75-8b1435e46d15', '8b5ab515-a9ab-4e9f-a9c4-efe58c6970f7', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('8532b6b1-4488-41bd-8c37-e2f7364ce648', 'e1ac8c3c-1c60-4c14-8143-84c3c8c66934', '8b5ab515-a9ab-4e9f-a9c4-efe58c6970f7', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('006d065b-e4fe-40ac-b21d-5fa125475a60', '730f379c-986b-4274-8b88-3e90e5bbba25', '8b5ab515-a9ab-4e9f-a9c4-efe58c6970f7', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('416fa7d3-00cd-4dc1-82ef-bec6d09a23d6', '588636d6-7193-4a2b-be5f-cafe112d3bf5', '8b5ab515-a9ab-4e9f-a9c4-efe58c6970f7', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('7c6b189e-b85f-4b64-ae07-171a9452de46', '75dd8ca8-14aa-4dbb-aac0-c16bcb1ef61f', '8b5ab515-a9ab-4e9f-a9c4-efe58c6970f7', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('d8b77a47-f327-48b0-bb5d-0913cf60deea', '2c5ab7ea-f37f-4917-bec2-202b20d25ff0', '8b5ab515-a9ab-4e9f-a9c4-efe58c6970f7', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('7f5e7b68-227a-47b7-a634-f8239e86009a', '62973440-0374-4c2c-a49b-b771b7640912', '8b5ab515-a9ab-4e9f-a9c4-efe58c6970f7', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('d9d876b8-fbab-4cba-85cc-1fbc55cace59', '64412e27-169e-44ea-a101-74ebf8cb82d9', 'd34ea986-3f58-4947-81fa-2a67cc57818f', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('b4389eba-6e72-43e4-9da3-10e8fdd270de', '2d7ed5a0-fb21-4927-9a25-647c17d29668', 'd34ea986-3f58-4947-81fa-2a67cc57818f', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('a5fb815d-3197-429c-8e16-c2d642e409c0', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'd34ea986-3f58-4947-81fa-2a67cc57818f', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('d72b6349-8348-4457-9d67-c83be2939aa9', 'a4cd3cac-3b49-4b36-93e7-13fbb14ce76f', 'd34ea986-3f58-4947-81fa-2a67cc57818f', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('7b341230-5cfb-406d-9bda-b951bbfc26f7', '8cbf0aa4-f707-4cd3-8258-0c72f8fb4db0', 'd34ea986-3f58-4947-81fa-2a67cc57818f', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('05594f89-96d9-4cd0-b891-761cd6fc6825', 'ad3c4eb3-8ddb-45a0-9df2-d6ec5d14fbbc', 'd34ea986-3f58-4947-81fa-2a67cc57818f', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('f0737f7c-42cb-4bd7-badf-1b479fa31008', 'c2f39b5b-6aeb-4b82-8541-d25920314339', 'd34ea986-3f58-4947-81fa-2a67cc57818f', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('e31805b8-719b-4779-9347-deddf29e161d', '87076e41-40fd-4832-bbbc-1e5211878264', 'd34ea986-3f58-4947-81fa-2a67cc57818f', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('3a3a6f1f-e3a8-46a6-808c-7036cfe9575c', '2d5137ae-9d77-4a12-94ea-fda383a8db10', 'd34ea986-3f58-4947-81fa-2a67cc57818f', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('01258e17-6d81-4544-9c44-9aa1f9a54f3f', '205b0afa-3efa-4bdf-9bc0-3f6449ff5c1a', 'd34ea986-3f58-4947-81fa-2a67cc57818f', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('fa6ca842-4751-4876-a7c0-ded96275ddf4', '9e9e9485-bbad-4aa4-9e2d-f8362dbbbba1', 'd34ea986-3f58-4947-81fa-2a67cc57818f', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('954466cb-25a3-4523-a326-d9e5cbe8a107', 'baddeb10-3f99-4843-859c-50cc51659153', 'd34ea986-3f58-4947-81fa-2a67cc57818f', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('b8c1de23-bb58-4026-af41-678eaa5268a5', '2df936cc-f04a-4269-85ca-5dcf8099e184', 'd34ea986-3f58-4947-81fa-2a67cc57818f', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('2f2ee475-aedf-4b18-a75c-5c00a0620654', 'b887e221-2edd-4a37-9b65-209c92b8997d', 'd34ea986-3f58-4947-81fa-2a67cc57818f', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('d06d429b-c53a-43ac-8d88-e5766e4167bd', '58b79c83-ba88-430b-a9c9-d549d43b3600', 'd34ea986-3f58-4947-81fa-2a67cc57818f', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('b6c64e9d-70de-47d9-941d-c812c8a2a3e1', 'c2efd8b2-7ab2-45b8-b7c9-425ac7d36b56', 'd34ea986-3f58-4947-81fa-2a67cc57818f', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('f54f3a33-c4e2-4177-8795-d92ddedbeb20', '0bea60a7-9789-42bb-a217-22d142cf3b1b', 'd34ea986-3f58-4947-81fa-2a67cc57818f', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('f2abc211-a2a1-4122-99f5-41261e9a8f33', 'ffed4ce4-53b7-497e-a449-e3dee93aec1d', 'd34ea986-3f58-4947-81fa-2a67cc57818f', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('05f39d05-8166-4251-a115-1573da550d46', 'ee83822a-75aa-4b08-8772-c2cd40443532', 'd34ea986-3f58-4947-81fa-2a67cc57818f', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('28d55cdf-12af-4e0c-ba1a-c96969009d77', 'a1845f87-cece-4cb0-91c7-7bd68f439063', 'd34ea986-3f58-4947-81fa-2a67cc57818f', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('7a273dcc-e844-40f8-b9fe-160aafc00602', '730f379c-986b-4274-8b88-3e90e5bbba25', 'd34ea986-3f58-4947-81fa-2a67cc57818f', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('963fdef5-94f9-4baf-b98b-6de44864e094', '2c5ab7ea-f37f-4917-bec2-202b20d25ff0', 'd34ea986-3f58-4947-81fa-2a67cc57818f', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('08e0118b-eab4-45de-aaf5-367e98d9adb1', '64412e27-169e-44ea-a101-74ebf8cb82d9', 'c52c2f4c-b403-47f3-a22c-4c14c4528b9d', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('0cced576-c847-4f6c-a2f9-53c875f951fd', 'cb2c22ac-87de-44e4-9638-35979f6af667', 'c52c2f4c-b403-47f3-a22c-4c14c4528b9d', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('41983a6a-4955-4f93-a422-2e31f6ef6e9a', 'ca3040f2-e173-40a5-aab7-6ef15965ce43', 'c52c2f4c-b403-47f3-a22c-4c14c4528b9d', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('2ec3f26a-2139-4cd8-b77b-cb6f33490104', '8cbf0aa4-f707-4cd3-8258-0c72f8fb4db0', 'c52c2f4c-b403-47f3-a22c-4c14c4528b9d', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('20bc24aa-34be-4994-b711-772dd1d8911f', 'fcf62145-e196-4777-a201-77f6693810c4', 'c52c2f4c-b403-47f3-a22c-4c14c4528b9d', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('73836408-e053-43ce-b761-bec35f113683', '87076e41-40fd-4832-bbbc-1e5211878264', 'c52c2f4c-b403-47f3-a22c-4c14c4528b9d', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('f87508ee-06bc-494f-abb0-bcfda4a94f81', '853b8f16-20c9-42e9-a04d-daa0237823ca', 'c52c2f4c-b403-47f3-a22c-4c14c4528b9d', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('9db18261-b198-4cf6-ab3d-ec1c68742278', '2c4e42ab-be60-439f-95dc-28ccd7c75411', 'c52c2f4c-b403-47f3-a22c-4c14c4528b9d', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('0b0f1450-5108-49b6-b30b-d8510d3613dd', '9e9e9485-bbad-4aa4-9e2d-f8362dbbbba1', 'c52c2f4c-b403-47f3-a22c-4c14c4528b9d', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('9c0ef287-0070-438d-a624-541d338ef346', 'db95956f-786e-46c7-87c1-ad5ebaacf355', 'c52c2f4c-b403-47f3-a22c-4c14c4528b9d', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('acfe5d14-3a7a-43a7-b5c5-7ef071248a70', 'baddeb10-3f99-4843-859c-50cc51659153', 'c52c2f4c-b403-47f3-a22c-4c14c4528b9d', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('a04cd9d6-5f22-4849-891f-a9b3450ea8cc', '182709ef-635b-40a4-9ccd-774dd39b380f', 'c52c2f4c-b403-47f3-a22c-4c14c4528b9d', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('dd2871a2-d239-49db-85e7-4caf39e7ab85', '2df936cc-f04a-4269-85ca-5dcf8099e184', 'c52c2f4c-b403-47f3-a22c-4c14c4528b9d', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('9b0bdc7c-34c4-4240-998f-305ad037fad0', '58b79c83-ba88-430b-a9c9-d549d43b3600', 'c52c2f4c-b403-47f3-a22c-4c14c4528b9d', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('d8b7d6ac-e4b4-46ee-9f92-3d186d61d231', 'c2efd8b2-7ab2-45b8-b7c9-425ac7d36b56', 'c52c2f4c-b403-47f3-a22c-4c14c4528b9d', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('010c5ec1-a193-45d6-8eee-bff298dbf23c', '0bea60a7-9789-42bb-a217-22d142cf3b1b', 'c52c2f4c-b403-47f3-a22c-4c14c4528b9d', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('cd134ec1-d0a9-4ab9-ae5a-6d4b17793a96', '097ad133-9434-44d0-ad2f-16db49f0be9c', 'c52c2f4c-b403-47f3-a22c-4c14c4528b9d', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('1bb3016c-0937-4e71-bf57-dcd6042a7993', 'd2befc26-a318-4ae1-a1c6-c71dd7e7d79d', 'c52c2f4c-b403-47f3-a22c-4c14c4528b9d', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('a5d72aa6-ff54-454f-9835-5343c943c0e1', 'dd81de86-7f96-482a-b967-2e8e4cd9d910', 'c52c2f4c-b403-47f3-a22c-4c14c4528b9d', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('92d791cd-a405-49e3-b90c-72c5186778e6', 'bfca2841-ee2c-4981-9c74-3ef605fc1c3d', 'c52c2f4c-b403-47f3-a22c-4c14c4528b9d', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('aca66376-8f08-4c32-ad5e-7dbd7b67b742', 'a1845f87-cece-4cb0-91c7-7bd68f439063', 'c52c2f4c-b403-47f3-a22c-4c14c4528b9d', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('0667cff4-a42a-4b28-890f-15489547f218', '6c44fd5e-560d-4b8a-9d61-03c3e66872ef', 'c52c2f4c-b403-47f3-a22c-4c14c4528b9d', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('be7c2275-8c58-4d7c-8979-219a7960f66b', 'fff06898-5361-4464-9e75-8b1435e46d15', 'c52c2f4c-b403-47f3-a22c-4c14c4528b9d', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('881b4349-aceb-413c-bc80-8ba58fb64e82', 'e1ac8c3c-1c60-4c14-8143-84c3c8c66934', 'c52c2f4c-b403-47f3-a22c-4c14c4528b9d', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('a6390dcb-3438-4a3d-8b59-2d5d51157372', '588636d6-7193-4a2b-be5f-cafe112d3bf5', 'c52c2f4c-b403-47f3-a22c-4c14c4528b9d', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('f809a5b8-bda7-46f5-b7e8-0f3f20d79360', '75dd8ca8-14aa-4dbb-aac0-c16bcb1ef61f', 'c52c2f4c-b403-47f3-a22c-4c14c4528b9d', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('c08d1f07-0915-448a-86cc-1998fa772138', '7179898a-c353-4917-8dbd-62e10ea3249e', 'c52c2f4c-b403-47f3-a22c-4c14c4528b9d', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('2f3a912a-3403-44d9-8022-30ff79224d17', '64412e27-169e-44ea-a101-74ebf8cb82d9', '48a4d599-9cda-4301-8a4c-5b72ca78ee8d', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('344c8526-189b-4c04-944a-7be57fbc03c6', '994ebe5b-db43-4cd3-a1ee-693c2ef681ef', '48a4d599-9cda-4301-8a4c-5b72ca78ee8d', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('f28ced09-1147-4dff-a788-22f79c0bb504', '87031f89-d9b0-449f-84f4-c9b6dff15a9a', '48a4d599-9cda-4301-8a4c-5b72ca78ee8d', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('e248813a-8cdc-4986-a0a5-9f38adf06728', '853b8f16-20c9-42e9-a04d-daa0237823ca', '48a4d599-9cda-4301-8a4c-5b72ca78ee8d', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('cda44ad2-8459-466f-a6de-6423df6bdba1', '205b0afa-3efa-4bdf-9bc0-3f6449ff5c1a', '48a4d599-9cda-4301-8a4c-5b72ca78ee8d', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('a078df3f-41a5-405a-a2c6-7d909228d31c', 'baddeb10-3f99-4843-859c-50cc51659153', '48a4d599-9cda-4301-8a4c-5b72ca78ee8d', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('4b179023-1859-4767-b28b-bc12e97645db', 'b887e221-2edd-4a37-9b65-209c92b8997d', '48a4d599-9cda-4301-8a4c-5b72ca78ee8d', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('11b1ec82-4059-45c4-9e92-d4b291d23699', '58b79c83-ba88-430b-a9c9-d549d43b3600', '48a4d599-9cda-4301-8a4c-5b72ca78ee8d', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('f9648898-4e3f-4539-b360-f21f1de6bff4', 'c2efd8b2-7ab2-45b8-b7c9-425ac7d36b56', '48a4d599-9cda-4301-8a4c-5b72ca78ee8d', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('3941c1bf-a92b-4faa-8ff4-e618ef8a008b', '0bea60a7-9789-42bb-a217-22d142cf3b1b', '48a4d599-9cda-4301-8a4c-5b72ca78ee8d', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('2e8c4bc2-8d28-4735-a976-53df2a0347b5', 'ffed4ce4-53b7-497e-a449-e3dee93aec1d', '48a4d599-9cda-4301-8a4c-5b72ca78ee8d', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('1ec0f851-aaf5-45ec-9feb-9a91e41f29e7', 'ee83822a-75aa-4b08-8772-c2cd40443532', '48a4d599-9cda-4301-8a4c-5b72ca78ee8d', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('3c17e6a5-9229-4be3-be05-eaf9e4c5cb5a', '097ad133-9434-44d0-ad2f-16db49f0be9c', '48a4d599-9cda-4301-8a4c-5b72ca78ee8d', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('831bdebc-4618-491f-b1b4-203d05fbdeb2', 'd2befc26-a318-4ae1-a1c6-c71dd7e7d79d', '48a4d599-9cda-4301-8a4c-5b72ca78ee8d', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('b0e7fd94-0b14-4159-b1b5-3ab370684779', 'dd81de86-7f96-482a-b967-2e8e4cd9d910', '48a4d599-9cda-4301-8a4c-5b72ca78ee8d', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('020ab256-632a-4a69-a7df-208ce21e0eaa', 'a1845f87-cece-4cb0-91c7-7bd68f439063', '48a4d599-9cda-4301-8a4c-5b72ca78ee8d', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('a8e0b587-dae7-41f5-a5b8-4d514f158b55', 'fff06898-5361-4464-9e75-8b1435e46d15', '48a4d599-9cda-4301-8a4c-5b72ca78ee8d', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('5d5f1e86-dd78-4398-bc6a-bd220f46194a', 'e1ac8c3c-1c60-4c14-8143-84c3c8c66934', '48a4d599-9cda-4301-8a4c-5b72ca78ee8d', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('cce2f358-11d1-4547-8449-954afd0e0b9c', 'e45e5e33-d62e-47cb-9d54-cee790fc6b5f', '48a4d599-9cda-4301-8a4c-5b72ca78ee8d', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('d1837a5f-dc39-4a34-8228-863bb9e2e8da', '588636d6-7193-4a2b-be5f-cafe112d3bf5', '48a4d599-9cda-4301-8a4c-5b72ca78ee8d', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('fe27a284-e6f5-4224-91b3-02d58e5a33e6', '75dd8ca8-14aa-4dbb-aac0-c16bcb1ef61f', '48a4d599-9cda-4301-8a4c-5b72ca78ee8d', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('c484e8a4-1fec-4452-87fc-2b10f6cde6de', '2c5ab7ea-f37f-4917-bec2-202b20d25ff0', '48a4d599-9cda-4301-8a4c-5b72ca78ee8d', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('88be0322-b156-4dd5-8259-86a05caf1314', '64412e27-169e-44ea-a101-74ebf8cb82d9', '59c2efd4-a0a7-4d95-8fb1-455a7fb413c6', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('4c9cbdcd-609c-4994-8762-f2b42e844331', 'cb2c22ac-87de-44e4-9638-35979f6af667', '59c2efd4-a0a7-4d95-8fb1-455a7fb413c6', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('4746de93-3420-4848-9963-4030e2ec0375', 'a4cd3cac-3b49-4b36-93e7-13fbb14ce76f', '59c2efd4-a0a7-4d95-8fb1-455a7fb413c6', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('ea719bc3-bf6b-4b57-8622-7ce443402522', '8cbf0aa4-f707-4cd3-8258-0c72f8fb4db0', '59c2efd4-a0a7-4d95-8fb1-455a7fb413c6', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('b8be93c2-77c6-4f56-a74b-5107ad719273', '444bbc7d-86f8-4258-9429-e73ce69a9e41', '59c2efd4-a0a7-4d95-8fb1-455a7fb413c6', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('ba1292e6-f2ee-4b59-9338-b1eece7ce750', 'c2f39b5b-6aeb-4b82-8541-d25920314339', '59c2efd4-a0a7-4d95-8fb1-455a7fb413c6', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('6d7a87f6-b409-4ba8-a682-99cc25e6c9d6', '4526d150-cfcf-4b04-ab54-12789b788829', '59c2efd4-a0a7-4d95-8fb1-455a7fb413c6', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('617c3a81-345f-49b6-86ed-b2389eeedfd7', '2d5137ae-9d77-4a12-94ea-fda383a8db10', '59c2efd4-a0a7-4d95-8fb1-455a7fb413c6', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('246af371-3670-49e9-8b6c-717fc5dce0c5', '205b0afa-3efa-4bdf-9bc0-3f6449ff5c1a', '59c2efd4-a0a7-4d95-8fb1-455a7fb413c6', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('2cd58f2f-f2e6-475e-a5bb-f94f01ada7ec', '9e9e9485-bbad-4aa4-9e2d-f8362dbbbba1', '59c2efd4-a0a7-4d95-8fb1-455a7fb413c6', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('7cc312ce-29cb-4c5e-a9ab-3cf96d86e74e', 'baddeb10-3f99-4843-859c-50cc51659153', '59c2efd4-a0a7-4d95-8fb1-455a7fb413c6', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('44e42834-950a-4880-897c-2e6526c71eb7', '182709ef-635b-40a4-9ccd-774dd39b380f', '59c2efd4-a0a7-4d95-8fb1-455a7fb413c6', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('e59717c5-49e5-40e1-920c-aae3ff2d910e', '2df936cc-f04a-4269-85ca-5dcf8099e184', '59c2efd4-a0a7-4d95-8fb1-455a7fb413c6', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('0d4feaa4-a201-45b2-90e7-6778f8753e7d', '58b79c83-ba88-430b-a9c9-d549d43b3600', '59c2efd4-a0a7-4d95-8fb1-455a7fb413c6', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('21940a17-b0c5-4f67-aed5-d83ff23d32c5', 'd7c3523c-d595-44f0-ad72-ddf8ae299cbb', '59c2efd4-a0a7-4d95-8fb1-455a7fb413c6', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('2ac2ca54-1877-4a88-8653-3fc6e403b9ea', 'dd81de86-7f96-482a-b967-2e8e4cd9d910', '59c2efd4-a0a7-4d95-8fb1-455a7fb413c6', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('8dbc9cd0-70f3-43a4-a3cc-5eeb1c9af509', 'fff06898-5361-4464-9e75-8b1435e46d15', '59c2efd4-a0a7-4d95-8fb1-455a7fb413c6', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('f4049645-1b68-42bb-9db5-44fbe8ab0407', 'e45e5e33-d62e-47cb-9d54-cee790fc6b5f', '59c2efd4-a0a7-4d95-8fb1-455a7fb413c6', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('149eaa27-7590-4c98-bb5a-0636f11420f4', '730f379c-986b-4274-8b88-3e90e5bbba25', '59c2efd4-a0a7-4d95-8fb1-455a7fb413c6', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('185e8982-5895-4428-ae29-b7e0c7c43d1f', '2c5ab7ea-f37f-4917-bec2-202b20d25ff0', '59c2efd4-a0a7-4d95-8fb1-455a7fb413c6', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('d914c57a-cad9-48e1-a69c-5a4c7b2dd7e5', '64412e27-169e-44ea-a101-74ebf8cb82d9', '9cf07484-c7b4-453c-acd7-e763f3ccc98f', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('6be1608b-24d9-4251-bfbe-2ea2ece16bbc', 'cb2c22ac-87de-44e4-9638-35979f6af667', '9cf07484-c7b4-453c-acd7-e763f3ccc98f', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('2ca25e27-eb20-4b2e-85f7-02807c3d67cc', '2d3c1e66-1835-457f-93e9-265fe483feee', '9cf07484-c7b4-453c-acd7-e763f3ccc98f', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('7756ccc9-d469-4336-a5a7-2f7f100265a0', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9cf07484-c7b4-453c-acd7-e763f3ccc98f', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('11bd2c9c-f8cb-4e12-b152-2bcd38000e5b', 'ad3c4eb3-8ddb-45a0-9df2-d6ec5d14fbbc', '9cf07484-c7b4-453c-acd7-e763f3ccc98f', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('81647a0b-607d-4147-a5c0-fe9a60519da5', '444bbc7d-86f8-4258-9429-e73ce69a9e41', '9cf07484-c7b4-453c-acd7-e763f3ccc98f', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('494d8dca-7179-496f-b81c-2b72a5fa1f10', '994ebe5b-db43-4cd3-a1ee-693c2ef681ef', '9cf07484-c7b4-453c-acd7-e763f3ccc98f', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('22147c60-db11-4d8c-95cd-8024e1dbf3f7', '2d5137ae-9d77-4a12-94ea-fda383a8db10', '9cf07484-c7b4-453c-acd7-e763f3ccc98f', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('07d9fbff-fbf4-480a-8ea1-686f0fd1a51a', '9e9e9485-bbad-4aa4-9e2d-f8362dbbbba1', '9cf07484-c7b4-453c-acd7-e763f3ccc98f', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('bc1c2f85-0c87-451c-8fe0-506d4ce1dbab', 'c2efd8b2-7ab2-45b8-b7c9-425ac7d36b56', '9cf07484-c7b4-453c-acd7-e763f3ccc98f', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('463dd0a0-1684-4b0f-876a-bd2a8993c669', '0bea60a7-9789-42bb-a217-22d142cf3b1b', '9cf07484-c7b4-453c-acd7-e763f3ccc98f', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('5ecaa144-c79c-432e-8235-4845b7271697', 'ffed4ce4-53b7-497e-a449-e3dee93aec1d', '9cf07484-c7b4-453c-acd7-e763f3ccc98f', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('f0e7723a-fc42-493c-b1ce-601a313055aa', '097ad133-9434-44d0-ad2f-16db49f0be9c', '9cf07484-c7b4-453c-acd7-e763f3ccc98f', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('257a70ea-aed4-4e6c-b99e-86f13522c7c9', '6c44fd5e-560d-4b8a-9d61-03c3e66872ef', '9cf07484-c7b4-453c-acd7-e763f3ccc98f', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('611a516c-8543-4aa7-b99b-8ca94747b05e', 'e45e5e33-d62e-47cb-9d54-cee790fc6b5f', '9cf07484-c7b4-453c-acd7-e763f3ccc98f', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('2cb7e91e-61a7-4b52-b09f-2d457cd7aa5c', '730f379c-986b-4274-8b88-3e90e5bbba25', '9cf07484-c7b4-453c-acd7-e763f3ccc98f', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('d4880d17-c95e-4ed2-9680-6f06ccd5aad6', '62973440-0374-4c2c-a49b-b771b7640912', '9cf07484-c7b4-453c-acd7-e763f3ccc98f', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('1c508372-56ed-4141-a562-8937a53792b1', '64412e27-169e-44ea-a101-74ebf8cb82d9', '30fc358d-b78f-40cb-ad67-51ca279e649b', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('b9f046a3-a2d8-4b0a-b8ce-e104b4f145be', 'cb2c22ac-87de-44e4-9638-35979f6af667', '30fc358d-b78f-40cb-ad67-51ca279e649b', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('aab5aed0-1317-48c1-8383-3483928b2b77', '8cbf0aa4-f707-4cd3-8258-0c72f8fb4db0', '30fc358d-b78f-40cb-ad67-51ca279e649b', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('4801c702-2c23-4e1d-b38d-985907fe5e2c', 'ad3c4eb3-8ddb-45a0-9df2-d6ec5d14fbbc', '30fc358d-b78f-40cb-ad67-51ca279e649b', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('f387eac2-9c35-4e09-b72b-010effa69a7c', '444bbc7d-86f8-4258-9429-e73ce69a9e41', '30fc358d-b78f-40cb-ad67-51ca279e649b', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('6f045721-d174-488b-b2a2-b7e3ea099bb1', 'c2f39b5b-6aeb-4b82-8541-d25920314339', '30fc358d-b78f-40cb-ad67-51ca279e649b', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('c1a05c6c-a9fb-41f3-a15f-83610f2d0703', '994ebe5b-db43-4cd3-a1ee-693c2ef681ef', '30fc358d-b78f-40cb-ad67-51ca279e649b', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('f5668005-6ec3-46f6-97e1-b15911544fd7', 'fcf62145-e196-4777-a201-77f6693810c4', '30fc358d-b78f-40cb-ad67-51ca279e649b', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('8b4cfd58-3591-4d67-be45-85ac038be199', '87076e41-40fd-4832-bbbc-1e5211878264', '30fc358d-b78f-40cb-ad67-51ca279e649b', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('222d6b44-ab9a-4dda-9a4b-b1adbdeb0fd1', '4526d150-cfcf-4b04-ab54-12789b788829', '30fc358d-b78f-40cb-ad67-51ca279e649b', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('2eb3a282-3e74-4223-a954-527235afb87b', '182709ef-635b-40a4-9ccd-774dd39b380f', '30fc358d-b78f-40cb-ad67-51ca279e649b', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('0bf61a2e-6ed2-444d-89ce-9c63683392e8', '2df936cc-f04a-4269-85ca-5dcf8099e184', '30fc358d-b78f-40cb-ad67-51ca279e649b', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('043447af-a475-4c4e-ade1-673b892951cc', '4a182d8b-a553-455c-8485-f834da6de4e9', '30fc358d-b78f-40cb-ad67-51ca279e649b', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('007ef5d8-9464-4d26-9e63-54a6fb2f1ff2', 'b887e221-2edd-4a37-9b65-209c92b8997d', '30fc358d-b78f-40cb-ad67-51ca279e649b', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('6353a8be-b2ea-4d7a-bdec-626fa37ae718', 'd7c3523c-d595-44f0-ad72-ddf8ae299cbb', '30fc358d-b78f-40cb-ad67-51ca279e649b', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('cb6e1eb8-7518-44da-ae6f-419f6fb14701', 'd2befc26-a318-4ae1-a1c6-c71dd7e7d79d', '30fc358d-b78f-40cb-ad67-51ca279e649b', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('c375f316-c143-4298-91b8-e88b4c003532', 'dd81de86-7f96-482a-b967-2e8e4cd9d910', '30fc358d-b78f-40cb-ad67-51ca279e649b', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('1ba02a5c-5824-4a2d-962e-f0652983bde9', 'a1845f87-cece-4cb0-91c7-7bd68f439063', '30fc358d-b78f-40cb-ad67-51ca279e649b', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('d494cde9-ace2-4e71-a4af-3207913503e7', 'e1ac8c3c-1c60-4c14-8143-84c3c8c66934', '30fc358d-b78f-40cb-ad67-51ca279e649b', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('c003e6d7-9b47-4b89-a4d9-1d443e34e51c', '588636d6-7193-4a2b-be5f-cafe112d3bf5', '30fc358d-b78f-40cb-ad67-51ca279e649b', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('90f78b68-e09b-4846-91d6-68bf60243010', '75dd8ca8-14aa-4dbb-aac0-c16bcb1ef61f', '30fc358d-b78f-40cb-ad67-51ca279e649b', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('d40689e2-3dd3-4d6d-bc7c-b4a538aa318f', '64412e27-169e-44ea-a101-74ebf8cb82d9', 'a388ef91-e5ce-45ec-becb-c6cc54b4e616', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('9f28a89f-9b69-4ed0-986b-58e0d8f6f4aa', 'cb2c22ac-87de-44e4-9638-35979f6af667', 'a388ef91-e5ce-45ec-becb-c6cc54b4e616', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('20ead2b0-1a68-4671-8eb6-675652f5a9d1', '2d3c1e66-1835-457f-93e9-265fe483feee', 'a388ef91-e5ce-45ec-becb-c6cc54b4e616', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('0725147e-ba8b-43a8-86bd-ef52901e4ed5', 'ca3040f2-e173-40a5-aab7-6ef15965ce43', 'a388ef91-e5ce-45ec-becb-c6cc54b4e616', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('3b4a38cd-cdf9-4978-a1a8-6116a0895933', 'c2f39b5b-6aeb-4b82-8541-d25920314339', 'a388ef91-e5ce-45ec-becb-c6cc54b4e616', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('8b233e06-de78-42f6-a854-e995284db277', '994ebe5b-db43-4cd3-a1ee-693c2ef681ef', 'a388ef91-e5ce-45ec-becb-c6cc54b4e616', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('fe294dba-60f9-4f74-a2ad-cee75362364f', '87031f89-d9b0-449f-84f4-c9b6dff15a9a', 'a388ef91-e5ce-45ec-becb-c6cc54b4e616', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('4470a560-cff2-4024-a75d-fc97abf1f97d', 'fcf62145-e196-4777-a201-77f6693810c4', 'a388ef91-e5ce-45ec-becb-c6cc54b4e616', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('fba11400-9b07-4f7e-8e0e-e466575e5ea7', '87076e41-40fd-4832-bbbc-1e5211878264', 'a388ef91-e5ce-45ec-becb-c6cc54b4e616', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('b169a793-2a4e-4118-be12-f910bc57c233', 'ee83822a-75aa-4b08-8772-c2cd40443532', 'a388ef91-e5ce-45ec-becb-c6cc54b4e616', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('61c47050-c6c9-4098-8b34-e3d9a79036ac', '097ad133-9434-44d0-ad2f-16db49f0be9c', 'a388ef91-e5ce-45ec-becb-c6cc54b4e616', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('a645f468-95e1-4351-9f97-464dfb0cbfc6', 'a1845f87-cece-4cb0-91c7-7bd68f439063', 'a388ef91-e5ce-45ec-becb-c6cc54b4e616', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('bd8b28d7-bf60-4493-8779-d0b4d93290d1', '588636d6-7193-4a2b-be5f-cafe112d3bf5', 'a388ef91-e5ce-45ec-becb-c6cc54b4e616', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('ab8cc9da-ec9d-4f12-b3a2-0c54dbda6bc9', '75dd8ca8-14aa-4dbb-aac0-c16bcb1ef61f', 'a388ef91-e5ce-45ec-becb-c6cc54b4e616', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('8e6b9f1e-9a0e-42b5-8f3a-2170ddb9019f', '2c5ab7ea-f37f-4917-bec2-202b20d25ff0', 'a388ef91-e5ce-45ec-becb-c6cc54b4e616', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('919f5cea-0e12-4f6e-90b8-0f77b0a7a2be', '64412e27-169e-44ea-a101-74ebf8cb82d9', '4076715f-9263-494e-8dbf-7a9024c9aa30', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('ae403152-1a88-4cf7-a703-3f4801614048', '8cbf0aa4-f707-4cd3-8258-0c72f8fb4db0', '4076715f-9263-494e-8dbf-7a9024c9aa30', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('c3dbf46d-df46-4579-b75b-736c56d187e5', 'c2f39b5b-6aeb-4b82-8541-d25920314339', '4076715f-9263-494e-8dbf-7a9024c9aa30', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('cb86c376-4e79-4435-b3d6-573d5721698f', 'fcf62145-e196-4777-a201-77f6693810c4', '4076715f-9263-494e-8dbf-7a9024c9aa30', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('f7f4b998-eca8-4fd6-ab10-525c119593ab', '87076e41-40fd-4832-bbbc-1e5211878264', '4076715f-9263-494e-8dbf-7a9024c9aa30', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('f14819ba-47e4-45f5-bd13-327ee0240b71', '4526d150-cfcf-4b04-ab54-12789b788829', '4076715f-9263-494e-8dbf-7a9024c9aa30', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('d0d3aa44-be79-4660-9889-93b55ea3d765', '853b8f16-20c9-42e9-a04d-daa0237823ca', '4076715f-9263-494e-8dbf-7a9024c9aa30', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('3714bc98-dd8b-4065-9822-6ab4872a1a0b', '205b0afa-3efa-4bdf-9bc0-3f6449ff5c1a', '4076715f-9263-494e-8dbf-7a9024c9aa30', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('df05b953-ec21-4187-89b0-432c98b817ce', '182709ef-635b-40a4-9ccd-774dd39b380f', '4076715f-9263-494e-8dbf-7a9024c9aa30', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('ee343881-743b-43e8-9278-8d5c88b5000c', 'b887e221-2edd-4a37-9b65-209c92b8997d', '4076715f-9263-494e-8dbf-7a9024c9aa30', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('dcb45a60-4b76-40b8-8810-447d6ecc5b1a', 'c2efd8b2-7ab2-45b8-b7c9-425ac7d36b56', '4076715f-9263-494e-8dbf-7a9024c9aa30', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('30ec4093-6c56-441d-b97c-f6967a5001d8', 'dd81de86-7f96-482a-b967-2e8e4cd9d910', '4076715f-9263-494e-8dbf-7a9024c9aa30', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('007181f4-1ad3-4ced-8591-31875f5545d4', 'a1845f87-cece-4cb0-91c7-7bd68f439063', '4076715f-9263-494e-8dbf-7a9024c9aa30', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('432a406f-52b0-4485-a54d-e46387e975c6', '6c44fd5e-560d-4b8a-9d61-03c3e66872ef', '4076715f-9263-494e-8dbf-7a9024c9aa30', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('ec277c06-6490-43d4-ba5b-e7ef4cbb20f0', 'fff06898-5361-4464-9e75-8b1435e46d15', '4076715f-9263-494e-8dbf-7a9024c9aa30', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('960cb34f-d92a-4bfc-ab50-6a6802ff0fb7', '588636d6-7193-4a2b-be5f-cafe112d3bf5', '4076715f-9263-494e-8dbf-7a9024c9aa30', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('e6c2631a-077c-403e-8907-dff7b187fedc', '75dd8ca8-14aa-4dbb-aac0-c16bcb1ef61f', '4076715f-9263-494e-8dbf-7a9024c9aa30', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('be68d4b6-9d5f-424f-9901-7f6dbb5ae445', '2c5ab7ea-f37f-4917-bec2-202b20d25ff0', '4076715f-9263-494e-8dbf-7a9024c9aa30', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('a8a1e92f-da12-49fa-bcd7-fff0cd5c3c99', '64412e27-169e-44ea-a101-74ebf8cb82d9', 'eb71854b-2850-45e0-bece-7728aaecb035', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('efd065f9-abdc-4736-8931-1956af8992e0', 'a4cd3cac-3b49-4b36-93e7-13fbb14ce76f', 'eb71854b-2850-45e0-bece-7728aaecb035', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('704d2d0e-42d4-4928-83d8-a50d1efe49a3', '8cbf0aa4-f707-4cd3-8258-0c72f8fb4db0', 'eb71854b-2850-45e0-bece-7728aaecb035', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('6109564d-f09e-4543-a9b0-f557013a0949', '87031f89-d9b0-449f-84f4-c9b6dff15a9a', 'eb71854b-2850-45e0-bece-7728aaecb035', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('ee21a429-3f11-41df-8acd-ffc6477598f3', 'fcf62145-e196-4777-a201-77f6693810c4', 'eb71854b-2850-45e0-bece-7728aaecb035', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('96415fda-e770-4b1e-ae88-1030f21db061', '4526d150-cfcf-4b04-ab54-12789b788829', 'eb71854b-2850-45e0-bece-7728aaecb035', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('ad49afcd-6a4b-4d4b-9f8d-594ba76c0be2', '853b8f16-20c9-42e9-a04d-daa0237823ca', 'eb71854b-2850-45e0-bece-7728aaecb035', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('8fe7d2f8-4d58-4d69-bb60-fc0f541b2500', '205b0afa-3efa-4bdf-9bc0-3f6449ff5c1a', 'eb71854b-2850-45e0-bece-7728aaecb035', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('60e90141-123b-4a5a-95f6-c9fc428ca2fb', 'baddeb10-3f99-4843-859c-50cc51659153', 'eb71854b-2850-45e0-bece-7728aaecb035', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('223f5a91-a638-4176-8973-6db1da336d46', '2df936cc-f04a-4269-85ca-5dcf8099e184', 'eb71854b-2850-45e0-bece-7728aaecb035', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('b68d6033-94d4-4216-b63f-ec1aa03f4607', 'c2efd8b2-7ab2-45b8-b7c9-425ac7d36b56', 'eb71854b-2850-45e0-bece-7728aaecb035', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('30203787-6085-4025-9cc8-6c75ee094f2d', 'd2befc26-a318-4ae1-a1c6-c71dd7e7d79d', 'eb71854b-2850-45e0-bece-7728aaecb035', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('75c348d3-e2cc-44bd-a6c2-03155ad9251a', 'dd81de86-7f96-482a-b967-2e8e4cd9d910', 'eb71854b-2850-45e0-bece-7728aaecb035', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('c564e36b-6b78-4be9-82cf-256e1ab78311', 'a1845f87-cece-4cb0-91c7-7bd68f439063', 'eb71854b-2850-45e0-bece-7728aaecb035', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('dfc086a0-7542-4af3-958f-7c62f247c631', '730f379c-986b-4274-8b88-3e90e5bbba25', 'eb71854b-2850-45e0-bece-7728aaecb035', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('d2783ecc-e32d-4bca-9b70-b11dbf20b856', '588636d6-7193-4a2b-be5f-cafe112d3bf5', 'eb71854b-2850-45e0-bece-7728aaecb035', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('dd6cc6e0-9c41-4a1e-a793-6228f788b6aa', '75dd8ca8-14aa-4dbb-aac0-c16bcb1ef61f', 'eb71854b-2850-45e0-bece-7728aaecb035', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('6c1d18d1-319f-40ae-a418-0e36f580a6a9', '62973440-0374-4c2c-a49b-b771b7640912', 'eb71854b-2850-45e0-bece-7728aaecb035', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('9896fa6d-5294-423d-8ad9-7feec60f05af', '64412e27-169e-44ea-a101-74ebf8cb82d9', '0ab93253-b022-4706-8e47-75934c3f084c', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('25f772b0-9f4c-4483-bf61-d441e57091d8', 'cb2c22ac-87de-44e4-9638-35979f6af667', '0ab93253-b022-4706-8e47-75934c3f084c', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('1c966eaf-c72d-4867-873e-1bf7583368fc', '9ba179ed-d26d-4828-a0f6-8836c2063992', '0ab93253-b022-4706-8e47-75934c3f084c', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('6d1def6d-750c-47f5-9826-80dd8426d75e', 'a4cd3cac-3b49-4b36-93e7-13fbb14ce76f', '0ab93253-b022-4706-8e47-75934c3f084c', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('f279d0b8-3256-4762-ac34-044ebbdd3784', 'fcf62145-e196-4777-a201-77f6693810c4', '0ab93253-b022-4706-8e47-75934c3f084c', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('c9bedffd-163c-48d5-8334-70d2223cfe62', '4526d150-cfcf-4b04-ab54-12789b788829', '0ab93253-b022-4706-8e47-75934c3f084c', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('e4845638-203e-4cc3-874e-4fc08bb4cf4b', '853b8f16-20c9-42e9-a04d-daa0237823ca', '0ab93253-b022-4706-8e47-75934c3f084c', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('40d6c5df-b300-4aa2-bf01-4658ea40e267', '2d5137ae-9d77-4a12-94ea-fda383a8db10', '0ab93253-b022-4706-8e47-75934c3f084c', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('15547bd4-6c6a-421c-80c6-877690132612', '9e9e9485-bbad-4aa4-9e2d-f8362dbbbba1', '0ab93253-b022-4706-8e47-75934c3f084c', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('a6e3e9de-7244-467f-ab9d-dc04aa21657b', 'baddeb10-3f99-4843-859c-50cc51659153', '0ab93253-b022-4706-8e47-75934c3f084c', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('ee7babc4-47c2-4e82-8c1f-c15cd739bd27', 'b887e221-2edd-4a37-9b65-209c92b8997d', '0ab93253-b022-4706-8e47-75934c3f084c', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('9fad2b44-3b23-413f-8151-d790fab22315', 'c2efd8b2-7ab2-45b8-b7c9-425ac7d36b56', '0ab93253-b022-4706-8e47-75934c3f084c', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('1cc276dc-22b6-49af-92ec-c126a1eea289', '097ad133-9434-44d0-ad2f-16db49f0be9c', '0ab93253-b022-4706-8e47-75934c3f084c', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('381b6d26-956f-4cb6-ba55-13e51fff8efc', 'd2befc26-a318-4ae1-a1c6-c71dd7e7d79d', '0ab93253-b022-4706-8e47-75934c3f084c', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('5be7ba2c-75e2-4744-a28b-ad7bc9009481', 'dd81de86-7f96-482a-b967-2e8e4cd9d910', '0ab93253-b022-4706-8e47-75934c3f084c', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('0c2bff14-4662-4bcf-9252-b1c7653dc2b9', 'fff06898-5361-4464-9e75-8b1435e46d15', '0ab93253-b022-4706-8e47-75934c3f084c', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('0909d012-370e-4bde-be4c-7e34490b2de5', '75dd8ca8-14aa-4dbb-aac0-c16bcb1ef61f', '0ab93253-b022-4706-8e47-75934c3f084c', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('ea877c96-60a3-4b33-8e93-ac2213f06e88', '7179898a-c353-4917-8dbd-62e10ea3249e', '0ab93253-b022-4706-8e47-75934c3f084c', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('9271e238-1a66-400d-8f46-6b42181b0874', '64412e27-169e-44ea-a101-74ebf8cb82d9', '802b5d84-e898-4077-b2d2-45a04d17e4e4', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('0eb8e92a-d0f8-4d83-b4b8-a1eadd25470c', 'cb2c22ac-87de-44e4-9638-35979f6af667', '802b5d84-e898-4077-b2d2-45a04d17e4e4', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('26b8a5b8-e26b-4573-970f-fb6976b0c013', '9ba179ed-d26d-4828-a0f6-8836c2063992', '802b5d84-e898-4077-b2d2-45a04d17e4e4', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('ae218b4b-5930-4c79-af26-66b7892c0379', '444bbc7d-86f8-4258-9429-e73ce69a9e41', '802b5d84-e898-4077-b2d2-45a04d17e4e4', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('ee464af1-79d1-41c7-b191-cfdb7ba8599a', '994ebe5b-db43-4cd3-a1ee-693c2ef681ef', '802b5d84-e898-4077-b2d2-45a04d17e4e4', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('05635029-832b-42ec-9076-05f4d7f8c94b', '87031f89-d9b0-449f-84f4-c9b6dff15a9a', '802b5d84-e898-4077-b2d2-45a04d17e4e4', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('60abafcb-fc42-4d7b-9402-6b5e1666ee82', '853b8f16-20c9-42e9-a04d-daa0237823ca', '802b5d84-e898-4077-b2d2-45a04d17e4e4', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('8b65e8b0-333a-434b-81bd-187da3f1eecf', '2df936cc-f04a-4269-85ca-5dcf8099e184', '802b5d84-e898-4077-b2d2-45a04d17e4e4', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('28ece90d-51f2-4b9d-8e84-7cce7a876072', '58b79c83-ba88-430b-a9c9-d549d43b3600', '802b5d84-e898-4077-b2d2-45a04d17e4e4', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('560b7560-c057-4841-a221-cd59881d0b96', 'c2efd8b2-7ab2-45b8-b7c9-425ac7d36b56', '802b5d84-e898-4077-b2d2-45a04d17e4e4', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('a6edef27-9507-43d9-9e72-0f2b20e289b0', 'd7c3523c-d595-44f0-ad72-ddf8ae299cbb', '802b5d84-e898-4077-b2d2-45a04d17e4e4', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('ced13799-a211-40b9-ad55-e19032478328', 'd2befc26-a318-4ae1-a1c6-c71dd7e7d79d', '802b5d84-e898-4077-b2d2-45a04d17e4e4', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('0b87803b-7194-4fdc-ac19-023879c370eb', 'dd81de86-7f96-482a-b967-2e8e4cd9d910', '802b5d84-e898-4077-b2d2-45a04d17e4e4', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('6e1d66f6-ca2d-432a-8abc-d1eaa1712c17', 'a1845f87-cece-4cb0-91c7-7bd68f439063', '802b5d84-e898-4077-b2d2-45a04d17e4e4', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('b2e8de60-b3e5-4294-8785-05554d556092', '6c44fd5e-560d-4b8a-9d61-03c3e66872ef', '802b5d84-e898-4077-b2d2-45a04d17e4e4', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('8e1a6cc9-c83c-4ab5-8221-9ca900a96f85', 'fff06898-5361-4464-9e75-8b1435e46d15', '802b5d84-e898-4077-b2d2-45a04d17e4e4', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('8d3f4eee-29be-4126-b6d5-dd907e194ad6', '588636d6-7193-4a2b-be5f-cafe112d3bf5', '802b5d84-e898-4077-b2d2-45a04d17e4e4', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('cf6ffced-520f-499e-aade-ca9a6b6f9ccc', '64412e27-169e-44ea-a101-74ebf8cb82d9', '28cb6008-bddc-4894-83de-7919a02db956', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('075c947c-ca7a-4ee3-ad50-143ca765f999', 'cb2c22ac-87de-44e4-9638-35979f6af667', '28cb6008-bddc-4894-83de-7919a02db956', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('b5cf1214-4a79-4c1a-b32d-1e577ca5d7af', '2d7ed5a0-fb21-4927-9a25-647c17d29668', '28cb6008-bddc-4894-83de-7919a02db956', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('eaba76d8-eda5-4928-a195-18d180769181', '9ba179ed-d26d-4828-a0f6-8836c2063992', '28cb6008-bddc-4894-83de-7919a02db956', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('e8138628-aa14-42ca-b133-62407c4b3dd3', '444bbc7d-86f8-4258-9429-e73ce69a9e41', '28cb6008-bddc-4894-83de-7919a02db956', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('79060e46-c57d-4ee1-a4e0-1b4a1fb77f0d', 'c2f39b5b-6aeb-4b82-8541-d25920314339', '28cb6008-bddc-4894-83de-7919a02db956', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('dd7cbfe9-00a8-40fe-be49-0a1e62315e12', '994ebe5b-db43-4cd3-a1ee-693c2ef681ef', '28cb6008-bddc-4894-83de-7919a02db956', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('95c2f8da-1aed-4521-814f-35cfb66777a7', 'fcf62145-e196-4777-a201-77f6693810c4', '28cb6008-bddc-4894-83de-7919a02db956', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('972d377c-8131-4406-833a-cb7e19a20e90', '87076e41-40fd-4832-bbbc-1e5211878264', '28cb6008-bddc-4894-83de-7919a02db956', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('412a1dd0-41d9-452d-b4c4-04c90bc942d1', '4526d150-cfcf-4b04-ab54-12789b788829', '28cb6008-bddc-4894-83de-7919a02db956', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('388323e1-cff2-4e89-a7c9-24724a0c6759', '9e9e9485-bbad-4aa4-9e2d-f8362dbbbba1', '28cb6008-bddc-4894-83de-7919a02db956', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('be599070-7149-40c6-9c90-128018290dd1', 'baddeb10-3f99-4843-859c-50cc51659153', '28cb6008-bddc-4894-83de-7919a02db956', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('8ee1df06-86bf-4337-8d0b-408352696da7', '182709ef-635b-40a4-9ccd-774dd39b380f', '28cb6008-bddc-4894-83de-7919a02db956', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('7bd85834-a925-4d9e-9fba-029e07ae6052', 'b887e221-2edd-4a37-9b65-209c92b8997d', '28cb6008-bddc-4894-83de-7919a02db956', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('f9c77d16-85d2-4bae-9ff2-298c36b957f7', '58b79c83-ba88-430b-a9c9-d549d43b3600', '28cb6008-bddc-4894-83de-7919a02db956', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('322eebef-efd3-41f4-ae1b-a3817c6e5f35', 'd7c3523c-d595-44f0-ad72-ddf8ae299cbb', '28cb6008-bddc-4894-83de-7919a02db956', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('5146ab5f-290a-4d68-8226-6b4e7f21b6cd', 'ee83822a-75aa-4b08-8772-c2cd40443532', '28cb6008-bddc-4894-83de-7919a02db956', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('921844c3-7d28-43cd-a617-5bc49a7210fa', 'bfca2841-ee2c-4981-9c74-3ef605fc1c3d', '28cb6008-bddc-4894-83de-7919a02db956', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('c9263fdb-8209-48ea-993d-2806a71ef3d5', 'a1845f87-cece-4cb0-91c7-7bd68f439063', '28cb6008-bddc-4894-83de-7919a02db956', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('aaeefd7f-854a-4ebd-95e7-d5e7929f70e7', 'fff06898-5361-4464-9e75-8b1435e46d15', '28cb6008-bddc-4894-83de-7919a02db956', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('657d3810-8a4d-43b5-b530-9010d39c6605', '730f379c-986b-4274-8b88-3e90e5bbba25', '28cb6008-bddc-4894-83de-7919a02db956', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('fdbc16c0-6a5f-441b-9c89-83be6d0aa759', '2c5ab7ea-f37f-4917-bec2-202b20d25ff0', '28cb6008-bddc-4894-83de-7919a02db956', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('ac58d0c9-0cfb-4d25-9756-24947532fe5d', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2b549267-2f56-4fa1-ba24-bdebc6b7e89c', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('55b84f7c-ab8f-4d7f-83b8-fd059b1f2d2f', 'cb2c22ac-87de-44e4-9638-35979f6af667', '2b549267-2f56-4fa1-ba24-bdebc6b7e89c', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('88984278-f3c6-4342-b70a-96312b163dac', '2d7ed5a0-fb21-4927-9a25-647c17d29668', '2b549267-2f56-4fa1-ba24-bdebc6b7e89c', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('d97ebc9b-a90e-4069-acb5-35f60120ad3d', '9ba179ed-d26d-4828-a0f6-8836c2063992', '2b549267-2f56-4fa1-ba24-bdebc6b7e89c', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('a8273cea-c24f-4a9d-932c-71eaa1052099', 'a4cd3cac-3b49-4b36-93e7-13fbb14ce76f', '2b549267-2f56-4fa1-ba24-bdebc6b7e89c', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('29e4dede-b2aa-4b03-b22d-12cbad1a4eed', '8cbf0aa4-f707-4cd3-8258-0c72f8fb4db0', '2b549267-2f56-4fa1-ba24-bdebc6b7e89c', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('d1fb6aa3-eb46-4f9e-85f4-1d53f7a043bb', '444bbc7d-86f8-4258-9429-e73ce69a9e41', '2b549267-2f56-4fa1-ba24-bdebc6b7e89c', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('fbd88e3e-b9a2-48b0-a2ff-d5bb79933196', '205b0afa-3efa-4bdf-9bc0-3f6449ff5c1a', '2b549267-2f56-4fa1-ba24-bdebc6b7e89c', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('7b9b9aa7-fe55-4f87-954e-47b7712310d2', '2df936cc-f04a-4269-85ca-5dcf8099e184', '2b549267-2f56-4fa1-ba24-bdebc6b7e89c', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('0f8c0238-ee42-41fb-a455-4b815d112f8d', 'b887e221-2edd-4a37-9b65-209c92b8997d', '2b549267-2f56-4fa1-ba24-bdebc6b7e89c', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('24bde89b-d5a8-49dd-bf5a-e7529afbce75', '58b79c83-ba88-430b-a9c9-d549d43b3600', '2b549267-2f56-4fa1-ba24-bdebc6b7e89c', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('ca5b3d75-caa7-4609-905b-dad1b3576a77', 'c2efd8b2-7ab2-45b8-b7c9-425ac7d36b56', '2b549267-2f56-4fa1-ba24-bdebc6b7e89c', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('54f32c2e-34e1-464c-ad7c-2f89be1efcd7', '0bea60a7-9789-42bb-a217-22d142cf3b1b', '2b549267-2f56-4fa1-ba24-bdebc6b7e89c', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('2bc8a589-def1-484c-98ee-544c1e5d0f4c', 'ee83822a-75aa-4b08-8772-c2cd40443532', '2b549267-2f56-4fa1-ba24-bdebc6b7e89c', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('6eb1583b-14a9-47cf-bb60-5eede398a7d8', '097ad133-9434-44d0-ad2f-16db49f0be9c', '2b549267-2f56-4fa1-ba24-bdebc6b7e89c', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('d4cbec5e-7cab-46e7-83ee-b736aa9f4085', 'd2befc26-a318-4ae1-a1c6-c71dd7e7d79d', '2b549267-2f56-4fa1-ba24-bdebc6b7e89c', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('086b55ea-9a3f-48f5-852c-b9f4d9deeac5', 'a1845f87-cece-4cb0-91c7-7bd68f439063', '2b549267-2f56-4fa1-ba24-bdebc6b7e89c', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('396b7228-d9a6-4168-8c29-e239c95737ab', '6c44fd5e-560d-4b8a-9d61-03c3e66872ef', '2b549267-2f56-4fa1-ba24-bdebc6b7e89c', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('a15cfbcd-4128-46d6-bbd5-a18996308cdb', 'e45e5e33-d62e-47cb-9d54-cee790fc6b5f', '2b549267-2f56-4fa1-ba24-bdebc6b7e89c', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('b77457a4-3ccf-4b29-a2f3-7110c8e44df7', '75dd8ca8-14aa-4dbb-aac0-c16bcb1ef61f', '2b549267-2f56-4fa1-ba24-bdebc6b7e89c', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('53756ce1-0ece-49b3-abff-a0f9a16443c2', '64412e27-169e-44ea-a101-74ebf8cb82d9', '5aa6ffd0-b35b-41c0-8bdd-9c618c27579e', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('5fbb92ea-d56a-44f8-96d2-e61201a1066d', 'cb2c22ac-87de-44e4-9638-35979f6af667', '5aa6ffd0-b35b-41c0-8bdd-9c618c27579e', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('5be31ea5-51f9-4a35-96d1-1dcf7dfff3dc', '2d3c1e66-1835-457f-93e9-265fe483feee', '5aa6ffd0-b35b-41c0-8bdd-9c618c27579e', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('23d3ff7e-a1f7-4b49-a1ae-37b768799533', '9ba179ed-d26d-4828-a0f6-8836c2063992', '5aa6ffd0-b35b-41c0-8bdd-9c618c27579e', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('c0f77e47-6914-41aa-99ef-1e9fa7a66430', 'a4cd3cac-3b49-4b36-93e7-13fbb14ce76f', '5aa6ffd0-b35b-41c0-8bdd-9c618c27579e', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('054a364c-358e-45c6-a30a-9ae914749d1c', '994ebe5b-db43-4cd3-a1ee-693c2ef681ef', '5aa6ffd0-b35b-41c0-8bdd-9c618c27579e', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('576d017e-dd72-4e7e-a8d1-0dbc40545b22', '87076e41-40fd-4832-bbbc-1e5211878264', '5aa6ffd0-b35b-41c0-8bdd-9c618c27579e', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('fe3c3750-4634-484e-8b10-bc8277580955', '4526d150-cfcf-4b04-ab54-12789b788829', '5aa6ffd0-b35b-41c0-8bdd-9c618c27579e', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('3c2959a3-3a21-44b3-b1bf-5e4bda4ca528', '2d5137ae-9d77-4a12-94ea-fda383a8db10', '5aa6ffd0-b35b-41c0-8bdd-9c618c27579e', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('02e445a5-aa3a-4345-81ce-ec483b026174', '205b0afa-3efa-4bdf-9bc0-3f6449ff5c1a', '5aa6ffd0-b35b-41c0-8bdd-9c618c27579e', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('64e11b7d-3935-476d-9b4a-2f5d707af392', '9e9e9485-bbad-4aa4-9e2d-f8362dbbbba1', '5aa6ffd0-b35b-41c0-8bdd-9c618c27579e', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('2fbcc974-f2c9-4405-af48-47b43ca45cf7', 'db95956f-786e-46c7-87c1-ad5ebaacf355', '5aa6ffd0-b35b-41c0-8bdd-9c618c27579e', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('7839cb6c-73ee-400a-9d8b-1d6e38184824', '2df936cc-f04a-4269-85ca-5dcf8099e184', '5aa6ffd0-b35b-41c0-8bdd-9c618c27579e', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('73902ab8-86ad-47c5-b082-6dc560ce22e8', 'c2efd8b2-7ab2-45b8-b7c9-425ac7d36b56', '5aa6ffd0-b35b-41c0-8bdd-9c618c27579e', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('b436102f-13ef-4ddb-984e-6f3cf53ea44d', 'd7c3523c-d595-44f0-ad72-ddf8ae299cbb', '5aa6ffd0-b35b-41c0-8bdd-9c618c27579e', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('8b20ec58-0be2-413a-b96b-71f0a89b225e', 'ffed4ce4-53b7-497e-a449-e3dee93aec1d', '5aa6ffd0-b35b-41c0-8bdd-9c618c27579e', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('846482ed-fc3c-4eac-aeb8-0dac6ec773fb', 'ee83822a-75aa-4b08-8772-c2cd40443532', '5aa6ffd0-b35b-41c0-8bdd-9c618c27579e', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('f75c9df3-5ae2-4bff-b9eb-2ab6c7f49436', 'd2befc26-a318-4ae1-a1c6-c71dd7e7d79d', '5aa6ffd0-b35b-41c0-8bdd-9c618c27579e', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('aae9f601-59c5-4eb1-a204-b8ca8d4d0702', 'dd81de86-7f96-482a-b967-2e8e4cd9d910', '5aa6ffd0-b35b-41c0-8bdd-9c618c27579e', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('3376cbfc-bdf6-461b-b646-f0de8aa9df11', 'a1845f87-cece-4cb0-91c7-7bd68f439063', '5aa6ffd0-b35b-41c0-8bdd-9c618c27579e', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('cb758758-faae-4735-a126-5107b3dfb9e2', 'e1ac8c3c-1c60-4c14-8143-84c3c8c66934', '5aa6ffd0-b35b-41c0-8bdd-9c618c27579e', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('4f8dcddc-9cb9-4c5d-9f67-b71dca2c7963', '730f379c-986b-4274-8b88-3e90e5bbba25', '5aa6ffd0-b35b-41c0-8bdd-9c618c27579e', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('b483fb14-1e38-4f73-b7da-d5e2c4106778', '64412e27-169e-44ea-a101-74ebf8cb82d9', '45b7f477-0ce1-4b46-bccb-5f80b508da35', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('00eb0b4e-97eb-430d-8bcd-02425a0e5cf0', 'cb2c22ac-87de-44e4-9638-35979f6af667', '45b7f477-0ce1-4b46-bccb-5f80b508da35', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('8b0c01d8-4078-467d-9939-e95191a7ed5d', '2d7ed5a0-fb21-4927-9a25-647c17d29668', '45b7f477-0ce1-4b46-bccb-5f80b508da35', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('325b8295-5386-4300-8328-34a804bce116', '8cbf0aa4-f707-4cd3-8258-0c72f8fb4db0', '45b7f477-0ce1-4b46-bccb-5f80b508da35', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('9e03896a-a68c-40c5-add0-a3db58360737', 'ad3c4eb3-8ddb-45a0-9df2-d6ec5d14fbbc', '45b7f477-0ce1-4b46-bccb-5f80b508da35', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('58367d5d-8f3f-4819-9f34-cb5642f2b043', '87031f89-d9b0-449f-84f4-c9b6dff15a9a', '45b7f477-0ce1-4b46-bccb-5f80b508da35', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('be7ec0d3-8a09-46bc-b9f7-a5e7c00698cf', 'fcf62145-e196-4777-a201-77f6693810c4', '45b7f477-0ce1-4b46-bccb-5f80b508da35', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('7009680c-1a82-48d6-9b7d-553634234bc8', '4526d150-cfcf-4b04-ab54-12789b788829', '45b7f477-0ce1-4b46-bccb-5f80b508da35', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('6352368d-a41c-4176-b045-484eb7fb0b02', '205b0afa-3efa-4bdf-9bc0-3f6449ff5c1a', '45b7f477-0ce1-4b46-bccb-5f80b508da35', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('10b40c66-45c9-428e-9299-3640244832f2', '9e9e9485-bbad-4aa4-9e2d-f8362dbbbba1', '45b7f477-0ce1-4b46-bccb-5f80b508da35', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('01524478-45ae-47ce-a683-81bd0c44c525', '2df936cc-f04a-4269-85ca-5dcf8099e184', '45b7f477-0ce1-4b46-bccb-5f80b508da35', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('2ab45cb4-016e-4737-b5af-9606cf324cc7', 'b887e221-2edd-4a37-9b65-209c92b8997d', '45b7f477-0ce1-4b46-bccb-5f80b508da35', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('d7f46909-83e9-482a-a723-c7e98315c660', 'd7c3523c-d595-44f0-ad72-ddf8ae299cbb', '45b7f477-0ce1-4b46-bccb-5f80b508da35', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('07e05f34-2c13-4b2f-b696-5fad2ecdbf59', 'ffed4ce4-53b7-497e-a449-e3dee93aec1d', '45b7f477-0ce1-4b46-bccb-5f80b508da35', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('7d5ffe6b-0d51-44a4-af41-0632e14deddd', 'ee83822a-75aa-4b08-8772-c2cd40443532', '45b7f477-0ce1-4b46-bccb-5f80b508da35', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('38eb4c7c-651c-4640-8e9c-7e1a3ed23b49', '097ad133-9434-44d0-ad2f-16db49f0be9c', '45b7f477-0ce1-4b46-bccb-5f80b508da35', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('7c1523f5-db95-4346-9ca8-f655114f9915', 'd2befc26-a318-4ae1-a1c6-c71dd7e7d79d', '45b7f477-0ce1-4b46-bccb-5f80b508da35', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('e9fd8a16-aa10-4f95-8897-d0eef02afc8b', 'a1845f87-cece-4cb0-91c7-7bd68f439063', '45b7f477-0ce1-4b46-bccb-5f80b508da35', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('173365ac-8474-4677-bf01-6a17d07a512a', 'e1ac8c3c-1c60-4c14-8143-84c3c8c66934', '45b7f477-0ce1-4b46-bccb-5f80b508da35', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('e42b762a-2b64-4e7f-b752-02e378a33914', '730f379c-986b-4274-8b88-3e90e5bbba25', '45b7f477-0ce1-4b46-bccb-5f80b508da35', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('ad013830-2219-43af-aa39-1dbfeda6abfe', '2c5ab7ea-f37f-4917-bec2-202b20d25ff0', '45b7f477-0ce1-4b46-bccb-5f80b508da35', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('50a44bfd-fedd-44f2-b828-4ec23ec1dc5d', '64412e27-169e-44ea-a101-74ebf8cb82d9', '547b7170-078e-4d3a-a702-178d22490cf9', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('52d7e010-45b8-48d4-9f14-750adc041d82', 'cb2c22ac-87de-44e4-9638-35979f6af667', '547b7170-078e-4d3a-a702-178d22490cf9', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('4f5f6455-1eba-4993-9cc0-8b2c53363cc8', '2d7ed5a0-fb21-4927-9a25-647c17d29668', '547b7170-078e-4d3a-a702-178d22490cf9', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('febd9996-ad78-466d-82db-c21e52e30b5b', 'a4cd3cac-3b49-4b36-93e7-13fbb14ce76f', '547b7170-078e-4d3a-a702-178d22490cf9', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('796c7303-d91d-4750-a302-57212f0b70db', '8cbf0aa4-f707-4cd3-8258-0c72f8fb4db0', '547b7170-078e-4d3a-a702-178d22490cf9', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('5afe71bf-1224-44a7-8e8f-11ccbf3cd33d', '853b8f16-20c9-42e9-a04d-daa0237823ca', '547b7170-078e-4d3a-a702-178d22490cf9', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('a55edd12-3f8d-49b7-8715-0bd85214590c', '2d5137ae-9d77-4a12-94ea-fda383a8db10', '547b7170-078e-4d3a-a702-178d22490cf9', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('40b3ae52-b377-4941-9370-cfc6ea19718f', 'b887e221-2edd-4a37-9b65-209c92b8997d', '547b7170-078e-4d3a-a702-178d22490cf9', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('531b2146-0b24-4677-bc92-8c770d9ed06b', 'c2efd8b2-7ab2-45b8-b7c9-425ac7d36b56', '547b7170-078e-4d3a-a702-178d22490cf9', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('73cee4ff-9201-4754-beae-9aa241a0e908', 'd7c3523c-d595-44f0-ad72-ddf8ae299cbb', '547b7170-078e-4d3a-a702-178d22490cf9', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('7e93be9b-5d4f-4dfb-9cdb-b1770c6e1020', 'ffed4ce4-53b7-497e-a449-e3dee93aec1d', '547b7170-078e-4d3a-a702-178d22490cf9', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('18727629-4c88-4b55-9365-6e93b2c2dfde', 'ee83822a-75aa-4b08-8772-c2cd40443532', '547b7170-078e-4d3a-a702-178d22490cf9', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('0d998038-7e61-4426-a4a3-981c894e355a', '097ad133-9434-44d0-ad2f-16db49f0be9c', '547b7170-078e-4d3a-a702-178d22490cf9', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('fb0f59e4-cfaa-4d1c-8f00-1486e10f30a6', 'bfca2841-ee2c-4981-9c74-3ef605fc1c3d', '547b7170-078e-4d3a-a702-178d22490cf9', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('4252d9b1-7b16-424c-b6fb-4280e9b81752', 'a1845f87-cece-4cb0-91c7-7bd68f439063', '547b7170-078e-4d3a-a702-178d22490cf9', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('7f889713-9cc4-4183-8d9a-928875e34751', '6c44fd5e-560d-4b8a-9d61-03c3e66872ef', '547b7170-078e-4d3a-a702-178d22490cf9', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('5cdcae70-178b-4a98-98ad-01aa09f3651f', 'fff06898-5361-4464-9e75-8b1435e46d15', '547b7170-078e-4d3a-a702-178d22490cf9', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('521da264-e477-4b84-b824-ba0489450e28', 'e45e5e33-d62e-47cb-9d54-cee790fc6b5f', '547b7170-078e-4d3a-a702-178d22490cf9', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('e33c126c-1020-44fb-8065-204034336284', '730f379c-986b-4274-8b88-3e90e5bbba25', '547b7170-078e-4d3a-a702-178d22490cf9', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('be9f6f6b-4edd-4137-b7ea-cbca75ec6d53', '588636d6-7193-4a2b-be5f-cafe112d3bf5', '547b7170-078e-4d3a-a702-178d22490cf9', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('0473558c-af50-4c93-bf80-f4e3da6b636d', '62973440-0374-4c2c-a49b-b771b7640912', '547b7170-078e-4d3a-a702-178d22490cf9', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('f43c5d94-ffe7-4c55-a2dd-a9f5bb3bd003', '7179898a-c353-4917-8dbd-62e10ea3249e', '547b7170-078e-4d3a-a702-178d22490cf9', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('185f97dc-dca4-4999-8bdf-9a3f01c2d0d6', '64412e27-169e-44ea-a101-74ebf8cb82d9', 'f2c54cc7-41e1-4567-9c2c-47eb5b4ab153', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('634dae86-3a9a-4b00-95dc-6cf0f8c43f00', 'cb2c22ac-87de-44e4-9638-35979f6af667', 'f2c54cc7-41e1-4567-9c2c-47eb5b4ab153', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('7e9e7c53-8aac-44ec-aab4-58096d3cc69a', '2d3c1e66-1835-457f-93e9-265fe483feee', 'f2c54cc7-41e1-4567-9c2c-47eb5b4ab153', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('c9889788-3cbd-4cbf-9fb4-e7ce8525f9db', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'f2c54cc7-41e1-4567-9c2c-47eb5b4ab153', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('6ffac56d-ceb4-4f31-805d-ecebd5e593d3', 'ca3040f2-e173-40a5-aab7-6ef15965ce43', 'f2c54cc7-41e1-4567-9c2c-47eb5b4ab153', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('b6e86488-d847-4561-a6dc-2e07e01e1e26', 'a4cd3cac-3b49-4b36-93e7-13fbb14ce76f', 'f2c54cc7-41e1-4567-9c2c-47eb5b4ab153', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('7063e94b-e39c-4650-8727-f6e55557d19f', 'ad3c4eb3-8ddb-45a0-9df2-d6ec5d14fbbc', 'f2c54cc7-41e1-4567-9c2c-47eb5b4ab153', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('0b11f5ec-c750-4f88-9db4-37166e5eed6d', '205b0afa-3efa-4bdf-9bc0-3f6449ff5c1a', 'f2c54cc7-41e1-4567-9c2c-47eb5b4ab153', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('fea12d26-654e-483b-903e-7663272ffa1b', '9e9e9485-bbad-4aa4-9e2d-f8362dbbbba1', 'f2c54cc7-41e1-4567-9c2c-47eb5b4ab153', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('0bf2b480-8a94-445c-8c5c-40a46c919def', 'db95956f-786e-46c7-87c1-ad5ebaacf355', 'f2c54cc7-41e1-4567-9c2c-47eb5b4ab153', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('5c89f6ef-2ccd-4cc0-a4ba-d4e6ec1e911d', 'baddeb10-3f99-4843-859c-50cc51659153', 'f2c54cc7-41e1-4567-9c2c-47eb5b4ab153', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('1cd35141-9142-462a-9ece-b74827435a7d', '182709ef-635b-40a4-9ccd-774dd39b380f', 'f2c54cc7-41e1-4567-9c2c-47eb5b4ab153', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('0e6fb9f3-6f10-4b15-aeb2-765745a2d782', 'd7c3523c-d595-44f0-ad72-ddf8ae299cbb', 'f2c54cc7-41e1-4567-9c2c-47eb5b4ab153', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('5b7925d8-4694-4c66-87ac-d8773aff6551', 'a1845f87-cece-4cb0-91c7-7bd68f439063', 'f2c54cc7-41e1-4567-9c2c-47eb5b4ab153', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('9e73be7d-762d-48af-be1b-cb4af317bd4d', '6c44fd5e-560d-4b8a-9d61-03c3e66872ef', 'f2c54cc7-41e1-4567-9c2c-47eb5b4ab153', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('500edc65-b0f2-466f-be62-d3b6be4101fe', '62973440-0374-4c2c-a49b-b771b7640912', 'f2c54cc7-41e1-4567-9c2c-47eb5b4ab153', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('0cd191ee-455b-4670-af62-351195764282', '64412e27-169e-44ea-a101-74ebf8cb82d9', '2478cb4a-0fc7-4bf4-a50c-e8f05c2aaa13', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('1cf0fa5d-5586-4336-b0f0-ec53ca80513b', '2d7ed5a0-fb21-4927-9a25-647c17d29668', '2478cb4a-0fc7-4bf4-a50c-e8f05c2aaa13', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('928e67d9-fa2f-445a-a2a9-7101474b3f81', '444bbc7d-86f8-4258-9429-e73ce69a9e41', '2478cb4a-0fc7-4bf4-a50c-e8f05c2aaa13', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('8ff1b049-1372-494c-aa2f-10114182154c', '87076e41-40fd-4832-bbbc-1e5211878264', '2478cb4a-0fc7-4bf4-a50c-e8f05c2aaa13', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('91defb35-a4f4-4dc1-88bb-dedff87abdb2', '4526d150-cfcf-4b04-ab54-12789b788829', '2478cb4a-0fc7-4bf4-a50c-e8f05c2aaa13', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('e5494928-396f-40e3-972d-477596f4e8bb', '853b8f16-20c9-42e9-a04d-daa0237823ca', '2478cb4a-0fc7-4bf4-a50c-e8f05c2aaa13', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('7d324869-2ea6-49bd-91d3-91e6bbf630f4', '9e9e9485-bbad-4aa4-9e2d-f8362dbbbba1', '2478cb4a-0fc7-4bf4-a50c-e8f05c2aaa13', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('0bcacee6-89de-4136-a809-7c73f22df0af', '182709ef-635b-40a4-9ccd-774dd39b380f', '2478cb4a-0fc7-4bf4-a50c-e8f05c2aaa13', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('eeb2bab1-d71f-4641-b69a-c1a08d804a52', '4a182d8b-a553-455c-8485-f834da6de4e9', '2478cb4a-0fc7-4bf4-a50c-e8f05c2aaa13', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('91221e67-53a1-4548-8b63-34fdd7cc6cb5', 'b887e221-2edd-4a37-9b65-209c92b8997d', '2478cb4a-0fc7-4bf4-a50c-e8f05c2aaa13', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('21890728-5b03-45e5-9340-526b742a9152', 'd7c3523c-d595-44f0-ad72-ddf8ae299cbb', '2478cb4a-0fc7-4bf4-a50c-e8f05c2aaa13', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('e742e922-9c4a-474e-9058-3bd116a01439', '06ccbc31-e870-41c9-9293-b54aef58de21', '2478cb4a-0fc7-4bf4-a50c-e8f05c2aaa13', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('a4dff2b6-f172-438d-adc4-7c9c1cd59db2', '097ad133-9434-44d0-ad2f-16db49f0be9c', '2478cb4a-0fc7-4bf4-a50c-e8f05c2aaa13', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('211526e9-ef11-4b55-a338-35dea9ccbc1f', 'd2befc26-a318-4ae1-a1c6-c71dd7e7d79d', '2478cb4a-0fc7-4bf4-a50c-e8f05c2aaa13', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('2f70f19c-9c70-4dbe-a158-c0f7b537dd09', 'bfca2841-ee2c-4981-9c74-3ef605fc1c3d', '2478cb4a-0fc7-4bf4-a50c-e8f05c2aaa13', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('71ba72d5-ebf7-440a-b1c0-bc424af940d3', 'a1845f87-cece-4cb0-91c7-7bd68f439063', '2478cb4a-0fc7-4bf4-a50c-e8f05c2aaa13', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('924c2996-7b3f-4383-b201-c07212a8a0db', 'fff06898-5361-4464-9e75-8b1435e46d15', '2478cb4a-0fc7-4bf4-a50c-e8f05c2aaa13', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('0454b453-b5b2-4d0d-a301-fbca1abb5230', '75dd8ca8-14aa-4dbb-aac0-c16bcb1ef61f', '2478cb4a-0fc7-4bf4-a50c-e8f05c2aaa13', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('5ca40baf-2c43-4c41-84ea-de43880003e8', 'cb2c22ac-87de-44e4-9638-35979f6af667', 'a7a2fd76-64cf-41e1-be53-0ebc172b605a', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('8593feeb-1350-4063-a25c-c37c1dfb7183', '8cbf0aa4-f707-4cd3-8258-0c72f8fb4db0', 'a7a2fd76-64cf-41e1-be53-0ebc172b605a', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('291950c0-b740-4e4c-8f31-a02ca7c040f7', 'c2f39b5b-6aeb-4b82-8541-d25920314339', 'a7a2fd76-64cf-41e1-be53-0ebc172b605a', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('64e7f01f-8b4f-4988-be69-5b3837b622ec', '87076e41-40fd-4832-bbbc-1e5211878264', 'a7a2fd76-64cf-41e1-be53-0ebc172b605a', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('4fdce85e-6b63-4245-a1f1-74e918afaffb', '9e9e9485-bbad-4aa4-9e2d-f8362dbbbba1', 'a7a2fd76-64cf-41e1-be53-0ebc172b605a', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('433d77e3-31bf-4e85-a17b-38f0825c2425', '182709ef-635b-40a4-9ccd-774dd39b380f', 'a7a2fd76-64cf-41e1-be53-0ebc172b605a', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('ce129456-04bd-4f3a-a906-8ab91baf2c1d', '06ccbc31-e870-41c9-9293-b54aef58de21', 'a7a2fd76-64cf-41e1-be53-0ebc172b605a', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('914e2574-0dc1-4301-95b8-4cda2cf91b59', '097ad133-9434-44d0-ad2f-16db49f0be9c', 'a7a2fd76-64cf-41e1-be53-0ebc172b605a', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('4cd78118-19de-4357-a847-a2f353a38b20', 'd2befc26-a318-4ae1-a1c6-c71dd7e7d79d', 'a7a2fd76-64cf-41e1-be53-0ebc172b605a', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('a9c5da25-ac01-4dd4-a243-ad150bbd0339', 'bfca2841-ee2c-4981-9c74-3ef605fc1c3d', 'a7a2fd76-64cf-41e1-be53-0ebc172b605a', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('78c06a1f-26c0-4c99-aeb4-9f9ff6cb25a5', 'fff06898-5361-4464-9e75-8b1435e46d15', 'a7a2fd76-64cf-41e1-be53-0ebc172b605a', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('d53efb02-248a-4791-a72b-97aa4959e0b8', 'e1ac8c3c-1c60-4c14-8143-84c3c8c66934', 'a7a2fd76-64cf-41e1-be53-0ebc172b605a', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('6958e12c-f3e4-4ea6-8394-bce05cbf6fe1', '730f379c-986b-4274-8b88-3e90e5bbba25', 'a7a2fd76-64cf-41e1-be53-0ebc172b605a', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('58a1ef74-3e11-4781-8d89-4b4e857e107f', '75dd8ca8-14aa-4dbb-aac0-c16bcb1ef61f', 'a7a2fd76-64cf-41e1-be53-0ebc172b605a', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('2c83f469-6aad-492e-9f71-83bdac217045', '62973440-0374-4c2c-a49b-b771b7640912', 'a7a2fd76-64cf-41e1-be53-0ebc172b605a', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('99b75385-fda1-4ad6-b071-3c2b08bc3467', '7179898a-c353-4917-8dbd-62e10ea3249e', 'a7a2fd76-64cf-41e1-be53-0ebc172b605a', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('a9f7701c-405a-44a0-ad3e-d751105ed6b1', '64412e27-169e-44ea-a101-74ebf8cb82d9', '6c1be796-e383-4344-80eb-1d24392eb0a8', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('88051b96-3896-4c8b-9b8e-95cf57e58dfa', 'cb2c22ac-87de-44e4-9638-35979f6af667', '6c1be796-e383-4344-80eb-1d24392eb0a8', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('ac38c444-5b6f-4f58-a441-73b928e4e29f', '2d7ed5a0-fb21-4927-9a25-647c17d29668', '6c1be796-e383-4344-80eb-1d24392eb0a8', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('88bd6ea9-481f-4446-ab5f-f337610175f3', 'a4cd3cac-3b49-4b36-93e7-13fbb14ce76f', '6c1be796-e383-4344-80eb-1d24392eb0a8', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('9b6d64b9-5724-48e1-bf3d-f74d3a6580ad', 'c2f39b5b-6aeb-4b82-8541-d25920314339', '6c1be796-e383-4344-80eb-1d24392eb0a8', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('7cc1d28e-1224-4d23-8295-f9f979170ee4', '994ebe5b-db43-4cd3-a1ee-693c2ef681ef', '6c1be796-e383-4344-80eb-1d24392eb0a8', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('8e661566-a140-4fec-b693-e5f1b34a575b', '87031f89-d9b0-449f-84f4-c9b6dff15a9a', '6c1be796-e383-4344-80eb-1d24392eb0a8', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('71ab4d60-9b0a-4c23-86b2-3fada1b19036', 'fcf62145-e196-4777-a201-77f6693810c4', '6c1be796-e383-4344-80eb-1d24392eb0a8', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('225439bf-8412-403d-aa51-e21bf754b9ca', '87076e41-40fd-4832-bbbc-1e5211878264', '6c1be796-e383-4344-80eb-1d24392eb0a8', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('f584f382-520c-48c5-b73a-7772ca677cda', '4526d150-cfcf-4b04-ab54-12789b788829', '6c1be796-e383-4344-80eb-1d24392eb0a8', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('22699cd2-2f9c-444f-af75-e6b0e8be9e96', 'b887e221-2edd-4a37-9b65-209c92b8997d', '6c1be796-e383-4344-80eb-1d24392eb0a8', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('1bc25880-dbe0-4e96-a651-16c459ecfbb2', 'c2efd8b2-7ab2-45b8-b7c9-425ac7d36b56', '6c1be796-e383-4344-80eb-1d24392eb0a8', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('d485d16b-0d4d-4b42-abdd-6e835e276a4f', 'd7c3523c-d595-44f0-ad72-ddf8ae299cbb', '6c1be796-e383-4344-80eb-1d24392eb0a8', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('0c1e075a-88a4-4dce-ac5e-9997192d622f', 'ee83822a-75aa-4b08-8772-c2cd40443532', '6c1be796-e383-4344-80eb-1d24392eb0a8', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('8c133343-78dc-4d4c-8338-bb0dc99e0889', '097ad133-9434-44d0-ad2f-16db49f0be9c', '6c1be796-e383-4344-80eb-1d24392eb0a8', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('304a6ccd-0e69-4ae7-9b55-3ee77b84024a', 'a1845f87-cece-4cb0-91c7-7bd68f439063', '6c1be796-e383-4344-80eb-1d24392eb0a8', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('c2e75822-0045-4bd7-a89a-ed1dfde242ae', '730f379c-986b-4274-8b88-3e90e5bbba25', '6c1be796-e383-4344-80eb-1d24392eb0a8', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('69d75afd-83fa-4d3b-a783-b0bd4f397c3a', '75dd8ca8-14aa-4dbb-aac0-c16bcb1ef61f', '6c1be796-e383-4344-80eb-1d24392eb0a8', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('d842c3cc-3b13-4460-a6bf-18d2451f13e9', '2c5ab7ea-f37f-4917-bec2-202b20d25ff0', '6c1be796-e383-4344-80eb-1d24392eb0a8', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('db582abe-0edc-4003-b654-2ebf72999373', '64412e27-169e-44ea-a101-74ebf8cb82d9', 'e2559476-b848-4bae-bce9-fdcbdf95c2e7', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('b27af338-00d1-456d-ad70-5b1107465a14', 'cb2c22ac-87de-44e4-9638-35979f6af667', 'e2559476-b848-4bae-bce9-fdcbdf95c2e7', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('571d3e0c-53b4-4110-865f-d5a1e2dda5db', '2d7ed5a0-fb21-4927-9a25-647c17d29668', 'e2559476-b848-4bae-bce9-fdcbdf95c2e7', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('f1b25277-9797-4c4f-9039-93b020616352', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'e2559476-b848-4bae-bce9-fdcbdf95c2e7', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('0b8bd3bc-0401-44c9-93a2-1c3425b09772', '444bbc7d-86f8-4258-9429-e73ce69a9e41', 'e2559476-b848-4bae-bce9-fdcbdf95c2e7', 3, NULL);
INSERT INTO "public"."course_user" VALUES ('17b4f8dd-d66a-4217-b12f-2ebd9940c131', '994ebe5b-db43-4cd3-a1ee-693c2ef681ef', 'e2559476-b848-4bae-bce9-fdcbdf95c2e7', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('9a39ed20-5039-419e-9d30-107f53946030', '2d5137ae-9d77-4a12-94ea-fda383a8db10', 'e2559476-b848-4bae-bce9-fdcbdf95c2e7', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('91245fdd-34c8-43bd-a1f0-e17afdbf512e', '205b0afa-3efa-4bdf-9bc0-3f6449ff5c1a', 'e2559476-b848-4bae-bce9-fdcbdf95c2e7', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('d21b6259-1723-4822-9564-90f917c5bad7', '9e9e9485-bbad-4aa4-9e2d-f8362dbbbba1', 'e2559476-b848-4bae-bce9-fdcbdf95c2e7', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('c4ead630-7d52-4346-863f-7d18182b8659', 'b887e221-2edd-4a37-9b65-209c92b8997d', 'e2559476-b848-4bae-bce9-fdcbdf95c2e7', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('74ba3705-bc6d-42db-8b9e-226dc0cbc850', 'd7c3523c-d595-44f0-ad72-ddf8ae299cbb', 'e2559476-b848-4bae-bce9-fdcbdf95c2e7', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('a6e51efe-0905-4e0b-ae72-5f50a4203ecf', 'ffed4ce4-53b7-497e-a449-e3dee93aec1d', 'e2559476-b848-4bae-bce9-fdcbdf95c2e7', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('7968378f-9061-495b-8fc6-1c52e929e327', '097ad133-9434-44d0-ad2f-16db49f0be9c', 'e2559476-b848-4bae-bce9-fdcbdf95c2e7', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('1ac484fe-0968-471f-a187-163e7522803e', 'dd81de86-7f96-482a-b967-2e8e4cd9d910', 'e2559476-b848-4bae-bce9-fdcbdf95c2e7', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('54075355-3740-447b-9f8f-6f9f4a96ce8f', '6c44fd5e-560d-4b8a-9d61-03c3e66872ef', 'e2559476-b848-4bae-bce9-fdcbdf95c2e7', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('3d359cb3-d4a0-427b-aeab-5c863cc90b40', '588636d6-7193-4a2b-be5f-cafe112d3bf5', 'e2559476-b848-4bae-bce9-fdcbdf95c2e7', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('7089acf6-eda5-480c-8b2f-9ed77205789b', '75dd8ca8-14aa-4dbb-aac0-c16bcb1ef61f', 'e2559476-b848-4bae-bce9-fdcbdf95c2e7', 5, NULL);
INSERT INTO "public"."course_user" VALUES ('2851d8be-a407-4a9d-852c-09c2f9a43192', '2c5ab7ea-f37f-4917-bec2-202b20d25ff0', 'e2559476-b848-4bae-bce9-fdcbdf95c2e7', 3, NULL);

INSERT INTO "public"."exam_question" VALUES ('c29ccb3f-2429-4d49-9cbb-ba348164be00', '86600cfb-7b48-4e81-8e05-8fa29d49d7a9', 'b6484e21-6937-489c-b031-b71767994221', 0);
INSERT INTO "public"."exam_question" VALUES ('c29ccb3f-2429-4d49-9cbb-ba348164be01', '86600cfb-7b48-4e81-8e05-8fa29d49d7a9', 'b6484e21-6937-489c-b031-b71767994736', 0);
INSERT INTO "public"."exam_question" VALUES ('c29ccb3f-2429-4d49-9cbb-ba348164be58', '86600cfb-7b48-4e81-8e05-8fa29d49d7a6', '82a72f33-69d1-417a-bc4a-54e4a3f42a06', 0);
INSERT INTO "public"."exam_question" VALUES ('c29ccb3f-2429-4d49-9cbb-ba348164be59', '86600cfb-7b48-4e81-8e05-8fa29d49d7a6', 'b6484e21-6937-489c-b031-b71767994233', 0);
INSERT INTO "public"."exam_question" VALUES ('c29ccb3f-2429-4d49-9cbb-ba348164be60', '86600cfb-7b48-4e81-8e05-8fa29d49d7a6', 'b6484e21-6937-489c-b031-b71767994221', 0);
INSERT INTO "public"."exam_question" VALUES ('291494a8-1527-4fa3-aff7-67c0406849a9', '86600cfb-7b48-4e81-8e05-8fa29d49d7a6', '53ce35a7-9dcf-4741-a4ed-872874daf829', 1);
INSERT INTO "public"."exam_question" VALUES ('b8afcdb5-b8e4-4ee3-8708-48865787454c', '86600cfb-7b48-4e81-8e05-8fa29d49d7a6', '0fe5d2ee-6892-4f62-a6e6-83284f2430bc', 1);
INSERT INTO "public"."exam_question" VALUES ('0d043280-4256-48b8-8792-5aca115b7b14', '86600cfb-7b48-4e81-8e05-8fa29d49d7a6', '1ca8c89a-1bd0-41b2-adf0-4f7b55f8b256', 0);
INSERT INTO "public"."exam_question" VALUES ('72cb08d5-dfc7-40d5-910f-1b04eb9378ff', '86600cfb-7b48-4e81-8e05-8fa29d49d7a6', '513a7e58-00d0-450b-8f0d-78af23898b81', 1);
INSERT INTO "public"."exam_question" VALUES ('b4b22535-6990-4197-aa9f-5c8b917baf13', '86600cfb-7b48-4e81-8e05-8fa29d49d7a6', 'fe65d7df-69ac-4a17-805c-f1f2b65b9972', 2);
INSERT INTO "public"."exam_question" VALUES ('d132fdaa-3435-43c4-9e98-1fe2117e89ad', '86600cfb-7b48-4e81-8e05-8fa29d49d7a6', 'c4b3219f-9d83-4497-ad15-d46772141bd5', 0);
INSERT INTO "public"."exam_question" VALUES ('aeca96c8-d678-4899-a275-0f64368ef85e', '86600cfb-7b48-4e81-8e05-8fa29d49d7a6', '1168fba1-8391-4294-b1cb-2c108f96af1f', 0);
INSERT INTO "public"."exam_question" VALUES ('1887af1a-a0c2-4caa-82e9-f71ae7516752', '86600cfb-7b48-4e81-8e05-8fa29d49d7a6', '29a71c20-290b-471d-acc8-4c5c929f96a8', 0);
INSERT INTO "public"."exam_question" VALUES ('e2176cc8-41b8-435f-8b39-d63ef2bbe495', '86600cfb-7b48-4e81-8e05-8fa29d49d7a6', '20d06a81-f597-41bc-a60c-480d5c38eb80', 0);


INSERT INTO "public"."intro_attachment" VALUES ('d2ae79dd-ff69-435a-b487-840c0841da07', 'b3108f5a-c769-42ab-84c9-80a6d80f5821', 'DeCuongDeTaiTN (1).pdf', 227177, 'http://62.171.185.208/webservice/pluginfile.php/67/mod_assign/introattachment/0/DeCuongDeTaiTN%20%281%29.pdf', '2024-05-22 09:18:13+07', 'application/pdf');
INSERT INTO "public"."intro_attachment" VALUES ('a67f8044-ad92-423e-a94a-ede9074ae458', 'b3108f5a-c769-42ab-84c9-80a6d80f5821', 'file.svg', 3494, 'http://62.171.185.208/webservice/pluginfile.php/67/mod_assign/introattachment/0/file.svg', '2024-05-22 09:18:13+07', 'image/svg+xml');
INSERT INTO "public"."intro_attachment" VALUES ('bd0075d7-dfdd-4c87-8f05-a0adb9fe2d63', 'bcf9e719-9112-4c10-8033-4f0e759a0259', 'FIT_CDIO_Week01 - Getting Started Programing.pdf', 711486, 'http://62.171.185.208:8081/webservice/pluginfile.php/166/mod_assign/introattachment/0/FIT_CDIO_Week01%20-%20Getting%20Started%20Programing.pdf', '2024-08-01 13:24:41+07', 'application/pdf');
INSERT INTO "public"."intro_attachment" VALUES ('35f9c547-6e37-4d2b-9287-fb52f2b48a68', '908590a0-5200-4a8e-93b4-7ed647a3b96e', 'FIT_CDIO_Week02 - IfElseWitchCaseLoop.pdf', 285317, 'http://62.171.185.208:8081/webservice/pluginfile.php/169/mod_assign/introattachment/0/FIT_CDIO_Week02%20-%20IfElseWitchCaseLoop.pdf', '2024-08-01 13:28:37+07', 'application/pdf');
INSERT INTO "public"."intro_attachment" VALUES ('19c1d3eb-ab1d-4c0f-a740-7d49e9100b51', '7ae51e73-9f91-4eb8-805c-cf62a79907cf', 'FIT_CDIO_Week02 - IfElseWitchCaseLoop.pdf', 285317, 'http://62.171.185.208:8081/webservice/pluginfile.php/170/mod_assign/introattachment/0/FIT_CDIO_Week02%20-%20IfElseWitchCaseLoop.pdf', '2024-08-01 13:28:52+07', 'application/pdf');


-- ----------------------------
INSERT INTO "public"."activity_attachment" VALUES ('43eb677a-af62-4496-ae4e-b03f3de1663c', 'b3108f5a-c769-42ab-84c9-80a6d80f5821', '2024-04-28T06-36 Giao dịch số 7503068499806565-14511976 (1).pdf', 1059934, 'http://62.171.185.208/webservice/pluginfile.php/67/mod_assign/activityattachment/0/2024-04-28T06-36%20Giao%20d%E1%BB%8Bch%20s%E1%BB%91%207503068499806565-14511976%20%281%29.pdf', '2024-05-22 09:18:13+07', 'application/pdf');

INSERT INTO "public"."submission_assignment" VALUES ('8c6dd82d-7886-4378-ac13-d0781d6440a4', '2d3c1e66-1835-457f-93e9-265fe483feee', '577e118d-604b-450c-a02c-cf8e9f35f8ee', 'f', -1, NULL, '', '2024-05-06 14:20:25', '2024-05-06 21:20:25+07');
INSERT INTO "public"."submission_assignment" VALUES ('aa45447a-836f-40de-8737-b1478bc80a19', 'cb2c22ac-87de-44e4-9638-35979f6af667', '577e118d-604b-450c-a02c-cf8e9f35f8ee', 'f', -1, NULL, '', '2024-05-24 02:53:17', '2024-05-28 14:10:04+07');
INSERT INTO "public"."submission_assignment" VALUES ('ad32ef95-b182-4935-8f0e-3b88d5896adc', '2d7ed5a0-fb21-4927-9a25-647c17d29668', 'b1b3e215-2450-4819-9aa6-3aea9f87e604', 'f', -1, NULL, '', '2024-05-07 08:43:42', '2024-05-07 15:43:42+07');
INSERT INTO "public"."submission_assignment" VALUES ('9f011388-31b4-4630-ac11-975febff1948', 'cb2c22ac-87de-44e4-9638-35979f6af667', 'b1b3e215-2450-4819-9aa6-3aea9f87e604', 't', 100, NULL, '', '2024-05-06 07:35:10', '2024-05-06 14:39:26+07');
INSERT INTO "public"."submission_assignment" VALUES ('8478c536-e657-408c-acbb-55905eeead13', '2d7ed5a0-fb21-4927-9a25-647c17d29668', '3926bcb3-6415-458d-b449-6e2b464732d7', 't', 4.5, NULL, '<p dir="ltr" style="text-align:left;">Quá xuất sắc</p>', '2024-05-27 05:11:08', '2024-05-27 12:11:08+07');
INSERT INTO "public"."submission_assignment" VALUES ('b85df3d3-86ce-449f-8ed3-6ecafcad4cf9', 'cb2c22ac-87de-44e4-9638-35979f6af667', '3926bcb3-6415-458d-b449-6e2b464732d7', 't', 85, NULL, '<p dir="ltr" style="text-align:left;">Qua xuất sắc<img src="http://62.171.185.208/webservice/pluginfile.php/41/assignfeedback_comments/feedback/6/242549690_4573384179372457_7212491116034148251_n.png" alt="hehe" width="600" height="600" class="img-fluid atto_image_button_text-bottom" /></p>', '2024-05-06 07:31:38', '2024-05-26 11:52:48+07');
INSERT INTO "public"."submission_assignment" VALUES ('29d83061-2aac-4bb4-9e41-6344dad72264', '9ba179ed-d26d-4828-a0f6-8836c2063992', '3926bcb3-6415-458d-b449-6e2b464732d7', 't', 100, '<p dir="ltr" style="text-align:left;">hehe</p>', '<p dir="ltr" style="text-align:left;">Quá giỏi</p>', '2024-05-08 02:27:03', '2024-05-08 09:27:37+07');
INSERT INTO "public"."submission_assignment" VALUES ('5dece352-1ce6-4159-a23e-80437d9f15ec', '2d7ed5a0-fb21-4927-9a25-647c17d29668', '8c6d9aa1-f157-49ca-bfae-bc8a14570c81', 'f', -1, NULL, '', '2024-05-28 08:09:33', '2024-05-28 15:09:33+07');
INSERT INTO "public"."submission_assignment" VALUES ('e8500189-218e-4420-95fd-0ba98b4fbddd', 'cb2c22ac-87de-44e4-9638-35979f6af667', '8c6d9aa1-f157-49ca-bfae-bc8a14570c81', 'f', -1, NULL, '', '2024-05-06 08:11:48', '2024-05-07 17:25:05+07');
INSERT INTO "public"."submission_assignment" VALUES ('13bc8451-f836-455d-9a36-fc0e00596443', '9ba179ed-d26d-4828-a0f6-8836c2063992', '8c6d9aa1-f157-49ca-bfae-bc8a14570c81', 'f', -1, NULL, '', '2024-05-08 02:08:36', '2024-05-08 09:12:00+07');
INSERT INTO "public"."submission_assignment" VALUES ('8c6dd82d-7886-4378-ac13-d0781d6440a5', 'cb2c22ac-87de-44e4-9638-35979f6af667', 'e1a6c218-1a45-4d2e-9020-1f3e8d5f098c', 'f', -1, '<p>Biến là một vùng nhớ dùng để lưu trữ dữ liệu và có thể thay đổi trong quá trình thực thi chương trình. Trong lập trình, biến có các loại phổ biến như biến cục bộ, biến toàn cục và biến tĩnh. Biến cục bộ là biến được khai báo trong một hàm hoặc một khối mã và chỉ có thể được sử dụng trong phạm vi đó. Biến toàn cục là biến được khai báo bên ngoài các hàm và có thể được truy cập từ bất kỳ đâu trong chương trình. Biến tĩnh là biến giữ nguyên giá trị của nó trong suốt quá trình thực thi chương trình, ngay cả khi đã ra khỏi phạm vi của nó.</p>', '', '2024-07-03 14:00:00', '2024-07-03 14:00:00+07');
INSERT INTO "public"."submission_assignment" VALUES ('aa45447a-836f-40de-8737-b1478bc80a18', '2d7ed5a0-fb21-4927-9a25-647c17d29668', 'e1a6c218-1a45-4d2e-9020-1f3e8d5f098c', 'f', -1, '<p>Biến là một nơi lưu trữ dữ liệu có thể thay đổi trong chương trình. Có nhiều loại biến như biến cục bộ và biến toàn cục. Biến cục bộ chỉ có thể được sử dụng trong phạm vi hàm mà nó được khai báo. Biến toàn cục có thể được sử dụng ở bất kỳ đâu trong chương trình.</p>', '', '2024-07-03 14:00:00', '2024-07-03 14:00:00+07');
INSERT INTO "public"."submission_assignment" VALUES ('ad32ef95-b182-4935-8f0e-3b88d5896ad1', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'e1a6c218-1a45-4d2e-9020-1f3e8d5f098c', 'f', -1, '<p>Biến là một nơi lưu trữ dữ liệu trong chương trình. Có biến cục bộ và biến toàn cục.</p>', '', '2024-07-03 14:00:00', '2024-07-03 14:00:00+07');
INSERT INTO "public"."submission_assignment" VALUES ('9f011388-31b4-4630-ac11-975febff1942', 'cb2c22ac-87de-44e4-9638-35979f6af667', 'b24d3df4-3f8e-4d23-b18f-8d82ff37cda9', 'f', -1, '<p>Hàm là một đoạn mã thực hiện một nhiệm vụ cụ thể và có thể trả về một giá trị. Hàm có thể tồn tại độc lập và không thuộc về bất kỳ đối tượng nào. Phương thức là một hàm nhưng thuộc về một đối tượng hoặc một lớp. Phương thức có thể tương tác với các thuộc tính của đối tượng mà nó thuộc về và có thể truy cập các phương thức khác của cùng đối tượng.</p>', '', '2024-07-03 14:00:00', '2024-07-03 14:00:00+07');
INSERT INTO "public"."submission_assignment" VALUES ('8478c536-e657-408c-acbb-55905eeead25', '2d7ed5a0-fb21-4927-9a25-647c17d29668', 'b24d3df4-3f8e-4d23-b18f-8d82ff37cda9', 'f', -1, '<p>Hàm là một đoạn mã thực hiện một nhiệm vụ và có thể trả về một giá trị. Nó không thuộc về bất kỳ đối tượng nào. Phương thức là một hàm nhưng thuộc về một đối tượng hoặc lớp và có thể truy cập các thuộc tính và phương thức khác của đối tượng đó.</p>', '', '2024-07-03 14:00:00', '2024-07-03 14:00:00+07');
INSERT INTO "public"."submission_assignment" VALUES ('b85df3d3-86ce-449f-8ed3-6ecafcad4c56', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'b24d3df4-3f8e-4d23-b18f-8d82ff37cda9', 'f', -1, '<p>Hàm là một đoạn mã thực hiện một nhiệm vụ. Phương thức là hàm thuộc về một đối tượng.</p>', '', '2024-07-03 14:00:00', '2024-07-03 14:00:00+07');
INSERT INTO "public"."submission_assignment" VALUES ('29d83061-2aac-4bb4-9e41-6344dad72265', 'cb2c22ac-87de-44e4-9638-35979f6af667', 'f58e95a8-799c-4d2e-b5f3-d9b9d5566eec', 'f', -1, '<p>Các kiểu dữ liệu cơ bản trong lập trình gồm: Số nguyên (int): Lưu trữ số nguyên, ví dụ: `int age = 25;` Số thực (float, double): Lưu trữ số thập phân, ví dụ: `float height = 5.8;` Ký tự (char): Lưu trữ một ký tự, ví dụ: `char grade = A;` Chuỗi (string): Lưu trữ chuỗi ký tự, ví dụ: `string name = "John";` Boolean (bool): Lưu trữ giá trị đúng hoặc sai, ví dụ: `bool isStudent = true;`</p>', '', '2024-07-03 14:00:00', '2024-07-03 14:00:00+07');
INSERT INTO "public"."submission_assignment" VALUES ('8c6dd82d-7886-4378-ac13-d0781d6440a9', '2d7ed5a0-fb21-4927-9a25-647c17d29668', 'f58e95a8-799c-4d2e-b5f3-d9b9d5566eec', 'f', -1, '<p>Các kiểu dữ liệu cơ bản gồm: Số nguyên: `int age = 25;` Số thực: `float height = 5.8;` Ký tự: `char grade = A;` Chuỗi: `string name = "John";` Boolean: `bool isStudent = true;`</p>', '', '2024-07-03 14:00:00', '2024-07-03 14:00:00+07');
INSERT INTO "public"."submission_assignment" VALUES ('8c6dd82d-7886-4378-ac13-d0781d6440a2', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'f58e95a8-799c-4d2e-b5f3-d9b9d5566eec', 'f', -1, '<p>Các kiểu dữ liệu cơ bản là số nguyên, số thực, ký tự, chuỗi và boolean. Ví dụ: `int age = 25;`, `float height = 5.8;`, `char grade = A;`, `string name = "John";`, `bool isStudent = true;`</p>', '', '2024-07-03 14:00:00', '2024-07-03 14:00:00+07');
INSERT INTO "public"."submission_assignment" VALUES ('13bc8451-f836-455d-9a36-fc0e00596453', 'cb2c22ac-87de-44e4-9638-35979f6af667', 'c12f49db-074f-4e5c-9c19-9dffcdf9a6b4', 'f', -1, '<p>Các nguyên lý lập trình hướng đối tượng gồm: Tính đóng gói: Đóng gói dữ liệu và các phương thức liên quan vào một đối tượng. Tính kế thừa: Một lớp có thể kế thừa các thuộc tính và phương thức từ một lớp khác. Tính đa hình: Cho phép một phương thức có thể có nhiều cách cài đặt khác nhau. Tính trừu tượng: Ẩn giấu các chi tiết cài đặt và chỉ hiển thị các tính năng của đối tượng.</p>', '', '2024-07-03 14:00:00', '2024-07-03 14:00:00+07');
INSERT INTO "public"."submission_assignment" VALUES ('8c6dd82d-7886-4378-ac13-d0781d6440a6', '2d7ed5a0-fb21-4927-9a25-647c17d29668', 'c12f49db-074f-4e5c-9c19-9dffcdf9a6b4', 'f', -1, '<p>Các nguyên lý lập trình hướng đối tượng gồm: Đóng gói: Đóng gói dữ liệu và phương thức vào một đối tượng. Kế thừa: Kế thừa thuộc tính và phương thức từ lớp khác. Đa hình: Một phương thức có thể có nhiều cách cài đặt. Trừu tượng: Ẩn chi tiết cài đặt, chỉ hiển thị tính năng.</p>', '', '2024-07-03 14:00:00', '2024-07-03 14:00:00+07');
INSERT INTO "public"."submission_assignment" VALUES ('aa45447a-836f-40de-8737-b1478bc80a67', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'c12f49db-074f-4e5c-9c19-9dffcdf9a6b4', 'f', -1, '<p>Các nguyên lý lập trình hướng đối tượng gồm đóng gói, kế thừa, đa hình và trừu tượng. Mỗi nguyên lý có vai trò khác nhau trong lập trình.</p>', '', '2024-07-03 14:00:00', '2024-07-03 14:00:00+07');
INSERT INTO "public"."submission_assignment" VALUES ('40b37e96-5960-4484-97fe-a3d207c4f5c9', 'ca3040f2-e173-40a5-aab7-6ef15965ce43', '438413fa-ac31-496a-becb-709505ea990a', 't', 65, NULL, '<p dir="ltr" style="text-align:left;">Tốt</p>', '2024-05-13 03:32:09', '2024-05-13 10:32:40+07');

-- Records of submission_grade
-- ----------------------------
INSERT INTO "public"."submission_grade" VALUES ('d393472f-51e7-44cc-ab66-b7924f06cc70', '9f011388-31b4-4630-ac11-975febff1948', 100, '2024-05-07 15:41:52+07', '2024-05-07 15:43:41+07');
INSERT INTO "public"."submission_grade" VALUES ('ba856634-b455-406f-ac3f-c9f81d7e90cb', 'b85df3d3-86ce-449f-8ed3-6ecafcad4cf9', 85, '2024-05-27 12:10:38+07', '2024-05-28 08:50:19+07');
INSERT INTO "public"."submission_grade" VALUES ('197fc2c8-42e8-4fcf-927d-cb0500923973', '29d83061-2aac-4bb4-9e41-6344dad72264', 100, '2024-05-27 12:11:19+07', '2024-05-27 12:11:34+07');
INSERT INTO "public"."submission_grade" VALUES ('20c2d520-8543-474b-b186-51d288497f7b', '40b37e96-5960-4484-97fe-a3d207c4f5c9', 65, '2024-05-24 10:22:55+07', '2024-05-24 10:23:14+07');

INSERT INTO "public"."submission_assignment_file" VALUES ('70c12ca5-e76a-47a9-aefd-2117f0c9f8f0', 'aa45447a-836f-40de-8737-b1478bc80a19', 'DeCuongDeTaiTN (1).pdf', 227177, 'http://62.171.185.208/webservice/pluginfile.php/39/assignsubmission_file/submission_files/21/DeCuongDeTaiTN%20%281%29.pdf', '2024-05-28 14:10:04+07', 'application/pdf');
INSERT INTO "public"."submission_assignment_file" VALUES ('2e81be32-b6b4-47e6-9659-dd4dad461ae5', '9f011388-31b4-4630-ac11-975febff1948', 'f662213566f63d19a90770676f0941ee.jpg', 44665, 'http://62.171.185.208/webservice/pluginfile.php/38/assignsubmission_file/submission_files/5/f662213566f63d19a90770676f0941ee.jpg', '2024-05-06 14:39:26+07', 'image/jpeg');
INSERT INTO "public"."submission_assignment_file" VALUES ('f52878c4-ec12-4f2b-846c-fa8e3849da56', 'b85df3d3-86ce-449f-8ed3-6ecafcad4cf9', 'DeCuongDeTaiTN (1).pdf', 227177, 'http://62.171.185.208/webservice/pluginfile.php/41/assignsubmission_file/submission_files/4/DeCuongDeTaiTN%20%281%29.pdf', '2024-05-26 08:58:16+07', 'application/pdf');
INSERT INTO "public"."submission_assignment_file" VALUES ('14a9db27-30d2-45b6-ac89-4ee45f0d2844', '29d83061-2aac-4bb4-9e41-6344dad72264', '65864c8f201a9b2b1b6ca4405906b6de.jpg', 6616, 'http://62.171.185.208/webservice/pluginfile.php/41/assignsubmission_file/submission_files/15/65864c8f201a9b2b1b6ca4405906b6de.jpg', '2024-05-08 09:27:37+07', 'image/jpeg');
INSERT INTO "public"."submission_assignment_file" VALUES ('779f5d26-82d7-4161-a2d6-83b145c7f6b8', 'e8500189-218e-4420-95fd-0ba98b4fbddd', '1f449.png', 9852, 'http://62.171.185.208/webservice/pluginfile.php/42/assignsubmission_file/submission_files/6/1f449.png', '2024-05-06 15:13:42+07', 'image/png');
INSERT INTO "public"."submission_assignment_file" VALUES ('779f5d26-82d7-4161-a2d6-83b145c7f6b2', 'e8500189-218e-4420-95fd-0ba98b4fbddd', 'test1.jpg', 60887, 'http://62.171.185.208/webservice/pluginfile.php/42/assignsubmission_file/submission_files/6/test1.jpg', '2024-05-07 17:25:05+07', 'image/jpeg');
INSERT INTO "public"."submission_assignment_file" VALUES ('d7da73d7-76d1-448f-9d7c-cfcdf2045deb', '13bc8451-f836-455d-9a36-fc0e00596443', '438255262_122148182144103154_1065002638849796416_n.jpg', 59292, 'http://62.171.185.208/webservice/pluginfile.php/42/assignsubmission_file/submission_files/14/438255262_122148182144103154_1065002638849796416_n.jpg', '2024-05-08 09:12:00+07', 'image/jpeg');
INSERT INTO "public"."submission_assignment_file" VALUES ('7c4727d4-ce7d-4659-9979-496219958a26', '40b37e96-5960-4484-97fe-a3d207c4f5c9', '2024-04-26T07-00 Giao dịch số 7331655503614525-14503349 (1).pdf', 1059932, 'http://62.171.185.208/webservice/pluginfile.php/48/assignsubmission_file/submission_files/16/2024-04-26T07-00%20Giao%20d%E1%BB%8Bch%20s%E1%BB%91%207331655503614525-14503349%20%281%29.pdf', '2024-05-13 10:32:40+07', 'application/pdf');

-- Records of rubric_user
-- ----------------------------
INSERT INTO "public"."rubric_user" VALUES ('31fed2d0-c774-4b5d-a131-070fd0979ae4', 'Rubric 1', 'Rubric 1 description', '[{"criteriaName":"Content","criteriaDescription":"","scale":[{"score":1,"description":"The essay is incomplete, inaccurate, illogical, and uses sources inappropriately"},{"score":2,"description":"The essay is complete, accurate, but lacks logic, and uses sources somewhat appropriately"},{"score":3,"description":"The essay is complete, accurate, and logical, and uses sources appropriately"},{"score":4,"description":"The essay is complete, accurate, logical, creative, and uses sources appropriately"}]},{"criteriaName":"Form","criteriaDescription":"","scale":[{"score":1,"description":"The essay has many errors in grammar, spelling, or punctuation, uses limited vocabulary, and has an unclear layout."},{"score":2,"description":"The essay has several errors in grammar, spelling, or punctuation, uses somewhat varied and rich vocabulary, and has a somewhat clear layout."},{"score":3,"description":"The essay has few errors in grammar, spelling, or punctuation, uses varied, rich, and appropriate vocabulary, and has a relatively clear layout."},{"score":4,"description":"The essay has no errors in grammar, spelling, or punctuation, and uses varied, rich, and appropriate vocabulary with a clear layout"}]},{"criteriaName":"Style","criteriaDescription":"","scale":[{"score":1,"description":"The essay is unclear, not engaging, and not appropriate for the topic, purpose, and audience."},{"score":2,"description":"The essay is unclear, lacks engagement, and is somewhat appropriate for the topic, purpose, and audience."},{"score":3,"description":"The essay is relatively clear, engaging, and appropriate for the topic, purpose, and audience."},{"score":4,"description":"The essay is clear, engaging, and appropriate for the topic, purpose, and audience."}]}]', '64412e27-169e-44ea-a101-74ebf8cb82d9');
INSERT INTO "public"."rubric_user" VALUES ('e15e0a60-6893-48f9-9fbd-0bdb671e1c84', 'Rubric 2', 'Rubric 2 description', '[{"criteriaName":"Ideas and content","scale":[{"score":1,"description":"The opinion and support for it is buried, confused and/or undear."},{"score":2,"description":"An opinion is given. The reasons given tend to be weak or inaccurate. May get off topic."},{"score":3,"description":"An opinion is given. One reason may be unclear or lack detail."},{"score":4,"description":"The paper clearly states an opinion and gives 3 clear, detailed reasons in support of it"}]},{"criteriaName":"Organization","scale":[{"score":1,"description":"There is no real beginning or ending. The ideas seem loosely strung together. No paragraph formatting"},{"score":2,"description":"The paper has an attempt at a beginning &/or ending. Some ideas may seem out of order. Some problems with paragraphs."},{"score":3,"description":"The paper has a beginning, middle and end. The order makes sense. Paragraphs are indented; some have topic and closing sentences"},{"score":4,"description":"The paper has a beginning with an interesting lead, a middle, and an ending. It is in an order that makes sense. Paragraphs are indented and have topic and closing sentences and main ideas."}]},{"criteriaName":"Voice & tone","scale":[{"score":1,"description":"The writing is bland and sounds like the writer doesn`t like the topic. No thoughts or feelings."},{"score":2,"description":"The paper could have been written by anyone. It shows very little about what the writer thought and felt."},{"score":3,"description":"The writing seems sincere but not enthusiastic. The writer`s voice fades in and out."},{"score":4,"description":"The writing shows what the writer thinks and feels. It sounds like the writer cares about the topic."}]},{"criteriaName":"Word choice","scale":[{"score":1,"description":"The same words are used over and over. Some words are used incorrectly.\n"},{"score":2,"description":"The words areordinary but generally correct.\n"},{"score":3,"description":"The words are mostly ordinary, with a few attempts at descriptive words."},{"score":4,"description":"Descriptive words are used (`helpful`) instead of `good` or `destructive` instead of `bad`."}]},{"criteriaName":"Sentence fluency","scale":[{"score":1,"description":"The essay is hard to read because of incomplete and run-on sentences.\n"},{"score":2,"description":"There are many incomplete sentences and run-ons.\n"},{"score":3,"description":"The sentences are usually correct."},{"score":4,"description":"The sentences are complete, clear, and begin in different ways."}]},{"criteriaName":"Conventions","scale":[{"score":1,"description":"The writing is almost impossible to read because of errors."},{"score":2,"description":"There are enough errors to make the writing hard to read and understand."},{"score":3,"description":"Spelling, punctuation and caps are usually correct_ Some problems with grammar."},{"score":4,"description":"Spelling, punctuation, capitalization, and grammar are correct. Only minor edits are needed."}]}]', '64412e27-169e-44ea-a101-74ebf8cb82d9');

INSERT INTO "public"."synchronize_state" VALUES ('aa85547e-5938-478b-9c33-b8857a5a9bc1', '8edbc0aa-0b91-480e-a428-23abf2109df9', 'SUCCESS', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'USER', 0, '2024-08-04 14:16:00.495272+07');
INSERT INTO "public"."synchronize_state" VALUES ('ba395f50-2019-48e6-8aa1-638ca826dda2', '8edbc0aa-0b91-480e-a428-23abf2109df9', 'SUCCESS', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'COURSE', 0, '2024-08-04 14:16:00.580636+07');
INSERT INTO "public"."synchronize_state" VALUES ('4c7be331-a793-44eb-808f-66e2387296b8', '8edbc0aa-0b91-480e-a428-23abf2109df9', 'SUCCESS', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'RESOURCE', 0, '2024-08-04 14:16:00.586788+07');


------------ add question
INSERT INTO public.question_bank_category
(id, "name", description, organization_id, is_org_question_bank, created_by, updated_by, created_at, updated_at)
VALUES('2eb6711f-5759-43e2-ab56-d00d572db220'::uuid, 'Kỹ thuật lập trình', '<p>Kỹ thuật lập trình</p>', '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, true, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-08-04 23:30:40.786', '2024-08-04 23:30:40.786');
INSERT INTO public.question_bank_category
(id, "name", description, organization_id, is_org_question_bank, created_by, updated_by, created_at, updated_at)
VALUES('607e34b1-0af0-435c-85a0-68409acf5834'::uuid, 'Ứng dụng web', '<p>ứng dụng web</p>', '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, true, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-08-04 23:40:33.813', '2024-08-04 23:40:33.813');
INSERT INTO public.question_bank_category
(id, "name", description, organization_id, is_org_question_bank, created_by, updated_by, created_at, updated_at)
VALUES('2ae708a8-3e07-4b53-91ff-32e005bf289c'::uuid, 'Hệ thống thông tin', '<p>Hệ thống thông tin</p>', '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, true, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-08-04 23:48:50.717', '2024-08-04 23:48:50.717');


INSERT INTO public.question
(id, org_id, "name", question_text, general_feedback, default_mark, created_by, updated_by, created_at, updated_at, question_bank_category_id, is_org_question_bank, "qtype", "difficulty")
VALUES('560c0865-35df-486d-b886-5189c0a5d66f'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'Một hàm đệ quy là một hàm tự gọi lại chính nó.', '<p>Một hàm đệ quy là một hàm tự gọi lại chính nó.</p>', '', 1.0, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-08-04 23:31:36.631', '2024-08-04 23:31:36.631', NULL, false, 'TRUE_FALSE'::public."qtype", 'EASY'::public."difficulty");
INSERT INTO public.question
(id, org_id, "name", question_text, general_feedback, default_mark, created_by, updated_by, created_at, updated_at, question_bank_category_id, is_org_question_bank, "qtype", "difficulty")
VALUES('01f3b10a-43b4-4400-863a-bf02fee2c7a7'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'Ngôn ngữ lập trình C++ không hỗ trợ lập trình hướng đối tượng.', '<p>Ngôn ngữ lập trình C++ không hỗ trợ lập trình hướng đối tượng.</p>', '', 1.0, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-08-04 23:31:54.532', '2024-08-04 23:31:54.532', NULL, false, 'TRUE_FALSE'::public."qtype", 'EASY'::public."difficulty");
INSERT INTO public.question
(id, org_id, "name", question_text, general_feedback, default_mark, created_by, updated_by, created_at, updated_at, question_bank_category_id, is_org_question_bank, "qtype", "difficulty")
VALUES('c3a2ceac-f0f3-4ed1-8083-a851af7e563a'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'Trong lập trình, vòng lặp "for" chỉ có thể sử dụng để lặp lại một khối lệnh với số lần cố định.', '<p>Trong lập trình, vòng lặp "for" chỉ có thể sử dụng để lặp lại một khối lệnh với số lần cố định.</p>', '', 1.0, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-08-04 23:33:10.884', '2024-08-04 23:33:10.884', NULL, false, 'TRUE_FALSE'::public."qtype", 'EASY'::public."difficulty");
INSERT INTO public.question
(id, org_id, "name", question_text, general_feedback, default_mark, created_by, updated_by, created_at, updated_at, question_bank_category_id, is_org_question_bank, "qtype", "difficulty")
VALUES('a267478d-407d-490a-a771-6575db96cf03'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'Mảng trong ngôn ngữ lập trình C có thể thay đổi kích thước sau khi được khai báo.', '<p>Mảng trong ngôn ngữ lập trình C có thể thay đổi kích thước sau khi được khai báo.</p>', '', 1.0, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-08-04 23:33:43.031', '2024-08-04 23:33:43.031', NULL, false, 'TRUE_FALSE'::public."qtype", 'EASY'::public."difficulty");
INSERT INTO public.question
(id, org_id, "name", question_text, general_feedback, default_mark, created_by, updated_by, created_at, updated_at, question_bank_category_id, is_org_question_bank, "qtype", "difficulty")
VALUES('1278efc3-479f-4bb8-a839-10cf23e95788'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'Phương pháp lập trình mà trong đó các đối tượng tương tác với nhau thông qua các phương thức được gọi là ___.', '<p>Phương pháp lập trình mà trong đó các đối tượng tương tác với nhau thông qua các phương thức được gọi là ___.</p>', '', 1.0, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-08-04 23:34:35.285', '2024-08-04 23:34:35.285', NULL, false, 'SHORT_ANSWER'::public."qtype", 'EASY'::public."difficulty");
INSERT INTO public.question
(id, org_id, "name", question_text, general_feedback, default_mark, created_by, updated_by, created_at, updated_at, question_bank_category_id, is_org_question_bank, "qtype", "difficulty")
VALUES('e99a6172-ef91-4b99-b800-d76b9c74a1d3'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'Trong ngôn ngữ lập trình C++, từ khóa dùng để tạo một lớp mới là ___.', '<p>Trong ngôn ngữ lập trình C++, từ khóa dùng để tạo một lớp mới là ___.</p>', '', 1.0, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-08-04 23:35:01.416', '2024-08-04 23:35:01.416', NULL, false, 'SHORT_ANSWER'::public."qtype", 'EASY'::public."difficulty");
INSERT INTO public.question
(id, org_id, "name", question_text, general_feedback, default_mark, created_by, updated_by, created_at, updated_at, question_bank_category_id, is_org_question_bank, "qtype", "difficulty")
VALUES('193a4ec2-af70-4fb7-ae2e-b4bf3e11dbad'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'Cấu trúc dữ liệu mà trong đó phần tử cuối cùng được thêm vào sẽ là phần tử đầu tiên được lấy ra được gọi là ___.', '<p>Cấu trúc dữ liệu mà trong đó phần tử cuối cùng được thêm vào sẽ là phần tử đầu tiên được lấy ra được gọi là ___.</p>', '', 1.0, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-08-04 23:35:31.555', '2024-08-04 23:35:31.555', NULL, false, 'SHORT_ANSWER'::public."qtype", 'EASY'::public."difficulty");
INSERT INTO public.question
(id, org_id, "name", question_text, general_feedback, default_mark, created_by, updated_by, created_at, updated_at, question_bank_category_id, is_org_question_bank, "qtype", "difficulty")
VALUES('496b4abe-ee7b-47b4-9553-004729a3587e'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'Phương pháp lập trình mà trong đó một hàm gọi lại chính nó được gọi là ___.', '<p>Phương pháp lập trình mà trong đó một hàm gọi lại chính nó được gọi là ___.</p>', '', 1.0, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-08-04 23:36:09.812', '2024-08-04 23:36:09.812', NULL, false, 'SHORT_ANSWER'::public."qtype", 'EASY'::public."difficulty");
INSERT INTO public.question
(id, org_id, "name", question_text, general_feedback, default_mark, created_by, updated_by, created_at, updated_at, question_bank_category_id, is_org_question_bank, "qtype", "difficulty")
VALUES('382f4794-f1c8-4b32-bac5-8654ad46b6e8'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'Các ngôn ngữ lập trình nào sau đây là ngôn ngữ lập trình hướng đối tượng?', '<p>Các ngôn ngữ lập trình nào sau đây là ngôn ngữ lập trình hướng đối tượng?</p>', '', 1.0, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-08-04 23:37:08.064', '2024-08-04 23:37:08.064', NULL, false, 'MULTIPLE_CHOICE'::public."qtype", 'EASY'::public."difficulty");
INSERT INTO public.question
(id, org_id, "name", question_text, general_feedback, default_mark, created_by, updated_by, created_at, updated_at, question_bank_category_id, is_org_question_bank, "qtype", "difficulty")
VALUES('a5d85c32-a968-4f0b-8072-99e652887a9f'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'Các cấu trúc dữ liệu nào sau đây được coi là cấu trúc dữ liệu tuyến tính?', '<p>Các cấu trúc dữ liệu nào sau đây được coi là cấu trúc dữ liệu tuyến tính?</p>', '', 1.0, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-08-04 23:38:36.487', '2024-08-04 23:38:36.487', NULL, false, 'MULTIPLE_CHOICE'::public."qtype", 'EASY'::public."difficulty");
INSERT INTO public.question
(id, org_id, "name", question_text, general_feedback, default_mark, created_by, updated_by, created_at, updated_at, question_bank_category_id, is_org_question_bank, "qtype", "difficulty")
VALUES('0df9d983-e43f-4ee3-b832-51acce5669e7'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'Những khái niệm nào sau đây là nguyên tắc cơ bản của lập trình hướng đối tượng?', '<p>Những khái niệm nào sau đây là nguyên tắc cơ bản của lập trình hướng đối tượng?</p>', '', 1.0, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-08-04 23:39:40.798', '2024-08-04 23:39:40.798', NULL, false, 'MULTIPLE_CHOICE'::public."qtype", 'EASY'::public."difficulty");
INSERT INTO public.question
(id, org_id, "name", question_text, general_feedback, default_mark, created_by, updated_by, created_at, updated_at, question_bank_category_id, is_org_question_bank, "qtype", "difficulty")
VALUES('143b4f9a-2bf2-45e7-9b3d-047414b85226'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'HTML là ngôn ngữ lập trình.', '<p>HTML là ngôn ngữ lập trình.</p>', '', 1.0, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-08-04 23:41:37.332', '2024-08-04 23:41:37.332', NULL, false, 'TRUE_FALSE'::public."qtype", 'EASY'::public."difficulty");
INSERT INTO public.question
(id, org_id, "name", question_text, general_feedback, default_mark, created_by, updated_by, created_at, updated_at, question_bank_category_id, is_org_question_bank, "qtype", "difficulty")
VALUES('83ab4947-2289-4432-9cb4-5a391c7b8f4f'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'CSS được sử dụng để định kiểu cho các thành phần HTML.', '<p>CSS được sử dụng để định kiểu cho các thành phần HTML.</p>', '', 1.0, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-08-04 23:41:59.414', '2024-08-04 23:41:59.414', NULL, false, 'TRUE_FALSE'::public."qtype", 'EASY'::public."difficulty");
INSERT INTO public.question
(id, org_id, "name", question_text, general_feedback, default_mark, created_by, updated_by, created_at, updated_at, question_bank_category_id, is_org_question_bank, "qtype", "difficulty")
VALUES('7c923a3b-aee6-4890-b96f-7f0a812d1021'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'Node.js là một môi trường chạy JavaScript trên phía server.', '<p>Node.js là một môi trường chạy JavaScript trên phía server.</p>', '', 1.0, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-08-04 23:42:11.556', '2024-08-04 23:42:11.556', NULL, false, 'TRUE_FALSE'::public."qtype", 'EASY'::public."difficulty");
INSERT INTO public.question
(id, org_id, "name", question_text, general_feedback, default_mark, created_by, updated_by, created_at, updated_at, question_bank_category_id, is_org_question_bank, "qtype", "difficulty")
VALUES('2ec85315-a873-4b65-a4f3-4c86d60d2fb7'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'Angular là một framework cho phát triển ứng dụng web front-end.', '<p>Angular là một framework cho phát triển ứng dụng web front-end.</p>', '', 1.0, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-08-04 23:42:23.546', '2024-08-04 23:42:23.546', NULL, false, 'TRUE_FALSE'::public."qtype", 'EASY'::public."difficulty");
INSERT INTO public.question
(id, org_id, "name", question_text, general_feedback, default_mark, created_by, updated_by, created_at, updated_at, question_bank_category_id, is_org_question_bank, "qtype", "difficulty")
VALUES('57fd911a-3ca5-4316-90e3-a582dfc7f3b1'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'Ngôn ngữ đánh dấu được sử dụng để tạo cấu trúc của trang web là ___.', '<p>Ngôn ngữ đánh dấu được sử dụng để tạo cấu trúc của trang web là ___.</p>', '', 1.0, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-08-04 23:42:49.686', '2024-08-04 23:42:49.686', NULL, false, 'SHORT_ANSWER'::public."qtype", 'EASY'::public."difficulty");
INSERT INTO public.question
(id, org_id, "name", question_text, general_feedback, default_mark, created_by, updated_by, created_at, updated_at, question_bank_category_id, is_org_question_bank, "qtype", "difficulty")
VALUES('c43ef98c-79bd-4dc2-9877-3a826c641a3f'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'Framework JavaScript phổ biến được phát triển bởi Facebook để xây dựng giao diện người dùng là ___.', '<p>Framework JavaScript phổ biến được phát triển bởi Facebook để xây dựng giao diện người dùng là ___.</p>', '', 1.0, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-08-04 23:43:13.821', '2024-08-04 23:43:13.821', NULL, false, 'SHORT_ANSWER'::public."qtype", 'EASY'::public."difficulty");
INSERT INTO public.question
(id, org_id, "name", question_text, general_feedback, default_mark, created_by, updated_by, created_at, updated_at, question_bank_category_id, is_org_question_bank, "qtype", "difficulty")
VALUES('81fb484b-e882-4b97-865c-4b486a3090d6'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'Giao thức bảo mật được sử dụng để truyền tải dữ liệu một cách an toàn giữa trình duyệt và server là ___.', '<p>Giao thức bảo mật được sử dụng để truyền tải dữ liệu một cách an toàn giữa trình duyệt và server là ___.</p>', '', 1.0, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-08-04 23:43:41.978', '2024-08-04 23:43:41.978', NULL, false, 'SHORT_ANSWER'::public."qtype", 'EASY'::public."difficulty");
INSERT INTO public.question
(id, org_id, "name", question_text, general_feedback, default_mark, created_by, updated_by, created_at, updated_at, question_bank_category_id, is_org_question_bank, "qtype", "difficulty")
VALUES('ff9e5072-6d48-4e97-a059-54729cbf7526'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'Những công nghệ nào sau đây thường được sử dụng trong phát triển ứng dụng web front-end?', '<p>Những công nghệ nào sau đây thường được sử dụng trong phát triển ứng dụng web front-end?</p>', '', 1.0, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-08-04 23:45:22.452', '2024-08-04 23:45:22.452', NULL, false, 'MULTIPLE_CHOICE'::public."qtype", 'EASY'::public."difficulty");
INSERT INTO public.question
(id, org_id, "name", question_text, general_feedback, default_mark, created_by, updated_by, created_at, updated_at, question_bank_category_id, is_org_question_bank, "qtype", "difficulty")
VALUES('6335b900-459f-4ded-a78d-d3e9d84ce78b'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'Những framework nào sau đây là framework phổ biến cho phát triển ứng dụng web back-end?', '<p>Những framework nào sau đây là framework phổ biến cho phát triển ứng dụng web back-end?</p>', '', 1.0, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-08-04 23:46:18.751', '2024-08-04 23:46:18.751', NULL, false, 'MULTIPLE_CHOICE'::public."qtype", 'EASY'::public."difficulty");
INSERT INTO public.question
(id, org_id, "name", question_text, general_feedback, default_mark, created_by, updated_by, created_at, updated_at, question_bank_category_id, is_org_question_bank, "qtype", "difficulty")
VALUES('bd5963e5-a5a9-4a9b-8f30-061dcea3988a'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'Những phương pháp nào sau đây có thể giúp tối ưu hóa hiệu suất của trang web?', '<p>Những phương pháp nào sau đây có thể giúp tối ưu hóa hiệu suất của trang web?</p>', '', 1.0, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-08-04 23:47:37.194', '2024-08-04 23:47:37.194', NULL, false, 'MULTIPLE_CHOICE'::public."qtype", 'EASY'::public."difficulty");
INSERT INTO public.question
(id, org_id, "name", question_text, general_feedback, default_mark, created_by, updated_by, created_at, updated_at, question_bank_category_id, is_org_question_bank, "qtype", "difficulty")
VALUES('38ad9c73-9f87-4106-879a-6c7b6352453c'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'Những thành phần nào sau đây là thành phần cơ bản của hệ thống thông tin?', '<p>Những thành phần nào sau đây là thành phần cơ bản của hệ thống thông tin?</p>', '', 1.0, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-08-04 23:49:47.807', '2024-08-04 23:49:47.807', NULL, false, 'MULTIPLE_CHOICE'::public."qtype", 'EASY'::public."difficulty");
INSERT INTO public.question
(id, org_id, "name", question_text, general_feedback, default_mark, created_by, updated_by, created_at, updated_at, question_bank_category_id, is_org_question_bank, "qtype", "difficulty")
VALUES('54252d90-a401-4a28-88a0-1d9f53d0f7d6'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'Những loại hệ thống thông tin nào sau đây thường được sử dụng trong các tổ chức?', '<p>Những loại hệ thống thông tin nào sau đây thường được sử dụng trong các tổ chức?</p>', '', 1.0, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-08-04 23:51:08.162', '2024-08-04 23:51:08.162', NULL, false, 'MULTIPLE_CHOICE'::public."qtype", 'EASY'::public."difficulty");
INSERT INTO public.question
(id, org_id, "name", question_text, general_feedback, default_mark, created_by, updated_by, created_at, updated_at, question_bank_category_id, is_org_question_bank, "qtype", "difficulty")
VALUES('a498bde0-a531-4dc4-a11f-61a685f03d58'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'Những yếu tố nào sau đây có thể ảnh hưởng đến hiệu quả của hệ thống thông tin?', '<p>Những yếu tố nào sau đây có thể ảnh hưởng đến hiệu quả của hệ thống thông tin?</p>', '', 1.0, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-08-04 23:52:36.583', '2024-08-04 23:52:36.583', NULL, false, 'MULTIPLE_CHOICE'::public."qtype", 'EASY'::public."difficulty");
INSERT INTO public.question
(id, org_id, "name", question_text, general_feedback, default_mark, created_by, updated_by, created_at, updated_at, question_bank_category_id, is_org_question_bank, "qtype", "difficulty")
VALUES('f324a283-eb75-44ee-a87d-95c8557e3afe'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'Hệ thống thông tin có khả năng hỗ trợ các quyết định bán cấu trúc và không cấu trúc thường được gọi là ___.', '<p>Hệ thống thông tin có khả năng hỗ trợ các quyết định bán cấu trúc và không cấu trúc thường được gọi là ___.</p>', '', 1.0, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-08-04 23:53:04.731', '2024-08-04 23:53:04.731', NULL, false, 'SHORT_ANSWER'::public."qtype", 'EASY'::public."difficulty");
INSERT INTO public.question
(id, org_id, "name", question_text, general_feedback, default_mark, created_by, updated_by, created_at, updated_at, question_bank_category_id, is_org_question_bank, "qtype", "difficulty")
VALUES('4817c348-c195-4cb5-aa9a-1605d0bf85cb'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'Quá trình thu thập, xử lý, lưu trữ và phân phối thông tin để hỗ trợ các quyết định và kiểm soát trong một tổ chức được gọi là ___.', '<p>Quá trình thu thập, xử lý, lưu trữ và phân phối thông tin để hỗ trợ các quyết định và kiểm soát trong một tổ chức được gọi là ___.</p>', '', 1.0, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-08-04 23:53:26.828', '2024-08-04 23:53:26.828', NULL, false, 'SHORT_ANSWER'::public."qtype", 'EASY'::public."difficulty");
INSERT INTO public.question
(id, org_id, "name", question_text, general_feedback, default_mark, created_by, updated_by, created_at, updated_at, question_bank_category_id, is_org_question_bank, "qtype", "difficulty")
VALUES('887dc519-25fd-4756-a1bb-282d51c3c1c0'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'Một phần mềm được sử dụng để quản lý và tương tác với cơ sở dữ liệu là ___.', '<p>Một phần mềm được sử dụng để quản lý và tương tác với cơ sở dữ liệu là ___.</p>', '', 1.0, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-08-04 23:53:50.944', '2024-08-04 23:53:50.944', NULL, false, 'SHORT_ANSWER'::public."qtype", 'EASY'::public."difficulty");
INSERT INTO public.question
(id, org_id, "name", question_text, general_feedback, default_mark, created_by, updated_by, created_at, updated_at, question_bank_category_id, is_org_question_bank, "qtype", "difficulty")
VALUES('a83546aa-471e-4e6a-9b60-72a8bb18e768'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'Hệ thống thông tin tích hợp các chức năng quản lý tài chính, nhân sự, sản xuất và các chức năng kinh doanh khác vào một hệ thống duy nhất là ___.', '<p>Hệ thống thông tin tích hợp các chức năng quản lý tài chính, nhân sự, sản xuất và các chức năng kinh doanh khác vào một hệ thống duy nhất là ___.</p>', '', 1.0, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-08-04 23:54:17.067', '2024-08-04 23:54:17.067', NULL, false, 'SHORT_ANSWER'::public."qtype", 'EASY'::public."difficulty");
INSERT INTO public.question
(id, org_id, "name", question_text, general_feedback, default_mark, created_by, updated_by, created_at, updated_at, question_bank_category_id, is_org_question_bank, "qtype", "difficulty")
VALUES('777eacb8-9d55-4192-9c16-6f2eddca0c7d'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'Hệ thống thông tin chỉ bao gồm phần cứng và phần mềm.', '<p>Hệ thống thông tin chỉ bao gồm phần cứng và phần mềm.</p>', '', 1.0, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-08-04 23:54:33.134', '2024-08-04 23:54:33.134', NULL, false, 'TRUE_FALSE'::public."qtype", 'EASY'::public."difficulty");
INSERT INTO public.question
(id, org_id, "name", question_text, general_feedback, default_mark, created_by, updated_by, created_at, updated_at, question_bank_category_id, is_org_question_bank, "qtype", "difficulty")
VALUES('2ab7f04f-0c51-46dc-a492-50af3a21945a'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'Hệ thống thông tin quản lý (MIS) thường được sử dụng để hỗ trợ các quyết định chiến lược trong một tổ chức.', '<p>Hệ thống thông tin quản lý (MIS) thường được sử dụng để hỗ trợ các quyết định chiến lược trong một tổ chức.</p>', '', 1.0, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-08-04 23:54:45.202', '2024-08-04 23:54:45.202', NULL, false, 'TRUE_FALSE'::public."qtype", 'EASY'::public."difficulty");
INSERT INTO public.question
(id, org_id, "name", question_text, general_feedback, default_mark, created_by, updated_by, created_at, updated_at, question_bank_category_id, is_org_question_bank, "qtype", "difficulty")
VALUES('f5b1e99a-9c1a-4f1d-b469-2a6aa6f1fe14'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'Dữ liệu trong hệ thống thông tin luôn phải được mã hóa để đảm bảo an toàn.', '<p>Dữ liệu trong hệ thống thông tin luôn phải được mã hóa để đảm bảo an toàn.</p>', '', 1.0, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-08-04 23:55:07.289', '2024-08-04 23:55:07.289', NULL, false, 'TRUE_FALSE'::public."qtype", 'EASY'::public."difficulty");
INSERT INTO public.question
(id, org_id, "name", question_text, general_feedback, default_mark, created_by, updated_by, created_at, updated_at, question_bank_category_id, is_org_question_bank, "qtype", "difficulty")
VALUES('f16a9095-5c9b-4bc3-a82c-eeb9227842d0'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'ERP (Enterprise Resource Planning) là một loại hệ thống thông tin tích hợp nhiều chức năng kinh doanh khác nhau vào một hệ thống duy nhất.', '<p>ERP (Enterprise Resource Planning) là một loại hệ thống thông tin tích hợp nhiều chức năng kinh doanh khác nhau vào một hệ thống duy nhất.</p>', '', 1.0, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-08-04 23:55:21.377', '2024-08-04 23:55:21.377', NULL, false, 'TRUE_FALSE'::public."qtype", 'EASY'::public."difficulty");

INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('7ba6c701-ea50-4350-854f-804904f04d21'::uuid, '560c0865-35df-486d-b886-5189c0a5d66f'::uuid, 'Correct', 'true', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('846462a1-729d-4c14-a533-0d61268e503a'::uuid, '01f3b10a-43b4-4400-863a-bf02fee2c7a7'::uuid, 'Correct', 'false', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('aaf4f04a-57d8-4477-8133-c1914f88bf2c'::uuid, 'c3a2ceac-f0f3-4ed1-8083-a851af7e563a'::uuid, 'Correct', 'false', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('8d3badbf-cc9d-4d5e-9a94-4f1d7d740efa'::uuid, 'a267478d-407d-490a-a771-6575db96cf03'::uuid, 'Correct', 'false', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('ab1849cc-766a-4a8c-8d4b-f16a6c68ece6'::uuid, '1278efc3-479f-4bb8-a839-10cf23e95788'::uuid, '<p>lập trình hướng đối tượng</p>', 'lập trình hướng đối tượng', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('524d7eed-b802-482b-8a8c-0cb964453657'::uuid, 'e99a6172-ef91-4b99-b800-d76b9c74a1d3'::uuid, '<p>class</p>', 'class', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('5f72a734-e87b-46b6-a5b4-85d7348b9fe9'::uuid, '193a4ec2-af70-4fb7-ae2e-b4bf3e11dbad'::uuid, '<p>stack</p>', 'stack', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('0a0bea20-0f9f-464a-9b91-7164ec93a212'::uuid, '496b4abe-ee7b-47b4-9553-004729a3587e'::uuid, '<p>đệ quy</p>', 'đệ quy', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('9fce4acb-b806-41f4-9cf1-4894df7f9542'::uuid, '382f4794-f1c8-4b32-bac5-8654ad46b6e8'::uuid, '<p>Python</p>', '<p>Python</p>', 0.50);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('e2e47065-bb4b-4350-8061-96d7b83eda32'::uuid, '382f4794-f1c8-4b32-bac5-8654ad46b6e8'::uuid, '<p>C</p>', '<p>C</p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('eb739ec0-aa6e-4873-b60d-ea2c02f98395'::uuid, '382f4794-f1c8-4b32-bac5-8654ad46b6e8'::uuid, '<p>Java</p>', '<p>Java</p>', 0.50);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('9ad9737d-867f-47a8-b638-bfa0d16991f6'::uuid, '382f4794-f1c8-4b32-bac5-8654ad46b6e8'::uuid, '<p>HTML</p>', '<p>HTML</p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('2d2a055d-554c-4302-9042-05f807f5f974'::uuid, 'a5d85c32-a968-4f0b-8072-99e652887a9f'::uuid, '<p>Danh sách liên kết</p>', '<p>Danh sách liên kết</p>', 0.50);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('f3e5baa7-f80c-4f15-a46c-5c1f6e0ff5e5'::uuid, 'a5d85c32-a968-4f0b-8072-99e652887a9f'::uuid, '<p>Cây nhị phân</p>', '<p>Cây nhị phân</p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('910e49f0-8784-4ecf-bf57-e17b0b533335'::uuid, 'a5d85c32-a968-4f0b-8072-99e652887a9f'::uuid, '<p>Ngăn xếp</p>', '<p>Ngăn xếp</p>', 0.50);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('11bb7b97-1eb9-46d8-a795-1a8dd0de4616'::uuid, 'a5d85c32-a968-4f0b-8072-99e652887a9f'::uuid, '<p>Đồ thị</p>', '<p>Đồ thị</p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('6c4b8f8d-34ef-47c7-a601-39471c343235'::uuid, '0df9d983-e43f-4ee3-b832-51acce5669e7'::uuid, '<p>Đóng gói</p>', '<p>Đóng gói</p>', 0.50);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('98cc1506-97ed-438d-9a14-f53290296eff'::uuid, '0df9d983-e43f-4ee3-b832-51acce5669e7'::uuid, '<p>Hàm đệ quy</p>', '<p>Hàm đệ quy</p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('37853f30-ae7b-4367-9c05-3d168cfb8541'::uuid, '0df9d983-e43f-4ee3-b832-51acce5669e7'::uuid, '<p>Kế thừa</p>', '<p>Kế thừa</p>', 0.50);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('6555aaba-4f72-45ba-be99-dc8beaa266a1'::uuid, '0df9d983-e43f-4ee3-b832-51acce5669e7'::uuid, '<p>Phân tích dữ liệu</p>', '<p>Phân tích dữ liệu</p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('126f915b-eaf1-45b6-bcd7-b0f470aeb92d'::uuid, '143b4f9a-2bf2-45e7-9b3d-047414b85226'::uuid, 'Correct', 'false', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('1aa00b7e-f048-4fa2-b09f-713a7dc627ce'::uuid, '83ab4947-2289-4432-9cb4-5a391c7b8f4f'::uuid, 'Correct', 'true', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('67c48f30-b05a-4c47-9a12-a7cf175fa90c'::uuid, '7c923a3b-aee6-4890-b96f-7f0a812d1021'::uuid, 'Correct', 'true', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('658ba633-baf2-4332-a567-90fdedcf1830'::uuid, '2ec85315-a873-4b65-a4f3-4c86d60d2fb7'::uuid, 'Correct', 'true', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('4615bf88-b9cf-4217-943b-ba2654ac3669'::uuid, '57fd911a-3ca5-4316-90e3-a582dfc7f3b1'::uuid, '<p>HTML</p>', 'HTML', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('6691a1ca-a4b8-4b6c-b0a1-7b1dc818651c'::uuid, 'c43ef98c-79bd-4dc2-9877-3a826c641a3f'::uuid, '<p>React</p>', 'React', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('b385ca6c-6e92-4cf8-a67a-3e02e3609458'::uuid, '81fb484b-e882-4b97-865c-4b486a3090d6'::uuid, '<p>HTTPS</p>', 'HTTPS', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('41ac4267-5cef-478c-9d78-b60538484c66'::uuid, 'ff9e5072-6d48-4e97-a059-54729cbf7526'::uuid, '<p>HTML</p>', '<p>HTML</p>', 0.50);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('3f203216-22fd-4f15-8146-ef343e9adcfa'::uuid, 'ff9e5072-6d48-4e97-a059-54729cbf7526'::uuid, '<p>CSS</p>', '<p>CSS</p>', 0.50);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('9daa71b2-353d-4290-ab08-51cfa8910964'::uuid, 'ff9e5072-6d48-4e97-a059-54729cbf7526'::uuid, '<p>Java</p>', '<p>Java</p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('132e1fcf-f86c-450a-b202-18156a5987e6'::uuid, 'ff9e5072-6d48-4e97-a059-54729cbf7526'::uuid, '<p>Node.js</p>', '<p>Node.js</p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('43345703-f725-4411-b1f1-d80b1bc49b73'::uuid, '6335b900-459f-4ded-a78d-d3e9d84ce78b'::uuid, '<p>React</p>', '<p>React</p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('16fa6bd0-ea1a-43ad-9142-0a2f2beb3461'::uuid, '6335b900-459f-4ded-a78d-d3e9d84ce78b'::uuid, '<p>Django</p>', '<p>Django</p>', 0.50);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('96d5db66-74b5-4d96-94f0-8c04b0df3469'::uuid, '6335b900-459f-4ded-a78d-d3e9d84ce78b'::uuid, '<p>Laravel</p>', '<p>Laravel</p>', 0.50);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('b4c83d5d-3033-45e0-bc95-82f9c1a3da28'::uuid, '6335b900-459f-4ded-a78d-d3e9d84ce78b'::uuid, '<p>Angular</p>', '<p>Angular</p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('664657dc-6d9b-4c4e-b4b3-3892d0d29152'::uuid, 'bd5963e5-a5a9-4a9b-8f30-061dcea3988a'::uuid, '<p>Sử dụng bộ nhớ đệm (caching)</p>', '<p>Sử dụng bộ nhớ đệm (caching)</p>', 0.30);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('9455b8a7-063a-481a-848a-d668455a49ec'::uuid, 'bd5963e5-a5a9-4a9b-8f30-061dcea3988a'::uuid, '<p>Tối ưu hóa hình ảnh</p>', '<p>Tối ưu hóa hình ảnh</p>', 0.30);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('9be1affd-9f8f-474a-810a-093814d1fc2a'::uuid, 'bd5963e5-a5a9-4a9b-8f30-061dcea3988a'::uuid, '<p>Sử dụng nhiều font chữ</p>', '<p>Sử dụng nhiều font chữ</p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('3ebcbb0c-4915-4bde-8b8f-9735bdf2402b'::uuid, 'bd5963e5-a5a9-4a9b-8f30-061dcea3988a'::uuid, '<p>Giảm thiểu số lượng yêu cầu HTTP</p>', '<p>Giảm thiểu số lượng yêu cầu HTTP</p>', 0.40);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('4b22022f-f3c4-4080-8e86-ee8e04705c4e'::uuid, '38ad9c73-9f87-4106-879a-6c7b6352453c'::uuid, '<p>Phần cứng</p>', '<p>Phần cứng</p>', 0.25);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('279e01a8-8cbd-4a19-b35f-1b6d6d599ee1'::uuid, '38ad9c73-9f87-4106-879a-6c7b6352453c'::uuid, '<p>Phần mềm</p>', '<p>Phần mềm</p>', 0.25);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('4984e0d6-9254-4c96-870d-cb4a4d90db71'::uuid, '38ad9c73-9f87-4106-879a-6c7b6352453c'::uuid, '<p>Dữ liệu</p>', '<p>Dữ liệu</p>', 0.25);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('86a989e4-d74c-4a2d-850f-61797ed0e8d9'::uuid, '38ad9c73-9f87-4106-879a-6c7b6352453c'::uuid, '<p>Người sử dụng</p>', '<p>Người sử dụng</p>', 0.25);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('351facaa-52fc-4dab-ac90-501cd42ab2a3'::uuid, '54252d90-a401-4a28-88a0-1d9f53d0f7d6'::uuid, '<p>Hệ thống xử lý giao dịch (TPS)</p>', '<p>Hệ thống xử lý giao dịch (TPS)</p>', 0.30);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('8b7080d1-dafe-4697-b585-32b66dbc7c59'::uuid, '54252d90-a401-4a28-88a0-1d9f53d0f7d6'::uuid, '<p>Hệ thống hỗ trợ quyết định (DSS)</p>', '<p>Hệ thống hỗ trợ quyết định (DSS)</p>', 0.30);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('3edb6097-4caf-4b82-b907-b57a82d4a9ee'::uuid, '54252d90-a401-4a28-88a0-1d9f53d0f7d6'::uuid, '<p>Hệ thống thông tin điều hành (EIS)</p>', '<p>Hệ thống thông tin điều hành (EIS)</p>', 0.40);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('acac9865-8066-4efe-b6ef-a5486d168fc7'::uuid, '54252d90-a401-4a28-88a0-1d9f53d0f7d6'::uuid, '<p>Hệ thống quản lý cơ sở dữ liệu (DBMS)</p>', '<p>Hệ thống quản lý cơ sở dữ liệu (DBMS)</p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('4c3eb786-3c24-4b0f-ad3d-11ba2420fbf9'::uuid, 'a498bde0-a531-4dc4-a11f-61a685f03d58'::uuid, '<p>Công nghệ</p>', '<p>Công nghệ</p>', 0.25);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('4c23e2fc-cf00-45b9-820a-0b9b5d156f21'::uuid, 'a498bde0-a531-4dc4-a11f-61a685f03d58'::uuid, '<p>Quản lý</p>', '<p>Quản lý</p>', 0.25);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('934a4f13-3402-4616-bbb9-d59fd2b2992c'::uuid, 'a498bde0-a531-4dc4-a11f-61a685f03d58'::uuid, '<p>Người sử dụng</p>', '<p>Người sử dụng</p>', 0.25);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('ba617f29-f2f7-4eab-95c8-ba12cc2aeb04'::uuid, 'a498bde0-a531-4dc4-a11f-61a685f03d58'::uuid, '<p>Chính sách công ty</p>', '<p>Chính sách công ty</p>', 0.25);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('7936790c-2f00-41c3-a7bd-e20a10e365da'::uuid, 'f324a283-eb75-44ee-a87d-95c8557e3afe'::uuid, '<p>hệ thống hỗ trợ quyết định (DSS)</p>', 'hệ thống hỗ trợ quyết định (DSS)', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('72f1589a-ceb8-40fc-8ab8-13ad1ce2d751'::uuid, '4817c348-c195-4cb5-aa9a-1605d0bf85cb'::uuid, '<p>hệ thống thông tin quản lý (MIS)</p>', 'hệ thống thông tin quản lý (MIS)', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('671f458f-ca6c-473c-ace4-ac7a59311cfb'::uuid, '887dc519-25fd-4756-a1bb-282d51c3c1c0'::uuid, '<p>hệ thống quản lý cơ sở dữ liệu (DBMS)</p>', 'hệ thống quản lý cơ sở dữ liệu (DBMS)', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('7e3aed82-27ab-4e97-a8c9-6d23a0a7b889'::uuid, 'a83546aa-471e-4e6a-9b60-72a8bb18e768'::uuid, '<p>hệ thống hoạch định nguồn lực doanh nghiệp (ERP)</p>', 'hệ thống hoạch định nguồn lực doanh nghiệp (ERP)', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('76459464-0cad-4d40-9344-502742ba4403'::uuid, '777eacb8-9d55-4192-9c16-6f2eddca0c7d'::uuid, 'Correct', 'false', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('8c6a2ff9-7f6c-4023-aa19-d613e148ef96'::uuid, '2ab7f04f-0c51-46dc-a492-50af3a21945a'::uuid, 'Correct', 'true', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('41fbe710-cfd6-4043-bbc1-2b78ca1896db'::uuid, 'f5b1e99a-9c1a-4f1d-b469-2a6aa6f1fe14'::uuid, 'Correct', 'false', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('416d1b89-d3fb-430e-8024-89f33548fe46'::uuid, 'f16a9095-5c9b-4bc3-a82c-eeb9227842d0'::uuid, 'Correct', 'true', 1.00);
---------------