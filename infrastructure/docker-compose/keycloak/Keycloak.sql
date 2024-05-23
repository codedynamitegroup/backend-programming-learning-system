/*
 Navicat Premium Data Transfer

 Source Server         : PG
 Source Server Type    : PostgreSQL
 Source Server Version : 150006 (150006)
 Source Host           : localhost:5436
 Source Catalog        : keycloak
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 150006 (150006)
 File Encoding         : 65001

 Date: 21/05/2024 20:45:13
*/


-- ----------------------------
-- Table structure for admin_event_entity
-- ----------------------------
DROP TABLE IF EXISTS "public"."admin_event_entity";
CREATE TABLE "public"."admin_event_entity" (
  "id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "admin_event_time" int8,
  "realm_id" varchar(255) COLLATE "pg_catalog"."default",
  "operation_type" varchar(255) COLLATE "pg_catalog"."default",
  "auth_realm_id" varchar(255) COLLATE "pg_catalog"."default",
  "auth_client_id" varchar(255) COLLATE "pg_catalog"."default",
  "auth_user_id" varchar(255) COLLATE "pg_catalog"."default",
  "ip_address" varchar(255) COLLATE "pg_catalog"."default",
  "resource_path" varchar(2550) COLLATE "pg_catalog"."default",
  "representation" text COLLATE "pg_catalog"."default",
  "error" varchar(255) COLLATE "pg_catalog"."default",
  "resource_type" varchar(64) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of admin_event_entity
-- ----------------------------

-- ----------------------------
-- Table structure for associated_policy
-- ----------------------------
DROP TABLE IF EXISTS "public"."associated_policy";
CREATE TABLE "public"."associated_policy" (
  "policy_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "associated_policy_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of associated_policy
-- ----------------------------
INSERT INTO "public"."associated_policy" VALUES ('87efea1a-01ea-44f2-b473-012a1c846dad', '1bb684a2-4982-49d3-bddf-49f26f1cc901');
INSERT INTO "public"."associated_policy" VALUES ('975f2b8c-344a-4e00-9a6d-de34e2675854', 'e1a403f3-c854-4ceb-a018-2b27daf79b0f');

-- ----------------------------
-- Table structure for authentication_execution
-- ----------------------------
DROP TABLE IF EXISTS "public"."authentication_execution";
CREATE TABLE "public"."authentication_execution" (
  "id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "alias" varchar(255) COLLATE "pg_catalog"."default",
  "authenticator" varchar(36) COLLATE "pg_catalog"."default",
  "realm_id" varchar(36) COLLATE "pg_catalog"."default",
  "flow_id" varchar(36) COLLATE "pg_catalog"."default",
  "requirement" int4,
  "priority" int4,
  "authenticator_flow" bool NOT NULL DEFAULT false,
  "auth_flow_id" varchar(36) COLLATE "pg_catalog"."default",
  "auth_config" varchar(36) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of authentication_execution
-- ----------------------------
INSERT INTO "public"."authentication_execution" VALUES ('775fcaa0-bbd4-4f0e-ad62-019a6b4fb4ff', NULL, 'auth-cookie', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'f9ba9768-3c62-4ef6-8b86-046b40d47cc5', 2, 10, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('6e362f90-f929-44fe-84d3-24a798d859e8', NULL, 'auth-spnego', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'f9ba9768-3c62-4ef6-8b86-046b40d47cc5', 3, 20, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('7fb57b35-0660-4f4c-bcbf-1a700082d7b7', NULL, 'identity-provider-redirector', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'f9ba9768-3c62-4ef6-8b86-046b40d47cc5', 2, 25, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('e2d1b87b-af04-4e17-bf51-2162b76a70e0', NULL, NULL, '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'f9ba9768-3c62-4ef6-8b86-046b40d47cc5', 2, 30, 't', '6b428d10-205f-4da9-871b-37d8a2a5462f', NULL);
INSERT INTO "public"."authentication_execution" VALUES ('25deed58-6caa-47ea-b39c-33e492bef9b3', NULL, 'auth-username-password-form', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '6b428d10-205f-4da9-871b-37d8a2a5462f', 0, 10, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('a78d5017-19c4-4151-aa4a-41831d83ed05', NULL, NULL, '2615b5da-5c3b-432f-af31-9af5f519b2a6', '6b428d10-205f-4da9-871b-37d8a2a5462f', 1, 20, 't', '0b861432-43d6-40ff-8196-e995d2fedf1e', NULL);
INSERT INTO "public"."authentication_execution" VALUES ('01c3cd77-03e4-42df-9be5-c142d6b139fc', NULL, 'conditional-user-configured', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '0b861432-43d6-40ff-8196-e995d2fedf1e', 0, 10, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('9bb8820b-45dd-4aff-b649-62eb758a989e', NULL, 'auth-otp-form', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '0b861432-43d6-40ff-8196-e995d2fedf1e', 0, 20, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('0e2c54dc-03ee-4a19-8e34-7832b1784fa0', NULL, 'direct-grant-validate-username', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '31da6c0f-6efa-4e95-b14b-deac1ba6a735', 0, 10, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('9c9dec87-76c2-4bd6-8244-c1e803f2b547', NULL, 'direct-grant-validate-password', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '31da6c0f-6efa-4e95-b14b-deac1ba6a735', 0, 20, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('15420348-ebbd-4f84-afa0-ef016e78aff6', NULL, NULL, '2615b5da-5c3b-432f-af31-9af5f519b2a6', '31da6c0f-6efa-4e95-b14b-deac1ba6a735', 1, 30, 't', '271cc0a2-b927-432c-a275-c6081ba226f5', NULL);
INSERT INTO "public"."authentication_execution" VALUES ('082930af-2e24-43e3-a24d-d08eb6d79059', NULL, 'conditional-user-configured', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '271cc0a2-b927-432c-a275-c6081ba226f5', 0, 10, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('0c113522-aab2-498e-911b-709930f5e256', NULL, 'direct-grant-validate-otp', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '271cc0a2-b927-432c-a275-c6081ba226f5', 0, 20, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('68dd25b7-7d12-44a5-9980-3e33e4775a8a', NULL, 'registration-page-form', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '3fd1a01f-589b-458b-aca1-5aa5159e84ff', 0, 10, 't', '4e5c2754-2499-4041-82e2-58e59a804d8b', NULL);
INSERT INTO "public"."authentication_execution" VALUES ('895d21ff-4fdf-4aeb-897d-165aa1f9871d', NULL, 'registration-user-creation', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '4e5c2754-2499-4041-82e2-58e59a804d8b', 0, 20, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('396d9816-840a-443a-97a2-fff110407702', NULL, 'registration-profile-action', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '4e5c2754-2499-4041-82e2-58e59a804d8b', 0, 40, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('ea1bf798-a7a1-4a87-9a54-0f7852461e44', NULL, 'registration-password-action', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '4e5c2754-2499-4041-82e2-58e59a804d8b', 0, 50, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('8be6d768-f73a-4fa3-9b3f-13cee2e818f6', NULL, 'registration-recaptcha-action', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '4e5c2754-2499-4041-82e2-58e59a804d8b', 3, 60, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('be2bac66-70d5-469e-88a7-9ec233232537', NULL, 'registration-terms-and-conditions', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '4e5c2754-2499-4041-82e2-58e59a804d8b', 3, 70, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('57dbd649-abdb-48b9-a0af-5f540b2d821b', NULL, 'reset-credentials-choose-user', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'ac953ec0-1e20-456f-9069-61d433213c63', 0, 10, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('282c9b83-391d-4662-967f-4751087ac52c', NULL, 'reset-credential-email', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'ac953ec0-1e20-456f-9069-61d433213c63', 0, 20, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('db0781bb-73f6-4c0d-a987-9b2c6dac39a9', NULL, 'reset-password', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'ac953ec0-1e20-456f-9069-61d433213c63', 0, 30, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('2d0912e1-5b74-457a-ad80-00a0fd81f38e', NULL, NULL, '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'ac953ec0-1e20-456f-9069-61d433213c63', 1, 40, 't', '15e64cb2-cc9a-403f-bb43-ab35459a1997', NULL);
INSERT INTO "public"."authentication_execution" VALUES ('496e54ed-e977-4e10-a48d-e742b9978701', NULL, 'conditional-user-configured', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '15e64cb2-cc9a-403f-bb43-ab35459a1997', 0, 10, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('207dd6ff-132e-4df1-baa8-b3872fce5a0f', NULL, 'reset-otp', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '15e64cb2-cc9a-403f-bb43-ab35459a1997', 0, 20, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('d5855ebd-e655-446c-8369-ceda2c7cc7e0', NULL, 'client-secret', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '79b8ae65-8961-45fd-8b80-efc6068046f1', 2, 10, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('7adddb98-e3cb-4f67-8abb-3e2271d9e08b', NULL, 'client-jwt', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '79b8ae65-8961-45fd-8b80-efc6068046f1', 2, 20, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('e9fd11f6-b0c9-4f4e-a635-866e84756918', NULL, 'client-secret-jwt', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '79b8ae65-8961-45fd-8b80-efc6068046f1', 2, 30, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('b637de20-98a8-4adb-8113-9247a334e09e', NULL, 'client-x509', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '79b8ae65-8961-45fd-8b80-efc6068046f1', 2, 40, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('0f3b50f9-ccaf-4c93-b02d-0b08939c8bfa', NULL, 'idp-review-profile', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '2b2fbfd3-bdf4-4920-9ab8-225af9eac40d', 0, 10, 'f', NULL, '4347a4e4-e047-4be7-9b09-0f994153756b');
INSERT INTO "public"."authentication_execution" VALUES ('5d117269-bb25-4b5f-b5ec-a46063ac1895', NULL, NULL, '2615b5da-5c3b-432f-af31-9af5f519b2a6', '2b2fbfd3-bdf4-4920-9ab8-225af9eac40d', 0, 20, 't', '419770b7-086b-40d4-b024-a13a1c6d2fd3', NULL);
INSERT INTO "public"."authentication_execution" VALUES ('a3b4f88d-00b0-42f6-b227-b456a2eaa123', NULL, 'idp-create-user-if-unique', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '419770b7-086b-40d4-b024-a13a1c6d2fd3', 2, 10, 'f', NULL, 'b6460faf-19e9-489d-bbbe-4b7d626be1a3');
INSERT INTO "public"."authentication_execution" VALUES ('fcdc2192-1ad2-43a5-9505-58683bd671db', NULL, NULL, '2615b5da-5c3b-432f-af31-9af5f519b2a6', '419770b7-086b-40d4-b024-a13a1c6d2fd3', 2, 20, 't', '5ba9ed4a-0eb3-4674-beb0-92fd43af88c9', NULL);
INSERT INTO "public"."authentication_execution" VALUES ('681c187e-3544-45ed-93e4-2e8095959d5a', NULL, 'idp-confirm-link', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '5ba9ed4a-0eb3-4674-beb0-92fd43af88c9', 0, 10, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('00231092-b71b-48e8-bb5e-afe09269d6b6', NULL, NULL, '2615b5da-5c3b-432f-af31-9af5f519b2a6', '5ba9ed4a-0eb3-4674-beb0-92fd43af88c9', 0, 20, 't', '3eb628e2-b0d1-499a-b140-d718a62a8026', NULL);
INSERT INTO "public"."authentication_execution" VALUES ('f8e4d25c-df4e-4bc5-b57f-488cc64d9ed2', NULL, 'idp-email-verification', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '3eb628e2-b0d1-499a-b140-d718a62a8026', 2, 10, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('c5fa0444-21d0-49e4-b6c8-20d1eb30be77', NULL, NULL, '2615b5da-5c3b-432f-af31-9af5f519b2a6', '3eb628e2-b0d1-499a-b140-d718a62a8026', 2, 20, 't', '74fb4bf7-d4fb-4c78-a98e-ee4c45570f86', NULL);
INSERT INTO "public"."authentication_execution" VALUES ('0f4c440d-4a9f-4ca1-9cb1-8ae1ae67776c', NULL, 'idp-username-password-form', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '74fb4bf7-d4fb-4c78-a98e-ee4c45570f86', 0, 10, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('1dfd57e6-2fe8-4feb-b172-2dc335921646', NULL, NULL, '2615b5da-5c3b-432f-af31-9af5f519b2a6', '74fb4bf7-d4fb-4c78-a98e-ee4c45570f86', 1, 20, 't', '9f764955-29cb-46bc-8aa8-da7096b0b8e0', NULL);
INSERT INTO "public"."authentication_execution" VALUES ('40f7f0db-e8bf-40d3-be16-8ff578cb6ab6', NULL, 'conditional-user-configured', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '9f764955-29cb-46bc-8aa8-da7096b0b8e0', 0, 10, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('a4a5d301-d37c-486d-a0e0-ed1bec5945f4', NULL, 'auth-otp-form', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '9f764955-29cb-46bc-8aa8-da7096b0b8e0', 0, 20, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('9699db3d-955f-47bb-b9ca-d857f78ac119', NULL, 'http-basic-authenticator', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'f9901114-50c7-4d45-9604-d74f702e2d40', 0, 10, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('848dd29b-3d42-4f94-8430-9e4c9dfb1718', NULL, 'docker-http-basic-authenticator', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '634f1375-a975-47c3-8ea9-a25c84ac59b2', 0, 10, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('c0d3e23a-9732-493d-9856-ce7abdb43c61', NULL, 'auth-cookie', 'e668ca58-deb8-459c-9294-39e5e530c03f', '4053a918-0053-462d-83e7-415a75f6b1c8', 2, 10, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('93e4de55-f313-4233-99aa-bc10dfb06ea7', NULL, 'auth-spnego', 'e668ca58-deb8-459c-9294-39e5e530c03f', '4053a918-0053-462d-83e7-415a75f6b1c8', 3, 20, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('46ed536c-249e-43a3-8ab1-055bebf8e84d', NULL, 'identity-provider-redirector', 'e668ca58-deb8-459c-9294-39e5e530c03f', '4053a918-0053-462d-83e7-415a75f6b1c8', 2, 25, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('76773d36-a5ac-4aca-a3fa-f570a5142bf8', NULL, NULL, 'e668ca58-deb8-459c-9294-39e5e530c03f', '4053a918-0053-462d-83e7-415a75f6b1c8', 2, 30, 't', '6536d910-ebf5-4e1f-8f4d-e0115af69bb3', NULL);
INSERT INTO "public"."authentication_execution" VALUES ('8cfc56f6-a9ee-4265-9edb-8566e6f91e1c', NULL, 'auth-username-password-form', 'e668ca58-deb8-459c-9294-39e5e530c03f', '6536d910-ebf5-4e1f-8f4d-e0115af69bb3', 0, 10, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('d632c923-ad4a-4d7f-bbdc-6fb64c1f347e', NULL, NULL, 'e668ca58-deb8-459c-9294-39e5e530c03f', '6536d910-ebf5-4e1f-8f4d-e0115af69bb3', 1, 20, 't', 'c0ecf6bd-628f-4208-ab1d-b6cabce68372', NULL);
INSERT INTO "public"."authentication_execution" VALUES ('a10bc67b-85d1-477d-9551-f1449d070f6d', NULL, 'conditional-user-configured', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'c0ecf6bd-628f-4208-ab1d-b6cabce68372', 0, 10, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('735a2383-aeec-443e-a7d8-90eca826cbd2', NULL, 'auth-otp-form', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'c0ecf6bd-628f-4208-ab1d-b6cabce68372', 0, 20, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('eac995ce-bb7d-44af-8632-98f0cc2b79ec', NULL, 'direct-grant-validate-username', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'd578000c-01c8-41bf-96cd-362ad59e78e7', 0, 10, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('404e7721-cdf0-46ac-a24d-f5ed8c9d882b', NULL, 'direct-grant-validate-password', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'd578000c-01c8-41bf-96cd-362ad59e78e7', 0, 20, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('96f33444-fb76-4dd8-8225-957c096d0c7c', NULL, NULL, 'e668ca58-deb8-459c-9294-39e5e530c03f', 'd578000c-01c8-41bf-96cd-362ad59e78e7', 1, 30, 't', '334946d2-0370-434a-8845-0eb8600daa42', NULL);
INSERT INTO "public"."authentication_execution" VALUES ('c53fe46e-052a-441c-8e30-0ac6f0f19f03', NULL, 'conditional-user-configured', 'e668ca58-deb8-459c-9294-39e5e530c03f', '334946d2-0370-434a-8845-0eb8600daa42', 0, 10, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('39ee8c2d-e6a6-4acc-8150-9cb687812bb9', NULL, 'direct-grant-validate-otp', 'e668ca58-deb8-459c-9294-39e5e530c03f', '334946d2-0370-434a-8845-0eb8600daa42', 0, 20, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('e6f9d16e-b03c-452a-b03d-74f0e3e7074f', NULL, 'registration-page-form', 'e668ca58-deb8-459c-9294-39e5e530c03f', '2e5f802c-a39c-448d-87c0-2969a99732ef', 0, 10, 't', '5e67f74c-9b6f-4439-acae-c7bf61bfa4b2', NULL);
INSERT INTO "public"."authentication_execution" VALUES ('9b944370-7d0c-4afc-9dae-7fe5198d80d4', NULL, 'registration-user-creation', 'e668ca58-deb8-459c-9294-39e5e530c03f', '5e67f74c-9b6f-4439-acae-c7bf61bfa4b2', 0, 20, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('2f941a2e-2cef-4f4f-bf2e-85b6a2e46781', NULL, 'registration-profile-action', 'e668ca58-deb8-459c-9294-39e5e530c03f', '5e67f74c-9b6f-4439-acae-c7bf61bfa4b2', 0, 40, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('d9369af1-f2ac-429b-be3c-5c2b807cfba8', NULL, 'registration-password-action', 'e668ca58-deb8-459c-9294-39e5e530c03f', '5e67f74c-9b6f-4439-acae-c7bf61bfa4b2', 0, 50, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('836a344a-ebf2-4f07-966a-4d48eddf1bef', NULL, 'registration-recaptcha-action', 'e668ca58-deb8-459c-9294-39e5e530c03f', '5e67f74c-9b6f-4439-acae-c7bf61bfa4b2', 3, 60, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('e63a4ad0-153b-4597-9daf-818b8eda4944', NULL, 'reset-credentials-choose-user', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'f7549afc-2cd9-4455-acbe-f33593101401', 0, 10, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('18a7709a-dc20-4c34-901a-4c45f6a985ad', NULL, 'reset-credential-email', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'f7549afc-2cd9-4455-acbe-f33593101401', 0, 20, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('3d1080dc-d030-4cd2-9c10-3a5c1b528f64', NULL, 'reset-password', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'f7549afc-2cd9-4455-acbe-f33593101401', 0, 30, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('92cc7490-a1a5-4bc7-b97a-7d4faae192e1', NULL, NULL, 'e668ca58-deb8-459c-9294-39e5e530c03f', 'f7549afc-2cd9-4455-acbe-f33593101401', 1, 40, 't', 'f61fdbdb-e06a-4b9f-ad6e-1a33761ae0dd', NULL);
INSERT INTO "public"."authentication_execution" VALUES ('5b1580c2-3887-4717-badb-e05101f40693', NULL, 'conditional-user-configured', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'f61fdbdb-e06a-4b9f-ad6e-1a33761ae0dd', 0, 10, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('cd3adb71-070e-43d6-8923-39e85cfd9313', NULL, 'reset-otp', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'f61fdbdb-e06a-4b9f-ad6e-1a33761ae0dd', 0, 20, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('65461ad9-8af7-4a5d-b651-dd07687c1eb2', NULL, 'client-secret', 'e668ca58-deb8-459c-9294-39e5e530c03f', '438fbcb1-15aa-4e7a-86cb-acbee86655bb', 2, 10, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('93de983b-745b-480c-afb8-5179ad860996', NULL, 'client-jwt', 'e668ca58-deb8-459c-9294-39e5e530c03f', '438fbcb1-15aa-4e7a-86cb-acbee86655bb', 2, 20, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('fee6aadf-b960-4ba3-b756-a8e2ae4b009f', NULL, 'client-secret-jwt', 'e668ca58-deb8-459c-9294-39e5e530c03f', '438fbcb1-15aa-4e7a-86cb-acbee86655bb', 2, 30, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('506bce6a-3f4f-4629-a6d3-df692e27b259', NULL, 'client-x509', 'e668ca58-deb8-459c-9294-39e5e530c03f', '438fbcb1-15aa-4e7a-86cb-acbee86655bb', 2, 40, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('0b7eedbb-a879-4888-9343-46cde3cd2e11', NULL, 'idp-review-profile', 'e668ca58-deb8-459c-9294-39e5e530c03f', '7b1dff7d-c332-4e9f-8c5d-610fed8ffb8f', 0, 10, 'f', NULL, '6195a81c-eb41-4855-b6b4-e71362b347e8');
INSERT INTO "public"."authentication_execution" VALUES ('d87fd565-ddfb-492b-b643-0b4f3af521c8', NULL, NULL, 'e668ca58-deb8-459c-9294-39e5e530c03f', '7b1dff7d-c332-4e9f-8c5d-610fed8ffb8f', 0, 20, 't', 'adb214d9-1bd8-4b5b-88f3-2d3c41e61748', NULL);
INSERT INTO "public"."authentication_execution" VALUES ('3cc1a68e-e4db-41a2-8b15-bc43ffe008b9', NULL, 'idp-create-user-if-unique', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'adb214d9-1bd8-4b5b-88f3-2d3c41e61748', 2, 10, 'f', NULL, 'ff2b5125-7734-4f1a-b9ad-b335998334cb');
INSERT INTO "public"."authentication_execution" VALUES ('430bbda8-ea86-46c7-ac1a-2344dd2a0ae5', NULL, NULL, 'e668ca58-deb8-459c-9294-39e5e530c03f', 'adb214d9-1bd8-4b5b-88f3-2d3c41e61748', 2, 20, 't', 'eb37e054-60f9-4959-87a7-1b4b54bfec66', NULL);
INSERT INTO "public"."authentication_execution" VALUES ('c8cc942f-47ab-4449-b028-7f2dc5467f62', NULL, 'idp-confirm-link', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'eb37e054-60f9-4959-87a7-1b4b54bfec66', 0, 10, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('7ecb1ff9-d9e8-4bd6-a961-9dc21a91aa6b', NULL, NULL, 'e668ca58-deb8-459c-9294-39e5e530c03f', 'eb37e054-60f9-4959-87a7-1b4b54bfec66', 0, 20, 't', 'a2061536-edfe-489d-9dc8-869afb444da6', NULL);
INSERT INTO "public"."authentication_execution" VALUES ('5421eab9-0520-42e3-9462-fba59f35f2d6', NULL, 'idp-email-verification', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'a2061536-edfe-489d-9dc8-869afb444da6', 2, 10, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('4f821eb1-b225-4197-b15b-99c08f86ee95', NULL, NULL, 'e668ca58-deb8-459c-9294-39e5e530c03f', 'a2061536-edfe-489d-9dc8-869afb444da6', 2, 20, 't', '187ee796-db03-42b6-84c9-7df562482f4d', NULL);
INSERT INTO "public"."authentication_execution" VALUES ('3b4ca0c5-3147-46ce-a5ef-cefe43217056', NULL, 'idp-username-password-form', 'e668ca58-deb8-459c-9294-39e5e530c03f', '187ee796-db03-42b6-84c9-7df562482f4d', 0, 10, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('f9eb2077-5ed3-4e8a-9c55-46c47c210bd8', NULL, NULL, 'e668ca58-deb8-459c-9294-39e5e530c03f', '187ee796-db03-42b6-84c9-7df562482f4d', 1, 20, 't', '2fdcdbc1-37c4-4f1c-ba3b-51a00688c428', NULL);
INSERT INTO "public"."authentication_execution" VALUES ('17617582-aaef-46b8-9bde-991fb275e0a5', NULL, 'conditional-user-configured', 'e668ca58-deb8-459c-9294-39e5e530c03f', '2fdcdbc1-37c4-4f1c-ba3b-51a00688c428', 0, 10, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('648c3c2c-fa91-421b-a1b4-0b474d5b0e99', NULL, 'auth-otp-form', 'e668ca58-deb8-459c-9294-39e5e530c03f', '2fdcdbc1-37c4-4f1c-ba3b-51a00688c428', 0, 20, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('e076baa5-39f6-4a7e-934c-0ae53bfb171f', NULL, 'http-basic-authenticator', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'e811d61e-04c3-455b-bed9-de96f739805b', 0, 10, 'f', NULL, NULL);
INSERT INTO "public"."authentication_execution" VALUES ('a605393d-8a0e-41bb-8577-7b1a27cac521', NULL, 'docker-http-basic-authenticator', 'e668ca58-deb8-459c-9294-39e5e530c03f', '3d14f447-37e4-4759-a8e3-dd59b4da2f1b', 0, 10, 'f', NULL, NULL);

-- ----------------------------
-- Table structure for authentication_flow
-- ----------------------------
DROP TABLE IF EXISTS "public"."authentication_flow";
CREATE TABLE "public"."authentication_flow" (
  "id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "alias" varchar(255) COLLATE "pg_catalog"."default",
  "description" varchar(255) COLLATE "pg_catalog"."default",
  "realm_id" varchar(36) COLLATE "pg_catalog"."default",
  "provider_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'basic-flow'::character varying,
  "top_level" bool NOT NULL DEFAULT false,
  "built_in" bool NOT NULL DEFAULT false
)
;

-- ----------------------------
-- Records of authentication_flow
-- ----------------------------
INSERT INTO "public"."authentication_flow" VALUES ('f9ba9768-3c62-4ef6-8b86-046b40d47cc5', 'browser', 'browser based authentication', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'basic-flow', 't', 't');
INSERT INTO "public"."authentication_flow" VALUES ('6b428d10-205f-4da9-871b-37d8a2a5462f', 'forms', 'Username, password, otp and other auth forms.', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'basic-flow', 'f', 't');
INSERT INTO "public"."authentication_flow" VALUES ('0b861432-43d6-40ff-8196-e995d2fedf1e', 'Browser - Conditional OTP', 'Flow to determine if the OTP is required for the authentication', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'basic-flow', 'f', 't');
INSERT INTO "public"."authentication_flow" VALUES ('31da6c0f-6efa-4e95-b14b-deac1ba6a735', 'direct grant', 'OpenID Connect Resource Owner Grant', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'basic-flow', 't', 't');
INSERT INTO "public"."authentication_flow" VALUES ('271cc0a2-b927-432c-a275-c6081ba226f5', 'Direct Grant - Conditional OTP', 'Flow to determine if the OTP is required for the authentication', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'basic-flow', 'f', 't');
INSERT INTO "public"."authentication_flow" VALUES ('3fd1a01f-589b-458b-aca1-5aa5159e84ff', 'registration', 'registration flow', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'basic-flow', 't', 't');
INSERT INTO "public"."authentication_flow" VALUES ('4e5c2754-2499-4041-82e2-58e59a804d8b', 'registration form', 'registration form', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'form-flow', 'f', 't');
INSERT INTO "public"."authentication_flow" VALUES ('ac953ec0-1e20-456f-9069-61d433213c63', 'reset credentials', 'Reset credentials for a user if they forgot their password or something', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'basic-flow', 't', 't');
INSERT INTO "public"."authentication_flow" VALUES ('15e64cb2-cc9a-403f-bb43-ab35459a1997', 'Reset - Conditional OTP', 'Flow to determine if the OTP should be reset or not. Set to REQUIRED to force.', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'basic-flow', 'f', 't');
INSERT INTO "public"."authentication_flow" VALUES ('79b8ae65-8961-45fd-8b80-efc6068046f1', 'clients', 'Base authentication for clients', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'client-flow', 't', 't');
INSERT INTO "public"."authentication_flow" VALUES ('2b2fbfd3-bdf4-4920-9ab8-225af9eac40d', 'first broker login', 'Actions taken after first broker login with identity provider account, which is not yet linked to any Keycloak account', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'basic-flow', 't', 't');
INSERT INTO "public"."authentication_flow" VALUES ('419770b7-086b-40d4-b024-a13a1c6d2fd3', 'User creation or linking', 'Flow for the existing/non-existing user alternatives', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'basic-flow', 'f', 't');
INSERT INTO "public"."authentication_flow" VALUES ('5ba9ed4a-0eb3-4674-beb0-92fd43af88c9', 'Handle Existing Account', 'Handle what to do if there is existing account with same email/username like authenticated identity provider', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'basic-flow', 'f', 't');
INSERT INTO "public"."authentication_flow" VALUES ('3eb628e2-b0d1-499a-b140-d718a62a8026', 'Account verification options', 'Method with which to verity the existing account', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'basic-flow', 'f', 't');
INSERT INTO "public"."authentication_flow" VALUES ('74fb4bf7-d4fb-4c78-a98e-ee4c45570f86', 'Verify Existing Account by Re-authentication', 'Reauthentication of existing account', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'basic-flow', 'f', 't');
INSERT INTO "public"."authentication_flow" VALUES ('9f764955-29cb-46bc-8aa8-da7096b0b8e0', 'First broker login - Conditional OTP', 'Flow to determine if the OTP is required for the authentication', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'basic-flow', 'f', 't');
INSERT INTO "public"."authentication_flow" VALUES ('f9901114-50c7-4d45-9604-d74f702e2d40', 'saml ecp', 'SAML ECP Profile Authentication Flow', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'basic-flow', 't', 't');
INSERT INTO "public"."authentication_flow" VALUES ('634f1375-a975-47c3-8ea9-a25c84ac59b2', 'docker auth', 'Used by Docker clients to authenticate against the IDP', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'basic-flow', 't', 't');
INSERT INTO "public"."authentication_flow" VALUES ('4053a918-0053-462d-83e7-415a75f6b1c8', 'browser', 'browser based authentication', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'basic-flow', 't', 't');
INSERT INTO "public"."authentication_flow" VALUES ('6536d910-ebf5-4e1f-8f4d-e0115af69bb3', 'forms', 'Username, password, otp and other auth forms.', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'basic-flow', 'f', 't');
INSERT INTO "public"."authentication_flow" VALUES ('c0ecf6bd-628f-4208-ab1d-b6cabce68372', 'Browser - Conditional OTP', 'Flow to determine if the OTP is required for the authentication', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'basic-flow', 'f', 't');
INSERT INTO "public"."authentication_flow" VALUES ('d578000c-01c8-41bf-96cd-362ad59e78e7', 'direct grant', 'OpenID Connect Resource Owner Grant', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'basic-flow', 't', 't');
INSERT INTO "public"."authentication_flow" VALUES ('334946d2-0370-434a-8845-0eb8600daa42', 'Direct Grant - Conditional OTP', 'Flow to determine if the OTP is required for the authentication', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'basic-flow', 'f', 't');
INSERT INTO "public"."authentication_flow" VALUES ('2e5f802c-a39c-448d-87c0-2969a99732ef', 'registration', 'registration flow', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'basic-flow', 't', 't');
INSERT INTO "public"."authentication_flow" VALUES ('5e67f74c-9b6f-4439-acae-c7bf61bfa4b2', 'registration form', 'registration form', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'form-flow', 'f', 't');
INSERT INTO "public"."authentication_flow" VALUES ('f7549afc-2cd9-4455-acbe-f33593101401', 'reset credentials', 'Reset credentials for a user if they forgot their password or something', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'basic-flow', 't', 't');
INSERT INTO "public"."authentication_flow" VALUES ('f61fdbdb-e06a-4b9f-ad6e-1a33761ae0dd', 'Reset - Conditional OTP', 'Flow to determine if the OTP should be reset or not. Set to REQUIRED to force.', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'basic-flow', 'f', 't');
INSERT INTO "public"."authentication_flow" VALUES ('438fbcb1-15aa-4e7a-86cb-acbee86655bb', 'clients', 'Base authentication for clients', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'client-flow', 't', 't');
INSERT INTO "public"."authentication_flow" VALUES ('7b1dff7d-c332-4e9f-8c5d-610fed8ffb8f', 'first broker login', 'Actions taken after first broker login with identity provider account, which is not yet linked to any Keycloak account', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'basic-flow', 't', 't');
INSERT INTO "public"."authentication_flow" VALUES ('adb214d9-1bd8-4b5b-88f3-2d3c41e61748', 'User creation or linking', 'Flow for the existing/non-existing user alternatives', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'basic-flow', 'f', 't');
INSERT INTO "public"."authentication_flow" VALUES ('eb37e054-60f9-4959-87a7-1b4b54bfec66', 'Handle Existing Account', 'Handle what to do if there is existing account with same email/username like authenticated identity provider', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'basic-flow', 'f', 't');
INSERT INTO "public"."authentication_flow" VALUES ('a2061536-edfe-489d-9dc8-869afb444da6', 'Account verification options', 'Method with which to verity the existing account', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'basic-flow', 'f', 't');
INSERT INTO "public"."authentication_flow" VALUES ('187ee796-db03-42b6-84c9-7df562482f4d', 'Verify Existing Account by Re-authentication', 'Reauthentication of existing account', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'basic-flow', 'f', 't');
INSERT INTO "public"."authentication_flow" VALUES ('2fdcdbc1-37c4-4f1c-ba3b-51a00688c428', 'First broker login - Conditional OTP', 'Flow to determine if the OTP is required for the authentication', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'basic-flow', 'f', 't');
INSERT INTO "public"."authentication_flow" VALUES ('e811d61e-04c3-455b-bed9-de96f739805b', 'saml ecp', 'SAML ECP Profile Authentication Flow', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'basic-flow', 't', 't');
INSERT INTO "public"."authentication_flow" VALUES ('3d14f447-37e4-4759-a8e3-dd59b4da2f1b', 'docker auth', 'Used by Docker clients to authenticate against the IDP', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'basic-flow', 't', 't');
INSERT INTO "public"."authentication_flow" VALUES ('1dd2567d-999c-4cde-9757-9edf83129f9a', 'Link Google account with existing account	', '', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'basic-flow', 't', 'f');

-- ----------------------------
-- Table structure for authenticator_config
-- ----------------------------
DROP TABLE IF EXISTS "public"."authenticator_config";
CREATE TABLE "public"."authenticator_config" (
  "id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "alias" varchar(255) COLLATE "pg_catalog"."default",
  "realm_id" varchar(36) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of authenticator_config
-- ----------------------------
INSERT INTO "public"."authenticator_config" VALUES ('4347a4e4-e047-4be7-9b09-0f994153756b', 'review profile config', '2615b5da-5c3b-432f-af31-9af5f519b2a6');
INSERT INTO "public"."authenticator_config" VALUES ('b6460faf-19e9-489d-bbbe-4b7d626be1a3', 'create unique user config', '2615b5da-5c3b-432f-af31-9af5f519b2a6');
INSERT INTO "public"."authenticator_config" VALUES ('6195a81c-eb41-4855-b6b4-e71362b347e8', 'review profile config', 'e668ca58-deb8-459c-9294-39e5e530c03f');
INSERT INTO "public"."authenticator_config" VALUES ('ff2b5125-7734-4f1a-b9ad-b335998334cb', 'create unique user config', 'e668ca58-deb8-459c-9294-39e5e530c03f');

-- ----------------------------
-- Table structure for authenticator_config_entry
-- ----------------------------
DROP TABLE IF EXISTS "public"."authenticator_config_entry";
CREATE TABLE "public"."authenticator_config_entry" (
  "authenticator_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "value" text COLLATE "pg_catalog"."default",
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of authenticator_config_entry
-- ----------------------------
INSERT INTO "public"."authenticator_config_entry" VALUES ('4347a4e4-e047-4be7-9b09-0f994153756b', 'missing', 'update.profile.on.first.login');
INSERT INTO "public"."authenticator_config_entry" VALUES ('b6460faf-19e9-489d-bbbe-4b7d626be1a3', 'false', 'require.password.update.after.registration');
INSERT INTO "public"."authenticator_config_entry" VALUES ('6195a81c-eb41-4855-b6b4-e71362b347e8', 'missing', 'update.profile.on.first.login');
INSERT INTO "public"."authenticator_config_entry" VALUES ('ff2b5125-7734-4f1a-b9ad-b335998334cb', 'false', 'require.password.update.after.registration');

-- ----------------------------
-- Table structure for broker_link
-- ----------------------------
DROP TABLE IF EXISTS "public"."broker_link";
CREATE TABLE "public"."broker_link" (
  "identity_provider" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "storage_provider_id" varchar(255) COLLATE "pg_catalog"."default",
  "realm_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "broker_user_id" varchar(255) COLLATE "pg_catalog"."default",
  "broker_username" varchar(255) COLLATE "pg_catalog"."default",
  "token" text COLLATE "pg_catalog"."default",
  "user_id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of broker_link
-- ----------------------------

-- ----------------------------
-- Table structure for client
-- ----------------------------
DROP TABLE IF EXISTS "public"."client";
CREATE TABLE "public"."client" (
  "id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "enabled" bool NOT NULL DEFAULT false,
  "full_scope_allowed" bool NOT NULL DEFAULT false,
  "client_id" varchar(255) COLLATE "pg_catalog"."default",
  "not_before" int4,
  "public_client" bool NOT NULL DEFAULT false,
  "secret" varchar(255) COLLATE "pg_catalog"."default",
  "base_url" varchar(255) COLLATE "pg_catalog"."default",
  "bearer_only" bool NOT NULL DEFAULT false,
  "management_url" varchar(255) COLLATE "pg_catalog"."default",
  "surrogate_auth_required" bool NOT NULL DEFAULT false,
  "realm_id" varchar(36) COLLATE "pg_catalog"."default",
  "protocol" varchar(255) COLLATE "pg_catalog"."default",
  "node_rereg_timeout" int4 DEFAULT 0,
  "frontchannel_logout" bool NOT NULL DEFAULT false,
  "consent_required" bool NOT NULL DEFAULT false,
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "service_accounts_enabled" bool NOT NULL DEFAULT false,
  "client_authenticator_type" varchar(255) COLLATE "pg_catalog"."default",
  "root_url" varchar(255) COLLATE "pg_catalog"."default",
  "description" varchar(255) COLLATE "pg_catalog"."default",
  "registration_token" varchar(255) COLLATE "pg_catalog"."default",
  "standard_flow_enabled" bool NOT NULL DEFAULT true,
  "implicit_flow_enabled" bool NOT NULL DEFAULT false,
  "direct_access_grants_enabled" bool NOT NULL DEFAULT false,
  "always_display_in_console" bool NOT NULL DEFAULT false
)
;

-- ----------------------------
-- Records of client
-- ----------------------------
INSERT INTO "public"."client" VALUES ('0f7b7c6e-b419-4d57-a05a-929313247c5b', 't', 'f', 'master-realm', 0, 'f', NULL, NULL, 't', NULL, 'f', '2615b5da-5c3b-432f-af31-9af5f519b2a6', NULL, 0, 'f', 'f', 'master Realm', 'f', 'client-secret', NULL, NULL, NULL, 't', 'f', 'f', 'f');
INSERT INTO "public"."client" VALUES ('ad3b314e-5403-45ee-b31e-aa88e47b7933', 't', 'f', 'account', 0, 't', NULL, '/realms/master/account/', 'f', NULL, 'f', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'openid-connect', 0, 'f', 'f', '${client_account}', 'f', 'client-secret', '${authBaseUrl}', NULL, NULL, 't', 'f', 'f', 'f');
INSERT INTO "public"."client" VALUES ('1418f9d8-877d-4a16-a0c7-05f2bac8f4e4', 't', 'f', 'account-console', 0, 't', NULL, '/realms/master/account/', 'f', NULL, 'f', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'openid-connect', 0, 'f', 'f', '${client_account-console}', 'f', 'client-secret', '${authBaseUrl}', NULL, NULL, 't', 'f', 'f', 'f');
INSERT INTO "public"."client" VALUES ('f9506698-432f-4575-89fd-159b3bed7106', 't', 'f', 'broker', 0, 'f', NULL, NULL, 't', NULL, 'f', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'openid-connect', 0, 'f', 'f', '${client_broker}', 'f', 'client-secret', NULL, NULL, NULL, 't', 'f', 'f', 'f');
INSERT INTO "public"."client" VALUES ('e0f7d215-09a8-426a-83d3-b159f75c1d63', 't', 'f', 'security-admin-console', 0, 't', NULL, '/admin/master/console/', 'f', NULL, 'f', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'openid-connect', 0, 'f', 'f', '${client_security-admin-console}', 'f', 'client-secret', '${authAdminUrl}', NULL, NULL, 't', 'f', 'f', 'f');
INSERT INTO "public"."client" VALUES ('0432b1de-a06c-4b2a-b688-5fde98e510e2', 't', 'f', 'admin-cli', 0, 't', NULL, NULL, 'f', NULL, 'f', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'openid-connect', 0, 'f', 'f', '${client_admin-cli}', 'f', 'client-secret', NULL, NULL, NULL, 'f', 'f', 't', 'f');
INSERT INTO "public"."client" VALUES ('e91855ac-d4b5-4c39-8aa3-ec0609b98ada', 't', 'f', 'spring-boot-realm-dev-realm', 0, 'f', NULL, NULL, 't', NULL, 'f', '2615b5da-5c3b-432f-af31-9af5f519b2a6', NULL, 0, 'f', 'f', 'spring-boot-realm-dev Realm', 'f', 'client-secret', NULL, NULL, NULL, 't', 'f', 'f', 'f');
INSERT INTO "public"."client" VALUES ('20d9416e-0e2d-48d3-bfff-f256d60cc99c', 't', 'f', 'realm-management', 0, 'f', NULL, NULL, 't', NULL, 'f', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'openid-connect', 0, 'f', 'f', '${client_realm-management}', 'f', 'client-secret', NULL, NULL, NULL, 't', 'f', 'f', 'f');
INSERT INTO "public"."client" VALUES ('51f2891f-9f5a-4054-8823-3627b06e3e5b', 't', 'f', 'account', 0, 't', NULL, '/realms/spring-boot-realm-dev/account/', 'f', NULL, 'f', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'openid-connect', 0, 'f', 'f', '${client_account}', 'f', 'client-secret', '${authBaseUrl}', NULL, NULL, 't', 'f', 'f', 'f');
INSERT INTO "public"."client" VALUES ('aa5445f5-a056-46f7-97e8-7d5fe2ab4453', 't', 'f', 'account-console', 0, 't', NULL, '/realms/spring-boot-realm-dev/account/', 'f', NULL, 'f', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'openid-connect', 0, 'f', 'f', '${client_account-console}', 'f', 'client-secret', '${authBaseUrl}', NULL, NULL, 't', 'f', 'f', 'f');
INSERT INTO "public"."client" VALUES ('a3074b6a-2f88-4a1e-b1ab-3564c6b89ba9', 't', 'f', 'broker', 0, 'f', NULL, NULL, 't', NULL, 'f', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'openid-connect', 0, 'f', 'f', '${client_broker}', 'f', 'client-secret', NULL, NULL, NULL, 't', 'f', 'f', 'f');
INSERT INTO "public"."client" VALUES ('7b5fba19-edfe-4208-af18-4eba02c6d1fd', 't', 'f', 'security-admin-console', 0, 't', NULL, '/admin/spring-boot-realm-dev/console/', 'f', NULL, 'f', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'openid-connect', 0, 'f', 'f', '${client_security-admin-console}', 'f', 'client-secret', '${authAdminUrl}', NULL, NULL, 't', 'f', 'f', 'f');
INSERT INTO "public"."client" VALUES ('013f7a7e-a923-44dc-bf06-12f9d50a38c3', 't', 't', 'spring-client-api-rest', 0, 'f', 'pE2Lz9RL01YGE15800wDxRfnz2KFuCgX', '', 'f', '', 'f', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'openid-connect', -1, 't', 'f', 'spring-client-api-rest', 't', 'client-secret', '', '', NULL, 't', 'f', 't', 'f');
INSERT INTO "public"."client" VALUES ('ab045118-6511-45fb-93d5-e6bcd83aa04f', 't', 't', 'authenticationClientId', 0, 't', NULL, '', 'f', '', 'f', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'openid-connect', -1, 't', 'f', '', 'f', 'client-secret', '', '', NULL, 't', 'f', 't', 'f');
INSERT INTO "public"."client" VALUES ('39132819-80be-4746-861d-ce870d61b7c1', 't', 'f', 'admin-cli', 0, 'f', 'bTEi5t1OKE7l97ij9wYjAMqqYA4NCod8', '', 'f', '', 'f', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'openid-connect', 0, 'f', 'f', '${client_admin-cli}', 't', 'client-secret', '', '', NULL, 'f', 'f', 't', 'f');

-- ----------------------------
-- Table structure for client_attributes
-- ----------------------------
DROP TABLE IF EXISTS "public"."client_attributes";
CREATE TABLE "public"."client_attributes" (
  "client_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "value" text COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of client_attributes
-- ----------------------------
INSERT INTO "public"."client_attributes" VALUES ('ad3b314e-5403-45ee-b31e-aa88e47b7933', 'post.logout.redirect.uris', '+');
INSERT INTO "public"."client_attributes" VALUES ('1418f9d8-877d-4a16-a0c7-05f2bac8f4e4', 'post.logout.redirect.uris', '+');
INSERT INTO "public"."client_attributes" VALUES ('1418f9d8-877d-4a16-a0c7-05f2bac8f4e4', 'pkce.code.challenge.method', 'S256');
INSERT INTO "public"."client_attributes" VALUES ('e0f7d215-09a8-426a-83d3-b159f75c1d63', 'post.logout.redirect.uris', '+');
INSERT INTO "public"."client_attributes" VALUES ('e0f7d215-09a8-426a-83d3-b159f75c1d63', 'pkce.code.challenge.method', 'S256');
INSERT INTO "public"."client_attributes" VALUES ('51f2891f-9f5a-4054-8823-3627b06e3e5b', 'post.logout.redirect.uris', '+');
INSERT INTO "public"."client_attributes" VALUES ('aa5445f5-a056-46f7-97e8-7d5fe2ab4453', 'post.logout.redirect.uris', '+');
INSERT INTO "public"."client_attributes" VALUES ('aa5445f5-a056-46f7-97e8-7d5fe2ab4453', 'pkce.code.challenge.method', 'S256');
INSERT INTO "public"."client_attributes" VALUES ('7b5fba19-edfe-4208-af18-4eba02c6d1fd', 'post.logout.redirect.uris', '+');
INSERT INTO "public"."client_attributes" VALUES ('7b5fba19-edfe-4208-af18-4eba02c6d1fd', 'pkce.code.challenge.method', 'S256');
INSERT INTO "public"."client_attributes" VALUES ('013f7a7e-a923-44dc-bf06-12f9d50a38c3', 'client.secret.creation.time', '1715777662');
INSERT INTO "public"."client_attributes" VALUES ('013f7a7e-a923-44dc-bf06-12f9d50a38c3', 'oauth2.device.authorization.grant.enabled', 'false');
INSERT INTO "public"."client_attributes" VALUES ('013f7a7e-a923-44dc-bf06-12f9d50a38c3', 'oidc.ciba.grant.enabled', 'false');
INSERT INTO "public"."client_attributes" VALUES ('013f7a7e-a923-44dc-bf06-12f9d50a38c3', 'backchannel.logout.session.required', 'true');
INSERT INTO "public"."client_attributes" VALUES ('013f7a7e-a923-44dc-bf06-12f9d50a38c3', 'backchannel.logout.revoke.offline.tokens', 'false');
INSERT INTO "public"."client_attributes" VALUES ('39132819-80be-4746-861d-ce870d61b7c1', 'backchannel.logout.url', 'http://localhost:9098');
INSERT INTO "public"."client_attributes" VALUES ('39132819-80be-4746-861d-ce870d61b7c1', 'client.secret.creation.time', '1715777741');
INSERT INTO "public"."client_attributes" VALUES ('013f7a7e-a923-44dc-bf06-12f9d50a38c3', 'display.on.consent.screen', 'false');
INSERT INTO "public"."client_attributes" VALUES ('ab045118-6511-45fb-93d5-e6bcd83aa04f', 'oauth2.device.authorization.grant.enabled', 'false');
INSERT INTO "public"."client_attributes" VALUES ('ab045118-6511-45fb-93d5-e6bcd83aa04f', 'oidc.ciba.grant.enabled', 'false');
INSERT INTO "public"."client_attributes" VALUES ('ab045118-6511-45fb-93d5-e6bcd83aa04f', 'backchannel.logout.session.required', 'true');
INSERT INTO "public"."client_attributes" VALUES ('ab045118-6511-45fb-93d5-e6bcd83aa04f', 'backchannel.logout.revoke.offline.tokens', 'false');
INSERT INTO "public"."client_attributes" VALUES ('39132819-80be-4746-861d-ce870d61b7c1', 'oauth2.device.authorization.grant.enabled', 'false');
INSERT INTO "public"."client_attributes" VALUES ('39132819-80be-4746-861d-ce870d61b7c1', 'oidc.ciba.grant.enabled', 'false');
INSERT INTO "public"."client_attributes" VALUES ('39132819-80be-4746-861d-ce870d61b7c1', 'display.on.consent.screen', 'false');
INSERT INTO "public"."client_attributes" VALUES ('39132819-80be-4746-861d-ce870d61b7c1', 'backchannel.logout.session.required', 'true');
INSERT INTO "public"."client_attributes" VALUES ('39132819-80be-4746-861d-ce870d61b7c1', 'backchannel.logout.revoke.offline.tokens', 'false');

-- ----------------------------
-- Table structure for client_auth_flow_bindings
-- ----------------------------
DROP TABLE IF EXISTS "public"."client_auth_flow_bindings";
CREATE TABLE "public"."client_auth_flow_bindings" (
  "client_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "flow_id" varchar(36) COLLATE "pg_catalog"."default",
  "binding_name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of client_auth_flow_bindings
-- ----------------------------

-- ----------------------------
-- Table structure for client_initial_access
-- ----------------------------
DROP TABLE IF EXISTS "public"."client_initial_access";
CREATE TABLE "public"."client_initial_access" (
  "id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "realm_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "timestamp" int4,
  "expiration" int4,
  "count" int4,
  "remaining_count" int4
)
;

-- ----------------------------
-- Records of client_initial_access
-- ----------------------------

-- ----------------------------
-- Table structure for client_node_registrations
-- ----------------------------
DROP TABLE IF EXISTS "public"."client_node_registrations";
CREATE TABLE "public"."client_node_registrations" (
  "client_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "value" int4,
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of client_node_registrations
-- ----------------------------

-- ----------------------------
-- Table structure for client_scope
-- ----------------------------
DROP TABLE IF EXISTS "public"."client_scope";
CREATE TABLE "public"."client_scope" (
  "id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "realm_id" varchar(36) COLLATE "pg_catalog"."default",
  "description" varchar(255) COLLATE "pg_catalog"."default",
  "protocol" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of client_scope
-- ----------------------------
INSERT INTO "public"."client_scope" VALUES ('0cf0a34b-0346-4291-8d89-683378a7e2e2', 'offline_access', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'OpenID Connect built-in scope: offline_access', 'openid-connect');
INSERT INTO "public"."client_scope" VALUES ('b0ad2b84-c7f5-461d-955c-e84ed0c1c831', 'role_list', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'SAML role list', 'saml');
INSERT INTO "public"."client_scope" VALUES ('9dcfe6e4-49ab-4793-bb46-924dcf6055f5', 'profile', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'OpenID Connect built-in scope: profile', 'openid-connect');
INSERT INTO "public"."client_scope" VALUES ('76386606-f8dd-43fe-8d3a-a2c961e381e4', 'email', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'OpenID Connect built-in scope: email', 'openid-connect');
INSERT INTO "public"."client_scope" VALUES ('ee24b790-e82d-4cba-bda1-f1af7659a7e2', 'address', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'OpenID Connect built-in scope: address', 'openid-connect');
INSERT INTO "public"."client_scope" VALUES ('a4e06c75-dbbe-4fbd-bdf8-acb74a9e87d4', 'phone', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'OpenID Connect built-in scope: phone', 'openid-connect');
INSERT INTO "public"."client_scope" VALUES ('7aac5fb5-c5c9-491f-8b99-087db6b8aa5c', 'roles', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'OpenID Connect scope for add user roles to the access token', 'openid-connect');
INSERT INTO "public"."client_scope" VALUES ('dadf7439-407d-4d35-b52c-cdc5e2fa6706', 'web-origins', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'OpenID Connect scope for add allowed web origins to the access token', 'openid-connect');
INSERT INTO "public"."client_scope" VALUES ('f6907590-d9d0-4168-8bd3-5d4a26a978f9', 'microprofile-jwt', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'Microprofile - JWT built-in scope', 'openid-connect');
INSERT INTO "public"."client_scope" VALUES ('9f95fa1c-49ff-4a0b-bd45-7f5a966a3cf5', 'acr', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'OpenID Connect scope for add acr (authentication context class reference) to the token', 'openid-connect');
INSERT INTO "public"."client_scope" VALUES ('50056c1c-f13e-4dea-bc4b-59bb6eae4768', 'offline_access', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'OpenID Connect built-in scope: offline_access', 'openid-connect');
INSERT INTO "public"."client_scope" VALUES ('22ba7bb8-08c9-4c77-bd8b-16cc912218f6', 'role_list', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'SAML role list', 'saml');
INSERT INTO "public"."client_scope" VALUES ('0d6d3683-d0d7-4ad9-b08d-3ed0545fe0d6', 'profile', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'OpenID Connect built-in scope: profile', 'openid-connect');
INSERT INTO "public"."client_scope" VALUES ('fc4f4c5a-1168-4a67-9ca8-104a5ae91c78', 'email', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'OpenID Connect built-in scope: email', 'openid-connect');
INSERT INTO "public"."client_scope" VALUES ('c3f54006-62f3-4978-b072-37769c2e4a89', 'address', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'OpenID Connect built-in scope: address', 'openid-connect');
INSERT INTO "public"."client_scope" VALUES ('3b975094-4d95-4ee4-9fcb-2bd2514625c9', 'phone', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'OpenID Connect built-in scope: phone', 'openid-connect');
INSERT INTO "public"."client_scope" VALUES ('072eb48c-17cb-4d3c-b809-1066d9c8c366', 'roles', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'OpenID Connect scope for add user roles to the access token', 'openid-connect');
INSERT INTO "public"."client_scope" VALUES ('33e3b464-6d41-491c-8e63-e9fa4bbf7a77', 'web-origins', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'OpenID Connect scope for add allowed web origins to the access token', 'openid-connect');
INSERT INTO "public"."client_scope" VALUES ('1fa4bd1c-d250-44ea-89af-f4460cd13d7d', 'microprofile-jwt', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'Microprofile - JWT built-in scope', 'openid-connect');
INSERT INTO "public"."client_scope" VALUES ('9b50f631-7ede-4ed2-8ac2-bcd3f4014fe4', 'acr', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'OpenID Connect scope for add acr (authentication context class reference) to the token', 'openid-connect');

-- ----------------------------
-- Table structure for client_scope_attributes
-- ----------------------------
DROP TABLE IF EXISTS "public"."client_scope_attributes";
CREATE TABLE "public"."client_scope_attributes" (
  "scope_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "value" varchar(2048) COLLATE "pg_catalog"."default",
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of client_scope_attributes
-- ----------------------------
INSERT INTO "public"."client_scope_attributes" VALUES ('0cf0a34b-0346-4291-8d89-683378a7e2e2', 'true', 'display.on.consent.screen');
INSERT INTO "public"."client_scope_attributes" VALUES ('0cf0a34b-0346-4291-8d89-683378a7e2e2', '${offlineAccessScopeConsentText}', 'consent.screen.text');
INSERT INTO "public"."client_scope_attributes" VALUES ('b0ad2b84-c7f5-461d-955c-e84ed0c1c831', 'true', 'display.on.consent.screen');
INSERT INTO "public"."client_scope_attributes" VALUES ('b0ad2b84-c7f5-461d-955c-e84ed0c1c831', '${samlRoleListScopeConsentText}', 'consent.screen.text');
INSERT INTO "public"."client_scope_attributes" VALUES ('9dcfe6e4-49ab-4793-bb46-924dcf6055f5', 'true', 'display.on.consent.screen');
INSERT INTO "public"."client_scope_attributes" VALUES ('9dcfe6e4-49ab-4793-bb46-924dcf6055f5', '${profileScopeConsentText}', 'consent.screen.text');
INSERT INTO "public"."client_scope_attributes" VALUES ('9dcfe6e4-49ab-4793-bb46-924dcf6055f5', 'true', 'include.in.token.scope');
INSERT INTO "public"."client_scope_attributes" VALUES ('76386606-f8dd-43fe-8d3a-a2c961e381e4', 'true', 'display.on.consent.screen');
INSERT INTO "public"."client_scope_attributes" VALUES ('76386606-f8dd-43fe-8d3a-a2c961e381e4', '${emailScopeConsentText}', 'consent.screen.text');
INSERT INTO "public"."client_scope_attributes" VALUES ('76386606-f8dd-43fe-8d3a-a2c961e381e4', 'true', 'include.in.token.scope');
INSERT INTO "public"."client_scope_attributes" VALUES ('ee24b790-e82d-4cba-bda1-f1af7659a7e2', 'true', 'display.on.consent.screen');
INSERT INTO "public"."client_scope_attributes" VALUES ('ee24b790-e82d-4cba-bda1-f1af7659a7e2', '${addressScopeConsentText}', 'consent.screen.text');
INSERT INTO "public"."client_scope_attributes" VALUES ('ee24b790-e82d-4cba-bda1-f1af7659a7e2', 'true', 'include.in.token.scope');
INSERT INTO "public"."client_scope_attributes" VALUES ('a4e06c75-dbbe-4fbd-bdf8-acb74a9e87d4', 'true', 'display.on.consent.screen');
INSERT INTO "public"."client_scope_attributes" VALUES ('a4e06c75-dbbe-4fbd-bdf8-acb74a9e87d4', '${phoneScopeConsentText}', 'consent.screen.text');
INSERT INTO "public"."client_scope_attributes" VALUES ('a4e06c75-dbbe-4fbd-bdf8-acb74a9e87d4', 'true', 'include.in.token.scope');
INSERT INTO "public"."client_scope_attributes" VALUES ('7aac5fb5-c5c9-491f-8b99-087db6b8aa5c', 'true', 'display.on.consent.screen');
INSERT INTO "public"."client_scope_attributes" VALUES ('7aac5fb5-c5c9-491f-8b99-087db6b8aa5c', '${rolesScopeConsentText}', 'consent.screen.text');
INSERT INTO "public"."client_scope_attributes" VALUES ('7aac5fb5-c5c9-491f-8b99-087db6b8aa5c', 'false', 'include.in.token.scope');
INSERT INTO "public"."client_scope_attributes" VALUES ('dadf7439-407d-4d35-b52c-cdc5e2fa6706', 'false', 'display.on.consent.screen');
INSERT INTO "public"."client_scope_attributes" VALUES ('dadf7439-407d-4d35-b52c-cdc5e2fa6706', '', 'consent.screen.text');
INSERT INTO "public"."client_scope_attributes" VALUES ('dadf7439-407d-4d35-b52c-cdc5e2fa6706', 'false', 'include.in.token.scope');
INSERT INTO "public"."client_scope_attributes" VALUES ('f6907590-d9d0-4168-8bd3-5d4a26a978f9', 'false', 'display.on.consent.screen');
INSERT INTO "public"."client_scope_attributes" VALUES ('f6907590-d9d0-4168-8bd3-5d4a26a978f9', 'true', 'include.in.token.scope');
INSERT INTO "public"."client_scope_attributes" VALUES ('9f95fa1c-49ff-4a0b-bd45-7f5a966a3cf5', 'false', 'display.on.consent.screen');
INSERT INTO "public"."client_scope_attributes" VALUES ('9f95fa1c-49ff-4a0b-bd45-7f5a966a3cf5', 'false', 'include.in.token.scope');
INSERT INTO "public"."client_scope_attributes" VALUES ('50056c1c-f13e-4dea-bc4b-59bb6eae4768', 'true', 'display.on.consent.screen');
INSERT INTO "public"."client_scope_attributes" VALUES ('50056c1c-f13e-4dea-bc4b-59bb6eae4768', '${offlineAccessScopeConsentText}', 'consent.screen.text');
INSERT INTO "public"."client_scope_attributes" VALUES ('22ba7bb8-08c9-4c77-bd8b-16cc912218f6', 'true', 'display.on.consent.screen');
INSERT INTO "public"."client_scope_attributes" VALUES ('22ba7bb8-08c9-4c77-bd8b-16cc912218f6', '${samlRoleListScopeConsentText}', 'consent.screen.text');
INSERT INTO "public"."client_scope_attributes" VALUES ('0d6d3683-d0d7-4ad9-b08d-3ed0545fe0d6', 'true', 'display.on.consent.screen');
INSERT INTO "public"."client_scope_attributes" VALUES ('0d6d3683-d0d7-4ad9-b08d-3ed0545fe0d6', '${profileScopeConsentText}', 'consent.screen.text');
INSERT INTO "public"."client_scope_attributes" VALUES ('0d6d3683-d0d7-4ad9-b08d-3ed0545fe0d6', 'true', 'include.in.token.scope');
INSERT INTO "public"."client_scope_attributes" VALUES ('fc4f4c5a-1168-4a67-9ca8-104a5ae91c78', 'true', 'display.on.consent.screen');
INSERT INTO "public"."client_scope_attributes" VALUES ('fc4f4c5a-1168-4a67-9ca8-104a5ae91c78', '${emailScopeConsentText}', 'consent.screen.text');
INSERT INTO "public"."client_scope_attributes" VALUES ('fc4f4c5a-1168-4a67-9ca8-104a5ae91c78', 'true', 'include.in.token.scope');
INSERT INTO "public"."client_scope_attributes" VALUES ('c3f54006-62f3-4978-b072-37769c2e4a89', 'true', 'display.on.consent.screen');
INSERT INTO "public"."client_scope_attributes" VALUES ('c3f54006-62f3-4978-b072-37769c2e4a89', '${addressScopeConsentText}', 'consent.screen.text');
INSERT INTO "public"."client_scope_attributes" VALUES ('c3f54006-62f3-4978-b072-37769c2e4a89', 'true', 'include.in.token.scope');
INSERT INTO "public"."client_scope_attributes" VALUES ('3b975094-4d95-4ee4-9fcb-2bd2514625c9', 'true', 'display.on.consent.screen');
INSERT INTO "public"."client_scope_attributes" VALUES ('3b975094-4d95-4ee4-9fcb-2bd2514625c9', '${phoneScopeConsentText}', 'consent.screen.text');
INSERT INTO "public"."client_scope_attributes" VALUES ('3b975094-4d95-4ee4-9fcb-2bd2514625c9', 'true', 'include.in.token.scope');
INSERT INTO "public"."client_scope_attributes" VALUES ('072eb48c-17cb-4d3c-b809-1066d9c8c366', 'true', 'display.on.consent.screen');
INSERT INTO "public"."client_scope_attributes" VALUES ('072eb48c-17cb-4d3c-b809-1066d9c8c366', '${rolesScopeConsentText}', 'consent.screen.text');
INSERT INTO "public"."client_scope_attributes" VALUES ('072eb48c-17cb-4d3c-b809-1066d9c8c366', 'false', 'include.in.token.scope');
INSERT INTO "public"."client_scope_attributes" VALUES ('33e3b464-6d41-491c-8e63-e9fa4bbf7a77', 'false', 'display.on.consent.screen');
INSERT INTO "public"."client_scope_attributes" VALUES ('33e3b464-6d41-491c-8e63-e9fa4bbf7a77', '', 'consent.screen.text');
INSERT INTO "public"."client_scope_attributes" VALUES ('33e3b464-6d41-491c-8e63-e9fa4bbf7a77', 'false', 'include.in.token.scope');
INSERT INTO "public"."client_scope_attributes" VALUES ('1fa4bd1c-d250-44ea-89af-f4460cd13d7d', 'false', 'display.on.consent.screen');
INSERT INTO "public"."client_scope_attributes" VALUES ('1fa4bd1c-d250-44ea-89af-f4460cd13d7d', 'true', 'include.in.token.scope');
INSERT INTO "public"."client_scope_attributes" VALUES ('9b50f631-7ede-4ed2-8ac2-bcd3f4014fe4', 'false', 'display.on.consent.screen');
INSERT INTO "public"."client_scope_attributes" VALUES ('9b50f631-7ede-4ed2-8ac2-bcd3f4014fe4', 'false', 'include.in.token.scope');

-- ----------------------------
-- Table structure for client_scope_client
-- ----------------------------
DROP TABLE IF EXISTS "public"."client_scope_client";
CREATE TABLE "public"."client_scope_client" (
  "client_id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "scope_id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "default_scope" bool NOT NULL DEFAULT false
)
;

-- ----------------------------
-- Records of client_scope_client
-- ----------------------------
INSERT INTO "public"."client_scope_client" VALUES ('ad3b314e-5403-45ee-b31e-aa88e47b7933', '9dcfe6e4-49ab-4793-bb46-924dcf6055f5', 't');
INSERT INTO "public"."client_scope_client" VALUES ('ad3b314e-5403-45ee-b31e-aa88e47b7933', 'dadf7439-407d-4d35-b52c-cdc5e2fa6706', 't');
INSERT INTO "public"."client_scope_client" VALUES ('ad3b314e-5403-45ee-b31e-aa88e47b7933', '9f95fa1c-49ff-4a0b-bd45-7f5a966a3cf5', 't');
INSERT INTO "public"."client_scope_client" VALUES ('ad3b314e-5403-45ee-b31e-aa88e47b7933', '76386606-f8dd-43fe-8d3a-a2c961e381e4', 't');
INSERT INTO "public"."client_scope_client" VALUES ('ad3b314e-5403-45ee-b31e-aa88e47b7933', '7aac5fb5-c5c9-491f-8b99-087db6b8aa5c', 't');
INSERT INTO "public"."client_scope_client" VALUES ('ad3b314e-5403-45ee-b31e-aa88e47b7933', 'ee24b790-e82d-4cba-bda1-f1af7659a7e2', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('ad3b314e-5403-45ee-b31e-aa88e47b7933', 'a4e06c75-dbbe-4fbd-bdf8-acb74a9e87d4', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('ad3b314e-5403-45ee-b31e-aa88e47b7933', '0cf0a34b-0346-4291-8d89-683378a7e2e2', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('ad3b314e-5403-45ee-b31e-aa88e47b7933', 'f6907590-d9d0-4168-8bd3-5d4a26a978f9', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('1418f9d8-877d-4a16-a0c7-05f2bac8f4e4', '9dcfe6e4-49ab-4793-bb46-924dcf6055f5', 't');
INSERT INTO "public"."client_scope_client" VALUES ('1418f9d8-877d-4a16-a0c7-05f2bac8f4e4', 'dadf7439-407d-4d35-b52c-cdc5e2fa6706', 't');
INSERT INTO "public"."client_scope_client" VALUES ('1418f9d8-877d-4a16-a0c7-05f2bac8f4e4', '9f95fa1c-49ff-4a0b-bd45-7f5a966a3cf5', 't');
INSERT INTO "public"."client_scope_client" VALUES ('1418f9d8-877d-4a16-a0c7-05f2bac8f4e4', '76386606-f8dd-43fe-8d3a-a2c961e381e4', 't');
INSERT INTO "public"."client_scope_client" VALUES ('1418f9d8-877d-4a16-a0c7-05f2bac8f4e4', '7aac5fb5-c5c9-491f-8b99-087db6b8aa5c', 't');
INSERT INTO "public"."client_scope_client" VALUES ('1418f9d8-877d-4a16-a0c7-05f2bac8f4e4', 'ee24b790-e82d-4cba-bda1-f1af7659a7e2', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('1418f9d8-877d-4a16-a0c7-05f2bac8f4e4', 'a4e06c75-dbbe-4fbd-bdf8-acb74a9e87d4', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('1418f9d8-877d-4a16-a0c7-05f2bac8f4e4', '0cf0a34b-0346-4291-8d89-683378a7e2e2', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('1418f9d8-877d-4a16-a0c7-05f2bac8f4e4', 'f6907590-d9d0-4168-8bd3-5d4a26a978f9', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('0432b1de-a06c-4b2a-b688-5fde98e510e2', '9dcfe6e4-49ab-4793-bb46-924dcf6055f5', 't');
INSERT INTO "public"."client_scope_client" VALUES ('0432b1de-a06c-4b2a-b688-5fde98e510e2', 'dadf7439-407d-4d35-b52c-cdc5e2fa6706', 't');
INSERT INTO "public"."client_scope_client" VALUES ('0432b1de-a06c-4b2a-b688-5fde98e510e2', '9f95fa1c-49ff-4a0b-bd45-7f5a966a3cf5', 't');
INSERT INTO "public"."client_scope_client" VALUES ('0432b1de-a06c-4b2a-b688-5fde98e510e2', '76386606-f8dd-43fe-8d3a-a2c961e381e4', 't');
INSERT INTO "public"."client_scope_client" VALUES ('0432b1de-a06c-4b2a-b688-5fde98e510e2', '7aac5fb5-c5c9-491f-8b99-087db6b8aa5c', 't');
INSERT INTO "public"."client_scope_client" VALUES ('0432b1de-a06c-4b2a-b688-5fde98e510e2', 'ee24b790-e82d-4cba-bda1-f1af7659a7e2', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('0432b1de-a06c-4b2a-b688-5fde98e510e2', 'a4e06c75-dbbe-4fbd-bdf8-acb74a9e87d4', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('0432b1de-a06c-4b2a-b688-5fde98e510e2', '0cf0a34b-0346-4291-8d89-683378a7e2e2', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('0432b1de-a06c-4b2a-b688-5fde98e510e2', 'f6907590-d9d0-4168-8bd3-5d4a26a978f9', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('f9506698-432f-4575-89fd-159b3bed7106', '9dcfe6e4-49ab-4793-bb46-924dcf6055f5', 't');
INSERT INTO "public"."client_scope_client" VALUES ('f9506698-432f-4575-89fd-159b3bed7106', 'dadf7439-407d-4d35-b52c-cdc5e2fa6706', 't');
INSERT INTO "public"."client_scope_client" VALUES ('f9506698-432f-4575-89fd-159b3bed7106', '9f95fa1c-49ff-4a0b-bd45-7f5a966a3cf5', 't');
INSERT INTO "public"."client_scope_client" VALUES ('f9506698-432f-4575-89fd-159b3bed7106', '76386606-f8dd-43fe-8d3a-a2c961e381e4', 't');
INSERT INTO "public"."client_scope_client" VALUES ('f9506698-432f-4575-89fd-159b3bed7106', '7aac5fb5-c5c9-491f-8b99-087db6b8aa5c', 't');
INSERT INTO "public"."client_scope_client" VALUES ('f9506698-432f-4575-89fd-159b3bed7106', 'ee24b790-e82d-4cba-bda1-f1af7659a7e2', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('f9506698-432f-4575-89fd-159b3bed7106', 'a4e06c75-dbbe-4fbd-bdf8-acb74a9e87d4', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('f9506698-432f-4575-89fd-159b3bed7106', '0cf0a34b-0346-4291-8d89-683378a7e2e2', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('f9506698-432f-4575-89fd-159b3bed7106', 'f6907590-d9d0-4168-8bd3-5d4a26a978f9', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('0f7b7c6e-b419-4d57-a05a-929313247c5b', '9dcfe6e4-49ab-4793-bb46-924dcf6055f5', 't');
INSERT INTO "public"."client_scope_client" VALUES ('0f7b7c6e-b419-4d57-a05a-929313247c5b', 'dadf7439-407d-4d35-b52c-cdc5e2fa6706', 't');
INSERT INTO "public"."client_scope_client" VALUES ('0f7b7c6e-b419-4d57-a05a-929313247c5b', '9f95fa1c-49ff-4a0b-bd45-7f5a966a3cf5', 't');
INSERT INTO "public"."client_scope_client" VALUES ('0f7b7c6e-b419-4d57-a05a-929313247c5b', '76386606-f8dd-43fe-8d3a-a2c961e381e4', 't');
INSERT INTO "public"."client_scope_client" VALUES ('0f7b7c6e-b419-4d57-a05a-929313247c5b', '7aac5fb5-c5c9-491f-8b99-087db6b8aa5c', 't');
INSERT INTO "public"."client_scope_client" VALUES ('0f7b7c6e-b419-4d57-a05a-929313247c5b', 'ee24b790-e82d-4cba-bda1-f1af7659a7e2', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('0f7b7c6e-b419-4d57-a05a-929313247c5b', 'a4e06c75-dbbe-4fbd-bdf8-acb74a9e87d4', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('0f7b7c6e-b419-4d57-a05a-929313247c5b', '0cf0a34b-0346-4291-8d89-683378a7e2e2', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('0f7b7c6e-b419-4d57-a05a-929313247c5b', 'f6907590-d9d0-4168-8bd3-5d4a26a978f9', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('e0f7d215-09a8-426a-83d3-b159f75c1d63', '9dcfe6e4-49ab-4793-bb46-924dcf6055f5', 't');
INSERT INTO "public"."client_scope_client" VALUES ('e0f7d215-09a8-426a-83d3-b159f75c1d63', 'dadf7439-407d-4d35-b52c-cdc5e2fa6706', 't');
INSERT INTO "public"."client_scope_client" VALUES ('e0f7d215-09a8-426a-83d3-b159f75c1d63', '9f95fa1c-49ff-4a0b-bd45-7f5a966a3cf5', 't');
INSERT INTO "public"."client_scope_client" VALUES ('e0f7d215-09a8-426a-83d3-b159f75c1d63', '76386606-f8dd-43fe-8d3a-a2c961e381e4', 't');
INSERT INTO "public"."client_scope_client" VALUES ('e0f7d215-09a8-426a-83d3-b159f75c1d63', '7aac5fb5-c5c9-491f-8b99-087db6b8aa5c', 't');
INSERT INTO "public"."client_scope_client" VALUES ('e0f7d215-09a8-426a-83d3-b159f75c1d63', 'ee24b790-e82d-4cba-bda1-f1af7659a7e2', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('e0f7d215-09a8-426a-83d3-b159f75c1d63', 'a4e06c75-dbbe-4fbd-bdf8-acb74a9e87d4', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('e0f7d215-09a8-426a-83d3-b159f75c1d63', '0cf0a34b-0346-4291-8d89-683378a7e2e2', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('e0f7d215-09a8-426a-83d3-b159f75c1d63', 'f6907590-d9d0-4168-8bd3-5d4a26a978f9', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('51f2891f-9f5a-4054-8823-3627b06e3e5b', 'fc4f4c5a-1168-4a67-9ca8-104a5ae91c78', 't');
INSERT INTO "public"."client_scope_client" VALUES ('51f2891f-9f5a-4054-8823-3627b06e3e5b', '9b50f631-7ede-4ed2-8ac2-bcd3f4014fe4', 't');
INSERT INTO "public"."client_scope_client" VALUES ('51f2891f-9f5a-4054-8823-3627b06e3e5b', '0d6d3683-d0d7-4ad9-b08d-3ed0545fe0d6', 't');
INSERT INTO "public"."client_scope_client" VALUES ('51f2891f-9f5a-4054-8823-3627b06e3e5b', '33e3b464-6d41-491c-8e63-e9fa4bbf7a77', 't');
INSERT INTO "public"."client_scope_client" VALUES ('51f2891f-9f5a-4054-8823-3627b06e3e5b', '072eb48c-17cb-4d3c-b809-1066d9c8c366', 't');
INSERT INTO "public"."client_scope_client" VALUES ('51f2891f-9f5a-4054-8823-3627b06e3e5b', '3b975094-4d95-4ee4-9fcb-2bd2514625c9', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('51f2891f-9f5a-4054-8823-3627b06e3e5b', '1fa4bd1c-d250-44ea-89af-f4460cd13d7d', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('51f2891f-9f5a-4054-8823-3627b06e3e5b', 'c3f54006-62f3-4978-b072-37769c2e4a89', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('51f2891f-9f5a-4054-8823-3627b06e3e5b', '50056c1c-f13e-4dea-bc4b-59bb6eae4768', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('aa5445f5-a056-46f7-97e8-7d5fe2ab4453', 'fc4f4c5a-1168-4a67-9ca8-104a5ae91c78', 't');
INSERT INTO "public"."client_scope_client" VALUES ('aa5445f5-a056-46f7-97e8-7d5fe2ab4453', '9b50f631-7ede-4ed2-8ac2-bcd3f4014fe4', 't');
INSERT INTO "public"."client_scope_client" VALUES ('aa5445f5-a056-46f7-97e8-7d5fe2ab4453', '0d6d3683-d0d7-4ad9-b08d-3ed0545fe0d6', 't');
INSERT INTO "public"."client_scope_client" VALUES ('aa5445f5-a056-46f7-97e8-7d5fe2ab4453', '33e3b464-6d41-491c-8e63-e9fa4bbf7a77', 't');
INSERT INTO "public"."client_scope_client" VALUES ('aa5445f5-a056-46f7-97e8-7d5fe2ab4453', '072eb48c-17cb-4d3c-b809-1066d9c8c366', 't');
INSERT INTO "public"."client_scope_client" VALUES ('aa5445f5-a056-46f7-97e8-7d5fe2ab4453', '3b975094-4d95-4ee4-9fcb-2bd2514625c9', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('aa5445f5-a056-46f7-97e8-7d5fe2ab4453', '1fa4bd1c-d250-44ea-89af-f4460cd13d7d', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('aa5445f5-a056-46f7-97e8-7d5fe2ab4453', 'c3f54006-62f3-4978-b072-37769c2e4a89', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('aa5445f5-a056-46f7-97e8-7d5fe2ab4453', '50056c1c-f13e-4dea-bc4b-59bb6eae4768', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('39132819-80be-4746-861d-ce870d61b7c1', 'fc4f4c5a-1168-4a67-9ca8-104a5ae91c78', 't');
INSERT INTO "public"."client_scope_client" VALUES ('39132819-80be-4746-861d-ce870d61b7c1', '9b50f631-7ede-4ed2-8ac2-bcd3f4014fe4', 't');
INSERT INTO "public"."client_scope_client" VALUES ('39132819-80be-4746-861d-ce870d61b7c1', '0d6d3683-d0d7-4ad9-b08d-3ed0545fe0d6', 't');
INSERT INTO "public"."client_scope_client" VALUES ('39132819-80be-4746-861d-ce870d61b7c1', '33e3b464-6d41-491c-8e63-e9fa4bbf7a77', 't');
INSERT INTO "public"."client_scope_client" VALUES ('39132819-80be-4746-861d-ce870d61b7c1', '072eb48c-17cb-4d3c-b809-1066d9c8c366', 't');
INSERT INTO "public"."client_scope_client" VALUES ('39132819-80be-4746-861d-ce870d61b7c1', '3b975094-4d95-4ee4-9fcb-2bd2514625c9', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('39132819-80be-4746-861d-ce870d61b7c1', '1fa4bd1c-d250-44ea-89af-f4460cd13d7d', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('39132819-80be-4746-861d-ce870d61b7c1', 'c3f54006-62f3-4978-b072-37769c2e4a89', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('39132819-80be-4746-861d-ce870d61b7c1', '50056c1c-f13e-4dea-bc4b-59bb6eae4768', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('a3074b6a-2f88-4a1e-b1ab-3564c6b89ba9', 'fc4f4c5a-1168-4a67-9ca8-104a5ae91c78', 't');
INSERT INTO "public"."client_scope_client" VALUES ('a3074b6a-2f88-4a1e-b1ab-3564c6b89ba9', '9b50f631-7ede-4ed2-8ac2-bcd3f4014fe4', 't');
INSERT INTO "public"."client_scope_client" VALUES ('a3074b6a-2f88-4a1e-b1ab-3564c6b89ba9', '0d6d3683-d0d7-4ad9-b08d-3ed0545fe0d6', 't');
INSERT INTO "public"."client_scope_client" VALUES ('a3074b6a-2f88-4a1e-b1ab-3564c6b89ba9', '33e3b464-6d41-491c-8e63-e9fa4bbf7a77', 't');
INSERT INTO "public"."client_scope_client" VALUES ('a3074b6a-2f88-4a1e-b1ab-3564c6b89ba9', '072eb48c-17cb-4d3c-b809-1066d9c8c366', 't');
INSERT INTO "public"."client_scope_client" VALUES ('a3074b6a-2f88-4a1e-b1ab-3564c6b89ba9', '3b975094-4d95-4ee4-9fcb-2bd2514625c9', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('a3074b6a-2f88-4a1e-b1ab-3564c6b89ba9', '1fa4bd1c-d250-44ea-89af-f4460cd13d7d', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('a3074b6a-2f88-4a1e-b1ab-3564c6b89ba9', 'c3f54006-62f3-4978-b072-37769c2e4a89', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('a3074b6a-2f88-4a1e-b1ab-3564c6b89ba9', '50056c1c-f13e-4dea-bc4b-59bb6eae4768', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('20d9416e-0e2d-48d3-bfff-f256d60cc99c', 'fc4f4c5a-1168-4a67-9ca8-104a5ae91c78', 't');
INSERT INTO "public"."client_scope_client" VALUES ('20d9416e-0e2d-48d3-bfff-f256d60cc99c', '9b50f631-7ede-4ed2-8ac2-bcd3f4014fe4', 't');
INSERT INTO "public"."client_scope_client" VALUES ('20d9416e-0e2d-48d3-bfff-f256d60cc99c', '0d6d3683-d0d7-4ad9-b08d-3ed0545fe0d6', 't');
INSERT INTO "public"."client_scope_client" VALUES ('20d9416e-0e2d-48d3-bfff-f256d60cc99c', '33e3b464-6d41-491c-8e63-e9fa4bbf7a77', 't');
INSERT INTO "public"."client_scope_client" VALUES ('20d9416e-0e2d-48d3-bfff-f256d60cc99c', '072eb48c-17cb-4d3c-b809-1066d9c8c366', 't');
INSERT INTO "public"."client_scope_client" VALUES ('20d9416e-0e2d-48d3-bfff-f256d60cc99c', '3b975094-4d95-4ee4-9fcb-2bd2514625c9', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('20d9416e-0e2d-48d3-bfff-f256d60cc99c', '1fa4bd1c-d250-44ea-89af-f4460cd13d7d', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('20d9416e-0e2d-48d3-bfff-f256d60cc99c', 'c3f54006-62f3-4978-b072-37769c2e4a89', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('20d9416e-0e2d-48d3-bfff-f256d60cc99c', '50056c1c-f13e-4dea-bc4b-59bb6eae4768', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('7b5fba19-edfe-4208-af18-4eba02c6d1fd', 'fc4f4c5a-1168-4a67-9ca8-104a5ae91c78', 't');
INSERT INTO "public"."client_scope_client" VALUES ('7b5fba19-edfe-4208-af18-4eba02c6d1fd', '9b50f631-7ede-4ed2-8ac2-bcd3f4014fe4', 't');
INSERT INTO "public"."client_scope_client" VALUES ('7b5fba19-edfe-4208-af18-4eba02c6d1fd', '0d6d3683-d0d7-4ad9-b08d-3ed0545fe0d6', 't');
INSERT INTO "public"."client_scope_client" VALUES ('7b5fba19-edfe-4208-af18-4eba02c6d1fd', '33e3b464-6d41-491c-8e63-e9fa4bbf7a77', 't');
INSERT INTO "public"."client_scope_client" VALUES ('7b5fba19-edfe-4208-af18-4eba02c6d1fd', '072eb48c-17cb-4d3c-b809-1066d9c8c366', 't');
INSERT INTO "public"."client_scope_client" VALUES ('7b5fba19-edfe-4208-af18-4eba02c6d1fd', '3b975094-4d95-4ee4-9fcb-2bd2514625c9', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('7b5fba19-edfe-4208-af18-4eba02c6d1fd', '1fa4bd1c-d250-44ea-89af-f4460cd13d7d', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('7b5fba19-edfe-4208-af18-4eba02c6d1fd', 'c3f54006-62f3-4978-b072-37769c2e4a89', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('7b5fba19-edfe-4208-af18-4eba02c6d1fd', '50056c1c-f13e-4dea-bc4b-59bb6eae4768', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('013f7a7e-a923-44dc-bf06-12f9d50a38c3', 'fc4f4c5a-1168-4a67-9ca8-104a5ae91c78', 't');
INSERT INTO "public"."client_scope_client" VALUES ('013f7a7e-a923-44dc-bf06-12f9d50a38c3', '9b50f631-7ede-4ed2-8ac2-bcd3f4014fe4', 't');
INSERT INTO "public"."client_scope_client" VALUES ('013f7a7e-a923-44dc-bf06-12f9d50a38c3', '0d6d3683-d0d7-4ad9-b08d-3ed0545fe0d6', 't');
INSERT INTO "public"."client_scope_client" VALUES ('013f7a7e-a923-44dc-bf06-12f9d50a38c3', '33e3b464-6d41-491c-8e63-e9fa4bbf7a77', 't');
INSERT INTO "public"."client_scope_client" VALUES ('013f7a7e-a923-44dc-bf06-12f9d50a38c3', '072eb48c-17cb-4d3c-b809-1066d9c8c366', 't');
INSERT INTO "public"."client_scope_client" VALUES ('013f7a7e-a923-44dc-bf06-12f9d50a38c3', '3b975094-4d95-4ee4-9fcb-2bd2514625c9', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('013f7a7e-a923-44dc-bf06-12f9d50a38c3', '1fa4bd1c-d250-44ea-89af-f4460cd13d7d', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('013f7a7e-a923-44dc-bf06-12f9d50a38c3', 'c3f54006-62f3-4978-b072-37769c2e4a89', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('013f7a7e-a923-44dc-bf06-12f9d50a38c3', '50056c1c-f13e-4dea-bc4b-59bb6eae4768', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('ab045118-6511-45fb-93d5-e6bcd83aa04f', 'fc4f4c5a-1168-4a67-9ca8-104a5ae91c78', 't');
INSERT INTO "public"."client_scope_client" VALUES ('ab045118-6511-45fb-93d5-e6bcd83aa04f', '9b50f631-7ede-4ed2-8ac2-bcd3f4014fe4', 't');
INSERT INTO "public"."client_scope_client" VALUES ('ab045118-6511-45fb-93d5-e6bcd83aa04f', '0d6d3683-d0d7-4ad9-b08d-3ed0545fe0d6', 't');
INSERT INTO "public"."client_scope_client" VALUES ('ab045118-6511-45fb-93d5-e6bcd83aa04f', '33e3b464-6d41-491c-8e63-e9fa4bbf7a77', 't');
INSERT INTO "public"."client_scope_client" VALUES ('ab045118-6511-45fb-93d5-e6bcd83aa04f', '072eb48c-17cb-4d3c-b809-1066d9c8c366', 't');
INSERT INTO "public"."client_scope_client" VALUES ('ab045118-6511-45fb-93d5-e6bcd83aa04f', '3b975094-4d95-4ee4-9fcb-2bd2514625c9', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('ab045118-6511-45fb-93d5-e6bcd83aa04f', '1fa4bd1c-d250-44ea-89af-f4460cd13d7d', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('ab045118-6511-45fb-93d5-e6bcd83aa04f', 'c3f54006-62f3-4978-b072-37769c2e4a89', 'f');
INSERT INTO "public"."client_scope_client" VALUES ('ab045118-6511-45fb-93d5-e6bcd83aa04f', '50056c1c-f13e-4dea-bc4b-59bb6eae4768', 'f');

-- ----------------------------
-- Table structure for client_scope_role_mapping
-- ----------------------------
DROP TABLE IF EXISTS "public"."client_scope_role_mapping";
CREATE TABLE "public"."client_scope_role_mapping" (
  "scope_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "role_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of client_scope_role_mapping
-- ----------------------------
INSERT INTO "public"."client_scope_role_mapping" VALUES ('0cf0a34b-0346-4291-8d89-683378a7e2e2', '3f44286b-64c4-4797-9a87-0100ab640c79');
INSERT INTO "public"."client_scope_role_mapping" VALUES ('50056c1c-f13e-4dea-bc4b-59bb6eae4768', '6638b669-7d90-4203-aa23-91b2d5bfa168');

-- ----------------------------
-- Table structure for client_session
-- ----------------------------
DROP TABLE IF EXISTS "public"."client_session";
CREATE TABLE "public"."client_session" (
  "id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "client_id" varchar(36) COLLATE "pg_catalog"."default",
  "redirect_uri" varchar(255) COLLATE "pg_catalog"."default",
  "state" varchar(255) COLLATE "pg_catalog"."default",
  "timestamp" int4,
  "session_id" varchar(36) COLLATE "pg_catalog"."default",
  "auth_method" varchar(255) COLLATE "pg_catalog"."default",
  "realm_id" varchar(255) COLLATE "pg_catalog"."default",
  "auth_user_id" varchar(36) COLLATE "pg_catalog"."default",
  "current_action" varchar(36) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of client_session
-- ----------------------------

-- ----------------------------
-- Table structure for client_session_auth_status
-- ----------------------------
DROP TABLE IF EXISTS "public"."client_session_auth_status";
CREATE TABLE "public"."client_session_auth_status" (
  "authenticator" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "status" int4,
  "client_session" varchar(36) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of client_session_auth_status
-- ----------------------------

-- ----------------------------
-- Table structure for client_session_note
-- ----------------------------
DROP TABLE IF EXISTS "public"."client_session_note";
CREATE TABLE "public"."client_session_note" (
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "value" varchar(255) COLLATE "pg_catalog"."default",
  "client_session" varchar(36) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of client_session_note
-- ----------------------------

-- ----------------------------
-- Table structure for client_session_prot_mapper
-- ----------------------------
DROP TABLE IF EXISTS "public"."client_session_prot_mapper";
CREATE TABLE "public"."client_session_prot_mapper" (
  "protocol_mapper_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "client_session" varchar(36) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of client_session_prot_mapper
-- ----------------------------

-- ----------------------------
-- Table structure for client_session_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."client_session_role";
CREATE TABLE "public"."client_session_role" (
  "role_id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "client_session" varchar(36) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of client_session_role
-- ----------------------------

-- ----------------------------
-- Table structure for client_user_session_note
-- ----------------------------
DROP TABLE IF EXISTS "public"."client_user_session_note";
CREATE TABLE "public"."client_user_session_note" (
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "value" varchar(2048) COLLATE "pg_catalog"."default",
  "client_session" varchar(36) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of client_user_session_note
-- ----------------------------

-- ----------------------------
-- Table structure for component
-- ----------------------------
DROP TABLE IF EXISTS "public"."component";
CREATE TABLE "public"."component" (
  "id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "parent_id" varchar(36) COLLATE "pg_catalog"."default",
  "provider_id" varchar(36) COLLATE "pg_catalog"."default",
  "provider_type" varchar(255) COLLATE "pg_catalog"."default",
  "realm_id" varchar(36) COLLATE "pg_catalog"."default",
  "sub_type" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of component
-- ----------------------------
INSERT INTO "public"."component" VALUES ('fcc98ea4-9c5b-403e-9b2d-28401ca26469', 'Trusted Hosts', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'trusted-hosts', 'org.keycloak.services.clientregistration.policy.ClientRegistrationPolicy', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'anonymous');
INSERT INTO "public"."component" VALUES ('a68ff05e-3791-4102-af6d-5b64302f23aa', 'Consent Required', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'consent-required', 'org.keycloak.services.clientregistration.policy.ClientRegistrationPolicy', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'anonymous');
INSERT INTO "public"."component" VALUES ('95fa7478-3a4c-49f5-94aa-bc96d32cc342', 'Full Scope Disabled', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'scope', 'org.keycloak.services.clientregistration.policy.ClientRegistrationPolicy', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'anonymous');
INSERT INTO "public"."component" VALUES ('727bfd4b-1ada-4d0c-b88f-71bee58b9dc9', 'Max Clients Limit', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'max-clients', 'org.keycloak.services.clientregistration.policy.ClientRegistrationPolicy', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'anonymous');
INSERT INTO "public"."component" VALUES ('0932d4b3-8d99-4237-b6e7-6b2d3a3c5c44', 'Allowed Protocol Mapper Types', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'allowed-protocol-mappers', 'org.keycloak.services.clientregistration.policy.ClientRegistrationPolicy', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'anonymous');
INSERT INTO "public"."component" VALUES ('18ffce94-1dc4-40b1-99f4-59c699d69851', 'Allowed Client Scopes', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'allowed-client-templates', 'org.keycloak.services.clientregistration.policy.ClientRegistrationPolicy', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'anonymous');
INSERT INTO "public"."component" VALUES ('24868ea3-fd03-426a-9f91-3dd2ea4e6a04', 'Allowed Protocol Mapper Types', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'allowed-protocol-mappers', 'org.keycloak.services.clientregistration.policy.ClientRegistrationPolicy', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'authenticated');
INSERT INTO "public"."component" VALUES ('b835ce5e-7c92-4b3d-bbb7-29c016d91393', 'Allowed Client Scopes', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'allowed-client-templates', 'org.keycloak.services.clientregistration.policy.ClientRegistrationPolicy', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'authenticated');
INSERT INTO "public"."component" VALUES ('e2eedda4-8c0b-4a39-992c-cb0648e503ee', 'rsa-generated', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'rsa-generated', 'org.keycloak.keys.KeyProvider', '2615b5da-5c3b-432f-af31-9af5f519b2a6', NULL);
INSERT INTO "public"."component" VALUES ('57cf46c6-da6e-4e42-96e8-abd7953d66da', 'rsa-enc-generated', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'rsa-enc-generated', 'org.keycloak.keys.KeyProvider', '2615b5da-5c3b-432f-af31-9af5f519b2a6', NULL);
INSERT INTO "public"."component" VALUES ('7b43f08f-d7ee-4b4d-bfa1-4c3aaf3ab160', 'hmac-generated', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'hmac-generated', 'org.keycloak.keys.KeyProvider', '2615b5da-5c3b-432f-af31-9af5f519b2a6', NULL);
INSERT INTO "public"."component" VALUES ('89fb03b8-aead-4f10-8531-b7b651aac3bc', 'aes-generated', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'aes-generated', 'org.keycloak.keys.KeyProvider', '2615b5da-5c3b-432f-af31-9af5f519b2a6', NULL);
INSERT INTO "public"."component" VALUES ('c41edf67-fa83-4688-a1ac-7be148397d20', 'rsa-generated', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'rsa-generated', 'org.keycloak.keys.KeyProvider', 'e668ca58-deb8-459c-9294-39e5e530c03f', NULL);
INSERT INTO "public"."component" VALUES ('4d3026f9-6ea4-4151-98ac-ef52f38238e6', 'rsa-enc-generated', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'rsa-enc-generated', 'org.keycloak.keys.KeyProvider', 'e668ca58-deb8-459c-9294-39e5e530c03f', NULL);
INSERT INTO "public"."component" VALUES ('ae2d4f0e-bc78-4d52-854a-cd8904ba2faf', 'hmac-generated', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'hmac-generated', 'org.keycloak.keys.KeyProvider', 'e668ca58-deb8-459c-9294-39e5e530c03f', NULL);
INSERT INTO "public"."component" VALUES ('e0c48a64-0db1-44b3-92d7-af2bcd099be2', 'aes-generated', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'aes-generated', 'org.keycloak.keys.KeyProvider', 'e668ca58-deb8-459c-9294-39e5e530c03f', NULL);
INSERT INTO "public"."component" VALUES ('9e029bd9-c51f-478d-9b39-d9b637af47a4', 'Trusted Hosts', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'trusted-hosts', 'org.keycloak.services.clientregistration.policy.ClientRegistrationPolicy', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'anonymous');
INSERT INTO "public"."component" VALUES ('f855f6f8-44f6-4533-8a30-4b93930ba1c0', 'Consent Required', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'consent-required', 'org.keycloak.services.clientregistration.policy.ClientRegistrationPolicy', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'anonymous');
INSERT INTO "public"."component" VALUES ('f9a6878e-4250-4608-ac95-a508d2391760', 'Full Scope Disabled', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'scope', 'org.keycloak.services.clientregistration.policy.ClientRegistrationPolicy', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'anonymous');
INSERT INTO "public"."component" VALUES ('be9feb1f-ad84-40d8-ad52-bb2936773723', 'Max Clients Limit', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'max-clients', 'org.keycloak.services.clientregistration.policy.ClientRegistrationPolicy', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'anonymous');
INSERT INTO "public"."component" VALUES ('61c7d176-15a0-47ab-8130-ef2c0d7606ba', 'Allowed Protocol Mapper Types', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'allowed-protocol-mappers', 'org.keycloak.services.clientregistration.policy.ClientRegistrationPolicy', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'anonymous');
INSERT INTO "public"."component" VALUES ('d80bac3f-2072-4b4f-9127-a1c8e554865d', 'Allowed Client Scopes', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'allowed-client-templates', 'org.keycloak.services.clientregistration.policy.ClientRegistrationPolicy', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'anonymous');
INSERT INTO "public"."component" VALUES ('33810afa-439c-4777-9eec-3eae2361d4b6', 'Allowed Protocol Mapper Types', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'allowed-protocol-mappers', 'org.keycloak.services.clientregistration.policy.ClientRegistrationPolicy', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'authenticated');
INSERT INTO "public"."component" VALUES ('c273d06c-be67-445f-8fe6-09351cb11095', 'Allowed Client Scopes', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'allowed-client-templates', 'org.keycloak.services.clientregistration.policy.ClientRegistrationPolicy', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'authenticated');

-- ----------------------------
-- Table structure for component_config
-- ----------------------------
DROP TABLE IF EXISTS "public"."component_config";
CREATE TABLE "public"."component_config" (
  "id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "component_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "value" varchar(4000) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of component_config
-- ----------------------------
INSERT INTO "public"."component_config" VALUES ('85c11879-1aa0-4bd0-bcb6-75fc7617b70a', 'fcc98ea4-9c5b-403e-9b2d-28401ca26469', 'host-sending-registration-request-must-match', 'true');
INSERT INTO "public"."component_config" VALUES ('94d3fb22-3cba-4bb9-8db3-7b45230c844f', 'fcc98ea4-9c5b-403e-9b2d-28401ca26469', 'client-uris-must-match', 'true');
INSERT INTO "public"."component_config" VALUES ('8a8c4174-c055-47cd-8315-9e3ddef3c28b', '0932d4b3-8d99-4237-b6e7-6b2d3a3c5c44', 'allowed-protocol-mapper-types', 'oidc-full-name-mapper');
INSERT INTO "public"."component_config" VALUES ('54a8cc53-cd58-4357-a397-5ebd9c6331e3', '0932d4b3-8d99-4237-b6e7-6b2d3a3c5c44', 'allowed-protocol-mapper-types', 'saml-user-property-mapper');
INSERT INTO "public"."component_config" VALUES ('a7f56085-be42-400c-ac95-ceb2553193c4', '0932d4b3-8d99-4237-b6e7-6b2d3a3c5c44', 'allowed-protocol-mapper-types', 'oidc-usermodel-property-mapper');
INSERT INTO "public"."component_config" VALUES ('2f7a4d38-8b22-413b-8d72-33c3822a015d', '0932d4b3-8d99-4237-b6e7-6b2d3a3c5c44', 'allowed-protocol-mapper-types', 'oidc-sha256-pairwise-sub-mapper');
INSERT INTO "public"."component_config" VALUES ('2cc8e06b-bd9c-4704-b0f3-c3b1b2de1ec0', '0932d4b3-8d99-4237-b6e7-6b2d3a3c5c44', 'allowed-protocol-mapper-types', 'oidc-address-mapper');
INSERT INTO "public"."component_config" VALUES ('252e0f20-7b55-4010-a3bc-9b0031fe5615', '0932d4b3-8d99-4237-b6e7-6b2d3a3c5c44', 'allowed-protocol-mapper-types', 'saml-role-list-mapper');
INSERT INTO "public"."component_config" VALUES ('e346ea54-cd4f-4df6-a9df-3e5c2a882b71', '0932d4b3-8d99-4237-b6e7-6b2d3a3c5c44', 'allowed-protocol-mapper-types', 'saml-user-attribute-mapper');
INSERT INTO "public"."component_config" VALUES ('93877613-dd44-4d61-9b17-273f2626c53c', '0932d4b3-8d99-4237-b6e7-6b2d3a3c5c44', 'allowed-protocol-mapper-types', 'oidc-usermodel-attribute-mapper');
INSERT INTO "public"."component_config" VALUES ('4c6bb9f2-bec8-4e9f-9426-92eeb44357b7', '24868ea3-fd03-426a-9f91-3dd2ea4e6a04', 'allowed-protocol-mapper-types', 'oidc-sha256-pairwise-sub-mapper');
INSERT INTO "public"."component_config" VALUES ('e841b7d5-8ff6-4bf1-9fee-46adc1430c23', '24868ea3-fd03-426a-9f91-3dd2ea4e6a04', 'allowed-protocol-mapper-types', 'saml-user-attribute-mapper');
INSERT INTO "public"."component_config" VALUES ('c1d821b3-0b77-4b6c-b0e0-db68fccf31d1', '24868ea3-fd03-426a-9f91-3dd2ea4e6a04', 'allowed-protocol-mapper-types', 'saml-role-list-mapper');
INSERT INTO "public"."component_config" VALUES ('2fb006f3-0478-4ce7-ba73-a9377b401f81', '24868ea3-fd03-426a-9f91-3dd2ea4e6a04', 'allowed-protocol-mapper-types', 'oidc-usermodel-attribute-mapper');
INSERT INTO "public"."component_config" VALUES ('af78c127-dcf3-447c-ab1a-50c46402485c', '24868ea3-fd03-426a-9f91-3dd2ea4e6a04', 'allowed-protocol-mapper-types', 'saml-user-property-mapper');
INSERT INTO "public"."component_config" VALUES ('b0a5fa91-9199-4e9f-9306-1da8f5929292', '24868ea3-fd03-426a-9f91-3dd2ea4e6a04', 'allowed-protocol-mapper-types', 'oidc-usermodel-property-mapper');
INSERT INTO "public"."component_config" VALUES ('7be6771d-5d87-45f9-b17c-998b4263b272', '24868ea3-fd03-426a-9f91-3dd2ea4e6a04', 'allowed-protocol-mapper-types', 'oidc-full-name-mapper');
INSERT INTO "public"."component_config" VALUES ('06197893-014a-4bd0-88ad-0bda6d39a018', '24868ea3-fd03-426a-9f91-3dd2ea4e6a04', 'allowed-protocol-mapper-types', 'oidc-address-mapper');
INSERT INTO "public"."component_config" VALUES ('28c4034c-0422-4ae0-86cc-c3fd25a9e48b', '727bfd4b-1ada-4d0c-b88f-71bee58b9dc9', 'max-clients', '200');
INSERT INTO "public"."component_config" VALUES ('5b432083-a7ae-4663-a8f2-77901ad63fe3', 'b835ce5e-7c92-4b3d-bbb7-29c016d91393', 'allow-default-scopes', 'true');
INSERT INTO "public"."component_config" VALUES ('cc1a4864-a6e5-450c-a4ed-149c3a2794c9', '18ffce94-1dc4-40b1-99f4-59c699d69851', 'allow-default-scopes', 'true');
INSERT INTO "public"."component_config" VALUES ('850af9d6-e38c-485e-9b08-1dc109b2aa78', '7b43f08f-d7ee-4b4d-bfa1-4c3aaf3ab160', 'secret', 'yDFB-rw_NZQVkFmC54pCyf1CAxIXzceCuBaX1UFm3X6Rzva0-n0MDq7m7p7I5Sj8ZLPb1peI4_lc4eMMK_u1aA');
INSERT INTO "public"."component_config" VALUES ('a1781dac-befb-4cf7-9f9c-07c4956d347f', '7b43f08f-d7ee-4b4d-bfa1-4c3aaf3ab160', 'algorithm', 'HS256');
INSERT INTO "public"."component_config" VALUES ('f0fb34b2-cef3-4ff9-9401-bdeff9882a2d', '7b43f08f-d7ee-4b4d-bfa1-4c3aaf3ab160', 'kid', 'cb47e0b5-fb2c-4f56-9ccb-202903c003e7');
INSERT INTO "public"."component_config" VALUES ('b4d52344-65cd-49b6-b173-04a89ec4cffe', '7b43f08f-d7ee-4b4d-bfa1-4c3aaf3ab160', 'priority', '100');
INSERT INTO "public"."component_config" VALUES ('2da5da2b-7f9a-4849-8f21-7fb06c28c7a3', '89fb03b8-aead-4f10-8531-b7b651aac3bc', 'kid', '24d78a3c-5cb6-4c53-b69b-ee0b46828341');
INSERT INTO "public"."component_config" VALUES ('9df649f1-3f4a-4361-a8fb-ae8312aef852', '89fb03b8-aead-4f10-8531-b7b651aac3bc', 'priority', '100');
INSERT INTO "public"."component_config" VALUES ('97377308-0a51-4f65-9cc4-86139b701533', '89fb03b8-aead-4f10-8531-b7b651aac3bc', 'secret', '5n-mGI6tPWdqB0PjM_0Oeg');
INSERT INTO "public"."component_config" VALUES ('5e3d1564-6638-4867-b0a0-00485a7406fa', 'e2eedda4-8c0b-4a39-992c-cb0648e503ee', 'certificate', 'MIICmzCCAYMCBgGPfFBqJDANBgkqhkiG9w0BAQsFADARMQ8wDQYDVQQDDAZtYXN0ZXIwHhcNMjQwNTE1MTI1MTM1WhcNMzQwNTE1MTI1MzE1WjARMQ8wDQYDVQQDDAZtYXN0ZXIwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQDAj2onEIpEqJw+JQP4D0lRgFXyKEhnXBi4z/o3qhpfCpBVUtD9Yns6UIB8AbMGEq/0HbG+FD77mOkZk5T+lqw0HLRkrgOFQjePJoUGyeVYftnccG5koV5NTmVfm7HXSMtHCMVTrhQ+ZlIqpBfjbMK1PkM8Buk/pnev4Z4vOZID5Z2rJn2Jmb1+6w+oM3M+4Y8ZUhAokoHvDt8sI348vsB7RAEMlxhBmT5Ksf44KJYMjUrQB81/CF9CSYTEXZxx3rlWVkXQ1ZQgPUIRyUJpRHre1ZxqQF+sMs32/1Q4hANUaYnKxKPoMT7Tav/abDjmje5TgJ2xURvOa67soCWBRiLHAgMBAAEwDQYJKoZIhvcNAQELBQADggEBAHXEvfzJe81rA0LhvajlD09uItFSbsWDFysMuRVuXGZ9UY0sbQ9ID0RWk25IG78plD9WQ9Y33s29LkIe5Tgx2ctJNJWq+AV3CnA43Aymx7+m3bLO8W/IGZTo6acVlztIeWwbgsgB/GdLy/OWIJ5OCF9457ditaLG7mj6KzS+kqy1HdNZmgTbuhyXWR8XlTJVCCW4Ymj8EwVi9gpVDG/8hBWnU06LrBWVaYpglpP7AqAzjOlYr780++NJOeq1Q2fhP+tAQGM5Q/JtIzUp5hu5zJSCs4nnB1qiGohDIhEcratcNsxLejli77v+0FqkeZKGYvHav2nnzqNTovs+JZQPHos=');
INSERT INTO "public"."component_config" VALUES ('3e93ed6d-7726-4261-85dc-e2c10c42c934', 'e2eedda4-8c0b-4a39-992c-cb0648e503ee', 'priority', '100');
INSERT INTO "public"."component_config" VALUES ('c837da17-4153-4f5e-bb0c-0cf20aac9dae', 'e2eedda4-8c0b-4a39-992c-cb0648e503ee', 'privateKey', 'MIIEowIBAAKCAQEAwI9qJxCKRKicPiUD+A9JUYBV8ihIZ1wYuM/6N6oaXwqQVVLQ/WJ7OlCAfAGzBhKv9B2xvhQ++5jpGZOU/pasNBy0ZK4DhUI3jyaFBsnlWH7Z3HBuZKFeTU5lX5ux10jLRwjFU64UPmZSKqQX42zCtT5DPAbpP6Z3r+GeLzmSA+WdqyZ9iZm9fusPqDNzPuGPGVIQKJKB7w7fLCN+PL7Ae0QBDJcYQZk+SrH+OCiWDI1K0AfNfwhfQkmExF2ccd65VlZF0NWUID1CEclCaUR63tWcakBfrDLN9v9UOIQDVGmJysSj6DE+02r/2mw45o3uU4CdsVEbzmuu7KAlgUYixwIDAQABAoIBAEyTO7WZQEMZgji8Y52sBo4gqQ0Js/FWkIY+PtUQEjilbMxhiLabCUIhbVbjHhxWJh7ACET8rCdFob0IEYJEzOpUV/CJuuCteoa03MXcWBYfK+gb1eqyuVuox2uD8O8aBayT8lTarzY5XoeSheVtBOkqf3ZJkUw8mPAamttQ254saeuSxckfHu3Ttl7n7T+7u+RvL3ZlChutiStUtBXaO1LBgoXlqsNgRdOpeAX9BZdg0YsOYaY9taSigmK+W47JWU5zk3i1NEHclC5RHglf9JciWx/j6Q80hxNAurfkTkQ83fyzU2YfRVxF97O3MJZo/eBQg4zsWmDTJznt9fAxrzECgYEA+pBB5fHdXq2J4nb5pnlQwc6v3E/t9mEGeyQQnQ3vMjS0Kll7IEIW8V2W3Yf3bCa/57LOCK3zRqAkxuPMgxZvPhL5fS2EHbSO6g/4aiyupnoIngOJhEyB3NTDJKC6w8vRUoySCkOwmR4mEth07YUKXspu7mL2EDUoq5EhJ7TNG7sCgYEAxLz7F66iLrdr8LetKBFKCuruEwXXjziyRsBUbDBM+wDpGFdI1R39EqOFX5ktTDHYiWeGiU30i3oz6ul1eX2mIl6QDySKF0luR44XXk/lly/8Bb8HtVRH/j1J8CHJEd9HZGR5SJdBQaiBnGLFIvlgoNSLCT+fXAQACo6A8AaWdmUCgYAjCEZeawmjcioEItRW5UFYR5io+ffwabJpRyqXetpFr7686RPg97yTdJ1iTd9XHLfaIlLSPdf0uPFLaZAvh9R33llJmjKNoLAWo7L8zVCB8DACP8ZbXAMQKCM8nMhgFcAnhYXpr3sifWefXOpER0Si6jTGWcnDjFsqWblD/vBqfwKBgQCH94edNV725GMgCQEN2O0QII8K7JWucOOczB1MbBE3w8hUvzYhu8kEUajCig1pRGW/iKHNUOf6YSlyZ4h9v13LEQmEvZ8GOwSRRV1XG+azl0EZA44jPq1GwzrPT7oztNkVQ+8iQQ6jfv6cgxJ1el3SqTGx4ZuUL1uL8DKiMBtalQKBgBOOT/uY6iD7GPuxIjxvZFUbM/kxDNBa1+rg7glb+dDQu67RV2OZU200QHium460dWEuDWkqGtEfsG52IUAxfX4ZRWaWfcbaJa9RUc3EIus+YpOOBpKYeJVcqjAhep4xRPJosZ3o++PFH6CjJypQnkF2ObqUh7FS6ksfzBZNZiRz');
INSERT INTO "public"."component_config" VALUES ('c1312728-a4ec-4975-86d4-cf13c9683c62', 'e2eedda4-8c0b-4a39-992c-cb0648e503ee', 'keyUse', 'SIG');
INSERT INTO "public"."component_config" VALUES ('99f1b6c8-9ad7-4572-a652-f7ad3da12f14', '57cf46c6-da6e-4e42-96e8-abd7953d66da', 'privateKey', 'MIIEpAIBAAKCAQEA2SXm0ttOPcZQR9Pt+SYCavEQuE1G0DfVzY6okcoIbfcu4u6BCDpRNE8JxDH46r7muIMt2hb9YQPCro9osf7gwceFadV+mh9e+v50arfcQ3SPZN1zIVIwIlqnKbBD1xjC4af1r0ib1zb0D2nbU0LRUUJtQIpKB3mOWp+zz6HubTtfYsxcRyUKLqB6pkmUSVFM5qlSyNflZYK3TYyZz80lMEUTEqSO4O7rvRBaVoK3ns5nCx4o9oEhNLW3YM1JDrEJp9zYPSSQqbTxZTZRTX0U4foiVa8VGV65tI6acDwyyAZbdMvS1rVxtfGNQZ+0OqaW1OXhkOUY5lZeIlSL5qQUmwIDAQABAoIBAFrs5fRQ5Dg1vBP3h+QVqFmDS48AvLAfUSVboPY69MCnCjj3yYvab3pJxjsi+anB+fY055Q0oDBpVLGnVx2BLje2BgVE4lhC3pCWz8SH7HFKc2i22aiQM5uO/gQUzLNaqO+4VsXoz2iUmCmEF9SLW/58pCasQUdT/OmxiaddlOqjdlhgSnmFSwitVzK0l49rRyI2P4OnrRZa8ixd/3A/ZBA1e67oPdVqqyrjQO18EnHlKAnXkISxl2WOANP75HhKH30Qp/ie/u5P2IwezBPPuOfLo04iwKeFc9bNXe4iD/GUK/1DZ1TNOpVB6GzMxqk2W05JjEz6uKP5HUdRMGLjGNECgYEA78OQNOy5tzYXsZJwA7Pmqb0LXkyopDgt7VymI+1yjpFsrBve2Nz+zRFVaR8+3xPr6zBDFfzuvV81oEdiareq5SAbWk8N5XTWp+cPz7pxKyQpwvpuBA0Bq5fo9PZODKITWlW2Yy5ItYZedKg8WkQ5xb8drCi+T1o/AidxTptUdT0CgYEA59pHtqUR9893MUxPPEBi6HFXoyhmsqbifOROB78aH6nun9QWskl9Em+EuaWYqeYkdRw3gAtevr3Plh6w2UNtlQYti/LWUrhli9IT/vwSV9za4pO2GRGH18KYNMVTTzeBQOEleeFcwFeI0ZnEyTx5f8A6tFRAx+FW/QvmIlVVvrcCgYA+f1CIqyghvKTicZRnMq6ukgtzkjHnVImMNLlN5igVR4z3M/CbwMdeNuV3mGBwD6ZQUO07vwmQLVAyLklWHfga74qRuMebhyAo9g7mC+hR4YRNQbAJuEY2L0vXBpkDq/+1bWA0bC0hvBvE9tF8igoxJIcciCZLUu/XpOZhIhYa1QKBgQCsUdK9EADDwwGetU2qxVv90MfG7y8tFtX85x6LqWA8Kmu9hL99sRrxSctGw6oslG2CUP96/nhjoeWYeKUORYw7l4TgoBLlFkH64p+UAzuK7A4PGqPcC+h/1xSTHBnoJaO+WdgltvbdyfFZf0UAIB9ZcMDw6DHhnTyvBFn+KJh7DwKBgQCLABz7DHhd+mgxdDuzxGxKn/hi5KMh9xaZ4IR+kG4hRpHt7/czLL9KJjWROJHvmvE9s3YfVKznRJ+Qla7NeOG6gPTqYMswLf6Uk1IFgEXFdP9Bm3bI6ZGjO3IBC5MGhHaDsWZF+tJpsSzgIvZ2SO26MoRCFIIjH60apvst3l8W2A==');
INSERT INTO "public"."component_config" VALUES ('db9bdf14-c1a6-4807-b818-a0264007cd0a', '57cf46c6-da6e-4e42-96e8-abd7953d66da', 'certificate', 'MIICmzCCAYMCBgGPfFBsnTANBgkqhkiG9w0BAQsFADARMQ8wDQYDVQQDDAZtYXN0ZXIwHhcNMjQwNTE1MTI1MTM2WhcNMzQwNTE1MTI1MzE2WjARMQ8wDQYDVQQDDAZtYXN0ZXIwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQDZJebS2049xlBH0+35JgJq8RC4TUbQN9XNjqiRyght9y7i7oEIOlE0TwnEMfjqvua4gy3aFv1hA8Kuj2ix/uDBx4Vp1X6aH176/nRqt9xDdI9k3XMhUjAiWqcpsEPXGMLhp/WvSJvXNvQPadtTQtFRQm1AikoHeY5an7PPoe5tO19izFxHJQouoHqmSZRJUUzmqVLI1+VlgrdNjJnPzSUwRRMSpI7g7uu9EFpWgreezmcLHij2gSE0tbdgzUkOsQmn3Ng9JJCptPFlNlFNfRTh+iJVrxUZXrm0jppwPDLIBlt0y9LWtXG18Y1Bn7Q6ppbU5eGQ5RjmVl4iVIvmpBSbAgMBAAEwDQYJKoZIhvcNAQELBQADggEBABtYQk/mFzE6jVNvfwJJhuU0cHHvkbgAIaIsWXlth+0Ag3X92e41Yf2Uv/eTVkMRku2nR1NzzE2JpPQlAMhej2F0Nhbs/7wBPZrq8ijbHTGEgUffqgQY08JTwBCnIwRn1yK472kzqyaf5AqJVBsJn/R4gkN0E9ICFXfsGz/zMI3+R2CnqM3MPkwsyC2QdkdGrwihjk5S+BbJbxHr8zbIVRTDALGTAdT8b3sh4JUIMk/41CD4T3Dfhzwbi1tNKHGLSxktrNWo5Cx7e0/gXtRfAuW6xb/Gt+9cSl4ysDLiQPBJHBpK6eq+Ul4dJEfK9kAMVjWYtP5qCutE9T9rjLn8dhI=');
INSERT INTO "public"."component_config" VALUES ('9e9a97ad-984a-488d-99bd-cdad9ba92fb9', '57cf46c6-da6e-4e42-96e8-abd7953d66da', 'algorithm', 'RSA-OAEP');
INSERT INTO "public"."component_config" VALUES ('4c9c6ca9-6704-40de-8974-b740583c17d9', '57cf46c6-da6e-4e42-96e8-abd7953d66da', 'priority', '100');
INSERT INTO "public"."component_config" VALUES ('4caa066d-7e4b-4007-9dc6-1c7826ad1d47', '57cf46c6-da6e-4e42-96e8-abd7953d66da', 'keyUse', 'ENC');
INSERT INTO "public"."component_config" VALUES ('e03aadf2-34c1-4a3b-8ac4-9f633e6c21f7', '4d3026f9-6ea4-4151-98ac-ef52f38238e6', 'certificate', 'MIICuTCCAaECBgGPfFDzlDANBgkqhkiG9w0BAQsFADAgMR4wHAYDVQQDDBVzcHJpbmctYm9vdC1yZWFsbS1kZXYwHhcNMjQwNTE1MTI1MjExWhcNMzQwNTE1MTI1MzUxWjAgMR4wHAYDVQQDDBVzcHJpbmctYm9vdC1yZWFsbS1kZXYwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQDw8DFHfvAQsizzh0uHQEbTsCQH1nBhKyy3eIWT4VW6dEnUVCuE4cGqP/ckIQOFjZ6qxE15VGXDDG82Z2qiSVS4LlffVYCzzs/6lXE0ZPGteUXS92bb9O6eTlIGzBELCLPRWNkksfCgtaHuNGxP+xYPjSAjMFo5rm1SRoZbaw1PCDCpu0f/oB+hEu25UhDb05dB3WIdUJ8LS9vhEH42r4OkvNa7GSFftaBdGmhQAIQ3c7Q5i0UYsGlUlmD8rGug9UmnJulXXpI6dq2C8+WFsa8RH0We/YnKOcLc4EATgU2VPlMps9sAdeqShpJ3WNPTemcxuLLHl9ji+3M4XxhMirZtAgMBAAEwDQYJKoZIhvcNAQELBQADggEBAJS2yZmaTeBI+AQKgqLyPwM3bm+I/9D1D5RVzaDdF2q+YNAyMorWKGUyZZ5daXhYiEojX/g6hRAzIvdYmdWNfV2oSsvFTcSLrdDdlAbVl3lmbHMU2U0QYzUlwPnS8pdYTfDeBUTDnlFcnXN5lI1C4xXJO33vZoSd4qnV77L6Govwjh8WmgsR+jq3YwFteWVE4JMQOslMQ3ZK0LtrZJ1be3A7WC3AilSy60guV9EC4Tq2MpEi5N8lACFCbeglDdXWFYLqzvPgVnRIQZiXMJzJDmTUXfImqQ0PFuOWmQPqOEgMsbIcf8ovkaGMyq/fe31Ml49TfZa5l3KpUOsv1yoLzvY=');
INSERT INTO "public"."component_config" VALUES ('5a687b27-c8a5-425e-a45e-a69a61fb435b', '4d3026f9-6ea4-4151-98ac-ef52f38238e6', 'algorithm', 'RSA-OAEP');
INSERT INTO "public"."component_config" VALUES ('c9ee448f-b2ba-459c-8cd3-744148837ca6', '4d3026f9-6ea4-4151-98ac-ef52f38238e6', 'privateKey', 'MIIEowIBAAKCAQEA8PAxR37wELIs84dLh0BG07AkB9ZwYSsst3iFk+FVunRJ1FQrhOHBqj/3JCEDhY2eqsRNeVRlwwxvNmdqoklUuC5X31WAs87P+pVxNGTxrXlF0vdm2/Tunk5SBswRCwiz0VjZJLHwoLWh7jRsT/sWD40gIzBaOa5tUkaGW2sNTwgwqbtH/6AfoRLtuVIQ29OXQd1iHVCfC0vb4RB+Nq+DpLzWuxkhX7WgXRpoUACEN3O0OYtFGLBpVJZg/KxroPVJpybpV16SOnatgvPlhbGvER9Fnv2JyjnC3OBAE4FNlT5TKbPbAHXqkoaSd1jT03pnMbiyx5fY4vtzOF8YTIq2bQIDAQABAoIBABE/4QdRWzaWywkUYp/oRinZrnqxK5KJWMY55rZTp6OVt8Nv0z3MO+VIdxUrF+lz3iwzqahKFo8EUOIAPW4o+dvF1ZyzrmcxI0q5cEVkBLl6uTkFZWPSAVNsIAtEiOPVV6phRgqOgr++wT0gm7CONWIfpHFggNUoW8NMMUpSO72woNtZHC0b8HJKZmqElt1l16Xmy6vJw9vasPX+8wp8PCgBTPNcwaXOosljDV0J5O+q6I5wbxbzXydkN92JjxLmIkFeFCzpIYfQOHajM86HT2lVqCs9Rr504e7uFdO/IiSlkRCBCzDDfkd1vNueLnFdYofYIvPKATwZiOtejAmhnjECgYEA+djxWq5+S5WCTRk8jPUxDELg9DdLqAtMwoeBK6P0tbOxciI8BBAAyhUjqdWCqcGFyp4aGoQ0TVv1pcu4wKsBqQIrMVWG8DrZ6OxC6tdpCnFwlO63mb/66z/w6ofDM6mchA3rcRWKOPAHgnpjV/bA4RboTj/Xq9l7gNvCmalyMvMCgYEA9t8V5t3kopm0YYC2ETbo+ohYqR6vNttpHvyXxwl+bM9a//NXfoIa8VeTusNs8NrENzp83jpvHjibiK5dQ7TZYBJOIXleX9GvhZQXM8QoBNWHwsD/xe78QbCTaYY77MGG3yVFRBAYDLMU+oa5Itfux/KC+1c/kw91ojeJ+e9kCR8CgYBSXHWTkxoHCI4fpEYVoW49wH4vg1rpVnBDYC/wlufATjAck7R9EllwRG+xOLUOCMF1/ZBVVWd4aOwdb37D5Jtzf0eFx8/nuT7ETb3xdHkn/CVEszzK7kJk8nsUlRSAH1V9IqmOaa9a/aU8GeRNxwXmLYr+4ITUHalc3RTVWspOiQKBgBHHn1wxPvY2+7bJ/lLfEYh5qWkEvLnGs5t3tbawCFrt1C/65qJF3IrlM86PpJj0KI2RuMyIiNg0W39Mj4sAy2cP6nCevR1JjMqiD8m6pucyOcTdAY7P13sjrHo9ILO8fGo11PdB8Xl4rFoeuda4lonv/V78uadtxZsZROarRxkhAoGBAI3imc9ep4/4s55cyexMJaTjxCHmM6s3BBhtHSVeJvOxd7V6dUnwHOSu9mse3iym0+YlbbTZxgvM549IYzwVAiaH09kpNRnyto5U8yXWVkg4YNhQKEjeJ3DXvPTK8PCO+X0W2FxNjoXiLOv+ZmJPfA4k5GCfI540TO8JPAjBW1x0');
INSERT INTO "public"."component_config" VALUES ('67a16a4f-2946-4e1e-bbd0-92b1df062510', '4d3026f9-6ea4-4151-98ac-ef52f38238e6', 'priority', '100');
INSERT INTO "public"."component_config" VALUES ('984aacee-0b64-42f3-9fc9-f67400c41320', '4d3026f9-6ea4-4151-98ac-ef52f38238e6', 'keyUse', 'ENC');
INSERT INTO "public"."component_config" VALUES ('bfac6135-ddaa-4d00-8300-5ea1e7dfdabc', 'e0c48a64-0db1-44b3-92d7-af2bcd099be2', 'priority', '100');
INSERT INTO "public"."component_config" VALUES ('3662da6f-b276-441e-885b-a72dae766542', 'e0c48a64-0db1-44b3-92d7-af2bcd099be2', 'secret', 'pkJVmIq5DSyaREuhxqPuJQ');
INSERT INTO "public"."component_config" VALUES ('5b659403-2462-4d31-b07e-26ba1ae08773', 'e0c48a64-0db1-44b3-92d7-af2bcd099be2', 'kid', '12efdc46-cacf-4bae-97b1-6aa101035337');
INSERT INTO "public"."component_config" VALUES ('d35e2690-4ad3-41dd-88b2-81bbe7461412', 'c41edf67-fa83-4688-a1ac-7be148397d20', 'keyUse', 'SIG');
INSERT INTO "public"."component_config" VALUES ('57efdab6-f339-4fe7-a751-0fb49a0d4ddd', 'c41edf67-fa83-4688-a1ac-7be148397d20', 'certificate', 'MIICuTCCAaECBgGPfFDy0TANBgkqhkiG9w0BAQsFADAgMR4wHAYDVQQDDBVzcHJpbmctYm9vdC1yZWFsbS1kZXYwHhcNMjQwNTE1MTI1MjEwWhcNMzQwNTE1MTI1MzUwWjAgMR4wHAYDVQQDDBVzcHJpbmctYm9vdC1yZWFsbS1kZXYwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCk943cAhIMTuvhZkCdhHu8ZmJUuQAo0a3J/qAEXomilLq9decQfd2hhVgm3+ie+rQFvLFcbvra3SlbrEQvqmwjpAf4vmxP+K3T+4EGcWt/a216rTWbCNjAE5RRjp+/Mp7ek23lQpAO3xt3vuTCvn6YUNkMCL5TIY14/UawmUiOqM8TkfTh9dknko2HRHsnMbR3g2UOctxbE45tixgnl1sRGuU59wcA2a6tsnMOHlNHtOUb6rN8a1qVGMXBifpe+l93I+L4E/J/xZctG6vk1oIiAIKKA1pYGTZROQUian9d2CKuP+9eXNAZHCzcV1rf72L+0hjH75yKdubqlPRO0dmlAgMBAAEwDQYJKoZIhvcNAQELBQADggEBADfnHy39QY0vvszEq2furIf7HXrs5NUWg2nPdOJio+5A9ahA08GEKrcm091Y5CYYFUP8XaIt3nOSkhWd1KQdWKHjd+UzoHj5DHWfZtotqChX9Y9JqFtjhrOoM3pjTqba4gFbdYLLP9jaxgKL++118Uud/Ilnn4oD8aqkDgKz4RgqqF7QEqdV/QrVxoDYUq3S8BjxP+n/eqVcSvq/66oBHJ2VM2jTki2FWSR5btqe0Wh8J8al9oQdQkY5ns3IES50lFdDed0U2S0Ty1QlCK5NUxBgjpM91ggsregwWbo8y++pFnaTO3nYMdf7VuD82R9pQXw0k2jaEUxdlp8HH+mwspQ=');
INSERT INTO "public"."component_config" VALUES ('1e971741-3223-47b7-b29a-eaae763627c6', 'c41edf67-fa83-4688-a1ac-7be148397d20', 'privateKey', 'MIIEowIBAAKCAQEApPeN3AISDE7r4WZAnYR7vGZiVLkAKNGtyf6gBF6JopS6vXXnEH3doYVYJt/onvq0BbyxXG762t0pW6xEL6psI6QH+L5sT/it0/uBBnFrf2tteq01mwjYwBOUUY6fvzKe3pNt5UKQDt8bd77kwr5+mFDZDAi+UyGNeP1GsJlIjqjPE5H04fXZJ5KNh0R7JzG0d4NlDnLcWxOObYsYJ5dbERrlOfcHANmurbJzDh5TR7TlG+qzfGtalRjFwYn6XvpfdyPi+BPyf8WXLRur5NaCIgCCigNaWBk2UTkFImp/Xdgirj/vXlzQGRws3Fda3+9i/tIYx++cinbm6pT0TtHZpQIDAQABAoIBAEwgXRtw7Sk25k0+pYTLFVqsmKXmNXegwyUa1ncNtVAMeFxj4zxOCQ+3fCV8YFm08YxQNjykjiiftK00QscISxzrXi5gmZUR+g1/21vAzU2gooXhFoKzw2pn3qMAQSG3V27489a/L8FdHczVj7V6uOrLLE4MXt/39NQndQ6bvcrux4W+2taWdCyJH38cBuZOGON7JxsCUuc7sGu3bbvBVZpxWnXtS1J75ESZyZs30TH/tX+Pc3eszSqlJhZwJjBS4UuQuH44Jvet9W1FGoDpzDLsR0eM8sMalNaTt3pzEob+Ly/qnAFaoIDXjEUXIRkygX6LRgdganzv2o2YkbpXRwUCgYEA22RBpn/U4GjsK/keK4Th0u0qgsWzsfF+ThVrsUpbfFibWFavlHoQ0aAXmmTXCXwsG2YXca/y73t1MaDAjXgW1JDUoT+EShnBn4sbrDOoYpubzdRgIo4UNtrJ3pb4IRQwYRFqDdmgJMlpZ4T+Zw4aA1kL/ObshsjjFCRkyDti4BMCgYEAwH5xgi8XnJSWAot0E6qzXaVdzAdnT4JAt3T/TLKypQSsTeyrKQU0QhN0HBvE8+VpdKMVq96iLSjfde3lBhFhoxI92kgvlu27VIpJIuWd6pjeMMdyDUl++/LLOteBqhJ+KtiFtAvLpQJyyw7X5Z8ZWSvs7GlXg4QNd2Sn9FG5xmcCgYAT71kzytvKBF6pZDqEk899PgWl2lcIrTvf1nxxoKMNenOrJD1SDYFnutdKNS2A9CKB3tX0g5tcfWhZuRSmBip06DAZ8s6PeSWp3JcIH62GQEN5AXo2yZg2n8zGCAvF3bLDrzRmy8aMcSy9tkzzikl80mOPeGA3oxtXIjNyKktCtwKBgBiFArhufzd2xdT1JogKymY3VkdS+hnqoYu833hJmu/iNICIkRTckNeJ2tRpxSC8LD6rN2t5JHdUKYLAFtg7BpDbFf3kDAvRpHcUVlSXoxHq/wJ/pUuD/STivHh2UxHy4RdcFUvl5L7UHQM4lM+vAG+XZMqIcJlUDNMUg0Bf2KYpAoGBAI8M/JhHbFECbo/6vKCf57qArYVets86wCcaxB1FZFkIH7yUefksv0Ehr+jZLGMWloi5g3NJgJWRDPlB+951hk59mBmlSUzXt4tdL9zjwfxdGIdF7LqNpKps91P8yC6Ej6oMAfUeDn2jDxLxSZW2z1mU089+6QdymQEB9DOcNWGj');
INSERT INTO "public"."component_config" VALUES ('ef0981c2-6633-464e-8870-5fc5c6ed8f90', 'c41edf67-fa83-4688-a1ac-7be148397d20', 'priority', '100');
INSERT INTO "public"."component_config" VALUES ('33ac4aac-b19a-459b-b9e9-4cdd7c41228d', 'ae2d4f0e-bc78-4d52-854a-cd8904ba2faf', 'secret', 'twt8LLdtQA2yZ85ttNiTbvMiIYqZCxr7e4OsfedokQTLK9adfSGh5Qzxg1qB1tGT32ULOTcWNRxLgvGlouO9cA');
INSERT INTO "public"."component_config" VALUES ('0e269aa8-97e3-4991-892a-cb7c7dab749e', 'ae2d4f0e-bc78-4d52-854a-cd8904ba2faf', 'priority', '100');
INSERT INTO "public"."component_config" VALUES ('8791a5ee-d716-4249-b2fa-eb8bca33d34b', 'ae2d4f0e-bc78-4d52-854a-cd8904ba2faf', 'kid', '32d04011-3bb3-4aa8-a1a9-80c7e49e9700');
INSERT INTO "public"."component_config" VALUES ('1a79e521-e3b0-479f-9849-ac2234e1e07b', 'ae2d4f0e-bc78-4d52-854a-cd8904ba2faf', 'algorithm', 'HS256');
INSERT INTO "public"."component_config" VALUES ('7250c7f2-e467-4254-873c-032c197dbea3', '61c7d176-15a0-47ab-8130-ef2c0d7606ba', 'allowed-protocol-mapper-types', 'saml-user-attribute-mapper');
INSERT INTO "public"."component_config" VALUES ('cbed2472-57b4-4ac6-933e-4e6ee2d634e6', '61c7d176-15a0-47ab-8130-ef2c0d7606ba', 'allowed-protocol-mapper-types', 'oidc-usermodel-property-mapper');
INSERT INTO "public"."component_config" VALUES ('18e9ca1f-e596-4739-bd15-3f59e3c4e674', '61c7d176-15a0-47ab-8130-ef2c0d7606ba', 'allowed-protocol-mapper-types', 'saml-role-list-mapper');
INSERT INTO "public"."component_config" VALUES ('1811475d-4ed5-4197-b4d2-eaae9e41723a', '61c7d176-15a0-47ab-8130-ef2c0d7606ba', 'allowed-protocol-mapper-types', 'oidc-usermodel-attribute-mapper');
INSERT INTO "public"."component_config" VALUES ('01762bbd-fb53-4c68-8c38-bc8840407065', '61c7d176-15a0-47ab-8130-ef2c0d7606ba', 'allowed-protocol-mapper-types', 'saml-user-property-mapper');
INSERT INTO "public"."component_config" VALUES ('f5991c5f-b172-436c-80cd-70955f10a26b', '61c7d176-15a0-47ab-8130-ef2c0d7606ba', 'allowed-protocol-mapper-types', 'oidc-sha256-pairwise-sub-mapper');
INSERT INTO "public"."component_config" VALUES ('28cb069d-7798-4175-9fb5-f4aa631f5318', '61c7d176-15a0-47ab-8130-ef2c0d7606ba', 'allowed-protocol-mapper-types', 'oidc-full-name-mapper');
INSERT INTO "public"."component_config" VALUES ('f1c60f56-69c9-4eb6-801f-322fdcff44cc', '61c7d176-15a0-47ab-8130-ef2c0d7606ba', 'allowed-protocol-mapper-types', 'oidc-address-mapper');
INSERT INTO "public"."component_config" VALUES ('d11984fb-a37e-4848-a93a-f0fed570d755', 'be9feb1f-ad84-40d8-ad52-bb2936773723', 'max-clients', '200');
INSERT INTO "public"."component_config" VALUES ('adfb5ed1-8025-411f-b01f-d168b8b5916b', '9e029bd9-c51f-478d-9b39-d9b637af47a4', 'host-sending-registration-request-must-match', 'true');
INSERT INTO "public"."component_config" VALUES ('f4b58e0f-50b2-46e0-9263-537dc05516b0', '9e029bd9-c51f-478d-9b39-d9b637af47a4', 'client-uris-must-match', 'true');
INSERT INTO "public"."component_config" VALUES ('4b3fa6a6-ce74-4723-9227-797c5e9dfd84', 'c273d06c-be67-445f-8fe6-09351cb11095', 'allow-default-scopes', 'true');
INSERT INTO "public"."component_config" VALUES ('b4520900-e87e-4802-adba-b4557353d9fa', 'd80bac3f-2072-4b4f-9127-a1c8e554865d', 'allow-default-scopes', 'true');
INSERT INTO "public"."component_config" VALUES ('7bafc03e-0d75-4afb-9d89-20a7b74908bb', '33810afa-439c-4777-9eec-3eae2361d4b6', 'allowed-protocol-mapper-types', 'saml-user-property-mapper');
INSERT INTO "public"."component_config" VALUES ('fa4ca220-4b28-4d78-883a-83fa5761a60f', '33810afa-439c-4777-9eec-3eae2361d4b6', 'allowed-protocol-mapper-types', 'oidc-usermodel-property-mapper');
INSERT INTO "public"."component_config" VALUES ('5716c340-98ad-4152-88de-5cb2f0ab91c8', '33810afa-439c-4777-9eec-3eae2361d4b6', 'allowed-protocol-mapper-types', 'oidc-full-name-mapper');
INSERT INTO "public"."component_config" VALUES ('e087f19a-9ee7-436f-945e-695f761080d9', '33810afa-439c-4777-9eec-3eae2361d4b6', 'allowed-protocol-mapper-types', 'saml-role-list-mapper');
INSERT INTO "public"."component_config" VALUES ('0099662c-0191-41c9-bf47-3529e1868cc9', '33810afa-439c-4777-9eec-3eae2361d4b6', 'allowed-protocol-mapper-types', 'oidc-usermodel-attribute-mapper');
INSERT INTO "public"."component_config" VALUES ('2facab7d-f4a7-4eae-9cd6-ba7b2d4fe68d', '33810afa-439c-4777-9eec-3eae2361d4b6', 'allowed-protocol-mapper-types', 'oidc-address-mapper');
INSERT INTO "public"."component_config" VALUES ('c3ea3727-6590-4c0b-8b70-4c0590404ff7', '33810afa-439c-4777-9eec-3eae2361d4b6', 'allowed-protocol-mapper-types', 'oidc-sha256-pairwise-sub-mapper');
INSERT INTO "public"."component_config" VALUES ('55212df4-9f4f-4dbb-99c1-c5b9718f536f', '33810afa-439c-4777-9eec-3eae2361d4b6', 'allowed-protocol-mapper-types', 'saml-user-attribute-mapper');

-- ----------------------------
-- Table structure for composite_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."composite_role";
CREATE TABLE "public"."composite_role" (
  "composite" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "child_role" varchar(36) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of composite_role
-- ----------------------------
INSERT INTO "public"."composite_role" VALUES ('65fc0149-3019-478a-9f89-1070902d30ac', '4563d488-ae6e-4c47-982f-7a944dca3315');
INSERT INTO "public"."composite_role" VALUES ('65fc0149-3019-478a-9f89-1070902d30ac', '87bddd2e-a8c2-427c-9eee-2551c52b833a');
INSERT INTO "public"."composite_role" VALUES ('65fc0149-3019-478a-9f89-1070902d30ac', '4063c93e-c013-407d-8988-b22226d30eab');
INSERT INTO "public"."composite_role" VALUES ('65fc0149-3019-478a-9f89-1070902d30ac', '087aabfe-8d7c-4199-820c-dafa28d78ab4');
INSERT INTO "public"."composite_role" VALUES ('65fc0149-3019-478a-9f89-1070902d30ac', 'a703639a-dfad-49c2-a690-14646d0cc15f');
INSERT INTO "public"."composite_role" VALUES ('65fc0149-3019-478a-9f89-1070902d30ac', 'eb4b4f13-1f77-4906-a86d-761d553f7c75');
INSERT INTO "public"."composite_role" VALUES ('65fc0149-3019-478a-9f89-1070902d30ac', '3a04f9a5-e48f-4951-a1e1-2d4ce4bedadc');
INSERT INTO "public"."composite_role" VALUES ('65fc0149-3019-478a-9f89-1070902d30ac', '81675fb1-7db6-4c81-9d58-f67f8bea99ac');
INSERT INTO "public"."composite_role" VALUES ('65fc0149-3019-478a-9f89-1070902d30ac', '96def430-199b-4ca5-bf94-cf17d2e1107a');
INSERT INTO "public"."composite_role" VALUES ('65fc0149-3019-478a-9f89-1070902d30ac', 'ff6c6662-281a-45ba-85c9-eee46b3daacf');
INSERT INTO "public"."composite_role" VALUES ('65fc0149-3019-478a-9f89-1070902d30ac', 'd1967293-739e-4929-809e-eecdec6dc886');
INSERT INTO "public"."composite_role" VALUES ('65fc0149-3019-478a-9f89-1070902d30ac', '6ab62bf7-0e01-4e20-90f0-9808e24c51d9');
INSERT INTO "public"."composite_role" VALUES ('65fc0149-3019-478a-9f89-1070902d30ac', 'f9fad5a9-e9fd-4bcf-873f-8704e91e7df2');
INSERT INTO "public"."composite_role" VALUES ('65fc0149-3019-478a-9f89-1070902d30ac', 'efd2a77d-ec05-4994-8420-e098d037d6ef');
INSERT INTO "public"."composite_role" VALUES ('65fc0149-3019-478a-9f89-1070902d30ac', 'e5108bbf-8356-4d06-ad4c-c22776df4433');
INSERT INTO "public"."composite_role" VALUES ('65fc0149-3019-478a-9f89-1070902d30ac', '867bb1ca-79b2-4cd9-b822-ce1a4c525c67');
INSERT INTO "public"."composite_role" VALUES ('65fc0149-3019-478a-9f89-1070902d30ac', '33b604e4-82cc-4fcb-ada2-2b09333d9c97');
INSERT INTO "public"."composite_role" VALUES ('65fc0149-3019-478a-9f89-1070902d30ac', '2cef1106-65fd-4dcb-9f99-244bb0fac29c');
INSERT INTO "public"."composite_role" VALUES ('087aabfe-8d7c-4199-820c-dafa28d78ab4', '2cef1106-65fd-4dcb-9f99-244bb0fac29c');
INSERT INTO "public"."composite_role" VALUES ('087aabfe-8d7c-4199-820c-dafa28d78ab4', 'e5108bbf-8356-4d06-ad4c-c22776df4433');
INSERT INTO "public"."composite_role" VALUES ('963f1d10-817e-483b-a520-124cf561b457', 'b810741d-f504-435f-879f-878c72017bf2');
INSERT INTO "public"."composite_role" VALUES ('a703639a-dfad-49c2-a690-14646d0cc15f', '867bb1ca-79b2-4cd9-b822-ce1a4c525c67');
INSERT INTO "public"."composite_role" VALUES ('963f1d10-817e-483b-a520-124cf561b457', '5145a956-bd72-4410-a888-f52908ff8de6');
INSERT INTO "public"."composite_role" VALUES ('5145a956-bd72-4410-a888-f52908ff8de6', '058764ef-3b12-4e79-a46b-80e6b41b8a6a');
INSERT INTO "public"."composite_role" VALUES ('5c56fb08-48b3-47fd-8651-f57072eee361', '423ec62d-5001-4b4a-97fb-a85092b3b363');
INSERT INTO "public"."composite_role" VALUES ('65fc0149-3019-478a-9f89-1070902d30ac', '86ff801f-9de1-43b6-bc10-8c2359c618af');
INSERT INTO "public"."composite_role" VALUES ('963f1d10-817e-483b-a520-124cf561b457', '3f44286b-64c4-4797-9a87-0100ab640c79');
INSERT INTO "public"."composite_role" VALUES ('963f1d10-817e-483b-a520-124cf561b457', 'cd63ca60-00e0-4644-96ec-dce24011b101');
INSERT INTO "public"."composite_role" VALUES ('65fc0149-3019-478a-9f89-1070902d30ac', '0988e974-2024-41e5-8c32-508b22b973b0');
INSERT INTO "public"."composite_role" VALUES ('65fc0149-3019-478a-9f89-1070902d30ac', '6e458f60-7b19-4acb-9c96-899fd2026f67');
INSERT INTO "public"."composite_role" VALUES ('65fc0149-3019-478a-9f89-1070902d30ac', '2e2ddcaa-14dd-481f-8e63-f0e3f0a21e9b');
INSERT INTO "public"."composite_role" VALUES ('65fc0149-3019-478a-9f89-1070902d30ac', '93a07816-81e8-476f-b19c-7ce5a57972e3');
INSERT INTO "public"."composite_role" VALUES ('65fc0149-3019-478a-9f89-1070902d30ac', '763fd871-95d0-4ed0-ad62-b42563d77605');
INSERT INTO "public"."composite_role" VALUES ('65fc0149-3019-478a-9f89-1070902d30ac', '971cc95b-cf7f-4d82-9173-74beb2e01f59');
INSERT INTO "public"."composite_role" VALUES ('65fc0149-3019-478a-9f89-1070902d30ac', 'd7e8380f-4dc7-42b1-8fd2-db7c7bc5e9b5');
INSERT INTO "public"."composite_role" VALUES ('65fc0149-3019-478a-9f89-1070902d30ac', '23fa0bb9-de2b-4b87-9221-56bdb0c02528');
INSERT INTO "public"."composite_role" VALUES ('65fc0149-3019-478a-9f89-1070902d30ac', 'fb2aef97-2fea-4b05-a30a-d72cebe38449');
INSERT INTO "public"."composite_role" VALUES ('65fc0149-3019-478a-9f89-1070902d30ac', '07352222-5b9f-4889-876a-abbf96e05f05');
INSERT INTO "public"."composite_role" VALUES ('65fc0149-3019-478a-9f89-1070902d30ac', '5678a1aa-2183-411d-baf8-1cb77285b1c4');
INSERT INTO "public"."composite_role" VALUES ('65fc0149-3019-478a-9f89-1070902d30ac', 'a25c6703-4bb9-489c-ac50-a238b75e8ad8');
INSERT INTO "public"."composite_role" VALUES ('65fc0149-3019-478a-9f89-1070902d30ac', 'a78d4052-4e7b-47b4-b13a-ca3f081055e8');
INSERT INTO "public"."composite_role" VALUES ('65fc0149-3019-478a-9f89-1070902d30ac', '271780ee-beec-4b7f-ba91-95e2c96590a6');
INSERT INTO "public"."composite_role" VALUES ('65fc0149-3019-478a-9f89-1070902d30ac', 'd53b666e-d916-4e44-898b-2562385af3e4');
INSERT INTO "public"."composite_role" VALUES ('65fc0149-3019-478a-9f89-1070902d30ac', '696b5770-ceef-420f-aff4-6f9018dd4d96');
INSERT INTO "public"."composite_role" VALUES ('65fc0149-3019-478a-9f89-1070902d30ac', 'dcbc2317-ac1e-4599-875b-232717dde80d');
INSERT INTO "public"."composite_role" VALUES ('2e2ddcaa-14dd-481f-8e63-f0e3f0a21e9b', 'dcbc2317-ac1e-4599-875b-232717dde80d');
INSERT INTO "public"."composite_role" VALUES ('2e2ddcaa-14dd-481f-8e63-f0e3f0a21e9b', '271780ee-beec-4b7f-ba91-95e2c96590a6');
INSERT INTO "public"."composite_role" VALUES ('93a07816-81e8-476f-b19c-7ce5a57972e3', 'd53b666e-d916-4e44-898b-2562385af3e4');
INSERT INTO "public"."composite_role" VALUES ('5af3bb46-70b4-469c-a964-b13736ebf36f', '139e0bef-158d-4a9c-802b-5c6768d05297');
INSERT INTO "public"."composite_role" VALUES ('5af3bb46-70b4-469c-a964-b13736ebf36f', '3a82a7eb-c421-4391-9c6c-2378fd1f75ec');
INSERT INTO "public"."composite_role" VALUES ('5af3bb46-70b4-469c-a964-b13736ebf36f', '63efa6aa-a85e-4dd6-aa96-2d04fdb1c573');
INSERT INTO "public"."composite_role" VALUES ('5af3bb46-70b4-469c-a964-b13736ebf36f', '370f9c56-d9b2-442f-8785-fe39bc847e62');
INSERT INTO "public"."composite_role" VALUES ('5af3bb46-70b4-469c-a964-b13736ebf36f', '3de3589c-2c21-486c-8270-dd1e049fa7e0');
INSERT INTO "public"."composite_role" VALUES ('5af3bb46-70b4-469c-a964-b13736ebf36f', 'f7ff78ff-afd3-4d54-9075-8a6defa4aaab');
INSERT INTO "public"."composite_role" VALUES ('5af3bb46-70b4-469c-a964-b13736ebf36f', 'c7ea5e9a-bfcc-4cb8-bcca-ff205c7c07f2');
INSERT INTO "public"."composite_role" VALUES ('5af3bb46-70b4-469c-a964-b13736ebf36f', '5f4b1af8-0142-4347-b1fa-15268c90c6d5');
INSERT INTO "public"."composite_role" VALUES ('5af3bb46-70b4-469c-a964-b13736ebf36f', '66627d90-e457-45f0-8315-5e3bed234842');
INSERT INTO "public"."composite_role" VALUES ('5af3bb46-70b4-469c-a964-b13736ebf36f', '44e1b181-5113-4832-b951-eedd4d1e6cd8');
INSERT INTO "public"."composite_role" VALUES ('5af3bb46-70b4-469c-a964-b13736ebf36f', 'd9917051-d97f-4952-bffc-8f87e8105d88');
INSERT INTO "public"."composite_role" VALUES ('5af3bb46-70b4-469c-a964-b13736ebf36f', 'e86eb467-a81b-4c30-ac81-18cc7a2951dd');
INSERT INTO "public"."composite_role" VALUES ('5af3bb46-70b4-469c-a964-b13736ebf36f', '0a71f1c1-0c08-46eb-88a9-ce62b4aac965');
INSERT INTO "public"."composite_role" VALUES ('5af3bb46-70b4-469c-a964-b13736ebf36f', '210f7b06-7fef-4f10-9ac7-4fa2d916424d');
INSERT INTO "public"."composite_role" VALUES ('5af3bb46-70b4-469c-a964-b13736ebf36f', '0896918b-26d5-4aae-8e0b-fc800f2dbb8e');
INSERT INTO "public"."composite_role" VALUES ('5af3bb46-70b4-469c-a964-b13736ebf36f', 'a16638be-25b8-4356-9229-2218c7068f4e');
INSERT INTO "public"."composite_role" VALUES ('5af3bb46-70b4-469c-a964-b13736ebf36f', 'c81eef58-8c5d-409e-9a3d-19cee5db5d85');
INSERT INTO "public"."composite_role" VALUES ('35579285-15b3-403c-a636-4c5a2767c90a', '09efab05-ec9a-47cd-9954-b89abc424fad');
INSERT INTO "public"."composite_role" VALUES ('370f9c56-d9b2-442f-8785-fe39bc847e62', '0896918b-26d5-4aae-8e0b-fc800f2dbb8e');
INSERT INTO "public"."composite_role" VALUES ('63efa6aa-a85e-4dd6-aa96-2d04fdb1c573', 'c81eef58-8c5d-409e-9a3d-19cee5db5d85');
INSERT INTO "public"."composite_role" VALUES ('63efa6aa-a85e-4dd6-aa96-2d04fdb1c573', '210f7b06-7fef-4f10-9ac7-4fa2d916424d');
INSERT INTO "public"."composite_role" VALUES ('35579285-15b3-403c-a636-4c5a2767c90a', '05027f7e-0390-47f2-a3a3-ca33d49beac6');
INSERT INTO "public"."composite_role" VALUES ('05027f7e-0390-47f2-a3a3-ca33d49beac6', '9cc494ca-d02f-4482-a74e-0108251c2d27');
INSERT INTO "public"."composite_role" VALUES ('2c328d98-992f-4033-8e3c-8421857bb7d3', '0ec4f99f-bf5e-4834-b451-7266afbe647c');
INSERT INTO "public"."composite_role" VALUES ('65fc0149-3019-478a-9f89-1070902d30ac', '401d44ba-e48a-4be9-896b-97192732f271');
INSERT INTO "public"."composite_role" VALUES ('5af3bb46-70b4-469c-a964-b13736ebf36f', 'e5b59374-d652-4b96-bf87-4740aef9b554');
INSERT INTO "public"."composite_role" VALUES ('35579285-15b3-403c-a636-4c5a2767c90a', '6638b669-7d90-4203-aa23-91b2d5bfa168');
INSERT INTO "public"."composite_role" VALUES ('35579285-15b3-403c-a636-4c5a2767c90a', '31b319e8-9e92-4645-82d5-649b46ffb9d8');
INSERT INTO "public"."composite_role" VALUES ('b63687c2-e689-4c46-852f-a2e0698d834b', '66627d90-e457-45f0-8315-5e3bed234842');
INSERT INTO "public"."composite_role" VALUES ('b63687c2-e689-4c46-852f-a2e0698d834b', '5f4b1af8-0142-4347-b1fa-15268c90c6d5');
INSERT INTO "public"."composite_role" VALUES ('b63687c2-e689-4c46-852f-a2e0698d834b', '9cc494ca-d02f-4482-a74e-0108251c2d27');
INSERT INTO "public"."composite_role" VALUES ('b63687c2-e689-4c46-852f-a2e0698d834b', '05027f7e-0390-47f2-a3a3-ca33d49beac6');
INSERT INTO "public"."composite_role" VALUES ('147e24ee-88a1-47ab-8a7e-33e00d538f25', '33f34903-cf72-4d0c-adac-5b552d530b92');
INSERT INTO "public"."composite_role" VALUES ('2499f3ff-56d8-465e-bda8-485e7f87e9fe', '1d94e0b1-91a4-4ab4-ae60-285057b4411c');

-- ----------------------------
-- Table structure for credential
-- ----------------------------
DROP TABLE IF EXISTS "public"."credential";
CREATE TABLE "public"."credential" (
  "id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "salt" bytea,
  "type" varchar(255) COLLATE "pg_catalog"."default",
  "user_id" varchar(36) COLLATE "pg_catalog"."default",
  "created_date" int8,
  "user_label" varchar(255) COLLATE "pg_catalog"."default",
  "secret_data" text COLLATE "pg_catalog"."default",
  "credential_data" text COLLATE "pg_catalog"."default",
  "priority" int4
)
;

-- ----------------------------
-- Records of credential
-- ----------------------------
INSERT INTO "public"."credential" VALUES ('f00c7ce6-12bf-463a-96dd-4942a835a92a', NULL, 'password', 'c823ecac-ca19-4dd8-959e-83dc4c4ab3f7', 1715777598677, NULL, '{"value":"iL3RrDsdtIO/SvvOEXE077ZHGLdp+qwMCM7UVemoGsw=","salt":"+QkdrnfbXDrEaxP3CA2cpw==","additionalParameters":{}}', '{"hashIterations":27500,"algorithm":"pbkdf2-sha256","additionalParameters":{}}', 10);
INSERT INTO "public"."credential" VALUES ('d78255e1-77ef-4d6a-9cf2-5f981e0227c5', NULL, 'password', '7ad37931-d638-4de4-b5c3-6fcd3f447285', 1715777899803, 'My password', '{"value":"Am2WVkCy00R+a/zK1Qu5jVFtCQp4Ali5eUTlJCc3ZEQ=","salt":"qQo84djWJuoHL7TBi58flg==","additionalParameters":{}}', '{"hashIterations":27500,"algorithm":"pbkdf2-sha256","additionalParameters":{}}', 10);
INSERT INTO "public"."credential" VALUES ('faf3aa2f-ea43-417a-acf1-9042fa3f3c3a', NULL, 'password', 'e8a1f677-0c79-4dee-9993-c6e392d6c00a', 1715777975012, 'My password', '{"value":"jtCTuuUVUb25gmLZYd66TrOMacwOC8sQK+dOrHf7ew4=","salt":"h27RrekjmRcV21oCQ/GEow==","additionalParameters":{}}', '{"hashIterations":27500,"algorithm":"pbkdf2-sha256","additionalParameters":{}}', 10);
INSERT INTO "public"."credential" VALUES ('778f0be4-66e3-4fcd-97ad-1601b6db08d4', NULL, 'password', '1a1d2bc4-1235-433a-b00e-bbff136a4195', 1716007060207, 'My password', '{"value":"1FOIi311FmCdWBxAh8ExRUuiwy+P0jL9Lb9rtRT+eZA=","salt":"FPjynaqRzFl3tiHgo93nEg==","additionalParameters":{}}', '{"hashIterations":27500,"algorithm":"pbkdf2-sha256","additionalParameters":{}}', 10);
INSERT INTO "public"."credential" VALUES ('65d6b304-c454-4d73-9095-cb2e4f528f06', NULL, 'password', 'e554a98a-0c8e-434c-ad16-1b3e10a7d518', 1716296471565, 'My password', '{"value":"x/VbRz05TCMEghyU5QXrgyhswYeDJdvG9ak4j59m3Yc=","salt":"kvrdT3LBb4TFv6xC+QuFxw==","additionalParameters":{}}', '{"hashIterations":27500,"algorithm":"pbkdf2-sha256","additionalParameters":{}}', 10);

-- ----------------------------
-- Table structure for databasechangelog
-- ----------------------------
DROP TABLE IF EXISTS "public"."databasechangelog";
CREATE TABLE "public"."databasechangelog" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "author" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "filename" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "dateexecuted" timestamp(6) NOT NULL,
  "orderexecuted" int4 NOT NULL,
  "exectype" varchar(10) COLLATE "pg_catalog"."default" NOT NULL,
  "md5sum" varchar(35) COLLATE "pg_catalog"."default",
  "description" varchar(255) COLLATE "pg_catalog"."default",
  "comments" varchar(255) COLLATE "pg_catalog"."default",
  "tag" varchar(255) COLLATE "pg_catalog"."default",
  "liquibase" varchar(20) COLLATE "pg_catalog"."default",
  "contexts" varchar(255) COLLATE "pg_catalog"."default",
  "labels" varchar(255) COLLATE "pg_catalog"."default",
  "deployment_id" varchar(10) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of databasechangelog
-- ----------------------------
INSERT INTO "public"."databasechangelog" VALUES ('1.0.0.Final-KEYCLOAK-5461', 'sthorger@redhat.com', 'META-INF/jpa-changelog-1.0.0.Final.xml', '2024-05-15 12:52:36.646289', 1, 'EXECUTED', '8:bda77d94bf90182a1e30c24f1c155ec7', 'createTable tableName=APPLICATION_DEFAULT_ROLES; createTable tableName=CLIENT; createTable tableName=CLIENT_SESSION; createTable tableName=CLIENT_SESSION_ROLE; createTable tableName=COMPOSITE_ROLE; createTable tableName=CREDENTIAL; createTable tab...', '', NULL, '4.20.0', NULL, NULL, '5777555705');
INSERT INTO "public"."databasechangelog" VALUES ('1.0.0.Final-KEYCLOAK-5461', 'sthorger@redhat.com', 'META-INF/db2-jpa-changelog-1.0.0.Final.xml', '2024-05-15 12:52:36.654958', 2, 'MARK_RAN', '8:1ecb330f30986693d1cba9ab579fa219', 'createTable tableName=APPLICATION_DEFAULT_ROLES; createTable tableName=CLIENT; createTable tableName=CLIENT_SESSION; createTable tableName=CLIENT_SESSION_ROLE; createTable tableName=COMPOSITE_ROLE; createTable tableName=CREDENTIAL; createTable tab...', '', NULL, '4.20.0', NULL, NULL, '5777555705');
INSERT INTO "public"."databasechangelog" VALUES ('1.1.0.Beta1', 'sthorger@redhat.com', 'META-INF/jpa-changelog-1.1.0.Beta1.xml', '2024-05-15 12:52:36.896572', 3, 'EXECUTED', '8:cb7ace19bc6d959f305605d255d4c843', 'delete tableName=CLIENT_SESSION_ROLE; delete tableName=CLIENT_SESSION; delete tableName=USER_SESSION; createTable tableName=CLIENT_ATTRIBUTES; createTable tableName=CLIENT_SESSION_NOTE; createTable tableName=APP_NODE_REGISTRATIONS; addColumn table...', '', NULL, '4.20.0', NULL, NULL, '5777555705');
INSERT INTO "public"."databasechangelog" VALUES ('1.1.0.Final', 'sthorger@redhat.com', 'META-INF/jpa-changelog-1.1.0.Final.xml', '2024-05-15 12:52:36.932367', 4, 'EXECUTED', '8:80230013e961310e6872e871be424a63', 'renameColumn newColumnName=EVENT_TIME, oldColumnName=TIME, tableName=EVENT_ENTITY', '', NULL, '4.20.0', NULL, NULL, '5777555705');
INSERT INTO "public"."databasechangelog" VALUES ('1.2.0.Beta1', 'psilva@redhat.com', 'META-INF/jpa-changelog-1.2.0.Beta1.xml', '2024-05-15 12:52:37.483823', 5, 'EXECUTED', '8:67f4c20929126adc0c8e9bf48279d244', 'delete tableName=CLIENT_SESSION_ROLE; delete tableName=CLIENT_SESSION_NOTE; delete tableName=CLIENT_SESSION; delete tableName=USER_SESSION; createTable tableName=PROTOCOL_MAPPER; createTable tableName=PROTOCOL_MAPPER_CONFIG; createTable tableName=...', '', NULL, '4.20.0', NULL, NULL, '5777555705');
INSERT INTO "public"."databasechangelog" VALUES ('1.2.0.Beta1', 'psilva@redhat.com', 'META-INF/db2-jpa-changelog-1.2.0.Beta1.xml', '2024-05-15 12:52:37.501811', 6, 'MARK_RAN', '8:7311018b0b8179ce14628ab412bb6783', 'delete tableName=CLIENT_SESSION_ROLE; delete tableName=CLIENT_SESSION_NOTE; delete tableName=CLIENT_SESSION; delete tableName=USER_SESSION; createTable tableName=PROTOCOL_MAPPER; createTable tableName=PROTOCOL_MAPPER_CONFIG; createTable tableName=...', '', NULL, '4.20.0', NULL, NULL, '5777555705');
INSERT INTO "public"."databasechangelog" VALUES ('1.2.0.RC1', 'bburke@redhat.com', 'META-INF/jpa-changelog-1.2.0.CR1.xml', '2024-05-15 12:53:09.810748', 7, 'EXECUTED', '8:037ba1216c3640f8785ee6b8e7c8e3c1', 'delete tableName=CLIENT_SESSION_ROLE; delete tableName=CLIENT_SESSION_NOTE; delete tableName=CLIENT_SESSION; delete tableName=USER_SESSION_NOTE; delete tableName=USER_SESSION; createTable tableName=MIGRATION_MODEL; createTable tableName=IDENTITY_P...', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('1.2.0.RC1', 'bburke@redhat.com', 'META-INF/db2-jpa-changelog-1.2.0.CR1.xml', '2024-05-15 12:53:09.828726', 8, 'MARK_RAN', '8:7fe6ffe4af4df289b3157de32c624263', 'delete tableName=CLIENT_SESSION_ROLE; delete tableName=CLIENT_SESSION_NOTE; delete tableName=CLIENT_SESSION; delete tableName=USER_SESSION_NOTE; delete tableName=USER_SESSION; createTable tableName=MIGRATION_MODEL; createTable tableName=IDENTITY_P...', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('1.2.0.Final', 'keycloak', 'META-INF/jpa-changelog-1.2.0.Final.xml', '2024-05-15 12:53:09.846008', 9, 'EXECUTED', '8:9c136bc3187083a98745c7d03bc8a303', 'update tableName=CLIENT; update tableName=CLIENT; update tableName=CLIENT', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('1.3.0', 'bburke@redhat.com', 'META-INF/jpa-changelog-1.3.0.xml', '2024-05-15 12:53:10.090032', 10, 'EXECUTED', '8:b5f09474dca81fb56a97cf5b6553d331', 'delete tableName=CLIENT_SESSION_ROLE; delete tableName=CLIENT_SESSION_PROT_MAPPER; delete tableName=CLIENT_SESSION_NOTE; delete tableName=CLIENT_SESSION; delete tableName=USER_SESSION_NOTE; delete tableName=USER_SESSION; createTable tableName=ADMI...', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('1.4.0', 'bburke@redhat.com', 'META-INF/jpa-changelog-1.4.0.xml', '2024-05-15 12:53:10.207673', 11, 'EXECUTED', '8:ca924f31bd2a3b219fdcfe78c82dacf4', 'delete tableName=CLIENT_SESSION_AUTH_STATUS; delete tableName=CLIENT_SESSION_ROLE; delete tableName=CLIENT_SESSION_PROT_MAPPER; delete tableName=CLIENT_SESSION_NOTE; delete tableName=CLIENT_SESSION; delete tableName=USER_SESSION_NOTE; delete table...', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('1.4.0', 'bburke@redhat.com', 'META-INF/db2-jpa-changelog-1.4.0.xml', '2024-05-15 12:53:10.212664', 12, 'MARK_RAN', '8:8acad7483e106416bcfa6f3b824a16cd', 'delete tableName=CLIENT_SESSION_AUTH_STATUS; delete tableName=CLIENT_SESSION_ROLE; delete tableName=CLIENT_SESSION_PROT_MAPPER; delete tableName=CLIENT_SESSION_NOTE; delete tableName=CLIENT_SESSION; delete tableName=USER_SESSION_NOTE; delete table...', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('1.5.0', 'bburke@redhat.com', 'META-INF/jpa-changelog-1.5.0.xml', '2024-05-15 12:53:10.240227', 13, 'EXECUTED', '8:9b1266d17f4f87c78226f5055408fd5e', 'delete tableName=CLIENT_SESSION_AUTH_STATUS; delete tableName=CLIENT_SESSION_ROLE; delete tableName=CLIENT_SESSION_PROT_MAPPER; delete tableName=CLIENT_SESSION_NOTE; delete tableName=CLIENT_SESSION; delete tableName=USER_SESSION_NOTE; delete table...', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('1.6.1_from15', 'mposolda@redhat.com', 'META-INF/jpa-changelog-1.6.1.xml', '2024-05-15 12:53:10.29322', 14, 'EXECUTED', '8:d80ec4ab6dbfe573550ff72396c7e910', 'addColumn tableName=REALM; addColumn tableName=KEYCLOAK_ROLE; addColumn tableName=CLIENT; createTable tableName=OFFLINE_USER_SESSION; createTable tableName=OFFLINE_CLIENT_SESSION; addPrimaryKey constraintName=CONSTRAINT_OFFL_US_SES_PK2, tableName=...', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('1.6.1_from16-pre', 'mposolda@redhat.com', 'META-INF/jpa-changelog-1.6.1.xml', '2024-05-15 12:53:10.296739', 15, 'MARK_RAN', '8:d86eb172171e7c20b9c849b584d147b2', 'delete tableName=OFFLINE_CLIENT_SESSION; delete tableName=OFFLINE_USER_SESSION', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('1.6.1_from16', 'mposolda@redhat.com', 'META-INF/jpa-changelog-1.6.1.xml', '2024-05-15 12:53:10.301297', 16, 'MARK_RAN', '8:5735f46f0fa60689deb0ecdc2a0dea22', 'dropPrimaryKey constraintName=CONSTRAINT_OFFLINE_US_SES_PK, tableName=OFFLINE_USER_SESSION; dropPrimaryKey constraintName=CONSTRAINT_OFFLINE_CL_SES_PK, tableName=OFFLINE_CLIENT_SESSION; addColumn tableName=OFFLINE_USER_SESSION; update tableName=OF...', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('1.6.1', 'mposolda@redhat.com', 'META-INF/jpa-changelog-1.6.1.xml', '2024-05-15 12:53:10.306167', 17, 'EXECUTED', '8:d41d8cd98f00b204e9800998ecf8427e', 'empty', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('1.7.0', 'bburke@redhat.com', 'META-INF/jpa-changelog-1.7.0.xml', '2024-05-15 12:53:10.423373', 18, 'EXECUTED', '8:5c1a8fd2014ac7fc43b90a700f117b23', 'createTable tableName=KEYCLOAK_GROUP; createTable tableName=GROUP_ROLE_MAPPING; createTable tableName=GROUP_ATTRIBUTE; createTable tableName=USER_GROUP_MEMBERSHIP; createTable tableName=REALM_DEFAULT_GROUPS; addColumn tableName=IDENTITY_PROVIDER; ...', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('1.8.0', 'mposolda@redhat.com', 'META-INF/jpa-changelog-1.8.0.xml', '2024-05-15 12:53:10.523617', 19, 'EXECUTED', '8:1f6c2c2dfc362aff4ed75b3f0ef6b331', 'addColumn tableName=IDENTITY_PROVIDER; createTable tableName=CLIENT_TEMPLATE; createTable tableName=CLIENT_TEMPLATE_ATTRIBUTES; createTable tableName=TEMPLATE_SCOPE_MAPPING; dropNotNullConstraint columnName=CLIENT_ID, tableName=PROTOCOL_MAPPER; ad...', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('1.8.0-2', 'keycloak', 'META-INF/jpa-changelog-1.8.0.xml', '2024-05-15 12:53:10.534068', 20, 'EXECUTED', '8:dee9246280915712591f83a127665107', 'dropDefaultValue columnName=ALGORITHM, tableName=CREDENTIAL; update tableName=CREDENTIAL', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('1.8.0', 'mposolda@redhat.com', 'META-INF/db2-jpa-changelog-1.8.0.xml', '2024-05-15 12:53:10.53661', 21, 'MARK_RAN', '8:9eb2ee1fa8ad1c5e426421a6f8fdfa6a', 'addColumn tableName=IDENTITY_PROVIDER; createTable tableName=CLIENT_TEMPLATE; createTable tableName=CLIENT_TEMPLATE_ATTRIBUTES; createTable tableName=TEMPLATE_SCOPE_MAPPING; dropNotNullConstraint columnName=CLIENT_ID, tableName=PROTOCOL_MAPPER; ad...', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('1.8.0-2', 'keycloak', 'META-INF/db2-jpa-changelog-1.8.0.xml', '2024-05-15 12:53:10.543173', 22, 'MARK_RAN', '8:dee9246280915712591f83a127665107', 'dropDefaultValue columnName=ALGORITHM, tableName=CREDENTIAL; update tableName=CREDENTIAL', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('1.9.0', 'mposolda@redhat.com', 'META-INF/jpa-changelog-1.9.0.xml', '2024-05-15 12:53:10.581247', 23, 'EXECUTED', '8:d9fa18ffa355320395b86270680dd4fe', 'update tableName=REALM; update tableName=REALM; update tableName=REALM; update tableName=REALM; update tableName=CREDENTIAL; update tableName=CREDENTIAL; update tableName=CREDENTIAL; update tableName=REALM; update tableName=REALM; customChange; dr...', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('1.9.1', 'keycloak', 'META-INF/jpa-changelog-1.9.1.xml', '2024-05-15 12:53:10.587941', 24, 'EXECUTED', '8:90cff506fedb06141ffc1c71c4a1214c', 'modifyDataType columnName=PRIVATE_KEY, tableName=REALM; modifyDataType columnName=PUBLIC_KEY, tableName=REALM; modifyDataType columnName=CERTIFICATE, tableName=REALM', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('1.9.1', 'keycloak', 'META-INF/db2-jpa-changelog-1.9.1.xml', '2024-05-15 12:53:10.591183', 25, 'MARK_RAN', '8:11a788aed4961d6d29c427c063af828c', 'modifyDataType columnName=PRIVATE_KEY, tableName=REALM; modifyDataType columnName=CERTIFICATE, tableName=REALM', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('1.9.2', 'keycloak', 'META-INF/jpa-changelog-1.9.2.xml', '2024-05-15 12:53:10.763269', 26, 'EXECUTED', '8:a4218e51e1faf380518cce2af5d39b43', 'createIndex indexName=IDX_USER_EMAIL, tableName=USER_ENTITY; createIndex indexName=IDX_USER_ROLE_MAPPING, tableName=USER_ROLE_MAPPING; createIndex indexName=IDX_USER_GROUP_MAPPING, tableName=USER_GROUP_MEMBERSHIP; createIndex indexName=IDX_USER_CO...', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('authz-2.0.0', 'psilva@redhat.com', 'META-INF/jpa-changelog-authz-2.0.0.xml', '2024-05-15 12:53:11.083397', 27, 'EXECUTED', '8:d9e9a1bfaa644da9952456050f07bbdc', 'createTable tableName=RESOURCE_SERVER; addPrimaryKey constraintName=CONSTRAINT_FARS, tableName=RESOURCE_SERVER; addUniqueConstraint constraintName=UK_AU8TT6T700S9V50BU18WS5HA6, tableName=RESOURCE_SERVER; createTable tableName=RESOURCE_SERVER_RESOU...', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('authz-2.5.1', 'psilva@redhat.com', 'META-INF/jpa-changelog-authz-2.5.1.xml', '2024-05-15 12:53:11.097881', 28, 'EXECUTED', '8:d1bf991a6163c0acbfe664b615314505', 'update tableName=RESOURCE_SERVER_POLICY', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('2.1.0-KEYCLOAK-5461', 'bburke@redhat.com', 'META-INF/jpa-changelog-2.1.0.xml', '2024-05-15 12:53:11.299075', 29, 'EXECUTED', '8:88a743a1e87ec5e30bf603da68058a8c', 'createTable tableName=BROKER_LINK; createTable tableName=FED_USER_ATTRIBUTE; createTable tableName=FED_USER_CONSENT; createTable tableName=FED_USER_CONSENT_ROLE; createTable tableName=FED_USER_CONSENT_PROT_MAPPER; createTable tableName=FED_USER_CR...', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('2.2.0', 'bburke@redhat.com', 'META-INF/jpa-changelog-2.2.0.xml', '2024-05-15 12:53:11.34544', 30, 'EXECUTED', '8:c5517863c875d325dea463d00ec26d7a', 'addColumn tableName=ADMIN_EVENT_ENTITY; createTable tableName=CREDENTIAL_ATTRIBUTE; createTable tableName=FED_CREDENTIAL_ATTRIBUTE; modifyDataType columnName=VALUE, tableName=CREDENTIAL; addForeignKeyConstraint baseTableName=FED_CREDENTIAL_ATTRIBU...', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('2.3.0', 'bburke@redhat.com', 'META-INF/jpa-changelog-2.3.0.xml', '2024-05-15 12:53:11.41202', 31, 'EXECUTED', '8:ada8b4833b74a498f376d7136bc7d327', 'createTable tableName=FEDERATED_USER; addPrimaryKey constraintName=CONSTR_FEDERATED_USER, tableName=FEDERATED_USER; dropDefaultValue columnName=TOTP, tableName=USER_ENTITY; dropColumn columnName=TOTP, tableName=USER_ENTITY; addColumn tableName=IDE...', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('2.4.0', 'bburke@redhat.com', 'META-INF/jpa-changelog-2.4.0.xml', '2024-05-15 12:53:11.442865', 32, 'EXECUTED', '8:b9b73c8ea7299457f99fcbb825c263ba', 'customChange', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('2.5.0', 'bburke@redhat.com', 'META-INF/jpa-changelog-2.5.0.xml', '2024-05-15 12:53:11.501686', 33, 'EXECUTED', '8:07724333e625ccfcfc5adc63d57314f3', 'customChange; modifyDataType columnName=USER_ID, tableName=OFFLINE_USER_SESSION', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('2.5.0-unicode-oracle', 'hmlnarik@redhat.com', 'META-INF/jpa-changelog-2.5.0.xml', '2024-05-15 12:53:11.514738', 34, 'MARK_RAN', '8:8b6fd445958882efe55deb26fc541a7b', 'modifyDataType columnName=DESCRIPTION, tableName=AUTHENTICATION_FLOW; modifyDataType columnName=DESCRIPTION, tableName=CLIENT_TEMPLATE; modifyDataType columnName=DESCRIPTION, tableName=RESOURCE_SERVER_POLICY; modifyDataType columnName=DESCRIPTION,...', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('2.5.0-unicode-other-dbs', 'hmlnarik@redhat.com', 'META-INF/jpa-changelog-2.5.0.xml', '2024-05-15 12:53:11.586511', 35, 'EXECUTED', '8:29b29cfebfd12600897680147277a9d7', 'modifyDataType columnName=DESCRIPTION, tableName=AUTHENTICATION_FLOW; modifyDataType columnName=DESCRIPTION, tableName=CLIENT_TEMPLATE; modifyDataType columnName=DESCRIPTION, tableName=RESOURCE_SERVER_POLICY; modifyDataType columnName=DESCRIPTION,...', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('2.5.0-duplicate-email-support', 'slawomir@dabek.name', 'META-INF/jpa-changelog-2.5.0.xml', '2024-05-15 12:53:11.595123', 36, 'EXECUTED', '8:73ad77ca8fd0410c7f9f15a471fa52bc', 'addColumn tableName=REALM', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('2.5.0-unique-group-names', 'hmlnarik@redhat.com', 'META-INF/jpa-changelog-2.5.0.xml', '2024-05-15 12:53:11.606982', 37, 'EXECUTED', '8:64f27a6fdcad57f6f9153210f2ec1bdb', 'addUniqueConstraint constraintName=SIBLING_NAMES, tableName=KEYCLOAK_GROUP', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('2.5.1', 'bburke@redhat.com', 'META-INF/jpa-changelog-2.5.1.xml', '2024-05-15 12:53:11.613153', 38, 'EXECUTED', '8:27180251182e6c31846c2ddab4bc5781', 'addColumn tableName=FED_USER_CONSENT', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('3.0.0', 'bburke@redhat.com', 'META-INF/jpa-changelog-3.0.0.xml', '2024-05-15 12:53:11.619616', 39, 'EXECUTED', '8:d56f201bfcfa7a1413eb3e9bc02978f9', 'addColumn tableName=IDENTITY_PROVIDER', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('3.2.0-fix', 'keycloak', 'META-INF/jpa-changelog-3.2.0.xml', '2024-05-15 12:53:11.622779', 40, 'MARK_RAN', '8:91f5522bf6afdc2077dfab57fbd3455c', 'addNotNullConstraint columnName=REALM_ID, tableName=CLIENT_INITIAL_ACCESS', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('3.2.0-fix-with-keycloak-5416', 'keycloak', 'META-INF/jpa-changelog-3.2.0.xml', '2024-05-15 12:53:11.627708', 41, 'MARK_RAN', '8:0f01b554f256c22caeb7d8aee3a1cdc8', 'dropIndex indexName=IDX_CLIENT_INIT_ACC_REALM, tableName=CLIENT_INITIAL_ACCESS; addNotNullConstraint columnName=REALM_ID, tableName=CLIENT_INITIAL_ACCESS; createIndex indexName=IDX_CLIENT_INIT_ACC_REALM, tableName=CLIENT_INITIAL_ACCESS', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('3.2.0-fix-offline-sessions', 'hmlnarik', 'META-INF/jpa-changelog-3.2.0.xml', '2024-05-15 12:53:11.63719', 42, 'EXECUTED', '8:ab91cf9cee415867ade0e2df9651a947', 'customChange', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('3.2.0-fixed', 'keycloak', 'META-INF/jpa-changelog-3.2.0.xml', '2024-05-15 12:53:11.977569', 43, 'EXECUTED', '8:ceac9b1889e97d602caf373eadb0d4b7', 'addColumn tableName=REALM; dropPrimaryKey constraintName=CONSTRAINT_OFFL_CL_SES_PK2, tableName=OFFLINE_CLIENT_SESSION; dropColumn columnName=CLIENT_SESSION_ID, tableName=OFFLINE_CLIENT_SESSION; addPrimaryKey constraintName=CONSTRAINT_OFFL_CL_SES_P...', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('3.3.0', 'keycloak', 'META-INF/jpa-changelog-3.3.0.xml', '2024-05-15 12:53:11.983831', 44, 'EXECUTED', '8:84b986e628fe8f7fd8fd3c275c5259f2', 'addColumn tableName=USER_ENTITY', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('authz-3.4.0.CR1-resource-server-pk-change-part1', 'glavoie@gmail.com', 'META-INF/jpa-changelog-authz-3.4.0.CR1.xml', '2024-05-15 12:53:11.990617', 45, 'EXECUTED', '8:a164ae073c56ffdbc98a615493609a52', 'addColumn tableName=RESOURCE_SERVER_POLICY; addColumn tableName=RESOURCE_SERVER_RESOURCE; addColumn tableName=RESOURCE_SERVER_SCOPE', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('authz-3.4.0.CR1-resource-server-pk-change-part2-KEYCLOAK-6095', 'hmlnarik@redhat.com', 'META-INF/jpa-changelog-authz-3.4.0.CR1.xml', '2024-05-15 12:53:11.998897', 46, 'EXECUTED', '8:70a2b4f1f4bd4dbf487114bdb1810e64', 'customChange', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('authz-3.4.0.CR1-resource-server-pk-change-part3-fixed', 'glavoie@gmail.com', 'META-INF/jpa-changelog-authz-3.4.0.CR1.xml', '2024-05-15 12:53:12.001957', 47, 'MARK_RAN', '8:7be68b71d2f5b94b8df2e824f2860fa2', 'dropIndex indexName=IDX_RES_SERV_POL_RES_SERV, tableName=RESOURCE_SERVER_POLICY; dropIndex indexName=IDX_RES_SRV_RES_RES_SRV, tableName=RESOURCE_SERVER_RESOURCE; dropIndex indexName=IDX_RES_SRV_SCOPE_RES_SRV, tableName=RESOURCE_SERVER_SCOPE', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('authz-3.4.0.CR1-resource-server-pk-change-part3-fixed-nodropindex', 'glavoie@gmail.com', 'META-INF/jpa-changelog-authz-3.4.0.CR1.xml', '2024-05-15 12:53:12.091543', 48, 'EXECUTED', '8:bab7c631093c3861d6cf6144cd944982', 'addNotNullConstraint columnName=RESOURCE_SERVER_CLIENT_ID, tableName=RESOURCE_SERVER_POLICY; addNotNullConstraint columnName=RESOURCE_SERVER_CLIENT_ID, tableName=RESOURCE_SERVER_RESOURCE; addNotNullConstraint columnName=RESOURCE_SERVER_CLIENT_ID, ...', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('authn-3.4.0.CR1-refresh-token-max-reuse', 'glavoie@gmail.com', 'META-INF/jpa-changelog-authz-3.4.0.CR1.xml', '2024-05-15 12:53:12.099833', 49, 'EXECUTED', '8:fa809ac11877d74d76fe40869916daad', 'addColumn tableName=REALM', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('3.4.0', 'keycloak', 'META-INF/jpa-changelog-3.4.0.xml', '2024-05-15 12:53:12.216462', 50, 'EXECUTED', '8:fac23540a40208f5f5e326f6ceb4d291', 'addPrimaryKey constraintName=CONSTRAINT_REALM_DEFAULT_ROLES, tableName=REALM_DEFAULT_ROLES; addPrimaryKey constraintName=CONSTRAINT_COMPOSITE_ROLE, tableName=COMPOSITE_ROLE; addPrimaryKey constraintName=CONSTR_REALM_DEFAULT_GROUPS, tableName=REALM...', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('3.4.0-KEYCLOAK-5230', 'hmlnarik@redhat.com', 'META-INF/jpa-changelog-3.4.0.xml', '2024-05-15 12:53:12.312807', 51, 'EXECUTED', '8:2612d1b8a97e2b5588c346e817307593', 'createIndex indexName=IDX_FU_ATTRIBUTE, tableName=FED_USER_ATTRIBUTE; createIndex indexName=IDX_FU_CONSENT, tableName=FED_USER_CONSENT; createIndex indexName=IDX_FU_CONSENT_RU, tableName=FED_USER_CONSENT; createIndex indexName=IDX_FU_CREDENTIAL, t...', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('3.4.1', 'psilva@redhat.com', 'META-INF/jpa-changelog-3.4.1.xml', '2024-05-15 12:53:12.320021', 52, 'EXECUTED', '8:9842f155c5db2206c88bcb5d1046e941', 'modifyDataType columnName=VALUE, tableName=CLIENT_ATTRIBUTES', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('3.4.2', 'keycloak', 'META-INF/jpa-changelog-3.4.2.xml', '2024-05-15 12:53:12.326012', 53, 'EXECUTED', '8:2e12e06e45498406db72d5b3da5bbc76', 'update tableName=REALM', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('3.4.2-KEYCLOAK-5172', 'mkanis@redhat.com', 'META-INF/jpa-changelog-3.4.2.xml', '2024-05-15 12:53:12.333128', 54, 'EXECUTED', '8:33560e7c7989250c40da3abdabdc75a4', 'update tableName=CLIENT', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('4.0.0-KEYCLOAK-6335', 'bburke@redhat.com', 'META-INF/jpa-changelog-4.0.0.xml', '2024-05-15 12:53:12.348647', 55, 'EXECUTED', '8:87a8d8542046817a9107c7eb9cbad1cd', 'createTable tableName=CLIENT_AUTH_FLOW_BINDINGS; addPrimaryKey constraintName=C_CLI_FLOW_BIND, tableName=CLIENT_AUTH_FLOW_BINDINGS', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('4.0.0-CLEANUP-UNUSED-TABLE', 'bburke@redhat.com', 'META-INF/jpa-changelog-4.0.0.xml', '2024-05-15 12:53:12.362687', 56, 'EXECUTED', '8:3ea08490a70215ed0088c273d776311e', 'dropTable tableName=CLIENT_IDENTITY_PROV_MAPPING', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('4.0.0-KEYCLOAK-6228', 'bburke@redhat.com', 'META-INF/jpa-changelog-4.0.0.xml', '2024-05-15 12:53:12.410417', 57, 'EXECUTED', '8:2d56697c8723d4592ab608ce14b6ed68', 'dropUniqueConstraint constraintName=UK_JKUWUVD56ONTGSUHOGM8UEWRT, tableName=USER_CONSENT; dropNotNullConstraint columnName=CLIENT_ID, tableName=USER_CONSENT; addColumn tableName=USER_CONSENT; addUniqueConstraint constraintName=UK_JKUWUVD56ONTGSUHO...', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('4.0.0-KEYCLOAK-5579-fixed', 'mposolda@redhat.com', 'META-INF/jpa-changelog-4.0.0.xml', '2024-05-15 12:53:12.650251', 58, 'EXECUTED', '8:3e423e249f6068ea2bbe48bf907f9d86', 'dropForeignKeyConstraint baseTableName=CLIENT_TEMPLATE_ATTRIBUTES, constraintName=FK_CL_TEMPL_ATTR_TEMPL; renameTable newTableName=CLIENT_SCOPE_ATTRIBUTES, oldTableName=CLIENT_TEMPLATE_ATTRIBUTES; renameColumn newColumnName=SCOPE_ID, oldColumnName...', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('authz-4.0.0.CR1', 'psilva@redhat.com', 'META-INF/jpa-changelog-authz-4.0.0.CR1.xml', '2024-05-15 12:53:12.719879', 59, 'EXECUTED', '8:15cabee5e5df0ff099510a0fc03e4103', 'createTable tableName=RESOURCE_SERVER_PERM_TICKET; addPrimaryKey constraintName=CONSTRAINT_FAPMT, tableName=RESOURCE_SERVER_PERM_TICKET; addForeignKeyConstraint baseTableName=RESOURCE_SERVER_PERM_TICKET, constraintName=FK_FRSRHO213XCX4WNKOG82SSPMT...', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('authz-4.0.0.Beta3', 'psilva@redhat.com', 'META-INF/jpa-changelog-authz-4.0.0.Beta3.xml', '2024-05-15 12:53:12.735256', 60, 'EXECUTED', '8:4b80200af916ac54d2ffbfc47918ab0e', 'addColumn tableName=RESOURCE_SERVER_POLICY; addColumn tableName=RESOURCE_SERVER_PERM_TICKET; addForeignKeyConstraint baseTableName=RESOURCE_SERVER_PERM_TICKET, constraintName=FK_FRSRPO2128CX4WNKOG82SSRFY, referencedTableName=RESOURCE_SERVER_POLICY', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('authz-4.2.0.Final', 'mhajas@redhat.com', 'META-INF/jpa-changelog-authz-4.2.0.Final.xml', '2024-05-15 12:53:12.755615', 61, 'EXECUTED', '8:66564cd5e168045d52252c5027485bbb', 'createTable tableName=RESOURCE_URIS; addForeignKeyConstraint baseTableName=RESOURCE_URIS, constraintName=FK_RESOURCE_SERVER_URIS, referencedTableName=RESOURCE_SERVER_RESOURCE; customChange; dropColumn columnName=URI, tableName=RESOURCE_SERVER_RESO...', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('authz-4.2.0.Final-KEYCLOAK-9944', 'hmlnarik@redhat.com', 'META-INF/jpa-changelog-authz-4.2.0.Final.xml', '2024-05-15 12:53:12.768476', 62, 'EXECUTED', '8:1c7064fafb030222be2bd16ccf690f6f', 'addPrimaryKey constraintName=CONSTRAINT_RESOUR_URIS_PK, tableName=RESOURCE_URIS', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('4.2.0-KEYCLOAK-6313', 'wadahiro@gmail.com', 'META-INF/jpa-changelog-4.2.0.xml', '2024-05-15 12:53:12.776312', 63, 'EXECUTED', '8:2de18a0dce10cdda5c7e65c9b719b6e5', 'addColumn tableName=REQUIRED_ACTION_PROVIDER', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('4.3.0-KEYCLOAK-7984', 'wadahiro@gmail.com', 'META-INF/jpa-changelog-4.3.0.xml', '2024-05-15 12:53:12.784781', 64, 'EXECUTED', '8:03e413dd182dcbd5c57e41c34d0ef682', 'update tableName=REQUIRED_ACTION_PROVIDER', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('4.6.0-KEYCLOAK-7950', 'psilva@redhat.com', 'META-INF/jpa-changelog-4.6.0.xml', '2024-05-15 12:53:12.791674', 65, 'EXECUTED', '8:d27b42bb2571c18fbe3fe4e4fb7582a7', 'update tableName=RESOURCE_SERVER_RESOURCE', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('4.6.0-KEYCLOAK-8377', 'keycloak', 'META-INF/jpa-changelog-4.6.0.xml', '2024-05-15 12:53:12.845271', 66, 'EXECUTED', '8:698baf84d9fd0027e9192717c2154fb8', 'createTable tableName=ROLE_ATTRIBUTE; addPrimaryKey constraintName=CONSTRAINT_ROLE_ATTRIBUTE_PK, tableName=ROLE_ATTRIBUTE; addForeignKeyConstraint baseTableName=ROLE_ATTRIBUTE, constraintName=FK_ROLE_ATTRIBUTE_ID, referencedTableName=KEYCLOAK_ROLE...', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('4.6.0-KEYCLOAK-8555', 'gideonray@gmail.com', 'META-INF/jpa-changelog-4.6.0.xml', '2024-05-15 12:53:12.859339', 67, 'EXECUTED', '8:ced8822edf0f75ef26eb51582f9a821a', 'createIndex indexName=IDX_COMPONENT_PROVIDER_TYPE, tableName=COMPONENT', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('4.7.0-KEYCLOAK-1267', 'sguilhen@redhat.com', 'META-INF/jpa-changelog-4.7.0.xml', '2024-05-15 12:53:12.867511', 68, 'EXECUTED', '8:f0abba004cf429e8afc43056df06487d', 'addColumn tableName=REALM', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('4.7.0-KEYCLOAK-7275', 'keycloak', 'META-INF/jpa-changelog-4.7.0.xml', '2024-05-15 12:53:12.888579', 69, 'EXECUTED', '8:6662f8b0b611caa359fcf13bf63b4e24', 'renameColumn newColumnName=CREATED_ON, oldColumnName=LAST_SESSION_REFRESH, tableName=OFFLINE_USER_SESSION; addNotNullConstraint columnName=CREATED_ON, tableName=OFFLINE_USER_SESSION; addColumn tableName=OFFLINE_USER_SESSION; customChange; createIn...', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('4.8.0-KEYCLOAK-8835', 'sguilhen@redhat.com', 'META-INF/jpa-changelog-4.8.0.xml', '2024-05-15 12:53:12.899701', 70, 'EXECUTED', '8:9e6b8009560f684250bdbdf97670d39e', 'addNotNullConstraint columnName=SSO_MAX_LIFESPAN_REMEMBER_ME, tableName=REALM; addNotNullConstraint columnName=SSO_IDLE_TIMEOUT_REMEMBER_ME, tableName=REALM', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('authz-7.0.0-KEYCLOAK-10443', 'psilva@redhat.com', 'META-INF/jpa-changelog-authz-7.0.0.xml', '2024-05-15 12:53:12.907249', 71, 'EXECUTED', '8:4223f561f3b8dc655846562b57bb502e', 'addColumn tableName=RESOURCE_SERVER', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('8.0.0-adding-credential-columns', 'keycloak', 'META-INF/jpa-changelog-8.0.0.xml', '2024-05-15 12:53:12.918915', 72, 'EXECUTED', '8:215a31c398b363ce383a2b301202f29e', 'addColumn tableName=CREDENTIAL; addColumn tableName=FED_USER_CREDENTIAL', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('8.0.0-updating-credential-data-not-oracle-fixed', 'keycloak', 'META-INF/jpa-changelog-8.0.0.xml', '2024-05-15 12:53:12.931894', 73, 'EXECUTED', '8:83f7a671792ca98b3cbd3a1a34862d3d', 'update tableName=CREDENTIAL; update tableName=CREDENTIAL; update tableName=CREDENTIAL; update tableName=FED_USER_CREDENTIAL; update tableName=FED_USER_CREDENTIAL; update tableName=FED_USER_CREDENTIAL', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('8.0.0-updating-credential-data-oracle-fixed', 'keycloak', 'META-INF/jpa-changelog-8.0.0.xml', '2024-05-15 12:53:12.934706', 74, 'MARK_RAN', '8:f58ad148698cf30707a6efbdf8061aa7', 'update tableName=CREDENTIAL; update tableName=CREDENTIAL; update tableName=CREDENTIAL; update tableName=FED_USER_CREDENTIAL; update tableName=FED_USER_CREDENTIAL; update tableName=FED_USER_CREDENTIAL', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('8.0.0-credential-cleanup-fixed', 'keycloak', 'META-INF/jpa-changelog-8.0.0.xml', '2024-05-15 12:53:12.973301', 75, 'EXECUTED', '8:79e4fd6c6442980e58d52ffc3ee7b19c', 'dropDefaultValue columnName=COUNTER, tableName=CREDENTIAL; dropDefaultValue columnName=DIGITS, tableName=CREDENTIAL; dropDefaultValue columnName=PERIOD, tableName=CREDENTIAL; dropDefaultValue columnName=ALGORITHM, tableName=CREDENTIAL; dropColumn ...', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('8.0.0-resource-tag-support', 'keycloak', 'META-INF/jpa-changelog-8.0.0.xml', '2024-05-15 12:53:12.985434', 76, 'EXECUTED', '8:87af6a1e6d241ca4b15801d1f86a297d', 'addColumn tableName=MIGRATION_MODEL; createIndex indexName=IDX_UPDATE_TIME, tableName=MIGRATION_MODEL', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('9.0.0-always-display-client', 'keycloak', 'META-INF/jpa-changelog-9.0.0.xml', '2024-05-15 12:53:12.992362', 77, 'EXECUTED', '8:b44f8d9b7b6ea455305a6d72a200ed15', 'addColumn tableName=CLIENT', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('9.0.0-drop-constraints-for-column-increase', 'keycloak', 'META-INF/jpa-changelog-9.0.0.xml', '2024-05-15 12:53:12.995272', 78, 'MARK_RAN', '8:2d8ed5aaaeffd0cb004c046b4a903ac5', 'dropUniqueConstraint constraintName=UK_FRSR6T700S9V50BU18WS5PMT, tableName=RESOURCE_SERVER_PERM_TICKET; dropUniqueConstraint constraintName=UK_FRSR6T700S9V50BU18WS5HA6, tableName=RESOURCE_SERVER_RESOURCE; dropPrimaryKey constraintName=CONSTRAINT_O...', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('9.0.0-increase-column-size-federated-fk', 'keycloak', 'META-INF/jpa-changelog-9.0.0.xml', '2024-05-15 12:53:13.044067', 79, 'EXECUTED', '8:e290c01fcbc275326c511633f6e2acde', 'modifyDataType columnName=CLIENT_ID, tableName=FED_USER_CONSENT; modifyDataType columnName=CLIENT_REALM_CONSTRAINT, tableName=KEYCLOAK_ROLE; modifyDataType columnName=OWNER, tableName=RESOURCE_SERVER_POLICY; modifyDataType columnName=CLIENT_ID, ta...', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('9.0.0-recreate-constraints-after-column-increase', 'keycloak', 'META-INF/jpa-changelog-9.0.0.xml', '2024-05-15 12:53:13.047642', 80, 'MARK_RAN', '8:c9db8784c33cea210872ac2d805439f8', 'addNotNullConstraint columnName=CLIENT_ID, tableName=OFFLINE_CLIENT_SESSION; addNotNullConstraint columnName=OWNER, tableName=RESOURCE_SERVER_PERM_TICKET; addNotNullConstraint columnName=REQUESTER, tableName=RESOURCE_SERVER_PERM_TICKET; addNotNull...', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('9.0.1-add-index-to-client.client_id', 'keycloak', 'META-INF/jpa-changelog-9.0.1.xml', '2024-05-15 12:53:13.060423', 81, 'EXECUTED', '8:95b676ce8fc546a1fcfb4c92fae4add5', 'createIndex indexName=IDX_CLIENT_ID, tableName=CLIENT', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('9.0.1-KEYCLOAK-12579-drop-constraints', 'keycloak', 'META-INF/jpa-changelog-9.0.1.xml', '2024-05-15 12:53:13.063867', 82, 'MARK_RAN', '8:38a6b2a41f5651018b1aca93a41401e5', 'dropUniqueConstraint constraintName=SIBLING_NAMES, tableName=KEYCLOAK_GROUP', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('9.0.1-KEYCLOAK-12579-add-not-null-constraint', 'keycloak', 'META-INF/jpa-changelog-9.0.1.xml', '2024-05-15 12:53:13.075193', 83, 'EXECUTED', '8:3fb99bcad86a0229783123ac52f7609c', 'addNotNullConstraint columnName=PARENT_GROUP, tableName=KEYCLOAK_GROUP', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('9.0.1-KEYCLOAK-12579-recreate-constraints', 'keycloak', 'META-INF/jpa-changelog-9.0.1.xml', '2024-05-15 12:53:13.07886', 84, 'MARK_RAN', '8:64f27a6fdcad57f6f9153210f2ec1bdb', 'addUniqueConstraint constraintName=SIBLING_NAMES, tableName=KEYCLOAK_GROUP', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('9.0.1-add-index-to-events', 'keycloak', 'META-INF/jpa-changelog-9.0.1.xml', '2024-05-15 12:53:13.091589', 85, 'EXECUTED', '8:ab4f863f39adafd4c862f7ec01890abc', 'createIndex indexName=IDX_EVENT_TIME, tableName=EVENT_ENTITY', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('map-remove-ri', 'keycloak', 'META-INF/jpa-changelog-11.0.0.xml', '2024-05-15 12:53:13.100317', 86, 'EXECUTED', '8:13c419a0eb336e91ee3a3bf8fda6e2a7', 'dropForeignKeyConstraint baseTableName=REALM, constraintName=FK_TRAF444KK6QRKMS7N56AIWQ5Y; dropForeignKeyConstraint baseTableName=KEYCLOAK_ROLE, constraintName=FK_KJHO5LE2C0RAL09FL8CM9WFW9', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('map-remove-ri', 'keycloak', 'META-INF/jpa-changelog-12.0.0.xml', '2024-05-15 12:53:13.109528', 87, 'EXECUTED', '8:e3fb1e698e0471487f51af1ed80fe3ac', 'dropForeignKeyConstraint baseTableName=REALM_DEFAULT_GROUPS, constraintName=FK_DEF_GROUPS_GROUP; dropForeignKeyConstraint baseTableName=REALM_DEFAULT_ROLES, constraintName=FK_H4WPD7W4HSOOLNI3H0SW7BTJE; dropForeignKeyConstraint baseTableName=CLIENT...', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('12.1.0-add-realm-localization-table', 'keycloak', 'META-INF/jpa-changelog-12.0.0.xml', '2024-05-15 12:53:13.132064', 88, 'EXECUTED', '8:babadb686aab7b56562817e60bf0abd0', 'createTable tableName=REALM_LOCALIZATIONS; addPrimaryKey tableName=REALM_LOCALIZATIONS', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('default-roles', 'keycloak', 'META-INF/jpa-changelog-13.0.0.xml', '2024-05-15 12:53:13.143981', 89, 'EXECUTED', '8:72d03345fda8e2f17093d08801947773', 'addColumn tableName=REALM; customChange', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('default-roles-cleanup', 'keycloak', 'META-INF/jpa-changelog-13.0.0.xml', '2024-05-15 12:53:13.164432', 90, 'EXECUTED', '8:61c9233951bd96ffecd9ba75f7d978a4', 'dropTable tableName=REALM_DEFAULT_ROLES; dropTable tableName=CLIENT_DEFAULT_ROLES', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('13.0.0-KEYCLOAK-16844', 'keycloak', 'META-INF/jpa-changelog-13.0.0.xml', '2024-05-15 12:53:13.174397', 91, 'EXECUTED', '8:ea82e6ad945cec250af6372767b25525', 'createIndex indexName=IDX_OFFLINE_USS_PRELOAD, tableName=OFFLINE_USER_SESSION', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('map-remove-ri-13.0.0', 'keycloak', 'META-INF/jpa-changelog-13.0.0.xml', '2024-05-15 12:53:13.183298', 92, 'EXECUTED', '8:d3f4a33f41d960ddacd7e2ef30d126b3', 'dropForeignKeyConstraint baseTableName=DEFAULT_CLIENT_SCOPE, constraintName=FK_R_DEF_CLI_SCOPE_SCOPE; dropForeignKeyConstraint baseTableName=CLIENT_SCOPE_CLIENT, constraintName=FK_C_CLI_SCOPE_SCOPE; dropForeignKeyConstraint baseTableName=CLIENT_SC...', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('13.0.0-KEYCLOAK-17992-drop-constraints', 'keycloak', 'META-INF/jpa-changelog-13.0.0.xml', '2024-05-15 12:53:13.185822', 93, 'MARK_RAN', '8:1284a27fbd049d65831cb6fc07c8a783', 'dropPrimaryKey constraintName=C_CLI_SCOPE_BIND, tableName=CLIENT_SCOPE_CLIENT; dropIndex indexName=IDX_CLSCOPE_CL, tableName=CLIENT_SCOPE_CLIENT; dropIndex indexName=IDX_CL_CLSCOPE, tableName=CLIENT_SCOPE_CLIENT', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('13.0.0-increase-column-size-federated', 'keycloak', 'META-INF/jpa-changelog-13.0.0.xml', '2024-05-15 12:53:13.201722', 94, 'EXECUTED', '8:9d11b619db2ae27c25853b8a37cd0dea', 'modifyDataType columnName=CLIENT_ID, tableName=CLIENT_SCOPE_CLIENT; modifyDataType columnName=SCOPE_ID, tableName=CLIENT_SCOPE_CLIENT', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('13.0.0-KEYCLOAK-17992-recreate-constraints', 'keycloak', 'META-INF/jpa-changelog-13.0.0.xml', '2024-05-15 12:53:13.20455', 95, 'MARK_RAN', '8:3002bb3997451bb9e8bac5c5cd8d6327', 'addNotNullConstraint columnName=CLIENT_ID, tableName=CLIENT_SCOPE_CLIENT; addNotNullConstraint columnName=SCOPE_ID, tableName=CLIENT_SCOPE_CLIENT; addPrimaryKey constraintName=C_CLI_SCOPE_BIND, tableName=CLIENT_SCOPE_CLIENT; createIndex indexName=...', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('json-string-accomodation-fixed', 'keycloak', 'META-INF/jpa-changelog-13.0.0.xml', '2024-05-15 12:53:13.214138', 96, 'EXECUTED', '8:dfbee0d6237a23ef4ccbb7a4e063c163', 'addColumn tableName=REALM_ATTRIBUTE; update tableName=REALM_ATTRIBUTE; dropColumn columnName=VALUE, tableName=REALM_ATTRIBUTE; renameColumn newColumnName=VALUE, oldColumnName=VALUE_NEW, tableName=REALM_ATTRIBUTE', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('14.0.0-KEYCLOAK-11019', 'keycloak', 'META-INF/jpa-changelog-14.0.0.xml', '2024-05-15 12:53:13.237439', 97, 'EXECUTED', '8:75f3e372df18d38c62734eebb986b960', 'createIndex indexName=IDX_OFFLINE_CSS_PRELOAD, tableName=OFFLINE_CLIENT_SESSION; createIndex indexName=IDX_OFFLINE_USS_BY_USER, tableName=OFFLINE_USER_SESSION; createIndex indexName=IDX_OFFLINE_USS_BY_USERSESS, tableName=OFFLINE_USER_SESSION', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('14.0.0-KEYCLOAK-18286', 'keycloak', 'META-INF/jpa-changelog-14.0.0.xml', '2024-05-15 12:53:13.241716', 98, 'MARK_RAN', '8:7fee73eddf84a6035691512c85637eef', 'createIndex indexName=IDX_CLIENT_ATT_BY_NAME_VALUE, tableName=CLIENT_ATTRIBUTES', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('14.0.0-KEYCLOAK-18286-revert', 'keycloak', 'META-INF/jpa-changelog-14.0.0.xml', '2024-05-15 12:53:13.264494', 99, 'MARK_RAN', '8:7a11134ab12820f999fbf3bb13c3adc8', 'dropIndex indexName=IDX_CLIENT_ATT_BY_NAME_VALUE, tableName=CLIENT_ATTRIBUTES', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('14.0.0-KEYCLOAK-18286-supported-dbs', 'keycloak', 'META-INF/jpa-changelog-14.0.0.xml', '2024-05-15 12:53:13.276957', 100, 'EXECUTED', '8:c0f6eaac1f3be773ffe54cb5b8482b70', 'createIndex indexName=IDX_CLIENT_ATT_BY_NAME_VALUE, tableName=CLIENT_ATTRIBUTES', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('14.0.0-KEYCLOAK-18286-unsupported-dbs', 'keycloak', 'META-INF/jpa-changelog-14.0.0.xml', '2024-05-15 12:53:13.280073', 101, 'MARK_RAN', '8:18186f0008b86e0f0f49b0c4d0e842ac', 'createIndex indexName=IDX_CLIENT_ATT_BY_NAME_VALUE, tableName=CLIENT_ATTRIBUTES', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('KEYCLOAK-17267-add-index-to-user-attributes', 'keycloak', 'META-INF/jpa-changelog-14.0.0.xml', '2024-05-15 12:53:13.293153', 102, 'EXECUTED', '8:09c2780bcb23b310a7019d217dc7b433', 'createIndex indexName=IDX_USER_ATTRIBUTE_NAME, tableName=USER_ATTRIBUTE', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('KEYCLOAK-18146-add-saml-art-binding-identifier', 'keycloak', 'META-INF/jpa-changelog-14.0.0.xml', '2024-05-15 12:53:13.30238', 103, 'EXECUTED', '8:276a44955eab693c970a42880197fff2', 'customChange', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('15.0.0-KEYCLOAK-18467', 'keycloak', 'META-INF/jpa-changelog-15.0.0.xml', '2024-05-15 12:53:13.312207', 104, 'EXECUTED', '8:ba8ee3b694d043f2bfc1a1079d0760d7', 'addColumn tableName=REALM_LOCALIZATIONS; update tableName=REALM_LOCALIZATIONS; dropColumn columnName=TEXTS, tableName=REALM_LOCALIZATIONS; renameColumn newColumnName=TEXTS, oldColumnName=TEXTS_NEW, tableName=REALM_LOCALIZATIONS; addNotNullConstrai...', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('17.0.0-9562', 'keycloak', 'META-INF/jpa-changelog-17.0.0.xml', '2024-05-15 12:53:13.322636', 105, 'EXECUTED', '8:5e06b1d75f5d17685485e610c2851b17', 'createIndex indexName=IDX_USER_SERVICE_ACCOUNT, tableName=USER_ENTITY', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('18.0.0-10625-IDX_ADMIN_EVENT_TIME', 'keycloak', 'META-INF/jpa-changelog-18.0.0.xml', '2024-05-15 12:53:13.333137', 106, 'EXECUTED', '8:4b80546c1dc550ac552ee7b24a4ab7c0', 'createIndex indexName=IDX_ADMIN_EVENT_TIME, tableName=ADMIN_EVENT_ENTITY', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('19.0.0-10135', 'keycloak', 'META-INF/jpa-changelog-19.0.0.xml', '2024-05-15 12:53:13.342272', 107, 'EXECUTED', '8:af510cd1bb2ab6339c45372f3e491696', 'customChange', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('20.0.0-12964-supported-dbs', 'keycloak', 'META-INF/jpa-changelog-20.0.0.xml', '2024-05-15 12:53:13.352961', 108, 'EXECUTED', '8:05c99fc610845ef66ee812b7921af0ef', 'createIndex indexName=IDX_GROUP_ATT_BY_NAME_VALUE, tableName=GROUP_ATTRIBUTE', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('20.0.0-12964-unsupported-dbs', 'keycloak', 'META-INF/jpa-changelog-20.0.0.xml', '2024-05-15 12:53:13.356594', 109, 'MARK_RAN', '8:314e803baf2f1ec315b3464e398b8247', 'createIndex indexName=IDX_GROUP_ATT_BY_NAME_VALUE, tableName=GROUP_ATTRIBUTE', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('client-attributes-string-accomodation-fixed', 'keycloak', 'META-INF/jpa-changelog-20.0.0.xml', '2024-05-15 12:53:13.371585', 110, 'EXECUTED', '8:56e4677e7e12556f70b604c573840100', 'addColumn tableName=CLIENT_ATTRIBUTES; update tableName=CLIENT_ATTRIBUTES; dropColumn columnName=VALUE, tableName=CLIENT_ATTRIBUTES; renameColumn newColumnName=VALUE, oldColumnName=VALUE_NEW, tableName=CLIENT_ATTRIBUTES', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('21.0.2-17277', 'keycloak', 'META-INF/jpa-changelog-21.0.2.xml', '2024-05-15 12:53:13.378301', 111, 'EXECUTED', '8:8806cb33d2a546ce770384bf98cf6eac', 'customChange', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('21.1.0-19404', 'keycloak', 'META-INF/jpa-changelog-21.1.0.xml', '2024-05-15 12:53:13.482003', 112, 'EXECUTED', '8:fdb2924649d30555ab3a1744faba4928', 'modifyDataType columnName=DECISION_STRATEGY, tableName=RESOURCE_SERVER_POLICY; modifyDataType columnName=LOGIC, tableName=RESOURCE_SERVER_POLICY; modifyDataType columnName=POLICY_ENFORCE_MODE, tableName=RESOURCE_SERVER', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('21.1.0-19404-2', 'keycloak', 'META-INF/jpa-changelog-21.1.0.xml', '2024-05-15 12:53:13.484836', 113, 'MARK_RAN', '8:1c96cc2b10903bd07a03670098d67fd6', 'addColumn tableName=RESOURCE_SERVER_POLICY; update tableName=RESOURCE_SERVER_POLICY; dropColumn columnName=DECISION_STRATEGY, tableName=RESOURCE_SERVER_POLICY; renameColumn newColumnName=DECISION_STRATEGY, oldColumnName=DECISION_STRATEGY_NEW, tabl...', '', NULL, '4.20.0', NULL, NULL, '5777589383');
INSERT INTO "public"."databasechangelog" VALUES ('22.0.0-17484', 'keycloak', 'META-INF/jpa-changelog-22.0.0.xml', '2024-05-15 12:53:13.496261', 114, 'EXECUTED', '8:4c3d4e8b142a66fcdf21b89a4dd33301', 'customChange', '', NULL, '4.20.0', NULL, NULL, '5777589383');

-- ----------------------------
-- Table structure for databasechangeloglock
-- ----------------------------
DROP TABLE IF EXISTS "public"."databasechangeloglock";
CREATE TABLE "public"."databasechangeloglock" (
  "id" int4 NOT NULL,
  "locked" bool NOT NULL,
  "lockgranted" timestamp(6),
  "lockedby" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of databasechangeloglock
-- ----------------------------
INSERT INTO "public"."databasechangeloglock" VALUES (1, 'f', NULL, NULL);
INSERT INTO "public"."databasechangeloglock" VALUES (1000, 'f', NULL, NULL);
INSERT INTO "public"."databasechangeloglock" VALUES (1001, 'f', NULL, NULL);

-- ----------------------------
-- Table structure for default_client_scope
-- ----------------------------
DROP TABLE IF EXISTS "public"."default_client_scope";
CREATE TABLE "public"."default_client_scope" (
  "realm_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "scope_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "default_scope" bool NOT NULL DEFAULT false
)
;

-- ----------------------------
-- Records of default_client_scope
-- ----------------------------
INSERT INTO "public"."default_client_scope" VALUES ('2615b5da-5c3b-432f-af31-9af5f519b2a6', '0cf0a34b-0346-4291-8d89-683378a7e2e2', 'f');
INSERT INTO "public"."default_client_scope" VALUES ('2615b5da-5c3b-432f-af31-9af5f519b2a6', 'b0ad2b84-c7f5-461d-955c-e84ed0c1c831', 't');
INSERT INTO "public"."default_client_scope" VALUES ('2615b5da-5c3b-432f-af31-9af5f519b2a6', '9dcfe6e4-49ab-4793-bb46-924dcf6055f5', 't');
INSERT INTO "public"."default_client_scope" VALUES ('2615b5da-5c3b-432f-af31-9af5f519b2a6', '76386606-f8dd-43fe-8d3a-a2c961e381e4', 't');
INSERT INTO "public"."default_client_scope" VALUES ('2615b5da-5c3b-432f-af31-9af5f519b2a6', 'ee24b790-e82d-4cba-bda1-f1af7659a7e2', 'f');
INSERT INTO "public"."default_client_scope" VALUES ('2615b5da-5c3b-432f-af31-9af5f519b2a6', 'a4e06c75-dbbe-4fbd-bdf8-acb74a9e87d4', 'f');
INSERT INTO "public"."default_client_scope" VALUES ('2615b5da-5c3b-432f-af31-9af5f519b2a6', '7aac5fb5-c5c9-491f-8b99-087db6b8aa5c', 't');
INSERT INTO "public"."default_client_scope" VALUES ('2615b5da-5c3b-432f-af31-9af5f519b2a6', 'dadf7439-407d-4d35-b52c-cdc5e2fa6706', 't');
INSERT INTO "public"."default_client_scope" VALUES ('2615b5da-5c3b-432f-af31-9af5f519b2a6', 'f6907590-d9d0-4168-8bd3-5d4a26a978f9', 'f');
INSERT INTO "public"."default_client_scope" VALUES ('2615b5da-5c3b-432f-af31-9af5f519b2a6', '9f95fa1c-49ff-4a0b-bd45-7f5a966a3cf5', 't');
INSERT INTO "public"."default_client_scope" VALUES ('e668ca58-deb8-459c-9294-39e5e530c03f', '50056c1c-f13e-4dea-bc4b-59bb6eae4768', 'f');
INSERT INTO "public"."default_client_scope" VALUES ('e668ca58-deb8-459c-9294-39e5e530c03f', '22ba7bb8-08c9-4c77-bd8b-16cc912218f6', 't');
INSERT INTO "public"."default_client_scope" VALUES ('e668ca58-deb8-459c-9294-39e5e530c03f', '0d6d3683-d0d7-4ad9-b08d-3ed0545fe0d6', 't');
INSERT INTO "public"."default_client_scope" VALUES ('e668ca58-deb8-459c-9294-39e5e530c03f', 'fc4f4c5a-1168-4a67-9ca8-104a5ae91c78', 't');
INSERT INTO "public"."default_client_scope" VALUES ('e668ca58-deb8-459c-9294-39e5e530c03f', 'c3f54006-62f3-4978-b072-37769c2e4a89', 'f');
INSERT INTO "public"."default_client_scope" VALUES ('e668ca58-deb8-459c-9294-39e5e530c03f', '3b975094-4d95-4ee4-9fcb-2bd2514625c9', 'f');
INSERT INTO "public"."default_client_scope" VALUES ('e668ca58-deb8-459c-9294-39e5e530c03f', '072eb48c-17cb-4d3c-b809-1066d9c8c366', 't');
INSERT INTO "public"."default_client_scope" VALUES ('e668ca58-deb8-459c-9294-39e5e530c03f', '33e3b464-6d41-491c-8e63-e9fa4bbf7a77', 't');
INSERT INTO "public"."default_client_scope" VALUES ('e668ca58-deb8-459c-9294-39e5e530c03f', '1fa4bd1c-d250-44ea-89af-f4460cd13d7d', 'f');
INSERT INTO "public"."default_client_scope" VALUES ('e668ca58-deb8-459c-9294-39e5e530c03f', '9b50f631-7ede-4ed2-8ac2-bcd3f4014fe4', 't');

-- ----------------------------
-- Table structure for event_entity
-- ----------------------------
DROP TABLE IF EXISTS "public"."event_entity";
CREATE TABLE "public"."event_entity" (
  "id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "client_id" varchar(255) COLLATE "pg_catalog"."default",
  "details_json" varchar(2550) COLLATE "pg_catalog"."default",
  "error" varchar(255) COLLATE "pg_catalog"."default",
  "ip_address" varchar(255) COLLATE "pg_catalog"."default",
  "realm_id" varchar(255) COLLATE "pg_catalog"."default",
  "session_id" varchar(255) COLLATE "pg_catalog"."default",
  "event_time" int8,
  "type" varchar(255) COLLATE "pg_catalog"."default",
  "user_id" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of event_entity
-- ----------------------------

-- ----------------------------
-- Table structure for fed_user_attribute
-- ----------------------------
DROP TABLE IF EXISTS "public"."fed_user_attribute";
CREATE TABLE "public"."fed_user_attribute" (
  "id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "user_id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "realm_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "storage_provider_id" varchar(36) COLLATE "pg_catalog"."default",
  "value" varchar(2024) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of fed_user_attribute
-- ----------------------------

-- ----------------------------
-- Table structure for fed_user_consent
-- ----------------------------
DROP TABLE IF EXISTS "public"."fed_user_consent";
CREATE TABLE "public"."fed_user_consent" (
  "id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "client_id" varchar(255) COLLATE "pg_catalog"."default",
  "user_id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "realm_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "storage_provider_id" varchar(36) COLLATE "pg_catalog"."default",
  "created_date" int8,
  "last_updated_date" int8,
  "client_storage_provider" varchar(36) COLLATE "pg_catalog"."default",
  "external_client_id" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of fed_user_consent
-- ----------------------------

-- ----------------------------
-- Table structure for fed_user_consent_cl_scope
-- ----------------------------
DROP TABLE IF EXISTS "public"."fed_user_consent_cl_scope";
CREATE TABLE "public"."fed_user_consent_cl_scope" (
  "user_consent_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "scope_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of fed_user_consent_cl_scope
-- ----------------------------

-- ----------------------------
-- Table structure for fed_user_credential
-- ----------------------------
DROP TABLE IF EXISTS "public"."fed_user_credential";
CREATE TABLE "public"."fed_user_credential" (
  "id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "salt" bytea,
  "type" varchar(255) COLLATE "pg_catalog"."default",
  "created_date" int8,
  "user_id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "realm_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "storage_provider_id" varchar(36) COLLATE "pg_catalog"."default",
  "user_label" varchar(255) COLLATE "pg_catalog"."default",
  "secret_data" text COLLATE "pg_catalog"."default",
  "credential_data" text COLLATE "pg_catalog"."default",
  "priority" int4
)
;

-- ----------------------------
-- Records of fed_user_credential
-- ----------------------------

-- ----------------------------
-- Table structure for fed_user_group_membership
-- ----------------------------
DROP TABLE IF EXISTS "public"."fed_user_group_membership";
CREATE TABLE "public"."fed_user_group_membership" (
  "group_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "user_id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "realm_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "storage_provider_id" varchar(36) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of fed_user_group_membership
-- ----------------------------

-- ----------------------------
-- Table structure for fed_user_required_action
-- ----------------------------
DROP TABLE IF EXISTS "public"."fed_user_required_action";
CREATE TABLE "public"."fed_user_required_action" (
  "required_action" varchar(255) COLLATE "pg_catalog"."default" NOT NULL DEFAULT ' '::character varying,
  "user_id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "realm_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "storage_provider_id" varchar(36) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of fed_user_required_action
-- ----------------------------

-- ----------------------------
-- Table structure for fed_user_role_mapping
-- ----------------------------
DROP TABLE IF EXISTS "public"."fed_user_role_mapping";
CREATE TABLE "public"."fed_user_role_mapping" (
  "role_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "user_id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "realm_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "storage_provider_id" varchar(36) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of fed_user_role_mapping
-- ----------------------------

-- ----------------------------
-- Table structure for federated_identity
-- ----------------------------
DROP TABLE IF EXISTS "public"."federated_identity";
CREATE TABLE "public"."federated_identity" (
  "identity_provider" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "realm_id" varchar(36) COLLATE "pg_catalog"."default",
  "federated_user_id" varchar(255) COLLATE "pg_catalog"."default",
  "federated_username" varchar(255) COLLATE "pg_catalog"."default",
  "token" text COLLATE "pg_catalog"."default",
  "user_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of federated_identity
-- ----------------------------

-- ----------------------------
-- Table structure for federated_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."federated_user";
CREATE TABLE "public"."federated_user" (
  "id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "storage_provider_id" varchar(255) COLLATE "pg_catalog"."default",
  "realm_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of federated_user
-- ----------------------------

-- ----------------------------
-- Table structure for group_attribute
-- ----------------------------
DROP TABLE IF EXISTS "public"."group_attribute";
CREATE TABLE "public"."group_attribute" (
  "id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'sybase-needs-something-here'::character varying,
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "value" varchar(255) COLLATE "pg_catalog"."default",
  "group_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of group_attribute
-- ----------------------------

-- ----------------------------
-- Table structure for group_role_mapping
-- ----------------------------
DROP TABLE IF EXISTS "public"."group_role_mapping";
CREATE TABLE "public"."group_role_mapping" (
  "role_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "group_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of group_role_mapping
-- ----------------------------

-- ----------------------------
-- Table structure for identity_provider
-- ----------------------------
DROP TABLE IF EXISTS "public"."identity_provider";
CREATE TABLE "public"."identity_provider" (
  "internal_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "enabled" bool NOT NULL DEFAULT false,
  "provider_alias" varchar(255) COLLATE "pg_catalog"."default",
  "provider_id" varchar(255) COLLATE "pg_catalog"."default",
  "store_token" bool NOT NULL DEFAULT false,
  "authenticate_by_default" bool NOT NULL DEFAULT false,
  "realm_id" varchar(36) COLLATE "pg_catalog"."default",
  "add_token_role" bool NOT NULL DEFAULT true,
  "trust_email" bool NOT NULL DEFAULT false,
  "first_broker_login_flow_id" varchar(36) COLLATE "pg_catalog"."default",
  "post_broker_login_flow_id" varchar(36) COLLATE "pg_catalog"."default",
  "provider_display_name" varchar(255) COLLATE "pg_catalog"."default",
  "link_only" bool NOT NULL DEFAULT false
)
;

-- ----------------------------
-- Records of identity_provider
-- ----------------------------
INSERT INTO "public"."identity_provider" VALUES ('054ae052-c162-486a-b29b-6d4297088a9c', 't', 'google', 'google', 'f', 'f', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'f', 't', '1dd2567d-999c-4cde-9757-9edf83129f9a', NULL, NULL, 'f');
INSERT INTO "public"."identity_provider" VALUES ('583acf5e-efa5-490f-bf2a-96af3f7ed70a', 't', 'microsoft', 'microsoft', 'f', 'f', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'f', 'f', '7b1dff7d-c332-4e9f-8c5d-610fed8ffb8f', NULL, NULL, 'f');

-- ----------------------------
-- Table structure for identity_provider_config
-- ----------------------------
DROP TABLE IF EXISTS "public"."identity_provider_config";
CREATE TABLE "public"."identity_provider_config" (
  "identity_provider_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "value" text COLLATE "pg_catalog"."default",
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of identity_provider_config
-- ----------------------------
INSERT INTO "public"."identity_provider_config" VALUES ('054ae052-c162-486a-b29b-6d4297088a9c', 'false', 'hideOnLoginPage');
INSERT INTO "public"."identity_provider_config" VALUES ('054ae052-c162-486a-b29b-6d4297088a9c', 'false', 'acceptsPromptNoneForwardFromClient');
INSERT INTO "public"."identity_provider_config" VALUES ('054ae052-c162-486a-b29b-6d4297088a9c', '132336113026-k11rr8icghmocc6ve3e84rsvr3q5apum.apps.googleusercontent.com', 'clientId');
INSERT INTO "public"."identity_provider_config" VALUES ('054ae052-c162-486a-b29b-6d4297088a9c', 'false', 'disableUserInfo');
INSERT INTO "public"."identity_provider_config" VALUES ('054ae052-c162-486a-b29b-6d4297088a9c', 'false', 'filteredByClaim');
INSERT INTO "public"."identity_provider_config" VALUES ('054ae052-c162-486a-b29b-6d4297088a9c', 'IMPORT', 'syncMode');
INSERT INTO "public"."identity_provider_config" VALUES ('054ae052-c162-486a-b29b-6d4297088a9c', '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', 'clientSecret');
INSERT INTO "public"."identity_provider_config" VALUES ('583acf5e-efa5-490f-bf2a-96af3f7ed70a', 'qvV8Q~WQwoUwOhEx3pEZydsBE8nSgIGLMb5AQdjV', 'clientSecret');
INSERT INTO "public"."identity_provider_config" VALUES ('583acf5e-efa5-490f-bf2a-96af3f7ed70a', 'e5bc1d80-da68-470f-8fe5-732a71a3a23d', 'clientId');

-- ----------------------------
-- Table structure for identity_provider_mapper
-- ----------------------------
DROP TABLE IF EXISTS "public"."identity_provider_mapper";
CREATE TABLE "public"."identity_provider_mapper" (
  "id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "idp_alias" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "idp_mapper_name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "realm_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of identity_provider_mapper
-- ----------------------------

-- ----------------------------
-- Table structure for idp_mapper_config
-- ----------------------------
DROP TABLE IF EXISTS "public"."idp_mapper_config";
CREATE TABLE "public"."idp_mapper_config" (
  "idp_mapper_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "value" text COLLATE "pg_catalog"."default",
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of idp_mapper_config
-- ----------------------------

-- ----------------------------
-- Table structure for keycloak_group
-- ----------------------------
DROP TABLE IF EXISTS "public"."keycloak_group";
CREATE TABLE "public"."keycloak_group" (
  "id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "parent_group" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "realm_id" varchar(36) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of keycloak_group
-- ----------------------------

-- ----------------------------
-- Table structure for keycloak_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."keycloak_role";
CREATE TABLE "public"."keycloak_role" (
  "id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "client_realm_constraint" varchar(255) COLLATE "pg_catalog"."default",
  "client_role" bool NOT NULL DEFAULT false,
  "description" varchar(255) COLLATE "pg_catalog"."default",
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "realm_id" varchar(255) COLLATE "pg_catalog"."default",
  "client" varchar(36) COLLATE "pg_catalog"."default",
  "realm" varchar(36) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of keycloak_role
-- ----------------------------
INSERT INTO "public"."keycloak_role" VALUES ('963f1d10-817e-483b-a520-124cf561b457', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'f', '${role_default-roles}', 'default-roles-master', '2615b5da-5c3b-432f-af31-9af5f519b2a6', NULL, NULL);
INSERT INTO "public"."keycloak_role" VALUES ('4563d488-ae6e-4c47-982f-7a944dca3315', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'f', '${role_create-realm}', 'create-realm', '2615b5da-5c3b-432f-af31-9af5f519b2a6', NULL, NULL);
INSERT INTO "public"."keycloak_role" VALUES ('65fc0149-3019-478a-9f89-1070902d30ac', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'f', '${role_admin}', 'admin', '2615b5da-5c3b-432f-af31-9af5f519b2a6', NULL, NULL);
INSERT INTO "public"."keycloak_role" VALUES ('87bddd2e-a8c2-427c-9eee-2551c52b833a', '0f7b7c6e-b419-4d57-a05a-929313247c5b', 't', '${role_create-client}', 'create-client', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '0f7b7c6e-b419-4d57-a05a-929313247c5b', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('4063c93e-c013-407d-8988-b22226d30eab', '0f7b7c6e-b419-4d57-a05a-929313247c5b', 't', '${role_view-realm}', 'view-realm', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '0f7b7c6e-b419-4d57-a05a-929313247c5b', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('087aabfe-8d7c-4199-820c-dafa28d78ab4', '0f7b7c6e-b419-4d57-a05a-929313247c5b', 't', '${role_view-users}', 'view-users', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '0f7b7c6e-b419-4d57-a05a-929313247c5b', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('a703639a-dfad-49c2-a690-14646d0cc15f', '0f7b7c6e-b419-4d57-a05a-929313247c5b', 't', '${role_view-clients}', 'view-clients', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '0f7b7c6e-b419-4d57-a05a-929313247c5b', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('eb4b4f13-1f77-4906-a86d-761d553f7c75', '0f7b7c6e-b419-4d57-a05a-929313247c5b', 't', '${role_view-events}', 'view-events', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '0f7b7c6e-b419-4d57-a05a-929313247c5b', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('3a04f9a5-e48f-4951-a1e1-2d4ce4bedadc', '0f7b7c6e-b419-4d57-a05a-929313247c5b', 't', '${role_view-identity-providers}', 'view-identity-providers', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '0f7b7c6e-b419-4d57-a05a-929313247c5b', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('81675fb1-7db6-4c81-9d58-f67f8bea99ac', '0f7b7c6e-b419-4d57-a05a-929313247c5b', 't', '${role_view-authorization}', 'view-authorization', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '0f7b7c6e-b419-4d57-a05a-929313247c5b', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('96def430-199b-4ca5-bf94-cf17d2e1107a', '0f7b7c6e-b419-4d57-a05a-929313247c5b', 't', '${role_manage-realm}', 'manage-realm', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '0f7b7c6e-b419-4d57-a05a-929313247c5b', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('ff6c6662-281a-45ba-85c9-eee46b3daacf', '0f7b7c6e-b419-4d57-a05a-929313247c5b', 't', '${role_manage-users}', 'manage-users', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '0f7b7c6e-b419-4d57-a05a-929313247c5b', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('d1967293-739e-4929-809e-eecdec6dc886', '0f7b7c6e-b419-4d57-a05a-929313247c5b', 't', '${role_manage-clients}', 'manage-clients', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '0f7b7c6e-b419-4d57-a05a-929313247c5b', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('6ab62bf7-0e01-4e20-90f0-9808e24c51d9', '0f7b7c6e-b419-4d57-a05a-929313247c5b', 't', '${role_manage-events}', 'manage-events', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '0f7b7c6e-b419-4d57-a05a-929313247c5b', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('f9fad5a9-e9fd-4bcf-873f-8704e91e7df2', '0f7b7c6e-b419-4d57-a05a-929313247c5b', 't', '${role_manage-identity-providers}', 'manage-identity-providers', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '0f7b7c6e-b419-4d57-a05a-929313247c5b', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('efd2a77d-ec05-4994-8420-e098d037d6ef', '0f7b7c6e-b419-4d57-a05a-929313247c5b', 't', '${role_manage-authorization}', 'manage-authorization', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '0f7b7c6e-b419-4d57-a05a-929313247c5b', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('e5108bbf-8356-4d06-ad4c-c22776df4433', '0f7b7c6e-b419-4d57-a05a-929313247c5b', 't', '${role_query-users}', 'query-users', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '0f7b7c6e-b419-4d57-a05a-929313247c5b', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('867bb1ca-79b2-4cd9-b822-ce1a4c525c67', '0f7b7c6e-b419-4d57-a05a-929313247c5b', 't', '${role_query-clients}', 'query-clients', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '0f7b7c6e-b419-4d57-a05a-929313247c5b', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('33b604e4-82cc-4fcb-ada2-2b09333d9c97', '0f7b7c6e-b419-4d57-a05a-929313247c5b', 't', '${role_query-realms}', 'query-realms', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '0f7b7c6e-b419-4d57-a05a-929313247c5b', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('2cef1106-65fd-4dcb-9f99-244bb0fac29c', '0f7b7c6e-b419-4d57-a05a-929313247c5b', 't', '${role_query-groups}', 'query-groups', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '0f7b7c6e-b419-4d57-a05a-929313247c5b', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('b810741d-f504-435f-879f-878c72017bf2', 'ad3b314e-5403-45ee-b31e-aa88e47b7933', 't', '${role_view-profile}', 'view-profile', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'ad3b314e-5403-45ee-b31e-aa88e47b7933', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('5145a956-bd72-4410-a888-f52908ff8de6', 'ad3b314e-5403-45ee-b31e-aa88e47b7933', 't', '${role_manage-account}', 'manage-account', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'ad3b314e-5403-45ee-b31e-aa88e47b7933', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('058764ef-3b12-4e79-a46b-80e6b41b8a6a', 'ad3b314e-5403-45ee-b31e-aa88e47b7933', 't', '${role_manage-account-links}', 'manage-account-links', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'ad3b314e-5403-45ee-b31e-aa88e47b7933', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('f1b1bfb3-672e-49c0-9597-de43bc66b728', 'ad3b314e-5403-45ee-b31e-aa88e47b7933', 't', '${role_view-applications}', 'view-applications', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'ad3b314e-5403-45ee-b31e-aa88e47b7933', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('423ec62d-5001-4b4a-97fb-a85092b3b363', 'ad3b314e-5403-45ee-b31e-aa88e47b7933', 't', '${role_view-consent}', 'view-consent', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'ad3b314e-5403-45ee-b31e-aa88e47b7933', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('5c56fb08-48b3-47fd-8651-f57072eee361', 'ad3b314e-5403-45ee-b31e-aa88e47b7933', 't', '${role_manage-consent}', 'manage-consent', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'ad3b314e-5403-45ee-b31e-aa88e47b7933', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('0c3cf22b-0b87-410a-a921-12886a232e70', 'ad3b314e-5403-45ee-b31e-aa88e47b7933', 't', '${role_view-groups}', 'view-groups', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'ad3b314e-5403-45ee-b31e-aa88e47b7933', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('32dbd3ff-d3b0-4dc8-96f9-0a5a1d8b6fdb', 'ad3b314e-5403-45ee-b31e-aa88e47b7933', 't', '${role_delete-account}', 'delete-account', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'ad3b314e-5403-45ee-b31e-aa88e47b7933', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('f15a710e-be5e-4274-b4f5-296d6b44c778', 'f9506698-432f-4575-89fd-159b3bed7106', 't', '${role_read-token}', 'read-token', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'f9506698-432f-4575-89fd-159b3bed7106', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('86ff801f-9de1-43b6-bc10-8c2359c618af', '0f7b7c6e-b419-4d57-a05a-929313247c5b', 't', '${role_impersonation}', 'impersonation', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '0f7b7c6e-b419-4d57-a05a-929313247c5b', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('3f44286b-64c4-4797-9a87-0100ab640c79', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'f', '${role_offline-access}', 'offline_access', '2615b5da-5c3b-432f-af31-9af5f519b2a6', NULL, NULL);
INSERT INTO "public"."keycloak_role" VALUES ('cd63ca60-00e0-4644-96ec-dce24011b101', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'f', '${role_uma_authorization}', 'uma_authorization', '2615b5da-5c3b-432f-af31-9af5f519b2a6', NULL, NULL);
INSERT INTO "public"."keycloak_role" VALUES ('35579285-15b3-403c-a636-4c5a2767c90a', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'f', '${role_default-roles}', 'default-roles-spring-boot-realm-dev', 'e668ca58-deb8-459c-9294-39e5e530c03f', NULL, NULL);
INSERT INTO "public"."keycloak_role" VALUES ('0988e974-2024-41e5-8c32-508b22b973b0', 'e91855ac-d4b5-4c39-8aa3-ec0609b98ada', 't', '${role_create-client}', 'create-client', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'e91855ac-d4b5-4c39-8aa3-ec0609b98ada', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('6e458f60-7b19-4acb-9c96-899fd2026f67', 'e91855ac-d4b5-4c39-8aa3-ec0609b98ada', 't', '${role_view-realm}', 'view-realm', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'e91855ac-d4b5-4c39-8aa3-ec0609b98ada', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('2e2ddcaa-14dd-481f-8e63-f0e3f0a21e9b', 'e91855ac-d4b5-4c39-8aa3-ec0609b98ada', 't', '${role_view-users}', 'view-users', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'e91855ac-d4b5-4c39-8aa3-ec0609b98ada', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('93a07816-81e8-476f-b19c-7ce5a57972e3', 'e91855ac-d4b5-4c39-8aa3-ec0609b98ada', 't', '${role_view-clients}', 'view-clients', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'e91855ac-d4b5-4c39-8aa3-ec0609b98ada', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('763fd871-95d0-4ed0-ad62-b42563d77605', 'e91855ac-d4b5-4c39-8aa3-ec0609b98ada', 't', '${role_view-events}', 'view-events', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'e91855ac-d4b5-4c39-8aa3-ec0609b98ada', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('971cc95b-cf7f-4d82-9173-74beb2e01f59', 'e91855ac-d4b5-4c39-8aa3-ec0609b98ada', 't', '${role_view-identity-providers}', 'view-identity-providers', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'e91855ac-d4b5-4c39-8aa3-ec0609b98ada', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('d7e8380f-4dc7-42b1-8fd2-db7c7bc5e9b5', 'e91855ac-d4b5-4c39-8aa3-ec0609b98ada', 't', '${role_view-authorization}', 'view-authorization', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'e91855ac-d4b5-4c39-8aa3-ec0609b98ada', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('23fa0bb9-de2b-4b87-9221-56bdb0c02528', 'e91855ac-d4b5-4c39-8aa3-ec0609b98ada', 't', '${role_manage-realm}', 'manage-realm', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'e91855ac-d4b5-4c39-8aa3-ec0609b98ada', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('fb2aef97-2fea-4b05-a30a-d72cebe38449', 'e91855ac-d4b5-4c39-8aa3-ec0609b98ada', 't', '${role_manage-users}', 'manage-users', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'e91855ac-d4b5-4c39-8aa3-ec0609b98ada', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('07352222-5b9f-4889-876a-abbf96e05f05', 'e91855ac-d4b5-4c39-8aa3-ec0609b98ada', 't', '${role_manage-clients}', 'manage-clients', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'e91855ac-d4b5-4c39-8aa3-ec0609b98ada', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('5678a1aa-2183-411d-baf8-1cb77285b1c4', 'e91855ac-d4b5-4c39-8aa3-ec0609b98ada', 't', '${role_manage-events}', 'manage-events', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'e91855ac-d4b5-4c39-8aa3-ec0609b98ada', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('a25c6703-4bb9-489c-ac50-a238b75e8ad8', 'e91855ac-d4b5-4c39-8aa3-ec0609b98ada', 't', '${role_manage-identity-providers}', 'manage-identity-providers', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'e91855ac-d4b5-4c39-8aa3-ec0609b98ada', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('a78d4052-4e7b-47b4-b13a-ca3f081055e8', 'e91855ac-d4b5-4c39-8aa3-ec0609b98ada', 't', '${role_manage-authorization}', 'manage-authorization', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'e91855ac-d4b5-4c39-8aa3-ec0609b98ada', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('271780ee-beec-4b7f-ba91-95e2c96590a6', 'e91855ac-d4b5-4c39-8aa3-ec0609b98ada', 't', '${role_query-users}', 'query-users', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'e91855ac-d4b5-4c39-8aa3-ec0609b98ada', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('d53b666e-d916-4e44-898b-2562385af3e4', 'e91855ac-d4b5-4c39-8aa3-ec0609b98ada', 't', '${role_query-clients}', 'query-clients', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'e91855ac-d4b5-4c39-8aa3-ec0609b98ada', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('696b5770-ceef-420f-aff4-6f9018dd4d96', 'e91855ac-d4b5-4c39-8aa3-ec0609b98ada', 't', '${role_query-realms}', 'query-realms', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'e91855ac-d4b5-4c39-8aa3-ec0609b98ada', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('dcbc2317-ac1e-4599-875b-232717dde80d', 'e91855ac-d4b5-4c39-8aa3-ec0609b98ada', 't', '${role_query-groups}', 'query-groups', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'e91855ac-d4b5-4c39-8aa3-ec0609b98ada', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('5af3bb46-70b4-469c-a964-b13736ebf36f', '20d9416e-0e2d-48d3-bfff-f256d60cc99c', 't', '${role_realm-admin}', 'realm-admin', 'e668ca58-deb8-459c-9294-39e5e530c03f', '20d9416e-0e2d-48d3-bfff-f256d60cc99c', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('139e0bef-158d-4a9c-802b-5c6768d05297', '20d9416e-0e2d-48d3-bfff-f256d60cc99c', 't', '${role_create-client}', 'create-client', 'e668ca58-deb8-459c-9294-39e5e530c03f', '20d9416e-0e2d-48d3-bfff-f256d60cc99c', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('3a82a7eb-c421-4391-9c6c-2378fd1f75ec', '20d9416e-0e2d-48d3-bfff-f256d60cc99c', 't', '${role_view-realm}', 'view-realm', 'e668ca58-deb8-459c-9294-39e5e530c03f', '20d9416e-0e2d-48d3-bfff-f256d60cc99c', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('63efa6aa-a85e-4dd6-aa96-2d04fdb1c573', '20d9416e-0e2d-48d3-bfff-f256d60cc99c', 't', '${role_view-users}', 'view-users', 'e668ca58-deb8-459c-9294-39e5e530c03f', '20d9416e-0e2d-48d3-bfff-f256d60cc99c', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('370f9c56-d9b2-442f-8785-fe39bc847e62', '20d9416e-0e2d-48d3-bfff-f256d60cc99c', 't', '${role_view-clients}', 'view-clients', 'e668ca58-deb8-459c-9294-39e5e530c03f', '20d9416e-0e2d-48d3-bfff-f256d60cc99c', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('3de3589c-2c21-486c-8270-dd1e049fa7e0', '20d9416e-0e2d-48d3-bfff-f256d60cc99c', 't', '${role_view-events}', 'view-events', 'e668ca58-deb8-459c-9294-39e5e530c03f', '20d9416e-0e2d-48d3-bfff-f256d60cc99c', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('f7ff78ff-afd3-4d54-9075-8a6defa4aaab', '20d9416e-0e2d-48d3-bfff-f256d60cc99c', 't', '${role_view-identity-providers}', 'view-identity-providers', 'e668ca58-deb8-459c-9294-39e5e530c03f', '20d9416e-0e2d-48d3-bfff-f256d60cc99c', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('c7ea5e9a-bfcc-4cb8-bcca-ff205c7c07f2', '20d9416e-0e2d-48d3-bfff-f256d60cc99c', 't', '${role_view-authorization}', 'view-authorization', 'e668ca58-deb8-459c-9294-39e5e530c03f', '20d9416e-0e2d-48d3-bfff-f256d60cc99c', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('5f4b1af8-0142-4347-b1fa-15268c90c6d5', '20d9416e-0e2d-48d3-bfff-f256d60cc99c', 't', '${role_manage-realm}', 'manage-realm', 'e668ca58-deb8-459c-9294-39e5e530c03f', '20d9416e-0e2d-48d3-bfff-f256d60cc99c', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('66627d90-e457-45f0-8315-5e3bed234842', '20d9416e-0e2d-48d3-bfff-f256d60cc99c', 't', '${role_manage-users}', 'manage-users', 'e668ca58-deb8-459c-9294-39e5e530c03f', '20d9416e-0e2d-48d3-bfff-f256d60cc99c', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('44e1b181-5113-4832-b951-eedd4d1e6cd8', '20d9416e-0e2d-48d3-bfff-f256d60cc99c', 't', '${role_manage-clients}', 'manage-clients', 'e668ca58-deb8-459c-9294-39e5e530c03f', '20d9416e-0e2d-48d3-bfff-f256d60cc99c', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('d9917051-d97f-4952-bffc-8f87e8105d88', '20d9416e-0e2d-48d3-bfff-f256d60cc99c', 't', '${role_manage-events}', 'manage-events', 'e668ca58-deb8-459c-9294-39e5e530c03f', '20d9416e-0e2d-48d3-bfff-f256d60cc99c', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('e86eb467-a81b-4c30-ac81-18cc7a2951dd', '20d9416e-0e2d-48d3-bfff-f256d60cc99c', 't', '${role_manage-identity-providers}', 'manage-identity-providers', 'e668ca58-deb8-459c-9294-39e5e530c03f', '20d9416e-0e2d-48d3-bfff-f256d60cc99c', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('0a71f1c1-0c08-46eb-88a9-ce62b4aac965', '20d9416e-0e2d-48d3-bfff-f256d60cc99c', 't', '${role_manage-authorization}', 'manage-authorization', 'e668ca58-deb8-459c-9294-39e5e530c03f', '20d9416e-0e2d-48d3-bfff-f256d60cc99c', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('210f7b06-7fef-4f10-9ac7-4fa2d916424d', '20d9416e-0e2d-48d3-bfff-f256d60cc99c', 't', '${role_query-users}', 'query-users', 'e668ca58-deb8-459c-9294-39e5e530c03f', '20d9416e-0e2d-48d3-bfff-f256d60cc99c', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('0896918b-26d5-4aae-8e0b-fc800f2dbb8e', '20d9416e-0e2d-48d3-bfff-f256d60cc99c', 't', '${role_query-clients}', 'query-clients', 'e668ca58-deb8-459c-9294-39e5e530c03f', '20d9416e-0e2d-48d3-bfff-f256d60cc99c', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('a16638be-25b8-4356-9229-2218c7068f4e', '20d9416e-0e2d-48d3-bfff-f256d60cc99c', 't', '${role_query-realms}', 'query-realms', 'e668ca58-deb8-459c-9294-39e5e530c03f', '20d9416e-0e2d-48d3-bfff-f256d60cc99c', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('c81eef58-8c5d-409e-9a3d-19cee5db5d85', '20d9416e-0e2d-48d3-bfff-f256d60cc99c', 't', '${role_query-groups}', 'query-groups', 'e668ca58-deb8-459c-9294-39e5e530c03f', '20d9416e-0e2d-48d3-bfff-f256d60cc99c', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('09efab05-ec9a-47cd-9954-b89abc424fad', '51f2891f-9f5a-4054-8823-3627b06e3e5b', 't', '${role_view-profile}', 'view-profile', 'e668ca58-deb8-459c-9294-39e5e530c03f', '51f2891f-9f5a-4054-8823-3627b06e3e5b', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('05027f7e-0390-47f2-a3a3-ca33d49beac6', '51f2891f-9f5a-4054-8823-3627b06e3e5b', 't', '${role_manage-account}', 'manage-account', 'e668ca58-deb8-459c-9294-39e5e530c03f', '51f2891f-9f5a-4054-8823-3627b06e3e5b', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('9cc494ca-d02f-4482-a74e-0108251c2d27', '51f2891f-9f5a-4054-8823-3627b06e3e5b', 't', '${role_manage-account-links}', 'manage-account-links', 'e668ca58-deb8-459c-9294-39e5e530c03f', '51f2891f-9f5a-4054-8823-3627b06e3e5b', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('0d419b88-9674-4185-b7e2-5aebca91c06b', '51f2891f-9f5a-4054-8823-3627b06e3e5b', 't', '${role_view-applications}', 'view-applications', 'e668ca58-deb8-459c-9294-39e5e530c03f', '51f2891f-9f5a-4054-8823-3627b06e3e5b', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('0ec4f99f-bf5e-4834-b451-7266afbe647c', '51f2891f-9f5a-4054-8823-3627b06e3e5b', 't', '${role_view-consent}', 'view-consent', 'e668ca58-deb8-459c-9294-39e5e530c03f', '51f2891f-9f5a-4054-8823-3627b06e3e5b', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('2c328d98-992f-4033-8e3c-8421857bb7d3', '51f2891f-9f5a-4054-8823-3627b06e3e5b', 't', '${role_manage-consent}', 'manage-consent', 'e668ca58-deb8-459c-9294-39e5e530c03f', '51f2891f-9f5a-4054-8823-3627b06e3e5b', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('daa24dc6-dcfd-4c98-a09e-9a70ade11357', '51f2891f-9f5a-4054-8823-3627b06e3e5b', 't', '${role_view-groups}', 'view-groups', 'e668ca58-deb8-459c-9294-39e5e530c03f', '51f2891f-9f5a-4054-8823-3627b06e3e5b', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('e77f147d-1bdc-4d68-a193-fa710f5eb201', '51f2891f-9f5a-4054-8823-3627b06e3e5b', 't', '${role_delete-account}', 'delete-account', 'e668ca58-deb8-459c-9294-39e5e530c03f', '51f2891f-9f5a-4054-8823-3627b06e3e5b', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('401d44ba-e48a-4be9-896b-97192732f271', 'e91855ac-d4b5-4c39-8aa3-ec0609b98ada', 't', '${role_impersonation}', 'impersonation', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'e91855ac-d4b5-4c39-8aa3-ec0609b98ada', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('e5b59374-d652-4b96-bf87-4740aef9b554', '20d9416e-0e2d-48d3-bfff-f256d60cc99c', 't', '${role_impersonation}', 'impersonation', 'e668ca58-deb8-459c-9294-39e5e530c03f', '20d9416e-0e2d-48d3-bfff-f256d60cc99c', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('8bcff026-09a0-43b2-b068-6fff4a663aa4', 'a3074b6a-2f88-4a1e-b1ab-3564c6b89ba9', 't', '${role_read-token}', 'read-token', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'a3074b6a-2f88-4a1e-b1ab-3564c6b89ba9', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('6638b669-7d90-4203-aa23-91b2d5bfa168', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'f', '${role_offline-access}', 'offline_access', 'e668ca58-deb8-459c-9294-39e5e530c03f', NULL, NULL);
INSERT INTO "public"."keycloak_role" VALUES ('31b319e8-9e92-4645-82d5-649b46ffb9d8', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'f', '${role_uma_authorization}', 'uma_authorization', 'e668ca58-deb8-459c-9294-39e5e530c03f', NULL, NULL);
INSERT INTO "public"."keycloak_role" VALUES ('b63687c2-e689-4c46-852f-a2e0698d834b', '39132819-80be-4746-861d-ce870d61b7c1', 't', '', 'admin', 'e668ca58-deb8-459c-9294-39e5e530c03f', '39132819-80be-4746-861d-ce870d61b7c1', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('147e24ee-88a1-47ab-8a7e-33e00d538f25', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'f', '', 'admin', 'e668ca58-deb8-459c-9294-39e5e530c03f', NULL, NULL);
INSERT INTO "public"."keycloak_role" VALUES ('2499f3ff-56d8-465e-bda8-485e7f87e9fe', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'f', '', 'user', 'e668ca58-deb8-459c-9294-39e5e530c03f', NULL, NULL);
INSERT INTO "public"."keycloak_role" VALUES ('33f34903-cf72-4d0c-adac-5b552d530b92', '013f7a7e-a923-44dc-bf06-12f9d50a38c3', 't', '', 'admin_client_role', 'e668ca58-deb8-459c-9294-39e5e530c03f', '013f7a7e-a923-44dc-bf06-12f9d50a38c3', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('1d94e0b1-91a4-4ab4-ae60-285057b4411c', '013f7a7e-a923-44dc-bf06-12f9d50a38c3', 't', '', 'user_client_role', 'e668ca58-deb8-459c-9294-39e5e530c03f', '013f7a7e-a923-44dc-bf06-12f9d50a38c3', NULL);
INSERT INTO "public"."keycloak_role" VALUES ('c9e89928-e6ee-4d03-b954-06dc4f53afc0', '013f7a7e-a923-44dc-bf06-12f9d50a38c3', 't', NULL, 'uma_protection', 'e668ca58-deb8-459c-9294-39e5e530c03f', '013f7a7e-a923-44dc-bf06-12f9d50a38c3', NULL);

-- ----------------------------
-- Table structure for migration_model
-- ----------------------------
DROP TABLE IF EXISTS "public"."migration_model";
CREATE TABLE "public"."migration_model" (
  "id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "version" varchar(36) COLLATE "pg_catalog"."default",
  "update_time" int8 NOT NULL DEFAULT 0
)
;

-- ----------------------------
-- Records of migration_model
-- ----------------------------
INSERT INTO "public"."migration_model" VALUES ('4baw8', '22.0.4', 1715777593);

-- ----------------------------
-- Table structure for offline_client_session
-- ----------------------------
DROP TABLE IF EXISTS "public"."offline_client_session";
CREATE TABLE "public"."offline_client_session" (
  "user_session_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "client_id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "offline_flag" varchar(4) COLLATE "pg_catalog"."default" NOT NULL,
  "timestamp" int4,
  "data" text COLLATE "pg_catalog"."default",
  "client_storage_provider" varchar(36) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'local'::character varying,
  "external_client_id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'local'::character varying
)
;

-- ----------------------------
-- Records of offline_client_session
-- ----------------------------

-- ----------------------------
-- Table structure for offline_user_session
-- ----------------------------
DROP TABLE IF EXISTS "public"."offline_user_session";
CREATE TABLE "public"."offline_user_session" (
  "user_session_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "user_id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "realm_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "created_on" int4 NOT NULL,
  "offline_flag" varchar(4) COLLATE "pg_catalog"."default" NOT NULL,
  "data" text COLLATE "pg_catalog"."default",
  "last_session_refresh" int4 NOT NULL DEFAULT 0
)
;

-- ----------------------------
-- Records of offline_user_session
-- ----------------------------

-- ----------------------------
-- Table structure for policy_config
-- ----------------------------
DROP TABLE IF EXISTS "public"."policy_config";
CREATE TABLE "public"."policy_config" (
  "policy_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "value" text COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of policy_config
-- ----------------------------
INSERT INTO "public"."policy_config" VALUES ('1bb684a2-4982-49d3-bddf-49f26f1cc901', 'clients', '["ab045118-6511-45fb-93d5-e6bcd83aa04f"]');
INSERT INTO "public"."policy_config" VALUES ('e1a403f3-c854-4ceb-a018-2b27daf79b0f', 'clients', '["ab045118-6511-45fb-93d5-e6bcd83aa04f"]');

-- ----------------------------
-- Table structure for protocol_mapper
-- ----------------------------
DROP TABLE IF EXISTS "public"."protocol_mapper";
CREATE TABLE "public"."protocol_mapper" (
  "id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "protocol" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "protocol_mapper_name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "client_id" varchar(36) COLLATE "pg_catalog"."default",
  "client_scope_id" varchar(36) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of protocol_mapper
-- ----------------------------
INSERT INTO "public"."protocol_mapper" VALUES ('f6a3e899-c8bf-4ae0-a67a-6f4a7013db6a', 'audience resolve', 'openid-connect', 'oidc-audience-resolve-mapper', '1418f9d8-877d-4a16-a0c7-05f2bac8f4e4', NULL);
INSERT INTO "public"."protocol_mapper" VALUES ('1cab10ba-8626-4fbf-9877-039f76fc0d92', 'locale', 'openid-connect', 'oidc-usermodel-attribute-mapper', 'e0f7d215-09a8-426a-83d3-b159f75c1d63', NULL);
INSERT INTO "public"."protocol_mapper" VALUES ('8682f6e7-de69-4079-b7ff-b636a859a271', 'role list', 'saml', 'saml-role-list-mapper', NULL, 'b0ad2b84-c7f5-461d-955c-e84ed0c1c831');
INSERT INTO "public"."protocol_mapper" VALUES ('6878a59c-2210-4042-b13f-d27c2026c4b0', 'full name', 'openid-connect', 'oidc-full-name-mapper', NULL, '9dcfe6e4-49ab-4793-bb46-924dcf6055f5');
INSERT INTO "public"."protocol_mapper" VALUES ('253e3ea4-5434-4ce8-978a-cf7367181221', 'family name', 'openid-connect', 'oidc-usermodel-attribute-mapper', NULL, '9dcfe6e4-49ab-4793-bb46-924dcf6055f5');
INSERT INTO "public"."protocol_mapper" VALUES ('77edb35a-edd7-4e4b-b311-2d434fd77898', 'given name', 'openid-connect', 'oidc-usermodel-attribute-mapper', NULL, '9dcfe6e4-49ab-4793-bb46-924dcf6055f5');
INSERT INTO "public"."protocol_mapper" VALUES ('fd70c9a8-465c-4fdb-98b9-9cbbf5dec8ff', 'middle name', 'openid-connect', 'oidc-usermodel-attribute-mapper', NULL, '9dcfe6e4-49ab-4793-bb46-924dcf6055f5');
INSERT INTO "public"."protocol_mapper" VALUES ('dd095981-e038-441c-98d7-0c912452f46d', 'nickname', 'openid-connect', 'oidc-usermodel-attribute-mapper', NULL, '9dcfe6e4-49ab-4793-bb46-924dcf6055f5');
INSERT INTO "public"."protocol_mapper" VALUES ('c9da8259-0efd-4e2a-92fe-c6cd4a68df94', 'username', 'openid-connect', 'oidc-usermodel-attribute-mapper', NULL, '9dcfe6e4-49ab-4793-bb46-924dcf6055f5');
INSERT INTO "public"."protocol_mapper" VALUES ('653b2548-5b27-4d59-8fe1-81ba78f38a93', 'profile', 'openid-connect', 'oidc-usermodel-attribute-mapper', NULL, '9dcfe6e4-49ab-4793-bb46-924dcf6055f5');
INSERT INTO "public"."protocol_mapper" VALUES ('ca2c92b2-2672-4f4f-99e1-cbf47332f279', 'picture', 'openid-connect', 'oidc-usermodel-attribute-mapper', NULL, '9dcfe6e4-49ab-4793-bb46-924dcf6055f5');
INSERT INTO "public"."protocol_mapper" VALUES ('d4a4d4d4-18ec-4cc1-a964-568150cbe21d', 'website', 'openid-connect', 'oidc-usermodel-attribute-mapper', NULL, '9dcfe6e4-49ab-4793-bb46-924dcf6055f5');
INSERT INTO "public"."protocol_mapper" VALUES ('98d4263a-2b82-492c-9da0-7e1a76ab8a96', 'gender', 'openid-connect', 'oidc-usermodel-attribute-mapper', NULL, '9dcfe6e4-49ab-4793-bb46-924dcf6055f5');
INSERT INTO "public"."protocol_mapper" VALUES ('ac4e475b-b236-413c-86c1-fb93a532c587', 'birthdate', 'openid-connect', 'oidc-usermodel-attribute-mapper', NULL, '9dcfe6e4-49ab-4793-bb46-924dcf6055f5');
INSERT INTO "public"."protocol_mapper" VALUES ('2867c607-885d-418f-b662-3998a47b07b9', 'zoneinfo', 'openid-connect', 'oidc-usermodel-attribute-mapper', NULL, '9dcfe6e4-49ab-4793-bb46-924dcf6055f5');
INSERT INTO "public"."protocol_mapper" VALUES ('1762108b-0b44-4bfd-95c4-e82670bfe666', 'locale', 'openid-connect', 'oidc-usermodel-attribute-mapper', NULL, '9dcfe6e4-49ab-4793-bb46-924dcf6055f5');
INSERT INTO "public"."protocol_mapper" VALUES ('131385ec-989d-4da3-98d5-cd34467fa377', 'updated at', 'openid-connect', 'oidc-usermodel-attribute-mapper', NULL, '9dcfe6e4-49ab-4793-bb46-924dcf6055f5');
INSERT INTO "public"."protocol_mapper" VALUES ('67b8de63-0561-45d4-87e3-378903c259e0', 'email', 'openid-connect', 'oidc-usermodel-attribute-mapper', NULL, '76386606-f8dd-43fe-8d3a-a2c961e381e4');
INSERT INTO "public"."protocol_mapper" VALUES ('60610bca-bbb1-47b5-9567-8367d9203e1b', 'email verified', 'openid-connect', 'oidc-usermodel-property-mapper', NULL, '76386606-f8dd-43fe-8d3a-a2c961e381e4');
INSERT INTO "public"."protocol_mapper" VALUES ('9ecd12cc-c47b-4001-900d-c4145ca1e48d', 'address', 'openid-connect', 'oidc-address-mapper', NULL, 'ee24b790-e82d-4cba-bda1-f1af7659a7e2');
INSERT INTO "public"."protocol_mapper" VALUES ('74a4bd50-0c0b-402b-9957-de7a2b66b082', 'phone number', 'openid-connect', 'oidc-usermodel-attribute-mapper', NULL, 'a4e06c75-dbbe-4fbd-bdf8-acb74a9e87d4');
INSERT INTO "public"."protocol_mapper" VALUES ('27749eee-1bc7-4b1e-9b10-39056b27f3b3', 'phone number verified', 'openid-connect', 'oidc-usermodel-attribute-mapper', NULL, 'a4e06c75-dbbe-4fbd-bdf8-acb74a9e87d4');
INSERT INTO "public"."protocol_mapper" VALUES ('f519eb0b-83d3-428e-82f3-11776d956f36', 'realm roles', 'openid-connect', 'oidc-usermodel-realm-role-mapper', NULL, '7aac5fb5-c5c9-491f-8b99-087db6b8aa5c');
INSERT INTO "public"."protocol_mapper" VALUES ('195ba860-baac-45b4-9ab7-c6e6a57788cd', 'client roles', 'openid-connect', 'oidc-usermodel-client-role-mapper', NULL, '7aac5fb5-c5c9-491f-8b99-087db6b8aa5c');
INSERT INTO "public"."protocol_mapper" VALUES ('4aa710fa-c370-47d7-9b06-ec5b60789a4f', 'audience resolve', 'openid-connect', 'oidc-audience-resolve-mapper', NULL, '7aac5fb5-c5c9-491f-8b99-087db6b8aa5c');
INSERT INTO "public"."protocol_mapper" VALUES ('dbdaea97-4420-4cde-94d0-8841f78a5dd5', 'allowed web origins', 'openid-connect', 'oidc-allowed-origins-mapper', NULL, 'dadf7439-407d-4d35-b52c-cdc5e2fa6706');
INSERT INTO "public"."protocol_mapper" VALUES ('5c7f5d0b-651e-45c9-b90d-3963218f6389', 'upn', 'openid-connect', 'oidc-usermodel-attribute-mapper', NULL, 'f6907590-d9d0-4168-8bd3-5d4a26a978f9');
INSERT INTO "public"."protocol_mapper" VALUES ('e6dd94ac-eab1-4613-95da-1dff48917027', 'groups', 'openid-connect', 'oidc-usermodel-realm-role-mapper', NULL, 'f6907590-d9d0-4168-8bd3-5d4a26a978f9');
INSERT INTO "public"."protocol_mapper" VALUES ('3bdc210f-57e4-498b-8396-855dd66164d4', 'acr loa level', 'openid-connect', 'oidc-acr-mapper', NULL, '9f95fa1c-49ff-4a0b-bd45-7f5a966a3cf5');
INSERT INTO "public"."protocol_mapper" VALUES ('1ec3cb0e-164d-4a92-bb0b-efe919659a05', 'audience resolve', 'openid-connect', 'oidc-audience-resolve-mapper', 'aa5445f5-a056-46f7-97e8-7d5fe2ab4453', NULL);
INSERT INTO "public"."protocol_mapper" VALUES ('57b2b7ae-31d4-437d-8ece-b6a4cd42e807', 'role list', 'saml', 'saml-role-list-mapper', NULL, '22ba7bb8-08c9-4c77-bd8b-16cc912218f6');
INSERT INTO "public"."protocol_mapper" VALUES ('6c08a425-4c60-46c7-a8dd-224690f7f6dd', 'full name', 'openid-connect', 'oidc-full-name-mapper', NULL, '0d6d3683-d0d7-4ad9-b08d-3ed0545fe0d6');
INSERT INTO "public"."protocol_mapper" VALUES ('2235697e-e9ab-47a3-bd7b-065a7ff9fc4d', 'family name', 'openid-connect', 'oidc-usermodel-attribute-mapper', NULL, '0d6d3683-d0d7-4ad9-b08d-3ed0545fe0d6');
INSERT INTO "public"."protocol_mapper" VALUES ('faa7a6b9-b9e6-450e-b350-da5641824545', 'given name', 'openid-connect', 'oidc-usermodel-attribute-mapper', NULL, '0d6d3683-d0d7-4ad9-b08d-3ed0545fe0d6');
INSERT INTO "public"."protocol_mapper" VALUES ('5d334a92-2dfe-4e51-9fae-dfcbfb5b067e', 'middle name', 'openid-connect', 'oidc-usermodel-attribute-mapper', NULL, '0d6d3683-d0d7-4ad9-b08d-3ed0545fe0d6');
INSERT INTO "public"."protocol_mapper" VALUES ('fa233467-e1e6-4cd2-a5a4-07536d10d42a', 'nickname', 'openid-connect', 'oidc-usermodel-attribute-mapper', NULL, '0d6d3683-d0d7-4ad9-b08d-3ed0545fe0d6');
INSERT INTO "public"."protocol_mapper" VALUES ('25340ca4-1a6c-4e74-a064-381dda4a54ff', 'username', 'openid-connect', 'oidc-usermodel-attribute-mapper', NULL, '0d6d3683-d0d7-4ad9-b08d-3ed0545fe0d6');
INSERT INTO "public"."protocol_mapper" VALUES ('a01503a7-00b8-4d52-a2d3-9f4111e91a82', 'profile', 'openid-connect', 'oidc-usermodel-attribute-mapper', NULL, '0d6d3683-d0d7-4ad9-b08d-3ed0545fe0d6');
INSERT INTO "public"."protocol_mapper" VALUES ('ddbffa14-aa3f-4ad7-867b-d75127278347', 'picture', 'openid-connect', 'oidc-usermodel-attribute-mapper', NULL, '0d6d3683-d0d7-4ad9-b08d-3ed0545fe0d6');
INSERT INTO "public"."protocol_mapper" VALUES ('6c854b63-3f87-49dd-bf3a-94586450fe74', 'website', 'openid-connect', 'oidc-usermodel-attribute-mapper', NULL, '0d6d3683-d0d7-4ad9-b08d-3ed0545fe0d6');
INSERT INTO "public"."protocol_mapper" VALUES ('517f0899-ca3c-4605-ac4d-c99051b49645', 'gender', 'openid-connect', 'oidc-usermodel-attribute-mapper', NULL, '0d6d3683-d0d7-4ad9-b08d-3ed0545fe0d6');
INSERT INTO "public"."protocol_mapper" VALUES ('5e6bdd6b-41ac-401d-be81-c9fc184bea52', 'birthdate', 'openid-connect', 'oidc-usermodel-attribute-mapper', NULL, '0d6d3683-d0d7-4ad9-b08d-3ed0545fe0d6');
INSERT INTO "public"."protocol_mapper" VALUES ('5b43adc0-09c3-4149-a4af-1830889adea8', 'zoneinfo', 'openid-connect', 'oidc-usermodel-attribute-mapper', NULL, '0d6d3683-d0d7-4ad9-b08d-3ed0545fe0d6');
INSERT INTO "public"."protocol_mapper" VALUES ('403cfd1a-d205-403a-a984-dae4e35adb65', 'locale', 'openid-connect', 'oidc-usermodel-attribute-mapper', NULL, '0d6d3683-d0d7-4ad9-b08d-3ed0545fe0d6');
INSERT INTO "public"."protocol_mapper" VALUES ('27c159c8-d1d5-473d-9e68-73c8e832d6ed', 'updated at', 'openid-connect', 'oidc-usermodel-attribute-mapper', NULL, '0d6d3683-d0d7-4ad9-b08d-3ed0545fe0d6');
INSERT INTO "public"."protocol_mapper" VALUES ('88e34b05-91e8-4e8e-912c-39fc3a0910ed', 'email', 'openid-connect', 'oidc-usermodel-attribute-mapper', NULL, 'fc4f4c5a-1168-4a67-9ca8-104a5ae91c78');
INSERT INTO "public"."protocol_mapper" VALUES ('0a965ad0-2754-455e-8f39-ef52fe623538', 'email verified', 'openid-connect', 'oidc-usermodel-property-mapper', NULL, 'fc4f4c5a-1168-4a67-9ca8-104a5ae91c78');
INSERT INTO "public"."protocol_mapper" VALUES ('cc788a4a-1c71-4d21-a82b-cfa8b876ef37', 'address', 'openid-connect', 'oidc-address-mapper', NULL, 'c3f54006-62f3-4978-b072-37769c2e4a89');
INSERT INTO "public"."protocol_mapper" VALUES ('14532097-e4e1-4a04-8244-32aac6464d49', 'phone number', 'openid-connect', 'oidc-usermodel-attribute-mapper', NULL, '3b975094-4d95-4ee4-9fcb-2bd2514625c9');
INSERT INTO "public"."protocol_mapper" VALUES ('93e50584-2187-412d-ba58-255f32aa2ce1', 'phone number verified', 'openid-connect', 'oidc-usermodel-attribute-mapper', NULL, '3b975094-4d95-4ee4-9fcb-2bd2514625c9');
INSERT INTO "public"."protocol_mapper" VALUES ('395598e4-8c6e-402c-b81c-ff29c73c7bfb', 'realm roles', 'openid-connect', 'oidc-usermodel-realm-role-mapper', NULL, '072eb48c-17cb-4d3c-b809-1066d9c8c366');
INSERT INTO "public"."protocol_mapper" VALUES ('13643eac-fc3c-4af7-bec1-0b87e16dcc01', 'client roles', 'openid-connect', 'oidc-usermodel-client-role-mapper', NULL, '072eb48c-17cb-4d3c-b809-1066d9c8c366');
INSERT INTO "public"."protocol_mapper" VALUES ('42e44f20-7c45-405f-8df6-6089143ac84c', 'audience resolve', 'openid-connect', 'oidc-audience-resolve-mapper', NULL, '072eb48c-17cb-4d3c-b809-1066d9c8c366');
INSERT INTO "public"."protocol_mapper" VALUES ('d319b6be-f040-42e1-8aac-bb61442b1d8e', 'allowed web origins', 'openid-connect', 'oidc-allowed-origins-mapper', NULL, '33e3b464-6d41-491c-8e63-e9fa4bbf7a77');
INSERT INTO "public"."protocol_mapper" VALUES ('3a093b99-5f55-4433-bec1-e5c32c39bbd1', 'upn', 'openid-connect', 'oidc-usermodel-attribute-mapper', NULL, '1fa4bd1c-d250-44ea-89af-f4460cd13d7d');
INSERT INTO "public"."protocol_mapper" VALUES ('eb860f14-56f3-4f30-9e74-0a0663b1cd2a', 'groups', 'openid-connect', 'oidc-usermodel-realm-role-mapper', NULL, '1fa4bd1c-d250-44ea-89af-f4460cd13d7d');
INSERT INTO "public"."protocol_mapper" VALUES ('5e783b6d-d530-453f-a038-b831b23479d7', 'acr loa level', 'openid-connect', 'oidc-acr-mapper', NULL, '9b50f631-7ede-4ed2-8ac2-bcd3f4014fe4');
INSERT INTO "public"."protocol_mapper" VALUES ('89f72fda-0231-4c92-a2e0-7259e7bdad43', 'locale', 'openid-connect', 'oidc-usermodel-attribute-mapper', '7b5fba19-edfe-4208-af18-4eba02c6d1fd', NULL);
INSERT INTO "public"."protocol_mapper" VALUES ('42f475ab-4508-4ea4-bc68-31cfb6b66d6c', 'Client ID', 'openid-connect', 'oidc-usersessionmodel-note-mapper', '013f7a7e-a923-44dc-bf06-12f9d50a38c3', NULL);
INSERT INTO "public"."protocol_mapper" VALUES ('32580c06-eef3-4d59-a0cd-72c84413da36', 'Client Host', 'openid-connect', 'oidc-usersessionmodel-note-mapper', '013f7a7e-a923-44dc-bf06-12f9d50a38c3', NULL);
INSERT INTO "public"."protocol_mapper" VALUES ('68b42a83-ae20-490b-8bc7-7d00ab4443d7', 'Client IP Address', 'openid-connect', 'oidc-usersessionmodel-note-mapper', '013f7a7e-a923-44dc-bf06-12f9d50a38c3', NULL);
INSERT INTO "public"."protocol_mapper" VALUES ('0c3e08a1-d51e-4761-9ff2-53a9be0e6a78', 'Client ID', 'openid-connect', 'oidc-usersessionmodel-note-mapper', '39132819-80be-4746-861d-ce870d61b7c1', NULL);
INSERT INTO "public"."protocol_mapper" VALUES ('77c9e9b1-2e6e-4684-9ea6-e0c62e5efa36', 'Client Host', 'openid-connect', 'oidc-usersessionmodel-note-mapper', '39132819-80be-4746-861d-ce870d61b7c1', NULL);
INSERT INTO "public"."protocol_mapper" VALUES ('0296fe38-4fe3-4217-a131-08785c25d725', 'Client IP Address', 'openid-connect', 'oidc-usersessionmodel-note-mapper', '39132819-80be-4746-861d-ce870d61b7c1', NULL);

-- ----------------------------
-- Table structure for protocol_mapper_config
-- ----------------------------
DROP TABLE IF EXISTS "public"."protocol_mapper_config";
CREATE TABLE "public"."protocol_mapper_config" (
  "protocol_mapper_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "value" text COLLATE "pg_catalog"."default",
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of protocol_mapper_config
-- ----------------------------
INSERT INTO "public"."protocol_mapper_config" VALUES ('1cab10ba-8626-4fbf-9877-039f76fc0d92', 'true', 'userinfo.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('1cab10ba-8626-4fbf-9877-039f76fc0d92', 'locale', 'user.attribute');
INSERT INTO "public"."protocol_mapper_config" VALUES ('1cab10ba-8626-4fbf-9877-039f76fc0d92', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('1cab10ba-8626-4fbf-9877-039f76fc0d92', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('1cab10ba-8626-4fbf-9877-039f76fc0d92', 'locale', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('1cab10ba-8626-4fbf-9877-039f76fc0d92', 'String', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('8682f6e7-de69-4079-b7ff-b636a859a271', 'false', 'single');
INSERT INTO "public"."protocol_mapper_config" VALUES ('8682f6e7-de69-4079-b7ff-b636a859a271', 'Basic', 'attribute.nameformat');
INSERT INTO "public"."protocol_mapper_config" VALUES ('8682f6e7-de69-4079-b7ff-b636a859a271', 'Role', 'attribute.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('131385ec-989d-4da3-98d5-cd34467fa377', 'true', 'userinfo.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('131385ec-989d-4da3-98d5-cd34467fa377', 'updatedAt', 'user.attribute');
INSERT INTO "public"."protocol_mapper_config" VALUES ('131385ec-989d-4da3-98d5-cd34467fa377', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('131385ec-989d-4da3-98d5-cd34467fa377', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('131385ec-989d-4da3-98d5-cd34467fa377', 'updated_at', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('131385ec-989d-4da3-98d5-cd34467fa377', 'long', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('1762108b-0b44-4bfd-95c4-e82670bfe666', 'true', 'userinfo.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('1762108b-0b44-4bfd-95c4-e82670bfe666', 'locale', 'user.attribute');
INSERT INTO "public"."protocol_mapper_config" VALUES ('1762108b-0b44-4bfd-95c4-e82670bfe666', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('1762108b-0b44-4bfd-95c4-e82670bfe666', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('1762108b-0b44-4bfd-95c4-e82670bfe666', 'locale', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('1762108b-0b44-4bfd-95c4-e82670bfe666', 'String', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('253e3ea4-5434-4ce8-978a-cf7367181221', 'true', 'userinfo.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('253e3ea4-5434-4ce8-978a-cf7367181221', 'lastName', 'user.attribute');
INSERT INTO "public"."protocol_mapper_config" VALUES ('253e3ea4-5434-4ce8-978a-cf7367181221', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('253e3ea4-5434-4ce8-978a-cf7367181221', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('253e3ea4-5434-4ce8-978a-cf7367181221', 'family_name', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('253e3ea4-5434-4ce8-978a-cf7367181221', 'String', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('2867c607-885d-418f-b662-3998a47b07b9', 'true', 'userinfo.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('2867c607-885d-418f-b662-3998a47b07b9', 'zoneinfo', 'user.attribute');
INSERT INTO "public"."protocol_mapper_config" VALUES ('2867c607-885d-418f-b662-3998a47b07b9', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('2867c607-885d-418f-b662-3998a47b07b9', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('2867c607-885d-418f-b662-3998a47b07b9', 'zoneinfo', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('2867c607-885d-418f-b662-3998a47b07b9', 'String', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('653b2548-5b27-4d59-8fe1-81ba78f38a93', 'true', 'userinfo.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('653b2548-5b27-4d59-8fe1-81ba78f38a93', 'profile', 'user.attribute');
INSERT INTO "public"."protocol_mapper_config" VALUES ('653b2548-5b27-4d59-8fe1-81ba78f38a93', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('653b2548-5b27-4d59-8fe1-81ba78f38a93', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('653b2548-5b27-4d59-8fe1-81ba78f38a93', 'profile', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('653b2548-5b27-4d59-8fe1-81ba78f38a93', 'String', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('6878a59c-2210-4042-b13f-d27c2026c4b0', 'true', 'userinfo.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('6878a59c-2210-4042-b13f-d27c2026c4b0', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('6878a59c-2210-4042-b13f-d27c2026c4b0', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('77edb35a-edd7-4e4b-b311-2d434fd77898', 'true', 'userinfo.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('77edb35a-edd7-4e4b-b311-2d434fd77898', 'firstName', 'user.attribute');
INSERT INTO "public"."protocol_mapper_config" VALUES ('77edb35a-edd7-4e4b-b311-2d434fd77898', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('77edb35a-edd7-4e4b-b311-2d434fd77898', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('77edb35a-edd7-4e4b-b311-2d434fd77898', 'given_name', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('77edb35a-edd7-4e4b-b311-2d434fd77898', 'String', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('98d4263a-2b82-492c-9da0-7e1a76ab8a96', 'true', 'userinfo.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('98d4263a-2b82-492c-9da0-7e1a76ab8a96', 'gender', 'user.attribute');
INSERT INTO "public"."protocol_mapper_config" VALUES ('98d4263a-2b82-492c-9da0-7e1a76ab8a96', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('98d4263a-2b82-492c-9da0-7e1a76ab8a96', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('98d4263a-2b82-492c-9da0-7e1a76ab8a96', 'gender', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('98d4263a-2b82-492c-9da0-7e1a76ab8a96', 'String', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('ac4e475b-b236-413c-86c1-fb93a532c587', 'true', 'userinfo.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('ac4e475b-b236-413c-86c1-fb93a532c587', 'birthdate', 'user.attribute');
INSERT INTO "public"."protocol_mapper_config" VALUES ('ac4e475b-b236-413c-86c1-fb93a532c587', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('ac4e475b-b236-413c-86c1-fb93a532c587', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('ac4e475b-b236-413c-86c1-fb93a532c587', 'birthdate', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('ac4e475b-b236-413c-86c1-fb93a532c587', 'String', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('c9da8259-0efd-4e2a-92fe-c6cd4a68df94', 'true', 'userinfo.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('c9da8259-0efd-4e2a-92fe-c6cd4a68df94', 'username', 'user.attribute');
INSERT INTO "public"."protocol_mapper_config" VALUES ('c9da8259-0efd-4e2a-92fe-c6cd4a68df94', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('c9da8259-0efd-4e2a-92fe-c6cd4a68df94', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('c9da8259-0efd-4e2a-92fe-c6cd4a68df94', 'preferred_username', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('c9da8259-0efd-4e2a-92fe-c6cd4a68df94', 'String', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('ca2c92b2-2672-4f4f-99e1-cbf47332f279', 'true', 'userinfo.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('ca2c92b2-2672-4f4f-99e1-cbf47332f279', 'picture', 'user.attribute');
INSERT INTO "public"."protocol_mapper_config" VALUES ('ca2c92b2-2672-4f4f-99e1-cbf47332f279', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('ca2c92b2-2672-4f4f-99e1-cbf47332f279', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('ca2c92b2-2672-4f4f-99e1-cbf47332f279', 'picture', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('ca2c92b2-2672-4f4f-99e1-cbf47332f279', 'String', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('d4a4d4d4-18ec-4cc1-a964-568150cbe21d', 'true', 'userinfo.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('d4a4d4d4-18ec-4cc1-a964-568150cbe21d', 'website', 'user.attribute');
INSERT INTO "public"."protocol_mapper_config" VALUES ('d4a4d4d4-18ec-4cc1-a964-568150cbe21d', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('d4a4d4d4-18ec-4cc1-a964-568150cbe21d', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('d4a4d4d4-18ec-4cc1-a964-568150cbe21d', 'website', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('d4a4d4d4-18ec-4cc1-a964-568150cbe21d', 'String', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('dd095981-e038-441c-98d7-0c912452f46d', 'true', 'userinfo.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('dd095981-e038-441c-98d7-0c912452f46d', 'nickname', 'user.attribute');
INSERT INTO "public"."protocol_mapper_config" VALUES ('dd095981-e038-441c-98d7-0c912452f46d', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('dd095981-e038-441c-98d7-0c912452f46d', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('dd095981-e038-441c-98d7-0c912452f46d', 'nickname', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('dd095981-e038-441c-98d7-0c912452f46d', 'String', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('fd70c9a8-465c-4fdb-98b9-9cbbf5dec8ff', 'true', 'userinfo.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('fd70c9a8-465c-4fdb-98b9-9cbbf5dec8ff', 'middleName', 'user.attribute');
INSERT INTO "public"."protocol_mapper_config" VALUES ('fd70c9a8-465c-4fdb-98b9-9cbbf5dec8ff', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('fd70c9a8-465c-4fdb-98b9-9cbbf5dec8ff', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('fd70c9a8-465c-4fdb-98b9-9cbbf5dec8ff', 'middle_name', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('fd70c9a8-465c-4fdb-98b9-9cbbf5dec8ff', 'String', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('60610bca-bbb1-47b5-9567-8367d9203e1b', 'true', 'userinfo.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('60610bca-bbb1-47b5-9567-8367d9203e1b', 'emailVerified', 'user.attribute');
INSERT INTO "public"."protocol_mapper_config" VALUES ('60610bca-bbb1-47b5-9567-8367d9203e1b', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('60610bca-bbb1-47b5-9567-8367d9203e1b', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('60610bca-bbb1-47b5-9567-8367d9203e1b', 'email_verified', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('60610bca-bbb1-47b5-9567-8367d9203e1b', 'boolean', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('67b8de63-0561-45d4-87e3-378903c259e0', 'true', 'userinfo.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('67b8de63-0561-45d4-87e3-378903c259e0', 'email', 'user.attribute');
INSERT INTO "public"."protocol_mapper_config" VALUES ('67b8de63-0561-45d4-87e3-378903c259e0', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('67b8de63-0561-45d4-87e3-378903c259e0', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('67b8de63-0561-45d4-87e3-378903c259e0', 'email', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('67b8de63-0561-45d4-87e3-378903c259e0', 'String', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('9ecd12cc-c47b-4001-900d-c4145ca1e48d', 'formatted', 'user.attribute.formatted');
INSERT INTO "public"."protocol_mapper_config" VALUES ('9ecd12cc-c47b-4001-900d-c4145ca1e48d', 'country', 'user.attribute.country');
INSERT INTO "public"."protocol_mapper_config" VALUES ('9ecd12cc-c47b-4001-900d-c4145ca1e48d', 'postal_code', 'user.attribute.postal_code');
INSERT INTO "public"."protocol_mapper_config" VALUES ('9ecd12cc-c47b-4001-900d-c4145ca1e48d', 'true', 'userinfo.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('9ecd12cc-c47b-4001-900d-c4145ca1e48d', 'street', 'user.attribute.street');
INSERT INTO "public"."protocol_mapper_config" VALUES ('9ecd12cc-c47b-4001-900d-c4145ca1e48d', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('9ecd12cc-c47b-4001-900d-c4145ca1e48d', 'region', 'user.attribute.region');
INSERT INTO "public"."protocol_mapper_config" VALUES ('9ecd12cc-c47b-4001-900d-c4145ca1e48d', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('9ecd12cc-c47b-4001-900d-c4145ca1e48d', 'locality', 'user.attribute.locality');
INSERT INTO "public"."protocol_mapper_config" VALUES ('27749eee-1bc7-4b1e-9b10-39056b27f3b3', 'true', 'userinfo.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('27749eee-1bc7-4b1e-9b10-39056b27f3b3', 'phoneNumberVerified', 'user.attribute');
INSERT INTO "public"."protocol_mapper_config" VALUES ('27749eee-1bc7-4b1e-9b10-39056b27f3b3', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('27749eee-1bc7-4b1e-9b10-39056b27f3b3', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('27749eee-1bc7-4b1e-9b10-39056b27f3b3', 'phone_number_verified', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('27749eee-1bc7-4b1e-9b10-39056b27f3b3', 'boolean', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('74a4bd50-0c0b-402b-9957-de7a2b66b082', 'true', 'userinfo.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('74a4bd50-0c0b-402b-9957-de7a2b66b082', 'phoneNumber', 'user.attribute');
INSERT INTO "public"."protocol_mapper_config" VALUES ('74a4bd50-0c0b-402b-9957-de7a2b66b082', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('74a4bd50-0c0b-402b-9957-de7a2b66b082', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('74a4bd50-0c0b-402b-9957-de7a2b66b082', 'phone_number', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('74a4bd50-0c0b-402b-9957-de7a2b66b082', 'String', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('195ba860-baac-45b4-9ab7-c6e6a57788cd', 'true', 'multivalued');
INSERT INTO "public"."protocol_mapper_config" VALUES ('195ba860-baac-45b4-9ab7-c6e6a57788cd', 'foo', 'user.attribute');
INSERT INTO "public"."protocol_mapper_config" VALUES ('195ba860-baac-45b4-9ab7-c6e6a57788cd', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('195ba860-baac-45b4-9ab7-c6e6a57788cd', 'resource_access.${client_id}.roles', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('195ba860-baac-45b4-9ab7-c6e6a57788cd', 'String', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('f519eb0b-83d3-428e-82f3-11776d956f36', 'true', 'multivalued');
INSERT INTO "public"."protocol_mapper_config" VALUES ('f519eb0b-83d3-428e-82f3-11776d956f36', 'foo', 'user.attribute');
INSERT INTO "public"."protocol_mapper_config" VALUES ('f519eb0b-83d3-428e-82f3-11776d956f36', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('f519eb0b-83d3-428e-82f3-11776d956f36', 'realm_access.roles', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('f519eb0b-83d3-428e-82f3-11776d956f36', 'String', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('5c7f5d0b-651e-45c9-b90d-3963218f6389', 'true', 'userinfo.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('5c7f5d0b-651e-45c9-b90d-3963218f6389', 'username', 'user.attribute');
INSERT INTO "public"."protocol_mapper_config" VALUES ('5c7f5d0b-651e-45c9-b90d-3963218f6389', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('5c7f5d0b-651e-45c9-b90d-3963218f6389', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('5c7f5d0b-651e-45c9-b90d-3963218f6389', 'upn', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('5c7f5d0b-651e-45c9-b90d-3963218f6389', 'String', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('e6dd94ac-eab1-4613-95da-1dff48917027', 'true', 'multivalued');
INSERT INTO "public"."protocol_mapper_config" VALUES ('e6dd94ac-eab1-4613-95da-1dff48917027', 'foo', 'user.attribute');
INSERT INTO "public"."protocol_mapper_config" VALUES ('e6dd94ac-eab1-4613-95da-1dff48917027', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('e6dd94ac-eab1-4613-95da-1dff48917027', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('e6dd94ac-eab1-4613-95da-1dff48917027', 'groups', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('e6dd94ac-eab1-4613-95da-1dff48917027', 'String', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('3bdc210f-57e4-498b-8396-855dd66164d4', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('3bdc210f-57e4-498b-8396-855dd66164d4', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('57b2b7ae-31d4-437d-8ece-b6a4cd42e807', 'false', 'single');
INSERT INTO "public"."protocol_mapper_config" VALUES ('57b2b7ae-31d4-437d-8ece-b6a4cd42e807', 'Basic', 'attribute.nameformat');
INSERT INTO "public"."protocol_mapper_config" VALUES ('57b2b7ae-31d4-437d-8ece-b6a4cd42e807', 'Role', 'attribute.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('2235697e-e9ab-47a3-bd7b-065a7ff9fc4d', 'true', 'userinfo.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('2235697e-e9ab-47a3-bd7b-065a7ff9fc4d', 'lastName', 'user.attribute');
INSERT INTO "public"."protocol_mapper_config" VALUES ('2235697e-e9ab-47a3-bd7b-065a7ff9fc4d', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('2235697e-e9ab-47a3-bd7b-065a7ff9fc4d', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('2235697e-e9ab-47a3-bd7b-065a7ff9fc4d', 'family_name', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('2235697e-e9ab-47a3-bd7b-065a7ff9fc4d', 'String', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('25340ca4-1a6c-4e74-a064-381dda4a54ff', 'true', 'userinfo.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('25340ca4-1a6c-4e74-a064-381dda4a54ff', 'username', 'user.attribute');
INSERT INTO "public"."protocol_mapper_config" VALUES ('25340ca4-1a6c-4e74-a064-381dda4a54ff', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('25340ca4-1a6c-4e74-a064-381dda4a54ff', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('25340ca4-1a6c-4e74-a064-381dda4a54ff', 'preferred_username', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('25340ca4-1a6c-4e74-a064-381dda4a54ff', 'String', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('27c159c8-d1d5-473d-9e68-73c8e832d6ed', 'true', 'userinfo.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('27c159c8-d1d5-473d-9e68-73c8e832d6ed', 'updatedAt', 'user.attribute');
INSERT INTO "public"."protocol_mapper_config" VALUES ('27c159c8-d1d5-473d-9e68-73c8e832d6ed', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('27c159c8-d1d5-473d-9e68-73c8e832d6ed', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('27c159c8-d1d5-473d-9e68-73c8e832d6ed', 'updated_at', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('27c159c8-d1d5-473d-9e68-73c8e832d6ed', 'long', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('403cfd1a-d205-403a-a984-dae4e35adb65', 'true', 'userinfo.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('403cfd1a-d205-403a-a984-dae4e35adb65', 'locale', 'user.attribute');
INSERT INTO "public"."protocol_mapper_config" VALUES ('403cfd1a-d205-403a-a984-dae4e35adb65', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('403cfd1a-d205-403a-a984-dae4e35adb65', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('403cfd1a-d205-403a-a984-dae4e35adb65', 'locale', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('403cfd1a-d205-403a-a984-dae4e35adb65', 'String', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('517f0899-ca3c-4605-ac4d-c99051b49645', 'true', 'userinfo.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('517f0899-ca3c-4605-ac4d-c99051b49645', 'gender', 'user.attribute');
INSERT INTO "public"."protocol_mapper_config" VALUES ('517f0899-ca3c-4605-ac4d-c99051b49645', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('517f0899-ca3c-4605-ac4d-c99051b49645', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('517f0899-ca3c-4605-ac4d-c99051b49645', 'gender', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('517f0899-ca3c-4605-ac4d-c99051b49645', 'String', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('5b43adc0-09c3-4149-a4af-1830889adea8', 'true', 'userinfo.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('5b43adc0-09c3-4149-a4af-1830889adea8', 'zoneinfo', 'user.attribute');
INSERT INTO "public"."protocol_mapper_config" VALUES ('5b43adc0-09c3-4149-a4af-1830889adea8', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('5b43adc0-09c3-4149-a4af-1830889adea8', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('5b43adc0-09c3-4149-a4af-1830889adea8', 'zoneinfo', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('5b43adc0-09c3-4149-a4af-1830889adea8', 'String', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('5d334a92-2dfe-4e51-9fae-dfcbfb5b067e', 'true', 'userinfo.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('5d334a92-2dfe-4e51-9fae-dfcbfb5b067e', 'middleName', 'user.attribute');
INSERT INTO "public"."protocol_mapper_config" VALUES ('5d334a92-2dfe-4e51-9fae-dfcbfb5b067e', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('5d334a92-2dfe-4e51-9fae-dfcbfb5b067e', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('5d334a92-2dfe-4e51-9fae-dfcbfb5b067e', 'middle_name', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('5d334a92-2dfe-4e51-9fae-dfcbfb5b067e', 'String', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('5e6bdd6b-41ac-401d-be81-c9fc184bea52', 'true', 'userinfo.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('5e6bdd6b-41ac-401d-be81-c9fc184bea52', 'birthdate', 'user.attribute');
INSERT INTO "public"."protocol_mapper_config" VALUES ('5e6bdd6b-41ac-401d-be81-c9fc184bea52', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('5e6bdd6b-41ac-401d-be81-c9fc184bea52', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('5e6bdd6b-41ac-401d-be81-c9fc184bea52', 'birthdate', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('5e6bdd6b-41ac-401d-be81-c9fc184bea52', 'String', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('6c08a425-4c60-46c7-a8dd-224690f7f6dd', 'true', 'userinfo.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('6c08a425-4c60-46c7-a8dd-224690f7f6dd', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('6c08a425-4c60-46c7-a8dd-224690f7f6dd', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('6c854b63-3f87-49dd-bf3a-94586450fe74', 'true', 'userinfo.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('6c854b63-3f87-49dd-bf3a-94586450fe74', 'website', 'user.attribute');
INSERT INTO "public"."protocol_mapper_config" VALUES ('6c854b63-3f87-49dd-bf3a-94586450fe74', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('6c854b63-3f87-49dd-bf3a-94586450fe74', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('6c854b63-3f87-49dd-bf3a-94586450fe74', 'website', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('6c854b63-3f87-49dd-bf3a-94586450fe74', 'String', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('a01503a7-00b8-4d52-a2d3-9f4111e91a82', 'true', 'userinfo.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('a01503a7-00b8-4d52-a2d3-9f4111e91a82', 'profile', 'user.attribute');
INSERT INTO "public"."protocol_mapper_config" VALUES ('a01503a7-00b8-4d52-a2d3-9f4111e91a82', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('a01503a7-00b8-4d52-a2d3-9f4111e91a82', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('a01503a7-00b8-4d52-a2d3-9f4111e91a82', 'profile', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('a01503a7-00b8-4d52-a2d3-9f4111e91a82', 'String', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('ddbffa14-aa3f-4ad7-867b-d75127278347', 'true', 'userinfo.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('ddbffa14-aa3f-4ad7-867b-d75127278347', 'picture', 'user.attribute');
INSERT INTO "public"."protocol_mapper_config" VALUES ('ddbffa14-aa3f-4ad7-867b-d75127278347', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('ddbffa14-aa3f-4ad7-867b-d75127278347', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('ddbffa14-aa3f-4ad7-867b-d75127278347', 'picture', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('ddbffa14-aa3f-4ad7-867b-d75127278347', 'String', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('fa233467-e1e6-4cd2-a5a4-07536d10d42a', 'true', 'userinfo.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('fa233467-e1e6-4cd2-a5a4-07536d10d42a', 'nickname', 'user.attribute');
INSERT INTO "public"."protocol_mapper_config" VALUES ('fa233467-e1e6-4cd2-a5a4-07536d10d42a', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('fa233467-e1e6-4cd2-a5a4-07536d10d42a', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('fa233467-e1e6-4cd2-a5a4-07536d10d42a', 'nickname', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('fa233467-e1e6-4cd2-a5a4-07536d10d42a', 'String', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('faa7a6b9-b9e6-450e-b350-da5641824545', 'true', 'userinfo.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('faa7a6b9-b9e6-450e-b350-da5641824545', 'firstName', 'user.attribute');
INSERT INTO "public"."protocol_mapper_config" VALUES ('faa7a6b9-b9e6-450e-b350-da5641824545', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('faa7a6b9-b9e6-450e-b350-da5641824545', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('faa7a6b9-b9e6-450e-b350-da5641824545', 'given_name', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('faa7a6b9-b9e6-450e-b350-da5641824545', 'String', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('0a965ad0-2754-455e-8f39-ef52fe623538', 'true', 'userinfo.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('0a965ad0-2754-455e-8f39-ef52fe623538', 'emailVerified', 'user.attribute');
INSERT INTO "public"."protocol_mapper_config" VALUES ('0a965ad0-2754-455e-8f39-ef52fe623538', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('0a965ad0-2754-455e-8f39-ef52fe623538', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('0a965ad0-2754-455e-8f39-ef52fe623538', 'email_verified', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('0a965ad0-2754-455e-8f39-ef52fe623538', 'boolean', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('88e34b05-91e8-4e8e-912c-39fc3a0910ed', 'true', 'userinfo.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('88e34b05-91e8-4e8e-912c-39fc3a0910ed', 'email', 'user.attribute');
INSERT INTO "public"."protocol_mapper_config" VALUES ('88e34b05-91e8-4e8e-912c-39fc3a0910ed', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('88e34b05-91e8-4e8e-912c-39fc3a0910ed', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('88e34b05-91e8-4e8e-912c-39fc3a0910ed', 'email', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('88e34b05-91e8-4e8e-912c-39fc3a0910ed', 'String', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('cc788a4a-1c71-4d21-a82b-cfa8b876ef37', 'formatted', 'user.attribute.formatted');
INSERT INTO "public"."protocol_mapper_config" VALUES ('cc788a4a-1c71-4d21-a82b-cfa8b876ef37', 'country', 'user.attribute.country');
INSERT INTO "public"."protocol_mapper_config" VALUES ('cc788a4a-1c71-4d21-a82b-cfa8b876ef37', 'postal_code', 'user.attribute.postal_code');
INSERT INTO "public"."protocol_mapper_config" VALUES ('cc788a4a-1c71-4d21-a82b-cfa8b876ef37', 'true', 'userinfo.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('cc788a4a-1c71-4d21-a82b-cfa8b876ef37', 'street', 'user.attribute.street');
INSERT INTO "public"."protocol_mapper_config" VALUES ('cc788a4a-1c71-4d21-a82b-cfa8b876ef37', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('cc788a4a-1c71-4d21-a82b-cfa8b876ef37', 'region', 'user.attribute.region');
INSERT INTO "public"."protocol_mapper_config" VALUES ('cc788a4a-1c71-4d21-a82b-cfa8b876ef37', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('cc788a4a-1c71-4d21-a82b-cfa8b876ef37', 'locality', 'user.attribute.locality');
INSERT INTO "public"."protocol_mapper_config" VALUES ('14532097-e4e1-4a04-8244-32aac6464d49', 'true', 'userinfo.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('14532097-e4e1-4a04-8244-32aac6464d49', 'phoneNumber', 'user.attribute');
INSERT INTO "public"."protocol_mapper_config" VALUES ('14532097-e4e1-4a04-8244-32aac6464d49', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('14532097-e4e1-4a04-8244-32aac6464d49', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('14532097-e4e1-4a04-8244-32aac6464d49', 'phone_number', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('14532097-e4e1-4a04-8244-32aac6464d49', 'String', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('93e50584-2187-412d-ba58-255f32aa2ce1', 'true', 'userinfo.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('93e50584-2187-412d-ba58-255f32aa2ce1', 'phoneNumberVerified', 'user.attribute');
INSERT INTO "public"."protocol_mapper_config" VALUES ('93e50584-2187-412d-ba58-255f32aa2ce1', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('93e50584-2187-412d-ba58-255f32aa2ce1', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('93e50584-2187-412d-ba58-255f32aa2ce1', 'phone_number_verified', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('93e50584-2187-412d-ba58-255f32aa2ce1', 'boolean', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('13643eac-fc3c-4af7-bec1-0b87e16dcc01', 'true', 'multivalued');
INSERT INTO "public"."protocol_mapper_config" VALUES ('13643eac-fc3c-4af7-bec1-0b87e16dcc01', 'foo', 'user.attribute');
INSERT INTO "public"."protocol_mapper_config" VALUES ('13643eac-fc3c-4af7-bec1-0b87e16dcc01', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('13643eac-fc3c-4af7-bec1-0b87e16dcc01', 'resource_access.${client_id}.roles', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('13643eac-fc3c-4af7-bec1-0b87e16dcc01', 'String', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('395598e4-8c6e-402c-b81c-ff29c73c7bfb', 'true', 'multivalued');
INSERT INTO "public"."protocol_mapper_config" VALUES ('395598e4-8c6e-402c-b81c-ff29c73c7bfb', 'foo', 'user.attribute');
INSERT INTO "public"."protocol_mapper_config" VALUES ('395598e4-8c6e-402c-b81c-ff29c73c7bfb', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('395598e4-8c6e-402c-b81c-ff29c73c7bfb', 'realm_access.roles', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('395598e4-8c6e-402c-b81c-ff29c73c7bfb', 'String', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('3a093b99-5f55-4433-bec1-e5c32c39bbd1', 'true', 'userinfo.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('3a093b99-5f55-4433-bec1-e5c32c39bbd1', 'username', 'user.attribute');
INSERT INTO "public"."protocol_mapper_config" VALUES ('3a093b99-5f55-4433-bec1-e5c32c39bbd1', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('3a093b99-5f55-4433-bec1-e5c32c39bbd1', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('3a093b99-5f55-4433-bec1-e5c32c39bbd1', 'upn', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('3a093b99-5f55-4433-bec1-e5c32c39bbd1', 'String', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('eb860f14-56f3-4f30-9e74-0a0663b1cd2a', 'true', 'multivalued');
INSERT INTO "public"."protocol_mapper_config" VALUES ('eb860f14-56f3-4f30-9e74-0a0663b1cd2a', 'foo', 'user.attribute');
INSERT INTO "public"."protocol_mapper_config" VALUES ('eb860f14-56f3-4f30-9e74-0a0663b1cd2a', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('eb860f14-56f3-4f30-9e74-0a0663b1cd2a', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('eb860f14-56f3-4f30-9e74-0a0663b1cd2a', 'groups', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('eb860f14-56f3-4f30-9e74-0a0663b1cd2a', 'String', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('5e783b6d-d530-453f-a038-b831b23479d7', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('5e783b6d-d530-453f-a038-b831b23479d7', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('89f72fda-0231-4c92-a2e0-7259e7bdad43', 'true', 'userinfo.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('89f72fda-0231-4c92-a2e0-7259e7bdad43', 'locale', 'user.attribute');
INSERT INTO "public"."protocol_mapper_config" VALUES ('89f72fda-0231-4c92-a2e0-7259e7bdad43', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('89f72fda-0231-4c92-a2e0-7259e7bdad43', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('89f72fda-0231-4c92-a2e0-7259e7bdad43', 'locale', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('89f72fda-0231-4c92-a2e0-7259e7bdad43', 'String', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('32580c06-eef3-4d59-a0cd-72c84413da36', 'clientHost', 'user.session.note');
INSERT INTO "public"."protocol_mapper_config" VALUES ('32580c06-eef3-4d59-a0cd-72c84413da36', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('32580c06-eef3-4d59-a0cd-72c84413da36', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('32580c06-eef3-4d59-a0cd-72c84413da36', 'clientHost', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('32580c06-eef3-4d59-a0cd-72c84413da36', 'String', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('42f475ab-4508-4ea4-bc68-31cfb6b66d6c', 'client_id', 'user.session.note');
INSERT INTO "public"."protocol_mapper_config" VALUES ('42f475ab-4508-4ea4-bc68-31cfb6b66d6c', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('42f475ab-4508-4ea4-bc68-31cfb6b66d6c', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('42f475ab-4508-4ea4-bc68-31cfb6b66d6c', 'client_id', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('42f475ab-4508-4ea4-bc68-31cfb6b66d6c', 'String', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('68b42a83-ae20-490b-8bc7-7d00ab4443d7', 'clientAddress', 'user.session.note');
INSERT INTO "public"."protocol_mapper_config" VALUES ('68b42a83-ae20-490b-8bc7-7d00ab4443d7', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('68b42a83-ae20-490b-8bc7-7d00ab4443d7', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('68b42a83-ae20-490b-8bc7-7d00ab4443d7', 'clientAddress', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('68b42a83-ae20-490b-8bc7-7d00ab4443d7', 'String', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('0296fe38-4fe3-4217-a131-08785c25d725', 'clientAddress', 'user.session.note');
INSERT INTO "public"."protocol_mapper_config" VALUES ('0296fe38-4fe3-4217-a131-08785c25d725', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('0296fe38-4fe3-4217-a131-08785c25d725', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('0296fe38-4fe3-4217-a131-08785c25d725', 'clientAddress', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('0296fe38-4fe3-4217-a131-08785c25d725', 'String', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('0c3e08a1-d51e-4761-9ff2-53a9be0e6a78', 'client_id', 'user.session.note');
INSERT INTO "public"."protocol_mapper_config" VALUES ('0c3e08a1-d51e-4761-9ff2-53a9be0e6a78', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('0c3e08a1-d51e-4761-9ff2-53a9be0e6a78', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('0c3e08a1-d51e-4761-9ff2-53a9be0e6a78', 'client_id', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('0c3e08a1-d51e-4761-9ff2-53a9be0e6a78', 'String', 'jsonType.label');
INSERT INTO "public"."protocol_mapper_config" VALUES ('77c9e9b1-2e6e-4684-9ea6-e0c62e5efa36', 'clientHost', 'user.session.note');
INSERT INTO "public"."protocol_mapper_config" VALUES ('77c9e9b1-2e6e-4684-9ea6-e0c62e5efa36', 'true', 'id.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('77c9e9b1-2e6e-4684-9ea6-e0c62e5efa36', 'true', 'access.token.claim');
INSERT INTO "public"."protocol_mapper_config" VALUES ('77c9e9b1-2e6e-4684-9ea6-e0c62e5efa36', 'clientHost', 'claim.name');
INSERT INTO "public"."protocol_mapper_config" VALUES ('77c9e9b1-2e6e-4684-9ea6-e0c62e5efa36', 'String', 'jsonType.label');

-- ----------------------------
-- Table structure for realm
-- ----------------------------
DROP TABLE IF EXISTS "public"."realm";
CREATE TABLE "public"."realm" (
  "id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "access_code_lifespan" int4,
  "user_action_lifespan" int4,
  "access_token_lifespan" int4,
  "account_theme" varchar(255) COLLATE "pg_catalog"."default",
  "admin_theme" varchar(255) COLLATE "pg_catalog"."default",
  "email_theme" varchar(255) COLLATE "pg_catalog"."default",
  "enabled" bool NOT NULL DEFAULT false,
  "events_enabled" bool NOT NULL DEFAULT false,
  "events_expiration" int8,
  "login_theme" varchar(255) COLLATE "pg_catalog"."default",
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "not_before" int4,
  "password_policy" varchar(2550) COLLATE "pg_catalog"."default",
  "registration_allowed" bool NOT NULL DEFAULT false,
  "remember_me" bool NOT NULL DEFAULT false,
  "reset_password_allowed" bool NOT NULL DEFAULT false,
  "social" bool NOT NULL DEFAULT false,
  "ssl_required" varchar(255) COLLATE "pg_catalog"."default",
  "sso_idle_timeout" int4,
  "sso_max_lifespan" int4,
  "update_profile_on_soc_login" bool NOT NULL DEFAULT false,
  "verify_email" bool NOT NULL DEFAULT false,
  "master_admin_client" varchar(36) COLLATE "pg_catalog"."default",
  "login_lifespan" int4,
  "internationalization_enabled" bool NOT NULL DEFAULT false,
  "default_locale" varchar(255) COLLATE "pg_catalog"."default",
  "reg_email_as_username" bool NOT NULL DEFAULT false,
  "admin_events_enabled" bool NOT NULL DEFAULT false,
  "admin_events_details_enabled" bool NOT NULL DEFAULT false,
  "edit_username_allowed" bool NOT NULL DEFAULT false,
  "otp_policy_counter" int4 DEFAULT 0,
  "otp_policy_window" int4 DEFAULT 1,
  "otp_policy_period" int4 DEFAULT 30,
  "otp_policy_digits" int4 DEFAULT 6,
  "otp_policy_alg" varchar(36) COLLATE "pg_catalog"."default" DEFAULT 'HmacSHA1'::character varying,
  "otp_policy_type" varchar(36) COLLATE "pg_catalog"."default" DEFAULT 'totp'::character varying,
  "browser_flow" varchar(36) COLLATE "pg_catalog"."default",
  "registration_flow" varchar(36) COLLATE "pg_catalog"."default",
  "direct_grant_flow" varchar(36) COLLATE "pg_catalog"."default",
  "reset_credentials_flow" varchar(36) COLLATE "pg_catalog"."default",
  "client_auth_flow" varchar(36) COLLATE "pg_catalog"."default",
  "offline_session_idle_timeout" int4 DEFAULT 0,
  "revoke_refresh_token" bool NOT NULL DEFAULT false,
  "access_token_life_implicit" int4 DEFAULT 0,
  "login_with_email_allowed" bool NOT NULL DEFAULT true,
  "duplicate_emails_allowed" bool NOT NULL DEFAULT false,
  "docker_auth_flow" varchar(36) COLLATE "pg_catalog"."default",
  "refresh_token_max_reuse" int4 DEFAULT 0,
  "allow_user_managed_access" bool NOT NULL DEFAULT false,
  "sso_max_lifespan_remember_me" int4 NOT NULL DEFAULT 0,
  "sso_idle_timeout_remember_me" int4 NOT NULL DEFAULT 0,
  "default_role" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of realm
-- ----------------------------
INSERT INTO "public"."realm" VALUES ('e668ca58-deb8-459c-9294-39e5e530c03f', 60, 300, 18000, NULL, NULL, NULL, 't', 'f', 0, NULL, 'spring-boot-realm-dev', 0, NULL, 'f', 'f', 'f', 'f', 'EXTERNAL', 1800, 36000, 'f', 'f', 'e91855ac-d4b5-4c39-8aa3-ec0609b98ada', 1800, 'f', NULL, 'f', 'f', 'f', 'f', 0, 1, 30, 6, 'HmacSHA1', 'totp', '4053a918-0053-462d-83e7-415a75f6b1c8', '2e5f802c-a39c-448d-87c0-2969a99732ef', 'd578000c-01c8-41bf-96cd-362ad59e78e7', 'f7549afc-2cd9-4455-acbe-f33593101401', '438fbcb1-15aa-4e7a-86cb-acbee86655bb', 2592000, 'f', 900, 't', 'f', '3d14f447-37e4-4759-a8e3-dd59b4da2f1b', 0, 'f', 0, 0, '35579285-15b3-403c-a636-4c5a2767c90a');
INSERT INTO "public"."realm" VALUES ('2615b5da-5c3b-432f-af31-9af5f519b2a6', 60, 300, 60, NULL, NULL, NULL, 't', 'f', 0, NULL, 'master', 0, NULL, 'f', 'f', 'f', 'f', 'EXTERNAL', 1800, 36000, 'f', 'f', '0f7b7c6e-b419-4d57-a05a-929313247c5b', 1800, 'f', NULL, 'f', 'f', 'f', 'f', 0, 1, 30, 6, 'HmacSHA1', 'totp', 'f9ba9768-3c62-4ef6-8b86-046b40d47cc5', '3fd1a01f-589b-458b-aca1-5aa5159e84ff', '31da6c0f-6efa-4e95-b14b-deac1ba6a735', 'ac953ec0-1e20-456f-9069-61d433213c63', '79b8ae65-8961-45fd-8b80-efc6068046f1', 2592000, 'f', 900, 't', 'f', '634f1375-a975-47c3-8ea9-a25c84ac59b2', 0, 'f', 0, 0, '963f1d10-817e-483b-a520-124cf561b457');

-- ----------------------------
-- Table structure for realm_attribute
-- ----------------------------
DROP TABLE IF EXISTS "public"."realm_attribute";
CREATE TABLE "public"."realm_attribute" (
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "realm_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "value" text COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of realm_attribute
-- ----------------------------
INSERT INTO "public"."realm_attribute" VALUES ('_browser_header.contentSecurityPolicyReportOnly', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '');
INSERT INTO "public"."realm_attribute" VALUES ('_browser_header.xContentTypeOptions', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'nosniff');
INSERT INTO "public"."realm_attribute" VALUES ('_browser_header.referrerPolicy', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'no-referrer');
INSERT INTO "public"."realm_attribute" VALUES ('_browser_header.xRobotsTag', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'none');
INSERT INTO "public"."realm_attribute" VALUES ('_browser_header.xFrameOptions', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'SAMEORIGIN');
INSERT INTO "public"."realm_attribute" VALUES ('_browser_header.contentSecurityPolicy', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'frame-src ''self''; frame-ancestors ''self''; object-src ''none'';');
INSERT INTO "public"."realm_attribute" VALUES ('_browser_header.xXSSProtection', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '1; mode=block');
INSERT INTO "public"."realm_attribute" VALUES ('_browser_header.strictTransportSecurity', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'max-age=31536000; includeSubDomains');
INSERT INTO "public"."realm_attribute" VALUES ('bruteForceProtected', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'false');
INSERT INTO "public"."realm_attribute" VALUES ('permanentLockout', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'false');
INSERT INTO "public"."realm_attribute" VALUES ('maxFailureWaitSeconds', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '900');
INSERT INTO "public"."realm_attribute" VALUES ('minimumQuickLoginWaitSeconds', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '60');
INSERT INTO "public"."realm_attribute" VALUES ('waitIncrementSeconds', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '60');
INSERT INTO "public"."realm_attribute" VALUES ('quickLoginCheckMilliSeconds', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '1000');
INSERT INTO "public"."realm_attribute" VALUES ('maxDeltaTimeSeconds', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '43200');
INSERT INTO "public"."realm_attribute" VALUES ('failureFactor', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '30');
INSERT INTO "public"."realm_attribute" VALUES ('realmReusableOtpCode', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'false');
INSERT INTO "public"."realm_attribute" VALUES ('displayName', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'Keycloak');
INSERT INTO "public"."realm_attribute" VALUES ('displayNameHtml', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '<div class="kc-logo-text"><span>Keycloak</span></div>');
INSERT INTO "public"."realm_attribute" VALUES ('defaultSignatureAlgorithm', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'RS256');
INSERT INTO "public"."realm_attribute" VALUES ('offlineSessionMaxLifespanEnabled', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'false');
INSERT INTO "public"."realm_attribute" VALUES ('offlineSessionMaxLifespan', '2615b5da-5c3b-432f-af31-9af5f519b2a6', '5184000');
INSERT INTO "public"."realm_attribute" VALUES ('realmReusableOtpCode', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'false');
INSERT INTO "public"."realm_attribute" VALUES ('oauth2DeviceCodeLifespan', 'e668ca58-deb8-459c-9294-39e5e530c03f', '600');
INSERT INTO "public"."realm_attribute" VALUES ('oauth2DevicePollingInterval', 'e668ca58-deb8-459c-9294-39e5e530c03f', '5');
INSERT INTO "public"."realm_attribute" VALUES ('cibaBackchannelTokenDeliveryMode', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'poll');
INSERT INTO "public"."realm_attribute" VALUES ('cibaExpiresIn', 'e668ca58-deb8-459c-9294-39e5e530c03f', '120');
INSERT INTO "public"."realm_attribute" VALUES ('cibaInterval', 'e668ca58-deb8-459c-9294-39e5e530c03f', '5');
INSERT INTO "public"."realm_attribute" VALUES ('cibaAuthRequestedUserHint', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'login_hint');
INSERT INTO "public"."realm_attribute" VALUES ('parRequestUriLifespan', 'e668ca58-deb8-459c-9294-39e5e530c03f', '60');
INSERT INTO "public"."realm_attribute" VALUES ('shortVerificationUri', 'e668ca58-deb8-459c-9294-39e5e530c03f', '');
INSERT INTO "public"."realm_attribute" VALUES ('actionTokenGeneratedByUserLifespan-verify-email', 'e668ca58-deb8-459c-9294-39e5e530c03f', '');
INSERT INTO "public"."realm_attribute" VALUES ('actionTokenGeneratedByUserLifespan-idp-verify-account-via-email', 'e668ca58-deb8-459c-9294-39e5e530c03f', '');
INSERT INTO "public"."realm_attribute" VALUES ('actionTokenGeneratedByUserLifespan-reset-credentials', 'e668ca58-deb8-459c-9294-39e5e530c03f', '');
INSERT INTO "public"."realm_attribute" VALUES ('actionTokenGeneratedByUserLifespan-execute-actions', 'e668ca58-deb8-459c-9294-39e5e530c03f', '');
INSERT INTO "public"."realm_attribute" VALUES ('clientSessionIdleTimeout', 'e668ca58-deb8-459c-9294-39e5e530c03f', '0');
INSERT INTO "public"."realm_attribute" VALUES ('clientSessionMaxLifespan', 'e668ca58-deb8-459c-9294-39e5e530c03f', '0');
INSERT INTO "public"."realm_attribute" VALUES ('clientOfflineSessionIdleTimeout', 'e668ca58-deb8-459c-9294-39e5e530c03f', '0');
INSERT INTO "public"."realm_attribute" VALUES ('clientOfflineSessionMaxLifespan', 'e668ca58-deb8-459c-9294-39e5e530c03f', '0');
INSERT INTO "public"."realm_attribute" VALUES ('bruteForceProtected', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'false');
INSERT INTO "public"."realm_attribute" VALUES ('permanentLockout', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'false');
INSERT INTO "public"."realm_attribute" VALUES ('maxFailureWaitSeconds', 'e668ca58-deb8-459c-9294-39e5e530c03f', '900');
INSERT INTO "public"."realm_attribute" VALUES ('minimumQuickLoginWaitSeconds', 'e668ca58-deb8-459c-9294-39e5e530c03f', '60');
INSERT INTO "public"."realm_attribute" VALUES ('waitIncrementSeconds', 'e668ca58-deb8-459c-9294-39e5e530c03f', '60');
INSERT INTO "public"."realm_attribute" VALUES ('quickLoginCheckMilliSeconds', 'e668ca58-deb8-459c-9294-39e5e530c03f', '1000');
INSERT INTO "public"."realm_attribute" VALUES ('maxDeltaTimeSeconds', 'e668ca58-deb8-459c-9294-39e5e530c03f', '43200');
INSERT INTO "public"."realm_attribute" VALUES ('failureFactor', 'e668ca58-deb8-459c-9294-39e5e530c03f', '30');
INSERT INTO "public"."realm_attribute" VALUES ('actionTokenGeneratedByAdminLifespan', 'e668ca58-deb8-459c-9294-39e5e530c03f', '43200');
INSERT INTO "public"."realm_attribute" VALUES ('actionTokenGeneratedByUserLifespan', 'e668ca58-deb8-459c-9294-39e5e530c03f', '18000');
INSERT INTO "public"."realm_attribute" VALUES ('defaultSignatureAlgorithm', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'RS256');
INSERT INTO "public"."realm_attribute" VALUES ('offlineSessionMaxLifespanEnabled', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'false');
INSERT INTO "public"."realm_attribute" VALUES ('offlineSessionMaxLifespan', 'e668ca58-deb8-459c-9294-39e5e530c03f', '5184000');
INSERT INTO "public"."realm_attribute" VALUES ('webAuthnPolicyRpEntityName', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'keycloak');
INSERT INTO "public"."realm_attribute" VALUES ('webAuthnPolicySignatureAlgorithms', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'ES256');
INSERT INTO "public"."realm_attribute" VALUES ('webAuthnPolicyRpId', 'e668ca58-deb8-459c-9294-39e5e530c03f', '');
INSERT INTO "public"."realm_attribute" VALUES ('webAuthnPolicyAttestationConveyancePreference', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'not specified');
INSERT INTO "public"."realm_attribute" VALUES ('webAuthnPolicyAuthenticatorAttachment', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'not specified');
INSERT INTO "public"."realm_attribute" VALUES ('webAuthnPolicyRequireResidentKey', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'not specified');
INSERT INTO "public"."realm_attribute" VALUES ('webAuthnPolicyUserVerificationRequirement', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'not specified');
INSERT INTO "public"."realm_attribute" VALUES ('webAuthnPolicyCreateTimeout', 'e668ca58-deb8-459c-9294-39e5e530c03f', '0');
INSERT INTO "public"."realm_attribute" VALUES ('webAuthnPolicyAvoidSameAuthenticatorRegister', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'false');
INSERT INTO "public"."realm_attribute" VALUES ('webAuthnPolicyRpEntityNamePasswordless', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'keycloak');
INSERT INTO "public"."realm_attribute" VALUES ('webAuthnPolicySignatureAlgorithmsPasswordless', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'ES256');
INSERT INTO "public"."realm_attribute" VALUES ('webAuthnPolicyRpIdPasswordless', 'e668ca58-deb8-459c-9294-39e5e530c03f', '');
INSERT INTO "public"."realm_attribute" VALUES ('webAuthnPolicyAttestationConveyancePreferencePasswordless', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'not specified');
INSERT INTO "public"."realm_attribute" VALUES ('webAuthnPolicyAuthenticatorAttachmentPasswordless', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'not specified');
INSERT INTO "public"."realm_attribute" VALUES ('webAuthnPolicyRequireResidentKeyPasswordless', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'not specified');
INSERT INTO "public"."realm_attribute" VALUES ('webAuthnPolicyUserVerificationRequirementPasswordless', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'not specified');
INSERT INTO "public"."realm_attribute" VALUES ('webAuthnPolicyCreateTimeoutPasswordless', 'e668ca58-deb8-459c-9294-39e5e530c03f', '0');
INSERT INTO "public"."realm_attribute" VALUES ('webAuthnPolicyAvoidSameAuthenticatorRegisterPasswordless', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'false');
INSERT INTO "public"."realm_attribute" VALUES ('client-policies.profiles', 'e668ca58-deb8-459c-9294-39e5e530c03f', '{"profiles":[]}');
INSERT INTO "public"."realm_attribute" VALUES ('client-policies.policies', 'e668ca58-deb8-459c-9294-39e5e530c03f', '{"policies":[]}');
INSERT INTO "public"."realm_attribute" VALUES ('_browser_header.contentSecurityPolicyReportOnly', 'e668ca58-deb8-459c-9294-39e5e530c03f', '');
INSERT INTO "public"."realm_attribute" VALUES ('_browser_header.xContentTypeOptions', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'nosniff');
INSERT INTO "public"."realm_attribute" VALUES ('_browser_header.referrerPolicy', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'no-referrer');
INSERT INTO "public"."realm_attribute" VALUES ('_browser_header.xRobotsTag', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'none');
INSERT INTO "public"."realm_attribute" VALUES ('_browser_header.xFrameOptions', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'SAMEORIGIN');
INSERT INTO "public"."realm_attribute" VALUES ('_browser_header.contentSecurityPolicy', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'frame-src ''self''; frame-ancestors ''self''; object-src ''none'';');
INSERT INTO "public"."realm_attribute" VALUES ('_browser_header.xXSSProtection', 'e668ca58-deb8-459c-9294-39e5e530c03f', '1; mode=block');
INSERT INTO "public"."realm_attribute" VALUES ('_browser_header.strictTransportSecurity', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'max-age=31536000; includeSubDomains');

-- ----------------------------
-- Table structure for realm_default_groups
-- ----------------------------
DROP TABLE IF EXISTS "public"."realm_default_groups";
CREATE TABLE "public"."realm_default_groups" (
  "realm_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "group_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of realm_default_groups
-- ----------------------------

-- ----------------------------
-- Table structure for realm_enabled_event_types
-- ----------------------------
DROP TABLE IF EXISTS "public"."realm_enabled_event_types";
CREATE TABLE "public"."realm_enabled_event_types" (
  "realm_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "value" varchar(255) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of realm_enabled_event_types
-- ----------------------------

-- ----------------------------
-- Table structure for realm_events_listeners
-- ----------------------------
DROP TABLE IF EXISTS "public"."realm_events_listeners";
CREATE TABLE "public"."realm_events_listeners" (
  "realm_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "value" varchar(255) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of realm_events_listeners
-- ----------------------------
INSERT INTO "public"."realm_events_listeners" VALUES ('2615b5da-5c3b-432f-af31-9af5f519b2a6', 'jboss-logging');
INSERT INTO "public"."realm_events_listeners" VALUES ('e668ca58-deb8-459c-9294-39e5e530c03f', 'jboss-logging');

-- ----------------------------
-- Table structure for realm_localizations
-- ----------------------------
DROP TABLE IF EXISTS "public"."realm_localizations";
CREATE TABLE "public"."realm_localizations" (
  "realm_id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "locale" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "texts" text COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of realm_localizations
-- ----------------------------

-- ----------------------------
-- Table structure for realm_required_credential
-- ----------------------------
DROP TABLE IF EXISTS "public"."realm_required_credential";
CREATE TABLE "public"."realm_required_credential" (
  "type" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "form_label" varchar(255) COLLATE "pg_catalog"."default",
  "input" bool NOT NULL DEFAULT false,
  "secret" bool NOT NULL DEFAULT false,
  "realm_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of realm_required_credential
-- ----------------------------
INSERT INTO "public"."realm_required_credential" VALUES ('password', 'password', 't', 't', '2615b5da-5c3b-432f-af31-9af5f519b2a6');
INSERT INTO "public"."realm_required_credential" VALUES ('password', 'password', 't', 't', 'e668ca58-deb8-459c-9294-39e5e530c03f');

-- ----------------------------
-- Table structure for realm_smtp_config
-- ----------------------------
DROP TABLE IF EXISTS "public"."realm_smtp_config";
CREATE TABLE "public"."realm_smtp_config" (
  "realm_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "value" varchar(255) COLLATE "pg_catalog"."default",
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of realm_smtp_config
-- ----------------------------

-- ----------------------------
-- Table structure for realm_supported_locales
-- ----------------------------
DROP TABLE IF EXISTS "public"."realm_supported_locales";
CREATE TABLE "public"."realm_supported_locales" (
  "realm_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "value" varchar(255) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of realm_supported_locales
-- ----------------------------

-- ----------------------------
-- Table structure for redirect_uris
-- ----------------------------
DROP TABLE IF EXISTS "public"."redirect_uris";
CREATE TABLE "public"."redirect_uris" (
  "client_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "value" varchar(255) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of redirect_uris
-- ----------------------------
INSERT INTO "public"."redirect_uris" VALUES ('ad3b314e-5403-45ee-b31e-aa88e47b7933', '/realms/master/account/*');
INSERT INTO "public"."redirect_uris" VALUES ('1418f9d8-877d-4a16-a0c7-05f2bac8f4e4', '/realms/master/account/*');
INSERT INTO "public"."redirect_uris" VALUES ('e0f7d215-09a8-426a-83d3-b159f75c1d63', '/admin/master/console/*');
INSERT INTO "public"."redirect_uris" VALUES ('51f2891f-9f5a-4054-8823-3627b06e3e5b', '/realms/spring-boot-realm-dev/account/*');
INSERT INTO "public"."redirect_uris" VALUES ('aa5445f5-a056-46f7-97e8-7d5fe2ab4453', '/realms/spring-boot-realm-dev/account/*');
INSERT INTO "public"."redirect_uris" VALUES ('7b5fba19-edfe-4208-af18-4eba02c6d1fd', '/admin/spring-boot-realm-dev/console/*');
INSERT INTO "public"."redirect_uris" VALUES ('013f7a7e-a923-44dc-bf06-12f9d50a38c3', 'http://localhost:8182/*');
INSERT INTO "public"."redirect_uris" VALUES ('ab045118-6511-45fb-93d5-e6bcd83aa04f', '/*');

-- ----------------------------
-- Table structure for required_action_config
-- ----------------------------
DROP TABLE IF EXISTS "public"."required_action_config";
CREATE TABLE "public"."required_action_config" (
  "required_action_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "value" text COLLATE "pg_catalog"."default",
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of required_action_config
-- ----------------------------

-- ----------------------------
-- Table structure for required_action_provider
-- ----------------------------
DROP TABLE IF EXISTS "public"."required_action_provider";
CREATE TABLE "public"."required_action_provider" (
  "id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "alias" varchar(255) COLLATE "pg_catalog"."default",
  "name" varchar(255) COLLATE "pg_catalog"."default",
  "realm_id" varchar(36) COLLATE "pg_catalog"."default",
  "enabled" bool NOT NULL DEFAULT false,
  "default_action" bool NOT NULL DEFAULT false,
  "provider_id" varchar(255) COLLATE "pg_catalog"."default",
  "priority" int4
)
;

-- ----------------------------
-- Records of required_action_provider
-- ----------------------------
INSERT INTO "public"."required_action_provider" VALUES ('ad8a3730-2c05-4301-81e7-9de4758ad1a9', 'VERIFY_EMAIL', 'Verify Email', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 't', 'f', 'VERIFY_EMAIL', 50);
INSERT INTO "public"."required_action_provider" VALUES ('ab7582a6-e88e-4b52-94ab-03774fcf51a6', 'UPDATE_PROFILE', 'Update Profile', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 't', 'f', 'UPDATE_PROFILE', 40);
INSERT INTO "public"."required_action_provider" VALUES ('a4ef65c2-72e4-4317-82de-b539548b4c69', 'CONFIGURE_TOTP', 'Configure OTP', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 't', 'f', 'CONFIGURE_TOTP', 10);
INSERT INTO "public"."required_action_provider" VALUES ('8d865dcb-4500-402c-8a45-7898add7d8a9', 'UPDATE_PASSWORD', 'Update Password', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 't', 'f', 'UPDATE_PASSWORD', 30);
INSERT INTO "public"."required_action_provider" VALUES ('fd225f92-4750-4f87-ae6c-3e425727dce6', 'TERMS_AND_CONDITIONS', 'Terms and Conditions', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'f', 'f', 'TERMS_AND_CONDITIONS', 20);
INSERT INTO "public"."required_action_provider" VALUES ('d26cb026-f65e-4095-b9c5-53e82531c92a', 'delete_account', 'Delete Account', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'f', 'f', 'delete_account', 60);
INSERT INTO "public"."required_action_provider" VALUES ('52e2bb3a-057c-4d7c-a5b9-f69e928d34cc', 'update_user_locale', 'Update User Locale', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 't', 'f', 'update_user_locale', 1000);
INSERT INTO "public"."required_action_provider" VALUES ('733fa225-d0c5-438e-8042-c05fb00a2cc4', 'webauthn-register', 'Webauthn Register', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 't', 'f', 'webauthn-register', 70);
INSERT INTO "public"."required_action_provider" VALUES ('541d89a5-0027-4c87-827a-d68421ec9d32', 'webauthn-register-passwordless', 'Webauthn Register Passwordless', '2615b5da-5c3b-432f-af31-9af5f519b2a6', 't', 'f', 'webauthn-register-passwordless', 80);
INSERT INTO "public"."required_action_provider" VALUES ('f74c342f-4ef7-40a5-9c75-355f5ec89a00', 'VERIFY_EMAIL', 'Verify Email', 'e668ca58-deb8-459c-9294-39e5e530c03f', 't', 'f', 'VERIFY_EMAIL', 50);
INSERT INTO "public"."required_action_provider" VALUES ('a71139b4-600a-4d88-b841-848f05264213', 'UPDATE_PROFILE', 'Update Profile', 'e668ca58-deb8-459c-9294-39e5e530c03f', 't', 'f', 'UPDATE_PROFILE', 40);
INSERT INTO "public"."required_action_provider" VALUES ('4993e854-7326-46ad-a4ad-62d7db766d66', 'CONFIGURE_TOTP', 'Configure OTP', 'e668ca58-deb8-459c-9294-39e5e530c03f', 't', 'f', 'CONFIGURE_TOTP', 10);
INSERT INTO "public"."required_action_provider" VALUES ('2d67843e-c029-42e2-829c-1f94046eeabc', 'UPDATE_PASSWORD', 'Update Password', 'e668ca58-deb8-459c-9294-39e5e530c03f', 't', 'f', 'UPDATE_PASSWORD', 30);
INSERT INTO "public"."required_action_provider" VALUES ('2ed77560-0e33-4bb7-a450-a02bbec85d19', 'TERMS_AND_CONDITIONS', 'Terms and Conditions', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'f', 'f', 'TERMS_AND_CONDITIONS', 20);
INSERT INTO "public"."required_action_provider" VALUES ('e1eaae28-7038-4e85-9865-d5b02d372c5b', 'delete_account', 'Delete Account', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'f', 'f', 'delete_account', 60);
INSERT INTO "public"."required_action_provider" VALUES ('fbe19d4f-daeb-4508-aa82-189784973bb5', 'update_user_locale', 'Update User Locale', 'e668ca58-deb8-459c-9294-39e5e530c03f', 't', 'f', 'update_user_locale', 1000);
INSERT INTO "public"."required_action_provider" VALUES ('20908e96-d0f7-41f0-ac5c-9b5ab49e5177', 'webauthn-register', 'Webauthn Register', 'e668ca58-deb8-459c-9294-39e5e530c03f', 't', 'f', 'webauthn-register', 70);
INSERT INTO "public"."required_action_provider" VALUES ('ab151bc7-5f25-4892-b7bc-3e04286e933e', 'webauthn-register-passwordless', 'Webauthn Register Passwordless', 'e668ca58-deb8-459c-9294-39e5e530c03f', 't', 'f', 'webauthn-register-passwordless', 80);

-- ----------------------------
-- Table structure for resource_attribute
-- ----------------------------
DROP TABLE IF EXISTS "public"."resource_attribute";
CREATE TABLE "public"."resource_attribute" (
  "id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'sybase-needs-something-here'::character varying,
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "value" varchar(255) COLLATE "pg_catalog"."default",
  "resource_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of resource_attribute
-- ----------------------------

-- ----------------------------
-- Table structure for resource_policy
-- ----------------------------
DROP TABLE IF EXISTS "public"."resource_policy";
CREATE TABLE "public"."resource_policy" (
  "resource_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "policy_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of resource_policy
-- ----------------------------
INSERT INTO "public"."resource_policy" VALUES ('1663e499-add0-4c4b-a764-e3b3f1cadfe2', '87efea1a-01ea-44f2-b473-012a1c846dad');
INSERT INTO "public"."resource_policy" VALUES ('2ec07e8f-94a2-4b6e-824c-27196ea66789', '975f2b8c-344a-4e00-9a6d-de34e2675854');

-- ----------------------------
-- Table structure for resource_scope
-- ----------------------------
DROP TABLE IF EXISTS "public"."resource_scope";
CREATE TABLE "public"."resource_scope" (
  "resource_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "scope_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of resource_scope
-- ----------------------------
INSERT INTO "public"."resource_scope" VALUES ('1663e499-add0-4c4b-a764-e3b3f1cadfe2', '1d252b93-e258-4f5b-8c84-b9e80a8e976e');
INSERT INTO "public"."resource_scope" VALUES ('2ec07e8f-94a2-4b6e-824c-27196ea66789', '1d252b93-e258-4f5b-8c84-b9e80a8e976e');

-- ----------------------------
-- Table structure for resource_server
-- ----------------------------
DROP TABLE IF EXISTS "public"."resource_server";
CREATE TABLE "public"."resource_server" (
  "id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "allow_rs_remote_mgmt" bool NOT NULL DEFAULT false,
  "policy_enforce_mode" int2 NOT NULL,
  "decision_strategy" int2 NOT NULL DEFAULT 1
)
;

-- ----------------------------
-- Records of resource_server
-- ----------------------------
INSERT INTO "public"."resource_server" VALUES ('20d9416e-0e2d-48d3-bfff-f256d60cc99c', 'f', 0, 1);

-- ----------------------------
-- Table structure for resource_server_perm_ticket
-- ----------------------------
DROP TABLE IF EXISTS "public"."resource_server_perm_ticket";
CREATE TABLE "public"."resource_server_perm_ticket" (
  "id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "owner" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "requester" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "created_timestamp" int8 NOT NULL,
  "granted_timestamp" int8,
  "resource_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "scope_id" varchar(36) COLLATE "pg_catalog"."default",
  "resource_server_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "policy_id" varchar(36) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of resource_server_perm_ticket
-- ----------------------------

-- ----------------------------
-- Table structure for resource_server_policy
-- ----------------------------
DROP TABLE IF EXISTS "public"."resource_server_policy";
CREATE TABLE "public"."resource_server_policy" (
  "id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "description" varchar(255) COLLATE "pg_catalog"."default",
  "type" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "decision_strategy" int2,
  "logic" int2,
  "resource_server_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "owner" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of resource_server_policy
-- ----------------------------
INSERT INTO "public"."resource_server_policy" VALUES ('87efea1a-01ea-44f2-b473-012a1c846dad', 'token-exchange.permission.idp.054ae052-c162-486a-b29b-6d4297088a9c', '', 'scope', 1, 0, '20d9416e-0e2d-48d3-bfff-f256d60cc99c', NULL);
INSERT INTO "public"."resource_server_policy" VALUES ('1bb684a2-4982-49d3-bddf-49f26f1cc901', 'google-token-exchange', '', 'client', 1, 0, '20d9416e-0e2d-48d3-bfff-f256d60cc99c', NULL);
INSERT INTO "public"."resource_server_policy" VALUES ('e1a403f3-c854-4ceb-a018-2b27daf79b0f', 'microsoft-token-exchange', '', 'client', 1, 0, '20d9416e-0e2d-48d3-bfff-f256d60cc99c', NULL);
INSERT INTO "public"."resource_server_policy" VALUES ('975f2b8c-344a-4e00-9a6d-de34e2675854', 'token-exchange.permission.idp.583acf5e-efa5-490f-bf2a-96af3f7ed70a', '', 'scope', 1, 0, '20d9416e-0e2d-48d3-bfff-f256d60cc99c', NULL);

-- ----------------------------
-- Table structure for resource_server_resource
-- ----------------------------
DROP TABLE IF EXISTS "public"."resource_server_resource";
CREATE TABLE "public"."resource_server_resource" (
  "id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "type" varchar(255) COLLATE "pg_catalog"."default",
  "icon_uri" varchar(255) COLLATE "pg_catalog"."default",
  "owner" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "resource_server_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "owner_managed_access" bool NOT NULL DEFAULT false,
  "display_name" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of resource_server_resource
-- ----------------------------
INSERT INTO "public"."resource_server_resource" VALUES ('1663e499-add0-4c4b-a764-e3b3f1cadfe2', 'idp.resource.054ae052-c162-486a-b29b-6d4297088a9c', 'IdentityProvider', NULL, '20d9416e-0e2d-48d3-bfff-f256d60cc99c', '20d9416e-0e2d-48d3-bfff-f256d60cc99c', 'f', NULL);
INSERT INTO "public"."resource_server_resource" VALUES ('2ec07e8f-94a2-4b6e-824c-27196ea66789', 'idp.resource.583acf5e-efa5-490f-bf2a-96af3f7ed70a', 'IdentityProvider', NULL, '20d9416e-0e2d-48d3-bfff-f256d60cc99c', '20d9416e-0e2d-48d3-bfff-f256d60cc99c', 'f', NULL);

-- ----------------------------
-- Table structure for resource_server_scope
-- ----------------------------
DROP TABLE IF EXISTS "public"."resource_server_scope";
CREATE TABLE "public"."resource_server_scope" (
  "id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "icon_uri" varchar(255) COLLATE "pg_catalog"."default",
  "resource_server_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "display_name" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of resource_server_scope
-- ----------------------------
INSERT INTO "public"."resource_server_scope" VALUES ('1d252b93-e258-4f5b-8c84-b9e80a8e976e', 'token-exchange', NULL, '20d9416e-0e2d-48d3-bfff-f256d60cc99c', NULL);

-- ----------------------------
-- Table structure for resource_uris
-- ----------------------------
DROP TABLE IF EXISTS "public"."resource_uris";
CREATE TABLE "public"."resource_uris" (
  "resource_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "value" varchar(255) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of resource_uris
-- ----------------------------

-- ----------------------------
-- Table structure for role_attribute
-- ----------------------------
DROP TABLE IF EXISTS "public"."role_attribute";
CREATE TABLE "public"."role_attribute" (
  "id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "role_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "value" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of role_attribute
-- ----------------------------

-- ----------------------------
-- Table structure for scope_mapping
-- ----------------------------
DROP TABLE IF EXISTS "public"."scope_mapping";
CREATE TABLE "public"."scope_mapping" (
  "client_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "role_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of scope_mapping
-- ----------------------------
INSERT INTO "public"."scope_mapping" VALUES ('1418f9d8-877d-4a16-a0c7-05f2bac8f4e4', '5145a956-bd72-4410-a888-f52908ff8de6');
INSERT INTO "public"."scope_mapping" VALUES ('1418f9d8-877d-4a16-a0c7-05f2bac8f4e4', '0c3cf22b-0b87-410a-a921-12886a232e70');
INSERT INTO "public"."scope_mapping" VALUES ('aa5445f5-a056-46f7-97e8-7d5fe2ab4453', '05027f7e-0390-47f2-a3a3-ca33d49beac6');
INSERT INTO "public"."scope_mapping" VALUES ('aa5445f5-a056-46f7-97e8-7d5fe2ab4453', 'daa24dc6-dcfd-4c98-a09e-9a70ade11357');

-- ----------------------------
-- Table structure for scope_policy
-- ----------------------------
DROP TABLE IF EXISTS "public"."scope_policy";
CREATE TABLE "public"."scope_policy" (
  "scope_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "policy_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of scope_policy
-- ----------------------------
INSERT INTO "public"."scope_policy" VALUES ('1d252b93-e258-4f5b-8c84-b9e80a8e976e', '87efea1a-01ea-44f2-b473-012a1c846dad');
INSERT INTO "public"."scope_policy" VALUES ('1d252b93-e258-4f5b-8c84-b9e80a8e976e', '975f2b8c-344a-4e00-9a6d-de34e2675854');

-- ----------------------------
-- Table structure for user_attribute
-- ----------------------------
DROP TABLE IF EXISTS "public"."user_attribute";
CREATE TABLE "public"."user_attribute" (
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "value" varchar(255) COLLATE "pg_catalog"."default",
  "user_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL DEFAULT 'sybase-needs-something-here'::character varying
)
;

-- ----------------------------
-- Records of user_attribute
-- ----------------------------

-- ----------------------------
-- Table structure for user_consent
-- ----------------------------
DROP TABLE IF EXISTS "public"."user_consent";
CREATE TABLE "public"."user_consent" (
  "id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "client_id" varchar(255) COLLATE "pg_catalog"."default",
  "user_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "created_date" int8,
  "last_updated_date" int8,
  "client_storage_provider" varchar(36) COLLATE "pg_catalog"."default",
  "external_client_id" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of user_consent
-- ----------------------------

-- ----------------------------
-- Table structure for user_consent_client_scope
-- ----------------------------
DROP TABLE IF EXISTS "public"."user_consent_client_scope";
CREATE TABLE "public"."user_consent_client_scope" (
  "user_consent_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "scope_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of user_consent_client_scope
-- ----------------------------

-- ----------------------------
-- Table structure for user_entity
-- ----------------------------
DROP TABLE IF EXISTS "public"."user_entity";
CREATE TABLE "public"."user_entity" (
  "id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "email" varchar(255) COLLATE "pg_catalog"."default",
  "email_constraint" varchar(255) COLLATE "pg_catalog"."default",
  "email_verified" bool NOT NULL DEFAULT false,
  "enabled" bool NOT NULL DEFAULT false,
  "federation_link" varchar(255) COLLATE "pg_catalog"."default",
  "first_name" varchar(255) COLLATE "pg_catalog"."default",
  "last_name" varchar(255) COLLATE "pg_catalog"."default",
  "realm_id" varchar(255) COLLATE "pg_catalog"."default",
  "username" varchar(255) COLLATE "pg_catalog"."default",
  "created_timestamp" int8,
  "service_account_client_link" varchar(255) COLLATE "pg_catalog"."default",
  "not_before" int4 NOT NULL DEFAULT 0
)
;

-- ----------------------------
-- Records of user_entity
-- ----------------------------
INSERT INTO "public"."user_entity" VALUES ('c823ecac-ca19-4dd8-959e-83dc4c4ab3f7', NULL, '86ca6c50-c2de-465d-b526-2ae3a5c2678f', 'f', 't', NULL, NULL, NULL, '2615b5da-5c3b-432f-af31-9af5f519b2a6', 'admin', 1715777598280, NULL, 0);
INSERT INTO "public"."user_entity" VALUES ('f7fe4331-157c-4c8d-8d63-9182aede34b9', NULL, '25e4c095-3213-4ebd-aa0e-296c680115f3', 'f', 't', NULL, NULL, NULL, 'e668ca58-deb8-459c-9294-39e5e530c03f', 'service-account-spring-client-api-rest', 1715777662556, '013f7a7e-a923-44dc-bf06-12f9d50a38c3', 0);
INSERT INTO "public"."user_entity" VALUES ('85b4e63c-fcbd-497a-8edc-0a14014c6cc3', NULL, '08b13326-65b7-49bc-ab11-42abf9ac9570', 'f', 't', NULL, NULL, NULL, 'e668ca58-deb8-459c-9294-39e5e530c03f', 'service-account-admin-cli', 1715777741369, '39132819-80be-4746-861d-ce870d61b7c1', 0);
INSERT INTO "public"."user_entity" VALUES ('7ad37931-d638-4de4-b5c3-6fcd3f447285', 'nguyenquoctuan385@gmail.com', 'nguyenquoctuan385@gmail.com', 'f', 't', NULL, 'Tuấn', 'Nguyễn Quốc', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'nguyenquoctuan385@gmail.com', 1715777892428, NULL, 0);
INSERT INTO "public"."user_entity" VALUES ('e8a1f677-0c79-4dee-9993-c6e392d6c00a', 'dcthong852@gmail.com', 'dcthong852@gmail.com', 'f', 't', NULL, 'Duong', 'Thong', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'dcthong852@gmail.com', 1715777957931, NULL, 0);
INSERT INTO "public"."user_entity" VALUES ('1a1d2bc4-1235-433a-b00e-bbff136a4195', NULL, 'ab1d9865-55f9-468b-8acd-3a56099c7a69', 'f', 't', NULL, 'admin', '', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'admin', 1716007047975, NULL, 0);
INSERT INTO "public"."user_entity" VALUES ('e554a98a-0c8e-434c-ad16-1b3e10a7d518', 'tgtien852@gmail.com', 'tgtien852@gmail.com', 'f', 't', NULL, 'Tien', 'Truong', 'e668ca58-deb8-459c-9294-39e5e530c03f', 'tgtien852@gmail.com', 1716296452101, NULL, 0);

-- ----------------------------
-- Table structure for user_federation_config
-- ----------------------------
DROP TABLE IF EXISTS "public"."user_federation_config";
CREATE TABLE "public"."user_federation_config" (
  "user_federation_provider_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "value" varchar(255) COLLATE "pg_catalog"."default",
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of user_federation_config
-- ----------------------------

-- ----------------------------
-- Table structure for user_federation_mapper
-- ----------------------------
DROP TABLE IF EXISTS "public"."user_federation_mapper";
CREATE TABLE "public"."user_federation_mapper" (
  "id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "federation_provider_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "federation_mapper_type" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "realm_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of user_federation_mapper
-- ----------------------------

-- ----------------------------
-- Table structure for user_federation_mapper_config
-- ----------------------------
DROP TABLE IF EXISTS "public"."user_federation_mapper_config";
CREATE TABLE "public"."user_federation_mapper_config" (
  "user_federation_mapper_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "value" varchar(255) COLLATE "pg_catalog"."default",
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of user_federation_mapper_config
-- ----------------------------

-- ----------------------------
-- Table structure for user_federation_provider
-- ----------------------------
DROP TABLE IF EXISTS "public"."user_federation_provider";
CREATE TABLE "public"."user_federation_provider" (
  "id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "changed_sync_period" int4,
  "display_name" varchar(255) COLLATE "pg_catalog"."default",
  "full_sync_period" int4,
  "last_sync" int4,
  "priority" int4,
  "provider_name" varchar(255) COLLATE "pg_catalog"."default",
  "realm_id" varchar(36) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of user_federation_provider
-- ----------------------------

-- ----------------------------
-- Table structure for user_group_membership
-- ----------------------------
DROP TABLE IF EXISTS "public"."user_group_membership";
CREATE TABLE "public"."user_group_membership" (
  "group_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "user_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of user_group_membership
-- ----------------------------

-- ----------------------------
-- Table structure for user_required_action
-- ----------------------------
DROP TABLE IF EXISTS "public"."user_required_action";
CREATE TABLE "public"."user_required_action" (
  "user_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "required_action" varchar(255) COLLATE "pg_catalog"."default" NOT NULL DEFAULT ' '::character varying
)
;

-- ----------------------------
-- Records of user_required_action
-- ----------------------------

-- ----------------------------
-- Table structure for user_role_mapping
-- ----------------------------
DROP TABLE IF EXISTS "public"."user_role_mapping";
CREATE TABLE "public"."user_role_mapping" (
  "role_id" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "user_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of user_role_mapping
-- ----------------------------
INSERT INTO "public"."user_role_mapping" VALUES ('963f1d10-817e-483b-a520-124cf561b457', 'c823ecac-ca19-4dd8-959e-83dc4c4ab3f7');
INSERT INTO "public"."user_role_mapping" VALUES ('65fc0149-3019-478a-9f89-1070902d30ac', 'c823ecac-ca19-4dd8-959e-83dc4c4ab3f7');
INSERT INTO "public"."user_role_mapping" VALUES ('0988e974-2024-41e5-8c32-508b22b973b0', 'c823ecac-ca19-4dd8-959e-83dc4c4ab3f7');
INSERT INTO "public"."user_role_mapping" VALUES ('6e458f60-7b19-4acb-9c96-899fd2026f67', 'c823ecac-ca19-4dd8-959e-83dc4c4ab3f7');
INSERT INTO "public"."user_role_mapping" VALUES ('2e2ddcaa-14dd-481f-8e63-f0e3f0a21e9b', 'c823ecac-ca19-4dd8-959e-83dc4c4ab3f7');
INSERT INTO "public"."user_role_mapping" VALUES ('93a07816-81e8-476f-b19c-7ce5a57972e3', 'c823ecac-ca19-4dd8-959e-83dc4c4ab3f7');
INSERT INTO "public"."user_role_mapping" VALUES ('763fd871-95d0-4ed0-ad62-b42563d77605', 'c823ecac-ca19-4dd8-959e-83dc4c4ab3f7');
INSERT INTO "public"."user_role_mapping" VALUES ('971cc95b-cf7f-4d82-9173-74beb2e01f59', 'c823ecac-ca19-4dd8-959e-83dc4c4ab3f7');
INSERT INTO "public"."user_role_mapping" VALUES ('d7e8380f-4dc7-42b1-8fd2-db7c7bc5e9b5', 'c823ecac-ca19-4dd8-959e-83dc4c4ab3f7');
INSERT INTO "public"."user_role_mapping" VALUES ('23fa0bb9-de2b-4b87-9221-56bdb0c02528', 'c823ecac-ca19-4dd8-959e-83dc4c4ab3f7');
INSERT INTO "public"."user_role_mapping" VALUES ('fb2aef97-2fea-4b05-a30a-d72cebe38449', 'c823ecac-ca19-4dd8-959e-83dc4c4ab3f7');
INSERT INTO "public"."user_role_mapping" VALUES ('07352222-5b9f-4889-876a-abbf96e05f05', 'c823ecac-ca19-4dd8-959e-83dc4c4ab3f7');
INSERT INTO "public"."user_role_mapping" VALUES ('5678a1aa-2183-411d-baf8-1cb77285b1c4', 'c823ecac-ca19-4dd8-959e-83dc4c4ab3f7');
INSERT INTO "public"."user_role_mapping" VALUES ('a25c6703-4bb9-489c-ac50-a238b75e8ad8', 'c823ecac-ca19-4dd8-959e-83dc4c4ab3f7');
INSERT INTO "public"."user_role_mapping" VALUES ('a78d4052-4e7b-47b4-b13a-ca3f081055e8', 'c823ecac-ca19-4dd8-959e-83dc4c4ab3f7');
INSERT INTO "public"."user_role_mapping" VALUES ('271780ee-beec-4b7f-ba91-95e2c96590a6', 'c823ecac-ca19-4dd8-959e-83dc4c4ab3f7');
INSERT INTO "public"."user_role_mapping" VALUES ('d53b666e-d916-4e44-898b-2562385af3e4', 'c823ecac-ca19-4dd8-959e-83dc4c4ab3f7');
INSERT INTO "public"."user_role_mapping" VALUES ('696b5770-ceef-420f-aff4-6f9018dd4d96', 'c823ecac-ca19-4dd8-959e-83dc4c4ab3f7');
INSERT INTO "public"."user_role_mapping" VALUES ('dcbc2317-ac1e-4599-875b-232717dde80d', 'c823ecac-ca19-4dd8-959e-83dc4c4ab3f7');
INSERT INTO "public"."user_role_mapping" VALUES ('35579285-15b3-403c-a636-4c5a2767c90a', 'f7fe4331-157c-4c8d-8d63-9182aede34b9');
INSERT INTO "public"."user_role_mapping" VALUES ('147e24ee-88a1-47ab-8a7e-33e00d538f25', '7ad37931-d638-4de4-b5c3-6fcd3f447285');
INSERT INTO "public"."user_role_mapping" VALUES ('147e24ee-88a1-47ab-8a7e-33e00d538f25', 'e8a1f677-0c79-4dee-9993-c6e392d6c00a');
INSERT INTO "public"."user_role_mapping" VALUES ('c9e89928-e6ee-4d03-b954-06dc4f53afc0', 'f7fe4331-157c-4c8d-8d63-9182aede34b9');
INSERT INTO "public"."user_role_mapping" VALUES ('b63687c2-e689-4c46-852f-a2e0698d834b', '1a1d2bc4-1235-433a-b00e-bbff136a4195');
INSERT INTO "public"."user_role_mapping" VALUES ('35579285-15b3-403c-a636-4c5a2767c90a', 'e554a98a-0c8e-434c-ad16-1b3e10a7d518');
INSERT INTO "public"."user_role_mapping" VALUES ('2499f3ff-56d8-465e-bda8-485e7f87e9fe', 'e554a98a-0c8e-434c-ad16-1b3e10a7d518');

-- ----------------------------
-- Table structure for user_session
-- ----------------------------
DROP TABLE IF EXISTS "public"."user_session";
CREATE TABLE "public"."user_session" (
  "id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "auth_method" varchar(255) COLLATE "pg_catalog"."default",
  "ip_address" varchar(255) COLLATE "pg_catalog"."default",
  "last_session_refresh" int4,
  "login_username" varchar(255) COLLATE "pg_catalog"."default",
  "realm_id" varchar(255) COLLATE "pg_catalog"."default",
  "remember_me" bool NOT NULL DEFAULT false,
  "started" int4,
  "user_id" varchar(255) COLLATE "pg_catalog"."default",
  "user_session_state" int4,
  "broker_session_id" varchar(255) COLLATE "pg_catalog"."default",
  "broker_user_id" varchar(255) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of user_session
-- ----------------------------

-- ----------------------------
-- Table structure for user_session_note
-- ----------------------------
DROP TABLE IF EXISTS "public"."user_session_note";
CREATE TABLE "public"."user_session_note" (
  "user_session" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "name" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "value" varchar(2048) COLLATE "pg_catalog"."default"
)
;

-- ----------------------------
-- Records of user_session_note
-- ----------------------------

-- ----------------------------
-- Table structure for username_login_failure
-- ----------------------------
DROP TABLE IF EXISTS "public"."username_login_failure";
CREATE TABLE "public"."username_login_failure" (
  "realm_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "username" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "failed_login_not_before" int4,
  "last_failure" int8,
  "last_ip_failure" varchar(255) COLLATE "pg_catalog"."default",
  "num_failures" int4
)
;

-- ----------------------------
-- Records of username_login_failure
-- ----------------------------

-- ----------------------------
-- Table structure for web_origins
-- ----------------------------
DROP TABLE IF EXISTS "public"."web_origins";
CREATE TABLE "public"."web_origins" (
  "client_id" varchar(36) COLLATE "pg_catalog"."default" NOT NULL,
  "value" varchar(255) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of web_origins
-- ----------------------------
INSERT INTO "public"."web_origins" VALUES ('e0f7d215-09a8-426a-83d3-b159f75c1d63', '+');
INSERT INTO "public"."web_origins" VALUES ('7b5fba19-edfe-4208-af18-4eba02c6d1fd', '+');
INSERT INTO "public"."web_origins" VALUES ('013f7a7e-a923-44dc-bf06-12f9d50a38c3', '*');
INSERT INTO "public"."web_origins" VALUES ('ab045118-6511-45fb-93d5-e6bcd83aa04f', '/*');

-- ----------------------------
-- Indexes structure for table admin_event_entity
-- ----------------------------
CREATE INDEX "idx_admin_event_time" ON "public"."admin_event_entity" USING btree (
  "realm_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "admin_event_time" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table admin_event_entity
-- ----------------------------
ALTER TABLE "public"."admin_event_entity" ADD CONSTRAINT "constraint_admin_event_entity" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table associated_policy
-- ----------------------------
CREATE INDEX "idx_assoc_pol_assoc_pol_id" ON "public"."associated_policy" USING btree (
  "associated_policy_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table associated_policy
-- ----------------------------
ALTER TABLE "public"."associated_policy" ADD CONSTRAINT "constraint_farsrpap" PRIMARY KEY ("policy_id", "associated_policy_id");

-- ----------------------------
-- Indexes structure for table authentication_execution
-- ----------------------------
CREATE INDEX "idx_auth_exec_flow" ON "public"."authentication_execution" USING btree (
  "flow_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_auth_exec_realm_flow" ON "public"."authentication_execution" USING btree (
  "realm_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "flow_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table authentication_execution
-- ----------------------------
ALTER TABLE "public"."authentication_execution" ADD CONSTRAINT "constraint_auth_exec_pk" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table authentication_flow
-- ----------------------------
CREATE INDEX "idx_auth_flow_realm" ON "public"."authentication_flow" USING btree (
  "realm_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table authentication_flow
-- ----------------------------
ALTER TABLE "public"."authentication_flow" ADD CONSTRAINT "constraint_auth_flow_pk" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table authenticator_config
-- ----------------------------
CREATE INDEX "idx_auth_config_realm" ON "public"."authenticator_config" USING btree (
  "realm_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table authenticator_config
-- ----------------------------
ALTER TABLE "public"."authenticator_config" ADD CONSTRAINT "constraint_auth_pk" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table authenticator_config_entry
-- ----------------------------
ALTER TABLE "public"."authenticator_config_entry" ADD CONSTRAINT "constraint_auth_cfg_pk" PRIMARY KEY ("authenticator_id", "name");

-- ----------------------------
-- Primary Key structure for table broker_link
-- ----------------------------
ALTER TABLE "public"."broker_link" ADD CONSTRAINT "constr_broker_link_pk" PRIMARY KEY ("identity_provider", "user_id");

-- ----------------------------
-- Indexes structure for table client
-- ----------------------------
CREATE INDEX "idx_client_id" ON "public"."client" USING btree (
  "client_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Uniques structure for table client
-- ----------------------------
ALTER TABLE "public"."client" ADD CONSTRAINT "uk_b71cjlbenv945rb6gcon438at" UNIQUE ("realm_id", "client_id");

-- ----------------------------
-- Primary Key structure for table client
-- ----------------------------
ALTER TABLE "public"."client" ADD CONSTRAINT "constraint_7" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table client_attributes
-- ----------------------------
ALTER TABLE "public"."client_attributes" ADD CONSTRAINT "constraint_3c" PRIMARY KEY ("client_id", "name");

-- ----------------------------
-- Primary Key structure for table client_auth_flow_bindings
-- ----------------------------
ALTER TABLE "public"."client_auth_flow_bindings" ADD CONSTRAINT "c_cli_flow_bind" PRIMARY KEY ("client_id", "binding_name");

-- ----------------------------
-- Indexes structure for table client_initial_access
-- ----------------------------
CREATE INDEX "idx_client_init_acc_realm" ON "public"."client_initial_access" USING btree (
  "realm_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table client_initial_access
-- ----------------------------
ALTER TABLE "public"."client_initial_access" ADD CONSTRAINT "cnstr_client_init_acc_pk" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table client_node_registrations
-- ----------------------------
ALTER TABLE "public"."client_node_registrations" ADD CONSTRAINT "constraint_84" PRIMARY KEY ("client_id", "name");

-- ----------------------------
-- Indexes structure for table client_scope
-- ----------------------------
CREATE INDEX "idx_realm_clscope" ON "public"."client_scope" USING btree (
  "realm_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Uniques structure for table client_scope
-- ----------------------------
ALTER TABLE "public"."client_scope" ADD CONSTRAINT "uk_cli_scope" UNIQUE ("realm_id", "name");

-- ----------------------------
-- Primary Key structure for table client_scope
-- ----------------------------
ALTER TABLE "public"."client_scope" ADD CONSTRAINT "pk_cli_template" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table client_scope_attributes
-- ----------------------------
CREATE INDEX "idx_clscope_attrs" ON "public"."client_scope_attributes" USING btree (
  "scope_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table client_scope_attributes
-- ----------------------------
ALTER TABLE "public"."client_scope_attributes" ADD CONSTRAINT "pk_cl_tmpl_attr" PRIMARY KEY ("scope_id", "name");

-- ----------------------------
-- Indexes structure for table client_scope_client
-- ----------------------------
CREATE INDEX "idx_cl_clscope" ON "public"."client_scope_client" USING btree (
  "scope_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_clscope_cl" ON "public"."client_scope_client" USING btree (
  "client_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table client_scope_client
-- ----------------------------
ALTER TABLE "public"."client_scope_client" ADD CONSTRAINT "c_cli_scope_bind" PRIMARY KEY ("client_id", "scope_id");

-- ----------------------------
-- Indexes structure for table client_scope_role_mapping
-- ----------------------------
CREATE INDEX "idx_clscope_role" ON "public"."client_scope_role_mapping" USING btree (
  "scope_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_role_clscope" ON "public"."client_scope_role_mapping" USING btree (
  "role_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table client_scope_role_mapping
-- ----------------------------
ALTER TABLE "public"."client_scope_role_mapping" ADD CONSTRAINT "pk_template_scope" PRIMARY KEY ("scope_id", "role_id");

-- ----------------------------
-- Indexes structure for table client_session
-- ----------------------------
CREATE INDEX "idx_client_session_session" ON "public"."client_session" USING btree (
  "session_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table client_session
-- ----------------------------
ALTER TABLE "public"."client_session" ADD CONSTRAINT "constraint_8" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table client_session_auth_status
-- ----------------------------
ALTER TABLE "public"."client_session_auth_status" ADD CONSTRAINT "constraint_auth_status_pk" PRIMARY KEY ("client_session", "authenticator");

-- ----------------------------
-- Primary Key structure for table client_session_note
-- ----------------------------
ALTER TABLE "public"."client_session_note" ADD CONSTRAINT "constraint_5e" PRIMARY KEY ("client_session", "name");

-- ----------------------------
-- Primary Key structure for table client_session_prot_mapper
-- ----------------------------
ALTER TABLE "public"."client_session_prot_mapper" ADD CONSTRAINT "constraint_cs_pmp_pk" PRIMARY KEY ("client_session", "protocol_mapper_id");

-- ----------------------------
-- Primary Key structure for table client_session_role
-- ----------------------------
ALTER TABLE "public"."client_session_role" ADD CONSTRAINT "constraint_5" PRIMARY KEY ("client_session", "role_id");

-- ----------------------------
-- Primary Key structure for table client_user_session_note
-- ----------------------------
ALTER TABLE "public"."client_user_session_note" ADD CONSTRAINT "constr_cl_usr_ses_note" PRIMARY KEY ("client_session", "name");

-- ----------------------------
-- Indexes structure for table component
-- ----------------------------
CREATE INDEX "idx_component_provider_type" ON "public"."component" USING btree (
  "provider_type" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_component_realm" ON "public"."component" USING btree (
  "realm_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table component
-- ----------------------------
ALTER TABLE "public"."component" ADD CONSTRAINT "constr_component_pk" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table component_config
-- ----------------------------
CREATE INDEX "idx_compo_config_compo" ON "public"."component_config" USING btree (
  "component_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table component_config
-- ----------------------------
ALTER TABLE "public"."component_config" ADD CONSTRAINT "constr_component_config_pk" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table composite_role
-- ----------------------------
CREATE INDEX "idx_composite" ON "public"."composite_role" USING btree (
  "composite" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_composite_child" ON "public"."composite_role" USING btree (
  "child_role" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table composite_role
-- ----------------------------
ALTER TABLE "public"."composite_role" ADD CONSTRAINT "constraint_composite_role" PRIMARY KEY ("composite", "child_role");

-- ----------------------------
-- Indexes structure for table credential
-- ----------------------------
CREATE INDEX "idx_user_credential" ON "public"."credential" USING btree (
  "user_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table credential
-- ----------------------------
ALTER TABLE "public"."credential" ADD CONSTRAINT "constraint_f" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table databasechangeloglock
-- ----------------------------
ALTER TABLE "public"."databasechangeloglock" ADD CONSTRAINT "databasechangeloglock_pkey" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table default_client_scope
-- ----------------------------
CREATE INDEX "idx_defcls_realm" ON "public"."default_client_scope" USING btree (
  "realm_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_defcls_scope" ON "public"."default_client_scope" USING btree (
  "scope_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table default_client_scope
-- ----------------------------
ALTER TABLE "public"."default_client_scope" ADD CONSTRAINT "r_def_cli_scope_bind" PRIMARY KEY ("realm_id", "scope_id");

-- ----------------------------
-- Indexes structure for table event_entity
-- ----------------------------
CREATE INDEX "idx_event_time" ON "public"."event_entity" USING btree (
  "realm_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "event_time" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table event_entity
-- ----------------------------
ALTER TABLE "public"."event_entity" ADD CONSTRAINT "constraint_4" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table fed_user_attribute
-- ----------------------------
CREATE INDEX "idx_fu_attribute" ON "public"."fed_user_attribute" USING btree (
  "user_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "realm_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table fed_user_attribute
-- ----------------------------
ALTER TABLE "public"."fed_user_attribute" ADD CONSTRAINT "constr_fed_user_attr_pk" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table fed_user_consent
-- ----------------------------
CREATE INDEX "idx_fu_cnsnt_ext" ON "public"."fed_user_consent" USING btree (
  "user_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "client_storage_provider" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "external_client_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_fu_consent" ON "public"."fed_user_consent" USING btree (
  "user_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "client_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_fu_consent_ru" ON "public"."fed_user_consent" USING btree (
  "realm_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "user_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table fed_user_consent
-- ----------------------------
ALTER TABLE "public"."fed_user_consent" ADD CONSTRAINT "constr_fed_user_consent_pk" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table fed_user_consent_cl_scope
-- ----------------------------
ALTER TABLE "public"."fed_user_consent_cl_scope" ADD CONSTRAINT "constraint_fgrntcsnt_clsc_pm" PRIMARY KEY ("user_consent_id", "scope_id");

-- ----------------------------
-- Indexes structure for table fed_user_credential
-- ----------------------------
CREATE INDEX "idx_fu_credential" ON "public"."fed_user_credential" USING btree (
  "user_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "type" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_fu_credential_ru" ON "public"."fed_user_credential" USING btree (
  "realm_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "user_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table fed_user_credential
-- ----------------------------
ALTER TABLE "public"."fed_user_credential" ADD CONSTRAINT "constr_fed_user_cred_pk" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table fed_user_group_membership
-- ----------------------------
CREATE INDEX "idx_fu_group_membership" ON "public"."fed_user_group_membership" USING btree (
  "user_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "group_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_fu_group_membership_ru" ON "public"."fed_user_group_membership" USING btree (
  "realm_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "user_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table fed_user_group_membership
-- ----------------------------
ALTER TABLE "public"."fed_user_group_membership" ADD CONSTRAINT "constr_fed_user_group" PRIMARY KEY ("group_id", "user_id");

-- ----------------------------
-- Indexes structure for table fed_user_required_action
-- ----------------------------
CREATE INDEX "idx_fu_required_action" ON "public"."fed_user_required_action" USING btree (
  "user_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "required_action" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_fu_required_action_ru" ON "public"."fed_user_required_action" USING btree (
  "realm_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "user_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table fed_user_required_action
-- ----------------------------
ALTER TABLE "public"."fed_user_required_action" ADD CONSTRAINT "constr_fed_required_action" PRIMARY KEY ("required_action", "user_id");

-- ----------------------------
-- Indexes structure for table fed_user_role_mapping
-- ----------------------------
CREATE INDEX "idx_fu_role_mapping" ON "public"."fed_user_role_mapping" USING btree (
  "user_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "role_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_fu_role_mapping_ru" ON "public"."fed_user_role_mapping" USING btree (
  "realm_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "user_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table fed_user_role_mapping
-- ----------------------------
ALTER TABLE "public"."fed_user_role_mapping" ADD CONSTRAINT "constr_fed_user_role" PRIMARY KEY ("role_id", "user_id");

-- ----------------------------
-- Indexes structure for table federated_identity
-- ----------------------------
CREATE INDEX "idx_fedidentity_feduser" ON "public"."federated_identity" USING btree (
  "federated_user_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_fedidentity_user" ON "public"."federated_identity" USING btree (
  "user_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table federated_identity
-- ----------------------------
ALTER TABLE "public"."federated_identity" ADD CONSTRAINT "constraint_40" PRIMARY KEY ("identity_provider", "user_id");

-- ----------------------------
-- Primary Key structure for table federated_user
-- ----------------------------
ALTER TABLE "public"."federated_user" ADD CONSTRAINT "constr_federated_user" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table group_attribute
-- ----------------------------
CREATE INDEX "idx_group_att_by_name_value" ON "public"."group_attribute" USING btree (
  "name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  (value::character varying(250)) COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_group_attr_group" ON "public"."group_attribute" USING btree (
  "group_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table group_attribute
-- ----------------------------
ALTER TABLE "public"."group_attribute" ADD CONSTRAINT "constraint_group_attribute_pk" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table group_role_mapping
-- ----------------------------
CREATE INDEX "idx_group_role_mapp_group" ON "public"."group_role_mapping" USING btree (
  "group_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table group_role_mapping
-- ----------------------------
ALTER TABLE "public"."group_role_mapping" ADD CONSTRAINT "constraint_group_role" PRIMARY KEY ("role_id", "group_id");

-- ----------------------------
-- Indexes structure for table identity_provider
-- ----------------------------
CREATE INDEX "idx_ident_prov_realm" ON "public"."identity_provider" USING btree (
  "realm_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Uniques structure for table identity_provider
-- ----------------------------
ALTER TABLE "public"."identity_provider" ADD CONSTRAINT "uk_2daelwnibji49avxsrtuf6xj33" UNIQUE ("provider_alias", "realm_id");

-- ----------------------------
-- Primary Key structure for table identity_provider
-- ----------------------------
ALTER TABLE "public"."identity_provider" ADD CONSTRAINT "constraint_2b" PRIMARY KEY ("internal_id");

-- ----------------------------
-- Primary Key structure for table identity_provider_config
-- ----------------------------
ALTER TABLE "public"."identity_provider_config" ADD CONSTRAINT "constraint_d" PRIMARY KEY ("identity_provider_id", "name");

-- ----------------------------
-- Indexes structure for table identity_provider_mapper
-- ----------------------------
CREATE INDEX "idx_id_prov_mapp_realm" ON "public"."identity_provider_mapper" USING btree (
  "realm_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table identity_provider_mapper
-- ----------------------------
ALTER TABLE "public"."identity_provider_mapper" ADD CONSTRAINT "constraint_idpm" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table idp_mapper_config
-- ----------------------------
ALTER TABLE "public"."idp_mapper_config" ADD CONSTRAINT "constraint_idpmconfig" PRIMARY KEY ("idp_mapper_id", "name");

-- ----------------------------
-- Uniques structure for table keycloak_group
-- ----------------------------
ALTER TABLE "public"."keycloak_group" ADD CONSTRAINT "sibling_names" UNIQUE ("realm_id", "parent_group", "name");

-- ----------------------------
-- Primary Key structure for table keycloak_group
-- ----------------------------
ALTER TABLE "public"."keycloak_group" ADD CONSTRAINT "constraint_group" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table keycloak_role
-- ----------------------------
CREATE INDEX "idx_keycloak_role_client" ON "public"."keycloak_role" USING btree (
  "client" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_keycloak_role_realm" ON "public"."keycloak_role" USING btree (
  "realm" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Uniques structure for table keycloak_role
-- ----------------------------
ALTER TABLE "public"."keycloak_role" ADD CONSTRAINT "UK_J3RWUVD56ONTGSUHOGM184WW2-2" UNIQUE ("name", "client_realm_constraint");

-- ----------------------------
-- Primary Key structure for table keycloak_role
-- ----------------------------
ALTER TABLE "public"."keycloak_role" ADD CONSTRAINT "constraint_a" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table migration_model
-- ----------------------------
CREATE INDEX "idx_update_time" ON "public"."migration_model" USING btree (
  "update_time" "pg_catalog"."int8_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table migration_model
-- ----------------------------
ALTER TABLE "public"."migration_model" ADD CONSTRAINT "constraint_migmod" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table offline_client_session
-- ----------------------------
CREATE INDEX "idx_offline_css_preload" ON "public"."offline_client_session" USING btree (
  "client_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "offline_flag" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_us_sess_id_on_cl_sess" ON "public"."offline_client_session" USING btree (
  "user_session_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table offline_client_session
-- ----------------------------
ALTER TABLE "public"."offline_client_session" ADD CONSTRAINT "constraint_offl_cl_ses_pk3" PRIMARY KEY ("user_session_id", "client_id", "client_storage_provider", "external_client_id", "offline_flag");

-- ----------------------------
-- Indexes structure for table offline_user_session
-- ----------------------------
CREATE INDEX "idx_offline_uss_by_user" ON "public"."offline_user_session" USING btree (
  "user_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "realm_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "offline_flag" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_offline_uss_by_usersess" ON "public"."offline_user_session" USING btree (
  "realm_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "offline_flag" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "user_session_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_offline_uss_createdon" ON "public"."offline_user_session" USING btree (
  "created_on" "pg_catalog"."int4_ops" ASC NULLS LAST
);
CREATE INDEX "idx_offline_uss_preload" ON "public"."offline_user_session" USING btree (
  "offline_flag" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "created_on" "pg_catalog"."int4_ops" ASC NULLS LAST,
  "user_session_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table offline_user_session
-- ----------------------------
ALTER TABLE "public"."offline_user_session" ADD CONSTRAINT "constraint_offl_us_ses_pk2" PRIMARY KEY ("user_session_id", "offline_flag");

-- ----------------------------
-- Primary Key structure for table policy_config
-- ----------------------------
ALTER TABLE "public"."policy_config" ADD CONSTRAINT "constraint_dpc" PRIMARY KEY ("policy_id", "name");

-- ----------------------------
-- Indexes structure for table protocol_mapper
-- ----------------------------
CREATE INDEX "idx_clscope_protmap" ON "public"."protocol_mapper" USING btree (
  "client_scope_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_protocol_mapper_client" ON "public"."protocol_mapper" USING btree (
  "client_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table protocol_mapper
-- ----------------------------
ALTER TABLE "public"."protocol_mapper" ADD CONSTRAINT "constraint_pcm" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table protocol_mapper_config
-- ----------------------------
ALTER TABLE "public"."protocol_mapper_config" ADD CONSTRAINT "constraint_pmconfig" PRIMARY KEY ("protocol_mapper_id", "name");

-- ----------------------------
-- Indexes structure for table realm
-- ----------------------------
CREATE INDEX "idx_realm_master_adm_cli" ON "public"."realm" USING btree (
  "master_admin_client" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Uniques structure for table realm
-- ----------------------------
ALTER TABLE "public"."realm" ADD CONSTRAINT "uk_orvsdmla56612eaefiq6wl5oi" UNIQUE ("name");

-- ----------------------------
-- Primary Key structure for table realm
-- ----------------------------
ALTER TABLE "public"."realm" ADD CONSTRAINT "constraint_4a" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table realm_attribute
-- ----------------------------
CREATE INDEX "idx_realm_attr_realm" ON "public"."realm_attribute" USING btree (
  "realm_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table realm_attribute
-- ----------------------------
ALTER TABLE "public"."realm_attribute" ADD CONSTRAINT "constraint_9" PRIMARY KEY ("name", "realm_id");

-- ----------------------------
-- Indexes structure for table realm_default_groups
-- ----------------------------
CREATE INDEX "idx_realm_def_grp_realm" ON "public"."realm_default_groups" USING btree (
  "realm_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Uniques structure for table realm_default_groups
-- ----------------------------
ALTER TABLE "public"."realm_default_groups" ADD CONSTRAINT "con_group_id_def_groups" UNIQUE ("group_id");

-- ----------------------------
-- Primary Key structure for table realm_default_groups
-- ----------------------------
ALTER TABLE "public"."realm_default_groups" ADD CONSTRAINT "constr_realm_default_groups" PRIMARY KEY ("realm_id", "group_id");

-- ----------------------------
-- Indexes structure for table realm_enabled_event_types
-- ----------------------------
CREATE INDEX "idx_realm_evt_types_realm" ON "public"."realm_enabled_event_types" USING btree (
  "realm_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table realm_enabled_event_types
-- ----------------------------
ALTER TABLE "public"."realm_enabled_event_types" ADD CONSTRAINT "constr_realm_enabl_event_types" PRIMARY KEY ("realm_id", "value");

-- ----------------------------
-- Indexes structure for table realm_events_listeners
-- ----------------------------
CREATE INDEX "idx_realm_evt_list_realm" ON "public"."realm_events_listeners" USING btree (
  "realm_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table realm_events_listeners
-- ----------------------------
ALTER TABLE "public"."realm_events_listeners" ADD CONSTRAINT "constr_realm_events_listeners" PRIMARY KEY ("realm_id", "value");

-- ----------------------------
-- Primary Key structure for table realm_localizations
-- ----------------------------
ALTER TABLE "public"."realm_localizations" ADD CONSTRAINT "realm_localizations_pkey" PRIMARY KEY ("realm_id", "locale");

-- ----------------------------
-- Primary Key structure for table realm_required_credential
-- ----------------------------
ALTER TABLE "public"."realm_required_credential" ADD CONSTRAINT "constraint_92" PRIMARY KEY ("realm_id", "type");

-- ----------------------------
-- Primary Key structure for table realm_smtp_config
-- ----------------------------
ALTER TABLE "public"."realm_smtp_config" ADD CONSTRAINT "constraint_e" PRIMARY KEY ("realm_id", "name");

-- ----------------------------
-- Indexes structure for table realm_supported_locales
-- ----------------------------
CREATE INDEX "idx_realm_supp_local_realm" ON "public"."realm_supported_locales" USING btree (
  "realm_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table realm_supported_locales
-- ----------------------------
ALTER TABLE "public"."realm_supported_locales" ADD CONSTRAINT "constr_realm_supported_locales" PRIMARY KEY ("realm_id", "value");

-- ----------------------------
-- Indexes structure for table redirect_uris
-- ----------------------------
CREATE INDEX "idx_redir_uri_client" ON "public"."redirect_uris" USING btree (
  "client_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table redirect_uris
-- ----------------------------
ALTER TABLE "public"."redirect_uris" ADD CONSTRAINT "constraint_redirect_uris" PRIMARY KEY ("client_id", "value");

-- ----------------------------
-- Primary Key structure for table required_action_config
-- ----------------------------
ALTER TABLE "public"."required_action_config" ADD CONSTRAINT "constraint_req_act_cfg_pk" PRIMARY KEY ("required_action_id", "name");

-- ----------------------------
-- Indexes structure for table required_action_provider
-- ----------------------------
CREATE INDEX "idx_req_act_prov_realm" ON "public"."required_action_provider" USING btree (
  "realm_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table required_action_provider
-- ----------------------------
ALTER TABLE "public"."required_action_provider" ADD CONSTRAINT "constraint_req_act_prv_pk" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table resource_attribute
-- ----------------------------
ALTER TABLE "public"."resource_attribute" ADD CONSTRAINT "res_attr_pk" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table resource_policy
-- ----------------------------
CREATE INDEX "idx_res_policy_policy" ON "public"."resource_policy" USING btree (
  "policy_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table resource_policy
-- ----------------------------
ALTER TABLE "public"."resource_policy" ADD CONSTRAINT "constraint_farsrpp" PRIMARY KEY ("resource_id", "policy_id");

-- ----------------------------
-- Indexes structure for table resource_scope
-- ----------------------------
CREATE INDEX "idx_res_scope_scope" ON "public"."resource_scope" USING btree (
  "scope_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table resource_scope
-- ----------------------------
ALTER TABLE "public"."resource_scope" ADD CONSTRAINT "constraint_farsrsp" PRIMARY KEY ("resource_id", "scope_id");

-- ----------------------------
-- Primary Key structure for table resource_server
-- ----------------------------
ALTER TABLE "public"."resource_server" ADD CONSTRAINT "pk_resource_server" PRIMARY KEY ("id");

-- ----------------------------
-- Uniques structure for table resource_server_perm_ticket
-- ----------------------------
ALTER TABLE "public"."resource_server_perm_ticket" ADD CONSTRAINT "uk_frsr6t700s9v50bu18ws5pmt" UNIQUE ("owner", "requester", "resource_server_id", "resource_id", "scope_id");

-- ----------------------------
-- Primary Key structure for table resource_server_perm_ticket
-- ----------------------------
ALTER TABLE "public"."resource_server_perm_ticket" ADD CONSTRAINT "constraint_fapmt" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table resource_server_policy
-- ----------------------------
CREATE INDEX "idx_res_serv_pol_res_serv" ON "public"."resource_server_policy" USING btree (
  "resource_server_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Uniques structure for table resource_server_policy
-- ----------------------------
ALTER TABLE "public"."resource_server_policy" ADD CONSTRAINT "uk_frsrpt700s9v50bu18ws5ha6" UNIQUE ("name", "resource_server_id");

-- ----------------------------
-- Primary Key structure for table resource_server_policy
-- ----------------------------
ALTER TABLE "public"."resource_server_policy" ADD CONSTRAINT "constraint_farsrp" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table resource_server_resource
-- ----------------------------
CREATE INDEX "idx_res_srv_res_res_srv" ON "public"."resource_server_resource" USING btree (
  "resource_server_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Uniques structure for table resource_server_resource
-- ----------------------------
ALTER TABLE "public"."resource_server_resource" ADD CONSTRAINT "uk_frsr6t700s9v50bu18ws5ha6" UNIQUE ("name", "owner", "resource_server_id");

-- ----------------------------
-- Primary Key structure for table resource_server_resource
-- ----------------------------
ALTER TABLE "public"."resource_server_resource" ADD CONSTRAINT "constraint_farsr" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table resource_server_scope
-- ----------------------------
CREATE INDEX "idx_res_srv_scope_res_srv" ON "public"."resource_server_scope" USING btree (
  "resource_server_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Uniques structure for table resource_server_scope
-- ----------------------------
ALTER TABLE "public"."resource_server_scope" ADD CONSTRAINT "uk_frsrst700s9v50bu18ws5ha6" UNIQUE ("name", "resource_server_id");

-- ----------------------------
-- Primary Key structure for table resource_server_scope
-- ----------------------------
ALTER TABLE "public"."resource_server_scope" ADD CONSTRAINT "constraint_farsrs" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table resource_uris
-- ----------------------------
ALTER TABLE "public"."resource_uris" ADD CONSTRAINT "constraint_resour_uris_pk" PRIMARY KEY ("resource_id", "value");

-- ----------------------------
-- Indexes structure for table role_attribute
-- ----------------------------
CREATE INDEX "idx_role_attribute" ON "public"."role_attribute" USING btree (
  "role_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table role_attribute
-- ----------------------------
ALTER TABLE "public"."role_attribute" ADD CONSTRAINT "constraint_role_attribute_pk" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table scope_mapping
-- ----------------------------
CREATE INDEX "idx_scope_mapping_role" ON "public"."scope_mapping" USING btree (
  "role_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table scope_mapping
-- ----------------------------
ALTER TABLE "public"."scope_mapping" ADD CONSTRAINT "constraint_81" PRIMARY KEY ("client_id", "role_id");

-- ----------------------------
-- Indexes structure for table scope_policy
-- ----------------------------
CREATE INDEX "idx_scope_policy_policy" ON "public"."scope_policy" USING btree (
  "policy_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table scope_policy
-- ----------------------------
ALTER TABLE "public"."scope_policy" ADD CONSTRAINT "constraint_farsrsps" PRIMARY KEY ("scope_id", "policy_id");

-- ----------------------------
-- Indexes structure for table user_attribute
-- ----------------------------
CREATE INDEX "idx_user_attribute" ON "public"."user_attribute" USING btree (
  "user_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_user_attribute_name" ON "public"."user_attribute" USING btree (
  "name" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "value" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table user_attribute
-- ----------------------------
ALTER TABLE "public"."user_attribute" ADD CONSTRAINT "constraint_user_attribute_pk" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table user_consent
-- ----------------------------
CREATE INDEX "idx_user_consent" ON "public"."user_consent" USING btree (
  "user_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Uniques structure for table user_consent
-- ----------------------------
ALTER TABLE "public"."user_consent" ADD CONSTRAINT "uk_jkuwuvd56ontgsuhogm8uewrt" UNIQUE ("client_id", "client_storage_provider", "external_client_id", "user_id");

-- ----------------------------
-- Primary Key structure for table user_consent
-- ----------------------------
ALTER TABLE "public"."user_consent" ADD CONSTRAINT "constraint_grntcsnt_pm" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table user_consent_client_scope
-- ----------------------------
CREATE INDEX "idx_usconsent_clscope" ON "public"."user_consent_client_scope" USING btree (
  "user_consent_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table user_consent_client_scope
-- ----------------------------
ALTER TABLE "public"."user_consent_client_scope" ADD CONSTRAINT "constraint_grntcsnt_clsc_pm" PRIMARY KEY ("user_consent_id", "scope_id");

-- ----------------------------
-- Indexes structure for table user_entity
-- ----------------------------
CREATE INDEX "idx_user_email" ON "public"."user_entity" USING btree (
  "email" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_user_service_account" ON "public"."user_entity" USING btree (
  "realm_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST,
  "service_account_client_link" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Uniques structure for table user_entity
-- ----------------------------
ALTER TABLE "public"."user_entity" ADD CONSTRAINT "uk_dykn684sl8up1crfei6eckhd7" UNIQUE ("realm_id", "email_constraint");
ALTER TABLE "public"."user_entity" ADD CONSTRAINT "uk_ru8tt6t700s9v50bu18ws5ha6" UNIQUE ("realm_id", "username");

-- ----------------------------
-- Primary Key structure for table user_entity
-- ----------------------------
ALTER TABLE "public"."user_entity" ADD CONSTRAINT "constraint_fb" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table user_federation_config
-- ----------------------------
ALTER TABLE "public"."user_federation_config" ADD CONSTRAINT "constraint_f9" PRIMARY KEY ("user_federation_provider_id", "name");

-- ----------------------------
-- Indexes structure for table user_federation_mapper
-- ----------------------------
CREATE INDEX "idx_usr_fed_map_fed_prv" ON "public"."user_federation_mapper" USING btree (
  "federation_provider_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);
CREATE INDEX "idx_usr_fed_map_realm" ON "public"."user_federation_mapper" USING btree (
  "realm_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table user_federation_mapper
-- ----------------------------
ALTER TABLE "public"."user_federation_mapper" ADD CONSTRAINT "constraint_fedmapperpm" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table user_federation_mapper_config
-- ----------------------------
ALTER TABLE "public"."user_federation_mapper_config" ADD CONSTRAINT "constraint_fedmapper_cfg_pm" PRIMARY KEY ("user_federation_mapper_id", "name");

-- ----------------------------
-- Indexes structure for table user_federation_provider
-- ----------------------------
CREATE INDEX "idx_usr_fed_prv_realm" ON "public"."user_federation_provider" USING btree (
  "realm_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table user_federation_provider
-- ----------------------------
ALTER TABLE "public"."user_federation_provider" ADD CONSTRAINT "constraint_5c" PRIMARY KEY ("id");

-- ----------------------------
-- Indexes structure for table user_group_membership
-- ----------------------------
CREATE INDEX "idx_user_group_mapping" ON "public"."user_group_membership" USING btree (
  "user_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table user_group_membership
-- ----------------------------
ALTER TABLE "public"."user_group_membership" ADD CONSTRAINT "constraint_user_group" PRIMARY KEY ("group_id", "user_id");

-- ----------------------------
-- Indexes structure for table user_required_action
-- ----------------------------
CREATE INDEX "idx_user_reqactions" ON "public"."user_required_action" USING btree (
  "user_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table user_required_action
-- ----------------------------
ALTER TABLE "public"."user_required_action" ADD CONSTRAINT "constraint_required_action" PRIMARY KEY ("required_action", "user_id");

-- ----------------------------
-- Indexes structure for table user_role_mapping
-- ----------------------------
CREATE INDEX "idx_user_role_mapping" ON "public"."user_role_mapping" USING btree (
  "user_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table user_role_mapping
-- ----------------------------
ALTER TABLE "public"."user_role_mapping" ADD CONSTRAINT "constraint_c" PRIMARY KEY ("role_id", "user_id");

-- ----------------------------
-- Primary Key structure for table user_session
-- ----------------------------
ALTER TABLE "public"."user_session" ADD CONSTRAINT "constraint_57" PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table user_session_note
-- ----------------------------
ALTER TABLE "public"."user_session_note" ADD CONSTRAINT "constraint_usn_pk" PRIMARY KEY ("user_session", "name");

-- ----------------------------
-- Primary Key structure for table username_login_failure
-- ----------------------------
ALTER TABLE "public"."username_login_failure" ADD CONSTRAINT "CONSTRAINT_17-2" PRIMARY KEY ("realm_id", "username");

-- ----------------------------
-- Indexes structure for table web_origins
-- ----------------------------
CREATE INDEX "idx_web_orig_client" ON "public"."web_origins" USING btree (
  "client_id" COLLATE "pg_catalog"."default" "pg_catalog"."text_ops" ASC NULLS LAST
);

-- ----------------------------
-- Primary Key structure for table web_origins
-- ----------------------------
ALTER TABLE "public"."web_origins" ADD CONSTRAINT "constraint_web_origins" PRIMARY KEY ("client_id", "value");

-- ----------------------------
-- Foreign Keys structure for table associated_policy
-- ----------------------------
ALTER TABLE "public"."associated_policy" ADD CONSTRAINT "fk_frsr5s213xcx4wnkog82ssrfy" FOREIGN KEY ("associated_policy_id") REFERENCES "public"."resource_server_policy" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."associated_policy" ADD CONSTRAINT "fk_frsrpas14xcx4wnkog82ssrfy" FOREIGN KEY ("policy_id") REFERENCES "public"."resource_server_policy" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table authentication_execution
-- ----------------------------
ALTER TABLE "public"."authentication_execution" ADD CONSTRAINT "fk_auth_exec_flow" FOREIGN KEY ("flow_id") REFERENCES "public"."authentication_flow" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."authentication_execution" ADD CONSTRAINT "fk_auth_exec_realm" FOREIGN KEY ("realm_id") REFERENCES "public"."realm" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table authentication_flow
-- ----------------------------
ALTER TABLE "public"."authentication_flow" ADD CONSTRAINT "fk_auth_flow_realm" FOREIGN KEY ("realm_id") REFERENCES "public"."realm" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table authenticator_config
-- ----------------------------
ALTER TABLE "public"."authenticator_config" ADD CONSTRAINT "fk_auth_realm" FOREIGN KEY ("realm_id") REFERENCES "public"."realm" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table client_attributes
-- ----------------------------
ALTER TABLE "public"."client_attributes" ADD CONSTRAINT "fk3c47c64beacca966" FOREIGN KEY ("client_id") REFERENCES "public"."client" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table client_initial_access
-- ----------------------------
ALTER TABLE "public"."client_initial_access" ADD CONSTRAINT "fk_client_init_acc_realm" FOREIGN KEY ("realm_id") REFERENCES "public"."realm" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table client_node_registrations
-- ----------------------------
ALTER TABLE "public"."client_node_registrations" ADD CONSTRAINT "fk4129723ba992f594" FOREIGN KEY ("client_id") REFERENCES "public"."client" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table client_scope_attributes
-- ----------------------------
ALTER TABLE "public"."client_scope_attributes" ADD CONSTRAINT "fk_cl_scope_attr_scope" FOREIGN KEY ("scope_id") REFERENCES "public"."client_scope" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table client_scope_role_mapping
-- ----------------------------
ALTER TABLE "public"."client_scope_role_mapping" ADD CONSTRAINT "fk_cl_scope_rm_scope" FOREIGN KEY ("scope_id") REFERENCES "public"."client_scope" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table client_session
-- ----------------------------
ALTER TABLE "public"."client_session" ADD CONSTRAINT "fk_b4ao2vcvat6ukau74wbwtfqo1" FOREIGN KEY ("session_id") REFERENCES "public"."user_session" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table client_session_auth_status
-- ----------------------------
ALTER TABLE "public"."client_session_auth_status" ADD CONSTRAINT "auth_status_constraint" FOREIGN KEY ("client_session") REFERENCES "public"."client_session" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table client_session_note
-- ----------------------------
ALTER TABLE "public"."client_session_note" ADD CONSTRAINT "fk5edfb00ff51c2736" FOREIGN KEY ("client_session") REFERENCES "public"."client_session" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table client_session_prot_mapper
-- ----------------------------
ALTER TABLE "public"."client_session_prot_mapper" ADD CONSTRAINT "fk_33a8sgqw18i532811v7o2dk89" FOREIGN KEY ("client_session") REFERENCES "public"."client_session" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table client_session_role
-- ----------------------------
ALTER TABLE "public"."client_session_role" ADD CONSTRAINT "fk_11b7sgqw18i532811v7o2dv76" FOREIGN KEY ("client_session") REFERENCES "public"."client_session" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table client_user_session_note
-- ----------------------------
ALTER TABLE "public"."client_user_session_note" ADD CONSTRAINT "fk_cl_usr_ses_note" FOREIGN KEY ("client_session") REFERENCES "public"."client_session" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table component
-- ----------------------------
ALTER TABLE "public"."component" ADD CONSTRAINT "fk_component_realm" FOREIGN KEY ("realm_id") REFERENCES "public"."realm" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table component_config
-- ----------------------------
ALTER TABLE "public"."component_config" ADD CONSTRAINT "fk_component_config" FOREIGN KEY ("component_id") REFERENCES "public"."component" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table composite_role
-- ----------------------------
ALTER TABLE "public"."composite_role" ADD CONSTRAINT "fk_a63wvekftu8jo1pnj81e7mce2" FOREIGN KEY ("composite") REFERENCES "public"."keycloak_role" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."composite_role" ADD CONSTRAINT "fk_gr7thllb9lu8q4vqa4524jjy8" FOREIGN KEY ("child_role") REFERENCES "public"."keycloak_role" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table credential
-- ----------------------------
ALTER TABLE "public"."credential" ADD CONSTRAINT "fk_pfyr0glasqyl0dei3kl69r6v0" FOREIGN KEY ("user_id") REFERENCES "public"."user_entity" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table default_client_scope
-- ----------------------------
ALTER TABLE "public"."default_client_scope" ADD CONSTRAINT "fk_r_def_cli_scope_realm" FOREIGN KEY ("realm_id") REFERENCES "public"."realm" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table federated_identity
-- ----------------------------
ALTER TABLE "public"."federated_identity" ADD CONSTRAINT "fk404288b92ef007a6" FOREIGN KEY ("user_id") REFERENCES "public"."user_entity" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table group_attribute
-- ----------------------------
ALTER TABLE "public"."group_attribute" ADD CONSTRAINT "fk_group_attribute_group" FOREIGN KEY ("group_id") REFERENCES "public"."keycloak_group" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table group_role_mapping
-- ----------------------------
ALTER TABLE "public"."group_role_mapping" ADD CONSTRAINT "fk_group_role_group" FOREIGN KEY ("group_id") REFERENCES "public"."keycloak_group" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table identity_provider
-- ----------------------------
ALTER TABLE "public"."identity_provider" ADD CONSTRAINT "fk2b4ebc52ae5c3b34" FOREIGN KEY ("realm_id") REFERENCES "public"."realm" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table identity_provider_config
-- ----------------------------
ALTER TABLE "public"."identity_provider_config" ADD CONSTRAINT "fkdc4897cf864c4e43" FOREIGN KEY ("identity_provider_id") REFERENCES "public"."identity_provider" ("internal_id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table identity_provider_mapper
-- ----------------------------
ALTER TABLE "public"."identity_provider_mapper" ADD CONSTRAINT "fk_idpm_realm" FOREIGN KEY ("realm_id") REFERENCES "public"."realm" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table idp_mapper_config
-- ----------------------------
ALTER TABLE "public"."idp_mapper_config" ADD CONSTRAINT "fk_idpmconfig" FOREIGN KEY ("idp_mapper_id") REFERENCES "public"."identity_provider_mapper" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table keycloak_role
-- ----------------------------
ALTER TABLE "public"."keycloak_role" ADD CONSTRAINT "fk_6vyqfe4cn4wlq8r6kt5vdsj5c" FOREIGN KEY ("realm") REFERENCES "public"."realm" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table policy_config
-- ----------------------------
ALTER TABLE "public"."policy_config" ADD CONSTRAINT "fkdc34197cf864c4e43" FOREIGN KEY ("policy_id") REFERENCES "public"."resource_server_policy" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table protocol_mapper
-- ----------------------------
ALTER TABLE "public"."protocol_mapper" ADD CONSTRAINT "fk_cli_scope_mapper" FOREIGN KEY ("client_scope_id") REFERENCES "public"."client_scope" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."protocol_mapper" ADD CONSTRAINT "fk_pcm_realm" FOREIGN KEY ("client_id") REFERENCES "public"."client" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table protocol_mapper_config
-- ----------------------------
ALTER TABLE "public"."protocol_mapper_config" ADD CONSTRAINT "fk_pmconfig" FOREIGN KEY ("protocol_mapper_id") REFERENCES "public"."protocol_mapper" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table realm_attribute
-- ----------------------------
ALTER TABLE "public"."realm_attribute" ADD CONSTRAINT "fk_8shxd6l3e9atqukacxgpffptw" FOREIGN KEY ("realm_id") REFERENCES "public"."realm" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table realm_default_groups
-- ----------------------------
ALTER TABLE "public"."realm_default_groups" ADD CONSTRAINT "fk_def_groups_realm" FOREIGN KEY ("realm_id") REFERENCES "public"."realm" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table realm_enabled_event_types
-- ----------------------------
ALTER TABLE "public"."realm_enabled_event_types" ADD CONSTRAINT "fk_h846o4h0w8epx5nwedrf5y69j" FOREIGN KEY ("realm_id") REFERENCES "public"."realm" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table realm_events_listeners
-- ----------------------------
ALTER TABLE "public"."realm_events_listeners" ADD CONSTRAINT "fk_h846o4h0w8epx5nxev9f5y69j" FOREIGN KEY ("realm_id") REFERENCES "public"."realm" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table realm_required_credential
-- ----------------------------
ALTER TABLE "public"."realm_required_credential" ADD CONSTRAINT "fk_5hg65lybevavkqfki3kponh9v" FOREIGN KEY ("realm_id") REFERENCES "public"."realm" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table realm_smtp_config
-- ----------------------------
ALTER TABLE "public"."realm_smtp_config" ADD CONSTRAINT "fk_70ej8xdxgxd0b9hh6180irr0o" FOREIGN KEY ("realm_id") REFERENCES "public"."realm" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table realm_supported_locales
-- ----------------------------
ALTER TABLE "public"."realm_supported_locales" ADD CONSTRAINT "fk_supported_locales_realm" FOREIGN KEY ("realm_id") REFERENCES "public"."realm" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table redirect_uris
-- ----------------------------
ALTER TABLE "public"."redirect_uris" ADD CONSTRAINT "fk_1burs8pb4ouj97h5wuppahv9f" FOREIGN KEY ("client_id") REFERENCES "public"."client" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table required_action_provider
-- ----------------------------
ALTER TABLE "public"."required_action_provider" ADD CONSTRAINT "fk_req_act_realm" FOREIGN KEY ("realm_id") REFERENCES "public"."realm" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table resource_attribute
-- ----------------------------
ALTER TABLE "public"."resource_attribute" ADD CONSTRAINT "fk_5hrm2vlf9ql5fu022kqepovbr" FOREIGN KEY ("resource_id") REFERENCES "public"."resource_server_resource" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table resource_policy
-- ----------------------------
ALTER TABLE "public"."resource_policy" ADD CONSTRAINT "fk_frsrpos53xcx4wnkog82ssrfy" FOREIGN KEY ("resource_id") REFERENCES "public"."resource_server_resource" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."resource_policy" ADD CONSTRAINT "fk_frsrpp213xcx4wnkog82ssrfy" FOREIGN KEY ("policy_id") REFERENCES "public"."resource_server_policy" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table resource_scope
-- ----------------------------
ALTER TABLE "public"."resource_scope" ADD CONSTRAINT "fk_frsrpos13xcx4wnkog82ssrfy" FOREIGN KEY ("resource_id") REFERENCES "public"."resource_server_resource" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."resource_scope" ADD CONSTRAINT "fk_frsrps213xcx4wnkog82ssrfy" FOREIGN KEY ("scope_id") REFERENCES "public"."resource_server_scope" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table resource_server_perm_ticket
-- ----------------------------
ALTER TABLE "public"."resource_server_perm_ticket" ADD CONSTRAINT "fk_frsrho213xcx4wnkog82sspmt" FOREIGN KEY ("resource_server_id") REFERENCES "public"."resource_server" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."resource_server_perm_ticket" ADD CONSTRAINT "fk_frsrho213xcx4wnkog83sspmt" FOREIGN KEY ("resource_id") REFERENCES "public"."resource_server_resource" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."resource_server_perm_ticket" ADD CONSTRAINT "fk_frsrho213xcx4wnkog84sspmt" FOREIGN KEY ("scope_id") REFERENCES "public"."resource_server_scope" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."resource_server_perm_ticket" ADD CONSTRAINT "fk_frsrpo2128cx4wnkog82ssrfy" FOREIGN KEY ("policy_id") REFERENCES "public"."resource_server_policy" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table resource_server_policy
-- ----------------------------
ALTER TABLE "public"."resource_server_policy" ADD CONSTRAINT "fk_frsrpo213xcx4wnkog82ssrfy" FOREIGN KEY ("resource_server_id") REFERENCES "public"."resource_server" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table resource_server_resource
-- ----------------------------
ALTER TABLE "public"."resource_server_resource" ADD CONSTRAINT "fk_frsrho213xcx4wnkog82ssrfy" FOREIGN KEY ("resource_server_id") REFERENCES "public"."resource_server" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table resource_server_scope
-- ----------------------------
ALTER TABLE "public"."resource_server_scope" ADD CONSTRAINT "fk_frsrso213xcx4wnkog82ssrfy" FOREIGN KEY ("resource_server_id") REFERENCES "public"."resource_server" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table resource_uris
-- ----------------------------
ALTER TABLE "public"."resource_uris" ADD CONSTRAINT "fk_resource_server_uris" FOREIGN KEY ("resource_id") REFERENCES "public"."resource_server_resource" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table role_attribute
-- ----------------------------
ALTER TABLE "public"."role_attribute" ADD CONSTRAINT "fk_role_attribute_id" FOREIGN KEY ("role_id") REFERENCES "public"."keycloak_role" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table scope_mapping
-- ----------------------------
ALTER TABLE "public"."scope_mapping" ADD CONSTRAINT "fk_ouse064plmlr732lxjcn1q5f1" FOREIGN KEY ("client_id") REFERENCES "public"."client" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table scope_policy
-- ----------------------------
ALTER TABLE "public"."scope_policy" ADD CONSTRAINT "fk_frsrasp13xcx4wnkog82ssrfy" FOREIGN KEY ("policy_id") REFERENCES "public"."resource_server_policy" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."scope_policy" ADD CONSTRAINT "fk_frsrpass3xcx4wnkog82ssrfy" FOREIGN KEY ("scope_id") REFERENCES "public"."resource_server_scope" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table user_attribute
-- ----------------------------
ALTER TABLE "public"."user_attribute" ADD CONSTRAINT "fk_5hrm2vlf9ql5fu043kqepovbr" FOREIGN KEY ("user_id") REFERENCES "public"."user_entity" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table user_consent
-- ----------------------------
ALTER TABLE "public"."user_consent" ADD CONSTRAINT "fk_grntcsnt_user" FOREIGN KEY ("user_id") REFERENCES "public"."user_entity" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table user_consent_client_scope
-- ----------------------------
ALTER TABLE "public"."user_consent_client_scope" ADD CONSTRAINT "fk_grntcsnt_clsc_usc" FOREIGN KEY ("user_consent_id") REFERENCES "public"."user_consent" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table user_federation_config
-- ----------------------------
ALTER TABLE "public"."user_federation_config" ADD CONSTRAINT "fk_t13hpu1j94r2ebpekr39x5eu5" FOREIGN KEY ("user_federation_provider_id") REFERENCES "public"."user_federation_provider" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table user_federation_mapper
-- ----------------------------
ALTER TABLE "public"."user_federation_mapper" ADD CONSTRAINT "fk_fedmapperpm_fedprv" FOREIGN KEY ("federation_provider_id") REFERENCES "public"."user_federation_provider" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "public"."user_federation_mapper" ADD CONSTRAINT "fk_fedmapperpm_realm" FOREIGN KEY ("realm_id") REFERENCES "public"."realm" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table user_federation_mapper_config
-- ----------------------------
ALTER TABLE "public"."user_federation_mapper_config" ADD CONSTRAINT "fk_fedmapper_cfg" FOREIGN KEY ("user_federation_mapper_id") REFERENCES "public"."user_federation_mapper" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table user_federation_provider
-- ----------------------------
ALTER TABLE "public"."user_federation_provider" ADD CONSTRAINT "fk_1fj32f6ptolw2qy60cd8n01e8" FOREIGN KEY ("realm_id") REFERENCES "public"."realm" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table user_group_membership
-- ----------------------------
ALTER TABLE "public"."user_group_membership" ADD CONSTRAINT "fk_user_group_user" FOREIGN KEY ("user_id") REFERENCES "public"."user_entity" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table user_required_action
-- ----------------------------
ALTER TABLE "public"."user_required_action" ADD CONSTRAINT "fk_6qj3w1jw9cvafhe19bwsiuvmd" FOREIGN KEY ("user_id") REFERENCES "public"."user_entity" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table user_role_mapping
-- ----------------------------
ALTER TABLE "public"."user_role_mapping" ADD CONSTRAINT "fk_c4fqv34p1mbylloxang7b1q3l" FOREIGN KEY ("user_id") REFERENCES "public"."user_entity" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table user_session_note
-- ----------------------------
ALTER TABLE "public"."user_session_note" ADD CONSTRAINT "fk5edfb00ff51d3472" FOREIGN KEY ("user_session") REFERENCES "public"."user_session" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Keys structure for table web_origins
-- ----------------------------
ALTER TABLE "public"."web_origins" ADD CONSTRAINT "fk_lojpho213xcx4wnkog82ssrfy" FOREIGN KEY ("client_id") REFERENCES "public"."client" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
