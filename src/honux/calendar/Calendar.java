package honux.calendar;

import java.util.Scanner;

public class Calendar {
	
	private static final int[] MAXDAYS={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	public int getMaxDaysOfMonth(int month) {
		return MAXDAYS[month -1];
	}
	public void printSampleCalendar() {
		System.out.println("일  월  화  수  목  금  토");
		System.out.println("--------------------");
		System.out.println(" 1  2  3  4  5  6  7");
		System.out.println(" 8  9 10 11 12 13 14");
		System.out.println("15 16 17 18 19 20 21");
		System.out.println("22 23 24 25 26 27 28");
	}
	public static void main(String[] args) {
		//숫자를 입력받아 해당하는 달의 최대 일수를 출력하는 프로그램
		System.out.println("달을 입력하세요");
		Scanner scanner = new Scanner(System.in);
		Calendar cal = new Calendar();
//		String s1 = scanner.nextLine();
//		int input = Integer.parseInt(s1);
//		if(input==1||input==3||input==5||input==7||input==8||input==10||input==12) {
//			System.out.printf("%s월은 31일까지 있습니다.",input);
//		} else if(input==2) {
//			System.out.printf("%s월은 28일까지 있습니다.",input);
//		} else {
//			System.out.printf("%s월은 30일까지 있습니다.",input);
//		}
		int month = scanner.nextInt();
		
		System.out.printf("%d 월은 %d일 까지 있습니다.\n", month, cal.getMaxDaysOfMonth(month));
		scanner.close();	
		cal.printSampleCalendar();
	}
}
