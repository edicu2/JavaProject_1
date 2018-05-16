package DamagochiGame;
	import java.util.*;
	public class Student {
	
		Scanner scan= new Scanner(System.in);
		String pass, passcheck;   // 비밀번호 설정을 위한 변수 
							      //- 종료시킬때 정보가 다 날아감 그래서 비밀번호를 입력해 잘못 선택하는 것을 막기 위함
		
		String Dama_name="";      //  이름  변수
		
		String player="";         // 다마고치를 키우는 플레이어의 이름 변수
		
		int hungry = 50;          // 포만감  
		int hungrycnt=0;          // 0이하의 경우가 3번 생기면 사망시키기 위한 카운트 변수 
		int hungrymaxcnt=0;  //포만감이 100을 초과하는 경우가 연속할 경우 사망시키기 위한 카운트 변수
		
		int money = 5000;         //처음 소지금 
		int bank = 500000;       // 은행 잔고 
		
		int happy = 50;           // 행복도
		int happycnt=0;	          // 행복도가 20 이하 경우가 계속 될 경우 카운트하는 변수 
		
		int exp=0;        		  // 경험치
		
		int level=3;              // 레벨
		String levelSee[]= {" ( 유치원생 )"," ( 초등학생 )"," ( 중학생 )"," ( 고등학생 )"," ( 대학생 )"};
					              // 레벨에 따라서 5단계로 이름을 나눔  ex)레벨 1 유치원생, 레벨2 초등학생
		
		int onlyplaycnt=0;        //놀기를 연달아서 하게되면 카운트하는 변수 
						
		int chaselect;     		  //시작 시 캐릭터 선택을 위한 변수   (1번 남자  , 2번 여자 ) 
		
	
	
	
		public void damaimg1() {	   /*      damaimg1, damaimg2 
									    * 캐릭터를 선택하는 부분과, 다마고치의 이름을 적을 때 
									    * 캐릭터를 예시로 보여주기 위해 사용
										*/ 
			System.out.println();
			System.out.println("      ┌───∫∬───┐");
			System.out.println("    │   Λ         Λ  │ ");
			System.out.println(" ♪  │        ▼       │");
			System.out.println("    └────────────────┘");
			System.out.println("   	 ________                         1번(남자)"); //1-1                  
			System.out.println(" 	⊂ │        ∪       │ ⊃");
			System.out.println("   	│───┬───│");
			System.out.println("   	└───┴───┘");
			System.out.println("      	       ∪   ∪");
			System.out.println();
		}
		
		
		public void damaimg2() {
			System.out.println(); 
			System.out.println("       ┌───∫∬∫──┐");
			System.out.println("     │  Λ         Λ  │ ");
			System.out.println(" ♪   │       ▼       │");
			System.out.println("     └───────────────┘");
			System.out.println("   	 ________                         2번(여자)"); //2-1
			System.out.println("	 ⊂│    ∪     │⊃");
			System.out.println("   	/〓〓〓〓\\ ");
			System.out.println("    	      ∪   ∪");		
			System.out.println();
		}
		
		public void damaimghead1_1() {      				// 얼굴표정을 달리 하기 위해 머리카락 부분만 표현
			System.out.println();           							
			System.out.println("     ┌───∫∬───┐");
		}
		public void damaimgbody1_1() {      // 레벨에 따른 신체 변화를 표현 및 행위에 따른 상태 게이지 표현
			int showcnt=0;  // 데이터를 게이지로 표현 시키기 위한 카운트 변수 
			
			System.out.print("    	________        "+"  행 복  :");// 캐릭터의 오른쪽에 데이터를 표현하기 위함
			
			while(happy/5!=showcnt) {							 				  
				System.out.print("■");							  //  데이터를 보기 쉽게 게이지로 나타냄	
				showcnt+=1;										
			}
			System.out.println(" "+happy+""); 					   // 게이지 뒤에 정확한 수치를 나타냄 
				showcnt=0;										   // ex) 행복 : ■■■■■■■■ 80
				
			System.out.print("                 ⊂ │        ∪         │ ⊃"+" 	     포만감 :");
			while(hungry/5!=showcnt) {
				System.out.print("■");
				showcnt+=1;
			}
			System.out.println(" "+hungry+""); 
				showcnt=0;
			System.out.print("   	│───┬───│");
			System.out.println(" 	       돈     :" + money+"원" + "(은행잔고 : " + bank+"원)") ;
			
			if(level>=3)System.out.println("   	│   │   │");        // 레벨에 따라 신체 변화 표현
			
			System.out.println("   	└───┴───┘");
			if(level>=2)System.out.println("          |   |");      // 레벨에 따라 신체 변화 표현
			if(level>=4)System.out.println("          |   |");      // 레벨에 따라 신체 변화 표현
			System.out.println("      	      ∪      ∪");	
		}
		
		
		public void damaimghead2_1() {		                  // 얼굴표정을 달리 하기 위해 머리카락 부분만 표현 
			System.out.println();								
			System.out.println("     ┌───∫∬∫──┐");  
		}
		
		public void damaimgbody2_1() {                     // 레벨에 따른 신체 변화를 표현 및 행위에 따른 상태 게이지 표현
			int showcnt=0;   // 데이터를 게이지로 표현 시키기 위한  변수 
			System.out.print("   	________         "+"  행 복  :");// 캐릭터의 오른쪽에 데이터를 표현하기 위함      
			while(hungry/5!=showcnt) {								
				System.out.print("■");								//  데이터를 보기 쉽게 게이지로 나타냄
				showcnt+=1;
			}
			System.out.println(" "+happy+""); 						// 게이지 뒤에 정확한 수치를 나타냄   
			showcnt=0;												// ex) 행복 : ■■■■■■■■ 80
			System.out.print("	⊂│    ∪     │⊃      "+" 	     포만감 :");
			while(hungry/5!=showcnt) {
				System.out.print("■");
				showcnt+=1;
			}
			System.out.println(" "+hungry+""); 
				showcnt=0;
			System.out.print("   	/〓〓〓〓\\");
			System.out.println(" 	       돈     :" + money+"원" + "(은행잔고 : " + bank+"원)") ;
			if(level>=2) {System.out.println("       /〓〓〓〓〓\\ ");} // 레벨에 따라 신체 변화 표현
			if(level>=3) {System.out.println("      /〓〓〓〓〓〓\\ ");}// 레벨에 따라 신체 변화 표현
			if(level>=4) {System.out.println("    	   | | ");}        // 레벨에 따라 신체 변화 표현
			System.out.println("    	       ∪   ∪");		
		}
		
		
		public void damafeel() {             //  캐릭터 상태 게이지에 따라서 표정 변화 표현
			int showcnt=0;						 // 캐릭터의 오른쪽에 데이터를 표현하기 위해서 이모티콘 옆에 데이터 적음.
			if(happy>60 ) {					
				if(hungry>=90) {   //행복 60초과 && 포만감 90 이상 표정
					System.out.println("    │   ε       ε   │   " +" lv."+ level +""+levelSee[level-1]);
					System.out.println("    │   )   ε   (   │     " +" 이름  : "+ Dama_name);
					System.out.print("    └───────────────┘     " +" EXP :");
					while(exp/5!=showcnt) {
						System.out.print("■");							//  데이터를 보기 쉽게 게이지로 나타냄
						showcnt+=1;
					}
					System.out.println(" "+exp+"");						// 게이지 뒤에 정확한 수치를 나타냄 
																		// ex) 경험치 : ■■■■■■■■ 80
				}
				else if(hungry>60 && hungry<90) {  //행복 60초과  && 60<포만감<90  표정
									
					System.out.println("    │   Λ        Λ  │ ♪   " +" lv."+ level +""+levelSee[level-1]);
					System.out.println(" ♪  │       ▼       │     " +" 이름  : "+ Dama_name);
					System.out.print("    └───────────────┘     " +" EXP :");
									
				    while(exp/5!=showcnt) {
						System.out.print("■");							//  데이터를 보기 쉽게 게이지로 나타냄						
						showcnt+=1;
					}
					System.out.println(" "+exp+"");						// 게이지 뒤에 정확한 수치를 나타냄  
																		// ex) 경험치 : ■■■■■■■■ 80					
				}
				else if(hungry<30) {	   //행복 60초과  && 포만감 30미만  표정
					System.out.println("   │  @       @    │ ;   " +" lv."+ level +""+levelSee[level-1]);
					System.out.println("   │       ㅁ             │     " +" 이름  : "+ Dama_name);
					System.out.print("   └───────────────┘     " +" EXP :");
					while(exp/5!=showcnt) {
						System.out.print("■");							//  데이터를 보기 쉽게 게이지로 나타냄							
						showcnt+=1;
					}
					System.out.println(" "+exp+"");						// 게이지 뒤에 정확한 수치를 나타냄
																		// ex) 경험치 : ■■■■■■■■ 80	
				}
				else {				//행복 60초과  && 30<=포만감<=60   표정
					System.out.println("    │   Λ        Λ  │ ♪   " +" lv."+ level +""+levelSee[level-1]);
					System.out.println("    │       ㅡ             │     " +" 이름  : "+ Dama_name);
					System.out.print("    └───────────────┘     " +" EXP :");
					while(exp/5!=showcnt) {
						System.out.print("■");							//  데이터를 보기 쉽게 게이지로 나타냄						
						showcnt+=1;
					}
					System.out.println(" "+exp+"");						// 게이지 뒤에 정확한 수치를 나타냄 
																		// ex) 경험치 : ■■■■■■■■ 80	
				}
			}	
			else if(happy>30){
				if(hungry>=90) {    //30<행복<=60 && 포만감 90이상 표정
					System.out.println("    │   ε       ε   │   " +" lv."+ level +""+levelSee[level-1]);
					System.out.println("    │   )   ε   (   │     " +" 이름  : "+ Dama_name);
					System.out.print("    └───────────────┘     " +" EXP :");
					while(exp/5!=showcnt) {
						System.out.print("■");							//  데이터를 보기 쉽게 게이지로 나타냄							
						showcnt+=1;
					}
					System.out.println(" "+exp+"");						// 게이지 뒤에 정확한 수치를 나타냄 
																		// ex) 경험치 : ■■■■■■■■ 80	
				}
				else if(hungry<30) {      //30<행복<=60 && 포만감 30미만 표정
					System.out.println("    │  @         @  │ ;   " +" lv."+ level +""+levelSee[level-1]);
					System.out.println("    │       0       │     " +" 이름  : "+ Dama_name);
					System.out.print("    └───────────────┘     " +" EXP :");
					while(exp/5!=showcnt) {
						System.out.print("■");							//  데이터를 보기 쉽게 게이지로 나타냄						
						showcnt+=1;
					}
					System.out.println(" "+exp+"");						// 게이지 뒤에 정확한 수치를 나타냄 
																		// ex) 경험치 : ■■■■■■■■ 80	
				}
				else {			//30<행복<=60 && 30<=포만감<90 표정
					System.out.println("    │   Λ        Λ  │ ♪   " +" lv."+ level +""+levelSee[level-1]);
					System.out.println("    │       ㅡ             │     " +" 이름  : "+ Dama_name);
					System.out.print("    └───────────────┘     " +" EXP :");
					while(exp/5!=showcnt) {
						System.out.print("■");							//  데이터를 보기 쉽게 게이지로 나타냄
						showcnt+=1;
					}
					System.out.println(" "+exp+"");						// 게이지 뒤에 정확한 수치를 나타냄 
																		// ex) 경험치 : ■■■■■■■■ 80	
				}
			}
			
			else if(happy<=30){  //  행복 30이하일때 표정        배가 고프던 배가 부르던 전부 다 우울한 표정
					System.out.println("    │   ㅠ             ㅠ     │"    +" lv."+ level +""+levelSee[level-1]);
					System.out.println("    │   u   -   u   │     " +" 이름  : "+ Dama_name);
					System.out.print("    └───────────────┘     " +" EXP :");
					while(exp/5!=showcnt) {
						System.out.print("■");							//  데이터를 보기 쉽게 게이지로 나타냄
						showcnt+=1;
					}
					System.out.println(" "+exp+"");						// 게이지 뒤에 정확한 수치를 나타냄 
																		// ex) 경험치 : ■■■■■■■■ 80	
			}
			
			
		}
		
		public void Start() {				// 다마고치를 시작할 때 sleep을 사용하여 로딩부분을 만듬 
		
			System.out.println(" [java] 10조_쉽조의 다마고치");
			System.out.println("                                                                      2017학생ver ");
			System.out.println(" 우리 다마고치 잘 부탁드립니다");
			System.out.println(" 소중하게 잘 키워주세요");
			System.out.println("=========================================================");
			System.out.println(" ");
			System.out.print("  다마고치 로딩중 ");
			for(int road=0;road<4;road++) {      // for문 안에 sleep을 넣어 ...을 1초 시간씩 텀을 두어 4번 반복출력
				System.out.print(" .");
				 try {Thread.sleep(1000); } catch (InterruptedException e){ }; //thread.sleep으로 1초의 멈춤을 주었다. 1000 == 1초 
			}
			System.out.print("\n\n				            다마고치를 시작합니다."
								+"\n\n========================================================="
								+ "\n\n 			            다마고치 비밀번호를 설정해주세요.\n\n 비밀번호 입력 : ");	
		
				pass=scan.next();  // pass(비밀번호)는 프로그램을  종료할 때 비밀번호로 보안을 하기 위해 사용.
				
				while(true) {   // passcheck(비밀번호 확인)읉 통해 pass와 일치한다면 while문을 빠져나온다.
					System.out.print("				    다시 한번 입력해주세요.\n\n 비밀번호 확인 : ");
					passcheck=scan.next();
					if(pass.equals(passcheck)) break;
				else {
					System.out.println("				    비밀번호가 일치하지 않습니다. ");
					continue;
				}
			}
			System.out.println("\n=========================================================\n");
		}
		
		
		public void identify() {    // 캐릭터를 선택과 기본적인 인적사항을 적는 메서드
		
			damaimg1();				//damaimg1 메서드는 다마고치의 캐릭터 표현 
			damaimg2();				//damaimg2 메서드는 다마고치의 캐릭터 표현 
			
			while(true) {
				System.out.print(" 캐릭터 선택 : ");
				chaselect = scan.nextInt();   //chaselect는 캐릭터 선택 입력 값 넣음 
				
				switch(chaselect){		//chaselect가 1 or 2 에 따른 선택값 변환
				case 1 : System.out.println("\n 1번(남자) 캐릭터를 선택하였습니다."); damaimg1(); break;
				case 2 : System.out.println("\n 2번(여자) 캐릭터를 선택하였습니다."); damaimg2(); break;
				default : System.out.print("다시 입력 하시오.");break;  
				}
				
				if(chaselect==1 || chaselect==2) break;  // chaselect 1 or 2  값을 입력하였을 경우 while을 빠져나온다.
			
				else continue;    // chaselect 1,2 이 외의 값을 입력하였을 경우 while의 첫번째로 올라간다.
					
			}
				
			
			System.out.print("\n다마고찌의 이름 : ");
			Dama_name=scan.next();								//다마고치이름 입력 
			System.out.println();
			System.out.print(Dama_name+"의 주인(player)의 이름 : ");
			player=scan.next();									// 다마고치를 키우는 주인이름 입력
						
		}
				
		
		public void chadata() {		// (먹기, 놀기 , 공부하기)행동에 따라 다마고치의 데이터 표현 
 		

			
 			if(happy>100)
 				happy=100;  // 행복도 수치 최대 100 으로 설정
 			else if(happy<0) 
				happy=0;	  //행복도 수치 최소 0으로 설정
			

 			
 			if(happy<20) {  // 행복이 20 미만이 될때마다 happycnt++, 그리고 switch로 암시를 주는 문구를 넣고 happycnt==4가 되면 
 				happycnt+=1;// 게임 오버시킨다.
 				switch(happycnt) {
					case 1 : System.out.println(" 우울해.. 놀고 싶어!"); break;
					case 2 : System.out.println("우울해......"); hungry+=40; break;
					case 3 : System.out.println("................"); hungry+=40; break;
					default: System.out.println(Dama_name+"가 사망하였습니다..."); 
							System.out.println("  ,ad8888ba,         db         88           88  8888888");
							System.out.println(" d8'     ` 8b       d88b        888         888  88     ");
							System.out.println("d8'                d8'`8b       88`8       8'88  88     ");
							System.out.println("88                d8'  `8b      88 `8     8' 88  88aaaaa");
							System.out.println("88      88888    d8YaaaaY8b     88  `8   8'  88  88aaaaa");
							System.out.println("Y8,        88   d8''''''''8b    88   `8 8'   88  88     ");
							System.out.println(" Y8a.    .a88  d8'        `8b   88    `8'    88  88     ");
							System.out.println("  `'Y88888P'  d8'          `8b  88           88  8888888");
							System.out.println();
							System.out.println("  ,ad8888ba,  8b           d8  88888888888  88888888ba ");
							System.out.println(" d8''    ''8b `8b         d8'  88           88      '8b ");
							System.out.println("d8'        `8b `8b       d8'   88           88      ,8P	");
							System.out.println("88          88  `8b     d8'    88aaaaa      88aaaaaa8P'	");
							System.out.println("88          88   `8b   d8'     88'''''      88''''88'  	");
							System.out.println("Y8,        ,8P    `8b d8'      88           88    `8b  	");
							System.out.println(" Y8a.    .a8P      `888'       88           88     `8b 	");
							System.out.println("  `'Y8888Y''        `8'        88888888888  88      `8b	");
							System.exit(0); break; // 게임오버로 System.exit();를 사용 ()안에는 0 이외에도 사용이 가능하나
												   // 보통 0을 많이 사용한다.
				}
 			}
 			if(hungry>100) // 포만감 수치 최대 100으로 설정
 				hungry=100;
 			if( hungry<=0) // 포만감 수치 최소 0으로 설정
				 hungry=0;
 			
 			switch(hungrymaxcnt) {  // 포만감이 100을 초과하는 경우를 카운트하여 횟수에 따라 출력 3번째때 사망  
 				case 1 :System.out.println(" 배가 너무 부르다...");break;
 				case 2 :System.out.println(" 배불러 죽을것 같아..이제 더는 못먹겠어....");break;
 				case 3: System.out.println(Dama_name+"가 사망하였습니다..."); 
				System.out.println("  ,ad8888ba,         db         88           88  8888888");
				System.out.println(" d8'     ` 8b       d88b        888         888  88     ");
				System.out.println("d8'                d8'`8b       88`8       8'88  88     ");
				System.out.println("88                d8'  `8b      88 `8     8' 88  88aaaaa");
				System.out.println("88      88888    d8YaaaaY8b     88  `8   8'  88  88aaaaa");
				System.out.println("Y8,        88   d8''''''''8b    88   `8 8'   88  88     ");
				System.out.println(" Y8a.    .a88  d8'        `8b   88    `8'    88  88     ");
				System.out.println("  `'Y88888P'  d8'          `8b  88           88  8888888");
				System.out.println();
				System.out.println("  ,ad8888ba,  8b           d8  88888888888  88888888ba ");
				System.out.println(" d8''    ''8b `8b         d8'  88           88      '8b ");
				System.out.println("d8'        `8b `8b       d8'   88           88      ,8P	");
				System.out.println("88          88  `8b     d8'    88aaaaa      88aaaaaa8P'	");
				System.out.println("88          88   `8b   d8'     88'''''      88''''88'  	");
				System.out.println("Y8,        ,8P    `8b d8'      88           88    `8b  	");
				System.out.println(" Y8a.    .a8P      `888'       88           88     `8b 	");
				System.out.println("  `'Y8888Y''        `8'        88888888888  88      `8b	");
				System.exit(0); break; // 게임오버로 System.exit();를 사용 ()안에는 0 이외에도 사용이 가능하나
									   // 보통 0을 많이 사용한다
 			}
 			
 			
 			if(hungry<20) {		// 배고픔 20미만 
 				happy=(20-hungry)/2;   //(20-포만감)/2 수치만큼 행복을 (-) 시킨다.
 				if(hungry<=0) {
 					hungrycnt++;     // 포만감이 0의 경우가 생길때 마다 hungrycnt를 카운트한다. (리셋 없음)
 					switch(hungrycnt) {  //switch로 0이 될때마다 표현한다.
 					case 1 : System.out.println(" 어머니가 밥은 먹고 다니랬는데... ");
 							System.out.println(Dama_name+"가 너무 배가 고파 군것질을 했습니다. \n 돈  -5000원/"
 									+ "  포만감 +25 /  경고 (1회)");
 							money-=5000;
 							hungry+=25;break;
 					case 2 : System.out.println(" 어머니가 도시락을 주셨다. 이번이 마지막이야..ㅠ  \n" + 
 							"  포만감 +25 /  경고 (2회) %마지막% ");
 							hungry+=40; break;
 					default : 
 					System.out.println(Dama_name+"가 사망하였습니다..."); 	
 					System.out.println("  ,ad8888ba,         db         88           88  8888888");
 					System.out.println(" d8'     ` 8b       d88b        888         888  88     ");
 					System.out.println("d8'                d8'`8b       88`8       8'88  88     ");
 					System.out.println("88                d8'  `8b      88 `8     8' 88  88aaaaa");
 					System.out.println("88      88888    d8YaaaaY8b     88  `8   8'  88  88aaaaa");
 					System.out.println("Y8,        88   d8''''''''8b    88   `8 8'   88  88     ");
 					System.out.println(" Y8a.    .a88  d8'        `8b   88    `8'    88  88     ");
 					System.out.println("  `'Y88888P'  d8'          `8b  88           88  8888888");
 					System.out.println();
 					System.out.println("  ,ad8888ba,  8b           d8  88888888888  88888888ba ");
 					System.out.println(" d8''    ''8b `8b         d8'  88           88      '8b ");
 					System.out.println("d8'        `8b `8b       d8'   88           88      ,8P	");
 					System.out.println("88          88  `8b     d8'    88aaaaa      88aaaaaa8P'	");
 					System.out.println("88          88   `8b   d8'     88'''''      88''''88'  	");
 					System.out.println("Y8,        ,8P    `8b d8'      88           88    `8b  	");
 					System.out.println(" Y8a.    .a8P      `888'       88           88     `8b 	");
 					System.out.println("  `'Y8888Y''        `8'        88888888888  88      `8b	");	
 					System.exit(0); break;  // 게임오버로 System.exit(0);를 사용
 					
 					}
 				}	
 			}
 			if( exp>=100) { 	// 경험치 수치 최대 100으로 설정
 				level+=1;	 		// 경험치 최대치 도달 시 레벨 증가
 				bank += 30;
				exp=0;				// 레벨 증가 후 경험치 초기화
 			}
 			else if( exp<0) exp=0; //경험치가 떨어진 경우 최소를 0으로 
 						
 			switch(chaselect){ 	// chaselect는 초기 캐릭터 선택시 1번 남자 , 2번 여자 선택한 변수
 													// switch로 캐릭터와 변화된 수치 출력 
			case 1 :  damaimghead1_1();damafeel();damaimgbody1_1(); break;			
			case 2 :  damaimghead2_1();damafeel();damaimgbody2_1(); break;		

 			}
			
		}
		
		public void vocabulary_study1() { 	//영어 단어 맞추기 공부 레벨에 따라 난이도 조절 
			hungrymaxcnt=0; 								//밥먹기 이외의 행동을 하면 hungrymaxcnt 초기화
			String word[][]=									//레벨에 따라 문제 난이도를 구분하였다. 
		//word[0]~word[9] 레벨 1  //word[10]~word[19] 레벨 2  // word[20]~word[29] 레벨 3  // word[30]~word[39] 레벨 4
		/*레벨 1 문제*/	{{"놀다","play"},{"자다","sleep"},{"연필","pencle"},         
						{"책","book"},{"사진","picture"},{"과자","snack"},
						{"(동물)말","horse"},{"야구","baseball"},{"피아노","piano"},{"숫자","number"},
		
						
		/*레벨 2 문제*/	{"시작하다","begin"},{"결혼하다","merry"},{"아파트","apartment"},
		{"유명한","famous"},{"반복하다","repeat"},{"~를 통하여","through"},
		{"기억하다","remember"},{"멍청한","stupid"},{"채소","vegetable"},{"내던지다","throw"},
		
		
		/*레벨 3 문제*/ 	{"환경","environment"}, {"놀이동산","amusementpark"},
		{"제안","suggestion"},{"기회","opportunity"},{"독특한, 두더러진","distinctive"},
		{"합리적인","reasonable"},{"업적","accomplishment"},{"부정확한","inaccurate"},{"지도력","leadership"},
		{"교통","transportation"},
		
		
		/*레벨 4 문제 */	{"인출하다","withdraw"},{"급료","paycheck"},{"무료의","complimentary"},
		{"혼란한, 오리무중의","clueless"},{"결합","conjunction"},{"시연회","demonstration"},
		{"임시의","tentative"},{"신뢰성","credibility"},{"총회","conference"},{"규제","regulation"}};
			
			char hint[]=new char[20];  	// 영어단어 힌트 주기 위해 영어 단어를 한 철자식 hint배열에 넣음.	
			int  hintran[]=new int[20]; 	// hintran[]에 해당영어단어의 길이를 최대로한 hint random.
			int random=0; 							// random은 exam[]에 랜덤으로 담은 랜덤값을 넣음
			int	wcnt=0;								// wcnt는 answer의 알파벳[word]를 하나씩뽑을 때 사용
			int x=0;											// x는 틀릴때마다 카운트하는 변수 
			int hcnt=0;									// hint[]에 알파벳 넣을때 쓰는 변수
			int hintselect;								// hintselect 힌트를 추가로 더 받을지 선택하는 변수
			int hintrandom=0; 					// hintrandom 힌트에 대한 랜덤값 추출을 위해 사용 
			int examcnt=0;							// examcnt 문제 3개 출력할때 사용
			int score=0;									// scroe은 맞춘 갯수
			int exam[] =new int[3] ;  		//exam[]에 문제 번호 3개 추출하여 넣음
			int	 judgecnt=0;  						// 옳은지 틀렸는지 확인하기 위해 카운트하는 변수 
			String dap="", answer="";  	// dap은 답을 입력  , answer은 정답을 넣어두는 변수 
			boolean judge=true;  				// judgecnt와 함께 쓰이는 변수 
			System.out.println("\n========================================================\n");
			System.out.println("	    (vocabulary) 영단어 공부 \n ");
			System.out.println(" 	        -3문제 진행- ");
			System.out.println("\n========================================================\n\n");
			
		
		while(true) {
			
			exam[examcnt]=(int)(Math.random()*(10)+((level-1)*10));     // 레벨 1: 0~9  /  레벨 2 :10~19 /  레벨3:20~29 / 레벨4: 30~39중에서 랜덤값 출력
			
			judgecnt=0;   // 문제가 출력된 후 값을 0으로 만들어준다.
			while(examcnt>judgecnt) {	// 문제를 3개 추출하는데 랜덤값이 중복이 있는지 없는지 확인 
				
				if(exam[examcnt]==exam[judgecnt]) {
					judge=false;  // 랜덤값이 중복이 된다면 false 입력 
				}
				judgecnt++;
			}
			
			if(judge==false) {  				//judge에 false가 입력되있다면 judge=true로 입력, while의 처음으로 다시 올라간다.
				judge=true;     
				continue;
			}
				examcnt++; 						// 틀린 것이 없다면 문제 카운트를 올려준다.
				
			if(examcnt==3) break; 	 	// 중복되지 않은 문제를 3개 출력하고나면 while을 빠져나온다.
		}
		
			examcnt=0;  							// 문제를 첫번째부터 다시 출력 하기 때문에 examcnt를 다시 0으로 만들어준다.
		while(examcnt<3) {				 	//3문제 출력후에 while을 빠져나옴
			System.out.println("\n========================================================");
			System.out.println(" "+(examcnt+1)+" 번 문제  ===============================================");
			System.out.println("========================================================\n");					
			random=exam[examcnt]; 						// random변수에 랜덤으로 추출한 문제번호를 담은 exam[examcnt]를 넣어준다.
			answer=word[random][1];				 	// answer변수에는 정답을 입력한다.
			hcnt=0; 														// hint[]에 알파벳 넣을때 쓰는 변수
			
			while(hcnt<answer.length()) {   		// hint[]배열에 정답의 알파벳을 하나씩 순서대로 입력한다. - 나중에 힌트를 줄때 사용
				hint[hcnt]=answer.charAt(hcnt);  	// chaAt(); 은 알파벳을 하나씩 뽑기위해 사용 (0)이 들어가면 첫번째 알파벳 ~
				hcnt++;
			}
			
			while(true) {    
				
				System.out.println(word[random][0]+" 뜻의 영어단어는 ??\n");
				wcnt=0;  													// wcnt변수는 answer의 문자(word)를 하나씩 알파벳이나 '_'로 표현하기 위해 사용
				 while(wcnt<answer.length() ) {	// while로 문제 길이만큼 반복
					 										
					 if(wcnt<x) {			// x(틀린 횟수) - 1번 틀리면 정답의 첫번째 알파벳까지 보여주고 2번 틀리면 두번째 알파벳까지 보여준다...
						System.out.print(" "+answer.charAt(wcnt)+" "); 
					 }
					 
					 else {					// 나머지 부분은 _로 표현된다.
					 System.out.print(" _ ");
					 }
					
					wcnt+=1;
				 }	 
				 System.out.println(" " + answer.length()+"글자\n"); // 알파벳이 전체 몇글자인지 표현해줌
				 System.out.print(" 답 :  ");
				 dap=(scan.next());				//답 입력 
				
				
				 
				 if(dap.equals(answer)) {				// 정답일 경우 표현   String String 비교는 .equals()를 사용 
					 System.out.println("	 		정답 : [ "+answer+" ]");
					 System.out.println("				정답입니다.!");
					 score++;											//맞춘만큼 갯수 증가
					 break;
				 }
				 	 
				 
				 else {
					 System.out.println(" 				      틀렸습니다.\n\n========================================================\n");
					
					 x+=1;  // 틀렸을 경우 x++; 
					 
					 if(x==level+2) { // 레벨에 따라 단어의 길이 차이가 있어 레벨이 낮을때에는 알바벳 힌트를 주는 횟수를 적게 했음.
						
						 	System.out.print( " 1.알파벳 조합 힌트 사용   2.정답 보 기       선택 : 	" ); 
						 	hintselect=scan.nextInt();
						 	
						 	
						 	if(hintselect==1) {  // 조합 힌트 사용
						 		System.out.println("\n\n  		       알파벳 조합 힌트를 선택하였습니다.\n\n");  //
						 		System.out.println(word[random][0]+" 뜻의 단어는 ??\n");  // 문제를 다시 보여줌 
						 		
						 		hcnt=0;
						 		while(hcnt<answer.length()){  	// 위에서 힌트를 알파벳힌트를 보여준 부분 까지는 보여주게함
						 			if(hcnt<x-1) { 								//x-1을 한 이유는 마지막에 틀린 후에 x가 한번더 (+)가 됬음 그래서(-)넣어 힌트를 줬던부분을 동일하게 해줌 		
						 				System.out.print(" "+answer.charAt(hcnt)+" ");
						 			}
						 			else {
						 				System.out.print(" _ ");
						 			}		
						 			hcnt++;
						 		}
						 		System.out.println("\n");
						 		System.out.println(" 	    -힌트 :  아래의 알파벳을 골라 답을 입력하시오. \n");
						 		
						 		hcnt=0;   
						 		while(true) {
						 			
						 			hintrandom=(int)(Math.random()*(answer.length()-(level+1))+(level+1)); // hintrandom을 힌트주지 않은부분으로 랜덤 뽑음.
						 		
						 			hintran[hcnt]=hintrandom;  //hintran[]에 랜덤으로 받은 숫자를 넣음 
						 			
						 			int cnt=0;  
						 			
						 			while(cnt<hcnt ) {  					// 중복되는 랜덤값이 없도록 검사한다.
						 				if(hintran[hcnt]==hintran[cnt]) {
						 					judge=false;
						 				}
						 				cnt++;
						 			}
						 			
						 			
						 			if(judge==false) {
						 				judge=true;
						 				continue;
						 			}
						 			
						 			hcnt++;
						 			System.out.print( " "+hint[hintrandom]+ " /");
						 		
						 			if((hcnt+level+1)==answer.length()){	// 힌트는 틀릴때마다 알파벳을 하나씩 공개하는 부분의 최대힌트수 (level+1) 
						 																						// 그 이후 알파벳 조합힌트에서의  제공되는 힌트 수가  hcnt 
						 																						// 두 부분의 합이 정답의 길이와 같으면 break로 빠져나온다. 
						 				break;
						 			}
						 					
						 		}
						 		
						 		System.out.print("\n\n 답 : ");
						 		dap=scan.next();					// 답 입력 
						 		 System.out.println("	 		정답 : [ "+word[random][1]+" ]");
						 		 if(dap.equals(answer)) {   // 정답일 경우  출력
						 			 
									 
									 System.out.println("				정답입니다.!");
									 score++;
									 break;
						 		 }
						 		 
						 		 else {										 //정답이 아닐 경유  출력
							 		System.out.println(" 			     아쉽네요ㅠ 틀렸습니다.  ");
							 		break;
							 	}
						 		 
						 	} 
						 	
						 	if(hintselect==2) { 			 // 1번 알파벳 조합 힌트를 사용하지 않았을 경우  출력 
						 		System.out.println("\n\n  		  	  정답보기를 선택하였습니다.\n");
						 		System.out.println("	 		정답 : [ "+word[random][1]+" ]");
						 		System.out.println("");
						 		System.out.println("===========================================================\n");
						 		break;
						 	}
								
						 } 	 
					 }				 
				 }
				 wcnt=0; x=0; hcnt=0; 
				
				examcnt++;						//문제 카운트 올려줌
			} 												//while문 빠져나옴
			
			System.out.println("===========================================================\n");
			System.out.println("		 	  맞힌 갯수 : " +score);
			if(score==2  || score==3) {
				System.out.println("						참 잘했습니다~!!");
			}
			System.out.println("\n===========================================================\n");
			System.out.println();
			System.out.println("===========================================================");
			System.out.println("                  	공부 끝!!   ");
			System.out.println("===========================================================\n");
			
			
			//수치 변화에 대한 정보
			happy-=3;
			System.out.print("\n 행복 -3 / ");
	
			hungry-=5;
			System.out.print(" 포만감 -5 / ");
			
			exp+=10+score;
			System.out.print(" 경험치  +10 + 보너스(+"+score+")\n\n"); // 맞춘 갯수에 따른 보너스 점수 추가 
						
		}
	
			
		
		public void piece_play3(){			// 같은 단어 맞추기 게임 
			hungrymaxcnt=0;
			Scanner scan= new Scanner(System.in);  
			
			String squareMenu[] = {"사과","배","자두","복숭아","포도","파인애플","블루베리","당근"};  // 단어를 넣어놓은 배열 
			
			int randomNum[]= new int[16];  														// 1~16까지 랜덤으로 숫자를 넣을 배열 
			String squareBox[] = new String[16];  												// 랜덤으로 단어를 넣을 배열 - play할때 처음에 보여지는 배열이다. 
			
			String squareBlind[] = {" ( 1 ) "," ( 2 ) "," ( 3 ) "," ( 4 ) ",				// 문제를 풀때 보여지는 배열 
									" ( 5 ) "," ( 6 ) "," ( 7 ) "," ( 8 ) ",										// 맞출때마다 그 자리는 단어로 다시 채워진다 .
									" ( 9 ) "," ( 10) "," ( 11) "," ( 12) ",
									" ( 13) "," ( 14) "," ( 15) "," ( 16) "};
			int boxCnt=0;	         			//  박스에 관련되어 사용될 때 
			int menuCnt=0; 				//  배열에 menu를 넣을 때 사용
			int judgeCnt=0;		  			//  중복되는 것이 있는지 판단할때 사용되는 카운트 변수 
			int menuleng=0;			  	//  배열을 나열하여 나타낼 때 칸을 맞추기 위함
			boolean judge=true;      //  중복되는 것이 있는지 판단할때 사용
			int dap1,dap2;					//  dap1 , dap2 은 답 적는 변수
			int select;								// select 선택할 때 사용
			int hint;								// hint에 사용
			int hintcnt=5;						// hintcnt는 힌트 제한 횟수
			int score=0;							// score는 점수
			int endcnt=20; 					// 문제 답 입력 가능 횟수 
			String pause="";  				// 게임을 시작전 시작할 준비가 되었는지 확인하기 위한 변수
			String dapfruit="";			// 답입력 
			
			
			
			System.out.println("========================================================\n");
			System.out.println("	    	( brain ) 두뇌 발달  \n ");
			System.out.println(" 	    	  - 같은 단어 찾기 - "
					+ "\n		-힌트: 총 (5회), 사용시 정답 입력기회도 줄어든다.   ");
			System.out.println("\n========================================================\n");

			System.out.println("\n========================================================");
			System.out.println(" "+(int)(40/level)+ " 초 뒤 카드 뒤집음 ======================================="); // 레벨에 따라 문제를 볼 수 있는 시간이 짧다.
			System.out.println("========================================================\n\n");
			
			
			
			while(true){		// 랜덤 숫자를 16번 돌려서 randomNum[]에 집어 넣는다.
				
				randomNum[boxCnt]=(int)(Math.random()*squareBox.length); // 배열의 길이 만큼 랜덤을 뽑는다.
				judgeCnt=0;		// 중복을 확인하기 위해 사용하는 카운트 
				
				
				while(judgeCnt<boxCnt) { // 반복중 중복이 나온다면 judge=false한다.
			
					if(randomNum[judgeCnt]==randomNum[boxCnt]) 	judge=false; 	
						
					judgeCnt+=1;
				}
					
				if(judge==false) {  // judge=false라면 true로 다시 입력 후 while을 처음으로 올라간다.
					judge=true;
					continue;
				}
				
				squareBox[randomNum[boxCnt]] = squareMenu[menuCnt] ; // 랜덤인 배열에 중복이 없을 경우  squermenu[]의 메뉴들을 순서대로 입력해준다.
																	 // menucnt는 0부터 시작하여 menu들을 사과, 배 , 자두 .. 순서대로 입력시킨다.
				boxCnt+=1;
				if(boxCnt==16) break; // 다 입력 되면 break로 빠져나온다.
				if(boxCnt%2==0 && boxCnt>0) {menuCnt+=1; }  // 두개씩 입력하고 menucnt++하여 다음 메뉴를 입력한다.
				
				
			}
			
			
			boxCnt=0;
			
			while(boxCnt<=15) {  						//  출력화면내에 나타나는 모양을 일정하게 하기 위함
				menuleng=(int)(squareBox[boxCnt].length());     
				System.out.print(" ||   "+squareBox[boxCnt]+"  " );   // 단어의 길이가 가장 긴것이 4글자이므로 4글자를 기준으로 
				
				if(menuleng<4) {								      //모양을 일정하게 잡았다.
					
					while(true) {
						System.out.print("   ");
						
						menuleng+=1;
						
						if(menuleng==4) break;			// 모양을 잡고 다음 단어로 넘언간다 .
					}
					
				}		
				
				boxCnt+=1;
				if(boxCnt%4==0) {					// 단어를 4개를 하고 나면  \n\n\n으로 줄을 띄워준다.
					System.out.println(" || \n\n\n");
				}
			}
			System.out.println((20/level)+" 초 후에 카드를 뒷면으로 뒤집습니다. 그 사이 단어를 확인해주세요.\n"); // 레벨에 따른 문제 시간 초 다르게 하였음
			
			for(int examtime=20/level;examtime>0; examtime--) {	   // 문제를 암기할 수 있는 시간 표시        
				System.out.print(" "+(examtime-1));  
				try {Thread.sleep(1000); } catch (InterruptedException e){ }; //thread.sleep으로 1초의 멈춤을 주었다. 1000 == 1초 
				if(examtime%21==0) { System.out.println(); } // 한줄로 길게 나열되는 것을 막기 위하여 사용.
			}
										
			
			System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"		// for문을  실행하고 나면 실행 
						+ "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n " 
						+ "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n "
						+ "\n  시작하겠습니까??\n"
						+ "  시작하고자한다면   \'아무 문자\'를 친 후  enter키를 눌러주세요.\n  입력 : ");
			pause = scan.next(); //게임을 시작전 시작할 준비가 되었는지 확인하기 위해 사용		
			
			while(true) { 	   		// Sqareblind[] 순서대로  출력해준다 .
				
				boxCnt=0;
				System.out.println(
						"========================================================\n"
						+ "같은 단어의\'번호\'와 \'과일\'을 적으시오 ==============================\n"
						+"========================================================\n\n"
						+ "ex) 번호 입력1 : 숫자    |  " 
						+ "번호 입력 2 : 숫자   |  "
						+ "과일 이름  : 과일   \n\n");
				while(boxCnt<=15) {						  // 1번 블라인드 박스부터 순서대로 출력 
					
					System.out.print(" ||  ");						
					menuleng=(squareBlind[boxCnt]).length();
					
					if(menuleng<=3) {						// 단어 마다 길이가 다름을 보완하여서 반복을 사용해 길이를 일정하게 만들어 틀 모양이 반듯하게 나오도록 했다.
												
						while(true) {						
							System.out.print(" ");			
							menuleng+=1;					
							if(menuleng==4) break;			
						}
					}	
					
					System.out.print(squareBlind[boxCnt]);
					
					menuleng=(squareBlind[boxCnt]).length();
					if(menuleng<=3) {
						
						while(true) {
							System.out.print(" ");
							menuleng+=1;
							if(menuleng==4) break;
						}
					}		
					
					boxCnt+=1;
					if(boxCnt%4==0) {
						System.out.println("  || \n\n\n");
					}
				}
				System.out.println("========================================================");
				System.out.println("  1번. 정답 입력하기   / 2번. 힌트 얻기 ("+hintcnt+"회 ) / 3번. 그만하기 \n");	// 정답 입력 양식 
				System.out.print(" 선택  : ");
				select=scan.nextInt();
				System.out.println();
				
				
				
				if(select==1) {					// 정답 입력 부분 
					System.out.println(" \'1번. 정답 입력하기\'를 선택하였습니다.\n");
					System.out.print(" 번호 입력1 : ");
					dap1=scan.nextInt();
					System.out.println();
					System.out.print(" 번호 입력2 : ");
					dap2=scan.nextInt();
					System.out.println();
					System.out.print(" 과일 이름    : ");
					dapfruit=scan.next();
					System.out.println();	
					endcnt--;
					
					if(squareBox[dap1-1].equals(squareBox[dap2-1]) &&		// 정답과 답입력과 같은 지 확인 하여 정답일 경우 출력 
					    squareBox[dap1-1].equals(dapfruit))   {
						score++;										
						squareBlind[dap1-1]=dapfruit;
						squareBlind[dap2-1]=dapfruit;
						System.out.println("					정답입니다.!!!");
						System.out.println("	 				정답 : [ "+ squareBox[dap1-1]+" ]");
						System.out.println("					맞힌 갯수 : " +score+" 개");
						System.out.println("				         남은 횟수    : " + endcnt+" 회");
					}
					else {													// 정답이 아닌 경우 출력 
						System.out.println("				          땡!.. 틀렸습니다..!");
						System.out.println("					맞힌 갯수 : " +score+" 개");
						System.out.println("				          남은 횟수    : " + endcnt+" 회");
					}
				
				}
				else if(select==2) {			// 힌트얻기 부분 
					endcnt--;
					System.out.println(" \'2번. 힌트 얻기\'를 선택하였습니다.\n");
					if(hintcnt>0) {
						System.out.print(" 알고 싶은 번호를 입력  : ");	
						hint=scan.nextInt();
						System.out.println(
											"				       "
											+hint+"번 단어는  ["+squareBox[hint-1]+"]");
						hintcnt--;
						System.out.println("				               남은 힌트    : " + hintcnt+" 회");		// 힌트 사용시에도 남은 횟수가 같이 줄어든다.
						System.out.println("				               남은 횟수    : " + endcnt+" 회");
						
					}
					else System.out.println("힌트를 다 사용하였습니다. ");
				}
				
				if( endcnt==0 || score==8 || select==3 ) {
					System.out.println("					총 맞힌 갯수 : " +score+" 개");
					if(score>=7) {	
						System.out.println("아주 잘했습니다!~~");	
					}
					System.out.println("				               남은 횟수    : " + endcnt+" 회");
					System.out.println("				               남은 힌트    : " + hintcnt+" 회");
					System.out.println("\n");
				   
					break;
				}
				
			}	
			System.out.println("========================================================");
			System.out.println("                  	게임 끝!!   ");
			System.out.println("========================================================\n");
			onlyplaycnt++;
			
			happy+=5;
			System.out.print("\n  행복 +5 / ");			// 변화 상태 표시
			
			 hungry-=5;
			 System.out.print(" 포만감 -5 / ");			// 변화 상태 표시
			
			
			if(onlyplaycnt<3) {
				exp+=10;
			System.out.print(" 경험치  +10 \n\n");			// 변화 상태 표시
			}
			
			else if( onlyplaycnt>=3) {
				exp-=10;	
				System.out.println("놀기만 해서 경험치가 떯어졌습니다.-10");
				System.out.println(" "+Dama_name+" : 많이 놀았으니까 이젠 공부해야지..! ");
			}/*게임을 3번연속하면 경험치 수치 감소 */
		
	}
	
		
		
		
		
		
		
		
		
		
		public void math_study2() {  /*구구단 공부  레벨에 따른 난이도 올리기 */
			hungrymaxcnt=0;
			int randNumber1, randNumber2, input, answer,select,moncnt=0, score=0;
			
			int randNumber; 				// 진법 변환 할 숫자를  랜덤으로 뽑는 변수 
			String changeanswer="";			// 진법 변환    정답을 넣은  변수
			String changedap="";			// 진법 변환    답을 넣을 변수 
			String change[]=new String[8];
			int changecnt=7,changesel=0; 
			int length=0;
			
			System.out.println("========================================================\n");
			System.out.println("	    	( Math ) 수학 연산 연습  \n ");
			System.out.println("    		 - 구구단(활동) ,  진법 변환  - \n\n"
							 + "		      - 5문제  - ");
			System.out.println("\n========================================================\n\n");
			 
				System.out.println("            1번.  구구단(활동)    ");
				if(level>=2) {System.out.print("/  2번.  진법 변환  \n");}	
				
		while(true) {				
			System.out.print("    선택 : ");
			select=scan.nextInt();				// 구구단 문제 or 진법변호나 문제 선택함
			switch(select) {
			
			case 1: 							// 구구단 문제 
					System.out.println("========================================================");
					System.out.println("\n   	    LV."+level+"        난이도   :  "+(1)
										+"  단    ~  "+((level*5)-1)+"   단\n");						//레벨에 따라  난이도 조절 
					System.out.println("========================================================");
					while (true) {
						
						randNumber1 = (int)(Math.random()*((level*5)-1))+1;						//레벨에 따라  난이도 조절 
						randNumber2 = (int)(Math.random()*9)+1;
		
						System.out.println("\n  		 "+randNumber1 + "  x  " + randNumber2 + "  = ?? ");
						System.out.print(" 답 : ");
						input = scan.nextInt();				
						answer = randNumber1 * randNumber2;
		
						if (input == answer) {
							System.out.println("					정답입니다");
							System.out.println("					정답 : ["+answer+"]");
							score++;															// 정답일 경우 score++
						} 
						else {
							System.out.println("					틀렸습니다");
							System.out.println("					정답 : ["+answer+"]");	
						}
						System.out.println("\n========================================================");
						moncnt++;				
						if(moncnt==5) {															// 5문제 출력시 break
							break;
						}
					}
					break;
				
				
			case 2 :
					System.out.println("========================================================");
					System.out.println("\n 					진법 변환 \n");
					System.out.println("========================================================");
					while(true) {
						
						changecnt=7;					// 진법을 변환하기 위해 사용되는 카운트 (7에서 0까지 최대 8칸을 사용하여  변환된 진법숫자를  표시하기 위해  7로 설정 ) 
						changedap="";					// 진법 변환의 답 입력 변수 
						changeanswer="";				// 정답을 넣은 변수 
						
						randNumber=(int)(Math.random()*(16*(level+1)));							// 랜덤으로 뽑을 10진수의 숫자
						System.out.println();
						System.out.println( " 		       숫자  : "+randNumber);
						System.out.println("\n					 변환할 진법을 선택");					// 진법 변환 선택 
						System.out.println("  1번  (2진법 )  /  2번  (8진법 )   / 3번  (16진법)   \n");	// 보기
						System.out.print("   선택: ");
						changesel=scan.nextInt();
						
						
						switch(changesel) {
						case 1: changesel=2; length=0; ;break;		//  1번 2진법     length은 진법으로 변환할 때 몇자리로 나타낼지 결정하기 위한 변수 
																	//	ex ) length=0이면 (0~ 7까지 8자리)  ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ ㅡ  
						
						case 2: changesel=8; length=5; ;break;		//	2번 8진법   
																	//	ex ) length=5이면 (5~ 7까지 3자리)  ㅡ ㅡ ㅡ    
						
						case 3: changesel=16; length=6; ;break;		//	3번 16진법\
																	//	ex ) length=5이면 (6~ 7까지 2자리)  ㅡ ㅡ
						}
						System.out.print("\n\n    "+ changesel+" 진법    :   ");
						
						while(changecnt>=length) {					// 위의 case에 따라 length가 정해지고 반복횟수 결정 
						
							if((int)(randNumber/changesel)>=0) {
								
								switch((int)(randNumber%changesel)) {				// 16진법의 진법 변환을 위해 사용 숫자 15 =F 14=E 등...
								case 15:change[changecnt]="F" ; break;
								case 14:change[changecnt]="E" ; break;
								case 13:change[changecnt]="D" ; break;
								case 12:change[changecnt]="C" ; break;
								case 11:change[changecnt]="B" ; break;
								case 10:change[changecnt]="A" ; break;
								default:change[changecnt]=Integer.toString(randNumber%changesel);	// String 배열임으로 자료형 맞춰줌.
								}
								
							}
							randNumber=(int)(randNumber/changesel);
							
							changecnt--;
						}
						changecnt+=1;				// 위에서 changecnt-- 하면서 진법변환 한것을 change[changcnt]에 넣어준 후 
													// 다시 changecnt를 +1시켜준 후
						while(changecnt<=7) {		// while문에서   changecnt++ 하여  _  _ 로 표시 되도록 한다.
							System.out.print("  _  " );
							changeanswer+=change[changecnt];	// 반복을 돌리면서 진법을 변환한 chang[]배열에 문자를 하나씩 정답 변수에 넣어 합쳐준다.
							changecnt++;
						}
						System.out.print("\n\n  답 : ");
						changedap=scan.next();			
						if(changeanswer.equals(changedap)) {	// 정답과 비교 후 출력 
							System.out.println("					정답입니다~!");
							System.out.println("					정답 : ["+changeanswer+"]");
							score++;
						}
						else {
							System.out.println("					틀렸습니다ㅠㅠ");
							System.out.println("					정답 : ["+changeanswer+"]");
						}
						System.out.println("\n========================================================");
						moncnt++;
						if(moncnt==5) {							//문제가 5번 출력 되면 종료 
							break;
						}
					}
					
				
				System.out.println("\n					맞춘 갯수 : "+ score);		// 맞춘 갯수 확인 
				System.out.println("\n\n");
			    
				break;
				default :				// 문제 룰 선택시 1번과 2번 외에 선택할 경우 다시 입력을 받도록 한다.
					System.out.println(" 									다시 입력하세요.");
					continue;
			}
			break;
		}
		
			System.out.println("========================================================");
			System.out.println("                  	공부 끝!!   ");
			System.out.println("========================================================\n");
			onlyplaycnt=0;
			
			happy-=3;
			System.out.print("\n 행복 -3 / ");							// 변화 상태 표시
			
			 hungry-=5;
			 System.out.print(" 포만감 -5 / ");							// 변화 상태 표시
			
			
			exp+=10+score;
			System.out.print(" 경험치  +10 + 보너스(+"+score+")\n\n");		// 변화 상태 표시
			
		}
		
		public void lang_study3() { /*지문 읽고 답 찾기 문제 */
		    hungrymaxcnt=0;
		    					
		    int judgecnt,insmon; 					// judgecnt : 문제 중복 있는 지 없는지 판단하는 변수 ,
		    										// insmon: 중복이 없다면 instant뜻으로 잠시 즉석으로 문제 번호를 넣어 놓는 변수 
		     int moncnt=0, ocnt=0, recnt=0, xcnt=0 ;// moncnt는 문제 10개를 출력하기 위해서 사용하는 변수 
		     										//  ocnt: 맞는수 , recnt: 틀렸을때 기회 , xcnt: 틀린수
		     int mon[] = new int[10];    			// 중복되지 않게숫자를 받아서 여기 배열에다 집어넣고 확인한다.
		     boolean overlap=false;      			// overlap이 되지 않으면 false  되었으면 true 변환하여 중복을 판단 함
		     String input;      					// 답을 적는 변수    
		     String answer;   						// 정답을 넣어 놓는 변수              
		     String Exam[][]=new String[][]         // 문제를 넣어 놓은 변수        
		               {
		               {"'사방이 모두 적으로 고립되어 둘러싸인 상태'라는 뜻을 가진 사자성어는? " ,"사면초가"},
		               {" dama는 오늘 밥과 오리구이와 국수를 아침에 먹었다 \n 점심에는 식혜를 마시고 오므라이스를 먹었다 \n 저녁에는 돼지고기를 먹고 후식으로 아이스크림을 먹었다\n 본문에서 사용된 한자어를 찾아 쓰시오.  ","식혜"},
		               {" 병아리는 삐약삐약 \n 강아지는 멍멍  \n 개구리는 폴짝 \n 호랑이는 어흥 \n 본문에서 의태어를 찾아쓰시오","폴짝"},               
		               {" dama는 늦잠을 잤다. ( ? ) dama는 지각을 했다 \n 빈칸에 알맞는 접속어을 써주세요 \n 그리고 그래서 왜냐하면 만약" ,"그래서"},
		               {"'자기의 몸을 희생하여 옳은 도리를 행한다'라는 뜻을 가진 사자성어는? ","살신성인"},
		               {" [ㅅㅅ ㅂㄹ ㅇㄷㄲㅈ ㄱㄷ] 자음을 보고 속담을 맞춰보세요(띄어쓰기X)","세살버릇여든까지간다"},
		               {" 다음중 외래어가 아닌것은? \n 김밥 라디오 넥타이 오무라이스 ","김밥"},              
		               {" 어제가 내일이였으면 좋겠다. 그러면 오늘이 금요일일 텐데.. 여기서 오늘은 무슨 요일일까?","일요일"},
		               {" [ㄴㅁㅇ ㅅㄱ ㄷㄱ ㅂㅁㅇ ㅈㄱ ㄷㄴㄷ] 자음을 보고 속담을 맞춰보세요(띄어쓰기X)","낮말은새가듣고밤말은쥐가듣는다"},
		               {" [ㅈㅏㄹㅜㅁㅏㄷㅣ] 를 낱말로 만든다면 무엇이 될까요? /n [보기] 다람쥐, 도시 청출, 어람","다람쥐"},
		               {" [상Hx2] 글자를 재배치하여 하나의 단어를 만들어보세요","새해"},
		               {" '모든 일이 뜻대로 됨'이라는 뜻을 가진 사자성어는?","백사여의"},
		               {" [몸보다 ( ? )이 더 크다] 빈칸에 들어갈 말로 알맞은 말은?","배꼽"},
		               {" [( ? ) 도둑이 ( ? )도둑 된다] 빈칸에 들어갈 말을 차례대로 입력해주세요.(띄어쓰기X)","바늘,소"},
		               {" 나에게 둘을 더하면 최고가 되고, 하나를 빼면 몸이 십분의 일로 줄어들고, 모자를 잘못 쓰면 백배가 된다. 나는 누구일까? (띄어쓰기X) ","열십"},
		               {" '[1.어줍잖게, 2.어쭙잖게] 구걸이나 하는 녀석이 [3.어따대고, 4.얻다 대고] 큰소리야'라는 말에서 맞춤법이 맞는 번호를 입력주세요(띄어쓰기X)","24"},
		               {" '[1.엊그저께, 2.엊그저게] 나를 [3.마뜩잖게, 4.마뜩찮게] 생각했던 사람을 우연히 만났다'라는 말에서 맞춤법이 맞는 번호를 입력주세요(띄어쓰기X)","13"},
		               {" '그녀는 눈을 [1.지긋이, 2.지그시] 감고 말했다. 이 자리를 [3.빌려, 4.빌어] 감사드릴 분이 있습니다'라는 말에서 맞춤법이 맞는 번호를 입력주세요(띄어쓰기X)","23"}
		               };

		     
		     Scanner scan = new Scanner(System.in);
		     
		     System.out.println("");
		     
		     while(true) {                      
		        
		        mon[moncnt]=(int)(Math.random()*Exam.length ); /*여기 부분은 mon배열에 random값을 넣고 중복되는 것이 있는지 
		                                            			*배열들을 서로 비교한다. 그러다 같은 랜덤 값이 나온 배열들이 있다면 
		                                            			*overlap을 false로 바꾼다 . while 반복이 다 돌아가고 if에서
		                                            			*overlap이 false라면 overlap을 true다시 변경하고 continue로
		                                            			*while(true)구문의 가장 위로 가서 다시 배열에 랜덤 숫자를 받아 넣는다.
		                                            			*/ 
		        judgecnt=0;                                             
		        while(judgecnt<moncnt) {                                        
		           if(mon[judgecnt]==mon[moncnt]) {
		              overlap=true;    
		           }  
		           judgecnt++;
		        }
		        
		        if(overlap==true) {
		         overlap=false;
		         continue;
		        }
		        insmon=mon[moncnt];
		        answer=Exam[insmon][1];
		        System.out.println((moncnt+1)+"번 \n"+Exam[insmon][0]);
		        System.out.print("답: ");
		        moncnt++;
		        input=scan.next();   
		        												/*그래서 문제가 없다면 overlap이 false로 바뀌지 않아 통과하게 되고 
		        												 *insmon에는 중복되지 않은 문제 random번호를 넣고  
		        												 *answer에는 그 배열의 정답을 넣는다.
		        												 *그리고 문제를 출력하고 while부분에서 정답과 틀린부분을 체크한다. 
		        												 */
		           
		        while(true) {
		           if ( answer.equals(input) ) { 
		              System.out.println("");
		              System.out.println("정답입니다");
		              System.out.println("");
		              ocnt++;
		              break;
		           }
		           else {
		              if(recnt<4) {
		                 System.out.print("다시입력: ");
		                 input=scan.next();   
		                 recnt++;
		                 continue;
		              }
		              else {
		                 System.out.println("");
		                 System.out.println("틀렸습니다");
		                 System.out.println("");
		                 xcnt++;
		                 recnt=0;
		                 break;
		              }
		           } 
		        }
		        
		        System.out.println("정답:  \'"+ answer +" \' ");
		       
		        if(moncnt>=3)break;        // 여기는 문제가 10문제가 출력이 되면 나올수 있도록 break를 걸어두었다.
		     }
		     
		     System.out.println("총 맞는갯수: "+ocnt+" , 틀린갯수: "+xcnt);
		     


		     System.out.println("========================================================");
		    System.out.println("                     공부 끝!!   ");
		    System.out.println("========================================================\n");
		    onlyplaycnt=0;
		    
		    happy-=3;
		    System.out.print("\n  행복 -3 / ");
		    
		     hungry-=5;
		     System.out.print(" 포만감 -5 / ");
		       
		    exp+=10;
		    System.out.print(" 경험치  +10 \n\n");

		 }
		
		public void rockpapersc_play1(){   				 // 가위 바위보 게임   변수 이름 다수정 
			hungrymaxcnt=0;								 // 먹는 것 이외의 다른 행위를 할 경우 0으로 만들어준다.
			Scanner scan=new Scanner(System.in);		 // 입력값을 받기 위해 사용 
			int com=(int)(Math.random()*3)+1;			 // 가위바위보 3가지중 하나임으로 1~3사이 랜덤
			int user;									 // 유저의 선택 값을 넣을 변수 
			String com_text="";						     // 선택값을  묵 , 찌 , 빠 중 한개로 변환하여 넣는 변수
			String user_text="";						 // 선택값을  묵 , 찌 , 빠 중 한개로 변환하여 넣는 변수
			int cntuser=0;								 // 이길 때 카운트 
			int cntcom=0;								 // 이길 때 카운트
			
		
			System.out.println("========================================================\n");
			System.out.println("	      ( play ) 가위바위보 게임  \n ");
			System.out.println(" 	      	  -  3선승 제  -  ");
			System.out.println("\n========================================================");
			while(true){
				com=(int)(Math.random()*3+1);
				System.out.println("========================================================");
				System.out.println(" 1.가위 2.바위 3.보 중에서 입력하시오 . \n");
				System.out.print("선택 : ");
				user=Integer.parseInt(scan.next());
				
				if(user==2)							// user 와 다마고치가 낸 숫자를  묵 찌 빠 로 변환하여 변수에 넣음
					user_text="묵";
				else if(user==1)
					user_text="찌";
				else if(user==3)
					user_text="빠";
				if(com==2)
					com_text="묵";
				else if(com==1)
					com_text="찌";
				else if(com==3)
					com_text="빠";
				
				if(com-user==0)						// 같은 것을 낸 경우 
				{
					System.out.print("       "+Dama_name+" : "+ com_text+"  		 V S   " );
					System.out.println("  	  "+player+" : "+  user_text );
					System.out.println("\n			비겼습니다. \n" );
				}
				else if(com-user==1|| com-user==-2)
				{
					cntcom=cntcom+1;				// 다마고치가 이긴 경우
					System.out.print("       "+Dama_name+" : "+ com_text+"  		 V S   " );
					System.out.println("  	  "+player+" : "+  user_text );
					System.out.println("\n			"+Dama_name+"  승!! \n" );
				}
				else if(com-user==2|| com-user==-1)
				{
					cntuser=cntuser+1;				// player가 이긴 경우 
					System.out.print("       "+Dama_name+" : "+ com_text+"  		 V S   " );
					System.out.println("  	  "+player+" : "+  user_text );
					System.out.println("\n			"+player+"  승 !! \n");
				}
				
				if(cntcom==3 || cntuser==3) 
				{	System.out.println("========================================================\n");
					if(cntuser==3)
					System.out.println("		     "+player+"의 승리! \n " );
					
					if(cntcom==3)
					System.out.println("		     "+Dama_name+"의 승리! \n " );

					System.out.println("========================================================");
					break;
					
				}
			
			
			}
			
			System.out.println("========================================================");
			System.out.println("                  	게임 끝!!   ");
			System.out.println("========================================================\n");	
			
			onlyplaycnt++;
			happy+=5;
			System.out.print("\n  행복 +5 / ");		   // 게임 후 변화 수치 표시
			
			hungry-=5;
			System.out.print(" 포만감 -5 / ");			   // 게임 후 변화 수치 표시
			
			if(onlyplaycnt<3) {
				exp+=10;
				System.out.print(" 경험치  +"+10+" \n\n");// 게임 후 변화 수치 표시
			
			}
				
			else if( onlyplaycnt>=3) {
				 exp-=10;
		
				System.out.println("놀기만 해서 경험치가 떯어졌습니다.-10");
				System.out.println(" "+Dama_name+" : 많이 놀았으니까 이젠 공부해야지..! ");
				}/*게임을 3번연속하면 경험치 수치 감소 */
			
		}
		
		
		public void dice_play2() {  // 주사위 게임 (2개 중 택1 하여 게임 진행 )  
									// 1. 주사위 값의 합을 몇 배수로 만들기 게임  
									// 2. 주사위 합이 큰 쪽이 승리하는 게임
			hungrymaxcnt=0;
			int playerdice=0,damadice=0, dicecnt=0;		// 
			int playerhap=0;							// player의 주사위 확인하여 나온 값을 합하여 넣는 변수
			int damahap=0;								// 다마고치의 주사위 확인하여 나온 값을 합하여 넣는 변수
			int hapcnt=0;								// 주사위 값을 확인하여 합한 횟수 
			int select=0;								// 주사위를 던질지 , 주사위를 확인 할지 선택한 것을 넣는 변수 
			int monselect;								// 룰을 2가지 중에서 선택한 것을 넣는 변수 
			int multiplesel=0;							// 룰 2번째 주사위 합을 n배수로 만드는 룰을 선택할 때  - n 배수를 정하여 넣는 변수 
		
			System.out.println("");
			System.out.println("========================================================\n");
			System.out.println("	      ( play ) 주사위 게임  \n ");
			System.out.println(" 	      	  -  주사위 합   - \n\n"
				 + "		 * 짝수 번 째의 경우  "+ player
				 + "\n		 * 홀수 번 째의 경우  " + Dama_name
				 + "\n	 *주사위를 더 던질 것인지 값을 확인 할지 선택 "
				 + "\n *주사위 합이 큰 쪽을 룰로 선택하였을 시 "
				 + "4번 값을 확인하고 승패를 결정한다.  ");
			System.out.println("\n========================================================");
			
			System.out.println("		!게임 규칙 선택 !\n");
			System.out.println(" 1번 주사위 합이 더 큰쪽 (승)  /  2번 주사위 합을 n배수로 만드는 쪽(승)");
			System.out.print("\n\n  선택  : ");
			monselect=scan.nextInt();					// 2가지 중 1개의 룰을 선택 
		
			if(monselect==1) System.out.println(" 1번 주사위 합이 더 큰쪽 (승) 을 선택하였습니다. ");
		
			if(monselect==2) {
				System.out.println(" 2번 주사위 합을 n배수로 만드는 쪽(승) 을 선택하였습니다.");
				while(true) {
					System.out.print("몇 배수 선택 ( 7 배수 이상 ~ 11배수 이하  ): ");
					multiplesel=scan.nextInt();
		
					if(multiplesel<7 || multiplesel>11) {
						System.out.print("\n 다시 선택해주세요( 7 배수 이상 ~ 11배수 이하  ) "); 
						continue;
					}
					else { break;}
				}
			}
			System.out.println("\n========================================================");
			while(true) {
				
				System.out.println("\n   		"+(hapcnt+1)+"  번   째  \n\n");
		
				System.out.print(" 1번 주사위 던지기  ");					 // 주사위를 던지고 싶은 만큼 던진 후 주사위 값을 확인 
				if(dicecnt>=1) {
					System.out.print("  /   2번 주사위 값 확인   ");		 // 주사위를 한번 이상 던 진 후에 주사위 값을 확인 하는 것이 출력됨
				}
		
		
				if(hapcnt%2==0) {
		
					if(dicecnt==0) { select=1; }
		
					else { select=(int)(Math.random()*2)+1;}
		
					System.out.print("\n\n\n \'"+Dama_name + "\'(이)가 ");
				}
		
				else if(hapcnt%2==1) { 
					System.out.print("\n\n\'"+player+"\'의  선택  : ");
					
					select=scan.nextInt();
		
					System.out.print("\n\n \'"+player+"\'(이)가 ");
				}
				switch(select) {									
					case 1:System.out.println(" "+select+" 번  '주사위 던지기'를 선택했습니다.\n "); break;
					case 2:System.out.println(" "+select+" 번  '주사위 확인하기'를 선택하였습니다.\n"); break;
				}
		
				if(select==1) {
					playerdice =(int)((Math.random()*6)+1);		// 주사위 숫자가 최대 6임으로 1~6사이 숫자 랜덤 값 
					damadice = (int)((Math.random()*6)+1);		// 주사위 숫자가 최대 6임으로 1~6사이 숫자 랜덤 값 
					dicecnt++;
				}
		
				else if(select==2) {							// 주사위 값을 확인하기를 선택하였을 때 출력 
											
					System.out.print(player+" 의 주사위 값 : "+ playerdice+"     " );
					System.out.print(Dama_name+" 의 주사위 값 : "+ damadice+"\n\n" );
			
					playerhap+=playerdice;
					damahap+=damadice;
					hapcnt++;
					System.out.print(player+" 의 주사위 합 : "+ playerhap+"     " );
					System.out.print(Dama_name+" 의 주사위 합 : "+ damahap+"\n\n"  );
					dicecnt=0;
				}
				System.out.println("========================================================");
				if(monselect==1 && hapcnt==4) {
					if(playerhap>damahap) { System.out.println("					"+playerhap+" \n	 	         "+player+" 의 승리!!");}
					else if(playerhap==damahap) { System.out.println("				무승부 !!");}
					else { System.out.println(damahap+" \n	    	      "+Dama_name+" 의 승리!!");} 
					break;
				}	
			
				if(monselect==2 && playerhap!=0 && damahap!=0 
				&&(playerhap%multiplesel==0 || damahap%multiplesel==0)) {
					System.out.print("  		     "+multiplesel+" 의 배수 : ");
					if(playerhap%multiplesel==0) {System.out.println(playerhap+" \n	 	         "+player+" 의 승리!!");}
					else if(damahap%multiplesel==0) {System.out.println(damahap+" \n	    	      "+Dama_name+" 의 승리!!");}
					else { System.out.println("				무승부 !!");}
					break;
				}
			}
			
			System.out.println("========================================================");
			System.out.println("                  	게임 끝!!   ");
			System.out.println("========================================================\n");
			
			onlyplaycnt++;
			happy+=5;
			System.out.print("\n  행복 +5 / ");				// 게임 후 변화 수치 표시
			
			hungry-=5;
			System.out.print(" 포만감 -5 / ");					// 게임 후 변화 수치 표시
			
			if(onlyplaycnt<3) {
				exp+=10;
				System.out.print(" 경험치  +"+10+" \n\n");		// 게임 후 변화 수치 표시
			}
			
			else if( onlyplaycnt>=3) {
				exp-=10;
			
				System.out.println("놀기만 해서 경험치가 떯어졌습니다.-10");
				System.out.println(" "+Dama_name+" : 많이 놀았으니까 이젠 공부해야지..! ");
			}												//게임을 3번연속하면 경험치 수치 감소 
			
		}
		
	     public void eat() {
	         
	         String food[][]=new String[][]    				// 메뉴종류와 가격 포만감 이 들어있는  배열 
	               {
	               {"냄비갈비","4000","35"},{"돼지 뚝배기","3000","30"},
	               {"소 불고기","3500","30"},{"국밥","5000","35"},{"알밥","2800","30"},
	               {"돈까스","3200","31"},{"도시락","3000","30"},{"육개장칼국수","4500","33"},
	               {"연어초밥","6000","30"},{"파스타","5500","35"},{"김밥","2000","20"},
	               {"라면,밥","2500","25"},{"우동","3000","25"},{"핫도그","1500","15"}
	               };
	               
	               
	               Scanner scan = new Scanner(System.in);
	               int sample[] = new int[5];
	               int scnt=0; //scnt는 sample[] 숫자 기입을 위해서, 중복 방지를 위해서
	               int foodnum, seecnt;
	               boolean truth=true;
	               System.out.println("========================================================\n");
	               System.out.println("		    !! 다마고치 식당  !!	"	);
	               System.out.println("\n========================================================\n");
	               while(true) {
	                  sample[scnt]=(int)(Math.random()*food.length);
	                  seecnt=0;
	                  while(seecnt<scnt) {					//여러개의 메뉴 출력
	                     if (sample[seecnt]==sample[scnt])
	                    	 truth=false;
	                     seecnt+=1;
	                  }
	                  if(truth==false) {
	                     truth=true; continue;			//메뉴가 중복될 경우 재출력
	                  }
	                  foodnum=sample[scnt];
	                 
	                  System.out.println(" "+((scnt)+1)+"번 "+food[foodnum][0]+" ("+food[foodnum][1]+"원)\n");
	                  
	                  scnt+=1;
	                  
	                  if(scnt==4) {									//메뉴가 4개 전부 출력되었을 경우
	                     System.out.println(" 5번 다른 메뉴 보기 \n\n 6번 야식 메뉴 \n");
	                     System.out.print(" 선택 : ");
	                     sample[4]=Integer.parseInt(scan.next());
	                     
	                  }
	                  
	                  if(5==sample[4]) {						//5번을 선택하면 메뉴를 초기화 후에 재출력
	                     scnt=0;
	                     sample[4]=0;
	                  }
	                  else if(scnt==4 && sample[4]!=6) {			//1~4번을 선택하면 음식에 따라 상태 게이지가 변화
	                     foodnum=sample[ sample[4]-1];
	                     int Price=Integer.parseInt(food[foodnum][1]);
	                     int eat=Integer.parseInt(food[foodnum][2]);
	                     money -= Price;
	                     System.out.println();
	                     System.out.println("				 \'"+food[foodnum][0]+"\'을 선택하였습니다.");
	                     System.out.println("====================================================\n");
	                     System.out.print(" 돈 -"+Price+"원");
	                     
	                     if(hungry<=99) {						// 포만감 99이하일 경우 변화 상태 표시 
	                    	 hungry += eat;
	                    	 System.out.print(" /  포만감 +"+eat);
	                    	 happy+=eat/2;
	                    	 System.out.println(" /  행복  +"+(eat/2));
	                    	 
	                     }
	                     else {
	                    	hungry += eat;
	          				happy-=(hungry-100)/5;   			// 포만감이 최대 100에서 100을 초과할 때  (행복도를 초과한 수치)/5만큼  (-)시킨다. 
	          				System.out.print("/ 행복  -"+(hungry-100)/5);
	          				hungry=100;  
	          				System.out.println(" /   포만감 +"+0);// 포만감  Max 100으로 설정
	          				hungrymaxcnt++;			 			// 포만감이 100초과가 계속 될때 hungrymaxcnt++;
	          			}	
	                    
	                     if(money < 0) { 						// 현금이 0원 미만일 경우 현금 5만원 은행에서 가져옴
	                        money += 50000;
	                        bank -= 50000;
	                        System.out.println("현금이 부족해서 5만원을 꺼냈다.");
	                     }
	                     break;
	                  }
	                  
	                  
	                  if(6==sample[4]) {        						//6번 선택시 야식 메뉴로 이동
	                	  System.out.println("====================================================\n");
	                	 System.out.println("\n 				\'야식\'을 선택하였습니다.");
	                     Scanner night = new Scanner (System.in);
	                     System.out.println(" 1번 치킨 (만오천원)\n\n 2번 피자 (2만원)\n\n 3번 족발 (3만원)\n\n"
	                     		+ " 4번 떡순튀 (2만원)\n\n ");
	                     System.out.print(" 선택 : ");
	                     sample[4]=night.nextInt();			// 야식 메뉴 선택 
	                     
	                     switch (sample[4]) {				// 선택한 메뉴에 따라 switch문으로 출력 
	                     case 1 :								
	                    	
	                    	 
	                    	 System.out.println("				\'치킨\'(을)를  선택하였습니다.");
	                        System.out.println("\" 치킨은 살 안쪄요. 살은 내가 쪄요\"");
	                        if (money < 15000 ) {
	                           bank -= 15000;
	                           System.out.println("				현금이 부족하여 카드계산하였습니다. ");	// 현굼이 부족하 경우 
	                        } else {															// 카드계산 - 은행에서 출금됨
	                           money -= 15000;
	                        }                     
	                        
	                    	System.out.println("  돈  -"+15000+"\n");
	                     break;
	                     case 2 :
	                    	
	                    	 System.out.println("				\'피자\'(을)를  선택하였습니다.");
	                        System.out.println("\"내 인생도 피자\"");
	                        if (money < 20000 ) {
	                           bank -= 20000;
	                           System.out.println("				현금이 부족하여 카드계산하였습니다.");
	                        } else {
	                           money -= 20000;
	                        }
	                        
	                    	System.out.println("  돈  -"+20000+"\n");
	                     break;
	                     case 3 :
	                    	 
	                    	 System.out.println("				\'족발\'(을)를  선택하였습니다.");
	                    	 System.out.println("\"야식하면 족발이지.!\"");
	                        if (money < 25000 ) {
	                           bank -= 25000;
	                           System.out.println("				현금이 부족하여 카드계산하였습니다.");
	                        } else {
	                           money -= 25000;
	                        }
	                     
	                    	System.out.println("  돈  -"+25000+"\n");
	                     break;
	                     case 4 :
	                    	
	                    	 System.out.println("				\'떡볶이\'(을)를 선택하였습니다.");
	                        if (money < 10000 ) {
	                           bank -= 10000;
	                           System.out.println("				현금이 부족하여 카드계산하였습니다.");
	                        } else {
	                           money -= 10000;
	                        }
	                       
	                    	 System.out.println("  돈  -"+10000+"\n");
	                     break;
	                     default :
	                        System.out.println("오늘은 먹고 싶은게 없네 ..먹지말자..");
	                     break;
	                     }
	                     if(hungry<=99) {				//  포만감 99이하일 경우 변화 상태 표시
		                        hungry += 30;
		                        happy += 15;
		                        System.out.println("====================================================\n");
		                        System.out.print(" 행복  +"+15);
		                    	System.out.print(" /  포만감  +"+30+"\n");
	                        }
	                     else {							//  포만감 100이상일 경우 변화 상태 표시
	                        	hungry += 30;
		                        happy -= (hungry-100)/5;
		                        System.out.println("====================================================\n");
		                        System.out.print(" 행복  -"+(hungry-100)/5);
		                    	System.out.print(" /  포만감  +"+0+"\n");
		                    	hungrymaxcnt++;
	                     }
	                  
	                     if(money < 0) { 				// 현금 0원 미만일 경우 5만원 출금 
	                        money += 50000;
	                        bank -= 50000;
	                        System.out.println("현금이 부족해서 5만원을 꺼냈다.");
	                     }
	                     
	                     break;
	                  }
	                  
	               }            
	      }
		      
		      
		   public void bank () {
		         
		      int num;
		      int take; //인출금액
		            
		      Scanner in = new Scanner (System.in);
		      
		      System.out.print("1. 인출    2. 취소         \n\n 선택 : ");
		      num=in.nextInt();
		      switch (num) {
		      case 1 :
		          	Scanner Test = new Scanner(System.in);  
		            System.out.println("잔고 : "+bank+"원");
		            System.out.print("인출금액 : ");
		            take=Test.nextInt();
		            money += take;
		            bank -= take;
		            System.out.println(take+"원 인출");
		            System.out.print("소지금 : "+money+"원");
		            System.out.println(",   잔고 : "+bank+"원");
		       break;
		       default :
		            System.out.println("취소");
		            System.out.println("잔고 : "+bank+"원");
		       break;
		            
		         }
		      
		    
		  }
		   public void childmath_study1() {		  	// 레벨 1 때만  할 수 있는 study 메서드 
				hungrymaxcnt=0;
				System.out.println("");
				System.out.println("====================================================\n");
				System.out.println("	      ( study ) 숫자 공부  \n "
						+ "			- 덧셈 -");
				System.out.println("\n====================================================");
				
			   Scanner cal = new Scanner(System.in);
			      int dap, answer=0;

			      int cnt=0, moncnt=0,score=0;
			      
			      while (true) {
			    	 
			    	  while(true) {										// 유치원생 난이도를 유지하기 위해 
					    int exam1 = (int)(Math.random()*5+1);			// 랜덤을 1~5 사이에서 뽑느다
					    int exam2 = (int)(Math.random()*5+1);			
			    		System.out.println("\n===================================================");
			  			System.out.println(" "+(moncnt+1)+" 번 문제  ===========================================");
			  			System.out.println("===================================================\n");			
				        System.out.println("\n		 "+exam1+"  +  "+exam2+" 는   ???\n");
				        System.out.print(" 	        답 : ");
				         dap= cal.nextInt();
				         answer=exam1+exam2;
				         if ( dap == answer ) {
				            System.out.println("					정답입니다.");
				            score++;
				            break;
				         }
				         else { 
				            System.out.println("					오답입니다");
				            cnt++;
				            if (cnt >= 5) {
				               System.out.println("			정답 : "+answer);
				               break;
				            }
				            continue;
				         }
			    	  }
			    	  moncnt++;
			    	  if(moncnt==5) break;
				         else continue;
			     }
			    System.out.println("					맞춘 갯수 : "+ score+"\n");
			    System.out.println("========================================================");
				System.out.println("                  	공부 끝!!   ");
				System.out.println("========================================================\n");
				
				onlyplaycnt=0;
				
				happy-=3;
				System.out.print("\n  행복 -3 / ");          // 변화 수치 표시
				
				 hungry-=5;
				 System.out.print(" 포만감 -5 / ");			// 변화 수치 표시
				
				exp+=10;
				System.out.print(" 경험치  +10 \n\n");			// 변화 수치 표시

			}
			
		
		 public void childmath_study2() {
		     hungrymaxcnt=0;
		     int   cnt=0,randNumber=0;//  남은 재기회 4-cnt /5번 기회준다 / randNumber 랜덤으로 문제를 뽑기위한 변수
		     String input, answer1="포도" , answer2="병아리",answer3="가위", answer4="연필", answer5="책";// input 답 입력 
		     System.out.println("");
		     System.out.println("====================================================\n");
		     System.out.println("         ( study ) 물건 이름 알기   \n "
		           + "         - 1문제씩 풀기 -");
		     System.out.println("\n====================================================");
		     
		     
		        
		        
		     System.out.println("\n===================================================");
		       System.out.println(" =================     문제            =====================");
		       System.out.println("===================================================\n");
		       randNumber=(int)(Math.random()*5+1);
		     
		       if(randNumber==1||randNumber==2||randNumber==3||randNumber==4||randNumber==5) {
		        System.out.println("저는 무슨 과일일까요?");
		        System.out.println("");   
		        System.out.print("    ┬");  // 옆에 "저는 갈색 모자를 쓰고 있어요."라는문자를 넣기 위해서 print를 사용하여 줄을 바꾸지 않았다
		        System.out.println("     저는 갈색 모자를 쓰고 있어요.");
		        System.out.print("  ○○○○○ "); 
		        System.out.println("  저는 보라색 옷을 입고 있어요.");
		        System.out.println("   ○○○ "); 
		        System.out.println("    ○"); 
		        System.out.println("");
		           
		        while(true) {
		           System.out.print("답: ");
		           input= scan.next(); //값입력을 받기위해서 scan.next();를 사용했다
		           
		           if(answer1.equals(input)) { // input값이 answer1가 동일한 값이면 if문을 실행한다
		              System.out.println("               정답입니다");
		           }
		           else {
		              System.out.println("            틀렸습니다  남은 기회 : "+(4-cnt)); //cnt(0)값이 1씩 커지면서 남은기회는 4321로 줄어든다
		              cnt++;
		              if(cnt>=5) break; // cnt가 5이상이될경우 if문이 실행되어 break작동, 따라서 중단됨
		              continue; // cnt가 5미만일경우 위로 올라가서 else문을 다시 실행시킨다
		           }   
		           System.out.println("               정답은 "+answer1+"이었습니다.");
		           break; // 정답을 말하고 중단
		        }
		     }   
		              

		            
		     if(randNumber==1||randNumber==2||randNumber==3||randNumber==4||randNumber==5) {
		        System.out.println("저는 무슨 동물일까요?");
		        System.out.println("");
		        System.out.println("        ▲▲ "); 
		        System.out.print  ("    ┌──────┐");  // 옆에 "저는 노란색이에요."라는문자를 넣기 위해서 print를 사용하여 줄을 바꾸지 않았다
		        System.out.println("     저는 노란색이에요.");
		        System.out.print  ("    │ º  º │");
		        System.out.println("     저의 엄마는 빨간모자를 쓰고 있어요.");
		        System.out.print("  ##│  Σ   │##  ");
		        System.out.println(" 저는 크면 알을 낳아요.");
		        System.out.println("    └──────┘");
		        System.out.println("      |   |");
		        System.out.println("      3   3");            
		           
		        while(true) {
		           System.out.print("답: ");
		           input= scan.next();//값입력을 받기위해서 scan.next();를 사용했다
		           
		           if(answer2.equals(input)) {
		              System.out.println("               정답입니다");
		           }
		           else {
		              System.out.println("            틀렸습니다  남은 기회 : "+(4-cnt));//cnt(0)값이 1씩 커지면서 남은기회는 4321로 줄어든다
		              cnt++;
		              if(cnt>=5) break;// cnt가 5이상이될경우 if문이 실행되어 break작동, 따라서 중단됨
		              continue; // cnt가 5미만일경우 위로 올라가서 else문을 다시 실행시킨다
		           }   
		           System.out.println("               정답은 "+answer2+"이었습니다.");
		           break;// 정답을 말하고 중단
		        }
		     }
		            
		            
		     if(randNumber==1||randNumber==2||randNumber==3||randNumber==4||randNumber==5) {
		        System.out.println("저는 무슨 사물일까요?");
		        System.out.println("");
		              
		        System.out.print  ("┌─┐  ┌─┐");
		        System.out.println("  저는 두글자이에요.");
		        System.out.print  ("│ │  │ │");
		        System.out.println("  저는 무언가를 자를 수 있어요");
		        System.out.println("└─┘  └─┘");
		        System.out.println("  \\  /");
		        System.out.println("      Ｏ");
		        System.out.println("  /  \\");
		        System.out.println(" /    \\");
		        System.out.println("");

		        while(true) {
		           System.out.print("답: ");
		           input= scan.next();//값입력을 받기위해서 scan.next();를 사용했다
		           
		           if(answer3.equals(input)) {
		              System.out.println("               정답입니다");
		           }
		           else {
		              System.out.println("            틀렸습니다  남은 기회 : "+(4-cnt));//cnt(0)값이 1씩 커지면서 남은기회는 4321로 줄어든다
		              cnt++;
		              if(cnt>=5) break;// cnt가 5이상이될경우 if문이 실행되어 break작동, 따라서 중단됨
		              continue; // cnt가 5미만일경우 위로 올라가서 else문을 다시 실행시킨다
		           }   
		           System.out.println("               정답은 "+answer3+"이었습니다.");
		           break;   // 정답을 말하고 중단
		        }
		     }   
		           
		     if(randNumber==1||randNumber==2||randNumber==3||randNumber==4||randNumber==5) {
		        System.out.println("저는 무슨 사물일까요?");
		        System.out.println("");            
		              
		        System.out.print("   　　┌──┐");
		        System.out.println("  저는 두글자이에요.");
		        System.out.print("   　　├──┤");
		        System.out.println("  저는 글씨를 쓸 수 있어요.");
		        System.out.println("   　　││││");
		        System.out.println("   　　││││");
		        System.out.println("   　　││││");
		        System.out.println("　 　  ＼ 　 ／");
		        System.out.println("　　  　   ▼ ");
		        System.out.println("");
		              
		        while(true) {
		           System.out.print("답: ");
		           input= scan.next();//값입력을 받기위해서 scan.next();를 사용했다
		           
		           if(answer4.equals(input)) {
		              System.out.println("               정답입니다");
		           }
		           else {
		              System.out.println("            틀렸습니다  남은 기회 : "+(4-cnt));//cnt(0)값이 1씩 커지면서 남은기회는 4321로 줄어든다
		              cnt++;
		              if(cnt>=5) break;// cnt가 5이상이될경우 if문이 실행되어 break작동, 따라서 중단됨
		              continue; // cnt가 5미만일경우 위로 올라가서 else문을 다시 실행시킨다
		           }   
		           System.out.println("               정답은 "+answer4+"이었습니다.");
		           break;// 정답을 말하고 중단
		        }
		     }
		     if(randNumber==1||randNumber==2||randNumber==3||randNumber==4||randNumber==5) {
		        System.out.println("저는 무슨 사물일까요?");
		        System.out.println("");
		              
		        System.out.print  ("┌───────────┐ ┌───────────┐");
		        System.out.println("  저는 한글자이에요.");
		        System.out.print  ("│           └─┘           │");
		        System.out.println("  저를 읽는것을 '독서한다'라고 해요.");
		        System.out.println("│　~~~~~~~~~~   ~~~~~~~~  │");
		        System.out.println("│　~~~~~~       ~~~~~~    │");
		        System.out.println("│　~~~~~~~~     ~~~~~~~   │");
		        System.out.println("│　~~~~~~       ~~~~      │");
		        System.out.println("│　~~~~~~~~~~   ~~~~~~    │");
		        System.out.println("│　~~~~~~~~  　 ~~~       │");
		        System.out.println("│　~~~~~~       ~~~~~~~~  │");
		        System.out.println("│           ┌─┐           │");
		        System.out.println("└───────────┘ └───────────┘");
		        System.out.println("");

		        while(true) {
		           System.out.print("답: ");
		           input= scan.next();//값입력을 받기위해서 scan.next();를 사용했다.
		           
		           if(answer5.equals(input)) {
		              System.out.println("               정답입니다");
		           }
		           else {
		              System.out.println("            틀렸습니다  남은 기회 : "+(4-cnt));//cnt(0)값이 1씩 커지면서 남은기회는 4, 3, 2, 1로 줄어든다.
		              cnt++;
		              if(cnt>=5) break;// cnt가 5이상이될경우 if문이 실행되어 break작동, 따라서 중단됨
		              continue; // cnt가 5미만일경우 위로 올라가서 else문을 다시 실행시킨다
		           }   
		           System.out.println("               정답은 "+answer5+"이었습니다.");
		           break;// 정답을 말하고 중단
		        }      
		     }
		     System.out.println("========================================================");
		     System.out.println("                     공부 끝!!   ");
		     System.out.println("========================================================\n");
		     onlyplaycnt=0;
		           
		     happy-=3;
		     System.out.print("\n  행복 -3 / ");			// 변화 상태 표시
		           
		     hungry-=5;
		     System.out.print(" 포만감 -5 / ");			// 변화 상태 표시
		              
		     exp+=10;
		     System.out.print(" 경험치  +10 \n\n");		// 변화 상태 표시
		  
		  }
		  
	}
