package CardGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Gpanel2 extends JPanel{
	
	private JPanel panelTop ; 
	private JLabel labelLeft;
	private JLabel labelRight ;
	private JTextField textField ;
	private JLabel middle ; 
	private JButton[] buttons = new JButton[16];
	private ImageIcon imageback , image;
	
	
	
	public Gpanel2(GameFrame frame,GameCard game, GameTimer time, GameLife life, GameText text) {	
			
		// settting of panel
		this.setBackground(Color.white);
		this.setLayout(null);
		this.setBounds(0,0,600,103);
		
		// setting of top Part
		labelLeft = new JLabel();
		labelLeft.setFont(new Font("serif",Font.BOLD,40));
		labelLeft.setBounds(10,5,150, 60);
		labelRight = new JLabel(life.getShow());
		labelRight.setFont(new Font("serif",Font.BOLD,40));
		labelRight.setBounds(160,5,450, 60);
		textField = new JTextField(); 
		textField.setBackground(Color.black);
		textField.setForeground(Color.white);
		textField.setFont(new Font("serif",Font.PLAIN,17));
		textField.setBounds(0,60,600,43);
		this.add(labelLeft);
		this.add(labelRight);
		this.add(textField);
		life.showLife();
		labelRight.setText(life.getShow());
		labelRight.getText();
		
		// setting of middle Part
		middle = new JLabel() { 
			ImageIcon i = new ImageIcon("img/PanelBack1.jpg");
			public void paintComponent(Graphics g) {
			g.drawImage(i.getImage(),0,0,600,720,null);}};	
		middle.setBounds(0,103,600,720);
		middle.setLayout(new GridLayout(4,4,15,10));
		middle.setBorder(new EmptyBorder(10,20,10,20));
		for(int i=0 ; i<16 ; i++) {
			game.matchView(buttons, i);
			buttons[i].setBackground(Color.white);
			buttons[i].setOpaque(false);
			middle.add( buttons[i] );
			buttons[i].setCursor(new Cursor(Cursor.HAND_CURSOR)); // button 커서 모양 변경 
			buttons[i].addActionListener(new ActionListener(){    // ActionLister 익명 클래스로 선언 
				public void actionPerformed(ActionEvent e) {
					Runnable btn = new ButtonSound();             // buttonSound를 Thread사용 
					Thread t = new Thread(btn);
					t.start();
					for(int i= 0 ; i<16 ; i++) {
						if(e.getSource() == buttons[i]) {	
							game.setCard(game.getCardCount() , i);
							image = new ImageIcon(game.getImage(i));
							buttons[i].setIcon(image);
							game.plusCardCount();
						}
						if(game.getCardCount()==2) {			  // 뒤집은 카드 2장을 비교
							game.cardCompare( buttons ,labelRight, life );
							life.showLife();		
							if(game.getTruth().equals("o")) { 	
								time.setDap(1);
								textField.setText(text.OPrint());	
							}
							else {
								textField.setText(text.XPrint());
							}
						textField.getText();
						labelRight.setText(life.getShow());
						labelRight.getText();
						game.resetCardCount();
						}
					}
				}
			});
		}
		this.add(middle);
		this.setVisible(true);		
	}
	
	// Game 시작 시  설정 메서드 
	public void sSet(GameFrame frame, GameCard game, GameTimer time, GameLife life, GameText text) {
		life.setLife();
		life.showLife();
		labelRight.setText(life.getShow());
		labelRight.getText();
		textField.setText("      게임 시작 전 잠시 기다려주세요.");
		labelLeft.setText("COUNT");
		game.backView(buttons);	
		time.resetCount();
		time.resetDap();
		try {Thread.sleep(1000);} catch (InterruptedException g) {};			
		game.randomSet(16);	
		text.textPrint(textField,1);
		game.firstView(buttons);
		time.starttimeOut(labelLeft,life,text,textField);	
		game.backView(buttons);
		text.textPrint(textField,2);
		time.setCount(20);
		time.timeOut(labelLeft,life,text,textField);
		frame.prePanel();
	}
	
	// panel of backgroundImage // Override
	@Override
	public void paintComponent(Graphics g){
		ImageIcon i = new ImageIcon("img/PanelBack.jpg");
		g.drawImage(i.getImage(),0,0,605,830,null);
	}
}

