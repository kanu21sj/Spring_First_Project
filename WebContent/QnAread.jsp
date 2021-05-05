<%@page import="board.QnADB"%>
<%@page import="board.QnAVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- QnA 게시판이 브라우저에 출력되기 위한 jsp, crud 기능중 read메서드에 해당되는 페이지 -->
    <%
	//데이터베이스 칼럼 중 auto increment로 설정된 no 값을 가져오기 위하여 매개변수 get.Parameter 사용
	//no의 타입은 int이므로 변환시켜주기 위하여 Integer.parseInt문 사용
    	int no = Integer.parseInt(request.getParameter("no")); 
  	//클래스로부터 객체 생성을 위해 new 연산자 사용. 객체를 생성시킨 후, 객체의 주소 db 주소를 리턴하도록 설정
		QnADB db = new QnADB();
	//read메서드 사용하여 no를 읽은 값을 QnAVO bag 변수 선언하여 저장
		QnAVO bag = db.read(no);
	//db내, update메서드안 no를 저장 
		db.update(no);
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
	<table border="1">
	<tr>
	<!-- get문 사용하여 bag안의 type, title, content 값들을 출력 -->
		<td width="700"><%= bag.getType() %>&nbsp;&nbsp;<%= bag.getTitle()%></td>
	</tr>
	<tr>
		<td width="700" height="300"><%= bag.getContent() %></td>
	</tr>
	</table>
	<!-- a 태그 안 href 사용하여 제목을 클릭할 경우 QnAmain 페이지로 이동할 수 있도록 설정 -->
	<a href="QnAmain.jsp"><button type="button">뒤로가기</button></a>&nbsp;&nbsp;
</body>
</html>