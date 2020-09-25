package com.company.training.web.screens.stage;

import com.haulmont.cuba.gui.screen.*;
import com.company.training.entity.Stage;

@UiController("training_Stage.edit")
@UiDescriptor("stage-edit.xml")
@EditedEntityContainer("stageDc")
@LoadDataBeforeShow
public class StageEdit extends StandardEditor<Stage> {
}