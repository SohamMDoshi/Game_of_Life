import com.swiggy.board.Board;
import com.swiggy.board.Cell;
import com.swiggy.board.CellStatus;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BoardTest {

    @Test
    public void testShuffleArrayIndexes_ExpectShuffledArray() throws Exception{
        Board board = new Board();
        int[] originalArray = new int[5];
        int[] copyOfOriginalArray = new int[5];
        for (int i = 0; i < originalArray.length; i++) {
            originalArray[i] = i;
            copyOfOriginalArray[i] = i;
        }
        Random random = new Random();
        Method shuffle = Board.class.getDeclaredMethod("shuffle", Random.class, int[].class);
        shuffle.setAccessible(true);
        shuffle.invoke(board,random, originalArray);
        assertNotEquals(Arrays.toString(copyOfOriginalArray), Arrays.toString(originalArray));
    }

    @Test
    public void testSet7AliveCells_ExpectCountOfAliveCells7() throws Exception{
        int expectedAliveCells = 7;
        int rows = 3;
        int column = 5;
        int[] position = {2,3,6,1,4,9,11,7,5,12,14,0,8,10,13};
        Cell[][] cells = new Cell[rows][column];
        Board board = new Board(cells);
        Method setAliveCells = Board.class.getDeclaredMethod("setAliveCells", int.class, int[].class, int.class, int.class);
        setAliveCells.setAccessible(true);
        setAliveCells.invoke(board,expectedAliveCells,position,rows,column);
        int actualCountOfAliveCells = 0;
        for (Cell[] cell : cells) {
            for (int j = 0; j < cells[0].length; j++) {
                if (cell[j].getStatus() == CellStatus.ALIVE) actualCountOfAliveCells++;
            }
        }
        assertEquals(expectedAliveCells,actualCountOfAliveCells);
    }

    @Test
    public void testCountAliveNeighbors_ExpectedFiveAliveNeighbor() throws Exception{
        Cell[][] testCases = {
                {new Cell(CellStatus.ALIVE),new Cell(CellStatus.DEAD),new Cell(CellStatus.ALIVE)},
                {new Cell(CellStatus.DEAD),new Cell(CellStatus.ALIVE),new Cell(CellStatus.DEAD)},
                {new Cell(CellStatus.ALIVE),new Cell(CellStatus.ALIVE),new Cell(CellStatus.ALIVE)}
        };
        Board board = new Board(testCases);
        Method countLiveNeighbor = Board.class.getDeclaredMethod("countLiveNeighbor", int.class, int.class);
        countLiveNeighbor.setAccessible(true);
        int neighborCount = (int) countLiveNeighbor.invoke(board,1,1);
        assertEquals(5,neighborCount);
    }

    @Test
    public void testCountAliveNeighbors_ExpectedThreeAliveNeighbor() throws Exception{
        Cell[][] testCases = {
                {new Cell(CellStatus.ALIVE),new Cell(CellStatus.DEAD),new Cell(CellStatus.ALIVE)},
                {new Cell(CellStatus.DEAD),new Cell(CellStatus.ALIVE),new Cell(CellStatus.DEAD)},
                {new Cell(CellStatus.ALIVE),new Cell(CellStatus.ALIVE),new Cell(CellStatus.ALIVE)}
        };
        Board board = new Board(testCases);
        Method countLiveNeighbor = Board.class.getDeclaredMethod("countLiveNeighbor", int.class, int.class);
        countLiveNeighbor.setAccessible(true);
        int neighborCount = (int) countLiveNeighbor.invoke(board,0,1);
        assertEquals(3,neighborCount);
    }

    @Test
    public void testCountAliveNeighborsWithInvalidRowsAndColumns_ExpectedZeroAliveNeighbor() throws Exception{
        Cell[][] testCases = {
                {new Cell(CellStatus.ALIVE),new Cell(CellStatus.DEAD),new Cell(CellStatus.ALIVE)},
                {new Cell(CellStatus.DEAD),new Cell(CellStatus.ALIVE),new Cell(CellStatus.DEAD)},
                {new Cell(CellStatus.ALIVE),new Cell(CellStatus.ALIVE),new Cell(CellStatus.ALIVE)}
        };
        Board board = new Board(testCases);
        Method countLiveNeighbor = Board.class.getDeclaredMethod("countLiveNeighbor", int.class, int.class);
        countLiveNeighbor.setAccessible(true);
        int neighborCount2 = (int) countLiveNeighbor.invoke(board,-1,8);
        assertEquals(0,neighborCount2);
    }

    @Test
    public void testGenerateAllPositions () throws Exception{
        Board board = new Board(3,4,10.0);
        Method generateAllPositions = Board.class.getDeclaredMethod("generateAllPositions", int.class);
        generateAllPositions.setAccessible(true);
        int[] positions = (int[]) generateAllPositions.invoke(board,3*4);
        assertEquals(12,positions.length);
    }
}
