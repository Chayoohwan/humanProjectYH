package DTO;

public class Client_DTO {
	private String id;	//고객 아이디
	private int cnt;	//대여수량
	private int no; //대여한 책번호
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}

}