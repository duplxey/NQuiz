package com.duplxey.nquiz.commander.command.commands.general;

import com.duplxey.nquiz.commander.command.Command;
import com.duplxey.nquiz.util.FileUtil;

public class AboutCommand extends Command {

    public AboutCommand() {
        super("about", "Displays some general information.");
    }

    @Override
    public void execute(String[] args) {
        System.out.println(FileUtil.getFileContent("resources/about.txt"));
    }
}
