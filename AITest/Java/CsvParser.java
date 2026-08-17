package aitest;

import java.util.Arrays;
import java.util.List;

/** Intentionally defective implementation for AI repair exercises. */
public final class CsvParser {
    private CsvParser() {
    }

    public static List<String> parseLine(String line) {
        return Arrays.stream(line.split(","))
                .map(String::trim)
                .map(value -> value.replace("\"", ""))
                .toList();
    }
}
