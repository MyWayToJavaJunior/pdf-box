package pdfmaker.converter;

import pdfmaker.converter.strategy.ConverterStrategy;
import pdfmaker.converter.strategy.ElectronConverterStrategy;

/**
 * Created by bobrov on 24.09.17.
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
