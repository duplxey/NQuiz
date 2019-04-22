package com.duplxey.nquiz.constants;

/**
 * All the commonly used messages.
 */
public enum Message {
    UNKNOWN_COMMAND("Unknown command! Use 'help' for help."),
    NO_COMMAND("Cannot find the specified command."),
    WRONG_SYNTAX("Wrong syntax! "),
    PROGRAM_EXIT("Terminating the program."),
    ARGUMENT_NULL("Specified argument is null!"),
    ;

    private String text;

    Message(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
