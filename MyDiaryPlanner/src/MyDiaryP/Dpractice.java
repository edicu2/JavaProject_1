package MyDiaryP;

import java.util.Calendar;
import java.util.Scanner;

public class Dpractice {
	
	
	final static int FIRSTDATE = 1;
	
	public Dpractice() {
		Calendar();
		
	}
	public void Calendar() {
		Calendar cal = Calendar.getInstance();
		Scanner scan = new Scanner(System.in);
		System.out.println("�⵵�� �Է��Ͻÿ� :");
		int year = scan.nextInt();
		System.out.println("���� �Է��Ͻÿ� :");
		int month = scan.nextInt();
		cal.set(year, month - 1, FIRSTDATE); // date setting
		int firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		int lastDay = cal.getActualMaximum(Calendar.DATE);
		System.out.println(firstDayOfWeek);
		System.out.println(lastDay);
		System.out.println(cal.get(Calendar.YEAR) + "�� " + (cal.get(Calendar.MONTH) + 1) + "��      " + firstDayOfWeek
				+ "- ù��° ���� ����  ");

		for (int j = 1; j <= firstDayOfWeek; j++) {
			System.out.print("   ");
		}
		for (int i = 1; i <= lastDay; i++) {
			if (i < 10)
				System.out.print(" ");
			System.out.print(" " + i);
			if ((firstDayOfWeek + i) % 7 == 1) {
				System.out.println("");
			}
		}
	}
	
	/*
	 * for (int j = 1; j < firstDayOfWeek; j++) { System.out.print("   "); } for
	 * (int i = 1; i <= lastDay; i++) { if (i < 10) System.out.print(" ");
	 * System.out.print(" " + i); if ((firstDayOfWeek + i) % 7 == 1) {
	 * System.out.println(""); } }
	 */
}
