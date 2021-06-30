package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Newspaper;
import newspaperDAO.NewspaperDAO;

/**
 * Servlet implementation class NewspapersServlet
 */
@WebServlet("/")
public class NewspapersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private NewspaperDAO newspaperDAO;

	public void init() {
		newspaperDAO = new NewspaperDAO();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewspapersServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertNewspaper(request, response);
				break;
			case "/delete":
				deleteNewspaper(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateNewspaper(request, response);
				break;
			default:
				listNewspaper(request, response);
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void listNewspaper(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Newspaper> list = newspaperDAO.selectAllNewspapers();
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("newspaper-list.jsp");
		dispatcher.forward(request, response);
	}

	private void deleteNewspaper(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		newspaperDAO.deleteNewspaper(id);
		response.sendRedirect("list");
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("add-newspaper.jsp");
		dispatcher.forward(request, response);
	}

	private void insertNewspaper(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		newspaperDAO.insertNewspaper(new Newspaper(title, content));
		response.sendRedirect("list");
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Newspaper existingNewspaper = newspaperDAO.selectNewspaper(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("edit-newspaper.jsp");
		request.setAttribute("newspaper", existingNewspaper);
		dispatcher.forward(request, response);
	}

	private void updateNewspaper(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		Newspaper newspaper = new Newspaper(id, title, content);
		newspaperDAO.updateNewspaper(newspaper);
		response.sendRedirect("list");
	}

}
