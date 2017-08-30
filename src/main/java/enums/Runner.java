package enums;

/**
 * Created by Anton_Chyrko on 8/22/2017.
 */
public class Runner {
    public static void main(String[] args) {
//        Day.MONDAY.isWeekend();
        System.out.println("Day.MONDAY.isWeekend() = " + Day.MONDAY.isWeekend());
        System.out.println("Day.FRIDAY.getDay() = " + Day.FRIDAY.getDay("monday"));
        System.out.println("Day.THURSDAY.getAbbr() = " + Day.THURSDAY.getAbbr());

    }
}
