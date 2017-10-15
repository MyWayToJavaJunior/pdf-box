package com.lwerl.pdfmaker.converter.strategy;

import com.lwerl.pdfmaker.converter.option.ConverterOption;

import java.io.IOException;

/**
 * Интерфйес стратегии конвертации
 *
 * @author lWeRl
 * 24.09.17.
 */
public interface ConverterStrategy {
    void convert(ConverterOption option, String inputFileName, String outputFileName) throws IOException, InterruptedException;
}
