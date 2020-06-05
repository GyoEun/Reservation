<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ page import="persistance.reservationDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>예약 정보 수정</title>
</head>
<body>

<div>
    <form action="UpdateReserveController.java" method = "doGet">
        <label>예약인 성함 <input type="text" name="new_reservationName"></label>
        <br>
        <label>예약인 연락처<input type = "text" name = "new_reservationPnum"></label>
        <br>
     	<label>시설<input type = "text" name = "new_lodgeFacilitiesName"></label>
     	<label>예약인원<input type = "text" name = "new_headCnt"></label>
        <br>
     	<label>예약기간 <input type = "date" name = "start" value="2020-06-01"> ~ <input type = "date" name = "end"></label>
        
        <br>
    	<label>차량 <input type="text" name="new_carNum">
       	<input type = "text" name = "new_carName"></label>
        <br>
        <input type="submit" value="수정">
        <button onclick="self.close();">취소</button>
    </form>
</div>

</body>
</html>