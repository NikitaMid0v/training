alter table TRAINING_STAGE add constraint FK_TRAINING_STAGE_ON_INVOICE foreign key (INVOICE_ID) references TRAINING_INVOICE(ID);
alter table TRAINING_STAGE add constraint FK_TRAINING_STAGE_ON_SERVICE_COMPLETION_CERTIFICATE foreign key (SERVICE_COMPLETION_CERTIFICATE_ID) references TRAINING_SERVICE_COMPLETION_CERTIFICATE(ID);
create index IDX_TRAINING_STAGE_ON_INVOICE on TRAINING_STAGE (INVOICE_ID);
create index IDX_TRAINING_STAGE_ON_SERVICE_COMPLETION_CERTIFICATE on TRAINING_STAGE (SERVICE_COMPLETION_CERTIFICATE_ID);