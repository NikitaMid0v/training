insert into SYS_SCHEDULED_TASK
(ID, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, DEFINED_BY, SYS_TENANT_ID, BEAN_NAME, METHOD_NAME, CLASS_NAME, SCRIPT_NAME, USER_NAME, IS_SINGLETON, IS_ACTIVE, PERIOD_, TIMEOUT, START_DATE, CRON, SCHEDULING_TYPE, TIME_FRAME, START_DELAY, PERMITTED_SERVERS, LOG_START, LOG_FINISH, LAST_START_TIME, LAST_START_SERVER, METHOD_PARAMS, DESCRIPTION)
values ('8d85a291-82ba-7ea0-5347-a715634ebfa1', '2020-10-01 12:42:34', 'admin', '2020-10-01 12:49:00', 'admin', null, null, 'B', null, 'cuba_FtsManager', 'processQueue', null, null, null, true, true, 30, null, '2020-10-01 00:00:00', null, 'P', null, null, null, null, null, '2020-10-01 12:49:00', 'localhost:8080/app-core', '<?xml version="1.0" encoding="UTF-8"?>

<params/>
', null);
