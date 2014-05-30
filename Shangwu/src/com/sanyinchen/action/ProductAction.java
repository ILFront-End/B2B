package com.sanyinchen.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sanyinchen.dao.ProductDao;

public class ProductAction extends HttpServlet {

	ProductDao mProductDao;

	/**
	 * Constructor of the object.
	 */
	public ProductAction() {
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
		PrintWriter out = response.getWriter();
		// product_name,product_price,product_1,product_2,product_3,
		// product_title,product_number,product_other,
		// product_path,user_name,user_rename,user_company,
		// user_phone,user_email,flag;
		String product_name = request.getParameter("contentname");
		String product_price = request.getParameter("contentprice");
		String product_1 = request.getParameter("one");
		String product_2 = request.getParameter("two");
		String product_3 = request.getParameter("three");
		String product_title = request.getParameter("xinxibiaoti");
		String product_number = request.getParameter("changpinnum");
		String product_other = request.getParameter("canpin");
		String[] temp = product_other.split("fenge");

		product_other = temp[0];
		temp = temp[1].split(",");
		String user_name = temp[0];
		String str = "";
		for (int i = 1; i <= 5; i++) {
			str += temp[i];
			if (i != 5)
				str += ",";
		}
		String product_path = str;
		String user_rename = temp[6];
		String user_company = temp[7];
		String user_phone = temp[8];
		String user_email = temp[9];
		List<Object> params = new ArrayList<Object>();
		params.add(product_name);
		params.add(product_price);
		params.add(product_1);
		params.add(product_2);
		params.add(product_3);
		params.add(product_title);
		params.add(product_number);
		params.add(product_other);
		params.add(product_path);
		params.add(user_name);
		params.add(user_rename);
		params.add(user_company);
		params.add(user_phone);
		params.add(user_email);
		params.add("0");
		params.add(0);
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		params.add(formatter.format(date));
		for (int i = 0; i < params.size(); i++)
			System.out.println(i + "-----------" + params.get(i).toString());
		Boolean flag = mProductDao.datalist(params);
		if (flag) {
			out.print("1");
		} else {
			out.print("0");
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
		mProductDao = new ProductDao();
	}

}
