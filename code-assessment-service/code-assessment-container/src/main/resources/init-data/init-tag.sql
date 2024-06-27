INSERT INTO tag(id, name, tag_type)
VALUES
    ('4d5d31cc-6386-4ef5-903d-625e64b122d7', 'Array', 'ALGORITHM'),
    ('cd55e806-5d20-4813-b2ce-f8a235fc9151', 'Math', 'ALGORITHM'),
    ('98e3f555-aa71-413d-a5bd-5dd6599ababb', 'Hash Table', 'ALGORITHM'),
    ('dc7551c6-9183-4909-ae0a-dcfaae838883', 'Two Pointer', 'ALGORITHM'),
    ('a5539d34-fda8-4eb2-8e53-a441931da88d', 'Sorting', 'ALGORITHM'),
    ('0445b8ba-a466-4419-b737-5a2a3ce08ddf', 'Binary Tree', 'ALGORITHM'),
    ('dc3bd976-e836-411d-be01-2349ef551f5b', 'Binary Search', 'ALGORITHM'),
    ('b930cc0d-a9fc-4a60-894b-62ef391ad51f', 'Greedy', 'ALGORITHM'),
    ('c11c568a-0aff-465c-a7f2-cf4a587b76cd', 'Counting', 'ALGORITHM'),
    ('d3379a08-30b0-4835-b4b2-468296fd3d07', 'Linked List', 'ALGORITHM'),
    ('f51c408d-2232-484d-833e-1c59733107a7', 'Dynamic Programming', 'ALGORITHM'),
    ('28762fc4-b0c4-47f8-aa7d-6ce02ccb5a47', 'Recursion', 'ALGORITHM'),
    ('8cbb60b7-39d0-462f-8498-b9b3ec80b5c3', 'Stack', 'ALGORITHM'),
    ('9d752cc0-75b3-4dce-b92e-21375e2d61c5', 'String', 'ALGORITHM'),
    ('d4070634-15e1-4b20-8142-ac2b0d7d3b20', 'Matrix', 'ALGORITHM'),
    ('4276d92b-8752-476f-b127-cf1135772249', 'Iterator', 'ALGORITHM'),
    ('6d7ed26b-a88e-4ae0-8660-f5a2e6255247', 'Loop', 'OTHER'),
    ('5ef5d400-575b-4e85-82f2-d2cfe5d97378', 'Condition', 'OTHER'),
    ('ce905845-66a8-45b4-bed2-5da718926bf3', 'Bitwise', 'OTHER'),
    ('2a11f923-7574-466f-a030-374ae5b18700', 'C++', 'OTHER'),
    ('5d49c893-5ab8-4b82-aea5-70ab95bdf89c', 'Java', 'OTHER');

insert into tag_code_question
values
--1
    ('3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', 'cd55e806-5d20-4813-b2ce-f8a235fc9151'),
    ('3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', '2a11f923-7574-466f-a030-374ae5b18700'),
    ('3c5b1113-d267-4d21-bc6e-8cbd4cb57b69', '5d49c893-5ab8-4b82-aea5-70ab95bdf89c'),

--2
    ('f6d7b882-9399-4bc3-baad-6350285bfa78', 'cd55e806-5d20-4813-b2ce-f8a235fc9151'),
    ('f6d7b882-9399-4bc3-baad-6350285bfa78', '4d5d31cc-6386-4ef5-903d-625e64b122d7'),
--    ('f6d7b882-9399-4bc3-baad-6350285bfa78', '2a11f923-7574-466f-a030-374ae5b18700'),
    ('f6d7b882-9399-4bc3-baad-6350285bfa78', '5d49c893-5ab8-4b82-aea5-70ab95bdf89c'),
    ('f6d7b882-9399-4bc3-baad-6350285bfa78', '6d7ed26b-a88e-4ae0-8660-f5a2e6255247'),

--3
    ('48caf2c9-8c81-49a7-b656-c3b024a798c3', '5d49c893-5ab8-4b82-aea5-70ab95bdf89c'),
    ('48caf2c9-8c81-49a7-b656-c3b024a798c3', 'cd55e806-5d20-4813-b2ce-f8a235fc9151'),

