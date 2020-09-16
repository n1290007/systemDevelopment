package jp.ac.isc.cloud;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

protected void doPost(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{

		Connection users=null;
		try {

			users=DBConnection.openConnection();
			String id=request.getParameter("updateId");
			String name=request.getParameter("updateName");
			String picture=request.getParameter("updatePicture");
			state.executeUpdate("UPDATE user_table SET name='"+name+"'WHERE id='"+id+"'");
			DBConnection.closeConnection(users,state);

			response.sendRedirect("/select");

	}catch(SQLException e) {
		e.printStackTrace();
	}
}
}