package com.duplxey.nquiz.commander.command;

import com.duplxey.nquiz.commander.command.commands.QuizCommand;
import com.duplxey.nquiz.commander.command.commands.general.AboutCommand;
import com.duplxey.nquiz.commander.command.commands.general.CommandsCommand;
import com.duplxey.nquiz.commander.command.commands.general.ExitCommand;
import com.duplxey.nquiz.commander.command.commands.general.InfoCommand;
import com.duplxey.nquiz.quiz.QuizManager;

public class CommandRegister {

    public CommandRegister(QuizManager quizManager) {
        new AboutCommand();
        new CommandsCommand();
        new ExitCommand();
        new InfoCommand();

        // Quiz specific commands
        new QuizCommand(quizManager);
    }
}