--4
    ('2589a5b7-94c9-4a76-86d9-576718ca63c3', '5d49c893-5ab8-4b82-aea5-70ab95bdf89c'),
    ('2589a5b7-94c9-4a76-86d9-576718ca63c3', '4d5d31cc-6386-4ef5-903d-625e64b122d7'),
    ('2589a5b7-94c9-4a76-86d9-576718ca63c3', 'f51c408d-2232-484d-833e-1c59733107a7'),
    ('2589a5b7-94c9-4a76-86d9-576718ca63c3', '4276d92b-8752-476f-b127-cf1135772249'),

--5
    ('2dbe940c-8d25-4a88-a283-d79785c1ea2a', '5d49c893-5ab8-4b82-aea5-70ab95bdf89c'),
    ('2dbe940c-8d25-4a88-a283-d79785c1ea2a', 'dc7551c6-9183-4909-ae0a-dcfaae838883'),
    ('2dbe940c-8d25-4a88-a283-d79785c1ea2a', '4d5d31cc-6386-4ef5-903d-625e64b122d7'),
    ('2dbe940c-8d25-4a88-a283-d79785c1ea2a', 'a5539d34-fda8-4eb2-8e53-a441931da88d'),
--6
    ('07bf0b32-09ce-47d0-b4e1-c0ba35799b43', '2a11f923-7574-466f-a030-374ae5b18700'),
    ('07bf0b32-09ce-47d0-b4e1-c0ba35799b43', 'cd55e806-5d20-4813-b2ce-f8a235fc9151'),
    ('07bf0b32-09ce-47d0-b4e1-c0ba35799b43', '6d7ed26b-a88e-4ae0-8660-f5a2e6255247'),

--7
    ('2f3b15cc-219f-47eb-8d17-702e89afb86a', '2a11f923-7574-466f-a030-374ae5b18700'),
    ('2f3b15cc-219f-47eb-8d17-702e89afb86a', 'cd55e806-5d20-4813-b2ce-f8a235fc9151'),
    ('2f3b15cc-219f-47eb-8d17-702e89afb86a', '6d7ed26b-a88e-4ae0-8660-f5a2e6255247'),

--8
    ('fe0a658d-7ce9-4524-b388-84539a34a521', '2a11f923-7574-466f-a030-374ae5b18700'),
    ('fe0a658d-7ce9-4524-b388-84539a34a521', 'cd55e806-5d20-4813-b2ce-f8a235fc9151'),
    ('fe0a658d-7ce9-4524-b388-84539a34a521', '6d7ed26b-a88e-4ae0-8660-f5a2e6255247'),

--9
    ('1374d22a-b27b-4d3d-9ad4-b613e1f1e253', '2a11f923-7574-466f-a030-374ae5b18700'),
    ('1374d22a-b27b-4d3d-9ad4-b613e1f1e253', 'cd55e806-5d20-4813-b2ce-f8a235fc9151'),
    ('1374d22a-b27b-4d3d-9ad4-b613e1f1e253', '6d7ed26b-a88e-4ae0-8660-f5a2e6255247'),

--10
    ('06d71d03-f5ba-4a89-9083-596ef649ade9', '2a11f923-7574-466f-a030-374ae5b18700'),
    ('06d71d03-f5ba-4a89-9083-596ef649ade9', 'cd55e806-5d20-4813-b2ce-f8a235fc9151'),

--11
    ('b1ae32db-17e6-4fdb-991b-160e95721562', '2a11f923-7574-466f-a030-374ae5b18700'),
    ('b1ae32db-17e6-4fdb-991b-160e95721562', 'cd55e806-5d20-4813-b2ce-f8a235fc9151'),
    ('b1ae32db-17e6-4fdb-991b-160e95721562', 'ce905845-66a8-45b4-bed2-5da718926bf3'),

--12
    ('058cdf70-3cc5-4a99-9edd-edfa0325c207', '2a11f923-7574-466f-a030-374ae5b18700'),
    ('058cdf70-3cc5-4a99-9edd-edfa0325c207', 'cd55e806-5d20-4813-b2ce-f8a235fc9151'),
    ('058cdf70-3cc5-4a99-9edd-edfa0325c207', '6d7ed26b-a88e-4ae0-8660-f5a2e6255247'),

