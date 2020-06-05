package Controller;

import java.io.IOException;
import java.util.Calendar;


import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistance.reservationDAO;
import persistance.reservationDTO;

@WebServlet("/update")
public class UpdateReserveController {
	private reservationDAO reserveDAO = new reservationDAO();
	
	DecimalFormat df = new DecimalFormat("00");
	Calendar currentCalendar = Calendar.getInstance(); 
	
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Reservation_ID = req.getParameter("reservationPnum");
    	String Lodge_Facilities_ID = req.getParameter("new_lodgeFacilitiesName");
    	 String Reservation_Name = req.getParameter("new_reservationName");
    	String Reservation_Phone_Number = req.getParameter("new_reservationPnum");
    	String count = req.getParameter("new_headCnt");
    	
    	String strYear = Integer.toString(currentCalendar.get(Calendar.YEAR));
    	String strMonth = df.format(currentCalendar.get(Calendar.MONTH) + 1);
    	String strDay = df.format(currentCalendar.get(Calendar.DATE));
    	String strDate = strYear + strMonth + strDay; 
    	String Reservation_Date= strDate;
    	String Reservation_Start=req.getParameter("new_start");
    	String Reservation_End = req.getParameter("new_end");
    	
    	String Car_Num = req.getParameter("new_carNum");
    	String Car_Name = req.getParameter("new_carName");
    	String isCancel = "0";
        
        reservationDTO dto = new reservationDTO(Reservation_ID,Lodge_Facilities_ID,Reservation_Name,
    			Reservation_Phone_Number,count,Reservation_Date,Reservation_Start,Reservation_End,
    			Car_Num,Car_Name,isCancel);
        
        reserveDAO.InsertReserve(dto);
    }
}
