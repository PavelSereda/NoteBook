package by.tc.nb.command.impl;

import by.tc.nb.bean.AddNoteRequest;
import by.tc.nb.bean.FileRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.entity.Note;
import by.tc.nb.bean.entity.NoteBook;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.source.NoteBookProvider;

import java.io.FileNotFoundException;
import java.io.IOException;


public class WriteNoteBookInFile implements Command {
    @Override
    public Response execute(Request request) throws CommandException, IOException {
        FileRequest req = null;

        if (request instanceof FileRequest) {
            req = (FileRequest) request;
        } else {
            throw new CommandException("Wrong request");
        }

        NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
        noteBook.writeNotebookInFile(req.getPath());

        Response response = new Response();
        response.setErrorStatus(false);
        response.setResultMessage("Operation completed!");

        return response;
    }
}
