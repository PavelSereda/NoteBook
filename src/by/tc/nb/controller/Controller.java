package by.tc.nb.controller;

import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

public class Controller {
	private CommandHelper helper = new CommandHelper();
	
	
	public Controller(){}
	
	public Response doRequest(Request request) throws IOException, ParseException {
		String commandName = request.getCommandName();
		
		Command command = helper.getCommand(commandName);
		
		Response response;
		try {
			response = command.execute(request);
		} catch (CommandException e) {
			// logging
			response = new Response();
			response.setErrorStatus(true);
			response.setErrorMessage("ERROR!");
		}

		return response;
		
	}

}
