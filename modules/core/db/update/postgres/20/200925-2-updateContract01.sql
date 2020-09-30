alter table TRAINING_CONTRACT rename column vat to vat__u77685 ;
alter table TRAINING_CONTRACT alter column vat__u77685 drop not null ;
alter table TRAINING_CONTRACT rename column signed_date to signed_date__u76716 ;
alter table TRAINING_CONTRACT alter column signed_date__u76716 drop not null ;
alter table TRAINING_CONTRACT add column SIGNED_DATE date ^
update TRAINING_CONTRACT set SIGNED_DATE = current_date where SIGNED_DATE is null ;
alter table TRAINING_CONTRACT alter column SIGNED_DATE set not null ;
alter table TRAINING_CONTRACT add column VAT decimal(19, 2) ^
update TRAINING_CONTRACT set VAT = 0 where VAT is null ;
alter table TRAINING_CONTRACT alter column VAT set not null ;
