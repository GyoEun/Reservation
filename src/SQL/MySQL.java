package SQL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

@WebServlet("/")
public class MySQL extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String preInsert = "INSERT INTO reservation(`Reservation_ID`, `Lodge_Facilities_ID`,`Member_ID`,`Reservation_Name`,`Reservation_Phone_Number`,"
        		+ "`Headcount`,`Reservation_Date`,`Reservation_Start`,`Reservation_End`,`isCancel`,`Car_Num`,`Car_Name`)"
        		+ " VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost/sogongdo?characterEncoding=utf8&serverTimezone=UTC&useSSL=false";
        String user = "root";
        String pw = "1234";


        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,user,pw);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    }