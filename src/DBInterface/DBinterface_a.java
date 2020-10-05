package DBInterface;

import java.util.HashMap;

//관리자
public interface DBinterface_a {
	
	public void List(); //책 리스트(책 정보)
	public void addBook(int no, String cname, int w, String kk, int ti);//책  등록
	public void deleteBook(int e); //책 삭제
	public void brList(); //대여목록
	public HashMap<String, String> getHashList();
	
}
