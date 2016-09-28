package by.tc.nb.bean.entity;

import java.util.List;

public class NoteBook {
    private List<Note> notes;


    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public void add(Note newNote){
        notes.add(newNote);
    }



    public List<Note> getNotes() {
        return notes;
    }
}
