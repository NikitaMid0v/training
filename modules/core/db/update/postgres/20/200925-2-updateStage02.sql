alter table TRAINING_STAGE rename column vat to vat__u87961 ;
alter table TRAINING_STAGE alter column vat__u87961 drop not null ;
alter table TRAINING_STAGE add column VAT decimal(19, 2) ^
update TRAINING_STAGE set VAT = 0 where VAT is null ;
alter table TRAINING_STAGE alter column VAT set not null ;
