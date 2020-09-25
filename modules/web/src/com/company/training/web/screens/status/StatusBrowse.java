package com.company.training.web.screens.status;

import com.haulmont.cuba.gui.screen.*;
import com.company.training.entity.Status;

@UiController("training_Status.browse")
@UiDescriptor("status-browse.xml")
@LookupComponent("statusesTable")
@LoadDataBeforeShow
public class StatusBrowse extends StandardLookup<Status> {
}