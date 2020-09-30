package com.company.training.web.screens.stage;

import com.company.training.entity.Contract;
import com.company.training.entity.Invoice;
import com.company.training.entity.ServiceCompletionCertificate;
import com.haulmont.cuba.core.global.TimeSource;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.screen.*;
import com.company.training.entity.Stage;

import javax.inject.Inject;
import java.util.Optional;

@UiController("training_Stage.edit")
@UiDescriptor("stage-edit.xml")
@EditedEntityContainer("stageDc")
@LoadDataBeforeShow
public class StageEdit extends StandardEditor<Stage> {
    @Inject
    private DataContext dataContext;
    @Inject
    private TimeSource timeSource;

    private Invoice createInvoice(Stage stage){
        Optional<Stage> stageOptional = Optional.ofNullable(stage);
        Invoice invoice = dataContext.create(Invoice.class);
        invoice.setAmount(stage.getAmount());
        invoice.setDate(timeSource.currentTimestamp());
        invoice.setVat(stage.getVat());
        invoice.setTotalAmount(stage.getTotalAmount());
        invoice.setDescription(stage.getDescription());
        invoice.setNumber(stageOptional.map(Stage::getContract).map(Contract::getNumber).orElse(null));
        invoice.setFiles(stageOptional.map(Stage::getContract).map(Contract::getFiles).orElse(null));
        return invoice;
    }

    private ServiceCompletionCertificate createCertificate(Stage stage){
        Optional<Stage> stageOptional = Optional.ofNullable(stage);
        ServiceCompletionCertificate certificate = dataContext.create(ServiceCompletionCertificate.class);
        certificate.setAmount(stage.getAmount());
        certificate.setDate(timeSource.currentTimestamp());
        certificate.setVat(stage.getVat());
        certificate.setTotalAmount(stage.getTotalAmount());
        certificate.setDescription(stage.getDescription());
        certificate.setNumber(stageOptional.map(Stage::getContract).map(Contract::getNumber).orElse(null));
        certificate.setFiles(stageOptional.map(Stage::getContract).map(Contract::getFiles).orElse(null));
        return certificate;
    }

    public void onCreateInvoiceAndCertificateBtnClick() {
        Stage stage = getEditedEntity();
        stage.setInvoice(createInvoice(stage));
        stage.setServiceCompletionCertificate(createCertificate(stage));
    }
}