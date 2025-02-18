package cafeboard.board.entity;

import cafeboard.BaseTimeEntity;
import cafeboard.board.dto.BoardRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
@RequiredArgsConstructor
public class Board extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @Column(nullable = false,unique = true)
    private String name;


    public void update(BoardRequest rq) {
        name=rq.name();
    }
}
