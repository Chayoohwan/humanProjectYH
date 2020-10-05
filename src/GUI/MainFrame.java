package GUI;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

import javax.print.attribute.IntegerSyntax;
import javax.swing.BoxLayout;
import javax.swing.JTextField;

import DAO.Store_DAO;
import DBInterface.DBinterface_Imple;

public class MainFrame extends Frame implements ActionListener {
	Label title = new Label("Human도서관에 오신걸 환영합니다."); // 컴포넌트
	// Label east = new Label("east");// 컴포넌트
	// Label center = new Label("Center");// 컴포넌트
	// Label west=new Label("west");// 컴포넌트
	// Label south=new Label("south");// 컴포넌트

	// 초기버튼생성
	Button admin = new Button("관리자");
	Button client = new Button("고객");
	// 초기버튼생성

	// 관리자버튼 누르면
	Panel abutton = new Panel();
	Button ahome = new Button("HOME");
	Button allview = new Button("책 목록보기");
	Button asign = new Button("책  등록");
	Button adel = new Button("책 삭제");

	// 관리자 목록보기
	Panel aList = new Panel();
	List aaList = new List(10);

	// 책등록하기
	Panel bsign = new Panel();
	List bsignList = new List(10);
	JTextField insd = new JTextField(10);
	// 책삭제하기
	Panel bsignD = new Panel();
	JTextField inse = new JTextField(10);

	// 고객버튼 누르면
	Panel bclient = new Panel();
	Button bhome = new Button("HOME");
	Button brent = new Button("대여하기");
	Button cclient = new Button("대여목록");

	// cclient 폼
	Panel ccclient = new Panel();
	List cList = new List(10);

	// brent 폼
	Panel fullsign = new Panel();
	List booklist = new List(15);
	List mybookList = new List(15);
	Button choicebookbtn = new Button("->");
	Panel hlist = new Panel();
	JTextField ins = new JTextField();

	// 초기 관리자,고객 클릭 위치패널
	Panel select = new Panel();
	Panel select_South = new Panel();
	Panel select_North = new Panel();

	DBinterface_Imple dbimple = new DBinterface_Imple();

	// 생성자
	public MainFrame() {
		// bsignD
		bsignD.setLayout(new BorderLayout());
		bsignD.add(aList, "Center");
		bsignD.add(ins, "South");

		// bsign 책등록
		bsign.setLayout(new BorderLayout());
		bsign.add(bsignList, "Center");
		bsign.add(ins, "South");
		// aList
		aList.setLayout(new BorderLayout());
		aList.add(aaList);

		// cclient
		ccclient.setLayout(new BorderLayout());
		ccclient.add(cList);

		// brent
		fullsign.setLayout(new BorderLayout());
		fullsign.add(booklist, "West");
		fullsign.add(choicebookbtn, "Center");
		fullsign.add(mybookList, "East");
		fullsign.add(ins, "South");
		ins.setText("@list,@del 번호, 기능 있음");
		// 초기버튼 시작 (고객 관리자)
		select_North.add(admin);
		select_South.add(client);

		select.setLayout(new BoxLayout(select, BoxLayout.X_AXIS));
		select.add(select_North, "Center");
		select.add(select_South, "Center");
		// 초기버튼 끝

		// 고객 버튼 누르면 좌측에 메뉴
		bclient.setLayout(new BoxLayout(bclient, BoxLayout.Y_AXIS));
		bclient.add(bhome, "West");
		bclient.add(brent, "West");
		bclient.add(cclient, "West");
		// 고객 끝

		// 관리자 누르면 좌측에 메뉴선택
		abutton.setLayout(new BoxLayout(abutton, BoxLayout.Y_AXIS));
		abutton.add(ahome, "West");
		abutton.add(allview, "West");
		abutton.add(asign, "West");
		abutton.add(adel, "West");
		//

		// 액션 등록
		admin.addActionListener(this);
		client.addActionListener(this);
		ahome.addActionListener(this);
		bhome.addActionListener(this);
		brent.addActionListener(this);
		choicebookbtn.addActionListener(this);
		cclient.addActionListener(this);
		allview.addActionListener(this);
		asign.addActionListener(this);
		adel.addActionListener(this);
		ins.addActionListener(this);
		//

		// 영역지정
		this.add(title, "North");
		// this.add(east,"East");
		this.add(select, "Center");
		// this.add(west,"West");
		this.add(ins,"South");
		// 영역지정 끝
		// 창 크기 지정 및 x키 적용 소스 시작
		this.setBounds(500, 500, 500, 350);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		this.setVisible(true);
		// 창 크기 지정 및 x키 적용 소스 끝
	}

