INSERT INTO public.user (id,email,dob,first_name,last_name,phone,address,avatar_url,created_at,updated_at,is_deleted) VALUES
	 ('9ba179ed-d26d-4828-a0f6-8836c2063992','nguyenquoctuan385@gmail.com','2002-05-29','Tuan','Nguyen Quoc','+8412365478',NULL,NULL,'2024-04-12 21:33:23.371836+07','2024-04-12 21:33:23.371836+07',false),
	 ('b029f559-52a8-4699-b595-71161498ed8c','dcthong852@gmail.com','2002-04-29','Thong','Duong','+8412365478',NULL,NULL,'2024-04-15 18:07:20.891115+07','2024-04-15 18:07:20.891115+07',false),
	 ('8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7','nthoang852@gmail.com','2002-03-29','Hoang','Nguyen Thanh','+8412365478',NULL,NULL,'2024-04-15 18:07:41.151759+07','2024-04-15 18:07:41.151759+07',false),
	 ('39328bcf-8af6-44fc-9ae9-247f953ee2a2','ndqkhanh852@gmail.com','2002-03-29','Khanh','Nguyen Dinh','+8412365478',NULL,NULL,'2024-04-15 18:07:41.151759+07','2024-04-15 18:07:41.151759+07',false),
	 ('8edbc0aa-0b91-480e-a428-23abf2109df9','tgtien852@gmail.com','2002-03-29','Tien','Truong Gia','+8412365478',NULL,NULL,'2024-04-15 18:07:41.151759+07','2024-04-15 18:07:41.151759+07',false),
	 ('05dbdfde-1eae-47ba-8ebb-6c4cdc4f6510','dntien852@gmail.com','2002-03-29','Tien','Dang Ngoc','+8412365478',NULL,NULL,'2024-04-15 18:07:41.151759+07','2024-04-15 18:07:41.151759+07',false),
     ('64412e27-169e-44ea-a101-74ebf8cb82d9','kayonkiu@gmail.com','2002-03-29','Admin','User',NULL,NULL,NULL,'2024-06-04 19:54:23.636865+07','2024-06-04 19:54:23.637867+07', false),
	 ('cb2c22ac-87de-44e4-9638-35979f6af667','duongchithong2002@gmail.com','2002-03-29','Dương','Chí Thông',NULL,NULL,NULL,'2024-06-04 19:54:23.664571+07','2024-06-04 19:54:23.664571+07', false),
	 ('2d7ed5a0-fb21-4927-9a25-647c17d29668','dntienes@gmail.com','2002-03-29','Tiến','Đặng Ngọc','0993331110',NULL,NULL,'2024-06-04 19:54:23.690581+07','2024-06-04 19:54:23.690581+07', false);

INSERT INTO public."user" (id,email,dob,first_name,last_name,phone,address,avatar_url,created_at,updated_at,is_deleted) VALUES
	 ('2d3c1e66-1835-457f-93e9-265fe483feee','dt.ngocthw@gmail.com','2002-03-29','Thư','Ngọc',NULL,NULL,NULL,'2024-06-04 19:54:23.712124+07','2024-06-04 19:54:23.712124+07',false),
	 ('a9f5487e-c0b1-4fa4-b93a-6f16bde90583','ktpm4t@gmail.com','2002-03-29','giáo','vien',NULL,NULL,NULL,'2024-06-04 19:54:23.73386+07','2024-06-04 19:54:23.73386+07',false),
	 ('ca3040f2-e173-40a5-aab7-6ef15965ce43','truonggiatien123@gmail.com','2002-03-29','Trương','Gia Tiến',NULL,NULL,NULL,'2024-06-04 19:54:23.789748+07','2024-06-04 19:54:23.789748+07',false);

INSERT INTO public.topic(id, name, description, thumbnail_url, created_by, updated_by, is_single_programming_language)
VALUES
    ('9ba179ed-d26d-4828-a0f6-8836c2063992',
     'Learn Python',
     'Python is a versatile and user-friendly programming language known for its readability and efficiency. It''s widely used for web development, data analysis, artificial intelligence, and more.',
     'https://cdn.codechef.com/images/self-learning/icons/python.svg',
     '9ba179ed-d26d-4828-a0f6-8836c2063992',
     '9ba179ed-d26d-4828-a0f6-8836c2063992',
        true
    ),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb92',
     'Learn C',
     'C is a fundamental programming language that''s ideal for beginners due to its simplicity and direct control over hardware. Learning C provides a strong foundation in computer science concepts and programming techniques.',
     'https://cdn.codechef.com/images/self-learning/icons/c.svg',
     '9ba179ed-d26d-4828-a0f6-8836c2063992',
     '9ba179ed-d26d-4828-a0f6-8836c2063992',
     true),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb46',
     'Learn Java',
     'Java is a high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible. It is a general-purpose programming language intended to let application developers write once, run anywhere (WORA), meaning that compiled Java code can run on all platforms that support Java without the need for recompilation.',
     'https://cdn.codechef.com/images/self-learning/icons/java.svg',
     '9ba179ed-d26d-4828-a0f6-8836c2063992',
     '9ba179ed-d26d-4828-a0f6-8836c2063992',
     true),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb47',
     'Learn JavaScript',
     'JavaScript is a programming language that conforms to the ECMAScript specification. JavaScript is high-level, often just-in-time compiled, and multi-paradigm. It has curly-bracket syntax, dynamic typing, prototype-based object-orientation, and first-class functions.',
     'https://logos-download.com/wp-content/uploads/2019/01/JavaScript_Logo.png',
     '9ba179ed-d26d-4828-a0f6-8836c2063992',
     '9ba179ed-d26d-4828-a0f6-8836c2063992',
     true),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb49',
     'Learn SQL',
     'This sample SQL certification course equips you with the skills and knowledge to effectively query, manipulate, and manage data in relational databases using SQL.  The course prepares you for various entry-level database administrator or data analyst roles that heavily utilize SQL.',
     'https://e7.pngegg.com/pngimages/170/924/png-clipart-microsoft-sql-server-microsoft-azure-sql-database-microsoft-text-logo.png',
     '9ba179ed-d26d-4828-a0f6-8836c2063992',
     '9ba179ed-d26d-4828-a0f6-8836c2063992',
     true),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb48',
     'Data structures and Algorithms',
     'Explore the fundamental building blocks of computer science through our comprehensive courses on Data Structures and Algorithms. Gain a solid understanding of both theory and practical application.',
     'https://cdn.codechef.com/images/self-learning/icons/stacks-and-queues.svg',
     '9ba179ed-d26d-4828-a0f6-8836c2063992',
     '9ba179ed-d26d-4828-a0f6-8836c2063992',
     false);

INSERT INTO public.organization(id, description, name, created_at, updated_at, is_deleted)
VALUES
	 ('9ba179ed-d26d-4828-a0f6-8836c2063992',NULL,'Code Dynamite','2024-04-15 18:37:44.08878+07','2024-04-15 18:37:44.08878+07',false),
	 ('08b65a39-394f-4977-a5fa-3fe145b620f8',NULL,'moodle2','2024-04-15 18:09:29.488151+07','2024-04-15 18:09:29.488151+07',false),
	 ('3ead3b08-afdd-442f-b544-fdbd86eaa186',NULL,'Code Dynamite','2024-04-15 18:09:40.033204+07','2024-04-15 18:09:40.033204+07',false);

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

