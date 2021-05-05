<%@page import="board.MemberVO"%>
<%@page import="board.MemberDB"%>
<%@page import="board.EmailVO"%>
<%@page import="board.EmailDB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 이메일 문의 게시판이 브라우저에 출력되기 위한 jsp, crud 기능중 create메서드에 해당되는 페이지 -->
<%
	//회원가입 데이터에서 객체 속성 중 id를 가져오기 위해 session.getAttribute문 사용하여 id를 가져옴
	//getAttribute 문은 Object 리턴시 리턴받아올 값의 타입을 설정해주어야 함.
	//가져올 값(id)의 타입은 string이므로 (string)추가
	//저장된 id를 가져오기 위한 DAO(MemberDB) db 선언
	//읽어온 id 값을 저장하기 위한 VO(MemberVO) bag 변수 선언
	String id = (String)session.getAttribute("id");
	MemberDB db = new MemberDB();
	RuserVO bag = db.read(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p style="font-size: 30px;">이메일 문의</p>
	<p style="font-size: 20px;">불편사항이나 문의사항을 남겨주시면 신속하게 답변드리겠습니다.</p>
	<hr color="grey">
	<br>
	<!-- form태그는 값을 입력하고 싶을 때 사용, 입력값들은 모두 form들어가야 한다.-->
	<!-- action: 입력값을 받아서 처리하는 다음 페이지를 지정 -->
	<form action="emailconnect.jsp">
	
	<!-- id, name는 get문을 사용하여 MemberDB에서 가져온 값을 출력해줌   -->
		아&nbsp;&nbsp;이&nbsp;&nbsp;디&nbsp;&nbsp; <input name="id" value=<%=bag.getId()%>>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		이&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;름&nbsp;&nbsp; <input
			name="name" value=<%=bag.getName()%>><br> <br>
		연&nbsp;&nbsp;락&nbsp;&nbsp;처&nbsp;&nbsp; <input name="tel">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		이&nbsp;&nbsp;메&nbsp;&nbsp;일&nbsp;&nbsp; <input name="email"><br>
		<br>
		<hr color="grey">
		<!-- 문의유형은 주어진 항목 중 선택할 수 있도록 radio 타입으로 설정 -->
		문의유형&nbsp; <input type="radio" value="문의" name="type">문의 <input
			type="radio" value="불만" name="type">불만 <input type="radio"
			value="칭찬" name="type">칭찬 <input type="radio" value="제안"
			name="type">제안<br> <br>
		제&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목&nbsp;&nbsp; <input
			name="title"><br> <br>
		내&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;용&nbsp;&nbsp;
		<textarea rows="10" cols="100" name="content"></textarea>
		<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<!-- 등록하기 버튼을 클릭하게 되면 emailconnect 페이지로 연결 -->
		<button>등록하기</button>
	</form>
</body>
</html>