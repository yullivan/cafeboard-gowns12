package cafeboard.board.service;

import cafeboard.board.dto.BoardRequest;
import cafeboard.board.dto.BoardResponse;
import cafeboard.board.entity.Board;
import cafeboard.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public void save(BoardRequest rq) {
        Board board = new Board(rq.name());
        boardRepository.save(board);
    }

    public List<BoardResponse> readAll() {
        return boardRepository.findAll().stream()
                .map(o -> new BoardResponse(
                        o.getId(),
                        o.getName()
                ))
                .toList();
    }
}
