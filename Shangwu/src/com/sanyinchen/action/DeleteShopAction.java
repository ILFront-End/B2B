package com.sanyinchen.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sanyinchen.dao.ChangShopStateDao;
import com.sanyinchen.dao.ChangStateDao;
import com.sanyinchen.dao.DeleteShopStateDao;

public class DeleteShopAction extends HttpServlet {

	DeleteShopStateDao mChangStateDao;

	/**
	 * Constructor of the object.
	 */
	public DeleteShopAction() {
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

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String who = request.getParameter("who");
		String product_name = request.getParameter("product_name");
		String shuxing = request.getParameter("shuxing").trim();
		System.out.println(who);
		System.out.println(product_name);
		List<Object> params = new ArrayList<Object>();
		// params.add("1");
		String[] temp = shuxing.split(" ");
		params.add(who);
		params.add(product_name.trim());
		params.add("0");
		params.add(temp[temp.length - 1]);
		Boolean flag = mChangStateDao.datalist(params);
		System.out.println("flag=  " + flag);
		if (flag)
			out.print("1");
		else
			out.print("0");
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
		mChangStateDao = new DeleteShopStateDao();
	}

}
