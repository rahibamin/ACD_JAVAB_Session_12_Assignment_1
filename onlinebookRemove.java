package db.connection;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class onlinebookRemove
 */
@WebServlet(description = "Remove", urlPatterns = { "/onlinebookRemove" })
public class onlinebookRemove extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public onlinebookRemove() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String r_book_title=request.getParameter("r_book_title");
		String r_book_author=request.getParameter("r_book_author");
		String r_book_publisher=request.getParameter("r_book_publisher");
		String r_book_publication_year=request.getParameter("r_book_publication_year");
		String r_book_price=request.getParameter("r_book_price");
		
		
		String q_r = "delete from `OnlineBooks`.Books where book_title=?";
		java.sql.Connection con= DBConnection.getDBInstance();
		
		try {
			PreparedStatement stmt1 = con.prepareStatement(q_r);
			stmt1.setString(1, r_book_title);
			stmt1.setString(2, r_book_author);
			stmt1.setString(3, r_book_publisher);
			stmt1.setString(4, r_book_publication_year);
			stmt1.setString(5, r_book_price);
			stmt1.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		doGet(request, response);
		
		System.out.println("Book Removed");
	}

}
