INSERT INTO public.user (id,email,dob,first_name,last_name,phone,address,avatar_url,created_at,updated_at,is_deleted)
VALUES
('9ba179ed-d26d-4828-a0f6-8836c2063992','nguyenquoctuan385@gmail.com',NULL,'Tuan','Nguyen','012345678','HCM',NULL,'2024-04-12 21:33:23.371836+07','2024-04-12 21:33:23.371836+07',true),
('b029f559-52a8-4699-b595-71161498ed8c','dcthong852@gmail.com',NULL,'Thong','Duong','12365478',NULL,NULL,'2024-04-15 18:07:20.891115+07','2024-04-15 18:07:20.891115+07',false),
('8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7','tgtien852@gmail.com',NULL,'Tien','Truong','12365478',NULL,NULL,'2024-04-15 18:07:41.151759+07','2024-04-15 18:07:41.151759+07',false);

-- INSERT INTO public.questions(id, org_id, difficulty, name, question_text, general_feedback, default_mark, qtype, created_by, updated_by)
-- VALUES
--     ('b6484e21-6937-489c-b031-b71767994221', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'HARD', 'Question Pants', 'Question Mouse Text', 'Question Tuna feedback', 1, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
--     ('b6484e21-6937-489c-b031-b71767994201', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'HARD', 'Question Pants', 'Question Mouse Text', 'Question Tuna feedback', 1, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
--     ('b6484e21-6937-489c-b031-b71767994233', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'EASY', 'Question Handle', 'Question Wire Text', 'Question Gold feedback', 1, 'ESSAY', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
--     ('b6484e21-6937-489c-b031-b71767994132', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'MEDIUM', 'Question hihi', 'Question Wow Text', 'Question Amazing feedback', 1, 'SHORT_ANSWER', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
--     ('b6484e21-6937-489c-b031-b71767994735', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'HARD', 'Question haha', 'Question Speaker Text', 'Question Good Job feedback', 1, 'MULTIPLE_CHOICE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992');

INSERT INTO public.qtype_code_questions(id,question_id ,dsl_template , name ,problem_statement ,input_format ,output_format ,copy_state ,failure_messages ,constraints, max_grade)
VALUES
    ('3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', 'b6484e21-6937-489c-b031-b71767994221', 'template', 'code question name', 'code question statement', 'input format', 'output format', 'CREATED', '', 'None', 10);

INSERT INTO test_cases(id, code_question_id  ,input_data  ,output_data  ,is_sample )
VALUES
    ('9b103259-1a04-4ae4-aaac-dbd8f2d37ec6', '3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', E'1\n2', '3', true);

INSERT INTO programming_language(id ,name , compiler_api_id ,time_limit,memory_limit,is_actived, copy_state)
VALUES
    ('c95d5c7d-cadf-42cc-afdc-968211ae3720', 'Java (OpenJDK 13.0.1)', 62, 2, 204800, true, 'CREATED');

INSERT INTO programming_language_code_question(programming_language_id,code_question_id,time_limit,memory_limit,active)
VALUES
    ('c95d5c7d-cadf-42cc-afdc-968211ae3720','3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', 1, 204800, true);

INSERT INTO tag(id, name)
VALUES
    ('4d5d31cc-6386-4ef5-903d-625e64b122d7','Java'),
    ('cd55e806-5d20-4813-b2ce-f8a235fc9151','Math');

insert into shared_solution (id, code_question_id, user_id, title, content) values ('675b7db4-228a-4b75-8eac-aa4336241b63', '3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', 'b029f559-52a8-4699-b595-71161498ed8c', 'Devil Commands, The', 'transition revolutionary platforms');
insert into shared_solution (id, code_question_id, user_id, title, content) values ('bbbad0c0-a0a2-43c9-b3d5-c05ca848bb48', '3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'The Divine Woman', 'unleash global supply-chains');
insert into shared_solution (id, code_question_id, user_id, title, content) values ('7679484a-2070-41d8-8aca-f242144c124c', '3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', 'b029f559-52a8-4699-b595-71161498ed8c', 'Dimples', 'aggregate 24/365 action-items');
insert into shared_solution (id, code_question_id, user_id, title, content) values ('9b393ec2-6eef-4a63-8f29-ee358161be49', '3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', 'Fatal Hour, The', 'mesh impactful solutions');
insert into shared_solution (id, code_question_id, user_id, title, content) values ('e56c0333-f1ec-4ed2-8b29-ed90d26823cd', '3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'Three Stooges Meet Hercules, The', 'innovate interactive content');

insert into shared_solution_tag (shared_solution_id, tag_id) values ('675b7db4-228a-4b75-8eac-aa4336241b63', '4d5d31cc-6386-4ef5-903d-625e64b122d7');
insert into shared_solution_tag (shared_solution_id, tag_id) values ('675b7db4-228a-4b75-8eac-aa4336241b63', 'cd55e806-5d20-4813-b2ce-f8a235fc9151');
insert into shared_solution_tag (shared_solution_id, tag_id) values ('bbbad0c0-a0a2-43c9-b3d5-c05ca848bb48', 'cd55e806-5d20-4813-b2ce-f8a235fc9151');
insert into shared_solution_tag (shared_solution_id, tag_id) values ('7679484a-2070-41d8-8aca-f242144c124c', '4d5d31cc-6386-4ef5-903d-625e64b122d7');


insert into code_submission (id, code_question_id, user_id, language_id, source_code, number_of_test_case_sent, grading_status, copy_state, avg_runtime, avg_memory) values ('51e9fece-d9c8-4ec0-8910-11b9bff89fdf', '3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', 'b029f559-52a8-4699-b595-71161498ed8c', 'c95d5c7d-cadf-42cc-afdc-968211ae3720', 'aW1wb3J0IGphdmEuaW8uKjsNCg0KY2xhc3MgUmVzdWx0IHsNCiAgICBwdWJsaWMgc3RhdGljIGludCBzdW1PZlR3b0ludGVnZXJzKGludCBhLCBpbnQgYikgew0KICAgICAgICByZXR1cm4gYSArIGI7DQogICAgfQ0KfQ0KDQpwdWJsaWMgY2xhc3MgTWFpbiB7DQogICAgcHVibGljIHN0YXRpYyB2b2lkIG1haW4oU3RyaW5nW10gYXJncykgdGhyb3dzIElPRXhjZXB0aW9uIHsNCiAgICAgICAgQnVmZmVyZWRSZWFkZXIgYnVmZmVyZWRSZWFkZXIgPSBuZXcgQnVmZmVyZWRSZWFkZXIobmV3IElucHV0U3RyZWFtUmVhZGVyKFN5c3RlbS5pbikpOw0KDQogICAgICAgIGludCBhID0gSW50ZWdlci5wYXJzZUludChidWZmZXJlZFJlYWRlci5yZWFkTGluZSgpLnRyaW0oKSk7DQoNCiAgICAgICAgaW50IGIgPSBJbnRlZ2VyLnBhcnNlSW50KGJ1ZmZlcmVkUmVhZGVyLnJlYWRMaW5lKCkudHJpbSgpKTsNCg0KICAgICAgICBpbnQgcmVzdWx0ID0gUmVzdWx0LnN1bU9mVHdvSW50ZWdlcnMoYSwgYik7DQoNCiAgICAgICAgICAgIFN5c3RlbS5vdXQucHJpbnQocmVzdWx0KTsNCiAgICAgICAgICAgIGJ1ZmZlcmVkUmVhZGVyLmNsb3NlKCk7DQogICAgICAgIA0KDQogICAgfQ0KfQ==', 0, 'GRADED', 'CREATED', 0.91, 3327);
insert into code_submission (id, code_question_id, user_id, language_id, source_code, number_of_test_case_sent, grading_status, copy_state, avg_runtime, avg_memory) values ('750b13af-f23f-4586-a890-35a9cc0469f8', '3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', 'c95d5c7d-cadf-42cc-afdc-968211ae3720', 'aW1wb3J0IGphdmEuaW8uKjsNCg0KY2xhc3MgUmVzdWx0IHsNCiAgICBwdWJsaWMgc3RhdGljIGludCBzdW1PZlR3b0ludGVnZXJzKGludCBhLCBpbnQgYikgew0KICAgICAgICByZXR1cm4gYSArIGI7DQogICAgfQ0KfQ0KDQpwdWJsaWMgY2xhc3MgTWFpbiB7DQogICAgcHVibGljIHN0YXRpYyB2b2lkIG1haW4oU3RyaW5nW10gYXJncykgdGhyb3dzIElPRXhjZXB0aW9uIHsNCiAgICAgICAgQnVmZmVyZWRSZWFkZXIgYnVmZmVyZWRSZWFkZXIgPSBuZXcgQnVmZmVyZWRSZWFkZXIobmV3IElucHV0U3RyZWFtUmVhZGVyKFN5c3RlbS5pbikpOw0KDQogICAgICAgIGludCBhID0gSW50ZWdlci5wYXJzZUludChidWZmZXJlZFJlYWRlci5yZWFkTGluZSgpLnRyaW0oKSk7DQoNCiAgICAgICAgaW50IGIgPSBJbnRlZ2VyLnBhcnNlSW50KGJ1ZmZlcmVkUmVhZGVyLnJlYWRMaW5lKCkudHJpbSgpKTsNCg0KICAgICAgICBpbnQgcmVzdWx0ID0gUmVzdWx0LnN1bU9mVHdvSW50ZWdlcnMoYSwgYik7DQoNCiAgICAgICAgICAgIFN5c3RlbS5vdXQucHJpbnQocmVzdWx0KTsNCiAgICAgICAgICAgIGJ1ZmZlcmVkUmVhZGVyLmNsb3NlKCk7DQogICAgICAgIA0KDQogICAgfQ0KfQ==', 0, 'GRADING', 'CREATED', null, null);
insert into code_submission (id, code_question_id, user_id, language_id, source_code, number_of_test_case_sent, grading_status, copy_state, avg_runtime, avg_memory) values ('09b198db-4a26-47a9-ad9e-ce471c85070d', '3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'c95d5c7d-cadf-42cc-afdc-968211ae3720', 'aW1wb3J0IGphdmEuaW8uKjsNCg0KY2xhc3MgUmVzdWx0IHsNCiAgICBwdWJsaWMgc3RhdGljIGludCBzdW1PZlR3b0ludGVnZXJzKGludCBhLCBpbnQgYikgew0KICAgICAgICByZXR1cm4gYSArIGI7DQogICAgfQ0KfQ0KDQpwdWJsaWMgY2xhc3MgTWFpbiB7DQogICAgcHVibGljIHN0YXRpYyB2b2lkIG1haW4oU3RyaW5nW10gYXJncykgdGhyb3dzIElPRXhjZXB0aW9uIHsNCiAgICAgICAgQnVmZmVyZWRSZWFkZXIgYnVmZmVyZWRSZWFkZXIgPSBuZXcgQnVmZmVyZWRSZWFkZXIobmV3IElucHV0U3RyZWFtUmVhZGVyKFN5c3RlbS5pbikpOw0KDQogICAgICAgIGludCBhID0gSW50ZWdlci5wYXJzZUludChidWZmZXJlZFJlYWRlci5yZWFkTGluZSgpLnRyaW0oKSk7DQoNCiAgICAgICAgaW50IGIgPSBJbnRlZ2VyLnBhcnNlSW50KGJ1ZmZlcmVkUmVhZGVyLnJlYWRMaW5lKCkudHJpbSgpKTsNCg0KICAgICAgICBpbnQgcmVzdWx0ID0gUmVzdWx0LnN1bU9mVHdvSW50ZWdlcnMoYSwgYik7DQoNCiAgICAgICAgICAgIFN5c3RlbS5vdXQucHJpbnQocmVzdWx0KTsNCiAgICAgICAgICAgIGJ1ZmZlcmVkUmVhZGVyLmNsb3NlKCk7DQogICAgICAgIA0KDQogICAgfQ0KfQ==', 0, 'GRADED', 'CREATED', 0.05, 6471);
