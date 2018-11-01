package jUnit.assertionsExample;

import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.*;

public class AssertExceptionsAssertJTest {

    @Test
    public void willThrowThrows(){
        assertThatThrownBy(() -> willThrown())
                .isInstanceOf(IOException.class)
                .hasMessage("Bang");
    }


    private static void willThrown() throws IOException{
        throw new IOException("Bang");
    }
}
