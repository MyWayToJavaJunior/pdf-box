package com.lwerl.pdfmaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.lwerl.pdfmaker.service.PDFConvertService;

import java.io.*;

/**
 * Конроллер микросервиса
 *
 * @author lWeRl
 * 24.09.17.
 */
@RestController
public class PDFController {

    private PDFConvertService service;

    @Autowired
    public PDFController(PDFConvertService service) {
        this.service = service;
    }

    @RequestMapping(value = "/convert", method = RequestMethod.POST)
    public ResponseEntity convertToPDF(
            @RequestParam(value = "option") String optionJson,
            @RequestParam(value = "content") String content
    ) throws FileNotFoundException {
        try {
            // Конвертируем
            InputStream result = service.convert(optionJson, content);
            // Отдаем ответ
            return ResponseEntity
                    .ok()
                    .contentLength(result.available())
                    .contentType(MediaType.parseMediaType("application/octet-stream"))
                    .body(new InputStreamResource(result));
        } catch (Exception e) {
            // Обрабатываем ошибки
            return ResponseEntity
                    .status(500)
                    .contentType(MediaType.TEXT_PLAIN)
                    .body(e.toString() + ":" + e.getMessage());
        }
    }
}
