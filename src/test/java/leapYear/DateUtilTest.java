package leapYear;

import org.junit.Test;

import static org.junit.Assert.*;

public class DateUtilTest {

    @Test
    public void normalLeapYearisLeapTest(){
        assertTrue(DateUtil.isLeapYear(1992));
    }

    @Test
    public void normalLeapYearisLeapTest2(){
        assertTrue(DateUtil.isLeapYear(1996));
    }

    @Test
    public void nonlLeapYearisNotLeapTest(){
        assertFalse(DateUtil.isLeapYear(1991));
    }



}