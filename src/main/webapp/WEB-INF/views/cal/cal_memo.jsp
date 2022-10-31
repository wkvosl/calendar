<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.Calendar"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    
    <c:set var="year" value="${param.year }" scope="session"/>
    <c:set var="month" value="${param.month }" scope="session"/>
    <c:set var="day" value="${param.day }" scope="session"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/cal.css"/>
</head>
<body>

<c:if test="${empty cal_member }">
	<div id="floatDiv_calmemo">
		<aside>
					<h4>${year }년 ${month }월 ${day }일 메모</h4>
				<form method="post" action="/cal/cal_memo_insert">
					<input type="hidden" name="memo_date" value="${year }${month}${day}">
					
						<input name="memo_title" value="${calcontent.memo_title }"><br>
						<textarea name="memo_write" inputmode="text">${calcontent.memo_write }</textarea><br>
					
					<button type="submit" >저장</button>&nbsp;
				</form>
		</aside>
	</div>
</c:if>


<c:if test="${not empty cal_member }">

	<div id="floatDiv_calmemo">
		
			<c:forEach var="calcontent" items="${cal_member }">
			
					<form method="post" action="/cal/cal_memo_update">
						
						
					<h4>${year }년 ${month }월 ${day }일 메모</h4>
				
						<input type="hidden" name="memo_date" value="${year }${month}${day}">
					
						<input type="hidden" name="memo_id" value="${calcontent.memo_id }">
						<input name="memo_title" value="${calcontent.memo_title }"><br>
						<textarea name="memo_write" inputmode="text">${calcontent.memo_write }</textarea><br>
					
					
						<button type="button" onclick="location.href='/cal/cal_memo_delete?memo_id=${calcontent.memo_id }'">삭제</button>
						<button type="submit" >수정</button>&nbsp;
					</form>
			</c:forEach>
	</div>
</c:if>

<jsp:include page="/cal/cal"/>

</body>
</html>