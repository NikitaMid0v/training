package com.company.training.web.screens.contract;

import com.haulmont.cuba.gui.screen.*;
import com.company.training.entity.Contract;

@UiController("training_Contract.edit")
@UiDescriptor("contract-edit.xml")
@EditedEntityContainer("contractDc")
@LoadDataBeforeShow
public class ContractEdit extends StandardEditor<Contract> {
}