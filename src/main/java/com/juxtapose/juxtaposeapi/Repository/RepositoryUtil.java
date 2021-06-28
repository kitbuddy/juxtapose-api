package com.juxtapose.juxtaposeapi.Repository;

import com.juxtapose.juxtaposeapi.Utils.CommonConstants.ApiConstants;
import com.juxtapose.juxtaposeapi.model.JuxtaposeUser;
import com.juxtapose.juxtaposeapi.model.MenuItems;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class RepositoryUtil {

    ApiConstants apiConstants;

    public JuxtaposeUser buildJuxtaposeUser(ResultSet rs, int number) throws SQLException {

        log.info("entering buildJuxtaposeUser ");
        return JuxtaposeUser.builder().id(rs.getInt(apiConstants.id))
                                        .first_name(rs.getString(apiConstants.FIRST_NAME))
                                        .last_name(rs.getString(apiConstants.LAST_NAME))
                                        .email(rs.getString(apiConstants.EMAIL))
                                        .phone(rs.getString(apiConstants.PHONE)).build();
    }

    public MenuItems buildMenuItem(ResultSet rs, int number) throws SQLException {

        log.info("entering buildMenuItem ");

        return MenuItems.builder().id(rs.getInt(apiConstants.id))
                .menuItem(rs.getString(apiConstants.MENU_ITEM)).build();
    }
}
