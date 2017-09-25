package pdfmaker.helper;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by bobrov on 24.09.17.
 */
public class TempFileHelper {

    private TempFileHelper() {
    }

    static public Path makeTempFileFromString(String content) throws IOException {
        Path temp = Files.createTempFile("content-", ".html");
        try(BufferedWriter writer = Files.newBufferedWriter(temp)) {
            writer.write(content);
            writer.flush();
        }
        return temp;
    }
}
