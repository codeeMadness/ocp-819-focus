package Chapter10.SecureCoding.fPreventDoS;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LeakingResource {

    //bad practice
    public long countLines(Path path) throws IOException {
        return Files.lines(path).count();
    }

    //best practice with try-with-resource
    public long countLines2(Path path) throws IOException {
        try (var stream = Files.lines(path)) {
            return stream.count();
        }
    }
}
