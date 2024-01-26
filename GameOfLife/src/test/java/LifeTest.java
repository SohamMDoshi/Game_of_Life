import com.swiggy.board.Board;
import com.swiggy.board.Cell;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LifeTest {

    @Test
    public void testIfLifeProbabilityIs20Percent () {
        int lifeCount=0;
        int rows = 20;
        int cols = 80;
        int expectedCount = (int) ((rows * cols) * 0.2);
        Board board = new Board(rows,cols);
        board.initializeBoard();
        for (int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                if(board.getValue(i,j) == 1) lifeCount++;
            }
        }
        assertEquals(expectedCount,lifeCount);
    }

    @Test
    public void testCountNeighbors() {
        Board board = new Board(20,80);
        board.setValue(2,2,1);
        board.setValue(2,3,1);
        board.setValue(1,1,1);
        board.setValue(3,3,1);
        board.setValue(1,2,1);
        board.setValue(8,7,1);
        board.setValue(8,6,1);
        int neighborCount = Cell.countNeighbors(3,2,board);
        assertEquals(3, neighborCount);
    }

    public void testCou
}
