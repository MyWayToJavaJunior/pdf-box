package com.lwerl.pdfmaker.converter.strategy;

/**
 * Перечисление стратегий конвертирований HTML в PDF
 * Каждый элемент перечисления связан с конкретной стратегией
 *
 * @author lWeRl
 * 24.09.17.
 */
public enum ConverterMethod {

    ELECTRONPDF(new ElectronConverterStrategy());

    private ConverterStrategy converterStrategy;

    ConverterMethod(ConverterStrategy converterStrategy) {
        this.converterStrategy = converterStrategy;
    }

    public ConverterStrategy getStrategy() {
        return converterStrategy;
    }

}
