<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ page import="persistance.reservationDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">

<title>예약 정보 등록</title>
</head>
<body>

<div>
    <form action="insert">
        <label>예약인 성함 <input type="text" name="reservationName"></label>
        <br>
        <label>예약인 연락처<input type = "text" name = "reservationPnum"></label>
        <br>
     	<label>시설<input type = "text" name = "lodgeFacilitiesName"></label>
     	<label>예약인원<input type = "text" name = "headCnt"></label>
     	<br>
     	<label>예약기간 <input type = "date" name = "start" value="2020-06-01"> ~ <input type = "date" name = "end"></label>

        <br>
    	<label>차량 <input type="text" name="carNum">
       	<input type = "text" name = "carName"></label>
        <br>
        <input type="submit" value="등록" >
        <button onclick="self.close();">취소</button>
    </form>
</div>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js"></script> 
<script src="http://malsup.github.com/jquery.form.js"></script> 

  <script type="text/javascript">
window.opener.location.reload();
//window.close();
</script>

</body>
</html>