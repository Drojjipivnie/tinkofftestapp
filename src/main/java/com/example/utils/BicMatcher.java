package com.example.utils;

import java.util.regex.Pattern;

public class BicMatcher {

    private static Pattern pattern = Pattern.compile("^04([0-9][0-9])([0-9][0-9])(0[5-9][0-9]|[1-9][0-9][0-9]|00[0-2])$");

    private BicMatcher() {

    }

    public static boolean match(String bicCode) {
        return pattern.matcher(bicCode).matches();
    }

}