	// 액션 퍼포먼드
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(admin)) {
			// System.out.println("관리자 로그인");
			this.remove(select);
			adminform();
		} else if (e.getSource().equals(client)) {
			System.out.println("고객 로그인");
			this.remove(select);
			// this.remove(abutton);
			clientform();
		} else if (e.getSource().equals(ahome)) {
			clear();
			this.add(select);
			this.setVisible(true);
		} else if (e.getSource().equals(bhome)) {
			clear();
			this.add(select);
			this.setVisible(true);
		} else if (e.getSource().equals(brent)) {
			brentt();
		} else if (e.getSource().equals(choicebookbtn)) {
			brentlist();
		} else if (e.getSource().equals(cclient)) {
			rentbList();
		} else if (e.getSource().equals(allview)) {
			adList();
		} else if (e.getSource().equals(asign)) {
			asignC();
		} else if (e.getSource().equals(adel)) {
			asignD();
		} else if (e.getSource().equals(ins)) {
			commandToken();
		}
	}

	// 전화면 클리어
	public void clear() {
		this.remove(bclient);
		this.remove(fullsign);
		this.remove(abutton);
		this.remove(select);
		this.remove(ccclient);
		this.remove(aList);
		this.remove(bsign);
		this.remove(bsignD);
	}

	// 고객세부 클리어
	public void cleara() {
		this.remove(fullsign);
		this.remove(ccclient);
	}

	// 관리자 세부 클리어
	public void clearb() {
		this.remove(aList);
		this.remove(bsign);
		this.remove(adel);
		this.remove(bsign);
		this.remove(bsignD);
	}

	// 관리자 버튼 폼
	public void adminform() {
		this.add(abutton, "West");
		this.setVisible(true);
	}

	// 책목록보기
	public void adList() {
		clearb();
		this.add(aList);
		aList(dbimple.getHashList());
		this.setVisible(true);
	}

	// 책등록하기
	private void asignC() {
		clearb();
		this.add(bsign, "Center");
		this.setVisible(true);
	}

	// 책삭제하기
	private void asignD() {
		clearb();
		aList(dbimple.getHashList());
		this.add(bsignD, "Center");
		this.setVisible(true);
	}

	public void clientform() { // 고객 버튼
		this.add(bclient, "West");
		this.setVisible(true);
	}

	public void brentt() { // 대여하기
		cleara();
		this.add(fullsign, "Center");
		bookList(dbimple.getHashList());
		commandToken();
		System.out.println("대여완료");
		this.setVisible(true);
	}

	// 대여하기 버튼
	public void brentlist() {
		dbimple.rent();
	}

	// 대여목록
	public void rentbList() {
		cleara();
		clearb();
		cList(dbimple.getidList());
		this.add(ccclient, "Center");
		this.setVisible(true);
	}

	public void aList(HashMap<String, String> hashList) {
		aaList.removeAll();
		Set<String> s = hashList.keySet();
		Iterator<String> it = s.iterator();
		while (it.hasNext()) {
			aaList.add(it.next());
		}
	}

	public void cList(HashMap<String, String> getidList) {
		// TODO Auto-generated method stub
		cList.removeAll();
		Set<String> s = getidList.keySet();
		Iterator<String> it = s.iterator();
		while (it.hasNext()) {
			cList.add(it.next());
		}
	}

	public void bookList(HashMap<String, String> wlist) {
		booklist.removeAll();
		Set<String> s = wlist.keySet();
		Iterator<String> it = s.iterator();
		while (it.hasNext()) {
			booklist.add(it.next());
		}
	}

	public void commandToken() { // 띄워쓰기를 토큰이라고 부른다.
		String com = null;
		String word1 = null;
		String word2 = null;
		String word3 = null;
		String word4 = null;
		String word5 = null;
		String commandM = ins.getText();
		if (!commandM.equals("")) {
			StringTokenizer st = new StringTokenizer(commandM, " ");
			int tokensCnt = st.countTokens();
			if (tokensCnt == 1) {
				com = st.nextToken();
				if (com.equals("@list")) {
					System.out.println("엔터눌렸어");
					rentbList();
				}
			} else if (tokensCnt == 2) {
				com = st.nextToken();
				word1 = st.nextToken();
				if (com.equals("@del")) {
					dbimple.deleteBook(Integer.parseInt(word1));
				}
			} else if (tokensCnt == 5) {
				com = st.nextToken();
				word1 = st.nextToken();
				word2 = st.nextToken();
				word3 = st.nextToken();
				word4 = st.nextToken();
				word5 = st.nextToken();
				if (com.equals("@input")) {
				}
			}
		}
	}
}
