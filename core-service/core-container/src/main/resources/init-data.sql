INSERT INTO public.user(id, email, first_name, last_name)
VALUES ('d215b5f8-0249-4dc5-89a3-51fd148cfb45', 'khanhndq2002@gmail.com', 'Khanh', 'Nguyen');

INSERT INTO public.topic(id, name, description, created_by, updated_by)
VALUES
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb45', 'Learn Python', 'Python is a versatile and user-friendly programming language known for its readability and efficiency. It''s widely used for web development, data analysis, artificial intelligence, and more.', 'd215b5f8-0249-4dc5-89a3-51fd148cfb45', 'd215b5f8-0249-4dc5-89a3-51fd148cfb45'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb46', 'Learn Java', 'Java is a high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible. It is a general-purpose programming language intended to let application developers write once, run anywhere (WORA), meaning that compiled Java code can run on all platforms that support Java without the need for recompilation.', 'd215b5f8-0249-4dc5-89a3-51fd148cfb45', 'd215b5f8-0249-4dc5-89a3-51fd148cfb45'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb47', 'Learn JavaScript', 'JavaScript is a programming language that conforms to the ECMAScript specification. JavaScript is high-level, often just-in-time compiled, and multi-paradigm. It has curly-bracket syntax, dynamic typing, prototype-based object-orientation, and first-class functions.', 'd215b5f8-0249-4dc5-89a3-51fd148cfb45', 'd215b5f8-0249-4dc5-89a3-51fd148cfb45'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb48', 'Data structures and Algorithms', 'Explore the fundamental building blocks of computer science through our comprehensive courses on Data Structures and Algorithms. Gain a solid understanding of both theory and practical application.','d215b5f8-0249-4dc5-89a3-51fd148cfb45', 'd215b5f8-0249-4dc5-89a3-51fd148cfb45' );

INSERT INTO public.organization(id, name, description)
VALUES
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb45', 'Codecademy', 'Codecademy is an American online interactive platform that offers free coding classes in 12 different programming languages including Python, Java, JavaScript (jQuery, AngularJS, React.js), Ruby, SQL, and Sass, as well as markup languages HTML and CSS.'),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb46', 'Coursera', 'Coursera is an American massive open online course provider founded in 2012 by Stanford University computer science professors Andrew Ng and Daphne Koller that offers massive open online courses, specializations, degrees, professional and mastertrack courses.');

INSERT INTO public.programming_language(id, name, compiler_api_id)
VALUES
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb47', 'Python (2.7.17)', 70),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb48', 'Java (OpenJDK 13.0.1)', 62),
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb49', 'C++ (GCC 9.2.0)', 54);

INSERT INTO public.question(id, org_id, difficulty, name, question_text, general_feedback, default_mark, qtype, created_by, updated_by)
VALUES
    ('b6484e21-6937-489c-b031-b71767994221', 'd215b5f8-0249-4dc5-89a3-51fd148cfb45', 'HARD', 'Question Pants', 'Question Mouse Text', 'Question Tuna feedback', 1, 'CODE', 'd215b5f8-0249-4dc5-89a3-51fd148cfb45', 'd215b5f8-0249-4dc5-89a3-51fd148cfb45');

INSERT INTO public.qtype_code_question(id, question_id, dsl_template)
VALUES
    ('27549d54-4a3a-4be4-9875-eab03f88ba5d', 'b6484e21-6937-489c-b031-b71767994221', 'print(Hello World)');

INSERT INTO public.answer_of_question(id, question_id, feedback, answer, fraction)
VALUES
    ('d215b5f8-0249-4dc5-89a3-51fd148cfb15', 'b6484e21-6937-489c-b031-b71767994221', 'Correct', 'print(Hello World)', 1);
