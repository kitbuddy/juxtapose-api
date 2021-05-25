package com.juxtapose.juxtaposeapi.repositoryAPI;

import com.juxtapose.juxtaposeapi.Repository.DatabasePropertyViolationException;
import com.juxtapose.juxtaposeapi.model.JuxtaposeUser;

import java.util.List;

public interface IUserRepository {

    List<JuxtaposeUser> getAllUser() throws Exception;

    List<JuxtaposeUser> getUsersById(Integer Id) throws Exception, DatabasePropertyViolationException;
}
