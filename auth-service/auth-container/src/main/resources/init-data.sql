INSERT INTO public.main_organization (id,description,name,email,phone,address,api_key,moodle_url,created_at,updated_at,updated_by,created_by,is_deleted) VALUES
	 ('ffd44f60-aaa2-4142-ae73-7727b3051ddb',NULL,'Code Dynamite','codedynamite@gmail.com','12345678',NULL,NULL,NULL,'2024-04-15 18:37:44.08878+07','2024-04-15 18:37:44.08878+07','9ba179ed-d26d-4828-a0f6-8836c2063992','9ba179ed-d26d-4828-a0f6-8836c2063992',false),
	 ('08b65a39-394f-4977-a5fa-3fe145b620f8',NULL,'moodle2','moodle234@gmail.com','12345678',NULL,NULL,NULL,'2024-04-15 18:09:29.488151+07','2024-04-15 18:09:29.488151+07','9ba179ed-d26d-4828-a0f6-8836c2063992','9ba179ed-d26d-4828-a0f6-8836c2063992',false),
	 ('3ead3b08-afdd-442f-b544-fdbd86eaa186',NULL,'Code Dynamite','codedynamite@gmail.com','12345678',NULL,NULL,NULL,'2024-04-15 18:09:40.033204+07','2024-04-15 18:09:40.033204+07','9ba179ed-d26d-4828-a0f6-8836c2063992','9ba179ed-d26d-4828-a0f6-8836c2063992',false);

