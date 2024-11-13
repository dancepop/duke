package duke.dancepop.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoField;

public class DateTimeUtil {
    public static final String YEAR_MONTH_DAY_FORMAT = "yyyy-MM-dd";
    public static final String HOUR_MINUTES_FORMAT = "[HHmm][HH:mm]";
    public static final String LOCAL_DATE_TIME_CLI_OUTPUT_FORMAT = "MMM dd yyyy HH:mm";

    public static LocalDateTime userInputToLocalDateTime(String localDateTime) {
        // Referenced from
        // https://docs.oracle.com/javase/10/docs/api/java/time/format/DateTimeFormatterBuilder.html#appendPattern(java.lang.String)
        // https://docs.oracle.com/javase/10/docs/api/java/time/format/SignStyle.html
        // https://docs.oracle.com/javase/10/docs/api/java/time/format/DateTimeFormatterBuilder.html#optionalStart()
        // https://docs.oracle.com/javase/10/docs/api/java/time/format/DateTimeFormatterBuilder.html#parseDefaulting(java.time.temporal.TemporalField,long)
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern(YEAR_MONTH_DAY_FORMAT)
                .optionalStart()
                .appendLiteral(' ')
                .appendPattern(HOUR_MINUTES_FORMAT)
                .optionalEnd()
                .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                .toFormatter();

        return LocalDateTime.parse(localDateTime, formatter);
    }

    public static String toString(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(LOCAL_DATE_TIME_CLI_OUTPUT_FORMAT);
        return localDateTime.format(formatter);
    }

    public static LocalDateTime isoToLocalDateTime(String localDateTime) {
        // Referenced from DateTimeFormatter docs
        return LocalDateTime.parse(localDateTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    public static String toCsvString(LocalDateTime localDateTime) {
        // Referenced from DateTimeFormatter docs
        return localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
}
