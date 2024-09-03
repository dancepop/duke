package duke.dancepop.exceptions;

import duke.dancepop.Log;

import java.text.MessageFormat;

public class MissingInputException extends InputException {

    private String description;

    public MissingInputException(String description) {
        super();
        this.description = description;
    }

    public String getMessage() {
        return MessageFormat.format(ExceptionConsts.DESCRIPTION_CANNOT_BE_EMPTY, description);
    }
}
