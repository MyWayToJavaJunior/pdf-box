package pdfmaker.service;

import org.springframework.stereotype.Service;
import pdfmaker.converter.Converter;
import pdfmaker.converter.option.ConverterOption;
import pdfmaker.helper.TempFileHelper;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

/**
 * Created by bobrov on 24.09.17.
 */
@Service
public class PDFConvertService {

    public InputStream convert(ConverterOption option, String content) throws IOException, InterruptedException {
        Path temp = TempFileHelper.makeTempFileFromString(content);
        Converter converter = new Converter(option);
        return converter.convert(temp);
    }

}
