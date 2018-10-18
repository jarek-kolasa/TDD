package jUnit.beforeAndAfter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class ReaderWriterWithBeforeAndAfterTest {

    private File writtenFile;
    private File tempFolder;

    @Before
    public void setup() throws Exception {
        // with a temporary folder to write to
        tempFolder = File.createTempFile("temp", "file");
        tempFolder.delete();
        tempFolder.mkdir();

    }

    @After
    public void teardown() throws Exception {
        // and the tidy up is successful
        assertTrue(writtenFile.delete());
//        assertTrue(tempFolder.delete());
    }

    @Test
    public void readslinesItWrote() throws Exception {

        // when we write the file
        List<String> someLines = asList("One", "Two", "Three");
        writtenFile = ReaderWriter.write(tempFolder, "MyFile", someLines);

        // then we can read it back
        List<String> readLines = ReaderWriter.read(writtenFile);

        // and they match
        assertEquals(someLines, readLines);
    }

    @Test
    public void readsZeroLinesItWrote() throws Exception {

        // when we write the file
        List<String> someLines = asList();
        writtenFile = ReaderWriter.write(tempFolder, "MyFile", someLines);

        // then we can read it back
        List<String> readLines = ReaderWriter.read(writtenFile);

        // and they match
        assertEquals(someLines, readLines);
    }
}
