package servlet;

import java.io.IOException;
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
		listNewspaper(request, response);
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

}
