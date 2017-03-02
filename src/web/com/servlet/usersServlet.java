package web.com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.com.dao.usersDAO;
import web.com.dao.impl.usersDAOImpl;
import web.com.entity.users;

public class usersServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		usersDAO users = new usersDAOImpl();
		
		List<users> userList = users.getAllUsers();
		
		request.setAttribute("userList", userList);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
