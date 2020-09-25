package com.company.training.web.screens.status;

import com.haulmont.cuba.gui.screen.*;
import com.company.training.entity.Status;

@UiController("training_Status.edit")
@UiDescriptor("status-edit.xml")
@EditedEntityContainer("statusDc")
@LoadDataBeforeShow
public class StatusEdit extends StandardEditor<Status> {
}