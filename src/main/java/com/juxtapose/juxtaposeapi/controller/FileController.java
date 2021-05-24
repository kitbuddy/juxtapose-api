package com.juxtapose.juxtaposeapi.controller;

import com.juxtapose.juxtaposeapi.model.JuxtaposeUser;
import com.juxtapose.juxtaposeapi.service.GetAllUsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class FileController {

    private final GetAllUsersService getAllUsersService;

    public FileController(GetAllUsersService getAllUsersService) {
        this.getAllUsersService = getAllUsersService;
    }

    @GetMapping(path = "/fileUpload")
    public String getUploadFile() {

        return "file upload";
    }

    @GetMapping(path = "/userList")
    public List<JuxtaposeUser> getJuxtaposeUser() throws Exception {
        log.info("Entering getJuxtaposeUser controller ............ ");
        return this.getAllUsersService.getAllUsersService();
    }
}