INSERT INTO public.topic_programming_language(topic_id, programming_language_id)
VALUES
    ('9ba179ed-d26d-4828-a0f6-8836c2063992', 'd27a8b36-83fd-450d-a7c3-bf3eef7b1468'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb92', 'c95d5c7d-cadf-42cc-afdc-968211ae3720'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb46', 'c95d5c7d-cadf-42cc-afdc-968211ae3720'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb47', 'c95d5c7d-cadf-42cc-afdc-968211ae3720'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb48', 'c95d5c7d-cadf-42cc-afdc-968211ae3720'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb48', 'd27a8b36-83fd-450d-a7c3-bf3eef7b1468'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb48', 'cc69d904-ba4e-44fb-a0b5-8170e30bac39'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb49', 'c95d5c7d-cadf-42cc-afdc-968211ae3720');

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
--    ('d215b5f8-0249-4dc5-89a3-51fd148cfb15', 'b6484e21-6937-489c-b031-b71767994221', 'Correct', 'print(Hello World)', 1), câu hỏi code thì làm j có ở đây
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb64', 'b6484e21-6937-489c-b031-b71767994233', 'Wrong', 'Essat 1', 1),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb86', 'b6484e21-6937-489c-b031-b71767994233', 'Wow', 'p p p)', 1),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb25', 'b6484e21-6937-489c-b031-b71767994233', 'Good', 'essay t12', 1),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb69', 'b6484e21-6937-489c-b031-b71767994132', 'Bad', 'short answer t12', 1),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfe63', 'b6484e21-6937-489c-b031-b71767994735', 'Hihi', 'multi 1', 1),
    ('d215b5f8-0249-4dc5-89a3-51fd148cff62', 'b6484e21-6937-489c-b031-b71767994735', 'huhu', 'multi 2', 1),
    ('d215b5f8-0249-4dc5-89a3-51fd148cff20', 'b6484e21-6937-489c-b031-b71767994735', 'haha', 'multi 3', 1);

-- INSERT INTO public.qtype_code_question(id, question_id, dsl_template, name, max_grade)
-- values
--     ('3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', 'b6484e21-6937-489c-b031-b71767994221', '', 'Tổng 2 số', '10');

-- INSERT INTO public.qtype_code_question(id, question_id, dsl_template)
-- VALUES
--     ('27549d54-4a3a-4be4-9875-eab03f88ba6d', 'b6484e21-6937-489c-b031-b71767994736', 'print(Hello World)'),
--     ('27549d54-4a3a-4be4-9875-eab03f88ba7d', 'b6484e21-6937-489c-b031-b71767994737', 'print(Hello World)'),
--     ('27549d54-4a3a-4be4-9875-eab03f88ba8d', 'b6484e21-6937-489c-b031-b71767994738', 'print(Hello World)'),
--     ('27549d54-4a3a-4be4-9875-eab03f88ba9d', 'b6484e21-6937-489c-b031-b71767994739', 'print(Hello World)'),
--     ('27549d54-4a3a-4be4-9875-eab03f88ba0d', 'b6484e21-6937-489c-b031-b71767994740', 'print(Hello World)'),
--     ('27549d54-4a3a-4be4-9875-eab03f88ba1a', 'b6484e21-6937-489c-b031-b71767994741', 'print(Hello World)'),
--     ('27549d54-4a3a-4be4-9875-eab03f88ba2a', 'b6484e21-6937-489c-b031-b71767994742', 'print(Hello World)'),
--     ('27549d54-4a3a-4be4-9875-eab03f88ba3a', 'b6484e21-6937-489c-b031-b71767994743', 'print(Hello World)'),
--     ('27549d54-4a3a-4be4-9875-eab03f88ba4a', 'b6484e21-6937-489c-b031-b71767994744', 'print(Hello World)'),
--     ('27549d54-4a3a-4be4-9875-eab03f88ba5a', 'b6484e21-6937-489c-b031-b71767994745', 'print(Hello World)'),
--     ('27549d54-4a3a-4be4-9875-eab03f88ba6a', 'b6484e21-6937-489c-b031-b71767994746', 'print(Hello World)'),
--     ('27549d54-4a3a-4be4-9875-eab03f88ba7a', 'b6484e21-6937-489c-b031-b71767994747', 'print(Hello World)'),
--     ('27549d54-4a3a-4be4-9875-eab03f88ba8a', 'b6484e21-6937-489c-b031-b71767994748', 'print(Hello World)'),
--     ('27549d54-4a3a-4be4-9875-eab03f88ba9a', 'b6484e21-6937-489c-b031-b71767994749', 'print(Hello World)'),
--     ('27549d54-4a3a-4be4-9875-eab03f88ba5b', 'b6484e21-6937-489c-b031-b71767994750', 'print(Hello World)'),
--     ('27549d54-4a3a-4be4-9875-eab03f88ba6b', 'b6484e21-6937-489c-b031-b71767994751', 'print(Hello World)'),
--     ('27549d54-4a3a-4be4-9875-eab03f88ba7b', 'b6484e21-6937-489c-b031-b71767994752', 'print(Hello World)'),
--     ('27549d54-4a3a-4be4-9875-eab03f88ba8b', 'b6484e21-6937-489c-b031-b71767994753', 'print(Hello World)');

INSERT INTO public.qtype_code_question(id, question_id, dsl_template)
VALUES
    ('3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', 'b6484e21-6937-489c-b031-b71767994221', 'template'),
    ('f6d7b882-9399-4bc3-baad-6350285bfa78', 'b6484e21-6937-489c-b031-b71767994736', 'template'),
    ('48caf2c9-8c81-49a7-b656-c3b024a798c3', 'b6484e21-6937-489c-b031-b71767994737', 'template'),
    ('2589a5b7-94c9-4a76-86d9-576718ca63c3', 'b6484e21-6937-489c-b031-b71767994738', 'template'),
    ('2dbe940c-8d25-4a88-a283-d79785c1ea2a', 'b6484e21-6937-489c-b031-b71767994739', 'template'),
    ('07bf0b32-09ce-47d0-b4e1-c0ba35799b43', 'b6484e21-6937-489c-b031-b71767994740', 'template'),
    ('2f3b15cc-219f-47eb-8d17-702e89afb86a', 'b6484e21-6937-489c-b031-b71767994741', 'template'),
    ('fe0a658d-7ce9-4524-b388-84539a34a521', 'b6484e21-6937-489c-b031-b71767994742', 'template'),
    ('1374d22a-b27b-4d3d-9ad4-b613e1f1e253', 'b6484e21-6937-489c-b031-b71767994743', 'template'),
    ('06d71d03-f5ba-4a89-9083-596ef649ade9', 'b6484e21-6937-489c-b031-b71767994744', 'template'),
    ('b1ae32db-17e6-4fdb-991b-160e95721562', 'b6484e21-6937-489c-b031-b71767994745', 'template'),
    ('058cdf70-3cc5-4a99-9edd-edfa0325c207', 'b6484e21-6937-489c-b031-b71767994746', 'template'),
    ('51981528-01ff-491a-bc7b-a24aedfb0363', 'b6484e21-6937-489c-b031-b71767994747', 'template'),
    ('6181a38b-2b06-4a60-ad5f-750780d79e3e', 'b6484e21-6937-489c-b031-b71767994748', 'template'),
    ('22427527-053c-4602-a519-9e52cb5f2366', 'b6484e21-6937-489c-b031-b71767994749', 'template'),
    ('cd39d755-41f1-452f-a0df-09c64c7a67cf', 'b6484e21-6937-489c-b031-b71767994750', 'template'),
    ('d49496bb-87a5-483f-9597-564ad6ee0305', 'b6484e21-6937-489c-b031-b71767994751', 'template'),
    ('4be91526-365b-4e50-99ae-75ba2a87ba08', 'b6484e21-6937-489c-b031-b71767994752', 'template'),
    ('4be91526-365b-4e50-99ae-75ba2a87ba09', 'b6484e21-6937-489c-b031-b71767994753', 'template');

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
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb16', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'Intermediate Python', 'This course is designed for intermediate Python programmers who want to enhance their skills and knowledge. It covers advanced topics such as object-oriented programming, data structures, algorithms, and more.', 'INTERMEDIATE', '2024-04-15 18:09:29.488151+07', '2024-04-15 18:09:29.488151+07', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 4),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb17', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'Advanced Python', 'This course is designed for experienced Python programmers who want to master advanced Python concepts and techniques. It covers topics such as decorators, generators, metaclasses, and more.', 'ADVANCED', '2024-04-15 18:09:29.488151+07', '2024-04-15 18:09:29.488151+07', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 4),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb18', 'd215b5f8-0249-4dc5-89a3-51fd148cfb46', 'Learn Java', 'This course is designed for beginners who want to learn Java programming from scratch. It covers the basics of Java programming, including data types, control structures, functions, and more.', 'BASIC', '2024-04-15 18:09:29.488151+07', '2024-04-15 18:09:29.488151+07', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 0),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb19', 'd215b5f8-0249-4dc5-89a3-51fd148cfb46', 'Intermediate Java', 'This course is designed for intermediate Java programmers who want to enhance their skills and knowledge. It covers advanced topics such as object-oriented programming, data structures, algorithms, and more.', 'INTERMEDIATE', '2024-04-15 18:09:29.488151+07', '2024-04-15 18:09:29.488151+07', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 0),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb20', 'd215b5f8-0249-4dc5-89a3-51fd148cfb46', 'Advanced Java', 'This course is designed for experienced Java programmers who want to master advanced Java concepts and techniques. It covers topics such as decorators, generators, metaclasses, and more.', 'ADVANCED', '2024-04-15 18:09:29.488151+07', '2024-04-15 18:09:29.488151+07', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 0),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb21', 'd215b5f8-0249-4dc5-89a3-51fd148cfb48', 'Stacks and Queues', 'This course is designed for beginners who want to learn about stacks and queues. It covers the basics of stacks and queues, including their implementation, operations, and applications.', 'BASIC', '2024-04-15 18:09:29.488151+07', '2024-04-15 18:09:29.488151+07', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 0),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb22', 'd215b5f8-0249-4dc5-89a3-51fd148cfb48', 'Linked Lists', 'This course is designed for intermediate programmers who want to learn about linked lists. It covers the basics of linked lists, including their implementation, operations, and applications.', 'INTERMEDIATE', '2024-04-15 18:09:29.488151+07', '2024-04-15 18:09:29.488151+07', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 0),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb23', 'd215b5f8-0249-4dc5-89a3-51fd148cfb48', 'Binary Trees', 'This course is designed for experienced programmers who want to learn about binary trees. It covers the basics of binary trees, including their implementation, operations, and applications.', 'ADVANCED', '2024-04-15 18:09:29.488151+07', '2024-04-15 18:09:29.488151+07', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 0);

