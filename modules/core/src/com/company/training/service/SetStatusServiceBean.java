package com.company.training.service;

import com.company.training.core.SetStatusBean;
import com.company.training.entity.Contract;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service(SetStatusService.NAME)
public class SetStatusServiceBean implements SetStatusService {
    @Inject
    private SetStatusBean setStatusBean;

    @Override
    public void setNewStatus(Contract contract) {
        setStatusBean.setStatus(contract, "New", "1");
    }

    @Override
    public void setInDiscussionStatus(Contract contract) {
        setStatusBean.setStatus(contract, "In discussion", "2");
    }

    @Override
    public void setActiveStatus(Contract contract) {
        setStatusBean.setStatus(contract, "Active", "3");
    }

    @Override
    public void setEndedStatus(Contract contract) {
        setStatusBean.setStatus(contract, "Ended", "4");
    }

    @Override
    public void setCancelledStatus(Contract contract) {
        setStatusBean.setStatus(contract, "Cancelled", "5");
    }

}