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

import com.sanyinchen.Contendata.BuyState;
import com.sanyinchen.Contendata.SellState;
import com.sanyinchen.dao.GetProductBuyShopDao;
import com.sanyinchen.dao.GetProductShopDao;

public class BuyAction extends HttpServlet {
	/**
	 * Constructor of the object.
	 */
	GetProductBuyShopDao mDao;

	public BuyAction() {
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
		String name = request.getParameter("name").trim();
		List<Object> parms = new ArrayList<Object>();
		parms.add(name);
		List<Map<String, Object>> list = mDao.datalist(parms);
		String str = "";
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> map = list.get(i);

				int value = Integer.valueOf(map.get("flag").toString());
				if (value == 0)
					continue;
				str += map.get("product_dingdan").toString() + ","
						+ map.get("product_data").toString() + ","
						+ map.get("product_name_seller").toString() + ","
						+ map.get("product_path").toString() + ","
						+ map.get("product_name").toString() + ","
						+ map.get("product_other").toString() + ","
						+ map.get("product_price").toString() + ","
						+ map.get("product_number").toString() + ","
						+ map.get("product_money").toString() + ","
						+ BuyState.getsellsate(value) + ","
						+ BuyState.getsellsate2(value);
				if (i != list.size() - 1)
					str += ",";
			}
			System.out.println("str-->" + str);
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
		mDao = new GetProductBuyShopDao();
	}

}
