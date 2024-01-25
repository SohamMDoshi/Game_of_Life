import com.swiggy.board.Board;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    @Test
    public void setValueInBorad() {
        Board board = new Board(10,15);
        board.set(3,6,7);
        assertEquals(7,board.get(3,6));
    }
}
