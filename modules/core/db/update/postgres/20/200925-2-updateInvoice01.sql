alter table TRAINING_INVOICE rename column vat to vat__u20122 ;
alter table TRAINING_INVOICE add column VAT decimal(19, 2) ;
