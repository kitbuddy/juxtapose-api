package com.juxtapose.juxtaposeapi.repositoryAPI;

import com.juxtapose.juxtaposeapi.Repository.DatabasePropertyViolationException;
import com.juxtapose.juxtaposeapi.model.JuxtaposeUser;
import com.juxtapose.juxtaposeapi.model.MenuItems;
import com.juxtapose.juxtaposeapi.model.RequestModels.JuxtaposeUserRequest;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {

    List<JuxtaposeUser> getAllUser() throws Exception;

    List<JuxtaposeUser> getUsersById(Integer Id) throws Exception, DatabasePropertyViolationException;

    Optional<List<JuxtaposeUser>> getUserByGlobalSearch(JuxtaposeUserRequest juxtaposeUserRequest) throws DatabasePropertyViolationException;

    List<MenuItems> getAllMenuItems() throws Exception;

}
