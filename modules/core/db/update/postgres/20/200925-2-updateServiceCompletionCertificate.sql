alter table TRAINING_SERVICE_COMPLETION_CERTIFICATE rename column vat to vat__u35753 ;
alter table TRAINING_SERVICE_COMPLETION_CERTIFICATE alter column vat__u35753 drop not null ;
alter table TRAINING_SERVICE_COMPLETION_CERTIFICATE add column VAT double precision ^
update TRAINING_SERVICE_COMPLETION_CERTIFICATE set VAT = 0 where VAT is null ;
alter table TRAINING_SERVICE_COMPLETION_CERTIFICATE alter column VAT set not null ;
