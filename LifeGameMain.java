package LIFEGAME;

import java.util.ArrayList; 
import java.util.Scanner; 

public class LifeGameMain {  
	
	public static void main(String[] args) {
    
	Scanner sc = new Scanner(System.in);
    
	LifeGameSQL sql = new LifeGameSQL();
	
	LifeGameDTO character = new LifeGameDTO();
	
	StoreDTO store = new StoreDTO();
    
	sql.life();
	sql.game();
	
    boolean run = true;
    
    sql.connect();
    
    sql.oneSown();
    
    boolean firstRun = true;
    
    String mid = null;
    
    sql.dropCdto();
    sql.createCdto();
	
    while(firstRun) {
    
    
    System.out.println(" <<<<<<<< 1. 캐릭터 선택\t2.게임 시작 >>>>>>>> ");
    
    System.out.print("상단의 메뉴 중 원하시는 것을 보고 입력해주세요! >> ");
    int firstMenu = sc.nextInt();
    
    switch(firstMenu) {
    	case 1:
    
    //캐릭터 선택 while문
    
    while (run) {
      String select;
      System.out.println("캐릭터를 선택해주세요");
      System.out.println("=====================================================");
      System.out.println("\t1.준호\t2.재원\t3.주현\t4.준서");
      System.out.println("======== 0번을 누르면 캐릭터 선택하지 않고 종료합니다. ========");
      int choice = sc.nextInt();
      switch (choice) {
        case 0:
          System.out.println("초기화면으로 돌아갑니다");
          run = false;
          break;
        case 1:
          System.out.println("준호");
          System.out.println("돈: 1000만 || 행복: 50 || 건강 : 0");
          System.out.print("해당 캐릭터로 선택을 완료하시겠습니까?(Y/N) >> ");
          select = sc.next();
          if (select.equals("Y")) {
            System.out.println("캐릭터 선택을 완료하셨습니다!");
            //bank를 사용하지 않고 cdto의 balance와 property를 통해 금액 관리
            //캐릭터 선택을 완료하면 cdto 테이블에 해당 캐릭터의 정보 입력(mid는 이미 있음)
			//이걸 네 개 만들자 1234
			sql.selectCharacter1();
            //이때 캐릭터는 하나만 들어가 있는 상태라 이에 대해서는 걱정 없음
            System.out.println("게임을 시작합니다!");
            run = false;
          } else if (select.equals("N")) {
            System.out.println("캐릭터 선택창으로 돌아갑니다.");
          } else {
        	System.out.println("존재하지 않는 캐릭터입니다.");
          }
          break;
        case 2:
        	System.out.println("재원");
            System.out.println("돈: 5000만 || 행복: 0 || 건강 : 0");
            System.out.print("해당 캐릭터로 선택을 완료하시겠습니까?(Y/N) >> ");
            select = sc.next();
            if (select.equals("Y")) {
              System.out.println("캐릭터 선택을 완료하셨습니다!");
              sql.selectCharacter2();
              System.out.println("게임을 시작합니다!");
              run = false;
            } else if (select.equals("N")) {
              System.out.println("캐릭터 선택창으로 돌아갑니다.");
            } else {
          	System.out.println("존재하지 않는 캐릭터입니다.");
            }
            break;
        case 3:
        	System.out.println("주현");
            System.out.println("돈: 2500만 || 행복: 25 || 건강 : 25");
            System.out.print("해당 캐릭터로 선택을 완료하시겠습니까?(Y/N) >> ");
            select = sc.next();
            if (select.equals("Y")) {
              System.out.println("캐릭터 선택을 완료하셨습니다!");
              sql.selectCharacter3();
              System.out.println("게임을 시작합니다!");
              run = false;
            } else if (select.equals("N")) {
              System.out.println("캐릭터 선택창으로 돌아갑니다.");
            } else {
          	System.out.println("존재하지 않는 캐릭터입니다.");
            }
            break;
        case 4:
        	System.out.println("준서");
            System.out.println("돈: 2000만 || 행복: 0 || 건강 : 50");
            System.out.print("해당 캐릭터로 선택을 완료하시겠습니까?(Y/N) >> ");
            select = sc.next();
            if (select.equals("Y")) {
              System.out.println("캐릭터 선택을 완료하셨습니다!");
              sql.selectCharacter4();
              System.out.println("게임을 시작합니다!");
              run = false;
            } else if (select.equals("N")) {
              System.out.println("캐릭터 선택창으로 돌아갑니다.");
            } else {
          	System.out.println("존재하지 않는 캐릭터입니다.");
            }
            break;
        default:
        	System.out.println("존재하지 않는 캐릭터입니다.");
        	break;

       } //end original switch 

    } //end original while
    break;
    case 2: //우리 컨텐츠

    	
    	boolean contentsrun=true;
    	
    	while(contentsrun) {
    		
    		
    	System.out.println("1.돈 2.상점 3.건강 4.연애 5.내 상태&지갑 확인 6.종료");
    	int contents = sc.nextInt();
    	boolean moneyrun=true;
    	switch(contents) {
    	case 1:
    		
    		System.out.println("돈 관련 메뉴");
    		
    		while(moneyrun) {
    			
    			if(sql.badEndingsBool()) {
    				sql.dead();
    				run = false;
    				contentsrun = false;
    				moneyrun = false;
    				firstRun = false;
    				break;
    			}
    			
    			
    			if(sql.goodEndingsBool()) {
    				sql.success();
    				run = false;
    				contentsrun = false;
    				moneyrun = false;
    				firstRun = false;
    				break;
    			}
    			
    			
    			System.out.println("1.돈 벌기\t2.돈 쓰기\t3.종료"); //돈 쓰기:도박, 로또
    			int menu = sc.nextInt();
    			
    			switch(menu) {
    			case 1:
    					
    				//일일 장사 결과를 정해주는 주사위
    				int result = (int)(Math.random()*6)+1;
    					
    				if (result == 6) {
    					System.out.println("대박!");
    					int balance = 500000; //들어가는 돈. 70에서 실험위해 2200으로 수정 
    					character.setBalance(balance);
    				    character.setProperty(balance);
    					sql.deposit(character);
    						
    					int happy = 35;
    					character.setHappy(happy);
    					sql.upHappy(character);
    						
    					int health = 5;
    					character.setHealth(health);
    					sql.downHealth(character);
    					
    					System.out.println("대박나서 수익이 " + balance + "만큼 났습니다!");
    					System.out.println("행복지수가 +" + happy + " 올랐습니다! ");
    					System.out.println("건강지수가 + " + health + " 떨어졌습니다...");
    					System.out.println();
    					
    					sql.check();
    						
    				} else if (result > 1) {
    					int balance = 20000; //들어가는 돈 . 35에서 1500으로 수정
    					character.setBalance(balance);
    					character.setProperty(balance);
    					sql.deposit(character);
    						
    					int happy = 5;
    					character.setHappy(happy);
    					sql.downHappy(character);
    						
    					int health = 5;
    					character.setHealth(health);
    					sql.downHealth(character);
    					
    					System.out.println("수익이 " + balance + "만큼 났습니다!");
    					System.out.println("행복지수가 -" + happy + " 떨어졌습니다... ");
    					System.out.println("건강지수가 -" + health + " 떨어졌습니다 ...");
    					System.out.println();
    					sql.check();
    				} else {
    					System.out.println("오늘은 잘 안 됐네요~");
    					int balance = 20000; //들어가는 돈 10에서 800으로 수정
    					character.setBalance(balance);
    					character.setProperty(balance);
    					sql.deposit(character);
    						
    					int happy = 35;
    					character.setHappy(happy);
    					sql.downHappy(character);
    						
    					int health = 5;
    					character.setHealth(health);
    					sql.downHealth(character);
    					
    					System.out.println("수익이 " + balance + "만큼 났습니다!");
    					System.out.println("행복지수가 -" + happy + " 떨어졌습니다... ");
    					System.out.println("건강지수가 -" + health + " 떨어졌습니다 ...");
    					System.out.println();
    					sql.check();
    				}
    				
    				break;
    			case 2: //menu 2
    				
    				
    				System.out.println("돈 쓰는 방법 선택");
    				System.out.println("1.도박\t2.로또\t3.종료"); //상점은 연동 보류
    				int getMoney = sc.nextInt();
    				switch(getMoney) {
    				case 1:
    					System.out.println("강원랜드에 오신 걸 환영합니다!");
    					System.out.println("게임을 선택해주세요 >> 1.홀짝 2.룰렛 3.다이사이"); //다이사이는 룰 중 세 개의 숫자 합을 맞히는 배팅법을 채택
    					int gameMenu = sc.nextInt();
    					switch(gameMenu) {
    					case 1:
    						System.out.print("홀과 짝 중 한 가지를 입력해주세요! >> ");
    						String choice = sc.next();
    						System.out.print("배팅 금액을 입력해주세요!! >> ");
    						int bat = sc.nextInt();
    						
    						result = (int)(Math.random()*2)+1;
    						
    						if ((choice.equals("홀")&&result == 1)||(choice.equals("짝")&&result == 2)) {
    							System.out.println("축하드립니다! 맞히셨습니다!!");
    							character.setBalance(bat*2);
    							character.setProperty(bat*2);
    							sql.deposit(character);
    							System.out.println("획득 금액 >> " + (bat*2));
    							int happy = 10;
    							character.setHappy(happy);
    							sql.upHappy(character);
    							System.out.println("행복지수가 +" + happy + " 올랐습니다!");
    							System.out.println();

    							sql.check();
    							
    						} else {
    							System.out.println("아쉽네요 ㅜ 틀렸습니다...");
    							System.out.println();
    							System.out.println(bat + "원을 잃으셨습니다...");
    							
    							character.setBalance(bat);
    							character.setProperty(bat);
    							sql.withdraw(character);
    							
    							int happy = 5;
    							character.setHappy(happy);
    							sql.downHappy(character);
    							System.out.println("행복지수가 -" + happy + " 떨어졌습니다..");
    							System.out.println();
    							
    							sql.check();
    						}
    						break;
    					case 2:
    						
    						System.out.println("1~50까지의 숫자 중 하나를 입력해주세요!");
    						int roul = sc.nextInt();
    						
    						System.out.print("배팅 금액을 입력해주세요!! >> ");
    						bat = sc.nextInt();
    						
    						
    						int roll = (int)(Math.random()*50)+1;
    						
    						if (roul == roll) {
    							System.out.println("룰렛의 숫자를 맞히셨습니다!");
    							System.out.println("획득 금액 >> " + (bat*50)); //음, 50배
    							
    							character.setBalance(bat*50);
    							character.setProperty(bat*50);
    							sql.deposit(character);
    							
    							int happy = 50;
    							character.setHappy(happy);
    							sql.upHappy(character);
    							System.out.println("행복지수가 +" + happy + " 올랐습니다! ");
    							System.out.println();
    							
    							sql.check();
    						} else {
    							System.out.println("아쉽네요. 게임에서 패배하셨습니다...");
    							character.setBalance(bat);
    							character.setProperty(bat);
    							sql.withdraw(character);
    							
    							int happy = 5;
    							character.setHappy(happy);
    							sql.downHappy(character);
    							
    							System.out.println(bat + "원을 잃으셨습니다...");
    							System.out.println("행복지수가 -" + happy + " 떨어졌습니다... ");
    							System.out.println();
    							
    							sql.check();
    						}
    						
    						break;
    					case 3:
    						System.out.print("예상하시는 주사위 3개의합을 입력해주세요! >> ");
    						int sum = sc.nextInt();
    						System.out.print("배팅 금액을 입력해주세요!! >> ");
    						bat = sc.nextInt();
    						
    						
    						int [] daisai = new int [3]; //여기에 주사위 세 개 굴려서 보여주고 그 합도 보여주는 메소드 쓸 것
    						int daisaiResult = 0;
    						
    						for (int i = 0; i < 3 ; i++) {
    							daisai[i] = (int)(Math.random()*6)+1;
    							System.out.println((i+1) + " 번째 숫자 : " + daisai[i]);
    						}
    						
    						for (int i = 0; i < 3; i++) {
    							daisaiResult += daisai[i];
    						}
    						System.out.println("합계 >> " + daisaiResult);
    						
    						if (sum == daisaiResult) {
    							System.out.println("다이사이 게임에서 승리하셨습니다!");
    							System.out.println("획득 금액 >> " + (bat*16));
    							character.setBalance(bat*16);
    							character.setProperty(bat*16);
    							sql.deposit(character);
    							
    							int happy = 16;
    							character.setHappy(happy);
    							sql.upHappy(character);
    							
    							System.out.println("행복지수가 +" + happy + " 올랐습니다! ");
    							System.out.println();
    							
    							sql.check();
    						} else {
    							System.out.println("아쉽네요. 게임에서 패배하셨습니다...");
    							character.setBalance(bat);
    							character.setProperty(bat);
    							sql.withdraw(character);
    							
    							int happy = 5;
    							character.setHappy(happy);
    							sql.downHappy(character);
    							
    							System.out.println(bat + "원을 잃으셨습니다...");
    							System.out.println("행복지수가 -" + happy + " 떨어졌습니다..... ");
    							
    							System.out.println();
    							
    							sql.check();
    						}
    						break;
    					default:
    						System.out.println("잘못입력하셨습니다.");
    						break;
    					} //gameMenu end
    					break;
    				case 2: //로또

    					//최대 십만까지 내기. 최소 1000원. 평균은 5000이라 한다

    					//당첨액 1등 20억(ending 볼 수 있음) 2등 5000만 3등 150만 4등 5만 5등 5천(3개부터 돈 받을 수 있음)

    					//공은 보너스까지 총 7개
    					
    					if(sql.goodEndingsBool()) {
    						sql.success();
    						run = false;
    						contentsrun = false;
    						moneyrun = false;
    						firstRun = false;
    						break;
    					};
    					
    					

    					System.out.println("로또에 도전합니다!!");

    					System.out.println("1000원 지불하셨습니다~ ");

    					int lot = 1000;

    					character.setBalance(lot);

    					character.setProperty(lot);

    					sql.withdraw(character);

    					

    					System.out.println("1~45사이의 숫자를 여섯 번 입력해주세요!!");

    					

    					int chalange [] = new int [6];

    					

    				    for (int i = 0; i < 6; i++) {

    				    	System.out.print((i+1) + "번째 숫자 >> ");

    				    	int a = sc.nextInt();

    				    	chalange[i] = a;

    				    }

    				ArrayList<Integer> arr = new ArrayList<Integer>(); //당첨 결과 저장

    				

    				System.out.println("당첨번호를 확인해보겠습니다!");

    				
    			    int w = 0;
    				
    				while(w < 6) { //당첨 번호 6개

    					int l = (int)(Math.random()*45)+1; //소문자 L

    					if (!arr.contains(l)) { //숫자가 이미 들어가 있으면 새로 생성한 걸 집어넣자

    						arr.add(l);

    						System.out.println((w+1) + "번째 번호 >> " + arr.get(w));
    						
    						w ++;

    					} else {
    						
    						continue;

    					}

    				}

    				int bonus = 0; //보너스 번호
    				int bw = 0;

    				while(bw < 1) { //당첨 번호 6개

    					bonus = (int)(Math.random()*45)+1;

    					if (!arr.contains(bonus)) { //숫자가 이미 들어가 있으면 새로 생성한 걸 집어넣자

    						arr.add(bonus);
    						
    						System.out.println("보너스 번호 >> " + arr.get(6));
    						
    						bw ++;

    					} else {
    						
    						continue;

    					}

    				}
    				
    				int lCnt = 0; //맞힌 갯수

    				//결과 확인

    				for (int i = 0; i < 6; i++) {

    					 //7가지 숫자 중 맞힌 것

    					if (arr.contains(chalange[i])) {//입력한 6개의 숫자의 포함 여부 분석

    						lCnt ++;

    					} else {

    						continue;

    					}

    				}

    				

    				if (lCnt == 6) {

    					System.out.println("축하드립니다!!! 1등에 당첨되셨습니다~!!!!!");

    					System.out.println("당첨금 : 20억 !!!");

    					int cel = 2000000000;

    					character.setBalance(cel);

    					character.setProperty(cel);

    					sql.deposit(character);
    					
    					sql.check();


    				} else if (lCnt == 5) {

    					if (sql.checkBonus(bonus, chalange)) {//chalange에서 보너스 번호가 있는지 찾아야 한다

    						System.out.println("축하드립니다!! 2등에 당첨되셨습니다~!!!!");

    						System.out.println("당첨금 : 5000만 !!");

    						int cel = 50000000;

    						character.setBalance(cel);

    						character.setProperty(cel);

    						sql.deposit(character);
    						
    						sql.check();

    					} else {

    						System.out.println("축하드립니다! 3등에 당첨되셨습니다~!!!");

    						System.out.println("당첨금 : 150만 !");

    						int cel = 1500000;

    						character.setBalance(cel);

    						character.setProperty(cel);

    						sql.deposit(character);
    						
    						sql.check();

    					}

    				} else if (lCnt == 4) {

    						System.out.println("축하드립니다! 4등에 당첨되셨습니다~!!");

    						System.out.println("당첨금 : 5만");

    						int cel = 50000;

    						character.setBalance(cel);

    						character.setProperty(cel);

    						sql.deposit(character);
    						
    						sql.check();

    				} else if (lCnt == 3) {

    						System.out.println("축하드립니다! 5등에 당첨되셨습니다~!");

    						System.out.println("당첨금 : 5천");

    						int cel = 5000;

    						character.setBalance(cel);

    						character.setProperty(cel);

    						sql.deposit(character);
    						
    						sql.check();

    				} else {

    					System.out.println("아깝네요~ 당첨되지 않았습니다 ㅜ");
    					
    					sql.check();
    				}

    					break;
    				case 3:
    					System.out.println("메인 메뉴 돌아갑니다");
    					moneyrun=false;
    					break;
    				default:
    					System.out.println("잘못입력하셨습니다.");
    					break;
    				}
    				
    				break;
    			case 3:
					System.out.println("상위 메뉴로 돌아갑니다");
					moneyrun=false;
					break;
    			default:
    				break;

    			} //end first switch - money
    		
    		}//end while - money
    	

    		
    		break;
    	case 2: // 상점 case
    		boolean Storerun = true;
    		
    		int Storemenu = 0;
    		
    		
    		while(Storerun) {
    			
    			System.out.println("==========================================================");
    			System.out.println(" 1.상품목록\t 2.구매\t\t 3.판매\t\t 4.돌아가기");
    			System.out.println("==========================================================");
    			Storemenu=sc.nextInt();
    			boolean Storerun1 =true;
    			boolean Storerun2 =true;
    			boolean Storerun3 =true;
    			
    			
    			switch(Storemenu) {
    			
    			case 1: //상품 목록
    				
    				while(Storerun1) {
    					System.out.println("==========================================================");
    					System.out.println(" 상품 종류를 고르시오");
    					System.out.println(" 1.집\t 2.외제차\t 3.국산차\t 4.시계\t ");
    					System.out.println(" 5.지갑\t 6.옷\t 7.확인완료");
    					System.out.println("==========================================================");
    					int Storetypenumber = sc.nextInt();
    					
    					
    					switch(Storetypenumber) {
    					case 1: // 집 목록
    						sql.houseImfo();
    						System.out.println("집을 사시면 행복도 10이 추가됩니다.");
    						
    						break;

    					case 2: // 외제차 목록
    						sql.FcarImfo();
    						System.out.println("외제차를 사시면 행복도 5가 추가됩니다.");
    						
    						break;

    					case 3://국산차 목록
    						sql.carImfo();
    						System.out.println("국산차를 사시면 행복도 3가 추가됩니다.");
    						//행복도 상승 메소드
    						break;

    					case 4://시계 목록
    						sql.watchImfo();
    						System.out.println("시계를 사시면 행복도 1가 추가됩니다.");
    						//행복도 상승 메소드
    						break;

    					case 5://지갑 목록
    						sql.walletImfo();
    						System.out.println("지갑을 사도 행복도 추가 없음.");
    						
    						break;

    					case 6://옷 목록
    						sql.CloImfo();
    						System.out.println("옷을 사도 행복도 추가 없음.");
    						
    						break;

    					case 7://종료 
    						System.out.println("전 페이지로 돌아갑니다.");
    						Storerun1 = false;
    						
    						break;

    					default:
    						System.out.println("입력 오류 다시 입력하시오");
    						break;

    						
    					}//end switch
    				
    				}//end while
    				
    				break;
    			case 2:// 구매
    				while (Storerun2) {
    					System.out.println("=======================================");
    					System.out.println(" 구매하시는 사람의 이름을 입력하시오"); // 본인인증
    					System.out.println("=======================================");
    					String Storename = sc.next();
    					System.out.println("=======================================");
    					System.out.println(" 구매하는 브랜드를 입력하시오"); // 상품
    					System.out.println("=======================================");
    					String Storesid = sc.next();

    					store.setMid(Storename);
    					store.setsId(Storesid);

    					int StoreCDTObalance = sql.StoreCDTOCheckbalance(store);
    					// 캐릭터 자산
    					int StoreSprice = sql.StoreCheckSprice(store);
    					// 상점 가격
    					
    					if (StoreCDTObalance >= StoreSprice) {
    						sql.buyStore(store);
    						int happy = 20;
    						character.setHappy(happy);
    						sql.upHappy(character);
    					} else {
    						int lessbalance = StoreSprice - StoreCDTObalance;
    						System.out.println("돈이 부족합니다.");
    						System.out.println("부족한 금액은 :" + lessbalance + "입니다");
    					}
    					
    					if(sql.goodEndingsBool()) {
    						sql.success();
    						run = false;
    						contentsrun = false;
    						Storerun2 = false;
    						firstRun = false;
    						break;
    					};

    					Storerun2 = false;
    				} // end while
    				
    				

    				break;

    			case 3:// 판매
    				while (Storerun3) {
    					System.out.println("=======================================");
    					System.out.println(" 본인인증을 위해 판매하시는 사람의 이름을 입력하시오"); // 본인인증
    					System.out.println("=======================================");
    					String Storename = sc.next();
    					sql.StoreSellList(store);
    					System.out.println("=======================================");
    					System.out.println(" 판매하는 브랜드를 입력하시오"); // 상품
    					System.out.println("=======================================");
    					String Storesid = sc.next();

    					store.setMid(Storename);
    					store.setsId(Storesid);
    					int potential = sql.StoreSellpotential();

    					int Storesown = sql.StoreSownCheck(store);
    					if (Storesown > 0) { // 보유 여부 확인
    						
    						int happy = 20;
    						character.setHappy(happy);
    						sql.downHappy(character);
    						sql.sellStore(store);

    						if (potential > 0) { // 보유한 상품 정렬
    							System.out.println("판매 가능한 상품은 : ");
    							System.out.println();
    							System.out.println("======================");
    							sql.StoreSellList(store);
    							System.out.println("======================");

    						} else {
    							System.out.println("판매 가능한 상품이 없습니다..ㅜㅜ");
    						}
    					} else {
    						System.out.println("보유하지 않는 상품입니다");

    						if (potential > 0) {
    							System.out.println("판매 가능한 상품은 : ");
    							System.out.println();
    							System.out.println("======================");
    							sql.StoreSellList(store);
    							System.out.println("======================");

    						} else {
    							System.out.println("판매 가능한 상품이 없습니다..ㅜㅜ");
    						}
    					}

    					Storerun3 = false;
    				}
    				break;
    			case 4:
    				System.out.println("상점을 나옵니다.");
    				Storerun=false;
    				break;
    				
    			default:
    				System.out.println("잘못 입력했습니다 다시 입력 바랍니다.");
    				break;
    			
    			
    			
    			}//end switch
    		}//end while
    		// 상점 case 종료
    		
    		break;
    	case 3: //건강 case
    		
    		
    		boolean hrun = true;
    		boolean hrun1 = true;
    		boolean hrun2 = true;
    		
    		while(hrun) {
    			int hmenu = 0;
    			int hmenu1 = 0;
    			int hmenu2 = 0;
    			
    			
    			System.out.println("=============== 건강 ===================");
    			System.out.println("1. 식사\t 2. 잠\t 3. 운동\t 4. 술\t 5. 담배 6.종료");
    			System.out.print("메뉴 선택 >> ");
    			hmenu = sc.nextInt();
    			
    			switch(hmenu) {
    			case 1:
    		//		hrun1 = true;
    				while(hrun1) {
    	    			if(sql.badEndingsBool()) {
    	    				sql.dead();
    	    				hrun2 = false;
    	    				hrun1 = false;
    	    				hrun = false;
    	    				run = false;
    	    				contentsrun = false;
    	    				firstRun = false;
    	    				break;
    	    			};
    	    			if(sql.goodEndingsBool()) {
    	    				sql.dead();
    	    				hrun2 = false;
    	    				hrun1 = false;
    	    				hrun = false;
    	    				run = false;
    	    				contentsrun = false;
    	    				firstRun = false;
    	    				break;
    	    			};
    	    			
    					System.out.println("================= 식사 메뉴 ===================");
    					System.out.println("1. 피자 : 30000원\t 2. 치킨 : 20000원\t 3. 홍삼 : 200000원\t 4. 야채 : 5000원\t 5. 식사 종료");
    					System.out.print("메뉴 선택 >> ");
    					hmenu1 = sc.nextInt();
    					switch(hmenu1) {
    					case 1:
    						System.out.println("피자를 먹습니다.");
    						System.out.println("health" + " -45");
    						System.out.println("happy" + " +10");
    						System.out.println("money" + " -30000");
    						System.out.println("");
    						int health = 45;
    						character.setHealth(health);
    						sql.downHealth(character);
    						int happy = 10;
    						character.setHappy(happy);
    						sql.upHappy(character);
    						int property = 30000;
    						character.setProperty(property);
    						character.setBalance(property);
    						sql.withdraw(character);
    						sql.check();
    						break;
    					case 2:
    						System.out.println("치킨을 먹습니다.");						
    						System.out.println("health" + " -45");
    						System.out.println("happy" + " +5");
    						System.out.println("money" + " -20000");
    						System.out.println("");
    					    health = 45;
    						character.setHealth(health);
    						sql.downHealth(character);
    						happy = 5;
    						character.setHappy(happy);
    						sql.upHappy(character);
    						property = 20000;
    						character.setProperty(property);
    						character.setBalance(property);
    						sql.withdraw(character);
    						sql.check();
    						break;
    					case 3:
    						System.out.println("홍삼을 먹습니다.");						
    						System.out.println("health" + " +10");
    						System.out.println("happy" + " -45");
    						System.out.println("money" + " -200000");
    						System.out.println("");
    						health = 10;
    						character.setHealth(health);
    						sql.upHealth(character);
    						happy = 45;
    						character.setHappy(happy);
    						sql.downHappy(character);
    						property = 200000;
    						character.setProperty(property);
    						character.setBalance(property);
    						sql.withdraw(character);
    						sql.check();
    						break;
    					case 4:
    						System.out.println("야채를 먹습니다.");						
    						System.out.println("health" + " +5");
    						System.out.println("happy" + " -45");
    						System.out.println("money" + " -5000");
    						System.out.println("");
    						health = 5;
    						character.setHealth(health);
    						sql.upHealth(character);
    						happy = 45;
    						character.setHappy(happy);
    						sql.downHappy(character);
    						property = 5000;
    						character.setProperty(property);
    						character.setBalance(property);
    						sql.withdraw(character);
    						sql.check();
    						break;
    					case 5:
    						System.out.println("식사를 종료합니다.");

    						hrun1 = false;
    						break;
    					default:
    						System.out.println("잘못입력했습니다.");
    						break;
    					}
    					}
    				break;
    			case 2:
    				 
    				
    				if(sql.house()) {
    						//아파트 유
    						System.out.println("잠을 잡니다. zzz...");
    						System.out.println("health" + " +10");
    						System.out.println("happy" + " +10");
    						System.out.println("");
    						int health = 10;
    						character.setHealth(health);
    						sql.upHealth(character);
    						int happy = 10;
    						character.setHappy(happy);
    						sql.upHappy(character);
    						sql.check();
    					
    						
    					
    					
    				} else if(sql.house1()) {
    						//빌라 유
    						
    						System.out.println("잠을 잡니다. zzz...");
    						System.out.println("health" + " + 5");
    						System.out.println("happy" + " +6");
    						System.out.println("");
    						int health = 5;
    						character.setHealth(health);
    						sql.upHealth(character);
    						int happy = 6;
    						character.setHappy(happy);
    						sql.upHappy(character);
    						sql.check();
    						
    					
    					
    					
    					
    				} else if(sql.house2()) {
    						// 원룸 유
    						
    						System.out.println("잠을 잡니다. zzz...");
    						System.out.println("health" + " +3");
    						System.out.println("happy" + " +4 ");
    						System.out.println("");
    						int health = 3;
    						character.setHealth(health);
    						sql.upHealth(character);
    						int happy = 4;
    						character.setHappy(happy);
    						sql.upHappy(character);
    						sql.check();
    						
    						
    				}
    				else {
    					// 주거지 x
    					
    					System.out.println("밖에서 잡니다. zz");
    					System.out.println("health" + " +2");
    					System.out.println("happy" + " -45 ");
    					System.out.println("");
    					int health = 2;
    					character.setHealth(health);
    					sql.upHealth(character);
    					int happy = 45; // 변경예정
    					character.setHappy(happy);
    					sql.downHappy(character);
    					sql.check();
    					boolean nRun = true;
    					while(nRun) { //일단 이 조건이라면 배드엔딩을 볼 때까지 술을 퍼마시게 함
    						//그래서 술을 마신 다음에 check를 해서 
    						if(sql.badEndingsBool()) {
    							sql.dead();
    							nRun = false;
    							hrun2 = false;
    							hrun1 = false;
    							hrun = false;
    							run = false;
    							contentsrun = false;
    							firstRun = false;
    							
    						} else {
    							break;
    						}
    						break;
    					}
    				}
    			
    				break;
    			case 3:	
    				hrun2 = true;
    				while(hrun2) {
    					if(sql.badEndingsBool()) {
    						sql.dead();
    	    				hrun2 = false;
    	    				hrun1 = false;
    	    				hrun = false;
    	    				run = false;
    	    				contentsrun = false;
    	    				firstRun = false;
    	    				break;
    	    			} 
    					if(sql.goodEndingsBool()) {
    						sql.dead();
    	    				hrun2 = false;
    	    				hrun1 = false;
    	    				hrun = false;
    	    				run = false;
    	    				contentsrun = false;
    	    				firstRun = false;
    	    				break;
    	    			}
    					
    					System.out.println("=============== 운동 종목 ===================");
    					System.out.println("1. 헬스장\t 2. 런닝\t 3. 운동 종료");
    					System.out.print("메뉴 선택 >> ");
    					hmenu2 = sc.nextInt();
    					
    					switch(hmenu2) {
    					case 1:
    						System.out.println("헬스를 합니다.");
    						
    						int result = (int)(Math.random()*10)+1;
    						if(result>1) {	
    							System.out.println("health" + " +5");
    							System.out.println("happy" + " -45");
    							System.out.println("money" + " -20000");
    							System.out.println("");
    							int health = 5;
    							character.setHealth(health);
    							sql.upHealth(character);
    							int happy = 45;
    							character.setHappy(happy);
    							sql.downHappy(character);
    							int property = 20000;
    							character.setProperty(property);
    							character.setBalance(property);
    							sql.withdraw(character);
    							sql.check();
    							
    						}else {
    							System.out.println("부상을 당했습니다.");
    							System.out.println("health" + " -10");
    							System.out.println("happy" + " -45");
    							System.out.println("money" + " -20000");
    							System.out.println("");
    							int health = 10;
    							character.setHealth(health);
    							sql.downHealth(character);
    							int happy = 45;
    							character.setHappy(happy);
    							sql.downHappy(character);
    							int property = 20000;
    							character.setProperty(property);
    							character.setBalance(property);
    							sql.withdraw(character);
    							sql.check();
    							
    						}
    						
    						break;
    					case 2:
    						System.out.println("런닝을 뜁니다.");
    						int result1 = (int)(Math.random()*10)+1;
    						if(result1>1) {	
    							System.out.println("health" + " +5");
    							System.out.println("happy" + " -45");
    							System.out.println("");
    							int health = 5;
    							character.setHealth(health);
    							sql.upHealth(character);
    							int happy = 45;
    							character.setHappy(happy);
    							sql.downHappy(character);
    							sql.check();
    							
    						}else {
    							System.out.println("부상을 당했습니다.");
    							System.out.println("health" + " -10");
    							System.out.println("happy" + " -20");
    							System.out.println("");
    							int health = 10;
    							character.setHealth(health);
    							sql.downHealth(character);
    							int happy = 20;
    							character.setHappy(happy);
    							sql.downHappy(character);	
    							sql.check();
    						}						
    						break;	
    					case 3:
    						hrun2 = false;
    						System.out.println("운동을 종료합니다.");						
    						break;
    					default:
    						System.out.println("잘못입력했습니다.");
    						break;
    					}
    					}
    			
    				break;
    			
    				case 4:
    				
    				System.out.println("술을 먹습니다.");
    				
    				
    				System.out.println("health" + " -8");
    				System.out.println("happy" + " +10");
    				System.out.println("money" + " -4000");	
    				System.out.println("");
    				int health = 8;
    				character.setHealth(health);
    				sql.downHealth(character);
    				int happy = 10;
    				character.setHappy(happy);
    				sql.upHappy(character);
    				int property = 4000;
    				character.setProperty(property);
    				character.setBalance(property);
    				sql.withdraw(character);
    				sql.check();
    				boolean dRun = true;
    				while(dRun) { //일단 이 조건이라면 배드엔딩을 볼 때까지 술을 퍼마시게 함
    					//그래서 술을 마신 다음에 check를 해서 
    					if(sql.badEndingsBool()) {
    						sql.dead();
    						dRun = false;
    	    				hrun2 = false;
    	    				hrun1 = false;
    	    				hrun = false;
    	    				run = false;
    	    				contentsrun = false;
    	    				firstRun = false;
    	    			
    	    			} else {
    	    				break;
    	    			}
    				}
    				break;
    			case 5:
    				
    				System.out.println("담배를 핍니다.");			
    				System.out.println("health" + " -45");
    				System.out.println("happy" + " +10");
    				System.out.println("money" + " -4500");	
    				System.out.println("");
    				health = 45;
    				character.setHealth(health);
    				sql.downHealth(character);
    				happy = 10;
    				character.setHappy(happy);
    				sql.upHappy(character);
    				property = 4500;
    				character.setProperty(property);
    				character.setBalance(property);
    				sql.withdraw(character);
    				sql.check();
    				boolean sRun = true;
    				while(sRun) { //일단 이 조건이라면 배드엔딩을 볼 때까지 술을 퍼마시게 함
    					//그래서 술을 마신 다음에 check를 해서 
    					if(sql.badEndingsBool()) {
    						sql.dead();
    						sRun = false;
    	    				hrun2 = false;
    	    				hrun1 = false;
    	    				hrun = false;
    	    				run = false;
    	    				contentsrun = false;
    	    				firstRun = false;
    	    			
    	    			} else {
    	    				break;
    	    			}
    				}
    				break;
    			case 6:
    				System.out.println("메인메뉴로 이동합니다");
    				hrun =false;
    				break;
 
    			default:
    				System.out.println("잘못입력했습니다.");
    				break;
    			
    			}
    		}//end while
    		// 건강 case3
    		
    		break;
    		
    	case 4:
    		int Apartsown =  sql.checkSownApart(); // 캐릭터의 보유여부
    		int vilasown =  sql.checkSownVila(); // 캐릭터의 보유여부
    		int oneroomsown =  sql.checkSownOneroom(); // 캐릭터의 보유여부
    		boolean LoveRun = true;
    		
    		
    		
    		while(LoveRun) {
    			
    			System.out.println("======================원하시는 애인을 선택해주세요=======================");
    			System.out.println("======================★신중하게 선택해주세요★=========================");
    			System.out.println("1.(상) / 아파트를 보유해야만 도전할 수 있습니다!");
    			System.out.println("※ 얼굴: ★★★★★ / 몸매: ★★★★★ / 재력: ★★★★★ / 난이도 : ★★★★★");
    			System.out.println("2.(중) / 빌라를 보유해야만 도전할 수 있습니다!");
    			System.out.println("※ 얼굴: ★★★☆☆ / 몸매: ★★★☆☆ / 재력: ★★★☆☆ / 난이도 : ★★★☆☆");
    			System.out.println("3.(하) / 원룸을 보유해야만 도전할 수 있습니다!");
    			System.out.println("※ 얼굴: ★☆☆☆☆ / 몸매: ★☆☆☆☆ / 재력: ★☆☆☆☆ / 난이도 : ★☆☆☆☆");
    			System.out.println("4. 메인화면으로 나가기 ! ");
    			System.out.println();
    			System.out.println("현재 상태");
    			System.out.println();
    			sql.check();
    			sql.checkSownApart();
    			sql.checkSownVila();
    			sql.checkSownOneroom();
    			System.out.println();
    			System.out.print("번호 선택 >> ");
    			int LoveMenu1 = sc.nextInt();

    			
    			
    			System.out.println();
    			switch(LoveMenu1) {
    			case 1:
    				sql.checkBalance();
    				System.out.println("1회 이용료는 5000000원입니다.");
    				// 한번 할때마다 사용금액
    				
    				
    				if (sql.StoreCDTOCheckbalance2() >= 5000000) {
    				
    				int lbalance = 5000000;
    				character.setBalance(lbalance);
    				character.setProperty(lbalance);
    				sql.withdraw(character);
    				// 아파트를 보유하고 있다는 전제조건
    				if(Apartsown > 0){
    					sql.apartques1(); // 첫번째 질문
    					int love1 = sc.nextInt();
    					System.out.println();
    					switch(love1) { // 첫번째 대답
    					case 1:
    						System.out.println("기름져서 차임");
    						System.out.println();
    						break;
    					case 2:
    						System.out.println("내장이라 차임");
    						System.out.println();
    						break;
    					case 3:
    						System.out.println("조류알레르기 있어서 차임");
    						System.out.println();
    						break;
    					case 4:
    						System.out.println("이빨에 고춧가루 끼는거 싫어서 차임");
    						System.out.println();
    						break;
    					case 5: // 첫번째 정답 맞춘 후
    						sql.apartques2(); // 두번째 질문
    						int love2 = sc.nextInt();
    						
    						switch(love2) { // 두번째 대답
    						case 1:
    							System.out.println("매실향 싫어해서 차임");
    							System.out.println();
    							break;
    						case 2:
    							System.out.println("순한 느낌이 싫어서 차임");
    							System.out.println();
    							break;
    						case 3:
    							System.out.println("전남친이 부산에 살아서 차임");
    							System.out.println();
    							break;
    						case 4:
    							System.out.println("참이슬 너무 써서 차임");
    							System.out.println();
    							break;
    						case 5:
    							System.out.println("과일주 먹으면 숙취 심해서 차임");
    							System.out.println();
    							break;
    						case 6:
    							System.out.println("블랙핑크 마지막처럼 좋아해서 차임");
    							System.out.println();
    							break;
    						case 7: // 2번 정답 & 3번 질문
    							sql.apartques3();
    							int love3 = sc.nextInt();
    							
    							switch(love3) {
    							case 1:
    								System.out.println("주량 너무 낮아서 노잼일거같아 차임");
    								break;
    							case 2:
    								System.out.println("애매해서 차임");
    								break;
    								
    							case 3:
    								System.out.println("평범해서 차임");
    								break;
    								
    							case 4: // 성공
    								System.out.println();
    								System.out.println("지현) 저도 주량 그정도 되는데~저희 자주 마셔요!!");
    								System.out.println();
    									
    								System.out.println("지현이와 술을 자주 마시다가 속도위반으로 그만..결혼하게 되었습니다..♥");
    								sql.love();
    								
    								LoveRun = false;
    								run = false;
    	    	    				contentsrun = false;
    	    	    				firstRun = false;
    								
    								
    								break;
    								
    							case 5:
    								System.out.println("가오부리는거 싫어해서 차임");
    								break;
    							default :
    								System.out.println("해당 번호는 없습니다");
    								break;
    							}
    							
    							System.out.println();
    							break;
    						case 8:
    							System.out.println("셔서 차임");
    							System.out.println();
    							break;
    						case 9:
    							System.out.println("두꺼비 싫어해서 차임");
    							System.out.println();
    							break;
    						case 10:
    							System.out.println("보리향 싫어해서 차임");
    							System.out.println();
    							break;
    						case 11:
    							System.out.println("도수 낮아서 차임");
    							break;
    						case 12:
    							System.out.println("제주도 섬이라서 차임");
    							break;
    						default :
    							System.out.println("없는 번호입니다. 다시 선택해주세요");
    							System.out.println();
    							break;
    						}
    						
    						break;
    					case 6:
    						System.out.println("중국 싫어해서 차임");
    						System.out.println();
    						break;
    					case 7:
    						System.out.println("인도 싫어해서 차임");
    						System.out.println();
    						break;
    					case 8:
    						System.out.println("밀가루 살쪄서 차임");
    						System.out.println();
    						break;
    					case 9:
    						System.out.println("느끼해서 차임");
    						System.out.println();
    						break;
    					case 10:
    						System.out.println("미국 싫어해서 차임");
    						System.out.println();
    						break;
    					default :
    						System.out.println("없는 번호입니다. 다시 선택해주세요");
    						System.out.println();
    						break;
    					}//첫번째 질문 switch 끝
    					
    				} 
    				
    				// 아파트를 보유하고 있지 않을때
    				else {
    					System.out.println("아파트를 보유하고 있지 않습니다.");
    					System.out.println("아파트를 구매 후 도전하세요 ^-^");
    					System.out.println("선택 화면으로 돌아갑니다");
    					LoveRun = false;
    					
    				}
    				} else {
						int lessbalance = 5000000 - sql.StoreCDTOCheckbalance2();
						System.out.println("돈이 부족합니다.");
						System.out.println("부족한 금액은 :" + lessbalance + "입니다");
					}
    				break;
    			case 2: // 중여자
    				sql.checkBalance();
    				System.out.println("1회 이용료는 3000000원입니다.");
    				// 한번 할때마다 사용금액
    				
    				
    				if (sql.StoreCDTOCheckbalance2() >= 3000000) {
    				int lbalance = 3000000;
    				character.setBalance(lbalance);
    				character.setProperty(lbalance);
    				sql.withdraw(character);
    				// 빌라를 보유하고 있다는 전제조건
    				if(vilasown > 0){
    					sql.vilaques1(); // 첫번째 질문
    					int love1 = sc.nextInt(); // 첫번째 답
    					System.out.println();
    					
    					if(love1 == 1) { // 첫번째 문제 1번 골랐을때
    						System.out.println("이전에 소개팅 많이했다는게 기분나빠서 차임");
    						System.out.println();			
    					} else if(love1 == 2) { // 첫번째 문제 2번 골랐을때
    						sql.vilaques2(); // 두번째 질문
    						int love2 = sc.nextInt();
    						if(love2 == 1) { // 두번째 문제 1번 골랐을때 정답 & 세번째 질문
    							sql.vilaques3();
    							int love3 = sc.nextInt();
    							switch(love3) {
    							case 1:
    								System.out.println("오글거리는거 싫어해서 차임");
    								break;
    								
    							case 2:
    								System.out.println("스킨쉽할까봐 걱정해서 차임");
    								break;
    								
    							case 3:
    								System.out.println("현실주의자여서 차임");
    								break;
    								
    							case 4:
    								System.out.println("여자인 자신을 배려해주지 않아서 차임");
    								break;
    								
    							case 5:
    								System.out.println("가현) 저 남자가 애니매이션 좋아하는거 처음봤어요 !!");
    								System.out.println("가현) 저도 애니매이션 엄청 좋아하거든요 ㅎㅎ");
    								System.out.println();
    								System.out.println("이후 같이 텔에서 넷플릭스 보다가 그만 사랑에 빠졌습니다..♥");
    								
    								int happy = 80;
    								character.setHappy(happy);
    								sql.upHappy(character);
    								
    								System.out.println();
    								sql.check();
    								break;
    								
    							case 6:
    								System.out.println("눈물 흘리면 화장지워지는게 싫어서 차임");
    								break;
    								
    							default:
    								System.out.println("없는 번호입니다. 다시 선택해주세요");
    								break;
    							}
    							
    						
    						
    						
    						}
    						else if(love2 == 2) { // 두번째 문제 2번 골랐을때
    							System.out.println("지현이 말을 부정해서 빈정상해 차임");
    						}
    						else { // 두번째 문제 다른번호일 경우
    							System.out.println("해당 번호는 없습니다. 다시 선택해주세요.");
    							System.out.println();
    							break;
    						}
    						
    					}
    					else { // 첫번째 문제 번호 다른번호일 경우
    						System.out.println("해당 번호는 없습니다. 다시 선택해주세요.");
    						System.out.println();
    						break;
    					}
    					
    				} 
    				
    				// 빌라를 보유하고 있지 않을때
    				else {
    					System.out.println("빌라를 보유하고 있지 않습니다.");
    					System.out.println("빌라를 구매 후 도전하세요 ^-^");
    					System.out.println("선택 화면으로 돌아갑니다");
    					System.out.println();
    					LoveRun = false;
    					
    				}
    				} else {
						int lessbalance = 3000000 - sql.StoreCDTOCheckbalance2();
						System.out.println("돈이 부족합니다.");
						System.out.println("부족한 금액은 :" + lessbalance + "입니다");
					}
    				break;
    			case 3:
    				sql.checkBalance();
    				System.out.println("1회 이용료는 1000000원입니다.");
    				
    				
    				
    				if (sql.StoreCDTOCheckbalance2() >= 1000000) {
    					
    				int lbalance = 1000000;
    				character.setBalance(lbalance);
    				character.setProperty(lbalance);
    				
    				sql.withdraw(character);
    				// 원룸를 보유하고 있다는 전제조건
    				if(oneroomsown > 0){
    					sql.oneroomques1(); // 첫번째 질문
    					int love1 = sc.nextInt(); // 첫번째 답
    					System.out.println();
    					
    					if(love1 == 1) { // 첫번째 문제 1번 골랐을때
    						sql.oneroomques2(); // 두번째 질문
    						int love2 = sc.nextInt();
    						System.out.println();
    						if(love2 == 1) { // 두번째 문제 1번 골랐을때
    							System.out.println("느끼함에 속이 안좋아져 토하다가 응급실간 후 차임");
    							System.out.println();
    						} else if(love2 == 2) { // 두번째 문제 2번 골랐을때
    							sql.oneroomques3(); // 세번째 질문
    							int love3 = sc.nextInt();
    							if(love3 == 1) {
    								System.out.println("술한잔 걸치고 서로에게 빠져 연애시작..♥");
    								System.out.println();
    								int happy = 50;
    								character.setHappy(happy);
    								sql.upHappy(character);
    								
    								sql.check();
    							} else if(love3 == 2) {
    								System.out.println("숙희의 성희롱 신고로 고소");
    								System.out.println();
    							} else {
    								System.out.println("해당 번호는 없습니다. 다시 선택해주세요.");
    								break;
    							}
    							
    						} else { // 두번째 문제 다른번호일 경우
    							System.out.println("해당 번호는 없습니다. 다시 선택해주세요.");
    							System.out.println();
    							break;
    						}
    						
    						
    						
    					} else if(love1 == 2) { // 첫번째 문제 2번 골랐을때
    						System.out.println("숙희의 급발진으로 소리지르면서 싸우다가 차임");
    						System.out.println();
    					}
    					else { // 첫번째 문제 번호 다른번호일 경우
    						System.out.println("해당 번호는 없습니다. 다시 선택해주세요.");
    						System.out.println();
    						break;
    					}
    					
    				} 
    				
    				// 원룸을 보유하고 있지 않을때
    				else {
    					System.out.println("원룸을 보유하고 있지 않습니다.");
    					System.out.println("원룸을 구매 후 도전하세요 ^-^");
    					System.out.println("선택 화면으로 돌아갑니다");
    					System.out.println();
    					LoveRun = false;
    					
    				}
    				
    				} else {
						int lessbalance = 1000000 - sql.StoreCDTOCheckbalance2();
						System.out.println("돈이 부족합니다.");
						System.out.println("부족한 금액은 :" + lessbalance + "입니다");
					}
    				break;
    			case 4:
    				System.out.println("메인 화면으로 나가겠습니다");
    				LoveRun = false;
    				break;
    			default :
    				System.out.println("잘못 입력하셨어요 ㅜㅡㅜ 다시 입력해주세요 !");
    				break;
    			
    			
    			} // switch(LoveNumber1) 종료
    			
    			
    		} // while(LoveRun) 종료
    		
    		
    		
    		
    		break;
    	case 5:
    		sql.check();
    		break;
    	case 6:
    		System.out.println("초기화면으로 돌아갑니다.");
    		contentsrun = false;
    		break;
    	default:
    		System.out.println("잘못입력하셨습니다.");
    		break;	
    	}//end while
    	}//end switch
    	
    	break;
    default:
    	System.out.println("잘못입력하셨습니다.");
    	break;
    } //end firstMenu switch
    } //end firstRun while
	}
}