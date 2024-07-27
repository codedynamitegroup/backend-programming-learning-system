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
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb92',
     'Learn C',
     'C is a fundamental programming language that''s ideal for beginners due to its simplicity and direct control over hardware. Learning C provides a strong foundation in computer science concepts and programming techniques.',
     'https://cdn.codechef.com/images/self-learning/icons/c.svg',
     '9ba179ed-d26d-4828-a0f6-8836c2063992',
     '9ba179ed-d26d-4828-a0f6-8836c2063992',
     true),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb93',
     'Learn C++',
     'C++ is a powerful, high-performance programming language that''s widely used in game development, system software, and scientific computing. It''s an extension of C with additional features like object-oriented programming.',
     'https://cdn.codechef.com/images/self-learning/icons/cpp.svg',
     '9ba179ed-d26d-4828-a0f6-8836c2063992',
     '9ba179ed-d26d-4828-a0f6-8836c2063992',
     true),
    ('9ba179ed-d26d-4828-a0f6-8836c2063992',
     'Learn Python',
     'Python is a versatile and user-friendly programming language known for its readability and efficiency. It''s widely used for web development, data analysis, artificial intelligence, and more.',
     'https://cdn.codechef.com/images/self-learning/icons/python.svg',
     '9ba179ed-d26d-4828-a0f6-8836c2063992',
     '9ba179ed-d26d-4828-a0f6-8836c2063992',
        true
    ),
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
     'Learn GO',
     'Go, also known as Golang, is a programming language created by Google, renowned for its simplicity and efficiency. It''s designed for building scalable and high-performance web applications and network servers. Go''s strong support for concurrency and its straightforward syntax make it popular for cloud computing and microservices.',
     'https://cdn.codechef.com/images/self-learning/icons/go.svg',
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
	 ('08b65a39-394f-4977-a5fa-3fe145b620f8','Moodle description','Moodle','2024-04-15 18:09:29.488151+07','2024-04-15 18:09:29.488151+07',false),
	 ('cb69c0bf-c454-4f15-be10-791f6749dac7','Moodle description','Moodle 2','2024-04-15 18:09:29.488151+07','2024-04-15 18:09:29.488151+07',false);

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
    -- C
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb92', '6b2f42e1-81e6-493b-9cc1-2436febc320e'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb92', '50e74d89-5742-4c21-b9e5-96a4766283fa'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb92', 'fb38c7b8-d50a-4980-95de-6a50a49ecc5d'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb92', '5f11cfd5-4358-4e8e-b28a-9c53beb014ad'),
    -- C++
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb93', '8794526e-f528-4ffc-b98d-320812e79c6f'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb93', 'e6a880d8-f0b2-4c2d-b97d-a74d5bec87b3'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb93', 'aed9a00b-6a4b-4534-b85e-4981097d61de'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb93', 'cba00cd8-8114-4bc4-84e6-499c27467978'),
    -- Python
    ('9ba179ed-d26d-4828-a0f6-8836c2063992', '5413d5e9-5513-4e86-b585-b4f9149bc692'),
    ('9ba179ed-d26d-4828-a0f6-8836c2063992', 'd27a8b36-83fd-450d-a7c3-bf3eef7b1468'),
    -- Java
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb46', 'c95d5c7d-cadf-42cc-afdc-968211ae3720'),
    -- JavaScript
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb47', 'cc69d904-ba4e-44fb-a0b5-8170e30bac39'),
    -- GO
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb49', 'e68c5866-1435-4958-bafe-ad901ee75c8d'),
    -- Java, C, C++, Python, Javascript
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb48', 'c95d5c7d-cadf-42cc-afdc-968211ae3720'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb48', '6b2f42e1-81e6-493b-9cc1-2436febc320e'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb48', '8794526e-f528-4ffc-b98d-320812e79c6f'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb48', '5413d5e9-5513-4e86-b585-b4f9149bc692'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb48', 'cc69d904-ba4e-44fb-a0b5-8170e30bac39');


INSERT INTO public.question(id, org_id, difficulty, name, question_text, general_feedback, default_mark, qtype, created_by, updated_by, copy_state)
VALUES
    ('b6484e21-6937-489c-b031-b71767994233', NULL, 'EASY', 'Question Handle', 'Question Wire Text', 'Question Gold feedback', 1, 'ESSAY', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994132', NULL, 'MEDIUM', 'Question hihi', 'Question Wow Text', 'Question Amazing feedback', 1, 'SHORT_ANSWER', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994735', NULL, 'HARD', 'Question haha', 'Question Speaker Text', 'Good Job', 1, 'MULTIPLE_CHOICE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994752', NULL, 'MEDIUM', 'K Divisible Elements Subarrays', 'Question Wow Text', 'Question Amazing feedback', 1, 'SHORT_ANSWER', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994753', NULL, 'HARD', 'Total Appeal of A String', 'Question Speaker Text', 'Good Job', 1, 'MULTIPLE_CHOICE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994751', NULL, 'EASY', 'Minimum Consecutive Cards to Pick Up', 'Question Wire Text', 'Question Gold feedback', 1, 'ESSAY', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),

    --    Questions with qtype CODE
    --1
    ('b6484e21-6937-489c-b031-b71767994221', NULL, 'EASY', 'Sum of two integer', E'<div class="elfjS" data-track-load="description_content"><p>Given two integer number A and B.</p><p>Calculate the sum of A and B.</p><p>&nbsp;</p><p><strong class="example">Example 1:</strong></p><pre>\nInput:\n1\n1\nOutput: 2\n</pre><p><strong class="example">Example 2:</strong></p><pre>\nInput:\n13\n10\nOutput: 23 \n</pre><p>&nbsp;</p></div>', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    --2
    ('b6484e21-6937-489c-b031-b71767994736', NULL, 'EASY', 'Sum of an array', E'<p>Write a function that takes an array of numbers as input and returns the sum of all the elements in the array.</p><blockquote>Example:</blockquote><pre class=\"ql-syntax\" spellcheck=\"false\"> Input:\r\n 3\r\n 1 2 3\r\n Output: 6    \r\n</pre><p><br></p>', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    --3
    ('b6484e21-6937-489c-b031-b71767994737', NULL, 'EASY', 'FizzBuzz', E'<p>Write a program that prints the numbers from 1 to n. But for multiples of three, print \"Fizz\" instead of the number, and for the multiples of five, print \"Buzz\". For numbers that are multiples of both three and five, print \"FizzBuzz\".</p><p>Example:</p><pre class=\"ql-syntax\" spellcheck=\"false\">Input: 15\r\nOutput:\r\n1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz\r\n</pre>', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    --4
    ('b6484e21-6937-489c-b031-b71767994738', NULL, 'MEDIUM', 'Robber', E'<p>You are given a list of non-negative integers representing the amount of money of each house in a row of houses. Each house has a certain amount of money stashed, but you cannot rob two adjacent houses at the same time because the police will be alerted. Your task is to determine the maximum amount of money you can rob tonight without alerting the police.</p><p>Example 1:</p><pre class=\"ql-syntax\" spellcheck=\"false\">Input: \r\n4\r\n1 2 3 1\r\nOutput: 4\r\nExplanation: Rob house 1 (money = 1) and then rob house 3 (money = 3). Total amount = 1 + 3 = 4.\r\n</pre>', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    --5
    ('b6484e21-6937-489c-b031-b71767994739', NULL, 'MEDIUM', 'Three sum closest', E'<p>You are given an array <code>nums</code> of integers. Write a function to find three numbers in <code>nums</code> such that the sum is closest to a given target <code>target</code>. Return the sum of the three integers. You may assume that each input would have exactly one solution.</p><p>Example:</p><pre class=\"ql-syntax\" spellcheck=\"false\">Input:\r\n4\r\n-1 2 1 -4\r\n1\r\nOutput: 2\r\nExplanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).\r\n</pre>', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    --6
    ('b6484e21-6937-489c-b031-b71767994740', NULL, 'EASY', 'List divisor', E'<p>List all divisor of number <code>n</code></p><p>Example:</p><pre class=\"ql-syntax\" spellcheck=\"false\">Input:\n10\nOutput:\n1 2 5 10\n</pre>', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    --7
    ('b6484e21-6937-489c-b031-b71767994741', NULL, 'EASY', 'List odd divisor', E'<p>List all odd divisor of number <code>n</code></p><p>Example:</p><pre class=\"ql-syntax\" spellcheck=\"false\">Input: 9\nOutput:\n1, 3, 9\n</pre>', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994742', NULL, 'EASY', 'Entirely odd digit', E'<p>Check if the positive integer <code>n</code> consists entirely of odd digits.</p><p>Example:</p><pre class=\"ql-syntax\" spellcheck=\"false\">Input:\n11\nOutput:\ntrue\n</pre>', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994743', NULL, 'MEDIUM', 'Palindrome integer', E'<p>Check if the positive integer n is a palindrome or not</p><p>Example:</p><pre class=\"ql-syntax\" spellcheck=\"false\">Input:\n11\nOutput:\ntrue\n</pre>', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994744', NULL, 'MEDIUM', 'Finding maximum sum k less than n', E'<p>Given <code>n</code> is a positive integer. Find the largest positive integer <code>k</code> such that S(k)&lt;n, where S(k) is defined as follows: S(k)=1+2+3+…+k.</p><p>Example:</p><pre class=\"ql-syntax\" spellcheck=\"false\">Input:\n15\nOutput:\n4\n</pre>', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994745', NULL, 'MEDIUM', 'Check 2^k', E'<p>Check if a 4-byte integer is of the form 2^k</p><p>Example:</p><pre class=\"ql-syntax\" spellcheck=\"false\">Input:\n4\nOutput:\ntrue\n</pre>', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994746', NULL, 'MEDIUM', 'Check 3^k', E'<p>Check if a 4-byte integer is of the form 3^k</p><p>Example:</p><pre class=\"ql-syntax\" spellcheck=\"false\">Input:\n4\nOutput:\nfalse\n</pre>', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994747', NULL, 'MEDIUM', 'Calculate S(n, x) with Summation and Exponential Series', E'<p>Calculate&nbsp;<span class=\"ql-formula\" data-value=\"S(n, x) = x + \\frac{x^2}{1 + 2} + \\frac{x^3}{1 + 2 + 3} + \\cdots + \\frac{x^n}{1 + 2 + 3 + \\cdots + n}\">﻿<span contenteditable=\"false\"><span class=\"katex\"><span class=\"katex-mathml\"><math xmlns=\"http://www.w3.org/1998/Math/MathML\"><semantics><mrow><mi>S</mi><mo stretchy=\"false\">(</mo><mi>n</mi><mo separator=\"true\">,</mo><mi>x</mi><mo stretchy=\"false\">)</mo><mo>=</mo><mi>x</mi><mo>+</mo><mfrac><msup><mi>x</mi><mn>2</mn></msup><mrow><mn>1</mn><mo>+</mo><mn>2</mn></mrow></mfrac><mo>+</mo><mfrac><msup><mi>x</mi><mn>3</mn></msup><mrow><mn>1</mn><mo>+</mo><mn>2</mn><mo>+</mo><mn>3</mn></mrow></mfrac><mo>+</mo><mo>⋯</mo><mo>+</mo><mfrac><msup><mi>x</mi><mi>n</mi></msup><mrow><mn>1</mn><mo>+</mo><mn>2</mn><mo>+</mo><mn>3</mn><mo>+</mo><mo>⋯</mo><mo>+</mo><mi>n</mi></mrow></mfrac></mrow><annotation encoding=\"application/x-tex\">S(n, x) = x + \\frac{x^2}{1 + 2} + \\frac{x^3}{1 + 2 + 3} + \\cdots + \\frac{x^n}{1 + 2 + 3 + \\cdots + n}</annotation></semantics></math></span><span class=\"katex-html\" aria-hidden=\"true\"><span class=\"base\"><span class=\"strut\" style=\"height: 1em; vertical-align: -0.25em;\"></span><span class=\"mord mathnormal\" style=\"margin-right: 0.0576em;\">S</span><span class=\"mopen\">(</span><span class=\"mord mathnormal\">n</span><span class=\"mpunct\">,</span><span class=\"mspace\" style=\"margin-right: 0.1667em;\"></span><span class=\"mord mathnormal\">x</span><span class=\"mclose\">)</span><span class=\"mspace\" style=\"margin-right: 0.2778em;\"></span><span class=\"mrel\">=</span><span class=\"mspace\" style=\"margin-right: 0.2778em;\"></span></span><span class=\"base\"><span class=\"strut\" style=\"height: 0.6667em; vertical-align: -0.0833em;\"></span><span class=\"mord mathnormal\">x</span><span class=\"mspace\" style=\"margin-right: 0.2222em;\"></span><span class=\"mbin\">+</span><span class=\"mspace\" style=\"margin-right: 0.2222em;\"></span></span><span class=\"base\"><span class=\"strut\" style=\"height: 1.4213em; vertical-align: -0.4033em;\"></span><span class=\"mord\"><span class=\"mopen nulldelimiter\"></span><span class=\"mfrac\"><span class=\"vlist-t vlist-t2\"><span class=\"vlist-r\"><span class=\"vlist\" style=\"height: 1.0179em;\"><span class=\"\" style=\"top: -2.655em;\"><span class=\"pstrut\" style=\"height: 3em;\"></span><span class=\"sizing reset-size6 size3 mtight\"><span class=\"mord mtight\"><span class=\"mord mtight\">1</span><span class=\"mbin mtight\">+</span><span class=\"mord mtight\">2</span></span></span></span><span class=\"\" style=\"top: -3.23em;\"><span class=\"pstrut\" style=\"height: 3em;\"></span><span class=\"frac-line\" style=\"border-bottom-width: 0.04em;\"></span></span><span class=\"\" style=\"top: -3.394em;\"><span class=\"pstrut\" style=\"height: 3em;\"></span><span class=\"sizing reset-size6 size3 mtight\"><span class=\"mord mtight\"><span class=\"mord mtight\"><span class=\"mord mathnormal mtight\">x</span><span class=\"msupsub\"><span class=\"vlist-t\"><span class=\"vlist-r\"><span class=\"vlist\" style=\"height: 0.8913em;\"><span class=\"\" style=\"top: -2.931em; margin-right: 0.0714em;\"><span class=\"pstrut\" style=\"height: 2.5em;\"></span><span class=\"sizing reset-size3 size1 mtight\"><span class=\"mord mtight\">2</span></span></span></span></span></span></span></span></span></span></span></span><span class=\"vlist-s\">​</span></span><span class=\"vlist-r\"><span class=\"vlist\" style=\"height: 0.4033em;\"><span class=\"\"></span></span></span></span></span><span class=\"mclose nulldelimiter\"></span></span><span class=\"mspace\" style=\"margin-right: 0.2222em;\"></span><span class=\"mbin\">+</span><span class=\"mspace\" style=\"margin-right: 0.2222em;\"></span></span><span class=\"base\"><span class=\"strut\" style=\"height: 1.4213em; vertical-align: -0.4033em;\"></span><span class=\"mord\"><span class=\"mopen nulldelimiter\"></span><span class=\"mfrac\"><span class=\"vlist-t vlist-t2\"><span class=\"vlist-r\"><span class=\"vlist\" style=\"height: 1.0179em;\"><span class=\"\" style=\"top: -2.655em;\"><span class=\"pstrut\" style=\"height: 3em;\"></span><span class=\"sizing reset-size6 size3 mtight\"><span class=\"mord mtight\"><span class=\"mord mtight\">1</span><span class=\"mbin mtight\">+</span><span class=\"mord mtight\">2</span><span class=\"mbin mtight\">+</span><span class=\"mord mtight\">3</span></span></span></span><span class=\"\" style=\"top: -3.23em;\"><span class=\"pstrut\" style=\"height: 3em;\"></span><span class=\"frac-line\" style=\"border-bottom-width: 0.04em;\"></span></span><span class=\"\" style=\"top: -3.394em;\"><span class=\"pstrut\" style=\"height: 3em;\"></span><span class=\"sizing reset-size6 size3 mtight\"><span class=\"mord mtight\"><span class=\"mord mtight\"><span class=\"mord mathnormal mtight\">x</span><span class=\"msupsub\"><span class=\"vlist-t\"><span class=\"vlist-r\"><span class=\"vlist\" style=\"height: 0.8913em;\"><span class=\"\" style=\"top: -2.931em; margin-right: 0.0714em;\"><span class=\"pstrut\" style=\"height: 2.5em;\"></span><span class=\"sizing reset-size3 size1 mtight\"><span class=\"mord mtight\">3</span></span></span></span></span></span></span></span></span></span></span></span><span class=\"vlist-s\">​</span></span><span class=\"vlist-r\"><span class=\"vlist\" style=\"height: 0.4033em;\"><span class=\"\"></span></span></span></span></span><span class=\"mclose nulldelimiter\"></span></span><span class=\"mspace\" style=\"margin-right: 0.2222em;\"></span><span class=\"mbin\">+</span><span class=\"mspace\" style=\"margin-right: 0.2222em;\"></span></span><span class=\"base\"><span class=\"strut\" style=\"height: 0.6667em; vertical-align: -0.0833em;\"></span><span class=\"minner\">⋯</span><span class=\"mspace\" style=\"margin-right: 0.2222em;\"></span><span class=\"mbin\">+</span><span class=\"mspace\" style=\"margin-right: 0.2222em;\"></span></span><span class=\"base\"><span class=\"strut\" style=\"height: 1.3143em; vertical-align: -0.4033em;\"></span><span class=\"mord\"><span class=\"mopen nulldelimiter\"></span><span class=\"mfrac\"><span class=\"vlist-t vlist-t2\"><span class=\"vlist-r\"><span class=\"vlist\" style=\"height: 0.911em;\"><span class=\"\" style=\"top: -2.655em;\"><span class=\"pstrut\" style=\"height: 3em;\"></span><span class=\"sizing reset-size6 size3 mtight\"><span class=\"mord mtight\"><span class=\"mord mtight\">1</span><span class=\"mbin mtight\">+</span><span class=\"mord mtight\">2</span><span class=\"mbin mtight\">+</span><span class=\"mord mtight\">3</span><span class=\"mbin mtight\">+</span><span class=\"minner mtight\">⋯</span><span class=\"mbin mtight\">+</span><span class=\"mord mathnormal mtight\">n</span></span></span></span><span class=\"\" style=\"top: -3.23em;\"><span class=\"pstrut\" style=\"height: 3em;\"></span><span class=\"frac-line\" style=\"border-bottom-width: 0.04em;\"></span></span><span class=\"\" style=\"top: -3.394em;\"><span class=\"pstrut\" style=\"height: 3em;\"></span><span class=\"sizing reset-size6 size3 mtight\"><span class=\"mord mtight\"><span class=\"mord mtight\"><span class=\"mord mathnormal mtight\">x</span><span class=\"msupsub\"><span class=\"vlist-t\"><span class=\"vlist-r\"><span class=\"vlist\" style=\"height: 0.7385em;\"><span class=\"\" style=\"top: -2.931em; margin-right: 0.0714em;\"><span class=\"pstrut\" style=\"height: 2.5em;\"></span><span class=\"sizing reset-size3 size1 mtight\"><span class=\"mord mathnormal mtight\">n</span></span></span></span></span></span></span></span></span></span></span></span><span class=\"vlist-s\">​</span></span><span class=\"vlist-r\"><span class=\"vlist\" style=\"height: 0.4033em;\"><span class=\"\"></span></span></span></span></span><span class=\"mclose nulldelimiter\"></span></span></span></span></span></span>﻿</span> , rounded to three decimal places.</p><p>Example:</p><pre class=\"ql-syntax\" spellcheck=\"false\">Input:\n2 1.5\nOutput:\n2.250\n</pre>', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994748', NULL, 'EASY', 'Check square number', 'Given an integer number n, check if it is a square number', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994749', NULL, 'EASY', 'Find the nax number from the set of float number a, b, c', 'A line with three number separated by a space character', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994750', NULL, 'EASY', 'Same sign number', 'Check if Two Real Numbers Have the Same Sign', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994754', NULL, 'MEDIUM', 'Solve ax+b=0', E'<p>Write a program to solve the linear equation <span class=\"ql-formula\" data-value=\"ax + b = 0\">﻿<span contenteditable=\"false\"><span class=\"katex\"><span class=\"katex-mathml\"><math xmlns=\"http://www.w3.org/1998/Math/MathML\"><semantics><mrow><mi>a</mi><mi>x</mi><mo>+</mo><mi>b</mi><mo>=</mo><mn>0</mn></mrow><annotation encoding=\"application/x-tex\">ax + b = 0</annotation></semantics></math></span><span class=\"katex-html\" aria-hidden=\"true\"><span class=\"base\"><span class=\"strut\" style=\"height: 0.6667em; vertical-align: -0.0833em;\"></span><span class=\"mord mathnormal\">a</span><span class=\"mord mathnormal\">x</span><span class=\"mspace\" style=\"margin-right: 0.2222em;\"></span><span class=\"mbin\">+</span><span class=\"mspace\" style=\"margin-right: 0.2222em;\"></span></span><span class=\"base\"><span class=\"strut\" style=\"height: 0.6944em;\"></span><span class=\"mord mathnormal\">b</span><span class=\"mspace\" style=\"margin-right: 0.2778em;\"></span><span class=\"mrel\">=</span><span class=\"mspace\" style=\"margin-right: 0.2778em;\"></span></span><span class=\"base\"><span class=\"strut\" style=\"height: 0.6444em;\"></span><span class=\"mord\">0</span></span></span></span></span>﻿</span> </p><p>Example 1:</p><pre class=\"ql-syntax\" spellcheck=\"false\">Input: \n0 0\nOutput:\nInfinite solutions\n</pre><p>Example 2:</p><pre class=\"ql-syntax\" spellcheck=\"false\">Input:\n0 5\nOutput:\nNo solution\n</pre><p>Example 3:</p><pre class=\"ql-syntax\" spellcheck=\"false\">Input:\n3 0\nOutput:\n0\n</pre>', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994755', NULL, 'EASY', 'Determine the Quarter of a Given Month', E'<p>Input a month of a year. Determine which quarter the month belongs to</p><p>Example:</p><pre class=\"ql-syntax\" spellcheck=\"false\">Input:\n1\nOutput:\nQuarter 1\n</pre>', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994756', NULL, 'EASY', 'Calculate sum of cubes', E'<p>Calculate <span class=\"ql-formula\" data-value=\"S(n) = 1^3 + 2^3 + \\ldots + n^3\">﻿<span contenteditable=\"false\"><span class=\"katex\"><span class=\"katex-mathml\"><math xmlns=\"http://www.w3.org/1998/Math/MathML\"><semantics><mrow><mi>S</mi><mo stretchy=\"false\">(</mo><mi>n</mi><mo stretchy=\"false\">)</mo><mo>=</mo><msup><mn>1</mn><mn>3</mn></msup><mo>+</mo><msup><mn>2</mn><mn>3</mn></msup><mo>+</mo><mo>…</mo><mo>+</mo><msup><mi>n</mi><mn>3</mn></msup></mrow><annotation encoding=\"application/x-tex\">S(n) = 1^3 + 2^3 + \\ldots + n^3</annotation></semantics></math></span><span class=\"katex-html\" aria-hidden=\"true\"><span class=\"base\"><span class=\"strut\" style=\"height: 1em; vertical-align: -0.25em;\"></span><span class=\"mord mathnormal\" style=\"margin-right: 0.0576em;\">S</span><span class=\"mopen\">(</span><span class=\"mord mathnormal\">n</span><span class=\"mclose\">)</span><span class=\"mspace\" style=\"margin-right: 0.2778em;\"></span><span class=\"mrel\">=</span><span class=\"mspace\" style=\"margin-right: 0.2778em;\"></span></span><span class=\"base\"><span class=\"strut\" style=\"height: 0.8974em; vertical-align: -0.0833em;\"></span><span class=\"mord\"><span class=\"mord\">1</span><span class=\"msupsub\"><span class=\"vlist-t\"><span class=\"vlist-r\"><span class=\"vlist\" style=\"height: 0.8141em;\"><span class=\"\" style=\"top: -3.063em; margin-right: 0.05em;\"><span class=\"pstrut\" style=\"height: 2.7em;\"></span><span class=\"sizing reset-size6 size3 mtight\"><span class=\"mord mtight\">3</span></span></span></span></span></span></span></span><span class=\"mspace\" style=\"margin-right: 0.2222em;\"></span><span class=\"mbin\">+</span><span class=\"mspace\" style=\"margin-right: 0.2222em;\"></span></span><span class=\"base\"><span class=\"strut\" style=\"height: 0.8974em; vertical-align: -0.0833em;\"></span><span class=\"mord\"><span class=\"mord\">2</span><span class=\"msupsub\"><span class=\"vlist-t\"><span class=\"vlist-r\"><span class=\"vlist\" style=\"height: 0.8141em;\"><span class=\"\" style=\"top: -3.063em; margin-right: 0.05em;\"><span class=\"pstrut\" style=\"height: 2.7em;\"></span><span class=\"sizing reset-size6 size3 mtight\"><span class=\"mord mtight\">3</span></span></span></span></span></span></span></span><span class=\"mspace\" style=\"margin-right: 0.2222em;\"></span><span class=\"mbin\">+</span><span class=\"mspace\" style=\"margin-right: 0.2222em;\"></span></span><span class=\"base\"><span class=\"strut\" style=\"height: 0.6667em; vertical-align: -0.0833em;\"></span><span class=\"minner\">…</span><span class=\"mspace\" style=\"margin-right: 0.2222em;\"></span><span class=\"mbin\">+</span><span class=\"mspace\" style=\"margin-right: 0.2222em;\"></span></span><span class=\"base\"><span class=\"strut\" style=\"height: 0.8141em;\"></span><span class=\"mord\"><span class=\"mord mathnormal\">n</span><span class=\"msupsub\"><span class=\"vlist-t\"><span class=\"vlist-r\"><span class=\"vlist\" style=\"height: 0.8141em;\"><span class=\"\" style=\"top: -3.063em; margin-right: 0.05em;\"><span class=\"pstrut\" style=\"height: 2.7em;\"></span><span class=\"sizing reset-size6 size3 mtight\"><span class=\"mord mtight\">3</span></span></span></span></span></span></span></span></span></span></span></span>﻿</span> </p><p>Example:</p><pre class=\"ql-syntax\" spellcheck=\"false\">Input:\n2\nOutput:\n9\n</pre>', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994757', NULL, 'EASY', 'English alphabet printing', 'Print from A to the nth character in the English alphabet', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994758', NULL, 'MEDIUM', 'Check prime number', 'Check if n is a prime number or not', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994759', NULL, 'EASY', 'Replace negative number', E'<p>Write a program to input three real numbers. Replace all negative numbers with their absolute values</p><p>Example:</p><pre class=\"ql-syntax\" spellcheck=\"false\">Input:\n1 -1.1 -2\nOutput:\n1 1.1 2\n</pre>', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994760', NULL, 'HARD', 'Check triangle from side length', E'<p>Write a program to input the lengths of the three sides of a triangle and determine the type of triangle</p><p>Example:</p><pre class=\"ql-syntax\" spellcheck=\"false\">Input:\n1 1 1\nOutput:\nEquilateral triangle\n</pre>', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994761', NULL, 'EASY', 'Determine number of days in a month', E'<p>Write a program to input a month and a year. Determine the number of days in that month</p><p>Example:</p><pre class=\"ql-syntax\" spellcheck=\"false\">Input:\n1 2020\nOutput:\n31\n</pre>', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994762', NULL, 'MEDIUM', 'Previous and next day', E'<p>Write a program to input a date, find the previous day and the next day</p><p>Example:</p><pre class=\"ql-syntax\" spellcheck=\"false\">Input:\n2024 6 26\nOutput:\n2024-06-25, 2024-06-27\n</pre>', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
    ('b6484e21-6937-489c-b031-b71767994763', NULL, 'HARD', 'Determine the Day of the Week from a Given Date', E'<p>Write a program to input a day, month, and year. Determine the day of the week for that date</p><p>Example:</p><pre class=\"ql-syntax\" spellcheck=\"false\">Input:\n2024-03-01\nOutput:\nFriday\n</pre>', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED');
INSERT INTO public.question(question_bank_category_id,
    id, org_id, difficulty, name, question_text, general_feedback, default_mark, qtype, created_by, updated_by, copy_state)
VALUES
    ('d8fed7b0-bd98-436e-9c4d-36b8fe9f372e',
    'b6484e21-6937-489c-b031-b71767994764', '08b65a39-394f-4977-a5fa-3fe145b620f8', 'EASY', 'List divisor', E'<p>List all divisor of number <code>n</code></p><p>Example:</p><pre class=\"ql-syntax\" spellcheck=\"false\">Input:\n10\nOutput:\n1 2 5 10\n</pre>', 'Good Job', 10, 'CODE', '64412e27-169e-44ea-a101-74ebf8cb82d9', '64412e27-169e-44ea-a101-74ebf8cb82d9', 'CREATED');
--INSERT INTO public.question(id, org_id, difficulty, name, question_text, general_feedback, default_mark, qtype, created_by, updated_by, copy_state)
--VALUES
--    ('b6484e21-6937-489c-b031-b71767994765', NULL, 'HARD', 'Question 65', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994766', NULL, 'HARD', 'Question 66', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994767', NULL, 'HARD', 'Question 67', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994768', NULL, 'HARD', 'Question 68', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994769', NULL, 'HARD', 'Question 69', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994770', NULL, 'HARD', 'Question 70', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994771', NULL, 'HARD', 'Question 71', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994772', NULL, 'HARD', 'Question 72', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994773', NULL, 'HARD', 'Question 73', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994774', NULL, 'HARD', 'Question 74', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994775', NULL, 'HARD', 'Question 75', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994776', NULL, 'HARD', 'Question 76', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994777', NULL, 'HARD', 'Question 77', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994778', NULL, 'HARD', 'Question 78', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994779', NULL, 'HARD', 'Question 79', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994780', NULL, 'HARD', 'Question 80', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994781', NULL, 'HARD', 'Question 81', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994782', NULL, 'HARD', 'Question 82', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994783', NULL, 'HARD', 'Question 83', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994784', NULL, 'HARD', 'Question 84', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994785', NULL, 'HARD', 'Question 85', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994786', NULL, 'HARD', 'Question 86', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994787', NULL, 'HARD', 'Question 87', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994788', NULL, 'HARD', 'Question 88', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994789', NULL, 'HARD', 'Question 89', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994790', NULL, 'HARD', 'Question 90', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994791', NULL, 'HARD', 'Question 91', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994792', NULL, 'HARD', 'Question 92', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994793', NULL, 'HARD', 'Question 93', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994794', NULL, 'HARD', 'Question 94', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994795', NULL, 'HARD', 'Question 95', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994796', NULL, 'HARD', 'Question 96', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994797', NULL, 'HARD', 'Question 97', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994798', NULL, 'HARD', 'Question 98', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994799', NULL, 'HARD', 'Question 99', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994800', NULL, 'HARD', 'Question 100', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994801', NULL, 'HARD', 'Question 101', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994802', NULL, 'HARD', 'Question 102', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994803', NULL, 'HARD', 'Question 103', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994804', NULL, 'HARD', 'Question 104', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994805', NULL, 'HARD', 'Question 105', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994806', NULL, 'HARD', 'Question 106', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994807', NULL, 'HARD', 'Question 107', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994808', NULL, 'HARD', 'Question 108', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994809', NULL, 'HARD', 'Question 109', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994810', NULL, 'HARD', 'Question 110', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994811', NULL, 'HARD', 'Question 111', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994812', NULL, 'HARD', 'Question 112', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994813', NULL, 'HARD', 'Question 113', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994814', NULL, 'HARD', 'Question 114', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994815', NULL, 'HARD', 'Question 115', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994816', NULL, 'HARD', 'Question 116', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994817', NULL, 'HARD', 'Question 117', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994818', NULL, 'HARD', 'Question 118', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994819', NULL, 'HARD', 'Question 119', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994820', NULL, 'HARD', 'Question 120', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994821', NULL, 'HARD', 'Question 121', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994822', NULL, 'HARD', 'Question 122', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994823', NULL, 'HARD', 'Question 123', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994824', NULL, 'HARD', 'Question 124', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994825', NULL, 'HARD', 'Question 125', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994826', NULL, 'HARD', 'Question 126', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994827', NULL, 'HARD', 'Question 127', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994828', NULL, 'HARD', 'Question 128', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994829', NULL, 'HARD', 'Question 129', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994830', NULL, 'HARD', 'Question 130', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994831', NULL, 'HARD', 'Question 131', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994832', NULL, 'HARD', 'Question 132', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994833', NULL, 'HARD', 'Question 133', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994834', NULL, 'HARD', 'Question 134', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994835', NULL, 'HARD', 'Question 135', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994836', NULL, 'HARD', 'Question 136', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994837', NULL, 'HARD', 'Question 137', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994838', NULL, 'HARD', 'Question 138', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994839', NULL, 'HARD', 'Question 139', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994840', NULL, 'HARD', 'Question 140', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994841', NULL, 'HARD', 'Question 141', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994842', NULL, 'HARD', 'Question 142', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994843', NULL, 'HARD', 'Question 143', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994844', NULL, 'HARD', 'Question 144', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994845', NULL, 'HARD', 'Question 145', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994846', NULL, 'HARD', 'Question 146', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED'),
--    ('b6484e21-6937-489c-b031-b71767994847', NULL, 'HARD', 'Question 147', 'Question Mouse Text', 'Good Job', 10, 'CODE', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'CREATED');

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
    ('d49496bb-87a5-483f-9597-564ad6ee0305', 'b6484e21-6937-489c-b031-b71767994754', 'template'),
    ('4be91526-365b-4e50-99ae-75ba2a87ba08', 'b6484e21-6937-489c-b031-b71767994755', 'template'),
    ('4be91526-365b-4e50-99ae-75ba2a87ba09', 'b6484e21-6937-489c-b031-b71767994756', 'template'),
    ('fa373da0-9d7d-4ced-bf8b-c06a0063cd4e', 'b6484e21-6937-489c-b031-b71767994757', 'template'),
    ('1f24ac22-737a-4074-9290-ec41bb15e2b0', 'b6484e21-6937-489c-b031-b71767994758', 'template'),
    ('7841c704-b8ae-4664-bb2c-d4a63fb80fd5', 'b6484e21-6937-489c-b031-b71767994759', 'template'),
    ('30a01889-fbc9-4eaf-9f4e-fa0341ea6ced', 'b6484e21-6937-489c-b031-b71767994760', 'template'),
    ('25315a21-41a1-464d-b9dc-d4ec978cd2ff', 'b6484e21-6937-489c-b031-b71767994761', 'template'),
    ('e557b35c-715e-4d21-8aaf-8c86ad5690b1', 'b6484e21-6937-489c-b031-b71767994762', 'template'),
    ('219cafcd-d4fe-4fb0-81fd-be2da867f9d4', 'b6484e21-6937-489c-b031-b71767994763', 'template'),
    ('9922c45b-fe25-4539-8c4b-4d247473b127', 'b6484e21-6937-489c-b031-b71767994764', 'template');


INSERT INTO public.qtype_essay_question(id, question_id, response_format, response_required, response_field_lines, min_word_limit, max_word_limit, attachments, attachments_required, grader_info, grader_info_format, response_template, max_bytes, file_types_list)
VALUES
    ('27549d54-4a3a-4be4-9875-eab03f88ba6e', 'b6484e21-6937-489c-b031-b71767994233', 'editor', 1, 10, 0, 0, 2, 0, 'Truong Gia Tien', 'author name', 'pdf please', 10, 'archive,document');

INSERT INTO public.qtype_shortanswer_question(id, question_id, case_sensitive)
VALUES
    ('27549d54-4a3a-4be4-9875-eab03f88ba7f', 'b6484e21-6937-489c-b031-b71767994132', false);

INSERT INTO public.qtype_multichoice_question(id, question_id, single, shuffle_answers, correct_feedback, partially_correct_feedback, incorrect_feedback, answer_numbering, show_num_correct, show_standard_instruction)
VALUES
    ('27549d54-4a3a-4be4-9875-eab03f88ba8f', 'b6484e21-6937-489c-b031-b71767994735', true, true, 'Correct', 'Partially correct', 'Incorrect', 'none', 3, 'Show instruction 2');

INSERT INTO "public"."certificate_course" ("id", "topic_id", "name", "skill_level", "description", "avg_rating", "start_time", "end_time", "created_by", "created_at", "updated_by", "updated_at") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb15', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'Basic Python', 'BASIC', '<div class="markdown prose w-full break-words dark:prose-invert light"><p><strong>Course Title: Basic Python</strong></p><p><strong>Course Description:</strong></p><p>Begin your journey into the world of programming with our <strong>Basic Python</strong> course. This course is designed for beginners with little to no prior programming experience and provides a solid foundation in Python, one of the most popular and versatile programming languages today.</p><p><strong>Key Features:</strong></p><ul><li><strong>Introduction to Python:</strong> Learn the basics of Python programming, including syntax, variables, and data types.</li><li><strong>Control Structures:</strong> Understand essential control structures such as loops and conditionals to control the flow of your programs.</li><li><strong>Functions:</strong> Discover how to write reusable code using functions, making your programs more modular and easier to manage.</li><li><strong>Data Structures:</strong> Get introduced to fundamental data structures like lists, tuples, and dictionaries to store and manipulate data efficiently.</li><li><strong>File Handling:</strong> Learn basic file input/output operations to read from and write to files.</li><li><strong>Error Handling:</strong> Gain an understanding of error handling to write more robust and reliable programs.</li><li><strong>Libraries and Modules:</strong> Explore how to use Python libraries and modules to extend the functionality of your programs.</li></ul><p>By the end of this course, you''ll have the skills to write simple Python programs, understand core programming concepts, and be ready to advance to more complex topics. Whether you''re aiming to start a career in programming, automate simple tasks, or just explore a new hobby, this Basic Python course is your gateway to the world of coding.</p><p><strong>Prerequisites:</strong></p><ul><li>No prior programming experience required</li><li>Basic computer literacy</li></ul><p>Join us and take the first step towards becoming a proficient Python programmer!</p></div>', 4.0, '2024-04-15 11:09:29.488151+00', '2024-04-15 11:09:29.488151+00', '9ba179ed-d26d-4828-a0f6-8836c2063992', '2024-07-20 07:51:27.603388+00', '9ba179ed-d26d-4828-a0f6-8836c2063992', '2024-07-20 07:51:27.603388+00');
INSERT INTO "public"."certificate_course" ("id", "topic_id", "name", "skill_level", "description", "avg_rating", "start_time", "end_time", "created_by", "created_at", "updated_by", "updated_at") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb16', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'Intermediate Python', 'INTERMEDIATE', '<div class="flex w-full flex-col gap-1 juice:empty:hidden juice:first:pt-[3px]"><div class="markdown prose w-full break-words dark:prose-invert light"><p><strong>Course Title: Intermediate Python</strong></p><p><strong>Course Description:</strong></p><p>Unlock the next level of your Python programming skills with our <strong>Intermediate Python</strong> course. Designed for those with a basic understanding of Python, this course dives deeper into the language, enhancing your ability to develop robust, efficient, and versatile code.</p><p><strong>Key Features:</strong></p><ul><li><strong>Advanced Data Structures:</strong> Master complex data structures like sets, dictionaries, and comprehensions to write more efficient code.</li><li><strong>Object-Oriented Programming:</strong> Gain a solid foundation in OOP principles, learning how to design and implement Python classes and objects effectively.</li><li><strong>Modules and Packages:</strong> Understand how to create and use modules and packages to organize your code better and reuse it across multiple projects.</li><li><strong>Error Handling:</strong> Learn advanced techniques for managing errors and exceptions to build more reliable programs.</li><li><strong>File I/O:</strong> Explore advanced file input/output operations to handle various file formats and data streams.</li><li><strong>Regular Expressions:</strong> Get introduced to regular expressions for powerful text processing capabilities.</li><li><strong>Libraries and Frameworks:</strong> Discover popular Python libraries and frameworks that can help streamline your development process.</li></ul><p>By the end of this course, you''ll be equipped with the skills and confidence to tackle more complex programming challenges and contribute to larger projects. Whether you''re looking to advance your career, prepare for a technical role, or simply enhance your coding abilities, this Intermediate Python course is the perfect stepping stone.</p><p><strong>Prerequisites:</strong></p><ul><li>Basic knowledge of Python programming</li><li>Familiarity with fundamental programming concepts</li></ul><p>Join us and take the next step in becoming a proficient Python programmer!</p></div></div>', 4.0, '2024-04-15 11:09:29.488151+00', '2024-04-15 11:09:29.488151+00', '9ba179ed-d26d-4828-a0f6-8836c2063992', '2024-07-20 07:51:27.603388+00', '9ba179ed-d26d-4828-a0f6-8836c2063992', '2024-07-20 07:51:27.603388+00');
INSERT INTO "public"."certificate_course" ("id", "topic_id", "name", "skill_level", "description", "avg_rating", "start_time", "end_time", "created_by", "created_at", "updated_by", "updated_at") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb17', '9ba179ed-d26d-4828-a0f6-8836c2063992', 'Advanced Python', 'ADVANCED', '<div class="markdown prose w-full break-words dark:prose-invert light"><p><strong>Course Title: Advanced Python</strong></p><p><strong>Course Description:</strong></p><p>Elevate your Python programming expertise with our <strong>Advanced Python</strong> course. This course is tailored for experienced Python developers who are ready to tackle sophisticated programming challenges and explore the full capabilities of the language.</p><p><strong>Key Features:</strong></p><ul><li><strong>Advanced Object-Oriented Programming:</strong> Dive deep into OOP principles, including inheritance, polymorphism, and metaclasses, to create more flexible and powerful code.</li><li><strong>Concurrency and Parallelism:</strong> Learn to write concurrent and parallel programs using threading, multiprocessing, and asynchronous programming.</li><li><strong>Decorators and Context Managers:</strong> Master the use of decorators and context managers to enhance code readability and functionality.</li><li><strong>Advanced Data Handling:</strong> Explore advanced techniques for data manipulation, including working with large datasets using libraries like Pandas and NumPy.</li><li><strong>Network Programming:</strong> Understand the principles of network programming to build applications that communicate over the internet using sockets and web APIs.</li><li><strong>Testing and Debugging:</strong> Gain expertise in advanced testing and debugging techniques to ensure your code is reliable and bug-free.</li><li><strong>Performance Optimization:</strong> Learn strategies for optimizing the performance of your Python applications, including profiling and efficient algorithm design.</li><li><strong>Metaprogramming:</strong> Explore the concepts of metaprogramming to write code that can manipulate itself.</li></ul><p>By the end of this course, you will be equipped with the advanced skills required to develop complex, high-performance Python applications. Whether you''re looking to solve intricate problems, contribute to cutting-edge projects, or simply refine your programming acumen, this Advanced Python course will help you achieve your goals.</p><p><strong>Prerequisites:</strong></p><ul><li>Solid understanding of intermediate Python concepts</li><li>Experience with basic object-oriented programming</li></ul><p>Join us and push the boundaries of your Python programming capabilities!</p></div>', 4.0, '2024-04-15 11:09:29.488151+00', '2024-04-15 11:09:29.488151+00', '9ba179ed-d26d-4828-a0f6-8836c2063992', '2024-07-20 07:51:27.603388+00', '9ba179ed-d26d-4828-a0f6-8836c2063992', '2024-07-20 07:51:27.603388+00');
INSERT INTO "public"."certificate_course" ("id", "topic_id", "name", "skill_level", "description", "avg_rating", "start_time", "end_time", "created_by", "created_at", "updated_by", "updated_at") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb19', 'd215b5f8-0249-4dc5-89a3-51fd148cfb46', 'Intermediate Java', 'INTERMEDIATE', 'This course is designed for intermediate Java programmers who want to enhance their skills and knowledge. It covers advanced topics such as object-oriented programming, data structures, algorithms, and more.', 0.0, '2024-04-15 11:09:29.488151+00', '2024-04-15 11:09:29.488151+00', '9ba179ed-d26d-4828-a0f6-8836c2063992', '2024-07-20 07:51:27.603388+00', '9ba179ed-d26d-4828-a0f6-8836c2063992', '2024-07-20 07:51:27.603388+00');
INSERT INTO "public"."certificate_course" ("id", "topic_id", "name", "skill_level", "description", "avg_rating", "start_time", "end_time", "created_by", "created_at", "updated_by", "updated_at") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb20', 'd215b5f8-0249-4dc5-89a3-51fd148cfb46', 'Advanced Java', 'ADVANCED', 'This course is designed for experienced Java programmers who want to master advanced Java concepts and techniques. It covers topics such as decorators, generators, metaclasses, and more.', 0.0, '2024-04-15 11:09:29.488151+00', '2024-04-15 11:09:29.488151+00', '9ba179ed-d26d-4828-a0f6-8836c2063992', '2024-07-20 07:51:27.603388+00', '9ba179ed-d26d-4828-a0f6-8836c2063992', '2024-07-20 07:51:27.603388+00');
INSERT INTO "public"."certificate_course" ("id", "topic_id", "name", "skill_level", "description", "avg_rating", "start_time", "end_time", "created_by", "created_at", "updated_by", "updated_at") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb21', 'd215b5f8-0249-4dc5-89a3-51fd148cfb48', 'Stacks and Queues', 'BASIC', 'This course is designed for beginners who want to learn about stacks and queues. It covers the basics of stacks and queues, including their implementation, operations, and applications.', 0.0, '2024-04-15 11:09:29.488151+00', '2024-04-15 11:09:29.488151+00', '9ba179ed-d26d-4828-a0f6-8836c2063992', '2024-07-20 07:51:27.603388+00', '9ba179ed-d26d-4828-a0f6-8836c2063992', '2024-07-20 07:51:27.603388+00');
INSERT INTO "public"."certificate_course" ("id", "topic_id", "name", "skill_level", "description", "avg_rating", "start_time", "end_time", "created_by", "created_at", "updated_by", "updated_at") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb22', 'd215b5f8-0249-4dc5-89a3-51fd148cfb48', 'Linked Lists', 'INTERMEDIATE', 'This course is designed for intermediate programmers who want to learn about linked lists. It covers the basics of linked lists, including their implementation, operations, and applications.', 0.0, '2024-04-15 11:09:29.488151+00', '2024-04-15 11:09:29.488151+00', '9ba179ed-d26d-4828-a0f6-8836c2063992', '2024-07-20 07:51:27.603388+00', '9ba179ed-d26d-4828-a0f6-8836c2063992', '2024-07-20 07:51:27.603388+00');
INSERT INTO "public"."certificate_course" ("id", "topic_id", "name", "skill_level", "description", "avg_rating", "start_time", "end_time", "created_by", "created_at", "updated_by", "updated_at") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb23', 'd215b5f8-0249-4dc5-89a3-51fd148cfb48', 'Binary Trees', 'ADVANCED', 'This course is designed for experienced programmers who want to learn about binary trees. It covers the basics of binary trees, including their implementation, operations, and applications.', 0.0, '2024-04-15 11:09:29.488151+00', '2024-04-15 11:09:29.488151+00', '9ba179ed-d26d-4828-a0f6-8836c2063992', '2024-07-20 07:51:27.603388+00', '9ba179ed-d26d-4828-a0f6-8836c2063992', '2024-07-20 07:51:27.603388+00');
INSERT INTO "public"."certificate_course" ("id", "topic_id", "name", "skill_level", "description", "avg_rating", "start_time", "end_time", "created_by", "created_at", "updated_by", "updated_at") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb18', 'd215b5f8-0249-4dc5-89a3-51fd148cfb46', 'Learn Java', 'BASIC', '<h3>Overview</h3><p>Welcome to the <strong>Learn Java</strong> course, designed specifically for beginners who are eager to dive into the world of Java programming. This course provides a thorough introduction to Java, covering the fundamental concepts and essential skills needed to become proficient in this popular programming language. Whether you''re aiming to build a strong foundation in programming or enhance your existing skills, this course is tailored to guide you through the basics of Java and beyond.</p><p><br></p><h3>What You Will Learn</h3><ol><li><strong>Java Syntax and Print Statements: </strong>Discover the core syntax of Java and understand how to use print statements effectively. Learn to display output and debug your code using various print methods.</li><li><strong>Variables and Data Types: </strong>Explore Java''s variable types and data structures. Gain insights into how different data types work and how to use them in your programs.</li><li><strong>Operators: </strong>Delve into the fundamental operators in Java, including arithmetic operations. Understand how to perform calculations and manipulate data using operators.</li><li><strong>Strings: </strong>Learn about string handling in Java, including the creation, manipulation, and comparison of string values. Master the use of strings to handle textual data.</li><li><strong>User Inputs: </strong>Discover how to capture and process user inputs. Learn about different methods for reading input, including <code>BufferedReader</code> and <code>Scanner</code>.</li><li><strong>Conditional Statements: </strong>Master control flow with conditional statements. Understand how to make decisions in your code using <code>if-else</code> and <code>switch</code> statements.</li><li><strong>Loops: </strong>Gain proficiency in using loops to execute repetitive tasks. Learn about different types of loops and how to use them effectively in your programs.</li><li><strong>Arrays: </strong>Explore the concept of arrays, including how to declare, initialize, and manipulate arrays. Learn about one-dimensional and multidimensional arrays to handle collections of data.</li><li><strong>Methods: </strong>Understand the structure and purpose of methods in Java. Learn to define, call, and use methods to organize and reuse code efficiently.</li></ol><h3>Features</h3><ul><li><strong>Hands-on Lessons:</strong> Each topic is accompanied by practical examples and exercises to reinforce your understanding.</li><li><strong>Comprehensive Resources:</strong> Access a variety of resources including detailed lessons, videos, and real-world examples to enhance your learning experience.</li><li><strong>Interactive Learning:</strong> Engage with interactive exercises and projects to apply what you''ve learned and build your programming skills.</li></ul><p><br></p><h3>Who Should Take This Course</h3><p>This course is ideal for:</p><ul><li>Beginners who want to start learning Java programming from scratch.</li><li>Individuals seeking to build a strong foundation in Java for further study or career advancement.</li><li>Anyone interested in understanding the basics of Java and applying them in real-world scenarios.</li></ul><p><br></p><h3>Conclusion</h3><p>By the end of this course, you will have a solid understanding of Java fundamentals and be equipped to tackle more advanced programming challenges. You''ll be prepared to continue your learning journey with more complex Java concepts and applications.</p><p>Join us in this exciting course and start your journey towards mastering Java programming today!</p>', 0.0, '2024-07-20 09:17:28.876+00', '2027-09-20 19:04:08.876+00', '9ba179ed-d26d-4828-a0f6-8836c2063992', '2024-07-20 07:51:27.603388+00', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 09:17:28.966831+00');
INSERT INTO "public"."certificate_course" ("id", "topic_id", "name", "skill_level", "description", "avg_rating", "start_time", "end_time", "created_by", "created_at", "updated_by", "updated_at") VALUES ('452371a5-2f58-4bfa-947b-af3140671057', 'd215b5f8-0249-4dc5-89a3-51fd148cfb93', 'Learn C++', 'BASIC', '<h1>Course Description: Learn C++ Crash Course</h1><p>Embark on a thrilling journey into the world of C++ programming with our <strong>"Learn C++ Crash Course"</strong>! This dynamic and hands-on course is designed to take you from a novice to a confident C++ programmer in no time. Perfect for beginners and those looking to solidify their programming skills, this course covers everything you need to know about C++.</p><h2>What You''ll Learn:</h2><h3>Chapter 1: Hello World</h3><p>Begin your adventure with the classic "Hello World" program. Learn about the structure of a C++ program, basic syntax, and how to set up your development environment.</p><h3>Chapter 2: Variables</h3><p>Discover the building blocks of C++ with variables. Understand different data types, variable declaration, initialization, and how to manipulate data.</p><h3>Chapter 3: Conditionals</h3><p>Dive into decision-making with conditionals. Master if statements, else if, else, and switch cases to control the flow of your programs.</p><h3>Chapter 4: Loops</h3><p>Unleash the power of loops to perform repetitive tasks efficiently. Explore for, while, and do-while loops, and understand their practical applications.</p><h3>Chapter 5: Vectors &amp; Arrays</h3><p>Get hands-on with data structures. Learn about arrays and vectors, their differences, and how to use them to store and manipulate collections of data.</p><h3>Chapter 6: Classes &amp; Objects</h3><p>Step into the realm of object-oriented programming. Create and work with classes and objects, understand constructors and destructors, and implement encapsulation, inheritance, and polymorphism.</p><h2>Why Enroll?</h2><ul><li><strong>Interactive Learning:</strong> Engage with practical examples, quizzes, and coding exercises to reinforce your understanding.</li><li><strong>Expert Guidance:</strong> Learn from industry professionals with years of experience in C++ programming.</li><li><strong>Comprehensive Curriculum:</strong> Cover all essential topics needed to build a solid foundation in C++.</li><li><strong>Flexible Schedule:</strong> Learn at your own pace with lifetime access to course materials.</li></ul><p>Join us in the <strong>"Learn C++ Crash Course"</strong> and take the first step towards becoming a proficient C++ programmer. Let''s code, create, and innovate together!</p><p>This paste expires in &lt;1 hour. Public IP access. Share whatever you see with others in seconds with Context.Terms of ServiceReport this</p>', NULL, '2024-07-20 09:46:43.455+00', '2027-09-20 19:33:23.455+00', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-10 13:43:04.895+00', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 09:46:43.577774+00');
INSERT INTO "public"."certificate_course" ("id", "topic_id", "name", "skill_level", "description", "avg_rating", "start_time", "end_time", "created_by", "created_at", "updated_by", "updated_at") VALUES ('2d2ebd9e-2829-495e-87f7-4f050a8f3628', 'd215b5f8-0249-4dc5-89a3-51fd148cfb92', 'Learn C', 'BASIC', '<h3>Course Description</h3><p>Unlock the world of programming with our <strong>"Learn C"</strong> certificate course! This course is tailored for beginners eager to dive into the fundamentals of C programming. Whether you''re looking to start a career in tech or simply want to expand your knowledge, this course offers a solid foundation in one of the most powerful and widely-used programming languages.</p><p><br></p><h3>What You''ll Learn</h3><ol><li><strong>Introduction, Outputting &amp; Math Operators: </strong>Start your journey by mastering the basics of C. Learn to write your first "Hello World" program, understand how to output data, and perform essential arithmetic operations. This foundational knowledge will set the stage for all your future coding endeavors.</li><li><strong>Pointers and Memory: </strong>Dive deep into the concept of pointers and memory management. Discover how to use pointers to optimize your code and manage memory effectively, providing you with a deeper understanding of how programs interact with computer memory.</li><li><strong>Variables and Data Types: </strong>Explore C’s variable types and data structures. Learn to declare and use various data types to handle data efficiently and accurately, making your programs more versatile and robust.</li><li><strong>Conditionals: </strong>Learn how to use conditionals to make your programs smarter. With <code>if</code> and <code>switch</code> statements, you’ll be able to control the flow of your programs based on different conditions, making your code more dynamic and responsive.</li><li><strong>Loops: </strong>Master the use of loops to execute repetitive tasks efficiently. Discover how <code>while</code> and <code>for</code> loops can help you automate repetitive operations, making your code more efficient and concise.</li><li><strong>Arrays: </strong>Understand arrays, a fundamental data structure in C. Learn to declare, initialize, and manipulate arrays to handle collections of data effectively, streamlining your programming tasks.</li><li><strong>Strings: </strong>Delve into string manipulation, an essential skill for handling text data. Learn how to work with strings to perform various text operations, enhancing the functionality of your programs.</li><li><strong>Functions and Structures: </strong>Elevate your programming skills by exploring functions and structures. Learn how to define and use functions to organize your code and create reusable components. Understand structures to group related data, making your code more modular and maintainable.</li></ol><p><br></p><h3>Why Enroll?</h3><ul><li><strong>Practical Learning</strong>: Engage in hands-on exercises that solidify your understanding and skills.</li><li><strong>Expert Guidance</strong>: Benefit from a course designed to provide a clear and comprehensive introduction to C programming.</li><li><strong>Career-Ready Skills</strong>: Gain essential programming skills that are highly valued in the tech industry, laying the groundwork for further study and career advancement.</li></ul><p><br></p><p>Join the <strong>"Learn C"</strong> course today and embark on your journey to becoming a proficient C programmer!</p>', NULL, '2024-07-20 10:08:56.181+00', '2027-09-20 19:55:36.181+00', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 07:57:26.179961+00', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 10:08:56.255418+00');


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
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb23', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7'),
    ('452371a5-2f58-4bfa-947b-af3140671057', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('452371a5-2f58-4bfa-947b-af3140671057', 'b029f559-52a8-4699-b595-71161498ed8c'),
    ('452371a5-2f58-4bfa-947b-af3140671057', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7'),
    -- add more for cer course id 452371a5-2f58-4bfa-947b-af3140671057
    ('452371a5-2f58-4bfa-947b-af3140671057', '39328bcf-8af6-44fc-9ae9-247f953ee2a2'),
    ('452371a5-2f58-4bfa-947b-af3140671057', '2d7ed5a0-fb21-4927-9a25-647c17d29668'),
    ('2d2ebd9e-2829-495e-87f7-4f050a8f3628', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('2d2ebd9e-2829-495e-87f7-4f050a8f3628', 'b029f559-52a8-4699-b595-71161498ed8c'),
    ('2d2ebd9e-2829-495e-87f7-4f050a8f3628', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7');

-- each user can only review a course once
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
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb23', 'd215b5f8-0249-4dc5-89a3-51fd148cfb17', 3, 'Okay course. Could be better.', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb24', '452371a5-2f58-4bfa-947b-af3140671057', 5, 'Great course! I learned a lot from it.', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb25', '452371a5-2f58-4bfa-947b-af3140671057', 4, 'Good course! I enjoyed it.', 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb26', '452371a5-2f58-4bfa-947b-af3140671057', 3, 'Okay course. Could be better.', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb27', '452371a5-2f58-4bfa-947b-af3140671057', 5, 'Excellent course', '39328bcf-8af6-44fc-9ae9-247f953ee2a2', '39328bcf-8af6-44fc-9ae9-247f953ee2a2'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb28', '452371a5-2f58-4bfa-947b-af3140671057', 5, 'The best course ever!', '2d7ed5a0-fb21-4927-9a25-647c17d29668', '2d7ed5a0-fb21-4927-9a25-647c17d29668'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb29', '2d2ebd9e-2829-495e-87f7-4f050a8f3628', 5, 'Great course! I learned a lot from it.', '9ba179ed-d26d-4828-a0f6-8836c2063992', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb30', '2d2ebd9e-2829-495e-87f7-4f050a8f3628', 4, 'Good course! I enjoyed it.', 'b029f559-52a8-4699-b595-71161498ed8c', 'b029f559-52a8-4699-b595-71161498ed8c'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb31', '2d2ebd9e-2829-495e-87f7-4f050a8f3628', 3, 'Okay course. Could be better.', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7');


INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb15', 'd215b5f8-0249-4dc5-89a3-51fd148cfb15', 1, 'Introduction to Python', 'This chapter introduces Python programming and covers basic concepts such as data types, control structures, and functions.', '9ba179ed-d26d-4828-a0f6-8836c2063992', '2024-07-20 07:51:27.606514+00', '9ba179ed-d26d-4828-a0f6-8836c2063992', '2024-07-20 07:51:27.606514+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb16', 'd215b5f8-0249-4dc5-89a3-51fd148cfb15', 2, 'Advanced Python Programming', 'This chapter covers advanced Python programming topics such as object-oriented programming, data structures, and algorithms.', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 07:51:27.606514+00', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 07:51:27.606514+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb17', 'd215b5f8-0249-4dc5-89a3-51fd148cfb15', 3, 'Python Projects', 'This chapter focuses on building real-world Python projects to apply the knowledge and skills learned in the previous chapters.', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', '2024-07-20 07:51:27.606514+00', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', '2024-07-20 07:51:27.606514+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb18', 'd215b5f8-0249-4dc5-89a3-51fd148cfb16', 1, 'Introduction to Java', 'This chapter introduces Java programming and covers basic concepts such as data types, control structures, and functions.', '9ba179ed-d26d-4828-a0f6-8836c2063992', '2024-07-20 07:51:27.606514+00', '9ba179ed-d26d-4828-a0f6-8836c2063992', '2024-07-20 07:51:27.606514+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb19', 'd215b5f8-0249-4dc5-89a3-51fd148cfb16', 2, 'Advanced Java Programming', 'This chapter covers advanced Java programming topics such as object-oriented programming, data structures, and algorithms.', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 07:51:27.606514+00', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 07:51:27.606514+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb20', 'd215b5f8-0249-4dc5-89a3-51fd148cfb16', 3, 'Java Projects', 'This chapter focuses on building real-world Java projects to apply the knowledge and skills learned in the previous chapters.', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', '2024-07-20 07:51:27.606514+00', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', '2024-07-20 07:51:27.606514+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb21', 'd215b5f8-0249-4dc5-89a3-51fd148cfb17', 1, 'Introduction to Stacks and Queues', 'This chapter introduces stacks and queues and covers basic concepts such as implementation, operations, and applications.', '9ba179ed-d26d-4828-a0f6-8836c2063992', '2024-07-20 07:51:27.606514+00', '9ba179ed-d26d-4828-a0f6-8836c2063992', '2024-07-20 07:51:27.606514+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb22', 'd215b5f8-0249-4dc5-89a3-51fd148cfb17', 2, 'Linked Lists', 'This chapter covers linked lists and their implementation, operations, and applications.', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 07:51:27.606514+00', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 07:51:27.606514+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb23', 'd215b5f8-0249-4dc5-89a3-51fd148cfb17', 3, 'Binary Trees', 'This chapter covers binary trees and their implementation, operations, and applications.', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', '2024-07-20 07:51:27.606514+00', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', '2024-07-20 07:51:27.606514+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb27', 'd215b5f8-0249-4dc5-89a3-51fd148cfb19', 1, 'Introduction to Stacks and Queues', 'This chapter introduces stacks and queues and covers basic concepts such as implementation, operations, and applications.', '9ba179ed-d26d-4828-a0f6-8836c2063992', '2024-07-20 07:51:27.606514+00', '9ba179ed-d26d-4828-a0f6-8836c2063992', '2024-07-20 07:51:27.606514+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb28', 'd215b5f8-0249-4dc5-89a3-51fd148cfb19', 2, 'Linked Lists', 'This chapter covers linked lists and their implementation, operations, and applications.', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 07:51:27.606514+00', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 07:51:27.606514+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb29', 'd215b5f8-0249-4dc5-89a3-51fd148cfb19', 3, 'Binary Trees', 'This chapter covers binary trees and their implementation, operations, and applications.', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', '2024-07-20 07:51:27.606514+00', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', '2024-07-20 07:51:27.606514+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb30', 'd215b5f8-0249-4dc5-89a3-51fd148cfb20', 1, 'Introduction to Stacks and Queues', 'This chapter introduces stacks and queues and covers basic concepts such as implementation, operations, and applications.', '9ba179ed-d26d-4828-a0f6-8836c2063992', '2024-07-20 07:51:27.606514+00', '9ba179ed-d26d-4828-a0f6-8836c2063992', '2024-07-20 07:51:27.606514+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb31', 'd215b5f8-0249-4dc5-89a3-51fd148cfb20', 2, 'Linked Lists', 'This chapter covers linked lists and their implementation, operations, and applications.', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 07:51:27.606514+00', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 07:51:27.606514+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb32', 'd215b5f8-0249-4dc5-89a3-51fd148cfb20', 3, 'Binary Trees', 'This chapter covers binary trees and their implementation, operations, and applications.', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', '2024-07-20 07:51:27.606514+00', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', '2024-07-20 07:51:27.606514+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb33', 'd215b5f8-0249-4dc5-89a3-51fd148cfb21', 1, 'Introduction to Stacks and Queues', 'This chapter introduces stacks and queues and covers basic concepts such as implementation, operations, and applications.', '9ba179ed-d26d-4828-a0f6-8836c2063992', '2024-07-20 07:51:27.606514+00', '9ba179ed-d26d-4828-a0f6-8836c2063992', '2024-07-20 07:51:27.606514+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb34', 'd215b5f8-0249-4dc5-89a3-51fd148cfb21', 2, 'Linked Lists', 'This chapter covers linked lists and their implementation, operations, and applications.', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 07:51:27.606514+00', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 07:51:27.606514+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb35', 'd215b5f8-0249-4dc5-89a3-51fd148cfb21', 3, 'Binary Trees', 'This chapter covers binary trees and their implementation, operations, and applications.', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', '2024-07-20 07:51:27.606514+00', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', '2024-07-20 07:51:27.606514+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb36', 'd215b5f8-0249-4dc5-89a3-51fd148cfb22', 1, 'Introduction to Stacks and Queues', 'This chapter introduces stacks and queues and covers basic concepts such as implementation, operations, and applications.', '9ba179ed-d26d-4828-a0f6-8836c2063992', '2024-07-20 07:51:27.606514+00', '9ba179ed-d26d-4828-a0f6-8836c2063992', '2024-07-20 07:51:27.606514+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb37', 'd215b5f8-0249-4dc5-89a3-51fd148cfb22', 2, 'Linked Lists', 'This chapter covers linked lists and their implementation, operations, and applications.', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 07:51:27.606514+00', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 07:51:27.606514+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb38', 'd215b5f8-0249-4dc5-89a3-51fd148cfb22', 3, 'Binary Trees', 'This chapter covers binary trees and their implementation, operations, and applications.', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', '2024-07-20 07:51:27.606514+00', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', '2024-07-20 07:51:27.606514+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb39', 'd215b5f8-0249-4dc5-89a3-51fd148cfb23', 1, 'Introduction to Stacks and Queues', 'This chapter introduces stacks and queues and covers basic concepts such as implementation, operations, and applications.', '9ba179ed-d26d-4828-a0f6-8836c2063992', '2024-07-20 07:51:27.606514+00', '9ba179ed-d26d-4828-a0f6-8836c2063992', '2024-07-20 07:51:27.606514+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb40', 'd215b5f8-0249-4dc5-89a3-51fd148cfb23', 2, 'Linked Lists', 'This chapter covers linked lists and their implementation, operations, and applications.', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 07:51:27.606514+00', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 07:51:27.606514+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb41', 'd215b5f8-0249-4dc5-89a3-51fd148cfb23', 3, 'Binary Trees', 'This chapter covers binary trees and their implementation, operations, and applications.', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', '2024-07-20 07:51:27.606514+00', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7', '2024-07-20 07:51:27.606514+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('de760849-3377-4334-8d14-ba89ca34e927', 'd215b5f8-0249-4dc5-89a3-51fd148cfb18', 0, 'Print statement and Java Syntax', '<p>Learn the basic concepts of Java, one of the most widely used object-oriented programming languages.</p>', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 09:17:28.974485+00', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 09:17:28.974485+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('a6ba8a08-84ae-4655-8406-05d181e58ae3', 'd215b5f8-0249-4dc5-89a3-51fd148cfb18', 1, 'Variables and Data Types', '<p><br></p>', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 09:17:29.005581+00', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 09:17:29.005582+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('9ce115e6-aaef-4743-9fb2-db64c86c4acd', 'd215b5f8-0249-4dc5-89a3-51fd148cfb18', 2, 'Operators', '<p><br></p>', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 09:17:29.00836+00', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 09:17:29.008361+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('4bbff1c6-51e5-4c6d-b5eb-0335f9b718cd', 'd215b5f8-0249-4dc5-89a3-51fd148cfb18', 3, 'Strings', '', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 09:17:29.011627+00', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 09:17:29.011627+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('567446cf-e4dd-45a6-93c1-9b539a9c4f2e', 'd215b5f8-0249-4dc5-89a3-51fd148cfb18', 4, 'User Inputs', '', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 09:17:29.015518+00', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 09:17:29.015519+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('259f29ff-ba18-4417-bafd-9e1c4c1319d2', 'd215b5f8-0249-4dc5-89a3-51fd148cfb18', 5, 'Conditional Statements', '', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 09:17:29.01767+00', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 09:17:29.017671+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('34b88085-66f2-47cc-85d9-0db02d5dfa64', 'd215b5f8-0249-4dc5-89a3-51fd148cfb18', 6, 'Loops', '', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 09:17:29.020402+00', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 09:17:29.020402+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('b995e375-ff54-4265-b81a-5c2b1f6f3b86', 'd215b5f8-0249-4dc5-89a3-51fd148cfb18', 7, 'Arrays', '', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 09:17:29.022025+00', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 09:17:29.022025+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('62513510-6e1b-4548-8b73-95427e766bb3', 'd215b5f8-0249-4dc5-89a3-51fd148cfb18', 8, ' Methods in Java', '', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 09:17:29.023454+00', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 09:17:29.023454+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('6c08d79b-4fd6-4369-99ea-322078e55307', '452371a5-2f58-4bfa-947b-af3140671057', 0, 'Hello World', '<p><span style="color: rgb(16, 22, 47);">Write, compile, and execute your first C++ program!</span></p>', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 09:46:43.606642+00', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 09:46:43.606644+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('88515ed4-0b74-47d8-9279-0d47c2a21ef4', '452371a5-2f58-4bfa-947b-af3140671057', 1, 'Variables', '<p>Introduction to variables and basic data types.</p>', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 09:46:43.664991+00', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 09:46:43.664995+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('75c1b5b9-370d-4c24-9335-56c5dbd43c51', '452371a5-2f58-4bfa-947b-af3140671057', 2, 'Conditionals & Logic', '<p>Learn how to use conditionals and logic to build programs that generate different outcomes.</p>', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 09:46:43.685545+00', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 09:46:43.685549+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('e099d057-b400-456b-b01a-54c5be0364d4', '452371a5-2f58-4bfa-947b-af3140671057', 3, 'Loops', '<p>Loops, loops, loops, loops, loops.</p>', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 09:46:43.70497+00', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 09:46:43.704974+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('e31671c0-e26f-46e7-ba81-6d954a51c37c', '452371a5-2f58-4bfa-947b-af3140671057', 4, 'Vectors', '<p>Learn how to use C++ vectors, a great way to keep your data organized.</p><p><br></p><p><br></p>', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 09:46:43.716337+00', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 09:46:43.716341+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('2a90b255-ca79-4fba-af46-952ac41a0502', '452371a5-2f58-4bfa-947b-af3140671057', 5, 'Functions', '<p>Use C++ functions to write more flexible, modular, reusable code.</p>', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 09:46:43.725628+00', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 09:46:43.725631+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('3e3699ce-1b80-4236-873f-05b17522e25f', '452371a5-2f58-4bfa-947b-af3140671057', 6, 'Classes & Objects', '<p>Use C++ classes and objects to build more scalable, modular programs.</p>', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 09:46:43.738072+00', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 09:46:43.738076+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('80124868-3c09-4967-b846-43ba04c064f7', '2d2ebd9e-2829-495e-87f7-4f050a8f3628', 0, 'Introduction, Outputting & Math Operators', '', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 10:08:56.261578+00', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 10:08:56.261578+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('3c8a381e-8a85-41ca-b07e-4d792c5571fd', '2d2ebd9e-2829-495e-87f7-4f050a8f3628', 1, 'Pointers and Memory', '', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 10:08:56.269486+00', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 10:08:56.269486+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('57fe22fb-ed2b-45d2-b1c0-5e8fca623cce', '2d2ebd9e-2829-495e-87f7-4f050a8f3628', 2, 'Variables and Data Types', '', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 10:08:56.271772+00', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 10:08:56.271773+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('99e1bbc1-92cd-4fff-b1ea-5151a6154c4f', '2d2ebd9e-2829-495e-87f7-4f050a8f3628', 3, 'Conditionals', '', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 10:08:56.274481+00', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 10:08:56.274482+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('c273fe40-49ef-42c6-8fd1-b732a96d281f', '2d2ebd9e-2829-495e-87f7-4f050a8f3628', 4, 'Loops', '', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 10:08:56.276718+00', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 10:08:56.276719+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('9fe625bc-0d96-40e2-9b4d-ce58a1d1ff09', '2d2ebd9e-2829-495e-87f7-4f050a8f3628', 5, 'Arrays', '', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 10:08:56.279616+00', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 10:08:56.279617+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('f1d16ebc-8ac1-4aa0-8380-1c0158099b5e', '2d2ebd9e-2829-495e-87f7-4f050a8f3628', 6, 'Strings', '', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 10:08:56.281483+00', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 10:08:56.281484+00');
INSERT INTO "public"."chapter" ("id", "certificate_course_id", "no", "title", "description", "created_by", "created_at", "updated_by", "updated_at") VALUES ('f142b4d8-75e1-4abf-a62a-1aade21ba327', '2d2ebd9e-2829-495e-87f7-4f050a8f3628', 7, 'Functions and Structures', '', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 10:08:56.283437+00', 'b029f559-52a8-4699-b595-71161498ed8c', '2024-07-20 10:08:56.283439+00');


INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb15', 1, 'd215b5f8-0249-4dc5-89a3-51fd148cfb15', 'CODE', 'Question 1', 'b6484e21-6937-489c-b031-b71767994221', NULL, NULL);
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb16', 2, 'd215b5f8-0249-4dc5-89a3-51fd148cfb15', 'LESSON', 'This is a lesson on Python programming.', NULL, '<p>This is a lesson on Python programming.</p>', NULL);
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb17', 3, 'd215b5f8-0249-4dc5-89a3-51fd148cfb15', 'VIDEO', 'Video on Python programming', NULL, NULL, 'https://youtu.be/rfscVS0vtbw?si=nAn_wxmKoIdCMwGy');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb18', 4, 'd215b5f8-0249-4dc5-89a3-51fd148cfb15', 'CODE', 'Question 2', 'b6484e21-6937-489c-b031-b71767994737', NULL, NULL);
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb19', 5, 'd215b5f8-0249-4dc5-89a3-51fd148cfb15', 'LESSON', 'This is a lesson on Python programming.', NULL, '<p>This is a lesson on Python programming.</p>', NULL);
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb20', 6, 'd215b5f8-0249-4dc5-89a3-51fd148cfb15', 'VIDEO', 'Video on Python programming', NULL, NULL, 'https://youtu.be/rfscVS0vtbw?si=nAn_wxmKoIdCMwGy');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb21', 1, 'd215b5f8-0249-4dc5-89a3-51fd148cfb16', 'CODE', 'Question 1', 'b6484e21-6937-489c-b031-b71767994738', NULL, NULL);
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb22', 2, 'd215b5f8-0249-4dc5-89a3-51fd148cfb16', 'LESSON', 'This is a lesson on Python programming.', NULL, '<p>This is a lesson on Python programming.</p>', NULL);
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb23', 3, 'd215b5f8-0249-4dc5-89a3-51fd148cfb16', 'VIDEO', 'Video on Python programming', NULL, NULL, 'https://youtu.be/rfscVS0vtbw?si=nAn_wxmKoIdCMwGy');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb24', 4, 'd215b5f8-0249-4dc5-89a3-51fd148cfb16', 'CODE', 'Question 2', 'b6484e21-6937-489c-b031-b71767994739', NULL, NULL);
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb25', 5, 'd215b5f8-0249-4dc5-89a3-51fd148cfb16', 'LESSON', 'This is a lesson on Python programming.', NULL, '<p>This is a lesson on Python programming.</p>', NULL);
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb26', 6, 'd215b5f8-0249-4dc5-89a3-51fd148cfb16', 'VIDEO', 'Video on Python programming', NULL, NULL, 'https://youtu.be/rfscVS0vtbw?si=nAn_wxmKoIdCMwGy');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb27', 1, 'd215b5f8-0249-4dc5-89a3-51fd148cfb17', 'CODE', 'Question 1', 'b6484e21-6937-489c-b031-b71767994740', NULL, NULL);
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb28', 2, 'd215b5f8-0249-4dc5-89a3-51fd148cfb17', 'LESSON', 'This is a lesson on Python programming.', NULL, '<p>This is a lesson on Python programming.</p>', NULL);
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb29', 3, 'd215b5f8-0249-4dc5-89a3-51fd148cfb17', 'VIDEO', 'Video on Python programming', NULL, NULL, 'https://youtu.be/rfscVS0vtbw?si=nAn_wxmKoIdCMwGy');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb30', 4, 'd215b5f8-0249-4dc5-89a3-51fd148cfb17', 'CODE', 'Question 2', 'b6484e21-6937-489c-b031-b71767994741', NULL, NULL);
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb31', 5, 'd215b5f8-0249-4dc5-89a3-51fd148cfb17', 'LESSON', 'This is a lesson on Python programming.', NULL, '<p>This is a lesson on Python programming.</p>', NULL);
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb32', 6, 'd215b5f8-0249-4dc5-89a3-51fd148cfb17', 'VIDEO', 'Video on Python programming', NULL, NULL, 'https://youtu.be/rfscVS0vtbw?si=nAn_wxmKoIdCMwGy');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb33', 1, 'd215b5f8-0249-4dc5-89a3-51fd148cfb18', 'CODE', 'Question 1', 'b6484e21-6937-489c-b031-b71767994221', NULL, NULL);
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb34', 2, 'd215b5f8-0249-4dc5-89a3-51fd148cfb18', 'LESSON', 'This is a lesson on Python programming.', NULL, '<p>This is a lesson on Python programming.</p>', NULL);
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb35', 3, 'd215b5f8-0249-4dc5-89a3-51fd148cfb18', 'VIDEO', 'Video on Python programming', NULL, NULL, 'https://youtu.be/rfscVS0vtbw?si=nAn_wxmKoIdCMwGy');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb36', 4, 'd215b5f8-0249-4dc5-89a3-51fd148cfb18', 'LESSON', 'This is a lesson on Python programming.', NULL, '<p>This is a lesson on Python programming.</p>', NULL);
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb37', 5, 'd215b5f8-0249-4dc5-89a3-51fd148cfb18', 'VIDEO', 'Video on Python programming', NULL, NULL, 'https://youtu.be/rfscVS0vtbw?si=nAn_wxmKoIdCMwGy');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb38', 1, 'd215b5f8-0249-4dc5-89a3-51fd148cfb19', 'LESSON', 'This is a lesson on Python programming.', NULL, '<p>This is a lesson on Python programming.</p>', NULL);
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb39', 2, 'd215b5f8-0249-4dc5-89a3-51fd148cfb19', 'VIDEO', 'Video on Python programming', NULL, NULL, 'https://youtu.be/rfscVS0vtbw?si=nAn_wxmKoIdCMwGy');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb40', 1, 'd215b5f8-0249-4dc5-89a3-51fd148cfb20', 'LESSON', 'This is a lesson on Python programming.', NULL, '<p>This is a lesson on Python programming.</p>', NULL);
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb41', 2, 'd215b5f8-0249-4dc5-89a3-51fd148cfb20', 'VIDEO', 'Video on Python programming', NULL, NULL, 'https://youtu.be/rfscVS0vtbw?si=nAn_wxmKoIdCMwGy');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('f38dfeea-9040-4734-bb79-4b5e8fafc884', 0, 'c273fe40-49ef-42c6-8fd1-b732a96d281f', 'LESSON', 'Loops In C', NULL, '<h3>Introduction</h3><p>Loops are essential in C programming for repeating a block of code multiple times based on a condition. They help automate repetitive tasks and process data efficiently. C provides several types of loops: <code>for</code>, <code>while</code>, and <code>do-while</code>.</p><h3>The <code>for</code> Loop</h3><p>The <code>for</code> loop is used when the number of iterations is known beforehand. It includes three parts: initialization, condition, and increment/decrement.</p><p><strong>Syntax:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
for (initialization; condition; increment/decrement) {
    // Code to execute
}
</pre><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
#include &lt;stdio.h&gt;

int main() {
    for (int i = 1; i &lt;= 5; i++) {
        printf("Iteration %d\n", i);
    }
    return 0;
}
</pre><p>In this example, the loop initializes <code>i</code> to 1, checks if <code>i</code> is less than or equal to 5, and increments <code>i</code> by 1 each time. The loop prints the current iteration number from 1 to 5.</p><h3>The <code>while</code> Loop</h3><p>The <code>while</code> loop is used when the number of iterations is not known beforehand and depends on a condition being true.</p><p><strong>Syntax:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
while (condition) {
    // Code to execute
}
</pre><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
#include &lt;stdio.h&gt;

int main() {
    int i = 1;
    while (i &lt;= 5) {
        printf("Iteration %d\n", i);
        i++;
    }
    return 0;
}
</pre><p>In this example, the loop starts with <code>i</code> set to 1. As long as <code>i</code> is less than or equal to 5, the loop prints the current iteration number and increments <code>i</code>.</p><h3>The <code>do-while</code> Loop</h3><p>The <code>do-while</code> loop is similar to the <code>while</code> loop but guarantees that the loop body will execute at least once before the condition is tested.</p><p><strong>Syntax:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
do {
    // Code to execute
} while (condition);
</pre><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
#include &lt;stdio.h&gt;

int main() {
    int i = 1;
    do {
        printf("Iteration %d\n", i);
        i++;
    } while (i &lt;= 5);
    return 0;
}
</pre><p>In this example, the loop prints the current iteration number and increments <code>i</code>, and it checks the condition after executing the loop body.</p><h3>Loop Control Statements</h3><p>C provides control statements to alter the flow of loops:</p><ul><li><code><strong>break</strong></code><strong>:</strong> Exits the loop immediately, regardless of the condition.</li><li><strong>Example:</strong></li></ul><pre class="ql-syntax" spellcheck="false">c
Copy code
for (int i = 1; i &lt;= 10; i++) {
    if (i == 6) {
        break;
    }
    printf("Iteration %d\n", i);
}
</pre><ul><li>This loop will print iteration numbers from 1 to 5 and then exit when <code>i</code> equals 6.</li><li><code><strong>continue</strong></code><strong>:</strong> Skips the rest of the code in the current iteration and proceeds to the next iteration of the loop.</li><li><strong>Example:</strong></li></ul><pre class="ql-syntax" spellcheck="false">c
Copy code
for (int i = 1; i &lt;= 10; i++) {
    if (i % 2 == 0) {
        continue;
    }
    printf("Odd number %d\n", i);
}
</pre><ul><li>This loop prints only the odd numbers between 1 and 10, skipping the even numbers.</li></ul><h3>Nested Loops</h3><p>You can nest loops within each other to handle more complex scenarios.</p><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
#include &lt;stdio.h&gt;

int main() {
    for (int i = 1; i &lt;= 3; i++) {
        for (int j = 1; j &lt;= 3; j++) {
            printf("i = %d, j = %d\n", i, j);
        }
    }
    return 0;
}
</pre><p>In this example, the outer loop iterates three times, and for each iteration of the outer loop, the inner loop also iterates three times, printing the values of <code>i</code> and <code>j</code>.</p><h3>Conclusion</h3><p>Loops are powerful constructs in C programming that allow you to repeat actions and process data efficiently. Understanding how to use <code>for</code>, <code>while</code>, and <code>do-while</code> loops, as well as loop control statements, is essential for writing effective and efficient C code.</p>', '');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('7fd2dd46-6553-42bf-916f-9bd730df08ab', 1, 'c273fe40-49ef-42c6-8fd1-b732a96d281f', 'VIDEO', 'C Programming Tutorial for Beginners - While Loops', NULL, '', 'https://www.youtube.com/watch?v=KJgsSFOSQv0&t=8983s');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('b632eb20-a320-4db5-b3c5-dded099b04af', 2, 'c273fe40-49ef-42c6-8fd1-b732a96d281f', 'VIDEO', 'C Programming Tutorial for Beginners - For Loops', NULL, '', 'https://www.youtube.com/watch?v=KJgsSFOSQv0&t=10211s');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('0ab30091-fef7-4596-9040-3cf680afd9d5', 0, '9fe625bc-0d96-40e2-9b4d-ce58a1d1ff09', 'LESSON', 'Arrays In C', NULL, '<h3>Introduction</h3><p>Arrays in C are a data structure that allows you to store multiple values of the same type in a single variable. They are useful for managing collections of data, such as lists or tables, where each element is accessed using an index. This lesson covers the basics of arrays, including declaration, initialization, and manipulation.</p><h3>Declaring Arrays</h3><p>To use an array, you first need to declare it by specifying the type of its elements and the number of elements it will hold.</p><p><strong>Syntax:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
dataType arrayName[arraySize];
</pre><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
int numbers[5];
</pre><p>In this example, <code>numbers</code> is an array of integers capable of holding 5 elements.</p><h3>Initializing Arrays</h3><p>After declaring an array, you can initialize it with values either at the time of declaration or later in the code.</p><ul><li><strong>Initialization at Declaration:</strong></li><li>You can initialize an array with specific values when you declare it.</li><li><strong>Syntax:</strong></li></ul><pre class="ql-syntax" spellcheck="false">c
Copy code
dataType arrayName[] = {value1, value2, value3, ...};
</pre><ul><li><strong>Example:</strong></li></ul><pre class="ql-syntax" spellcheck="false">c
Copy code
int numbers[] = {1, 2, 3, 4, 5};
</pre><ul><li>Here, <code>numbers</code> is initialized with five values. The size of the array is automatically determined by the number of values provided.</li><li><strong>Initialization After Declaration:</strong></li><li>You can also initialize an array after declaring it by assigning values to each element individually.</li><li><strong>Example:</strong></li></ul><pre class="ql-syntax" spellcheck="false">c
Copy code
int numbers[5];
numbers[0] = 1;
numbers[1] = 2;
numbers[2] = 3;
numbers[3] = 4;
numbers[4] = 5;
</pre><h3>Accessing Array Elements</h3><p>Array elements are accessed using their index, which starts from 0. You can read or modify elements using their index.</p><p><strong>Syntax:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
arrayName[index]
</pre><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
int numbers[] = {1, 2, 3, 4, 5};
int firstNumber = numbers[0]; // Access the first element
numbers[2] = 10; // Modify the third element
</pre><p>In this example, <code>firstNumber</code> is assigned the value <code>1</code>, and the third element of the <code>numbers</code> array is updated to <code>10</code>.</p><h3>Array Length</h3><p>The length of an array (i.e., the number of elements it holds) can be determined using the <code>sizeof</code> operator. This approach calculates the total size of the array and divides it by the size of an individual element.</p><p><strong>Syntax:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
int length = sizeof(arrayName) / sizeof(arrayName[0]);
</pre><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
int numbers[] = {1, 2, 3, 4, 5};
int length = sizeof(numbers) / sizeof(numbers[0]);
printf("Array length: %d\n", length);
</pre><p>In this example, <code>length</code> will be <code>5</code>, representing the number of elements in the <code>numbers</code> array.</p><h3>Iterating Through Arrays</h3><p>You can use loops to iterate through all elements of an array. This is useful for performing operations on each element.</p><ul><li><strong>Using a </strong><code><strong>for</strong></code><strong> Loop:</strong></li><li><strong>Example:</strong></li></ul><pre class="ql-syntax" spellcheck="false">c
Copy code
int numbers[] = {1, 2, 3, 4, 5};
for (int i = 0; i &lt; sizeof(numbers) / sizeof(numbers[0]); i++) {
    printf("%d\n", numbers[i]);
}
</pre><ul><li>This loop prints each element of the <code>numbers</code> array.</li><li><strong>Using an Enhanced </strong><code><strong>for</strong></code><strong> Loop (C99 Standard):</strong></li><li><strong>Example:</strong></li></ul><pre class="ql-syntax" spellcheck="false">c
Copy code
int numbers[] = {1, 2, 3, 4, 5};
for (int i : numbers) {
    printf("%d\n", i);
}
</pre><ul><li>This loop is more concise and iterates over each element of the array directly.</li></ul><h3>Multidimensional Arrays</h3><p>C also supports multidimensional arrays, such as 2D arrays, which can be thought of as arrays of arrays.</p><p><strong>Syntax:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
dataType arrayName[rowSize][columnSize];
</pre><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
int matrix[3][3] = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};
</pre><p>In this example, <code>matrix</code> is a 3x3 array.</p><ul><li><strong>Accessing Elements:</strong></li><li><strong>Example:</strong></li></ul><pre class="ql-syntax" spellcheck="false">c
Copy code
int value = matrix[1][2]; // Access the element in the second row, third column
</pre><ul><li><strong>Iterating Through a 2D Array:</strong></li><li><strong>Example:</strong></li></ul><pre class="ql-syntax" spellcheck="false">c
Copy code
for (int i = 0; i &lt; 3; i++) {
    for (int j = 0; j &lt; 3; j++) {
        printf("%d ", matrix[i][j]);
    }
    printf("\n");
}
</pre><ul><li>This loop prints each element of the 2D array in matrix form.</li></ul><h3>Conclusion</h3><p>Arrays are fundamental to C programming, allowing you to store and manage multiple values efficiently. Understanding how to declare, initialize, access, and manipulate arrays is crucial for working with collections of data. Multidimensional arrays further extend this concept, enabling the handling of more complex data structures.</p>', '');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('5c09c716-768f-4437-95a7-ade97ab4d13d', 1, '9fe625bc-0d96-40e2-9b4d-ce58a1d1ff09', 'VIDEO', 'C Programming Tutorial for Beginners - Arrays', NULL, '', 'https://www.youtube.com/watch?v=KJgsSFOSQv0&t=5189s');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('e3627884-b8ea-42d1-872a-0390f5d20a1d', 0, 'f1d16ebc-8ac1-4aa0-8380-1c0158099b5e', 'LESSON', 'Strings In C', NULL, '<h3>Introduction</h3><p>In C programming, strings are sequences of characters stored in an array. Unlike some other programming languages, C does not have a built-in string data type. Instead, strings are handled as arrays of characters, terminated by a special null character <code>''\0''</code>. This null terminator indicates the end of the string.</p><h3>Declaring Strings</h3><p>To declare a string in C, you create an array of characters. The size of the array should be sufficient to hold all characters, including the null terminator.</p><p><strong>Syntax:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
char stringName[size];
</pre><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
char greeting[6];
</pre><p>In this example, <code>greeting</code> can hold up to 5 characters plus the null terminator.</p><h3>Initializing Strings</h3><p>You can initialize a string at the time of declaration using double quotes. The compiler automatically includes the null terminator.</p><p><strong>Syntax:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
char stringName[] = "initialValue";
</pre><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
char greeting[] = "Hello";
</pre><p>In this example, <code>greeting</code> is initialized to "Hello", and the array size is automatically set to 6 (5 characters + 1 null terminator).</p><h3>Accessing String Characters</h3><p>You can access individual characters in a string using array indexing. Remember that the index starts from 0.</p><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
#include &lt;stdio.h&gt;

int main() {
    char greeting[] = "Hello";
    printf("First character: %c\n", greeting[0]); // H
    printf("Third character: %c\n", greeting[2]); // l
    return 0;
}
</pre><h3>String Functions</h3><p>C provides a standard library <code>&lt;string.h&gt;</code> with functions to manipulate strings. Here are some commonly used functions:</p><ul><li><code><strong>strlen()</strong></code>: Computes the length of a string (excluding the null terminator).</li><li><strong>Example:</strong></li></ul><pre class="ql-syntax" spellcheck="false">c
Copy code
#include &lt;stdio.h&gt;
#include &lt;string.h&gt;

int main() {
    char str[] = "Hello";
    printf("Length of string: %zu\n", strlen(str));
    return 0;
}
</pre><ul><li><code><strong>strcpy()</strong></code>: Copies a string from one location to another.</li><li><strong>Syntax:</strong></li></ul><pre class="ql-syntax" spellcheck="false">c
Copy code
char *strcpy(char *dest, const char *src);
</pre><ul><li><strong>Example:</strong></li></ul><pre class="ql-syntax" spellcheck="false">c
Copy code
#include &lt;stdio.h&gt;
#include &lt;string.h&gt;

int main() {
    char source[] = "Hello";
    char destination[6];
    strcpy(destination, source);
    printf("Destination string: %s\n", destination);
    return 0;
}
</pre><ul><li><code><strong>strcat()</strong></code>: Concatenates (appends) one string to the end of another.</li><li><strong>Syntax:</strong></li></ul><pre class="ql-syntax" spellcheck="false">c
Copy code
char *strcat(char *dest, const char *src);
</pre><ul><li><strong>Example:</strong></li></ul><pre class="ql-syntax" spellcheck="false">c
Copy code
#include &lt;stdio.h&gt;
#include &lt;string.h&gt;

int main() {
    char str1[20] = "Hello";
    char str2[] = " World";
    strcat(str1, str2);
    printf("Concatenated string: %s\n", str1);
    return 0;
}
</pre><ul><li><code><strong>strcmp()</strong></code>: Compares two strings.</li><li><strong>Syntax:</strong></li></ul><pre class="ql-syntax" spellcheck="false">c
Copy code
int strcmp(const char *str1, const char *str2);
</pre><ul><li><strong>Example:</strong></li></ul><pre class="ql-syntax" spellcheck="false">c
Copy code
#include &lt;stdio.h&gt;
#include &lt;string.h&gt;

int main() {
    char str1[] = "Hello";
    char str2[] = "Hello";
    int result = strcmp(str1, str2);
    if (result == 0) {
        printf("Strings are equal.\n");
    } else if (result &lt; 0) {
        printf("String 1 is less than String 2.\n");
    } else {
        printf("String 1 is greater than String 2.\n");
    }
    return 0;
}
</pre><h3>Reading Strings</h3><p>You can read strings from the user using <code>scanf()</code> or <code>fgets()</code>. <code>fgets()</code> is generally preferred because it handles input safely, preventing buffer overflow.</p><ul><li><strong>Using </strong><code><strong>scanf()</strong></code><strong>:</strong></li><li><strong>Example:</strong></li></ul><pre class="ql-syntax" spellcheck="false">c
Copy code
#include &lt;stdio.h&gt;

int main() {
    char name[50];
    printf("Enter your name: ");
    scanf("%49s", name); // Reads up to 49 characters
    printf("Hello, %s!\n", name);
    return 0;
}
</pre><ul><li><strong>Using </strong><code><strong>fgets()</strong></code><strong>:</strong></li><li><strong>Example:</strong></li></ul><pre class="ql-syntax" spellcheck="false">c
Copy code
#include &lt;stdio.h&gt;

int main() {
    char name[50];
    printf("Enter your name: ");
    fgets(name, sizeof(name), stdin); // Reads up to sizeof(name) - 1 characters
    printf("Hello, %s", name);
    return 0;
}
</pre><h3>String Literals</h3><p>String literals are constant strings used in your code. They are automatically null-terminated.</p><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
#include &lt;stdio.h&gt;

int main() {
    printf("This is a string literal.\n");
    return 0;
}
</pre><h3>Conclusion</h3><p>Strings in C are handled as arrays of characters, terminated by a null character. Understanding how to declare, initialize, and manipulate strings, along with using standard library functions, is essential for managing textual data in C programs.</p>', '');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('83d99377-5964-4261-9889-0707c4654969', 1, 'f1d16ebc-8ac1-4aa0-8380-1c0158099b5e', 'VIDEO', 'Strings in C', NULL, '', 'https://youtu.be/5TzFNouc0PE?si=VAJZKM9oetwPwgeh');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('f3a669a5-b4db-4ceb-8de5-d75af0d21d88', 0, 'f142b4d8-75e1-4abf-a62a-1aade21ba327', 'LESSON', 'Functions and Structures In C', NULL, '<h3>Functions</h3><p>In C programming, functions are blocks of code designed to perform a specific task. They help in organizing code, promoting reusability, and reducing redundancy. Functions can be called from other functions, allowing you to break down complex problems into simpler, manageable tasks.</p><h4>Defining Functions</h4><p>To define a function, you specify the return type, function name, and parameters (if any). The function body contains the code to be executed.</p><p><strong>Syntax:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
returnType functionName(parameters) {
    // Code to execute
    return value; // if returnType is not void
}
</pre><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
#include &lt;stdio.h&gt;

// Function declaration
int add(int a, int b);

// Function definition
int add(int a, int b) {
    return a + b;
}

int main() {
    int result = add(5, 3);
    printf("Sum: %d\n", result);
    return 0;
}
</pre><h4>Calling Functions</h4><p>You can call a function by using its name followed by parentheses. If the function requires parameters, pass them inside the parentheses.</p><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
int result = add(10, 20);
</pre><h4>Function Parameters and Return Types</h4><p>Functions can accept parameters to provide input values and return a value to the caller. The return type can be any valid data type, including <code>int</code>, <code>float</code>, <code>char</code>, etc. If a function does not return a value, use <code>void</code>.</p><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
float multiply(float x, float y) {
    return x * y;
}

void printMessage() {
    printf("This function does not return a value.\n");
}
</pre><h4>Function Overloading</h4><p>C does not support function overloading directly, meaning you cannot have multiple functions with the same name but different parameters. Instead, you can achieve similar functionality by using different names for functions.</p><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
int addInt(int a, int b) {
    return a + b;
}

float addFloat(float a, float b) {
    return a + b;
}
</pre><h3>Structures</h3><p>Structures (<code>struct</code>) in C are used to group related variables of different types into a single unit. They are useful for creating complex data types that model real-world entities.</p><h4>Defining Structures</h4><p>To define a structure, use the <code>struct</code> keyword followed by the structure name and its members enclosed in curly braces.</p><p><strong>Syntax:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
struct StructureName {
    dataType member1;
    dataType member2;
    // Additional members
};
</pre><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
#include &lt;stdio.h&gt;

// Structure definition
struct Person {
    char name[50];
    int age;
    float height;
};

int main() {
    // Structure variable declaration and initialization
    struct Person person1 = {"Alice", 30, 5.5};

    // Accessing structure members
    printf("Name: %s\n", person1.name);
    printf("Age: %d\n", person1.age);
    printf("Height: %.2f\n", person1.height);

    return 0;
}
</pre><h4>Accessing Structure Members</h4><p>Structure members are accessed using the dot operator (<code>.</code>) with the structure variable.</p><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
person1.age = 35; // Modify age
printf("Updated Age: %d\n", person1.age);
</pre><h4>Pointers to Structures</h4><p>You can use pointers to structures to handle large amounts of data more efficiently. Access structure members through a pointer using the arrow operator (<code>-&gt;</code>).</p><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
#include &lt;stdio.h&gt;

// Structure definition
struct Person {
    char name[50];
    int age;
};

int main() {
    // Structure variable and pointer declaration
    struct Person person1 = {"Bob", 25};
    struct Person *ptr = &amp;person1;

    // Accessing members via pointer
    printf("Name: %s\n", ptr-&gt;name);
    printf("Age: %d\n", ptr-&gt;age);

    return 0;
}
</pre><h3>Functions with Structures</h3><p>Functions can accept structures as parameters or return structures. This allows you to pass complex data types to functions for processing.</p><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
#include &lt;stdio.h&gt;

// Structure definition
struct Rectangle {
    int length;
    int width;
};

// Function to calculate area
int calculateArea(struct Rectangle r) {
    return r.length * r.width;
}

int main() {
    // Structure variable declaration
    struct Rectangle rect = {10, 5};

    // Function call
    int area = calculateArea(rect);
    printf("Area of Rectangle: %d\n", area);

    return 0;
}
</pre><h3>Conclusion</h3><p>Functions and structures are fundamental in C programming, helping to organize code and manage complex data. Functions promote modularity and reuse, while structures allow for the grouping of related data into cohesive units. Mastering both concepts will enable you to write more efficient and maintainable C programs.</p>', '');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('282c9246-1319-4e0f-9392-dbae3852a1e7', 1, 'a6ba8a08-84ae-4655-8406-05d181e58ae3', 'VIDEO', 'Java Basics - An Overview', NULL, '', 'https://youtu.be/doxwM_gVc90?si=GVcuTo7tYVhTrbde');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('0270923f-ca5e-4676-8b8e-bf667e579a18', 1, '62513510-6e1b-4548-8b73-95427e766bb3', 'VIDEO', 'Java methods 📞', NULL, '', 'https://youtu.be/v5p_SUfi710?si=SHNA00c8OUpILr1Y');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('83cadec2-7053-4c3f-b485-74bebd62e32d', 1, 'f142b4d8-75e1-4abf-a62a-1aade21ba327', 'VIDEO', 'Structures and Functions (Part 1)', NULL, '', 'https://www.youtube.com/watch?v=16P51olKuzk');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('fa9d1c90-6bab-4220-bee4-2e33c5192485', 0, '34b88085-66f2-47cc-85d9-0db02d5dfa64', 'LESSON', 'Loops in Java', NULL, '<h3>Introduction to Loops</h3><p>Loops in Java are used to execute a block of code repeatedly based on a condition. They are essential for tasks that require repetition, such as iterating over arrays or performing repetitive operations. Java provides several types of loops:</p><ol><li><code><strong>for</strong></code><strong> Loop</strong></li><li><code><strong>while</strong></code><strong> Loop</strong></li><li><code><strong>do-while</strong></code><strong> Loop</strong></li></ol><h3>The <code>for</code> Loop</h3><p>The <code>for</code> loop is used when you know in advance how many times you want to execute a block of code. It consists of three parts: initialization, condition, and iteration.</p><p><strong>Syntax:</strong></p><pre class="ql-syntax" spellcheck="false">java
Copy code
for (initialization; condition; iteration) {
    // Code to execute repeatedly
}
</pre><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">java
Copy code
for (int i = 0; i &lt; 5; i++) {
    System.out.println("Iteration: " + i);
}
</pre><p>In this example:</p><ul><li><code>initialization</code> is <code>int i = 0</code> (the loop starts with <code>i</code> set to 0).</li><li><code>condition</code> is <code>i &lt; 5</code> (the loop continues as long as <code>i</code> is less than 5).</li><li><code>iteration</code> is <code>i++</code> (after each iteration, <code>i</code> is incremented by 1).</li></ul><h3>The <code>while</code> Loop</h3><p>The <code>while</code> loop is used when the number of iterations is not known in advance and is determined by a condition that is evaluated before each iteration.</p><p><strong>Syntax:</strong></p><pre class="ql-syntax" spellcheck="false">java
Copy code
while (condition) {
    // Code to execute repeatedly
}
</pre><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">java
Copy code
int i = 0;
while (i &lt; 5) {
    System.out.println("Iteration: " + i);
    i++;
}
</pre><p>In this example:</p><ul><li><code>condition</code> is <code>i &lt; 5</code> (the loop continues as long as <code>i</code> is less than 5).</li><li><code>i++</code> is used to increment <code>i</code> within the loop body.</li></ul><h3>The <code>do-while</code> Loop</h3><p>The <code>do-while</code> loop is similar to the <code>while</code> loop, but it guarantees that the block of code will be executed at least once because the condition is evaluated after the execution of the loop body.</p><p><strong>Syntax:</strong></p><pre class="ql-syntax" spellcheck="false">java
Copy code
do {
    // Code to execute repeatedly
} while (condition);
</pre><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">java
Copy code
int i = 0;
do {
    System.out.println("Iteration: " + i);
    i++;
} while (i &lt; 5);
</pre><p>In this example:</p><ul><li>The block of code is executed first, and then <code>condition</code> (<code>i &lt; 5</code>) is evaluated to determine if the loop should continue.</li></ul><h3>Nested Loops</h3><p>You can nest loops within each other to perform more complex iterations.</p><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">java
Copy code
for (int i = 0; i &lt; 3; i++) {
    for (int j = 0; j &lt; 3; j++) {
        System.out.println("i: " + i + ", j: " + j);
    }
}
</pre><p>In this example, the outer loop iterates three times, and for each iteration of the outer loop, the inner loop also iterates three times.</p><h3>Break and Continue Statements</h3><p>The <code>break</code> and <code>continue</code> statements are used to control the flow of loops.</p><ul><li><code><strong>break</strong></code>: Exits the loop immediately, regardless of the condition.</li><li><code><strong>continue</strong></code>: Skips the current iteration and proceeds to the next iteration of the loop.</li></ul><p><strong>Example using </strong><code><strong>break</strong></code><strong>:</strong></p><pre class="ql-syntax" spellcheck="false">java
Copy code
for (int i = 0; i &lt; 5; i++) {
    if (i == 3) {
        break; // Exit the loop when i is 3
    }
    System.out.println("i: " + i);
}
</pre><p><strong>Example using </strong><code><strong>continue</strong></code><strong>:</strong></p><pre class="ql-syntax" spellcheck="false">java
Copy code
for (int i = 0; i &lt; 5; i++) {
    if (i == 3) {
        continue; // Skip the rest of the loop body when i is 3
    }
    System.out.println("i: " + i);
}
</pre><h3>Example Program</h3><p>Here’s a complete example program demonstrating different types of loops:</p><pre class="ql-syntax" spellcheck="false">java
Copy code
public class LoopExample {
    public static void main(String[] args) {
        // For loop
        System.out.println("For Loop:");
        for (int i = 0; i &lt; 5; i++) {
            System.out.println("Iteration: " + i);
        }

        // While loop
        System.out.println("While Loop:");
        int j = 0;
        while (j &lt; 5) {
            System.out.println("Iteration: " + j);
            j++;
        }

        // Do-while loop
        System.out.println("Do-While Loop:");
        int k = 0;
        do {
            System.out.println("Iteration: " + k);
            k++;
        } while (k &lt; 5);

        // Nested loops
        System.out.println("Nested Loops:");
        for (int x = 0; x &lt; 3; x++) {
            for (int y = 0; y &lt; 3; y++) {
                System.out.println("x: " + x + ", y: " + y);
            }
        }

        // Break and Continue
        System.out.println("Break and Continue:");
        for (int i = 0; i &lt; 5; i++) {
            if (i == 3) {
                break;
            }
            System.out.println("Break example - i: " + i);
        }

        for (int i = 0; i &lt; 5; i++) {
            if (i == 3) {
                continue;
            }
            System.out.println("Continue example - i: " + i);
        }
    }
}
</pre><h3>Conclusion</h3><p>Loops are powerful constructs in Java that allow you to execute code repeatedly based on specified conditions. Understanding how to use <code>for</code>, <code>while</code>, and <code>do-while</code> loops, along with <code>break</code> and <code>continue</code> statements, will help you manage repetitive tasks and control the flow of your programs effectively.</p>', '');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('cd20e221-d739-4d7a-b855-0fe1603b211d', 1, '34b88085-66f2-47cc-85d9-0db02d5dfa64', 'VIDEO', 'Introduction to Loops in Java Programming - For Beginners', NULL, '', 'https://youtu.be/tCJZiHEpHbg?si=MpEkgMgfQe_eumok');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('ee19f9b6-b558-4c65-beaa-2cdd926c8419', 0, 'b995e375-ff54-4265-b81a-5c2b1f6f3b86', 'LESSON', 'Arrays in Java', NULL, '<h3>Introduction to Arrays</h3><p>An array in Java is a data structure that allows you to store multiple values of the same type in a single variable. Arrays are useful for handling collections of data, such as lists or tables. Each element in an array is accessed using an index, which starts from 0.</p><h3>Declaring Arrays</h3><p>To use an array, you first need to declare it. Here’s how you can declare an array in Java:</p><p><strong>Syntax:</strong></p><pre class="ql-syntax" spellcheck="false">java
Copy code
dataType[] arrayName;
</pre><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">java
Copy code
int[] numbers;
</pre><p>In this example, <code>numbers</code> is an array of integers.</p><h3>Initializing Arrays</h3><p>After declaring an array, you need to initialize it. You can initialize an array in two main ways:</p><ol><li><strong>Using the </strong><code><strong>new</strong></code><strong> Keyword</strong></li><li>You can initialize an array with a specified size using the <code>new</code> keyword.</li><li><strong>Syntax:</strong></li></ol><pre class="ql-syntax" spellcheck="false">java
Copy code
arrayName = new dataType[size];
</pre><ol><li><strong>Example:</strong></li></ol><pre class="ql-syntax" spellcheck="false">java
Copy code
int[] numbers = new int[5]; // Array of 5 integers
</pre><ol><li><strong>Using an Array Literal</strong></li><li>You can also initialize an array with specific values at the time of declaration.</li><li><strong>Syntax:</strong></li></ol><pre class="ql-syntax" spellcheck="false">java
Copy code
dataType[] arrayName = {value1, value2, value3, ...};
</pre><ol><li><strong>Example:</strong></li></ol><pre class="ql-syntax" spellcheck="false">java
Copy code
int[] numbers = {1, 2, 3, 4, 5};
</pre><h3>Accessing Array Elements</h3><p>You can access and modify elements in an array using their index. The index starts from 0 and goes up to <code>length - 1</code>, where <code>length</code> is the size of the array.</p><p><strong>Syntax:</strong></p><pre class="ql-syntax" spellcheck="false">java
Copy code
arrayName[index]
</pre><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">java
Copy code
int[] numbers = {1, 2, 3, 4, 5};
int firstNumber = numbers[0]; // Access the first element
numbers[2] = 10; // Modify the third element
</pre><h3>Array Length</h3><p>The <code>length</code> property of an array returns the number of elements in the array.</p><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">java
Copy code
int[] numbers = {1, 2, 3, 4, 5};
int length = numbers.length;
System.out.println("Array length: " + length);
</pre><h3>Iterating Through Arrays</h3><p>You can use loops to iterate through the elements of an array.</p><ol><li><strong>Using a </strong><code><strong>for</strong></code><strong> Loop</strong></li><li><strong>Example:</strong></li></ol><pre class="ql-syntax" spellcheck="false">java
Copy code
int[] numbers = {1, 2, 3, 4, 5};
for (int i = 0; i &lt; numbers.length; i++) {
    System.out.println(numbers[i]);
}
</pre><ol><li><strong>Using an Enhanced </strong><code><strong>for</strong></code><strong> Loop</strong></li><li>The enhanced <code>for</code> loop (also known as the "for-each" loop) simplifies iterating through arrays.</li><li><strong>Syntax:</strong></li></ol><pre class="ql-syntax" spellcheck="false">java
Copy code
for (dataType element : arrayName) {
    // Code to execute for each element
}
</pre><ol><li><strong>Example:</strong></li></ol><pre class="ql-syntax" spellcheck="false">java
Copy code
int[] numbers = {1, 2, 3, 4, 5};
for (int number : numbers) {
    System.out.println(number);
}
</pre><h3>Multidimensional Arrays</h3><p>Java also supports multidimensional arrays, such as 2D arrays. A 2D array can be thought of as an array of arrays.</p><p><strong>Syntax:</strong></p><pre class="ql-syntax" spellcheck="false">java
Copy code
dataType[][] arrayName;
</pre><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">java
Copy code
int[][] matrix = new int[3][3]; // 3x3 matrix
</pre><p>You can initialize a 2D array with values as follows:</p><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">java
Copy code
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};
</pre><p><strong>Accessing Elements:</strong></p><pre class="ql-syntax" spellcheck="false">java
Copy code
int value = matrix[1][2]; // Access the element in the second row, third column
</pre><p><strong>Iterating Through a 2D Array:</strong></p><pre class="ql-syntax" spellcheck="false">java
Copy code
for (int i = 0; i &lt; matrix.length; i++) {
    for (int j = 0; j &lt; matrix[i].length; j++) {
        System.out.print(matrix[i][j] + " ");
    }
    System.out.println();
}
</pre><h3>Example Program</h3><p>Here’s a complete example demonstrating various operations with arrays:</p><pre class="ql-syntax" spellcheck="false">java
Copy code
public class ArrayExample {
    public static void main(String[] args) {
        // 1D Array Declaration and Initialization
        int[] numbers = {1, 2, 3, 4, 5};

        // Accessing Elements
        System.out.println("First element: " + numbers[0]);

        // Modifying Elements
        numbers[2] = 10;

        // Printing Array Elements using for Loop
        System.out.println("Array elements:");
        for (int i = 0; i &lt; numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        // Printing Array Elements using Enhanced for Loop
        System.out.println("Array elements (Enhanced for Loop):");
        for (int number : numbers) {
            System.out.println(number);
        }

        // 2D Array Declaration and Initialization
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Printing 2D Array Elements
        System.out.println("2D Array elements:");
        for (int i = 0; i &lt; matrix.length; i++) {
            for (int j = 0; j &lt; matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
</pre><h3>Conclusion</h3><p>Arrays are a fundamental part of Java that allow you to manage collections of data efficiently. Understanding how to declare, initialize, access, and iterate through arrays will help you handle multiple values effectively in your Java programs. Multidimensional arrays further extend this concept, enabling more complex data structures.</p>', '');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('c598ae41-0cfd-4a22-b0f6-bf057e3c5768', 1, 'b995e375-ff54-4265-b81a-5c2b1f6f3b86', 'VIDEO', 'Java arrays 🚗', NULL, '', 'https://youtu.be/ei_4Nt7XWOw?si=aAyI3LF0EUYA7BKi');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('08faef47-d54d-4a37-8aa4-67d50b9a4539', 0, '62513510-6e1b-4548-8b73-95427e766bb3', 'LESSON', 'Methods In Java', NULL, '<h3>Introduction to Methods</h3><p>In Java, methods are blocks of code designed to perform a specific task. They allow you to group code into reusable units, making your program more organized and easier to manage. Methods help you avoid code duplication by allowing you to call the same piece of code from multiple places.</p><h3>Defining a Method</h3><p>To define a method, you need to specify its return type, name, and parameters (if any). A method definition includes the method body enclosed in curly braces <code>{}</code>.</p><p><strong>Syntax:</strong></p><pre class="ql-syntax" spellcheck="false">java
Copy code
returnType methodName(parameters) {
    // Code to execute
    return value; // if returnType is not void
}
</pre><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">java
Copy code
public class Example {
    // Method that returns an integer
    public int add(int a, int b) {
        return a + b;
    }

    // Method with no return value
    public void printMessage() {
        System.out.println("Hello, world!");
    }
}
</pre><h3>Calling a Method</h3><p>You can call a method by using its name followed by parentheses. If the method requires parameters, you need to pass them inside the parentheses.</p><p><strong>Syntax:</strong></p><pre class="ql-syntax" spellcheck="false">java
Copy code
methodName(arguments);
</pre><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">java
Copy code
public class Example {
    public static void main(String[] args) {
        Example example = new Example();

        // Calling a method with a return value
        int sum = example.add(5, 10);
        System.out.println("Sum: " + sum);

        // Calling a method with no return value
        example.printMessage();
    }

    public int add(int a, int b) {
        return a + b;
    }

    public void printMessage() {
        System.out.println("Hello, world!");
    }
}
</pre><h3>Method Parameters</h3><p>Methods can accept parameters, which are variables used to pass information into the method. You can define multiple parameters, separated by commas.</p><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">java
Copy code
public class Example {
    public int multiply(int x, int y) {
        return x * y;
    }
}
</pre><p>When calling this method, you provide values for <code>x</code> and <code>y</code>:</p><pre class="ql-syntax" spellcheck="false">java
Copy code
int product = example.multiply(4, 5);
</pre><h3>Method Return Types</h3><p>Methods can return values of any data type. If a method does not return a value, it should have a return type of <code>void</code>.</p><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">java
Copy code
public class Example {
    // Method with return value
    public int square(int number) {
        return number * number;
    }

    // Method with no return value
    public void displayMessage() {
        System.out.println("This method has no return value.");
    }
}
</pre><h3>Method Overloading</h3><p>Method overloading allows you to define multiple methods with the same name but different parameter lists. The method that gets called depends on the number and type of arguments passed.</p><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">java
Copy code
public class Example {
    // Method to add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Overloaded method to add three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }
}
</pre><h3>Method Scope</h3><p>A method’s scope refers to where it can be accessed. Methods defined in a class can be called from other methods within the same class or from other classes if they are public.</p><h3>Static Methods</h3><p>Static methods belong to the class rather than any particular instance. They can be called without creating an instance of the class.</p><p><strong>Syntax:</strong></p><pre class="ql-syntax" spellcheck="false">java
Copy code
public static returnType methodName(parameters) {
    // Code to execute
}
</pre><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">java
Copy code
public class Example {
    public static void printStaticMessage() {
        System.out.println("This is a static method.");
    }
}
</pre><p>You can call the static method without creating an instance of the class:</p><pre class="ql-syntax" spellcheck="false">java
Copy code
Example.printStaticMessage();
</pre><h3>Example Program</h3><p>Here’s a complete example demonstrating various aspects of methods:</p><pre class="ql-syntax" spellcheck="false">java
Copy code
public class MethodExample {
    public static void main(String[] args) {
        MethodExample example = new MethodExample();

        // Calling a method with parameters and return value
        int sum = example.add(5, 10);
        System.out.println("Sum: " + sum);

        // Calling an overloaded method
        int total = example.add(1, 2, 3);
        System.out.println("Total: " + total);

        // Calling a method with no return value
        example.displayMessage();

        // Calling a static method
        MethodExample.printStaticMessage();
    }

    // Method with return value
    public int add(int a, int b) {
        return a + b;
    }

    // Overloaded method
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Method with no return value
    public void displayMessage() {
        System.out.println("This method has no return value.");
    }

    // Static method
    public static void printStaticMessage() {
        System.out.println("This is a static method.");
    }
}
</pre><h3>Conclusion</h3><p>Methods are fundamental to organizing and structuring your Java programs. They allow you to encapsulate functionality, improve code reuse, and enhance readability. By understanding how to define, call, and manage methods, you can write more modular and maintainable code.</p>', '');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('6283a358-69a8-4621-a187-4e15b7ba8289', 0, 'de760849-3377-4334-8d14-ba89ca34e927', 'LESSON', 'Learn print in detail', NULL, '<h3>Introduction to Printing in Java</h3><p>In Java, the <code>System.out</code> object is used to output data to the console. There are two primary methods to print data: <code>print</code> and <code>println</code>.</p><ol><li><strong>print</strong>: This method prints the text to the console.</li><li><strong>println</strong>: This method prints the text to the console and then moves the cursor to a new line.</li></ol><h3>Basic Syntax</h3><ul><li><strong>Using </strong><code><strong>print</strong></code>:</li></ul><pre class="ql-syntax" spellcheck="false">java
Copy code
System.out.print("Hello, World!");
</pre><ul><li>This will output:</li></ul><pre class="ql-syntax" spellcheck="false">Copy code
Hello, World!
</pre><ul><li><strong>Using </strong><code><strong>println</strong></code>:</li></ul><pre class="ql-syntax" spellcheck="false">java
Copy code
System.out.println("Hello, World!");
</pre><ul><li>This will output:</li></ul><pre class="ql-syntax" spellcheck="false">Copy code
Hello, World!
</pre><h3>Differences Between <code>print</code> and <code>println</code></h3><p>The main difference between <code>print</code> and <code>println</code> is that <code>println</code> adds a newline character at the end of the output, moving the cursor to the next line. This makes it easy to print multiple lines of text.</p><pre class="ql-syntax" spellcheck="false">java
Copy code
System.out.print("Hello, ");
System.out.print("World!");
</pre><p>This will output:</p><pre class="ql-syntax" spellcheck="false">Copy code
Hello, World!
java
Copy code
System.out.println("Hello, ");
System.out.println("World!");
</pre><p>This will output:</p><pre class="ql-syntax" spellcheck="false">Copy code
Hello,
World!
</pre><h3>Printing Variables</h3><p>You can also print variables using <code>print</code> and <code>println</code>.</p><pre class="ql-syntax" spellcheck="false">java
Copy code
int number = 10;
System.out.print("The number is: ");
System.out.println(number);
</pre><p>This will output:</p><pre class="ql-syntax" spellcheck="false">csharp
Copy code
The number is: 10
</pre><h3>Formatting Output</h3><p>Java provides the <code>printf</code> method for formatted output. It works similarly to the <code>printf</code> function in C.</p><pre class="ql-syntax" spellcheck="false">java
Copy code
int number = 10;
String name = "Alice";
System.out.printf("Hello, %s! You have %d new messages.\n", name, number);
</pre><p>This will output:</p><pre class="ql-syntax" spellcheck="false">arduino
Copy code
Hello, Alice! You have 10 new messages.
</pre><h3>Escape Sequences</h3><p>You can use escape sequences to format your output.</p><ul><li><code>\n</code>: Newline</li><li><code>\t</code>: Tab</li><li><code>\\</code>: Backslash</li><li><code>\"</code>: Double quote</li></ul><pre class="ql-syntax" spellcheck="false">java
Copy code
System.out.println("Hello, \nWorld!");
System.out.println("A tab:\tHere");
System.out.println("Backslash:\\");
System.out.println("Quote:\"");
</pre><p>This will output:</p><pre class="ql-syntax" spellcheck="false">less
Copy code
Hello,
World!
A tab:	Here
Backslash:\
Quote:"
</pre><h3>Example Program</h3><p>Here''s a complete example program demonstrating the use of <code>print</code>, <code>println</code>, and <code>printf</code> methods:</p><pre class="ql-syntax" spellcheck="false">java
Copy code
public class PrintExample {
    public static void main(String[] args) {
        // Using print
        System.out.print("This is a print example.");
        System.out.print(" No newline after this.");

        // Using println
        System.out.println(" This is a println example.");
        System.out.println("This is another println example.");

        // Printing variables
        int number = 42;
        double price = 19.99;
        String name = "Java";
        System.out.println("Number: " + number);
        System.out.println("Price: " + price);
        System.out.println("Name: " + name);

        // Using printf
        System.out.printf("Name: %s, Number: %d, Price: %.2f\n", name, number, price);

        // Using escape sequences
        System.out.println("This is a line with a newline\nand a tab\tand a quote: \"");
    }
}
</pre><h3>Conclusion</h3><p>Understanding how to use <code>print</code>, <code>println</code>, and <code>printf</code> effectively is essential for creating readable and user-friendly console applications in Java. Practice these methods with various data types and formatting options to become more proficient.</p>', '');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('01ca9729-6c79-414c-8819-4390e167d529', 1, 'de760849-3377-4334-8d14-ba89ca34e927', 'VIDEO', 'What Is Java? | Java In 5 Minutes | Java Programming | Java Tutorial For Beginners | Simplilearn', NULL, '', 'https://youtu.be/mAtkPQO1FcA?si=KgglCgcDoZicuMQ6');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('adc19e75-7be4-4218-9802-8fb8d192ca4d', 2, 'de760849-3377-4334-8d14-ba89ca34e927', 'CODE', 'Print Sum Of Two Integers', 'b6484e21-6937-489c-b031-b71767994221', 'Sum of two integer', '');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('57310739-6d40-422c-850d-e75bdc3e3328', 0, 'a6ba8a08-84ae-4655-8406-05d181e58ae3', 'LESSON', 'Variables and Data Types in Java', NULL, '<h3>Introduction to Variables</h3><p>Variables in Java are used to store data that can be used and manipulated throughout your program. Each variable has a data type that determines what kind of data it can hold.</p><h3>Declaring Variables</h3><p>To declare a variable in Java, you need to specify the data type followed by the variable name.</p><pre class="ql-syntax" spellcheck="false">java
Copy code
int number;
</pre><h3>Initializing Variables</h3><p>You can initialize a variable when you declare it by assigning it a value.</p><pre class="ql-syntax" spellcheck="false">java
Copy code
int number = 10;
</pre><h3>Basic Data Types</h3><p>Java has several built-in data types, divided into two categories: primitive data types and reference data types.</p><h4>Primitive Data Types</h4><ol><li><strong>byte</strong>: 8-bit signed integer.</li></ol><pre class="ql-syntax" spellcheck="false">java
Copy code
byte b = 100;
</pre><ol><li><strong>short</strong>: 16-bit signed integer.</li></ol><pre class="ql-syntax" spellcheck="false">java
Copy code
short s = 10000;
</pre><ol><li><strong>int</strong>: 32-bit signed integer.</li></ol><pre class="ql-syntax" spellcheck="false">java
Copy code
int i = 100000;
</pre><ol><li><strong>long</strong>: 64-bit signed integer.</li></ol><pre class="ql-syntax" spellcheck="false">java
Copy code
long l = 100000L;
</pre><ol><li><strong>float</strong>: 32-bit floating-point number.</li></ol><pre class="ql-syntax" spellcheck="false">java
Copy code
float f = 10.5f;
</pre><ol><li><strong>double</strong>: 64-bit floating-point number.</li></ol><pre class="ql-syntax" spellcheck="false">java
Copy code
double d = 20.5;
</pre><ol><li><strong>boolean</strong>: Represents true or false.</li></ol><pre class="ql-syntax" spellcheck="false">java
Copy code
boolean flag = true;
</pre><ol><li><strong>char</strong>: 16-bit Unicode character.</li></ol><pre class="ql-syntax" spellcheck="false">java
Copy code
char c = ''A'';
</pre><h4>Reference Data Types</h4><p>Reference data types include classes, arrays, and interfaces.</p><ol><li><strong>String</strong>: Represents a sequence of characters.</li></ol><pre class="ql-syntax" spellcheck="false">java
Copy code
String str = "Hello, Java!";
</pre><h3>Type Casting</h3><p>Type casting is converting one data type to another. There are two types of casting:</p><ol><li><strong>Implicit Casting (Widening Conversion)</strong>: Automatically done by Java.</li></ol><pre class="ql-syntax" spellcheck="false">java
Copy code
int i = 100;
double d = i;  // Implicit casting
</pre><ol><li><strong>Explicit Casting (Narrowing Conversion)</strong>: Must be done manually.</li></ol><pre class="ql-syntax" spellcheck="false">java
Copy code
double d = 100.5;
int i = (int) d;  // Explicit casting
</pre><h3>Example Program</h3><p>Here''s a complete example program demonstrating variables and data types in Java:</p><pre class="ql-syntax" spellcheck="false">java
Copy code
public class VariablesExample {
    public static void main(String[] args) {
        // Primitive data types
        byte b = 100;
        short s = 10000;
        int i = 100000;
        long l = 100000L;
        float f = 10.5f;
        double d = 20.5;
        boolean flag = true;
        char c = ''A'';

        // Reference data type
        String str = "Hello, Java!";

        // Printing variables
        System.out.println("Byte value: " + b);
        System.out.println("Short value: " + s);
        System.out.println("Int value: " + i);
        System.out.println("Long value: " + l);
        System.out.println("Float value: " + f);
        System.out.println("Double value: " + d);
        System.out.println("Boolean value: " + flag);
        System.out.println("Char value: " + c);
        System.out.println("String value: " + str);

        // Type casting
        int intVal = 100;
        double doubleVal = intVal;  // Implicit casting
        System.out.println("Implicitly casted double value: " + doubleVal);

        double anotherDouble = 100.5;
        int anotherInt = (int) anotherDouble;  // Explicit casting
        System.out.println("Explicitly casted int value: " + anotherInt);
    }
}
</pre><h3>Conclusion</h3><p>Understanding variables and data types is fundamental in Java programming. By mastering these concepts, you can effectively store and manipulate data in your applications.</p>', '');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('a2d550b1-c925-4eb3-a751-6407e8c39523', 0, '9ce115e6-aaef-4743-9fb2-db64c86c4acd', 'LESSON', 'Arithmetic Operators in Java', NULL, '<h3>Introduction to Arithmetic Operators</h3><p>Arithmetic operators in Java are used to perform basic mathematical operations such as addition, subtraction, multiplication, and division. These operators are fundamental for any programming task that involves numerical calculations.</p><h3>Addition (<code>+</code>)</h3><p>The addition operator <code>+</code> is used to add two operands. It can be used with both integers and floating-point numbers.</p><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">java
Copy code
int a = 10;
int b = 5;
int sum = a + b;
System.out.println("The sum of a and b is: " + sum);
</pre><p><strong>Output:</strong></p><pre class="ql-syntax" spellcheck="false">css
Copy code
The sum of a and b is: 15
</pre><h3>Subtraction (<code>-</code>)</h3><p>The subtraction operator <code>-</code> is used to subtract the right operand from the left operand.</p><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">java
Copy code
int a = 10;
int b = 5;
int difference = a - b;
System.out.println("The difference between a and b is: " + difference);
</pre><p><strong>Output:</strong></p><pre class="ql-syntax" spellcheck="false">css
Copy code
The difference between a and b is: 5
</pre><h3>Multiplication (<code>*</code>)</h3><p>The multiplication operator <code>*</code> is used to multiply two operands.</p><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">java
Copy code
int a = 10;
int b = 5;
int product = a * b;
System.out.println("The product of a and b is: " + product);
</pre><p><strong>Output:</strong></p><pre class="ql-syntax" spellcheck="false">css
Copy code
The product of a and b is: 50
</pre><h3>Division (<code>/</code>)</h3><p>The division operator <code>/</code> is used to divide the left operand by the right operand. When using integers, the result will also be an integer, meaning the decimal part will be truncated.</p><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">java
Copy code
int a = 10;
int b = 5;
int quotient = a / b;
System.out.println("The quotient when a is divided by b is: " + quotient);
</pre><p><strong>Output:</strong></p><pre class="ql-syntax" spellcheck="false">csharp
Copy code
The quotient when a is divided by b is: 2
</pre><p><strong>Note:</strong> If you want to obtain a floating-point result, at least one of the operands must be a floating-point number.</p><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">java
Copy code
double a = 10;
double b = 4;
double quotient = a / b;
System.out.println("The quotient when a is divided by b is: " + quotient);
</pre><p><strong>Output:</strong></p><pre class="ql-syntax" spellcheck="false">csharp
Copy code
The quotient when a is divided by b is: 2.5
</pre><h3>Example Program</h3><p>Here''s a complete example program demonstrating the use of arithmetic operators in Java:</p><pre class="ql-syntax" spellcheck="false">java
Copy code
public class ArithmeticOperatorsExample {
    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        double c = 10.0;
        double d = 4.0;

        // Addition
        int sum = a + b;
        System.out.println("The sum of a and b is: " + sum);

        // Subtraction
        int difference = a - b;
        System.out.println("The difference between a and b is: " + difference);

        // Multiplication
        int product = a * b;
        System.out.println("The product of a and b is: " + product);

        // Integer Division
        int quotientInt = a / b;
        System.out.println("The quotient when a is divided by b (integer division) is: " + quotientInt);

        // Floating-point Division
        double quotientDouble = c / d;
        System.out.println("The quotient when c is divided by d (floating-point division) is: " + quotientDouble);
    }
}
</pre><h3>Conclusion</h3><p>Understanding and using arithmetic operators is essential for performing mathematical calculations in Java. Practice these operators with different types of operands to become more proficient in handling numerical data in your programs.</p>', '');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('bbe57580-dd18-46da-96d4-30ac7d80d0cc', 1, '9ce115e6-aaef-4743-9fb2-db64c86c4acd', 'VIDEO', 'Arithmetic Operators in Java', NULL, '', 'https://youtu.be/flWjzwzgybI?si=PIhMWR1NXPjALguT');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('fa8cfaa6-2507-479a-a7d8-1934441efcde', 0, '4bbff1c6-51e5-4c6d-b5eb-0335f9b718cd', 'LESSON', 'Strings In Java', NULL, '<h3>Introduction to Strings</h3><p>Strings in Java are objects that represent sequences of characters. They are used to store and manipulate text. Unlike primitive data types, strings are instances of the <code>String</code> class.</p><h3>Creating Strings</h3><p>You can create a string in Java in several ways:</p><ol><li><strong>Using String Literals</strong></li></ol><pre class="ql-syntax" spellcheck="false">java
Copy code
String greeting = "Hello, World!";
</pre><ol><li><strong>Using the </strong><code><strong>new</strong></code><strong> Keyword</strong></li></ol><pre class="ql-syntax" spellcheck="false">java
Copy code
String greeting = new String("Hello, World!");
</pre><h3>String Methods</h3><p>Java provides a variety of methods to manipulate strings. Here are some commonly used string methods:</p><ol><li><strong>Length of a String</strong></li><li>The <code>length()</code> method returns the number of characters in a string.</li></ol><pre class="ql-syntax" spellcheck="false">java
Copy code
String str = "Hello, World!";
int length = str.length();
System.out.println("Length of the string: " + length);
</pre><ol><li><strong>Concatenation</strong></li><li>You can concatenate two strings using the <code>+</code> operator or the <code>concat()</code> method.</li></ol><pre class="ql-syntax" spellcheck="false">java
Copy code
String str1 = "Hello";
String str2 = "World";
String result = str1 + ", " + str2 + "!";
System.out.println(result);

String result2 = str1.concat(", ").concat(str2).concat("!");
System.out.println(result2);
</pre><ol><li><strong>Character at a Specific Index</strong></li><li>The <code>charAt()</code> method returns the character at a specific index.</li></ol><pre class="ql-syntax" spellcheck="false">java
Copy code
String str = "Hello, World!";
char ch = str.charAt(0);
System.out.println("Character at index 0: " + ch);
</pre><ol><li><strong>Substring</strong></li><li>The <code>substring()</code> method extracts a part of the string.</li></ol><pre class="ql-syntax" spellcheck="false">java
Copy code
String str = "Hello, World!";
String sub = str.substring(7, 12);
System.out.println("Substring: " + sub);
</pre><ol><li><strong>Contains</strong></li><li>The <code>contains()</code> method checks if a string contains a specified sequence of characters.</li></ol><pre class="ql-syntax" spellcheck="false">java
Copy code
String str = "Hello, World!";
boolean contains = str.contains("World");
System.out.println("Contains ''World'': " + contains);
</pre><ol><li><strong>Replace</strong></li><li>The <code>replace()</code> method replaces all occurrences of a specified character or substring with another character or substring.</li></ol><pre class="ql-syntax" spellcheck="false">java
Copy code
String str = "Hello, World!";
String replacedStr = str.replace("World", "Java");
System.out.println("Replaced String: " + replacedStr);
</pre><ol><li><strong>Equals</strong></li><li>The <code>equals()</code> method compares two strings for equality.</li></ol><pre class="ql-syntax" spellcheck="false">java
Copy code
String str1 = "Hello";
String str2 = "Hello";
boolean isEqual = str1.equals(str2);
System.out.println("Strings are equal: " + isEqual);
</pre><h3>String Immutability</h3><p>Strings in Java are immutable, which means once a string is created, it cannot be changed. Any operation that modifies a string will result in the creation of a new string.</p><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">java
Copy code
String str = "Hello";
str = str.concat(", World!");
System.out.println(str); // Output: Hello, World!
</pre><h3>Example Program</h3><p>Here''s a complete example program demonstrating the use of strings in Java:</p><pre class="ql-syntax" spellcheck="false">java
Copy code
public class StringExample {
    public static void main(String[] args) {
        // Creating strings
        String greeting = "Hello, World!";
        String greetingNew = new String("Hello, World!");

        // Length of the string
        int length = greeting.length();
        System.out.println("Length of the string: " + length);

        // Concatenation
        String str1 = "Hello";
        String str2 = "World";
        String result = str1 + ", " + str2 + "!";
        System.out.println(result);

        String result2 = str1.concat(", ").concat(str2).concat("!");
        System.out.println(result2);

        // Character at a specific index
        char ch = greeting.charAt(0);
        System.out.println("Character at index 0: " + ch);

        // Substring
        String sub = greeting.substring(7, 12);
        System.out.println("Substring: " + sub);

        // Contains
        boolean contains = greeting.contains("World");
        System.out.println("Contains ''World'': " + contains);

        // Replace
        String replacedStr = greeting.replace("World", "Java");
        System.out.println("Replaced String: " + replacedStr);

        // Equals
        boolean isEqual = str1.equals(str2);
        System.out.println("Strings are equal: " + isEqual);
    }
}
</pre><h3>Conclusion</h3><p>Understanding strings and their methods is essential for manipulating text in Java. Strings are versatile and powerful, allowing you to perform a wide range of operations, from simple concatenation to complex transformations.</p>', '');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('e62daba7-70da-463b-a996-d6fb12fd2a69', 1, '4bbff1c6-51e5-4c6d-b5eb-0335f9b718cd', 'VIDEO', 'What is String in Java', NULL, '', 'https://youtu.be/cV-sOpOgof8?si=Bz8rVYwb6upCUYhi');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('a3a0f7b7-b998-49cd-a6c4-7a81ac589dd0', 2, '4bbff1c6-51e5-4c6d-b5eb-0335f9b718cd', 'CODE', 'English Alphabet Printing', 'b6484e21-6937-489c-b031-b71767994757', 'English alphabet printing', '');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('95dc53e2-0350-46fc-af2a-65bb94d2bebf', 0, '567446cf-e4dd-45a6-93c1-9b539a9c4f2e', 'LESSON', 'User Inputs In Java', NULL, '<h3>Introduction to User Inputs</h3><p>In Java, handling user input is crucial for interactive programs. The <code>Scanner</code> class is commonly used to read data from various input sources, such as the keyboard. This lesson will guide you through the basics of using the <code>Scanner</code> class to get user inputs in Java.</p><h3>Importing the Scanner Class</h3><p>To use the <code>Scanner</code> class, you need to import it from the <code>java.util</code> package.</p><pre class="ql-syntax" spellcheck="false">java
Copy code
import java.util.Scanner;
</pre><h3>Creating a Scanner Object</h3><p>You can create an instance of the <code>Scanner</code> class by passing <code>System.in</code> to its constructor, which allows it to read from the keyboard.</p><pre class="ql-syntax" spellcheck="false">java
Copy code
Scanner scanner = new Scanner(System.in);
</pre><h3>Reading User Inputs</h3><p>The <code>Scanner</code> class provides several methods to read different types of data. Here’s how you can use these methods:</p><ol><li><strong>Reading an Integer</strong></li><li>To read an integer value, use the <code>nextInt()</code> method.</li></ol><pre class="ql-syntax" spellcheck="false">java
Copy code
Scanner scanner = new Scanner(System.in);
System.out.print("Enter an integer: ");
int number = scanner.nextInt();
System.out.println("You entered: " + number);
</pre><ol><li><strong>Reading a Floating-Point Number</strong></li><li>To read a floating-point number, use the <code>nextDouble()</code> method.</li></ol><pre class="ql-syntax" spellcheck="false">java
Copy code
System.out.print("Enter a floating-point number: ");
double decimal = scanner.nextDouble();
System.out.println("You entered: " + decimal);
</pre><ol><li><strong>Reading a String</strong></li><li>To read a single word or a line of text, use the <code>next()</code> or <code>nextLine()</code> methods.</li></ol><ul><li><strong>Reading a Single Word</strong></li></ul><pre class="ql-syntax" spellcheck="false">java
Copy code
System.out.print("Enter a single word: ");
String word = scanner.next();
System.out.println("You entered: " + word);
</pre><ul><li><strong>Reading a Line of Text</strong></li></ul><pre class="ql-syntax" spellcheck="false">java
Copy code
System.out.print("Enter a line of text: ");
scanner.nextLine(); // consume the newline left-over
String line = scanner.nextLine();
System.out.println("You entered: " + line);
</pre><h3>Example Program</h3><p>Here is a complete example program demonstrating various types of user inputs:</p><pre class="ql-syntax" spellcheck="false">java
Copy code
import java.util.Scanner;

public class UserInputExample {
    public static void main(String[] args) {
        // Create a Scanner object
        Scanner scanner = new Scanner(System.in);

        // Reading an integer
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();
        System.out.println("You entered: " + number);

        // Reading a floating-point number
        System.out.print("Enter a floating-point number: ");
        double decimal = scanner.nextDouble();
        System.out.println("You entered: " + decimal);

        // Reading a single word
        System.out.print("Enter a single word: ");
        scanner.nextLine(); // consume the newline left-over
        String word = scanner.next();
        System.out.println("You entered: " + word);

        // Reading a line of text
        System.out.print("Enter a line of text: ");
        scanner.nextLine(); // consume the newline left-over
        String line = scanner.nextLine();
        System.out.println("You entered: " + line);

        // Close the scanner
        scanner.close();
    }
}
</pre><h3>Handling Input Mismatches</h3><p>If the user inputs data that doesn’t match the expected type, the <code>Scanner</code> will throw an <code>InputMismatchException</code>. To handle this, you can use exception handling techniques:</p><pre class="ql-syntax" spellcheck="false">java
Copy code
import java.util.Scanner;
import java.util.InputMismatchException;

public class SafeInputExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter an integer: ");
            int number = scanner.nextInt();
            System.out.println("You entered: " + number);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter an integer.");
        }

        scanner.close();
    }
}
</pre><h3>Conclusion</h3><p>Handling user inputs in Java is straightforward using the <code>Scanner</code> class. By understanding the various methods provided by <code>Scanner</code>, you can effectively capture and process user data. Remember to handle potential exceptions to make your programs more robust and user-friendly.</p>', '');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('90aaf174-feaf-4b3a-912d-ff1eb5e1c62d', 1, '567446cf-e4dd-45a6-93c1-9b539a9c4f2e', 'VIDEO', 'User Input using BufferedReader and Scanner in Java', NULL, '', 'https://youtu.be/bwHr9G5VIls?si=IE2R7vrgWlfdiVuu');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('7c946695-508a-4cce-b20a-2e30f911c1cc', 0, '259f29ff-ba18-4417-bafd-9e1c4c1319d2', 'LESSON', 'Conditional Statements In Java', NULL, '<h3>Introduction to Conditional Statements</h3><p>Conditional statements are used to make decisions in Java programs. They allow you to execute certain blocks of code based on whether a condition is true or false. Java provides several types of conditional statements:</p><ol><li><code><strong>if</strong></code><strong> Statement</strong></li><li><code><strong>if-else</strong></code><strong> Statement</strong></li><li><code><strong>if-else if-else</strong></code><strong> Statement</strong></li><li><code><strong>switch</strong></code><strong> Statement</strong></li></ol><h3>The <code>if</code> Statement</h3><p>The <code>if</code> statement allows you to execute a block of code if a specified condition evaluates to true.</p><p><strong>Syntax:</strong></p><pre class="ql-syntax" spellcheck="false">java
Copy code
if (condition) {
    // Code to execute if condition is true
}
</pre><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">java
Copy code
int age = 20;
if (age &gt;= 18) {
    System.out.println("You are an adult.");
}
</pre><h3>The <code>if-else</code> Statement</h3><p>The <code>if-else</code> statement allows you to execute one block of code if the condition is true and another block if the condition is false.</p><p><strong>Syntax:</strong></p><pre class="ql-syntax" spellcheck="false">java
Copy code
if (condition) {
    // Code to execute if condition is true
} else {
    // Code to execute if condition is false
}
</pre><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">java
Copy code
int age = 16;
if (age &gt;= 18) {
    System.out.println("You are an adult.");
} else {
    System.out.println("You are not an adult.");
}
</pre><h3>The <code>if-else if-else</code> Statement</h3><p>The <code>if-else if-else</code> statement allows you to test multiple conditions. If the first condition is false, it tests the next condition, and so on.</p><p><strong>Syntax:</strong></p><pre class="ql-syntax" spellcheck="false">java
Copy code
if (condition1) {
    // Code to execute if condition1 is true
} else if (condition2) {
    // Code to execute if condition2 is true
} else {
    // Code to execute if none of the above conditions are true
}
</pre><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">java
Copy code
int score = 85;
if (score &gt;= 90) {
    System.out.println("Grade: A");
} else if (score &gt;= 80) {
    System.out.println("Grade: B");
} else if (score &gt;= 70) {
    System.out.println("Grade: C");
} else {
    System.out.println("Grade: F");
}
</pre><h3>The <code>switch</code> Statement</h3><p>The <code>switch</code> statement is used to select one of many code blocks to be executed. It is a more elegant way to handle multiple conditions based on the value of a variable.</p><p><strong>Syntax:</strong></p><pre class="ql-syntax" spellcheck="false">java
Copy code
switch (expression) {
    case value1:
        // Code to execute if expression equals value1
        break;
    case value2:
        // Code to execute if expression equals value2
        break;
    // More cases as needed
    default:
        // Code to execute if none of the cases match
}
</pre><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">java
Copy code
int day = 3;
switch (day) {
    case 1:
        System.out.println("Monday");
        break;
    case 2:
        System.out.println("Tuesday");
        break;
    case 3:
        System.out.println("Wednesday");
        break;
    case 4:
        System.out.println("Thursday");
        break;
    case 5:
        System.out.println("Friday");
        break;
    case 6:
        System.out.println("Saturday");
        break;
    case 7:
        System.out.println("Sunday");
        break;
    default:
        System.out.println("Invalid day");
}
</pre><h3>Nested Conditional Statements</h3><p>You can nest conditional statements within each other to create more complex logic.</p><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">java
Copy code
int age = 25;
boolean hasTicket = true;

if (age &gt;= 18) {
    if (hasTicket) {
        System.out.println("You can enter the event.");
    } else {
        System.out.println("You need a ticket to enter.");
    }
} else {
    System.out.println("You are not allowed to enter.");
}
</pre><h3>Example Program</h3><p>Here’s a complete example demonstrating the use of conditional statements:</p><pre class="ql-syntax" spellcheck="false">java
Copy code
public class ConditionalExample {
    public static void main(String[] args) {
        int number = 15;

        // Using if-else
        if (number % 2 == 0) {
            System.out.println(number + " is even.");
        } else {
            System.out.println(number + " is odd.");
        }

        // Using switch
        int day = 5;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Invalid day");
        }
    }
}
</pre><h3>Conclusion</h3><p>Conditional statements are essential for controlling the flow of your Java programs. They enable your code to make decisions and perform different actions based on various conditions. Understanding and using these statements effectively will help you build more dynamic and responsive applications.</p>', '');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('de5e09b5-7a12-4d70-a338-3291b5306513', 1, '259f29ff-ba18-4417-bafd-9e1c4c1319d2', 'VIDEO', 'Conditional Statements | If-else, Switch Break | Complete Java Placement Course | Lecture 3', NULL, '', 'https://youtu.be/I5srDu75h_M?si=k67GK5hib7Qmt_j0');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('7dc6df9e-658c-40d7-99bc-776f2f7280a2', 2, '259f29ff-ba18-4417-bafd-9e1c4c1319d2', 'CODE', 'Determine Number Of Days In A Month', 'b6484e21-6937-489c-b031-b71767994761', 'Determine number of days in a month', '');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('3dcb036d-4358-48c1-8268-8a2b31546d84', 0, '6c08d79b-4fd6-4369-99ea-322078e55307', 'LESSON', 'Hello World!', NULL, '<p>Take a look at the&nbsp;<strong>hello.cpp</strong>&nbsp;file in the code editor that is placed in the middle of the screen. It’s a C++ program!</p><p>In our code editor, the file name is displayed at the top:</p><p><img src="https://i.ibb.co/SPphDcX/image.png"></p><p><a href="https://www.codecademy.com/resources/docs/cpp?page_ref=catalog" rel="noopener noreferrer" target="_blank" style="color: var(--color-primary); background-color: transparent;">C++</a>&nbsp;programs are stored in&nbsp;<a href="https://www.codecademy.com/resources/docs/cpp/files" rel="noopener noreferrer" target="_blank" style="color: var(--color-primary); background-color: transparent;">files</a>&nbsp;which usually have the file extension&nbsp;<strong>.cpp</strong>, which simply stands for “C Plus Plus”.</p><p>The code inside our C++ file is a classic first step all new programmers take — they greet the world through the terminal!</p><p>The&nbsp;<a href="https://www.codecademy.com/resources/docs/command-line/terminal?page_ref=catalog" rel="noopener noreferrer" target="_blank" style="color: var(--color-primary); background-color: transparent;"><em>terminal</em></a>&nbsp;is the black panel on the right. It should be blank right now. The code in the text editor will print text out onto the terminal. More specifically, it will print the phrase&nbsp;<code style="color: rgb(21, 20, 31); background-color: rgb(234, 233, 237);">Hello World!</code>.</p>', '');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('c19ab4d0-26bd-4440-8bf7-bc4b73bd2fcd', 1, '6c08d79b-4fd6-4369-99ea-322078e55307', 'CODE', 'Calculate sum of cubes', 'b6484e21-6937-489c-b031-b71767994756', 'Calculate sum of cubes', '');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('efbeb31a-60e7-4296-a133-fcd293998895', 2, '6c08d79b-4fd6-4369-99ea-322078e55307', 'LESSON', 'Compile & Excute', NULL, '<h3>Code → Save → Compile → Execute</h3><p>C++ is a compiled language. That means that to get a C++ program to run, you must first translate it from a human-readable form to something a machine can “understand.” That translation is done by a program called a&nbsp;<em>compiler</em>.</p><p>When you program in C++, you mainly go through 4 phases during development:</p><ol><li><strong>Code</strong>&nbsp;— writing the program</li><li><strong>Save</strong>&nbsp;— saving the program</li><li><strong>Compile</strong>&nbsp;— compiling via the&nbsp;<a href="https://www.codecademy.com/resources/docs/command-line/terminal" rel="noopener noreferrer" target="_blank" style="color: var(--color-primary); background-color: transparent;">terminal</a></li><li><strong>Execute</strong>&nbsp;— executing via the terminal</li></ol><p>And repeat (debug the&nbsp;<a href="https://www.codecademy.com/resources/docs/cpp/errors" rel="noopener noreferrer" target="_blank" style="color: var(--color-primary); background-color: transparent;">errors</a>&nbsp;if needed).</p>', '');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('099ff9aa-0b78-4892-9654-cea67d385d41', 3, '6c08d79b-4fd6-4369-99ea-322078e55307', 'LESSON', 'Compile & Execute (Advanced)', NULL, '<h2>The Process</h2><p>C++ is a compiled language. That means that to get a program to run, you must first translate it from the human-readable form to something a machine can “understand.” That translation is done by a program called a&nbsp;<em>compiler</em>.</p><p>What you read and write is called&nbsp;<em>source code</em>&nbsp;(usually it’s in an English-like language like C++), and what the computer executes is called&nbsp;<em>executable</em>,&nbsp;<em>object code</em>, or&nbsp;<a href="https://www.codecademy.com/resources/docs/general/machine-code?page_ref=catalog" rel="noopener noreferrer" target="_blank" style="color: var(--color-yellow); background-color: transparent;"><em>machine code</em></a>&nbsp;(a machine language).</p><p>Typically C++ source code files are given the suffix:</p><ul><li><strong>.cpp</strong>&nbsp;(ex:&nbsp;<strong>hello.cpp</strong>) or</li><li><strong>.h</strong>&nbsp;(ex:&nbsp;<strong>std_lib_facilities.h</strong>).</li></ul><p><img src="https://i.ibb.co/mq0FwpL/image.png"></p><h4>Compile:</h4><pre class="ql-syntax" spellcheck="false">g++ hello.cpp -o hello

</pre><p>A compiler translates the C++ program into machine language code which it stores on the disk as a file with the extension&nbsp;<strong>.o</strong>&nbsp;(e.g.&nbsp;<strong>hello.o</strong>). A linker then links the object code with standard library routines that the program may use and creates an executable image which is also saved on disk, usually as a file with the file name without any extension (e.g.&nbsp;<strong>hello</strong>).</p><h4>Execute:</h4><pre class="ql-syntax" spellcheck="false">./hello

</pre><p>The executable is loaded from the disk to memory and the computer’s&nbsp;<a href="https://www.codecademy.com/resources/docs/general/computer-hardware/cpu?page_ref=catalog" rel="noopener noreferrer" target="_blank" style="color: var(--color-yellow); background-color: transparent;">CPU</a>&nbsp;(<strong>C</strong>entral&nbsp;<strong>P</strong>rocessing&nbsp;<strong>U</strong>nit) executes the program one instruction at a time.</p><h4>Running Hello World Locally:</h4><p>On the Mac, it’s called the&nbsp;<a href="https://www.codecademy.com/resources/docs/command-line/terminal?page_ref=catalog" rel="noopener noreferrer" target="_blank" style="color: var(--color-yellow); background-color: transparent;">Terminal</a>. On Windows, it’s called the Command Prompt.</p><p><span style="background-color: rgb(255, 255, 255); color: rgb(255, 255, 255);"><img src="https://i.imgur.com/GQLYcJI.png"></span></p>', '');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('69c78499-bb6b-4a9e-8e07-7d1c623d0af8', 4, '6c08d79b-4fd6-4369-99ea-322078e55307', 'VIDEO', 'Running Hello World via Terminal (Mac)', NULL, '', 'https://www.youtube.com/watch?v=N4796qsD-H8');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('a36f857e-e2f7-4a9a-8c22-ebea4acbb93a', 5, '6c08d79b-4fd6-4369-99ea-322078e55307', 'VIDEO', 'Running Hello World via Command Prompt (Windows)', NULL, '', 'https://www.youtube.com/watch?v=GxHLErBLgI8');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('0c76cd5a-4aeb-4c86-abbc-94d8fa9e0f84', 0, '88515ed4-0b74-47d8-9279-0d47c2a21ef4', 'LESSON', 'Variables', NULL, '<h3>Introduction to Variables</h3><p>1 min</p><p>The&nbsp;<code style="color: rgb(21, 20, 31); background-color: rgb(234, 233, 237);">"Hello World!"</code>&nbsp;program simply writes to the screen. It does not read anything, calculate anything, or allow for&nbsp;<a href="https://www.codecademy.com/resources/docs/cpp/user-input" rel="noopener noreferrer" target="_blank" style="color: var(--color-primary); background-color: transparent;">user input</a>. That’s no fun!</p><p>Real programs tend to produce results based on some input that the user of the program gives, rather than just outputting the same thing every time.</p><p>To read something from the keyboard, we first need somewhere in the computer’s memory to&nbsp;<em>store data</em>. That is where variables come in.</p><p>A&nbsp;<a href="https://www.codecademy.com/resources/docs/cpp/variables?page_ref=catalog" rel="noopener noreferrer" target="_blank" style="color: var(--color-primary); background-color: transparent;"><strong>variable</strong></a>&nbsp;is simply a name that represents a particular piece of your computer’s memory that has been set aside for you to store, retrieve, and use data.</p><p>In this lesson, we will learn about some of the basic&nbsp;<a href="https://www.codecademy.com/resources/docs/cpp/data-types?page_ref=catalog" rel="noopener noreferrer" target="_blank" style="color: var(--color-primary); background-color: transparent;">data types</a>:</p><ul><li><code style="color: rgb(21, 20, 31); background-color: rgb(234, 233, 237);">int</code>: integer numbers</li><li><code style="color: rgb(21, 20, 31); background-color: rgb(234, 233, 237);">double</code>: floating-point numbers</li><li><code style="color: rgb(21, 20, 31); background-color: rgb(234, 233, 237);">char</code>: individual characters</li><li><code style="color: rgb(21, 20, 31); background-color: rgb(234, 233, 237);">string</code>: a sequence of characters</li><li><code style="color: rgb(21, 20, 31); background-color: rgb(234, 233, 237);">bool</code>: true/false values</li></ul><p>Every variable has a&nbsp;<strong>type</strong>, which represents the kind of information you can store inside of it. It tells your compiler how much memory to set aside for the variable, and it defines what you can do with the variable.</p>', '');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('9d57c570-118e-4af8-82ea-4e0c627512bc', 1, '88515ed4-0b74-47d8-9279-0d47c2a21ef4', 'LESSON', 'Basic Data Types', NULL, '<h4>Basic Data Types:</h4><p><a href="https://www.codecademy.com/resources/docs/cpp?page_ref=catalog" rel="noopener noreferrer" target="_blank" style="color: var(--color-yellow); background-color: transparent;">C++</a>&nbsp;provides a rather large number of&nbsp;<a href="https://www.codecademy.com/resources/docs/cpp/data-types?page_ref=catalog" rel="noopener noreferrer" target="_blank" style="color: var(--color-yellow); background-color: transparent;">types</a>. However, you can write perfectly good programs using only five of those:</p><p><span style="background-color: rgb(255, 255, 255); color: var(--color-text);"><img src="https://content.codecademy.com/courses/learn-cpp/variables/data-types.gif"></span></p><p>Here are some examples of declaring and initializing&nbsp;<a href="https://www.codecademy.com/resources/docs/cpp/variables?page_ref=catalog" rel="noopener noreferrer" target="_blank" style="color: var(--color-yellow); background-color: transparent;">variables</a>:</p><pre class="ql-syntax" spellcheck="false">int age =&nbsp;28;

double price =&nbsp;8.99;

char grade =&nbsp;''A'';

std::string message =&nbsp;"Game Over";

bool late_to_work =&nbsp;true;

</pre><h4>Datatype Modifiers:</h4><p>As the name implies, datatype modifiers are used with built-in data types to modify the length of data that a particular data type can hold. Data type modifiers in C++ are:</p><ul><li><code style="color: rgb(79, 224, 176); background-color: transparent;"><strong>signed</strong></code></li><li><code style="color: rgb(79, 224, 176); background-color: transparent;"><strong>unsigned</strong></code></li><li><code style="color: rgb(79, 224, 176); background-color: transparent;"><strong>short</strong></code></li><li><code style="color: rgb(79, 224, 176); background-color: transparent;"><strong>long</strong></code></li></ul><p>We will learn about these in a bit!</p><h4>Const:</h4><p><code style="color: rgb(79, 224, 176); background-color: transparent;"><strong>const</strong></code>&nbsp;(constant) variables cannot be changed by your program during execution.</p><pre class="ql-syntax" spellcheck="false">const double quarter =&nbsp;0.25;

// and now variable quarter can only be 0.25

</pre><p>Simply add the keyword&nbsp;<code style="color: rgb(79, 224, 176); background-color: transparent;"><strong>const</strong></code>&nbsp;before the data type during declaration to make the variable not modifiable.</p><h4>Type Conversion:</h4><p>A type cast is basically a conversion from one type to another.</p><p>The notation&nbsp;<code style="color: rgb(79, 224, 176); background-color: transparent;"><strong>(type) value</strong></code>&nbsp;means “convert&nbsp;<code style="color: rgb(79, 224, 176); background-color: transparent;"><strong>value</strong></code>&nbsp;to&nbsp;<code style="color: rgb(79, 224, 176); background-color: transparent;"><strong>type</strong></code>“. So for example:</p><pre class="ql-syntax" spellcheck="false">double weight1;
int weight2;

weight1 =&nbsp;154.49;
weight2 =&nbsp;(int) weight1;

// weight2 is now 154

</pre><p><strong>Note:</strong>&nbsp;Going from a&nbsp;<code style="color: rgb(79, 224, 176); background-color: transparent;"><strong>double</strong></code>&nbsp;to an&nbsp;<code style="color: rgb(79, 224, 176); background-color: transparent;"><strong>int</strong></code>&nbsp;simply removes the decimal. There’s no rounding involved.</p>', '');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('6147f0ef-ff4f-46d8-921a-a1a3fc5ad0a0', 2, '88515ed4-0b74-47d8-9279-0d47c2a21ef4', 'VIDEO', 'C++ Data Types', NULL, '', 'https://www.youtube.com/watch?v=8GJqjFoY7UQ');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('d84a5566-793a-4da3-acf3-1163c8fdd745', 3, '88515ed4-0b74-47d8-9279-0d47c2a21ef4', 'CODE', 'Sign number', 'b6484e21-6937-489c-b031-b71767994750', 'Same sign number', '');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('9592bc3e-874d-4d62-9b06-877d2ad79998', 4, '88515ed4-0b74-47d8-9279-0d47c2a21ef4', 'VIDEO', 'Data type sizes', NULL, '', 'https://www.youtube.com/watch?v=Bgs9PxHuF1M');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('4ee891ca-5117-425e-a226-288b50190375', 0, '75c1b5b9-370d-4c24-9335-56c5dbd43c51', 'LESSON', 'Conditionals & Logic', NULL, '<h3>Introduction to Conditionals &amp; Logic</h3><p>&lt;1 min</p><p>Every program we’ve seen so far has only had one possible path of execution — they all execute line by line, from top to bottom. And every time you run one of those programs, it gives you the same exact result. But it’s the twenty-first century, and we like options!</p><p>In this lesson, we will explore how programs make decisions by evaluating conditions and introduce logic into our code!</p><p>We’ll be covering the following concepts:</p><ul><li><code style="color: rgb(21, 20, 31); background-color: rgb(234, 233, 237);">if</code>,&nbsp;<code style="color: rgb(21, 20, 31); background-color: rgb(234, 233, 237);">else if</code>, and&nbsp;<code style="color: rgb(21, 20, 31); background-color: rgb(234, 233, 237);">else</code>&nbsp;statements</li><li><code style="color: rgb(21, 20, 31); background-color: rgb(234, 233, 237);"><a href="https://www.codecademy.com/resources/docs/cpp/switch?page_ref=catalog" rel="noopener noreferrer" target="_blank">switch</a></code>&nbsp;statements</li><li><a href="https://www.codecademy.com/resources/docs/cpp/operators?page_ref=cataloglink" rel="noopener noreferrer" target="_blank" style="color: var(--color-primary); background-color: transparent;">Relational operators</a></li><li><a href="https://www.codecademy.com/resources/docs/cpp/operators?page_ref=catalog" rel="noopener noreferrer" target="_blank" style="color: var(--color-primary); background-color: transparent;">Logical operators</a></li></ul><p>So…&nbsp;<em>if</em>&nbsp;you’ve already learned these concepts in another language, go to the next lesson —&nbsp;<em>else</em>, prepare yourself and let’s get started!</p>', '');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('cc2e6609-5a53-4d06-993d-3dd1d7bf840f', 1, '75c1b5b9-370d-4c24-9335-56c5dbd43c51', 'LESSON', 'Logical Operators', NULL, '<h3>Introduction to Logical Operators</h3><p>1 min</p><p>Often, when we are trying to create a control flow for our program, we’ll encounter situations where the logic cannot be satisfied with a single condition.</p><p><a href="https://www.codecademy.com/resources/docs/cpp/operators?page_ref=catalog" rel="noopener noreferrer" target="_blank" style="color: var(--color-primary); background-color: transparent;"><em>Logical operators</em></a>&nbsp;are used to combine two or more conditions. They allow programs to make more flexible decisions. The result of the operation of a logical operator is a&nbsp;<code style="color: rgb(21, 20, 31); background-color: rgb(234, 233, 237);">bool</code>&nbsp;value of either&nbsp;<code style="color: rgb(21, 20, 31); background-color: rgb(234, 233, 237);">true</code>&nbsp;or&nbsp;<code style="color: rgb(21, 20, 31); background-color: rgb(234, 233, 237);">false</code>.</p><p>There are three logical operators that we will cover:</p><ul><li><code style="color: rgb(21, 20, 31); background-color: rgb(234, 233, 237);">&amp;&amp;</code>: the&nbsp;<code style="color: rgb(21, 20, 31); background-color: rgb(234, 233, 237);">and</code>&nbsp;logical operator</li><li><code style="color: rgb(21, 20, 31); background-color: rgb(234, 233, 237);">||</code>: the&nbsp;<code style="color: rgb(21, 20, 31); background-color: rgb(234, 233, 237);">or</code>&nbsp;logical operator</li><li><code style="color: rgb(21, 20, 31); background-color: rgb(234, 233, 237);">!</code>: the&nbsp;<code style="color: rgb(21, 20, 31); background-color: rgb(234, 233, 237);">not</code>&nbsp;logical operator</li></ul><p>We will also discuss the order of operations.</p>', '');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('bbefd6ae-0381-4ff2-88a4-eaf6457e8ff3', 2, '75c1b5b9-370d-4c24-9335-56c5dbd43c51', 'CODE', 'Prime number', 'b6484e21-6937-489c-b031-b71767994758', 'Check prime number', '');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('c98adbce-828d-4faf-bb47-7d8028167274', 3, '75c1b5b9-370d-4c24-9335-56c5dbd43c51', 'VIDEO', 'Operators in C++', NULL, '', 'https://www.youtube.com/watch?v=ezqsL-st8qg');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('b1de3308-67cc-4abd-b3a7-6a3d0f235e96', 4, '75c1b5b9-370d-4c24-9335-56c5dbd43c51', 'CODE', 'Sum of two integer', 'b6484e21-6937-489c-b031-b71767994221', 'Sum of two integer', '');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('9d5a2747-e2e4-49c5-a1eb-1bfd38a764a6', 5, '75c1b5b9-370d-4c24-9335-56c5dbd43c51', 'CODE', 'Three sum closest', 'b6484e21-6937-489c-b031-b71767994739', 'Three sum closest', '');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('c194da54-8669-4054-8dd5-e574a3df5c09', 0, 'e099d057-b400-456b-b01a-54c5be0364d4', 'LESSON', 'Loops', NULL, '<h3>Introduction to Loops</h3><p>&lt;1 min</p><p>A&nbsp;<strong>loop</strong>&nbsp;is a programming tool that&nbsp;<em>repeats</em>&nbsp;some code or a set of instructions until a specified condition is reached. As a programmer, you’ll find that you rely on&nbsp;<a href="https://www.codecademy.com/resources/docs/cpp/loops" rel="noopener noreferrer" target="_blank" style="color: var(--color-primary); background-color: transparent;">loops</a>&nbsp;all the time! You’ll hear the generic term “iterate” when referring to loops;&nbsp;<em>iterate</em>&nbsp;simply means “to repeat”.</p><p>When we see that a process has to repeat multiple times in a row, we write a loop. Loops allow us to create efficient code that automates processes to make scalable, manageable programs.</p><p>In this lesson, we will learn about two types of loops:&nbsp;<code style="color: rgb(21, 20, 31); background-color: rgb(234, 233, 237);">while</code>&nbsp;loops and&nbsp;<code style="color: rgb(21, 20, 31); background-color: rgb(234, 233, 237);">for</code>&nbsp;loops!</p>', '');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('b0b854a6-a995-4510-8d38-03e027c49f83', 1, 'e099d057-b400-456b-b01a-54c5be0364d4', 'LESSON', 'Errors', NULL, '<h3>Introduction to Bugs</h3><p>1 min</p><p><em>“First actual case of bug being found.”</em></p><p>The story goes that on September 9th, 1947, computer scientist&nbsp;<a href="https://en.wikipedia.org/wiki/Grace_Hopper" rel="noopener noreferrer" target="_blank" style="color: var(--color-primary); background-color: transparent;">Grace Hopper</a>&nbsp;found a moth in the Harvard Mark II computer’s log book and reported the world’s first literal computer bug. However, the term “bug”, in the sense of technical error, dates back at least to 1878 and with Thomas Edison.</p><p>On your programming journey, you are destined to encounter innumerable red errors. Some even say, that debugging is over 75% of the development time. But what makes a programmer successful isn’t avoiding errors, it’s knowing how to find the solution.</p><p>In C++, there are many different ways of classifying errors, but they can be boiled down to four categories:</p><ul><li><strong>Compile-time errors:</strong>&nbsp;Errors found by the compiler.</li><li><strong>Link-time errors:</strong>&nbsp;Errors found by the linker when it is trying to combine object files into an executable program.</li><li><strong>Run-time errors:</strong>&nbsp;Errors found by checks in a running program.</li><li><strong>Logic errors:</strong>&nbsp;Errors found by the programmer looking for the causes of erroneous results.</li></ul><p>In this mini-lesson, we will be looking at different errors and different error messages, and we’ll teach you how to think about errors in your code a little differently.</p>', '');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('31cfeeec-30ad-482f-8aea-028913d2a0f2', 2, 'e099d057-b400-456b-b01a-54c5be0364d4', 'CODE', 'FizzBuzz', 'b6484e21-6937-489c-b031-b71767994737', 'FizzBuzz', '');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('1b22d932-f8c0-41ec-a46f-46b2eec749dc', 0, 'e31671c0-e26f-46e7-ba81-6d954a51c37c', 'LESSON', 'Vectors', NULL, '<h3>Introduction to Vectors</h3><p>1 min</p><p>To do just about anything of interest in a program, we need a group of data to work with.</p><p>For example, our program might need:</p><ul><li>A list of Twitter’s trending tags</li><li>A set of payment options for a car</li><li>A catalog of eBooks read over the last year</li></ul><p>The need for storing a collection of data is endless.</p><p>We are familiar with&nbsp;<a href="https://www.codecademy.com/resources/docs/cpp/data-types" rel="noopener noreferrer" target="_blank" style="background-color: transparent; color: var(--color-primary);">data types</a>&nbsp;like&nbsp;<code style="background-color: rgb(234, 233, 237); color: rgb(21, 20, 31);">int</code>&nbsp;and&nbsp;<code style="background-color: rgb(234, 233, 237); color: rgb(21, 20, 31);">double</code>, but how do we store a group of&nbsp;<code style="background-color: rgb(234, 233, 237); color: rgb(21, 20, 31);">int</code>s or a group of&nbsp;<code style="background-color: rgb(234, 233, 237); color: rgb(21, 20, 31);">double</code>s?</p><p>In this lesson, we will start with one of the simplest, and arguably the most useful, ways of storing data in C++: a vector.</p><p>A&nbsp;<em>vector</em>&nbsp;is a sequence of elements that you can access by index.</p>', '');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('2f67e699-31f1-4507-84ef-d34410c5f489', 1, 'e31671c0-e26f-46e7-ba81-6d954a51c37c', 'LESSON', 'Arrays', NULL, '<p><strong>Like vectors, the array is a data structure used in C++ to store a sequential collection of elements. Unlike vectors, its size cannot be changed.</strong></p><p>Being able to store multiple pieces of related information in the same structure is very useful when writing C++ programs. One way we can do that is by using vectors:</p><pre class="ql-syntax" spellcheck="false">std::vector&lt;int&gt; favoriteNums =&nbsp;{7, 9, 15, 16};

std::cout &lt;&lt; favoriteNums[2]; // Prints: 15

</pre><p>Vectors are a modern approach to handling information. But C++ also inherits a more low-level means of doing this from its parent language, C, called&nbsp;<em>arrays</em>.</p><p>Arrays in C++ are similar to vectors in that they allow us to store groups of information. However, arrays are ultimately lower-level constructs and require some more work on the part of the user.</p><h2>Arrays vs. Vectors</h2><p>If you’ve used C++ vectors in the past, you may be wondering what exactly the difference is between them and arrays, and when you should use which.</p><p>As was mentioned earlier, arrays are inherited from C, C++’s parent language. They are a low-level data structure and are incredibly rigid.&nbsp;<em>With arrays, you can’t add or remove elements; you can only modify existing elements.</em></p><p>Vectors are originated from arrays. Early in the creation of C++, the language developers took these basic arrays and wrote code to enhance them and make them more flexible and powerful. Therefore you can think of vectors as super arrays!</p><p>Vectors don’t require a static size. It’s possible to add and remove elements from them, as well as access their current size at any time.</p><h2>Creating an Array</h2><p>When creating an array, you have to keep two pieces of information in mind:</p><ol><li>The type of data you want to store inside of it.</li><li>How many items you want it to be able to hold (its size).</li></ol><p>We can create an array a lot like we create normal variables, by specifying the data type, giving it a descriptive name, and also specifying its size:</p><pre class="ql-syntax" spellcheck="false">int favoriteNums[4];

</pre><p>In the above code example, we’ve created an array with a size of&nbsp;<code style="background-color: transparent; color: rgb(79, 224, 176);"><strong>4</strong></code>, meaning it can hold four integers (all four elements will initially have the default&nbsp;<code style="background-color: transparent; color: rgb(79, 224, 176);"><strong>int</strong></code>&nbsp;value of&nbsp;<code style="background-color: transparent; color: rgb(79, 224, 176);"><strong>0</strong></code>).</p><p>In many cases, you won’t know what data needs to go in the array until after you’ve created it, but if you do happen to know the contents of the array ahead of time, you can initialize it with custom values upfront:</p><pre class="ql-syntax" spellcheck="false">int favoriteNums[] =&nbsp;{7, 9, 15, 16};

</pre><p>This array would also have a size of&nbsp;<code style="background-color: transparent; color: rgb(79, 224, 176);"><strong>4</strong></code>, but we don’t need to explicitly specify that when we initialize it in this way.</p><h2>Array Indices</h2><p>Like vectors, each element in an array is assigned a specific index starting at zero. To access or modify an element in the array you may simply refer to it by its index and operate on it accordingly.</p><pre class="ql-syntax" spellcheck="false">char vowels[] =&nbsp;{''a'', ''e'', ''i'', ''o'', ''u''};
//&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;indexes:&nbsp;&nbsp;0&nbsp;&nbsp;&nbsp;&nbsp;1&nbsp;&nbsp;&nbsp;&nbsp;2&nbsp;&nbsp;&nbsp;&nbsp;3&nbsp;&nbsp;&nbsp;&nbsp;4

std::cout &lt;&lt; vowels[0]; // Prints: a

vowels[0] =&nbsp;''r'';

std::cout &lt;&lt; vowels[0]; // Prints: r

</pre><p>In the case above we initialized an array of&nbsp;<code style="background-color: transparent; color: rgb(79, 224, 176);"><strong>char</strong></code>s with all of the vowels, and then printed out the first element in the array at index&nbsp;<code style="background-color: transparent; color: rgb(79, 224, 176);"><strong>0</strong></code>. We then modified the element at index&nbsp;<code style="background-color: transparent; color: rgb(79, 224, 176);"><strong>0</strong></code>&nbsp;by assigning it a new value of&nbsp;<code style="background-color: transparent; color: rgb(79, 224, 176);"><strong>r</strong></code>, which got printed out below.</p><p>Arrays in C++ have a set size, meaning you can’t add or remove elements once the array has been created. You may only modify existing elements without changing the total size or shape of the structure.</p>', '');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('46c10603-3b46-4f72-b259-9e8d20e90d48', 2, 'e31671c0-e26f-46e7-ba81-6d954a51c37c', 'VIDEO', 'Passing Vectors to Functions', NULL, '', 'https://www.youtube.com/watch?v=aUhYCyU2Meo');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('d72d93dd-1e4b-49f3-829d-6bd7391e2fdc', 3, 'e31671c0-e26f-46e7-ba81-6d954a51c37c', 'CODE', 'Array sum', 'b6484e21-6937-489c-b031-b71767994736', 'Sum of an array', '');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('1da523d7-baa5-49f7-b045-af02b4b5ce4a', 0, '2a90b255-ca79-4fba-af46-952ac41a0502', 'LESSON', 'Functions', NULL, '<h3>The Function of Functions</h3><p>4 min</p><p>As a programmer, you will find yourself reusing the same blocks of code over and over throughout your program. In times like these, you can turn to functions.</p><p>Also known as a method or procedure, a&nbsp;<em>function</em>&nbsp;is a named group of code statements that accomplish something together, a bit like a factory machine.</p><p><img src="https://content.codecademy.com/courses/learn-cpp/functions/functions-conceptual.gif">There are some great reasons to use functions in your code:</p><ul><li>A single line can make all that code fire off instead of a whole bunch of lines.</li><li>You can build DRY (Don’t Repeat Yourself) code, reusing the code you already wrote.</li><li>Functions help make your code flexible and&nbsp;<em>modular</em>, meaning you can group your code more easily by task.</li></ul><p>In fact, every C++ program has at least one function. “Hold on,” you may be thinking, “I’ve written some C++ programs, but I haven’t written any functions yet!”</p><p>Well, as it happens,&nbsp;<code style="color: rgb(21, 20, 31); background-color: rgb(234, 233, 237);">main()</code>&nbsp;is a function that you’ve already used! And you’ll understand it a bit more as you learn how functions work.</p>', '');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('a71a049b-ad3c-4461-a1b7-b51cbe7a202d', 1, '2a90b255-ca79-4fba-af46-952ac41a0502', 'LESSON', 'C++ Functions challenge', NULL, '<h3>How It Works</h3><p>&lt;1 min</p><p>Roll up your sleeves and get yourself in the mood for&nbsp;<a href="https://www.codecademy.com/resources/docs/cpp/functions" rel="noopener noreferrer" target="_blank" style="color: var(--color-primary); background-color: transparent;">functions</a>, because it’s code challenge time!</p><p>Say what? Here’s how it works:</p><ul><li>Each exercise in this lesson has a C++ function for you to build.</li><li>Each challenge has many solutions and we encourage you to be creative.</li><li>We don’t care what goes on in the function as long as it works the way it should. (Notice those tests in&nbsp;<code style="color: rgb(21, 20, 31); background-color: rgb(234, 233, 237);">main()</code>&nbsp;for each function.)</li></ul><p>As a refresher, C++ function syntax looks like this:</p><pre class="ql-syntax" spellcheck="false">return_type function_name(paramater1, parameter2) {

&nbsp;&nbsp;&nbsp;// Code block here

&nbsp;&nbsp;&nbsp;return output_if_there_is_any;

}

</pre><p>For example, with real code this might look like:</p><pre class="ql-syntax" spellcheck="false">bool is_even(int number) {

&nbsp;&nbsp;if (number %&nbsp;2 == 0) {

&nbsp;&nbsp;&nbsp;&nbsp;return true;

&nbsp;&nbsp;}

&nbsp;&nbsp;return false;

}

</pre><p>Best of luck!</p>', '');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('4b63932a-f317-4904-9da1-66659e2c2569', 2, '2a90b255-ca79-4fba-af46-952ac41a0502', 'LESSON', 'FUNCTIONS: SCOPE & FLEXIBILITY', NULL, '<h3>The Scope of Things</h3><p>7 min</p><p>Take a look at the program below. We have a&nbsp;<code style="color: rgb(21, 20, 31); background-color: rgb(234, 233, 237);">void</code>&nbsp;function named&nbsp;<code style="color: rgb(21, 20, 31); background-color: rgb(234, 233, 237);">favorite_animal()</code>&nbsp;and&nbsp;<code style="color: rgb(21, 20, 31); background-color: rgb(234, 233, 237);">main()</code>&nbsp;with a few statements inside.</p><pre class="ql-syntax" spellcheck="false">#include &lt;iostream&gt;

std::string sea_animal =&nbsp;"manatee";

void favorite_animal(std::string best_animal) {

&nbsp;&nbsp;std::string animal =&nbsp;best_animal;
&nbsp;&nbsp;std::cout &lt;&lt; "Best animal: " &lt;&lt; animal &lt;&lt; "\n";

}

int main() {

&nbsp;&nbsp;favorite_animal("jaguar");

&nbsp;&nbsp;std::cout &lt;&lt; sea_animal &lt;&lt; "\n";
&nbsp;&nbsp;std::cout &lt;&lt; animal &lt;&lt; "\n";

}

</pre><p>When this program is compiled and executed,&nbsp;<code style="color: rgb(21, 20, 31); background-color: rgb(234, 233, 237);">sea_animal</code>&nbsp;will print, but&nbsp;<code style="color: rgb(21, 20, 31); background-color: rgb(234, 233, 237);">animal</code>&nbsp;won’t. Why do you think that’s the case?</p><p><em>Scope</em>&nbsp;is the region of code that can access or view a given element.</p><ul><li><a href="https://www.codecademy.com/resources/docs/cpp/variables" rel="noopener noreferrer" target="_blank" style="color: var(--color-primary); background-color: transparent;">Variables</a>&nbsp;defined in&nbsp;<em>global scope</em>&nbsp;are accessible throughout the program.</li><li>Variables defined in a function have&nbsp;<em>local scope</em>&nbsp;and are only accessible inside the function.</li></ul><p><code style="color: rgb(21, 20, 31); background-color: rgb(234, 233, 237);">sea_animal</code>&nbsp;was defined in global scope at the top of the program, outside of&nbsp;<code style="color: rgb(21, 20, 31); background-color: rgb(234, 233, 237);">main()</code>. So&nbsp;<code style="color: rgb(21, 20, 31); background-color: rgb(234, 233, 237);">sea_animal</code>&nbsp;is defined everywhere in the program.</p><p>Because&nbsp;<code style="color: rgb(21, 20, 31); background-color: rgb(234, 233, 237);">animal</code>&nbsp;was only defined within&nbsp;<code style="color: rgb(21, 20, 31); background-color: rgb(234, 233, 237);">favorite_animal()</code>&nbsp;and not returned, it is not accessible to the rest of the program.</p>', '');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('93884e62-225d-41e8-8bef-2b6b83525606', 3, '2a90b255-ca79-4fba-af46-952ac41a0502', 'CODE', '2^k', 'b6484e21-6937-489c-b031-b71767994745', 'Check 2^k', '');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('fc975304-6d90-4bb7-a94b-4952aa2e3c27', 0, '3e3699ce-1b80-4236-873f-05b17522e25f', 'VIDEO', 'Classes & Objects', NULL, '', 'https://www.youtube.com/watch?v=nVrQO2eVU7A');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('67091f8f-802e-4169-9678-78fbb2555dde', 1, '3e3699ce-1b80-4236-873f-05b17522e25f', 'LESSON', 'Classes & Objects', NULL, '<h3>Getting Classy with C++</h3><p>3 min</p><p>So far, we’ve used several&nbsp;<a href="https://www.codecademy.com/resources/docs/cpp/data-types" rel="noopener noreferrer" target="_blank" style="background-color: transparent; color: var(--color-primary);">data types</a>, including&nbsp;<code style="background-color: rgb(234, 233, 237); color: rgb(21, 20, 31);">int</code>,&nbsp;<code style="background-color: rgb(234, 233, 237); color: rgb(21, 20, 31);">double</code>,&nbsp;<code style="background-color: rgb(234, 233, 237); color: rgb(21, 20, 31);">std::string</code>, and&nbsp;<code style="background-color: rgb(234, 233, 237); color: rgb(21, 20, 31);">bool</code>. When we work with&nbsp;<code style="background-color: rgb(234, 233, 237); color: rgb(21, 20, 31);">int</code>&nbsp;or&nbsp;<code style="background-color: rgb(234, 233, 237); color: rgb(21, 20, 31);">std::string</code>, we can create&nbsp;<a href="https://www.codecademy.com/resources/docs/cpp/variables" rel="noopener noreferrer" target="_blank" style="background-color: transparent; color: var(--color-primary);">variables</a>&nbsp;with certain properties and&nbsp;<a href="https://www.codecademy.com/resources/docs/cpp/methods" rel="noopener noreferrer" target="_blank" style="background-color: transparent; color: var(--color-primary);">methods</a>&nbsp;specific to those types. For example:</p><pre class="ql-syntax" spellcheck="false">int age =&nbsp;33;
age++; // age is now 34

</pre><p>But what happens when you want to create a “type” for something else? You can make your own! Bjarne Stroustrup developed C++ because he wanted to add a feature known as “classes” to the C language. A C++&nbsp;<em>class</em>&nbsp;is a user-defined type.</p><p>The class serves as a blueprint for&nbsp;<a href="https://www.codecademy.com/resources/docs/cpp/objects" rel="noopener noreferrer" target="_blank" style="background-color: transparent; color: var(--color-primary);"><em>objects</em></a>, which are instances of the class (just like&nbsp;<code style="background-color: rgb(234, 233, 237); color: rgb(21, 20, 31);">age</code>&nbsp;is an instance of&nbsp;<code style="background-color: rgb(234, 233, 237); color: rgb(21, 20, 31);">int</code>). An object gets characteristics and behaviors from its class.</p><p>We can create an empty C++ class like this in a header file:</p><pre class="ql-syntax" spellcheck="false">class City {
&nbsp;&nbsp;
}; // &lt;-- notice this semicolon!

</pre><p><strong>Fun fact:</strong>&nbsp;C++’s original name was “C with&nbsp;<a href="https://www.codecademy.com/resources/docs/cpp/classes" rel="noopener noreferrer" target="_blank" style="background-color: transparent; color: var(--color-primary);">Classes</a>.”</p>', '');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('5e062ef6-0170-44a5-8b03-0f03f66e9b25', 2, '3e3699ce-1b80-4236-873f-05b17522e25f', 'LESSON', 'Why Object-Oriented Programming?', NULL, '<h1>Why Object-Oriented Programming?</h1><p><strong>Why has object-oriented programming become a major programming paradigm?</strong></p><p>So far, you’ve built two kinds of C++ programs:</p><ul><li>Procedural: The program moves through a linear series of instructions.</li><li>Functional: The program moves from one function to another.</li></ul><p>But there is another very common way to structure C++ code: object-oriented programming.</p><p>Let’s consider a physical object: a light bulb. A light (usually) has two possible states: on and off. It also has functionality that allows you to change its state: you can turn it on and you turn it off. Thankfully, you don’t need to know electrical engineering to use the light! You only need to know how to interact with it.</p><p><em>Object-oriented programming (OOP)</em>&nbsp;is a programming paradigm that allows you to package together data states and functionality to modify those data states, while keeping the details hidden away (like with the lightbulb). As a result, code with OOP design is flexible, modular, and abstract. This makes it particularly useful when you create larger programs.</p><p>In C++, you can apply OOP in your code with classes and objects. And the C++ objects you create will have states and functionality.</p><p>There are four major benefits to object-oriented programming:</p><ul><li><strong>Encapsulation:</strong>&nbsp;in OOP, you bundle code into a single unit where you can determine the scope of each piece of data.</li><li><strong>Abstraction:</strong>&nbsp;by using classes, you are able to generalize your object types, simplifying your program.</li><li><strong>Inheritance:</strong>&nbsp;because a class can inherit attributes and behaviors from another class, you are able to reuse more code.</li><li><strong>Polymorphism:</strong>&nbsp;one class can be used to create many objects, all from the same flexible piece of code.</li></ul><p><br></p>', '');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('6e484389-1ef9-4628-b90d-550801d65e08', 3, '3e3699ce-1b80-4236-873f-05b17522e25f', 'VIDEO', 'Why Object-Oriented Programming?', NULL, '', 'https://www.youtube.com/watch?v=u8gRq4OojXY&embeds_referring_euri=https%3A%2F%2Fwww.codecademy.com%2F&embeds_referring_origin=https%3A%2F%2Fwww.codecademy.com&feature=emb_imp_woyt');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('8c62f072-2efb-4919-a27e-681c64ea0535', 0, '80124868-3c09-4967-b846-43ba04c064f7', 'LESSON', 'Introduction, Outputting & Math Operators in C', NULL, '<h3>Introduction to C Programming</h3><p>C is a powerful and widely-used programming language known for its efficiency and control. It serves as the foundation for many other languages and is crucial for system-level programming. This lesson will introduce you to the basics of C programming, focusing on outputting data and using math operators.</p><h3>Basic Structure of a C Program</h3><p>A C program consists of functions, with the <code>main</code> function being the entry point. The structure of a simple C program is as follows:</p><pre class="ql-syntax" spellcheck="false">c
Copy code
#include &lt;stdio.h&gt;

int main() {
    // Code to execute
    return 0;
}
</pre><ul><li><code>#include &lt;stdio.h&gt;</code>: This preprocessor directive includes the standard input/output library, allowing you to use functions like <code>printf</code>.</li><li><code>int main()</code>: The <code>main</code> function is where the execution of the program begins.</li><li><code>return 0;</code>: This statement ends the <code>main</code> function and returns a status code to the operating system.</li></ul><h3>Outputting Data</h3><p>In C, the <code>printf</code> function is used to output data to the console. It allows you to display formatted text and variables.</p><p><strong>Basic Syntax:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
printf("format string", variables);
</pre><p><strong>Examples:</strong></p><ul><li><strong>Printing Text:</strong></li></ul><pre class="ql-syntax" spellcheck="false">c
Copy code
printf("Hello, World!\n");
</pre><ul><li>This will output the text <code>Hello, World!</code> followed by a newline.</li><li><strong>Printing Variables:</strong></li></ul><pre class="ql-syntax" spellcheck="false">c
Copy code
int age = 25;
printf("Age: %d\n", age);
</pre><ul><li>The <code>%d</code> format specifier is used to print integers. Other specifiers include <code>%f</code> for floating-point numbers and <code>%s</code> for strings.</li><li><strong>Formatted Output:</strong></li></ul><pre class="ql-syntax" spellcheck="false">c
Copy code
float pi = 3.14159;
printf("Value of pi: %.2f\n", pi);
</pre><ul><li>The <code>%.2f</code> format specifier limits the floating-point number to two decimal places.</li></ul><h3>Math Operators in C</h3><p>Math operators in C perform arithmetic operations on variables and constants. They are similar to those used in other programming languages.</p><p><strong>Arithmetic Operators:</strong></p><ul><li><strong>Addition (</strong><code><strong>+</strong></code><strong>):</strong> Adds two values.</li></ul><pre class="ql-syntax" spellcheck="false">c
Copy code
int sum = 5 + 3; // sum is 8
</pre><ul><li><strong>Subtraction (</strong><code><strong>-</strong></code><strong>):</strong> Subtracts one value from another.</li></ul><pre class="ql-syntax" spellcheck="false">c
Copy code
int difference = 10 - 4; // difference is 6
</pre><ul><li><strong>Multiplication (</strong><code><strong>*</strong></code><strong>):</strong> Multiplies two values.</li></ul><pre class="ql-syntax" spellcheck="false">c
Copy code
int product = 7 * 6; // product is 42
</pre><ul><li><strong>Division (</strong><code><strong>/</strong></code><strong>):</strong> Divides one value by another. For integer division, the result is an integer.</li></ul><pre class="ql-syntax" spellcheck="false">c
Copy code
int quotient = 20 / 4; // quotient is 5
</pre><ul><li><strong>Modulus (</strong><code><strong>%</strong></code><strong>):</strong> Returns the remainder of a division.</li></ul><pre class="ql-syntax" spellcheck="false">c
Copy code
int remainder = 10 % 3; // remainder is 1
</pre><p><strong>Example Program:</strong></p><p>Here is a complete example demonstrating output and math operations:</p><pre class="ql-syntax" spellcheck="false">c
Copy code
#include &lt;stdio.h&gt;

int main() {
    int a = 10;
    int b = 5;
    int sum = a + b;
    int difference = a - b;
    int product = a * b;
    int quotient = a / b;
    int remainder = a % b;

    // Output the results
    printf("a = %d\n", a);
    printf("b = %d\n", b);
    printf("Sum: %d\n", sum);
    printf("Difference: %d\n", difference);
    printf("Product: %d\n", product);
    printf("Quotient: %d\n", quotient);
    printf("Remainder: %d\n", remainder);

    return 0;
}
</pre><p>In this program:</p><ul><li>We declare two integer variables, <code>a</code> and <code>b</code>.</li><li>We perform addition, subtraction, multiplication, division, and modulus operations.</li><li>We use <code>printf</code> to display the results of these operations.</li></ul><h3>Conclusion</h3><p>Understanding how to output data and use basic math operators is fundamental to programming in C. These concepts allow you to perform calculations and display results, forming the basis for more complex programming tasks. With these basics, you can start writing more advanced C programs and explore additional features of the language.</p>', '');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('9b030211-7ade-4d04-b138-e439caa809d8', 1, '80124868-3c09-4967-b846-43ba04c064f7', 'VIDEO', 'C Programming Tutorial for Beginners - Hello World', NULL, '', 'https://www.youtube.com/watch?v=KJgsSFOSQv0&t=544s');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('49386ce6-dd6e-4829-9b31-c9fc05653198', 0, '3c8a381e-8a85-41ca-b07e-4d792c5571fd', 'LESSON', 'Pointers and Memory In C', NULL, '<h3>Introduction to Pointers</h3><p>Pointers are a fundamental concept in C programming that allow you to directly interact with memory. Understanding pointers is crucial for managing memory efficiently and for various advanced programming techniques.</p><h3>What is a Pointer?</h3><p>A pointer is a variable that stores the memory address of another variable. Instead of holding a data value, a pointer holds the address where the value is stored in memory.</p><p><strong>Syntax for Pointer Declaration:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
dataType *pointerName;
</pre><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
int *p;
</pre><p>Here, <code>p</code> is a pointer to an integer.</p><h3>Declaring and Initializing Pointers</h3><p>To use a pointer, you need to declare it and then initialize it with the address of a variable.</p><p><strong>Declaration:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
int *p;
</pre><p><strong>Initialization:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
int x = 10;
p = &amp;x; // &amp;x gives the address of variable x
</pre><p>In this example, <code>p</code> now holds the address of the variable <code>x</code>.</p><h3>Dereferencing Pointers</h3><p>Dereferencing a pointer means accessing the value stored at the address the pointer points to. You use the <code>*</code> operator for dereferencing.</p><p><strong>Syntax:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
*pointerName
</pre><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
int value = *p; // value is now 10, the content of x
</pre><p>Here, <code>*p</code> gives you the value stored at the address held by <code>p</code>.</p><h3>Pointer Arithmetic</h3><p>Pointers can be incremented or decremented to traverse arrays or manipulate data structures.</p><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
int arr[] = {1, 2, 3, 4, 5};
int *ptr = arr;

printf("First element: %d\n", *ptr); // Outputs 1
ptr++; // Move to the next integer
printf("Second element: %d\n", *ptr); // Outputs 2
</pre><h3>Memory Allocation</h3><p>In C, dynamic memory allocation is handled using pointers. Functions from the <code>stdlib.h</code> library, such as <code>malloc</code>, <code>calloc</code>, <code>realloc</code>, and <code>free</code>, are used for this purpose.</p><ul><li><code><strong>malloc(size_t size)</strong></code>: Allocates a block of memory of the specified size.</li></ul><pre class="ql-syntax" spellcheck="false">c
Copy code
int *arr = (int *)malloc(5 * sizeof(int)); // Allocate memory for 5 integers
</pre><ul><li><code><strong>calloc(size_t num, size_t size)</strong></code>: Allocates memory for an array of <code>num</code> elements of <code>size</code> bytes each, and initializes all bytes to zero.</li></ul><pre class="ql-syntax" spellcheck="false">c
Copy code
int *arr = (int *)calloc(5, sizeof(int)); // Allocate memory for 5 integers and initialize to 0
</pre><ul><li><code><strong>realloc(void *ptr, size_t size)</strong></code>: Changes the size of previously allocated memory.</li></ul><pre class="ql-syntax" spellcheck="false">c
Copy code
arr = (int *)realloc(arr, 10 * sizeof(int)); // Resize memory to hold 10 integers
</pre><ul><li><code><strong>free(void *ptr)</strong></code>: Deallocates previously allocated memory.</li></ul><pre class="ql-syntax" spellcheck="false">c
Copy code
free(arr); // Free the allocated memory
</pre><h3>Example Program</h3><p>Here is an example demonstrating the use of pointers and dynamic memory allocation:</p><pre class="ql-syntax" spellcheck="false">c
Copy code
#include &lt;stdio.h&gt;
#include &lt;stdlib.h&gt;

int main() {
    int *ptr;
    int size = 5;

    // Allocate memory
    ptr = (int *)malloc(size * sizeof(int));

    // Check if memory allocation was successful
    if (ptr == NULL) {
        printf("Memory allocation failed\n");
        return 1;
    }

    // Initialize and print values
    for (int i = 0; i &lt; size; i++) {
        ptr[i] = i + 1;
    }

    for (int i = 0; i &lt; size; i++) {
        printf("Element %d: %d\n", i, ptr[i]);
    }

    // Free the allocated memory
    free(ptr);

    return 0;
}
</pre><p>In this program:</p><ul><li>We allocate memory for an array of integers.</li><li>Initialize the array with values and print them.</li><li>Finally, we free the allocated memory to prevent memory leaks.</li></ul><h3>Conclusion</h3><p>Pointers are a powerful feature in C programming that provide direct access to memory. Understanding pointers allows you to manage memory more efficiently and perform advanced programming techniques. With knowledge of pointer arithmetic and dynamic memory allocation, you can write more complex and efficient C programs.</p>', '');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('0fe31630-2800-429e-90af-676228cc4814', 1, '3c8a381e-8a85-41ca-b07e-4d792c5571fd', 'VIDEO', 'C Programming Tutorial for Beginners - Pointers and Memory', NULL, '', 'https://www.youtube.com/watch?v=KJgsSFOSQv0&t=11350s');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('e03ed4e8-de91-4867-8489-0cb157ff2c49', 0, '57fe22fb-ed2b-45d2-b1c0-5e8fca623cce', 'LESSON', 'Variables and Data Types In C', NULL, '<h3>Introduction</h3><p>In C programming, variables and data types are fundamental concepts that form the basis of any C program. Understanding how to declare variables and use different data types is essential for writing efficient and effective code.</p><h3>Variables</h3><p>A variable is a named storage location in memory that holds a value. The value of a variable can be changed during the execution of a program.</p><p><strong>Syntax for Variable Declaration:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
dataType variableName;
</pre><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
int age;
float salary;
</pre><p>In this example:</p><ul><li><code>age</code> is an integer variable.</li><li><code>salary</code> is a floating-point variable.</li></ul><h3>Initializing Variables</h3><p>Variables can be initialized at the time of declaration or later in the program.</p><p><strong>Declaration and Initialization:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
int age = 25;
float salary = 50000.50;
</pre><p><strong>Initialization after Declaration:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
int age;
age = 25;

float salary;
salary = 50000.50;
</pre><h3>Data Types</h3><p>Data types specify the type of data that a variable can hold. C provides several built-in data types, which can be broadly classified into the following categories:</p><h4>1. <strong>Basic Data Types</strong></h4><ul><li><strong>Integer Types (</strong><code><strong>int</strong></code><strong>)</strong></li><li class="ql-indent-1">Used to store whole numbers.</li><li><strong>Example:</strong></li></ul><pre class="ql-syntax" spellcheck="false">c
Copy code
int count = 10;
</pre><ul><li><strong>Floating-Point Types (</strong><code><strong>float</strong></code><strong>, </strong><code><strong>double</strong></code><strong>)</strong></li><li class="ql-indent-1">Used to store numbers with fractional parts.</li><li class="ql-indent-1"><code>float</code> is used for single-precision floating-point numbers.</li><li class="ql-indent-1"><code>double</code> is used for double-precision floating-point numbers.</li><li><strong>Example:</strong></li></ul><pre class="ql-syntax" spellcheck="false">c
Copy code
float temperature = 98.6;
double distance = 123456.789;
</pre><ul><li><strong>Character Type (</strong><code><strong>char</strong></code><strong>)</strong></li><li class="ql-indent-1">Used to store single characters.</li><li><strong>Example:</strong></li></ul><pre class="ql-syntax" spellcheck="false">c
Copy code
char grade = ''A'';
</pre><h4>2. <strong>Derived Data Types</strong></h4><ul><li><strong>Arrays</strong></li><li class="ql-indent-1">Collections of variables of the same type.</li><li><strong>Example:</strong></li></ul><pre class="ql-syntax" spellcheck="false">c
Copy code
int numbers[5] = {1, 2, 3, 4, 5};
</pre><ul><li><strong>Pointers</strong></li><li class="ql-indent-1">Variables that store memory addresses.</li><li><strong>Example:</strong></li></ul><pre class="ql-syntax" spellcheck="false">c
Copy code
int *ptr;
</pre><ul><li><strong>Structures</strong></li><li class="ql-indent-1">User-defined data types that group related variables.</li><li><strong>Example:</strong></li></ul><pre class="ql-syntax" spellcheck="false">c
Copy code
struct Person {
    char name[50];
    int age;
};
</pre><ul><li><strong>Unions</strong></li><li class="ql-indent-1">User-defined data types that can hold different data types but only one at a time.</li><li><strong>Example:</strong></li></ul><pre class="ql-syntax" spellcheck="false">c
Copy code
union Data {
    int i;
    float f;
    char str[20];
};
</pre><h4>3. <strong>Enumeration Types (</strong><code><strong>enum</strong></code><strong>)</strong></h4><ul><li><strong>Enumeration Types</strong></li><li class="ql-indent-1">Define a variable that can hold a set of predefined constants.</li><li><strong>Example:</strong></li></ul><pre class="ql-syntax" spellcheck="false">c
Copy code
enum Weekday { Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday };
</pre><h3>Example Program</h3><p>Here is a simple C program that demonstrates the use of different variables and data types:</p><pre class="ql-syntax" spellcheck="false">c
Copy code
#include &lt;stdio.h&gt;

int main() {
    int age = 25;
    float salary = 50000.50;
    char grade = ''A'';

    // Print variable values
    printf("Age: %d\n", age);
    printf("Salary: %.2f\n", salary);
    printf("Grade: %c\n", grade);

    // Using an array
    int numbers[3] = {10, 20, 30};
    printf("First number: %d\n", numbers[0]);

    // Using a structure
    struct Person {
        char name[50];
        int age;
    };

    struct Person person1;
    person1.age = 30;
    snprintf(person1.name, sizeof(person1.name), "Alice");

    printf("Person''s name: %s\n", person1.name);
    printf("Person''s age: %d\n", person1.age);

    return 0;
}
</pre><p>In this program:</p><ul><li>We declare and initialize variables of different types.</li><li>We use an array to store multiple integers.</li><li>We define and use a structure to group related data.</li></ul><h3>Conclusion</h3><p>Variables and data types are essential components of C programming. Understanding how to declare variables, initialize them, and use different data types allows you to handle various kinds of data efficiently. This knowledge forms the foundation for building more complex programs and algorithms in C.</p>', '');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('846796c7-bec6-41cd-a59e-76dd94092878', 1, '57fe22fb-ed2b-45d2-b1c0-5e8fca623cce', 'VIDEO', 'C Programming Tutorial for Beginners - Variables And Data Types', NULL, '', 'https://www.youtube.com/watch?v=KJgsSFOSQv0&t=1256s');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('b15a286f-731a-49df-a626-eff50219d38e', 0, '99e1bbc1-92cd-4fff-b1ea-5151a6154c4f', 'LESSON', 'Conditionals In C', NULL, '<h3>Introduction</h3><p>Conditionals in C are used to make decisions in a program based on certain conditions. They allow you to control the flow of execution and execute different blocks of code based on whether a condition is true or false. The main conditional statements in C are <code>if</code>, <code>else</code>, <code>else if</code>, and <code>switch</code>.</p><h3>The <code>if</code> Statement</h3><p>The <code>if</code> statement evaluates a condition and executes a block of code if the condition is true.</p><p><strong>Syntax:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
if (condition) {
    // Code to execute if condition is true
}
</pre><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
int number = 10;
if (number &gt; 0) {
    printf("The number is positive.\n");
}
</pre><p>In this example, the message will be printed because the condition <code>number &gt; 0</code> is true.</p><h3>The <code>if-else</code> Statement</h3><p>The <code>if-else</code> statement provides an alternative block of code that is executed if the condition in the <code>if</code> statement is false.</p><p><strong>Syntax:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
if (condition) {
    // Code to execute if condition is true
} else {
    // Code to execute if condition is false
}
</pre><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
int number = -5;
if (number &gt; 0) {
    printf("The number is positive.\n");
} else {
    printf("The number is not positive.\n");
}
</pre><p>Here, since <code>number</code> is not greater than 0, the second message will be printed.</p><h3>The <code>if-else if-else</code> Statement</h3><p>The <code>if-else if-else</code> statement is used to check multiple conditions in sequence. The first true condition''s block is executed, and the rest are skipped.</p><p><strong>Syntax:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
if (condition1) {
    // Code to execute if condition1 is true
} else if (condition2) {
    // Code to execute if condition2 is true
} else {
    // Code to execute if none of the above conditions are true
}
</pre><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
int number = 0;
if (number &gt; 0) {
    printf("The number is positive.\n");
} else if (number &lt; 0) {
    printf("The number is negative.\n");
} else {
    printf("The number is zero.\n");
}
</pre><p>In this example, the output will be "The number is zero" because neither of the first two conditions is true.</p><h3>The <code>switch</code> Statement</h3><p>The <code>switch</code> statement is used to select one of many code blocks to be executed based on the value of a variable.</p><p><strong>Syntax:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
switch (expression) {
    case constant1:
        // Code to execute if expression equals constant1
        break;
    case constant2:
        // Code to execute if expression equals constant2
        break;
    // More cases...
    default:
        // Code to execute if no case matches
}
</pre><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
int day = 3;
switch (day) {
    case 1:
        printf("Monday\n");
        break;
    case 2:
        printf("Tuesday\n");
        break;
    case 3:
        printf("Wednesday\n");
        break;
    case 4:
        printf("Thursday\n");
        break;
    case 5:
        printf("Friday\n");
        break;
    case 6:
        printf("Saturday\n");
        break;
    case 7:
        printf("Sunday\n");
        break;
    default:
        printf("Invalid day\n");
}
</pre><p>In this example, the output will be "Wednesday" because the value of <code>day</code> is 3.</p><h3>Nested Conditional Statements</h3><p>You can nest <code>if</code> and <code>switch</code> statements within each other to handle more complex conditions.</p><p><strong>Example:</strong></p><pre class="ql-syntax" spellcheck="false">c
Copy code
int number = 10;
if (number &gt; 0) {
    if (number % 2 == 0) {
        printf("The number is positive and even.\n");
    } else {
        printf("The number is positive and odd.\n");
    }
} else {
    printf("The number is non-positive.\n");
}
</pre><h3>Conclusion</h3><p>Conditional statements are a key component of control flow in C programming. They allow you to make decisions and execute different parts of your code based on conditions. Mastery of <code>if</code>, <code>else</code>, <code>else if</code>, and <code>switch</code> statements is crucial for creating flexible and robust programs.</p>', '');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('d9b65062-cee8-4694-9116-15acd43149d3', 1, '99e1bbc1-92cd-4fff-b1ea-5151a6154c4f', 'VIDEO', 'C Programming Tutorial for Beginners - If Statements', NULL, '', 'https://www.youtube.com/watch?v=KJgsSFOSQv0&t=6801s');
INSERT INTO "public"."chapter_resource" ("id", "no", "chapter_id", "resource_type", "title", "question_id", "lesson_html", "youtube_video_url") VALUES ('08c0ecd0-f53d-46d4-bf79-f7dfd8b60860', 2, '99e1bbc1-92cd-4fff-b1ea-5151a6154c4f', 'VIDEO', 'C Programming Tutorial for Beginners - Switch Statements', NULL, '', 'https://www.youtube.com/watch?v=KJgsSFOSQv0&t=8091s');


INSERT INTO public.contest(id, name, description, prizes, rules, scoring, thumbnail_url, start_time, end_time, created_by, updated_by, is_public, org_id, is_disabled_forum)
VALUES
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb15', 'Weekly Contest 01',
     '<h3>Welcome to the 1st CodeDynamite Weekly Contest</h3><p><br></p><p>We are thrilled to present the inaugural CodeDynamite Weekly Contest, a premier event designed to challenge your coding skills and ignite your passion for programming. Whether you''re a seasoned developer or a coding enthusiast, this contest offers a unique opportunity to showcase your talents, compete with like-minded individuals, and win exciting prizes.</p><p><br></p><p><strong>About the contest:</strong></p><ul><li><strong>Sponsored by:</strong> CodeDynamite, your go-to platform for cutting-edge coding resources and community support.</li><li><strong>When:</strong> Every week, with fresh and exciting challenges that cater to various skill levels.</li><li><strong>Who Can Participate:</strong> Open to all coding enthusiasts, regardless of experience level.</li></ul><p><br></p><p><strong>Why Join?</strong></p><ul><li><strong>Challenge Yourself:</strong> Tackle a variety of coding problems that will test your creativity and problem-solving abilities.</li><li><strong>Learn and Grow:</strong> Gain new insights and improve your coding skills through hands-on practice and real-time competition.</li><li><strong>Win Prizes:</strong> Stand a chance to win amazing rewards and earn recognition within the coding community.</li></ul><p><br></p><p><strong>How to Register:</strong></p><ul><li>Simply click the registration link below and fill out the required details to secure your spot in the contest.</li><li>Registration is quick, easy, and free!</li></ul><p><br></p><p><strong>Don’t miss out on this fantastic opportunity to connect, compete, and code with the best!</strong></p><p><br></p><p><strong>Register for the contest now and let your coding journey begin!</strong></p><p><a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb15/information" rel="noopener noreferrer" target="_blank">Link to register</a></p><p><br></p><p><br></p>',
     '<p><strong>🎉 Juicy Prizes Await You! 🎉</strong></p><p><br></p><p>Get ready to win some amazing rewards in the 1st CodeDynamite Weekly Contest! Here are the fantastic prizes up for grabs:</p><p><br></p><p><strong>1st Place:</strong></p><ul><li><strong>$500 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite T-Shirt</strong></li><li><strong>Personalized Winner''s Certificate</strong></li></ul><p><br></p><p><strong>2nd Place:</strong></p><ul><li><strong>$250 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Hoodie</strong></li><li><strong>Personalized Runner-Up Certificate</strong></li></ul><p><br></p><p><strong>3rd Place:</strong></p><ul><li><strong>$100 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Mug</strong></li><li><strong>Personalized Certificate of Achievement</strong></li></ul><p><br></p><p>Don''t miss your chance to win these incredible prizes and gain recognition in the coding community. <a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb16/information" rel="noopener noreferrer" target="_blank"><strong>Register now</strong></a> and let the competition begin!</p>',
     '<ol><li>Participants must submit their solutions before the end time.</li><li>Participants must follow the contest rules and guidelines.</li><li>Participants must not cheat or plagiarize.</li></ol>',
     '<p><strong>Pre-determined Challenge Scores:</strong></p><p>Each challenge you conquer has a pre-set score waiting to be claimed. The more complex the challenge, the higher the score you can rack up!</p><p><br></p><p><strong>Test Cases: Your Gateway to Glory:</strong></p><p>Each challenge comes with a battery of test cases designed to put your code through its paces. Every test case you conquer translates into points towards your final score. The more test cases you dominate, the closer you get to scoring supremacy!</p><p><br></p><p><strong>Multiple Submissions? No Problem!</strong></p><p>Feeling creative and tinkering with different solutions? No sweat! We take your highest scoring submission for each challenge into account, so fire away with your best attempts.</p><p><br></p><p><strong>The Leaderboard Beckons: It''s All About the Rank</strong></p><p>Participants are ranked on the glorious leaderboard based on their total score. But what happens when coders achieve the same score? Buckle up, because things get exciting!</p><p><br></p><p><strong>Tie-Breaker Time: Speed Demons Unite!</strong></p><p>In the thrilling case of a tie, the tie-breaker comes down to <strong>speed</strong>. The participant who submitted their highest-scoring solution in the <strong>shortest amount of time</strong> reigns supreme! So, channel your inner coding ninja and blaze through those challenges for ultimate glory.</p>',
     'https://leetcode.com/_next/static/images/weekly-default-553ede7bcc8e1b4a44c28a9e4a32068c.png',
     '2024-07-01 09:30:00.000000+07',
     '2024-07-01 10:30:00.000000+07',
     'b029f559-52a8-4699-b595-71161498ed8c',
     'b029f559-52a8-4699-b595-71161498ed8c',
     true,
     null,
     true
    ),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb16', 'Weekly Contest 02',
     '<h3>Welcome to the 2nd CodeDynamite Weekly Contest</h3><p><br></p><p>We are thrilled to present the inaugural CodeDynamite Weekly Contest, a premier event designed to challenge your coding skills and ignite your passion for programming. Whether you''re a seasoned developer or a coding enthusiast, this contest offers a unique opportunity to showcase your talents, compete with like-minded individuals, and win exciting prizes.</p><p><br></p><p><strong>About the contest:</strong></p><ul><li><strong>Sponsored by:</strong> CodeDynamite, your go-to platform for cutting-edge coding resources and community support.</li><li><strong>When:</strong> Every week, with fresh and exciting challenges that cater to various skill levels.</li><li><strong>Who Can Participate:</strong> Open to all coding enthusiasts, regardless of experience level.</li></ul><p><br></p><p><strong>Why Join?</strong></p><ul><li><strong>Challenge Yourself:</strong> Tackle a variety of coding problems that will test your creativity and problem-solving abilities.</li><li><strong>Learn and Grow:</strong> Gain new insights and improve your coding skills through hands-on practice and real-time competition.</li><li><strong>Win Prizes:</strong> Stand a chance to win amazing rewards and earn recognition within the coding community.</li></ul><p><br></p><p><strong>How to Register:</strong></p><ul><li>Simply click the registration link below and fill out the required details to secure your spot in the contest.</li><li>Registration is quick, easy, and free!</li></ul><p><br></p><p><strong>Don’t miss out on this fantastic opportunity to connect, compete, and code with the best!</strong></p><p><br></p><p><strong>Register for the contest now and let your coding journey begin!</strong></p><p><a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb16/information" rel="noopener noreferrer" target="_blank">Link to register</a></p><p><br></p><p><br></p>',
     '<p><strong>🎉 Juicy Prizes Await You! 🎉</strong></p><p><br></p><p>Get ready to win some amazing rewards in the 1st CodeDynamite Weekly Contest! Here are the fantastic prizes up for grabs:</p><p><br></p><p><strong>1st Place:</strong></p><ul><li><strong>$500 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite T-Shirt</strong></li><li><strong>Personalized Winner''s Certificate</strong></li></ul><p><br></p><p><strong>2nd Place:</strong></p><ul><li><strong>$250 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Hoodie</strong></li><li><strong>Personalized Runner-Up Certificate</strong></li></ul><p><br></p><p><strong>3rd Place:</strong></p><ul><li><strong>$100 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Mug</strong></li><li><strong>Personalized Certificate of Achievement</strong></li></ul><p><br></p><p>Don''t miss your chance to win these incredible prizes and gain recognition in the coding community. <a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb16/information" rel="noopener noreferrer" target="_blank"><strong>Register now</strong></a> and let the competition begin!</p>',
     '<ol><li>Participants must submit their solutions before the end time.</li><li>Participants must follow the contest rules and guidelines.</li><li>Participants must not cheat or plagiarize.</li></ol>',
     '<p><strong>Pre-determined Challenge Scores:</strong></p><p>Each challenge you conquer has a pre-set score waiting to be claimed. The more complex the challenge, the higher the score you can rack up!</p><p><br></p><p><strong>Test Cases: Your Gateway to Glory:</strong></p><p>Each challenge comes with a battery of test cases designed to put your code through its paces. Every test case you conquer translates into points towards your final score. The more test cases you dominate, the closer you get to scoring supremacy!</p><p><br></p><p><strong>Multiple Submissions? No Problem!</strong></p><p>Feeling creative and tinkering with different solutions? No sweat! We take your highest scoring submission for each challenge into account, so fire away with your best attempts.</p><p><br></p><p><strong>The Leaderboard Beckons: It''s All About the Rank</strong></p><p>Participants are ranked on the glorious leaderboard based on their total score. But what happens when coders achieve the same score? Buckle up, because things get exciting!</p><p><br></p><p><strong>Tie-Breaker Time: Speed Demons Unite!</strong></p><p>In the thrilling case of a tie, the tie-breaker comes down to <strong>speed</strong>. The participant who submitted their highest-scoring solution in the <strong>shortest amount of time</strong> reigns supreme! So, channel your inner coding ninja and blaze through those challenges for ultimate glory.</p>',
     'https://leetcode.com/_next/static/images/biweekly-default-f5a8fc3be85b6c9175207fd8fd855d47.png',
     '2024-07-08 09:30:00.000000+07',
     '2024-07-08 10:30:00.000000+07',
     'b029f559-52a8-4699-b595-71161498ed8c',
     'b029f559-52a8-4699-b595-71161498ed8c',
     true,
     null,
     true
    ),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb17', 'Weekly Contest 03',
     '<h3>Welcome to the 3rd CodeDynamite Weekly Contest</h3><p><br></p><p>We are thrilled to present the inaugural CodeDynamite Weekly Contest, a premier event designed to challenge your coding skills and ignite your passion for programming. Whether you''re a seasoned developer or a coding enthusiast, this contest offers a unique opportunity to showcase your talents, compete with like-minded individuals, and win exciting prizes.</p><p><br></p><p><strong>About the contest:</strong></p><ul><li><strong>Sponsored by:</strong> CodeDynamite, your go-to platform for cutting-edge coding resources and community support.</li><li><strong>When:</strong> Every week, with fresh and exciting challenges that cater to various skill levels.</li><li><strong>Who Can Participate:</strong> Open to all coding enthusiasts, regardless of experience level.</li></ul><p><br></p><p><strong>Why Join?</strong></p><ul><li><strong>Challenge Yourself:</strong> Tackle a variety of coding problems that will test your creativity and problem-solving abilities.</li><li><strong>Learn and Grow:</strong> Gain new insights and improve your coding skills through hands-on practice and real-time competition.</li><li><strong>Win Prizes:</strong> Stand a chance to win amazing rewards and earn recognition within the coding community.</li></ul><p><br></p><p><strong>How to Register:</strong></p><ul><li>Simply click the registration link below and fill out the required details to secure your spot in the contest.</li><li>Registration is quick, easy, and free!</li></ul><p><br></p><p><strong>Don’t miss out on this fantastic opportunity to connect, compete, and code with the best!</strong></p><p><br></p><p><strong>Register for the contest now and let your coding journey begin!</strong></p><p><a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb17/information" rel="noopener noreferrer" target="_blank">Link to register</a></p><p><br></p><p><br></p>',
     '<p><strong>🎉 Juicy Prizes Await You! 🎉</strong></p><p><br></p><p>Get ready to win some amazing rewards in the 1st CodeDynamite Weekly Contest! Here are the fantastic prizes up for grabs:</p><p><br></p><p><strong>1st Place:</strong></p><ul><li><strong>$500 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite T-Shirt</strong></li><li><strong>Personalized Winner''s Certificate</strong></li></ul><p><br></p><p><strong>2nd Place:</strong></p><ul><li><strong>$250 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Hoodie</strong></li><li><strong>Personalized Runner-Up Certificate</strong></li></ul><p><br></p><p><strong>3rd Place:</strong></p><ul><li><strong>$100 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Mug</strong></li><li><strong>Personalized Certificate of Achievement</strong></li></ul><p><br></p><p>Don''t miss your chance to win these incredible prizes and gain recognition in the coding community. <a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb16/information" rel="noopener noreferrer" target="_blank"><strong>Register now</strong></a> and let the competition begin!</p>',
     '<ol><li>Participants must submit their solutions before the end time.</li><li>Participants must follow the contest rules and guidelines.</li><li>Participants must not cheat or plagiarize.</li></ol>',
     '<p><strong>Pre-determined Challenge Scores:</strong></p><p>Each challenge you conquer has a pre-set score waiting to be claimed. The more complex the challenge, the higher the score you can rack up!</p><p><br></p><p><strong>Test Cases: Your Gateway to Glory:</strong></p><p>Each challenge comes with a battery of test cases designed to put your code through its paces. Every test case you conquer translates into points towards your final score. The more test cases you dominate, the closer you get to scoring supremacy!</p><p><br></p><p><strong>Multiple Submissions? No Problem!</strong></p><p>Feeling creative and tinkering with different solutions? No sweat! We take your highest scoring submission for each challenge into account, so fire away with your best attempts.</p><p><br></p><p><strong>The Leaderboard Beckons: It''s All About the Rank</strong></p><p>Participants are ranked on the glorious leaderboard based on their total score. But what happens when coders achieve the same score? Buckle up, because things get exciting!</p><p><br></p><p><strong>Tie-Breaker Time: Speed Demons Unite!</strong></p><p>In the thrilling case of a tie, the tie-breaker comes down to <strong>speed</strong>. The participant who submitted their highest-scoring solution in the <strong>shortest amount of time</strong> reigns supreme! So, channel your inner coding ninja and blaze through those challenges for ultimate glory.</p>',
     'https://assets.leetcode.com/contest/weekly-contest-291/card_img_1654267951.png',
     '2024-07-15 09:30:00.000000+07',
     '2024-07-15 10:30:00.000000+07',
     'b029f559-52a8-4699-b595-71161498ed8c',
     'b029f559-52a8-4699-b595-71161498ed8c',
     true,
     null,
     true
    ),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb18', 'Weekly Contest 04',
     '<h3>Welcome to the 4th CodeDynamite Weekly Contest</h3><p><br></p><p>We are thrilled to present the inaugural CodeDynamite Weekly Contest, a premier event designed to challenge your coding skills and ignite your passion for programming. Whether you''re a seasoned developer or a coding enthusiast, this contest offers a unique opportunity to showcase your talents, compete with like-minded individuals, and win exciting prizes.</p><p><br></p><p><strong>About the contest:</strong></p><ul><li><strong>Sponsored by:</strong> CodeDynamite, your go-to platform for cutting-edge coding resources and community support.</li><li><strong>When:</strong> Every week, with fresh and exciting challenges that cater to various skill levels.</li><li><strong>Who Can Participate:</strong> Open to all coding enthusiasts, regardless of experience level.</li></ul><p><br></p><p><strong>Why Join?</strong></p><ul><li><strong>Challenge Yourself:</strong> Tackle a variety of coding problems that will test your creativity and problem-solving abilities.</li><li><strong>Learn and Grow:</strong> Gain new insights and improve your coding skills through hands-on practice and real-time competition.</li><li><strong>Win Prizes:</strong> Stand a chance to win amazing rewards and earn recognition within the coding community.</li></ul><p><br></p><p><strong>How to Register:</strong></p><ul><li>Simply click the registration link below and fill out the required details to secure your spot in the contest.</li><li>Registration is quick, easy, and free!</li></ul><p><br></p><p><strong>Don’t miss out on this fantastic opportunity to connect, compete, and code with the best!</strong></p><p><br></p><p><strong>Register for the contest now and let your coding journey begin!</strong></p><p><a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb18/information" rel="noopener noreferrer" target="_blank">Link to register</a></p><p><br></p><p><br></p>',
     '<p><strong>🎉 Juicy Prizes Await You! 🎉</strong></p><p><br></p><p>Get ready to win some amazing rewards in the 1st CodeDynamite Weekly Contest! Here are the fantastic prizes up for grabs:</p><p><br></p><p><strong>1st Place:</strong></p><ul><li><strong>$500 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite T-Shirt</strong></li><li><strong>Personalized Winner''s Certificate</strong></li></ul><p><br></p><p><strong>2nd Place:</strong></p><ul><li><strong>$250 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Hoodie</strong></li><li><strong>Personalized Runner-Up Certificate</strong></li></ul><p><br></p><p><strong>3rd Place:</strong></p><ul><li><strong>$100 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Mug</strong></li><li><strong>Personalized Certificate of Achievement</strong></li></ul><p><br></p><p>Don''t miss your chance to win these incredible prizes and gain recognition in the coding community. <a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb16/information" rel="noopener noreferrer" target="_blank"><strong>Register now</strong></a> and let the competition begin!</p>',
     '<ol><li>Participants must submit their solutions before the end time.</li><li>Participants must follow the contest rules and guidelines.</li><li>Participants must not cheat or plagiarize.</li></ol>',
     '<p><strong>Pre-determined Challenge Scores:</strong></p><p>Each challenge you conquer has a pre-set score waiting to be claimed. The more complex the challenge, the higher the score you can rack up!</p><p><br></p><p><strong>Test Cases: Your Gateway to Glory:</strong></p><p>Each challenge comes with a battery of test cases designed to put your code through its paces. Every test case you conquer translates into points towards your final score. The more test cases you dominate, the closer you get to scoring supremacy!</p><p><br></p><p><strong>Multiple Submissions? No Problem!</strong></p><p>Feeling creative and tinkering with different solutions? No sweat! We take your highest scoring submission for each challenge into account, so fire away with your best attempts.</p><p><br></p><p><strong>The Leaderboard Beckons: It''s All About the Rank</strong></p><p>Participants are ranked on the glorious leaderboard based on their total score. But what happens when coders achieve the same score? Buckle up, because things get exciting!</p><p><br></p><p><strong>Tie-Breaker Time: Speed Demons Unite!</strong></p><p>In the thrilling case of a tie, the tie-breaker comes down to <strong>speed</strong>. The participant who submitted their highest-scoring solution in the <strong>shortest amount of time</strong> reigns supreme! So, channel your inner coding ninja and blaze through those challenges for ultimate glory.</p>',
     'https://assets.leetcode.com/contest/weekly-contest-291/card_img_1654267951.png',
     '2024-07-22 09:30:00.000000+07',
     '2024-07-22 10:30:00.000000+07',
     'b029f559-52a8-4699-b595-71161498ed8c',
     'b029f559-52a8-4699-b595-71161498ed8c',
     true,
     null,
     true
    ),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb19', 'Weekly Contest 05',
     '<h3>Welcome to the 5th CodeDynamite Weekly Contest</h3><p><br></p><p>We are thrilled to present the inaugural CodeDynamite Weekly Contest, a premier event designed to challenge your coding skills and ignite your passion for programming. Whether you''re a seasoned developer or a coding enthusiast, this contest offers a unique opportunity to showcase your talents, compete with like-minded individuals, and win exciting prizes.</p><p><br></p><p><strong>About the contest:</strong></p><ul><li><strong>Sponsored by:</strong> CodeDynamite, your go-to platform for cutting-edge coding resources and community support.</li><li><strong>When:</strong> Every week, with fresh and exciting challenges that cater to various skill levels.</li><li><strong>Who Can Participate:</strong> Open to all coding enthusiasts, regardless of experience level.</li></ul><p><br></p><p><strong>Why Join?</strong></p><ul><li><strong>Challenge Yourself:</strong> Tackle a variety of coding problems that will test your creativity and problem-solving abilities.</li><li><strong>Learn and Grow:</strong> Gain new insights and improve your coding skills through hands-on practice and real-time competition.</li><li><strong>Win Prizes:</strong> Stand a chance to win amazing rewards and earn recognition within the coding community.</li></ul><p><br></p><p><strong>How to Register:</strong></p><ul><li>Simply click the registration link below and fill out the required details to secure your spot in the contest.</li><li>Registration is quick, easy, and free!</li></ul><p><br></p><p><strong>Don’t miss out on this fantastic opportunity to connect, compete, and code with the best!</strong></p><p><br></p><p><strong>Register for the contest now and let your coding journey begin!</strong></p><p><a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb19/information" rel="noopener noreferrer" target="_blank">Link to register</a></p><p><br></p><p><br></p>',
     '<p><strong>🎉 Juicy Prizes Await You! 🎉</strong></p><p><br></p><p>Get ready to win some amazing rewards in the 1st CodeDynamite Weekly Contest! Here are the fantastic prizes up for grabs:</p><p><br></p><p><strong>1st Place:</strong></p><ul><li><strong>$500 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite T-Shirt</strong></li><li><strong>Personalized Winner''s Certificate</strong></li></ul><p><br></p><p><strong>2nd Place:</strong></p><ul><li><strong>$250 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Hoodie</strong></li><li><strong>Personalized Runner-Up Certificate</strong></li></ul><p><br></p><p><strong>3rd Place:</strong></p><ul><li><strong>$100 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Mug</strong></li><li><strong>Personalized Certificate of Achievement</strong></li></ul><p><br></p><p>Don''t miss your chance to win these incredible prizes and gain recognition in the coding community. <a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb16/information" rel="noopener noreferrer" target="_blank"><strong>Register now</strong></a> and let the competition begin!</p>',
     '<ol><li>Participants must submit their solutions before the end time.</li><li>Participants must follow the contest rules and guidelines.</li><li>Participants must not cheat or plagiarize.</li></ol>',
     '<p><strong>Pre-determined Challenge Scores:</strong></p><p>Each challenge you conquer has a pre-set score waiting to be claimed. The more complex the challenge, the higher the score you can rack up!</p><p><br></p><p><strong>Test Cases: Your Gateway to Glory:</strong></p><p>Each challenge comes with a battery of test cases designed to put your code through its paces. Every test case you conquer translates into points towards your final score. The more test cases you dominate, the closer you get to scoring supremacy!</p><p><br></p><p><strong>Multiple Submissions? No Problem!</strong></p><p>Feeling creative and tinkering with different solutions? No sweat! We take your highest scoring submission for each challenge into account, so fire away with your best attempts.</p><p><br></p><p><strong>The Leaderboard Beckons: It''s All About the Rank</strong></p><p>Participants are ranked on the glorious leaderboard based on their total score. But what happens when coders achieve the same score? Buckle up, because things get exciting!</p><p><br></p><p><strong>Tie-Breaker Time: Speed Demons Unite!</strong></p><p>In the thrilling case of a tie, the tie-breaker comes down to <strong>speed</strong>. The participant who submitted their highest-scoring solution in the <strong>shortest amount of time</strong> reigns supreme! So, channel your inner coding ninja and blaze through those challenges for ultimate glory.</p>',
     'https://leetcode.com/_next/static/images/weekly-default-553ede7bcc8e1b4a44c28a9e4a32068c.png',
     '2024-07-29 09:30:00.000000+07',
     '2024-07-29 10:30:00.000000+07',
     'b029f559-52a8-4699-b595-71161498ed8c',
     'b029f559-52a8-4699-b595-71161498ed8c',
     true,
     null,
     true
    ),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb20',  'Weekly Contest 06',
     '<h3>Welcome to the 6th CodeDynamite Weekly Contest</h3><p><br></p><p>We are thrilled to present the inaugural CodeDynamite Weekly Contest, a premier event designed to challenge your coding skills and ignite your passion for programming. Whether you''re a seasoned developer or a coding enthusiast, this contest offers a unique opportunity to showcase your talents, compete with like-minded individuals, and win exciting prizes.</p><p><br></p><p><strong>About the contest:</strong></p><ul><li><strong>Sponsored by:</strong> CodeDynamite, your go-to platform for cutting-edge coding resources and community support.</li><li><strong>When:</strong> Every week, with fresh and exciting challenges that cater to various skill levels.</li><li><strong>Who Can Participate:</strong> Open to all coding enthusiasts, regardless of experience level.</li></ul><p><br></p><p><strong>Why Join?</strong></p><ul><li><strong>Challenge Yourself:</strong> Tackle a variety of coding problems that will test your creativity and problem-solving abilities.</li><li><strong>Learn and Grow:</strong> Gain new insights and improve your coding skills through hands-on practice and real-time competition.</li><li><strong>Win Prizes:</strong> Stand a chance to win amazing rewards and earn recognition within the coding community.</li></ul><p><br></p><p><strong>How to Register:</strong></p><ul><li>Simply click the registration link below and fill out the required details to secure your spot in the contest.</li><li>Registration is quick, easy, and free!</li></ul><p><br></p><p><strong>Don’t miss out on this fantastic opportunity to connect, compete, and code with the best!</strong></p><p><br></p><p><strong>Register for the contest now and let your coding journey begin!</strong></p><p><a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb20/information" rel="noopener noreferrer" target="_blank">Link to register</a></p><p><br></p><p><br></p>',
     '<p><strong>🎉 Juicy Prizes Await You! 🎉</strong></p><p><br></p><p>Get ready to win some amazing rewards in the 1st CodeDynamite Weekly Contest! Here are the fantastic prizes up for grabs:</p><p><br></p><p><strong>1st Place:</strong></p><ul><li><strong>$500 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite T-Shirt</strong></li><li><strong>Personalized Winner''s Certificate</strong></li></ul><p><br></p><p><strong>2nd Place:</strong></p><ul><li><strong>$250 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Hoodie</strong></li><li><strong>Personalized Runner-Up Certificate</strong></li></ul><p><br></p><p><strong>3rd Place:</strong></p><ul><li><strong>$100 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Mug</strong></li><li><strong>Personalized Certificate of Achievement</strong></li></ul><p><br></p><p>Don''t miss your chance to win these incredible prizes and gain recognition in the coding community. <a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb16/information" rel="noopener noreferrer" target="_blank"><strong>Register now</strong></a> and let the competition begin!</p>',
     '<ol><li>Participants must submit their solutions before the end time.</li><li>Participants must follow the contest rules and guidelines.</li><li>Participants must not cheat or plagiarize.</li></ol>',
     '<p><strong>Pre-determined Challenge Scores:</strong></p><p>Each challenge you conquer has a pre-set score waiting to be claimed. The more complex the challenge, the higher the score you can rack up!</p><p><br></p><p><strong>Test Cases: Your Gateway to Glory:</strong></p><p>Each challenge comes with a battery of test cases designed to put your code through its paces. Every test case you conquer translates into points towards your final score. The more test cases you dominate, the closer you get to scoring supremacy!</p><p><br></p><p><strong>Multiple Submissions? No Problem!</strong></p><p>Feeling creative and tinkering with different solutions? No sweat! We take your highest scoring submission for each challenge into account, so fire away with your best attempts.</p><p><br></p><p><strong>The Leaderboard Beckons: It''s All About the Rank</strong></p><p>Participants are ranked on the glorious leaderboard based on their total score. But what happens when coders achieve the same score? Buckle up, because things get exciting!</p><p><br></p><p><strong>Tie-Breaker Time: Speed Demons Unite!</strong></p><p>In the thrilling case of a tie, the tie-breaker comes down to <strong>speed</strong>. The participant who submitted their highest-scoring solution in the <strong>shortest amount of time</strong> reigns supreme! So, channel your inner coding ninja and blaze through those challenges for ultimate glory.</p>',
     'https://leetcode.com/_next/static/images/biweekly-default-f5a8fc3be85b6c9175207fd8fd855d47.png',
     '2024-08-05 09:30:00.000000+07',
     '2024-08-05 10:30:00.000000+07',
     'b029f559-52a8-4699-b595-71161498ed8c',
     'b029f559-52a8-4699-b595-71161498ed8c',
     true,
     null,
     true
     ),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb21', 'Weekly Contest 07',
     '<h3>Welcome to the 7th CodeDynamite Weekly Contest</h3><p><br></p><p>We are thrilled to present the inaugural CodeDynamite Weekly Contest, a premier event designed to challenge your coding skills and ignite your passion for programming. Whether you''re a seasoned developer or a coding enthusiast, this contest offers a unique opportunity to showcase your talents, compete with like-minded individuals, and win exciting prizes.</p><p><br></p><p><strong>About the contest:</strong></p><ul><li><strong>Sponsored by:</strong> CodeDynamite, your go-to platform for cutting-edge coding resources and community support.</li><li><strong>When:</strong> Every week, with fresh and exciting challenges that cater to various skill levels.</li><li><strong>Who Can Participate:</strong> Open to all coding enthusiasts, regardless of experience level.</li></ul><p><br></p><p><strong>Why Join?</strong></p><ul><li><strong>Challenge Yourself:</strong> Tackle a variety of coding problems that will test your creativity and problem-solving abilities.</li><li><strong>Learn and Grow:</strong> Gain new insights and improve your coding skills through hands-on practice and real-time competition.</li><li><strong>Win Prizes:</strong> Stand a chance to win amazing rewards and earn recognition within the coding community.</li></ul><p><br></p><p><strong>How to Register:</strong></p><ul><li>Simply click the registration link below and fill out the required details to secure your spot in the contest.</li><li>Registration is quick, easy, and free!</li></ul><p><br></p><p><strong>Don’t miss out on this fantastic opportunity to connect, compete, and code with the best!</strong></p><p><br></p><p><strong>Register for the contest now and let your coding journey begin!</strong></p><p><a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb21/information" rel="noopener noreferrer" target="_blank">Link to register</a></p><p><br></p><p><br></p>',
     '<p><strong>🎉 Juicy Prizes Await You! 🎉</strong></p><p><br></p><p>Get ready to win some amazing rewards in the 1st CodeDynamite Weekly Contest! Here are the fantastic prizes up for grabs:</p><p><br></p><p><strong>1st Place:</strong></p><ul><li><strong>$500 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite T-Shirt</strong></li><li><strong>Personalized Winner''s Certificate</strong></li></ul><p><br></p><p><strong>2nd Place:</strong></p><ul><li><strong>$250 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Hoodie</strong></li><li><strong>Personalized Runner-Up Certificate</strong></li></ul><p><br></p><p><strong>3rd Place:</strong></p><ul><li><strong>$100 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Mug</strong></li><li><strong>Personalized Certificate of Achievement</strong></li></ul><p><br></p><p>Don''t miss your chance to win these incredible prizes and gain recognition in the coding community. <a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb16/information" rel="noopener noreferrer" target="_blank"><strong>Register now</strong></a> and let the competition begin!</p>',
     '<ol><li>Participants must submit their solutions before the end time.</li><li>Participants must follow the contest rules and guidelines.</li><li>Participants must not cheat or plagiarize.</li></ol>',
     '<p><strong>Pre-determined Challenge Scores:</strong></p><p>Each challenge you conquer has a pre-set score waiting to be claimed. The more complex the challenge, the higher the score you can rack up!</p><p><br></p><p><strong>Test Cases: Your Gateway to Glory:</strong></p><p>Each challenge comes with a battery of test cases designed to put your code through its paces. Every test case you conquer translates into points towards your final score. The more test cases you dominate, the closer you get to scoring supremacy!</p><p><br></p><p><strong>Multiple Submissions? No Problem!</strong></p><p>Feeling creative and tinkering with different solutions? No sweat! We take your highest scoring submission for each challenge into account, so fire away with your best attempts.</p><p><br></p><p><strong>The Leaderboard Beckons: It''s All About the Rank</strong></p><p>Participants are ranked on the glorious leaderboard based on their total score. But what happens when coders achieve the same score? Buckle up, because things get exciting!</p><p><br></p><p><strong>Tie-Breaker Time: Speed Demons Unite!</strong></p><p>In the thrilling case of a tie, the tie-breaker comes down to <strong>speed</strong>. The participant who submitted their highest-scoring solution in the <strong>shortest amount of time</strong> reigns supreme! So, channel your inner coding ninja and blaze through those challenges for ultimate glory.</p>',
     'https://assets.leetcode.com/contest/weekly-contest-291/card_img_1654267951.png',
     '2024-08-12 09:30:00.000000+07',
     '2024-08-12 10:30:00.000000+07',
     'b029f559-52a8-4699-b595-71161498ed8c',
     'b029f559-52a8-4699-b595-71161498ed8c',
     true,
     null,
     true
    ),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb22', 'Weekly Contest 08',
     '<h3>Welcome to the 8th CodeDynamite Weekly Contest</h3><p><br></p><p>We are thrilled to present the inaugural CodeDynamite Weekly Contest, a premier event designed to challenge your coding skills and ignite your passion for programming. Whether you''re a seasoned developer or a coding enthusiast, this contest offers a unique opportunity to showcase your talents, compete with like-minded individuals, and win exciting prizes.</p><p><br></p><p><strong>About the contest:</strong></p><ul><li><strong>Sponsored by:</strong> CodeDynamite, your go-to platform for cutting-edge coding resources and community support.</li><li><strong>When:</strong> Every week, with fresh and exciting challenges that cater to various skill levels.</li><li><strong>Who Can Participate:</strong> Open to all coding enthusiasts, regardless of experience level.</li></ul><p><br></p><p><strong>Why Join?</strong></p><ul><li><strong>Challenge Yourself:</strong> Tackle a variety of coding problems that will test your creativity and problem-solving abilities.</li><li><strong>Learn and Grow:</strong> Gain new insights and improve your coding skills through hands-on practice and real-time competition.</li><li><strong>Win Prizes:</strong> Stand a chance to win amazing rewards and earn recognition within the coding community.</li></ul><p><br></p><p><strong>How to Register:</strong></p><ul><li>Simply click the registration link below and fill out the required details to secure your spot in the contest.</li><li>Registration is quick, easy, and free!</li></ul><p><br></p><p><strong>Don’t miss out on this fantastic opportunity to connect, compete, and code with the best!</strong></p><p><br></p><p><strong>Register for the contest now and let your coding journey begin!</strong></p><p><a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb22/information" rel="noopener noreferrer" target="_blank">Link to register</a></p><p><br></p><p><br></p>',
     '<p><strong>🎉 Juicy Prizes Await You! 🎉</strong></p><p><br></p><p>Get ready to win some amazing rewards in the 1st CodeDynamite Weekly Contest! Here are the fantastic prizes up for grabs:</p><p><br></p><p><strong>1st Place:</strong></p><ul><li><strong>$500 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite T-Shirt</strong></li><li><strong>Personalized Winner''s Certificate</strong></li></ul><p><br></p><p><strong>2nd Place:</strong></p><ul><li><strong>$250 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Hoodie</strong></li><li><strong>Personalized Runner-Up Certificate</strong></li></ul><p><br></p><p><strong>3rd Place:</strong></p><ul><li><strong>$100 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Mug</strong></li><li><strong>Personalized Certificate of Achievement</strong></li></ul><p><br></p><p>Don''t miss your chance to win these incredible prizes and gain recognition in the coding community. <a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb16/information" rel="noopener noreferrer" target="_blank"><strong>Register now</strong></a> and let the competition begin!</p>',
     '<ol><li>Participants must submit their solutions before the end time.</li><li>Participants must follow the contest rules and guidelines.</li><li>Participants must not cheat or plagiarize.</li></ol>',
     '<p><strong>Pre-determined Challenge Scores:</strong></p><p>Each challenge you conquer has a pre-set score waiting to be claimed. The more complex the challenge, the higher the score you can rack up!</p><p><br></p><p><strong>Test Cases: Your Gateway to Glory:</strong></p><p>Each challenge comes with a battery of test cases designed to put your code through its paces. Every test case you conquer translates into points towards your final score. The more test cases you dominate, the closer you get to scoring supremacy!</p><p><br></p><p><strong>Multiple Submissions? No Problem!</strong></p><p>Feeling creative and tinkering with different solutions? No sweat! We take your highest scoring submission for each challenge into account, so fire away with your best attempts.</p><p><br></p><p><strong>The Leaderboard Beckons: It''s All About the Rank</strong></p><p>Participants are ranked on the glorious leaderboard based on their total score. But what happens when coders achieve the same score? Buckle up, because things get exciting!</p><p><br></p><p><strong>Tie-Breaker Time: Speed Demons Unite!</strong></p><p>In the thrilling case of a tie, the tie-breaker comes down to <strong>speed</strong>. The participant who submitted their highest-scoring solution in the <strong>shortest amount of time</strong> reigns supreme! So, channel your inner coding ninja and blaze through those challenges for ultimate glory.</p>',
     'https://assets.leetcode.com/contest/weekly-contest-291/card_img_1654267951.png',
     '2024-08-19 09:30:00.000000+07',
     '2024-08-19 10:30:00.000000+07',
     'b029f559-52a8-4699-b595-71161498ed8c',
     'b029f559-52a8-4699-b595-71161498ed8c',
     false,
     null,
     true
    ),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb23', 'Weekly Contest 09',
     '<h3>Welcome to the 9th CodeDynamite Weekly Contest</h3><p><br></p><p>We are thrilled to present the inaugural CodeDynamite Weekly Contest, a premier event designed to challenge your coding skills and ignite your passion for programming. Whether you''re a seasoned developer or a coding enthusiast, this contest offers a unique opportunity to showcase your talents, compete with like-minded individuals, and win exciting prizes.</p><p><br></p><p><strong>About the contest:</strong></p><ul><li><strong>Sponsored by:</strong> CodeDynamite, your go-to platform for cutting-edge coding resources and community support.</li><li><strong>When:</strong> Every week, with fresh and exciting challenges that cater to various skill levels.</li><li><strong>Who Can Participate:</strong> Open to all coding enthusiasts, regardless of experience level.</li></ul><p><br></p><p><strong>Why Join?</strong></p><ul><li><strong>Challenge Yourself:</strong> Tackle a variety of coding problems that will test your creativity and problem-solving abilities.</li><li><strong>Learn and Grow:</strong> Gain new insights and improve your coding skills through hands-on practice and real-time competition.</li><li><strong>Win Prizes:</strong> Stand a chance to win amazing rewards and earn recognition within the coding community.</li></ul><p><br></p><p><strong>How to Register:</strong></p><ul><li>Simply click the registration link below and fill out the required details to secure your spot in the contest.</li><li>Registration is quick, easy, and free!</li></ul><p><br></p><p><strong>Don’t miss out on this fantastic opportunity to connect, compete, and code with the best!</strong></p><p><br></p><p><strong>Register for the contest now and let your coding journey begin!</strong></p><p><a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb23/information" rel="noopener noreferrer" target="_blank">Link to register</a></p><p><br></p><p><br></p>',
     '<p><strong>🎉 Juicy Prizes Await You! 🎉</strong></p><p><br></p><p>Get ready to win some amazing rewards in the 1st CodeDynamite Weekly Contest! Here are the fantastic prizes up for grabs:</p><p><br></p><p><strong>1st Place:</strong></p><ul><li><strong>$500 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite T-Shirt</strong></li><li><strong>Personalized Winner''s Certificate</strong></li></ul><p><br></p><p><strong>2nd Place:</strong></p><ul><li><strong>$250 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Hoodie</strong></li><li><strong>Personalized Runner-Up Certificate</strong></li></ul><p><br></p><p><strong>3rd Place:</strong></p><ul><li><strong>$100 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Mug</strong></li><li><strong>Personalized Certificate of Achievement</strong></li></ul><p><br></p><p>Don''t miss your chance to win these incredible prizes and gain recognition in the coding community. <a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb16/information" rel="noopener noreferrer" target="_blank"><strong>Register now</strong></a> and let the competition begin!</p>',
     '<ol><li>Participants must submit their solutions before the end time.</li><li>Participants must follow the contest rules and guidelines.</li><li>Participants must not cheat or plagiarize.</li></ol>',
     '<p><strong>Pre-determined Challenge Scores:</strong></p><p>Each challenge you conquer has a pre-set score waiting to be claimed. The more complex the challenge, the higher the score you can rack up!</p><p><br></p><p><strong>Test Cases: Your Gateway to Glory:</strong></p><p>Each challenge comes with a battery of test cases designed to put your code through its paces. Every test case you conquer translates into points towards your final score. The more test cases you dominate, the closer you get to scoring supremacy!</p><p><br></p><p><strong>Multiple Submissions? No Problem!</strong></p><p>Feeling creative and tinkering with different solutions? No sweat! We take your highest scoring submission for each challenge into account, so fire away with your best attempts.</p><p><br></p><p><strong>The Leaderboard Beckons: It''s All About the Rank</strong></p><p>Participants are ranked on the glorious leaderboard based on their total score. But what happens when coders achieve the same score? Buckle up, because things get exciting!</p><p><br></p><p><strong>Tie-Breaker Time: Speed Demons Unite!</strong></p><p>In the thrilling case of a tie, the tie-breaker comes down to <strong>speed</strong>. The participant who submitted their highest-scoring solution in the <strong>shortest amount of time</strong> reigns supreme! So, channel your inner coding ninja and blaze through those challenges for ultimate glory.</p>',
     'https://leetcode.com/_next/static/images/weekly-default-553ede7bcc8e1b4a44c28a9e4a32068c.png',
     '2024-08-26 09:30:00.000000+07',
     '2024-08-26 10:30:00.000000+07',
     'b029f559-52a8-4699-b595-71161498ed8c',
     'b029f559-52a8-4699-b595-71161498ed8c',
     false,
     null,
     true
    ),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb24', 'Weekly Contest 10',
     '<h3>Welcome to the 10th CodeDynamite Weekly Contest</h3><p><br></p><p>We are thrilled to present the inaugural CodeDynamite Weekly Contest, a premier event designed to challenge your coding skills and ignite your passion for programming. Whether you''re a seasoned developer or a coding enthusiast, this contest offers a unique opportunity to showcase your talents, compete with like-minded individuals, and win exciting prizes.</p><p><br></p><p><strong>About the contest:</strong></p><ul><li><strong>Sponsored by:</strong> CodeDynamite, your go-to platform for cutting-edge coding resources and community support.</li><li><strong>When:</strong> Every week, with fresh and exciting challenges that cater to various skill levels.</li><li><strong>Who Can Participate:</strong> Open to all coding enthusiasts, regardless of experience level.</li></ul><p><br></p><p><strong>Why Join?</strong></p><ul><li><strong>Challenge Yourself:</strong> Tackle a variety of coding problems that will test your creativity and problem-solving abilities.</li><li><strong>Learn and Grow:</strong> Gain new insights and improve your coding skills through hands-on practice and real-time competition.</li><li><strong>Win Prizes:</strong> Stand a chance to win amazing rewards and earn recognition within the coding community.</li></ul><p><br></p><p><strong>How to Register:</strong></p><ul><li>Simply click the registration link below and fill out the required details to secure your spot in the contest.</li><li>Registration is quick, easy, and free!</li></ul><p><br></p><p><strong>Don’t miss out on this fantastic opportunity to connect, compete, and code with the best!</strong></p><p><br></p><p><strong>Register for the contest now and let your coding journey begin!</strong></p><p><a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb24/information" rel="noopener noreferrer" target="_blank">Link to register</a></p><p><br></p><p><br></p>',
     '<p><strong>🎉 Juicy Prizes Await You! 🎉</strong></p><p><br></p><p>Get ready to win some amazing rewards in the 1st CodeDynamite Weekly Contest! Here are the fantastic prizes up for grabs:</p><p><br></p><p><strong>1st Place:</strong></p><ul><li><strong>$500 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite T-Shirt</strong></li><li><strong>Personalized Winner''s Certificate</strong></li></ul><p><br></p><p><strong>2nd Place:</strong></p><ul><li><strong>$250 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Hoodie</strong></li><li><strong>Personalized Runner-Up Certificate</strong></li></ul><p><br></p><p><strong>3rd Place:</strong></p><ul><li><strong>$100 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Mug</strong></li><li><strong>Personalized Certificate of Achievement</strong></li></ul><p><br></p><p>Don''t miss your chance to win these incredible prizes and gain recognition in the coding community. <a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb16/information" rel="noopener noreferrer" target="_blank"><strong>Register now</strong></a> and let the competition begin!</p>',
     '<ol><li>Participants must submit their solutions before the end time.</li><li>Participants must follow the contest rules and guidelines.</li><li>Participants must not cheat or plagiarize.</li></ol>',
     '<p><strong>Pre-determined Challenge Scores:</strong></p><p>Each challenge you conquer has a pre-set score waiting to be claimed. The more complex the challenge, the higher the score you can rack up!</p><p><br></p><p><strong>Test Cases: Your Gateway to Glory:</strong></p><p>Each challenge comes with a battery of test cases designed to put your code through its paces. Every test case you conquer translates into points towards your final score. The more test cases you dominate, the closer you get to scoring supremacy!</p><p><br></p><p><strong>Multiple Submissions? No Problem!</strong></p><p>Feeling creative and tinkering with different solutions? No sweat! We take your highest scoring submission for each challenge into account, so fire away with your best attempts.</p><p><br></p><p><strong>The Leaderboard Beckons: It''s All About the Rank</strong></p><p>Participants are ranked on the glorious leaderboard based on their total score. But what happens when coders achieve the same score? Buckle up, because things get exciting!</p><p><br></p><p><strong>Tie-Breaker Time: Speed Demons Unite!</strong></p><p>In the thrilling case of a tie, the tie-breaker comes down to <strong>speed</strong>. The participant who submitted their highest-scoring solution in the <strong>shortest amount of time</strong> reigns supreme! So, channel your inner coding ninja and blaze through those challenges for ultimate glory.</p>',
     'https://leetcode.com/_next/static/images/biweekly-default-f5a8fc3be85b6c9175207fd8fd855d47.png',
     '2024-09-02 09:30:00.000000+07',
     '2024-09-02 10:30:00.000000+07',
     'b029f559-52a8-4699-b595-71161498ed8c',
     'b029f559-52a8-4699-b595-71161498ed8c',
     false,
     null,
     true
    ),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb25', 'Weekly Contest 11',
     '<h3>Welcome to the 11th CodeDynamite Weekly Contest</h3><p><br></p><p>We are thrilled to present the inaugural CodeDynamite Weekly Contest, a premier event designed to challenge your coding skills and ignite your passion for programming. Whether you''re a seasoned developer or a coding enthusiast, this contest offers a unique opportunity to showcase your talents, compete with like-minded individuals, and win exciting prizes.</p><p><br></p><p><strong>About the contest:</strong></p><ul><li><strong>Sponsored by:</strong> CodeDynamite, your go-to platform for cutting-edge coding resources and community support.</li><li><strong>When:</strong> Every week, with fresh and exciting challenges that cater to various skill levels.</li><li><strong>Who Can Participate:</strong> Open to all coding enthusiasts, regardless of experience level.</li></ul><p><br></p><p><strong>Why Join?</strong></p><ul><li><strong>Challenge Yourself:</strong> Tackle a variety of coding problems that will test your creativity and problem-solving abilities.</li><li><strong>Learn and Grow:</strong> Gain new insights and improve your coding skills through hands-on practice and real-time competition.</li><li><strong>Win Prizes:</strong> Stand a chance to win amazing rewards and earn recognition within the coding community.</li></ul><p><br></p><p><strong>How to Register:</strong></p><ul><li>Simply click the registration link below and fill out the required details to secure your spot in the contest.</li><li>Registration is quick, easy, and free!</li></ul><p><br></p><p><strong>Don’t miss out on this fantastic opportunity to connect, compete, and code with the best!</strong></p><p><br></p><p><strong>Register for the contest now and let your coding journey begin!</strong></p><p><a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb25/information" rel="noopener noreferrer" target="_blank">Link to register</a></p><p><br></p><p><br></p>',
     '<p><strong>🎉 Juicy Prizes Await You! 🎉</strong></p><p><br></p><p>Get ready to win some amazing rewards in the 1st CodeDynamite Weekly Contest! Here are the fantastic prizes up for grabs:</p><p><br></p><p><strong>1st Place:</strong></p><ul><li><strong>$500 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite T-Shirt</strong></li><li><strong>Personalized Winner''s Certificate</strong></li></ul><p><br></p><p><strong>2nd Place:</strong></p><ul><li><strong>$250 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Hoodie</strong></li><li><strong>Personalized Runner-Up Certificate</strong></li></ul><p><br></p><p><strong>3rd Place:</strong></p><ul><li><strong>$100 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Mug</strong></li><li><strong>Personalized Certificate of Achievement</strong></li></ul><p><br></p><p>Don''t miss your chance to win these incredible prizes and gain recognition in the coding community. <a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb16/information" rel="noopener noreferrer" target="_blank"><strong>Register now</strong></a> and let the competition begin!</p>',
     '<ol><li>Participants must submit their solutions before the end time.</li><li>Participants must follow the contest rules and guidelines.</li><li>Participants must not cheat or plagiarize.</li></ol>',
     '<p><strong>Pre-determined Challenge Scores:</strong></p><p>Each challenge you conquer has a pre-set score waiting to be claimed. The more complex the challenge, the higher the score you can rack up!</p><p><br></p><p><strong>Test Cases: Your Gateway to Glory:</strong></p><p>Each challenge comes with a battery of test cases designed to put your code through its paces. Every test case you conquer translates into points towards your final score. The more test cases you dominate, the closer you get to scoring supremacy!</p><p><br></p><p><strong>Multiple Submissions? No Problem!</strong></p><p>Feeling creative and tinkering with different solutions? No sweat! We take your highest scoring submission for each challenge into account, so fire away with your best attempts.</p><p><br></p><p><strong>The Leaderboard Beckons: It''s All About the Rank</strong></p><p>Participants are ranked on the glorious leaderboard based on their total score. But what happens when coders achieve the same score? Buckle up, because things get exciting!</p><p><br></p><p><strong>Tie-Breaker Time: Speed Demons Unite!</strong></p><p>In the thrilling case of a tie, the tie-breaker comes down to <strong>speed</strong>. The participant who submitted their highest-scoring solution in the <strong>shortest amount of time</strong> reigns supreme! So, channel your inner coding ninja and blaze through those challenges for ultimate glory.</p>',
     'https://assets.leetcode.com/contest/weekly-contest-291/card_img_1654267951.png',
     '2024-09-09 09:30:00.000000+07',
     '2024-09-09 10:30:00.000000+07',
     'b029f559-52a8-4699-b595-71161498ed8c',
     'b029f559-52a8-4699-b595-71161498ed8c',
     false,
     null,
     true
    ),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb26', 'Weekly Contest 12',
     '<h3>Welcome to the 12th CodeDynamite Weekly Contest</h3><p><br></p><p>We are thrilled to present the inaugural CodeDynamite Weekly Contest, a premier event designed to challenge your coding skills and ignite your passion for programming. Whether you''re a seasoned developer or a coding enthusiast, this contest offers a unique opportunity to showcase your talents, compete with like-minded individuals, and win exciting prizes.</p><p><br></p><p><strong>About the contest:</strong></p><ul><li><strong>Sponsored by:</strong> CodeDynamite, your go-to platform for cutting-edge coding resources and community support.</li><li><strong>When:</strong> Every week, with fresh and exciting challenges that cater to various skill levels.</li><li><strong>Who Can Participate:</strong> Open to all coding enthusiasts, regardless of experience level.</li></ul><p><br></p><p><strong>Why Join?</strong></p><ul><li><strong>Challenge Yourself:</strong> Tackle a variety of coding problems that will test your creativity and problem-solving abilities.</li><li><strong>Learn and Grow:</strong> Gain new insights and improve your coding skills through hands-on practice and real-time competition.</li><li><strong>Win Prizes:</strong> Stand a chance to win amazing rewards and earn recognition within the coding community.</li></ul><p><br></p><p><strong>How to Register:</strong></p><ul><li>Simply click the registration link below and fill out the required details to secure your spot in the contest.</li><li>Registration is quick, easy, and free!</li></ul><p><br></p><p><strong>Don’t miss out on this fantastic opportunity to connect, compete, and code with the best!</strong></p><p><br></p><p><strong>Register for the contest now and let your coding journey begin!</strong></p><p><a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb26/information" rel="noopener noreferrer" target="_blank">Link to register</a></p><p><br></p><p><br></p>',
     '<p><strong>🎉 Juicy Prizes Await You! 🎉</strong></p><p><br></p><p>Get ready to win some amazing rewards in the 1st CodeDynamite Weekly Contest! Here are the fantastic prizes up for grabs:</p><p><br></p><p><strong>1st Place:</strong></p><ul><li><strong>$500 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite T-Shirt</strong></li><li><strong>Personalized Winner''s Certificate</strong></li></ul><p><br></p><p><strong>2nd Place:</strong></p><ul><li><strong>$250 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Hoodie</strong></li><li><strong>Personalized Runner-Up Certificate</strong></li></ul><p><br></p><p><strong>3rd Place:</strong></p><ul><li><strong>$100 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Mug</strong></li><li><strong>Personalized Certificate of Achievement</strong></li></ul><p><br></p><p>Don''t miss your chance to win these incredible prizes and gain recognition in the coding community. <a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb16/information" rel="noopener noreferrer" target="_blank"><strong>Register now</strong></a> and let the competition begin!</p>',
     '<ol><li>Participants must submit their solutions before the end time.</li><li>Participants must follow the contest rules and guidelines.</li><li>Participants must not cheat or plagiarize.</li></ol>',
     '<p><strong>Pre-determined Challenge Scores:</strong></p><p>Each challenge you conquer has a pre-set score waiting to be claimed. The more complex the challenge, the higher the score you can rack up!</p><p><br></p><p><strong>Test Cases: Your Gateway to Glory:</strong></p><p>Each challenge comes with a battery of test cases designed to put your code through its paces. Every test case you conquer translates into points towards your final score. The more test cases you dominate, the closer you get to scoring supremacy!</p><p><br></p><p><strong>Multiple Submissions? No Problem!</strong></p><p>Feeling creative and tinkering with different solutions? No sweat! We take your highest scoring submission for each challenge into account, so fire away with your best attempts.</p><p><br></p><p><strong>The Leaderboard Beckons: It''s All About the Rank</strong></p><p>Participants are ranked on the glorious leaderboard based on their total score. But what happens when coders achieve the same score? Buckle up, because things get exciting!</p><p><br></p><p><strong>Tie-Breaker Time: Speed Demons Unite!</strong></p><p>In the thrilling case of a tie, the tie-breaker comes down to <strong>speed</strong>. The participant who submitted their highest-scoring solution in the <strong>shortest amount of time</strong> reigns supreme! So, channel your inner coding ninja and blaze through those challenges for ultimate glory.</p>',
     'https://assets.leetcode.com/contest/weekly-contest-291/card_img_1654267951.png',
     '2024-09-16 09:30:00.000000+07',
     '2024-09-16 10:30:00.000000+07',
     'b029f559-52a8-4699-b595-71161498ed8c',
     'b029f559-52a8-4699-b595-71161498ed8c',
     false,
     null,
     true
    ),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb27', 'Weekly Contest 13',
     '<h3>Welcome to the 13th CodeDynamite Weekly Contest</h3><p><br></p><p>We are thrilled to present the inaugural CodeDynamite Weekly Contest, a premier event designed to challenge your coding skills and ignite your passion for programming. Whether you''re a seasoned developer or a coding enthusiast, this contest offers a unique opportunity to showcase your talents, compete with like-minded individuals, and win exciting prizes.</p><p><br></p><p><strong>About the contest:</strong></p><ul><li><strong>Sponsored by:</strong> CodeDynamite, your go-to platform for cutting-edge coding resources and community support.</li><li><strong>When:</strong> Every week, with fresh and exciting challenges that cater to various skill levels.</li><li><strong>Who Can Participate:</strong> Open to all coding enthusiasts, regardless of experience level.</li></ul><p><br></p><p><strong>Why Join?</strong></p><ul><li><strong>Challenge Yourself:</strong> Tackle a variety of coding problems that will test your creativity and problem-solving abilities.</li><li><strong>Learn and Grow:</strong> Gain new insights and improve your coding skills through hands-on practice and real-time competition.</li><li><strong>Win Prizes:</strong> Stand a chance to win amazing rewards and earn recognition within the coding community.</li></ul><p><br></p><p><strong>How to Register:</strong></p><ul><li>Simply click the registration link below and fill out the required details to secure your spot in the contest.</li><li>Registration is quick, easy, and free!</li></ul><p><br></p><p><strong>Don’t miss out on this fantastic opportunity to connect, compete, and code with the best!</strong></p><p><br></p><p><strong>Register for the contest now and let your coding journey begin!</strong></p><p><a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb27/information" rel="noopener noreferrer" target="_blank">Link to register</a></p><p><br></p><p><br></p>',
     '<p><strong>🎉 Juicy Prizes Await You! 🎉</strong></p><p><br></p><p>Get ready to win some amazing rewards in the 1st CodeDynamite Weekly Contest! Here are the fantastic prizes up for grabs:</p><p><br></p><p><strong>1st Place:</strong></p><ul><li><strong>$500 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite T-Shirt</strong></li><li><strong>Personalized Winner''s Certificate</strong></li></ul><p><br></p><p><strong>2nd Place:</strong></p><ul><li><strong>$250 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Hoodie</strong></li><li><strong>Personalized Runner-Up Certificate</strong></li></ul><p><br></p><p><strong>3rd Place:</strong></p><ul><li><strong>$100 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Mug</strong></li><li><strong>Personalized Certificate of Achievement</strong></li></ul><p><br></p><p>Don''t miss your chance to win these incredible prizes and gain recognition in the coding community. <a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb16/information" rel="noopener noreferrer" target="_blank"><strong>Register now</strong></a> and let the competition begin!</p>',
     '<ol><li>Participants must submit their solutions before the end time.</li><li>Participants must follow the contest rules and guidelines.</li><li>Participants must not cheat or plagiarize.</li></ol>',
     '<p><strong>Pre-determined Challenge Scores:</strong></p><p>Each challenge you conquer has a pre-set score waiting to be claimed. The more complex the challenge, the higher the score you can rack up!</p><p><br></p><p><strong>Test Cases: Your Gateway to Glory:</strong></p><p>Each challenge comes with a battery of test cases designed to put your code through its paces. Every test case you conquer translates into points towards your final score. The more test cases you dominate, the closer you get to scoring supremacy!</p><p><br></p><p><strong>Multiple Submissions? No Problem!</strong></p><p>Feeling creative and tinkering with different solutions? No sweat! We take your highest scoring submission for each challenge into account, so fire away with your best attempts.</p><p><br></p><p><strong>The Leaderboard Beckons: It''s All About the Rank</strong></p><p>Participants are ranked on the glorious leaderboard based on their total score. But what happens when coders achieve the same score? Buckle up, because things get exciting!</p><p><br></p><p><strong>Tie-Breaker Time: Speed Demons Unite!</strong></p><p>In the thrilling case of a tie, the tie-breaker comes down to <strong>speed</strong>. The participant who submitted their highest-scoring solution in the <strong>shortest amount of time</strong> reigns supreme! So, channel your inner coding ninja and blaze through those challenges for ultimate glory.</p>',
     'https://leetcode.com/_next/static/images/weekly-default-553ede7bcc8e1b4a44c28a9e4a32068c.png',
     '2024-09-23 09:30:00.000000+07',
     '2024-09-23 10:30:00.000000+07',
     'b029f559-52a8-4699-b595-71161498ed8c',
     'b029f559-52a8-4699-b595-71161498ed8c',
     false,
     null,
     true
    ),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb28',  'Weekly Contest 14',
     '<h3>Welcome to the 14th CodeDynamite Weekly Contest</h3><p><br></p><p>We are thrilled to present the inaugural CodeDynamite Weekly Contest, a premier event designed to challenge your coding skills and ignite your passion for programming. Whether you''re a seasoned developer or a coding enthusiast, this contest offers a unique opportunity to showcase your talents, compete with like-minded individuals, and win exciting prizes.</p><p><br></p><p><strong>About the contest:</strong></p><ul><li><strong>Sponsored by:</strong> CodeDynamite, your go-to platform for cutting-edge coding resources and community support.</li><li><strong>When:</strong> Every week, with fresh and exciting challenges that cater to various skill levels.</li><li><strong>Who Can Participate:</strong> Open to all coding enthusiasts, regardless of experience level.</li></ul><p><br></p><p><strong>Why Join?</strong></p><ul><li><strong>Challenge Yourself:</strong> Tackle a variety of coding problems that will test your creativity and problem-solving abilities.</li><li><strong>Learn and Grow:</strong> Gain new insights and improve your coding skills through hands-on practice and real-time competition.</li><li><strong>Win Prizes:</strong> Stand a chance to win amazing rewards and earn recognition within the coding community.</li></ul><p><br></p><p><strong>How to Register:</strong></p><ul><li>Simply click the registration link below and fill out the required details to secure your spot in the contest.</li><li>Registration is quick, easy, and free!</li></ul><p><br></p><p><strong>Don’t miss out on this fantastic opportunity to connect, compete, and code with the best!</strong></p><p><br></p><p><strong>Register for the contest now and let your coding journey begin!</strong></p><p><a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb28/information" rel="noopener noreferrer" target="_blank">Link to register</a></p><p><br></p><p><br></p>',
     '<p><strong>🎉 Juicy Prizes Await You! 🎉</strong></p><p><br></p><p>Get ready to win some amazing rewards in the 1st CodeDynamite Weekly Contest! Here are the fantastic prizes up for grabs:</p><p><br></p><p><strong>1st Place:</strong></p><ul><li><strong>$500 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite T-Shirt</strong></li><li><strong>Personalized Winner''s Certificate</strong></li></ul><p><br></p><p><strong>2nd Place:</strong></p><ul><li><strong>$250 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Hoodie</strong></li><li><strong>Personalized Runner-Up Certificate</strong></li></ul><p><br></p><p><strong>3rd Place:</strong></p><ul><li><strong>$100 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Mug</strong></li><li><strong>Personalized Certificate of Achievement</strong></li></ul><p><br></p><p>Don''t miss your chance to win these incredible prizes and gain recognition in the coding community. <a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb16/information" rel="noopener noreferrer" target="_blank"><strong>Register now</strong></a> and let the competition begin!</p>',
     '<ol><li>Participants must submit their solutions before the end time.</li><li>Participants must follow the contest rules and guidelines.</li><li>Participants must not cheat or plagiarize.</li></ol>',
     '<p><strong>Pre-determined Challenge Scores:</strong></p><p>Each challenge you conquer has a pre-set score waiting to be claimed. The more complex the challenge, the higher the score you can rack up!</p><p><br></p><p><strong>Test Cases: Your Gateway to Glory:</strong></p><p>Each challenge comes with a battery of test cases designed to put your code through its paces. Every test case you conquer translates into points towards your final score. The more test cases you dominate, the closer you get to scoring supremacy!</p><p><br></p><p><strong>Multiple Submissions? No Problem!</strong></p><p>Feeling creative and tinkering with different solutions? No sweat! We take your highest scoring submission for each challenge into account, so fire away with your best attempts.</p><p><br></p><p><strong>The Leaderboard Beckons: It''s All About the Rank</strong></p><p>Participants are ranked on the glorious leaderboard based on their total score. But what happens when coders achieve the same score? Buckle up, because things get exciting!</p><p><br></p><p><strong>Tie-Breaker Time: Speed Demons Unite!</strong></p><p>In the thrilling case of a tie, the tie-breaker comes down to <strong>speed</strong>. The participant who submitted their highest-scoring solution in the <strong>shortest amount of time</strong> reigns supreme! So, channel your inner coding ninja and blaze through those challenges for ultimate glory.</p>',
     'https://leetcode.com/_next/static/images/biweekly-default-f5a8fc3be85b6c9175207fd8fd855d47.png',
     '2024-09-30 09:30:00.000000+07',
     '2024-09-30 10:30:00.000000+07',
     'b029f559-52a8-4699-b595-71161498ed8c',
     'b029f559-52a8-4699-b595-71161498ed8c',
     false,
     null,
     true
    ),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb29',  'Weekly Contest 15',
     '<h3>Welcome to the 15th CodeDynamite Weekly Contest</h3><p><br></p><p>We are thrilled to present the inaugural CodeDynamite Weekly Contest, a premier event designed to challenge your coding skills and ignite your passion for programming. Whether you''re a seasoned developer or a coding enthusiast, this contest offers a unique opportunity to showcase your talents, compete with like-minded individuals, and win exciting prizes.</p><p><br></p><p><strong>About the contest:</strong></p><ul><li><strong>Sponsored by:</strong> CodeDynamite, your go-to platform for cutting-edge coding resources and community support.</li><li><strong>When:</strong> Every week, with fresh and exciting challenges that cater to various skill levels.</li><li><strong>Who Can Participate:</strong> Open to all coding enthusiasts, regardless of experience level.</li></ul><p><br></p><p><strong>Why Join?</strong></p><ul><li><strong>Challenge Yourself:</strong> Tackle a variety of coding problems that will test your creativity and problem-solving abilities.</li><li><strong>Learn and Grow:</strong> Gain new insights and improve your coding skills through hands-on practice and real-time competition.</li><li><strong>Win Prizes:</strong> Stand a chance to win amazing rewards and earn recognition within the coding community.</li></ul><p><br></p><p><strong>How to Register:</strong></p><ul><li>Simply click the registration link below and fill out the required details to secure your spot in the contest.</li><li>Registration is quick, easy, and free!</li></ul><p><br></p><p><strong>Don’t miss out on this fantastic opportunity to connect, compete, and code with the best!</strong></p><p><br></p><p><strong>Register for the contest now and let your coding journey begin!</strong></p><p><a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb29/information" rel="noopener noreferrer" target="_blank">Link to register</a></p><p><br></p><p><br></p>',
     '<p><strong>🎉 Juicy Prizes Await You! 🎉</strong></p><p><br></p><p>Get ready to win some amazing rewards in the 1st CodeDynamite Weekly Contest! Here are the fantastic prizes up for grabs:</p><p><br></p><p><strong>1st Place:</strong></p><ul><li><strong>$500 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite T-Shirt</strong></li><li><strong>Personalized Winner''s Certificate</strong></li></ul><p><br></p><p><strong>2nd Place:</strong></p><ul><li><strong>$250 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Hoodie</strong></li><li><strong>Personalized Runner-Up Certificate</strong></li></ul><p><br></p><p><strong>3rd Place:</strong></p><ul><li><strong>$100 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Mug</strong></li><li><strong>Personalized Certificate of Achievement</strong></li></ul><p><br></p><p>Don''t miss your chance to win these incredible prizes and gain recognition in the coding community. <a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb16/information" rel="noopener noreferrer" target="_blank"><strong>Register now</strong></a> and let the competition begin!</p>',
     '<ol><li>Participants must submit their solutions before the end time.</li><li>Participants must follow the contest rules and guidelines.</li><li>Participants must not cheat or plagiarize.</li></ol>',
     '<p><strong>Pre-determined Challenge Scores:</strong></p><p>Each challenge you conquer has a pre-set score waiting to be claimed. The more complex the challenge, the higher the score you can rack up!</p><p><br></p><p><strong>Test Cases: Your Gateway to Glory:</strong></p><p>Each challenge comes with a battery of test cases designed to put your code through its paces. Every test case you conquer translates into points towards your final score. The more test cases you dominate, the closer you get to scoring supremacy!</p><p><br></p><p><strong>Multiple Submissions? No Problem!</strong></p><p>Feeling creative and tinkering with different solutions? No sweat! We take your highest scoring submission for each challenge into account, so fire away with your best attempts.</p><p><br></p><p><strong>The Leaderboard Beckons: It''s All About the Rank</strong></p><p>Participants are ranked on the glorious leaderboard based on their total score. But what happens when coders achieve the same score? Buckle up, because things get exciting!</p><p><br></p><p><strong>Tie-Breaker Time: Speed Demons Unite!</strong></p><p>In the thrilling case of a tie, the tie-breaker comes down to <strong>speed</strong>. The participant who submitted their highest-scoring solution in the <strong>shortest amount of time</strong> reigns supreme! So, channel your inner coding ninja and blaze through those challenges for ultimate glory.</p>',
     'https://leetcode.com/_next/static/images/biweekly-default-f5a8fc3be85b6c9175207fd8fd855d47.png',
     '2024-10-07 09:30:00.000000+07',
     '2024-10-07 10:30:00.000000+07',
     'b029f559-52a8-4699-b595-71161498ed8c',
     'b029f559-52a8-4699-b595-71161498ed8c',
     false,
     null,
     true
    ),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb30',  'HCMUS Hackathon Contest',
     '<h3>Welcome to the HCMUS Hackathon Contest</h3><p><br></p><p>We are thrilled to present the inaugural CodeDynamite Weekly Contest, a premier event designed to challenge your coding skills and ignite your passion for programming. Whether you''re a seasoned developer or a coding enthusiast, this contest offers a unique opportunity to showcase your talents, compete with like-minded individuals, and win exciting prizes.</p><p><br></p><p><strong>About the contest:</strong></p><ul><li><strong>Sponsored by:</strong> CodeDynamite, your go-to platform for cutting-edge coding resources and community support.</li><li><strong>When:</strong> Every week, with fresh and exciting challenges that cater to various skill levels.</li><li><strong>Who Can Participate:</strong> Open to all coding enthusiasts, regardless of experience level.</li></ul><p><br></p><p><strong>Why Join?</strong></p><ul><li><strong>Challenge Yourself:</strong> Tackle a variety of coding problems that will test your creativity and problem-solving abilities.</li><li><strong>Learn and Grow:</strong> Gain new insights and improve your coding skills through hands-on practice and real-time competition.</li><li><strong>Win Prizes:</strong> Stand a chance to win amazing rewards and earn recognition within the coding community.</li></ul><p><br></p><p><strong>How to Register:</strong></p><ul><li>Simply click the registration link below and fill out the required details to secure your spot in the contest.</li><li>Registration is quick, easy, and free!</li></ul><p><br></p><p><strong>Don’t miss out on this fantastic opportunity to connect, compete, and code with the best!</strong></p><p><br></p><p><strong>Register for the contest now and let your coding journey begin!</strong></p><p><a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb30/information" rel="noopener noreferrer" target="_blank">Link to register</a></p><p><br></p><p><br></p>',
     '<p><strong>🎉 Juicy Prizes Await You! 🎉</strong></p><p><br></p><p>Get ready to win some amazing rewards in the 1st CodeDynamite Weekly Contest! Here are the fantastic prizes up for grabs:</p><p><br></p><p><strong>1st Place:</strong></p><ul><li><strong>$500 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite T-Shirt</strong></li><li><strong>Personalized Winner''s Certificate</strong></li></ul><p><br></p><p><strong>2nd Place:</strong></p><ul><li><strong>$250 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Hoodie</strong></li><li><strong>Personalized Runner-Up Certificate</strong></li></ul><p><br></p><p><strong>3rd Place:</strong></p><ul><li><strong>$100 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Mug</strong></li><li><strong>Personalized Certificate of Achievement</strong></li></ul><p><br></p><p>Don''t miss your chance to win these incredible prizes and gain recognition in the coding community. <a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb16/information" rel="noopener noreferrer" target="_blank"><strong>Register now</strong></a> and let the competition begin!</p>',
     '<ol><li>Participants must submit their solutions before the end time.</li><li>Participants must follow the contest rules and guidelines.</li><li>Participants must not cheat or plagiarize.</li></ol>',
     '<p><strong>Pre-determined Challenge Scores:</strong></p><p>Each challenge you conquer has a pre-set score waiting to be claimed. The more complex the challenge, the higher the score you can rack up!</p><p><br></p><p><strong>Test Cases: Your Gateway to Glory:</strong></p><p>Each challenge comes with a battery of test cases designed to put your code through its paces. Every test case you conquer translates into points towards your final score. The more test cases you dominate, the closer you get to scoring supremacy!</p><p><br></p><p><strong>Multiple Submissions? No Problem!</strong></p><p>Feeling creative and tinkering with different solutions? No sweat! We take your highest scoring submission for each challenge into account, so fire away with your best attempts.</p><p><br></p><p><strong>The Leaderboard Beckons: It''s All About the Rank</strong></p><p>Participants are ranked on the glorious leaderboard based on their total score. But what happens when coders achieve the same score? Buckle up, because things get exciting!</p><p><br></p><p><strong>Tie-Breaker Time: Speed Demons Unite!</strong></p><p>In the thrilling case of a tie, the tie-breaker comes down to <strong>speed</strong>. The participant who submitted their highest-scoring solution in the <strong>shortest amount of time</strong> reigns supreme! So, channel your inner coding ninja and blaze through those challenges for ultimate glory.</p>',
     'https://leetcode.com/_next/static/images/biweekly-default-f5a8fc3be85b6c9175207fd8fd855d47.png',
     CURRENT_TIMESTAMP + INTERVAL '45 minutes',
     CURRENT_TIMESTAMP + INTERVAL '1 hour 45 minutes',
     'b029f559-52a8-4699-b595-71161498ed8c',
     'b029f559-52a8-4699-b595-71161498ed8c',
     true,
     '08b65a39-394f-4977-a5fa-3fe145b620f8',
     true
    ),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb31',  'HCMUS Algorithm Contest',
     '<h3>Welcome to the HCMUS Algorithm Contest</h3><p><br></p><p>We are thrilled to present the inaugural CodeDynamite Weekly Contest, a premier event designed to challenge your coding skills and ignite your passion for programming. Whether you''re a seasoned developer or a coding enthusiast, this contest offers a unique opportunity to showcase your talents, compete with like-minded individuals, and win exciting prizes.</p><p><br></p><p><strong>About the contest:</strong></p><ul><li><strong>Sponsored by:</strong> CodeDynamite, your go-to platform for cutting-edge coding resources and community support.</li><li><strong>When:</strong> Every week, with fresh and exciting challenges that cater to various skill levels.</li><li><strong>Who Can Participate:</strong> Open to all coding enthusiasts, regardless of experience level.</li></ul><p><br></p><p><strong>Why Join?</strong></p><ul><li><strong>Challenge Yourself:</strong> Tackle a variety of coding problems that will test your creativity and problem-solving abilities.</li><li><strong>Learn and Grow:</strong> Gain new insights and improve your coding skills through hands-on practice and real-time competition.</li><li><strong>Win Prizes:</strong> Stand a chance to win amazing rewards and earn recognition within the coding community.</li></ul><p><br></p><p><strong>How to Register:</strong></p><ul><li>Simply click the registration link below and fill out the required details to secure your spot in the contest.</li><li>Registration is quick, easy, and free!</li></ul><p><br></p><p><strong>Don’t miss out on this fantastic opportunity to connect, compete, and code with the best!</strong></p><p><br></p><p><strong>Register for the contest now and let your coding journey begin!</strong></p><p><a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb31/information" rel="noopener noreferrer" target="_blank">Link to register</a></p><p><br></p><p><br></p>',
     '<p><strong>🎉 Juicy Prizes Await You! 🎉</strong></p><p><br></p><p>Get ready to win some amazing rewards in the 1st CodeDynamite Weekly Contest! Here are the fantastic prizes up for grabs:</p><p><br></p><p><strong>1st Place:</strong></p><ul><li><strong>$500 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite T-Shirt</strong></li><li><strong>Personalized Winner''s Certificate</strong></li></ul><p><br></p><p><strong>2nd Place:</strong></p><ul><li><strong>$250 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Hoodie</strong></li><li><strong>Personalized Runner-Up Certificate</strong></li></ul><p><br></p><p><strong>3rd Place:</strong></p><ul><li><strong>$100 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Mug</strong></li><li><strong>Personalized Certificate of Achievement</strong></li></ul><p><br></p><p>Don''t miss your chance to win these incredible prizes and gain recognition in the coding community. <a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb16/information" rel="noopener noreferrer" target="_blank"><strong>Register now</strong></a> and let the competition begin!</p>',
     '<ol><li>Participants must submit their solutions before the end time.</li><li>Participants must follow the contest rules and guidelines.</li><li>Participants must not cheat or plagiarize.</li></ol>',
     '<p><strong>Pre-determined Challenge Scores:</strong></p><p>Each challenge you conquer has a pre-set score waiting to be claimed. The more complex the challenge, the higher the score you can rack up!</p><p><br></p><p><strong>Test Cases: Your Gateway to Glory:</strong></p><p>Each challenge comes with a battery of test cases designed to put your code through its paces. Every test case you conquer translates into points towards your final score. The more test cases you dominate, the closer you get to scoring supremacy!</p><p><br></p><p><strong>Multiple Submissions? No Problem!</strong></p><p>Feeling creative and tinkering with different solutions? No sweat! We take your highest scoring submission for each challenge into account, so fire away with your best attempts.</p><p><br></p><p><strong>The Leaderboard Beckons: It''s All About the Rank</strong></p><p>Participants are ranked on the glorious leaderboard based on their total score. But what happens when coders achieve the same score? Buckle up, because things get exciting!</p><p><br></p><p><strong>Tie-Breaker Time: Speed Demons Unite!</strong></p><p>In the thrilling case of a tie, the tie-breaker comes down to <strong>speed</strong>. The participant who submitted their highest-scoring solution in the <strong>shortest amount of time</strong> reigns supreme! So, channel your inner coding ninja and blaze through those challenges for ultimate glory.</p>',
     'https://leetcode.com/_next/static/images/biweekly-default-f5a8fc3be85b6c9175207fd8fd855d47.png',
     CURRENT_TIMESTAMP + INTERVAL '1 hour 20 minutes',
     CURRENT_TIMESTAMP + INTERVAL '2 hours 20 minutes',
     'b029f559-52a8-4699-b595-71161498ed8c',
     'b029f559-52a8-4699-b595-71161498ed8c',
     true,
     '08b65a39-394f-4977-a5fa-3fe145b620f8',
     true
    ),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb32',  'HCMUS Code-A-Thon Contest',
     '<h3>Welcome to the HCMUS Code-A-Thon Contest</h3><p><br></p><p>We are thrilled to present the inaugural CodeDynamite Weekly Contest, a premier event designed to challenge your coding skills and ignite your passion for programming. Whether you''re a seasoned developer or a coding enthusiast, this contest offers a unique opportunity to showcase your talents, compete with like-minded individuals, and win exciting prizes.</p><p><br></p><p><strong>About the contest:</strong></p><ul><li><strong>Sponsored by:</strong> CodeDynamite, your go-to platform for cutting-edge coding resources and community support.</li><li><strong>When:</strong> Every week, with fresh and exciting challenges that cater to various skill levels.</li><li><strong>Who Can Participate:</strong> Open to all coding enthusiasts, regardless of experience level.</li></ul><p><br></p><p><strong>Why Join?</strong></p><ul><li><strong>Challenge Yourself:</strong> Tackle a variety of coding problems that will test your creativity and problem-solving abilities.</li><li><strong>Learn and Grow:</strong> Gain new insights and improve your coding skills through hands-on practice and real-time competition.</li><li><strong>Win Prizes:</strong> Stand a chance to win amazing rewards and earn recognition within the coding community.</li></ul><p><br></p><p><strong>How to Register:</strong></p><ul><li>Simply click the registration link below and fill out the required details to secure your spot in the contest.</li><li>Registration is quick, easy, and free!</li></ul><p><br></p><p><strong>Don’t miss out on this fantastic opportunity to connect, compete, and code with the best!</strong></p><p><br></p><p><strong>Register for the contest now and let your coding journey begin!</strong></p><p><a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb32/information" rel="noopener noreferrer" target="_blank">Link to register</a></p><p><br></p><p><br></p>',
     '<p><strong>🎉 Juicy Prizes Await You! 🎉</strong></p><p><br></p><p>Get ready to win some amazing rewards in the 1st CodeDynamite Weekly Contest! Here are the fantastic prizes up for grabs:</p><p><br></p><p><strong>1st Place:</strong></p><ul><li><strong>$500 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite T-Shirt</strong></li><li><strong>Personalized Winner''s Certificate</strong></li></ul><p><br></p><p><strong>2nd Place:</strong></p><ul><li><strong>$250 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Hoodie</strong></li><li><strong>Personalized Runner-Up Certificate</strong></li></ul><p><br></p><p><strong>3rd Place:</strong></p><ul><li><strong>$100 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Mug</strong></li><li><strong>Personalized Certificate of Achievement</strong></li></ul><p><br></p><p>Don''t miss your chance to win these incredible prizes and gain recognition in the coding community. <a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb16/information" rel="noopener noreferrer" target="_blank"><strong>Register now</strong></a> and let the competition begin!</p>',
     '<ol><li>Participants must submit their solutions before the end time.</li><li>Participants must follow the contest rules and guidelines.</li><li>Participants must not cheat or plagiarize.</li></ol>',
     '<p><strong>Pre-determined Challenge Scores:</strong></p><p>Each challenge you conquer has a pre-set score waiting to be claimed. The more complex the challenge, the higher the score you can rack up!</p><p><br></p><p><strong>Test Cases: Your Gateway to Glory:</strong></p><p>Each challenge comes with a battery of test cases designed to put your code through its paces. Every test case you conquer translates into points towards your final score. The more test cases you dominate, the closer you get to scoring supremacy!</p><p><br></p><p><strong>Multiple Submissions? No Problem!</strong></p><p>Feeling creative and tinkering with different solutions? No sweat! We take your highest scoring submission for each challenge into account, so fire away with your best attempts.</p><p><br></p><p><strong>The Leaderboard Beckons: It''s All About the Rank</strong></p><p>Participants are ranked on the glorious leaderboard based on their total score. But what happens when coders achieve the same score? Buckle up, because things get exciting!</p><p><br></p><p><strong>Tie-Breaker Time: Speed Demons Unite!</strong></p><p>In the thrilling case of a tie, the tie-breaker comes down to <strong>speed</strong>. The participant who submitted their highest-scoring solution in the <strong>shortest amount of time</strong> reigns supreme! So, channel your inner coding ninja and blaze through those challenges for ultimate glory.</p>',
     'https://leetcode.com/_next/static/images/biweekly-default-f5a8fc3be85b6c9175207fd8fd855d47.png',
     CURRENT_TIMESTAMP + INTERVAL '1 hours',
     CURRENT_TIMESTAMP + INTERVAL '2 hours',
     'b029f559-52a8-4699-b595-71161498ed8c',
     'b029f559-52a8-4699-b595-71161498ed8c',
     true,
     '08b65a39-394f-4977-a5fa-3fe145b620f8',
     true
    ),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb33',  'HCMUS Coding Contest',
     '<h3>Welcome to the HCMUS Coding Contest</h3><p><br></p><p>We are thrilled to present the inaugural CodeDynamite Weekly Contest, a premier event designed to challenge your coding skills and ignite your passion for programming. Whether you''re a seasoned developer or a coding enthusiast, this contest offers a unique opportunity to showcase your talents, compete with like-minded individuals, and win exciting prizes.</p><p><br></p><p><strong>About the contest:</strong></p><ul><li><strong>Sponsored by:</strong> CodeDynamite, your go-to platform for cutting-edge coding resources and community support.</li><li><strong>When:</strong> Every week, with fresh and exciting challenges that cater to various skill levels.</li><li><strong>Who Can Participate:</strong> Open to all coding enthusiasts, regardless of experience level.</li></ul><p><br></p><p><strong>Why Join?</strong></p><ul><li><strong>Challenge Yourself:</strong> Tackle a variety of coding problems that will test your creativity and problem-solving abilities.</li><li><strong>Learn and Grow:</strong> Gain new insights and improve your coding skills through hands-on practice and real-time competition.</li><li><strong>Win Prizes:</strong> Stand a chance to win amazing rewards and earn recognition within the coding community.</li></ul><p><br></p><p><strong>How to Register:</strong></p><ul><li>Simply click the registration link below and fill out the required details to secure your spot in the contest.</li><li>Registration is quick, easy, and free!</li></ul><p><br></p><p><strong>Don’t miss out on this fantastic opportunity to connect, compete, and code with the best!</strong></p><p><br></p><p><strong>Register for the contest now and let your coding journey begin!</strong></p><p><a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb33/information" rel="noopener noreferrer" target="_blank">Link to register</a></p><p><br></p><p><br></p>',
     '<p><strong>🎉 Juicy Prizes Await You! 🎉</strong></p><p><br></p><p>Get ready to win some amazing rewards in the 1st CodeDynamite Weekly Contest! Here are the fantastic prizes up for grabs:</p><p><br></p><p><strong>1st Place:</strong></p><ul><li><strong>$500 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite T-Shirt</strong></li><li><strong>Personalized Winner''s Certificate</strong></li></ul><p><br></p><p><strong>2nd Place:</strong></p><ul><li><strong>$250 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Hoodie</strong></li><li><strong>Personalized Runner-Up Certificate</strong></li></ul><p><br></p><p><strong>3rd Place:</strong></p><ul><li><strong>$100 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Mug</strong></li><li><strong>Personalized Certificate of Achievement</strong></li></ul><p><br></p><p>Don''t miss your chance to win these incredible prizes and gain recognition in the coding community. <a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb16/information" rel="noopener noreferrer" target="_blank"><strong>Register now</strong></a> and let the competition begin!</p>',
     '<ol><li>Participants must submit their solutions before the end time.</li><li>Participants must follow the contest rules and guidelines.</li><li>Participants must not cheat or plagiarize.</li></ol>',
     '<p><strong>Pre-determined Challenge Scores:</strong></p><p>Each challenge you conquer has a pre-set score waiting to be claimed. The more complex the challenge, the higher the score you can rack up!</p><p><br></p><p><strong>Test Cases: Your Gateway to Glory:</strong></p><p>Each challenge comes with a battery of test cases designed to put your code through its paces. Every test case you conquer translates into points towards your final score. The more test cases you dominate, the closer you get to scoring supremacy!</p><p><br></p><p><strong>Multiple Submissions? No Problem!</strong></p><p>Feeling creative and tinkering with different solutions? No sweat! We take your highest scoring submission for each challenge into account, so fire away with your best attempts.</p><p><br></p><p><strong>The Leaderboard Beckons: It''s All About the Rank</strong></p><p>Participants are ranked on the glorious leaderboard based on their total score. But what happens when coders achieve the same score? Buckle up, because things get exciting!</p><p><br></p><p><strong>Tie-Breaker Time: Speed Demons Unite!</strong></p><p>In the thrilling case of a tie, the tie-breaker comes down to <strong>speed</strong>. The participant who submitted their highest-scoring solution in the <strong>shortest amount of time</strong> reigns supreme! So, channel your inner coding ninja and blaze through those challenges for ultimate glory.</p>',
     'https://leetcode.com/_next/static/images/biweekly-default-f5a8fc3be85b6c9175207fd8fd855d47.png',
     CURRENT_TIMESTAMP + INTERVAL '1 hour 15 minutes',
     CURRENT_TIMESTAMP + INTERVAL '2 hours 15 minutes',
     'b029f559-52a8-4699-b595-71161498ed8c',
     'b029f559-52a8-4699-b595-71161498ed8c',
     true,
     '08b65a39-394f-4977-a5fa-3fe145b620f8',
     true
    ),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb34',  'Asia Hackathon Contest',
     '<h3>Welcome to the Asia Hackathon Contest</h3><p><br></p><p>We are thrilled to present the inaugural Asia Hackathon Contest, a premier event designed to challenge your coding skills and ignite your passion for programming. Whether you''re a seasoned developer or a coding enthusiast, this contest offers a unique opportunity to showcase your talents, compete with like-minded individuals, and win exciting prizes.</p><p><br></p><p><strong>About the contest:</strong></p><ul><li><strong>Sponsored by:</strong> CodeDynamite, your go-to platform for cutting-edge coding resources and community support.</li><li><strong>When:</strong> Every week, with fresh and exciting challenges that cater to various skill levels.</li><li><strong>Who Can Participate:</strong> Open to all coding enthusiasts, regardless of experience level.</li></ul><p><br></p><p><strong>Why Join?</strong></p><ul><li><strong>Challenge Yourself:</strong> Tackle a variety of coding problems that will test your creativity and problem-solving abilities.</li><li><strong>Learn and Grow:</strong> Gain new insights and improve your coding skills through hands-on practice and real-time competition.</li><li><strong>Win Prizes:</strong> Stand a chance to win amazing rewards and earn recognition within the coding community.</li></ul><p><br></p><p><strong>How to Register:</strong></p><ul><li>Simply click the registration link below and fill out the required details to secure your spot in the contest.</li><li>Registration is quick, easy, and free!</li></ul><p><br></p><p><strong>Don’t miss out on this fantastic opportunity to connect, compete, and code with the best!</strong></p><p><br></p><p><strong>Register for the contest now and let your coding journey begin!</strong></p><p><a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb34/information" rel="noopener noreferrer" target="_blank">Link to register</a></p><p><br></p><p><br></p>',
     '<p><strong>🎉 Juicy Prizes Await You! 🎉</strong></p><p><br></p><p>Get ready to win some amazing rewards in the 1st CodeDynamite Weekly Contest! Here are the fantastic prizes up for grabs:</p><p><br></p><p><strong>1st Place:</strong></p><ul><li><strong>$500 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite T-Shirt</strong></li><li><strong>Personalized Winner''s Certificate</strong></li></ul><p><br></p><p><strong>2nd Place:</strong></p><ul><li><strong>$250 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Hoodie</strong></li><li><strong>Personalized Runner-Up Certificate</strong></li></ul><p><br></p><p><strong>3rd Place:</strong></p><ul><li><strong>$100 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Mug</strong></li><li><strong>Personalized Certificate of Achievement</strong></li></ul><p><br></p><p>Don''t miss your chance to win these incredible prizes and gain recognition in the coding community. <a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb16/information" rel="noopener noreferrer" target="_blank"><strong>Register now</strong></a> and let the competition begin!</p>',
     '<ol><li>Participants must submit their solutions before the end time.</li><li>Participants must follow the contest rules and guidelines.</li><li>Participants must not cheat or plagiarize.</li></ol>',
     '<p><strong>Pre-determined Challenge Scores:</strong></p><p>Each challenge you conquer has a pre-set score waiting to be claimed. The more complex the challenge, the higher the score you can rack up!</p><p><br></p><p><strong>Test Cases: Your Gateway to Glory:</strong></p><p>Each challenge comes with a battery of test cases designed to put your code through its paces. Every test case you conquer translates into points towards your final score. The more test cases you dominate, the closer you get to scoring supremacy!</p><p><br></p><p><strong>Multiple Submissions? No Problem!</strong></p><p>Feeling creative and tinkering with different solutions? No sweat! We take your highest scoring submission for each challenge into account, so fire away with your best attempts.</p><p><br></p><p><strong>The Leaderboard Beckons: It''s All About the Rank</strong></p><p>Participants are ranked on the glorious leaderboard based on their total score. But what happens when coders achieve the same score? Buckle up, because things get exciting!</p><p><br></p><p><strong>Tie-Breaker Time: Speed Demons Unite!</strong></p><p>In the thrilling case of a tie, the tie-breaker comes down to <strong>speed</strong>. The participant who submitted their highest-scoring solution in the <strong>shortest amount of time</strong> reigns supreme! So, channel your inner coding ninja and blaze through those challenges for ultimate glory.</p>',
     'https://leetcode.com/_next/static/images/biweekly-default-f5a8fc3be85b6c9175207fd8fd855d47.png',
     CURRENT_TIMESTAMP + INTERVAL '30 minutes',
     CURRENT_TIMESTAMP + INTERVAL '1 hour 30 minutes',
     'b029f559-52a8-4699-b595-71161498ed8c',
     'b029f559-52a8-4699-b595-71161498ed8c',
     true,
     null,
     true
    ),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb35',  'Pacific Algorithm Contest',
     '<h3>Welcome to the Pacific Algorithm Contest</h3><p><br></p><p>We are thrilled to present the inaugural Pacific Algorithm Contest, a premier event designed to challenge your coding skills and ignite your passion for programming. Whether you''re a seasoned developer or a coding enthusiast, this contest offers a unique opportunity to showcase your talents, compete with like-minded individuals, and win exciting prizes.</p><p><br></p><p><strong>About the contest:</strong></p><ul><li><strong>Sponsored by:</strong> CodeDynamite, your go-to platform for cutting-edge coding resources and community support.</li><li><strong>When:</strong> Every week, with fresh and exciting challenges that cater to various skill levels.</li><li><strong>Who Can Participate:</strong> Open to all coding enthusiasts, regardless of experience level.</li></ul><p><br></p><p><strong>Why Join?</strong></p><ul><li><strong>Challenge Yourself:</strong> Tackle a variety of coding problems that will test your creativity and problem-solving abilities.</li><li><strong>Learn and Grow:</strong> Gain new insights and improve your coding skills through hands-on practice and real-time competition.</li><li><strong>Win Prizes:</strong> Stand a chance to win amazing rewards and earn recognition within the coding community.</li></ul><p><br></p><p><strong>How to Register:</strong></p><ul><li>Simply click the registration link below and fill out the required details to secure your spot in the contest.</li><li>Registration is quick, easy, and free!</li></ul><p><br></p><p><strong>Don’t miss out on this fantastic opportunity to connect, compete, and code with the best!</strong></p><p><br></p><p><strong>Register for the contest now and let your coding journey begin!</strong></p><p><a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb35/information" rel="noopener noreferrer" target="_blank">Link to register</a></p><p><br></p><p><br></p>',
     '<p><strong>🎉 Juicy Prizes Await You! 🎉</strong></p><p><br></p><p>Get ready to win some amazing rewards in the 1st CodeDynamite Weekly Contest! Here are the fantastic prizes up for grabs:</p><p><br></p><p><strong>1st Place:</strong></p><ul><li><strong>$500 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite T-Shirt</strong></li><li><strong>Personalized Winner''s Certificate</strong></li></ul><p><br></p><p><strong>2nd Place:</strong></p><ul><li><strong>$250 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Hoodie</strong></li><li><strong>Personalized Runner-Up Certificate</strong></li></ul><p><br></p><p><strong>3rd Place:</strong></p><ul><li><strong>$100 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Mug</strong></li><li><strong>Personalized Certificate of Achievement</strong></li></ul><p><br></p><p>Don''t miss your chance to win these incredible prizes and gain recognition in the coding community. <a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb16/information" rel="noopener noreferrer" target="_blank"><strong>Register now</strong></a> and let the competition begin!</p>',
     '<ol><li>Participants must submit their solutions before the end time.</li><li>Participants must follow the contest rules and guidelines.</li><li>Participants must not cheat or plagiarize.</li></ol>',
     '<p><strong>Pre-determined Challenge Scores:</strong></p><p>Each challenge you conquer has a pre-set score waiting to be claimed. The more complex the challenge, the higher the score you can rack up!</p><p><br></p><p><strong>Test Cases: Your Gateway to Glory:</strong></p><p>Each challenge comes with a battery of test cases designed to put your code through its paces. Every test case you conquer translates into points towards your final score. The more test cases you dominate, the closer you get to scoring supremacy!</p><p><br></p><p><strong>Multiple Submissions? No Problem!</strong></p><p>Feeling creative and tinkering with different solutions? No sweat! We take your highest scoring submission for each challenge into account, so fire away with your best attempts.</p><p><br></p><p><strong>The Leaderboard Beckons: It''s All About the Rank</strong></p><p>Participants are ranked on the glorious leaderboard based on their total score. But what happens when coders achieve the same score? Buckle up, because things get exciting!</p><p><br></p><p><strong>Tie-Breaker Time: Speed Demons Unite!</strong></p><p>In the thrilling case of a tie, the tie-breaker comes down to <strong>speed</strong>. The participant who submitted their highest-scoring solution in the <strong>shortest amount of time</strong> reigns supreme! So, channel your inner coding ninja and blaze through those challenges for ultimate glory.</p>',
     'https://leetcode.com/_next/static/images/biweekly-default-f5a8fc3be85b6c9175207fd8fd855d47.png',
     CURRENT_TIMESTAMP + INTERVAL '40 minutes',
     CURRENT_TIMESTAMP + INTERVAL '1 hour 40 minutes',
     'b029f559-52a8-4699-b595-71161498ed8c',
     'b029f559-52a8-4699-b595-71161498ed8c',
     true,
     null,
     true
    ),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb36',  'Coding Hackathon Contest',
     '<h3>Welcome to the Coding Hackathon Contest</h3><p><br></p><p>We are thrilled to present the inaugural CodeDynamite Weekly Contest, a premier event designed to challenge your coding skills and ignite your passion for programming. Whether you''re a seasoned developer or a coding enthusiast, this contest offers a unique opportunity to showcase your talents, compete with like-minded individuals, and win exciting prizes.</p><p><br></p><p><strong>About the contest:</strong></p><ul><li><strong>Sponsored by:</strong> CodeDynamite, your go-to platform for cutting-edge coding resources and community support.</li><li><strong>When:</strong> Every week, with fresh and exciting challenges that cater to various skill levels.</li><li><strong>Who Can Participate:</strong> Open to all coding enthusiasts, regardless of experience level.</li></ul><p><br></p><p><strong>Why Join?</strong></p><ul><li><strong>Challenge Yourself:</strong> Tackle a variety of coding problems that will test your creativity and problem-solving abilities.</li><li><strong>Learn and Grow:</strong> Gain new insights and improve your coding skills through hands-on practice and real-time competition.</li><li><strong>Win Prizes:</strong> Stand a chance to win amazing rewards and earn recognition within the coding community.</li></ul><p><br></p><p><strong>How to Register:</strong></p><ul><li>Simply click the registration link below and fill out the required details to secure your spot in the contest.</li><li>Registration is quick, easy, and free!</li></ul><p><br></p><p><strong>Don’t miss out on this fantastic opportunity to connect, compete, and code with the best!</strong></p><p><br></p><p><strong>Register for the contest now and let your coding journey begin!</strong></p><p><a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb36/information" rel="noopener noreferrer" target="_blank">Link to register</a></p><p><br></p><p><br></p>',
     '<p><strong>🎉 Juicy Prizes Await You! 🎉</strong></p><p><br></p><p>Get ready to win some amazing rewards in the 1st CodeDynamite Weekly Contest! Here are the fantastic prizes up for grabs:</p><p><br></p><p><strong>1st Place:</strong></p><ul><li><strong>$500 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite T-Shirt</strong></li><li><strong>Personalized Winner''s Certificate</strong></li></ul><p><br></p><p><strong>2nd Place:</strong></p><ul><li><strong>$250 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Hoodie</strong></li><li><strong>Personalized Runner-Up Certificate</strong></li></ul><p><br></p><p><strong>3rd Place:</strong></p><ul><li><strong>$100 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Mug</strong></li><li><strong>Personalized Certificate of Achievement</strong></li></ul><p><br></p><p>Don''t miss your chance to win these incredible prizes and gain recognition in the coding community. <a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb16/information" rel="noopener noreferrer" target="_blank"><strong>Register now</strong></a> and let the competition begin!</p>',
     '<ol><li>Participants must submit their solutions before the end time.</li><li>Participants must follow the contest rules and guidelines.</li><li>Participants must not cheat or plagiarize.</li></ol>',
     '<p><strong>Pre-determined Challenge Scores:</strong></p><p>Each challenge you conquer has a pre-set score waiting to be claimed. The more complex the challenge, the higher the score you can rack up!</p><p><br></p><p><strong>Test Cases: Your Gateway to Glory:</strong></p><p>Each challenge comes with a battery of test cases designed to put your code through its paces. Every test case you conquer translates into points towards your final score. The more test cases you dominate, the closer you get to scoring supremacy!</p><p><br></p><p><strong>Multiple Submissions? No Problem!</strong></p><p>Feeling creative and tinkering with different solutions? No sweat! We take your highest scoring submission for each challenge into account, so fire away with your best attempts.</p><p><br></p><p><strong>The Leaderboard Beckons: It''s All About the Rank</strong></p><p>Participants are ranked on the glorious leaderboard based on their total score. But what happens when coders achieve the same score? Buckle up, because things get exciting!</p><p><br></p><p><strong>Tie-Breaker Time: Speed Demons Unite!</strong></p><p>In the thrilling case of a tie, the tie-breaker comes down to <strong>speed</strong>. The participant who submitted their highest-scoring solution in the <strong>shortest amount of time</strong> reigns supreme! So, channel your inner coding ninja and blaze through those challenges for ultimate glory.</p>',
     'https://leetcode.com/_next/static/images/biweekly-default-f5a8fc3be85b6c9175207fd8fd855d47.png',
     CURRENT_TIMESTAMP + INTERVAL '50 minutes',
     CURRENT_TIMESTAMP + INTERVAL '1 hour 50 minutes',
     'b029f559-52a8-4699-b595-71161498ed8c',
     'b029f559-52a8-4699-b595-71161498ed8c',
     true,
     null,
     true
    ),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb37',  'Fresher Coding Contest',
     '<h3>Welcome to the Fresher Coding Contest</h3><p><br></p><p>We are thrilled to present the inaugural CodeDynamite Weekly Contest, a premier event designed to challenge your coding skills and ignite your passion for programming. Whether you''re a seasoned developer or a coding enthusiast, this contest offers a unique opportunity to showcase your talents, compete with like-minded individuals, and win exciting prizes.</p><p><br></p><p><strong>About the contest:</strong></p><ul><li><strong>Sponsored by:</strong> CodeDynamite, your go-to platform for cutting-edge coding resources and community support.</li><li><strong>When:</strong> Every week, with fresh and exciting challenges that cater to various skill levels.</li><li><strong>Who Can Participate:</strong> Open to all coding enthusiasts, regardless of experience level.</li></ul><p><br></p><p><strong>Why Join?</strong></p><ul><li><strong>Challenge Yourself:</strong> Tackle a variety of coding problems that will test your creativity and problem-solving abilities.</li><li><strong>Learn and Grow:</strong> Gain new insights and improve your coding skills through hands-on practice and real-time competition.</li><li><strong>Win Prizes:</strong> Stand a chance to win amazing rewards and earn recognition within the coding community.</li></ul><p><br></p><p><strong>How to Register:</strong></p><ul><li>Simply click the registration link below and fill out the required details to secure your spot in the contest.</li><li>Registration is quick, easy, and free!</li></ul><p><br></p><p><strong>Don’t miss out on this fantastic opportunity to connect, compete, and code with the best!</strong></p><p><br></p><p><strong>Register for the contest now and let your coding journey begin!</strong></p><p><a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb37/information" rel="noopener noreferrer" target="_blank">Link to register</a></p><p><br></p><p><br></p>',
     '<p><strong>🎉 Juicy Prizes Await You! 🎉</strong></p><p><br></p><p>Get ready to win some amazing rewards in the 1st CodeDynamite Weekly Contest! Here are the fantastic prizes up for grabs:</p><p><br></p><p><strong>1st Place:</strong></p><ul><li><strong>$500 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite T-Shirt</strong></li><li><strong>Personalized Winner''s Certificate</strong></li></ul><p><br></p><p><strong>2nd Place:</strong></p><ul><li><strong>$250 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Hoodie</strong></li><li><strong>Personalized Runner-Up Certificate</strong></li></ul><p><br></p><p><strong>3rd Place:</strong></p><ul><li><strong>$100 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Mug</strong></li><li><strong>Personalized Certificate of Achievement</strong></li></ul><p><br></p><p>Don''t miss your chance to win these incredible prizes and gain recognition in the coding community. <a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb16/information" rel="noopener noreferrer" target="_blank"><strong>Register now</strong></a> and let the competition begin!</p>',
     '<ol><li>Participants must submit their solutions before the end time.</li><li>Participants must follow the contest rules and guidelines.</li><li>Participants must not cheat or plagiarize.</li></ol>',
     '<p><strong>Pre-determined Challenge Scores:</strong></p><p>Each challenge you conquer has a pre-set score waiting to be claimed. The more complex the challenge, the higher the score you can rack up!</p><p><br></p><p><strong>Test Cases: Your Gateway to Glory:</strong></p><p>Each challenge comes with a battery of test cases designed to put your code through its paces. Every test case you conquer translates into points towards your final score. The more test cases you dominate, the closer you get to scoring supremacy!</p><p><br></p><p><strong>Multiple Submissions? No Problem!</strong></p><p>Feeling creative and tinkering with different solutions? No sweat! We take your highest scoring submission for each challenge into account, so fire away with your best attempts.</p><p><br></p><p><strong>The Leaderboard Beckons: It''s All About the Rank</strong></p><p>Participants are ranked on the glorious leaderboard based on their total score. But what happens when coders achieve the same score? Buckle up, because things get exciting!</p><p><br></p><p><strong>Tie-Breaker Time: Speed Demons Unite!</strong></p><p>In the thrilling case of a tie, the tie-breaker comes down to <strong>speed</strong>. The participant who submitted their highest-scoring solution in the <strong>shortest amount of time</strong> reigns supreme! So, channel your inner coding ninja and blaze through those challenges for ultimate glory.</p>',
     'https://leetcode.com/_next/static/images/biweekly-default-f5a8fc3be85b6c9175207fd8fd855d47.png',
     CURRENT_TIMESTAMP + INTERVAL '1 hour',
     CURRENT_TIMESTAMP + INTERVAL '2 hours',
     'b029f559-52a8-4699-b595-71161498ed8c',
     'b029f559-52a8-4699-b595-71161498ed8c',
     true,
     null,
     true
    ),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb38',  'Junior Coding Contest',
     '<h3>Welcome to the Junior Coding Contest</h3><p><br></p><p>We are thrilled to present the inaugural CodeDynamite Weekly Contest, a premier event designed to challenge your coding skills and ignite your passion for programming. Whether you''re a seasoned developer or a coding enthusiast, this contest offers a unique opportunity to showcase your talents, compete with like-minded individuals, and win exciting prizes.</p><p><br></p><p><strong>About the contest:</strong></p><ul><li><strong>Sponsored by:</strong> CodeDynamite, your go-to platform for cutting-edge coding resources and community support.</li><li><strong>When:</strong> Every week, with fresh and exciting challenges that cater to various skill levels.</li><li><strong>Who Can Participate:</strong> Open to all coding enthusiasts, regardless of experience level.</li></ul><p><br></p><p><strong>Why Join?</strong></p><ul><li><strong>Challenge Yourself:</strong> Tackle a variety of coding problems that will test your creativity and problem-solving abilities.</li><li><strong>Learn and Grow:</strong> Gain new insights and improve your coding skills through hands-on practice and real-time competition.</li><li><strong>Win Prizes:</strong> Stand a chance to win amazing rewards and earn recognition within the coding community.</li></ul><p><br></p><p><strong>How to Register:</strong></p><ul><li>Simply click the registration link below and fill out the required details to secure your spot in the contest.</li><li>Registration is quick, easy, and free!</li></ul><p><br></p><p><strong>Don’t miss out on this fantastic opportunity to connect, compete, and code with the best!</strong></p><p><br></p><p><strong>Register for the contest now and let your coding journey begin!</strong></p><p><a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb38/information" rel="noopener noreferrer" target="_blank">Link to register</a></p><p><br></p><p><br></p>',
     '<p><strong>🎉 Juicy Prizes Await You! 🎉</strong></p><p><br></p><p>Get ready to win some amazing rewards in the 1st CodeDynamite Weekly Contest! Here are the fantastic prizes up for grabs:</p><p><br></p><p><strong>1st Place:</strong></p><ul><li><strong>$500 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite T-Shirt</strong></li><li><strong>Personalized Winner''s Certificate</strong></li></ul><p><br></p><p><strong>2nd Place:</strong></p><ul><li><strong>$250 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Hoodie</strong></li><li><strong>Personalized Runner-Up Certificate</strong></li></ul><p><br></p><p><strong>3rd Place:</strong></p><ul><li><strong>$100 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Mug</strong></li><li><strong>Personalized Certificate of Achievement</strong></li></ul><p><br></p><p>Don''t miss your chance to win these incredible prizes and gain recognition in the coding community. <a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb16/information" rel="noopener noreferrer" target="_blank"><strong>Register now</strong></a> and let the competition begin!</p>',
     '<ol><li>Participants must submit their solutions before the end time.</li><li>Participants must follow the contest rules and guidelines.</li><li>Participants must not cheat or plagiarize.</li></ol>',
     '<p><strong>Pre-determined Challenge Scores:</strong></p><p>Each challenge you conquer has a pre-set score waiting to be claimed. The more complex the challenge, the higher the score you can rack up!</p><p><br></p><p><strong>Test Cases: Your Gateway to Glory:</strong></p><p>Each challenge comes with a battery of test cases designed to put your code through its paces. Every test case you conquer translates into points towards your final score. The more test cases you dominate, the closer you get to scoring supremacy!</p><p><br></p><p><strong>Multiple Submissions? No Problem!</strong></p><p>Feeling creative and tinkering with different solutions? No sweat! We take your highest scoring submission for each challenge into account, so fire away with your best attempts.</p><p><br></p><p><strong>The Leaderboard Beckons: It''s All About the Rank</strong></p><p>Participants are ranked on the glorious leaderboard based on their total score. But what happens when coders achieve the same score? Buckle up, because things get exciting!</p><p><br></p><p><strong>Tie-Breaker Time: Speed Demons Unite!</strong></p><p>In the thrilling case of a tie, the tie-breaker comes down to <strong>speed</strong>. The participant who submitted their highest-scoring solution in the <strong>shortest amount of time</strong> reigns supreme! So, channel your inner coding ninja and blaze through those challenges for ultimate glory.</p>',
     'https://leetcode.com/_next/static/images/biweekly-default-f5a8fc3be85b6c9175207fd8fd855d47.png',
     CURRENT_TIMESTAMP + INTERVAL '1 hour 30 minutes',
     CURRENT_TIMESTAMP + INTERVAL '2 hours 30 minutes',
     'b029f559-52a8-4699-b595-71161498ed8c',
     'b029f559-52a8-4699-b595-71161498ed8c',
     true,
     null,
     true
    ),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb39',  'Senior Coding Contest',
     '<h3>Welcome to the Senior Coding Contest</h3><p><br></p><p>We are thrilled to present the inaugural CodeDynamite Weekly Contest, a premier event designed to challenge your coding skills and ignite your passion for programming. Whether you''re a seasoned developer or a coding enthusiast, this contest offers a unique opportunity to showcase your talents, compete with like-minded individuals, and win exciting prizes.</p><p><br></p><p><strong>About the contest:</strong></p><ul><li><strong>Sponsored by:</strong> CodeDynamite, your go-to platform for cutting-edge coding resources and community support.</li><li><strong>When:</strong> Every week, with fresh and exciting challenges that cater to various skill levels.</li><li><strong>Who Can Participate:</strong> Open to all coding enthusiasts, regardless of experience level.</li></ul><p><br></p><p><strong>Why Join?</strong></p><ul><li><strong>Challenge Yourself:</strong> Tackle a variety of coding problems that will test your creativity and problem-solving abilities.</li><li><strong>Learn and Grow:</strong> Gain new insights and improve your coding skills through hands-on practice and real-time competition.</li><li><strong>Win Prizes:</strong> Stand a chance to win amazing rewards and earn recognition within the coding community.</li></ul><p><br></p><p><strong>How to Register:</strong></p><ul><li>Simply click the registration link below and fill out the required details to secure your spot in the contest.</li><li>Registration is quick, easy, and free!</li></ul><p><br></p><p><strong>Don’t miss out on this fantastic opportunity to connect, compete, and code with the best!</strong></p><p><br></p><p><strong>Register for the contest now and let your coding journey begin!</strong></p><p><a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb39/information" rel="noopener noreferrer" target="_blank">Link to register</a></p><p><br></p><p><br></p>',
     '<p><strong>🎉 Juicy Prizes Await You! 🎉</strong></p><p><br></p><p>Get ready to win some amazing rewards in the 1st CodeDynamite Weekly Contest! Here are the fantastic prizes up for grabs:</p><p><br></p><p><strong>1st Place:</strong></p><ul><li><strong>$500 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite T-Shirt</strong></li><li><strong>Personalized Winner''s Certificate</strong></li></ul><p><br></p><p><strong>2nd Place:</strong></p><ul><li><strong>$250 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Hoodie</strong></li><li><strong>Personalized Runner-Up Certificate</strong></li></ul><p><br></p><p><strong>3rd Place:</strong></p><ul><li><strong>$100 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Mug</strong></li><li><strong>Personalized Certificate of Achievement</strong></li></ul><p><br></p><p>Don''t miss your chance to win these incredible prizes and gain recognition in the coding community. <a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb16/information" rel="noopener noreferrer" target="_blank"><strong>Register now</strong></a> and let the competition begin!</p>',
     '<ol><li>Participants must submit their solutions before the end time.</li><li>Participants must follow the contest rules and guidelines.</li><li>Participants must not cheat or plagiarize.</li></ol>',
     '<p><strong>Pre-determined Challenge Scores:</strong></p><p>Each challenge you conquer has a pre-set score waiting to be claimed. The more complex the challenge, the higher the score you can rack up!</p><p><br></p><p><strong>Test Cases: Your Gateway to Glory:</strong></p><p>Each challenge comes with a battery of test cases designed to put your code through its paces. Every test case you conquer translates into points towards your final score. The more test cases you dominate, the closer you get to scoring supremacy!</p><p><br></p><p><strong>Multiple Submissions? No Problem!</strong></p><p>Feeling creative and tinkering with different solutions? No sweat! We take your highest scoring submission for each challenge into account, so fire away with your best attempts.</p><p><br></p><p><strong>The Leaderboard Beckons: It''s All About the Rank</strong></p><p>Participants are ranked on the glorious leaderboard based on their total score. But what happens when coders achieve the same score? Buckle up, because things get exciting!</p><p><br></p><p><strong>Tie-Breaker Time: Speed Demons Unite!</strong></p><p>In the thrilling case of a tie, the tie-breaker comes down to <strong>speed</strong>. The participant who submitted their highest-scoring solution in the <strong>shortest amount of time</strong> reigns supreme! So, channel your inner coding ninja and blaze through those challenges for ultimate glory.</p>',
     'https://leetcode.com/_next/static/images/biweekly-default-f5a8fc3be85b6c9175207fd8fd855d47.png',
     CURRENT_TIMESTAMP + INTERVAL '2 hours',
     CURRENT_TIMESTAMP + INTERVAL '3 hours',
     'b029f559-52a8-4699-b595-71161498ed8c',
     'b029f559-52a8-4699-b595-71161498ed8c',
     true,
     null,
     true
    ),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb40',  'Tech Coding Contest',
     '<h3>Welcome to the Tech Coding Contest</h3><p><br></p><p>We are thrilled to present the inaugural CodeDynamite Weekly Contest, a premier event designed to challenge your coding skills and ignite your passion for programming. Whether you''re a seasoned developer or a coding enthusiast, this contest offers a unique opportunity to showcase your talents, compete with like-minded individuals, and win exciting prizes.</p><p><br></p><p><strong>About the contest:</strong></p><ul><li><strong>Sponsored by:</strong> CodeDynamite, your go-to platform for cutting-edge coding resources and community support.</li><li><strong>When:</strong> Every week, with fresh and exciting challenges that cater to various skill levels.</li><li><strong>Who Can Participate:</strong> Open to all coding enthusiasts, regardless of experience level.</li></ul><p><br></p><p><strong>Why Join?</strong></p><ul><li><strong>Challenge Yourself:</strong> Tackle a variety of coding problems that will test your creativity and problem-solving abilities.</li><li><strong>Learn and Grow:</strong> Gain new insights and improve your coding skills through hands-on practice and real-time competition.</li><li><strong>Win Prizes:</strong> Stand a chance to win amazing rewards and earn recognition within the coding community.</li></ul><p><br></p><p><strong>How to Register:</strong></p><ul><li>Simply click the registration link below and fill out the required details to secure your spot in the contest.</li><li>Registration is quick, easy, and free!</li></ul><p><br></p><p><strong>Don’t miss out on this fantastic opportunity to connect, compete, and code with the best!</strong></p><p><br></p><p><strong>Register for the contest now and let your coding journey begin!</strong></p><p><a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb40/information" rel="noopener noreferrer" target="_blank">Link to register</a></p><p><br></p><p><br></p>',
     '<p><strong>🎉 Juicy Prizes Await You! 🎉</strong></p><p><br></p><p>Get ready to win some amazing rewards in the 1st CodeDynamite Weekly Contest! Here are the fantastic prizes up for grabs:</p><p><br></p><p><strong>1st Place:</strong></p><ul><li><strong>$500 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite T-Shirt</strong></li><li><strong>Personalized Winner''s Certificate</strong></li></ul><p><br></p><p><strong>2nd Place:</strong></p><ul><li><strong>$250 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Hoodie</strong></li><li><strong>Personalized Runner-Up Certificate</strong></li></ul><p><br></p><p><strong>3rd Place:</strong></p><ul><li><strong>$100 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Mug</strong></li><li><strong>Personalized Certificate of Achievement</strong></li></ul><p><br></p><p>Don''t miss your chance to win these incredible prizes and gain recognition in the coding community. <a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb16/information" rel="noopener noreferrer" target="_blank"><strong>Register now</strong></a> and let the competition begin!</p>',
     '<ol><li>Participants must submit their solutions before the end time.</li><li>Participants must follow the contest rules and guidelines.</li><li>Participants must not cheat or plagiarize.</li></ol>',
     '<p><strong>Pre-determined Challenge Scores:</strong></p><p>Each challenge you conquer has a pre-set score waiting to be claimed. The more complex the challenge, the higher the score you can rack up!</p><p><br></p><p><strong>Test Cases: Your Gateway to Glory:</strong></p><p>Each challenge comes with a battery of test cases designed to put your code through its paces. Every test case you conquer translates into points towards your final score. The more test cases you dominate, the closer you get to scoring supremacy!</p><p><br></p><p><strong>Multiple Submissions? No Problem!</strong></p><p>Feeling creative and tinkering with different solutions? No sweat! We take your highest scoring submission for each challenge into account, so fire away with your best attempts.</p><p><br></p><p><strong>The Leaderboard Beckons: It''s All About the Rank</strong></p><p>Participants are ranked on the glorious leaderboard based on their total score. But what happens when coders achieve the same score? Buckle up, because things get exciting!</p><p><br></p><p><strong>Tie-Breaker Time: Speed Demons Unite!</strong></p><p>In the thrilling case of a tie, the tie-breaker comes down to <strong>speed</strong>. The participant who submitted their highest-scoring solution in the <strong>shortest amount of time</strong> reigns supreme! So, channel your inner coding ninja and blaze through those challenges for ultimate glory.</p>',
     'https://leetcode.com/_next/static/images/biweekly-default-f5a8fc3be85b6c9175207fd8fd855d47.png',
     CURRENT_TIMESTAMP + INTERVAL '2 hours 30 minutes',
     CURRENT_TIMESTAMP + INTERVAL '3 hours 30 minutes',
     'b029f559-52a8-4699-b595-71161498ed8c',
     'b029f559-52a8-4699-b595-71161498ed8c',
     true,
     null,
     true
    ),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb41',  'Code-A-Thon Contest',
     '<h3>Welcome to the Code-A-Thon Contest</h3><p><br></p><p>We are thrilled to present the inaugural CodeDynamite Weekly Contest, a premier event designed to challenge your coding skills and ignite your passion for programming. Whether you''re a seasoned developer or a coding enthusiast, this contest offers a unique opportunity to showcase your talents, compete with like-minded individuals, and win exciting prizes.</p><p><br></p><p><strong>About the contest:</strong></p><ul><li><strong>Sponsored by:</strong> CodeDynamite, your go-to platform for cutting-edge coding resources and community support.</li><li><strong>When:</strong> Every week, with fresh and exciting challenges that cater to various skill levels.</li><li><strong>Who Can Participate:</strong> Open to all coding enthusiasts, regardless of experience level.</li></ul><p><br></p><p><strong>Why Join?</strong></p><ul><li><strong>Challenge Yourself:</strong> Tackle a variety of coding problems that will test your creativity and problem-solving abilities.</li><li><strong>Learn and Grow:</strong> Gain new insights and improve your coding skills through hands-on practice and real-time competition.</li><li><strong>Win Prizes:</strong> Stand a chance to win amazing rewards and earn recognition within the coding community.</li></ul><p><br></p><p><strong>How to Register:</strong></p><ul><li>Simply click the registration link below and fill out the required details to secure your spot in the contest.</li><li>Registration is quick, easy, and free!</li></ul><p><br></p><p><strong>Don’t miss out on this fantastic opportunity to connect, compete, and code with the best!</strong></p><p><br></p><p><strong>Register for the contest now and let your coding journey begin!</strong></p><p><a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb41/information" rel="noopener noreferrer" target="_blank">Link to register</a></p><p><br></p><p><br></p>',
     '<p><strong>🎉 Juicy Prizes Await You! 🎉</strong></p><p><br></p><p>Get ready to win some amazing rewards in the 1st CodeDynamite Weekly Contest! Here are the fantastic prizes up for grabs:</p><p><br></p><p><strong>1st Place:</strong></p><ul><li><strong>$500 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite T-Shirt</strong></li><li><strong>Personalized Winner''s Certificate</strong></li></ul><p><br></p><p><strong>2nd Place:</strong></p><ul><li><strong>$250 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Hoodie</strong></li><li><strong>Personalized Runner-Up Certificate</strong></li></ul><p><br></p><p><strong>3rd Place:</strong></p><ul><li><strong>$100 Cash Prize</strong></li><li><strong>Exclusive CodeDynamite Mug</strong></li><li><strong>Personalized Certificate of Achievement</strong></li></ul><p><br></p><p>Don''t miss your chance to win these incredible prizes and gain recognition in the coding community. <a href="https://codedynamite.site/#/contests/d215b5f8-0249-4dc5-89a3-51fd148cfb16/information" rel="noopener noreferrer" target="_blank"><strong>Register now</strong></a> and let the competition begin!</p>',
     '<ol><li>Participants must submit their solutions before the end time.</li><li>Participants must follow the contest rules and guidelines.</li><li>Participants must not cheat or plagiarize.</li></ol>',
     '<p><strong>Pre-determined Challenge Scores:</strong></p><p>Each challenge you conquer has a pre-set score waiting to be claimed. The more complex the challenge, the higher the score you can rack up!</p><p><br></p><p><strong>Test Cases: Your Gateway to Glory:</strong></p><p>Each challenge comes with a battery of test cases designed to put your code through its paces. Every test case you conquer translates into points towards your final score. The more test cases you dominate, the closer you get to scoring supremacy!</p><p><br></p><p><strong>Multiple Submissions? No Problem!</strong></p><p>Feeling creative and tinkering with different solutions? No sweat! We take your highest scoring submission for each challenge into account, so fire away with your best attempts.</p><p><br></p><p><strong>The Leaderboard Beckons: It''s All About the Rank</strong></p><p>Participants are ranked on the glorious leaderboard based on their total score. But what happens when coders achieve the same score? Buckle up, because things get exciting!</p><p><br></p><p><strong>Tie-Breaker Time: Speed Demons Unite!</strong></p><p>In the thrilling case of a tie, the tie-breaker comes down to <strong>speed</strong>. The participant who submitted their highest-scoring solution in the <strong>shortest amount of time</strong> reigns supreme! So, channel your inner coding ninja and blaze through those challenges for ultimate glory.</p>',
     'https://leetcode.com/_next/static/images/biweekly-default-f5a8fc3be85b6c9175207fd8fd855d47.png',
     CURRENT_TIMESTAMP + INTERVAL '15 minutes',
     CURRENT_TIMESTAMP + INTERVAL '1 hours 15 minutes',
     'b029f559-52a8-4699-b595-71161498ed8c',
     'b029f559-52a8-4699-b595-71161498ed8c',
     true,
     null,
     true
    );

INSERT INTO public.contest_user(contest_id, user_id)
VALUES
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb15', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb15', 'b029f559-52a8-4699-b595-71161498ed8c'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb15', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb16', 'b029f559-52a8-4699-b595-71161498ed8c'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb16', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb16', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb16', 'cb2c22ac-87de-44e4-9638-35979f6af667'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb17', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb18', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb30', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb30', 'b029f559-52a8-4699-b595-71161498ed8c'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb30', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb31', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb31', 'b029f559-52a8-4699-b595-71161498ed8c'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb31', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb35', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb35', 'b029f559-52a8-4699-b595-71161498ed8c'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb35', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb38', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb38', 'b029f559-52a8-4699-b595-71161498ed8c'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb38', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb41', '9ba179ed-d26d-4828-a0f6-8836c2063992'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb41', 'b029f559-52a8-4699-b595-71161498ed8c'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb41', '8c98e9e1-a9e7-49ee-b9fd-0cb5bd7814f7');


-- Pick Random question type code from public.question and each contest will have at least 4 questions
INSERT INTO public.contest_question(contest_id, question_id)
VALUES
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb15', 'b6484e21-6937-489c-b031-b71767994221'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb15', 'b6484e21-6937-489c-b031-b71767994736'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb15', 'b6484e21-6937-489c-b031-b71767994737'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb15', 'b6484e21-6937-489c-b031-b71767994738'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb16', 'b6484e21-6937-489c-b031-b71767994739'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb16', 'b6484e21-6937-489c-b031-b71767994740'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb16', 'b6484e21-6937-489c-b031-b71767994741'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb16', 'b6484e21-6937-489c-b031-b71767994742'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb17', 'b6484e21-6937-489c-b031-b71767994743'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb17', 'b6484e21-6937-489c-b031-b71767994744'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb17', 'b6484e21-6937-489c-b031-b71767994745'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb17', 'b6484e21-6937-489c-b031-b71767994746'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb18', 'b6484e21-6937-489c-b031-b71767994747'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb18', 'b6484e21-6937-489c-b031-b71767994748'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb18', 'b6484e21-6937-489c-b031-b71767994749'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb18', 'b6484e21-6937-489c-b031-b71767994750'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb19', 'b6484e21-6937-489c-b031-b71767994754'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb19', 'b6484e21-6937-489c-b031-b71767994755'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb19', 'b6484e21-6937-489c-b031-b71767994756'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb19', 'b6484e21-6937-489c-b031-b71767994757'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb20', 'b6484e21-6937-489c-b031-b71767994755'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb20', 'b6484e21-6937-489c-b031-b71767994756'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb20', 'b6484e21-6937-489c-b031-b71767994757'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb20', 'b6484e21-6937-489c-b031-b71767994758'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb21', 'b6484e21-6937-489c-b031-b71767994759'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb21', 'b6484e21-6937-489c-b031-b71767994760'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb21', 'b6484e21-6937-489c-b031-b71767994761'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb21', 'b6484e21-6937-489c-b031-b71767994762'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb22', 'b6484e21-6937-489c-b031-b71767994763'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb22', 'b6484e21-6937-489c-b031-b71767994221'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb22', 'b6484e21-6937-489c-b031-b71767994736'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb22', 'b6484e21-6937-489c-b031-b71767994737'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb23', 'b6484e21-6937-489c-b031-b71767994738'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb23', 'b6484e21-6937-489c-b031-b71767994739'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb23', 'b6484e21-6937-489c-b031-b71767994740'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb23', 'b6484e21-6937-489c-b031-b71767994741'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb24', 'b6484e21-6937-489c-b031-b71767994742'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb24', 'b6484e21-6937-489c-b031-b71767994743'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb24', 'b6484e21-6937-489c-b031-b71767994744'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb24', 'b6484e21-6937-489c-b031-b71767994745'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb25', 'b6484e21-6937-489c-b031-b71767994746'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb25', 'b6484e21-6937-489c-b031-b71767994747'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb25', 'b6484e21-6937-489c-b031-b71767994748'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb25', 'b6484e21-6937-489c-b031-b71767994749'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb26', 'b6484e21-6937-489c-b031-b71767994750'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb26', 'b6484e21-6937-489c-b031-b71767994754'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb26', 'b6484e21-6937-489c-b031-b71767994755'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb26', 'b6484e21-6937-489c-b031-b71767994756'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb27', 'b6484e21-6937-489c-b031-b71767994754'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb27', 'b6484e21-6937-489c-b031-b71767994755'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb27', 'b6484e21-6937-489c-b031-b71767994756'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb27', 'b6484e21-6937-489c-b031-b71767994757'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb28', 'b6484e21-6937-489c-b031-b71767994758'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb28', 'b6484e21-6937-489c-b031-b71767994759'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb28', 'b6484e21-6937-489c-b031-b71767994760'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb28', 'b6484e21-6937-489c-b031-b71767994761'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb29', 'b6484e21-6937-489c-b031-b71767994762'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb29', 'b6484e21-6937-489c-b031-b71767994763'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb29', 'b6484e21-6937-489c-b031-b71767994221'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb29', 'b6484e21-6937-489c-b031-b71767994736'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb30', 'b6484e21-6937-489c-b031-b71767994221'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb30', 'b6484e21-6937-489c-b031-b71767994736'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb30', 'b6484e21-6937-489c-b031-b71767994737'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb30', 'b6484e21-6937-489c-b031-b71767994738'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb31', 'b6484e21-6937-489c-b031-b71767994739'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb31', 'b6484e21-6937-489c-b031-b71767994740'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb31', 'b6484e21-6937-489c-b031-b71767994741'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb31', 'b6484e21-6937-489c-b031-b71767994742'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb32', 'b6484e21-6937-489c-b031-b71767994743'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb32', 'b6484e21-6937-489c-b031-b71767994744'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb32', 'b6484e21-6937-489c-b031-b71767994745'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb32', 'b6484e21-6937-489c-b031-b71767994746'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb33', 'b6484e21-6937-489c-b031-b71767994747'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb33', 'b6484e21-6937-489c-b031-b71767994748'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb33', 'b6484e21-6937-489c-b031-b71767994749'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb33', 'b6484e21-6937-489c-b031-b71767994750'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb34', 'b6484e21-6937-489c-b031-b71767994754'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb34', 'b6484e21-6937-489c-b031-b71767994755'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb34', 'b6484e21-6937-489c-b031-b71767994756'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb34', 'b6484e21-6937-489c-b031-b71767994757'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb35', 'b6484e21-6937-489c-b031-b71767994755'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb35', 'b6484e21-6937-489c-b031-b71767994756'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb35', 'b6484e21-6937-489c-b031-b71767994757'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb35', 'b6484e21-6937-489c-b031-b71767994758'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb36', 'b6484e21-6937-489c-b031-b71767994759'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb36', 'b6484e21-6937-489c-b031-b71767994760'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb36', 'b6484e21-6937-489c-b031-b71767994761'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb36', 'b6484e21-6937-489c-b031-b71767994762'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb37', 'b6484e21-6937-489c-b031-b71767994763'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb37', 'b6484e21-6937-489c-b031-b71767994221'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb37', 'b6484e21-6937-489c-b031-b71767994736'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb37', 'b6484e21-6937-489c-b031-b71767994737'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb38', 'b6484e21-6937-489c-b031-b71767994738'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb38', 'b6484e21-6937-489c-b031-b71767994739'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb38', 'b6484e21-6937-489c-b031-b71767994740'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb38', 'b6484e21-6937-489c-b031-b71767994741'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb39', 'b6484e21-6937-489c-b031-b71767994742'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb39', 'b6484e21-6937-489c-b031-b71767994743'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb39', 'b6484e21-6937-489c-b031-b71767994744'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb39', 'b6484e21-6937-489c-b031-b71767994745'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb40', 'b6484e21-6937-489c-b031-b71767994746'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb40', 'b6484e21-6937-489c-b031-b71767994747'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb40', 'b6484e21-6937-489c-b031-b71767994748'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb40', 'b6484e21-6937-489c-b031-b71767994749'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb41', 'b6484e21-6937-489c-b031-b71767994750'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb41', 'b6484e21-6937-489c-b031-b71767994754'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb41', 'b6484e21-6937-489c-b031-b71767994755'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb41', 'b6484e21-6937-489c-b031-b71767994756');


INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank)
VALUES('20d06a81-f597-41bc-a60c-480d5c38eb80'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Câu 1', '<p><span style="color: rgb(51, 51, 51);">Hãy cho biết ý tưởng nào sau đây nói về phương pháp sắp xếp chọn tăng dần (select sort)?</span></p>', '', 1.00, 'MULTIPLE_CHOICE'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATED'::public."copystate", '2024-06-20 21:22:31.589', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-06-20 21:22:31.589', NULL, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank)
VALUES('82a72f33-69d1-417a-bc4a-54e4a3f42a06'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Câu 2', '<h4><a href="https://khoahoc.vietjack.com/question/958165/phuong-phap-nao-sau-day-chinh-la-phuong-phap-sap-xep-nhanh-quick-sort" rel="noopener noreferrer" target="_blank" style="color: rgb(0, 0, 0); background-color: transparent;">Phương pháp nào sau đây chính là phương pháp sắp xếp nhanh (Quick sort)?</a></h4><p><br></p>', '', 1.00, 'MULTIPLE_CHOICE'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATED'::public."copystate", '2024-06-20 21:24:16.622', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-06-20 21:24:16.622', NULL, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank)
VALUES('fe65d7df-69ac-4a17-805c-f1f2b65b9972'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Câu 3', '<h4><a href="https://khoahoc.vietjack.com/question/958164/hay-cho-biet-y-tuong-nao-sau-day-noi-ve-phuong-phap-sap-xep-nhanh-quick-sort" rel="noopener noreferrer" target="_blank" style="color: rgb(0, 0, 0); background-color: transparent;">Hãy cho biết ý tưởng nào sau đây nói về phương pháp sắp xếp nhanh (Quick sort)?</a></h4><p><br></p>', '', 1.00, 'MULTIPLE_CHOICE'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATED'::public."copystate", '2024-06-20 21:25:55.996', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-06-20 21:25:55.996', NULL, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank)
VALUES('53ce35a7-9dcf-4741-a4ed-872874daf829'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Câu 4', '<p><a href="https://vietjack.online/cau-hoi/958554/giai-thuat-de-quy-la-a-trong-giai-thuat-cua-no-co-loi-goi-toi-chinh-no" rel="noopener noreferrer" target="_blank" style="color: rgb(0, 0, 0); background-color: transparent;">Giải thuật đệ quy là:</a></p>', '', 1.00, 'MULTIPLE_CHOICE'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATED'::public."copystate", '2024-06-20 21:28:16.197', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-06-20 21:28:16.197', NULL, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank)
VALUES('0fe5d2ee-6892-4f62-a6e6-83284f2430bc'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Câu 5', '<p>QUEUE hoạt động như thế nào?</p>', '', 1.00, 'SHORT_ANSWER'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATED'::public."copystate", '2024-06-20 21:29:18.256', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-06-20 21:29:18.256', NULL, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank)
VALUES('513a7e58-00d0-450b-8f0d-78af23898b81'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Câu 6', '<p>Sinh viên IT mới ra trường lương nghìn $ ?</p>', '', 1.00, 'TRUE_FALSE'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATED'::public."copystate", '2024-06-20 21:30:29.529', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-06-20 21:30:29.529', NULL, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank)
VALUES('1168fba1-8391-4294-b1cb-2c108f96af1f'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Câu 7', '<p>Trường HCMUS top 1 IT?</p>', '', 1.00, 'TRUE_FALSE'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATED'::public."copystate", '2024-06-20 21:31:55.692', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-06-20 21:31:55.692', NULL, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank)
VALUES('c4b3219f-9d83-4497-ad15-d46772141bd5'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Câu 8', '<p>STACK hoạt động như nào?</p>', '', 1.00, 'SHORT_ANSWER'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATED'::public."copystate", '2024-06-20 21:33:16.328', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-06-20 21:33:16.328', NULL, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank)
VALUES('29a71c20-290b-471d-acc8-4c5c929f96a8'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Câu 9', '<p>Đầu vào trường Ú rất dễ?</p>', '', 1.00, 'TRUE_FALSE'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATED'::public."copystate", '2024-06-20 21:34:55.796', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-06-20 21:34:55.796', NULL, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank)
VALUES('1ca8c89a-1bd0-41b2-adf0-4f7b55f8b256'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Câu 10', '<p>Thầy cô trường Ú dễ thương</p>', '', 1.00, 'TRUE_FALSE'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATED'::public."copystate", '2024-06-20 21:35:23.054', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-06-20 21:35:23.054', NULL, false);


INSERT INTO public.qtype_multichoice_question
(id, question_id, single, shuffle_answers, correct_feedback, partially_correct_feedback, incorrect_feedback, answer_numbering, show_num_correct, show_standard_instruction)
VALUES('43455ada-fee6-4da7-b688-9a044662609f'::uuid, '20d06a81-f597-41bc-a60c-480d5c38eb80'::uuid, true, true, '', NULL, '', 'abc', 1, '1');
INSERT INTO public.qtype_multichoice_question
(id, question_id, single, shuffle_answers, correct_feedback, partially_correct_feedback, incorrect_feedback, answer_numbering, show_num_correct, show_standard_instruction)
VALUES('f6a3859e-a5b7-4f57-83a1-62bd1d4af10f'::uuid, '82a72f33-69d1-417a-bc4a-54e4a3f42a06'::uuid, true, true, '', NULL, '', 'abc', 1, '1');
INSERT INTO public.qtype_multichoice_question
(id, question_id, single, shuffle_answers, correct_feedback, partially_correct_feedback, incorrect_feedback, answer_numbering, show_num_correct, show_standard_instruction)
VALUES('a2e49b15-fd74-4911-aa70-bee57cfca69c'::uuid, 'fe65d7df-69ac-4a17-805c-f1f2b65b9972'::uuid, true, true, '', NULL, '', 'abc', 1, '1');
INSERT INTO public.qtype_multichoice_question
(id, question_id, single, shuffle_answers, correct_feedback, partially_correct_feedback, incorrect_feedback, answer_numbering, show_num_correct, show_standard_instruction)
VALUES('ff9dbd27-698c-438a-bb4d-9572c845e521'::uuid, '53ce35a7-9dcf-4741-a4ed-872874daf829'::uuid, true, true, '', NULL, '', 'abc', 1, '1');
INSERT INTO public.qtype_multichoice_question
(id, question_id, single, shuffle_answers, correct_feedback, partially_correct_feedback, incorrect_feedback, answer_numbering, show_num_correct, show_standard_instruction)
VALUES('5dd4f23a-e2eb-4dc4-96a1-07285d57a37d'::uuid, '513a7e58-00d0-450b-8f0d-78af23898b81'::uuid, true, false, '', NULL, '', NULL, 1, '1');
INSERT INTO public.qtype_multichoice_question
(id, question_id, single, shuffle_answers, correct_feedback, partially_correct_feedback, incorrect_feedback, answer_numbering, show_num_correct, show_standard_instruction)
VALUES('3e9bb601-6109-4a20-b529-1a070282e47f'::uuid, '1168fba1-8391-4294-b1cb-2c108f96af1f'::uuid, true, false, '', NULL, '', NULL, 1, '1');
INSERT INTO public.qtype_multichoice_question
(id, question_id, single, shuffle_answers, correct_feedback, partially_correct_feedback, incorrect_feedback, answer_numbering, show_num_correct, show_standard_instruction)
VALUES('0feadb2c-9dfd-4ebb-8a75-beb9d9eed408'::uuid, '29a71c20-290b-471d-acc8-4c5c929f96a8'::uuid, true, false, '', NULL, '', NULL, 1, '1');
INSERT INTO public.qtype_multichoice_question
(id, question_id, single, shuffle_answers, correct_feedback, partially_correct_feedback, incorrect_feedback, answer_numbering, show_num_correct, show_standard_instruction)
VALUES('400a2f4d-c880-4e00-94be-d4b4afebccbd'::uuid, '1ca8c89a-1bd0-41b2-adf0-4f7b55f8b256'::uuid, true, false, '', NULL, '', NULL, 1, '1');

INSERT INTO public.qtype_shortanswer_question
(id, question_id, case_sensitive)
VALUES('fa860cec-afa7-4b4d-948c-d8ab1d5a384e'::uuid, '0fe5d2ee-6892-4f62-a6e6-83284f2430bc'::uuid, true);
INSERT INTO public.qtype_shortanswer_question
(id, question_id, case_sensitive)
VALUES('78d62d6f-e323-4a40-bdaf-31b352227f29'::uuid, 'c4b3219f-9d83-4497-ad15-d46772141bd5'::uuid, true);

INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('f13af228-9d17-45b1-b3e5-7a34f590b145'::uuid, '20d06a81-f597-41bc-a60c-480d5c38eb80'::uuid, '<p><span style="color: rgb(63, 63, 63);">Phân đoạn dãy thành nhiều dãy con và lần lượt trộn hai dãy con thành dãy lớn hơn, cho đến khi thu được dãy ban đầu đã được sắp xếp</span></p>', '<p><span style="color: rgb(63, 63, 63);">Phân đoạn dãy thành nhiều dãy con và lần lượt trộn hai dãy con thành dãy lớn hơn, cho đến khi thu được dãy ban đầu đã được sắp xếp</span></p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('da47f572-a86b-4250-9596-fabf92ffb150'::uuid, '20d06a81-f597-41bc-a60c-480d5c38eb80'::uuid, '<p><span style="color: rgb(63, 63, 63);">Lần lượt lấy phần tử của danh sách chèn vị trí thích hợp của nó trong dãy</span></p>', '<p><span style="color: rgb(63, 63, 63);">Lần lượt lấy phần tử của danh sách chèn vị trí thích hợp của nó trong dãy</span></p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('20ba7b11-9b6a-48d6-96e5-5b49a4127bf7'::uuid, '20d06a81-f597-41bc-a60c-480d5c38eb80'::uuid, '<p><span style="color: rgb(63, 63, 63);">Chọn phần tử bé nhất xếp vào vị trí thứ nhất bằng cách đổi chổ phần tử bé nhất với phần tử thứ nhất; Tương tự đối với phần tử nhỏ thứ hai cho đến phần tử cuối cùng</span></p>', '<p><span style="color: rgb(63, 63, 63);">Chọn phần tử bé nhất xếp vào vị trí thứ nhất bằng cách đổi chổ phần tử bé nhất với phần tử thứ nhất; Tương tự đối với phần tử nhỏ thứ hai cho đến phần tử cuối cùng</span></p>', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('797744cf-8e04-486c-a3ef-778b71ab4303'::uuid, '20d06a81-f597-41bc-a60c-480d5c38eb80'::uuid, '<p><span style="color: rgb(63, 63, 63);">Bắt đầu từ cuối dãy đến đầu dãy, ta lần lượt so sánh hai phần tử kế tiếp nhau, nếu phần tử nào bé hơn được cho lên vị trí trên</span></p>', '<p><span style="color: rgb(63, 63, 63);">Bắt đầu từ cuối dãy đến đầu dãy, ta lần lượt so sánh hai phần tử kế tiếp nhau, nếu phần tử nào bé hơn được cho lên vị trí trên</span></p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('c057f9a7-29f2-4510-bda6-20282e084548'::uuid, '82a72f33-69d1-417a-bc4a-54e4a3f42a06'::uuid, '<p><span style="color: rgb(63, 63, 63);">Phương phap trộn</span></p>', '<p><span style="color: rgb(63, 63, 63);">Phương phap trộn</span></p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('73dce995-e874-4839-a4ed-b024534adb68'::uuid, '82a72f33-69d1-417a-bc4a-54e4a3f42a06'::uuid, '<p><span style="color: rgb(63, 63, 63);">Phương pháp vun đống</span></p>', '<p><span style="color: rgb(63, 63, 63);">Phương pháp vun đống</span></p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('b35e54ea-7b0d-4ed6-a1e5-3a24c1296670'::uuid, '82a72f33-69d1-417a-bc4a-54e4a3f42a06'::uuid, '<p><span style="color: rgb(63, 63, 63);">Phương pháp chèn</span></p>', '<p><span style="color: rgb(63, 63, 63);">Phương pháp chèn</span></p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('1350a0b1-43c6-43c5-a9e1-34bce3e6759e'::uuid, '82a72f33-69d1-417a-bc4a-54e4a3f42a06'::uuid, '<p><span style="color: rgb(63, 63, 63);">Phương pháp phân đoạn</span></p>', '<p><span style="color: rgb(63, 63, 63);">Phương pháp phân đoạn</span></p>', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('d64eda1d-8a47-4d01-9396-2362d55621d5'::uuid, 'fe65d7df-69ac-4a17-805c-f1f2b65b9972'::uuid, '<p><span style="color: rgb(63, 63, 63);">Chọn phần tử bé nhất xếp vào vị trí thứ nhất bằng cách đổi chổ phần tử bé nhất với phần tử thứ nhất; Tương tự đối với phần tử nhỏ thứ hai cho đến phần tử cuối cùng</span></p>', '<p><span style="color: rgb(63, 63, 63);">Chọn phần tử bé nhất xếp vào vị trí thứ nhất bằng cách đổi chổ phần tử bé nhất với phần tử thứ nhất; Tương tự đối với phần tử nhỏ thứ hai cho đến phần tử cuối cùng</span></p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('a0444c51-ede9-4c42-a821-e9e3b6124761'::uuid, 'fe65d7df-69ac-4a17-805c-f1f2b65b9972'::uuid, '<p><span style="color: rgb(63, 63, 63);">Bắt đầu từ cuối dãy đến đầu dãy, ta lần lượt so sánh hai phần tử kế tiếpnh u, nếu phần tử nào nhỏ hơn được đứng vị trí trên</span></p>', '<p><span style="color: rgb(63, 63, 63);">Bắt đầu từ cuối dãy đến đầu dãy, ta lần lượt so sánh hai phần tử kế tiếpnh u, nếu phần tử nào nhỏ hơn được đứng vị trí trên</span></p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('ca665a4c-0f11-4144-9f52-025fd9887870'::uuid, 'fe65d7df-69ac-4a17-805c-f1f2b65b9972'::uuid, '<p><span style="color: rgb(63, 63, 63);">Phân đoạn dãy thành nhiều dãy con và lần lượt trộn hai dãy con thành dãy lớn hơn, cho đến khi thu được dãy ban đầu đã được sắp xếp</span></p>', '<p><span style="color: rgb(63, 63, 63);">Phân đoạn dãy thành nhiều dãy con và lần lượt trộn hai dãy con thành dãy lớn hơn, cho đến khi thu được dãy ban đầu đã được sắp xếp</span></p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('e7a9f1de-b7bb-48d4-a7d9-c41c805c112a'::uuid, 'fe65d7df-69ac-4a17-805c-f1f2b65b9972'::uuid, '<p><span style="color: rgb(63, 63, 63);">Lần lượt chia dãy phần tử thành hai dãy con bởi một phần tử khoá (dãy con trước khoá gồm các phần tử nhỏ hơn khoá và dãy còn lại gồm các phần tử lớn hơn khoá)</span></p>', '<p><span style="color: rgb(63, 63, 63);">Lần lượt chia dãy phần tử thành hai dãy con bởi một phần tử khoá (dãy con trước khoá gồm các phần tử nhỏ hơn khoá và dãy còn lại gồm các phần tử lớn hơn khoá)</span></p>', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('7d39a4d4-a392-4929-9e0f-9317aa079a89'::uuid, '53ce35a7-9dcf-4741-a4ed-872874daf829'::uuid, '<p><span style="color: rgb(63, 63, 63);">Trong giải thuật của nó có lời gọi tới chính nó</span></p>', '<p><span style="color: rgb(63, 63, 63);">Trong giải thuật của nó có lời gọi tới chính nó</span></p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('b8eb7450-9483-4b7f-a42c-a74c13db3842'::uuid, '53ce35a7-9dcf-4741-a4ed-872874daf829'::uuid, '<p><span style="color: rgb(63, 63, 63);">Trong giải thuật của nó có lời gọi tới chính nó nhưng với phạm vi lớn hơn</span></p>', '<p><span style="color: rgb(63, 63, 63);">Trong giải thuật của nó có lời gọi tới chính nó nhưng với phạm vi lớn hơn</span></p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('085c69a6-858c-4c79-aa19-2308f04844ce'::uuid, '53ce35a7-9dcf-4741-a4ed-872874daf829'::uuid, '<p><span style="color: rgb(63, 63, 63);">Trong giải thuật của nó có lời gọi tới chính nó nhưng với phạm vi nhỏ hơn</span></p>', '<p><span style="color: rgb(63, 63, 63);">Trong giải thuật của nó có lời gọi tới chính nó nhưng với phạm vi nhỏ hơn</span></p>', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('8b9b49af-f8da-4df7-b1dc-039dc7d94e2a'::uuid, '53ce35a7-9dcf-4741-a4ed-872874daf829'::uuid, '<p><span style="color: rgb(63, 63, 63);">Trong giải thuật của nó có lời gọi tới một giải thuật khác đã biết kết quả</span></p>', '<p><span style="color: rgb(63, 63, 63);">Trong giải thuật của nó có lời gọi tới một giải thuật khác đã biết kết quả</span></p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('ee0be7d0-c592-4e40-8bba-871b6c9f7272'::uuid, '0fe5d2ee-6892-4f62-a6e6-83284f2430bc'::uuid, '<p>FILO</p>', 'FILO', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('c791aa62-c177-45de-b015-44b0679654d2'::uuid, '513a7e58-00d0-450b-8f0d-78af23898b81'::uuid, 'Correct', 'true', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('80c171ab-25c9-4371-ae3d-f6de0b36c505'::uuid, '1168fba1-8391-4294-b1cb-2c108f96af1f'::uuid, 'Correct', 'true', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('b06ddec2-cbe0-4488-8cde-228c55e43a26'::uuid, 'c4b3219f-9d83-4497-ad15-d46772141bd5'::uuid, '<p>FIFO</p>', 'FIFO', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('022472ef-31ab-4876-8509-8f1108ae9dbb'::uuid, '29a71c20-290b-471d-acc8-4c5c929f96a8'::uuid, 'Correct', 'true', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('c85f2ef4-5cb6-4e4a-a8d0-01947ae1007e'::uuid, '1ca8c89a-1bd0-41b2-adf0-4f7b55f8b256'::uuid, 'Correct', 'true', 1.00);
------------------
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank, is_lecturer_private)
VALUES('98abb4e8-94d6-41dc-a960-2f18438ce77d'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Mạng máy tính là gì?', '<p>Mạng máy tính là gì?</p>', '', 1.00, 'ESSAY'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATING'::public."copystate", '2024-07-16 21:09:31.287', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-07-16 21:09:31.287', '94f340b3-fb05-4e3a-8cb5-44ef5d936a9b'::uuid, true, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank, is_lecturer_private)
VALUES('fe7f0a71-d3c5-4d2b-be25-2faff42c6b5c'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Router có chức năng gì trong mạng máy tính?', '<p>Router có chức năng gì trong mạng máy tính?</p>', '', 1.00, 'SHORT_ANSWER'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATED'::public."copystate", '2024-07-16 21:09:58.782', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-07-16 21:09:58.782', '94f340b3-fb05-4e3a-8cb5-44ef5d936a9b'::uuid, true, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank, is_lecturer_private)
VALUES('e64fc118-1ae3-413d-9524-3e1dd1702ab5'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Giao thức nào sau đây thường được sử dụng cho truyền thông trong mạng Internet?', '<p>Giao thức nào sau đây thường được sử dụng cho truyền thông trong mạng Internet?</p>', '', 1.00, 'MULTIPLE_CHOICE'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATED'::public."copystate", '2024-07-16 21:10:58.079', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-07-16 21:10:58.079', '94f340b3-fb05-4e3a-8cb5-44ef5d936a9b'::uuid, true, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank, is_lecturer_private)
VALUES('c434f3a9-986e-4522-bbdc-d9c58e0380ed'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Thiết bị nào được sử dụng để kết nối các thiết bị trong một mạng cục bộ (LAN)?', '<p>Thiết bị nào được sử dụng để kết nối các thiết bị trong một mạng cục bộ (LAN)?</p>', '', 1.00, 'MULTIPLE_CHOICE'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATED'::public."copystate", '2024-07-16 21:12:26.553', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-07-16 21:12:26.553', '94f340b3-fb05-4e3a-8cb5-44ef5d936a9b'::uuid, true, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank, is_lecturer_private)
VALUES('514843c5-8814-4406-af5c-9bf55fdf9ec8'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'IP (Internet Protocol) là một giao thức thuộc tầng 4 trong mô hình OSI.', '<p>IP (Internet Protocol) là một giao thức thuộc tầng 4 trong mô hình OSI.</p>', '', 1.00, 'TRUE_FALSE'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATED'::public."copystate", '2024-07-16 21:12:49.093', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-07-16 21:12:49.093', '94f340b3-fb05-4e3a-8cb5-44ef5d936a9b'::uuid, true, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank, is_lecturer_private)
VALUES('c5e675a1-50a3-400c-a232-968413d0ebf2'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Trong lập trình hướng đối tượng, phương thức khởi tạo (constructor) không thể bị ghi đè (override).', '<p>Trong lập trình hướng đối tượng, phương thức khởi tạo (constructor) không thể bị ghi đè (override).</p>', '', 1.00, 'TRUE_FALSE'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATED'::public."copystate", '2024-07-16 21:22:13.306', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-07-16 21:22:13.306', 'a69c5276-4f35-469d-94b1-b2df3f3f2707'::uuid, true, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank, is_lecturer_private)
VALUES('e3ac5475-462e-457a-9e00-f37a6217135c'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'DNS (Domain Name System) giúp ánh xạ tên miền thành địa chỉ IP.', '<p>DNS (Domain Name System) giúp ánh xạ tên miền thành địa chỉ IP.</p>', '', 1.00, 'TRUE_FALSE'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATED'::public."copystate", '2024-07-16 21:13:06.524', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-07-16 21:13:06.524', '94f340b3-fb05-4e3a-8cb5-44ef5d936a9b'::uuid, true, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank, is_lecturer_private)
VALUES('4a8afa92-ad7c-4bd4-8bfc-d699f616a80d'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Mạng LAN (Local Area Network) chỉ hoạt động trong phạm vi nhỏ như một phòng hoặc tòa nhà.', '<p>Mạng LAN (Local Area Network) chỉ hoạt động trong phạm vi nhỏ như một phòng hoặc tòa nhà.</p>', '', 1.00, 'TRUE_FALSE'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATED'::public."copystate", '2024-07-16 21:15:02.085', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-07-16 21:15:02.085', '94f340b3-fb05-4e3a-8cb5-44ef5d936a9b'::uuid, true, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank, is_lecturer_private)
VALUES('1592dc84-c95f-45d6-9a65-6c1ac5e2e413'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Tất cả các thiết bị mạng đều phải sử dụng cáp để kết nối với nhau.', '<p>Tất cả các thiết bị mạng đều phải sử dụng cáp để kết nối với nhau.</p>', '', 1.00, 'TRUE_FALSE'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATED'::public."copystate", '2024-07-16 21:15:24.385', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-07-16 21:15:24.385', '94f340b3-fb05-4e3a-8cb5-44ef5d936a9b'::uuid, true, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank, is_lecturer_private)
VALUES('f6a71b52-bf17-4ac0-b736-fb609e8f84d9'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Lập trình hướng đối tượng là gì?', '<p>Lập trình hướng đối tượng là gì?</p>', '', 1.00, 'ESSAY'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATING'::public."copystate", '2024-07-16 21:18:53.851', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-07-16 21:18:53.851', 'a69c5276-4f35-469d-94b1-b2df3f3f2707'::uuid, true, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank, is_lecturer_private)
VALUES('9de30d16-41ac-4451-9947-2b2088dd6afa'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Đóng gói (encapsulation) là gì?', '<p>Đóng gói (encapsulation) là gì?</p>', '', 1.00, 'SHORT_ANSWER'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATED'::public."copystate", '2024-07-16 21:19:20.751', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-07-16 21:19:20.751', 'a69c5276-4f35-469d-94b1-b2df3f3f2707'::uuid, true, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank, is_lecturer_private)
VALUES('8de957d4-92df-4f94-997b-1e1275afdc2f'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Khái niệm nào sau đây không thuộc về lập trình hướng đối tượng?', '<p>Khái niệm nào sau đây không thuộc về lập trình hướng đối tượng?</p>', '', 1.00, 'MULTIPLE_CHOICE'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATED'::public."copystate", '2024-07-16 21:20:18.417', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-07-16 21:20:18.417', 'a69c5276-4f35-469d-94b1-b2df3f3f2707'::uuid, true, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank, is_lecturer_private)
VALUES('b387b570-5b99-4f82-83be-292c969db99f'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Tính chất nào của lập trình hướng đối tượng cho phép một lớp con kế thừa các thuộc tính và phương thức từ lớp cha?', '<p>Tính chất nào của lập trình hướng đối tượng cho phép một lớp con kế thừa các thuộc tính và phương thức từ lớp cha?</p>', '', 1.00, 'MULTIPLE_CHOICE'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATED'::public."copystate", '2024-07-16 21:21:16.834', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-07-16 21:21:16.834', 'a69c5276-4f35-469d-94b1-b2df3f3f2707'::uuid, true, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank, is_lecturer_private)
VALUES('4fa387a6-db86-48bb-85f4-fcbb43c8eeb0'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Lớp trừu tượng (Abstract class) không thể tạo được đối tượng trực tiếp.', '<p>Lớp trừu tượng (Abstract class) không thể tạo được đối tượng trực tiếp.</p>', '', 1.00, 'TRUE_FALSE'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATED'::public."copystate", '2024-07-16 21:21:41.464', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-07-16 21:21:41.464', 'a69c5276-4f35-469d-94b1-b2df3f3f2707'::uuid, true, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank, is_lecturer_private)
VALUES('b48fbf09-4b3f-4def-bfb8-4cfb65da1f27'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Một lớp con có thể kế thừa nhiều lớp cha trong ngôn ngữ lập trình Java.', '<p>Một lớp con có thể kế thừa nhiều lớp cha trong ngôn ngữ lập trình Java.</p>', '', 1.00, 'TRUE_FALSE'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATED'::public."copystate", '2024-07-16 21:21:56.766', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-07-16 21:21:56.766', 'a69c5276-4f35-469d-94b1-b2df3f3f2707'::uuid, true, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank, is_lecturer_private)
VALUES('306eaa8b-4054-4ad7-b6ed-b847a2d53b63'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Interface chỉ định nghĩa các phương thức nhưng không cung cấp hiện thực của chúng.', '<p>Interface chỉ định nghĩa các phương thức nhưng không cung cấp hiện thực của chúng.</p>', '', 1.00, 'TRUE_FALSE'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATED'::public."copystate", '2024-07-16 21:22:27.538', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-07-16 21:22:27.538', 'a69c5276-4f35-469d-94b1-b2df3f3f2707'::uuid, true, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank, is_lecturer_private)
VALUES('18fe1f1b-2d67-4bfa-bdfe-a19fe4daa665'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Cấu trúc dữ liệu là gì?', '<p>Cấu trúc dữ liệu là gì?</p>', '', 1.00, 'ESSAY'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATING'::public."copystate", '2024-07-16 21:23:11.989', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-07-16 21:23:11.989', 'd8fed7b0-bd98-436e-9c4d-36b8fe9f372e'::uuid, true, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank, is_lecturer_private)
VALUES('1f0daa04-6462-4eb5-9fc4-883f68e78b7c'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Giải thuật (thuật toán) là gì?', '<p>Giải thuật (thuật toán) là gì?</p>', '', 1.00, 'SHORT_ANSWER'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATED'::public."copystate", '2024-07-16 21:23:38.839', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-07-16 21:23:38.839', 'd8fed7b0-bd98-436e-9c4d-36b8fe9f372e'::uuid, true, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank, is_lecturer_private)
VALUES('1c054e46-a127-448d-a6a8-8c9be65cfded'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Cấu trúc dữ liệu nào sau đây là một dạng danh sách liên kết mà mỗi phần tử chứa một con trỏ đến phần tử tiếp theo và phần tử trước đó?', '<p>Cấu trúc dữ liệu nào sau đây là một dạng danh sách liên kết mà mỗi phần tử chứa một con trỏ đến phần tử tiếp theo và phần tử trước đó?</p>', '', 1.00, 'MULTIPLE_CHOICE'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATED'::public."copystate", '2024-07-16 21:24:30.034', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-07-16 21:24:30.034', 'd8fed7b0-bd98-436e-9c4d-36b8fe9f372e'::uuid, true, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank, is_lecturer_private)
VALUES('c88dfd4d-b102-4412-9127-17d68ec3a5e1'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Giải thuật tìm kiếm nhị phân yêu cầu cấu trúc dữ liệu đầu vào phải là gì?', '<p>Giải thuật tìm kiếm nhị phân yêu cầu cấu trúc dữ liệu đầu vào phải là gì?</p>', '', 1.00, 'MULTIPLE_CHOICE'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATED'::public."copystate", '2024-07-16 21:25:38.278', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-07-16 21:25:38.278', 'd8fed7b0-bd98-436e-9c4d-36b8fe9f372e'::uuid, true, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank, is_lecturer_private)
VALUES('eb74ae25-bfd1-4c3c-8d19-f29872f6b858'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Stack là một cấu trúc dữ liệu theo nguyên tắc LIFO (Last In, First Out).', '<p>Stack là một cấu trúc dữ liệu theo nguyên tắc LIFO (Last In, First Out).</p>', '', 1.00, 'TRUE_FALSE'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATED'::public."copystate", '2024-07-16 21:26:02.766', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-07-16 21:26:02.766', 'd8fed7b0-bd98-436e-9c4d-36b8fe9f372e'::uuid, true, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank, is_lecturer_private)
VALUES('9002af16-7252-421a-b8ab-c0f4944a1e89'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Độ phức tạp thời gian trung bình của giải thuật tìm kiếm nhị phân là O(n).', '<p>Độ phức tạp thời gian trung bình của giải thuật tìm kiếm nhị phân là O(n).</p>', '', 1.00, 'TRUE_FALSE'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATED'::public."copystate", '2024-07-16 21:26:48.714', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-07-16 21:26:48.714', 'd8fed7b0-bd98-436e-9c4d-36b8fe9f372e'::uuid, true, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank, is_lecturer_private)
VALUES('a411cc44-f924-445c-bd00-f605f7533dcf'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Độ phức tạp thời gian trung bình của giải thuật sắp xếp Quick Sort là O(n log n).', '<p>Độ phức tạp thời gian trung bình của giải thuật sắp xếp Quick Sort là O(n log n).</p>', '', 1.00, 'TRUE_FALSE'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATED'::public."copystate", '2024-07-16 21:27:05.722', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-07-16 21:27:05.722', 'd8fed7b0-bd98-436e-9c4d-36b8fe9f372e'::uuid, true, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank, is_lecturer_private)
VALUES('05d5cd7c-968b-49a6-acf3-c839f2d04243'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Trong cấu trúc dữ liệu Heap, phần tử lớn nhất luôn nằm ở gốc (root) trong một Max Heap.', '<p>Trong cấu trúc dữ liệu Heap, phần tử lớn nhất luôn nằm ở gốc (root) trong một Max Heap.</p>', '', 1.00, 'TRUE_FALSE'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATED'::public."copystate", '2024-07-16 21:27:23.647', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-07-16 21:27:23.647', 'd8fed7b0-bd98-436e-9c4d-36b8fe9f372e'::uuid, true, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank, is_lecturer_private)
VALUES('fd98f388-0b73-45ec-803f-d27a14773ac6'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Sự khác nhau chính giữa C và C++ là gì?', '<p>Sự khác nhau chính giữa C và C++ là gì?</p>', '', 1.00, 'ESSAY'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATING'::public."copystate", '2024-07-16 21:28:23.112', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-07-16 21:28:23.112', 'a54cf2f7-294c-4b1a-a8c7-6e8c34fb5f51'::uuid, false, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank, is_lecturer_private)
VALUES('4faf36f7-aa0b-43db-b830-aff5c0337996'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Con trỏ (pointer) trong C/C++ là gì?', '<p>Con trỏ (pointer) trong C/C++ là gì?</p>', '', 1.00, 'SHORT_ANSWER'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATED'::public."copystate", '2024-07-16 21:28:46.226', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-07-16 21:28:46.226', 'a54cf2f7-294c-4b1a-a8c7-6e8c34fb5f51'::uuid, false, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank, is_lecturer_private)
VALUES('175441dd-3023-480a-880a-4b9a93570c1d'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Trong C++, từ khóa nào được sử dụng để khai báo một lớp (class)?', '<p>Trong C++, từ khóa nào được sử dụng để khai báo một lớp (class)?</p>', '', 1.00, 'MULTIPLE_CHOICE'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATED'::public."copystate", '2024-07-16 21:29:48.846', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-07-16 21:29:48.846', 'a54cf2f7-294c-4b1a-a8c7-6e8c34fb5f51'::uuid, false, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank, is_lecturer_private)
VALUES('4981ef9b-2355-4ee7-acb6-6f72d549f50d'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Phương thức nào sau đây được sử dụng để giải phóng bộ nhớ đã cấp phát động trong C++?', '<p>Phương thức nào sau đây được sử dụng để giải phóng bộ nhớ đã cấp phát động trong C++?</p>', '', 1.00, 'MULTIPLE_CHOICE'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATED'::public."copystate", '2024-07-16 21:30:43.688', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-07-16 21:30:43.688', 'a54cf2f7-294c-4b1a-a8c7-6e8c34fb5f51'::uuid, false, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank, is_lecturer_private)
VALUES('643c9a5f-c96e-4a1a-be18-0c3758002e3d'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Trong C++, bạn có thể sử dụng từ khóa ''new'' để cấp phát bộ nhớ động.', '<p>Trong C++, bạn có thể sử dụng từ khóa <code>new</code> để cấp phát bộ nhớ động.</p>', '', 1.00, 'TRUE_FALSE'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATED'::public."copystate", '2024-07-16 21:31:19.590', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-07-16 21:31:19.590', 'a54cf2f7-294c-4b1a-a8c7-6e8c34fb5f51'::uuid, false, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank, is_lecturer_private)
VALUES('d0470328-32a5-4b28-8dd6-49a8c3a0b9c4'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Trong C, hàm scanf có thể được sử dụng để nhập dữ liệu từ người dùng.', '<p>Trong C, hàm <code>scanf</code> có thể được sử dụng để nhập dữ liệu từ người dùng.</p>', '', 1.00, 'TRUE_FALSE'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATED'::public."copystate", '2024-07-16 21:31:36.978', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-07-16 21:31:36.978', 'a54cf2f7-294c-4b1a-a8c7-6e8c34fb5f51'::uuid, false, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank, is_lecturer_private)
VALUES('ce2dda6f-1448-4cf8-932e-17deedee80a6'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Trong C++, hàm bạn định nghĩa bên trong một lớp được gọi là phương thức (method).', '<p>Trong C++, hàm bạn định nghĩa bên trong một lớp được gọi là phương thức (method).</p>', '', 1.00, 'TRUE_FALSE'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATED'::public."copystate", '2024-07-16 21:31:56.420', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-07-16 21:31:56.420', 'a54cf2f7-294c-4b1a-a8c7-6e8c34fb5f51'::uuid, false, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank, is_lecturer_private)
VALUES('886e4b8a-6c84-40ee-8b16-d80ffdd06f8b'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Trong C++, bạn không thể nạp chồng (overload) toán tử.', '<p>Trong C++, bạn không thể nạp chồng (overload) toán tử.</p>', '', 1.00, 'TRUE_FALSE'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATED'::public."copystate", '2024-07-16 21:32:10.287', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-07-16 21:32:10.287', 'a54cf2f7-294c-4b1a-a8c7-6e8c34fb5f51'::uuid, false, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank, is_lecturer_private)
VALUES('8288a841-3fc9-4163-878c-aa382dec8fe5'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'JVM (Java Virtual Machine) là gì?', '<p>JVM (Java Virtual Machine) là gì?</p>', '', 1.00, 'ESSAY'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATING'::public."copystate", '2024-07-16 21:32:52.120', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-07-16 21:32:52.120', 'b8d5995f-0cf9-4ad4-967c-f94f2187deb9'::uuid, false, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank, is_lecturer_private)
VALUES('bfece9c7-3f02-43e1-bb7e-4317b3658641'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Sự khác biệt giữa == và equals() trong Java là gì?', '<p>Sự khác biệt giữa <code>==</code> và <code>equals()</code> trong Java là gì?</p>', '', 1.00, 'SHORT_ANSWER'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATED'::public."copystate", '2024-07-16 21:33:27.427', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-07-16 21:33:27.427', 'b8d5995f-0cf9-4ad4-967c-f94f2187deb9'::uuid, false, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank, is_lecturer_private)
VALUES('d6b8b467-f21a-4957-a58f-ad58c4015b2e'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Trong Java, một lớp chỉ có thể kế thừa từ một lớp khác.', '<p>Trong Java, một lớp chỉ có thể kế thừa từ một lớp khác.</p>', '', 1.00, 'TRUE_FALSE'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATED'::public."copystate", '2024-07-16 21:34:16.910', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-07-16 21:34:16.910', 'b8d5995f-0cf9-4ad4-967c-f94f2187deb9'::uuid, false, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank, is_lecturer_private)
VALUES('f1de8ed8-5721-4260-b019-d3ae2852f048'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Trong Java, tất cả các lớp đều là con của lớp Object.', '<p>Trong Java, tất cả các lớp đều là con của lớp Object.</p>', '', 1.00, 'TRUE_FALSE'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATED'::public."copystate", '2024-07-16 21:34:30.027', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-07-16 21:34:30.027', 'b8d5995f-0cf9-4ad4-967c-f94f2187deb9'::uuid, false, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank, is_lecturer_private)
VALUES('56aa0b87-83b7-42cf-9e90-0f075ad8c53b'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Java hỗ trợ lập trình hàm (functional programming) từ phiên bản Java 8 trở đi với sự ra đời của lambda expressions.', '<p>&nbsp;Java hỗ trợ lập trình hàm (functional programming) từ phiên bản Java 8 trở đi với sự ra đời của lambda expressions.</p>', '', 1.00, 'TRUE_FALSE'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATED'::public."copystate", '2024-07-16 21:34:46.424', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-07-16 21:34:46.424', 'b8d5995f-0cf9-4ad4-967c-f94f2187deb9'::uuid, false, false);
INSERT INTO public.question
(id, org_id, "difficulty", "name", question_text, general_feedback, default_mark, "qtype", created_by, copy_state, created_at, updated_by, updated_at, question_bank_category_id, is_org_question_bank, is_lecturer_private)
VALUES('b0edc4d7-713a-48df-a9a7-8a8b411c3379'::uuid, '08b65a39-394f-4977-a5fa-3fe145b620f8'::uuid, 'EASY'::public."difficulty", 'Trong Java, bạn có thể tạo một đối tượng từ một lớp trừu tượng (abstract class).', '<p>Trong Java, bạn có thể tạo một đối tượng từ một lớp trừu tượng (abstract class).</p>', '', 1.00, 'TRUE_FALSE'::public."qtype", '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, 'CREATED'::public."copystate", '2024-07-16 21:35:07.187', '64412e27-169e-44ea-a101-74ebf8cb82d9'::uuid, '2024-07-16 21:35:07.187', 'b8d5995f-0cf9-4ad4-967c-f94f2187deb9'::uuid, false, false);


INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('c88f9871-2cc8-476e-afcd-db2c03455ae6'::uuid, 'fe7f0a71-d3c5-4d2b-be25-2faff42c6b5c'::uuid, '<p>Router có chức năng chuyển tiếp gói tin giữa các mạng khác nhau, định tuyến và quản lý luồng dữ liệu.</p>', 'Router có chức năng chuyển tiếp gói tin giữa các mạng khác nhau, định tuyến và quản lý luồng dữ liệu.', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('33d9b3bb-fffc-46b2-9312-1f5d57feaff9'::uuid, 'e64fc118-1ae3-413d-9524-3e1dd1702ab5'::uuid, '<p>HTTP</p>', '<p>HTTP</p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('fbdc889c-ea57-48ec-8e59-868cfcc8a472'::uuid, 'e64fc118-1ae3-413d-9524-3e1dd1702ab5'::uuid, '<p>FTP</p>', '<p>FTP</p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('32f89200-8f3e-467f-bc77-74aa3ad733db'::uuid, 'e64fc118-1ae3-413d-9524-3e1dd1702ab5'::uuid, '<p>SMTP</p>', '<p>SMTP</p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('3890c6c4-2b8a-43e3-a82b-785713f2c6f4'::uuid, 'e64fc118-1ae3-413d-9524-3e1dd1702ab5'::uuid, '<p>TCP/IP</p>', '<p>TCP/IP</p>', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('3dfd0458-6678-4328-9b4c-3132b8b32382'::uuid, 'c434f3a9-986e-4522-bbdc-d9c58e0380ed'::uuid, '<p>Router</p>', '<p>Router</p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('981085a7-ec44-4619-a979-9b3401852fa7'::uuid, 'c434f3a9-986e-4522-bbdc-d9c58e0380ed'::uuid, '<p>Switch</p>', '<p>Switch</p>', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('b8a262ca-d882-4550-b644-4528ff5efd64'::uuid, 'c434f3a9-986e-4522-bbdc-d9c58e0380ed'::uuid, '<p>Modem</p>', '<p>Modem</p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('1d8623ec-c3ee-4ed6-86a2-45f11a0e73f1'::uuid, 'c434f3a9-986e-4522-bbdc-d9c58e0380ed'::uuid, '<p>Hub</p>', '<p>Hub</p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('1e15ced7-3b2e-4165-9e84-f17873c12e20'::uuid, '514843c5-8814-4406-af5c-9bf55fdf9ec8'::uuid, 'Correct', 'false', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('d5387266-02bc-4454-b863-2bc6c2c16d6d'::uuid, 'e3ac5475-462e-457a-9e00-f37a6217135c'::uuid, 'Correct', 'true', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('63b158bf-6c48-4c9d-bf58-e237ade8b990'::uuid, '4a8afa92-ad7c-4bd4-8bfc-d699f616a80d'::uuid, 'Correct', 'true', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('29d5f2d0-e448-4687-b6e2-cb068248b263'::uuid, '1592dc84-c95f-45d6-9a65-6c1ac5e2e413'::uuid, 'Correct', 'false', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('fd776b92-4530-4f5c-bd5e-7dcacc6397b8'::uuid, '9de30d16-41ac-4451-9947-2b2088dd6afa'::uuid, '<p>Đóng gói là cơ chế ẩn giấu dữ liệu của một đối tượng và chỉ cho phép truy cập thông qua các phương thức của đối tượng đó.</p>', 'Đóng gói là cơ chế ẩn giấu dữ liệu của một đối tượng và chỉ cho phép truy cập thông qua các phương thức của đối tượng đó.', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('71db4b92-d4c1-4f50-9146-eb2227144723'::uuid, '8de957d4-92df-4f94-997b-1e1275afdc2f'::uuid, '<p>Kế thừa (Inheritance)</p>', '<p>Kế thừa (Inheritance)</p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('ae4e6e70-1ffd-46ba-b2fd-cb23a9a25cf6'::uuid, '8de957d4-92df-4f94-997b-1e1275afdc2f'::uuid, '<p>Đa hình (Polymorphism)</p>', '<p>Đa hình (Polymorphism)</p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('ecb79aab-c247-4559-aaa4-81adb366543b'::uuid, '8de957d4-92df-4f94-997b-1e1275afdc2f'::uuid, '<p>Biến toàn cục (Global Variable)</p>', '<p>Biến toàn cục (Global Variable)</p>', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('df670dd3-b304-4de7-9c49-435a5f1bfacf'::uuid, '8de957d4-92df-4f94-997b-1e1275afdc2f'::uuid, '<p>Đóng gói (Encapsulation)</p>', '<p>Đóng gói (Encapsulation)</p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('3f6cad54-a123-46a0-a12a-ccf3f5f380c0'::uuid, 'b387b570-5b99-4f82-83be-292c969db99f'::uuid, '<p>Đóng gói (Encapsulation)</p>', '<p>Đóng gói (Encapsulation)</p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('c58fb769-3574-44e2-8b88-0291d533df93'::uuid, 'b387b570-5b99-4f82-83be-292c969db99f'::uuid, '<p>Trừu tượng hóa (Abstraction)</p>', '<p>Trừu tượng hóa (Abstraction)</p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('2f204fe1-a67f-46e2-9837-0472cd4d6850'::uuid, 'b387b570-5b99-4f82-83be-292c969db99f'::uuid, '<p>Kế thừa (Inheritance)</p>', '<p>Kế thừa (Inheritance)</p>', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('d02d7a22-6e1a-488e-bb4d-1f3f474ebf3e'::uuid, 'b387b570-5b99-4f82-83be-292c969db99f'::uuid, '<p>Đa hình (Polymorphism)</p>', '<p>Đa hình (Polymorphism)</p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('4ae4f038-ec55-410f-b12e-b346941e9e99'::uuid, '4fa387a6-db86-48bb-85f4-fcbb43c8eeb0'::uuid, 'Correct', 'true', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('dce5ee63-4384-4547-a4a7-38236009be0d'::uuid, 'b48fbf09-4b3f-4def-bfb8-4cfb65da1f27'::uuid, 'Correct', 'false', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('dac69827-303a-4a11-b46f-698be40c73b7'::uuid, 'c5e675a1-50a3-400c-a232-968413d0ebf2'::uuid, 'Correct', 'true', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('69e8c753-bf53-42dd-8ae5-68b771fb51f3'::uuid, '306eaa8b-4054-4ad7-b6ed-b847a2d53b63'::uuid, 'Correct', 'true', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('d2c9bb4b-a8d7-4e59-9602-34ea079e4de1'::uuid, '1f0daa04-6462-4eb5-9fc4-883f68e78b7c'::uuid, '<p>Giải thuật là một tập hợp các bước cụ thể và hữu hạn để giải quyết một vấn đề hoặc thực hiện một tác vụ.</p>', 'Giải thuật là một tập hợp các bước cụ thể và hữu hạn để giải quyết một vấn đề hoặc thực hiện một tác vụ.', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('f3d13cab-0d0d-48bf-8c32-a83699bd38c0'::uuid, '1c054e46-a127-448d-a6a8-8c9be65cfded'::uuid, '<p>Danh sách liên kết đơn (Singly Linked List)</p>', '<p>Danh sách liên kết đơn (Singly Linked List)</p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('6fbe5289-62a6-49ff-baaa-c524466d8966'::uuid, '1c054e46-a127-448d-a6a8-8c9be65cfded'::uuid, '<p>Danh sách liên kết kép (Doubly Linked List)</p>', '<p>Danh sách liên kết kép (Doubly Linked List)</p>', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('e0b84f6f-ad13-4016-9bd1-d9938c400673'::uuid, '1c054e46-a127-448d-a6a8-8c9be65cfded'::uuid, '<p>Danh sách liên kết vòng (Circular Linked List)</p>', '<p>Danh sách liên kết vòng (Circular Linked List)</p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('2846c9af-6b6d-45ac-8b6a-61bf797df9ef'::uuid, '1c054e46-a127-448d-a6a8-8c9be65cfded'::uuid, '<p>Mảng (Array)</p>', '<p>Mảng (Array)</p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('2463db37-999f-49ec-a684-bee2e66aed95'::uuid, 'c88dfd4d-b102-4412-9127-17d68ec3a5e1'::uuid, '<p>Danh sách liên kết đơn</p>', '<p>Danh sách liên kết đơn</p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('d4539ec8-38ac-4af1-b8df-b977eac039dd'::uuid, 'c88dfd4d-b102-4412-9127-17d68ec3a5e1'::uuid, '<p>Danh sách liên kết kép</p>', '<p>Danh sách liên kết kép</p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('2116d00c-caa5-4ef4-87d7-5021d2c7883b'::uuid, 'c88dfd4d-b102-4412-9127-17d68ec3a5e1'::uuid, '<p>Mảng đã sắp xếp</p>', '<p>Mảng đã sắp xếp</p>', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('48d6b372-b486-4f09-a89b-cdae884b6a5f'::uuid, 'c88dfd4d-b102-4412-9127-17d68ec3a5e1'::uuid, '<p>Mảng chưa sắp xếp</p>', '<p>Mảng chưa sắp xếp</p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('7cbe35b2-8f0e-4131-9ac0-427e583fe88c'::uuid, 'eb74ae25-bfd1-4c3c-8d19-f29872f6b858'::uuid, 'Correct', 'true', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('b4f62a78-805e-4377-9ef5-ba0e54c61355'::uuid, '9002af16-7252-421a-b8ab-c0f4944a1e89'::uuid, 'Correct', 'false', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('166b2711-8d26-4cc3-8ea6-9a8281467b50'::uuid, 'a411cc44-f924-445c-bd00-f605f7533dcf'::uuid, 'Correct', 'true', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('520f3d3a-b639-490f-9ffd-1f4089e30033'::uuid, '05d5cd7c-968b-49a6-acf3-c839f2d04243'::uuid, 'Correct', 'true', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('f7f6b8b7-36df-4d7c-b06c-20abb78b5173'::uuid, '4faf36f7-aa0b-43db-b830-aff5c0337996'::uuid, '<p>Con trỏ là một biến lưu trữ địa chỉ của một biến khác trong bộ nhớ.</p>', 'Con trỏ là một biến lưu trữ địa chỉ của một biến khác trong bộ nhớ.', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('33ae0d75-a406-4ead-b30e-5f07931668b1'::uuid, '175441dd-3023-480a-880a-4b9a93570c1d'::uuid, '<p>struct</p>', '<p>struct</p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('66beaffa-b41a-4618-8541-e2cd599c9272'::uuid, '175441dd-3023-480a-880a-4b9a93570c1d'::uuid, '<p>class</p>', '<p>class</p>', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('188bcd0c-e9ef-4384-affa-48d162f37545'::uuid, '175441dd-3023-480a-880a-4b9a93570c1d'::uuid, '<p>union</p>', '<p>union</p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('508df0ac-fd12-4041-9f74-b12966d7a79d'::uuid, '175441dd-3023-480a-880a-4b9a93570c1d'::uuid, '<p>namespace</p>', '<p>namespace</p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('532ac08e-800b-493e-b5e6-532070921a8c'::uuid, '4981ef9b-2355-4ee7-acb6-6f72d549f50d'::uuid, '<p>delete</p>', '<p>delete</p>', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('66527d50-7123-436b-9866-9505c9596df5'::uuid, '4981ef9b-2355-4ee7-acb6-6f72d549f50d'::uuid, '<p>free</p>', '<p>free</p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('60c2751d-72c5-4fea-b8f9-5f58256ca9dc'::uuid, '4981ef9b-2355-4ee7-acb6-6f72d549f50d'::uuid, '<p>malloc</p>', '<p>malloc</p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('230eb79e-3be9-4336-b315-800c7b2a8ee4'::uuid, '4981ef9b-2355-4ee7-acb6-6f72d549f50d'::uuid, '<p>new</p>', '<p>new</p>', 0.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('180f1ed6-3079-469f-a313-f6707220dbb3'::uuid, '643c9a5f-c96e-4a1a-be18-0c3758002e3d'::uuid, 'Correct', 'true', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('687afdf5-90d8-4e74-83ca-d3b0fa2ac68e'::uuid, 'd0470328-32a5-4b28-8dd6-49a8c3a0b9c4'::uuid, 'Correct', 'true', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('9ca6ac06-c9f8-4873-a7ee-9f9dcfc82ff0'::uuid, 'ce2dda6f-1448-4cf8-932e-17deedee80a6'::uuid, 'Correct', 'true', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('d2207c09-ece6-4453-87a6-72a70d947933'::uuid, '886e4b8a-6c84-40ee-8b16-d80ffdd06f8b'::uuid, 'Correct', 'false', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('d87f8b5d-0b39-4a25-96d3-03389e6bfe3b'::uuid, 'bfece9c7-3f02-43e1-bb7e-4317b3658641'::uuid, '<p><code>==</code> so sánh địa chỉ bộ nhớ của hai đối tượng, còn <code>equals()</code> so sánh nội dung của hai đối tượng.</p>', ' == so sánh địa chỉ bộ nhớ của hai đối tượng, còn equals() so sánh nội dung của hai đối tượng.', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('37e75761-3d6d-465a-aadc-ef3f450577b2'::uuid, 'd6b8b467-f21a-4957-a58f-ad58c4015b2e'::uuid, 'Correct', 'true', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('a54485ae-3e69-4c35-80fe-8b378c7b3677'::uuid, 'f1de8ed8-5721-4260-b019-d3ae2852f048'::uuid, 'Correct', 'true', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('0a255d54-c5f6-4845-b712-8aa5674d82c0'::uuid, '56aa0b87-83b7-42cf-9e90-0f075ad8c53b'::uuid, 'Correct', 'true', 1.00);
INSERT INTO public.answer_of_question
(id, question_id, feedback, answer, fraction)
VALUES('43ab2d6b-a60f-4b3b-8a08-7bbab52daf19'::uuid, 'b0edc4d7-713a-48df-a9a7-8a8b411c3379'::uuid, 'Correct', 'false', 1.00);


INSERT INTO public.qtype_essay_question
(id, question_id, response_format, response_required, response_field_lines, min_word_limit, max_word_limit, attachments, attachments_required, grader_info, grader_info_format, response_template, max_bytes, file_types_list)
VALUES('958ec207-dea9-4b9f-9f5b-de54866bb830'::uuid, '98abb4e8-94d6-41dc-a960-2f18438ce77d'::uuid, 'editor', 0, 10, -1, -1, 0, 0, '', NULL, '', 1000, '');
INSERT INTO public.qtype_essay_question
(id, question_id, response_format, response_required, response_field_lines, min_word_limit, max_word_limit, attachments, attachments_required, grader_info, grader_info_format, response_template, max_bytes, file_types_list)
VALUES('b8d4aafd-75a6-41e7-9951-2b50ecdccceb'::uuid, 'f6a71b52-bf17-4ac0-b736-fb609e8f84d9'::uuid, 'editor', 0, 10, -1, -1, 0, 0, '', NULL, '', 1000, '');
INSERT INTO public.qtype_essay_question
(id, question_id, response_format, response_required, response_field_lines, min_word_limit, max_word_limit, attachments, attachments_required, grader_info, grader_info_format, response_template, max_bytes, file_types_list)
VALUES('f436ffbe-2d52-4c73-9602-58ab9712e905'::uuid, '18fe1f1b-2d67-4bfa-bdfe-a19fe4daa665'::uuid, 'editor', 0, 10, -1, -1, 0, 0, '', NULL, '', 1000, '');
INSERT INTO public.qtype_essay_question
(id, question_id, response_format, response_required, response_field_lines, min_word_limit, max_word_limit, attachments, attachments_required, grader_info, grader_info_format, response_template, max_bytes, file_types_list)
VALUES('340843a9-c04f-4af3-8aea-69bd3ebf1e5f'::uuid, 'fd98f388-0b73-45ec-803f-d27a14773ac6'::uuid, 'editor', 0, 10, -1, -1, 0, 0, '', NULL, '', 1000, '');
INSERT INTO public.qtype_essay_question
(id, question_id, response_format, response_required, response_field_lines, min_word_limit, max_word_limit, attachments, attachments_required, grader_info, grader_info_format, response_template, max_bytes, file_types_list)
VALUES('fa221145-465f-4399-ad11-338507ad7089'::uuid, '8288a841-3fc9-4163-878c-aa382dec8fe5'::uuid, 'editor', 0, 10, -1, -1, 0, 0, '', NULL, '', 1000, '');


INSERT INTO public.qtype_multichoice_question
(id, question_id, single, shuffle_answers, correct_feedback, partially_correct_feedback, incorrect_feedback, answer_numbering, show_num_correct, show_standard_instruction)
VALUES('3c14ff64-cd40-47ba-bf4e-9ff790ee6d74'::uuid, 'e64fc118-1ae3-413d-9524-3e1dd1702ab5'::uuid, true, true, '', NULL, '', 'abc', 1, '1');
INSERT INTO public.qtype_multichoice_question
(id, question_id, single, shuffle_answers, correct_feedback, partially_correct_feedback, incorrect_feedback, answer_numbering, show_num_correct, show_standard_instruction)
VALUES('51604d22-6532-43fe-b550-6c5389cf369d'::uuid, 'c434f3a9-986e-4522-bbdc-d9c58e0380ed'::uuid, true, true, '', NULL, '', 'abc', 1, '1');
INSERT INTO public.qtype_multichoice_question
(id, question_id, single, shuffle_answers, correct_feedback, partially_correct_feedback, incorrect_feedback, answer_numbering, show_num_correct, show_standard_instruction)
VALUES('bac127ad-b1e1-46db-90f0-d1a1d4e410bc'::uuid, '514843c5-8814-4406-af5c-9bf55fdf9ec8'::uuid, true, false, '', NULL, '', NULL, 0, '1');
INSERT INTO public.qtype_multichoice_question
(id, question_id, single, shuffle_answers, correct_feedback, partially_correct_feedback, incorrect_feedback, answer_numbering, show_num_correct, show_standard_instruction)
VALUES('941504e7-0b49-4f17-b304-ea4ac93f2818'::uuid, 'e3ac5475-462e-457a-9e00-f37a6217135c'::uuid, true, false, '', NULL, '', NULL, 1, '1');
INSERT INTO public.qtype_multichoice_question
(id, question_id, single, shuffle_answers, correct_feedback, partially_correct_feedback, incorrect_feedback, answer_numbering, show_num_correct, show_standard_instruction)
VALUES('a4fb455f-c6b9-417e-9e01-d2c1c98de7af'::uuid, '4a8afa92-ad7c-4bd4-8bfc-d699f616a80d'::uuid, true, false, '', NULL, '', NULL, 1, '1');
INSERT INTO public.qtype_multichoice_question
(id, question_id, single, shuffle_answers, correct_feedback, partially_correct_feedback, incorrect_feedback, answer_numbering, show_num_correct, show_standard_instruction)
VALUES('d679577e-b6d3-42af-bdf6-4892c66fb9fb'::uuid, '1592dc84-c95f-45d6-9a65-6c1ac5e2e413'::uuid, true, false, '', NULL, '', NULL, 0, '1');
INSERT INTO public.qtype_multichoice_question
(id, question_id, single, shuffle_answers, correct_feedback, partially_correct_feedback, incorrect_feedback, answer_numbering, show_num_correct, show_standard_instruction)
VALUES('eaddc978-c6ae-4de8-bddd-2754be4d48cf'::uuid, '8de957d4-92df-4f94-997b-1e1275afdc2f'::uuid, true, true, '', NULL, '', 'abc', 1, '1');
INSERT INTO public.qtype_multichoice_question
(id, question_id, single, shuffle_answers, correct_feedback, partially_correct_feedback, incorrect_feedback, answer_numbering, show_num_correct, show_standard_instruction)
VALUES('0ea5aabe-5655-40b3-92f4-d02a7bfdedef'::uuid, 'b387b570-5b99-4f82-83be-292c969db99f'::uuid, true, true, '', NULL, '', 'abc', 1, '1');
INSERT INTO public.qtype_multichoice_question
(id, question_id, single, shuffle_answers, correct_feedback, partially_correct_feedback, incorrect_feedback, answer_numbering, show_num_correct, show_standard_instruction)
VALUES('9fa33dd9-0bb8-48f9-919f-6116fc0283e7'::uuid, '4fa387a6-db86-48bb-85f4-fcbb43c8eeb0'::uuid, true, false, '', NULL, '', NULL, 1, '1');
INSERT INTO public.qtype_multichoice_question
(id, question_id, single, shuffle_answers, correct_feedback, partially_correct_feedback, incorrect_feedback, answer_numbering, show_num_correct, show_standard_instruction)
VALUES('85d2bdcb-b7fa-4fb7-a0a1-9ad7a3d52b75'::uuid, 'b48fbf09-4b3f-4def-bfb8-4cfb65da1f27'::uuid, true, false, '', NULL, '', NULL, 0, '1');
INSERT INTO public.qtype_multichoice_question
(id, question_id, single, shuffle_answers, correct_feedback, partially_correct_feedback, incorrect_feedback, answer_numbering, show_num_correct, show_standard_instruction)
VALUES('8e4f2622-c14d-4041-b4cb-6bf7ef623b13'::uuid, 'c5e675a1-50a3-400c-a232-968413d0ebf2'::uuid, true, false, '', NULL, '', NULL, 1, '1');
INSERT INTO public.qtype_multichoice_question
(id, question_id, single, shuffle_answers, correct_feedback, partially_correct_feedback, incorrect_feedback, answer_numbering, show_num_correct, show_standard_instruction)
VALUES('1baadcb5-ed26-464f-91cd-81adc8c94f6d'::uuid, '306eaa8b-4054-4ad7-b6ed-b847a2d53b63'::uuid, true, false, '', NULL, '', NULL, 1, '1');
INSERT INTO public.qtype_multichoice_question
(id, question_id, single, shuffle_answers, correct_feedback, partially_correct_feedback, incorrect_feedback, answer_numbering, show_num_correct, show_standard_instruction)
VALUES('e16dd324-438b-4a75-9e16-00259b501ea6'::uuid, '1c054e46-a127-448d-a6a8-8c9be65cfded'::uuid, true, true, '', NULL, '', 'abc', 1, '1');
INSERT INTO public.qtype_multichoice_question
(id, question_id, single, shuffle_answers, correct_feedback, partially_correct_feedback, incorrect_feedback, answer_numbering, show_num_correct, show_standard_instruction)
VALUES('fcec7fbc-cb99-4351-912a-3cf59c2d5763'::uuid, 'c88dfd4d-b102-4412-9127-17d68ec3a5e1'::uuid, true, true, '', NULL, '', 'abc', 1, '1');
INSERT INTO public.qtype_multichoice_question
(id, question_id, single, shuffle_answers, correct_feedback, partially_correct_feedback, incorrect_feedback, answer_numbering, show_num_correct, show_standard_instruction)
VALUES('1c7c461a-5a1a-494b-916b-2c4bcf9e7955'::uuid, 'eb74ae25-bfd1-4c3c-8d19-f29872f6b858'::uuid, true, false, '', NULL, '', NULL, 1, '1');
INSERT INTO public.qtype_multichoice_question
(id, question_id, single, shuffle_answers, correct_feedback, partially_correct_feedback, incorrect_feedback, answer_numbering, show_num_correct, show_standard_instruction)
VALUES('c39eed92-2b6a-4d69-888c-9d02dd33e0f3'::uuid, '9002af16-7252-421a-b8ab-c0f4944a1e89'::uuid, true, false, '', NULL, '', NULL, 0, '1');
INSERT INTO public.qtype_multichoice_question
(id, question_id, single, shuffle_answers, correct_feedback, partially_correct_feedback, incorrect_feedback, answer_numbering, show_num_correct, show_standard_instruction)
VALUES('69aa5c2f-a0e3-4933-920c-ff57c6173a0e'::uuid, 'a411cc44-f924-445c-bd00-f605f7533dcf'::uuid, true, false, '', NULL, '', NULL, 1, '1');
INSERT INTO public.qtype_multichoice_question
(id, question_id, single, shuffle_answers, correct_feedback, partially_correct_feedback, incorrect_feedback, answer_numbering, show_num_correct, show_standard_instruction)
VALUES('c5e8f6c7-8770-44bc-b7cf-d47fd88a4977'::uuid, '05d5cd7c-968b-49a6-acf3-c839f2d04243'::uuid, true, false, '', NULL, '', NULL, 1, '1');
INSERT INTO public.qtype_multichoice_question
(id, question_id, single, shuffle_answers, correct_feedback, partially_correct_feedback, incorrect_feedback, answer_numbering, show_num_correct, show_standard_instruction)
VALUES('c3790bb8-9c55-40ca-bf05-b02f47255721'::uuid, '175441dd-3023-480a-880a-4b9a93570c1d'::uuid, true, true, '', NULL, '', 'abc', 1, '1');
INSERT INTO public.qtype_multichoice_question
(id, question_id, single, shuffle_answers, correct_feedback, partially_correct_feedback, incorrect_feedback, answer_numbering, show_num_correct, show_standard_instruction)
VALUES('668759f1-53ce-47cc-8314-c78f4a9a2002'::uuid, '4981ef9b-2355-4ee7-acb6-6f72d549f50d'::uuid, true, true, '', NULL, '', 'abc', 1, '1');
INSERT INTO public.qtype_multichoice_question
(id, question_id, single, shuffle_answers, correct_feedback, partially_correct_feedback, incorrect_feedback, answer_numbering, show_num_correct, show_standard_instruction)
VALUES('1e27d53a-8568-4322-a458-75616210cc9f'::uuid, '643c9a5f-c96e-4a1a-be18-0c3758002e3d'::uuid, true, false, '', NULL, '', NULL, 1, '1');
INSERT INTO public.qtype_multichoice_question
(id, question_id, single, shuffle_answers, correct_feedback, partially_correct_feedback, incorrect_feedback, answer_numbering, show_num_correct, show_standard_instruction)
VALUES('3d1cb811-5a77-4950-9576-380df20ceaa0'::uuid, 'd0470328-32a5-4b28-8dd6-49a8c3a0b9c4'::uuid, true, false, '', NULL, '', NULL, 1, '1');
INSERT INTO public.qtype_multichoice_question
(id, question_id, single, shuffle_answers, correct_feedback, partially_correct_feedback, incorrect_feedback, answer_numbering, show_num_correct, show_standard_instruction)
VALUES('863c400b-140e-42c4-843d-421d5cfced67'::uuid, 'ce2dda6f-1448-4cf8-932e-17deedee80a6'::uuid, true, false, '', NULL, '', NULL, 1, '1');
INSERT INTO public.qtype_multichoice_question
(id, question_id, single, shuffle_answers, correct_feedback, partially_correct_feedback, incorrect_feedback, answer_numbering, show_num_correct, show_standard_instruction)
VALUES('dc342bec-96a6-4256-8cb2-0f88368ca334'::uuid, '886e4b8a-6c84-40ee-8b16-d80ffdd06f8b'::uuid, true, false, '', NULL, '', NULL, 0, '1');
INSERT INTO public.qtype_multichoice_question
(id, question_id, single, shuffle_answers, correct_feedback, partially_correct_feedback, incorrect_feedback, answer_numbering, show_num_correct, show_standard_instruction)
VALUES('0b1b5e54-1ef0-4659-b995-66ff720e9673'::uuid, 'd6b8b467-f21a-4957-a58f-ad58c4015b2e'::uuid, true, false, '', NULL, '', NULL, 1, '1');
INSERT INTO public.qtype_multichoice_question
(id, question_id, single, shuffle_answers, correct_feedback, partially_correct_feedback, incorrect_feedback, answer_numbering, show_num_correct, show_standard_instruction)
VALUES('ce5647c3-7a06-4637-9bd8-7d3eb719fdf0'::uuid, 'f1de8ed8-5721-4260-b019-d3ae2852f048'::uuid, true, false, '', NULL, '', NULL, 1, '1');
INSERT INTO public.qtype_multichoice_question
(id, question_id, single, shuffle_answers, correct_feedback, partially_correct_feedback, incorrect_feedback, answer_numbering, show_num_correct, show_standard_instruction)
VALUES('80cca57d-ea6b-478d-80b8-8240702196a8'::uuid, '56aa0b87-83b7-42cf-9e90-0f075ad8c53b'::uuid, true, false, '', NULL, '', NULL, 1, '1');
INSERT INTO public.qtype_multichoice_question
(id, question_id, single, shuffle_answers, correct_feedback, partially_correct_feedback, incorrect_feedback, answer_numbering, show_num_correct, show_standard_instruction)
VALUES('3df4fc1b-fe16-4971-aa0c-a6b2a6a63be3'::uuid, 'b0edc4d7-713a-48df-a9a7-8a8b411c3379'::uuid, true, false, '', NULL, '', NULL, 0, '1');


INSERT INTO public.qtype_shortanswer_question
(id, question_id, case_sensitive)
VALUES('08471708-dd88-4dcf-942b-b768e50db7ac'::uuid, 'fe7f0a71-d3c5-4d2b-be25-2faff42c6b5c'::uuid, true);
INSERT INTO public.qtype_shortanswer_question
(id, question_id, case_sensitive)
VALUES('0f8f6af6-07b7-40ab-b626-9c4cbf8c8cb8'::uuid, '9de30d16-41ac-4451-9947-2b2088dd6afa'::uuid, true);
INSERT INTO public.qtype_shortanswer_question
(id, question_id, case_sensitive)
VALUES('3b79fca2-0de6-4810-b487-5c325292082a'::uuid, '1f0daa04-6462-4eb5-9fc4-883f68e78b7c'::uuid, true);
INSERT INTO public.qtype_shortanswer_question
(id, question_id, case_sensitive)
VALUES('126cc3be-bb9c-40f9-85cd-c8a7275ac616'::uuid, '4faf36f7-aa0b-43db-b830-aff5c0337996'::uuid, true);
INSERT INTO public.qtype_shortanswer_question
(id, question_id, case_sensitive)
VALUES('80f079f1-2cc8-4e97-ba08-99064074b20a'::uuid, 'bfece9c7-3f02-43e1-bb7e-4317b3658641'::uuid, true);

