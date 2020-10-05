package JunitTest;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import DAO.Client_DAO;
import DAO.Store_DAO;
import DTO.Client_DTO;
import DTO.Store_DTO;

public class Store_DAO_Test {
	Client_DAO cdao = null;
	Store_DAO sdao = null;

	@Before
	public void loading() {
		sdao = Store_DAO.getInstance();
		cdao = new Client_DAO();
	}

	@Test // ��ü����
	public void selectTest() {
		ArrayList<Store_DTO> sDto = sdao.selectAll();
		if (sDto.size() > 0) {
			System.out.println("���� ��� �ִ� å�Դϴ�.");
			for (int i = 0; i < sDto.size(); i++) {
				System.out.println("==================");
				System.out.println(sDto.get(i).getNo());
				System.out.println(sDto.get(i).getBookname());
				System.out.println(sDto.get(i).getBprice());
				System.out.println(sDto.get(i).getBwriter());
				System.out.println(sDto.get(i).getBcnt());
			}
		}
	}

	@Test // å �԰�
	public void insertOne() {
		Store_DTO sDto = new Store_DTO();
		sDto.setNo(2);
		sDto.setBookname("���� ����");
		sDto.setBprice(5900);
		sDto.setBwriter("�̻�");
		sDto.setBcnt(5);
		sdao.insertOne(sDto);
		selectTest();
	}

	@Test // å ���� -
	public void updateM() {
		sdao.updateOne(1, 2);
	}

	@Test // å ���� +
	public void updateP() {
		sdao.updatetwo(1, 2);
	}

	@Test // å ��� ����
	public void deleteOne() {
		sdao.deleteB(2);
	}

	@Test // �� ��ٱ���
	public void selectTest1() {
		ArrayList<Client_DTO> sDto = cdao.selectwne();
		for (int i = 0; i < sDto.size(); i++) {
			System.out.println(sDto.get(i).getId());
			System.out.println(sDto.get(i).getNo());
			System.out.println(sDto.get(i).getCnt());
		}
	}

	@Test // �� ��ǰ����
	public void insertC() {
		Client_DTO cdto = new Client_DTO();
		cdto.setId("a1");
		cdto.setCnt(2);
		cdto.setNo(1);
		cdao.insertThe(cdto);
		sdao.updateOne(3, 2);
	}
	@Test //��ȣ�� ã��
	public void selectOne() {
		ArrayList<Store_DTO> sDto = sdao.selectList();
		for (int i = 0; i < sDto.size(); i++) {
			System.out.println("==================");
			System.out.println(sDto.get(i).getNo());
			System.out.println(sDto.get(i).getBookname());
			System.out.println(sDto.get(i).getBprice());
			System.out.println(sDto.get(i).getBwriter());
			System.out.println(sDto.get(i).getBcnt());
		}
	}
}
