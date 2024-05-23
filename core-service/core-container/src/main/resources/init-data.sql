INSERT INTO public.user (id,email,dob,first_name,last_name,phone,address,avatar_url,created_at,updated_at,is_deleted)
VALUES
	 ('9ba179ed-d26d-4828-a0f6-8836c2063992','nguyenquoctuan385@gmail.com',NULL,'Tuan','Nguyen','012345678','HCM',NULL,'2024-04-12 21:33:23.371836+07','2024-04-12 21:33:23.371836+07',true),
	 ('b029f559-52a8-4699-b595-71161498ed8c','dcthong852@gmail.com',NULL,'Thong','Duong','12365478',NULL,NULL,'2024-04-15 18:07:20.891115+07','2024-04-15 18:07:20.891115+07',false),
	 ('8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7','tgtien852@gmail.com',NULL,'Tien','Truong','12365478',NULL,NULL,'2024-04-15 18:07:41.151759+07','2024-04-15 18:07:41.151759+07',false);


INSERT INTO public.topic(id, name, description, thumbnail_url, created_by, updated_by)
VALUES
    ('9ba179ed-d26d-4828-a0f6-8836c2063992',
     'Learn Python',
     'Python is a versatile and user-friendly programming language known for its readability and efficiency. It''s widely used for web development, data analysis, artificial intelligence, and more.',
     'https://cdn.codechef.com/images/self-learning/icons/python.svg',
     '9ba179ed-d26d-4828-a0f6-8836c2063992',
     '9ba179ed-d26d-4828-a0f6-8836c2063992'
    ),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb92',
     'Learn C',
     'C is a fundamental programming language that''s ideal for beginners due to its simplicity and direct control over hardware. Learning C provides a strong foundation in computer science concepts and programming techniques.',
     'https://cdn.codechef.com/images/self-learning/icons/c.svg',
     '9ba179ed-d26d-4828-a0f6-8836c2063992',
     '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb46',
     'Learn Java',
     'Java is a high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible. It is a general-purpose programming language intended to let application developers write once, run anywhere (WORA), meaning that compiled Java code can run on all platforms that support Java without the need for recompilation.',
     'https://cdn.codechef.com/images/self-learning/icons/java.svg',
     '9ba179ed-d26d-4828-a0f6-8836c2063992',
     '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb47',
     'Learn JavaScript',
     'JavaScript is a programming language that conforms to the ECMAScript specification. JavaScript is high-level, often just-in-time compiled, and multi-paradigm. It has curly-bracket syntax, dynamic typing, prototype-based object-orientation, and first-class functions.',
     'https://logos-download.com/wp-content/uploads/2019/01/JavaScript_Logo.png',
     '9ba179ed-d26d-4828-a0f6-8836c2063992',
     '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb48',
     'Data structures and Algorithms',
     'Explore the fundamental building blocks of computer science through our comprehensive courses on Data Structures and Algorithms. Gain a solid understanding of both theory and practical application.',
     'https://cdn.codechef.com/images/self-learning/icons/stacks-and-queues.svg',
     '9ba179ed-d26d-4828-a0f6-8836c2063992',
     '9ba179ed-d26d-4828-a0f6-8836c2063992' ),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb49',
     'Learn SQL',
     'This sample SQL certification course equips you with the skills and knowledge to effectively query, manipulate, and manage data in relational databases using SQL.  The course prepares you for various entry-level database administrator or data analyst roles that heavily utilize SQL.',
     'https://e7.pngegg.com/pngimages/170/924/png-clipart-microsoft-sql-server-microsoft-azure-sql-database-microsoft-text-logo.png',
     '9ba179ed-d26d-4828-a0f6-8836c2063992',
     '9ba179ed-d26d-4828-a0f6-8836c2063992' );

INSERT INTO public.organization(id, description, name, created_at, updated_at, is_deleted)
VALUES
	 ('9ba179ed-d26d-4828-a0f6-8836c2063992',NULL,'Code Dynamite','2024-04-15 18:37:44.08878+07','2024-04-15 18:37:44.08878+07',false),
	 ('08b65a39-394f-4977-a5fa-3fe145b620f8',NULL,'moodle2','2024-04-15 18:09:29.488151+07','2024-04-15 18:09:29.488151+07',false),
	 ('3ead3b08-afdd-442f-b544-fdbd86eaa186',NULL,'Code Dynamite','2024-04-15 18:09:40.033204+07','2024-04-15 18:09:40.033204+07',false);

-- INSERT INTO public.programming_language(id, name, compiler_api_id)
-- VALUES
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb47', 'Python (2.7.17)', 70),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb48', 'Java (OpenJDK 13.0.1)', 62),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb49', 'C++ (GCC 9.2.0)', 54);

insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('e268cd70-cf0d-46ce-8f69-ade9d3a955a2', 'Assembly (NASM 2.14.02)', 45, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('ec1a6b7b-7817-4241-bc8f-febce8d2770e', 'Bash (5.0.0)', 46, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('d6f8e702-0ab0-40cb-82b9-a7963bd1cf80', 'Basic (FBC 1.07.1)', 47, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('6b2f42e1-81e6-493b-9cc1-2436febc320e', 'C (Clang 7.0.1)', 75, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('8794526e-f528-4ffc-b98d-320812e79c6f', 'C++ (Clang 7.0.1)', 76, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('50e74d89-5742-4c21-b9e5-96a4766283fa', 'C (GCC 7.4.0)', 48, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('e6a880d8-f0b2-4c2d-b97d-a74d5bec87b3', 'C++ (GCC 7.4.0)', 52, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('fb38c7b8-d50a-4980-95de-6a50a49ecc5d', 'C (GCC 8.3.0)', 49, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('aed9a00b-6a4b-4534-b85e-4981097d61de', 'C++ (GCC 8.3.0)', 53, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('5f11cfd5-4358-4e8e-b28a-9c53beb014ad', 'C (GCC 9.2.0)', 50, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('cba00cd8-8114-4bc4-84e6-499c27467978', 'C++ (GCC 9.2.0)', 54, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('875a7edb-f310-4a15-89f0-7ca9fc8ce028', 'Clojure (1.10.1)', 86, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('70614628-fc54-4620-b9b9-81b918cae732', 'C# (Mono 6.6.0.161)', 51, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('f6dd240a-b9c5-4ab6-b977-105136f75907', 'COBOL (GnuCOBOL 2.2)', 77, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('8c37b8a9-c6de-4db1-9638-b3633e44f5a5', 'Common Lisp (SBCL 2.0.0)', 55, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('833c5b34-acc6-4e4c-8e37-3c806538924f', 'D (DMD 2.089.1)', 56, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('aa81ebed-79f2-4a9e-b45f-5406b45889b3', 'Elixir (1.9.4)', 57, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('59c636af-82c5-45f3-b2c6-5c47067f5462', 'Erlang (OTP 22.2)', 58, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('bd5d2b87-da1d-4be9-be0b-3a9dcdbf8849', 'Executable', 44, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('5ab21579-2a25-4d63-83c6-032ba4f66518', 'F# (.NET Core SDK 3.1.202)', 87, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('9cc1ba4a-f325-4767-8d3d-e2808f82cd76', 'Fortran (GFortran 9.2.0)', 59, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('e68c5866-1435-4958-bafe-ad901ee75c8d', 'Go (1.13.5)', 60, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('3fa9d570-86d1-41c0-8044-981bfe4636b4', 'Groovy (3.0.3)', 88, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('0b50bbe2-582e-4582-a51b-2b2ac4212420', 'Haskell (GHC 8.8.1)', 61, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('c95d5c7d-cadf-42cc-afdc-968211ae3720', 'Java (OpenJDK 13.0.1)', 62, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('cc69d904-ba4e-44fb-a0b5-8170e30bac39', 'JavaScript (Node.js 12.14.0)', 63, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('a48c0969-16bb-4d8a-a611-751b48f72454', 'Kotlin (1.3.70)', 78, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('794665fa-0c05-4f48-9255-68bf5bb84685', 'Lua (5.3.5)', 64, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('54ba8969-a91a-4863-a634-87aef2c43148', 'Multi-file program', 89, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('5effd41c-97f4-4843-b6c0-ee1790cb8502', 'Objective-C (Clang 7.0.1)', 79, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('d00b24db-44a5-49c2-99ea-d7c832199c9d', 'OCaml (4.09.0)', 65, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('df127469-95be-4de7-aebe-7852608d4066', 'Octave (5.1.0)', 66, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('87426e80-200c-4fcc-8df4-388307419247', 'Pascal (FPC 3.0.4)', 67, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('0b79d359-f4b5-4ede-aa55-7a6eb8f0a4a8', 'Perl (5.28.1)', 85, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('9c84c818-6931-4309-b669-9631d6363118', 'PHP (7.4.1)', 68, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('4183d72e-a4fe-4c76-9e61-5fb42afad43b', 'Plain Text', 43, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('dae1111e-87a6-47c5-bae1-d62e8bd4dd10', 'Prolog (GNU Prolog 1.4.5)', 69, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('5413d5e9-5513-4e86-b585-b4f9149bc692', 'Python (2.7.17)', 70, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('d27a8b36-83fd-450d-a7c3-bf3eef7b1468', 'Python (3.8.1)', 71, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('eb1526bd-6dbc-4512-81ee-60b38af78669', 'R (4.0.0)', 80, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('39b33107-a91d-47e2-af0b-cfec36dd1f6f', 'Ruby (2.7.0)', 72, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('cac1604f-a42d-4c27-92c1-45da338220e2', 'Rust (1.40.0)', 73, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('acf4fa1d-35e8-41ee-b174-8f485a35b25f', 'Scala (2.13.2)', 81, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('959eb798-748b-4d49-a0d9-7580bf679e07', 'SQL (SQLite 3.27.2)', 82, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('5122684e-b577-40ef-a25a-7cc6b9f19088', 'Swift (5.2.3)', 83, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('574bebfa-640b-4836-9920-9686123cf324', 'TypeScript (3.7.4)', 74, 2, 204800);
insert into programming_language (id, name, compiler_api_id, time_limit, memory_limit) values ('c2812b53-059f-43cb-8e9b-966246a79567', 'Visual Basic.Net (vbnc 0.0.0.5943)', 84, 2, 204800);

INSERT INTO public.question(id, org_id, difficulty, name, question_text, general_feedback, default_mark, qtype, created_by, updated_by, copy_state)
VALUES
    ('b6484e21-6937-489c-b031-b71767994221', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'HARD', 'Question Pants', 'Question Mouse Text', 'Question Tuna feedback', 1, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994233', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'EASY', 'Question Handle', 'Question Wire Text', 'Question Gold feedback', 1, 'ESSAY', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994132', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'MEDIUM', 'Question hihi', 'Question Wow Text', 'Question Amazing feedback', 1, 'SHORT_ANSWER', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994735', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'HARD', 'Question haha', 'Question Speaker Text', 'Question Good Job feedback', 1, 'MULTIPLE_CHOICE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994736', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'MEDIUM', 'Outputting & Math Operators', 'Learn how to make C++ print whatever you want, and learn to use it as a basic calculator.', 'Question Good Job feedback', 1, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994737', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'HARD', 'Variables & Data Types', 'Learn how to declare variables and use different data types in C++.', 'Question Good Job feedback', 1, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994738', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'EASY', 'Control Structures', 'Learn how to use control structures such as if-else statements and loops in C++.', 'Question Good Job feedback', 1, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994739', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'MEDIUM', 'Functions', 'Learn how to define and use functions in C++.', 'Question Good Job feedback', 1, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994740', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'HARD', 'Arrays & Strings', 'Learn how to declare and use arrays and strings in C++.', 'Question Good Job feedback', 1, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994741', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'EASY', 'Pointers', 'Learn how to declare and use pointers in C++.', 'Question Good Job feedback', 1, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994742', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'MEDIUM', 'Classes & Objects', 'Learn how to define classes and create objects in C++.', 'Question Good Job feedback', 1, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994743', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'HARD', 'Inheritance & Polymorphism', 'Learn how to use inheritance and polymorphism in C++.', 'Question Good Job feedback', 1, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994744', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'EASY', 'File Handling', 'Learn how to read from and write to files in C++.', 'Question Good Job feedback', 1, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994745', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'MEDIUM', 'Exceptions', 'Learn how to handle exceptions in C++.', 'Question Good Job feedback', 1, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994746', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'HARD', 'Templates', 'Learn how to use templates in C++.', 'Question Good Job feedback', 1, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994747', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'EASY', 'STL', 'Learn how to use the Standard Template Library (STL) in C++.', 'Question Good Job feedback', 1, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994748', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'MEDIUM', 'Concurrency', 'Learn how to write concurrent programs in C++ using threads and mutexes.', 'Question Good Job feedback', 1, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994749', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'HARD', 'Networking', 'Learn how to write networked programs in C++ using sockets.', 'Question Good Job feedback', 1, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),

--     Questions for contest_question
    ('b6484e21-6937-489c-b031-b71767994750', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'HARD', 'Remove Digit From Number to Maximize Result', 'Question Mouse Text', 'Question Tuna feedback', 1, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994751', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'EASY', 'Minimum Consecutive Cards to Pick Up', 'Question Wire Text', 'Question Gold feedback', 1, 'ESSAY', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994752', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'MEDIUM', 'K Divisible Elements Subarrays', 'Question Wow Text', 'Question Amazing feedback', 1, 'SHORT_ANSWER', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994753', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'HARD', 'Total Appeal of A String', 'Question Speaker Text', 'Question Good Job feedback', 1, 'MULTIPLE_CHOICE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED');

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
    ('27549d54-4a3a-4be4-9875-eab03f88ba5d', 'b6484e21-6937-489c-b031-b71767994221', 'print(Hello World)'),
    ('27549d54-4a3a-4be4-9875-eab03f88ba6d', 'b6484e21-6937-489c-b031-b71767994736', 'print(Hello World)'),
    ('27549d54-4a3a-4be4-9875-eab03f88ba7d', 'b6484e21-6937-489c-b031-b71767994737', 'print(Hello World)'),
    ('27549d54-4a3a-4be4-9875-eab03f88ba8d', 'b6484e21-6937-489c-b031-b71767994738', 'print(Hello World)'),
    ('27549d54-4a3a-4be4-9875-eab03f88ba9d', 'b6484e21-6937-489c-b031-b71767994739', 'print(Hello World)'),
    ('27549d54-4a3a-4be4-9875-eab03f88ba0d', 'b6484e21-6937-489c-b031-b71767994740', 'print(Hello World)'),
    ('27549d54-4a3a-4be4-9875-eab03f88ba1a', 'b6484e21-6937-489c-b031-b71767994741', 'print(Hello World)'),
    ('27549d54-4a3a-4be4-9875-eab03f88ba2a', 'b6484e21-6937-489c-b031-b71767994742', 'print(Hello World)'),
    ('27549d54-4a3a-4be4-9875-eab03f88ba3a', 'b6484e21-6937-489c-b031-b71767994743', 'print(Hello World)'),
    ('27549d54-4a3a-4be4-9875-eab03f88ba4a', 'b6484e21-6937-489c-b031-b71767994744', 'print(Hello World)'),
    ('27549d54-4a3a-4be4-9875-eab03f88ba5a', 'b6484e21-6937-489c-b031-b71767994745', 'print(Hello World)'),
    ('27549d54-4a3a-4be4-9875-eab03f88ba6a', 'b6484e21-6937-489c-b031-b71767994746', 'print(Hello World)'),
    ('27549d54-4a3a-4be4-9875-eab03f88ba7a', 'b6484e21-6937-489c-b031-b71767994747', 'print(Hello World)'),
    ('27549d54-4a3a-4be4-9875-eab03f88ba8a', 'b6484e21-6937-489c-b031-b71767994748', 'print(Hello World)'),
    ('27549d54-4a3a-4be4-9875-eab03f88ba9a', 'b6484e21-6937-489c-b031-b71767994749', 'print(Hello World)'),
    ('27549d54-4a3a-4be4-9875-eab03f88ba5b', 'b6484e21-6937-489c-b031-b71767994750', 'print(Hello World)'),
    ('27549d54-4a3a-4be4-9875-eab03f88ba6b', 'b6484e21-6937-489c-b031-b71767994751', 'print(Hello World)'),
    ('27549d54-4a3a-4be4-9875-eab03f88ba7b', 'b6484e21-6937-489c-b031-b71767994752', 'print(Hello World)'),
    ('27549d54-4a3a-4be4-9875-eab03f88ba8b', 'b6484e21-6937-489c-b031-b71767994753', 'print(Hello World)');

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
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb22', 'd215b5f8-0249-4dc5-89a3-51fd148cfb48', 'Linked Lists', 'This course is designed for intermediate programmers who want to learn about linked lists. It covers the basics of linked lists, including their implementation, operations, and applications.', 'INTERMEDIATE', '2024-04-15 18:09:29.488151+07', '2024-04-15 18:09:29.488151+07', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 0),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb23', 'd215b5f8-0249-4dc5-89a3-51fd148cfb48', 'Binary Trees', 'This course is designed for experienced programmers who want to learn about binary trees. It covers the basics of binary trees, including their implementation, operations, and applications.', 'ADVANCED', '2024-04-15 18:09:29.488151+07', '2024-04-15 18:09:29.488151+07', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 0);

INSERT INTO public.topic_programming_language(topic_id, programming_language_id)
VALUES
    ('9ba179ed-d26d-4828-a0f6-8836c2063992', 'd27a8b36-83fd-450d-a7c3-bf3eef7b1468'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb92', 'c95d5c7d-cadf-42cc-afdc-968211ae3720'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb46', 'c95d5c7d-cadf-42cc-afdc-968211ae3720'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb47', 'c95d5c7d-cadf-42cc-afdc-968211ae3720'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb48', 'c95d5c7d-cadf-42cc-afdc-968211ae3720'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb49', 'c95d5c7d-cadf-42cc-afdc-968211ae3720');

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

INSERT INTO public.chapter(id, certificate_course_id, no, title, description, created_by, updated_by)
VALUES
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb15', 'd215b5f8-0249-4dc5-89a3-51fd148cfb15', 1, 'Introduction to Python', 'This chapter introduces Python programming and covers basic concepts such as data types, control structures, and functions.', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb16', 'd215b5f8-0249-4dc5-89a3-51fd148cfb15', 2, 'Advanced Python Programming', 'This chapter covers advanced Python programming topics such as object-oriented programming, data structures, and algorithms.', 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb17', 'd215b5f8-0249-4dc5-89a3-51fd148cfb15', 3, 'Python Projects', 'This chapter focuses on building real-world Python projects to apply the knowledge and skills learned in the previous chapters.', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb18', 'd215b5f8-0249-4dc5-89a3-51fd148cfb16', 1, 'Introduction to Java', 'This chapter introduces Java programming and covers basic concepts such as data types, control structures, and functions.', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb19', 'd215b5f8-0249-4dc5-89a3-51fd148cfb16', 2, 'Advanced Java Programming', 'This chapter covers advanced Java programming topics such as object-oriented programming, data structures, and algorithms.', 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb20', 'd215b5f8-0249-4dc5-89a3-51fd148cfb16', 3, 'Java Projects', 'This chapter focuses on building real-world Java projects to apply the knowledge and skills learned in the previous chapters.', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb21', 'd215b5f8-0249-4dc5-89a3-51fd148cfb17', 1, 'Introduction to Stacks and Queues', 'This chapter introduces stacks and queues and covers basic concepts such as implementation, operations, and applications.', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb22', 'd215b5f8-0249-4dc5-89a3-51fd148cfb17', 2, 'Linked Lists', 'This chapter covers linked lists and their implementation, operations, and applications.', 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb23', 'd215b5f8-0249-4dc5-89a3-51fd148cfb17', 3, 'Binary Trees', 'This chapter covers binary trees and their implementation, operations, and applications.', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb24', 'd215b5f8-0249-4dc5-89a3-51fd148cfb18', 1, 'Introduction to Stacks and Queues', 'This chapter introduces stacks and queues and covers basic concepts such as implementation, operations, and applications.', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb25', 'd215b5f8-0249-4dc5-89a3-51fd148cfb18', 2, 'Linked Lists', 'This chapter covers linked lists and their implementation, operations, and applications.', 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb26', 'd215b5f8-0249-4dc5-89a3-51fd148cfb18', 3, 'Binary Trees', 'This chapter covers binary trees and their implementation, operations, and applications.', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb27', 'd215b5f8-0249-4dc5-89a3-51fd148cfb19', 1, 'Introduction to Stacks and Queues', 'This chapter introduces stacks and queues and covers basic concepts such as implementation, operations, and applications.', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb28', 'd215b5f8-0249-4dc5-89a3-51fd148cfb19', 2, 'Linked Lists', 'This chapter covers linked lists and their implementation, operations, and applications.', 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb29', 'd215b5f8-0249-4dc5-89a3-51fd148cfb19', 3, 'Binary Trees', 'This chapter covers binary trees and their implementation, operations, and applications.', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb30', 'd215b5f8-0249-4dc5-89a3-51fd148cfb20', 1, 'Introduction to Stacks and Queues', 'This chapter introduces stacks and queues and covers basic concepts such as implementation, operations, and applications.', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb31', 'd215b5f8-0249-4dc5-89a3-51fd148cfb20', 2, 'Linked Lists', 'This chapter covers linked lists and their implementation, operations, and applications.', 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb32', 'd215b5f8-0249-4dc5-89a3-51fd148cfb20', 3, 'Binary Trees', 'This chapter covers binary trees and their implementation, operations, and applications.', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb33', 'd215b5f8-0249-4dc5-89a3-51fd148cfb21', 1, 'Introduction to Stacks and Queues', 'This chapter introduces stacks and queues and covers basic concepts such as implementation, operations, and applications.', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb34', 'd215b5f8-0249-4dc5-89a3-51fd148cfb21', 2, 'Linked Lists', 'This chapter covers linked lists and their implementation, operations, and applications.', 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb35', 'd215b5f8-0249-4dc5-89a3-51fd148cfb21', 3, 'Binary Trees', 'This chapter covers binary trees and their implementation, operations, and applications.', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb36', 'd215b5f8-0249-4dc5-89a3-51fd148cfb22', 1, 'Introduction to Stacks and Queues', 'This chapter introduces stacks and queues and covers basic concepts such as implementation, operations, and applications.', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb37', 'd215b5f8-0249-4dc5-89a3-51fd148cfb22', 2, 'Linked Lists', 'This chapter covers linked lists and their implementation, operations, and applications.', 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb38', 'd215b5f8-0249-4dc5-89a3-51fd148cfb22', 3, 'Binary Trees', 'This chapter covers binary trees and their implementation, operations, and applications.', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb39', 'd215b5f8-0249-4dc5-89a3-51fd148cfb23', 1, 'Introduction to Stacks and Queues', 'This chapter introduces stacks and queues and covers basic concepts such as implementation, operations, and applications.', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb40', 'd215b5f8-0249-4dc5-89a3-51fd148cfb23', 2, 'Linked Lists', 'This chapter covers linked lists and their implementation, operations, and applications.', 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb41', 'd215b5f8-0249-4dc5-89a3-51fd148cfb23', 3, 'Binary Trees', 'This chapter covers binary trees and their implementation, operations, and applications.', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7');

-- Only question with qtype = 'CODE' will have code_snippet
INSERT INTO public.chapter_question(id, chapter_id, question_id)
VALUES
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb15', 'd215b5f8-0249-4dc5-89a3-51fd148cfb15', 'b6484e21-6937-489c-b031-b71767994736'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb16', 'd215b5f8-0249-4dc5-89a3-51fd148cfb15', 'b6484e21-6937-489c-b031-b71767994737'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb17', 'd215b5f8-0249-4dc5-89a3-51fd148cfb15', 'b6484e21-6937-489c-b031-b71767994738'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb18', 'd215b5f8-0249-4dc5-89a3-51fd148cfb16', 'b6484e21-6937-489c-b031-b71767994739'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb19', 'd215b5f8-0249-4dc5-89a3-51fd148cfb16', 'b6484e21-6937-489c-b031-b71767994740'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb20', 'd215b5f8-0249-4dc5-89a3-51fd148cfb16', 'b6484e21-6937-489c-b031-b71767994741'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb21', 'd215b5f8-0249-4dc5-89a3-51fd148cfb17', 'b6484e21-6937-489c-b031-b71767994742'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb22', 'd215b5f8-0249-4dc5-89a3-51fd148cfb17', 'b6484e21-6937-489c-b031-b71767994743'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb23', 'd215b5f8-0249-4dc5-89a3-51fd148cfb17', 'b6484e21-6937-489c-b031-b71767994744'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb24', 'd215b5f8-0249-4dc5-89a3-51fd148cfb18', 'b6484e21-6937-489c-b031-b71767994745'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb25', 'd215b5f8-0249-4dc5-89a3-51fd148cfb18', 'b6484e21-6937-489c-b031-b71767994746'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb26', 'd215b5f8-0249-4dc5-89a3-51fd148cfb18', 'b6484e21-6937-489c-b031-b71767994747'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb27', 'd215b5f8-0249-4dc5-89a3-51fd148cfb19', 'b6484e21-6937-489c-b031-b71767994748'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb28', 'd215b5f8-0249-4dc5-89a3-51fd148cfb19', 'b6484e21-6937-489c-b031-b71767994749');

INSERT INTO public.code_submission(id, user_id, code_question_id, programming_language_id, source_code, grade, pass)
VALUES
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb15', '9ba179ed-d26d-4828-a0f6-8836c2063992', '27549d54-4a3a-4be4-9875-eab03f88ba5a', 'd27a8b36-83fd-450d-a7c3-bf3eef7b1468', 'print("Hello, World!")', 1, true);

INSERT INTO public.contest(id, name, description, thumbnail_url, start_time, end_time, created_by, updated_by)
VALUES
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb15', 'Python Contest',
     '<h3 style="text-align:start"><span style="font-size:24px"><span style="font-family:-apple-system,BlinkMacSystemFont,&quot;Segoe UI&quot;,&quot;PingFang SC&quot;,&quot;Hiragino Sans GB&quot;,&quot;Microsoft YaHei&quot;,&quot;Helvetica Neue&quot;,Helvetica,Arial,sans-serif,&quot;Apple Color Emoji&quot;,&quot;Segoe UI Emoji&quot;,&quot;Segoe UI Symbol&quot;"><span style="color:rgba(0, 0, 0, 0.85)"><span style="background-color:#fafafa">Ch&agrave;o mừng đến với Cuộc thi h&agrave;ng tuần Batch the code lần thứ 387</span></span></span></span></h3>

<p>&nbsp;</p>

<p style="text-align:start"><span style="font-size:14px"><span style="color:rgba(0, 0, 0, 0.65)"><span style="font-family:-apple-system,BlinkMacSystemFont,&quot;Segoe UI&quot;,&quot;PingFang SC&quot;,&quot;Hiragino Sans GB&quot;,&quot;Microsoft YaHei&quot;,&quot;Helvetica Neue&quot;,Helvetica,Arial,sans-serif,&quot;Apple Color Emoji&quot;,&quot;Segoe UI Emoji&quot;,&quot;Segoe UI Symbol&quot;"><span style="background-color:#fafafa">Cuộc thi n&agrave;y được t&agrave;i trợ bởi CodeDynamite.</span></span></span></span></p>

<p style="text-align:start"><span style="font-size:14px"><span style="color:rgba(0, 0, 0, 0.65)"><span style="font-family:-apple-system,BlinkMacSystemFont,&quot;Segoe UI&quot;,&quot;PingFang SC&quot;,&quot;Hiragino Sans GB&quot;,&quot;Microsoft YaHei&quot;,&quot;Helvetica Neue&quot;,Helvetica,Arial,sans-serif,&quot;Apple Color Emoji&quot;,&quot;Segoe UI Emoji&quot;,&quot;Segoe UI Symbol&quot;"><span style="background-color:#fafafa"><strong>H&atilde;y đăng k&yacute; trước cuộc thi v&agrave; điền v&agrave;o bản khảo s&aacute;t để được chọn phỏng vấn với CodeDynamite!!</strong></span></span></span></span></p>

<p style="text-align:start"><span style="font-size:14px"><span style="color:rgba(0, 0, 0, 0.65)"><span style="font-family:-apple-system,BlinkMacSystemFont,&quot;Segoe UI&quot;,&quot;PingFang SC&quot;,&quot;Hiragino Sans GB&quot;,&quot;Microsoft YaHei&quot;,&quot;Helvetica Neue&quot;,Helvetica,Arial,sans-serif,&quot;Apple Color Emoji&quot;,&quot;Segoe UI Emoji&quot;,&quot;Segoe UI Symbol&quot;"><span style="background-color:#fafafa">Bạn c&oacute; thể điền th&ocirc;ng tin li&ecirc;n hệ ở bước đăng k&yacute;.&nbsp;CodeDynamite c&oacute; thể li&ecirc;n hệ với những người chiến thắng cuộc thi đủ điều kiện để c&oacute; cơ hội phỏng vấn với CodeDynamite.</span></span></span></span></p>

<p style="text-align:start"><span style="font-size:14px"><span style="color:rgba(0, 0, 0, 0.65)"><span style="font-family:-apple-system,BlinkMacSystemFont,&quot;Segoe UI&quot;,&quot;PingFang SC&quot;,&quot;Hiragino Sans GB&quot;,&quot;Microsoft YaHei&quot;,&quot;Helvetica Neue&quot;,Helvetica,Arial,sans-serif,&quot;Apple Color Emoji&quot;,&quot;Segoe UI Emoji&quot;,&quot;Segoe UI Symbol&quot;"><span style="background-color:#fafafa"><strong><strong>⭐ Giải thưởng⭐</strong></strong></span></span></span></span></p>

<ul>
	<li>Th&iacute; sinh xếp&nbsp;<strong>thứ 1 ~ thứ 3</strong>&nbsp;sẽ gi&agrave;nh được Ba l&ocirc; CodeDynamite</li>
	<li>Th&iacute; sinh xếp&nbsp;<strong>thứ 4 ~ 10</strong>&nbsp;sẽ gi&agrave;nh được B&igrave;nh nước CodeDynamite</li>
	<li>Th&iacute; sinh xếp hạng&nbsp;<strong>11 ~ 16</strong>&nbsp;sẽ gi&agrave;nh được CodeDynamite Big O Notebook</li>
</ul>

<p style="text-align:start"><span style="font-size:14px"><span style="color:rgba(0, 0, 0, 0.65)"><span style="font-family:-apple-system,BlinkMacSystemFont,&quot;Segoe UI&quot;,&quot;PingFang SC&quot;,&quot;Hiragino Sans GB&quot;,&quot;Microsoft YaHei&quot;,&quot;Helvetica Neue&quot;,Helvetica,Arial,sans-serif,&quot;Apple Color Emoji&quot;,&quot;Segoe UI Emoji&quot;,&quot;Segoe UI Symbol&quot;"><span style="background-color:#fafafa">Chỉ t&agrave;i khoản LCUS(6bt.com) mới đủ điều kiện nhận phần thưởng.&nbsp;Sau khi bảng xếp hạng được ho&agrave;n tất, th&agrave;nh vi&ecirc;n nh&oacute;m CodeDynamitesẽ li&ecirc;n hệ với bạn qua email về m&oacute;n qu&agrave;!</span></span></span></span></p>

<p><img src="https://assets.leetcode.com/static_assets/others/Contest_Prize_Banner.png" style="--tw-border-spacing-x:0; --tw-border-spacing-y:0; --tw-ring-color:rgba(59,130,246,.5); --tw-ring-offset-color:#ffffff; --tw-ring-offset-shadow:0 0 #0000; --tw-ring-offset-width:0px; --tw-ring-shadow:0 0 #0000; --tw-rotate:0; --tw-scale-x:1; --tw-scale-y:1; --tw-scroll-snap-strictness:proximity; --tw-shadow-colored:0 0 #0000; --tw-shadow:0 0 #0000; --tw-skew-x:0; --tw-skew-y:0; --tw-translate-x:0; --tw-translate-y:0; background-color:#fafafa; border:0px none; box-sizing:border-box; color:rgba(0, 0, 0, 0.65); font-family:-apple-system,BlinkMacSystemFont,&quot;Segoe UI&quot;,&quot;PingFang SC&quot;,&quot;Hiragino Sans GB&quot;,&quot;Microsoft YaHei&quot;,&quot;Helvetica Neue&quot;,Helvetica,Arial,sans-serif,&quot;Apple Color Emoji&quot;,&quot;Segoe UI Emoji&quot;,&quot;Segoe UI Symbol&quot;; font-size:14px; font-style:normal; font-variant-ligatures:normal; font-weight:400; margin-bottom:20px; max-width:100%; text-align:start; text-decoration-color:initial; text-decoration-style:initial; text-decoration-thickness:initial; vertical-align:middle; white-space:normal" /></p>

<h4 style="text-align:start"><span style="font-size:18px"><span style="font-family:-apple-system,BlinkMacSystemFont,&quot;Segoe UI&quot;,&quot;PingFang SC&quot;,&quot;Hiragino Sans GB&quot;,&quot;Microsoft YaHei&quot;,&quot;Helvetica Neue&quot;,Helvetica,Arial,sans-serif,&quot;Apple Color Emoji&quot;,&quot;Segoe UI Emoji&quot;,&quot;Segoe UI Symbol&quot;"><span style="color:rgba(0, 0, 0, 0.85)"><span style="background-color:#fafafa">&nbsp;&nbsp;Lưu &yacute; quan trọng</span></span></span></span></h4>

<ol>
	<li>Để mang đến một cuộc thi tốt hơn v&agrave; đảm bảo t&iacute;nh c&ocirc;ng bằng, ch&uacute;ng t&ocirc;i đ&atilde; lắng nghe phản hồi của 6BroCoder v&agrave; suy nghĩ rất nhiều về thể lệ cuộc thi được cập nhật.&nbsp;Vui l&ograve;ng xem&nbsp;<a href="https://leetcode.com/discuss/general-discussion/951105/new-contest-rule-effective-from-december-2020" style="box-sizing:border-box; border:0px solid; --tw-border-spacing-x:0; --tw-border-spacing-y:0; --tw-translate-x:0; --tw-translate-y:0; --tw-rotate:0; --tw-skew-x:0; --tw-skew-y:0; --tw-scale-x:1; --tw-scale-y:1; --tw-pan-x: ; --tw-pan-y: ; --tw-pinch-zoom: ; --tw-scroll-snap-strictness:proximity; --tw-gradient-from-position: ; --tw-gradient-via-position: ; --tw-gradient-to-position: ; --tw-ordinal: ; --tw-slashed-zero: ; --tw-numeric-figure: ; --tw-numeric-spacing: ; --tw-numeric-fraction: ; --tw-ring-inset: ; --tw-ring-offset-width:0px; --tw-ring-offset-color:#ffffff; --tw-ring-color:rgba(59,130,246,.5); --tw-ring-offset-shadow:0 0 #0000; --tw-ring-shadow:0 0 #0000; --tw-shadow:0 0 #0000; --tw-shadow-colored:0 0 #0000; --tw-blur: ; --tw-brightness: ; --tw-contrast: ; --tw-grayscale: ; --tw-hue-rotate: ; --tw-invert: ; --tw-saturate: ; --tw-sepia: ; --tw-drop-shadow: ; --tw-backdrop-blur: ; --tw-backdrop-brightness: ; --tw-backdrop-contrast: ; --tw-backdrop-grayscale: ; --tw-backdrop-hue-rotate: ; --tw-backdrop-invert: ; --tw-backdrop-opacity: ; --tw-backdrop-saturate: ; --tw-backdrop-sepia: ; color:#1890ff; text-decoration:none; outline:none; cursor:pointer; transition:color 0.3s ease 0s; touch-action:manipulation">quy tắc</a>&nbsp;cuộc thi mới của ch&uacute;ng t&ocirc;i bao gồm nhiều t&igrave;nh huống hơn với giải th&iacute;ch chi tiết.</li>
	<li>Mỗi lần gửi sai sẽ bị&nbsp;phạt&nbsp;<strong>5 ph&uacute;t.</strong></li>
	<li>Để đảm bảo t&iacute;nh c&ocirc;ng bằng của cuộc thi, CodeDynamite sẽ ẩn một số test case trong suốt cuộc thi.&nbsp;Khi người d&ugrave;ng gửi b&agrave;i gửi kh&ocirc;ng ch&iacute;nh x&aacute;c, CodeDynamite sẽ kh&ocirc;ng hiển thị c&aacute;c trường hợp thử nghiệm ẩn cho người d&ugrave;ng.</li>
	<li>Đ&aacute;nh gi&aacute; cuối c&ugrave;ng của cuộc thi n&agrave;y sẽ được cập nhật trong v&ograve;ng 5 ng&agrave;y l&agrave;m việc sau cuộc thi.</li>
	<br />
	<li><strong>C&aacute;c h&agrave;nh động dưới đ&acirc;y được coi l&agrave; vi phạm cuộc thi</strong>&nbsp;:
	<ul>
		<li>Một người d&ugrave;ng gửi bằng nhiều t&agrave;i khoản trong một cuộc thi.&nbsp;T&agrave;i khoản LCUS (CodeDynamite.com) v&agrave; t&agrave;i khoản LCCN (CodeDynamite-cn.com) được coi l&agrave; t&agrave;i khoản ri&ecirc;ng biệt, ngay cả khi cả hai t&agrave;i khoản đều thuộc về c&ugrave;ng một người d&ugrave;ng.</li>
		<li>Nhiều t&agrave;i khoản gửi m&atilde; giống nhau cho c&ugrave;ng một vấn đề.</li>
		<li>Tạo ra những x&aacute;o trộn kh&ocirc;ng mong muốn l&agrave;m gi&aacute;n đoạn sự tham gia của người d&ugrave;ng kh&aacute;c v&agrave;o cuộc thi.</li>
		<li>C&ocirc;ng bố giải ph&aacute;p cuộc thi ở c&aacute;c b&agrave;i thảo luận c&ocirc;ng khai trước khi cuộc thi kết th&uacute;c.</li>
	</ul>
	<br />
	CodeDynamite nhấn mạnh v&agrave;o t&iacute;nh c&ocirc;ng bằng v&agrave; c&ocirc;ng bằng trong c&aacute;c cuộc thi của ch&uacute;ng t&ocirc;i.&nbsp;Ch&uacute;ng t&ocirc;i ho&agrave;n to&agrave;n&nbsp;<strong>KH&Ocirc;NG CHẤP NHẬN</strong>&nbsp;đối với c&aacute;c h&agrave;nh vi vi phạm (chẳng hạn như đạo văn, gian lận, v.v.).&nbsp;Khi người d&ugrave;ng bị coi l&agrave; vi phạm quy tắc cuộc thi, ch&uacute;ng t&ocirc;i sẽ &aacute;p dụng c&aacute;c h&igrave;nh phạt sau đối với người d&ugrave;ng n&agrave;y:

	<ul>
		<li><strong>Vi phạm lần đầu</strong>&nbsp;: Số tiền 6Coin đặt lại về 0 v&agrave; một cuộc thi v&agrave; thảo luận về lệnh cấm trong 1 th&aacute;ng.</li>
		<li><strong>Vi phạm lần 2</strong>&nbsp;: Kh&oacute;a t&agrave;i khoản vĩnh viễn m&agrave; kh&ocirc;ng kh&aacute;ng c&aacute;o.</li>
	</ul>
	<br />
	Hơn nữa, ch&uacute;ng t&ocirc;i khuyến kh&iacute;ch tất cả những người tham gia đ&oacute;ng g&oacute;p v&agrave;o việc duy tr&igrave; sự c&ocirc;ng bằng v&agrave; c&ocirc;ng bằng trong cuộc thi của ch&uacute;ng t&ocirc;i.&nbsp;Người d&ugrave;ng gửi (c&aacute;c) b&aacute;o c&aacute;o vi phạm hợp lệ sẽ kiếm th&ecirc;m 6Coin:
	<ul>
		<li>Đối với mỗi người tham gia vi phạm, 10 người d&ugrave;ng đầu ti&ecirc;n gửi b&aacute;o c&aacute;o vi phạm đối với người tham gia n&agrave;y sẽ kiếm được 20 6Coin.</li>
		<li>Mỗi người d&ugrave;ng c&oacute; thể kiếm tới 100 6Coin khi b&aacute;o c&aacute;o vi phạm trong một cuộc thi.</li>
		<li>Người d&ugrave;ng sẽ kh&ocirc;ng được thưởng 6Coins cho c&aacute;c b&aacute;o c&aacute;o về người d&ugrave;ng LCCN.</li>
	</ul>
	</li>
</ol>

<p><br />
&nbsp;</p>

<h4 style="text-align:start"><span style="font-size:18px"><span style="font-family:-apple-system,BlinkMacSystemFont,&quot;Segoe UI&quot;,&quot;PingFang SC&quot;,&quot;Hiragino Sans GB&quot;,&quot;Microsoft YaHei&quot;,&quot;Helvetica Neue&quot;,Helvetica,Arial,sans-serif,&quot;Apple Color Emoji&quot;,&quot;Segoe UI Emoji&quot;,&quot;Segoe UI Symbol&quot;"><span style="color:rgba(0, 0, 0, 0.85)"><span style="background-color:#fafafa">&nbsp;&nbsp;Th&ocirc;ng b&aacute;o</span></span></span></span></h4>

<p style="text-align:start"><span style="font-size:14px"><span style="color:rgba(0, 0, 0, 0.65)"><span style="font-family:-apple-system,BlinkMacSystemFont,&quot;Segoe UI&quot;,&quot;PingFang SC&quot;,&quot;Hiragino Sans GB&quot;,&quot;Microsoft YaHei&quot;,&quot;Helvetica Neue&quot;,Helvetica,Arial,sans-serif,&quot;Apple Color Emoji&quot;,&quot;Segoe UI Emoji&quot;,&quot;Segoe UI Symbol&quot;"><span style="background-color:#fafafa">Người d&ugrave;ng&nbsp;<strong>phải đăng k&yacute;</strong>&nbsp;để tham gia.&nbsp;Ch&uacute;ng t&ocirc;i hy vọng bạn th&iacute;ch cuộc thi n&agrave;y!</span></span></span></span></p>',
     'https://leetcode.com/_next/static/images/weekly-default-553ede7bcc8e1b4a44c28a9e4a32068c.png', '2024-05-20 18:09:29.488151+07', '2024-09-10 18:09:29.488151+07', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb16', 'Java Contest',
     '<h3 style="text-align:start"><span style="font-size:24px"><span style="font-family:-apple-system,BlinkMacSystemFont,&quot;Segoe UI&quot;,&quot;PingFang SC&quot;,&quot;Hiragino Sans GB&quot;,&quot;Microsoft YaHei&quot;,&quot;Helvetica Neue&quot;,Helvetica,Arial,sans-serif,&quot;Apple Color Emoji&quot;,&quot;Segoe UI Emoji&quot;,&quot;Segoe UI Symbol&quot;"><span style="color:rgba(0, 0, 0, 0.85)"><span style="background-color:#fafafa">Welcome to the Java Contest Batch the code #387</span></span></span></span></h3>',
     'https://leetcode.com/_next/static/images/biweekly-default-f5a8fc3be85b6c9175207fd8fd855d47.png', '2024-09-15 18:09:29.488151+07', '2024-10-15 18:09:29.488151+07', 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb17', 'Data Structures Contest',
     '<h3 style="text-align:start"><span style="font-size:24px"><span style="font-family:-apple-system,BlinkMacSystemFont,&quot;Segoe UI&quot;,&quot;PingFang SC&quot;,&quot;Hiragino Sans GB&quot;,&quot;Microsoft YaHei&quot;,&quot;Helvetica Neue&quot;,Helvetica,Arial,sans-serif,&quot;Apple Color Emoji&quot;,&quot;Segoe UI Emoji&quot;,&quot;Segoe UI Symbol&quot;"><span style="color:rgba(0, 0, 0, 0.85)"><span style="background-color:#fafafa">Welcome to the Data Structures Contest Batch the code #387</span></span></span></span></h3>',
     'https://assets.leetcode.com/contest/weekly-contest-291/card_img_1654267951.png', '2024-01-15 18:09:29.488151+07', null, '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb18', 'Algorithms Contest',
        '<h3 style="text-align:start"><span style="font-size:24px"><span style="font-family:-apple-system,BlinkMacSystemFont,&quot;Segoe UI&quot;,&quot;PingFang SC&quot;,&quot;Hiragino Sans GB&quot;,&quot;Microsoft YaHei&quot;,&quot;Helvetica Neue&quot;,Helvetica,Arial,sans-serif,&quot;Apple Color Emoji&quot;,&quot;Segoe UI Emoji&quot;,&quot;Segoe UI Symbol&quot;"><span style="color:rgba(0, 0, 0, 0.85)"><span style="background-color:#fafafa">Welcome to the Algorithms Contest Batch the code #387</span></span></span></span></h3>',
     'https://assets.leetcode.com/contest/weekly-contest-291/card_img_1654267951.png', '2024-01-15 18:09:29.488151+07', '2024-04-15 18:09:29.488151+07', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992');

INSERT INTO public.contest_user(contest_id, user_id)
VALUES
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb15', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb16', 'b029f559-52a8-4699-b595-71161498ed8c'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb17', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb18', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb15', 'b029f559-52a8-4699-b595-71161498ed8c'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb15', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7');

INSERT INTO public.contest_question(contest_id, question_id)
VALUES
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb15', 'b6484e21-6937-489c-b031-b71767994750'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb15', 'b6484e21-6937-489c-b031-b71767994751'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb15', 'b6484e21-6937-489c-b031-b71767994752'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb15', 'b6484e21-6937-489c-b031-b71767994753');

INSERT INTO public.code_submission(id, user_id, code_question_id, programming_language_id, source_code, grade, pass)
VALUES
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb16', '9ba179ed-d26d-4828-a0f6-8836c2063992', '27549d54-4a3a-4be4-9875-eab03f88ba5b', 'd27a8b36-83fd-450d-a7c3-bf3eef7b1468', 'print("Hello, World!")', 0, false),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb17', 'b029f559-52a8-4699-b595-71161498ed8c', '27549d54-4a3a-4be4-9875-eab03f88ba6b', 'd27a8b36-83fd-450d-a7c3-bf3eef7b1468', 'print("Hello, World!")', 0, false),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb18', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', '27549d54-4a3a-4be4-9875-eab03f88ba7b', 'd27a8b36-83fd-450d-a7c3-bf3eef7b1468', 'print("Hello, World!")', 0, false),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb19', '9ba179ed-d26d-4828-a0f6-8836c2063992', '27549d54-4a3a-4be4-9875-eab03f88ba5b', 'd27a8b36-83fd-450d-a7c3-bf3eef7b1468', 'print("Hello, World!")', 2, true),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb20', '9ba179ed-d26d-4828-a0f6-8836c2063992', '27549d54-4a3a-4be4-9875-eab03f88ba5b', 'd27a8b36-83fd-450d-a7c3-bf3eef7b1468', 'print("Hello, World!")', 3, true),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb21', 'b029f559-52a8-4699-b595-71161498ed8c', '27549d54-4a3a-4be4-9875-eab03f88ba6b', 'd27a8b36-83fd-450d-a7c3-bf3eef7b1468', 'print("Hello, World!")', 3, true),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb22', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', '27549d54-4a3a-4be4-9875-eab03f88ba7b', 'd27a8b36-83fd-450d-a7c3-bf3eef7b1468', 'print("Hello, World!")', 0, false),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb23', '9ba179ed-d26d-4828-a0f6-8836c2063992', '27549d54-4a3a-4be4-9875-eab03f88ba8b', 'd27a8b36-83fd-450d-a7c3-bf3eef7b1468', 'print("Hello, World!")', 4, true);

