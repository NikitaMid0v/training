package com.company.training.core;

import com.company.training.entity.Contract;
import com.company.training.entity.Status;
import com.company.training.service.EntityGeneratorService;
import com.haulmont.cuba.core.app.EmailService;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.EmailInfo;
import com.haulmont.cuba.core.global.EmailInfoBuilder;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component(SetStatusBean.NAME)
public class SetStatusBean {
    public static final String NAME = "training_SetStatusBean";
    @Inject
    private DataManager dataManager;
    @Inject
    private EntityGeneratorService entityGeneratorService;
    @Inject
    private EmailService emailService;

    public void setStatus(Contract contract, String statusName, String statusCode){
        contract = dataManager.reload(contract, "contract-view");
        Status status = entityGeneratorService.generateStatus(statusName, statusCode);
        contract.setStatus(dataManager.commit(status));
        dataManager.commit(contract);

        EmailInfo emailInfo = EmailInfoBuilder.create()
                .setAddresses("trainingtask@yandex.ru")
                .setCaption("status was edited")
                .setFrom(null)
                .setBody("status on contract " +contract.getNumber() + " was edited to " + statusName)
                .build();
        emailService.sendEmailAsync(emailInfo);
    }
}