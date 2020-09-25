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
    VAT double precision not null,
    TOTAL_AMOUNT decimal(19, 2),
    DESCRIPTION text,
    INVOICE_ID uuid,
    SERVICE_COMPLETION_CERTIFICATE_ID uuid,
    --
    primary key (ID)
);