<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="persistance.reservationDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form>
		<button class="btn" onclick="insertReserve()">등록</button>
		<input type="submit" value="삭제" />
		<button class="btn" onclick="updateReserve()">수정</button>
		
		<select id = 'selectBox'>
			<option>예약</option>
			<option>취소</option>
		</select>
	</form>
	
	<table width="700" border="3" bordercolor="lightgray" align="center">
		<thead>
			<tr>
            <td>All</td>
            <td>No</td>
            <td>예약시작</td>
            <td>예약종료</td>
            <td>시설명</td>
            <td>인원</td>
            <td>성함</td>
            <td>연락처</td>
            <td>예약시간</td>
        </tr>
		</thead>
		<%
			ArrayList<reservationDTO> list = (ArrayList<reservationDTO>) request.getAttribute("reservationDTO");
			if(list != null) {

			for (reservationDTO dto : list) {
				pageContext.setAttribute("dto", dto);	
		%>
			<tr>
				<td><input type="checkbox" name="reserveCheck"></td>
				<td><%="0"%></td>
				<td>${dto.getReservation_Start()}</td>
				<td>${dto.getReservation_End()}</td>
				<td>${dto.getLodge_Facilities_ID()}</td>
				<td>${dto.getHeadCount()}</td>
				<td>${dto.getReservation_Name()}</td>
				<td>${dto.getReservation_Phone_Number()}</td>
				<td>${dto.getReservation_Date()}</td>
			</tr>	
			<%}}%>		
	</table>
	<script>
	 function insertReserve(){
	        window.open("InsertReserveView.jsp","insert","width=400, height=400, left=300, top=300");
	    }
	 
	 function updateReserve(){
	        window.open("UpdateReserveView.jsp","update","width=400, height=400, left=300, top=300");
	    }
	</script>
	
</body>
</html>