<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 이메일 문의 게시판이 브라우저에 출력되기 위한 jsp, crud 기능중 update메서드에 해당되는 페이지 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>게시글 수정 화면입니다.</h2>
      <hr color="red">
		<!-- form태그는 값을 입력하고 싶을 때 사용, 입력값들은 모두 form들어가야 한다.-->
		<!-- action: 입력값을 받아서 처리하는 다음 페이지를 지정 -->
       <form action="emailconnect3.jsp">
       	연&nbsp;&nbsp;락&nbsp;&nbsp;처&nbsp;&nbsp; <input name="tel">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       	이&nbsp;&nbsp;메&nbsp;&nbsp;일&nbsp;&nbsp; <input name="email"><br>
		 <br>
		 <hr>
		문의유형&nbsp;
		<!-- 문의유형은 주어진 항목 중 선택할 수 있도록 radio 타입으로 설정 -->
		 <input type="radio" value="문의" name="type">문의
		 <input type="radio" value="불만" name="type">불만
		 <input type="radio" value="칭찬" name="type">칭찬
		 <input type="radio" value="제안" name="type">제안<br><br>
       	제&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목&nbsp;&nbsp; <input name="title"><br><br>
       	내&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;용&nbsp;&nbsp;
       	<textarea rows="10" cols="100" name="content"></textarea>
		<br>	
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button>수정하기</button>
       </form>
</body>
</html>