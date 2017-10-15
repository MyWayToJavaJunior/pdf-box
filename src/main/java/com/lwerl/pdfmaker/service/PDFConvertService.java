package com.lwerl.pdfmaker.service;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import com.lwerl.pdfmaker.converter.Converter;
import com.lwerl.pdfmaker.converter.option.ConverterOption;
import com.lwerl.pdfmaker.helper.TempFileHelper;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

/**
 * Сервис-прослойка для использовангия конвертера.
 *
 * @author lWeRl
 * 24.09.17.
 */
@Service
public class PDFConvertService {

    public InputStream convert(String optionJson, String content) throws IOException, InterruptedException {
        // Дессириализуем опции в объект
        ConverterOption option = new Gson().fromJson(optionJson, ConverterOption.class);
        // Создаем временый файл, для обмена с внешними процессами конвертации
        Path temp = TempFileHelper.makeTempFileFromString(content);
        // Получем результирующий InputStream
        InputStream result =  new Converter(option).convert(temp);
        // Чистим временные файлы
        TempFileHelper.deleteTempHtmlAndPdfFiles(temp);

        return result;
    }

}
