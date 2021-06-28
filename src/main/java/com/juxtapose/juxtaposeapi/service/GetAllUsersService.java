package com.juxtapose.juxtaposeapi.service;

import com.juxtapose.juxtaposeapi.Repository.DatabasePropertyViolationException;
import com.juxtapose.juxtaposeapi.model.JuxtaposeUser;
import com.juxtapose.juxtaposeapi.model.MenuItems;
import com.juxtapose.juxtaposeapi.model.RequestModels.JuxtaposeUserRequest;
import com.juxtapose.juxtaposeapi.repositoryAPI.IUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class GetAllUsersService {

    private final IUserRepository iUserRepository;

    public List<JuxtaposeUser> getAllUsersService() throws Exception {
        log.info("Entering getAllUsersService for GetAllUsersService");
        return  iUserRepository.getAllUser();
    }

    public List<JuxtaposeUser> getAllUsersById(Integer id) throws Exception, DatabasePropertyViolationException {
        log.info("Entering getAllUsersById for GetAllUsersService");
        return  iUserRepository.getUsersById(id);
    }

    public Optional<List<JuxtaposeUser>> getUserByGlobalSearch(JuxtaposeUserRequest juxtaposeUserRequest) throws DatabasePropertyViolationException {
        log.info("Entering getUserByGlobalSearch for GetAllUsersService");
        return  iUserRepository.getUserByGlobalSearch(juxtaposeUserRequest);
    }

    public List<MenuItems> getAllMenu() throws Exception {
        log.info("Entering getAllUsersService for GetAllUsersService");
        return  iUserRepository.getAllMenuItems();
    }
}
