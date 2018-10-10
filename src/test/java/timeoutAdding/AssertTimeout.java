package timeoutAdding;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AssertTimeout {

    @Test(timeout = 100L)
    public void testCanRunForever() {
        assertEquals(42, someLongRoutine());
    }

    private static int someLongRoutine() {
        while (true) {
            // The forever part
        }
    }
}
