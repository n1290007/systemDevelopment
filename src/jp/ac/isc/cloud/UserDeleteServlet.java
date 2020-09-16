package jp.ac.isc.cloud;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class UserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

protected void doPost(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException {


		users=DBConnection.openConnection();
		String id=request.getParameter("deleteId");
		Statement state=users.createStatement();
		state.executeUpdate("DELETE FROM user_table WHERE id='"+id+"'");
		DBConnection.closeConnection(users,state);

		response.sendRedirect("/select");

}catch(SQLException e) {
	e.printStackTrace();
}
}
}