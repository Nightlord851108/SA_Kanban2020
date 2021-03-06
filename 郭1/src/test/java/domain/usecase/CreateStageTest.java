package domain.usecase;

import domain.controller.CreateStageInputImpl;
import domain.controller.CreateStageOutputImpl;
import domain.controller.CreateWorkflowInputImpl;
import domain.controller.CreateWorkflowOutputImpl;
import domain.entity.Workflow;
import domain.usecase.stage.create.CreateStageInput;
import domain.usecase.stage.create.CreateStageOutput;
import domain.usecase.stage.create.CreateStageUseCase;
import domain.adapter.WorkflowRepositoryImpl;
import domain.usecase.workflow.create.CreateWorkflowInput;
import domain.usecase.workflow.create.CreateWorkflowOutput;
import domain.usecase.workflow.create.CreateWorkflowUseCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CreateStageTest {
    private WorkflowRepositoryImpl workflowRepository;
    private String workflowId;
    @Before
    public void setUp(){
        workflowRepository = new WorkflowRepositoryImpl();
        CreateWorkflowUseCase createWorkflowUseCase = new CreateWorkflowUseCase(workflowRepository);
        CreateWorkflowInput createWorkflowInput = new CreateWorkflowInputImpl();
        CreateWorkflowOutput createWorkflowOutput = new CreateWorkflowOutputImpl();
        createWorkflowInput.setWorkflowName("workflow1");
        createWorkflowUseCase.execute(createWorkflowInput, createWorkflowOutput);
        workflowId = createWorkflowOutput.getWorkflowId();

    }
    @Test
    public void createStage() {

        CreateStageUseCase createStage = new CreateStageUseCase(workflowRepository) ;
        CreateStageInput createStageInput = new CreateStageInputImpl() ;
        CreateStageOutput createStageOutput = new CreateStageOutputImpl() ;

        createStageInput.setStageName("backlog");
        createStageInput.setWorkflowId(workflowId);

        createStage.execute( createStageInput, createStageOutput ) ;

        assertNotNull(createStageOutput.getStageId());
    }
}