--13
    ('51981528-01ff-491a-bc7b-a24aedfb0363', '2a11f923-7574-466f-a030-374ae5b18700'),
    ('51981528-01ff-491a-bc7b-a24aedfb0363', 'cd55e806-5d20-4813-b2ce-f8a235fc9151'),
    ('51981528-01ff-491a-bc7b-a24aedfb0363', '6d7ed26b-a88e-4ae0-8660-f5a2e6255247'),

--14
    ('6181a38b-2b06-4a60-ad5f-750780d79e3e', '2a11f923-7574-466f-a030-374ae5b18700'),
    ('6181a38b-2b06-4a60-ad5f-750780d79e3e', 'cd55e806-5d20-4813-b2ce-f8a235fc9151'),

--15
    ('22427527-053c-4602-a519-9e52cb5f2366', '5ef5d400-575b-4e85-82f2-d2cfe5d97378'),
    ('22427527-053c-4602-a519-9e52cb5f2366', '2a11f923-7574-466f-a030-374ae5b18700'),

--16
    ('cd39d755-41f1-452f-a0df-09c64c7a67cf', '2a11f923-7574-466f-a030-374ae5b18700'),
    ('cd39d755-41f1-452f-a0df-09c64c7a67cf', 'cd55e806-5d20-4813-b2ce-f8a235fc9151'),
    ('cd39d755-41f1-452f-a0df-09c64c7a67cf', '5ef5d400-575b-4e85-82f2-d2cfe5d97378'),

--17
    ('d49496bb-87a5-483f-9597-564ad6ee0305', '2a11f923-7574-466f-a030-374ae5b18700'),
    ('d49496bb-87a5-483f-9597-564ad6ee0305', 'cd55e806-5d20-4813-b2ce-f8a235fc9151'),
    ('d49496bb-87a5-483f-9597-564ad6ee0305', '5ef5d400-575b-4e85-82f2-d2cfe5d97378'),

--18
    ('4be91526-365b-4e50-99ae-75ba2a87ba08', '2a11f923-7574-466f-a030-374ae5b18700'),
    ('4be91526-365b-4e50-99ae-75ba2a87ba08', 'cd55e806-5d20-4813-b2ce-f8a235fc9151'),
    ('4be91526-365b-4e50-99ae-75ba2a87ba08', '5ef5d400-575b-4e85-82f2-d2cfe5d97378'),

--19
    ('4be91526-365b-4e50-99ae-75ba2a87ba09', 'cd55e806-5d20-4813-b2ce-f8a235fc9151'),
    ('4be91526-365b-4e50-99ae-75ba2a87ba09', '2a11f923-7574-466f-a030-374ae5b18700'),
    ('4be91526-365b-4e50-99ae-75ba2a87ba09', '6d7ed26b-a88e-4ae0-8660-f5a2e6255247'),

--20
    ('fa373da0-9d7d-4ced-bf8b-c06a0063cd4e', '9d752cc0-75b3-4dce-b92e-21375e2d61c5'),
    ('fa373da0-9d7d-4ced-bf8b-c06a0063cd4e', '2a11f923-7574-466f-a030-374ae5b18700'),
    ('fa373da0-9d7d-4ced-bf8b-c06a0063cd4e', '6d7ed26b-a88e-4ae0-8660-f5a2e6255247'),

--21
    ('1f24ac22-737a-4074-9290-ec41bb15e2b0', 'cd55e806-5d20-4813-b2ce-f8a235fc9151'),
    ('1f24ac22-737a-4074-9290-ec41bb15e2b0', '2a11f923-7574-466f-a030-374ae5b18700'),
    ('1f24ac22-737a-4074-9290-ec41bb15e2b0', '6d7ed26b-a88e-4ae0-8660-f5a2e6255247'),

--22
    ('7841c704-b8ae-4664-bb2c-d4a63fb80fd5', 'cd55e806-5d20-4813-b2ce-f8a235fc9151'),
    ('7841c704-b8ae-4664-bb2c-d4a63fb80fd5', '2a11f923-7574-466f-a030-374ae5b18700'),
    ('7841c704-b8ae-4664-bb2c-d4a63fb80fd5', '5ef5d400-575b-4e85-82f2-d2cfe5d97378'),

