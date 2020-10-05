package Manager;
import java.util.Scanner;
import javax.sql.rowset.serial.SerialArray;
import DBInterface.DBinterface_Imple;
public class Implement {
	DBinterface_Imple serv=new DBinterface_Imple();
	public Implement() {
		Scanner in = new Scanner(System.in);
		while(true) {
			System.out.println("++휴먼도서관에 오신걸 환영합니다.++");
			menu();
			int key = in.nextInt();
			in.nextLine();
			switch (key) {
			case 1:list();	break;
			case 2:give();	break;
			case 3:Third(); break;
			case 4: break;
			case 5: serv.addBook(key, null, key, null, key); break;
			case 6: serv.brList(); break;
			default: System.out.println("잘못된 번호입니다.");
			}
			if(key==4) break;
		}
	}
	private void list() {
		serv.rent();
	}
	private void give() {
		serv.list();
	}
	private void Third() {
		serv.client();
	}
	private void menu() {
		System.out.println("1.물품구매하기");
		System.out.println("2.책방 장바구니");
		System.out.println("3.고객 장바구니");
		System.out.println("4.종료"); 
		
	}

}
