import com.swiggy.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BoardTest {

    @Test
    public void testInitializationOfBoardWithOneCell_ExpectFalseToSecondGeneration() {
        Board board = new Board(4,3,0.09);
        assertTrue(board.canEvolve());
        board.display();
        board.nextGeneration();
        board.display();
        board.nextGeneration();
        assertFalse(board.canEvolve());
    }
}
