package jUnit.rule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

public class AssertExceptionRuleTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void willThrowError() throws Exception{
        expectedException.expect(IOException.class);
        expectedException.expectMessage("ang");

        willThrown();
    }


    private static void willThrown() throws IOException{
        throw new IOException("Bang");
    }
}
