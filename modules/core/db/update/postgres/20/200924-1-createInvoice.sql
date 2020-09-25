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
    VAT integer,
    TOTAL_AMOUNT decimal(19, 2),
    DESCRIPTION text,
    --
    primary key (ID)
);