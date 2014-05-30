package com.sanyinchen.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sanyinchen.dao.Resiger;

public class ResigerAction extends HttpServlet {

	Resiger mResiger;

	/**
	 * Constructor of the object.
	 */
	public ResigerAction() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getContextPath();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String user_id = request.getParameter("username");
		String pswd = request.getParameter("rpsd");
		String user_name = request.getParameter("rusername");
		String company = request.getParameter("gongsiname");
		String e_mail = request.getParameter("email");
		String phone = request.getParameter("phone");
		String area=request.getParameter("address");
		int index = (int) Math.floor(Math.random() * 8 + 1);
		String pathuser = "../userphotos/" + index + ".jpg";
		System.out.println("path----->" + pathuser);
		List<Object> params = new ArrayList<Object>();
		params.add(user_id);
		params.add(pswd);
		params.add(user_name);
		params.add(company);
		params.add(e_mail);
		params.add(phone);
		params.add(pathuser);
		params.add(area);
		
		boolean flag = mResiger.datalist(params);
		System.out.println("×¢²á×´Ì¬----->" + flag);
		if(flag)
			out.print("1");
		else
			out.print("2");
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
		mResiger = new Resiger();
	}

}
