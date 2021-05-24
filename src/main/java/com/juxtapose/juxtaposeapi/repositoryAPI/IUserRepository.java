package com.juxtapose.juxtaposeapi.repositoryAPI;

import com.juxtapose.juxtaposeapi.model.JuxtaposeUser;

import java.util.List;

public interface IUserRepository {

    List<JuxtaposeUser> getAllUser() throws Exception;
}
