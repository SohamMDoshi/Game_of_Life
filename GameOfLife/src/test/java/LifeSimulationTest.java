import com.swiggy.Board;
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
        for (int i = 0; i < board.rows(); i++) {
            for (int j = 0; j < board.columns(); j++) {
                if(board.isCellAlive(i,j).status() == CellStatus.ALIVE) initializedLiveCellCount++;
            }
        }
        LifeSimulation simulation = new LifeSimulation(board);
        simulation.nextGeneration();
        int nextGenLiveCellCount = simulation.liveCellCount();
        assertNotEquals(initializedLiveCellCount,nextGenLiveCellCount);
    }
}
