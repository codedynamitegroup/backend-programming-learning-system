INSERT INTO public.user (id,email,dob,first_name,last_name,phone,address,avatar_url,created_at,updated_at,is_deleted)
VALUES
('9ba179ed-d26d-4828-a0f6-8836c2063992','nguyenquoctuan385@gmail.com',NULL,'Tuan','Nguyen','012345678','HCM',NULL,'2024-04-12 21:33:23.371836+07','2024-04-12 21:33:23.371836+07',true),
('b029f559-52a8-4699-b595-71161498ed8c','dcthong852@gmail.com',NULL,'Thong','Duong','12365478',NULL,NULL,'2024-04-15 18:07:20.891115+07','2024-04-15 18:07:20.891115+07',false),
('8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7','tgtien852@gmail.com',NULL,'Tien','Truong','12365478',NULL,NULL,'2024-04-15 18:07:41.151759+07','2024-04-15 18:07:41.151759+07',false);

INSERT INTO public.questions(id, org_id, difficulty, name, question_text, general_feedback, default_mark, qtype, created_by, updated_by)
VALUES
    ('b6484e21-6937-489c-b031-b71767994221', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'HARD', 'Question Pants', 'Question Mouse Text', 'Question Tuna feedback', 1, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('b6484e21-6937-489c-b031-b71767994201', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'HARD', 'Question Pants', 'Question Mouse Text', 'Question Tuna feedback', 1, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('b6484e21-6937-489c-b031-b71767994233', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'EASY', 'Question Handle', 'Question Wire Text', 'Question Gold feedback', 1, 'ESSAY', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('b6484e21-6937-489c-b031-b71767994132', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'MEDIUM', 'Question hihi', 'Question Wow Text', 'Question Amazing feedback', 1, 'SHORT_ANSWER', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('b6484e21-6937-489c-b031-b71767994735', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'HARD', 'Question haha', 'Question Speaker Text', 'Question Good Job feedback', 1, 'MULTIPLE_CHOICE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992');

INSERT INTO public.qtype_code_questions(id,question_id ,dsl_template , name ,problem_statement ,input_format ,output_format ,copy_state ,failure_messages ,constraints)
VALUES
    ('3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', 'b6484e21-6937-489c-b031-b71767994221', 'template', 'code question name', 'code question statement', 'input format', 'output format', 'CREATED', '', 'None');

INSERT INTO test_cases(id, code_question_id  ,input_data  ,output_data  ,is_sample )
VALUES
    ('9b103259-1a04-4ae4-aaac-dbd8f2d37ec6', '3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', E'1\n2', '3', true);

INSERT INTO programming_language(id ,name , compiler_api_id ,time_limit,memory_limit,is_actived, copy_state)
VALUES
    ('c95d5c7d-cadf-42cc-afdc-968211ae3720', 'Java (OpenJDK 13.0.1)', 62, 2, 204800, true, 'CREATED');

INSERT INTO programming_language_code_question(programming_language_id,code_question_id,time_limit,memory_limit,active)
VALUES
    ('c95d5c7d-cadf-42cc-afdc-968211ae3720','3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', 1, 204800, true);
