package com.duplxey.nquiz.commander.command;

import com.duplxey.nquiz.commander.command.commands.CommandsCommand;
import com.duplxey.nquiz.commander.command.commands.ExitCommand;
import com.duplxey.nquiz.commander.command.commands.InfoCommand;
import com.duplxey.nquiz.commander.command.commands.QuizCommand;

public class CommandRegister {

    public CommandRegister() {
        new ExitCommand();
        new CommandsCommand();
        new InfoCommand();
        new QuizCommand();
    }
}
