package com.company.training.web.screens.stage;

import com.company.training.entity.Stage;
import com.company.training.service.EntityGeneratorService;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("training_Stage.edit")
@UiDescriptor("stage-edit.xml")
@EditedEntityContainer("stageDc")
@LoadDataBeforeShow
public class StageEdit extends StandardEditor<Stage> {
    @Inject
    private DataContext dataContext;
    @Inject
    private EntityGeneratorService entityGeneratorService;

    public void onCreateInvoiceAndCertificateBtnClick() {
        Stage stage = getEditedEntity();

        stage.setInvoice(dataContext.merge(entityGeneratorService.generateInvoice(stage)));
        stage.setServiceCompletionCertificate(dataContext.merge(entityGeneratorService.generateCertificate(stage)));
    }
}