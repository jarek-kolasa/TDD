package jUnit.assertionsExample;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.internal.matchers.ArrayEquals;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class RectangleTest {

    @Test
    public void tryAssertTrue() {
        Rectangle rectangle = new Rectangle(10, 10);

        assertTrue(rectangle.isSquare());
    }

    @Test
    public void tryAssertFalse() {
        Rectangle rectangle = new Rectangle(9, 10);

        assertFalse(rectangle.isSquare());
    }

    @Test
    public void tryAssertTrueWithCommentIfFalse() {
        Rectangle rectangle = new Rectangle(9, 10);

        assertTrue("Only rectangle with the same width and height is a square", rectangle.isSquare());
    }

    @Test
    public void tryAssertNull() {
        Object value = null;

        assertNull(value);
    }

    @Test
    public void tryAssertNotNull() {
        Rectangle rectangle = new Rectangle(9, 10);

        assertNotNull(rectangle);
    }

    @Test
    public void tryAssertEquals() {
        Rectangle rectangle = new Rectangle(2, 8);

        assertEquals(16, rectangle.getArea());
    }

    @Test
    public void tryAssertEqualsWithStrings() {
        assertEquals("Hello\nWorld\nnow", "Hello\nWORLD\nnow");
    }

    @Test
    public void tryAssertNotEquals() {
        assertNotEquals(999999, new Rectangle(1, 3).getAspectRatio());
    }

    @Test
    public void tryAssertEqualsWithDouble() {
        double checkRatio = new Rectangle(1, 3).getAspectRatio();

        assertEquals(0.33333333, checkRatio, 0.001);
    }

    @Test
    public void tryAssertEqualsWithObject() {
        assertEquals(new Rectangle(1, 1), new Rectangle(1, 1));
    }

    @Test
    public void tryAssertSame() {
        Rectangle example1 = new Rectangle(4, 5);
        Rectangle example1SecondReference = example1;

        assertSame(example1, example1SecondReference);

        Rectangle duplicateOfExample1 = new Rectangle(4, 5);

        assertNotSame(example1, duplicateOfExample1);
        assertEquals(example1, duplicateOfExample1);
    }

    @Test
    public void tryAssertFail(){
        Assert.fail("This should never happen...");
    }

    @Test
    public void tryAssertArray(){
        Rectangle rectangle = new Rectangle(5, 6);

        assertArrayEquals(new int[] {5, 6}, rectangle.getSides());
    }

    @Test
    public void tryAssertList(){
        Rectangle rectangle = new Rectangle(5, 6);

        assertEquals(asList(5, 6), rectangle.getSidesList());

    }
}