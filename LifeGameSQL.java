package LIFEGAME;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//dto를 전부 cdto로
public class LifeGameSQL {

	Connection con = null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;

	
	
	public void connect() {

		con = DBConnection.DBConnect();

	}

	public void conClose() {
		try {

			con.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// 돈 관련 메소드들
	// 입금. mid를 조건으로 찾고 잔액과 총액 업그레이드.
	public void deposit(LifeGameDTO character) {

		String sql1 = "UPDATE cdto SET balance = balance + ?";

		try {

			pstmt = con.prepareStatement(sql1);
			pstmt.setInt(1, character.getBalance());

			int result = pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}

		String sql2 = "UPDATE cdto SET property = property + ?";

		try {

			pstmt = con.prepareStatement(sql2);
			pstmt.setInt(1, character.getProperty());

			int result = pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	// 출금
	public void withdraw(LifeGameDTO character) {

		String sql1 = "UPDATE cdto SET balance = balance - ? ";

		try {
			pstmt = con.prepareStatement(sql1);
			pstmt.setInt(1, character.getBalance());

			int result = pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		}

		String sql2 = "UPDATE cdto SET property = property - ?";

		try {
			pstmt = con.prepareStatement(sql2);
			pstmt.setInt(1, character.getProperty());

			int result = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	// 모든 스탯(잔액, 행복, 건강) 확인
	public void check() { // LifeGameDTO character

		String sql = "SELECT balance FROM cdto";

		try {
			stmt = con.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int balance = rs.getInt(1); // 신기하네
				System.out.println("잔액 : " + balance + " 원");
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		String sql1 = "SELECT happy FROM cdto";

		try {
			stmt = con.createStatement();

			rs = stmt.executeQuery(sql1);

			while (rs.next()) {
				int happy = rs.getInt(1); // 신기하네
				System.out.println("행복지수 : " + happy);
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		String sql2 = "SELECT health FROM cdto";

		try {
			stmt = con.createStatement();

			rs = stmt.executeQuery(sql2);

			while (rs.next()) {
				int health = rs.getInt(1); // 신기하네
				System.out.println("건강 : " + health);
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		String sql3 = "SELECT property FROM cdto";

		try {
			stmt = con.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int property = rs.getInt(1); // 신기하네
				System.out.println("총자산 : " + property + " 원");
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}
	}

	// 잔액 확인
	public int checkBalance() { // LifeGameDTO character
		
		int balance = 0;
		
		String sql = "SELECT balance FROM cdto";

		try {
			stmt = con.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				balance = rs.getInt(1); // 신기하네
				System.out.println("잔액 : " + balance + " 원");
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}
		
		return balance;
	}

	// 행복지수 확인
	public void checkHappy() { // LifeGameDTO character

		String sql = "SELECT happy FROM cdto";

		try {
			stmt = con.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int happy = rs.getInt(1); // 신기하네
				System.out.println("행복지수 : " + happy);
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}
	}

	// 건강 확인
	public void checkHealth() { // LifeGameDTO character

		String sql = "SELECT health FROM cdto";

		try {
			stmt = con.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int health = rs.getInt(1); // 신기하네
				System.out.println("건강 : " + health);
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}
	}

	// 엔딩용 - 총자산을 세팅해주는 메소드
	public int compare() { // 일단 로직 에러. property로 수정 후 테스트 필요

		int property = 0;

		String sql = "SELECT property FROM cdto";

		// mid를 set한 뒤에 사용.
		// 원래 잔액을 확인하고 balance라는 변수에 저장하여 비교 가능하도록 해줌

		try {
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				property = rs.getInt(1); // 신기하네
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return property;

	}

	// 행복과 건강 수치 변경
	public void upHappy(LifeGameDTO character) {

		String sql = "UPDATE cdto SET happy = happy + ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, character.getHappy());
//			pstmt.setString(2, character.getMid());

			int result = pstmt.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();

		}
	}

	public void downHappy(LifeGameDTO character) {

		String sql = "UPDATE cdto SET happy = happy - ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, character.getHappy());

			int result = pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

	public void upHealth(LifeGameDTO character) {

		String sql = "UPDATE cdto SET health = health + ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, character.getHealth());

			int result = pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		}
	}

	public void downHealth(LifeGameDTO character) {

		String sql = "UPDATE cdto SET health = health - ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, character.getHealth());

			int result = pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		}
		
	}

	// 캐릭터 선택
	public void selectCharacter1() { // 준호

		String sql = "INSERT INTO cdto VALUES ('준호',10000000,10000000,50,0)";
		// mid balance money happy health love
		try {
			stmt = con.createStatement();
			int result = stmt.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void selectCharacter2() { // 재원

		String sql = "INSERT INTO cdto VALUES ('재원',50000000,50000000,0,0)";
		// mid balance money happy health love
		try {
			stmt = con.createStatement();
			int result = stmt.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void selectCharacter3() { // 주현

		String sql = "INSERT INTO cdto VALUES ('주현',25000000,25000000,25,25)";
		// health happy balance money love mid
		try {
			stmt = con.createStatement();
			int result = stmt.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void selectCharacter4() { // 준서

		String sql = "INSERT INTO cdto VALUES ('준서',20000000,20000000,0,50)";
		// health happy balance money love mid
		try {
			stmt = con.createStatement();
			int result = stmt.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean checkBonus(int bonus, int[] chalange) {

		boolean check = false;

		for (int i = 0; i < 6; i++) {

			if (chalange[i] == bonus) {

				check = true;

			} else {

				continue;

			}

		}

		return check;

	}

	public int compareBalance() {

		int balance = 0;

		String sql = "SELECT balance FROM cdto";

		// mid를 set한 뒤에 사용.
		// 원래 잔액을 확인하고 balance라는 변수에 저장하여 비교 가능하도록 해줌

		try {
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				balance = rs.getInt(1); // 신기하네
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return balance;

	}

	public void storeImformation() {
		String sql = "select * from storetbl ";

		try {

			stmt = con.createStatement();
			// pstmt = con.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			while (rs.next()) { // 데이터(레코드)가 존재할때까지 반복

				System.out.println("브랜드: " + rs.getString(1));
				System.out.println("상품정보 : " + rs.getString(2));
				System.out.println("상품종류 : " + rs.getString(3));
				System.out.println("가격 : " + rs.getInt(4));
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 외제차 목록 메소드
	public void FcarImfo() {
		String sql = "select * from storetbl where Stype = '외제차'";

		try {

			stmt = con.createStatement();
			// pstmt=con.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			while (rs.next()) { // 데이터(레코드)가 존재할때까지 반복

				System.out.println("브랜드: " + rs.getString(1));
				System.out.println("상품정보 : " + rs.getString(2));
				System.out.println("상품종류 : " + rs.getString(3));
				System.out.println("가격 : " + rs.getInt(4));
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 집 목록 메소드
	public void houseImfo() {
		String sql = "select * from storetbl where Stype = '집'";

		try {

			stmt = con.createStatement();
			// pstmt=con.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			while (rs.next()) { // 데이터(레코드)가 존재할때까지 반복

				System.out.println("브랜드: " + rs.getString(1));
				System.out.println("상품정보 : " + rs.getString(2));
				System.out.println("상품종류 : " + rs.getString(3));
				System.out.println("가격 : " + rs.getInt(4));
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 차 목록 메소드
	public void carImfo() {
		String sql = "select * from storetbl where Stype = '국산차'";

		try {

			stmt = con.createStatement();
			// pstmt=con.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			while (rs.next()) { // 데이터(레코드)가 존재할때까지 반복

				System.out.println("브랜드: " + rs.getString(1));
				System.out.println("상품정보 : " + rs.getString(2));
				System.out.println("상품종류 : " + rs.getString(3));
				System.out.println("가격 : " + rs.getInt(4));
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 시계 목록 메소드
	public void watchImfo() {
		String sql = "select * from storetbl where Stype = '시계'";

		try {

			stmt = con.createStatement();
			// pstmt=con.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			while (rs.next()) { // 데이터(레코드)가 존재할때까지 반복

				System.out.println("브랜드: " + rs.getString(1));
				System.out.println("상품정보 : " + rs.getString(2));
				System.out.println("상품종류 : " + rs.getString(3));
				System.out.println("가격 : " + rs.getInt(4));
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 지갑 목록 메소드
	public void walletImfo() {
		String sql = "select * from storetbl where Stype = '지갑'";

		try {

			stmt = con.createStatement();
			// pstmt=con.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			while (rs.next()) { // 데이터(레코드)가 존재할때까지 반복

				System.out.println("브랜드: " + rs.getString(1));
				System.out.println("상품정보 : " + rs.getString(2));
				System.out.println("상품종류 : " + rs.getString(3));
				System.out.println("가격 : " + rs.getInt(4));
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 옷 목록 메소드
	public void CloImfo() {
		String sql = "select * from storetbl where Stype = '옷'";

		try {

			stmt = con.createStatement();
			// pstmt=con.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			while (rs.next()) { // 데이터(레코드)가 존재할때까지 반복

				System.out.println("브랜드: " + rs.getString(1));
				System.out.println("상품정보 : " + rs.getString(2));
				System.out.println("상품종류 : " + rs.getString(3));
				System.out.println("가격 : " + rs.getInt(4));
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 3. 구매 메소드
	public void buyStore(StoreDTO store) {
		// (1) sql문 작성
		String sql = "UPDATE cdto SET balance  = balance - (select sprice from storetbl where sid=?" + ")\r\n"
				+ "where cdto.mid =? ";

		// (2) stmt, pstmt 선언 후 try/catch문
		try {
			pstmt = con.prepareStatement(sql);

			// (3) pstmt로 선언했을 경우 ?에 데이터 삽입

			pstmt.setString(1, store.getsId());
			pstmt.setString(2, store.getMid());

			// (4) 실행
			int result = pstmt.executeUpdate();

			// (5) 실행결과
			if (result > 0) {
				System.out.println("구매 성공!");
			} else {
				System.out.println("구매 실패!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		// swon +1 메소드
		String sql2 = "update storetbl set sown=sown+1 where sid=?";

		try {
			pstmt = con.prepareStatement(sql2);

			pstmt.setString(1, store.getsId());

			// (4) 실행
			int result = pstmt.executeUpdate();

			// (5) 실행결과
			if (result > 0) {
				System.out.println("소유 성공!");
			} else {
				System.out.println("소유 실패!");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sql3 = "select happy,property from cdto where mid=?";
		try {
			pstmt = con.prepareStatement(sql3);
//				stmt = con.createStatement();
			pstmt.setString(1, store.getMid());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int happy = rs.getInt(1); // 신기하네
				int property = rs.getInt(2);
				System.out.println("행복지수 : " + happy);
				System.out.println("자산 : " + property);

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}// void buyStore

	// 판매 메소드
	public void sellStore(StoreDTO store) {
		String sql = "UPDATE cdto SET balance  = balance + (select sprice from storetbl where sid=? and sown>0"
				+ ")\r\n" + "where cdto.mid =?";

		// (2) stmt, pstmt 선언 후 try/catch문
		try {
			pstmt = con.prepareStatement(sql);

			// (3) pstmt로 선언했을 경우 ?에 데이터 삽입

			pstmt.setString(1, store.getsId());
			pstmt.setString(2, store.getMid());

			// (4) 실행
			int result = pstmt.executeUpdate();

			// (5) 실행결과
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// swon +1 메소드
		String sql2 = "update storetbl set sown=sown-1 where sid=? and sown>0";

		try {
			pstmt = con.prepareStatement(sql2);

			pstmt.setString(1, store.getsId());

			// (4) 실행
			int result = pstmt.executeUpdate();

			// (5) 실행결과
			if (result > 0) {
				System.out.println("판매 성공");
			} else {
				System.out.println("판매 실패");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sql3 = "select happy,property from cdto where mid =? ";
		try {
			pstmt = con.prepareStatement(sql3);
//					stmt = con.createStatement();
			pstmt.setString(1, store.getMid());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int happy = rs.getInt(1); // 신기하네
				int property = rs.getInt(2);
				System.out.println("행복지수 : " + happy);
				System.out.println("자산 : " + property);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}// end sellstore

	// 아파트
	public boolean house() {

		boolean house = true;
		String sql = "select sown from storetbl where sid = '포레나'";

		try {
			stmt = con.createStatement();

			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int sown = rs.getInt(1);
				if (sown > 0) {
					house = true;

				} else {
					house = false;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return house;

	}

	// 빌라
	public boolean house1() {

		boolean house = true;
		String sql = "select sown from storetbl where sid = '그린빌라'";
		int sown = 0;
		try {
			stmt = con.createStatement();

			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				sown = rs.getInt(1);
				if (sown > 0) {
					house = true;

				} else {
					house = false;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return house;

	}

	// 원룸
	public boolean house2() {

		boolean house = true;
		String sql = "select sown from storetbl where sid = '하우올리PM'";

		try {
			stmt = con.createStatement();

			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int sown = rs.getInt(1);
				if (sown > 0) {
					house = true;

				} else {
					house = false;
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return house;

	}

	public void LoveMenu() {
		System.out.println("======================원하시는 애인을 선택해주세요=======================");
		System.out.println("1.(상) / 아파트를 보유해야만 도전할 수 있습니다!");
		System.out.println("※ 얼굴: ★★★★★ / 몸매: ★★★★★ / 재력: ★★★★★ / 난이도 : ★★★★★");
		System.out.println("2.(중) / 빌라를 보유해야만 도전할 수 있습니다!");
		System.out.println("※ 얼굴: ★★★☆☆ / 몸매: ★★★☆☆ / 재력: ★★★☆☆ / 난이도 : ★★★☆☆");
		System.out.println("3.(하) / 원룸을 보유해야만 도전할 수 있습니다!");
		System.out.println("※ 얼굴: ★☆☆☆☆ / 몸매: ★☆☆☆☆ / 재력: ★☆☆☆☆ / 난이도 : ★☆☆☆☆");
		System.out.println("4. 메인화면으로 나가기 ! ");
		System.out.println();
		System.out.print("번호 선택 >> ");

	}

	public void oneroomques1() {
		System.out.println("(하) 여자를 꼬셔보세요 !");
		System.out.println();
		System.out.println("숙희) 안녕하세요 제가 좀 늦었죠 ㅠㅠ오래 기다리셨어요?");
		System.out.println();
		System.out.println("1. 아뇨아뇨 ! 저도 방금 도착했습니다 ");
		System.out.println("2. 아...네... 좀 늦으셨는데 ...뭐 괜찮아요 원래 시간약속을 잘 안지키시는건가..ㅋㅋ");
		System.out.print("선택 >>");

	}

	public void oneroomques2() {
		System.out.println("숙희) 죄송해요,, 메뉴부터 시킬까요? 어떤거 드시겠어요?");
		System.out.println();
		System.out.println("1. 저는 숙희씨 먹는거 보기만 해도 배부른걸요~?");
		System.out.println("2. 숙희씨 먼저 고르시면 그다음에 제가 안겹치게 고르겠습니다");
		System.out.print("선택 >>");

	}

	public void oneroomques3() {
		System.out.println("# 식사를 마치고");
		System.out.println("숙희) 저희 장소를 옮길까요 이제? 어디로 이동할까요?");

		System.out.println("1. 해도 졌는데 가볍게 술한잔 할까요? 제가 아는 이자카야가 있거든요");
		System.out.println("2. 제가 자취하는데 저희집가서 한잔 하실래요? 맛있는 요리 해드릴게요");
		System.out.print("선택 >>");

	}

	public void vilaques1() {
		System.out.println("(중) 여자를 꼬셔보세요 !");
		System.out.println();
		System.out.println("안녕하세요 ㅎㅎ(수줍수줍)");
		System.out.println();
		System.out.println("1. 엇 엄청 아름다우시네요 ! 제가 소개팅한 분들중에서 가장 이쁘신거같아요");
		System.out.println("2. 엄청 이쁘시네요 ㅎㅎ 완전 제스타일 !");
		System.out.print("선택 >>");

	}

	public void vilaques2() {
		System.out.println("지현) 하하,, 감사합니다 제가 사실 수지 닮았다는 얘기 많이 듣거든요 ㅎㅎ");
		System.out.println();

		System.out.println("1. 오 수지 닮으셨다 ㅎㅎ 왜 그런말 듣는지 알거같아요");
		System.out.println("2. 수지 하나도 안닮았어요 ! 굳이 찾으면 박보영느낌 ..??");
		System.out.print("선택 >>");
		System.out.println();

	}

	public void apartques1() {
		System.out.println("(상) 여자를 꼬셔보세요 !");
		System.out.println();
		System.out.println("# 만나서 메뉴 선정중");
		System.out.println("지현) 어떤거 먹으러 갈까요?");
		System.out.println();
		System.out.println("1.삼겹살\t 2.곱창\t 3.닭갈비\t 4.김치찌개");
		System.out.println("5.회\t 6.짜장면\t 7.카레\t 8.라멘");
		System.out.println("9.된장찌개\t 10.햄버거");
		System.out.println();
		System.out.print("선택 >>");

	}

	public void apartques2() {
		System.out.println("회 괜찮으세요?");
		System.out.println();
		System.out.println("지현) 어머 저 회 정말 좋아해요 !! 횟집가요 ㅎㅎ");
		System.out.println();
		System.out.println("#횟집 도착해서");
		System.out.println();
		System.out.println("지현) 저희 모둠회랑 술은 어떤거로 마실까요?");
		System.out.println("1.매화수\t 2.청하\t 3.대선\t 4.참이슬");
		System.out.println("5.자몽의 이슬\t 6.처음처럼\t 7.진로 + 테라\t 8.아이셔의 이슬");
		System.out.println("9.진로\t 10.클라우드\t 11.이슬톡톡\t 12.한라산");
		System.out.print("선택 >>");

	}

	public void apartques3() {
		System.out.println();
		System.out.println("저희 진로 테라 시켜서 소맥마실까요? ");
		System.out.println();
		System.out.println("지현) 앗! 저희 아버지께서 태진아를 좋아하셔서 테라진로 섞은거만 먹는데! ㅎㅎㅎ");
		System.out.println("지현) 쨘할까요? 쨘!! 근데 주량이 어떻게 되세요??");
		System.out.println();
		System.out.println("1. 제가 술을 잘 못해서...ㅎㅎ소주 두잔이 주량이에요");
		System.out.println("2. 잘 마시지는 못하는데 소주 반병정도 마시는 것 같아요");
		System.out.println("3. 저는 딱 소주 한병까지가 끝이에요!");
		System.out.println("4. 전 맞춰드릴수 있어요! 소주 3병까진 거뜬해요");
		System.out.println("5. 뭐..소주 한짝 딱 혼자 먹으면 좀 먹었다~할거같아요");
		System.out.println();
		System.out.print("선택 >> ");
	}

	public void vilaques3() {
		System.out.println("가현) 아이 뭐에요 ㅎㅎ감사합니다(심쿵)");
		System.out.println();
		System.out.println("#영화관에 도착해 영화 선정중");
		System.out.println();
		System.out.println("가현) 저희 어떤 장르로 영화 예매할까요?");
		System.out.println();
		System.out.println("1.로맨스\t 2.공포/스릴러\t 3.SF\t 4.애니매이션");
		System.out.println("5.느와르\t 6.애니매이션");
		System.out.println();
		System.out.print("선택 >>");

	}

	public int checkSownApart() { // 아파트 보유중인지 확인

		int sown = 0;

		String sql = "SELECT sown FROM storetbl WHERE sid = '포레나'";

		try {
			stmt = con.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				sown = rs.getInt(1); // 신기하네

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return sown;

	}

	public int checkSownVila() { // LifeGameDTO character

		int sown = 0;

		String sql = "SELECT sown FROM storetbl WHERE sid = '그린빌라'";

		try {
			stmt = con.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				sown = rs.getInt(1); // 신기하네

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return sown;

	}

	public int checkSownOneroom() { // LifeGameDTO character

		int sown = 0;

		String sql = "SELECT sown FROM storetbl WHERE sid = '하우올리PM'";

		try {
			stmt = con.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				sown = rs.getInt(1); // 신기하네

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return sown;

	}

	// sown 보유 메소드
	public int StoreSownCheck(StoreDTO store) { // 판매할 상품이 보유중인지 확인

		int sown = 0;

		String sql = "SELECT sown FROM storetbl WHERE sid = ?";

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, store.getsId());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				sown = rs.getInt(1); // select 값이 sown에 들어간다

			}

		} catch (SQLException e) {

		}
		return sown;

	}

	// 구매자 자산 체크
	public int StoreCDTOCheckbalance(StoreDTO store) {
		int balance = 0;

		String sql = "select balance from cdto where mid=?";

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, store.getMid());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				balance = rs.getInt(1);
			}

		} catch (SQLException e) {

		}

		return balance;
	}
	
	// 구매자 자산 체크 2 == mid 필요 없는 버전
		public int StoreCDTOCheckbalance2() {
			int balance = 0;

			String sql = "select balance from cdto";

			try {
				stmt = con.createStatement();

				rs = stmt.executeQuery(sql);

				while (rs.next()) {
					balance = rs.getInt(1);
				}

			} catch (SQLException e) {

			}

			return balance;
		}

	// 판매하는 가격 체크
	public int StoreCheckSprice(StoreDTO store) {

		int Sprice = 0;

		String sql = "select sprice from storetbl where sid=?";

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, store.getsId());

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Sprice = rs.getInt(1);
			}

		} catch (SQLException e) {

		}
		return Sprice;
	}

	// 판매가능한 상품 목록
	public void StoreSellList(StoreDTO store) {
		String sql = "select * from storetbl where sown>=1";

		try {

			stmt = con.createStatement();
			// pstmt=con.prepareStatement(sql);

			rs = stmt.executeQuery(sql);

			while (rs.next()) { // 데이터(레코드)가 존재할때까지 반복
				
				System.out.println("보유한 상품 목록");
				System.out.println("==================================================");
				System.out.println("브랜드: " + rs.getString(1));
				System.out.println("상품정보 : " + rs.getString(2));
				System.out.println("상품종류 : " + rs.getString(3));
				System.out.println("가격 : " + rs.getInt(4));
				System.out.println("보유 수 : " + rs.getInt(5));
				System.out.println("==================================================");
			
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int StoreSellpotential() {
		int sown = 0;
		String sql = "select sown from storetbl where sown>=1";

		try {
			stmt = con.createStatement();

			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				sown = rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sown;

	}

	// drop Cdto 메소드
	public void dropCdto() {

		String sql = "drop TABLE cdto";

		try {

			stmt = con.createStatement();

			boolean result = stmt.execute(sql);

		} catch (SQLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
	}

	// create 테이블 cdto
	public void createCdto() {

		String sql = "CREATE TABLE cdto (mid NVARCHAR2(20) PRIMARY KEY, balance NUMBER, property NUMBER, health NUMBER, happy NUMBER)";

		try {

			stmt = con.createStatement();

			boolean result = stmt.execute(sql);

		} catch (SQLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

	}
	// 엔딩 메소드
	public boolean badEndingsBool() {

		boolean dead = false;

		String sql = "SELECT property FROM cdto";

		try {
			stmt = con.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int property = rs.getInt(1); // 신기하네
				if (property < 0) {
					System.out.println();
					System.out.println("당신은 파산하셨습니다...");
					System.out.println("주위의 압박과 파산의 충격에서 버티지 못하고 자살을 선택합니다......");
					dead = true;
				}
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		String sql1 = "SELECT happy FROM cdto";

		try {
			stmt = con.createStatement();

			rs = stmt.executeQuery(sql1);

			while (rs.next()) {
				int happy = rs.getInt(1); // 신기하네
				if (happy <= -200) {
					System.out.println();
					System.out.println("당신은 삶에서 행복을 느끼지 못합니다...");
					System.out.println("인생의 허망함을 느끼고 자살을 선택합니다......");
					dead = true;
				}
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		String sql2 = "SELECT health FROM cdto";

		try {
			stmt = con.createStatement();

			rs = stmt.executeQuery(sql2);

			while (rs.next()) {
				int health = rs.getInt(1); // 신기하네
				if (health <= -200) {
					System.out.println();
					System.out.println("당신의 몸은 만신창이가 되어 더 이상 움직일 수 없게 되었습니다...");
					System.out.println("병상에서 당신은 절망하여 스스로 호흡기를 떼어냅니다......");
					dead = true;
				}
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return dead;

	}
	
	public void game() {
	    System.out.println("      ♥♥♥♥♥♥♥♥♥♥♥       ♣♣♣♣♣♣♣♣♣      ♠♠♠         ♠♠♠   ◆◆◆◆◆◆◆◆◆◆◆◆◆                         ");
	    System.out.println("     ♥♥♥♥♥♥♥♥♥♥♥♥      ♣♣♣     ♣♣♣     ♠♠♠♠       ♠♠♠♠   ◆◆◆◆◆◆◆◆◆◆◆◆◆                     ");
	    System.out.println("    ♥♥♥               ♣♣♣       ♣♣♣    ♠♠♠♠♠     ♠♠♠♠♠   ◆◆◆                       ");
	    System.out.println("    ♥♥♥              ♣♣♣♣       ♣♣♣♣   ♠♠♠♠♠♠   ♠♠♠♠♠♠   ◆◆◆                     ");
	    System.out.println("    ♥♥♥     ♥♥♥♥♥♥   ♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣   ♠♠♠  ♠♠♠♠♠  ♠♠♠   ◆◆◆◆◆◆◆◆◆◆◆◆◆                       ");
	    System.out.println("    ♥♥♥     ♥♥♥♥♥♥   ♣♣♣♣♣♣♣♣♣♣♣♣♣♣♣   ♠♠♠   ♠♠♠   ♠♠♠   ◆◆◆                           ");
	    System.out.println("    ♥♥♥        ♥♥♥   ♣♣♣♣       ♣♣♣♣   ♠♠♠         ♠♠♠   ◆◆◆                           ");
	    System.out.println("     ♥♥♥♥♥♥♥♥♥♥♥♥    ♣♣♣♣       ♣♣♣♣   ♠♠♠         ♠♠♠   ◆◆◆◆◆◆◆◆◆◆◆◆◆                   ");
	    System.out.println("      ♥♥♥♥♥♥♥♥♥♥     ♣♣♣♣       ♣♣♣♣   ♠♠♠         ♠♠♠   ◆◆◆◆◆◆◆◆◆◆◆◆◆                   ");
	}
	
	public void love() {
		System.out.println(" ◆◆               ♥♥♥♥♥♥♥♥      ♣♣♣♣     ♣♣♣♣   ♠♠♠♠♠♠♠♠♠♠♠♠♠                ");
		System.out.println(" ◆◆              ♥♥♥♥♥♥♥♥♥♥     ♣♣♣♣     ♣♣♣♣   ♠♠♠♠♠♠♠♠♠♠♠♠♠                   ");
		System.out.println(" ◆◆            ♥♥♥        ♥♥♥   ♣♣♣♣     ♣♣♣♣   ♠♠                          ");
		System.out.println(" ◆◆            ♥♥♥        ♥♥♥   ♣♣♣♣     ♣♣♣♣   ♠♠                       ");
		System.out.println(" ◆◆            ♥♥♥        ♥♥♥    ♣♣♣♣   ♣♣♣♣    ♠♠♠♠♠♠♠♠♠♠♠♠♠                        ");
		System.out.println(" ◆◆            ♥♥♥        ♥♥♥     ♣♣♣   ♣♣♣     ♠♠                        ");
		System.out.println(" ◆◆            ♥♥♥        ♥♥♥      ♣♣♣♣♣♣♣      ♠♠                      ");
		System.out.println(" ◆◆◆◆◆◆◆◆◆◆   ♥♥♥♥♥♥♥♥♥♥♥         ♣♣♣♣♣       ♠♠♠♠♠♠♠♠♠♠♠♠♠                         ");
		System.out.println(" ◆◆◆◆◆◆◆◆◆◆    ♥♥♥♥♥♥♥♥♥           ♣♣♣        ♠♠♠♠♠♠♠♠♠♠♠♠♠             ");
		
		}
		public void life() {
			System.out.println("♠♠            ◆◆◆◆◆◆◆◆       ♣♣♣♣♣♣♣♣♣♣♣       ♥♥♥♥♥♥♥♥♥♥♥♥♥        									         ");
			System.out.println("♠♠            ◆◆◆◆◆◆◆◆       ♣♣♣♣♣♣♣♣♣♣♣       ♥♥♥♥♥♥♥♥♥♥♥♥♥                                  ");
			System.out.println("♠♠                ◆◆           ♣♣                ♥♥                     					 ");
			System.out.println("♠♠                ◆◆           ♣♣                ♥♥                                             ");
			System.out.println("♠♠                ◆◆           ♣♣♣♣♣♣♣♣♣♣♣       ♥♥♥♥♥♥♥♥♥♥♥♥♥                                   ");
			System.out.println("♠♠                ◆◆           ♣♣♣♣♣♣♣♣♣♣♣       ♥♥                                        ");
			System.out.println("♠♠                ◆◆           ♣♣                ♥♥                                        ");
			System.out.println("♠♠♠♠♠♠♠♠♠     ◆◆◆◆◆◆◆◆       ♣♣                ♥♥♥♥♥♥♥♥♥♥♥♥♥                           ");
			System.out.println("♠♠♠♠♠♠♠♠♠     ◆◆◆◆◆◆◆◆       ♣♣                ♥♥♥♥♥♥♥♥♥♥♥♥♥                              ");
			
		}
		public void dead() {
			System.out.println("■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ");
			System.out.println("■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■");
			System.out.println("■ ■        ■■     ■■        ■ ■");
			System.out.println("■ ■      ■■         ■■      ■ ■ ");
			System.out.println("■ ■    ■■   ■■■■■■■   ■■    ■ ■");
			System.out.println("■ ■  ■■    ■       ■    ■■  ■ ■");
			System.out.println("■ ■■■     ■  ●   ●  ■     ■■■ ■");
			System.out.println("■ ■        ■       ■        ■ ■");
			System.out.println("■ ■       ■         ■       ■ ■");
			System.out.println("■ ■      ■           ■      ■ ■");
			System.out.println("■ ■     ■             ■     ■ ■");
			System.out.println("■ ■    ■               ■    ■ ■");
			System.out.println("■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■");
			System.out.println("■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■");
		}
		
		public void success() {
			System.out.println("    ♥♥♥♥♥♥♥♥♥♥     ♣♣♣        ♣♣♣     ♠♠♠♠♠♠♠♠♠♠♠♠♠    ♠♠♠♠♠♠♠♠♠♠♠♠♠    ◆◆◆◆◆◆◆◆◆◆◆◆◆      ♥♥♥♥♥♥♥♥♥♥       ♥♥♥♥♥♥♥♥♥♥                                   ");
			System.out.println("   ♥♥♥♥♥♥♥♥♥♥♥♥    ♣♣♣        ♣♣♣    ♠♠♠♠♠♠♠♠♠♠♠♠♠♠   ♠♠♠♠♠♠♠♠♠♠♠♠♠♠    ◆◆◆◆◆◆◆◆◆◆◆◆◆     ♥♥♥♥♥♥♥♥♥♥♥♥     ♥♥♥♥♥♥♥♥♥♥♥♥                            ");
			System.out.println("  ♥♥               ♣♣♣        ♣♣♣    ♠♠♠♠             ♠♠♠♠              ◆◆◆                 ♥♥               ♥♥  	                                          ");
			System.out.println("  ♥♥               ♣♣♣        ♣♣♣    ♠♠♠♠             ♠♠♠♠              ◆◆◆                 ♥♥               ♥♥                                          ");
			System.out.println("   ♥♥♥♥♥♥♥♥♥♥♥♥    ♣♣♣ 	      ♣♣♣    ♠♠♠♠             ♠♠♠♠              ◆◆◆◆◆◆◆◆◆◆◆◆◆     ♥♥♥♥♥♥♥♥♥♥♥♥     ♥♥♥♥♥♥♥♥♥♥♥♥                                     ");
			System.out.println("              ♥♥   ♣♣♣        ♣♣♣    ♠♠♠♠             ♠♠♠♠              ◆◆◆                           ♥♥                ♥♥                                         ");
			System.out.println("    	      ♥♥   ♣♣♣        ♣♣♣    ♠♠♠♠             ♠♠♠♠              ◆◆◆                           ♥♥                ♥♥                                         ");
			System.out.println("   ♥♥♥♥♥♥♥♥♥♥♥♥     ♣♣♣♣♣♣♣♣♣♣♣♣     ♠♠♠♠♠♠♠♠♠♠♠♠♠♠   ♠♠♠♠♠♠♠♠♠♠♠♠♠♠    ◆◆◆◆◆◆◆◆◆◆◆◆◆     ♥♥♥♥♥♥♥♥♥♥♥♥     ♥♥♥♥♥♥♥♥♥♥♥♥                                        ");
			System.out.println("    ♥♥♥♥♥♥♥♥♥♥       ♣♣♣♣♣♣♣♣♣♣       ♠♠♠♠♠♠♠♠♠♠♠♠♠    ♠♠♠♠♠♠♠♠♠♠♠♠♠    ◆◆◆◆◆◆◆◆◆◆◆◆◆      ♥♥♥♥♥♥♥♥♥♥       ♥♥♥♥♥♥♥♥♥♥♥                                            ");
		}
		
		public boolean goodEndingsBool() {

			boolean life = false;

			String sql = "SELECT property FROM cdto";

			try {
				stmt = con.createStatement();

				rs = stmt.executeQuery(sql);

				while (rs.next()) {
					int property = rs.getInt(1); // 신기하네
					if (property > 2000000000) {
						System.out.println();
						System.out.println();
						System.out.println("         $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$                        ");
						System.out.println("          $$$$$$$    $$$$    $$$$$$$$$$$$$$$$$$$$$$$$$$                $$$$$$  $$$$$$$$                       ");
						System.out.println("           $$$$$$    $$$$    $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$    $$$$$$$$$$$$  $$$$$$$$$                      ");
						System.out.println("            $$$$$            $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$   $$   $$$$$$$$$$  $$$$$$$$$$                     ");
						System.out.println("            $$$$$    $$$$    $$$$$$$$$$$$$$$$$$$$$$$$$$$$$   $$$$    $$$$$$$$      $$$$$$$                     ");
						System.out.println("            $$$$$    $$$$    $$$$$$$$$$$$$$$$$$$$$$$$$$$$   $$$$$$   $$$$$$$$  $$$$$$$$$$                     ");
						System.out.println("           $$$$$$    $$$$    $$$$$$$$$$$$$$$$$$$$$$$$$$$   $$$$$$$$   $$$$$$$  $$$$$$$$$                      ");
						System.out.println("          $$$$$$$            $$$$$$$$$$$$$$$$$$$$$$$$$$   $$$$$$$$$$   $$$$$$  $$$$$$$$                        ");
						System.out.println("         $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  $$$$$$$                        ");
						System.out.println("         $$$$                    $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$  $$$$$$$                         ");
						System.out.println("          $$$$$$$$$$$$   $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$                        ");
						System.out.println("           $$$$$$$$$$$   $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$                       ");
						System.out.println("            $$$$$$$$$$   $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$                     ");
						System.out.println("             $$$$$$$$$   $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$                ");
						System.out.println("              $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$             ");
						System.out.println("               $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
						life = true;
					}
				}

			} catch (SQLException e) {

				e.printStackTrace();

			}

			String sql1 = "SELECT happy FROM cdto";

			try {
				stmt = con.createStatement();

				rs = stmt.executeQuery(sql1);

				while (rs.next()) {
					int happy = rs.getInt(1); // 신기하네
					if (happy >= 200) {
						System.out.println();
						System.out.println("        ●●●●●●             ●●●●●●●                  ");
						System.out.println("       ●●    ●●           ●●     ●●              ");
						System.out.println("      ●●      ●●         ●●       ●●              ");
						System.out.println("                                               ");
						System.out.println("                                                 ");
						System.out.println("        ●●●●●●●●●●●●●●●●●●●●●●●●●●             ");
						System.out.println("         ●●                     ●●                ");
						System.out.println("          ●●   I'm Happy !!!!  ●●                 ");
						System.out.println("           ●●                 ●●                  ");
						System.out.println("            ●●●●●●●●●●●●●●●●●●●                                   ");
					
						life = true;
					}
				}

			} catch (SQLException e) {

				e.printStackTrace();

			}

			
			return life;

		}
		
		//sown = 0
		public void oneSown() {
					
			String sql = "UPDATE storetbl SET sown = 1";
					
			try {
				
				stmt = con.createStatement();
				
				int result = stmt.executeUpdate(sql);
				
			} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
			}
					
					
		}
	

};