INSERT INTO public.certificate_course_user(certificate_course_id, user_id)
VALUES
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb15', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb16', 'b029f559-52a8-4699-b595-71161498ed8c'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb17', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb18', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb19', 'b029f559-52a8-4699-b595-71161498ed8c'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb20', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb21', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb22', 'b029f559-52a8-4699-b595-71161498ed8c'),
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

-- INSERT INTO public.chapter_question(id, chapter_id, question_id)
-- VALUES
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb15', 'd215b5f8-0249-4dc5-89a3-51fd148cfb15', 'b6484e21-6937-489c-b031-b71767994736'),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb16', 'd215b5f8-0249-4dc5-89a3-51fd148cfb15', 'b6484e21-6937-489c-b031-b71767994737'),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb17', 'd215b5f8-0249-4dc5-89a3-51fd148cfb15', 'b6484e21-6937-489c-b031-b71767994738'),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb18', 'd215b5f8-0249-4dc5-89a3-51fd148cfb16', 'b6484e21-6937-489c-b031-b71767994739'),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb19', 'd215b5f8-0249-4dc5-89a3-51fd148cfb16', 'b6484e21-6937-489c-b031-b71767994740'),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb20', 'd215b5f8-0249-4dc5-89a3-51fd148cfb16', 'b6484e21-6937-489c-b031-b71767994741'),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb21', 'd215b5f8-0249-4dc5-89a3-51fd148cfb17', 'b6484e21-6937-489c-b031-b71767994742'),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb22', 'd215b5f8-0249-4dc5-89a3-51fd148cfb17', 'b6484e21-6937-489c-b031-b71767994743'),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb23', 'd215b5f8-0249-4dc5-89a3-51fd148cfb17', 'b6484e21-6937-489c-b031-b71767994744'),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb24', 'd215b5f8-0249-4dc5-89a3-51fd148cfb18', 'b6484e21-6937-489c-b031-b71767994745'),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb25', 'd215b5f8-0249-4dc5-89a3-51fd148cfb18', 'b6484e21-6937-489c-b031-b71767994746'),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb26', 'd215b5f8-0249-4dc5-89a3-51fd148cfb18', 'b6484e21-6937-489c-b031-b71767994747'),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb27', 'd215b5f8-0249-4dc5-89a3-51fd148cfb19', 'b6484e21-6937-489c-b031-b71767994748'),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb28', 'd215b5f8-0249-4dc5-89a3-51fd148cfb19', 'b6484e21-6937-489c-b031-b71767994749');

-- resource_type: 'CODE', 'LESSON', 'VIDEO'
-- Generate me 5 resources for each chapter with mixed resource types
INSERT INTO public.chapter_resource(id, no, chapter_id, resource_type, title, question_id, lesson_html, youtube_video_url)
VALUES
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb15', 1, 'd215b5f8-0249-4dc5-89a3-51fd148cfb15', 'CODE', 'Question 1', 'b6484e21-6937-489c-b031-b71767994221', NULL, NULL),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb16', 2, 'd215b5f8-0249-4dc5-89a3-51fd148cfb15', 'LESSON', 'This is a lesson on Python programming.', NULL, '<p>This is a lesson on Python programming.</p>', NULL),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb17', 3, 'd215b5f8-0249-4dc5-89a3-51fd148cfb15', 'VIDEO', 'Video on Python programming', NULL, NULL, 'https://youtu.be/rfscVS0vtbw?si=nAn_wxmKoIdCMwGy'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb18', 4, 'd215b5f8-0249-4dc5-89a3-51fd148cfb15', 'CODE', 'Question 2', 'b6484e21-6937-489c-b031-b71767994737', NULL, NULL),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb19', 5, 'd215b5f8-0249-4dc5-89a3-51fd148cfb15', 'LESSON', 'This is a lesson on Python programming.', NULL, '<p>This is a lesson on Python programming.</p>', NULL),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb20', 6, 'd215b5f8-0249-4dc5-89a3-51fd148cfb15', 'VIDEO', 'Video on Python programming', NULL, NULL, 'https://youtu.be/rfscVS0vtbw?si=nAn_wxmKoIdCMwGy'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb21', 1, 'd215b5f8-0249-4dc5-89a3-51fd148cfb16', 'CODE', 'Question 1', 'b6484e21-6937-489c-b031-b71767994738', NULL, NULL),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb22', 2, 'd215b5f8-0249-4dc5-89a3-51fd148cfb16', 'LESSON', 'This is a lesson on Python programming.', NULL, '<p>This is a lesson on Python programming.</p>', NULL),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb23', 3, 'd215b5f8-0249-4dc5-89a3-51fd148cfb16', 'VIDEO', 'Video on Python programming', NULL, NULL, 'https://youtu.be/rfscVS0vtbw?si=nAn_wxmKoIdCMwGy'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb24', 4, 'd215b5f8-0249-4dc5-89a3-51fd148cfb16', 'CODE', 'Question 2', 'b6484e21-6937-489c-b031-b71767994739', NULL, NULL),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb25', 5, 'd215b5f8-0249-4dc5-89a3-51fd148cfb16', 'LESSON', 'This is a lesson on Python programming.', NULL, '<p>This is a lesson on Python programming.</p>', NULL),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb26', 6, 'd215b5f8-0249-4dc5-89a3-51fd148cfb16', 'VIDEO', 'Video on Python programming', NULL, NULL, 'https://youtu.be/rfscVS0vtbw?si=nAn_wxmKoIdCMwGy'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb27', 1, 'd215b5f8-0249-4dc5-89a3-51fd148cfb17', 'CODE', 'Question 1', 'b6484e21-6937-489c-b031-b71767994740', NULL, NULL),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb28', 2, 'd215b5f8-0249-4dc5-89a3-51fd148cfb17', 'LESSON', 'This is a lesson on Python programming.', NULL, '<p>This is a lesson on Python programming.</p>', NULL),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb29', 3, 'd215b5f8-0249-4dc5-89a3-51fd148cfb17', 'VIDEO', 'Video on Python programming', NULL, NULL, 'https://youtu.be/rfscVS0vtbw?si=nAn_wxmKoIdCMwGy'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb30', 4, 'd215b5f8-0249-4dc5-89a3-51fd148cfb17', 'CODE', 'Question 2', 'b6484e21-6937-489c-b031-b71767994741', NULL, NULL),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb31', 5, 'd215b5f8-0249-4dc5-89a3-51fd148cfb17', 'LESSON', 'This is a lesson on Python programming.', NULL, '<p>This is a lesson on Python programming.</p>', NULL),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb32', 6, 'd215b5f8-0249-4dc5-89a3-51fd148cfb17', 'VIDEO', 'Video on Python programming', NULL, NULL, 'https://youtu.be/rfscVS0vtbw?si=nAn_wxmKoIdCMwGy'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb33', 1, 'd215b5f8-0249-4dc5-89a3-51fd148cfb18', 'CODE', 'Question 1', 'b6484e21-6937-489c-b031-b71767994221', NULL, NULL),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb34', 2, 'd215b5f8-0249-4dc5-89a3-51fd148cfb18', 'LESSON', 'This is a lesson on Python programming.', NULL, '<p>This is a lesson on Python programming.</p>', NULL),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb35', 3, 'd215b5f8-0249-4dc5-89a3-51fd148cfb18', 'VIDEO', 'Video on Python programming', NULL, NULL, 'https://youtu.be/rfscVS0vtbw?si=nAn_wxmKoIdCMwGy'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb36', 4, 'd215b5f8-0249-4dc5-89a3-51fd148cfb18', 'CODE', 'Question 2', 'b6484e21-6937-489c-b031-b71767994743', NULL, NULL),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb37', 5, 'd215b5f8-0249-4dc5-89a3-51fd148cfb18', 'LESSON', 'This is a lesson on Python programming.', NULL, '<p>This is a lesson on Python programming.</p>', NULL),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb38', 6, 'd215b5f8-0249-4dc5-89a3-51fd148cfb18', 'VIDEO', 'Video on Python programming', NULL, NULL, 'https://youtu.be/rfscVS0vtbw?si=nAn_wxmKoIdCMwGy'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb39', 1, 'd215b5f8-0249-4dc5-89a3-51fd148cfb19', 'CODE', 'Question 1', 'b6484e21-6937-489c-b031-b71767994744', NULL, NULL),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb40', 2, 'd215b5f8-0249-4dc5-89a3-51fd148cfb19', 'LESSON', 'This is a lesson on Python programming.', NULL, '<p>This is a lesson on Python programming.</p>', NULL),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb41', 3, 'd215b5f8-0249-4dc5-89a3-51fd148cfb19', 'VIDEO', 'Video on Python programming', NULL, NULL, 'https://youtu.be/rfscVS0vtbw?si=nAn_wxmKoIdCMwGy');


