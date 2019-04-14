package com.duplxey.nquiz.commander.command.commands;

import com.duplxey.nquiz.commander.command.Command;

public class ExitCommand extends Command {

    public ExitCommand() {
        super("exit", "Terminates the program.", new String[] {"quit"});
    }

    @Override
    public void execute(String[] args) {
        System.out.println("Terminating the program.");
        System.exit(0);
    }
}
