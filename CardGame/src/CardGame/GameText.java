package CardGame;

import javax.swing.JTextField;

public class GameText {
	private String[] sentence= {
			"",
			"         게임을 시작합니다.!  생명은 별 10개 , 카운트가 끝난 후 카드는 뒤집힙니다.                            ",
			"	게임 S T A R T  ! ! !    20초가 부여됩니다.                     ",
			"		         정답입니다 ! ! ",
			"		         틀렸습니다 ! !  (- ★)",
			"           시간이 다되었습니다.      G A M E  O V E R .. . . . . . . .. . . .     ",
			"           생명을 다 썼습니다.        G A M E  O V E R .. . . . . . . .. . . .      "
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
