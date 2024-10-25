package utils;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")
            .withZone(ZoneOffset.UTC);

    public static String formatModelTimestamp(Instant instant) {
        return FORMATTER.format(instant);
    }
}
