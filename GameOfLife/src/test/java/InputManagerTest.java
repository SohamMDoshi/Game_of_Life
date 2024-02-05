import com.swiggy.InputManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class InputManagerTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final InputStream inputStream = System.in;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStream));
    }
    @AfterEach
    public void tearDown() {
        System.setIn(inputStream);
        System.setOut(new PrintStream(new ByteArrayOutputStream()));
    }

    @Test
    public void testRowInputWithValidIntegerInput() {
        String simulatedUserInput = "33\n";
        InputStream originalSystemIn = System.in;
        try {
            System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
            InputManager inputManager = new InputManager();
            int result = inputManager.getRowsInput();
            assertEquals(33, result);
        } finally {
            System.setIn(originalSystemIn);
        }
    }

    @Test
    public void testRowInputWithInvalidIntegerInput() {
        String simulatedUserInput = "dfhad;\n";
        InputStream originalSystemIn = System.in;
        try {
            System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
            InputManager inputManager = new InputManager();
            assertThrows(NoSuchElementException.class, () -> {
               int result = inputManager.getColumnsInput();
            });
        } finally {
            System.setIn(originalSystemIn);
        }
    }
}
