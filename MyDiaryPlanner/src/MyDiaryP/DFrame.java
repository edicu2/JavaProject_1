package MyDiaryP;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DFrame implements ActionListener {

	private JFrame frame;
	private JPanel panelTop, panelCenter, panelBottom;
	private JTextField textYear, textMonth, textDate;
	private JLabel labelYear, labelMonth, labelDate, yearSee, monthSee,monthT;
	private JButton searchButton, exitButton;
	private JButton[] button = new JButton[42];
	private JLabel[] label = new JLabel[42];
	private DCalendar dCalendar = new DCalendar();
	private Point mouseClickedLocation = new Point(0, 0);

	public DFrame() {
		// frame setting
		frame = new JFrame();
		frame.setBounds(200, 40, 1300, 920);
		frame.setLayout(null);
		frame.setUndecorated(true);
		frame.setBackground(new Color(0, 0, 0, 210));
		frame.addMouseListener(new FrameMove_mouseAdapter(this));
		frame.addMouseMotionListener(new FrameMove_mouseMotionAdapter(this));
		// panelTop setting
		panelTop = new JPanel();
		panelTop.setOpaque(false);
		panelTop.setLayout(null);
		panelTop.setBounds(0, 0, 1300, 100);
		// MonthLabel setting -> panelTop
		Font font = new Font("Serif", Font.ITALIC, 60);
		yearSee = new JLabel();
		yearSee.setBounds(40,50,140,50);
		yearSee.setFont(font);
		yearSee.setOpaque(false);
		yearSee.setForeground(Color.white);
		
		monthSee = new JLabel();
		monthSee.setBounds(180,50,70,50);
		monthSee.setFont(font);
		monthSee.setOpaque(false);
		monthSee.setForeground(Color.white);
		
		monthT = new JLabel(".");
		monthT.setBounds(157,50,70,50);
		monthT.setFont(font);
		monthT.setOpaque(false);
		monthT.setForeground(Color.white);
		// TextField Setting -> panelTop
		textYear = new JTextField("");
		textYear.setBounds(970, 70, 60, 30);
		TextfieldSet(textYear);
		textMonth = new JTextField("");
		textMonth.setBounds(1060, 70, 40, 30);
		TextfieldSet(textMonth);
		textDate = new JTextField("");
		textDate.setBounds(1130, 70, 40, 30);
		TextfieldSet(textDate);
		
		// JLabel Setting -> panelTop
		labelYear = new JLabel("³â ");
		LabelSet(labelYear);
		labelYear.setFocusable(true);
		labelYear.setBounds(1035, 70, 30, 30);
		labelMonth = new JLabel("¿ù");
		LabelSet(labelMonth);
		labelMonth.setBounds(1105, 70, 20, 30);
		labelDate = new JLabel("ÀÏ");
		LabelSet(labelDate);
		labelDate.setBounds(1175, 70, 20, 30);
		// ExitButton Setting
		exitButton = new JButton(" X ");
		exitButton.setFont(new Font("SansSerif", Font.BOLD, 16));
		exitButton.setBounds(1230, 10, 53, 35);
		exitButton.setBackground(Color.black);
		exitButton.setForeground(Color.white);
		exitButton.addActionListener(this);
		// searchButton Setting
		searchButton = new JButton(" SEARCH ");
		searchButton.setBounds(1200, 70, 90, 30);
		searchButton.setBackground(Color.black);
		searchButton.setForeground(Color.white);
		searchButton.addActionListener(this);
		// panelCenter setting
		panelCenter = new JPanel() {
			ImageIcon i = new ImageIcon("diary_img/Days.png");
			public void paintComponent(Graphics g) {
				g.drawImage(i.getImage(), 0, 10, 1300, 100, null);
			}
		};
		panelCenter.setBounds(0, 80, 1300, 100);
		// panelBottom setting
		panelBottom = new JPanel();
		panelBottom.setOpaque(false);
		panelBottom.setLayout(new GridLayout(6, 7, 5, 5));
		panelBottom.setBounds(0, 200, 1300, 710);
		// add all
		panelTop.add(yearSee);
		panelTop.add(monthSee);
		panelTop.add(monthT);
		panelTop.add(labelYear);
		panelTop.add(labelMonth);
		panelTop.add(labelDate);
		panelTop.add(textYear);
		panelTop.add(textMonth);
		panelTop.add(textDate);
		panelTop.add(exitButton);
		panelTop.add(searchButton);
		frame.add(panelTop);
		frame.add(panelCenter);
		addButton(panelBottom);
		addLabel(button);
		frame.add(panelBottom);
		// frame setting
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Insert date on button
		dCalendar.Calendar(label, button,yearSee,monthSee);
	}

	// Button add
	public void addButton(JPanel panel) {
		for (int i = 0; i < 42; i++) {			
			button[i] = new JButton();
			button[i].setBorder(BorderFactory.createLineBorder(new Color(10, 100, 50, 100)));
			button[i].setContentAreaFilled(false);
			button[i].setOpaque(false);
			button[i].setLayout(null);
			button[i].setForeground(Color.white);
			button[i].setFont(new Font("SansSerif", Font.BOLD, 14));
			button[i].addActionListener(this);
			panel.add(button[i]);
		}
	}

	// label add
	public void addLabel(JButton[] button) {
		for (int i = 0; i < 42; i++) {
			label[i] = new JLabel();
			label[i].setBorder(BorderFactory.createLineBorder(new Color(10, 100, 50, 100)));
			label[i].setBounds(0, 0, 30, 30);
			label[i].setOpaque(false);
			label[i].setFont(new Font("SansSerif", Font.BOLD, 15));
			button[i].add(label[i]);
		}
	}

	// LabelYaer,Month,Date attribute
	public void LabelSet(JLabel label) {
		Font font = new Font("SansSerif", Font.BOLD, 16);
		label.setFont(font);
		label.setOpaque(false);
		label.setForeground(Color.red);
	}

	// LabelYaer,Month,Date attribute
	public void TextfieldSet(JTextField text) {
		Font font = new Font("SansSerif", Font.BOLD, 16);
		text.setFont(font);
		text.setBackground(new Color(0, 0, 0, 130));
		text.setForeground(Color.WHITE);
		text.setHorizontalAlignment(JTextField.RIGHT);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exitButton) {
			System.exit(0);
		} else if(e.getSource() == searchButton){
			dCalendar.SearchCalendar(label, button, textYear, textMonth, textDate,yearSee,monthSee);
		} 
		for(int i=0 ; i<42 ; i++) {
			if(e.getSource()==button[i]) {
				String buttonText = button[i].getText();
				int labelDay=Integer.parseInt(label[i].getText());
				DMemoField d =new DMemoField(buttonText , i , dCalendar , labelDay);
				
			}
		}
		
	}

	// frameMove class
	class FrameMove_mouseMotionAdapter extends MouseMotionAdapter {
		private DFrame frame;
		FrameMove_mouseMotionAdapter(DFrame frame) {
			this.frame = frame;
		}
		
		public void mouseMove(MouseEvent e) {
		}

		public void mouseDragged(MouseEvent e) {
			frame.frame.setLocation(e.getLocationOnScreen().x - frame.mouseClickedLocation.x,
					e.getLocationOnScreen().y - frame.mouseClickedLocation.y);
		}
	}

	class FrameMove_mouseAdapter extends MouseAdapter {
		private DFrame frame;

		FrameMove_mouseAdapter(DFrame frame) {
			this.frame = frame;
		}

		public void mousePressed(MouseEvent e) {
			frame.mouseClickedLocation.x = e.getX();
			frame.mouseClickedLocation.y = e.getY();
		}

		public void mouseReleased(MouseEvent e) {
		}
	}

}
