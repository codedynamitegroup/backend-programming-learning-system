INSERT INTO public.user (id,email,dob,first_name,last_name,phone,address,avatar_url,created_at,updated_at,is_deleted)
VALUES
	 ('9ba179ed-d26d-4828-a0f6-8836c2063992','nguyenquoctuan385@gmail.com',NULL,'Tuan','Nguyen','012345678','HCM',NULL,'2024-04-12 21:33:23.371836+07','2024-04-12 21:33:23.371836+07',true),
	 ('b029f559-52a8-4699-b595-71161498ed8c','dcthong852@gmail.com',NULL,'Thong','Duong','12365478',NULL,NULL,'2024-04-15 18:07:20.891115+07','2024-04-15 18:07:20.891115+07',false),
	 ('8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7','tgtien852@gmail.com',NULL,'Tien','Truong','12365478',NULL,NULL,'2024-04-15 18:07:41.151759+07','2024-04-15 18:07:41.151759+07',false);


INSERT INTO public.topic(id, name, description, created_by, updated_by)
VALUES
    ('9ba179ed-d26d-4828-a0f6-8836c2063992', 'Learn Python', 'Python is a versatile and user-friendly programming language known for its readability and efficiency. It''s widely used for web development, data analysis, artificial intelligence, and more.', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb92', 'Learn C', 'C is a fundamental programming language that''s ideal for beginners due to its simplicity and direct control over hardware. Learning C provides a strong foundation in computer science concepts and programming techniques.', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb46', 'Learn Java', 'Java is a high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible. It is a general-purpose programming language intended to let application developers write once, run anywhere (WORA), meaning that compiled Java code can run on all platforms that support Java without the need for recompilation.', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb47', 'Learn JavaScript', 'JavaScript is a programming language that conforms to the ECMAScript specification. JavaScript is high-level, often just-in-time compiled, and multi-paradigm. It has curly-bracket syntax, dynamic typing, prototype-based object-orientation, and first-class functions.', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb48', 'Data structures and Algorithms', 'Explore the fundamental building blocks of computer science through our comprehensive courses on Data Structures and Algorithms. Gain a solid understanding of both theory and practical application.','9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992' ),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb49', 'Learn SQL', 'This sample SQL certification course equips you with the skills and knowledge to effectively query, manipulate, and manage data in relational databases using SQL.  The course prepares you for various entry-level database administrator or data analyst roles that heavily utilize SQL.','9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992' );

INSERT INTO public.organization(id, description, name, created_at, updated_at, is_deleted)
VALUES
	 ('9ba179ed-d26d-4828-a0f6-8836c2063992',NULL,'Code Dynamite','2024-04-15 18:37:44.08878+07','2024-04-15 18:37:44.08878+07',false),
	 ('08b65a39-394f-4977-a5fa-3fe145b620f8',NULL,'moodle2','2024-04-15 18:09:29.488151+07','2024-04-15 18:09:29.488151+07',false),
	 ('3ead3b08-afdd-442f-b544-fdbd86eaa186',NULL,'Code Dynamite','2024-04-15 18:09:40.033204+07','2024-04-15 18:09:40.033204+07',false);

INSERT INTO public.programming_language(id, name, compiler_api_id)
VALUES
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb47', 'Python (2.7.17)', 70),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb48', 'Java (OpenJDK 13.0.1)', 62),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb49', 'C++ (GCC 9.2.0)', 54);

INSERT INTO public.question(id, org_id, difficulty, name, question_text, general_feedback, default_mark, qtype, created_by, updated_by, copy_state)
VALUES
    ('b6484e21-6937-489c-b031-b71767994221', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'HARD', 'Question Pants', 'Question Mouse Text', 'Question Tuna feedback', 1, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994233', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'EASY', 'Question Handle', 'Question Wire Text', 'Question Gold feedback', 1, 'ESSAY', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994132', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'MEDIUM', 'Question hihi', 'Question Wow Text', 'Question Amazing feedback', 1, 'SHORT_ANSWER', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994735', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'HARD', 'Question haha', 'Question Speaker Text', 'Question Good Job feedback', 1, 'MULTIPLE_CHOICE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED');

INSERT INTO public.answer_of_question(id, question_id, feedback, answer, fraction)
VALUES
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb15', 'b6484e21-6937-489c-b031-b71767994221', 'Correct', 'print(Hello World)', 1),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb64', 'b6484e21-6937-489c-b031-b71767994233', 'Wrong', 'Essat 1', 1),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb86', 'b6484e21-6937-489c-b031-b71767994233', 'Wow', 'p p p)', 1),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb25', 'b6484e21-6937-489c-b031-b71767994233', 'Good', 'essay t12', 1),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb69', 'b6484e21-6937-489c-b031-b71767994132', 'Bad', 'short answer t12', 1),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfe63', 'b6484e21-6937-489c-b031-b71767994735', 'Hihi', 'multi 1', 1),
    ('d215b5f8-0249-4dc5-89a3-51fd148cff62', 'b6484e21-6937-489c-b031-b71767994735', 'huhu', 'multi 2', 1),
    ('d215b5f8-0249-4dc5-89a3-51fd148cff20', 'b6484e21-6937-489c-b031-b71767994735', 'haha', 'multi 3', 1);


