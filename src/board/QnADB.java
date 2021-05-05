package board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
//영화보기 홈페이지에서 qna 게시판은 공지사항 또는 뉴스를 보여주기 위한 용도로 사용된다.
//qna 게시판 사용을 위한 데이터베이스에 접근을 위해 DAO(Data Access Object)생성
//생성된 QnADB가 어떠한 클래스에서도 접근 가능할 수 있도록 public 제어문 사용
public class QnADB {

	//QnAVO라는 bag이 담긴 ArrayList를 컴파일할때 예외를 발생시키지 않고 바로 진행
	//return되어야 하므로 void가 아닌 입력된 값을 가져와야 하므로 ArrayList<> 자리에 <QnAVO>가져옴
	public ArrayList<QnAVO> list() throws Exception { 

		// 전체 데이터를 담기 위한 list(컨테이너)생성
		ArrayList<QnAVO> list = new ArrayList<>();
		
	    //1. 커넥터 사용 설정
		  //데이터베이스 mySQL 사용하기 위한 커넥션 사용 연결
	    Class.forName("com.mysql.jdbc.Driver");
	    
	    //2. db연결
	      //디비 연결하여 데이터베이스를 사용할 준비 완료
	    	//?useUnicode=true&characterEncoding=utf8"; 한글 설정 해주기 위한 코드 추가
	    String url = "jdbc:mysql://localhost:3306/shop?useUnicode=true&characterEncoding=utf8";
	    //데이터베이스 연결하기 위한 url, id, 비밀번호 입력
	    Connection con = DriverManager.getConnection(url, "root", "1234");
	    
	    //3. SQL문 만들기
	      //SQL문을 만들어서 데이터가 들어있는 테이블에서 가져올 자료를 요청
	    String sql = "select * from qna";
	    //쿼리(sql) 실행하기 위한 PreparedStatement 객체 생성
	    PreparedStatement ps = con.prepareStatement(sql);
	    
	    //4. SQL문 mySQL서버로 전송
	    ResultSet rs = ps.executeQuery();
	    
	    //1. 검색결과 체크, 만약에 결과가 있으면 테이블에서 원하는 데이터 항목을 꺼내주면 된다.
	    //while문 사용하여 검색한 결과값(rs)이 하나씩 확인하여 체크, boolean(있으면 true, 없으면 false)
	    while (rs.next()) {
	    	
	    	//rs.next()로 호출된 값이 있을 경우 아래의 변수들에 대한 값들을 꺼내줌
	    	//꺼내주는 방법은 2가지, 1)항목명, 2)항목의 인덱스
	    	int no = rs.getInt(1); 
	    	String type = rs.getString(2); 
	    	String title = rs.getString(3); 
	    	String content = rs.getString(4); 
	    	int views = rs.getInt(5); 
	    	
	    	//bag을 만들어 호출된 값들을 QnAVO에 넣는다.
	    	QnAVO bag = new QnAVO();
			bag.setNo(no);
			bag.setType(type);
			bag.setTitle(title);
			bag.setContent(content);
			bag.setViews(views);
			
			//가방들을 넣어줄 컨테이너에 list를 생성하여 하나씩 넣어준다.
			list.add(bag);
		}
	    //bag이 들어간 list를 리턴받아 사용한다.
	    return list;
	}
	//게시글 수정 단계
	//update메소드 기능은 값을 입력을 받아 진행이 되는 단계이기 때문에 값이 void이고 int no위치에 따라 수정된 값들이 변경된다.
	//update메소드 컴파일할때 예외를 발생시키지 않고 바로 진행
	public void update(int no) throws Exception {
		
	    //1. 커넥터 사용
		  //데이터베이스 mySQL 사용하기 위한 커넥션 사용 연결
		Class.forName("com.mysql.jdbc.Driver");
		
		//2. db연결
	      //디비 연결하여 데이터베이스를 사용할 준비 완료
	    	//?useUnicode=true&characterEncoding=utf8"; 한글 설정 해주기 위한 코드 추가
		String url = "jdbc:mysql://localhost:3306/shop?useUnicode=true&characterEncoding=utf8";
		//데이터베이스 연결하기 위한 url, id, pw 입력
		Connection con = DriverManager.getConnection(url, "root", "1234");
		
	    //3. SQL문 만들기
	      //SQL문을 만들어서 데이터가 들어있는 테이블에서 가져올 자료를 요청
	    	//update문 사용하여  위해 데이터베이스내 해당 테이블에서 where문 사용하여 
			//수정할 값들의 위치를 확인하고 set문 사용하여 수정할 값들을 입력한 쿼리(sql)변수 생성
			//views(조회수)게시글 클릭당 1씩 조회수가 늘어나도록 설정
		String sql = "update qna set views = views + 1 where no = ?";
		//쿼리를 실행하기 위한 PreparedStatement 객체 생성
		PreparedStatement ps = con.prepareStatement(sql);
		
		//ps내 setString문 실행하여 입력받은 값을 지정
		ps.setInt(1, no);
		
	    //4. SQL문 mySQL서버로 전송
	      //3번 과정에서 생성된 쿼리를 실행하기 위해 mySQL서버로 전송
		ps.executeUpdate();
		
	}
	//게시글 검색하기 단계
	//read메소드 기능은 이미 저장된 값을 불러오는 단계이기 때문에 QnAVO에서 읽어올 값(id)를 넣어준다.
	//read메소드 컴파일할때 예외를 발생시키지 않고 바로 진행
	public QnAVO read(int no) throws Exception {
	    //1. 커넥터 사용  //데이터베이스 mySQL 사용하기 위한 커넥션 사용 연결
	    Class.forName("com.mysql.jdbc.Driver");
	    //2. db연결  //디비 연결하여 데이터베이스를 사용할 준비 완료
	    //?useUnicode=true&characterEncoding=utf8"; 한글 설정 해주기 위한 코드 추가
	    String url = "jdbc:mysql://localhost:3306/shop?useUnicode=true&characterEncoding=utf8";
	    //데이터베이스 연결하기 위한 url, id, pw 입력
	    Connection con = DriverManager.getConnection(url, "root", "1234");
	    //3. SQL문 만들기  //SQL문을 만들어서 데이터가 들어있는 테이블에서 가져올 자료를 요청
	    //select문을 사용하여 데이터베이스내 해당 테이블에서 where문으로 검색할 값의 위치를 확인하기 위한 쿼리 변수 선언
	    String sql = "select * from qna where no = ?";
	    //쿼리를 실행하기 위한 PreparedStatement 객체 생성
	    PreparedStatement ps = con.prepareStatement(sql);
	    //ps내 setString문 실행하여 입력받은 값을 위치에 맞게 저장
	    ps.setInt(1, no);
	    //4. SQL문 mySQL서버로 전송 //3번 과정에서 생성된 쿼리를 실행하기 위해 mySQL서버로 전송
	    ResultSet rs = ps.executeQuery();

	    //1. 검색결과 체크 //if문 사용하여 한 행씩 내려가서 검색한 결과값(rs)이 있는지 체크
	    QnAVO bag = new QnAVO();
	    if (rs.next()) {    	
	    	//2. 만약 결과가 있으면, 테이블에서 원하는 데이터 항목을 꺼내어 bag에 저장  //꺼내주는 방법은 2가지, 1)항목명, 2)항목의 인덱스
	    	int no1 = rs.getInt(1); 
	    	String type = rs.getString(2); 
	    	String title = rs.getString(3); 
	    	String content = rs.getString(4); 
	    	int views = rs.getInt(5); 
	    	//검색된 값들을 생성된 bag에 넣는다.
			bag.setNo(no1);
			bag.setType(type);
			bag.setTitle(title);
			bag.setContent(content);
			bag.setViews(views);;
		}
	    return bag; //bag을 리턴받아 사용한다.
	    
	}

}
