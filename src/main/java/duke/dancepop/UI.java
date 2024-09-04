package duke.dancepop;

import duke.dancepop.exceptions.ExitException;
import duke.dancepop.exceptions.InputException;
import duke.dancepop.parser.Command;
import duke.dancepop.parser.Parser;

import java.util.Scanner;

public class UI {
    private static final Scanner scanner = new Scanner(System.in);

    public static void start() {
        Log.printMsg("Hello! I'm DancePop", "What can I do for you?");
        while (true) {
            String input = getString();
            try {
                Command command = Parser.parse(input);
                command.execute();
            } catch (InputException e) {
                Log.printMsg(e.getMessages().toArray(new String[0]));
            } catch (ExitException e) {
                return;
            }
        }
    }

    private static String getString() {
        return scanner.nextLine().trim();
    }
}
