<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%@ page import="persistance.reservationDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">

<title>���� ���� ���</title>
</head>
<body>

<div>
    <form action="insert">
        <label>������ ���� <input type="text" name="reservationName"></label>
        <br>
        <label>������ ����ó<input type = "text" name = "reservationPnum"></label>
        <br>
     	<label>�ü�<input type = "text" name = "lodgeFacilitiesName"></label>
     	<label>�����ο�<input type = "text" name = "headCnt"></label>
     	<br>
     	<label>����Ⱓ <input type = "date" name = "start" value="2020-06-01"> ~ <input type = "date" name = "end"></label>

        <br>
    	<label>���� <input type="text" name="carNum">
       	<input type = "text" name = "carName"></label>
        <br>
        <input type="submit" value="���" >
        <button onclick="self.close();">���</button>
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