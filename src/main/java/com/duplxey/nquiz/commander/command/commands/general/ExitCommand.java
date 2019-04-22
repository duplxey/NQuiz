package com.duplxey.nquiz.commander.command.commands.general;

import com.duplxey.nquiz.commander.command.Command;
import com.duplxey.nquiz.constants.Message;

public class ExitCommand extends Command {

    public ExitCommand() {
        super("exit", "Terminates the program.", new String[] {"quit"});
    }

    @Override
    public void execute(String[] args) {
        System.out.println(Message.PROGRAM_EXIT.getText());
        System.exit(0);
    }
}
