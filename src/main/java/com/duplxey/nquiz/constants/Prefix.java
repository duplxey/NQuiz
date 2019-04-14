package com.duplxey.nquiz.constants;

/**
 * All the prefixes for messages/logging.
 */
public enum Prefix {
    INFO("INFO > ", 1),
    DEBUG("DEBUG > ", 2),
    WARNING("WARNING > ", 3),
    ERROR("ERROR > ", 4),
    ;

    private String prefix;
    private int level;

    Prefix(String prefix, int level) {
        this.prefix = prefix;
        this.level = level;
    }

    public String getPrefix() {
        return prefix;
    }

    public int getLevel() {
        return level;
    }
}
