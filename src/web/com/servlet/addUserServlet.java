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

public class addUserServlet extends HttpServlet {

	private String message;
	public void init() throws ServletException{
	      // 执行必需的初始化
	      message = "Hello World";
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
		
		
		String name = request.getParameter("username");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String address = request.getParameter("address");
		
		PrintWriter out = response.getWriter();
		/*out.print(message);
		out.print(name);
		out.print(gender);
		out.print(age);
		out.print(address);*/
		//初始化构造函数
		users u = new users(name,Integer.parseInt(gender),Integer.parseInt(age),address);

		usersDAO user = new usersDAOImpl();
		int result = user.addUser(u);
		
		if(result==0){
			out.print("添加失败！");
		}else{
			out.print("添加成功！");
			response.sendRedirect("usersServlet");
		}
	}

}
