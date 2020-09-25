alter table TRAINING_CONTRACT rename column vat to vat__u01476 ;
alter table TRAINING_CONTRACT alter column vat__u01476 drop not null ;
alter table TRAINING_CONTRACT rename column date_to to date_to__u13370 ;
alter table TRAINING_CONTRACT rename column date_from to date_from__u89718 ;
alter table TRAINING_CONTRACT add column DATE_FROM date ;
alter table TRAINING_CONTRACT add column DATE_TO date ;
alter table TRAINING_CONTRACT add column VAT double precision ^
update TRAINING_CONTRACT set VAT = 0 where VAT is null ;
alter table TRAINING_CONTRACT alter column VAT set not null ;
