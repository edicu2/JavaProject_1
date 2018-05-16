package CardGame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Gpanel3 extends JPanel{
	private JButton btn;
	private BufferedImage image;
	
	public Gpanel3(GameFrame frame,GameCard game, GameTimer time, GameLife life, GameText text,Gpanel2 Gp2) {	
		// setting of panel
		setSize(950,630);
		setLayout(null);
		// button (+)add
		buttonAdd(this,"HOME",frame,game,time,life,text,Gp2);
		buttonAdd(this,"한판 더하기",frame,game,time,life,text,Gp2);
		buttonAdd(this,"종료하기",frame,game,time,life,text,Gp2);
		setVisible(true);
		frame.add(this);
		frame.setVisible(true);
	}
	// method of button (+)add
	public void buttonAdd(Container t,String s,GameFrame f,GameCard game, GameTimer time, GameLife life, GameText text,Gpanel2 Gp2) {
		btn = new JButton(s);
		btn.setBackground(Color.white);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // ActionListener 익명 클래스
				Runnable btn = new ButtonSound();
				Thread t = new Thread(btn);
				t.start();
				if(e.getActionCommand().equals("한판 더하기")) {
					f.nextPanel();
					class settt implements Runnable{           // 익명 클래스에 Gpanel2 게임 시작 시  setting 메서드를 넣고 
						public void run() {
							Gp2.sSet(f,game, time, life, text);// thread 로 사용 
						}
					}
					Runnable settt = new settt();
					Thread tt = new Thread(settt);
					tt.start();	
				}
				else if(e.getActionCommand().equals("HOME"))
					f.prePanel();
				else 
					System.exit(1);
			}
		});
		// each of button sets setBounds
		if(btn.getText().equals("HOME"))
			btn.setBounds(240, 280, 130, 43);
		else if(btn.getText().equals("한판 더하기"))
			btn.setBounds(240,380, 130, 43);
		else 
			btn.setBounds(240,480, 130, 43);
		t.add(btn);
	}
	
	// backgroundImage of panel 
	@Override
	public void paintComponent(Graphics g){
		ImageIcon i = new ImageIcon("img/endimg2.png");
		g.drawImage(i.getImage(),0,0,605,830,null);
	}
	
}


