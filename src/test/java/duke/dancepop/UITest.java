package duke.dancepop;

import duke.dancepop.enums.CommandEnum;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class UITest {
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setup() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void tearDown() {
        System.setIn(System.in);
        System.setOut(System.out);
    }

    @Test
    void testUIStart() {
        setInput("test");

        UI.start();

        String output = outputStream.toString();
        assertTrue(output.contains("Hello! I'm DancePop"));
        assertTrue(output.contains("What can I do for you?"));
    }

    private void setInput(String input) {
        input += "\n" + CommandEnum.BYE.getValue();
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}