INSERT INTO public.qtype_code_question(id, question_id, dsl_template)
VALUES
    ('27549d54-4a3a-4be4-9875-eab03f88ba5d', 'b6484e21-6937-489c-b031-b71767994221', 'print(Hello World)');

INSERT INTO public.qtype_essay_question(id, question_id, response_format, response_required, response_field_lines, min_word_limit, max_word_limit, attachments, attachments_required, grader_info, grader_info_format, response_template, max_bytes, file_types_list)
VALUES
    ('27549d54-4a3a-4be4-9875-eab03f88ba6e', 'b6484e21-6937-489c-b031-b71767994233', 'editor', 1, 10, 0, 0, 0, 0, 'Truong Gia Tien', 'author name', 'pdf please', 0, '.exe, .png, .c, .cpp');

INSERT INTO public.qtype_shortanswer_question(id, question_id, case_sensitive)
VALUES
    ('27549d54-4a3a-4be4-9875-eab03f88ba7f', 'b6484e21-6937-489c-b031-b71767994132', false);

INSERT INTO public.qtype_multichoice_question(id, question_id, single, shuffle_answers, correct_feedback, partially_correct_feedback, incorrect_feedback, answer_numbering, show_num_correct, show_standard_instruction)
VALUES
    ('27549d54-4a3a-4be4-9875-eab03f88ba8f', 'b6484e21-6937-489c-b031-b71767994735', true, true, 'Correct', 'Partially correct', 'Incorrect', 'none', 3, 'Show instruction 2');

INSERT INTO public.certificate_course(id, topic_id, name, description, skill_level, start_time, end_time, created_by, updated_by, avg_rating)
VALUES
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb15', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'Learn Python', 'This course is designed for beginners who want to learn Python programming from scratch. It covers the basics of Python programming, including data types, control structures, functions, and more.', 'BASIC', '2024-04-15 18:09:29.488151+07', '2024-04-15 18:09:29.488151+07', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 4),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb16', 'd215b5f8-0249-4dc5-89a3-51fd148cfb92', 'Intermediate Python', 'This course is designed for intermediate Python programmers who want to enhance their skills and knowledge. It covers advanced topics such as object-oriented programming, data structures, algorithms, and more.', 'INTERMEDIATE', '2024-04-15 18:09:29.488151+07', '2024-04-15 18:09:29.488151+07', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 4),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb17', 'd215b5f8-0249-4dc5-89a3-51fd148cfb46', 'Advanced Python', 'This course is designed for experienced Python programmers who want to master advanced Python concepts and techniques. It covers topics such as decorators, generators, metaclasses, and more.', 'ADVANCED', '2024-04-15 18:09:29.488151+07', '2024-04-15 18:09:29.488151+07', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 4),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb18', 'd215b5f8-0249-4dc5-89a3-51fd148cfb47', 'Learn Java', 'This course is designed for beginners who want to learn Java programming from scratch. It covers the basics of Java programming, including data types, control structures, functions, and more.', 'BASIC', '2024-04-15 18:09:29.488151+07', '2024-04-15 18:09:29.488151+07', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 0),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb19', 'd215b5f8-0249-4dc5-89a3-51fd148cfb48', 'Intermediate Java', 'This course is designed for intermediate Java programmers who want to enhance their skills and knowledge. It covers advanced topics such as object-oriented programming, data structures, algorithms, and more.', 'INTERMEDIATE', '2024-04-15 18:09:29.488151+07', '2024-04-15 18:09:29.488151+07', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 0),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb20', 'd215b5f8-0249-4dc5-89a3-51fd148cfb49', 'Advanced Java', 'This course is designed for experienced Java programmers who want to master advanced Java concepts and techniques. It covers topics such as decorators, generators, metaclasses, and more.', 'ADVANCED', '2024-04-15 18:09:29.488151+07', '2024-04-15 18:09:29.488151+07', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 0),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb21', 'd215b5f8-0249-4dc5-89a3-51fd148cfb48', 'Stacks and Queues', 'This course is designed for beginners who want to learn about stacks and queues. It covers the basics of stacks and queues, including their implementation, operations, and applications.', 'BASIC', '2024-04-15 18:09:29.488151+07', '2024-04-15 18:09:29.488151+07', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 0),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb22', 'd215b5f8-0249-4dc5-89a3-51fd148cfb49', 'Linked Lists', 'This course is designed for intermediate programmers who want to learn about linked lists. It covers the basics of linked lists, including their implementation, operations, and applications.', 'INTERMEDIATE', '2024-04-15 18:09:29.488151+07', '2024-04-15 18:09:29.488151+07', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 0),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb23', 'd215b5f8-0249-4dc5-89a3-51fd148cfb49', 'Binary Trees', 'This course is designed for experienced programmers who want to learn about binary trees. It covers the basics of binary trees, including their implementation, operations, and applications.', 'ADVANCED', '2024-04-15 18:09:29.488151+07', '2024-04-15 18:09:29.488151+07', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 0);

