package db.connection;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class onlineBookUpdate
 */
@WebServlet("/onlineBookUpdate")
public class onlineBookUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public onlineBookUpdate() {
        super();
        // TODO Auto-generated constructor stub
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
		String book_title=request.getParameter("book_title");
		String book_author=request.getParameter("book_author");
		String book_publisher=request.getParameter("book_publisher");
		String book_publication_year=request.getParameter("book_publication_year");
		String book_price=request.getParameter("book_price");
		
		
		String q = "Update `OnlineBooks`.Books SET book_title =?, book_author =?, book_publisher=?, book_publication_year =?, book_price=?";
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
		System.out.println("Book Updated");
	}

}
