package com.duplxey.nquiz.commander.command.commands.general;

import com.duplxey.nquiz.commander.command.Command;
import com.duplxey.nquiz.commander.command.CommandManager;

public class CommandsCommand extends Command {

    public CommandsCommand() {
        super("commands", "Displays the command list.", new String[] {"help"});
    }

    @Override
    public void execute(String[] args) {
        System.out.println("List of all registered commands:");
        for (Command command : CommandManager.getCommands()) {
            System.out.println(command.info());
        }
    }
}
