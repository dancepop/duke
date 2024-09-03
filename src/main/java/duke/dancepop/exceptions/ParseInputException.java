package duke.dancepop.exceptions;

import duke.dancepop.Log;

public class ParseInputException extends InputException {

    public ParseInputException() {
        super();
    }

    public String getMessage() {
        return ExceptionConsts.UNKNOWN_COMMAND;
    }
}
