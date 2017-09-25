package pdfmaker.converter.option;

import pdfmaker.converter.ConverterMethod;

/**
 * Created by bobrov on 24.09.17.
 */
public class ConverterOption {

    private String page = "A4";
    private ConverterMethod method = ConverterMethod.ELECTRONPDF;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public ConverterMethod getMethod() {
        return method;
    }

    public void setMethod(ConverterMethod method) {
        this.method = method;
    }
}
