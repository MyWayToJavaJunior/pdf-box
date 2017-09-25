package pdfmaker.converter.strategy;

import pdfmaker.converter.option.ConverterOption;

import java.io.IOException;

/**
 * Created by bobrov on 24.09.17.
 */
public interface ConverterStrategy {
    void convert(ConverterOption option, String inputFileName, String outputFileName) throws IOException, InterruptedException;
}
