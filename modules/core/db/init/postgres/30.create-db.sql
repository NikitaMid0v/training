insert into SYS_SCHEDULED_TASK
(ID, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, DEFINED_BY, SYS_TENANT_ID, BEAN_NAME, METHOD_NAME, CLASS_NAME, SCRIPT_NAME, USER_NAME, IS_SINGLETON, IS_ACTIVE, PERIOD_, TIMEOUT, START_DATE, CRON, SCHEDULING_TYPE, TIME_FRAME, START_DELAY, PERMITTED_SERVERS, LOG_START, LOG_FINISH, LAST_START_TIME, LAST_START_SERVER, METHOD_PARAMS, DESCRIPTION)
values ('8d85a291-82ba-7ea0-5347-a715634ebfa1', '2020-10-01 12:42:34', 'admin', '2020-10-01 12:49:00', 'admin', null, null, 'B', null, 'cuba_FtsManager', 'processQueue', null, null, null, true, true, 30, null, '2020-10-01 00:00:00', null, 'P', null, null, null, null, null, '2020-10-01 12:49:00', 'localhost:8080/app-core', '<?xml version="1.0" encoding="UTF-8"?>

<params/>
', null);
insert into SYS_SCHEDULED_TASK
(ID, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, DEFINED_BY, SYS_TENANT_ID, BEAN_NAME, METHOD_NAME, CLASS_NAME, SCRIPT_NAME, USER_NAME, IS_SINGLETON, IS_ACTIVE, PERIOD_, TIMEOUT, START_DATE, CRON, SCHEDULING_TYPE, TIME_FRAME, START_DELAY, PERMITTED_SERVERS, LOG_START, LOG_FINISH, LAST_START_TIME, LAST_START_SERVER, METHOD_PARAMS, DESCRIPTION)
values ('9e4f2204-0cdf-2a23-914e-1226a4854631', '2020-10-02 12:18:04', 'manager', '2020-10-02 14:30:47', 'admin', null, null, 'B', null, 'cuba_Emailer', 'processQueuedEmails', null, null, null, true, true, 10, null, null, null, 'P', null, null, null, null, null, '2020-10-02 14:30:47', 'localhost:8080/app-core', '<?xml version="1.0" encoding="UTF-8"?>

<params/>
', null);

insert into TRAINING_ORGANIZATION
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME, TAX_NUMBER, REGISTRATION_NUMBER, ESCAPE_VAT)
values ('f50a859f-3d0a-8e47-ed76-6581c0d58d37', 1, '2020-09-30 12:50:56', 'admin', '2020-09-30 12:50:56', null, null, null, 'OOO Performer', '132-12112-3', '12333-21', true);

insert into TRAINING_ORGANIZATION
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME, TAX_NUMBER, REGISTRATION_NUMBER, ESCAPE_VAT)
values ('b5a0df3f-92e5-67bb-4e41-820681d70bd9', 1, '2020-09-30 12:51:29', 'admin', '2020-09-30 12:51:29', null, null, null, 'OOO Customer', '1113-12321', '133321-12', true);

insert into SEC_USER
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, LOGIN, LOGIN_LC, PASSWORD, PASSWORD_ENCRYPTION, NAME, FIRST_NAME, LAST_NAME, MIDDLE_NAME, POSITION_, EMAIL, LANGUAGE_, TIME_ZONE, TIME_ZONE_AUTO, ACTIVE, CHANGE_PASSWORD_AT_LOGON, GROUP_ID, GROUP_NAMES, IP_MASK, SYS_TENANT_ID)
values ('805f3d8f-89f2-a457-a4ca-2b7d3ceadcf4', 7, '2020-10-01 10:44:28', 'admin', '2020-10-02 11:15:39', 'admin', null, null, 'manager', 'manager', '$2a$10$wP5V6N.VXDS7YEQFvDyDiOBcHCvF2BFv6BMZQj/fxnQAG7Z/gOlZa', 'bcrypt', 'manager manager', 'manager', 'manager', 'manager', 'manager', 'manager@manager', 'en', null, null, true, false, '0fa2b1a5-1d68-4d69-9fbd-dff348347f93', null, null, null);

