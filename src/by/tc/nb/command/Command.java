package by.tc.nb.command;

import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.command.exception.CommandException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public interface Command {
	Response execute(Request request) throws CommandException, IOException, ParseException;
}
