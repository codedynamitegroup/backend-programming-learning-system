INSERT INTO public.main_organization (id,description,name,email,phone,address,api_key,moodle_url,created_at,updated_at,updated_by,created_by,is_deleted) VALUES
	 ('ffd44f60-aaa2-4142-ae73-7727b3051ddb',NULL,'Code Dynamite','codedynamite@gmail.com','12345678',NULL,NULL,NULL,'2024-04-15 18:37:44.08878+07','2024-04-15 18:37:44.08878+07','9ba179ed-d26d-4828-a0f6-8836c2063992','9ba179ed-d26d-4828-a0f6-8836c2063992',false),
	 ('08b65a39-394f-4977-a5fa-3fe145b620f8',NULL,'moodle2','moodle234@gmail.com','12345678',NULL,NULL,NULL,'2024-04-15 18:09:29.488151+07','2024-04-15 18:09:29.488151+07','9ba179ed-d26d-4828-a0f6-8836c2063992','9ba179ed-d26d-4828-a0f6-8836c2063992',false),
	 ('3ead3b08-afdd-442f-b544-fdbd86eaa186',NULL,'Code Dynamite','codedynamite@gmail.com','12345678',NULL,NULL,NULL,'2024-04-15 18:09:40.033204+07','2024-04-15 18:09:40.033204+07','9ba179ed-d26d-4828-a0f6-8836c2063992','9ba179ed-d26d-4828-a0f6-8836c2063992',false);

INSERT INTO public.main_user (id,email,password,dob,first_name,last_name,phone,address,avatar_url,refresh_token,last_ip,last_login,created_at,updated_at,is_deleted) VALUES
	 ('9ba179ed-d26d-4828-a0f6-8836c2063992','nguyenquoctuan385@gmail.com','123456',NULL,'Tuan','Nguyen','012345678','HCM',NULL,NULL,NULL,'2024-04-12 21:33:23.371836+07','2024-04-12 21:33:23.371836+07','2024-04-12 21:33:23.371836+07',true),
	 ('b029f559-52a8-4699-b595-71161498ed8c','dcthong852@gmail.com','123456',NULL,'Thong','Duong','12365478',NULL,NULL,NULL,NULL,'2024-04-15 18:07:20.891115+07','2024-04-15 18:07:20.891115+07','2024-04-15 18:07:20.891115+07',false),
	 ('8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7','tgtien852@gmail.com','123456',NULL,'Tien','Truong','12365478',NULL,NULL,NULL,NULL,'2024-04-15 18:07:41.151759+07','2024-04-15 18:07:41.151759+07','2024-04-15 18:07:41.151759+07',false);

INSERT INTO public."role"
(id, organization_id, description, "name", created_at, updated_at, updated_by, created_by)
VALUES('f705404f-5971-455e-9c34-93a0ce5b90b3'::uuid, '3ead3b08-afdd-442f-b544-fdbd86eaa186'::uuid, NULL, 'admin', '2024-04-15 18:39:05.040', '2024-04-15 18:39:05.040', '9ba179ed-d26d-4828-a0f6-8836c2063992'::uuid, '9ba179ed-d26d-4828-a0f6-8836c2063992'::uuid);
INSERT INTO public."role"
(id, organization_id, description, "name", created_at, updated_at, updated_by, created_by)
VALUES('f705404f-5971-455e-9c34-93a0ce5b90b4'::uuid, '3ead3b08-afdd-442f-b544-fdbd86eaa186'::uuid, NULL, 'student', '2024-04-15 18:39:05.040', '2024-04-15 18:39:05.040', '9ba179ed-d26d-4828-a0f6-8836c2063992'::uuid, '9ba179ed-d26d-4828-a0f6-8836c2063992'::uuid);
INSERT INTO public."role"
(id, organization_id, description, "name", created_at, updated_at, updated_by, created_by)
VALUES('f705404f-5971-455e-9c34-93a0ce5b90b5'::uuid, '3ead3b08-afdd-442f-b544-fdbd86eaa186'::uuid, NULL, 'manager', '2024-04-15 18:39:05.040', '2024-04-15 18:39:05.040', '9ba179ed-d26d-4828-a0f6-8836c2063992'::uuid, '9ba179ed-d26d-4828-a0f6-8836c2063992'::uuid);
INSERT INTO public."role"
(id, organization_id, description, "name", created_at, updated_at, updated_by, created_by)
VALUES('f705404f-5971-455e-9c34-93a0ce5b90b6'::uuid, '3ead3b08-afdd-442f-b544-fdbd86eaa186'::uuid, NULL, 'editingteacher', '2024-04-15 18:39:05.040', '2024-04-15 18:39:05.040', '9ba179ed-d26d-4828-a0f6-8836c2063992'::uuid, '9ba179ed-d26d-4828-a0f6-8836c2063992'::uuid);

INSERT INTO public.user_role (id,user_id,role_id,is_active,name,created_at,updated_at,updated_by,created_by) VALUES
	 ('5991f22b-f530-4913-88f2-90319ee93a76','9ba179ed-d26d-4828-a0f6-8836c2063992','f705404f-5971-455e-9c34-93a0ce5b90b3',true,'admin','2024-04-15 18:43:25.024225+07','2024-04-15 18:43:25.024225+07','9ba179ed-d26d-4828-a0f6-8836c2063992','9ba179ed-d26d-4828-a0f6-8836c2063992');
