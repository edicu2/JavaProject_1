package MyDiaryP;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;

public class DConnectDataBase {

	public static Connection makeConnection() {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String id = "DIARY";
		String password = "123456";
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 적재 성공");
			con = DriverManager.getConnection(url, id, password);
			System.out.println("데이터베이스 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다");
		} catch (SQLException e) {
			System.out.println("연결에 실패하였습니다.");
		}
		return con;
	}

	public int insertData(DJavaData j) {
		int result = 0;
		try {
			Connection con = makeConnection();
			String s = "INSERT INTO workplan values (?, ?)";
			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.setString(1, j.getDate());
			pstmt.setString(2, j.getMemo());
			result = pstmt.executeUpdate();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		return result;
	}
	
	
	public int updateData( String memo,int year, int month , int day ) {
		int result = 0;
		String sYear= Integer.toString(year);
		String sMonth= Integer.toString(month);
		String sDay= Integer.toString(day);
		String ymd = sYear+"-"+0+sMonth+"-"+0+sDay;
		try {
			Connection con = makeConnection();
			String s = "UPDATE workplan SET m_memo = ? where m_date=?";
			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.setString(1, memo);
			pstmt.setString(2, ymd);
			result = pstmt.executeUpdate();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		return result;
	} 
	

	public void search(String date, JLabel label) {
		int result = 0;
		DJavaData j = null;
		try {
			Connection con = makeConnection();
			String s = "SELECT * FROM workplan WHERE d_date= ?";
			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.setString(1, date);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				label.setText(rs.getString("m_memo"));
			}
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			//System.exit(0);
		}
		
	}
	
	

	public ArrayList<DJavaData> getAllData() {
		ArrayList<DJavaData> list = new ArrayList<>();
		DJavaData j = null;
		try {
			Connection con = makeConnection();
			String s = "SELECT * FROM workplan";
			PreparedStatement pstmt = con.prepareStatement(s);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				j = new DJavaData();
				j.setDate((rs.getString("m_date")));
				System.out.println(j.getDate());
				j.setMemo(rs.getString("m_memo"));
				list.add(j);
			}
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		}
		return list;
	}





	public static void main(String[] args)  {
		

	}

}