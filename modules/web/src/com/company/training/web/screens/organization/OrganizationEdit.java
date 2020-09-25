package com.company.training.web.screens.organization;

import com.haulmont.cuba.gui.screen.*;
import com.company.training.entity.Organization;

@UiController("training_Organization.edit")
@UiDescriptor("organization-edit.xml")
@EditedEntityContainer("organizationDc")
@LoadDataBeforeShow
public class OrganizationEdit extends StandardEditor<Organization> {
}