import com.swiggy.InputManager;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputManagerTest {

    @Test
    public void testIntegerInputWithNegativeIntegerInput() {
        InputManager inputManager = new InputManager();
        String simulatedUserInput = "33";
        InputStream originalSystemIn = System.in;
        try {
            System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
            int result = inputManager.getRowsInput();
            assertEquals(3, result);
        } finally {
            System.setIn(originalSystemIn);
        }
    }
}
