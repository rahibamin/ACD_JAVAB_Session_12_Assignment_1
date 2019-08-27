package db.connection;

import java.beans.Statement;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jndi.ldap.Connection;

/**
 * Servlet implementation class onlineBooks
 */
@WebServlet("/onlineBooks")
public class onlineBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public onlineBooks() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String book_title=request.getParameter("book_title");
		String book_author=request.getParameter("book_author");
		String book_publisher=request.getParameter("book_publisher");
		String book_publication_year=request.getParameter("book_publication_year");
		String book_price=request.getParameter("book_price");
		
		
		String q = "insert into `OnlineBooks`.Books(book_title, book_author, book_publisher, book_publication_year, book_price) values(?,?,?,?,?)";
		java.sql.Connection con= DBConnection.getDBInstance();
		
		try {
			PreparedStatement stmt = con.prepareStatement(q);
			stmt.setString(1, book_title);
			stmt.setString(2, book_author);
			stmt.setString(3, book_publisher);
			stmt.setString(4, book_publication_year);
			stmt.setString(5, book_price);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doGet(request, response);
		System.out.println("Book Added");
	}

}
