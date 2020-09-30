package com.company.training.web.screens.stage;

import com.company.training.entity.Contract;
import com.company.training.entity.Invoice;
import com.company.training.entity.ServiceCompletionCertificate;
import com.company.training.entity.Stage;
import com.company.training.service.ReportProviderService;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.TimeSource;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.reports.gui.ReportGuiManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.Optional;

@UiController("training_Stage.browse")
@UiDescriptor("stage-browse.xml")
@LookupComponent("stagesTable")
@LoadDataBeforeShow
public class StageBrowse extends StandardLookup<Stage> {
    private static final Logger log = LoggerFactory.getLogger(StageBrowse.class);
    @Inject
    private GroupTable<Stage> stagesTable;

    @Inject
    private DataContext dataContext;

    @Inject
    private TimeSource timeSource;

    @Inject
    private DataManager dataManager;

    @Inject
    private ReportGuiManager reportGuiManager;

    @Inject
    private ReportProviderService reportProviderService;

    public void onCreateInvoiceAndCertificateBtnClick() {
        stagesTable.getSelected().forEach(stage -> {
            stage.setInvoice(createInvoice(stage));
            stage.setServiceCompletionCertificate(createCertificate(stage));
            dataManager.commit(stage);
        });
    }

    private Invoice createInvoice(Stage stage) {
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

    private ServiceCompletionCertificate createCertificate(Stage stage) {
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

    @Subscribe("stagesTable.runInvoiceReport")
    public void onStagesTableRunInvoiceReport(Action.ActionPerformedEvent event) {
        reportGuiManager.runReport(reportProviderService.getReport("Invoice"), this);

    }

    @Subscribe("stagesTable.runCertificateReport")
    public void onStagesTableRunCertificateReport(Action.ActionPerformedEvent event) {
        reportGuiManager.runReport(reportProviderService.getReport("Certificate"), this);
    }


}