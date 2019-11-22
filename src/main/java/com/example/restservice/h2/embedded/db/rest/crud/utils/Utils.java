package com.example.restservice.h2.embedded.db.rest.crud.utils;

import java.text.MessageFormat;
import java.util.regex.Pattern;

public class Utils {

    public static final String  ALREADY_EXIST_EXCEPTION          = "User Already Exist by Username: {0}";

    public static final String  USER_NOT_FOUND_EXCEPTION         = "User Not Found by Username: {0}";

    public static final String  USER_NAME_VALIDATION_REGEX       = "^[a-zA-Z][a-zA-Z0-9.,$;]+$";

    public static final String  USERNAME_NOT_VALID_EXCEPTION     = "User.Username not valid! It must be start with a alphabet";

    public static final String  EMAIL_NOT_VALID_EXCEPTION        = "User.Email not valid!";

    public static final String  PASSWORD_NOT_VALID_EXCEPTION     = "User.Password not valid! The password must then contain characters from at least 3 of the following rules\n 1- Upper case, \n 2- Lower case, \n 3- Numbers, \n 4- Non-alpha numeric";

    public static final String  FIELD_VALIDATION_MESSAGE_PATTERN = "{0}\n{1}";

    public static final Pattern USERNAME_VALIDATION_PATTERN      = Pattern.compile(USER_NAME_VALIDATION_REGEX);

    public static final String  PASSWORD_VALIDATION_REGEX        = "(^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).*$)?(^(?=.*\\d)(?=.*[a-z])(?=.*[@#$%^&+=]).*$)?(^(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%^&+=]).*$)?(^(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$)?";

    public static final String  USERNAME_REQUIRED_EXCEPTION      = "'username' attribute is required! username value is Null";

    public static final String  PASSWORD_REQUIRED_EXCEPTION      = "'password' attribute is required! username value is Null";

    public static String getUsernameAlreadyExistException(String username) {
        return MessageFormat.format(ALREADY_EXIST_EXCEPTION, username);
    }

    public static String getUserNotFoundException(String username) {
        return MessageFormat.format(USER_NOT_FOUND_EXCEPTION, username);
    }

    public static String addFieldValidationException(String oldMessage, String newMessage) {
        return MessageFormat.format(FIELD_VALIDATION_MESSAGE_PATTERN, oldMessage, newMessage);
    }
}
