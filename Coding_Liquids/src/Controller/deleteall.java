package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class deleteall
 */
@WebServlet("/deleteall")
public class deleteall extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String ev=request.getParameter("ev");
		

		try {
			Class.forName("com.mysql.jdbc.Driver");
		
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/cl","root","");

		
			PreparedStatement st;
		
			st = con.prepareStatement("delete from event where id=?");
			st.setString(1,ev);
			int i=0;
			i=st.executeUpdate();
		
			
			response.sendRedirect("adminevents.jsp");
			
		} catch (SQLException | ClassNotFoundException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
