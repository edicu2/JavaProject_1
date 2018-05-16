package CardGame;

import javax.swing.JTextField;

public class GameLife {
	private int life;
	private String show;

	public GameLife(){
		life = 10;
	}
	// life show
	public void showLife() {
		show="";
		for ( int i=10 ; i>0 ; i-- ) {		
			if(i>life)
				show += "¡Ù";
			else
				show += "¡Ú";
		}
	}
	public String getShow() {
		return show;
	}
	
	// setting of life 
	public void minusLife() {
		show="";
		life--;		
	}
	public int getLife() {
		return life;
	}
	public void setLife() {
		life =10 ;
	}
}
