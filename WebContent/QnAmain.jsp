<%@page import="java.util.ArrayList"%>
<%@page import="board.QnADB"%>
<%@page import="board.QnAVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- QnA 게시판이 브라우저에 출력되기 위한 jsp, crud 기능중 read, update메서드에 해당되는 페이지 -->
    <%
  	//클래스로부터 객체 생성을 위해 new 연산자 사용. 객체를 생성시킨 후, 객체의 주소 db 주소를 리턴하도록 설정
		QnADB db = new QnADB();    
  	//QnAVO의 ArrayList 불러와서 db내 list값이 들어간 list변수 선언
		ArrayList<QnAVO> list = db.list();
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>자주 찾는 질문<br></h2>
	<h3>고객분들께서 자주 하시는 질문을 모았습니다.</h3>
	<hr color="grey"><br>
	<table border="1">
	<tr>
		<td width="100">번호</td>
		<td width="100">구분</td>
		<td width="400">제목</td>
		<td width="100">조회수</td>
	</tr>
	<%
	//for문을 사용, 데이터베이스안 list에 들어간 값 만큼 반복하여 출력
	//출력된 값을 bag2 선언하여 다시 저장
		for (int i = 0; i < list.size(); i++) {
		QnAVO bag2 = list.get(i);
	%>
	<tr>
		<!-- bag2에 저장된 값들을 get문 사용하여 브라우저로 출력 -->
		<td><%= bag2.getNo() %> </td>
		<td><%= bag2.getType() %></td>
		<!-- a 태그 안 href 사용하여 제목을 클릭할 경우 QnAread 페이지로 이동할 수 있도록 설정 -->
		<td><a href="QnAread.jsp?no=<%= bag2.getNo() %>"> <%= bag2.getTitle() %> </a></td>
		<td><%= bag2.getViews() %></td>
	</tr>
	<% } %>
	</table> 
</body>
</html>