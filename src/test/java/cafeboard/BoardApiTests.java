package cafeboard;

import cafeboard.board.dto.BoardRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BoardApiTests {

    @LocalServerPort
    int port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Test
    void createBoardTest() {
        RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .body(new BoardRequest("게시판 제목"))
                .when()
                .post("/boards")
                .then().log().all()
                .statusCode(200);
    }
}
