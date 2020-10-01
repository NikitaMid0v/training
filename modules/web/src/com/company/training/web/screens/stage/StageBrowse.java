package com.company.training.web.screens.stage;

import com.company.training.entity.Stage;
import com.company.training.service.EntityGeneratorService;
import com.company.training.service.ReportProviderService;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.reports.gui.ReportGuiManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

@UiController("training_Stage.browse")
@UiDescriptor("stage-browse.xml")
@LookupComponent("stagesTable")
@LoadDataBeforeShow
public class StageBrowse extends StandardLookup<Stage> {
    private static final Logger log = LoggerFactory.getLogger(StageBrowse.class);
    @Inject
    private GroupTable<Stage> stagesTable;

    @Inject
    private DataManager dataManager;

    @Inject
    private ReportGuiManager reportGuiManager;

    @Inject
    private ReportProviderService reportProviderService;

    @Inject
    private EntityGeneratorService entityGeneratorService;

    public void onCreateInvoiceAndCertificateBtnClick() {
        stagesTable.getSelected().forEach(stage -> {
            stage.setInvoice(dataManager.commit(entityGeneratorService.generateInvoice(stage)));
            stage.setServiceCompletionCertificate(dataManager.commit(entityGeneratorService.generateCertificate(stage)));
            dataManager.commit(stage);
        });
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