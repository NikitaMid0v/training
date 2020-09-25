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
    SIGNED_DATE timestamp not null,
    TYPE_ varchar(50) not null,
    --
    primary key (ID)
);