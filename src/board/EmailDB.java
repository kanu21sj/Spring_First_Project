package board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
//영화보기 홈페이지에서 이메일 게시판은 고객의 문의글을 받아 저장하기 위한 용도로 사용된다.
//이메일 문의 게시판 사용을 위한 데이터베이스에 접근하기 위해 DAO(Data Access Object)생성
//생성된 EmailDB가 어떠한 클래스에서도 접근 가능할 수 있도록 public 제어문 사용
public class EmailDB {
	
	//EmailVO라는 bag이 담긴 ArrayList를 컴파일할때 예외를 발생시키지 않고 바로 진행
	//return되어야 하므로 void가 아닌 입력된 값을 가져와야 하므로 ArrayList<> 자리에 <EmailVO>가져옴
	public ArrayList<EmailVO> list() throws Exception {
		
		//전체 데이터를 담기 위한 list(컨테이너)생성
		ArrayList<EmailVO> list = new ArrayList<>(); 
		
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
	      //select문 사용하여 데이터가 들어있는 테이블에서 가져올 자료를 요청하는 쿼리(sql)선언
	    String sql = "select * from board";
	    //쿼리(sql) 실행하기 위한 PreparedStatement 객체 생성
	    PreparedStatement ps = con.prepareStatement(sql);
	    
	    //4. SQL문 mySQL서버로 전송
	    ResultSet rs = ps.executeQuery();
	    
	    //1. 검색결과 체크, 만약에 결과가 있으면 테이블에서 원하는 데이터 항목을 꺼내주면 된다.
	    //while문 사용하여 검색한 결과값(rs)이 하나씩 확인하여 체크, boolean(있으면 true, 없으면 false)
	    while (rs.next()) {
	    	
	    	//rs.next()로 호출된 값이 있을 경우 아래의 변수들에 대한 값들을 꺼내줌
	    	//꺼내주는 방법은 2가지, 1)항목명, 2)항목의 인덱스
	    	String id = rs.getString(1); 
	    	String name = rs.getString(2); 
	    	String tel = rs.getString(3); 
	    	String email = rs.getString(4); 
	    	String type = rs.getString(5); 
	    	String title = rs.getString(6); 
	    	String content = rs.getString(7); 
	    	
	    	//bag을 만들어 호출된 값들을 EmailVO에 넣는다.
	    	EmailVO bag = new EmailVO();
	    	
	    	bag.setId(id);
	    	bag.setName(name);
			bag.setTel(tel);
			bag.setEmail(email);
			bag.setType(type);;
			bag.setTitle(title);
			bag.setContent(content);
			
			//저장된 bag들을 넣어줄 list를 생성하여 넣어준다.
			list.add(bag);
		}
	    //bag이 들어간 list를 리턴받아 사용한다.
	    return list; 
	}
	
	//이메일 문의 게시판은 crud 기능 전부가 필요하게 된다.
	//게시글 입력 단계
	//create메소드 기능은 입력을 받아 진행이 되는 단계이기 때문에 값이 void이고 입력된 값을 EmailVO bag에 저장한다.
	//create메소드를 컴파일할때 예외를 발생시키지 않고 바로 진행
	public void create(EmailVO bag) throws Exception {
		
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
	    	//insert문을 사용하여 입력받은 값(id...content까지)의 개수와 동일하게 values(?)작성하여 쿼리 설정
	    String sql = "insert into board(Id, name, tel, email, type, title, content) values(?, ?, ?, ?, ?, ?, ?)";
	    //쿼리실행하기 위한 PreparedStatement 객체 생성
	    PreparedStatement ps = con.prepareStatement(sql);
	    
	    //ps내 setString문 실행하여 입력받은 값을 지정된 쿼리 위치에 맞게 bag에 저장
	    ps.setString(1, bag.getId());
	    ps.setString(2, bag.getName());
	    ps.setString(3, bag.getTel());
	    ps.setString(4, bag.getEmail());
	    ps.setString(5, bag.getType());
	    ps.setString(6, bag.getTitle());
	    ps.setString(7, bag.getContent());
	    
	    //4. SQL문 mySQL서버로 전송
	      //3번 과정에서 생성된 쿼리를 실행하기 위해 mySQL서버로 전송
	    ps.executeUpdate();
	}
	
	//게시글 삭제 단계
	//delete메소드 기능은 값을 입력을 받아 진행이 되는 단계이기 때문에 값이 void이고 게시글 삭제는 id로 검색하여 삭제된다.
	//delete메소드 컴파일할때 예외를 발생시키지 않고 바로 진행
	public void delete(String id) throws Exception {
		
	    //1. 커넥터 사용 설정
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
	    	//delete문 사용하여 데이터베이스 내 해당 테이블에서 where문으로 id검색하여 그에 딸린 정보들 삭제하기 위한 쿼리 선언
	    String sql = "delete from board where id = ?";
	    //쿼리를 실행하기 위한 PreparedStatement 객체 생성
	    PreparedStatement ps = con.prepareStatement(sql);
	    //ps내 setString문 실행하여 입력받은 값 저장
	    ps.setString(1, id);
	    
	    //4. SQL문 mySQL서버로 전송
	      //3번 과정에서 생성된 쿼리를 실행하기 위해 mySQL서버로 전송
	    ps.executeUpdate();
	}
	
