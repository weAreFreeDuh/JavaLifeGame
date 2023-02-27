package LIFEGAME;

import java.sql.Connection;
 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class StoreSQL {
	
	// DB접속을 위한 변수 con 선언
		Connection con = null;

		// 쿼리문 전송을 위한 변수 stmt, pstmt 선언
		Statement stmt = null;
		
		PreparedStatement pstmt = null;
		// PreparedStatement : 쿼리문에서 '?'를 문자로 인식

		// 조회(select)결과를 저장하기 위한 변수 rs선언
		ResultSet rs = null;
	
	
	public void connect() {
			con = DBConnection.DBConnect();
		}	
		
	public void storeImformation() {
		String sql= "select * from storetbl ";
		
		try {

			stmt = con.createStatement();
			//pstmt = con.prepareStatement(sql);
			
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
	//외제차 목록 메소드
	public void FcarImfo() {
		String sql= "select * from storetbl where Stype = '외제차'";
		
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
	//집 목록 메소드
	public void houseImfo() {
			String sql= "select * from storetbl where Stype = '집'";
			
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
	//차 목록 메소드
	public void carImfo() {
		String sql= "select * from storetbl where Stype = '국산차'";
		
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
	//시계 목록 메소드
	public void watchImfo() {
		String sql= "select * from storetbl where Stype = '시계'";
		
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
	//지갑 목록 메소드
	public void walletImfo() {
		String sql= "select * from storetbl where Stype = '지갑'";
		
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
	//옷 목록 메소드
	public void CloImfo() {
		String sql= "select * from storetbl where Stype = '옷'";
		
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
	
	 //3. 구매 메소드
		public void buyStore(StoreDTO store) {
			// (1) sql문 작성
		String sql = "UPDATE cdto SET balance  = balance - (select sprice from storetbl where sid=?"
				+ ")\r\n"
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
			//swon +1 메소드
			String sql1="update storetbl set sown=sown+1 where sid=?";
			 
			try {
				pstmt = con.prepareStatement(sql1);
				
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
			String sql2="update cdto set happy = happy+(select uphappy from storetbl where sid =?)"
					+ "where cdto.mid =?";
			try {
				pstmt = con.prepareStatement(sql2);

				// (3) pstmt로 선언했을 경우 ?에 데이터 삽입
			
				pstmt.setString(1, store.getsId());
				pstmt.setString(2, store.getMid());
				
				// (4) 실행
				int result = pstmt.executeUpdate();

				// (5) 실행결과
				if (result > 0) {
					System.out.println("행복 성공!");
				} else {
					System.out.println("행복 실패!");
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
			String sql3 ="select happy,balance from cdto where mid=?";
			try {
				pstmt = con.prepareStatement(sql3);
//				stmt = con.createStatement();
				pstmt.setString(1, store.getMid());
				
				rs = pstmt.executeQuery();
						
				while(rs.next()) {
					int happy = rs.getInt(1); //신기하네
					int balance = rs.getInt(2);
					System.out.println("행복지수 : " + happy);
					System.out.println("자산 : " + balance);
					
				}
						
			} catch (SQLException e) {
				
					e.printStackTrace();
					
			}
			
			
		}//void buyStore

		// 판매 메소드
		public void sellStore(StoreDTO store) {
			String sql = "UPDATE cdto SET balance  = balance + (select sprice from storetbl where sid=? and sown>0"
					+ ")\r\n"
					+ "where cdto.mid =?";

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
						System.out.println("판매 성공");
					} else {
						System.out.println("구매 실패!");
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
				//swon +1 메소드
				String sql1="update storetbl set sown=sown-1 where sid=? and sown>0";
				 
				try {
					pstmt = con.prepareStatement(sql1);
					
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
				String sql2="update cdto set happy = happy-(select uphappy from storetbl where sid =?)"
						+ "where cdto.mid =?";
				try {
					pstmt = con.prepareStatement(sql2);
					
					pstmt.setString(1, store.getMid());

					// (3) pstmt로 선언했을 경우 ?에 데이터 삽입
				
					pstmt.setString(1, store.getsId());
					pstmt.setString(2, store.getMid());
					
					// (4) 실행
					int result = pstmt.executeUpdate();

					// (5) 실행결과
					if (result > 0) {
						System.out.println("행복 성공!");
					} else {
						System.out.println("행복 실패!");
					}
				}catch (SQLException e) {
					e.printStackTrace();
				}
				String sql3 ="select happy,balance from cdto where mid =? ";
				try {
					pstmt = con.prepareStatement(sql3);
//					stmt = con.createStatement();
					pstmt.setString(1, store.getMid());
					
					rs = pstmt.executeQuery();
							
					while(rs.next()) {
						int happy = rs.getInt(1); //신기하네
						int balance = rs.getInt(2);
						System.out.println("행복지수 : " + happy);
						System.out.println("자산 : " + balance);	
					}
				} catch (SQLException e) {
						e.printStackTrace();		
				}
				
		}//end sellstore
		
		//
		
}
