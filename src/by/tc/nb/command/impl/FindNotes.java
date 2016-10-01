package by.tc.nb.command.impl;

import by.tc.nb.bean.*;
import by.tc.nb.bean.entity.Note;
import by.tc.nb.bean.entity.NoteBook;
import by.tc.nb.command.Command;
import by.tc.nb.command.exception.CommandException;
import by.tc.nb.source.NoteBookProvider;

public class FindNotes implements Command {

    @Override
    public Response execute(Request request) throws CommandException {

        FindNotesRequest req = null;

        if (request instanceof FindNotesRequest) {
            req = (FindNotesRequest) request;
        } else {
            throw new CommandException("Wrong request");
        }


        String command = req.getCommandName();
        if (command.equals("FIND_NOTES_BY_CONTENT")) {
            String note = req.getSearchingContent();

            Note searchingNote = new Note(note);

            NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();

            FindNotesResponse response = new FindNotesResponse();
            response.setErrorStatus(false);
            response.setResultMessage("All OK!");
            response.setDetectednotes(noteBook.findNotesByContent(searchingNote));

            return response;
        } else {
            String date = req.getSearchingDate();

            Note searchingNote = new Note(null, date);

            NoteBook noteBook = NoteBookProvider.getInstance().getNoteBook();

            FindNotesResponse response = new FindNotesResponse();
            response.setErrorStatus(false);
            response.setResultMessage("All OK!");
            response.setDetectednotes(noteBook.findNotesByDate(searchingNote));

            return response;

        }
    }

}
