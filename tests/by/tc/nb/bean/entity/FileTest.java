package by.tc.nb.bean.entity;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class FileTest {

    private final String path = "E:\\notebook.txt";
    private final String incorrectPath = "wrfqwefw";

    @Test
    public void testWriteNotebookInFile() throws Exception {
        NoteBook n = new NoteBook();
        Assert.assertEquals(n.writeNotebookInFile(path), "Completed");
        // Assert.assertEquals(n.writeNotebookInFile(incorrectPath), "Incorrect path");
    }

    @Test
    public void LoadNotebookFromFile() throws Exception {
        NoteBook n = new NoteBook();
        Assert.assertEquals(n.loadNoteBookFromFile(path), "File was loaded.");
        // Assert.assertEquals(n.loadNoteBookFromFile(incorrectPath), "File doesn't exist");
    }

}