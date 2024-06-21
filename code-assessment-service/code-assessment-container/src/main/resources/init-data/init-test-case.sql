INSERT INTO test_cases(id, code_question_id  ,input_data  ,output_data  ,is_sample )
VALUES
    ('9b103259-1a04-4ae4-aaac-dbd8f2d37ec6', '3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', E'1\n2', '3', true),
    ('e1e4e8bc-1ebe-4973-9a76-197988fdd442', '3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', E'1\n1000', '1001', true),
    ('e1e4e8bc-1ebe-4973-9a76-197988fdd443', '3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', E'1\n1010', '1011', false),
    ('d6c25df9-3194-43a8-a1eb-617fbcce058d', '3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', E'1\n222', '223', true),

    ('4958f447-6cda-4807-9619-e4678c93d6c5', 'f6d7b882-9399-4bc3-baad-6350285bfa78', E'1\n1010', '1010', false),
    ('56ad180e-c833-43e6-978a-65f682b582b5', 'f6d7b882-9399-4bc3-baad-6350285bfa78', E'1\n101 1', '102', false),
    ('f063c223-dda8-4e03-a5d4-a62fda931cfd', 'f6d7b882-9399-4bc3-baad-6350285bfa78', E'2\n1 5', '6', true),
    ('ce90dd00-bbf1-461e-a7f8-716ca2ced68e', 'f6d7b882-9399-4bc3-baad-6350285bfa78', E'5\n1 1 1 1 1', '5', true),
    ('96584e1f-5c25-425c-bde6-09422a851b36', 'f6d7b882-9399-4bc3-baad-6350285bfa78', E'3\n0 0 0', '0', false),
    ('3dc3ad76-7b95-4a48-bfca-9d3486db12b2', 'f6d7b882-9399-4bc3-baad-6350285bfa78', E'2\n100 100', '200', false),

    ('dcbd352c-8ead-4e57-8839-3bbc6d6c8186', '48caf2c9-8c81-49a7-b656-c3b024a798c3', '15' , '1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz', true),
    ('9d5a437b-949c-468e-9d15-59c628db3106', '48caf2c9-8c81-49a7-b656-c3b024a798c3', '3' , '1 2 Fizz', false),

    ('c728a0e7-e472-4ca5-986c-9fc8fa5bf660', '2589a5b7-94c9-4a76-86d9-576718ca63c3', E'4\n1 2 3 1' , '4', true),
    ('30b50787-68a0-472c-b188-9427cdef5140', '2589a5b7-94c9-4a76-86d9-576718ca63c3', E'5\n2 7 9 3 1' , '12', false),
    ('5454652d-9522-44e9-891f-812a2dc6ec39', '2589a5b7-94c9-4a76-86d9-576718ca63c3', E'4\n2 1 1 2' , '4', false),
    ('d68d1900-bfc6-4849-9de4-14a32ca4fa6f', '2589a5b7-94c9-4a76-86d9-576718ca63c3', E'6\n5 5 10 100 10 5' , '110', true),
    ('fe8307ff-995c-4a49-86ce-41080317ad56', '2589a5b7-94c9-4a76-86d9-576718ca63c3', E'4\n0 0 0 0' , '0', false),
    ('f4c77b3b-4f77-4432-aa80-98fcc4ab5f69', '2589a5b7-94c9-4a76-86d9-576718ca63c3', E'4\n50 10 10 50' , '100', false),
    ('2c2529e9-7b95-4ac6-a957-2552e7600e1c', '2589a5b7-94c9-4a76-86d9-576718ca63c3', E'7\n10 20 30 40 50 60 70' , '160', false),

    ('d16bb21d-b37b-47ab-9137-4130142a8722', '2dbe940c-8d25-4a88-a283-d79785c1ea2a', E'4\n-1 2 1 -4\n1' , '2', true),
    ('55e0f65a-f8c1-4c80-be52-b3cfcadfbc76', '2dbe940c-8d25-4a88-a283-d79785c1ea2a', E'3\n0 0 0\n1' , '0', false),
    ('44a93fef-c73d-4b95-bc8b-8c78e4193123', '2dbe940c-8d25-4a88-a283-d79785c1ea2a', E'4\n1000 2000 3000 4000\n5000' , '6000', false),
    ('ab25af5a-985e-4377-a58a-94762eb042d6', '2dbe940c-8d25-4a88-a283-d79785c1ea2a', E'4\n-1000 -2000 -3000 -4000\n-5000' , '-6000', false),
    ('996e898a-507b-45c6-9574-a3d0cf853b64', '2dbe940c-8d25-4a88-a283-d79785c1ea2a', E'6\n-1 2 1 4 3 -5\n5' , '5', true)


    ;