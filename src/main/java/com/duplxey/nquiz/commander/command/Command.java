package com.duplxey.nquiz.commander.command;

public abstract class Command {

    private String command;
    private String description;
    private String syntax = "<command>";

    /**
     * Constructs a new command.
     *
     * @param command  Command
     * @param description  Description
     */
    public Command(String command, String description) {
        this.command = command;
        this.description = description;

        // Registers the command
        CommandManager.registerCommand(this);
    }

    /**
     * Constructs a new command with the syntax.
     *
     * @param command  Command
     * @param description  Description
     * @param syntax  Syntax
     */
    public Command(String command, String description, String syntax) {
        this(command, description);
        this.syntax = syntax;
    }

    /**
     * Executes the command.
     */
    public abstract void execute(String[] args);

    /**
     * Get command.
     *
     * @return  Command
     */
    public String getCommand() {
        return command;
    }

    /**
     * Gets formatted command's syntax.
     *
     * @return  Syntax
     */
    public String getSyntax() {
        return syntax.replace("<command>", command);
    }

    /**
     * Gets command's description.
     *
     * @return  Description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Displays command's info.
     */
    public void info() {
        System.out.println("Command info");
        System.out.println("cmd: " + command);
        System.out.println("des: " + description);
        System.out.println("syn: " + getSyntax());
    }
}
