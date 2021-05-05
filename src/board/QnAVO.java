package board;
//QnA게시판 정보를 저장하고 전달하기 위한 VO(Value Object) or DTO(Data Transfer Object)생성
//QnA게시판은 no의 경우 auto increment, views(조회수)로 인하여  int로 설정, 그 외 변수들은 String으로 설정 
//생성된 QnAVO가 어떠한 클래스에서도 접근 가능할 수 있도록 public 제어문 사용
public class QnAVO {
	
	int no;
	String type;
	String title;
	String content;
	int views;
	
	//Source 카테고리에 Generate Getters and Setters 사용하여
	//각 변수들의 입력값을 넣고 가져올 수 있게 만들어준다.
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	
}