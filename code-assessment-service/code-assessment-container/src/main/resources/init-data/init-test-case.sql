INSERT INTO test_cases(id, code_question_id  ,input_data  ,output_data  ,is_sample )
VALUES
--1
    ('9b103259-1a04-4ae4-aaac-dbd8f2d37ec6', '3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', E'1\n2', '3', true),
    ('e1e4e8bc-1ebe-4973-9a76-197988fdd442', '3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', E'1\n1000', '1001', true),
    ('e1e4e8bc-1ebe-4973-9a76-197988fdd443', '3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', E'1\n1010', '1011', false),
    ('d6c25df9-3194-43a8-a1eb-617fbcce058d', '3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', E'1\n222', '223', true),
--2
    ('4958f447-6cda-4807-9619-e4678c93d6c5', 'f6d7b882-9399-4bc3-baad-6350285bfa78', E'1\n1010', '1010', false),
    ('56ad180e-c833-43e6-978a-65f682b582b5', 'f6d7b882-9399-4bc3-baad-6350285bfa78', E'1\n101 1', '102', false),
    ('f063c223-dda8-4e03-a5d4-a62fda931cfd', 'f6d7b882-9399-4bc3-baad-6350285bfa78', E'2\n1 5', '6', true),
    ('ce90dd00-bbf1-461e-a7f8-716ca2ced68e', 'f6d7b882-9399-4bc3-baad-6350285bfa78', E'5\n1 1 1 1 1', '5', true),
    ('96584e1f-5c25-425c-bde6-09422a851b36', 'f6d7b882-9399-4bc3-baad-6350285bfa78', E'3\n0 0 0', '0', false),
    ('3dc3ad76-7b95-4a48-bfca-9d3486db12b2', 'f6d7b882-9399-4bc3-baad-6350285bfa78', E'2\n100 100', '200', false),
--3
    ('dcbd352c-8ead-4e57-8839-3bbc6d6c8186', '48caf2c9-8c81-49a7-b656-c3b024a798c3', '15' , '1 2 Fizz 4 Buzz Fizz 7 8 Fizz Buzz 11 Fizz 13 14 FizzBuzz', true),
    ('9d5a437b-949c-468e-9d15-59c628db3106', '48caf2c9-8c81-49a7-b656-c3b024a798c3', '3' , '1 2 Fizz', false),
--4
    ('c728a0e7-e472-4ca5-986c-9fc8fa5bf660', '2589a5b7-94c9-4a76-86d9-576718ca63c3', E'4\n1 2 3 1' , '4', true),
    ('30b50787-68a0-472c-b188-9427cdef5140', '2589a5b7-94c9-4a76-86d9-576718ca63c3', E'5\n2 7 9 3 1' , '12', false),
    ('5454652d-9522-44e9-891f-812a2dc6ec39', '2589a5b7-94c9-4a76-86d9-576718ca63c3', E'4\n2 1 1 2' , '4', false),
    ('d68d1900-bfc6-4849-9de4-14a32ca4fa6f', '2589a5b7-94c9-4a76-86d9-576718ca63c3', E'6\n5 5 10 100 10 5' , '110', true),
    ('fe8307ff-995c-4a49-86ce-41080317ad56', '2589a5b7-94c9-4a76-86d9-576718ca63c3', E'4\n0 0 0 0' , '0', false),
    ('f4c77b3b-4f77-4432-aa80-98fcc4ab5f69', '2589a5b7-94c9-4a76-86d9-576718ca63c3', E'4\n50 10 10 50' , '100', false),
    ('2c2529e9-7b95-4ac6-a957-2552e7600e1c', '2589a5b7-94c9-4a76-86d9-576718ca63c3', E'7\n10 20 30 40 50 60 70' , '160', false),
--5
    ('d16bb21d-b37b-47ab-9137-4130142a8722', '2dbe940c-8d25-4a88-a283-d79785c1ea2a', E'4\n-1 2 1 -4\n1' , '2', true),
    ('55e0f65a-f8c1-4c80-be52-b3cfcadfbc76', '2dbe940c-8d25-4a88-a283-d79785c1ea2a', E'3\n0 0 0\n1' , '0', false),
    ('44a93fef-c73d-4b95-bc8b-8c78e4193123', '2dbe940c-8d25-4a88-a283-d79785c1ea2a', E'4\n1000 2000 3000 4000\n5000' , '6000', false),
    ('ab25af5a-985e-4377-a58a-94762eb042d6', '2dbe940c-8d25-4a88-a283-d79785c1ea2a', E'4\n-1000 -2000 -3000 -4000\n-5000' , '-6000', false),
    ('996e898a-507b-45c6-9574-a3d0cf853b64', '2dbe940c-8d25-4a88-a283-d79785c1ea2a', E'6\n-1 2 1 4 3 -5\n5' , '5', true),
