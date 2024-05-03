INSERT INTO public.user (id,email,dob,first_name,last_name,phone,address,avatar_url,created_at,updated_at,is_deleted)
VALUES
	 ('9ba179ed-d26d-4828-a0f6-8836c2063992','nguyenquoctuan385@gmail.com',NULL,'Tuan','Nguyen','012345678','HCM',NULL,'2024-04-12 21:33:23.371836+07','2024-04-12 21:33:23.371836+07',true),
	 ('b029f559-52a8-4699-b595-71161498ed8c','dcthong852@gmail.com',NULL,'Thong','Duong','12365478',NULL,NULL,'2024-04-15 18:07:20.891115+07','2024-04-15 18:07:20.891115+07',false),
	 ('8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7','tgtien852@gmail.com',NULL,'Tien','Truong','12365478',NULL,NULL,'2024-04-15 18:07:41.151759+07','2024-04-15 18:07:41.151759+07',false);


INSERT INTO public.topic(id, name, description, created_by, updated_by)
VALUES
    ('9ba179ed-d26d-4828-a0f6-8836c2063992', 'Learn Python', 'Python is a versatile and user-friendly programming language known for its readability and efficiency. It''s widely used for web development, data analysis, artificial intelligence, and more.', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb46', 'Learn Java', 'Java is a high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible. It is a general-purpose programming language intended to let application developers write once, run anywhere (WORA), meaning that compiled Java code can run on all platforms that support Java without the need for recompilation.', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb47', 'Learn JavaScript', 'JavaScript is a programming language that conforms to the ECMAScript specification. JavaScript is high-level, often just-in-time compiled, and multi-paradigm. It has curly-bracket syntax, dynamic typing, prototype-based object-orientation, and first-class functions.', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb48', 'Data structures and Algorithms', 'Explore the fundamental building blocks of computer science through our comprehensive courses on Data Structures and Algorithms. Gain a solid understanding of both theory and practical application.','9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992' );

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