INSERT INTO public.main_user (id,organization_id,is_linked_with_google,is_linked_with_microsoft,email,username,dob,first_name,last_name,phone,address,avatar_url,refresh_token,last_login,created_at,updated_at,is_deleted) VALUES
	 ('9ba179ed-d26d-4828-a0f6-8836c2063992','08b65a39-394f-4977-a5fa-3fe145b620f8',false,false,'nguyenquoctuan385@gmail.com','nguyenquoctuan385@gmail.com','2002-05-29','Tuan','Nguyen Quoc','+8412365478','HCM',NULL,NULL,'2024-04-12 21:33:23.371836+07','2024-04-12 21:33:23.371836+07','2024-04-12 21:33:23.371836+07',false),
	 ('b029f559-52a8-4699-b595-71161498ed8c',null,false,false,'dcthong852@gmail.com','dcthong852@gmail.com','2002-04-29','Thong','Duong','+8412365478',NULL,NULL,NULL,'2024-04-15 18:07:20.891115+07','2024-04-15 18:07:20.891115+07','2024-04-15 18:07:20.891115+07',false),
	 ('8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7','08b65a39-394f-4977-a5fa-3fe145b620f8',false,false,'nthoang852@gmail.com','nthoang852@gmail.com','2002-03-29','Hoang','Nguyen Thanh','+8412365478',NULL,NULL,NULL,'2024-04-15 18:07:41.151759+07','2024-04-15 18:07:41.151759+07','2024-04-15 18:07:41.151759+07',false),
	 ('39328bcf-8af6-44fc-9ae9-247f953ee2a2','08b65a39-394f-4977-a5fa-3fe145b620f8',false,false,'ndqkhanh852@gmail.com','ndqkhanh852@gmail.com','2002-03-29','Khanh','Nguyen Dinh','+8412365478',NULL,NULL,NULL,'2024-04-15 18:07:41.151759+07','2024-04-15 18:07:41.151759+07','2024-04-15 18:07:41.151759+07',false),
	 ('8edbc0aa-0b91-480e-a428-23abf2109df9','08b65a39-394f-4977-a5fa-3fe145b620f8',false,false,'tgtien852@gmail.com','tgtien852@gmail.com','2002-03-29','Tien','Truong Gia','+8412365478',NULL,NULL,NULL,'2024-04-15 18:07:41.151759+07','2024-04-15 18:07:41.151759+07','2024-04-15 18:07:41.151759+07',false),
	 ('05dbdfde-1eae-47ba-8ebb-6c4cdc4f6510','08b65a39-394f-4977-a5fa-3fe145b620f8',false,false,'dntien852@gmail.com','dntien852@gmail.com','2002-03-29','Tien','Dang Ngoc','+8412365478',NULL,NULL,NULL,'2024-04-15 18:07:41.151759+07','2024-04-15 18:07:41.151759+07','2024-04-15 18:07:41.151759+07',false),
	 ('64412e27-169e-44ea-a101-74ebf8cb82d9','08b65a39-394f-4977-a5fa-3fe145b620f8',false,false,'kayonkiu@gmail.com','kayonkiu@gmail.com','2002-03-29','Tien','Ngoc','+8412365478',NULL,NULL,NULL,'2024-04-15 18:07:41.151759+07','2024-04-15 18:07:41.151759+07','2024-04-15 18:07:41.151759+07',false),
	 ('cb2c22ac-87de-44e4-9638-35979f6af667','08b65a39-394f-4977-a5fa-3fe145b620f8',false,false,'duongchithong2002@gmail.com','duongchithong2002@gmail.com','2002-03-29','Dương','Chí Thông','+8412365478',NULL,NULL,NULL,'2024-04-15 18:07:41.151759+07','2024-04-15 18:07:41.151759+07','2024-04-15 18:07:41.151759+07',false),
	 ('2d7ed5a0-fb21-4927-9a25-647c17d29668','08b65a39-394f-4977-a5fa-3fe145b620f8',false,false,'dntienes@gmail.com','dntienes@gmail.com','2002-03-29','Tiến','Đặng Ngọc','+8412365478',NULL,NULL,NULL,'2024-04-15 18:07:41.151759+07','2024-04-15 18:07:41.151759+07','2024-04-15 18:07:41.151759+07',false),
	 ('2d3c1e66-1835-457f-93e9-265fe483feee','08b65a39-394f-4977-a5fa-3fe145b620f8',false,false,'dt.ngocthw@gmail.com','dt.ngocthw@gmail.com','2002-03-29','Thư','Ngọc','+8412365478',NULL,NULL,NULL,'2024-04-15 18:07:41.151759+07','2024-04-15 18:07:41.151759+07','2024-04-15 18:07:41.151759+07',false),
	 ('a9f5487e-c0b1-4fa4-b93a-6f16bde90583','08b65a39-394f-4977-a5fa-3fe145b620f8',false,false,'ktpm4t@gmail.com','ktpm4t@gmail.com','2002-03-29','giáo','vien','+8412365478',NULL,NULL,NULL,'2024-04-15 18:07:41.151759+07','2024-04-15 18:07:41.151759+07','2024-04-15 18:07:41.151759+07',false),
	 ('ca3040f2-e173-40a5-aab7-6ef15965ce43','08b65a39-394f-4977-a5fa-3fe145b620f8',false,false,'truonggiatien123@gmail.com','truonggiatien123@gmail.com','2002-03-29','Trương','Gia Tiến','+8412365478',NULL,NULL,NULL,'2024-04-15 18:07:41.151759+07','2024-04-15 18:07:41.151759+07','2024-04-15 18:07:41.151759+07',false);

INSERT INTO public."role"
(id, description, name)
VALUES('350ab76e-5785-42b4-ac5c-1b9490f30038', NULL, 'admin'),
('9ba179ed-d26d-4828-a0f6-8836c2063992', NULL, 'user'),
('b04387d3-898f-402c-8f44-79611d6f3bee', NULL, 'student_moodle'),
('f705404f-5971-455e-9c34-93a0ce5b90b5', NULL, 'lecturer_moodle'),
('3ead3b08-afdd-442f-b544-fdbd86eaa186', NULL, 'admin_moodle');

