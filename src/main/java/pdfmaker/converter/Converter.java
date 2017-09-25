package pdfmaker.converter;

import pdfmaker.converter.option.ConverterOption;
import pdfmaker.converter.strategy.ConverterStrategy;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by bobrov on 24.09.17.
 */
public class Converter {

    private ConverterStrategy strategy;
    private ConverterOption option;

    public Converter(ConverterOption option) {
        this.option = option;
        this.strategy = option.getMethod().getStrategy();
    }

    public InputStream convert(Path file) throws IOException, InterruptedException {
        String htmlFilePath = file.toAbsolutePath().toString();
        String pdfFilePath = htmlFilePath.replace(".html", ".pdf");
        strategy.convert(option, htmlFilePath, pdfFilePath);
        Path pdfFile = Paths.get(pdfFilePath);
        byte[] buffer = Files.readAllBytes(pdfFile);
        InputStream result = new ByteArrayInputStream(buffer);
        // Удаляем временные файлы
        Files.delete(file);
        Files.delete(pdfFile);
        return result;
    }

}
