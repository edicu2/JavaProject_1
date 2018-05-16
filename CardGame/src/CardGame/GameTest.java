package CardGame;

public class GameTest {

	public static void main(String[] args) {
		GameSound sound = new GameSound();  // button , BGM sound..
		GameText text = new GameText();     // text input TextField 
		GameCard card = new GameCard();     // cardRandomSet , cardCompare , cardCount ..  
		GameTimer time = new GameTimer();   // Game TimeOut 
		GameLife life = new GameLife();     // life 
		
		//GameGui gui = new GameGui(card, time , life, text);
		GameFrame f = new GameFrame(card, time , life, text);
		
	}
}