--23
    ('30a01889-fbc9-4eaf-9f4e-fa0341ea6ced', 'cd55e806-5d20-4813-b2ce-f8a235fc9151'),
    ('30a01889-fbc9-4eaf-9f4e-fa0341ea6ced', '2a11f923-7574-466f-a030-374ae5b18700'),
    ('30a01889-fbc9-4eaf-9f4e-fa0341ea6ced', '5ef5d400-575b-4e85-82f2-d2cfe5d97378'),

--24
    ('25315a21-41a1-464d-b9dc-d4ec978cd2ff', 'cd55e806-5d20-4813-b2ce-f8a235fc9151'),
    ('25315a21-41a1-464d-b9dc-d4ec978cd2ff', '2a11f923-7574-466f-a030-374ae5b18700'),
    ('25315a21-41a1-464d-b9dc-d4ec978cd2ff', '5ef5d400-575b-4e85-82f2-d2cfe5d97378'),

--25
    ('e557b35c-715e-4d21-8aaf-8c86ad5690b1', 'cd55e806-5d20-4813-b2ce-f8a235fc9151'),
    ('e557b35c-715e-4d21-8aaf-8c86ad5690b1', '2a11f923-7574-466f-a030-374ae5b18700'),
    ('e557b35c-715e-4d21-8aaf-8c86ad5690b1', '5ef5d400-575b-4e85-82f2-d2cfe5d97378'),

--26
    ('219cafcd-d4fe-4fb0-81fd-be2da867f9d4', 'cd55e806-5d20-4813-b2ce-f8a235fc9151'),
    ('219cafcd-d4fe-4fb0-81fd-be2da867f9d4', '2a11f923-7574-466f-a030-374ae5b18700'),
    ('219cafcd-d4fe-4fb0-81fd-be2da867f9d4', '5ef5d400-575b-4e85-82f2-d2cfe5d97378')
    ;

--        ('4d5d31cc-6386-4ef5-903d-625e64b122d7', 'Array', 'ALGORITHM'),
--        ('cd55e806-5d20-4813-b2ce-f8a235fc9151', 'Math', 'ALGORITHM'),
--        ('98e3f555-aa71-413d-a5bd-5dd6599ababb', 'Hash Table', 'ALGORITHM'),
--        ('dc7551c6-9183-4909-ae0a-dcfaae838883', 'Two Pointer', 'ALGORITHM'),
--        ('a5539d34-fda8-4eb2-8e53-a441931da88d', 'Sorting', 'ALGORITHM'),
--        ('0445b8ba-a466-4419-b737-5a2a3ce08ddf', 'Binary Tree', 'ALGORITHM'),
--        ('dc3bd976-e836-411d-be01-2349ef551f5b', 'Binary Search', 'ALGORITHM'),
--        ('b930cc0d-a9fc-4a60-894b-62ef391ad51f', 'Greedy', 'ALGORITHM'),
--        ('c11c568a-0aff-465c-a7f2-cf4a587b76cd', 'Counting', 'ALGORITHM'),
--        ('d3379a08-30b0-4835-b4b2-468296fd3d07', 'Linked List', 'ALGORITHM'),
--        ('f51c408d-2232-484d-833e-1c59733107a7', 'Dynamic Programming', 'ALGORITHM'),
--        ('28762fc4-b0c4-47f8-aa7d-6ce02ccb5a47', 'Recursion', 'ALGORITHM'),
--        ('8cbb60b7-39d0-462f-8498-b9b3ec80b5c3', 'Stack', 'ALGORITHM'),
--        ('9d752cc0-75b3-4dce-b92e-21375e2d61c5', 'String', 'ALGORITHM'),
--        ('d4070634-15e1-4b20-8142-ac2b0d7d3b20', 'Matrix', 'ALGORITHM'),
--        ('4276d92b-8752-476f-b127-cf1135772249', 'Iterator', 'ALGORITHM'),
--        ('6d7ed26b-a88e-4ae0-8660-f5a2e6255247', 'Loop', 'OTHER'),
--        ('5ef5d400-575b-4e85-82f2-d2cfe5d97378', 'Condition', 'OTHER'),
--        ('ce905845-66a8-45b4-bed2-5da718926bf3', 'Bitwise', 'OTHER'),
--        ('2a11f923-7574-466f-a030-374ae5b18700', 'C++', 'OTHER'),
--        ('5d49c893-5ab8-4b82-aea5-70ab95bdf89c', 'Java', 'OTHER');