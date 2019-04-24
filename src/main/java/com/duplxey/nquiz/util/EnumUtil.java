package com.duplxey.nquiz.util;

import java.util.EnumSet;

public class EnumUtil {

    /**
     * Checks if the given value exists in the enumeration.
     *
     * @param _enumClass  Enum class
     * @param value  Value
     * @param <E>  /
     * @return  True if exists
     */
    public static <E extends Enum<E>> boolean isValid(Class<E> _enumClass, String value) {
        try {
            return EnumSet.allOf(_enumClass).contains(Enum.valueOf(_enumClass, value));
        } catch (Exception e) {
            return false;
        }
    }
}
