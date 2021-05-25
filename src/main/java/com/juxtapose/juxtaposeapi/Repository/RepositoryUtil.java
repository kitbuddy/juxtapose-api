package com.juxtapose.juxtaposeapi.Repository;

import com.juxtapose.juxtaposeapi.CommonConstants.ApiConstants;
import com.juxtapose.juxtaposeapi.model.JuxtaposeUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@Slf4j
public class RepositoryUtil {

    ApiConstants apiConstants;

    public JuxtaposeUser buildJuxtaposeUser(ResultSet rs, int number) throws SQLException {

        log.info("entering buildJuxtaposeUser ");
        return JuxtaposeUser.builder()
                                      .id(rs.getInt(apiConstants.id))
                                      .first_name(rs.getString(apiConstants.FIRST_NAME))
                                      .last_name(rs.getString(apiConstants.LAST_NAME))
                                      .email(rs.getString(apiConstants.EMAIL))
                                      .phone(rs.getString(apiConstants.PHONE)).build();
    }
}
