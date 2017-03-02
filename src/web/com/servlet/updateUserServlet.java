package web.com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.com.dao.usersDAO;
import web.com.dao.impl.usersDAOImpl;
import web.com.entity.users;

public class updateUserServlet extends HttpServlet {

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
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		//PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		usersDAO user = new usersDAOImpl();
		
		users u = user.getUsersById(Integer.parseInt(id));
		
		request.setAttribute("user",u);
		request.getRequestDispatcher("update.jsp").forward(request, response);
		
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/heml;charset=UTF-8");
		
		String id = request.getParameter("id");
		String name = request.getParameter("username");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String address = request.getParameter("address");
	
		
		users u = new users(Integer.parseInt(id),name,Integer.parseInt(gender),Integer.parseInt(age),address);
		
		
		usersDAO ud = new usersDAOImpl();
		int result = ud.updateUser(u);
		if(result==1){
			response.sendRedirect("usersServlet");
		}else{
			response.sendRedirect("update.jsp");
		}
	}

}
