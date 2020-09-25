alter table TRAINING_CONTRACT add column AMOUNT decimal(19, 2) ^
update TRAINING_CONTRACT set AMOUNT = 0 where AMOUNT is null ;
alter table TRAINING_CONTRACT alter column AMOUNT set not null ;
alter table TRAINING_CONTRACT add column TOTAL_AMOUNT decimal(19, 2) ;
-- alter table TRAINING_CONTRACT add column STATUS_ID uuid ^
-- update TRAINING_CONTRACT set STATUS_ID = <default_value> ;
-- alter table TRAINING_CONTRACT alter column STATUS_ID set not null ;
alter table TRAINING_CONTRACT add column STATUS_ID uuid not null ;
alter table TRAINING_CONTRACT add column DATE_FROM timestamp ;
alter table TRAINING_CONTRACT add column DATE_TO timestamp ;
alter table TRAINING_CONTRACT add column CUSTOMER_SIGNER_ID uuid ;
alter table TRAINING_CONTRACT add column VAT integer ^
update TRAINING_CONTRACT set VAT = 0 where VAT is null ;
alter table TRAINING_CONTRACT alter column VAT set not null ;
alter table TRAINING_CONTRACT add column PERFORMER_SIGNER_ID uuid ;
