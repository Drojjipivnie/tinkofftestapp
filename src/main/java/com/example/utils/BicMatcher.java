package com.example.utils;

import java.util.regex.Pattern;

public class BicMatcher {

    private static Pattern pattern = Pattern.compile("^04([0-9][0-9])([0-9][0-9])([0-9][0-9][0-9])$");

    public static boolean match(String bicCode) {
        return pattern.matcher(bicCode).matches();
    }

}
