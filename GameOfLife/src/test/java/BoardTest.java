import com.swiggy.board.Board;
import com.swiggy.board.Cell;
import com.swiggy.board.CellStatus;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

//    @Test
//    public void setValueInBorad() {
//        Board board = new Board(10,15);
//        board.setValue(3,6,7);
//        assertEquals(7,board.getValue(3,6));
//    }

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
