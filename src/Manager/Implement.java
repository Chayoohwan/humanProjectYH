package Manager;

import java.util.Scanner;

import javax.sql.rowset.serial.SerialArray;

import DBInterface.DBinterface_Imple;

public class Implement {
	DBinterface_Imple serv=new DBinterface_Imple();

	public Implement() {
		Scanner in = new Scanner(System.in);
		while(true) {
			System.out.println("++�޸չ����� ���Ű� ȯ���մϴ�.++");
			menu();
			int key = in.nextInt();
			in.nextLine();
			switch (key) {
			case 1:list();	break;
			case 2:give();	break;
			case 3:Third(); break;
			case 4: break;
			default: System.out.println("�߸��� ��ȣ�Դϴ�.");
			}
			if(key==4) break;
		}
	}

	private void list() {
		serv.buy();
	}
	private void give() {
		serv.list();
	}
	private void Third() {
		serv.client();
	}
	private void menu() {
		System.out.println("1.��ǰ�����ϱ�");
		System.out.println("2.å�� ��ٱ���");
		System.out.println("3.�� ��ٱ���");
		System.out.println("4.����"); 
		
	}

}
