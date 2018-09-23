package leapYear;

public class DateUtil {

    /**
     * Is leap year
     * @param year 4 digit year
     * @return true if leap year
     */
    public static boolean isLeapYear(int year) {
        return (year % 4) == 0 && ( !isDivisibleBy(year, 100) || isDivisibleBy(year, 400) );
    }

    private static boolean isDivisibleBy(int year, int divisor){
        return year % divisor == 0;
    }
}
