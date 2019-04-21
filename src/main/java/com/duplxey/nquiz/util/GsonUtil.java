package com.duplxey.nquiz.util;

import com.google.gson.Gson;

/**
 * Singleton for Gson
 * (I couldn't find anything in the documentation clarifying that you should share the instance of gson or create a new one every time)
 */
public class GsonUtil {

    private Gson gson;
    private static GsonUtil instance;

    public static GsonUtil getInstance() {
        if (instance == null) {
            instance = new GsonUtil();
        }
        return instance;
    }

    private GsonUtil() {
        gson = new Gson();
    }

    public Gson getGson() {
        return gson;
    }
}
