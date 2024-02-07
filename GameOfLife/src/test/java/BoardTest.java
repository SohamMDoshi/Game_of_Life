import com.swiggy.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BoardTest {

    @Test
    public void testInitializationOfBoardWithZeroCell_ExpectFalse() {
        Board board = new Board(4,3,0.03);
        assertFalse(board.canEvolve());
    }

    @Test
    public void testInitializationOfBoardWithOneCell_ExpectFalse() {
        Board board = new Board(4,3,0.09);
        assertFalse(board.canEvolve());
    }

    @Test
    public void testInitializationOfBoardWithFourCell_ExpectTrue() {
        Board board = new Board(4,3,0.4);
        assertTrue(board.canEvolve());
    }

    @Test
    public void testInitializationOfBoardWithThreeCell_ExpectTrue() {
        Board board = new Board(4,3,0.25);
        assertTrue(board.canEvolve());
    }
}
