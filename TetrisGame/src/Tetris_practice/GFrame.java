package Tetris_practice;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GFrame extends JFrame{
	GBlock block = new GBlock(this);
	JFrame frame;
	JPanel panel;
	JLabel label[][]= new JLabel[22][12];
	
	public GFrame() {
		frame = new JFrame();
		frame.setSize(380,630);
		frame.setLayout(null);

		panel = new JPanel();
		panel.setBounds(0,0,375,610);
		panel.setBackground(Color.white);
		panel.setLayout(new GridLayout(22,12,1,1));
				
		for(int i=0 ; i<22 ;i++) {
			for(int j=0 ; j<12;j++ ) {
				if( (j>=1 && j<=10) && (i>=1 && i<=20) ) {
					label[i][j] = new JLabel("0");
					label[i][j].setIcon(new ImageIcon("img//pic.jpg"));			
				}
				else {
					label[i][j] = new JLabel(" ");
				}
				panel.add(label[i][j]);
			}
		}
		
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		block.BlockPrint();
	}
}
