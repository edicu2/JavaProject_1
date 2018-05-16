package CardGame;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;


public class GameCard {
	private int[] random = new int[16];
	
	private Queue<Integer> randqueue = new LinkedList<Integer>();
	private Map<Integer,String> imageMap = new HashMap();
	
	private String[] image = new String[16];
	private String[] imageAddress = new String[8];
	private int[] card =new int[2];
	private int cardCount=0;
	private String truth="";

	
	public GameCard() {
		
		for(int i=0 ;i<8 ;i++) {
			imageMap.put(i,"img/img0"+(i+1)+".png");
		}
		
		
	}
	//Getter and Setter (String truth)
	public String getTruth() {
		return truth;
	}
	public void setTruth(String truth) {
		this.truth = truth;
	}
	// CardSetting (related cardRandomSet)
	public void setCard(int count, int imgnumber) {
		this.card[count] = imgnumber;
	}
	// relationMethod of Count 
	public int getCardCount() {
		return cardCount;
	}
	public void plusCardCount() {
		cardCount++;
	}
	public void resetCardCount() {
		cardCount=0;
	}	
	public String getImage(int i) {
		return image[i];
	}	
	// view Method 
	public void matchView(JButton[] button, int i) {
		button[i]= new JButton(new ImageIcon(image[i]));
	}
	public void firstView(JButton[] button) {
		for(int i= 0 ; i < 16 ; i++){
			button[i].setIcon(new ImageIcon(image[i]));
		}
	}
	public void backView(JButton[] button) {
		for(int i= 0 ; i < 16 ; i++){
			button[i].setIcon(new ImageIcon("img/backimg.jpg"));
		}
	}
	// two cards Compare
	public void cardCompare(JButton[] button ,JLabel label, GameLife life ) {
		if(!(image[card[0]].equals(image[card[1]])) || card[0]==card[1]) {  // 같은 자리의 카드 2번 클릭 , 2개의 카드가 다른 이미지 일 때
			truth="x";
			life.minusLife();
			button[card[0]].setIcon(new ImageIcon("img/backimg.jpg"));
			button[card[1]].setIcon(new ImageIcon("img/backimg.jpg"));	
		}
		else truth="o";
	}
	

	public void randomSet(int x) {
		int num; 
		while(true) {
			num = (int)(Math.random()*16);
			if(randqueue.contains(num)) continue;
			else break;
		}
		randqueue.offer(num);
		if(x == 1) {  
			int imgNum=0;
			for(int i=0 ; i<16 ; i++) {
				if( i%2==0  &&  i!=0 )  imgNum++;
				image[randqueue.poll()] = imageMap.get(imgNum);		
			}	
			return;
		}
		randomSet(x-1);
	}
	
	

	
	
	
}
