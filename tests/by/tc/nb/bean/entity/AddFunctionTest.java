package by.tc.nb.bean.entity;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class AddFunctionTest {
    NoteBook n = new NoteBook();


    @DataProvider(name = "dp")
    public Object[][] createSomeData() {

        return new Object[][]{
                {new Note("25.09.2011", "aaaaaaaaa"), 1},
                {new Note("15.09.2011", "aaaaafdaaaa"), 2},
                {new Note("25.49.2051", "aaaadbsaaaaa"), 3},
        };
    }

    @Test(dataProvider = "dp")
    public void testAddBySize(Note newNote, int size) {
        n.add(newNote);
        Assert.assertEquals(n.getNotes().size(), size);
    }


    @Test(dataProvider = "dp")
    public void testAddByNote(Note newNote, int size) {
        NoteBook n = new NoteBook();
        n.add(newNote);
        for (Note note : n.getNotes()) {
            Assert.assertEquals(note.getNote(), newNote.getNote());
            Assert.assertEquals(note.getDateStr(), newNote.getDateStr());
        }
    }

}