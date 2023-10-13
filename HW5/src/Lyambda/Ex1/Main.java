package Lyambda.Ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {
        LeapYearChecker isLeap = year -> (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("System for checking year is leap or not!");
        int year = Integer.parseInt(input.readLine());
        if (isLeap.isLeapYear(year)) {
            System.out.println("Leap year!");
        }
        else {
            System.out.println("Not leap year!");
        }

        System.out.println("System for calculating dates!");

        BetweenDates daysBetweenDates = (date1, date2) -> Math.abs(Period.between(date1, date2).getDays());
        BetweenDates weeksBetweenDates = (date1, date2) -> Math.abs(Period.between(date1, date2).getDays()) / 7;
        BetweenDates monthsBetweenDates = (date1, date2) -> Math.abs(Period.between(date1, date2).getMonths());
        BetweenDates yearsBetweenDates = (date1, date2) -> Math.abs(Period.between(date1, date2).getYears());

        System.out.println("Enter your first date:");
        System.out.print("Year 1: ");
        int year1 = Integer.parseInt(input.readLine());
        System.out.print("Month 1: ");
        int month1 = Integer.parseInt(input.readLine());
        System.out.print("Day 1: ");
        int day1 = Integer.parseInt(input.readLine());

        LocalDate date1 = LocalDate.of(year1, month1, day1);

        System.out.println("Enter your second date:");
        System.out.print("Year 2: ");
        int year2 = Integer.parseInt(input.readLine());
        System.out.print("Month 2: ");
        int month2 = Integer.parseInt(input.readLine());
        System.out.print("Day 2: ");
        int day2 = Integer.parseInt(input.readLine());

        LocalDate date2 = LocalDate.of(year2, month2, day2);

        int diffYear = yearsBetweenDates.calculateBetweenDates(date1, date2);
        int diffMonth = monthsBetweenDates.calculateBetweenDates(date1, date2);
        int diffWeek = weeksBetweenDates.calculateBetweenDates(date1, date2);
        int diffDay = daysBetweenDates.calculateBetweenDates(date1, date2);

        String statement = diffYear == 0 ?
                diffMonth == 0 ?
                        diffWeek == 0 ? String.valueOf(diffDay) :
                                diffWeek + " week, " + diffDay + " day " :
                        diffMonth + " month, " + diffWeek + " week, " + diffDay + " day" :
                diffYear + " year, " + diffMonth + " month, " + diffWeek + " week, " + diffDay + " day";

        System.out.print("Between " + date1 + " and " + date2 + ": ");
        try {
            System.out.println(Integer.parseInt(statement) == 0 ? "No difference, equal dates" : statement + " day");
        } catch (Exception e) {
            System.out.println(statement);
        }

        System.out.println("System for calculating week day of the date!");

        WeekDayOfDate weekDayOfDate = date -> new SimpleDateFormat("EEEE").format(date);

        System.out.println("Enter your date:");
        System.out.print("Year: ");
        int yearW = Integer.parseInt(input.readLine());
        System.out.print("Month: ");
        int monthW = Integer.parseInt(input.readLine());
        System.out.print("Day: ");
        int dayW = Integer.parseInt(input.readLine());

        Date date = new Date(yearW, monthW, dayW);

        System.out.println(weekDayOfDate.calculateWeekDayOfDate(date));
    }
}
