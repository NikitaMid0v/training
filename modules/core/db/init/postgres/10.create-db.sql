-- begin TRAINING_CONTRACT
create table TRAINING_CONTRACT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CUSTOMER_ID uuid not null,
    PERFORMER_ID uuid not null,
    NUMBER_ varchar(255),
    SIGNED_DATE date not null,
    TYPE_ varchar(50) not null,
    DATE_TO date,
    DATE_FROM date,
    AMOUNT decimal(19, 2) not null,
    CUSTOMER_SIGNER_ID uuid not null,
    STATUS_ID uuid,
    PERFORMER_SIGNER_ID uuid not null,
    VAT decimal(19, 2) not null,
    TOTAL_AMOUNT decimal(19, 2),
    --
    primary key (ID)
)^
-- end TRAINING_CONTRACT
-- begin TRAINING_STATUS
create table TRAINING_STATUS (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CODE varchar(255) not null,
    NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end TRAINING_STATUS
-- begin TRAINING_ORGANIZATION
create table TRAINING_ORGANIZATION (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    TAX_NUMBER varchar(255) not null,
    REGISTRATION_NUMBER varchar(255) not null,
    ESCAPE_VAT boolean,
    --
    primary key (ID)
)^
-- end TRAINING_ORGANIZATION
-- begin TRAINING_INVOICE
create table TRAINING_INVOICE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NUMBER_ varchar(255) not null,
    DATE_ timestamp not null,
    AMOUNT decimal(19, 2),
    VAT decimal(19, 2),
    TOTAL_AMOUNT decimal(19, 2),
    DESCRIPTION text,
    --
    primary key (ID)
)^
-- end TRAINING_INVOICE
-- begin TRAINING_SERVICE_COMPLETION_CERTIFICATE
create table TRAINING_SERVICE_COMPLETION_CERTIFICATE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NUMBER_ varchar(255) not null,
    DATE_ timestamp not null,
    VAT decimal(19, 2) not null,
    AMOUNT decimal(19, 2) not null,
    TOTAL_AMOUNT decimal(19, 2) not null,
    DESCRIPTION text,
    --
    primary key (ID)
)^
-- end TRAINING_SERVICE_COMPLETION_CERTIFICATE
-- begin TRAINING_CONTRACT_FILE_DESCRIPTOR_LINK
create table TRAINING_CONTRACT_FILE_DESCRIPTOR_LINK (
    CONTRACT_ID uuid,
    FILE_DESCRIPTOR_ID uuid,
    primary key (CONTRACT_ID, FILE_DESCRIPTOR_ID)
)^
-- end TRAINING_CONTRACT_FILE_DESCRIPTOR_LINK
-- begin TRAINING_STAGE
create table TRAINING_STAGE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    DATE_FROM date not null,
    DATE_TO date not null,
    AMOUNT decimal(19, 2),
    VAT decimal(19, 2) not null,
    TOTAL_AMOUNT decimal(19, 2),
    DESCRIPTION text,
    INVOICE_ID uuid,
    SERVICE_COMPLETION_CERTIFICATE_ID uuid,
    CONTRACT_ID uuid,
    --
    primary key (ID)
)^
-- end TRAINING_STAGE
-- begin TRAINING_SERVICE_COMPLETION_CERTIFICATE_FILE_DESCRIPTOR_LINK
create table TRAINING_SERVICE_COMPLETION_CERTIFICATE_FILE_DESCRIPTOR_LINK (
    SERVICE_COMPLETION_CERTIFICATE_ID uuid,
    FILE_DESCRIPTOR_ID uuid,
    primary key (SERVICE_COMPLETION_CERTIFICATE_ID, FILE_DESCRIPTOR_ID)
)^
-- end TRAINING_SERVICE_COMPLETION_CERTIFICATE_FILE_DESCRIPTOR_LINK
-- begin TRAINING_INVOICE_FILE_DESCRIPTOR_LINK
create table TRAINING_INVOICE_FILE_DESCRIPTOR_LINK (
    INVOICE_ID uuid,
    FILE_DESCRIPTOR_ID uuid,
    primary key (INVOICE_ID, FILE_DESCRIPTOR_ID)
)^
-- end TRAINING_INVOICE_FILE_DESCRIPTOR_LINK
