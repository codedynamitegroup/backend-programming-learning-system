INSERT INTO public.user(id,email,dob,first_name,last_name,phone,address,avatar_url,created_at,updated_at,is_deleted)
VALUES
   ('9ba179ed-d26d-4828-a0f6-8836c2063992','nguyenquoctuan385@gmail.com',NULL,'Tuan','Nguyen','012345678','HCM',NULL,'2024-04-12 21:33:23.371836+07','2024-04-12 21:33:23.371836+07',true),
   ('b029f559-52a8-4699-b595-71161498ed8c','dcthong852@gmail.com',NULL,'Thong','Duong','12365478',NULL,NULL,'2024-04-15 18:07:20.891115+07','2024-04-15 18:07:20.891115+07',false),
   ('8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7','tgtien852@gmail.com',NULL,'Tien','Truong','12365478',NULL,NULL,'2024-04-15 18:07:41.151759+07','2024-04-15 18:07:41.151759+07',false);

INSERT INTO public.organization(id, description, name, created_at, updated_at, is_deleted)
VALUES
	 ('9ba179ed-d26d-4828-a0f6-8836c2063992',NULL,'Code Dynamite','2024-04-15 18:37:44.08878+07','2024-04-15 18:37:44.08878+07',false),
	 ('08b65a39-394f-4977-a5fa-3fe145b620f8',NULL,'moodle2','2024-04-15 18:09:29.488151+07','2024-04-15 18:09:29.488151+07',false),
	 ('3ead3b08-afdd-442f-b544-fdbd86eaa186',NULL,'Code Dynamite','2024-04-15 18:09:40.033204+07','2024-04-15 18:09:40.033204+07',false);

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