--6
    ('f1933272-1693-4f86-904b-a7aed1dd3846', '07bf0b32-09ce-47d0-b4e1-c0ba35799b43', '7', '1 7', true),
    ('311c98d3-74e2-47fb-90f0-573c13512b0d', '07bf0b32-09ce-47d0-b4e1-c0ba35799b43', '10', '1 2 5 10', true),
    ('721339f3-e103-4f3f-aca9-e57e9aa77fd1', '07bf0b32-09ce-47d0-b4e1-c0ba35799b43', '15', '1 3 5 15', false),
    ('28c79c44-c204-4cbf-b489-a6e6881863a6', '07bf0b32-09ce-47d0-b4e1-c0ba35799b43', '100', '1 2 4 5 10 20 25 50 100', false),
    ('a5002801-64ce-4886-ad25-5ee42f5d6f22', '07bf0b32-09ce-47d0-b4e1-c0ba35799b43', '99', '1 3 9 11 33 99', false),
    ('6bdf8e0e-fdc1-4231-acce-9b2be83983ec', '07bf0b32-09ce-47d0-b4e1-c0ba35799b43', '9973', '1 9973', false),
    ('6e63b91b-cb4d-4997-b642-15f5d1f0406a', '07bf0b32-09ce-47d0-b4e1-c0ba35799b43', '99991', '1 99991', false),
    ('ea448be5-811c-4486-b85e-1a31e6810794', '07bf0b32-09ce-47d0-b4e1-c0ba35799b43', '360', '1 2 3 4 5 6 8 9 10 12 15 18 20 24 30 36 40 45 60 72 90 120 180 360', false),
    ('5d262eb4-d4c1-4654-b08e-3ac13dbeadb8', '07bf0b32-09ce-47d0-b4e1-c0ba35799b43', '49', '1 7 49', false),
    ('40362426-8f76-4488-9377-57cdee93408d', '07bf0b32-09ce-47d0-b4e1-c0ba35799b43', '60', '1 2 3 4 5 6 10 12 15 20 30 60', false),
    ('a23a8ef2-3df0-435b-901c-f40ce4e5cf99', '07bf0b32-09ce-47d0-b4e1-c0ba35799b43', '91', '1 7 13 91', false),
    ('653f4454-4660-41ad-a44a-8344dcbf98a7', '07bf0b32-09ce-47d0-b4e1-c0ba35799b43', '81', '1 3 9 27 81', false),
    ('ac90b45d-2351-4025-8800-d22c3a9badb7', '07bf0b32-09ce-47d0-b4e1-c0ba35799b43', '21', '1 3 7 21', false),
    ('a873e123-5fa7-44a9-b421-e012ac998095', '07bf0b32-09ce-47d0-b4e1-c0ba35799b43', '99999', '1 3 9 11 33 101 303 909 1111 3333 9091 27273 99999', false)
    ;

--7
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('123e4567-e89b-12d3-a456-426614174000', '2f3b15cc-219f-47eb-8d17-702e89afb86a', '9', '1, 3, 9', false);

