package com.sanyinchen.action;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sanyinchen.dao.GetShopDao;

public class GetShopAction extends HttpServlet {

	GetShopDao mDao;

	/**
	 * Constructor of the object.
	 */
	public GetShopAction() {
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

		response.setContentType("text/html");
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
		System.out.println("who= " + who);
		java.util.List<Object> params = new ArrayList<Object>();
		params.add(who);
		params.add("0");
		java.util.List<Map<String, Object>> list = mDao.datalist(params);
		String str = "";
		if (list != null)
			for (int i = 0; i < list.size(); i++) {
				str += list.get(i).get("product_path").toString() + ","
						+ list.get(i).get("product_name").toString() + ","
						+ list.get(i).get("product_other").toString() + ","
						+ list.get(i).get("product_price").toString() + ","
						+ list.get(i).get("product_price").toString();
				if (i != list.size() - 1) {
					str += ",";
				}
			}
		System.out.println(str);
		out.print(str);
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
		mDao = new GetShopDao();
	}

}
