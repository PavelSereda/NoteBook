package by.tc.nb.bean.entity;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class NoteBook {
    private List<Note> notes = new ArrayList<Note>();
    private List<Note> detectednotes = new ArrayList<Note>();

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public void add(Note newNote) {
        notes.add(newNote);
        System.out.println("Note was added");
    }

    public List<Note> findNotesByContent(Note searchingNote) {
        if (detectednotes.size() != 0) {
            detectednotes.clear();
        }
        for (Note n : notes) {
            if (n.getNote().toUpperCase().contains(searchingNote.getNote().toUpperCase())) {
                detectednotes.add(n);
            }
        }
        return detectednotes;
    }


    public List<Note> findNotesByDate(Note searchingNote) {
        if (detectednotes.size() != 0) {
            detectednotes.clear();
        }
        for (Note n : notes) {
            if (n.getDateStr().equals(searchingNote.getDateStr())) {
                detectednotes.add(n);
            }
        }
        return detectednotes;
    }


    public String writeNotebookInFile(String path) throws FileNotFoundException {

        try (FileWriter writer = new FileWriter(path, true)) {
            for (Note i : notes) {
                writer.write('[' + i.getDateStr() + ']' + " " + i.getNote() + "\r\n");
                writer.flush();
            }
        } catch (IOException ex) {
            System.out.println("Incorrect path");
            return "Incorrect path";
        }

        System.out.println("Completed");
        return "Completed";
    }

    public String loadNoteBookFromFile(String path) throws IOException, ParseException {
        String resultMessage = "File doesn't exist";
        try {
            File myfile = new File(path);
            FileReader fr = new FileReader(myfile);
            BufferedReader reader = new BufferedReader(fr);
            String line = null;
            String note;
            String dateStr;
            int linesCounter = 0;

            while ((line = reader.readLine()) != null) {
                dateStr = line.substring(line.indexOf('[') + 1, line.indexOf(']'));
                note = line.substring(line.indexOf(']') + 2, line.length());
                //System.out.println(dateStr);
                // System.out.println(note);
                Note n = new Note(note, dateStr);
                notes.add(n);
                linesCounter++;
            }
            //reader.close();
            resultMessage = "File was loaded.";
            System.out.println(resultMessage + " Notes count: " + linesCounter);
            return resultMessage;
        } catch (FileNotFoundException ex) {
            System.out.println(resultMessage);
            return resultMessage;
        }

    }

    public List<Note> getNotes() {
        return notes;
    }

    public List<Note> getDetectednotes() {
        return detectednotes;
    }
}
