package com.duplxey.nquiz.util;

import com.duplxey.nquiz.constants.Prefix;

public class Logger {

    private static Logger instance;

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    private Logger() {
    }

    public void log(Prefix prefix, String message) {

    }

    public void info(String message) {
        log(Prefix.INFO, message);
    }

    public void warning(String message) {
        log(Prefix.WARNING, message);
    }

    public void debug(String message) {
        log(Prefix.DEBUG, message);
    }

    public void error(String message) {
        log(Prefix.ERROR, message);
    }
}
