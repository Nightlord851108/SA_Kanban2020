package domain.controller;

import domain.usecase.CreateWorkflowOutputInterface;

public class CreateWorkflowOutputImpl implements CreateWorkflowOutputInterface {
    private String workflowId;

    public String getWorkflowId() {
        return this.workflowId;
    }

    public void setWorkFlowId(String id) {
        this.workflowId = id;
    }
}
