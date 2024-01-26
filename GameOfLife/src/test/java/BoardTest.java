import com.swiggy.board.Board;
import com.swiggy.board.Cell;
import com.swiggy.board.CellStatus;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BoardTest {

    @Test
    public void testShuffleArrayIndexes_ExpectShuffledArray() {
        Board board = new Board();
        int[] originalArray = new int[5];
        int[] copyOfOriginalArray = new int[5];
        for (int i = 0; i < originalArray.length; i++) {
            originalArray[i] = i;
            copyOfOriginalArray[i] = i;
        }
        Random random = new Random();
        board.shuffle(random, originalArray);
        assertNotEquals(Arrays.toString(copyOfOriginalArray), Arrays.toString(originalArray));
    }

    @Test
    public void testCountAliveNeighbors() {
        Cell[][] testCases = {
                {new Cell(CellStatus.ALIVE),new Cell(CellStatus.DEAD),new Cell(CellStatus.ALIVE)},
                {new Cell(CellStatus.DEAD),new Cell(CellStatus.ALIVE),new Cell(CellStatus.DEAD)},
                {new Cell(CellStatus.ALIVE),new Cell(CellStatus.ALIVE),new Cell(CellStatus.ALIVE)}
        };
        Board board = new Board(testCases);
        int neighborCount = board.countLiveNeighbor(1,1);
        assertEquals(5, neighborCount);
        int neighborCount1 = board.countLiveNeighbor(0,1);
        assertEquals(3,neighborCount1);
        int neighborCount2 = board.countLiveNeighbor(-1,8);
        assertEquals(0,neighborCount2);
    }
}
