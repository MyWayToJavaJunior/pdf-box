package pdfmaker.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pdfmaker.converter.option.ConverterOption;
import pdfmaker.service.PDFConvertService;

import java.io.*;

/**
 * Created by bobrov on 24.09.17.
 */
@RestController
public class PDFController {

    private PDFConvertService service;

    @Autowired
    public PDFController(PDFConvertService service) {
        this.service = service;
    }

    @RequestMapping("/test")
    public String test() {
        return "Test";
    }

    @RequestMapping(value = "/convert", method = RequestMethod.POST)
    public ResponseEntity convertToPDF(
            @RequestParam(value = "option") String optionJson,
            @RequestParam(value = "content") String content
    ) throws FileNotFoundException {
        Gson gson = new Gson();
        ConverterOption option = gson.fromJson(optionJson, ConverterOption.class);
        try {
            InputStream result = service.convert(option, content);
            return ResponseEntity
                    .ok()
                    .contentLength(result.available())
                    .contentType(
                            MediaType.parseMediaType("application/octet-stream"))
                    .body(new InputStreamResource(result));
        } catch (IOException | InterruptedException e) {
            return ResponseEntity.status(500).contentType(MediaType.TEXT_PLAIN).body(e.toString());
        }
    }
}
