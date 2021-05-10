package com.juxtapose.juxtaposeapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class FileController {

    public FileController() {
    }

    @GetMapping(path = "/fileUpload")
    public String getUploadFile() {
        return "file upload";
    }

}
