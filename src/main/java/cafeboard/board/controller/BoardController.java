package cafeboard.board.controller;

import cafeboard.board.dto.BoardRequest;
import cafeboard.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;

    @PostMapping("")
    public void createBoard(@RequestBody BoardRequest rq){
        boardService.save(rq);
    }
}
