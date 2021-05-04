package com.kartashov;

public class EnumTest {
    Day day;

    public EnumTest(Day day) {
        this.day = day;
    }

    public void printInfo() {
        switch (day) {
            case MONDAY:
                System.out.println("Mondays are bad.");
                break;

            case FRIDAY:
                System.out.println("Fridays are better");
                break;

            case SATURDAY:
            case SUNDAY:
                System.out.println("Weekends are best");
                break;

            default:
                System.out.println("Midweek days are so-so");
                break;

        }
    }

    public static void main(String[] args) {
        EnumTest day1 = new EnumTest(Day.MONDAY);
        day1.printInfo();
        EnumTest day7 = new EnumTest(Day.SATURDAY);
        day7.printInfo();
        EnumTest day3 = new EnumTest(Day.WEDNESDAY);
        day3.printInfo();
    }
}
