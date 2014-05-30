package com.sanyinchen.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sanyinchen.dao.HotProductDao;

public class HotProductAction extends HttpServlet {

	HotProductDao mDao;

	/**
	 * Constructor of the object.
	 */
	public HotProductAction() {
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
		List<Object> parames = new ArrayList<Object>();
		parames.add("1");
		List<Map<String, Object>> list = mDao.datalist(parames);
		System.out.println("list-->" + list.size());
		String str = "";
		if (list != null)
			if (list.size() < 15) {
				for (int i = 0; i < list.size(); i++) {
					String[] path = list.get(i).get("product_path").toString()
							.split(",");
					str += path[0] + ","
							+ list.get(i).get("product_name").toString() + ",";
					;
				}
			} else {
				for (int i = 0; i < 15; i++) {
					String[] path = list.get(i).get("product_path").toString()
							.split(",");
					str += path[0] + ","
							+ list.get(i).get("product_name").toString() + ",";
				}
			}
		// System.out.println("str:" + str);
		out.print(str);
		// System.out.println("name: "
		// + list.get(i).get("product_name").toString());
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
		mDao = new HotProductDao();
	}

}
