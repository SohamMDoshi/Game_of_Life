import com.swiggy.Cell;
import com.swiggy.CellStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    @Test
    public void TestDeadCellWith3AliveNeighbors_ExpectCellStatusBecomeAlive () {
        Cell cell = new Cell(CellStatus.DEAD);
        cell.evolve(3);
        assertTrue(cell.isAlive());
    }
    @Test
    public void TestAliveCellWith3AliveNeighbors_ExpectCellStatusRemainAlive () {
        Cell cell = new Cell(CellStatus.ALIVE);
        cell.evolve(3);
        assertTrue(cell.isAlive());
    }
    @Test
    public void TestAliveCellWith4AliveNeighbors_ExpectCellStatusBecomeDead () {
        Cell cell = new Cell(CellStatus.ALIVE);
        cell.evolve(4);
        assertFalse(cell.isAlive());
    }

    @Test
    public void TestAliveCellWith1AliveNeighbors_ExpectCellStatusBecomeDead () {
        Cell cell = new Cell(CellStatus.ALIVE);
        cell.evolve(1);
        assertFalse(cell.isAlive());
    }

}