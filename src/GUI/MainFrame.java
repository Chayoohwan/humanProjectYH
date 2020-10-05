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
	Label title = new Label("Human�������� ���Ű� ȯ���մϴ�."); // ������Ʈ
	// Label east = new Label("east");// ������Ʈ
	// Label center = new Label("Center");// ������Ʈ
	// Label west=new Label("west");// ������Ʈ
	// Label south=new Label("south");// ������Ʈ

	// �ʱ��ư����
	Button admin = new Button("������");
	Button client = new Button("��");
	// �ʱ��ư����

	// �����ڹ�ư ������
	Panel abutton = new Panel();
	Button ahome = new Button("HOME");
	Button allview = new Button("å ��Ϻ���");
	Button asign = new Button("å  ���");
	Button adel = new Button("å ����");

	// ������ ��Ϻ���
	Panel aList = new Panel();
	List aaList = new List(10);

	// å����ϱ�
	Panel bsign = new Panel();
	List bsignList = new List(10);
	JTextField insd = new JTextField(10);
	// å�����ϱ�
	Panel bsignD = new Panel();
	JTextField inse = new JTextField(10);

	// ����ư ������
	Panel bclient = new Panel();
	Button bhome = new Button("HOME");
	Button brent = new Button("�뿩�ϱ�");
	Button cclient = new Button("�뿩���");

	// cclient ��
	Panel ccclient = new Panel();
	List cList = new List(10);

	// brent ��
	Panel fullsign = new Panel();
	List booklist = new List(15);
	List mybookList = new List(15);
	Button choicebookbtn = new Button("->");
	Panel hlist = new Panel();
	JTextField ins = new JTextField();

	// �ʱ� ������,�� Ŭ�� ��ġ�г�
	Panel select = new Panel();
	Panel select_South = new Panel();
	Panel select_North = new Panel();

	DBinterface_Imple dbimple = new DBinterface_Imple();

	// ������
	public MainFrame() {
		// bsignD
		bsignD.setLayout(new BorderLayout());
		bsignD.add(aList, "Center");
		bsignD.add(ins, "South");

		// bsign å���
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
		ins.setText("@list,@del ��ȣ, ��� ����");
		// �ʱ��ư ���� (�� ������)
		select_North.add(admin);
		select_South.add(client);

		select.setLayout(new BoxLayout(select, BoxLayout.X_AXIS));
		select.add(select_North, "Center");
		select.add(select_South, "Center");
		// �ʱ��ư ��

		// �� ��ư ������ ������ �޴�
		bclient.setLayout(new BoxLayout(bclient, BoxLayout.Y_AXIS));
		bclient.add(bhome, "West");
		bclient.add(brent, "West");
		bclient.add(cclient, "West");
		// �� ��

		// ������ ������ ������ �޴�����
		abutton.setLayout(new BoxLayout(abutton, BoxLayout.Y_AXIS));
		abutton.add(ahome, "West");
		abutton.add(allview, "West");
		abutton.add(asign, "West");
		abutton.add(adel, "West");
		//

		// �׼� ���
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

		// ��������
		this.add(title, "North");
		// this.add(east,"East");
		this.add(select, "Center");
		// this.add(west,"West");
		this.add(ins,"South");
		// �������� ��
		// â ũ�� ���� �� xŰ ���� �ҽ� ����
		this.setBounds(500, 500, 500, 350);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		this.setVisible(true);
		// â ũ�� ���� �� xŰ ���� �ҽ� ��
	}

	// �׼� �����յ�
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(admin)) {
			// System.out.println("������ �α���");
			this.remove(select);
			adminform();
		} else if (e.getSource().equals(client)) {
			System.out.println("�� �α���");
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

	// ��ȭ�� Ŭ����
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

	// ������ Ŭ����
	public void cleara() {
		this.remove(fullsign);
		this.remove(ccclient);
	}

	// ������ ���� Ŭ����
	public void clearb() {
		this.remove(aList);
		this.remove(bsign);
		this.remove(adel);
		this.remove(bsign);
		this.remove(bsignD);
	}

	// ������ ��ư ��
	public void adminform() {
		this.add(abutton, "West");
		this.setVisible(true);
	}

	// å��Ϻ���
	public void adList() {
		clearb();
		this.add(aList);
		aList(dbimple.getHashList());
		this.setVisible(true);
	}

	// å����ϱ�
	private void asignC() {
		clearb();
		this.add(bsign, "Center");
		this.setVisible(true);
	}

	// å�����ϱ�
	private void asignD() {
		clearb();
		aList(dbimple.getHashList());
		this.add(bsignD, "Center");
		this.setVisible(true);
	}

	public void clientform() { // �� ��ư
		this.add(bclient, "West");
		this.setVisible(true);
	}

	public void brentt() { // �뿩�ϱ�
		cleara();
		this.add(fullsign, "Center");
		bookList(dbimple.getHashList());
		commandToken();
		System.out.println("�뿩�Ϸ�");
		this.setVisible(true);
	}

	// �뿩�ϱ� ��ư
	public void brentlist() {
		dbimple.rent();
	}

	// �뿩���
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

	public void commandToken() { // ������⸦ ��ū�̶�� �θ���.
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
					System.out.println("���ʹ��Ⱦ�");
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