--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb15', 'd215b5f8-0249-4dc5-89a3-51fd148cfb15', 'CODE', 'b6484e21-6937-489c-b031-b71767994736', NULL, NULL),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb16', 'd215b5f8-0249-4dc5-89a3-51fd148cfb15', 'LESSON', NULL, 'This is a lesson on Python programming.', NULL),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb17', 'd215b5f8-0249-4dc5-89a3-51fd148cfb15', 'VIDEO', NULL, NULL, 'https://youtu.be/rfscVS0vtbw?si=nAn_wxmKoIdCMwGy'),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb18', 'd215b5f8-0249-4dc5-89a3-51fd148cfb15', 'CODE', 'b6484e21-6937-489c-b031-b71767994737', NULL, NULL),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb19', 'd215b5f8-0249-4dc5-89a3-51fd148cfb15', 'LESSON', NULL, 'This is a lesson on Python programming.', NULL),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb20', 'd215b5f8-0249-4dc5-89a3-51fd148cfb15', 'VIDEO', NULL, NULL, 'https://youtu.be/rfscVS0vtbw?si=nAn_wxmKoIdCMwGy'),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb21', 'd215b5f8-0249-4dc5-89a3-51fd148cfb16', 'CODE', 'b6484e21-6937-489c-b031-b71767994738', NULL, NULL),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb22', 'd215b5f8-0249-4dc5-89a3-51fd148cfb16', 'LESSON', NULL, 'This is a lesson on Python programming.', NULL),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb23', 'd215b5f8-0249-4dc5-89a3-51fd148cfb16', 'VIDEO', NULL, NULL, 'https://youtu.be/rfscVS0vtbw?si=nAn_wxmKoIdCMwGy'),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb24', 'd215b5f8-0249-4dc5-89a3-51fd148cfb16', 'CODE', 'b6484e21-6937-489c-b031-b71767994739', NULL, NULL),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb25', 'd215b5f8-0249-4dc5-89a3-51fd148cfb16', 'LESSON', NULL, 'This is a lesson on Python programming.', NULL),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb26', 'd215b5f8-0249-4dc5-89a3-51fd148cfb16', 'VIDEO', NULL, NULL, 'https://youtu.be/rfscVS0vtbw?si=nAn_wxmKoIdCMwGy'),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb27', 'd215b5f8-0249-4dc5-89a3-51fd148cfb17', 'CODE', 'b6484e21-6937-489c-b031-b71767994740', NULL, NULL),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb28', 'd215b5f8-0249-4dc5-89a3-51fd148cfb17', 'LESSON', NULL, 'This is a lesson on Python programming.', NULL),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb29', 'd215b5f8-0249-4dc5-89a3-51fd148cfb17', 'VIDEO', NULL, NULL, 'https://youtu.be/rfscVS0vtbw?si=nAn_wxmKoIdCMwGy'),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb30', 'd215b5f8-0249-4dc5-89a3-51fd148cfb17', 'CODE', 'b6484e21-6937-489c-b031-b71767994741', NULL, NULL),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb31', 'd215b5f8-0249-4dc5-89a3-51fd148cfb17', 'LESSON', NULL, 'This is a lesson on Python programming.', NULL),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb32', 'd215b5f8-0249-4dc5-89a3-51fd148cfb17', 'VIDEO', NULL, NULL, 'https://youtu.be/rfscVS0vtbw?si=nAn_wxmKoIdCMwGy'),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb33', 'd215b5f8-0249-4dc5-89a3-51fd148cfb18', 'CODE', 'b6484e21-6937-489c-b031-b71767994742', NULL, NULL),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb34', 'd215b5f8-0249-4dc5-89a3-51fd148cfb18', 'LESSON', NULL, 'This is a lesson on Python programming.', NULL),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb35', 'd215b5f8-0249-4dc5-89a3-51fd148cfb18', 'VIDEO', NULL, NULL, 'https://youtu.be/rfscVS0vtbw?si=nAn_wxmKoIdCMwGy'),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb36', 'd215b5f8-0249-4dc5-89a3-51fd148cfb18', 'CODE', 'b6484e21-6937-489c-b031-b71767994743', NULL, NULL),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb37', 'd215b5f8-0249-4dc5-89a3-51fd148cfb18', 'LESSON', NULL, 'This is a lesson on Python programming.', NULL),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb38', 'd215b5f8-0249-4dc5-89a3-51fd148cfb18', 'VIDEO', NULL, NULL, 'https://youtu.be/rfscVS0vtbw?si=nAn_wxmKoIdCMwGy'),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb39', 'd215b5f8-0249-4dc5-89a3-51fd148cfb19', 'CODE', 'b6484e21-6937-489c-b031-b71767994744', NULL, NULL),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb40', 'd215b5f8-0249-4dc5-89a3-51fd148cfb19', 'LESSON', NULL, 'This is a lesson on Python programming.', NULL),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb41', 'd215b5f8-0249-4dc5-89a3-51fd148cfb19', 'VIDEO', NULL, NULL, 'https://youtu.be/rfscVS0vtbw?si=nAn_wxmKoIdCMwGy');



