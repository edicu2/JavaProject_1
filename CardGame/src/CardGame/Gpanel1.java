package CardGame;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;



public class Gpanel1 extends JPanel implements MouseListener {
	
	private JPanel panelFirst;
	private JButton button1;
	private JButton button2;
	private BufferedImage image;
	
	public Gpanel1(GameFrame frame,GameCard game, GameTimer time, GameLife life,GameText text,Gpanel2 Gp2) {	
		// setting of panel
		setSize(605,830);
		setLayout(null);
		
		//setting of Button1, Button2
		button1 = new JButton() {		
			ImageIcon i = new ImageIcon("img/startbutton.png");  // image 익명 클래스로 선언 
			public void paintComponent(Graphics g) {
			g.drawImage(i.getImage(),0,0,395,417,null);}};
		button1.setBounds(110,210,395,417);
		button1.setBackground(Color.white);
		button1.setOpaque(false);				// button 투명도 관련 - setOpaque, setBorderPainted, setContentAreaFilled
		button1.setBorderPainted(false);
		button1.setContentAreaFilled(false);
		button1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button1.addMouseListener(this);
		button1.addActionListener(new ActionListener() { // ActionListener (무명)익명 클래스 선언 
			public void actionPerformed(ActionEvent e) {	
				Runnable btn = new doorSound();
				Thread t = new Thread(btn);
				t.start();		
				frame.prePanel();
				class sett implements Runnable{					// Gpanel2 게임 시작 시 setting 메서드를 내부 클래스 안에 넣고
					public void run() {							// Thread로 사용
						Gp2.sSet(frame,game, time, life, text); 
					}
				}
				Runnable settt = new sett();
				Thread tt = new Thread(settt);
				tt.start();	
			}
		});
		button2 = new JButton() {
			ImageIcon i = new ImageIcon("img/exitButton.png");
			public void paintComponent(Graphics g) {
			g.drawImage(i.getImage(),0,0,130,90,null);}};
		button2.setBounds(450,30,130,90);
		button2.setBackground(Color.white);
		button2.setOpaque(false);
		button2.setBorderPainted(false);
		button2.setContentAreaFilled(false);
		button2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button2.addMouseListener(this);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);	
			}
		});
		add(button1);
		add(button2);
		this.setVisible(true);			
	}
	
	// panel of backgroundImage
	@Override
	public void paintComponent(Graphics g){
		ImageIcon i = new ImageIcon("img/startimg.jpg");
		g.drawImage(i.getImage(),0,0,605,830,null);
	}	
	
	// MouseListner 
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()== button1) button1.setBounds(110,210,390,410);
		else if(e.getSource()== button2) button2.setBounds(450,30,130,90); };
	/*마우스가 컴포넌트 안으로 들어온 상태*/
	public void mouseEntered(MouseEvent e) {
		if(e.getSource()== button1)button1.setBounds(109,212,386,400);
		else if(e.getSource()== button2) button2.setBounds(447,34,125,90);};
	
	/*마우스가 컴포넌트 밖으로 나간 상태*/
	public void mouseExited(MouseEvent e) {
		if(e.getSource()== button1)button1.setBounds(110,210,390,410);
		else if(e.getSource()== button2) button2.setBounds(450,30,130,90);};
	/*마우스 눌린 상태*/
	public void mousePressed(MouseEvent e) {
		if(e.getSource()== button1)button1.setBounds(108,213,382,398);
		else if(e.getSource()== button2) button2.setBounds(447,34,125,90);};
	/*마우스가 눌려서 풀린 상태*/
	public void mouseReleased(MouseEvent e) {};
}


