package cafeboard.board.service;

import cafeboard.board.dto.BoardRequest;
import cafeboard.board.entity.Board;
import cafeboard.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public void save(BoardRequest rq) {
        Board board = new Board(rq.name());
        boardRepository.save(board);
    }
}
