import com.swiggy.board.Board;
import com.swiggy.board.Cell;
import com.swiggy.board.CellStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CellTest {

    @Test
    public void TestDeadCellWith3AliveNeighbors_ExpectCellStatusBecomeAlive () {
        Cell cell = new Cell(CellStatus.DEAD);
        cell.evolve(3);
        assertEquals(CellStatus.ALIVE, cell.getStatus());
    }
    @Test
    public void TestAliveCellWith3AliveNeighbors_ExpectCellStatusRemainAlive () {
        Cell cell = new Cell(CellStatus.ALIVE);
        cell.evolve(3);
        assertEquals(CellStatus.ALIVE, cell.getStatus());
    }
    @Test
    public void TestAliveCellWith4AliveNeighbors_ExpectCellStatusBecomeDead () {
        Cell cell = new Cell(CellStatus.ALIVE);
        cell.evolve(4);
        assertEquals(CellStatus.DEAD, cell.getStatus());
    }

    @Test
    public void TestAliveCellWith1AliveNeighbors_ExpectCellStatusBecomeDead () {
        Cell cell = new Cell(CellStatus.ALIVE);
        cell.evolve(1);
        assertEquals(CellStatus.DEAD, cell.getStatus());
    }
}