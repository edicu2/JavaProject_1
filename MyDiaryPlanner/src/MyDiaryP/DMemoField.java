package MyDiaryP;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class DMemoField extends JFrame implements ActionListener {

	private JPanel panel;
	private JTextField textField;
	private JButton saveButton;
	private int buttonNum =0;
	private String saveText="";
	private int labelDay;
	private DCalendar dCalendar = null;
	
	public int getButtonNum() {
		return buttonNum;
	}

	public String getSaveText() {
		return saveText;
	}


	public DMemoField(String memo, int buttonNum , DCalendar dCalendar, int labelDay) {
		this.labelDay = labelDay;
		this.dCalendar = dCalendar;
		setBounds(200, 40, 700, 500);
		setLayout(null);
		setUndecorated(true);
		setBackground(new Color(0, 0, 0, 215));
		
		saveButton = new JButton("X");
		saveButton.setFont(new Font("SansSerif", Font.BOLD, 12));
		saveButton.setBounds(653, 3, 42, 35);
		saveButton.setBackground(Color.black);
		saveButton.setForeground(Color.white);
		saveButton.addActionListener(this);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 700, 500);
		panel.setOpaque(false);
		panel.setLayout(null);
		
		textField = new JTextField(memo);
		textField.setBounds(0, 40, 700, 460);
		textField.setOpaque(false);
		textField.setFont(new Font("°íµñ",Font.PLAIN,20));
		textField.setForeground(Color.white);
		
		panel.add(saveButton);
		panel.add(textField);
		add(panel);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.buttonNum = buttonNum;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==saveButton) {
			saveText = textField.getText();
			dCalendar.memoUpdate( buttonNum, saveText,labelDay);
			
			dispose();
			
		}
		
	}
}
