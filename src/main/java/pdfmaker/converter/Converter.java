package pdfmaker.converter;

import pdfmaker.converter.option.ConverterOption;
import pdfmaker.converter.strategy.ConverterStrategy;
import pdfmaker.helper.TempFileHelper;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Объект конвертера,
 * стретигия выбираеться из объекта опций
 *
 * @author lWeRl
 * 24.09.17.
 */
public class Converter {

    private ConverterStrategy strategy;
    private ConverterOption option;

    public Converter(ConverterOption option) {
        this.option = option;
        this.strategy = option.getMethod().getStrategy();
    }

    public InputStream convert(Path file) throws IOException, InterruptedException {

        // Создаем пути в виде строк
        String htmlFilePath = file.toAbsolutePath().toString();
        String pdfFilePath = TempFileHelper.getPdfFilePath(file);

        // Вызываем стратегию
        strategy.convert(option, htmlFilePath, pdfFilePath);

        // Получаем InputStream(ByteInputStream - для возможности удаления временных файлов)
        Path pdfFile = Paths.get(pdfFilePath);
        byte[] buffer = Files.readAllBytes(pdfFile);
        return new ByteArrayInputStream(buffer);
    }

}
