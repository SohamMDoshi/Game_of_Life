import com.swiggy.Board;
import com.swiggy.CellStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    @Test
    public void testInitializationOfBoard() {
        Board board = new Board(4,3,0.5);
        board.initializeBoard();

        int expectedLiveCellCount = 6;
        int actualLiveCellCount = 0;

        for (int i = 0; i < board.rows(); i++) {
            for (int j = 0; j < board.columns(); j++) {
                if (board.isCellAlive(i,j).status() == CellStatus.ALIVE) actualLiveCellCount++;
            }
        }

        assertEquals(expectedLiveCellCount,actualLiveCellCount);
    }
}
