package com.duplxey.nquiz.util;

import java.util.EnumSet;

public class EnumUtil {

    public static <E extends Enum<E>> boolean isValid(Class<E> _enumClass, String value) {
        try {
            return EnumSet.allOf(_enumClass).contains(Enum.valueOf(_enumClass, value));
        } catch (Exception e) {
            return false;
        }
    }
}
