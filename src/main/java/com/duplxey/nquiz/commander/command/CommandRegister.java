package com.duplxey.nquiz.commander.command;

import com.duplxey.nquiz.commander.command.commands.QuizCommand;
import com.duplxey.nquiz.commander.command.commands.general.AboutCommand;
import com.duplxey.nquiz.commander.command.commands.general.CommandsCommand;
import com.duplxey.nquiz.commander.command.commands.general.ExitCommand;
import com.duplxey.nquiz.commander.command.commands.general.InfoCommand;

public class CommandRegister {

    public CommandRegister() {
        new AboutCommand();
        new CommandsCommand();
        new ExitCommand();
        new InfoCommand();

        new QuizCommand();
    }
}
