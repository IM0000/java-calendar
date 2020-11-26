package honux.calendar;

import java.util.Scanner;

public class Prompt {

	private final static String PROMPT = "cal> ";

	public void runPrompt() {

		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		int month = 1;
		int year = 1;
		String day = "";
		while (month != -1 && year != -1) {
			System.out.println("연도를 입력하세요");
			System.out.print(PROMPT);
			year = scanner.nextInt();
			if (year == -1) {
				continue;
			}

			System.out.println("달을 입력하세요");
			System.out.print(PROMPT);
			month = scanner.nextInt();
			scanner.nextLine();

			if (month == -1 || month > 12) {
				continue;
			}
			System.out.println("첫번째 요일을 입력하세요. (SU, MO, TU, WE, TH, FR, SA)");
			System.out.print(PROMPT);
			day = scanner.nextLine();
			cal.printCalendar(year, month, day);
		}
		scanner.close();
		System.out.println("Bye~");
	}

	public static void main(String[] args) {
		// 셸 실행
		Prompt p = new Prompt();
		p.runPrompt();

	}
}
