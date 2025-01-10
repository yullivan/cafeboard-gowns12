package cafeboard.board.controller;

import cafeboard.board.dto.BoardRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
public class BoardController {

    @PostMapping("")
    public void createBoard(@RequestBody BoardRequest rq){
    }
}
