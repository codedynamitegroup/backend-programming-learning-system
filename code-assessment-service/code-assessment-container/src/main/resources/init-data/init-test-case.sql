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

--10
-- Sample test case for n = 15
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('550e8400-e29b-41d4-a716-446655440010', '06d71d03-f5ba-4a89-9083-596ef649ade9', '15', '4', true);

-- Additional test cases (non-sample cases)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('550e8400-e29b-41d4-a716-446655440011', '06d71d03-f5ba-4a89-9083-596ef649ade9', '1', '0', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('550e8400-e29b-41d4-a716-446655440012', '06d71d03-f5ba-4a89-9083-596ef649ade9', '10', '3', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('550e8400-e29b-41d4-a716-446655440013', '06d71d03-f5ba-4a89-9083-596ef649ade9', '20', '5', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('550e8400-e29b-41d4-a716-446655440014', '06d71d03-f5ba-4a89-9083-596ef649ade9', '50', '9', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('550e8400-e29b-41d4-a716-446655440015', '06d71d03-f5ba-4a89-9083-596ef649ade9', '100', '13', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('550e8400-e29b-41d4-a716-446655440016', '06d71d03-f5ba-4a89-9083-596ef649ade9', '500', '31', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('550e8400-e29b-41d4-a716-446655440017', '06d71d03-f5ba-4a89-9083-596ef649ade9', '1000', '44', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('550e8400-e29b-41d4-a716-446655440018', '06d71d03-f5ba-4a89-9083-596ef649ade9', '5050', '99', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('550e8400-e29b-41d4-a716-446655440019', '06d71d03-f5ba-4a89-9083-596ef649ade9', '101', '13', false);

--11
-- Sample test case for n = 8 (2^3)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('550e8400-e29b-41d4-a716-446655441000', 'b1ae32db-17e6-4fdb-991b-160e95721562', '8', 'true', true);

-- Additional test cases (non-sample cases)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('550e8400-e29b-41d4-a716-446655441001', 'b1ae32db-17e6-4fdb-991b-160e95721562', '1', 'true', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('550e8400-e29b-41d4-a716-446655441002', 'b1ae32db-17e6-4fdb-991b-160e95721562', '4', 'true', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('550e8400-e29b-41d4-a716-446655441003', 'b1ae32db-17e6-4fdb-991b-160e95721562', '16', 'true', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('550e8400-e29b-41d4-a716-446655441004', 'b1ae32db-17e6-4fdb-991b-160e95721562', '10000', 'false', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('550e8400-e29b-41d4-a716-446655441005', 'b1ae32db-17e6-4fdb-991b-160e95721562', '1023', 'false', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('550e8400-e29b-41d4-a716-446655441006', 'b1ae32db-17e6-4fdb-991b-160e95721562', '4096', 'true', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('550e8400-e29b-41d4-a716-446655441007', 'b1ae32db-17e6-4fdb-991b-160e95721562', '5000', 'false', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('550e8400-e29b-41d4-a716-446655441008', 'b1ae32db-17e6-4fdb-991b-160e95721562', '8192', 'true', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('550e8400-e29b-41d4-a716-446655441009', 'b1ae32db-17e6-4fdb-991b-160e95721562', '9999', 'false', false);

--12
-- Sample test case for n = 27 (3^3)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('550e8400-e29b-41d4-a716-446655442000', '058cdf70-3cc5-4a99-9edd-edfa0325c207', '27', 'true', true);

-- Additional test cases (non-sample cases)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('550e8400-e29b-41d4-a716-446655442001', '058cdf70-3cc5-4a99-9edd-edfa0325c207', '1', 'true', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('550e8400-e29b-41d4-a716-446655442002', '058cdf70-3cc5-4a99-9edd-edfa0325c207', '9', 'true', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('550e8400-e29b-41d4-a716-446655442003', '058cdf70-3cc5-4a99-9edd-edfa0325c207', '81', 'true', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('550e8400-e29b-41d4-a716-446655442004', '058cdf70-3cc5-4a99-9edd-edfa0325c207', '10000', 'false', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('550e8400-e29b-41d4-a716-446655442005', '058cdf70-3cc5-4a99-9edd-edfa0325c207', '1023', 'false', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('550e8400-e29b-41d4-a716-446655442006', '058cdf70-3cc5-4a99-9edd-edfa0325c207', '729', 'true', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('550e8400-e29b-41d4-a716-446655442007', '058cdf70-3cc5-4a99-9edd-edfa0325c207', '5000', 'false', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('550e8400-e29b-41d4-a716-446655442008', '058cdf70-3cc5-4a99-9edd-edfa0325c207', '6561', 'true', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('550e8400-e29b-41d4-a716-446655442009', '058cdf70-3cc5-4a99-9edd-edfa0325c207', '9999', 'false', false);

--13
-- Sample test case for n = 2 and x = 1.5
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('550e8400-e29b-41d4-a716-446655440000', '51981528-01ff-491a-bc7b-a24aedfb0363', '2 1.5', '2.250', true);

-- Additional test cases (non-sample cases)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('550e8400-e29b-41d4-a716-446655440001', '51981528-01ff-491a-bc7b-a24aedfb0363', '3 2.0', '6.333', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('550e8400-e29b-41d4-a716-446655440002', '51981528-01ff-491a-bc7b-a24aedfb0363', '4 1.1', '2.918', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('550e8400-e29b-41d4-a716-446655440003', '51981528-01ff-491a-bc7b-a24aedfb0363', '5 0.5', '1.917', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('550e8400-e29b-41d4-a716-446655440004', '51981528-01ff-491a-bc7b-a24aedfb0363', '6 3.0', '1822.591', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('550e8400-e29b-41d4-a716-446655440005', '51981528-01ff-491a-bc7b-a24aedfb0363', '7 1.5', '8.352', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('550e8400-e29b-41d4-a716-446655440006', '51981528-01ff-491a-bc7b-a24aedfb0363', '8 0.8', '1.657', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('550e8400-e29b-41d4-a716-446655440007', '51981528-01ff-491a-bc7b-a24aedfb0363', '9 2.5', '2924.165', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('550e8400-e29b-41d4-a716-446655440008', '51981528-01ff-491a-bc7b-a24aedfb0363', '10 1.2', '3.521', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('550e8400-e29b-41d4-a716-446655440009', '51981528-01ff-491a-bc7b-a24aedfb0363', '11 0.9', '2.134', false);

--14
-- Sample test case for n = 4 (which is 2^2, so it is a perfect square)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('4c835055-1f31-444e-866d-4db138dd1f12', '6181a38b-2b06-4a60-ad5f-750780d79e3e', '4', 'true', true);

-- Additional test cases (non-sample cases)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('8dbd6303-0794-4650-8b53-294e0e3102a8', '6181a38b-2b06-4a60-ad5f-750780d79e3e', '3', 'false', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('5ecb7724-5f76-4c3c-ad64-6b0be7ff630d', '6181a38b-2b06-4a60-ad5f-750780d79e3e', '16', 'true', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('c62592bb-92e6-49bb-abf2-de18ada29719', '6181a38b-2b06-4a60-ad5f-750780d79e3e', '25', 'true', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('1287f878-8820-43d8-9d83-b9fd79844852', '6181a38b-2b06-4a60-ad5f-750780d79e3e', '50', 'false', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('c3333875-f233-4ae7-9161-2afe375c53a5', '6181a38b-2b06-4a60-ad5f-750780d79e3e', '100', 'true', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('745ef3d2-f41e-45c4-af26-628350a5db93', '6181a38b-2b06-4a60-ad5f-750780d79e3e', '200', 'false', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('1677dfea-2f69-4a16-8a7a-b6ed5f06bda8', '6181a38b-2b06-4a60-ad5f-750780d79e3e', '256', 'true', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('1a8c5fec-18b7-4ef5-bd97-0cdae5e0546e', '6181a38b-2b06-4a60-ad5f-750780d79e3e', '10000', 'true', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('2e837260-43c9-43c7-8190-6d8fa3aca93b', '6181a38b-2b06-4a60-ad5f-750780d79e3e', '99999', 'false', false);


--15
-- Sample test case for a = 3.5, b = 6.1, c = 2.4 (max is 6.1)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('6d36d139-42ca-4873-8f0b-d3d5cead9349', '22427527-053c-4602-a519-9e52cb5f2366', '3.5 6.1 2.4', '6.1', true);

-- Additional test cases (non-sample cases)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('649d4026-388f-4b31-9475-50ba522c621c', '22427527-053c-4602-a519-9e52cb5f2366', '10.2 15.5 9.9', '15.5', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('94199462-d79d-43d2-875d-8fc238050437', '22427527-053c-4602-a519-9e52cb5f2366', '7.7 2.2 5.5', '7.7', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('773f661a-9b08-44ff-851d-5b90cb595226', '22427527-053c-4602-a519-9e52cb5f2366', '12.5 13.6 14.7', '14.7', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('5fcea8c0-a308-44e2-a8c9-7944217d330a', '22427527-053c-4602-a519-9e52cb5f2366', '25.1 24.9 25.2', '25.2', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('4003de43-6b13-4417-87d2-4823376d7c3f', '22427527-053c-4602-a519-9e52cb5f2366', '8.0 8.0 8.0', '8.0', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('4dabd6fa-1724-4166-897e-640e4eefabd5', '22427527-053c-4602-a519-9e52cb5f2366', '9.9 8.8 7.7', '9.9', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('edcf1fdc-f636-4f34-bad7-f85b908ac565', '22427527-053c-4602-a519-9e52cb5f2366', '55.5 44.4 66.6', '66.6', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('fdc304c0-3627-4e53-a673-346f87d473d9', '22427527-053c-4602-a519-9e52cb5f2366', '99.9 88.8 77.7', '99.9', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('de64856f-53aa-4198-91e9-a1fd00761e4b', '22427527-053c-4602-a519-9e52cb5f2366', '14.14 15.15 16.16', '16.16', false);


--16
-- Sample test case for a = 3.5, b = 6.1 (both are positive, so they have the same sign)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('857c4140-550a-4eab-9745-ffa072b98941', 'cd39d755-41f1-452f-a0df-09c64c7a67cf', '3.5 6.1', 'true', true);

-- Additional test cases (non-sample cases)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('82ddaa49-a1cb-4398-a6e0-14f8aff23903', 'cd39d755-41f1-452f-a0df-09c64c7a67cf', '-3.5 -6.1', 'true', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('196b3479-f80f-44d8-90f9-1d749f825da9', 'cd39d755-41f1-452f-a0df-09c64c7a67cf', '3.5 -6.1', 'false', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('7793b8ec-e6db-4be5-b541-3051fa2d0a9a', 'cd39d755-41f1-452f-a0df-09c64c7a67cf', '-3.5 6.1', 'false', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('d8f2ca77-da92-4679-ae98-dc17c593a8c8', 'cd39d755-41f1-452f-a0df-09c64c7a67cf', '0.0 0.0', 'true', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('6c42e919-d008-4883-8289-6293348a2935', 'cd39d755-41f1-452f-a0df-09c64c7a67cf', '0.0 -1.0', 'false', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('0de6b494-6f0a-4efc-93f8-902162b89ab6', 'cd39d755-41f1-452f-a0df-09c64c7a67cf', '-1.0 0.0', 'false', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('d8f5315e-e1ac-4899-9ff8-e492cf2f8623', 'cd39d755-41f1-452f-a0df-09c64c7a67cf', '1.0 -1.0', 'false', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('0eecc05c-da2f-43e2-ac54-a1d652b6ae22', 'cd39d755-41f1-452f-a0df-09c64c7a67cf', '-1.0 1.0', 'false', false);

INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('3c89368c-b59f-4ebf-b0b6-ab00d01f8ead', 'cd39d755-41f1-452f-a0df-09c64c7a67cf', '1.1 2.2', 'true', false);

--17
-- Sample test case for a = 2, b = -4 (solution x = 2)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('6627f5b1-2133-419c-9356-147126c7bd93', 'd49496bb-87a5-483f-9597-564ad6ee0305', '2 -4', '2.000', true);

-- Additional test cases (non-sample cases)
-- Case: a = 0, b = 0 (Infinite solutions)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('ab75b980-491e-4fc5-b707-9f8cd17f6293', 'd49496bb-87a5-483f-9597-564ad6ee0305', '0 0', 'Infinite solutions', false);

-- Case: a = 0, b != 0 (No solution)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('68813611-b43c-4b16-9aa2-90ef2f80ea7a', 'd49496bb-87a5-483f-9597-564ad6ee0305', '0 5', 'No solution', false);

-- Case: a != 0, b = 0 (x = 0)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('c13a8cfc-f668-40a5-a88f-4b9ddef24cbb', 'd49496bb-87a5-483f-9597-564ad6ee0305', '3 0', '0.000', false);

-- Case: a and b are negative
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('58e7c748-1a75-43f6-874e-7d41f4ada3b9', 'd49496bb-87a5-483f-9597-564ad6ee0305', '-2 -4', '-2.000', false);

-- Case: a and b are positive
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('6d2cadc9-0f89-410c-b040-c0d5b7ef44a7', 'd49496bb-87a5-483f-9597-564ad6ee0305', '5 10', '-2.000', false);

-- Case: a is positive and b is negative
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('4988b8e3-3df1-41b3-b20a-c8b5b3f33698', 'd49496bb-87a5-483f-9597-564ad6ee0305', '4 -8', '2.000', false);

-- Case: a is negative and b is positive
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('8c6f0bd5-a9ba-4f89-a4c8-82e8958d0795', 'd49496bb-87a5-483f-9597-564ad6ee0305', '-4 8', '-2.000', false);

-- Case: a = -100, b = 100
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('bc76f7dd-c88e-4a56-bf37-d7cbcfae26bf', 'd49496bb-87a5-483f-9597-564ad6ee0305', '-100 100', '-1.000', false);

-- Case: a = 100, b = -100
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('a2ae8649-28a1-4cb4-8cbd-f44721ef9e0b', 'd49496bb-87a5-483f-9597-564ad6ee0305', '100 -100', '1.000', false);

--18
-- Sample test case for month = 1 (Quarter 1)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('8a1bcf4e-1f3a-11ee-be56-0242ac120002', '4be91526-365b-4e50-99ae-75ba2a87ba08', '1', 'Quarter 1', true);

-- Additional test cases (non-sample cases)
-- Case: month = 2 (Quarter 1)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('8a1bcf4e-1f3a-11ee-be56-0242ac120003', '4be91526-365b-4e50-99ae-75ba2a87ba08', '2', 'Quarter 1', false);

-- Case: month = 4 (Quarter 2)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('8a1bcf4e-1f3a-11ee-be56-0242ac120004', '4be91526-365b-4e50-99ae-75ba2a87ba08', '4', 'Quarter 2', false);

-- Case: month = 7 (Quarter 3)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('8a1bcf4e-1f3a-11ee-be56-0242ac120005', '4be91526-365b-4e50-99ae-75ba2a87ba08', '7', 'Quarter 3', false);

-- Case: month = 10 (Quarter 4)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('8a1bcf4e-1f3a-11ee-be56-0242ac120006', '4be91526-365b-4e50-99ae-75ba2a87ba08', '10', 'Quarter 4', false);

-- Case: month = 12 (Quarter 4)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('8a1bcf4e-1f3a-11ee-be56-0242ac120007', '4be91526-365b-4e50-99ae-75ba2a87ba08', '12', 'Quarter 4', false);

--19
-- Sample test case for n = 1 (S(1) = 1^3 = 1)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('d41d8cd9-4a3b-4f58-9fc1-a5d14c4c7f00', '4be91526-365b-4e50-99ae-75ba2a87ba09', '1', '1', true);

-- Additional test cases (non-sample cases)
-- Case: n = 2 (S(2) = 1^3 + 2^3 = 1 + 8 = 9)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('d41d8cd9-4a3b-4f58-9fc1-a5d14c4c7f01', '4be91526-365b-4e50-99ae-75ba2a87ba09', '2', '9', false);

-- Case: n = 3 (S(3) = 1^3 + 2^3 + 3^3 = 1 + 8 + 27 = 36)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('d41d8cd9-4a3b-4f58-9fc1-a5d14c4c7f02', '4be91526-365b-4e50-99ae-75ba2a87ba09', '3', '36', false);

-- Case: n = 10 (S(10) = 1^3 + 2^3 + ... + 10^3 = 3025)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('d41d8cd9-4a3b-4f58-9fc1-a5d14c4c7f03', '4be91526-365b-4e50-99ae-75ba2a87ba09', '10', '3025', false);

-- Case: n = 100 (S(100) = 1^3 + 2^3 + ... + 100^3 = 25502500)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('d41d8cd9-4a3b-4f58-9fc1-a5d14c4c7f04', '4be91526-365b-4e50-99ae-75ba2a87ba09', '100', '25502500', false);

--20
-- Sample test case for n = 1 (A)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('ab3f10f4-f595-4b63-8ead-ed8d26973231', 'fa373da0-9d7d-4ced-bf8b-c06a0063cd4e', '2', 'AB', true);

-- Additional test cases (non-sample cases)
-- Case: n = 5 (ABCDE)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('e2141007-d713-44c5-a46e-9543b1959435', 'fa373da0-9d7d-4ced-bf8b-c06a0063cd4e', '5', 'ABCDE', false);

-- Case: n = 10 (ABCDEFGHIJ)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('5144f19b-a4cf-44a2-bd61-8e27cc5f8152', 'fa373da0-9d7d-4ced-bf8b-c06a0063cd4e', '10', 'ABCDEFGHIJ', false);

-- Case: n = 26 (ABCDEFGHIJKLMNOPQRSTUVWXYZ)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('5ecf4b1f-2b57-408b-a24e-f66effbcc242', 'fa373da0-9d7d-4ced-bf8b-c06a0063cd4e', '26', 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', false);

--21
-- Sample test case for n = 2 (prime number)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('6fb4ea47-0dc9-4891-8ac2-a4d0152a07a9', '1f24ac22-737a-4074-9290-ec41bb15e2b0', '2', 'true', true);

-- Additional test cases (non-sample cases)
-- Case: n = 4 (not a prime number)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('0c46783c-60ae-4e8f-a205-f74d47b60fd7', '1f24ac22-737a-4074-9290-ec41bb15e2b0', '4', 'false', true);

-- Case: n = 17 (prime number)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('53c14139-d991-45ff-91fa-e51a47198502', '1f24ac22-737a-4074-9290-ec41bb15e2b0', '17', 'true', false);

-- Case: n = 100000 (not a prime number)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('d7b950a4-7f5a-4924-a470-706d16fbd29a', '1f24ac22-737a-4074-9290-ec41bb15e2b0', '100000', 'false', false);

-- Case: n = 99991 (prime number)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('297ddc34-cef2-4bd7-9a1d-d156bb0e477c', '1f24ac22-737a-4074-9290-ec41bb15e2b0', '99991', 'true', false);

--22
-- Sample test case for input (-5.5, 10.2, -300.3)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('f27b9c3b-6f7d-4a5b-83c7-ef60a7b1fcfa', '7841c704-b8ae-4664-bb2c-d4a63fb80fd5', '-5.5 10.2 -300.3', '5.5 10.2 300.3', true);

-- Additional test cases (non-sample cases)
-- Case: input (0.5, -0.8, 99.9)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('8b19dca5-99b8-4bba-8d97-946cf4d7a0d5', '7841c704-b8ae-4664-bb2c-d4a63fb80fd5', '0.5 -0.8 99.9', '0.5 0.8 99.9', false);

-- Case: input (-123.45, 678.9, -0.01)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('4e7a883e-c58c-42e5-9c8e-8a7f85a4b619', '7841c704-b8ae-4664-bb2c-d4a63fb80fd5', '-123.45 678.9 -0.01', '123.45 678.9 0.01', false);

-- Case: input (400.0, 500.1, 600.2)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('9b31f6d6-4b75-4d91-922d-4f3835f9a8b8', '7841c704-b8ae-4664-bb2c-d4a63fb80fd5', '400 500.1 600.2', '400 500.1 600.2', false);

-- Case: input (-999.99, -0.0001, 0.01)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('f18ec18c-f1b6-49a8-a49b-7bfb7eac6d13', '7841c704-b8ae-4664-bb2c-d4a63fb80fd5', '-999.99 -0.0001 0.01', '999.99 0.0001 0.01', false);

--23
-- Sample test case for input (3, 4, 5) - Tam giác vuông
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('a3f0d5be-bd1c-4f9e-bc8e-e4d9d1b0d1d8', '30a01889-fbc9-4eaf-9f4e-fa0341ea6ced', '3 4 5', 'Right triangle', true);

-- Additional test cases (non-sample cases)
-- Case: input (5, 5, 5) - Tam giác đều
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('b17c15ec-2a45-4b25-81f3-9d67f10a1f1c', '30a01889-fbc9-4eaf-9f4e-fa0341ea6ced', '5 5 5', 'Equilateral triangle', false);

-- Case: input (5, 5, 8) - Tam giác cân
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('4b3e0bb4-7f8d-4e57-a3b1-4d7d5c8c5f0f', '30a01889-fbc9-4eaf-9f4e-fa0341ea6ced', '5 5 8', 'Isosceles triangle', false);
-- Case: input (6, 8, 10) - Tam giác vuông
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('2e47d56d-3f5e-4d6e-94f5-3c9b2a8a1e7f', '30a01889-fbc9-4eaf-9f4e-fa0341ea6ced', '6 8 10', 'Right triangle', false);

-- Case: input (3, 6, 8) - Tam giác thường
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('e75d2b99-774b-4f5d-918c-9a2b54d2b0e9', '30a01889-fbc9-4eaf-9f4e-fa0341ea6ced', '3 6 8', 'Triangle', false);

-- Case: input (1, 2, 3) - Không phải tam giác
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('fa9c1e7c-7b2b-4976-a7b5-3fcd0c2e8e9a', '30a01889-fbc9-4eaf-9f4e-fa0341ea6ced', '1 2 3', 'Not a triangle', false);

--24
-- Sample test case for input (2, 2020) - February in a leap year
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('1a2b3c4d-5e6f-7a8b-9c0d-1e2f3a4b5c6d', '25315a21-41a1-464d-b9dc-d4ec978cd2ff', '2 2020', '29', true);

-- Additional test cases (non-sample cases)
-- Case: input (1, 2021) - January
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('2b3c4d5e-6f7a-8b9c-0d1e-2f3a4b5c6d7e', '25315a21-41a1-464d-b9dc-d4ec978cd2ff', '1 2021', '31', false);

-- Case: input (2, 2021) - February in a non-leap year
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('3c4d5e6f-7a8b-9c0d-1e2f-3a4b5c6d7e8f', '25315a21-41a1-464d-b9dc-d4ec978cd2ff', '2 2021', '28', false);

-- Case: input (4, 2021) - April
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('4d5e6f7a-8b9c-0d1e-2f3a-4b5c6d7e8f9a', '25315a21-41a1-464d-b9dc-d4ec978cd2ff', '4 2021', '30', false);

-- Case: input (12, 2021) - December
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('5e6f7a8b-9c0d-1e2f-3a4b-5c6d7e8f9a0b', '25315a21-41a1-464d-b9dc-d4ec978cd2ff', '12 2021', '31', false);

--25
-- Sample test case for input '2024-06-26'
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('ab98c08f-0d0f-4631-bf98-cffde47abf41', 'e557b35c-715e-4d21-8aaf-8c86ad5690b1', '2024 6 26', '2024-06-25, 2024-06-27', true);

-- Additional test cases (non-sample cases)
-- Case: input '2024-01-01' - start of the year
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('cca7621a-235e-43f8-ba65-2f55040da2ed', 'e557b35c-715e-4d21-8aaf-8c86ad5690b1', '2024 1 1', '2023-12-31, 2024-01-02', false);

-- Case: input '2024-02-29' - leap year
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('8004c1cc-8b12-4ced-8277-fd584bcbf9f3', 'e557b35c-715e-4d21-8aaf-8c86ad5690b1', '2024 2 29', '2024-02-28, 2024-03-01', false);

-- Case: input '2024-12-31' - end of the year
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('51055fa5-1662-4e8a-9fdf-bd7359f41c2f', 'e557b35c-715e-4d21-8aaf-8c86ad5690b1', '2024 12 31', '2024-12-30, 2025-01-01', false);

-- Case: input '2024-07-01'
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('c881861c-4ead-4cdd-a88a-db6ce0944779', 'e557b35c-715e-4d21-8aaf-8c86ad5690b1', '2024 7 1', '2024-06-30, 2024-07-02', false);

--26
-- Sample test case for input '2024-03-01' which is a Friday
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('6bd949ed-26e0-4b62-b210-d67bbebd87a7', '219cafcd-d4fe-4fb0-81fd-be2da867f9d4', '2024-03-01', 'Friday', true);

-- Additional test cases (non-sample cases)
-- Case: input '2024-01-01' which is a Monday
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('0ae61e21-ee29-47de-9288-f190d7fbfee4', '219cafcd-d4fe-4fb0-81fd-be2da867f9d4', '2024-01-01', 'Monday', false);

-- Case: input '2024-12-31' which is a Tuesday
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('0668fbc4-85f0-4786-bb27-5a5df6543fb3', '219cafcd-d4fe-4fb0-81fd-be2da867f9d4', '2024-12-31', 'Tuesday', false);

-- Case: input '2024-02-29' which is a Thursday (Leap year)
INSERT INTO test_cases (id, code_question_id, input_data, output_data, is_sample)
VALUES ('3a645e59-063c-4e05-b2e8-b866b04abe9b', '219cafcd-d4fe-4fb0-81fd-be2da867f9d4', '2024-02-29', 'Thursday', false);
