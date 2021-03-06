package jUnit.leapYear;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class DateUtilJUnitParamsTest {

    @Test
    @Parameters
    @TestCaseName("The year {0} should have the leap as {1}")
    public void isLeapYear(int year, boolean shouldBeLeap){
        assertThat(DateUtil.isLeapYear(year), is(shouldBeLeap));
    }
    private Object parametersForIsLeapYear(){
        return new Object[][]{
                {1992, true},
                {1996, true},
                {1991, false},
                {1900, false},
                {2000, true}
        };
    }

}
