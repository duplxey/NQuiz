package com.duplxey.nquiz.constants;

/**
 * All the commonly used messages.
 */
public enum O {
    UNKNOWN_COMMAND("Unknown command! Use 'help' for help."),
    NO_COMMAND("Cannot find the specified command."),
    WRONG_SYNTAX("Wrong syntax! "),
    ;

    private String text;

    O(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
