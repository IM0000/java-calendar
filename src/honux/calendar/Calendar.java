package honux.calendar;

public class Calendar {

	private static final int[] MAXDAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAXDAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final String[] DAY_OF_THE_WEEK = { "SU", "MO", "TU", "WE", "TH", "FR", "SA" };

	public boolean isLeapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
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

	public int getDayNum(String day) {
		int dayIndex = 0;
		for (int i = 0; i <= 6; i++) {
			if (day.equalsIgnoreCase(DAY_OF_THE_WEEK[i])) {
				dayIndex = i;
				break;
			}
		}
		return dayIndex;
	}

	public void printCalendar(int year, int month, String day) {
		System.out.printf("    <<%4d년%3d월>>\n", year, month);
		System.out.println(" SU MO TU WE TH FR SA");
		System.out.println("---------------------");

		int maxDay = getMaxDaysOfMonth(year, month);
		for (int i = 0; i < getDayNum(day); i++) {
			System.out.print("   ");
		}
		for (int i = 1; i <= maxDay; i++) {
			System.out.printf("%3d", i);
			if ((i + getDayNum(day)) % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println();
	}
	/*
	 * 월을 입력하면 해당월의 달력을 출력한다. 달력은 모양은 1단계에서 작성한 모양으로 만든다. 1일은 일요일로 정해도 무방하다. -1을
	 * 입력받기 전까지 반복 입력받는다. 프롬프트를 출력한다.
	 */

}
