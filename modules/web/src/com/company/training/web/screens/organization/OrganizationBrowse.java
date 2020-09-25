package com.company.training.web.screens.organization;

import com.haulmont.cuba.gui.screen.*;
import com.company.training.entity.Organization;

@UiController("training_Organization.browse")
@UiDescriptor("organization-browse.xml")
@LookupComponent("organizationsTable")
@LoadDataBeforeShow
public class OrganizationBrowse extends StandardLookup<Organization> {
}