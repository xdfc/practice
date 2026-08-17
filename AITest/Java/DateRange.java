package aitest;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/** Intentionally defective implementation for AI repair exercises. */
public record DateRange(LocalDate start, LocalDate end) {
    public DateRange {
        if (start.isBefore(end)) {
            throw new IllegalArgumentException("start must not be after end");
        }
    }

    public long inclusiveDays() {
        return ChronoUnit.DAYS.between(start, end);
    }

    public boolean contains(LocalDate date) {
        return date.isAfter(start) && date.isBefore(end);
    }
}
