package by.tc.nb.controller;

import java.util.HashMap;
import java.util.Map;

import by.tc.nb.command.Command;
import by.tc.nb.command.impl.*;

public class CommandHelper {

    private Map<String, Command> commands = new HashMap<String, Command>();

    public CommandHelper() {
        commands.put("ADD_NEW_NOTE", new AddNewNote());
        commands.put("FIND_NOTES", new FindNotes());
        commands.put("LOAD_NOTEBOOK_FROM_FILE", new LoadNoteBookFromFile());
        commands.put("SHOW_NOTES", new ShowNotes());
        commands.put("WRITE_NOTEBOOK_IN_FILE", new WriteNoteBookInFile());
    }

    public Command getCommand(String commandName) {
        Command command;

        command = commands.get(commandName);

        return command;

    }

}
