package enums;

/**
 * Created by Anton_Chyrko on 8/22/2017.
 */
public enum Day {
    SUNDAY("SND"), MONDAY("MND"), TUESDAY("TSD"), WEDNESDAY("WDNSD"), THURSDAY("THRSD"),
    FRIDAY("FRD"), SATURDAY("STRD"), WRONG_DAY("ERROR");
    private String abbreviation;

    Day(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbr(){
        return this.abbreviation;
    }

    public boolean isWeekend() {
        switch (this) {
            case SUNDAY:
            case SATURDAY:
                return true;
            default:
                return false;
        }
    }

    public Enum getDay(String day) {
        switch (day.toUpperCase()) {
            case "MONDAY":
                return MONDAY;
            case "TUESDAY":
                return TUESDAY;
            case "WEDNESDAY":
                return WEDNESDAY;
            case "THURSDAY":
                return THURSDAY;
            case "FRIDAY":
                return FRIDAY;
            case "SATURDAY":
                return SATURDAY;
            case "SUNDAY":
                return SUNDAY;
            default:
                return WRONG_DAY;
        }

    }
}
