package honux.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Calendar {

	private static final int[] MAXDAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAXDAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private HashMap<Date, String> planMap = new HashMap<Date, String>();;

//	public Calendar() {
//		planMap = new HashMap<Date,String>();
//	}
	/**
	 * 
	 * @param date ex: "2020-11-26"
	 * @param plan
	 * @throws ParseException
	 */
	public void registerPlan(String strDate, String plan) throws ParseException {
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
		planMap.put(date, plan);
	}

	public String searchPlan(String strDate) throws ParseException {
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
		String plan = planMap.get(date);
		return plan;

	}

	public boolean isLeapYear(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
			return true;
		else
			return false;
	}

	public int getMaxDaysOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LEAP_MAXDAYS[month - 1];
		} else {
			return MAXDAYS[month - 1];
		}
	}

	public int getNumOfDays(int year, int month) {
		int numOfDays = 1;
		int preYear = year - 1;
		numOfDays = numOfDays + preYear * 365 + (preYear / 4 - preYear / 100 + preYear / 400);
		if (isLeapYear(year)) {
			for (int i = 1; i < month; i++) {
				numOfDays += LEAP_MAXDAYS[i - 1];
			}
		} else {
			for (int i = 1; i < month; i++) {
				numOfDays += MAXDAYS[i - 1];
			}
		}
		return numOfDays;
	}

	public void printCalendar(int year, int month) {
		System.out.printf("    <<%4d년%3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("---------------------");

		int numOfDays = getNumOfDays(year, month);
		int dayIndex = numOfDays % 7;
		int maxDay = getMaxDaysOfMonth(year, month);
		for (int i = 0; i < dayIndex; i++) {
			System.out.print("   ");
		}
		for (int i = 1; i <= maxDay; i++) {
			System.out.printf("%3d", i);
			if ((i + dayIndex) % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println();
	}

}
