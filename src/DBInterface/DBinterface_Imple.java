package DBInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import DAO.Client_DAO;
import DAO.Store_DAO;
import DTO.Client_DTO;
import DTO.Store_DTO;

public class DBinterface_Imple implements DBinterface_,DBinterface_a {
	private Store_DAO ssao = Store_DAO.getInstance();
	private Client_DAO cdao = new Client_DAO();
	Scanner in = new Scanner(System.in);
	int k;
	ArrayList<Store_DTO> sDto=null;
	@Override // �뿩�ϱ�
	public void rent() {
		list(); // ��ǰ���� ��������
		System.out.println("�����Ϸ��� 1�� �ƴϸ� 2���� �Է��ϼ���.");
		k=in.nextInt();
		in.nextLine();
		if (k==1) {
			System.out.println("id�� �Է����ּ���.");
			String id = in.next();
			System.out.println("�뿩�� å�� ��ȣ�� �Է����ּ���.");
			int k = in.nextInt();
			in.nextLine();
			System.out.println("�뿩�� ������ �Է����ּ���.");
			int i = in.nextInt();
			in.nextLine();

			Client_DTO cdto = new Client_DTO();
			cdto.setId(id);
			cdto.setNo(k);
			cdto.setCnt(i);
			cdao.insertThe(cdto);
			ssao.updateOne(i, k);
			System.out.println("���Ű� �Ϸ�Ǿ����ϴ�.");
		}else if(k==2){
			
		}
	}

	@Override // å����Ʈ
	public void list() {
		sDto = ssao.selectAll();
		if (ssao.selectAll().size() > 0) {
			System.out.println("���� ��� �ִ� å�Դϴ�.");
			for (int i = 0; i < sDto.size(); i++) {
				System.out.println("=================");
				System.out.println(sDto.get(i).getNo());
				System.out.println(sDto.get(i).getBookname());
				System.out.println(sDto.get(i).getBprice());
				System.out.println(sDto.get(i).getBwriter());
				System.out.println(sDto.get(i).getBcnt());
				
			}
		} else {
			System.out.println("���� ��� �����ϴ�.");
		}

	}

	@Override // ��ٱ��� ���
	public void client() {
		ArrayList<Client_DTO> cdto = cdao.selectwne();
		if (cdto.size() > 0) {
			System.out.println("��ٱ��� ����Դϴ�.");
			for (int i = 0; i < cdto.size(); i++) {
				System.out.println("========================");
				System.out.println("������ ID:" + cdto.get(i).getId() + "�Դϴ�.");
				System.out.println("å ��ȣ��:" + cdto.get(i).getNo() + "�Դϴ�.");
				System.out.println("�뿩�� å�� :" + cdto.get(i).getCnt() + "�� �Դϴ�.");
			}
		} else {
			System.out.println("Id�� �߸� �Է���ϴ�.");
		}
	}

	
	//������ ����  
	
	//������ å ��κ��� 
	@Override
	public void List() {
		list();
	}
	//å ����ϱ� 
	@Override
	public void addBook(int no, String cname, int w, String kk, int ti) {
		System.out.println("å �Է� �ڳ��Դϴ�.");
		System.out.println("1.�Է� "+"\n"+"2.�ǵ��ư���");
		k=in.nextInt();
		in.nextLine();
		if (k==1) {
			System.out.println("å��ȣ�� �Է��ϼ��� ");
			int a=in.nextInt();
			in.nextLine();
			System.out.println("å �̸��� �Է����ּ���.");
			String bname = in.nextLine();
			System.out.println("å�� ������ �Է����ּ���.");
			int i = in.nextInt();
			in.nextLine();
			System.out.println("�۰��� �Է����ּ���.");
			String Wname = in.next();
			System.out.println("������ �Է����ּ���.");
			int b=in.nextInt();
			in.nextLine();
			
			Store_DTO sdtu=new Store_DTO();
			sdtu.setNo(a);
			sdtu.setBookname(bname);
			sdtu.setBprice(i);
			sdtu.setBwriter(Wname);
			sdtu.setBcnt(b);
			ssao.insertOne(sdtu);
			System.out.println("�Է��� �Ϸ�Ǿ����ϴ�.");
		}else if(k==2){
			
		}
	}
	//å����
	@Override
	public void deleteBook(int e) {
		ssao.deleteB(e);
	}
	//�뿩���
	@Override
	public void brList() {
		sDto=ssao.selectList();
		ArrayList<Client_DTO> cdto=cdao.selectwne();
		for(int i=0;i<sDto.size();i++) {
			int c=sDto.get(i).getBcnt()-cdto.get(i).getCnt();
			if(c<=0) {
				System.out.println("�뿩ǰ���� �����ϴ�.");
			}
		System.out.println("�̸�:"+sDto.get(i).getBookname()+"  �뿩���� ���� :"+c);
		}
		
	}
	
	@Override
	public HashMap<String, String> getHashList() {
		// TODO Auto-generated method stub
		ArrayList<Store_DTO> wlist = ssao.selectAll();
		HashMap<String,String> hList = new HashMap<String, String>();
		for(int i=0; i < wlist.size(); i++) {
			hList.put(wlist.get(i).getBookname(),wlist.get(i).getBwriter());
		}
		return hList;
	}
	
	@Override
	public HashMap<String, String> getidList() {
		// TODO Auto-generated method stub
		ArrayList<Client_DTO> wlist = cdao.selectwne();
		HashMap<String,String> hList = new HashMap<String, String>();
		for(int i=0; i < wlist.size(); i++) {
			hList.put(wlist.get(i).getId(),"");
		}
		return hList;
	}
	
}
