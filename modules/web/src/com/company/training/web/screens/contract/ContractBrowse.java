package com.company.training.web.screens.contract;

import com.haulmont.cuba.gui.screen.*;
import com.company.training.entity.Contract;

@UiController("training_Contract.browse")
@UiDescriptor("contract-browse.xml")
@LookupComponent("contractsTable")
@LoadDataBeforeShow
public class ContractBrowse extends StandardLookup<Contract> {
}