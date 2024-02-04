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

        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                if (board.getCell(i,j).getStatus() == CellStatus.ALIVE) actualLiveCellCount++;
            }
        }

        assertEquals(expectedLiveCellCount,actualLiveCellCount);
    }
}
