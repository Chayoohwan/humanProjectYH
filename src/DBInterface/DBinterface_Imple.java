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

	@Override // ��ǰ����
	public void buy() {
		list(); // ��ǰ���� ��������
		if (ssao.selectAll().size() > 0) {
			System.out.println("id�� �Է����ּ���.");
			String id = in.next();
			System.out.println("������ å�� ��ȣ�� �Է����ּ���.");
			int k = in.nextInt();
			in.nextLine();
			System.out.println("������ ������ �Է����ּ���.");
			int i = in.nextInt();
			in.nextLine();

			Client_DTO cdto = new Client_DTO();
			cdto.setId(id);
			cdto.setNo(k);
			cdto.setCnt(i);
			cdao.insertThe(cdto);
			ssao.updateOne(i, k);
			System.out.println("���Ű� �Ϸ�Ǿ����ϴ�.");
		} else {
			System.out.println("������");
		}
	}

	@Override // å�渮��Ʈ
	public void list() {
		ArrayList<Store_DTO> sDto = ssao.selectAll();
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
				System.out.println("������ ID:" + cdto.get(i).getId() + "�Դϴ�.");
				System.out.println("å ��ȣ��:" + cdto.get(i).getNo() + "�Դϴ�.");
				System.out.println("�ֹ��Ͻ� ������:" + cdto.get(i).getCnt() + "�Դϴ�.");
			}
		} else {
			System.out.println("Id�� �߸� �Է���ϴ�.");
		}
	}
}
