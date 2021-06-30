package newspaperDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dBConnection.DBConnection;
import model.Newspaper;

public class NewspaperDAO {

	private static Connection conn = DBConnection.getConnection();
	private static NewspaperDAO instance;

	public static NewspaperDAO getInstance() {
		if (instance == null) {
			instance = new NewspaperDAO();
		}
		return instance;
	}

	public List<Newspaper> selectAllNewspapers() {
		List<Newspaper> list = new ArrayList();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from newspaper;");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getNString("title");
				String content = rs.getString("content");
				list.add(new Newspaper(id, title, content));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public boolean insertNewspaper(Newspaper newspaper) {
		boolean rowCreated = false;
		String insertNewspaper = "insert into newspaper(title, content) values(?, ?);";
		try {
			PreparedStatement ps = conn.prepareStatement(insertNewspaper);
			ps.setString(1, newspaper.getTitle());
			ps.setString(2, newspaper.getContent());
			rowCreated = ps.executeUpdate() > 0;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rowCreated;
	}

	public boolean updateNewspaper(Newspaper newspaper) {
		boolean rowUpdated = false;
		String updateNewspaper = "update newspaper set title = ?, content = ? where id = ?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(updateNewspaper);
			ps.setNString(1, newspaper.getTitle());
			ps.setNString(2, newspaper.getContent());
			ps.setInt(3, newspaper.getId());
			rowUpdated = ps.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowUpdated;
	}

	public boolean deleteNewspaper(int id) {
		boolean rowDeleted = false;

		String DELETE_NEWSPAPER = "DELETE FROM NEWSPAPER WHERE id = ?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_NEWSPAPER);
			ps.setInt(1, id);
			rowDeleted = ps.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowDeleted;

	}

	public Newspaper selectNewspaper(int id) {
		Newspaper newspaper = null;
		try {
			String SELECT_NEWSPAPER_BY_ID = "SELECT * FROM newspaper WHERE id = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(SELECT_NEWSPAPER_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				newspaper = new Newspaper(id, title, content);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newspaper;
	}

//	public static void main(String[] args) {
//		Newspaper newspaper = new Newspaper("pqMinh", "Phạm Quang Minh");
//		System.out.println(insertNewspaper(newspaper));
//		Newspaper newspaper1 = new Newspaper(22, "pqTu", "Phạm Quang Tu");
//		System.out.println(updateNewspaper(newspaper1));
//		System.out.println(deleteNewspaper(23));
//		List list = selectAllNewspapers();
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
//	}

}