	//게시글 수정 단계
	//update메소드 기능은 값을 입력을 받아 진행이 되는 단계이기 때문에 값이 void이고 수정된 값들을 VO bag에 저장한다.
	//update메소드 컴파일할때 예외를 발생시키지 않고 바로 진행
	public void update(EmailVO bag) throws Exception {
		
	    //1. 커넥터 사용 //데이터베이스 mySQL 사용하기 위한 커넥션 사용 연결
	    Class.forName("com.mysql.jdbc.Driver");
	    
	    //2. db연결 //디비 연결하여 데이터베이스를 사용할 준비 완료
	    //?useUnicode=true&characterEncoding=utf8"; 한글 설정 해주기 위한 코드 추가
	    String url = "jdbc:mysql://localhost:3306/shop?useUnicode=true&characterEncoding=utf8";
	    //데이터베이스 연결하기 위한 url, id, pw 입력
	    Connection con = DriverManager.getConnection(url, "root", "1234");
	    
	    //3. SQL문 만들기 //SQL문을 만들어서 데이터가 들어있는 테이블에서 가져올 자료를 요청
	    	//update문 사용하여 위해 데이터베이스내 해당 테이블에서 where문 사용하여 
	    	//수정할 값들의 위치를 확인하고 set문 사용하여 수정할 값들을 입력한 쿼리변수 선언 
	    String sql = "update board set type = ?, email = ?, title = ?, content = ? where tel = ?";
	    //쿼리를 실행하기 위한 PreparedStatement 객체 생성
	    PreparedStatement ps = con.prepareStatement(sql);
	    
	    //ps내 setString문 실행하여 입력받은 값을 지정된 쿼리 위치에 맞게 bag에 저장
	    ps.setString(1, bag.getTel());
	    ps.setString(2, bag.getEmail());
	    ps.setString(3, bag.getType());
	    ps.setString(4, bag.getTitle());
	    ps.setString(5, bag.getContent());
	    
	    //4. SQL문 mySQL서버로 전송
	      //3번 과정에서 생성된 쿼리를 실행하기 위해 mySQL서버로 전송
	    ps.executeUpdate();
	    
	}
	//게시글 검색하기 단계
	//read메소드 기능은 이미 저장된 값을 불러오는 단계이기 때문에 EmailVO에서 읽어올 값(id)를 넣어준다.
	//read메소드 컴파일할때 예외를 발생시키지 않고 바로 진행
	public EmailVO read(String id) throws Exception {
		
	    //1. 커넥터 사용  //데이터베이스 mySQL 사용하기 위한 커넥션 사용 연결
	    Class.forName("com.mysql.jdbc.Driver");
	    System.out.println("1. 커넥터 사용 설정 성공. <br>");
	    
	    //2. db연결  //디비 연결하여 데이터베이스를 사용할 준비 완료
	    //?useUnicode=true&characterEncoding=utf8"; 한글 설정 해주기 위한 코드 추가
	    String url = "jdbc:mysql://localhost:3306/shop?useUnicode=true&characterEncoding=utf8";
	    //데이터베이스 연결하기 위한 url, id, pw 입력
	    Connection con = DriverManager.getConnection(url, "root", "1234");
	    
	    //3. SQL문 만들기   //SQL문을 만들어서 데이터가 들어있는 테이블에서 가져올 자료를 요청
	    //select문 사용하여 위해 데이터베이스내 해당 테이블에서 where문 사용하여 검색할 값의 위치를 확인하기 위한 쿼리 변수 선언
	    String sql = "select * from board where id = ?";
	    //쿼리를 실행하기 위한 PreparedStatement 객체 생성
	    PreparedStatement ps = con.prepareStatement(sql);
	    //ps내 setString문 실행하여 입력받은 값을 위치에 맞게 저장
	    ps.setString(1, id);
	    
	    //4. SQL문 mySQL서버로 전송 //3번 과정에서 생성된 쿼리를 실행하기 위해 mySQL서버로 전송
	    ResultSet rs = ps.executeQuery();
	    
	    //read메서드로 불러올 값들을 넣기 위한 bag 생성
	    EmailVO bag = new EmailVO();

	    //1. 검색결과 체크 //if문 사용하여 한 행씩 내려가서 검색한 결과값(rs)이 있는지 체크
	    if (rs.next()) {
	    	//2. 만약 결과가 있으면, 테이블에서 원하는 데이터 항목을 꺼내어 bag에 저장
	    	//꺼내주는 방법은 2가지, 1)항목명, 2)항목의 인덱스
	    	String id2 = rs.getString(1); 
	    	String name = rs.getString(2); 
	    	String tel1 = rs.getString(3); 
	    	String email = rs.getString(4); 
	    	String type = rs.getString(5); 
	    	String title = rs.getString(6); 
	    	String content = rs.getString(7); 
	    	//검색된 값들을 생성된 bag에 넣는다.
	    	bag.setId(id2);
	    	bag.setName(name);
			bag.setTel(tel1);
			bag.setEmail(email);
			bag.setType(type);
			bag.setTitle(title);
			bag.setContent(content);
		}
	    //bag을 리턴받아 사용한다.
	    return bag;
	}

}
