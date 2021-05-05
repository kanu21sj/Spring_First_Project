<%@page import="board.MemberVO"%>
<%@page import="board.MemberDB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 이메일 문의 게시판이 브라우저에 출력되기 위한 jsp, crud 기능중 delete메서드에 해당되는 페이지 -->
<%
	//회원가입 데이터에서 객체 속성 중 id를 가져오기 위해 session.getAttribute문 사용하여 id를 가져옴
	//getAttribute 문은 Object 리턴시 리턴받아올 값의 타입을 설정해주어야 함.가져올 값(id)의 타입은 string이므로 (string)추가
	//저장된 id를 가져오기 위한 DAO(MemberDB) db 선언
	//읽어온 id 값을 저장하기 위한 VO(MemberVO) bag 변수 선언
	String id = (String) session.getAttribute("id");
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
<h2>게시글 삭제</h2>
      <hr color="red">
		<!-- form태그는 값을 입력하고 싶을 때 사용, 입력값들은 모두 form들어가야 한다.-->
		<!-- action: 입력값을 받아서 처리하는 다음 페이지를 지정 -->
       <form action="emailconnect2.jsp">
       	아이디&nbsp;&nbsp; <input name="id">
       	<!-- 게시글삭제 버튼을 클릭하게 되면 emailconnect2 페이지로 연결 -->
       <button>게시글삭제</button>
       </form>
</body>
</html>