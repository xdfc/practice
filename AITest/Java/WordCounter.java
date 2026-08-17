package aitest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/** Intentionally defective implementation for AI repair exercises. */
public final class WordCounter {
    private WordCounter() {
    }

    public static Map<String, Integer> count(Path path) throws IOException {
        Map<String, Integer> counts = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(path.toFile()));
        String line;
        while ((line = reader.readLine()) != null) {
            for (String word : line.split(" ")) {
                counts.put(word, counts.getOrDefault(word, 0) + 1);
            }
        }
        return counts;
    }
}
