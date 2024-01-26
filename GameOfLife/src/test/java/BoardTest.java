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
    public void testSet7AliveCells_ExpectCountOfAliveCells7() {
        int expectedAliveCells = 7;
        int rows = 3;
        int column = 5;
        int[] position = {2,3,6,1,4,9,11,7,5,12,14,0,8,10,13};
        Cell[][] cells = new Cell[rows][column];
        Board board = new Board(cells);
        board.setAliveCells(expectedAliveCells,position,rows,column);
        int actualCountOfAliveCells = 0;
        for (Cell[] cell : cells) {
            for (int j = 0; j < cells[0].length; j++) {
                if (cell[j].getStatus() == CellStatus.ALIVE) actualCountOfAliveCells++;
            }
        }
        assertEquals(expectedAliveCells,actualCountOfAliveCells);
    }

    @Test
    public void testCountAliveNeighbors_ExpectedFiveAliveNeighbor() {
        Cell[][] testCases = {
                {new Cell(CellStatus.ALIVE),new Cell(CellStatus.DEAD),new Cell(CellStatus.ALIVE)},
                {new Cell(CellStatus.DEAD),new Cell(CellStatus.ALIVE),new Cell(CellStatus.DEAD)},
                {new Cell(CellStatus.ALIVE),new Cell(CellStatus.ALIVE),new Cell(CellStatus.ALIVE)}
        };
        Board board = new Board(testCases);
        int neighborCount = board.countLiveNeighbor(1,1);
        assertEquals(5, neighborCount);
    }

    @Test
    public void testCountAliveNeighbors_ExpectedThreeAliveNeighbor() {
        Cell[][] testCases = {
                {new Cell(CellStatus.ALIVE),new Cell(CellStatus.DEAD),new Cell(CellStatus.ALIVE)},
                {new Cell(CellStatus.DEAD),new Cell(CellStatus.ALIVE),new Cell(CellStatus.DEAD)},
                {new Cell(CellStatus.ALIVE),new Cell(CellStatus.ALIVE),new Cell(CellStatus.ALIVE)}
        };
        Board board = new Board(testCases);
        int neighborCount1 = board.countLiveNeighbor(0,1);
        assertEquals(3,neighborCount1);
    }

    @Test
    public void testCountAliveNeighborsWithInvalidRowsAndColumns_ExpectedZeroAliveNeighbor() {
        Cell[][] testCases = {
                {new Cell(CellStatus.ALIVE),new Cell(CellStatus.DEAD),new Cell(CellStatus.ALIVE)},
                {new Cell(CellStatus.DEAD),new Cell(CellStatus.ALIVE),new Cell(CellStatus.DEAD)},
                {new Cell(CellStatus.ALIVE),new Cell(CellStatus.ALIVE),new Cell(CellStatus.ALIVE)}
        };
        Board board = new Board(testCases);
        int neighborCount2 = board.countLiveNeighbor(-1,8);
        assertEquals(0,neighborCount2);
    }
}
