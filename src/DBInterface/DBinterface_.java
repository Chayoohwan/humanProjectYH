package DBInterface;

import java.util.ArrayList;
import java.util.HashMap;

import DTO.Client_DTO;

//고객
public interface DBinterface_ {
	public void rent(); // 대여하기
	public void client();// 대여 목록보기
	public void list(); //책 목록보기
	public HashMap<String, String> getidList();

}
