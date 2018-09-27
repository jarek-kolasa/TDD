package jUnit.leapYear;

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

    @Test
    public void centuryYearsAreNotLeapTest(){
        assertFalse(DateUtil.isLeapYear(1900));
    }

    @Test
    public void year2000WasLeapTEst(){
        assertTrue(DateUtil.isLeapYear(2000));
    }
}