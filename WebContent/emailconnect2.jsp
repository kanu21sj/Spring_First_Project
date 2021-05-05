<%@page import="board.MemberDB"%>
<%@page import="board.EmailDB"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	//브라우저 emaildelete 페이지에서 입력하여 전송된 데이터를 받아야 한다.
	//매개변수 get.Parameter사용하여 각 변수들의 값을 찾아 읽어온다.
	String id = request.getParameter("id");
            
    //클래스로부터 객체 생성을 위해 new 연산자 사용. 객체를 생성시킨 후, 객체의 주소 db, db2 주소를 리턴하도록 설정
    EmailDB db = new EmailDB();
    MemberDB db2 = new MemberDB();
    //db내, delete메서드안 id를 저장
    db.delete(id);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
게시글 삭제가 완료되었습니다.
<!-- href(hypertext reference)사용, a태그 안 요소를 눌렀을 때 HTML의 이름에 맞게 각각에 입력된 페이지로 이동  -->	
	<a href="emailcreate.jsp"><button type="button">게시글 등록</button></a>&nbsp;&nbsp;
	<a href="emailread.jsp"><button type="button">게시글 검색</button></a>&nbsp;&nbsp;
	<a href="emailupdate.jsp"><button type="button">게시글 수정</button></a>&nbsp;&nbsp;
	<a href="emaildelete.jsp"><button type="button">게시글 삭제</button></a>&nbsp;&nbsp;
</body>
</html>