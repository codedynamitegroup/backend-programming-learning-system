INSERT INTO public.user(id,email,dob,first_name,last_name,phone,address,avatar_url,created_at,updated_at,is_deleted, user_id_moodle)
VALUES
   ('9ba179ed-d26d-4828-a0f6-8836c2063992','nguyenquoctuan3185@gmail.com',NULL,'Tuan','Nguyen','012345678','HCM',NULL,'2024-04-12 21:33:23.371836+07','2024-04-12 21:33:23.371836+07',true, 3),
   ('b029f559-52a8-4699-b595-71161498ed8c','dcthong852@gmail.com',NULL,'Thong','Duong','12365478',NULL,NULL,'2024-04-15 18:07:20.891115+07','2024-04-15 18:07:20.891115+07',false, 2),
   ('8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7','tgtien852@gmail.com',NULL,'Tien','Truong','12365478',NULL,NULL,'2024-04-15 18:07:41.151759+07','2024-04-15 18:07:41.151759+07',false, 1);

INSERT INTO public.organization(id, description, name, created_at, updated_at, is_deleted, moodle_url)
VALUES
	 ('9ba179ed-d26d-4828-a0f6-8836c2063992',NULL,'Code Dynamite','2024-04-15 18:37:44.08878+07','2024-04-15 18:37:44.08878+07',false, 'localhost'),
	 ('08b65a39-394f-4977-a5fa-3fe145b620f8',NULL,'moodle2','2024-04-15 18:09:29.488151+07','2024-04-15 18:09:29.488151+07',false, 'tempUrl1'),
	 ('3ead3b08-afdd-442f-b544-fdbd86eaa186',NULL,'Code Dynamite','2024-04-15 18:09:40.033204+07','2024-04-15 18:09:40.033204+07',false, 'tempUrl2');

INSERT INTO public.question(id, org_id, difficulty, name, question_text, general_feedback, default_mark, qtype, created_by, updated_by)
VALUES
   ('b6484e21-6937-489c-b031-b71767994221', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'HARD', 'Question Pants', 'Question Mouse Text', 'Question Tuna feedback', 1, 'CODE', 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c'),
   ('b6484e21-6937-489c-b031-b71767994233', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'EASY', 'Question Handle', 'Question Wire Text', 'Question Gold feedback', 1, 'ESSAY', 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c'),
   ('b6484e21-6937-489c-b031-b71767994132', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'MEDIUM', 'Question hihi', 'Question Wow Text', 'Question Amazing feedback', 1, 'SHORT_ANSWER', 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c'),
   ('b6484e21-6937-489c-b031-b71767994735', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'HARD', 'Question haha', 'Question Speaker Text', 'Question Good Job feedback', 1, 'MULTIPLE_CHOICE', 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c');

INSERT INTO public.course(id, name, course_type_id, created_by, updated_by, created_at, updated_at)
VALUES
    ('b6484e21-6937-489c-b031-b71767994736', 'CSC001 - Nhập môn lập trình', null, 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-04-15 18:07:41.151759+07', '2024-04-15 18:07:41.151759+07'),
    ('b6484e21-6937-489c-b031-b71767994737', 'CSC002 - Lập trình hướng đối tượng', null, 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-04-15 18:07:41.151759+07', '2024-04-15 18:07:41.151759+07'),
    ('b6484e21-6937-489c-b031-b71767994738', 'CSC003 - Lập trình web', null, 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-04-15 18:07:41.151759+07', '2024-04-15 18:07:41.151759+07');

INSERT INTO public.exam(id, course_id, name, intro, time_open, time_close, time_limit)
VALUES
    ('b6484e21-6937-489c-b031-b71767994739', 'b6484e21-6937-489c-b031-b71767994736', 'Kiểm tra giữa kỳ', 'Intro 1', '2024-04-15 18:07:41.151759+07', '2024-04-16 18:07:41.151759+07', 3600),
    ('b6484e21-6937-489c-b031-b71767994740', 'b6484e21-6937-489c-b031-b71767994737', 'Kiểm tra cuối kỳ', 'Intro 2', '2024-04-15 18:07:41.151759+07', '2024-04-16 18:07:41.151759+07', 3600),
    ('b6484e21-6937-489c-b031-b71767994741', 'b6484e21-6937-489c-b031-b71767994738', 'Kiểm tra đầu buổi 1', 'Intro 3', '2024-04-15 18:07:41.151759+07', '2024-04-16 18:07:41.151759+07', 3600);

INSERT INTO public.exam_question(id, exam_id, question_id)
VALUES
    ('b6484e21-6937-489c-b031-b71767994742', 'b6484e21-6937-489c-b031-b71767994739', 'b6484e21-6937-489c-b031-b71767994221'),
    ('b6484e21-6937-489c-b031-b71767994743', 'b6484e21-6937-489c-b031-b71767994740', 'b6484e21-6937-489c-b031-b71767994233'),
    ('b6484e21-6937-489c-b031-b71767994744', 'b6484e21-6937-489c-b031-b71767994741', 'b6484e21-6937-489c-b031-b71767994132');

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
    ('b6484e21-6937-489c-b031-b71767994744', 'b6484e21-6937-489c-b031-b71767991741', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('b6484e21-6937-489c-b031-b71767994745', 'b6484e21-6937-489c-b031-b71767992742', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('b6484e21-6937-489c-b031-b71767994746', 'b6484e21-6937-489c-b031-b71767993743', '9ba179ed-d26d-4828-a0f6-8836c2063992');

INSERT INTO public.course_type(id, moodle_id, name)
VALUES
    ('b6484e21-6937-489c-b031-b71767994747', '1', 'CLC'),
    ('b6484e21-6937-489c-b031-b71767994748', '2', 'VP'),
    ('b6484e21-6937-489c-b031-b71767994749', '3', 'APCS');

INSERT INTO public.role_moodle(id,name)
VALUES
    (1,'manager'),
    (2,'coursecreator'),
    (3,'editingteacher'),
    (4,'teacher'),
    (5,'student'),
    (6,'guest');

INSERT INTO public.org_role(id, org_id, role_moodle_id)
VALUES
    ('b6484e21-6937-489c-b031-b71767994750', '9ba179ed-d26d-4828-a0f6-8836c2063992', 1),
    ('b6484e21-6937-489c-b031-b71767994751', '9ba179ed-d26d-4828-a0f6-8836c2063992', 2),
    ('b6484e21-6937-489c-b031-b71767994752', '9ba179ed-d26d-4828-a0f6-8836c2063992', 3),
    ('b6484e21-6937-489c-b031-b71767994753', '9ba179ed-d26d-4828-a0f6-8836c2063992', 4),
    ('b6484e21-6937-489c-b031-b71767994754', '9ba179ed-d26d-4828-a0f6-8836c2063992', 5),
    ('b6484e21-6937-489c-b031-b71767994755', '9ba179ed-d26d-4828-a0f6-8836c2063992', 6);
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