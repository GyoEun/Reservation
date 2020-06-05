package persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import sun.security.util.math.intpoly.IntegerPolynomial;

public class reservationDAO {
	private DataSource ds;

	public reservationDAO() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MySQL");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 예약 정보 조회
	public ArrayList<reservationDTO> InquiryReserve() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "select * from reservation where isCancel = '0'"; // 예약정보
		//String sql = "select * from reservation";
		ArrayList<reservationDTO> articles = new ArrayList<reservationDTO>();
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				String reserveID = rs.getString("Reservation_ID");
				String lodgeFacilitiesID = rs.getString("Lodge_Facilities_ID");
				String reserveName = rs.getString("Reservation_Name");
				String reservePnum = rs.getString("Reservation_Phone_Number");
				String HeadCount = rs.getString("HeadCount");
				String reserveDate = rs.getString("Reservation_Date");
				String reserveStart = rs.getString("Reservation_Start");
				String reserveEnd = rs.getString("Reservation_End");
				String isCancel = rs.getString("isCancel");
				String carNum = rs.getString("Car_Num");
				String carName = rs.getString("Car_Name");

				reservationDTO dto = new reservationDTO(reserveID,lodgeFacilitiesID, reserveName, reservePnum,
						HeadCount, reserveDate, reserveStart, reserveEnd,carNum,carName,isCancel);
				articles.add(dto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return articles;
	}

	public void InsertReserve(reservationDTO dto) {
		   Connection conn= null;
	        PreparedStatement pst = null;
	        String sql = "INSERT INTO reservation(`Reservation_ID`, `Lodge_Facilities_ID`,`Reservation_Name`,`Reservation_Phone_Number`,"
	        		+ "`Headcount`,`Reservation_Date`,`Reservation_Start`,`Reservation_End`,`isCancel`,`Car_Num`,`Car_Name`)"
	        		+ " VALUES(0,?,?,?,?,?,?,?,?,?,?)";
	        try{
	            conn = ds.getConnection();
	        }catch (SQLException e){
	            e.printStackTrace();
	        }
	        try{
	            pst = conn.prepareStatement(sql);
	            //pst.setString(0,dto.getReservation_ID());
	            pst.setString(1,dto.getLodge_Facilities_ID());
	            pst.setString(2,dto.getReservation_Name());
	            pst.setString(3,dto.getReservation_Phone_Number());
	            pst.setString(4,dto.getHeadCount());
	            pst.setString(5,dto.getReservation_Date());
	            pst.setString(6,dto.getReservation_Start());
	            pst.setString(7,dto.getReservation_End());
	            pst.setString(8,dto.getIsCancel());
	            pst.setString(9, dto.getCar_Num());
	            pst.setString(10,dto.getCar_Name());
     
	            pst.executeUpdate();
	        }catch (SQLException e){
	            e.printStackTrace();
	        }
	    }

	
	public void UpdateReserve(reservationDTO dto) {
		   Connection conn= null;
	        PreparedStatement pst = null;
	        String sql = "UPDATE  reservation SET `Reservation_ID` = ?,`Lodge_Facilities_ID` = ?,\r\n" + 
	        		"`Reservation_Name` = ?,`Reservation_Phone_Number` = ?,`Headcount` = ?,\r\n" + 
	        		"`Reservation_Date` = ?,`Reservation_Start` = ?,`Reservation_End` =?,\r\n" + 
	        		"`isCancel` = ?,`Car_Num` = ?,`Car_Name` = ?\r\n" + 
	        		"WHERE `Reservation_ID` = ?";
	        try{
	            conn = ds.getConnection();
	        }catch (SQLException e){
	            e.printStackTrace();
	        }
	        try{
	            pst = conn.prepareStatement(sql);
	            pst.setString(1,dto.getLodge_Facilities_ID());
	            pst.setString(2,dto.getReservation_Name());
	            pst.setString(3,dto.getReservation_Phone_Number());
	            pst.setString(4,dto.getHeadCount());
	            pst.setString(5,dto.getReservation_Date());
	            pst.setString(6,dto.getReservation_Start());
	            pst.setString(7,dto.getReservation_End());
	            pst.setString(8,dto.getIsCancel());
	            pst.setString(9, dto.getCar_Num());
	            pst.setString(10,dto.getCar_Name());
  
	            pst.executeUpdate();
	        }catch (SQLException e){
	            e.printStackTrace();
	        }
	    }

	
}