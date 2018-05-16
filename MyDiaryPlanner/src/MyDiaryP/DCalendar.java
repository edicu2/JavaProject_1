package MyDiaryP;


import java.awt.Color;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class DCalendar {

	final static int FIRSTDATE = 1;
	
	private int firstDayOfWeek;
	private int lastDay;
	private int nowYear;
	private int nowMonth;
	private int nowDay;
	
	private int beforeMonth;
	private int beforeLastDay;
	
	private int afterMonth;
	private int afterFirstDay;
	
	private JButton[] button;
	
	private DConnectDataBase dcdb= new DConnectDataBase();
	
	public void Calendar(JLabel[] label, JButton[] button, JLabel yearS, JLabel monS ) {
		this.button = button;
		Calendar cal = Calendar.getInstance();
		Scanner scan = new Scanner(System.in);
		nowYear = cal.get(Calendar.YEAR);
		nowMonth = cal.get(Calendar.MONTH);
		nowDay = cal.get(Calendar.DATE);
		lastDay = cal.getActualMaximum(Calendar.DATE);
		cal.set(Calendar.DATE, FIRSTDATE);
		firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		
		beforeMonth = nowMonth-1;
		cal.set(Calendar.MONTH, beforeMonth);
		beforeLastDay = cal.getActualMaximum(Calendar.DATE);
		
		afterMonth = nowMonth+1;
		cal.set(Calendar.MONTH, afterMonth);
		afterFirstDay = FIRSTDATE;
		yearS.setText("2018");
		monS.setText(Integer.toString(nowMonth+1));
		/* another way (fristDayOfWeek)
		 * int date = cal.get(Calendar.DATE);
		 * int r = date % 7;
		 * int firstDayOfMonth = dayPrint - r + 1;
		 */
		
		variablePrint();
		BeforeCalendarPrint(label);
		NowCalendarPrint(label,button);
		AfterCalendarPrint(label);	
		memoPrint(button, nowMonth);
	}
	public void SearchCalendar(JLabel[] label, JButton[] button, JTextField textYear,JTextField textMonth, JTextField textDate , JLabel yearS ,JLabel monS ) {
		Calendar cals = Calendar.getInstance();
		Scanner scan = new Scanner(System.in);
		cals.set(Integer.parseInt(textYear.getText()), Integer.parseInt(textMonth.getText())-1 ,
				 Integer.parseInt(textDate.getText()));
		nowYear = cals.get(Calendar.YEAR);
		nowMonth = cals.get(Calendar.MONTH);
		nowDay = cals.get(Calendar.DATE);
		lastDay = cals.getActualMaximum(Calendar.DATE);
		cals.set(Calendar.DATE, FIRSTDATE);
		firstDayOfWeek = cals.get(Calendar.DAY_OF_WEEK);
		
		beforeMonth = nowMonth-1;
		cals.set(Calendar.MONTH, beforeMonth);
		beforeLastDay = cals.getActualMaximum(Calendar.DATE);
		
		afterMonth = nowMonth+1;
		cals.set(Calendar.MONTH, afterMonth);
		afterFirstDay = FIRSTDATE;
		yearS.setText(textYear.getText());
		monS.setText(Integer.toString(nowMonth+1));
		
		variablePrint();
		NowCalendarPrint(label, button);
		AfterCalendarPrint(label);	
		BeforeCalendarPrint(label);
		memoDelete(button);
		memoPrint(button, nowMonth);
		
		
	}
	
	public void BeforeCalendarPrint(JLabel[] label) {
		for (int i = firstDayOfWeek-2; i >= 0; i--) {
			label[i].setText(Integer.toString(beforeLastDay));
			label[i].setForeground(Color.gray);
			beforeLastDay--;
		}
	}
	
	public void NowCalendarPrint(JLabel[] label, JButton[] button) {
		
		int firstDOW = firstDayOfWeek;
		for (int i = 1; i <= lastDay; i++) {
			label[firstDOW - 1].setText(Integer.toString(i));
			label[firstDOW-1].setForeground(Color.white);
			button[firstDOW-1].setBorder(BorderFactory.createLineBorder(new Color(10, 100, 50, 100)));
			
			
			if(i==nowDay) {
				button[firstDOW-1 ].setBorder(BorderFactory.createLineBorder(new Color(67,116,217,140)));
				label[firstDOW-1].setForeground(new Color(67,116,217));
			}
			firstDOW++;
		}
		
	}
	
	public void AfterCalendarPrint(JLabel[] label) {
		for (int i = firstDayOfWeek+lastDay ; i <=42; i++) {
			label[i-1].setText(Integer.toString(afterFirstDay));
			label[i-1].setForeground(Color.gray);
			afterFirstDay++;
			
		}
	}
	public void memoDelete(JButton[] button) {
		for(int i = 0; i< 42 ; i++) {
			button[i].setText("");
		}
	}
	
	public void memoPrint(JButton[] button, int nowMonth) {
		ArrayList<DJavaData> list = dcdb.getAllData();
		for (int i = 0; i < list.size(); i++) {
			DJavaData data = list.get(i);
			if(Integer.parseInt(data.getDate().substring(5,7))==nowMonth+1) {
				button[Integer.parseInt(data.getDate().substring(8,10))+firstDayOfWeek-2].setText(data.getMemo());
			}
		}
	}
	
	public void memoUpdate(int i, String saveText,int labelDay) {
		button[i].setText(saveText);
		dcdb.updateData(saveText,nowYear,nowMonth+1 ,labelDay);
	}
	
	
	public void variablePrint() {
		System.out.println("현재 달  : "+(nowMonth+1));
		System.out.println("현재 날짜  : "+nowDay);
		System.out.println("1일이 잇는 요일 숫자  : "+firstDayOfWeek);
		System.out.println("마지막날짜 이번달  : "+lastDay);
		System.out.println("전 달  : "+(beforeMonth+1));
		System.out.println("전달 마지막날  : "+beforeLastDay);
		System.out.println("다음달  :  "+(afterMonth+1));
		System.out.println("다음달 첫째날  : "+afterFirstDay);
	}
	
	
}
