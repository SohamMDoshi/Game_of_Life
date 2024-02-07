import com.swiggy.ConsoleInput;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class ConsoleInputTest {

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
            ConsoleInput consoleInput = new ConsoleInput();
            int result = consoleInput.getRowsInput();
            assertEquals(33, result);
        } finally {
            System.setIn(originalSystemIn);
        }
    }

    @Test
    public void testRowInputWithInvalidIntegerInput() {
        String simulatedUserInput = "-33\n";
        InputStream originalSystemIn = System.in;
        try {
            System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
            ConsoleInput consoleInput = new ConsoleInput();
            assertThrows(NoSuchElementException.class, consoleInput::getColumnsInput);
        } finally {
            System.setIn(originalSystemIn);
        }
    }
}
