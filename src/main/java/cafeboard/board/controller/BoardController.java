package cafeboard.board.controller;

import cafeboard.board.dto.BoardRequest;
import cafeboard.board.dto.BoardResponse;
import cafeboard.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;

    @PostMapping("")
    public void createBoard(@RequestBody BoardRequest rq){
        boardService.save(rq);
    }

    @GetMapping("")
    public List<BoardResponse> readBoardList(){
        return boardService.readAll();
    }

    @PutMapping("/{boardId}")
    public void updateBoard(@PathVariable Long boardId, @RequestBody BoardRequest rq){
        boardService.update(boardId,rq);
    }
}
