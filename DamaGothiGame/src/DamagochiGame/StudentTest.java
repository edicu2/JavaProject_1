package DamagochiGame;
import java.util.*;
public class StudentTest {
	
	public static void main(String [] args) {
		Student st01= new Student();
		Scanner scan=new Scanner(System.in);
		int select;
		String exitselect="";
	
				
							
		st01.Start();
		
		st01.identify();
		
		st01.chadata();
		while(true) {
			System.out.println("\n 1. 공부(study)     2. 놀기(play)     3.밥먹기(eat)"
					+ "\n\n       4.은행가기(bank)    5.일시정지(pause) OR 종료\n ");
			System.out.print("  선택 : ");
			select=scan.nextInt();
			System.out.println("========================================================\n");
			if(select==1) {
				System.out.println(" 				\'공부(study)\'(을)를 선택하였습니다.\n");
				if(st01.level==1) {
					System.out.println("    1. 물건 이름 알기     2. 수학 공부      3. 영어 단어 공부   \n");
					System.out.print("  선택 : ");
					select=scan.nextInt();
					switch(select) {
					case 1:st01.childmath_study2(); break; 
					case 2:System.out.println("\n	1. 덧셈 공부       2.곱셈 공부\n");
							System.out.print("  선택 : ");
							select=scan.nextInt();
							switch(select) {
							case 1:st01.childmath_study1(); break;
							case 2:st01.math_study2();		break;
							} break;
					case 3:st01.vocabulary_study1();break;
					}
					
				}
				else{
					System.out.println("  1. 국어공부        2. 수학공부         3. 영어 공부\n");
					System.out.print("  선택 : ");
					select=scan.nextInt();
					switch(select) {
					case 1:st01.lang_study3();break; 
					case 2:st01.math_study2(); break;
					case 3:st01.vocabulary_study1();break;
					}
				}
				st01.chadata();
			}
			
			else if(select==2) {
				System.out.println(" 				\'놀기(play)\'(을)를 선택하였습니다.\n");
				System.out.println("  1. 주사위게임(dice)     2. 같은 단어 맞추기          3. 가위바위보");
				System.out.print("  선택 : ");
				select=scan.nextInt();
				switch(select) {
				case 1:st01.dice_play2();break; 
				case 2:st01.piece_play3(); break;
				case 3:st01.rockpapersc_play1();break;
				}
				st01.chadata();
			}
			else if(select==3) {
				System.out.println(" 			\'밥 먹기(eat)\'(을)를 선택하였습니다.\n");
				st01.eat();
				st01.chadata();
			}
			else if(select==4) {
				System.out.println(" 			\'은행 가기(bank)\'(을)를 선택하였습니다.\n");
				st01.bank();
				st01.chadata();
			}
			else if(select==5) {
				System.out.println(" \'일시정지(pause) OR 종료(exit)\'(을)를 선택하였습니다.\n");
				System.out.println("  1. 일시정지   2. 종료 ");
				System.out.print("  선택 : ");
				select=scan.nextInt();
				if(select==1) {
					while(true) {
						System.out.println(" \'일시정지(pause)\'(을)를 선택하였습니다.\n");
						System.out.println("  일시정지  해제  1번 (YES) / 2번 유지 (NO) ");
						System.out.print("  선택 : ");
						select=scan.nextInt();
						if(select==1) {
							System.out.println(" \'일시정지(pause) 해제\'(을)를 선택하였습니다.\n\n");
							break;
							
						}
						if(select==2) {
							System.out.println(" \'일시정지(pause) 유지\'(을)를 선택하였습니다.\n\n");
							continue;
						}
					}
					st01.chadata();
					continue;
				}
			
				if(select==2) { 
					System.out.println(" \'종료(EXIT)\'(을)를 선택하였습니다.\n\n");
					while(true) {
						System.out.print("다마고치 시작 시 입력한 비밀번호를 입력해주세요.\n 입력 :");
						st01.passcheck=scan.next();
						
						if(st01.pass.equals(st01.passcheck)) {
							System.out.println("\n비밀번호가 확인되었습니다.");
							break;
						}
						else {
							System.out.println("				    비밀번호가 일치하지 않습니다. ");
							continue;
						}
					}
					System.out.println(" 게임을 종료하면 기존의 다마고치의 정보가 모두 사라지게 됩니다.\n");
					System.out.println(" 종료  EXIT(대문자) // 계속 플레이 PLAY (을)를 적어주세요.");
					System.out.print("  입력 : ");
					exitselect=scan.next();
					if(exitselect.equals("EXIT")) {
						System.out.println(" 다마 고치를 이용해주셔서 감사합니다..\n");
						break;
					}	
					else {
						System.out.println(" 계속 플레이 합니다.\n");
						continue;
					}
				}
				
			}
			
		}	
	}										 
}
