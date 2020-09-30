alter table TRAINING_SERVICE_COMPLETION_CERTIFICATE rename column vat to vat__u63715 ;
alter table TRAINING_SERVICE_COMPLETION_CERTIFICATE alter column vat__u63715 drop not null ;
alter table TRAINING_SERVICE_COMPLETION_CERTIFICATE add column VAT decimal(19, 2) ^
update TRAINING_SERVICE_COMPLETION_CERTIFICATE set VAT = 0 where VAT is null ;
alter table TRAINING_SERVICE_COMPLETION_CERTIFICATE alter column VAT set not null ;
