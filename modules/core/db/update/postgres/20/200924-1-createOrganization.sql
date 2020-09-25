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
    ESCAPE_VAT decimal(19, 2),
    --
    primary key (ID)
);