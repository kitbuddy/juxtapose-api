package com.juxtapose.juxtaposeapi.controller;

import com.juxtapose.juxtaposeapi.Repository.DatabasePropertyViolationException;
import com.juxtapose.juxtaposeapi.Utils.CommonConstants.ApiConstants;
import com.juxtapose.juxtaposeapi.Utils.StringConcatUtil;
import com.juxtapose.juxtaposeapi.model.JuxtaposeUser;
import com.juxtapose.juxtaposeapi.model.RequestModels.JuxtaposeUserRequest;
import com.juxtapose.juxtaposeapi.service.GetAllUsersService;
import com.juxtapose.juxtaposeapi.validator.FileControllerUseValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
public class FileController {

    private final GetAllUsersService getAllUsersService;
    private final FileControllerUseValidator fileControllerUseValidator;

    @InitBinder
    public void setFileControllerUseValidator(WebDataBinder binder) {
        binder.addValidators(fileControllerUseValidator);
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

    @GetMapping(path = "/getUser/{id}")
    public List<JuxtaposeUser> getJuxtaposeUserById(@PathVariable("id") Integer id) throws Exception, DatabasePropertyViolationException {
        log.info("Entering getJuxtaposeUserById controller ....with id = " + id);
        return this.getAllUsersService.getAllUsersById(id);
    }

    @PostMapping(path = "/getUser/search")
    public Optional<List<JuxtaposeUser>> globalSearchForJuxtaposeUser(@RequestBody JuxtaposeUserRequest juxtaposeUserRequest, BindingResult bindingResult) throws Exception, DatabasePropertyViolationException {
        log.info("Entering globalSearchForJuxtaposeUser controller ....with body = " + juxtaposeUserRequest);
        if(bindingResult.hasErrors()) {

            StringBuilder errStringBuilder = StringConcatUtil.getErrorString(bindingResult);

            log.error(" {} globalSearchForJuxtaposeUser() Validation of Input: {} failed for reason {}",
                    ApiConstants.FILE_CONTROLLER, juxtaposeUserRequest, errStringBuilder.toString());
        }
        return this.getAllUsersService.getUserByGlobalSearch(juxtaposeUserRequest);
    }

    @GetMapping(path = "/menu")
    public List<JuxtaposeUser> getMenuItems() throws Exception {
        log.info("Entering getJuxtaposeUser controller ............ ");
        return this.getAllUsersService.getAllUsersService();
    }
}
