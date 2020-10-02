package com.company.training.service;

import com.company.training.entity.Contract;
import com.company.training.entity.Status;

public interface SetStatusService {
    String NAME = "training_SetStatusService";

    void setNewStatus(Contract contract);

    void setInDiscussionStatus(Contract contract);

    void setActiveStatus(Contract contract);

    void setEndedStatus(Contract contract);

    void setCancelledStatus(Contract contract);
}