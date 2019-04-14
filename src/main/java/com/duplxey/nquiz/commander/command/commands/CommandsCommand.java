package com.duplxey.nquiz.commander.command.commands;

import com.duplxey.nquiz.commander.command.Command;
import com.duplxey.nquiz.commander.command.CommandManager;

public class CommandsCommand extends Command {

    public CommandsCommand() {
        super("commands", "Displays the command list.", new String[] {"help"});
    }

    @Override
    public void execute(String[] args) {
        System.out.println("List of registered commands:");
        for (Command command : CommandManager.getCommands()) {
            System.out.println(command.getCommand() + " | " + command.getDescription() + " | " + command.getSyntax());
        }
    }
}
