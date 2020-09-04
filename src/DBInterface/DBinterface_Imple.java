package DBInterface;

import java.util.ArrayList;
import java.util.Scanner;
import DAO.Client_DAO;
import DAO.Store_DAO;
import DTO.Client_DTO;
import DTO.Store_DTO;

public class DBinterface_Imple implements DBinterface_ {
	private Store_DAO ssao = Store_DAO.getInstance();
	private Client_DAO cdao = new Client_DAO();
	Scanner in = new Scanner(System.in);

	@Override // 물품구매
	public void buy() {
		list(); // 상품정보 가져오기
		if (ssao.selectAll().size() > 0) {
			System.out.println("id를 입력해주세요.");
			String id = in.next();
			System.out.println("구매할 책의 번호를 입력해주세요.");
			int k = in.nextInt();
			in.nextLine();
			System.out.println("구매할 수량을 입력해주세요.");
			int i = in.nextInt();
			in.nextLine();

			Client_DTO cdto = new Client_DTO();
			cdto.setId(id);
			cdto.setNo(k);
			cdto.setCnt(i);
			cdao.insertThe(cdto);
			ssao.updateOne(i, k);
			System.out.println("구매가 완료되었습니다.");
		} else {
			System.out.println("재고없음");
		}
	}

	@Override // 책방리스트
	public void list() {
		ArrayList<Store_DTO> sDto = ssao.selectAll();
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
				System.out.println("고객님의 ID:" + cdto.get(i).getId() + "입니다.");
				System.out.println("책 번호는:" + cdto.get(i).getNo() + "입니다.");
				System.out.println("주문하신 갯수는:" + cdto.get(i).getCnt() + "입니다.");
			}
		} else {
			System.out.println("Id가 잘못 입력됬습니다.");
		}
	}
}
