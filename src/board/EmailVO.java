package board;
//이메일 게시판 정보를 저장하고 전달하기 위한 VO(Value Object) or DTO(Data Transfer Object)생성
//이메일 문의 게시판은 각각 회원가입 시 session된 정보(id, name), 사용자가 입력한 정보(id, tel, email, type, title, content)로 나뉜다.
//각 변수들의 타입은 숫자의 연산과정 또는 실수가 필요하지 않기 때문에 String으로 설정한다.
//생성된 EmailVO가 어떠한 클래스에서도 접근 가능할 수 있도록 public 제어문 사용
public class EmailVO {
	
	String id;
	String name;
	String tel;
	String email;
	String type;
	String title;
	String content;
	
	//Source 카테고리에 Generate Getters and Setters 사용하여
	//각 변수들의 입력값을 넣고 가져올 수 있게 만들어준다.
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	
}