INSERT INTO public.user_role (id,user_id,role_id) VALUES
	 ('5991f22b-f530-4913-88f2-90319ee93a76','9ba179ed-d26d-4828-a0f6-8836c2063992','b04387d3-898f-402c-8f44-79611d6f3bee'),
	 ('8afa567c-dd61-4ade-96b8-abc78d45875f','b029f559-52a8-4699-b595-71161498ed8c','350ab76e-5785-42b4-ac5c-1b9490f30038'),
     ('d2a22212-5dba-44c1-9de0-b3849fe6d1d8','8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7','b04387d3-898f-402c-8f44-79611d6f3bee'),
     ('b0ffd718-703b-4e56-8c7f-44159b8ec42c','39328bcf-8af6-44fc-9ae9-247f953ee2a2','f705404f-5971-455e-9c34-93a0ce5b90b5'),
     ('a2471ff5-508a-48c3-91d6-b109aa746099','8edbc0aa-0b91-480e-a428-23abf2109df9','3ead3b08-afdd-442f-b544-fdbd86eaa186'),
     ('13050987-00d6-42fc-870e-a90f06f7f627','9ba179ed-d26d-4828-a0f6-8836c2063992','9ba179ed-d26d-4828-a0f6-8836c2063992'),
     ('ffef89c5-2b73-4f9c-bb83-3fe99d980b8a','b029f559-52a8-4699-b595-71161498ed8c','9ba179ed-d26d-4828-a0f6-8836c2063992'),
     ('81195d13-f5d9-407f-965b-9bb42f70e7f8','8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7','9ba179ed-d26d-4828-a0f6-8836c2063992'),
     ('e7c82f19-c134-434d-9f5b-1344243b7b8e','39328bcf-8af6-44fc-9ae9-247f953ee2a2','9ba179ed-d26d-4828-a0f6-8836c2063992'),
     ('45d4ef4e-b0cd-433c-a21f-3c3889a82e07','8edbc0aa-0b91-480e-a428-23abf2109df9','9ba179ed-d26d-4828-a0f6-8836c2063992'),
     ('bc472603-137c-4187-b9bc-fdcb103e28d3','05dbdfde-1eae-47ba-8ebb-6c4cdc4f6510','9ba179ed-d26d-4828-a0f6-8836c2063992'),
     ('7e674f22-76c6-474c-b0b5-c8efbc524e13','64412e27-169e-44ea-a101-74ebf8cb82d9','9ba179ed-d26d-4828-a0f6-8836c2063992'),
     ('8ae760c2-cad7-460d-9a42-d581da1d0abf','64412e27-169e-44ea-a101-74ebf8cb82d9','f705404f-5971-455e-9c34-93a0ce5b90b5'),
     ('d547f452-1bb6-4937-bbf0-1a3599ead9f1','cb2c22ac-87de-44e4-9638-35979f6af667','9ba179ed-d26d-4828-a0f6-8836c2063992'),
     ('93e86824-14e9-49cd-9dc3-e9b68709359d','cb2c22ac-87de-44e4-9638-35979f6af667','b04387d3-898f-402c-8f44-79611d6f3bee'),
     ('ba7786a1-3925-437d-b75d-dfcf80cee7ed','2d7ed5a0-fb21-4927-9a25-647c17d29668','9ba179ed-d26d-4828-a0f6-8836c2063992'),
     ('bad8c925-6211-476a-9b0b-2cdd00715a34','2d7ed5a0-fb21-4927-9a25-647c17d29668','b04387d3-898f-402c-8f44-79611d6f3bee'),
     ('b102acbf-0214-426d-bd2c-8c18897aaa5e','2d3c1e66-1835-457f-93e9-265fe483feee','9ba179ed-d26d-4828-a0f6-8836c2063992'),
     ('9e1c6dd6-03f1-4ae4-9a04-d06966181bfa','2d3c1e66-1835-457f-93e9-265fe483feee','b04387d3-898f-402c-8f44-79611d6f3bee'),
     ('95691943-85e3-45b6-a737-483232a43496','a9f5487e-c0b1-4fa4-b93a-6f16bde90583','9ba179ed-d26d-4828-a0f6-8836c2063992'),
     ('45483a8b-3663-4170-86bf-3b937bd2a2b5','a9f5487e-c0b1-4fa4-b93a-6f16bde90583','f705404f-5971-455e-9c34-93a0ce5b90b5'),
     ('fccdb925-763e-460d-9426-2f299f1f4a76','ca3040f2-e173-40a5-aab7-6ef15965ce43','9ba179ed-d26d-4828-a0f6-8836c2063992'),
     ('cd2fca53-4ed5-4f41-a277-7558de2f2af5','ca3040f2-e173-40a5-aab7-6ef15965ce43','b04387d3-898f-402c-8f44-79611d6f3bee');
