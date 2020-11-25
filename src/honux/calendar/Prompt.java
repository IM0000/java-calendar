package honux.calendar;

import java.util.Scanner;

public class Prompt {

	private final static String PROMPT = "cal> ";

	public void runPrompt() {

		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		int month = 1;
		int year = 1;
		while (month != -1) {
			System.out.println("연도를 입력하세요");
			System.out.print(PROMPT);
			year = scanner.nextInt();
			System.out.println("달을 입력하세요");
			System.out.print(PROMPT);
			month = scanner.nextInt();
			if (month == -1 || month > 12) {
				continue;
			}
			cal.printCalendar(year , month);
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
