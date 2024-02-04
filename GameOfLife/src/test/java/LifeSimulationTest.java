import com.swiggy.Board;
import com.swiggy.Cell;
import com.swiggy.CellStatus;
import com.swiggy.LifeSimulation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LifeSimulationTest {

    @Test
    public void testNextGeneration_ExpectDifferentCountOfAliveCells() {
        Board board = new Board(3,5,0.4);
        board.initializeBoard();
        int initializedLiveCellCount = 0;
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                if(board.getCell(i,j).getStatus() == CellStatus.ALIVE) initializedLiveCellCount++;
            }
        }
        LifeSimulation simulation = new LifeSimulation(board);
        simulation.nextGeneration();
        int nextGenLiveCellCount = simulation.getLiveCellCount();
        assertNotEquals(initializedLiveCellCount,nextGenLiveCellCount);
    }
}
