package com.sanyinchen.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sanyinchen.dao.ProductShopDao;

public class productShopAction extends HttpServlet {
	ProductShopDao mDao;

	/**
	 * Constructor of the object.
	 */
	public productShopAction() {
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
		String buyer = request.getParameter("buyer");
		String poduct_name = request.getParameter("poduct_name");
		String product_price = request.getParameter("product_price");
		String product_oher = request.getParameter("product_oher");
		// System.out.println("buyer:" + buyer);
		// System.out.println("poduct_name" + poduct_name);
		// System.out.println("product_price" + product_price);
		System.out.println("product_oher--------->" + product_oher);
		// System.out.println("other-------->"+);
		Map<String, Object> map = new HashMap<String, Object>();

		// System.out.println(map.toString());
		String second = "";
		for (int i = 0; i < product_oher.length(); i++) {
			if (product_oher.charAt(i) != '\n')
				second += product_oher.charAt(i);
		}
		second = second.replace("/(^\\s*)|(\\s*$)/g", "");
		System.out.println("product_oher--------->" + second);
		map.put("buyer", buyer);
		map.put("poduct_name", poduct_name);
		map.put("product_price", product_price);
		map.put("product_oher", second);
		// System.out.println(map.toString());
		// System.out.println("map_product_name:"
		// + map.get(poduct_name).toString());
		boolean flag = mDao.datalist(map);
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
		mDao = new ProductShopDao();
	}

}
