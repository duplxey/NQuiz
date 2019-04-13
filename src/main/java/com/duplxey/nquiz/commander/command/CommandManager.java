package com.duplxey.nquiz.commander.command;

import java.util.*;

public class CommandManager {

    private static HashMap<String, Command> commands = new LinkedHashMap<>();

    public static void registerCommand(Command command) {
        commands.put(command.getCommand().toLowerCase(), command);
    }

    public static void unregisterCommand(Command command) {
        Iterator it = commands.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (entry.getValue() == command) it.remove();
        }
    }

    public static void unregisterCommand(String command) {
        commands.remove(command);
    }

    public static Command getCommand(String command) {
        return commands.get(command);
    }

    public static Collection<Command> getCommands() {
        return commands.values();
    }
}
