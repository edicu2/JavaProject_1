package CardGame;

import javax.swing.JTextField;

public class GameText {
	private String[] sentence= {
			"",
			"         ������ �����մϴ�.!  ������ �� 10�� , ī��Ʈ�� ���� �� ī��� �������ϴ�.                            ",
			"	���� S T A R T  ! ! !    20�ʰ� �ο��˴ϴ�.                     ",
			"		         �����Դϴ� ! ! ",
			"		         Ʋ�Ƚ��ϴ� ! !  (- ��)",
			"           �ð��� �ٵǾ����ϴ�.      G A M E  O V E R .. . . . . . . .. . . .     ",
			"           ������ �� ����ϴ�.        G A M E  O V E R .. . . . . . . .. . . .      "
	};
	
	
	
	
	public void textPrint(JTextField textField,int x) {
		try{Thread.sleep(3000);}catch(InterruptedException e) {};	
		
		for(int i=0 ; sentence[x].length() > i ; i++) {
			sentence[0]+=sentence[x].charAt(i);
			try{Thread.sleep(60);}catch(InterruptedException e) {};			
			textField.setText(sentence[0]);
			textField.getText();
		}

		sentence[0]="";
		textField.setText(sentence[0]);
		textField.getText();
		
	}	
	
	public String XPrint() {
		return sentence[4] ; 
	}
	
	public String OPrint() { 
		return sentence[3] ; 
	}
	
	public String sentence5() {
		return sentence[5] ; 
	}
	
	public String sentence6() {
		return sentence[6] ;
	}

}
