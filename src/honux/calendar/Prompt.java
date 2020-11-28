package honux.calendar;

import java.util.Scanner;

public class Prompt {

	public void printMenu() {
		System.out.println("+----------------------+");
		System.out.println("| 1. 일정 등록            ");
		System.out.println("| 2. 일정 검색            ");
		System.out.println("| 3. 달력 보기            ");
		System.out.println("| h. 도움말     q. 종료    ");
		System.out.println("+----------------------+");
	}

	private final static String PROMPT = "cal> ";

	public void runPrompt() {
		printMenu();
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
		boolean isLoop = true;
		while (isLoop) {
			System.out.println("명령 (1, 2, 3, h, q)");
			String cmd = scanner.next();
			switch (cmd) {
			case "1":
				cmdRegister(scanner, cal);
				break;
			case "2":
				cmdSearch(scanner, cal);
				break;
			case "3":
				cmdCal(scanner, cal);
				break;
			case "h":
				printMenu();
				break;
			case "q":
				isLoop = false;
				break;
			}
		}
		System.out.println("Bye~");
		scanner.close();
	}

	private void cmdCal(Scanner s, Calendar c) {

		int month = 1;
		int year = 1;

		System.out.println("연도를 입력하세요.");
		System.out.print(PROMPT);
		year = s.nextInt();

		System.out.println("달을 입력하세요.");
		System.out.print(PROMPT);
		month = s.nextInt();
		s.nextLine();

		if (month == -1 || month > 12 || month < 0) {
			System.out.println("잘못된 입력입니다..");
			return;
		}

		c.printCalendar(year, month);

	}

	private void cmdSearch(Scanner s, Calendar c) {
		System.out.println("[일정검색] 날짜를 입력해주세요.(yyyy-MM-dd)");
		String date = s.next();
		PlanItem plan;
		try {
			plan = c.searchPlan(date);
			System.out.println("일정 : " + plan.detail);
		} catch (NullPointerException e) {
			System.out.println("일정이 없습니다.");
		}
	}

	private void cmdRegister(Scanner s, Calendar c) {
		System.out.println("[일정등록] 날짜를 입력해주세요.(yyyy-MM-dd)");
		String date = s.next();
		System.out.println("일정을 입력해주세요.");
		s.nextLine();
		String text = s.nextLine();
		c.registerPlan(date, text);

	}

	public static void main(String[] args) {
		// 셸 실행
		Prompt p = new Prompt();
		p.runPrompt();

	}
}
