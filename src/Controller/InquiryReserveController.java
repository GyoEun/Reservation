package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistance.reservationDAO;
import persistance.reservationDTO;

@WebServlet("/inquiry")
public class InquiryReserveController extends HttpServlet {
	
	private reservationDAO reserveDAO = new reservationDAO();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ArrayList<reservationDTO> reserveDto;		
		reserveDto = reserveDAO.InquiryReserve();
		
//		for(reservationDTO dto:reserveDto) {
//			System.out.printf("%s | %s | %s | %s | %s | %s| %s\n", dto.getReservation_Start(),
//			dto.getReservation_End(), dto.getLodge_Facilities_ID(), dto.getHeadCount(),
//		    dto.getReservation_Name(), dto.getReservation_Phone_Number(),dto.getReservation_Date());
//		}		
		
		req.setAttribute("reservationDTO",reserveDto);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/InquiryReserveView.jsp");
		dispatcher.forward(req,resp);
//		dispatcher.forward(req, resp);
		
//		req.setAttribute("reservationDTO", dto);		
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/ReservationView.jsp");

//		dispatcher.include(req, resp);
//		dispatcher = req.getRequestDispatcher("/footer.jsp");
//		dispatcher.include(req, resp);
//		System.out.println("sendRedirect");
//		resp.sendRedirect("login.jsp");
	}

}
