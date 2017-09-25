package pdfmaker.converter.strategy;

import pdfmaker.converter.option.ConverterOption;

import java.io.IOException;

/**
 * Created by bobrov on 24.09.17.
 */
public class ElectronConverterStrategy implements ConverterStrategy {
    private final String COMMAND = "electron-pdf";

    @Override
    public void convert(ConverterOption option, String inputFileName, String outputFileName) throws IOException, InterruptedException {
        StringBuilder command = new StringBuilder(COMMAND);
        command.append(" ");
        command.append(inputFileName);
        command.append(" ");
        command.append(outputFileName);

        Process p = Runtime.getRuntime().exec(command.toString());
        p.waitFor();
    }
}
