INSERT INTO public.user (id,email,dob,first_name,last_name,phone,address,avatar_url,created_at,updated_at,is_deleted) VALUES
	 ('9ba179ed-d26d-4828-a0f6-8836c2063992','nguyenquoctuan385@gmail.com','2002-05-29','Tuan','Nguyen Quoc','+8412365478',NULL,NULL,'2024-04-12 21:33:23.371836+07','2024-04-12 21:33:23.371836+07',false),
	 ('b029f559-52a8-4699-b595-71161498ed8c','dcthong852@gmail.com','2002-04-29','Thong','Duong','+8412365478',NULL,NULL,'2024-04-15 18:07:20.891115+07','2024-04-15 18:07:20.891115+07',false),
	 ('8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7','nthoang852@gmail.com','2002-03-29','Hoang','Nguyen Thanh','+8412365478',NULL,NULL,'2024-04-15 18:07:41.151759+07','2024-04-15 18:07:41.151759+07',false),
	 ('39328bcf-8af6-44fc-9ae9-247f953ee2a2','ndqkhanh852@gmail.com','2002-03-29','Khanh','Nguyen Dinh','+8412365478',NULL,NULL,'2024-04-15 18:07:41.151759+07','2024-04-15 18:07:41.151759+07',false),
	 ('8edbc0aa-0b91-480e-a428-23abf2109df9','tgtien852@gmail.com','2002-03-29','Tien','Truong Gia','+8412365478',NULL,NULL,'2024-04-15 18:07:41.151759+07','2024-04-15 18:07:41.151759+07',false),
	 ('05dbdfde-1eae-47ba-8ebb-6c4cdc4f6510','dntien852@gmail.com','2002-03-29','Tien','Dang Ngoc','+8412365478',NULL,NULL,'2024-04-15 18:07:41.151759+07','2024-04-15 18:07:41.151759+07',false);

