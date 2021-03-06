package domain.usecase.task.create;

import domain.aggregate.card.Card;
import domain.aggregate.card.Task;
import domain.usecase.card.repository.ICardRepository;

public class CreateTaskUseCase {
    private ICardRepository cardRepository;
    private Task task;

    public CreateTaskUseCase(ICardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public void execute(CreateTaskUseCaseInput input, CreateTaskUseCaseOutput output) {
        Card card = cardRepository.getCardById(input.getCardId());
        task = card.createTask(input.getCardId(), input.getTaskName());

        card.addTaskId(task);
        cardRepository.save(card);

        output.setCardId(task.getCardId());
        output.setTaskId(task.getTaskId());
        output.setTaskName(task.getTaskName());
    }
}
