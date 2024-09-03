package duke.dancepop;

import duke.dancepop.exceptions.InputException;
import duke.dancepop.exceptions.ParseInputException;
import duke.dancepop.parser.Command;
import duke.dancepop.parser.Parser;

import java.util.Scanner;

public class UI {
    private static final Scanner scanner = new Scanner(System.in);

    public static void start() {
        Log.printMsg("Hello! I'm DancePop", "What can I do for you?");
        while (true) {
            String echo = getString();
            try {
                Command command = Parser.parse(echo);
                command.execute();
            } catch (InputException e) {
                Log.printMsg(e.getMessage());;
            }
        }
    }

    public static String getString() {
        return scanner.nextLine().trim();
    }
}
