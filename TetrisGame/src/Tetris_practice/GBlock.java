package Tetris_practice;

import javax.swing.ImageIcon;

public class GBlock {
	private String blockColor[]= {"img//block1.png","img//block2.png",
			"img//block3.png","img//block4.png","img//block5.png",
							  "img//block6.png","img//block1.png"};
	private int array[][][] = {
			//Longblock position
			{{0,0},{1,0},{2,0},{3,0}},
			//Lblock position
			{{0,0},{1,0},{2,0},{2,1}},
			//oblock position 
			{{0,0},{0,1},{1,0},{1,1}},
			//Zblock position
			{{0,0},{0,1},{1,1},{1,2}},	
			//ReLblock positon 
			{{0,1},{1,1},{2,1},{2,0}},
			//Ablock position
			{{0,0},{1,0},{1,1},{2,0}},
			//ReZblock postion 
			{{0,1},{0,2},{1,0},{1,1}}
		};  // 좌표 x , y를 바꾸면 도형 위치 변경 
	int x;
	int y;
	
	GFrame f;
	public GBlock(GFrame f) {
		this.f = f;
	}
	
	public void BlockPrint() {
		int rdm = (int)(Math.random()*7);
		int i=0;
		while(true) {
			x = array[rdm][i][0]+1; 
			y = array[rdm][i][1]+1;
			f.label[x][y].setIcon(new ImageIcon(blockColor[rdm]));
			i++;
			if(i>=array[rdm].length) break;
		}
	}
	
}
