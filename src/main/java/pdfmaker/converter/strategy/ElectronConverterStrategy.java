package pdfmaker.converter.strategy;

import pdfmaker.converter.option.ConverterOption;

import java.io.IOException;

/**
 * Стратегия конвертирования HTML в PDF
 * посредсвам внешеней программы electron-pdf
 *
 * @author lWeRl
 * 24.09.17.
 */
public class ElectronConverterStrategy implements ConverterStrategy {
    private final String COMMAND = "electron-pdf";

    // Ограничиываем создание стратегий пакетом (все статегии должны быть доступны из перечисления)
    ElectronConverterStrategy() {
    }

    @Override
    public void convert(ConverterOption option, String inputFileName, String outputFileName) throws IOException, InterruptedException {
        StringBuilder command = new StringBuilder(COMMAND);
        command
                .append(" ")
                .append(inputFileName)
                .append(" ")
                .append(outputFileName)
                .append(" ");
        if (option. getPageFormatName() != null) {
            command.append("-p ").append(option.getPageFormatName());
        }

        Process p = Runtime.getRuntime().exec(command.toString());
        p.waitFor();
    }
}
