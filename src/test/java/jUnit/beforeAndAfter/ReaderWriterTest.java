package jUnit.beforeAndAfter;

import org.junit.Test;

import java.io.File;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class ReaderWriterTest {

    @Test
    public void readslinesItWrote() throws Exception{
        // with a temporary folder to write to
        File tempFolder = File.createTempFile("temp", "file");
        tempFolder.delete();
        tempFolder.mkdir();

        // when we write the file
        List<String> someLines = asList("One", "Two", "Three");
        File writtenFile = ReaderWriter.write(tempFolder, "MyFile", someLines);

        // then we can read it back
        List<String> readLines = ReaderWriter.read(writtenFile);

        // and they match
        assertEquals(someLines, readLines);

        // and the tidy up is successful
        assertTrue(writtenFile.delete());
//        assertTrue(tempFolder.delete());
    }

}