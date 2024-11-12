package duke.dancepop.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    public static String LOCAL_DATETIME_OUTPUT = "MMM dd yyyy HH:mm";

    public static LocalDateTime toLocalDateTime(String localDateTime) {

    }

    public static String toString(LocalDateTime localDateTime) {
        // Taken from course site
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(LOCAL_DATETIME_OUTPUT);
        return localDateTime.format(formatter);
    }
}
