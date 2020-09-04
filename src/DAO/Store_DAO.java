package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.Store_DTO;

public class Store_DAO {
	private Connection conn = null;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String id = "system";
	private String pwd = "1111";
	private ResultSet rs = null;
	// �̱���
	public static Store_DAO sgdao = null;

	private Store_DAO() {
	}

	public static Store_DAO getInstance() {
		if (sgdao == null) {
			sgdao = new Store_DAO();
		}
		return sgdao;
	}

	public Connection conn() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pwd);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// ��ϵ� å ��ü����
	public ArrayList<Store_DTO> selectAll() {
		String sql = "select * from hmstore";
		Statement stt = null;
		ArrayList<Store_DTO> sDto = new ArrayList<>();
		if (conn() != null) {
			try {
				stt = conn.createStatement();
				rs = stt.executeQuery(sql);
				while (rs.next()) {
					Store_DTO sdto = new Store_DTO();
					sdto.setNo(rs.getInt("no"));
					sdto.setBookname(rs.getString("bookname"));
					sdto.setBprice(rs.getInt("bprice"));
					sdto.setBwriter(rs.getString("bwriter"));
					sdto.setBcnt(rs.getInt("bcnt"));
					sDto.add(sdto);
				}
				// ArrayIndexOutOfBoundsException ����
			} catch (ArrayIndexOutOfBoundsException d) {
				System.out.println("Index�� �ùٸ��� �ʽ��ϴ�.");
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				try {
					if (stt != null)
						stt.close();
					if (conn != null)
						conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		return sDto;
	}

	// å ����ϱ�
	public void insertOne(Store_DTO sdto) {
		String sql = "insert into hmstore values(?,?,?,?,?)";
		if (conn() != null) {
			PreparedStatement ppst = null;
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setInt(1, sdto.getNo());
				ppst.setString(2, sdto.getBookname());
				ppst.setInt(3, sdto.getBprice());
				ppst.setString(4, sdto.getBwriter());
				ppst.setInt(5, sdto.getBcnt());
				ppst.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				try {
					if (ppst != null)
						ppst.close();
					if (conn != null)
						conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}

	}

	// ��� ����-
	public void updateOne(int cnt, int no) {
		String sql = "update hmstore set bcnt=bcnt-? where no=?";
		PreparedStatement ppst = null;
		if (conn() != null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setInt(1, cnt);
				ppst.setInt(2, no);
				ppst.executeUpdate();
			} catch (Exception e) {
			} finally {
				try {
					if (ppst != null)
						ppst.close();
					if (conn != null)
						conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
	}

	// ��� ���� +
	public void updatetwo(int cnt, int no) {
		String sql = "update hmstore set bcnt=bcnt+? where no=?";
		PreparedStatement ppst = null;
		if (conn() != null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setInt(1, cnt);
				ppst.setInt(2, no);
				ppst.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				try {
					if (ppst != null)
						ppst.close();
					if (conn != null)
						conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
	}

	// å �����ϱ�
	public void deleteB(int no) {
		String sql = "delete from hmstore where no=?";
		PreparedStatement ppst = null;
		if (conn() != null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setInt(1, no);
				ppst.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				try {
					if (ppst != null)
						ppst.close();
					if (conn != null)
						conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
	}
	//��ȣ�� ����ã�� 
	public ArrayList<Store_DTO> selectList(int no) {
		String sql = "select * from hmstore where no= ?";
		PreparedStatement ppst = null;
		ArrayList<Store_DTO> sDto = new ArrayList<>();
		if (conn() != null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setInt(1, no);
				rs = ppst.executeQuery();
				while (rs.next()) {
					Store_DTO sdto = new Store_DTO();
					sdto.setNo(rs.getInt("no"));
					sdto.setBookname(rs.getString("bookname"));
					sdto.setBprice(rs.getInt("bprice"));
					sdto.setBwriter(rs.getString("bwriter"));
					sdto.setBcnt(rs.getInt("bcnt"));
					sDto.add(sdto);
				}
				// ArrayIndexOutOfBoundsException ����
			} catch (ArrayIndexOutOfBoundsException d) {
				System.out.println("Index�� �ùٸ��� �ʽ��ϴ�.");
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				try {
					if (ppst != null)
						ppst.close();
					if (conn != null)
						conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
		return sDto;
	}
}
