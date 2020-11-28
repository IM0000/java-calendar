package honux.calendar;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Calendar {

	private static final int[] MAXDAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAXDAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final String SAVE_FILE = "plan.dat";
	private HashMap<Date, PlanItem> planMap;

	public Calendar() {
		planMap = new HashMap<Date, PlanItem>();
		File f = new File(SAVE_FILE);
		if (!f.exists()) {
			return;
		}
		try {
			Scanner s = new Scanner(f);
			while(s.hasNext()) {
				String line = s.nextLine();
				String[] words=line.split(",");
				String date = words[0];
				String detail = words[1];
				PlanItem p = new PlanItem(date, detail);
				planMap.put(p.getDate(), p);
			}
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void registerPlan(String strDate, String plan) {
		PlanItem p = new PlanItem(strDate, plan);
		planMap.put(p.getDate(), p);
		
		File f = new File(SAVE_FILE);
		String item = p.saveString();
		try {
			FileWriter fw = new FileWriter(f, true);
			fw.write(item);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public PlanItem searchPlan(String strDate) {
		Date date = PlanItem.getDatefromString(strDate);
		return planMap.get(date);
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
