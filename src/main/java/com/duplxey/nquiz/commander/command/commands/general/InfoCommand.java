package com.duplxey.nquiz.commander.command.commands.general;

import com.duplxey.nquiz.commander.command.Command;
import com.duplxey.nquiz.commander.command.CommandManager;
import com.duplxey.nquiz.constants.Message;

public class InfoCommand extends Command {

    public InfoCommand() {
        super("info", "Displays the info of a command.", "<command> <target-command>");
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 1) {
            System.out.println(Message.WRONG_SYNTAX.getText() + getSyntax());
            return;
        }
        String name = args[0];
        Command command = CommandManager.getCommand(name);
        if (command == null) {
            System.out.println(Message.NO_COMMAND.getText());
            return;
        }
        System.out.println(command.info());
    }
}
