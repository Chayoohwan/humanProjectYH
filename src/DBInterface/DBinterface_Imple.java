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
	@Override // 대여하기
	public void rent() {
		list(); // 상품정보 가져오기
		System.out.println("구매하려면 1번 아니면 2번은 입력하세요.");
		k=in.nextInt();
		in.nextLine();
		if (k==1) {
			System.out.println("id를 입력해주세요.");
			String id = in.next();
			System.out.println("대여할 책의 번호를 입력해주세요.");
			int k = in.nextInt();
			in.nextLine();
			System.out.println("대여할 수량을 입력해주세요.");
			int i = in.nextInt();
			in.nextLine();

			Client_DTO cdto = new Client_DTO();
			cdto.setId(id);
			cdto.setNo(k);
			cdto.setCnt(i);
			cdao.insertThe(cdto);
			ssao.updateOne(i, k);
			System.out.println("구매가 완료되었습니다.");
		}else if(k==2){
			
		}
	}

	@Override // 책리스트
	public void list() {
		sDto = ssao.selectAll();
		if (ssao.selectAll().size() > 0) {
			System.out.println("현재 재고가 있는 책입니다.");
			for (int i = 0; i < sDto.size(); i++) {
				System.out.println("=================");
				System.out.println(sDto.get(i).getNo());
				System.out.println(sDto.get(i).getBookname());
				System.out.println(sDto.get(i).getBprice());
				System.out.println(sDto.get(i).getBwriter());
				System.out.println(sDto.get(i).getBcnt());
				
			}
		} else {
			System.out.println("현재 재고가 없습니다.");
		}

	}

	@Override // 장바구니 목록
	public void client() {
		ArrayList<Client_DTO> cdto = cdao.selectwne();
		if (cdto.size() > 0) {
			System.out.println("장바구니 목록입니다.");
			for (int i = 0; i < cdto.size(); i++) {
				System.out.println("========================");
				System.out.println("고객님의 ID:" + cdto.get(i).getId() + "입니다.");
				System.out.println("책 번호는:" + cdto.get(i).getNo() + "입니다.");
				System.out.println("대여한 책은 :" + cdto.get(i).getCnt() + "개 입니다.");
			}
		} else {
			System.out.println("Id가 잘못 입력됬습니다.");
		}
	}

	
	//도서관 입장  
	
	//보유한 책 모두보기 
	@Override
	public void List() {
		list();
	}
	//책 등록하기 
	@Override
	public void addBook(int no, String cname, int w, String kk, int ti) {
		System.out.println("책 입력 코너입니다.");
		System.out.println("1.입력 "+"\n"+"2.되돌아가기");
		k=in.nextInt();
		in.nextLine();
		if (k==1) {
			System.out.println("책번호를 입력하세요 ");
			int a=in.nextInt();
			in.nextLine();
			System.out.println("책 이름을 입력해주세요.");
			String bname = in.nextLine();
			System.out.println("책의 가격을 입력해주세요.");
			int i = in.nextInt();
			in.nextLine();
			System.out.println("작가를 입력해주세요.");
			String Wname = in.next();
			System.out.println("수량을 입력해주세요.");
			int b=in.nextInt();
			in.nextLine();
			
			Store_DTO sdtu=new Store_DTO();
			sdtu.setNo(a);
			sdtu.setBookname(bname);
			sdtu.setBprice(i);
			sdtu.setBwriter(Wname);
			sdtu.setBcnt(b);
			ssao.insertOne(sdtu);
			System.out.println("입력이 완료되었습니다.");
		}else if(k==2){
			
		}
	}
	//책삭제
	@Override
	public void deleteBook(int e) {
		ssao.deleteB(e);
	}
	//대여목록
	@Override
	public void brList() {
		sDto=ssao.selectList();
		ArrayList<Client_DTO> cdto=cdao.selectwne();
		for(int i=0;i<sDto.size();i++) {
			int c=sDto.get(i).getBcnt()-cdto.get(i).getCnt();
			if(c<=0) {
				System.out.println("대여품목이 없습니다.");
			}
		System.out.println("이름:"+sDto.get(i).getBookname()+"  대여중인 갯수 :"+c);
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
