package kanban.domain.usecase.board.repository;

import kanban.domain.model.aggregate.board.Board;

public interface IBoardRepository {
    void add(Board board);
}
