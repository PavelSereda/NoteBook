package by.tc.nb.bean.entity;

import java.time.LocalDate;
import java.util.Date;

public class Note {

    private String note;
    private String dateStr;

    public Note(String note, String dateStr) {
        this.note = note;
        this.dateStr = dateStr;
    }

    public Note(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }
}