insert into SEC_USER
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, LOGIN, LOGIN_LC, PASSWORD, PASSWORD_ENCRYPTION, NAME, FIRST_NAME, LAST_NAME, MIDDLE_NAME, POSITION_, EMAIL, LANGUAGE_, TIME_ZONE, TIME_ZONE_AUTO, ACTIVE, CHANGE_PASSWORD_AT_LOGON, GROUP_ID, GROUP_NAMES, IP_MASK, SYS_TENANT_ID)
values ('a86c7cf1-0f47-e271-519a-fbe72258d3fe', 6, '2020-10-01 10:45:29', 'admin', '2020-10-02 11:15:20', 'admin', null, null, 'Initiator', 'initiator', '$2a$10$Q678WpM39hJ.OS.LQihqJuz6vF9Wp/O4zq2b/vH4M03Q/e61W/2bS', 'bcrypt', 'Initiator Initiator', 'Initiator', 'Initiator', 'Initiator', 'Initiator', 'Initiator@Initiator', 'en', null, null, true, false, '0fa2b1a5-1d68-4d69-9fbd-dff348347f93', null, null, null);

insert into SEC_ROLE
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME, LOC_NAME, DESCRIPTION, ROLE_TYPE, IS_DEFAULT_ROLE, SYS_TENANT_ID, SECURITY_SCOPE)
values ('48d4e3f4-c968-6212-487d-07fc1e5497b6', 3, '2020-09-30 18:21:26', 'admin', '2020-10-02 11:13:52', 'admin', null, null, 'Initiator', null, null, 0, false, null, 'GENERIC_UI');

insert into SEC_PERMISSION
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE_, ROLE_ID)
values ('794a9259-b676-1b58-3e07-fec92878dc93', 1, '2020-10-02 11:06:34', 'admin', '2020-10-02 11:06:34', null, null, null, 10, 'training_Contract.browse', 1, '48d4e3f4-c968-6212-487d-07fc1e5497b6');

insert into SEC_PERMISSION
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE_, ROLE_ID)
values ('eb464b6c-3eff-d77f-8c28-05389cda9357', 1, '2020-10-02 11:06:34', 'admin', '2020-10-02 11:06:34', null, null, null, 10, 'bproc_MyTasks.browse', 1, '48d4e3f4-c968-6212-487d-07fc1e5497b6');

insert into SEC_ROLE
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME, LOC_NAME, DESCRIPTION, ROLE_TYPE, IS_DEFAULT_ROLE, SYS_TENANT_ID, SECURITY_SCOPE)
values ('44a0d5c4-dd53-801a-ba23-c88d9db7afaf', 3, '2020-09-30 18:21:45', 'admin', '2020-10-02 11:13:51', 'admin', null, null, 'Manager', null, null, 0, false, null, 'GENERIC_UI');

insert into SEC_PERMISSION
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE_, ROLE_ID)
values ('63fcd897-0e18-d2b0-ee80-23b084df87a0', 1, '2020-10-02 11:08:08', 'admin', '2020-10-02 11:08:08', null, null, null, 10, 'bproc_MyTasks.browse', 1, '44a0d5c4-dd53-801a-ba23-c88d9db7afaf');

insert into SEC_PERMISSION
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE_, ROLE_ID)
values ('c685f808-12c6-3ffe-5dc4-ed6db31227c6', 1, '2020-10-02 11:08:08', 'admin', '2020-10-02 11:08:08', null, null, null, 10, 'report$Report.browse', 1, '44a0d5c4-dd53-801a-ba23-c88d9db7afaf');

insert into SEC_PERMISSION
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE_, ROLE_ID)
values ('6ad838f6-af40-9632-74b7-481f23774aa9', 1, '2020-10-02 11:08:08', 'admin', '2020-10-02 11:08:08', null, null, null, 10, 'application-training', 1, '44a0d5c4-dd53-801a-ba23-c88d9db7afaf');

