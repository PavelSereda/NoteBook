package by.tc.nb.command.impl;

import by.tc.nb.bean.AddNoteRequest;
import by.tc.nb.bean.Request;
import by.tc.nb.bean.Response;
import by.tc.nb.bean.ShowNotesResponse;
import by.tc.nb.bean.entity.Note;
import by.tc.nb.bean.entity.NoteBook;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.source.NoteBookProvider;


public class ShowNotes implements Command {
    @Override
    public Response execute(Request request) throws CommandException {
        Request req = null;

        if(request instanceof Request) {
            req = request;
        }
        else{
            throw new CommandException("Wrong request");
        }

        NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();
        noteBook.getNotes();

        ShowNotesResponse response = new ShowNotesResponse();
        response.setErrorStatus(false);
        response.setNotes(noteBook.getNotes());
        response.setResultMessage("All OK!");


        return response;
    }
}
