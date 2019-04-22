package com.duplxey.nquiz.commander;

import com.duplxey.nquiz.commander.command.Command;
import com.duplxey.nquiz.commander.command.CommandManager;
import com.duplxey.nquiz.commander.command.CommandRegister;
import com.duplxey.nquiz.constants.Message;

import java.util.Arrays;
import java.util.Scanner;

public class Commander {

    private boolean running = true;

    public Commander() {
        // Registers all the commands.
        new CommandRegister();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (running) {
            String input = scanner.nextLine();

            if (input != null) {
                input = input.toLowerCase();

                String cmd;
                String[] arguments = {};
                if (input.contains(" ")) {
                    // contains arguments
                    arguments = input.split(" ");
                    cmd = arguments[0];
                    arguments = Arrays.copyOfRange(arguments, 1, arguments.length);
                } else {
                    cmd = input;
                }
                Command command = CommandManager.getCommand(cmd);
                if (command == null) {
                    System.out.println(Message.UNKNOWN_COMMAND.getText());
                } else {
                    command.execute(arguments);
                }
            }
        }
    }

    public void stop() {
        running = false;
    }
}
