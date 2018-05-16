package CardGame;

import java.awt.CardLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GameFrame extends JFrame {
	
	private CardLayout cards = new CardLayout();
	private JPanel panelTop ; 
	private JLabel labelLeft;
	private JLabel labelRight ;
	private JTextField textField ;
	private JPanel panelCenter ; 
	private JButton[] buttons = new JButton[16];
	// swing of secondPanel
	
	private ImageIcon imageback , image;
	private JPanel panelLast ;
	// swing of thridPanel
	
	private GameCard game;	
	private GameTimer time;
	private GameLife life;
	private GameText text;
	private GameSound sound;
	// method 사용을 위해 클래스를 불러옴.

	public GameFrame(GameCard game, GameTimer time, GameLife life, GameText text){
		this.game = game;	
		this.time = time;
		this.life = life;
		this.text = text;
		Gpanel2 Gp2;
		setBounds(550,100,605,850);
		getContentPane().setLayout(cards);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		
		getContentPane().add("two",Gp2=new Gpanel2(this,game,time,life,text));
		getContentPane().add("one",new Gpanel1(this,game,time,life,text,Gp2));
		getContentPane().add("three",new Gpanel3(this,game,time,life,text,Gp2));
		cards.show(this.getContentPane(), "one");;
	}
	public void lastPanel() {
		cards.last(this.getContentPane());
	}
	
	public void prePanel() {
		cards.previous(this.getContentPane());
	}
	
	public void nextPanel() {
		cards.next(this.getContentPane());
		
	}	
	
}