insert into code_submission (id, code_question_id, user_id, programming_language_id, source_code, grade, created_at, pass) values ('a2e5afa6-f0c8-422e-8895-a706d1a1d6c1', '3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'c95d5c7d-cadf-42cc-afdc-968211ae3720', 'Y2xhc3MgUmVzdWx0IHsKICAgIHB1YmxpYyBzdGF0aWMgaW50IHN1bU9mVHdvSW50ZWdlcnMoaW50IGEsIGludCBiKSB7CiAgICAgICAgcmV0dXJuIGEgKyBiOwogICAgfQp9', 10, CURRENT_TIMESTAMP, true);
insert into code_submission (id, code_question_id, user_id, programming_language_id, source_code, grade, created_at, pass) values ('4a177c20-9487-48f6-b057-6d981e66b6cf', '3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'c95d5c7d-cadf-42cc-afdc-968211ae3720', 'Y2xhc3MgUmVzdWx0IHsKICAgIHB1YmxpYyBzdGF0aWMgaW50IHN1bU9mVHdvSW50ZWdlcnMoaW50IGEsIGludCBiKSB7CiAgICAgICAgcmV0dXJuIGEgKyBiOwogICAgfQp9', 10, CURRENT_TIMESTAMP, true);
insert into code_submission (id, code_question_id, user_id, programming_language_id, source_code, grade, created_at, pass) values ('df32ebfe-ec52-42c6-9447-cdc5280d5701', '3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'cba00cd8-8114-4bc4-84e6-499c27467978', 'aW50IHN1bU9mVHdvSW50ZWdlcnMoaW50IGEsIGludCBiKXsKICAgIHJldHVybiBhICsgYjsKfQ==', 10, CURRENT_TIMESTAMP, true);
insert into code_submission (id, code_question_id, user_id, programming_language_id, source_code, grade, created_at, pass) values ('0b4bccfc-411f-499d-b470-9574152269aa', '3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', 'b029f559-52a8-4699-b595-71161498ed8c', 'c95d5c7d-cadf-42cc-afdc-968211ae3720', 'Y2xhc3MgUmVzdWx0IHsKICAgIHB1YmxpYyBzdGF0aWMgaW50IHN1bU9mVHdvSW50ZWdlcnMoaW50IGEsIGludCBiKSB7CiAgICAgICAgcmV0dXJuIGEgKyBiOwogICAgfQp9', 0, CURRENT_TIMESTAMP, false);
insert into code_submission (id, code_question_id, user_id, programming_language_id, source_code, grade, created_at, pass) values ('186c1fea-9706-4399-991a-8c9ff7d97b9a', '3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', 'c95d5c7d-cadf-42cc-afdc-968211ae3720', 'Y2xhc3MgUmVzdWx0IHsKICAgIHB1YmxpYyBzdGF0aWMgaW50IHN1bU9mVHdvSW50ZWdlcnMoaW50IGEsIGludCBiKSB7CiAgICAgICAgcmV0dXJuIGEgKyBiOwogICAgfQp9', 10, CURRENT_TIMESTAMP, true);

-- INSERT INTO public.code_submission(id, user_id, code_question_id, programming_language_id, source_code, grade, pass)
-- VALUES
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb15', '9ba179ed-d26d-4828-a0f6-8836c2063992', '27549d54-4a3a-4be4-9875-eab03f88ba5a', 'd27a8b36-83fd-450d-a7c3-bf3eef7b1468', 'print("Hello, World!")', 0, false),
--     ('27549d54-4a3a-4be4-9875-eab03f88ba5a', '9ba179ed-d26d-4828-a0f6-8836c2063992', '27549d54-4a3a-4be4-9875-eab03f88ba5a', 'd27a8b36-83fd-450d-a7c3-bf3eef7b1468', 'print("Hello, World!")', 1, true),
--     ('27549d54-4a3a-4be4-9875-eab03f88ba5b', '9ba179ed-d26d-4828-a0f6-8836c2063992', '27549d54-4a3a-4be4-9875-eab03f88ba5a', 'd27a8b36-83fd-450d-a7c3-bf3eef7b1468', 'print("Hello, World!")', 2, true),
--     ('27549d54-4a3a-4be4-9875-eab03f88ba5c', '9ba179ed-d26d-4828-a0f6-8836c2063992', '27549d54-4a3a-4be4-9875-eab03f88ba6a', 'd27a8b36-83fd-450d-a7c3-bf3eef7b1468', 'print("Hello, World!")', 0, false),
--     ('27549d54-4a3a-4be4-9875-eab03f88ba5d', '9ba179ed-d26d-4828-a0f6-8836c2063992', '27549d54-4a3a-4be4-9875-eab03f88ba6a', 'd27a8b36-83fd-450d-a7c3-bf3eef7b1468', 'print("Hello, World!")', 1, true),
--     ('27549d54-4a3a-4be4-9875-eab03f88ba5e', '9ba179ed-d26d-4828-a0f6-8836c2063992', '27549d54-4a3a-4be4-9875-eab03f88ba6a', 'd27a8b36-83fd-450d-a7c3-bf3eef7b1468', 'print("Hello, World!")', 0, false),
--     ('27549d54-4a3a-4be4-9875-eab03f88ba5f', '9ba179ed-d26d-4828-a0f6-8836c2063992', '27549d54-4a3a-4be4-9875-eab03f88ba7a', 'd27a8b36-83fd-450d-a7c3-bf3eef7b1468', 'print("Hello, World!")', 0, false),
--     ('27549d54-4a3a-4be4-9875-eab03f88ba6a', '9ba179ed-d26d-4828-a0f6-8836c2063992', '27549d54-4a3a-4be4-9875-eab03f88ba8a', 'd27a8b36-83fd-450d-a7c3-bf3eef7b1468', 'print("Hello, World!")', 1, false),
--     ('27549d54-4a3a-4be4-9875-eab03f88ba6b', '9ba179ed-d26d-4828-a0f6-8836c2063992', '27549d54-4a3a-4be4-9875-eab03f88ba9a', 'd27a8b36-83fd-450d-a7c3-bf3eef7b1468', 'print("Hello, World!")', 0, false),
--     ('27549d54-4a3a-4be4-9875-eab03f88ba6c', '9ba179ed-d26d-4828-a0f6-8836c2063992', '27549d54-4a3a-4be4-9875-eab03f88ba6a', 'd27a8b36-83fd-450d-a7c3-bf3eef7b1468', 'print("Hello, World!")', 0, false),
--     ('27549d54-4a3a-4be4-9875-eab03f88ba6d', '9ba179ed-d26d-4828-a0f6-8836c2063992', '27549d54-4a3a-4be4-9875-eab03f88ba6a', 'd27a8b36-83fd-450d-a7c3-bf3eef7b1468', 'print("Hello, World!")', 0, false);

INSERT INTO public.code_submission_certificate_course(code_submission_id, certificate_course_id)
VALUES
    ('a2e5afa6-f0c8-422e-8895-a706d1a1d6c1', 'd215b5f8-0249-4dc5-89a3-51fd148cfb16'),
    ('4a177c20-9487-48f6-b057-6d981e66b6cf', 'd215b5f8-0249-4dc5-89a3-51fd148cfb16'),
    ('df32ebfe-ec52-42c6-9447-cdc5280d5701', 'd215b5f8-0249-4dc5-89a3-51fd148cfb16'),
    ('0b4bccfc-411f-499d-b470-9574152269aa', 'd215b5f8-0249-4dc5-89a3-51fd148cfb16'),
    ('186c1fea-9706-4399-991a-8c9ff7d97b9a', 'd215b5f8-0249-4dc5-89a3-51fd148cfb16');

INSERT INTO public.contest(id, name, description, prizes, rules, scoring, thumbnail_url, start_time, end_time, created_by, updated_by, is_public)
VALUES
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb15', 'Python Contest',
     '<h3 style="text-align:start"><span style="font-size:24px"><span style="font-family:-apple-system,BlinkMacSystemFont,&quot;Segoe UI&quot;,&quot;PingFang SC&quot;,&quot;Hiragino Sans GB&quot;,&quot;Microsoft YaHei&quot;,&quot;Helvetica Neue&quot;,Helvetica,Arial,sans-serif,&quot;Apple Color Emoji&quot;,&quot;Segoe UI Emoji&quot;,&quot;Segoe UI Symbol&quot;"><span style="color:rgba(0, 0, 0, 0.85)"><span style="background-color:#fafafa">Welcome to the Python Contest Batch the code #387</span></span></span></span></h3>',
     '<ol><li>1st Place: $1000</li><li>2nd Place: $500</li><li>3rd Place: $250</li></ol>',
     '<ol><li>1. Participants must submit their solutions before the end time.</li><li>2. Participants must follow the contest rules and guidelines.</li><li>3. Participants must not cheat or plagiarize.</li></ol>',
     '- Each challenge has a pre-determined score.
          - A participant’s score depends on the number of test cases a participant’s code submission successfully passes.
          - If a participant submits more than one solution per challenge, then the participant’s score will reflect the highest score achieved.
          - Participants are ranked by score. If two or more participants achieve the same score, then the tie is broken by the total time taken to submit the last solution resulting in a higher score',
     'https://leetcode.com/_next/static/images/weekly-default-553ede7bcc8e1b4a44c28a9e4a32068c.png', '2024-05-20 18:09:29.488151+07', '2024-09-10 18:09:29.488151+07', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', true),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb16', 'Java Contest',
     '<h3 style="text-align:start"><span style="font-size:24px"><span style="font-family:-apple-system,BlinkMacSystemFont,&quot;Segoe UI&quot;,&quot;PingFang SC&quot;,&quot;Hiragino Sans GB&quot;,&quot;Microsoft YaHei&quot;,&quot;Helvetica Neue&quot;,Helvetica,Arial,sans-serif,&quot;Apple Color Emoji&quot;,&quot;Segoe UI Emoji&quot;,&quot;Segoe UI Symbol&quot;"><span style="color:rgba(0, 0, 0, 0.85)"><span style="background-color:#fafafa">Welcome to the Java Contest Batch the code #387</span></span></span></span></h3>',
     '- Prizes are optional. You may add any prizes that you would like to offer here.',
     '<ol><li>1. Participants must submit their solutions before the end time.</li><li>2. Participants must follow the contest rules and guidelines.</li><li>3. Participants must not cheat or plagiarize.</li></ol>',
     '- Each challenge has a pre-determined score.
          - A participant’s score depends on the number of test cases a participant’s code submission successfully passes.
          - If a participant submits more than one solution per challenge, then the participant’s score will reflect the highest score achieved.
          - Participants are ranked by score. If two or more participants achieve the same score, then the tie is broken by the total time taken to submit the last solution resulting in a higher score',
     'https://leetcode.com/_next/static/images/biweekly-default-f5a8fc3be85b6c9175207fd8fd855d47.png', '2024-09-15 18:09:29.488151+07', '2024-10-15 18:09:29.488151+07', 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', true),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb17', 'Data Structures Contest',
     '<h3 style="text-align:start"><span style="font-size:24px"><span style="font-family:-apple-system,BlinkMacSystemFont,&quot;Segoe UI&quot;,&quot;PingFang SC&quot;,&quot;Hiragino Sans GB&quot;,&quot;Microsoft YaHei&quot;,&quot;Helvetica Neue&quot;,Helvetica,Arial,sans-serif,&quot;Apple Color Emoji&quot;,&quot;Segoe UI Emoji&quot;,&quot;Segoe UI Symbol&quot;"><span style="color:rgba(0, 0, 0, 0.85)"><span style="background-color:#fafafa">Welcome to the Data Structures Contest Batch the code #387</span></span></span></span></h3>','<ol><li>1st Place: $1000</li><li>2nd Place: $500</li><li>3rd Place: $250</li></ol>',
     '<ol><li>1. Participants must submit their solutions before the end time.</li><li>2. Participants must follow the contest rules and guidelines.</li><li>3. Participants must not cheat or plagiarize.</li></ol>',
     '- Each challenge has a pre-determined score.
          - A participant’s score depends on the number of test cases a participant’s code submission successfully passes.
          - If a participant submits more than one solution per challenge, then the participant’s score will reflect the highest score achieved.
          - Participants are ranked by score. If two or more participants achieve the same score, then the tie is broken by the total time taken to submit the last solution resulting in a higher score',
     'https://assets.leetcode.com/contest/weekly-contest-291/card_img_1654267951.png', '2024-01-15 18:09:29.488151+07', null, '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', true),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb18', 'Algorithms Contest',
        '<h3 style="text-align:start"><span style="font-size:24px"><span style="font-family:-apple-system,BlinkMacSystemFont,&quot;Segoe UI&quot;,&quot;PingFang SC&quot;,&quot;Hiragino Sans GB&quot;,&quot;Microsoft YaHei&quot;,&quot;Helvetica Neue&quot;,Helvetica,Arial,sans-serif,&quot;Apple Color Emoji&quot;,&quot;Segoe UI Emoji&quot;,&quot;Segoe UI Symbol&quot;"><span style="color:rgba(0, 0, 0, 0.85)"><span style="background-color:#fafafa">Welcome to the Algorithms Contest Batch the code #387</span></span></span></span></h3>','<ol><li>1st Place: $1000</li><li>2nd Place: $500</li><li>3rd Place: $250</li></ol>',
     '<ol><li>1. Participants must submit their solutions before the end time.</li><li>2. Participants must follow the contest rules and guidelines.</li><li>3. Participants must not cheat or plagiarize.</li></ol>',
     '- Each challenge has a pre-determined score.
          - A participant’s score depends on the number of test cases a participant’s code submission successfully passes.
          - If a participant submits more than one solution per challenge, then the participant’s score will reflect the highest score achieved.
          - Participants are ranked by score. If two or more participants achieve the same score, then the tie is broken by the total time taken to submit the last solution resulting in a higher score',
     'https://assets.leetcode.com/contest/weekly-contest-291/card_img_1654267951.png', '2024-01-15 18:09:29.488151+07', '2024-04-15 18:09:29.488151+07', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', false),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb19', 'Python Contest',
        '<h3 style="text-align:start"><span style="font-size:24px"><span style="font-family:-apple-system,BlinkMacSystemFont,&quot;Segoe UI&quot;,&quot;PingFang SC&quot;,&quot;Hiragino Sans GB&quot;,&quot;Microsoft YaHei&quot;,&quot;Helvetica Neue&quot;,Helvetica,Arial,sans-serif,&quot;Apple Color Emoji&quot;,&quot;Segoe UI Emoji&quot;,&quot;Segoe UI Symbol&quot;"><span style="color:rgba(0, 0, 0, 0.85)"><span style="background-color:#fafafa">Welcome to the Python Contest Batch the code #387</span></span></span></span></h3>',
        '<ol><li>1st Place: $1000</li><li>2nd Place: $500</li><li>3rd Place: $250</li></ol>',
        '<ol><li>1. Participants must submit their solutions before the end time.</li><li>2. Participants must follow the contest rules and guidelines.</li><li>3. Participants must not cheat or plagiarize.</li></ol>',
        '- Each challenge has a pre-determined score.
            - A participant’s score depends on the number of test cases a participant’s code submission successfully passes.
            - If a participant submits more than one solution per challenge, then the participant’s score will reflect the highest score achieved.
            - Participants are ranked by score. If two or more participants achieve the same score, then the tie is broken by the total time taken to submit the last solution resulting in a higher score',
        'https://leetcode.com/_next/static/images/weekly-default-553ede7bcc8e1b4a44c28a9e4a32068c.png', '2024-05-20 18:09:29.488151+07', '2024-09-10 18:09:29.488151+07', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', true),
        ('d215b5f8-0249-4dc5-89a3-51fd148cfb20', 'Java Contest',
        '<h3 style="text-align:start"><span style="font-size:24px"><span style="font-family:-apple-system,BlinkMacSystemFont,&quot;Segoe UI&quot;,&quot;PingFang SC&quot;,&quot;Hiragino Sans GB&quot;,&quot;Microsoft YaHei&quot;,&quot;Helvetica Neue&quot;,Helvetica,Arial,sans-serif,&quot;Apple Color Emoji&quot;,&quot;Segoe UI Emoji&quot;,&quot;Segoe UI Symbol&quot;"><span style="color:rgba(0, 0, 0, 0.85)"><span style="background-color:#fafafa">Welcome to the Java Contest Batch the code #387</span></span></span></span></h3>',
        '- Prizes are optional. You may add any prizes that you would like to offer here.',
        '<ol><li>1. Participants must submit their solutions before the end time.</li><li>2. Participants must follow the contest rules and guidelines.</li><li>3. Participants must not cheat or plagiarize.</li></ol>',
        '- Each challenge has a pre-determined score.
            - A participant’s score depends on the number of test cases a participant’s code submission successfully passes.
            - If a participant submits more than one solution per challenge, then the participant’s score will reflect the highest score achieved.
            - Participants are ranked by score. If two or more participants achieve the same score, then the tie is broken by the total time taken to submit the last solution resulting in a higher score',
        'https://leetcode.com/_next/static/images/biweekly-default-f5a8fc3be85b6c9175207fd8fd855d47.png', '2024-09-15 18:09:29.488151+07', '2024-10-15 18:09:29.488151+07', 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', true),
        ('d215b5f8-0249-4dc5-89a3-51fd148cfb21', 'Data Structures Contest',
        '<h3 style="text-align:start"><span style="font-size:24px"><span style="font-family:-apple-system,BlinkMacSystemFont,&quot;Segoe UI&quot;,&quot;PingFang SC&quot;,&quot;Hiragino Sans GB&quot;,&quot;Microsoft YaHei&quot;,&quot;Helvetica Neue&quot;,Helvetica,Arial,sans-serif,&quot;Apple Color Emoji&quot;,&quot;Segoe UI Emoji&quot;,&quot;Segoe UI Symbol&quot;"><span style="color:rgba(0, 0, 0, 0.85)"><span style="background-color:#fafafa">Welcome to the Data Structures Contest Batch the code #387</span></span></span></span></h3>','<ol><li>1st Place: $1000</li><li>2nd Place: $500</li><li>3rd Place: $250</li></ol>',
        '<ol><li>1. Participants must submit their solutions before the end time.</li><li>2. Participants must follow the contest rules and guidelines.</li><li>3. Participants must not cheat or plagiarize.</li></ol>',
        '- Each challenge has a pre-determined score.
            - A participant’s score depends on the number of test cases a participant’s code submission successfully passes.
            - If a participant submits more than one solution per challenge, then the participant’s score will reflect the highest score achieved.
            - Participants are ranked by score. If two or more participants achieve the same score, then the tie is broken by the total time taken to submit the last solution resulting in a higher score',
        'https://assets.leetcode.com/contest/weekly-contest-291/card_img_1654267951.png', '2024-01-15 18:09:29.488151+07', null, '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', true),
        ('d215b5f8-0249-4dc5-89a3-51fd148cfb22', 'Algorithms Contest',
        '<h3 style="text-align:start"><span style="font-size:24px"><span style="font-family:-apple-system,BlinkMacSystemFont,&quot;Segoe UI&quot;,&quot;PingFang SC&quot;,&quot;Hiragino Sans GB&quot;,&quot;Microsoft YaHei&quot;,&quot;Helvetica Neue&quot;,Helvetica,Arial,sans-serif,&quot;Apple Color Emoji&quot;,&quot;Segoe UI Emoji&quot;,&quot;Segoe UI Symbol&quot;"><span style="color:rgba(0, 0, 0, 0.85)"><span style="background-color:#fafafa">Welcome to the Algorithms Contest Batch the code #387</span></span></span></span></h3>','<ol><li>1st Place: $1000</li><li>2nd Place: $500</li><li>3rd Place: $250</li></ol>',
        '<ol><li>1. Participants must submit their solutions before the end time.</li><li>2. Participants must follow the contest rules and guidelines.</li><li>3. Participants must not cheat or plagiarize.</li></ol>',
        '- Each challenge has a pre-determined score.
            - A participant’s score depends on the number of test cases a participant’s code submission successfully passes.
            - If a participant submits more than one solution per challenge, then the participant’s score will reflect the highest score achieved.
            - Participants are ranked by score. If two or more participants achieve the same score, then the tie is broken by the total time taken to submit the last solution resulting in a higher score',
        'https://assets.leetcode.com/contest/weekly-contest-291/card_img_1654267951.png', '2024-01-15 18:09:29.488151+07', '2024-04-15 18:09:29.488151+07', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', true),
        ('d215b5f8-0249-4dc5-89a3-51fd148cfb23', 'Python Contest',
        '<h3 style="text-align:start"><span style="font-size:24px"><span style="font-family:-apple-system,BlinkMacSystemFont,&quot;Segoe UI&quot;,&quot;PingFang SC&quot;,&quot;Hiragino Sans GB&quot;,&quot;Microsoft YaHei&quot;,&quot;Helvetica Neue&quot;,Helvetica,Arial,sans-serif,&quot;Apple Color Emoji&quot;,&quot;Segoe UI Emoji&quot;,&quot;Segoe UI Symbol&quot;"><span style="color:rgba(0, 0, 0, 0.85)"><span style="background-color:#fafafa">Welcome to the Python Contest Batch the code #387</span></span></span></span></h3>',
        '<ol><li>1st Place: $1000</li><li>2nd Place: $500</li><li>3rd Place: $250</li></ol>',
        '<ol><li>1. Participants must submit their solutions before the end time.</li><li>2. Participants must follow the contest rules and guidelines.</li><li>3. Participants must not cheat or plagiarize.</li></ol>',
        '- Each challenge has a pre-determined score.
            - A participant’s score depends on the number of test cases a participant’s code submission successfully passes.
            - If a participant submits more than one solution per challenge, then the participant’s score will reflect the highest score achieved.
            - Participants are ranked by score. If two or more participants achieve the same score, then the tie is broken by the total time taken to submit the last solution resulting in a higher score',
        'https://leetcode.com/_next/static/images/weekly-default-553ede7bcc8e1b4a44c28a9e4a32068c.png', '2024-05-20 18:09:29.488151+07', '2024-09-10 18:09:29.488151+07', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', true),
        ('d215b5f8-0249-4dc5-89a3-51fd148cfb24', 'Java Contest',
        '<h3 style="text-align:start"><span style="font-size:24px"><span style="font-family:-apple-system,BlinkMacSystemFont,&quot;Segoe UI&quot;,&quot;PingFang SC&quot;,&quot;Hiragino Sans GB&quot;,&quot;Microsoft YaHei&quot;,&quot;Helvetica Neue&quot;,Helvetica,Arial,sans-serif,&quot;Apple Color Emoji&quot;,&quot;Segoe UI Emoji&quot;,&quot;Segoe UI Symbol&quot;"><span style="color:rgba(0, 0, 0, 0.85)"><span style="background-color:#fafafa">Welcome to the Java Contest Batch the code #387</span></span></span></span></h3>',
        '- Prizes are optional. You may add any prizes that you would like to offer here.',
        '<ol><li>1. Participants must submit their solutions before the end time.</li><li>2. Participants must follow the contest rules and guidelines.</li><li>3. Participants must not cheat or plagiarize.</li></ol>',
        '- Each challenge has a pre-determined score.
            - A participant’s score depends on the number of test cases a participant’s code submission successfully passes.
            - If a participant submits more than one solution per challenge, then the participant’s score will reflect the highest score achieved.
            - Participants are ranked by score. If two or more participants achieve the same score, then the tie is broken by the total time taken to submit the last solution resulting in a higher score',
        'https://leetcode.com/_next/static/images/biweekly-default-f5a8fc3be85b6c9175207fd8fd855d47.png', '2024-09-15 18:09:29.488151+07', '2024-10-15 18:09:29.488151+07', 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', false),
        ('d215b5f8-0249-4dc5-89a3-51fd148cfb25', 'Data Structures Contest',
        '<h3 style="text-align:start"><span style="font-size:24px"><span style="font-family:-apple-system,BlinkMacSystemFont,&quot;Segoe UI&quot;,&quot;PingFang SC&quot;,&quot;Hiragino Sans GB&quot;,&quot;Microsoft YaHei&quot;,&quot;Helvetica Neue&quot;,Helvetica,Arial,sans-serif,&quot;Apple Color Emoji&quot;,&quot;Segoe UI Emoji&quot;,&quot;Segoe UI Symbol&quot;"><span style="color:rgba(0, 0, 0, 0.85)"><span style="background-color:#fafafa">Welcome to the Data Structures Contest Batch the code #387</span></span></span></span></h3>','<ol><li>1st Place: $1000</li><li>2nd Place: $500</li><li>3rd Place: $250</li></ol>',
        '<ol><li>1. Participants must submit their solutions before the end time.</li><li>2. Participants must follow the contest rules and guidelines.</li><li>3. Participants must not cheat or plagiarize.</li></ol>',
        '- Each challenge has a pre-determined score.
            - A participant’s score depends on the number of test cases a participant’s code submission successfully passes.
            - If a participant submits more than one solution per challenge, then the participant’s score will reflect the highest score achieved.
            - Participants are ranked by score. If two or more participants achieve the same score, then the tie is broken by the total time taken to submit the last solution resulting in a higher score',
        'https://assets.leetcode.com/contest/weekly-contest-291/card_img_1654267951.png', '2024-01-15 18:09:29.488151+07', null, '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', true),
        ('d215b5f8-0249-4dc5-89a3-51fd148cfb26', 'Algorithms Contest',
        '<h3 style="text-align:start"><span style="font-size:24px"><span style="font-family:-apple-system,BlinkMacSystemFont,&quot;Segoe UI&quot;,&quot;PingFang SC&quot;,&quot;Hiragino Sans GB&quot;,&quot;Microsoft YaHei&quot;,&quot;Helvetica Neue&quot;,Helvetica,Arial,sans-serif,&quot;Apple Color Emoji&quot;,&quot;Segoe UI Emoji&quot;,&quot;Segoe UI Symbol&quot;"><span style="color:rgba(0, 0, 0, 0.85)"><span style="background-color:#fafafa">Welcome to the Algorithms Contest Batch the code #387</span></span></span></span></h3>','<ol><li>1st Place: $1000</li><li>2nd Place: $500</li><li>3rd Place: $250</li></ol>',
        '<ol><li>1. Participants must submit their solutions before the end time.</li><li>2. Participants must follow the contest rules and guidelines.</li><li>3. Participants must not cheat or plagiarize.</li></ol>',
        '- Each challenge has a pre-determined score.
            - A participant’s score depends on the number of test cases a participant’s code submission successfully passes.
            - If a participant submits more than one solution per challenge, then the participant’s score will reflect the highest score achieved.
            - Participants are ranked by score. If two or more participants achieve the same score, then the tie is broken by the total time taken to submit the last solution resulting in a higher score',
        'https://assets.leetcode.com/contest/weekly-contest-291/card_img_1654267951.png', '2024-01-15 18:09:29.488151+07', '2024-04-15 18:09:29.488151+07', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', false),
        ('d215b5f8-0249-4dc5-89a3-51fd148cfb27', 'Python Contest',
        '<h3 style="text-align:start"><span style="font-size:24px"><span style="font-family:-apple-system,BlinkMacSystemFont,&quot;Segoe UI&quot;,&quot;PingFang SC&quot;,&quot;Hiragino Sans GB&quot;,&quot;Microsoft YaHei&quot;,&quot;Helvetica Neue&quot;,Helvetica,Arial,sans-serif,&quot;Apple Color Emoji&quot;,&quot;Segoe UI Emoji&quot;,&quot;Segoe UI Symbol&quot;"><span style="color:rgba(0, 0, 0, 0.85)"><span style="background-color:#fafafa">Welcome to the Python Contest Batch the code #387</span></span></span></span></h3>',
        '<ol><li>1st Place: $1000</li><li>2nd Place: $500</li><li>3rd Place: $250</li></ol>',
        '<ol><li>1. Participants must submit their solutions before the end time.</li><li>2. Participants must follow the contest rules and guidelines.</li><li>3. Participants must not cheat or plagiarize.</li></ol>',
        '- Each challenge has a pre-determined score.
            - A participant’s score depends on the number of test cases a participant’s code submission successfully passes.
            - If a participant submits more than one solution per challenge, then the participant’s score will reflect the highest score achieved.
            - Participants are ranked by score. If two or more participants achieve the same score, then the tie is broken by the total time taken to submit the last solution resulting in a higher score',
        'https://leetcode.com/_next/static/images/weekly-default-553ede7bcc8e1b4a44c28a9e4a32068c.png', '2024-05-20 18:09:29.488151+07', '2024-09-10 18:09:29.488151+07', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', true),
        ('d215b5f8-0249-4dc5-89a3-51fd148cfb28', 'Java Contest',
        '<h3 style="text-align:start"><span style="font-size:24px"><span style="font-family:-apple-system,BlinkMacSystemFont,&quot;Segoe UI&quot;,&quot;PingFang SC&quot;,&quot;Hiragino Sans GB&quot;,&quot;Microsoft YaHei&quot;,&quot;Helvetica Neue&quot;,Helvetica,Arial,sans-serif,&quot;Apple Color Emoji&quot;,&quot;Segoe UI Emoji&quot;,&quot;Segoe UI Symbol&quot;"><span style="color:rgba(0, 0, 0, 0.85)"><span style="background-color:#fafafa">Welcome to the Java Contest Batch the code #387</span></span></span></span></h3>',
        '- Prizes are optional. You may add any prizes that you would like to offer here.',
        '<ol><li>1. Participants must submit their solutions before the end time.</li><li>2. Participants must follow the contest rules and guidelines.</li><li>3. Participants must not cheat or plagiarize.</li></ol>',
        '- Each challenge has a pre-determined score.
            - A participant’s score depends on the number of test cases a participant’s code submission successfully passes.
            - If a participant submits more than one solution per challenge, then the participant’s score will reflect the highest score achieved.
            - Participants are ranked by score. If two or more participants achieve the same score, then the tie is broken by the total time taken to submit the last solution resulting in a higher score',
        'https://leetcode.com/_next/static/images/biweekly-default-f5a8fc3be85b6c9175207fd8fd855d47.png', '2024-09-15 18:09:29.488151+07', '2024-10-15 18:09:29.488151+07', 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c', true);

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

-- INSERT INTO public.code_submission(id, user_id, code_question_id, programming_language_id, source_code, grade, pass)
-- VALUES
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb16', '9ba179ed-d26d-4828-a0f6-8836c2063992', '27549d54-4a3a-4be4-9875-eab03f88ba5b', 'd27a8b36-83fd-450d-a7c3-bf3eef7b1468', 'print("Hello, World!")', 0, false),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb17', 'b029f559-52a8-4699-b595-71161498ed8c', '27549d54-4a3a-4be4-9875-eab03f88ba6b', 'd27a8b36-83fd-450d-a7c3-bf3eef7b1468', 'print("Hello, World!")', 0, false),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb18', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', '27549d54-4a3a-4be4-9875-eab03f88ba7b', 'd27a8b36-83fd-450d-a7c3-bf3eef7b1468', 'print("Hello, World!")', 0, false),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb19', '9ba179ed-d26d-4828-a0f6-8836c2063992', '27549d54-4a3a-4be4-9875-eab03f88ba5b', 'd27a8b36-83fd-450d-a7c3-bf3eef7b1468', 'print("Hello, World!")', 2, true),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb20', '9ba179ed-d26d-4828-a0f6-8836c2063992', '27549d54-4a3a-4be4-9875-eab03f88ba5b', 'd27a8b36-83fd-450d-a7c3-bf3eef7b1468', 'print("Hello, World!")', 3, true),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb21', 'b029f559-52a8-4699-b595-71161498ed8c', '27549d54-4a3a-4be4-9875-eab03f88ba6b', 'd27a8b36-83fd-450d-a7c3-bf3eef7b1468', 'print("Hello, World!")', 3, true),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb22', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', '27549d54-4a3a-4be4-9875-eab03f88ba7b', 'd27a8b36-83fd-450d-a7c3-bf3eef7b1468', 'print("Hello, World!")', 0, false),
--     ('d215b5f8-0249-4dc5-89a3-51fd148cfb23', '9ba179ed-d26d-4828-a0f6-8836c2063992', '27549d54-4a3a-4be4-9875-eab03f88ba8b', 'd27a8b36-83fd-450d-a7c3-bf3eef7b1468', 'print("Hello, World!")', 4, true);

INSERT INTO public.code_submission_contest(code_submission_id, contest_id)
VALUES
    ('a2e5afa6-f0c8-422e-8895-a706d1a1d6c1', 'd215b5f8-0249-4dc5-89a3-51fd148cfb15'),
    ('4a177c20-9487-48f6-b057-6d981e66b6cf', 'd215b5f8-0249-4dc5-89a3-51fd148cfb15'),
    ('df32ebfe-ec52-42c6-9447-cdc5280d5701', 'd215b5f8-0249-4dc5-89a3-51fd148cfb15'),
    ('0b4bccfc-411f-499d-b470-9574152269aa', 'd215b5f8-0249-4dc5-89a3-51fd148cfb15'),
    ('186c1fea-9706-4399-991a-8c9ff7d97b9a', 'd215b5f8-0249-4dc5-89a3-51fd148cfb15');



