package com.company.training.web.screens.stage;

import com.haulmont.cuba.gui.screen.*;
import com.company.training.entity.Stage;

@UiController("training_Stage.browse")
@UiDescriptor("stage-browse.xml")
@LookupComponent("stagesTable")
@LoadDataBeforeShow
public class StageBrowse extends StandardLookup<Stage> {
}