package Controller;

import persistance.reservationDAO;
import persistance.reservationDTO;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/insert")
public class InsertReserveController extends HttpServlet {
	private reservationDAO reserveDAO = new reservationDAO();
	
	DecimalFormat df = new DecimalFormat("00");
	Calendar currentCalendar = Calendar.getInstance(); 

	    @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        String Reservation_ID="0";
	    	String Lodge_Facilities_ID = req.getParameter("lodgeFacilitiesName");
	    	System.out.println("Lodge_Facilities_ID : " + Lodge_Facilities_ID);
	    	 String Reservation_Name = req.getParameter("reservationName");
	    	String Reservation_Phone_Number = req.getParameter("reservationPnum");
	    	String count = req.getParameter("headCnt");
	    	
	    	String strYear = Integer.toString(currentCalendar.get(Calendar.YEAR));
	    	String strMonth = df.format(currentCalendar.get(Calendar.MONTH) + 1);
	    	String strDay = df.format(currentCalendar.get(Calendar.DATE));
	    	String strDate = strYear + strMonth + strDay; 
	    	
	    	
	    	String Reservation_Date= strDate;
	    	String Reservation_Start=req.getParameter("start");
	    	String Reservation_End = req.getParameter("end");
	    	String Car_Num = req.getParameter("carNum");
	    	String Car_Name = req.getParameter("carName");
	    	String isCancel = "0";
	        
	        reservationDTO dto = new reservationDTO(Reservation_ID,Lodge_Facilities_ID,Reservation_Name,
	    			Reservation_Phone_Number,count,Reservation_Date,Reservation_Start,Reservation_End,
	    			Car_Num,Car_Name,isCancel);
	        
	        reserveDAO.InsertReserve(dto);
	        
	      
	      }
}

