package com.lwerl.pdfmaker.helper;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Утильный метод для работы с временными файлами
 *
 * @author lWeRl
 *         24.09.17
 */
public class TempFileHelper {

    private TempFileHelper() {
    }

    static public Path makeTempFileFromString(String content) throws IOException {
        Path temp = Files.createTempFile("content-", ".html");
        try (BufferedWriter writer = Files.newBufferedWriter(temp)) {
            writer.write(content);
            writer.flush();
        }
        return temp;
    }

    static public String getPdfFilePath(Path html){
        return html.toAbsolutePath().toString().replace(".html", ".pdf");
    }


    static public void deleteTempHtmlAndPdfFiles(Path html) throws IOException {

        // Создаем путь
        Path pdf = Paths.get(getPdfFilePath(html));

        // Удаляем временные файлы (html, pdf)
        Files.delete(html);
        Files.delete(pdf);
    }
}