-- Additional test cases (non-sample cases)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('223e4567-e89b-12d3-a456-426614174002', '2f3b15cc-219f-47eb-8d17-702e89afb86a', '15', '1, 3, 5, 15', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('323e4567-e89b-12d3-a456-426614174003', '2f3b15cc-219f-47eb-8d17-702e89afb86a', '21', '1, 3, 7, 21', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('423e4567-e89b-12d3-a456-426614174004', '2f3b15cc-219f-47eb-8d17-702e89afb86a', '25', '1, 5, 25', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('523e4567-e89b-12d3-a456-426614174005', '2f3b15cc-219f-47eb-8d17-702e89afb86a', '30', '1, 3, 5, 15', true);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('623e4567-e89b-12d3-a456-426614174006', '2f3b15cc-219f-47eb-8d17-702e89afb86a', '50', '1, 5, 25', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('723e4567-e89b-12d3-a456-426614174007', '2f3b15cc-219f-47eb-8d17-702e89afb86a', '99', '1, 3, 9, 11, 33, 99', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('823e4567-e89b-12d3-a456-426614174008', '2f3b15cc-219f-47eb-8d17-702e89afb86a', '100', '1, 5, 25', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('923e4567-e89b-12d3-a456-426614174009', '2f3b15cc-219f-47eb-8d17-702e89afb86a', '225', '1, 3, 5, 9, 15, 25, 45, 75, 225', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('103e4567-e89b-12d3-a456-426614174010', '2f3b15cc-219f-47eb-8d17-702e89afb86a', '500', '1, 5, 25', false);

--8
-- Sample test case for n = 13579 (all odd digits, sample case)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('fced2739-3638-4f85-b984-a19961f35893', 'fe0a658d-7ce9-4524-b388-84539a34a521', '13579', 'true', true);

-- Additional test cases (non-sample cases)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('400fa95a-7d09-4af4-b47c-31c2abe3c496', 'fe0a658d-7ce9-4524-b388-84539a34a521', '24680', 'false', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('521de40c-965d-4d8f-97af-e3c4296799ac', 'fe0a658d-7ce9-4524-b388-84539a34a521', '11111', 'true', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('a382bbca-b4ce-4bdf-923d-148148eb3513', 'fe0a658d-7ce9-4524-b388-84539a34a521', '12345', 'false', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('4c5ec63a-c9cc-4c40-9593-ed07cca593cd', 'fe0a658d-7ce9-4524-b388-84539a34a521', '97531', 'true', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('4636f78d-2388-4eae-9693-fe4bfe3f349f', 'fe0a658d-7ce9-4524-b388-84539a34a521', '86420', 'false', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('efb48cc6-987a-4e20-8095-5530fe8f475b', 'fe0a658d-7ce9-4524-b388-84539a34a521', '35791', 'true', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('995a60f6-509a-4252-a09c-09440d2f3740', 'fe0a658d-7ce9-4524-b388-84539a34a521', '10001', 'false', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('8bb5e9a4-1499-40ad-aa2f-e5ca9213548a', 'fe0a658d-7ce9-4524-b388-84539a34a521', '97531', 'true', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('648261e4-2d55-4308-a86b-a8ff746163b3', 'fe0a658d-7ce9-4524-b388-84539a34a521', '48260', 'false', false);

--9
-- Sample test case for n = 121 (palindromic number, sample case)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('f4a8a61b-8f4b-42d3-afe3-50a0efcb9d1e', '1374d22a-b27b-4d3d-9ad4-b613e1f1e253', '121', 'true', true);

-- Additional test cases (non-sample cases)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('a8b8e72b-9b4b-4e7d-94fa-8b2e3cfa8d1f', '1374d22a-b27b-4d3d-9ad4-b613e1f1e253', '12321', 'true', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('274c4ac1-e015-405a-9862-74673dd6aa2c', '1374d22a-b27b-4d3d-9ad4-b613e1f1e253', '12345', 'false', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('5944e422-5f87-44b5-9c37-aa069ccbbd35', '1374d22a-b27b-4d3d-9ad4-b613e1f1e253', '67876', 'true', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('decbcf46-696a-4109-9222-8471cc6f4b60', '1374d22a-b27b-4d3d-9ad4-b613e1f1e253', '78987', 'true', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('21e25851-e820-425d-be2e-d4a30ef57e02', '1374d22a-b27b-4d3d-9ad4-b613e1f1e253', '45654', 'true', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('bcf0f9da-8625-479e-8267-558bf89cf147', '1374d22a-b27b-4d3d-9ad4-b613e1f1e253', '98765', 'false', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('a2b56da1-2aa9-45c7-8820-efcf32c2897f', '1374d22a-b27b-4d3d-9ad4-b613e1f1e253', '54321', 'false', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('affc734f-537c-4f8f-becd-c46406638953', '1374d22a-b27b-4d3d-9ad4-b613e1f1e253', '10001', 'true', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('5653b5c7-ae47-4a0c-95aa-000f5c3bfa28', '1374d22a-b27b-4d3d-9ad4-b613e1f1e253', '20002', 'true', false);

