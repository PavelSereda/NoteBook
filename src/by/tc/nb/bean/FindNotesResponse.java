package by.tc.nb.bean;

import by.tc.nb.bean.entity.Note;

import java.util.List;


public class FindNotesResponse extends Response {
     private List<Note> detectednotes;

    public List<Note> getDetectednotes() {
        return detectednotes;
    }

    public void setDetectednotes(List<Note> detectednotes) {
        this.detectednotes = detectednotes;
    }
}