INSERT INTO public.topic_programming_language(topic_id, programming_language_id)
VALUES
    ('9ba179ed-d26d-4828-a0f6-8836c2063992', 'd215b5f8-0249-4dc5-89a3-51fd148cfb47'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb92', 'd215b5f8-0249-4dc5-89a3-51fd148cfb47'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb46', 'd215b5f8-0249-4dc5-89a3-51fd148cfb48'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb47', 'd215b5f8-0249-4dc5-89a3-51fd148cfb48'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb48', 'd215b5f8-0249-4dc5-89a3-51fd148cfb49'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb49', 'd215b5f8-0249-4dc5-89a3-51fd148cfb49');

INSERT INTO public.certificate_course_user(certificate_course_id, user_id)
VALUES
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb15', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb16', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb17', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb18', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb19', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb20', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb21', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb22', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb23', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb15', 'b029f559-52a8-4699-b595-71161498ed8c'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb16', 'b029f559-52a8-4699-b595-71161498ed8c'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb17', 'b029f559-52a8-4699-b595-71161498ed8c'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb18', 'b029f559-52a8-4699-b595-71161498ed8c'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb19', 'b029f559-52a8-4699-b595-71161498ed8c'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb20', 'b029f559-52a8-4699-b595-71161498ed8c'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb21', 'b029f559-52a8-4699-b595-71161498ed8c'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb22', 'b029f559-52a8-4699-b595-71161498ed8c'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb23', 'b029f559-52a8-4699-b595-71161498ed8c'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb15', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb16', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb17', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb18', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb19', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb20', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb21', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb22', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb23', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7');

INSERT INTO public.review(id, certificate_course_id, rating, content, created_by, updated_by)
VALUES
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb15', 'd215b5f8-0249-4dc5-89a3-51fd148cfb15', 5, 'Great course! I learned a lot from it.', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb16', 'd215b5f8-0249-4dc5-89a3-51fd148cfb15', 4, 'Good course! I enjoyed it.', 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb17', 'd215b5f8-0249-4dc5-89a3-51fd148cfb15', 3, 'Okay course. Could be better.', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb18', 'd215b5f8-0249-4dc5-89a3-51fd148cfb16', 5, 'Great course! I learned a lot from it.', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb19', 'd215b5f8-0249-4dc5-89a3-51fd148cfb16', 4, 'Good course! I enjoyed it.', 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb20', 'd215b5f8-0249-4dc5-89a3-51fd148cfb16', 3, 'Okay course. Could be better.', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb21', 'd215b5f8-0249-4dc5-89a3-51fd148cfb17', 5, 'Great course! I learned a lot from it.', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb22', 'd215b5f8-0249-4dc5-89a3-51fd148cfb17', 4, 'Good course! I enjoyed it.', 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb23', 'd215b5f8-0249-4dc5-89a3-51fd148cfb17', 3, 'Okay course. Could be better.', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7');