package com.sanyinchen.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sanyinchen.Contendata.ContentData;
import com.sanyinchen.dao.CheckuserDao;
import com.sanyinchen.dao.INsertPinLunDao;
import com.sanyinchen.jdbc.JdbcUtils;

public class PinLunAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PinLunAction() {
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
		String productname = request.getParameter("productname");
		String commont = request.getParameter("commont");
		String select = request.getParameter("select");
		String user_name = request.getParameter("username");
		System.out.println("productname->" + productname);
		System.out.println("commont->" + commont);
		System.out.println("select->" + select);
		System.out.println("user_name->" + user_name);
		CheckuserDao m = new CheckuserDao();
		List<Object> params = new ArrayList<Object>();
		params.add(user_name);
		List<Map<String, Object>> list = m.datalist(params);
		if (list.size() == 1) {
			String photo = list.get(0).get("photo").toString();
			String p = ContentData.IP_path + photo.substring(2, photo.length());
			System.out.println("photo->" + p);
			params.clear();
			params.add(user_name);
			params.add(p);
			params.add(productname);
			params.add(commont);
			params.add(select);
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

			params.add(formatter.format(date));
			INsertPinLunDao mm = new INsertPinLunDao();
			Boolean f = mm.datalist(params);
			if (f) {
				out.print("1");
			} else {
				out.print("2");
			}
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
	}

}
