package Chapter10.SecureCoding.fPreventDoS;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class HugeResource {

    public void transform(Path in, Path out) throws IOException {
        //On a small file, this works just fine. However, on an extremely large file, your program could run out of
        //memory and crash
        var list = Files.readAllLines(in);
        list.removeIf(s -> s.trim().isBlank());
        Files.write(out, list);
    }

    /**
     * An inclusion attack is when multiple files or components are embedded within a single file
     * “billion laughs attack” where the file gets expanded exponentially
     *
     * **/
}