-- INSERT INTO public.questions(id, org_id, difficulty, name, question_text, general_feedback, default_mark, qtype, created_by, updated_by)
-- VALUES
--     ('b6484e21-6937-489c-b031-b71767994221', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'HARD', 'Question Pants', 'Question Mouse Text', 'Question Tuna feedback', 1, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
--     ('b6484e21-6937-489c-b031-b71767994201', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'HARD', 'Question Pants', 'Question Mouse Text', 'Question Tuna feedback', 1, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
--     ('b6484e21-6937-489c-b031-b71767994233', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'EASY', 'Question Handle', 'Question Wire Text', 'Question Gold feedback', 1, 'ESSAY', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
--     ('b6484e21-6937-489c-b031-b71767994132', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'MEDIUM', 'Question hihi', 'Question Wow Text', 'Question Amazing feedback', 1, 'SHORT_ANSWER', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
--     ('b6484e21-6937-489c-b031-b71767994735', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'HARD', 'Question haha', 'Question Speaker Text', 'Question Good Job feedback', 1, 'MULTIPLE_CHOICE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992');

insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('e268cd70-cf0d-46ce-8f69-ade9d3a955a2', 'Assembly (NASM 2.14.02)', 45, 2, 204800, true, 'CREATED');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('ec1a6b7b-7817-4241-bc8f-febce8d2770e', 'Bash (5.0.0)', 46, 2, 204800, true, 'CREATED');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('d6f8e702-0ab0-40cb-82b9-a7963bd1cf80', 'Basic (FBC 1.07.1)', 47, 2, 204800, true, 'CREATED');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('6b2f42e1-81e6-493b-9cc1-2436febc320e', 'C (Clang 7.0.1)', 75, 2, 204800, true, 'CREATED');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('8794526e-f528-4ffc-b98d-320812e79c6f', 'C++ (Clang 7.0.1)', 76, 2, 204800, true, 'CREATED');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('50e74d89-5742-4c21-b9e5-96a4766283fa', 'C (GCC 7.4.0)', 48, 2, 204800, true, 'CREATED');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('e6a880d8-f0b2-4c2d-b97d-a74d5bec87b3', 'C++ (GCC 7.4.0)', 52, 2, 204800, true, 'CREATED');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('fb38c7b8-d50a-4980-95de-6a50a49ecc5d', 'C (GCC 8.3.0)', 49, 2, 204800, true, 'CREATED');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('aed9a00b-6a4b-4534-b85e-4981097d61de', 'C++ (GCC 8.3.0)', 53, 2, 204800, true, 'CREATED');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('5f11cfd5-4358-4e8e-b28a-9c53beb014ad', 'C (GCC 9.2.0)', 50, 2, 204800, true, 'CREATED');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state, head_code, body_code, tail_code) values ('cba00cd8-8114-4bc4-84e6-499c27467978', 'C++ (GCC 9.2.0)', 54, 2, 204800, true, 'CREATED', 'I2luY2x1ZGUgPGlvc3RyZWFtPg==', '', 'aW50IG1haW4oKQp7CgogICAgcmV0dXJuIDA7Cn0=');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('875a7edb-f310-4a15-89f0-7ca9fc8ce028', 'Clojure (1.10.1)', 86, 2, 204800, true, 'CREATED');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('70614628-fc54-4620-b9b9-81b918cae732', 'C# (Mono 6.6.0.161)', 51, 2, 204800, true, 'CREATED');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('f6dd240a-b9c5-4ab6-b977-105136f75907', 'COBOL (GnuCOBOL 2.2)', 77, 2, 204800, true, 'CREATED');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('8c37b8a9-c6de-4db1-9638-b3633e44f5a5', 'Common Lisp (SBCL 2.0.0)', 55, 2, 204800, true, 'CREATED');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('833c5b34-acc6-4e4c-8e37-3c806538924f', 'D (DMD 2.089.1)', 56, 2, 204800, true, 'CREATED');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('aa81ebed-79f2-4a9e-b45f-5406b45889b3', 'Elixir (1.9.4)', 57, 2, 204800, true, 'CREATED');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('59c636af-82c5-45f3-b2c6-5c47067f5462', 'Erlang (OTP 22.2)', 58, 2, 204800, true, 'CREATED');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('bd5d2b87-da1d-4be9-be0b-3a9dcdbf8849', 'Executable', 44, 2, 204800, true, 'CREATED');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('5ab21579-2a25-4d63-83c6-032ba4f66518', 'F# (.NET Core SDK 3.1.202)', 87, 2, 204800, true, 'CREATED');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('9cc1ba4a-f325-4767-8d3d-e2808f82cd76', 'Fortran (GFortran 9.2.0)', 59, 2, 204800, true, 'CREATED');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('e68c5866-1435-4958-bafe-ad901ee75c8d', 'Go (1.13.5)', 60, 2, 204800, true, 'CREATED');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('3fa9d570-86d1-41c0-8044-981bfe4636b4', 'Groovy (3.0.3)', 88, 2, 204800, true, 'CREATED');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('0b50bbe2-582e-4582-a51b-2b2ac4212420', 'Haskell (GHC 8.8.1)', 61, 2, 204800, true, 'CREATED');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state, head_code, body_code, tail_code) values ('c95d5c7d-cadf-42cc-afdc-968211ae3720', 'Java (OpenJDK 13.0.1)', 62, 2, 204800, true, 'CREATED', 'aW1wb3J0IGphdmEuaW8uKjs=', '', 'cHVibGljIGNsYXNzIE1haW4gewogICAgcHVibGljIHN0YXRpYyB2b2lkIG1haW4oU3RyaW5nW10gYXJncykgewoKICAgIH0KfQ==');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('cc69d904-ba4e-44fb-a0b5-8170e30bac39', 'JavaScript (Node.js 12.14.0)', 63, 2, 204800, true, 'CREATED');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('a48c0969-16bb-4d8a-a611-751b48f72454', 'Kotlin (1.3.70)', 78, 2, 204800, true, 'CREATED');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('794665fa-0c05-4f48-9255-68bf5bb84685', 'Lua (5.3.5)', 64, 2, 204800, true, 'CREATED');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('54ba8969-a91a-4863-a634-87aef2c43148', 'Multi-file program', 89, 2, 204800, true, 'CREATED');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('5effd41c-97f4-4843-b6c0-ee1790cb8502', 'Objective-C (Clang 7.0.1)', 79, 2, 204800, true, 'CREATED');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('d00b24db-44a5-49c2-99ea-d7c832199c9d', 'OCaml (4.09.0)', 65, 2, 204800, true, 'CREATED');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('df127469-95be-4de7-aebe-7852608d4066', 'Octave (5.1.0)', 66, 2, 204800, true, 'CREATED');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('87426e80-200c-4fcc-8df4-388307419247', 'Pascal (FPC 3.0.4)', 67, 2, 204800, true, 'CREATED');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('0b79d359-f4b5-4ede-aa55-7a6eb8f0a4a8', 'Perl (5.28.1)', 85, 2, 204800, true, 'CREATED');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('9c84c818-6931-4309-b669-9631d6363118', 'PHP (7.4.1)', 68, 2, 204800, true, 'CREATED');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('4183d72e-a4fe-4c76-9e61-5fb42afad43b', 'Plain Text', 43, 2, 204800, true, 'CREATED');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('dae1111e-87a6-47c5-bae1-d62e8bd4dd10', 'Prolog (GNU Prolog 1.4.5)', 69, 2, 204800, true, 'CREATED');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('5413d5e9-5513-4e86-b585-b4f9149bc692', 'Python (2.7.17)', 70, 2, 204800, true, 'CREATED');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('d27a8b36-83fd-450d-a7c3-bf3eef7b1468', 'Python (3.8.1)', 71, 2, 204800, true, 'CREATED');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('eb1526bd-6dbc-4512-81ee-60b38af78669', 'R (4.0.0)', 80, 2, 204800, true, 'CREATED');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('39b33107-a91d-47e2-af0b-cfec36dd1f6f', 'Ruby (2.7.0)', 72, 2, 204800, true, 'CREATED');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('cac1604f-a42d-4c27-92c1-45da338220e2', 'Rust (1.40.0)', 73, 2, 204800, true, 'CREATED');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('acf4fa1d-35e8-41ee-b174-8f485a35b25f', 'Scala (2.13.2)', 81, 2, 204800, true, 'CREATED');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('959eb798-748b-4d49-a0d9-7580bf679e07', 'SQL (SQLite 3.27.2)', 82, 2, 204800, true, 'CREATED');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('5122684e-b577-40ef-a25a-7cc6b9f19088', 'Swift (5.2.3)', 83, 2, 204800, true, 'CREATED');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('574bebfa-640b-4836-9920-9686123cf324', 'TypeScript (3.7.4)', 74, 2, 204800, true, 'CREATED');
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit, is_actived, copy_state) values ('c2812b53-059f-43cb-8e9b-966246a79567', 'Visual Basic.Net (vbnc 0.0.0.5943)', 84, 2, 204800, true, 'CREATED');


INSERT INTO public.qtype_code_questions(user_id, id, question_id ,dsl_template , name ,problem_statement ,input_format ,output_format ,copy_state ,failure_messages ,constraints, max_grade, difficulty) VALUES ('9ba179ed-d26d-4828-a0f6-8836c2063992', '3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', 'b6484e21-6937-489c-b031-b71767994221', 'template', 'Tổng 2 số', E'<div class="elfjS" data-track-load="description_content"><p>Given two integer number A and B.</p><p>Calculate the sum of A and B.</p><p>&nbsp;</p><p><strong class="example">Example 1:</strong></p><pre>\nInput:\n1\n1\nOutput: 2\n</pre><p><strong class="example">Example 2:</strong></p><pre>\nInput:\n13\n10\nOutput: 23 \n</pre><p>&nbsp;</p></div>', E'The first line is number A\nthe second line is number B', 'Sum of A and B', 'CREATED', '', '0 < A, B < 10000', 10, 'EASY');
INSERT INTO public.qtype_code_questions(user_id, id, question_id ,dsl_template , name ,problem_statement ,input_format ,output_format ,copy_state ,failure_messages ,constraints, max_grade, difficulty) VALUES ('9ba179ed-d26d-4828-a0f6-8836c2063992', 'f6d7b882-9399-4bc3-baad-6350285bfa78', 'b6484e21-6937-489c-b031-b71767994221', 'template', 'Island', 'code question statement', 'input format', 'output format', 'CREATED', '', 'None', 10, 'EASY');
INSERT INTO public.qtype_code_questions(user_id, id, question_id ,dsl_template , name ,problem_statement ,input_format ,output_format ,copy_state ,failure_messages ,constraints, max_grade, difficulty) VALUES ('9ba179ed-d26d-4828-a0f6-8836c2063992', '48caf2c9-8c81-49a7-b656-c3b024a798c3', 'b6484e21-6937-489c-b031-b71767994221', 'template', 'code question name 3', 'code question statement', 'input format', 'output format', 'CREATED', '', 'None', 10, 'EASY');
INSERT INTO public.qtype_code_questions(user_id, id, question_id ,dsl_template , name ,problem_statement ,input_format ,output_format ,copy_state ,failure_messages ,constraints, max_grade, difficulty) VALUES ('9ba179ed-d26d-4828-a0f6-8836c2063992', '2589a5b7-94c9-4a76-86d9-576718ca63c3', 'b6484e21-6937-489c-b031-b71767994221', 'template', 'code question name 4', 'code question statement', 'input format', 'output format', 'CREATED', '', 'None', 10, 'MEDIUM');
INSERT INTO public.qtype_code_questions(user_id, id, question_id ,dsl_template , name ,problem_statement ,input_format ,output_format ,copy_state ,failure_messages ,constraints, max_grade, difficulty) VALUES ('9ba179ed-d26d-4828-a0f6-8836c2063992', '2dbe940c-8d25-4a88-a283-d79785c1ea2a', 'b6484e21-6937-489c-b031-b71767994221', 'template', 'code question name 5', 'code question statement', 'input format', 'output format', 'CREATED', '', 'None', 10, 'MEDIUM');
INSERT INTO public.qtype_code_questions(user_id, id, question_id ,dsl_template , name ,problem_statement ,input_format ,output_format ,copy_state ,failure_messages ,constraints, max_grade, difficulty) VALUES ('9ba179ed-d26d-4828-a0f6-8836c2063992', '07bf0b32-09ce-47d0-b4e1-c0ba35799b43', 'b6484e21-6937-489c-b031-b71767994221', 'template', 'code question name 6', 'code question statement', 'input format', 'output format', 'CREATED', '', 'None', 10, 'MEDIUM');
INSERT INTO public.qtype_code_questions(user_id, id, question_id ,dsl_template , name ,problem_statement ,input_format ,output_format ,copy_state ,failure_messages ,constraints, max_grade, difficulty) VALUES ('9ba179ed-d26d-4828-a0f6-8836c2063992', '2f3b15cc-219f-47eb-8d17-702e89afb86a', 'b6484e21-6937-489c-b031-b71767994221', 'template', 'code question name 7', 'code question statement', 'input format', 'output format', 'CREATED', '', 'None', 10, 'MEDIUM');
INSERT INTO public.qtype_code_questions(user_id, id, question_id ,dsl_template , name ,problem_statement ,input_format ,output_format ,copy_state ,failure_messages ,constraints, max_grade, difficulty) VALUES ('9ba179ed-d26d-4828-a0f6-8836c2063992', 'fe0a658d-7ce9-4524-b388-84539a34a521', 'b6484e21-6937-489c-b031-b71767994221', 'template', 'code question name 8', 'code question statement', 'input format', 'output format', 'CREATED', '', 'None', 10, 'MEDIUM');
INSERT INTO public.qtype_code_questions(user_id, id, question_id ,dsl_template , name ,problem_statement ,input_format ,output_format ,copy_state ,failure_messages ,constraints, max_grade, difficulty) VALUES ('9ba179ed-d26d-4828-a0f6-8836c2063992', '1374d22a-b27b-4d3d-9ad4-b613e1f1e253', 'b6484e21-6937-489c-b031-b71767994221', 'template', 'code question name 9', 'code question statement', 'input format', 'output format', 'CREATED', '', 'None', 10, 'EASY');
INSERT INTO public.qtype_code_questions(user_id, id, question_id ,dsl_template , name ,problem_statement ,input_format ,output_format ,copy_state ,failure_messages ,constraints, max_grade, difficulty) VALUES ('9ba179ed-d26d-4828-a0f6-8836c2063992', '06d71d03-f5ba-4a89-9083-596ef649ade9', 'b6484e21-6937-489c-b031-b71767994221', 'template', 'code question name 10', 'code question statement', 'input format', 'output format', 'CREATED', '', 'None', 10, 'EASY');
INSERT INTO public.qtype_code_questions(user_id, id, question_id ,dsl_template , name ,problem_statement ,input_format ,output_format ,copy_state ,failure_messages ,constraints, max_grade, difficulty) VALUES ('9ba179ed-d26d-4828-a0f6-8836c2063992', 'b1ae32db-17e6-4fdb-991b-160e95721562', 'b6484e21-6937-489c-b031-b71767994221', 'template', 'code question name 11', 'code question statement', 'input format', 'output format', 'CREATED', '', 'None', 10, 'EASY');
INSERT INTO public.qtype_code_questions(user_id, id, question_id ,dsl_template , name ,problem_statement ,input_format ,output_format ,copy_state ,failure_messages ,constraints, max_grade, difficulty) VALUES ('9ba179ed-d26d-4828-a0f6-8836c2063992', '058cdf70-3cc5-4a99-9edd-edfa0325c207', 'b6484e21-6937-489c-b031-b71767994221', 'template', 'code question name 12', 'code question statement', 'input format', 'output format', 'CREATED', '', 'None', 10, 'HARD');
INSERT INTO public.qtype_code_questions(user_id, id, question_id ,dsl_template , name ,problem_statement ,input_format ,output_format ,copy_state ,failure_messages ,constraints, max_grade, difficulty) VALUES ('9ba179ed-d26d-4828-a0f6-8836c2063992', '51981528-01ff-491a-bc7b-a24aedfb0363', 'b6484e21-6937-489c-b031-b71767994221', 'template', 'code question name 13', 'code question statement', 'input format', 'output format', 'CREATED', '', 'None', 10, 'HARD');
INSERT INTO public.qtype_code_questions(user_id, id, question_id ,dsl_template , name ,problem_statement ,input_format ,output_format ,copy_state ,failure_messages ,constraints, max_grade, difficulty) VALUES ('9ba179ed-d26d-4828-a0f6-8836c2063992', '6181a38b-2b06-4a60-ad5f-750780d79e3e', 'b6484e21-6937-489c-b031-b71767994221', 'template', 'code question name 14', 'code question statement', 'input format', 'output format', 'CREATED', '', 'None', 10, 'HARD');
INSERT INTO public.qtype_code_questions(user_id, id, question_id ,dsl_template , name ,problem_statement ,input_format ,output_format ,copy_state ,failure_messages ,constraints, max_grade, difficulty) VALUES ('9ba179ed-d26d-4828-a0f6-8836c2063992', '22427527-053c-4602-a519-9e52cb5f2366', 'b6484e21-6937-489c-b031-b71767994221', 'template', 'code question name 15', 'code question statement', 'input format', 'output format', 'CREATED', '', 'None', 10, 'EASY');
INSERT INTO public.qtype_code_questions(user_id, id, question_id ,dsl_template , name ,problem_statement ,input_format ,output_format ,copy_state ,failure_messages ,constraints, max_grade, difficulty) VALUES ('9ba179ed-d26d-4828-a0f6-8836c2063992', 'cd39d755-41f1-452f-a0df-09c64c7a67cf', 'b6484e21-6937-489c-b031-b71767994221', 'template', 'code question name 16', 'code question statement', 'input format', 'output format', 'CREATED', '', 'None', 10, 'EASY');
INSERT INTO public.qtype_code_questions(user_id, id, question_id ,dsl_template , name ,problem_statement ,input_format ,output_format ,copy_state ,failure_messages ,constraints, max_grade, difficulty) VALUES ('9ba179ed-d26d-4828-a0f6-8836c2063992', 'd49496bb-87a5-483f-9597-564ad6ee0305', 'b6484e21-6937-489c-b031-b71767994221', 'template', 'code question name 17', 'code question statement', 'input format', 'output format', 'CREATED', '', 'None', 10, 'HARD');
INSERT INTO public.qtype_code_questions(user_id, id, question_id ,dsl_template , name ,problem_statement ,input_format ,output_format ,copy_state ,failure_messages ,constraints, max_grade, difficulty) VALUES ('9ba179ed-d26d-4828-a0f6-8836c2063992', '4be91526-365b-4e50-99ae-75ba2a87ba08', 'b6484e21-6937-489c-b031-b71767994221', 'template', 'code question name 18', 'code question statement', 'input format', 'output format', 'CREATED', '', 'None', 10, 'EASY');

INSERT INTO test_cases(id, code_question_id  ,input_data  ,output_data  ,is_sample )
VALUES
    ('9b103259-1a04-4ae4-aaac-dbd8f2d37ec6', '3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', E'1\n2', '3', true);

INSERT INTO tag(id, name, tag_type)
VALUES
    ('4d5d31cc-6386-4ef5-903d-625e64b122d7','Array', 'ALGORITHM'),
    ('cd55e806-5d20-4813-b2ce-f8a235fc9151','Math', 'ALGORITHM'),
    ('98e3f555-aa71-413d-a5bd-5dd6599ababb','Hash Table', 'ALGORITHM'),
    ('dc7551c6-9183-4909-ae0a-dcfaae838883','Two Pointer', 'ALGORITHM'),
    ('a5539d34-fda8-4eb2-8e53-a441931da88d','Sorting', 'ALGORITHM'),
    ('0445b8ba-a466-4419-b737-5a2a3ce08ddf','Binary Tree', 'ALGORITHM'),
    ('dc3bd976-e836-411d-be01-2349ef551f5b','Binary Search', 'ALGORITHM'),
    ('b930cc0d-a9fc-4a60-894b-62ef391ad51f','Greedy', 'ALGORITHM'),
    ('c11c568a-0aff-465c-a7f2-cf4a587b76cd','Counting', 'ALGORITHM'),
    ('d3379a08-30b0-4835-b4b2-468296fd3d07','Linked List', 'ALGORITHM'),
    ('f51c408d-2232-484d-833e-1c59733107a7','Dynamic Programming', 'ALGORITHM'),
    ('28762fc4-b0c4-47f8-aa7d-6ce02ccb5a47','Recursion', 'ALGORITHM'),
    ('8cbb60b7-39d0-462f-8498-b9b3ec80b5c3','Stack', 'ALGORITHM'),
    ('9d752cc0-75b3-4dce-b92e-21375e2d61c5','String', 'ALGORITHM'),
    ('d4070634-15e1-4b20-8142-ac2b0d7d3b20','Matrix', 'ALGORITHM'),
    ('4276d92b-8752-476f-b127-cf1135772249','Iterator', 'ALGORITHM'),
    ('5d49c893-5ab8-4b82-aea5-70ab95bdf89c', 'Java', 'OTHER');

insert into shared_solution (id, code_question_id, user_id, title, content) values ('675b7db4-228a-4b75-8eac-aa4336241b63', '3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', 'b029f559-52a8-4699-b595-71161498ed8c', 'Devil Commands, The', 'transition revolutionary platforms');
insert into shared_solution (id, code_question_id, user_id, title, content) values ('bbbad0c0-a0a2-43c9-b3d5-c05ca848bb48', '3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'The Divine Woman', 'unleash global supply-chains');
insert into shared_solution (id, code_question_id, user_id, title, content) values ('7679484a-2070-41d8-8aca-f242144c124c', '3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', 'b029f559-52a8-4699-b595-71161498ed8c', 'Dimples', 'aggregate 24/365 action-items');
insert into shared_solution (id, code_question_id, user_id, title, content) values ('9b393ec2-6eef-4a63-8f29-ee358161be49', '3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', 'Fatal Hour, The', 'mesh impactful solutions');
insert into shared_solution (id, code_question_id, user_id, title, content) values ('e56c0333-f1ec-4ed2-8b29-ed90d26823cd', '3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'Three Stooges Meet Hercules, The', 'innovate interactive content');

insert into shared_solution_tag (shared_solution_id, tag_id) values ('675b7db4-228a-4b75-8eac-aa4336241b63', '4d5d31cc-6386-4ef5-903d-625e64b122d7');
insert into shared_solution_tag (shared_solution_id, tag_id) values ('675b7db4-228a-4b75-8eac-aa4336241b63', 'cd55e806-5d20-4813-b2ce-f8a235fc9151');
insert into shared_solution_tag (shared_solution_id, tag_id) values ('bbbad0c0-a0a2-43c9-b3d5-c05ca848bb48', 'cd55e806-5d20-4813-b2ce-f8a235fc9151');
insert into shared_solution_tag (shared_solution_id, tag_id) values ('7679484a-2070-41d8-8aca-f242144c124c', '4d5d31cc-6386-4ef5-903d-625e64b122d7');

insert into code_submission (id, code_question_id, user_id, language_id, head_code, body_code, tail_code, number_of_test_case_sent, grading_status, copy_state, avg_runtime, avg_memory, grade, created_at) values ('a2e5afa6-f0c8-422e-8895-a706d1a1d6c1', '3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'c95d5c7d-cadf-42cc-afdc-968211ae3720', 'aW1wb3J0IGphdmEuaW8uKjs=', 'Y2xhc3MgUmVzdWx0IHsKICAgIHB1YmxpYyBzdGF0aWMgaW50IHN1bU9mVHdvSW50ZWdlcnMoaW50IGEsIGludCBiKSB7CiAgICAgICAgcmV0dXJuIGEgKyBiOwogICAgfQp9', 'cHVibGljIGNsYXNzIE1haW4gewogICAgcHVibGljIHN0YXRpYyB2b2lkIG1haW4oU3RyaW5nW10gYXJncykgdGhyb3dzIElPRXhjZXB0aW9uIHsKICAgICAgICBCdWZmZXJlZFJlYWRlciBidWZmZXJlZFJlYWRlciA9IG5ldyBCdWZmZXJlZFJlYWRlcihuZXcgSW5wdXRTdHJlYW1SZWFkZXIoU3lzdGVtLmluKSk7CgogICAgICAgIGludCBhID0gSW50ZWdlci5wYXJzZUludChidWZmZXJlZFJlYWRlci5yZWFkTGluZSgpLnRyaW0oKSk7CgogICAgICAgIGludCBiID0gSW50ZWdlci5wYXJzZUludChidWZmZXJlZFJlYWRlci5yZWFkTGluZSgpLnRyaW0oKSk7CgogICAgICAgIGludCByZXN1bHQgPSBSZXN1bHQuc3VtT2ZUd29JbnRlZ2VycyhhLCBiKTsKCiAgICAgICAgICAgIFN5c3RlbS5vdXQucHJpbnQocmVzdWx0KTsKICAgICAgICAgICAgYnVmZmVyZWRSZWFkZXIuY2xvc2UoKTsKICAgIH0KfQ==', 0, 'GRADED', 'CREATED', 0.17, 1610, 10, CURRENT_TIMESTAMP);
insert into code_submission (id, code_question_id, user_id, language_id, head_code, body_code, tail_code, number_of_test_case_sent, grading_status, copy_state, avg_runtime, avg_memory, grade, created_at) values ('4a177c20-9487-48f6-b057-6d981e66b6cf', '3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'c95d5c7d-cadf-42cc-afdc-968211ae3720', 'aW1wb3J0IGphdmEuaW8uKjs=', 'Y2xhc3MgUmVzdWx0IHsKICAgIHB1YmxpYyBzdGF0aWMgaW50IHN1bU9mVHdvSW50ZWdlcnMoaW50IGEsIGludCBiKSB7CiAgICAgICAgcmV0dXJuIGEgKyBiOwogICAgfQp9', 'cHVibGljIGNsYXNzIE1haW4gewogICAgcHVibGljIHN0YXRpYyB2b2lkIG1haW4oU3RyaW5nW10gYXJncykgdGhyb3dzIElPRXhjZXB0aW9uIHsKICAgICAgICBCdWZmZXJlZFJlYWRlciBidWZmZXJlZFJlYWRlciA9IG5ldyBCdWZmZXJlZFJlYWRlcihuZXcgSW5wdXRTdHJlYW1SZWFkZXIoU3lzdGVtLmluKSk7CgogICAgICAgIGludCBhID0gSW50ZWdlci5wYXJzZUludChidWZmZXJlZFJlYWRlci5yZWFkTGluZSgpLnRyaW0oKSk7CgogICAgICAgIGludCBiID0gSW50ZWdlci5wYXJzZUludChidWZmZXJlZFJlYWRlci5yZWFkTGluZSgpLnRyaW0oKSk7CgogICAgICAgIGludCByZXN1bHQgPSBSZXN1bHQuc3VtT2ZUd29JbnRlZ2VycyhhLCBiKTsKCiAgICAgICAgICAgIFN5c3RlbS5vdXQucHJpbnQocmVzdWx0KTsKICAgICAgICAgICAgYnVmZmVyZWRSZWFkZXIuY2xvc2UoKTsKICAgIH0KfQ==', 0, 'GRADED', 'CREATED', 0.17, 1710, 10, CURRENT_TIMESTAMP);
insert into code_submission (id, code_question_id, user_id, language_id, head_code, body_code, tail_code, number_of_test_case_sent, grading_status, copy_state, avg_runtime, avg_memory, grade, created_at) values ('df32ebfe-ec52-42c6-9447-cdc5280d5701', '3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'cba00cd8-8114-4bc4-84e6-499c27467978', 'I2luY2x1ZGUgPGlvc3RyZWFtPg==', 'aW50IHN1bU9mVHdvSW50ZWdlcnMoaW50IGEsIGludCBiKXsKICAgIHJldHVybiBhICsgYjsKfQ==', 'aW50IG1haW4oKQp7CiAgICBpbnQgYSwgYjsKICAgIHN0ZDo6Y2luID4+IGEgPj4gYjsKICAgIHN0ZDo6Y291dCA8PCBzdW1PZlR3b0ludGVnZXJzKGEsIGIpIDw8IHN0ZDo6ZW5kbDsKCiAgICByZXR1cm4gMDsKfQ==', 0, 'GRADED', 'CREATED', 0.17, 1610, 10, CURRENT_TIMESTAMP);
insert into code_submission (id, code_question_id, user_id, language_id, head_code, body_code, tail_code, number_of_test_case_sent, grading_status, copy_state, avg_runtime, avg_memory, grade, created_at) values ('0b4bccfc-411f-499d-b470-9574152269aa', '3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', 'b029f559-52a8-4699-b595-71161498ed8c', 'c95d5c7d-cadf-42cc-afdc-968211ae3720', 'aW1wb3J0IGphdmEuaW8uKjs=', 'Y2xhc3MgUmVzdWx0IHsKICAgIHB1YmxpYyBzdGF0aWMgaW50IHN1bU9mVHdvSW50ZWdlcnMoaW50IGEsIGludCBiKSB7CiAgICAgICAgcmV0dXJuIGEgKyBiOwogICAgfQp9', 'cHVibGljIGNsYXNzIE1haW4gewogICAgcHVibGljIHN0YXRpYyB2b2lkIG1haW4oU3RyaW5nW10gYXJncykgdGhyb3dzIElPRXhjZXB0aW9uIHsKICAgICAgICBCdWZmZXJlZFJlYWRlciBidWZmZXJlZFJlYWRlciA9IG5ldyBCdWZmZXJlZFJlYWRlcihuZXcgSW5wdXRTdHJlYW1SZWFkZXIoU3lzdGVtLmluKSk7CgogICAgICAgIGludCBhID0gSW50ZWdlci5wYXJzZUludChidWZmZXJlZFJlYWRlci5yZWFkTGluZSgpLnRyaW0oKSk7CgogICAgICAgIGludCBiID0gSW50ZWdlci5wYXJzZUludChidWZmZXJlZFJlYWRlci5yZWFkTGluZSgpLnRyaW0oKSk7CgogICAgICAgIGludCByZXN1bHQgPSBSZXN1bHQuc3VtT2ZUd29JbnRlZ2VycyhhLCBiKTsKCiAgICAgICAgICAgIFN5c3RlbS5vdXQucHJpbnQocmVzdWx0KTsKICAgICAgICAgICAgYnVmZmVyZWRSZWFkZXIuY2xvc2UoKTsKICAgIH0KfQ==', 0, 'GRADED', 'CREATED', null, null, 0, CURRENT_TIMESTAMP);
insert into code_submission (id, code_question_id, user_id, language_id, head_code, body_code, tail_code, number_of_test_case_sent, grading_status, copy_state, avg_runtime, avg_memory, grade, created_at) values ('186c1fea-9706-4399-991a-8c9ff7d97b9a', '3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', 'c95d5c7d-cadf-42cc-afdc-968211ae3720', 'aW1wb3J0IGphdmEuaW8uKjs=', 'Y2xhc3MgUmVzdWx0IHsKICAgIHB1YmxpYyBzdGF0aWMgaW50IHN1bU9mVHdvSW50ZWdlcnMoaW50IGEsIGludCBiKSB7CiAgICAgICAgcmV0dXJuIGEgKyBiOwogICAgfQp9', 'cHVibGljIGNsYXNzIE1haW4gewogICAgcHVibGljIHN0YXRpYyB2b2lkIG1haW4oU3RyaW5nW10gYXJncykgdGhyb3dzIElPRXhjZXB0aW9uIHsKICAgICAgICBCdWZmZXJlZFJlYWRlciBidWZmZXJlZFJlYWRlciA9IG5ldyBCdWZmZXJlZFJlYWRlcihuZXcgSW5wdXRTdHJlYW1SZWFkZXIoU3lzdGVtLmluKSk7CgogICAgICAgIGludCBhID0gSW50ZWdlci5wYXJzZUludChidWZmZXJlZFJlYWRlci5yZWFkTGluZSgpLnRyaW0oKSk7CgogICAgICAgIGludCBiID0gSW50ZWdlci5wYXJzZUludChidWZmZXJlZFJlYWRlci5yZWFkTGluZSgpLnRyaW0oKSk7CgogICAgICAgIGludCByZXN1bHQgPSBSZXN1bHQuc3VtT2ZUd29JbnRlZ2VycyhhLCBiKTsKCiAgICAgICAgICAgIFN5c3RlbS5vdXQucHJpbnQocmVzdWx0KTsKICAgICAgICAgICAgYnVmZmVyZWRSZWFkZXIuY2xvc2UoKTsKICAgIH0KfQ==', 0, 'GRADED', 'CREATED', 0.68, 8137, 10, CURRENT_TIMESTAMP);

INSERT INTO programming_language_code_question(programming_language_id,code_question_id,time_limit,memory_limit,active, head_code, body_code, tail_code)
VALUES
    ('c95d5c7d-cadf-42cc-afdc-968211ae3720', '3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', 1, 204800, true, 'aW1wb3J0IGphdmEuaW8uKjs=', 'Y2xhc3MgUmVzdWx0IHsKICAgIHB1YmxpYyBzdGF0aWMgaW50IHN1bU9mVHdvSW50ZWdlcnMoaW50IGEsIGludCBiKSB7CgogICAgfQp9', 'cHVibGljIGNsYXNzIE1haW4gewogICAgcHVibGljIHN0YXRpYyB2b2lkIG1haW4oU3RyaW5nW10gYXJncykgdGhyb3dzIElPRXhjZXB0aW9uIHsKICAgICAgICBCdWZmZXJlZFJlYWRlciBidWZmZXJlZFJlYWRlciA9IG5ldyBCdWZmZXJlZFJlYWRlcihuZXcgSW5wdXRTdHJlYW1SZWFkZXIoU3lzdGVtLmluKSk7CgogICAgICAgIGludCBhID0gSW50ZWdlci5wYXJzZUludChidWZmZXJlZFJlYWRlci5yZWFkTGluZSgpLnRyaW0oKSk7CgogICAgICAgIGludCBiID0gSW50ZWdlci5wYXJzZUludChidWZmZXJlZFJlYWRlci5yZWFkTGluZSgpLnRyaW0oKSk7CgogICAgICAgIGludCByZXN1bHQgPSBSZXN1bHQuc3VtT2ZUd29JbnRlZ2VycyhhLCBiKTsKCiAgICAgICAgICAgIFN5c3RlbS5vdXQucHJpbnQocmVzdWx0KTsKICAgICAgICAgICAgYnVmZmVyZWRSZWFkZXIuY2xvc2UoKTsKICAgIH0KfQ=='),
    ('cba00cd8-8114-4bc4-84e6-499c27467978', '3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', 1, 204800, true, 'I2luY2x1ZGUgPGlvc3RyZWFtPg==', 'aW50IHN1bU9mVHdvSW50ZWdlcnMoaW50IGEsIGludCBiKXsKICAgIAp9', 'aW50IG1haW4oKQp7CiAgICBpbnQgYSwgYjsKICAgIHN0ZDo6Y2luID4+IGEgPj4gYjsKICAgIHN0ZDo6Y291dCA8PCBzdW1PZlR3b0ludGVnZXJzKGEsIGIpIDw8IHN0ZDo6ZW5kbDsKCiAgICByZXR1cm4gMDsKfQ==');

insert into tag_code_question values('3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', 'cd55e806-5d20-4813-b2ce-f8a235fc9151');
