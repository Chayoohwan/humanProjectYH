package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.Client_DTO;

public class Client_DAO {
	private Connection conn = null;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String id = "system";
	private String pwd = "1111";
	private ResultSet rs = null;

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

	// 구매한 책 전체보기
	public ArrayList<Client_DTO> selectwne() {
		String sql = "select * from hmsclient";
		Statement stt = null;
		ArrayList<Client_DTO> cdto = new ArrayList<>();
		if (conn() != null) {
			try {
				stt = conn.createStatement();
				rs = stt.executeQuery(sql);
				while (rs.next()) {
					Client_DTO cDto = new Client_DTO();
					cDto.setId(rs.getString("id"));
					cDto.setNo(rs.getInt("no"));
					cDto.setCnt(rs.getInt("cnt"));
					cdto.add(cDto);

				}
				// ArrayIndexOutOfBoundsException 예외
			} catch (ArrayIndexOutOfBoundsException d) {
				System.out.println("Index가 올바르지 않습니다.");
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
		return cdto;
	}

	// 장바구니에 담는 메서드
	public void insertThe(Client_DTO m) {
		String sql = "insert into hmsclient values (?,?,?)";
		PreparedStatement ppst = null;
		if (conn() != null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setString(1, m.getId());
				ppst.setInt(2, m.getCnt());
				ppst.setInt(3, m.getNo());
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
}
