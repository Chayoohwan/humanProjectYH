package DBInterface;

import java.util.ArrayList;
import java.util.HashMap;

import DTO.Client_DTO;

//��
public interface DBinterface_ {
	public void rent(); // �뿩�ϱ�
	public void client();// �뿩 ��Ϻ���
	public void list(); //å ��Ϻ���
	public HashMap<String, String> getidList();

}
