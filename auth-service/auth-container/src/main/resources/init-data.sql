INSERT INTO public.main_organization (id,description,name,email,phone,address,api_key,moodle_url,created_at,updated_at,updated_by,created_by,is_deleted) VALUES
	 ('ffd44f60-aaa2-4142-ae73-7727b3051ddb',NULL,'Code Dynamite','codedynamite@gmail.com','12345678',NULL,NULL,NULL,'2024-04-15 18:37:44.08878+07','2024-04-15 18:37:44.08878+07','9ba179ed-d26d-4828-a0f6-8836c2063992','9ba179ed-d26d-4828-a0f6-8836c2063992',false),
	 ('08b65a39-394f-4977-a5fa-3fe145b620f8',NULL,'moodle2','moodle234@gmail.com','12345678',NULL,NULL,NULL,'2024-04-15 18:09:29.488151+07','2024-04-15 18:09:29.488151+07','9ba179ed-d26d-4828-a0f6-8836c2063992','9ba179ed-d26d-4828-a0f6-8836c2063992',false),
	 ('3ead3b08-afdd-442f-b544-fdbd86eaa186',NULL,'Code Dynamite','codedynamite@gmail.com','12345678',NULL,NULL,NULL,'2024-04-15 18:09:40.033204+07','2024-04-15 18:09:40.033204+07','9ba179ed-d26d-4828-a0f6-8836c2063992','9ba179ed-d26d-4828-a0f6-8836c2063992',false);

INSERT INTO public.main_user (id,organization_id,is_linked_with_google,is_linked_with_microsoft,email,username,dob,first_name,last_name,phone,address,avatar_url,refresh_token,last_login,created_at,updated_at,is_deleted) VALUES
	 ('9ba179ed-d26d-4828-a0f6-8836c2063992','08b65a39-394f-4977-a5fa-3fe145b620f8',false,false,'nguyenquoctuan385@gmail.com','nguyenquoctuan385@gmail.com',NULL,'Tuan','Nguyen','012345678','HCM',NULL,NULL,'2024-04-12 21:33:23.371836+07','2024-04-12 21:33:23.371836+07','2024-04-12 21:33:23.371836+07',false),
	 ('b029f559-52a8-4699-b595-71161498ed8c',null,false,false,'dcthong852@gmail.com','dcthong852@gmail.com',NULL,'Thong','Duong','12365478',NULL,NULL,NULL,'2024-04-15 18:07:20.891115+07','2024-04-15 18:07:20.891115+07','2024-04-15 18:07:20.891115+07',false),
	 ('8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7','08b65a39-394f-4977-a5fa-3fe145b620f8',false,false,'tgtien852@gmail.com','tgtien852@gmail.com',NULL,'Tien','Truong','12365478',NULL,NULL,NULL,'2024-04-15 18:07:41.151759+07','2024-04-15 18:07:41.151759+07','2024-04-15 18:07:41.151759+07',false);

INSERT INTO public."role"
(id, description, name)
VALUES('ffd44f60-aaa2-4142-ae73-7727b3051ddb', NULL, 'admin'),
('9ba179ed-d26d-4828-a0f6-8836c2063992', NULL, 'user'),
('08b65a39-394f-4977-a5fa-3fe145b620f8', NULL, 'student_moodle'),
('f705404f-5971-455e-9c34-93a0ce5b90b5', NULL, 'teacher_moodle'),
('3ead3b08-afdd-442f-b544-fdbd86eaa186', NULL, 'admin_moodle');

INSERT INTO public.user_role (id,user_id,role_id) VALUES
	 ('5991f22b-f530-4913-88f2-90319ee93a76','9ba179ed-d26d-4828-a0f6-8836c2063992','ffd44f60-aaa2-4142-ae73-7727b3051ddb'),
	 ('b029f559-52a8-4699-b595-71161498ed8c','b029f559-52a8-4699-b595-71161498ed8c','9ba179ed-d26d-4828-a0f6-8836c2063992'),
     ('8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7','8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7','9ba179ed-d26d-4828-a0f6-8836c2063992');
