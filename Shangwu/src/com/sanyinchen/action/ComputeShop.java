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

import com.sanyinchen.dao.GetProductNumberDao;
import com.sanyinchen.object.ComputeShopObject;

public class ComputeShop extends HttpServlet {

	GetProductNumberDao mDao;

	/**
	 * Constructor of the object.
	 */

	public ComputeShop() {
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
		String message = request.getParameter("message");
		System.out.println("message-------->" + message);
		String[] m = message.split(",");
		// for (int i = 0; i < m.length; i++)
		// System.out.println(i + " " + m[i].trim()+"end");
		ComputeShopObject[] objects = new ComputeShopObject[m.length / 2];
		// System.out.println();

		for (int i = 0, t = 0; i < m.length; i += 2, t++) {
			// if (i >= m.length)
			// break;
			System.out.println("i= " + i);
			objects[t] = new ComputeShopObject(m[i].trim(),
					Integer.valueOf(m[i + 1].trim()));

		}
		for (int i = 0; i < objects.length; i++)
			System.out.println(objects[i].getName() + " "
					+ objects[i].getNumber());
		boolean flag = false;
		String str = "";
		List<Map<String, Object>> list = null;
		List<Object> params = new ArrayList<Object>();
		for (int i = 0; i < objects.length; i++) {
			params.clear();
			params.add(objects[i].getName());
			list = mDao.datalist(params);
			if (list != null) {
				int number = Integer.valueOf(list.get(0).get("product_number")
						.toString());
				if (number < objects[i].getNumber()) {
					flag = true;
					str += objects[i].getName()+",";
				}
			}
		}
		if (!flag) {
			out.print("0");
		} else {
			out.print(str);
		}
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
		mDao = new GetProductNumberDao();
	}

}
