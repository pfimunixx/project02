package de.imunixx.api.mapper;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;

public class DateUtils {

    public static Date offsetDateTimeToDate(OffsetDateTime offsetDateTime) {
        if (offsetDateTime == null) {
            return null;
        }
        return Date.from(offsetDateTime.toInstant());
    }

    public static OffsetDateTime dateToOffsetDateTime(Date date) {
        if (date == null) {
            return null;
        }
        return date.toInstant().atOffset(ZoneOffset.UTC);
    }
}
