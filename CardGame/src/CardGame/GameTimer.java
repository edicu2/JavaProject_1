package CardGame;

import javax.swing.JLabel;
import javax.swing.JTextField;


public class GameTimer {

	private int count=10;
	private int dap = 0 ; 
	private String printTime="";
	
	// Getter and Setter ()
	public int getDap() {
		return dap;
	}
	public void resetDap() {
		dap= 0;
	}
	public void setDap(int dap) {
		this.dap += dap;
	}

	public int getCount() {
		return count;
	}
	public void resetCount() {
		this.count= 10;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	public String getPrintTime() {
		return printTime;
	}
	
	// Setting CountTime 
	public void setPrintTime(String printTime) {
		this.printTime = printTime;
	}
	
	// Start Count (Before the game begins)
	public void starttimeOut(JLabel la , GameLife life, GameText text , JTextField textField) {
		
		try {
			for(int i=count ; i>=0 ; i--) {
				if(i<10)setPrintTime("00:0"+Integer.toString(i));
				else setPrintTime("00:"+Integer.toString(i));			
				Thread.sleep(1000);			
				la.setText(getPrintTime());
				la.getText();
			}		
		} catch (InterruptedException g) {};
	}
	// card matching count
	public void timeOut(JLabel la , GameLife life, GameText text , JTextField textField) {
		
		for(int i=count ; i>=0 ; i--) {
			if(i<10)setPrintTime("00:0"+Integer.toString(i));
			else setPrintTime("00:"+Integer.toString(i));			
			try {Thread.sleep(1000);} catch (InterruptedException g) {};
			la.setText(getPrintTime());
			la.getText();
			
			// Ending condition (if(life), if(clear), if(timeOut)) 
			if(life.getLife()==0) {
				textField.setText(text.sentence6());
				break;
				}
			if(dap==8) {
				
				textField.setText("  		     C L E A R !!! ");			
				break;}
			if(i<=0) {
				textField.setText(text.sentence5());
				break;
			}
		}
		try{Thread.sleep(3000);}catch(InterruptedException e) {};
	}
}
