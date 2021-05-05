<%@page import="board.EmailDB"%>
<%@page import="board.EmailVO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	//브라우저 emailcreate 페이지에서 입력하여 전송된 데이터를 받아야 한다.
    	//매개변수 get.Parameter사용하여 각 변수들의 값을 찾아 읽어온다.
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String tel = request.getParameter("tel");
        String email = request.getParameter("email");
        String type = request.getParameter("type");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
       	//입력받은 데이터 저장을 위한 bag 생성
        EmailVO bag = new EmailVO();
       	
        //set메서드 사용하여 각각의 브라우저에서 입력받은 데이터들을 bag에 저장           		
        bag.setId(id);
        bag.setName(name);
        bag.setTel(tel);
        bag.setEmail(email);
        bag.setType(type);
        bag.setTitle(title);
        bag.setContent(content);
                
        //클래스로부터 객체 생성을 위해 new 연산자 사용. 객체를 생성시킨 후, 객체의 주소 db 주소를 리턴하도록 설정
        EmailDB db = new EmailDB();
        //db내, create메서드안 bag을 저장 
        db.create(bag);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 브라우저에서 입력된 값들을 bag에서 가져와출력 -->	
Tel&nbsp;&nbsp; <%= bag.getTel() %><br><br>
Email&nbsp;&nbsp; <%= bag.getEmail() %><br><br>
Type&nbsp;&nbsp; <%= bag.getType() %><br><br>
Title&nbsp;&nbsp; <%= bag.getTitle() %><br><br>
Content&nbsp;&nbsp; <%= bag.getContent() %><br><br>
<!-- 브라우저에서 입력된 값들을 bag에서 가져와출력 -->
<!-- href(hypertext reference)사용, a태그 안 요소를 눌렀을 때 HTML의 이름에 맞게 각각에 입력된 페이지로 이동  -->	
	<a href="emailcreate.jsp"><button type="button">게시글 등록</button></a>&nbsp;&nbsp;
	<a href="emailread.jsp"><button type="button">게시글 검색</button></a>&nbsp;&nbsp;
	<a href="emailupdate.jsp"><button type="button">게시글 수정</button></a>&nbsp;&nbsp;
	<a href="emaildelete.jsp"><button type="button">게시글 삭제</button></a>&nbsp;&nbsp;
</body>
</html>