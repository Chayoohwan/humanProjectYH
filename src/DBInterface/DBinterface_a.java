package DBInterface;

import java.util.HashMap;

//������
public interface DBinterface_a {
	
	public void List(); //å ����Ʈ(å ����)
	public void addBook(int no, String cname, int w, String kk, int ti);//å  ���
	public void deleteBook(int e); //å ����
	public void brList(); //�뿩���
	public HashMap<String, String> getHashList();
	
}
