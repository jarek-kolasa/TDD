package wordcount;

import org.junit.Test;

import static org.junit.Assert.*;

public class WordCounterTest {

    private WordCounter counter = new WordCounter();

    @Test
    public void emptyStringHasNoWords() {
        counter.add("");
        assertEquals(0, counter.getUniqueWords());
    }

    @Test
    public void singleWordStringHasOneWord() {
        counter.add("Hello");
        assertEquals(1, counter.getUniqueWords());
    }

    @Test
    public void twoSingleWordStringsHaveTwoWords() {
        counter.add("Hello");
        counter.add("World");
        assertEquals(2, counter.getUniqueWords());
    }

    @Test
    public void multiWordStringHasCorrectWordCount() {
        counter.add("one two three");
        assertEquals(3, counter.getUniqueWords());
    }

    @Test
    public void spacedOutMultiWordStringHasCorrectWordCount() {
        counter.add("    one   two    three     ");
        assertEquals(3, counter.getUniqueWords());
    }

    @Test
    public void severalMultiWordStringHasCorrectWordCount() {
        counter.add("one two three");
        counter.add("Four five six");
        assertEquals(6, counter.getUniqueWords());
    }

    @Test
    public void inputWithDuplicatesCountsOnlyIndyvidualCases(){
        counter.add("Test Test Test");
        assertEquals(1, counter.getUniqueWords());
    }

    @Test
    public void inputWithMixedCaseDuplicatesCountsOnlyIndyvidualCases(){
        counter.add("Test test TEST TesT");
        assertEquals(1, counter.getUniqueWords());
    }

    @Test
    public void inputWithPuntuationStillSpotsDuplicates(){
        counter.add("Nine.");
        counter.add("Nine ten.");
        counter.add("Nine, ten, eleven.");
        assertEquals(3, counter.getUniqueWords());
    }

}