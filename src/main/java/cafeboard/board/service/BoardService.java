package cafeboard.board.service;

import cafeboard.board.dto.BoardRequest;
import cafeboard.board.dto.BoardResponse;
import cafeboard.board.entity.Board;
import cafeboard.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public void update(Long boardId, BoardRequest rq) {
        Board board = boardRepository.findById(boardId).orElseThrow(()->new IllegalArgumentException("존재하느 않는 게시판입니다."));
        board.update(rq);
    }
}
