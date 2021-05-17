package com.example.disertatie.controller;

import com.example.disertatie.service.ImportFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/import")
public class ImportController {

    @Autowired
    private ImportFileService importFileService;

    @GetMapping("/test")
    public String apeleaza() {
        return "Successfull!";
    }

    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        importFileService.readFromExcelFile(file);
        return file.getName();
    }
}
