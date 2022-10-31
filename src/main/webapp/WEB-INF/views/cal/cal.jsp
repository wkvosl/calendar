<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.Calendar"%>
    
   <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>달력</title>
<link rel="stylesheet" type="text/css" href="/css/cal.css"/>
</head>
<body>

	<c:set var="year" value="${param.year }" scope="session"/>
	<c:set var="month" value="${param.month }" scope="session"/>
	<c:set var="day" value="${param.day }" scope="session"/>
	
	<a href="../home">홈으로</a> <h2>달력</h2>
	
	<form action="/cal/cal" method="post">
		<input type="number" name="year" value="${not empty year?year:'' }" maxlength="4" required="required" placeholder="년도 4자리 입력">
		<select name="month">
			<c:forEach var="i" begin="1" end="12">
				<option value="${i }" ${ month==i ?"selected":""}>${i }월</option>
			</c:forEach>
		</select>
		<input type="submit" value="확인">
		<input type="button" onclick="location.href='/cal/cal'" value="초기화">
	</form>
	
	
	<c:if test="${empty year}">
		<%
			Calendar emptyDate = Calendar.getInstance();
			int whenEmptyYear = emptyDate.get(Calendar.YEAR);
			int whenEmptyMonth = emptyDate.get(Calendar.MONTH)+1;
			int whenEmptyDay = emptyDate.get(Calendar.DAY_OF_MONTH);
			emptyDate.set(whenEmptyYear,whenEmptyMonth-1,1);
			int whenEmptyLastDay = emptyDate.getActualMaximum(Calendar.DATE);
			int whenEmptyStartDayofWeek = emptyDate.get(Calendar.DAY_OF_WEEK);
		%>
		<h3><%=whenEmptyYear %>년 <%=whenEmptyMonth %>월 <%=whenEmptyDay %>일</h3>

		<%
			if((whenEmptyLastDay > 28) && (whenEmptyMonth == 2)){
		%>
			<h5>윤년입니다.</h5>
		<%		
			}
		%>
		
		<table border="1">
			<tr>
				<th>일</th>
				<th>월</th>
				<th>화</th>
				<th>수</th>
				<th>목</th>
				<th>금</th>
				<th>토</th>
			</tr>
			<tr>
				<c:forEach var="i" begin="1" end="<%=whenEmptyStartDayofWeek-1 %>">
					<td></td>
				</c:forEach>
				
				<c:set var="count" value="<%=whenEmptyStartDayofWeek %>"/>
				<c:forEach var="j" begin="1" end="<%=whenEmptyLastDay %>">
					<td><a href="/cal/cal_memo?year=<%=whenEmptyYear%>&month=<%=whenEmptyMonth%>&day=${j }">${j }</a></td>
						<c:if test="${count % 7 == 0 }">
							<tr></tr>
						</c:if>
					<c:set var="count" value="${count+1 }"/> 
				</c:forEach>
			</tr>
		</table>
	</c:if>
	
	
	<c:if test="${not empty year}" >
		<h3>${year}년 ${month}월 ${day }일</h3>
		
		<c:if test="${(lastDay > 28) && (month == 2)}">
			<h5>윤년입니다.</h5>
		</c:if>
		
		<table border="1">
			<tr>
				<th>일</th>
				<th>월</th>
				<th>화</th>
				<th>수</th>
				<th>목</th>
				<th>금</th>
				<th>토</th>
			</tr>
			<tr>
				<c:forEach var="i" begin="1" end="${startDayofWeek-1 }">
					<td></td>
				</c:forEach>
				
				<c:set var="count" value="${startDayofWeek}"/>
				<c:forEach var="j" begin="1" end="${lastDay }">
					<td><a href="/cal/cal_memo?year=${year }&month=${month}&day=${j }" >${j }</a></td>
						<c:if test="${count % 7 == 0 }">
							<tr></tr>
						</c:if>
					<c:set var="count" value="${count+1 }"/> 
				</c:forEach>
			</tr>
		</table>
	</c:if>

</body>
</html>