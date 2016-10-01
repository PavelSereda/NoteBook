package by.tc.nb.bean.entity;

import by.tc.nb.command.impl.FindNotes;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;


public class FindNotesTest {
    NoteBook n = new NoteBook();

    @DataProvider(name = "dp")
    public Object[][] createSomeData() {
        List<Note> list = new ArrayList<Note>();
        list.add(new Note( "aaaaaaaaa","25.09.2011"));
        list.add(new Note( "aaaaaaaaaaaa","26.09.2011"));
        list.add(new Note("25.09.2011", "aaaaaaaaa"));
        return new Object[][]{
                {list},
        };
    }

    @Test(dataProvider = "dp")
    public void testFindNotesByContent(List<Note> list) throws Exception {
        n.setNotes(list);
        Note nn = new Note("aaaaa","aaaaa");
        n.findNotesByContent(nn);
        Assert.assertEquals(n.getDetectednotes().size(), 2);
    }


    @Test(dataProvider = "dp")
    public void testFindNotesByDate(List<Note> list) throws Exception {
        n.setNotes(list);
        Note nn = new Note(null,"26.09.2011");
        n.findNotesByDate(nn);
        Assert.assertEquals(n.getDetectednotes().size(), 1);
    }

}