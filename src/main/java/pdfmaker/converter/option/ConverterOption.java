package pdfmaker.converter.option;

import pdfmaker.converter.strategy.ConverterMethod;

/**
 * Набор опций пердоставляющий API сервиса
 * @author lWeRl
 * 24.09.17.
 */
public class ConverterOption {

    // Формат страницы
    private PageFormat pageFormat = PageFormat.A4;
    // Метод конвертации
    private ConverterMethod method = ConverterMethod.ELECTRONPDF;

    public String getPageFormatName() {
        if (pageFormat != null) {
            return pageFormat.name();
        } else {
            return null;
        }
    }

    public PageFormat getPageFormat() {
        return pageFormat;
    }

    public void setPageFormat(PageFormat pageFormat) {
        this.pageFormat = pageFormat;
    }

    public ConverterMethod getMethod() {
        return method;
    }

    public void setMethod(ConverterMethod method) {
        this.method = method;
    }
}
