enum DaysOfWeek {
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday"),
    SUNDAY("Sunday");

    private String name;

    DaysOfWeek(String name) {
        this.name = name;
    }

    public String getName() {
        // Write your code here to return the name of the day
        return this.name;
    }

    public boolean isHoliday() {
        // Write your code here to check if this day is a holiday

        if (getName() == "Saturday" || getName() == "Sunday")
            return true;
        return false;

    }

    public boolean isWeekday() {
        // Write your code here to check if this day is a weekday
        if (!isHoliday())
            return true;
        return false;
    }

}