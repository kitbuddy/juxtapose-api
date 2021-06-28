package com.juxtapose.juxtaposeapi.Utils.CommonConstants;

public class ApiConstants {

    public static final String id = "id";
    public static final String FIRST_NAME = "first_name";
    public static final String MENU_ITEM = "menuItem";
    public static final String LAST_NAME = "last_name";
    public static final String EMAIL = "email";
    public static final String PHONE = "phone";

    public static final String getUserDataSql = "select * from juxtaposeUser";
    public static final String getAllMenuItemsSql = "select * from MenuItems";

    public static final String getUsersById = "select * from juxtaposeUser " +
            "WHERE id = :id";

    public static final String FILE_CONTROLLER = "FILE Controller";

}
