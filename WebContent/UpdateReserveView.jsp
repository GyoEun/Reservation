<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ page import="persistance.reservationDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� ���� ����</title>
</head>
<body>

<div>
    <form action="UpdateReserveController.java" method = "doGet">
        <label>������ ���� <input type="text" name="new_reservationName"></label>
        <br>
        <label>������ ����ó<input type = "text" name = "new_reservationPnum"></label>
        <br>
     	<label>�ü�<input type = "text" name = "new_lodgeFacilitiesName"></label>
     	<label>�����ο�<input type = "text" name = "new_headCnt"></label>
        <br>
     	<label>����Ⱓ <input type = "date" name = "start" value="2020-06-01"> ~ <input type = "date" name = "end"></label>
        
        <br>
    	<label>���� <input type="text" name="new_carNum">
       	<input type = "text" name = "new_carName"></label>
        <br>
        <input type="submit" value="����">
        <button onclick="self.close();">���</button>
    </form>
</div>

</body>
</html>