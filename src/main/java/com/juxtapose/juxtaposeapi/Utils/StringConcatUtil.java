package com.juxtapose.juxtaposeapi.Utils;

import org.springframework.validation.BindingResult;

public class StringConcatUtil {

    public static StringBuilder getErrorString(BindingResult bindingResult) {

        StringBuilder errStringBuilder = new StringBuilder();

        bindingResult.getAllErrors().forEach( err -> errStringBuilder.append(err.getDefaultMessage() + ", "));

        errStringBuilder.setLength(Math.max(errStringBuilder.length() -1, 0));
        return errStringBuilder;
    }
}
