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

import com.sanyinchen.dao.CheckuserDao;

public class GetUserInfo extends HttpServlet {
	private CheckuserDao mCheckuser;

	/**
	 * Constructor of the object.
	 */
	public GetUserInfo() {
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
		String name = request.getParameter("user");
		System.out.println("check--------->" + name);
		List<Object> params = new ArrayList<Object>();
		params.add(name);
		List<Map<String, Object>> list = mCheckuser.datalist(params);
		System.out.println(list.size());
		if (list.size() == 1) {
			// out.println("1");
			Map<String, Object> map = list.get(0);
			String str = map.get("name").toString() + ","
					+ map.get("company").toString() + ","
					+ map.get("phone").toString() + ","
					+ map.get("e_mail").toString();
			out.print(str);
		} else {
			out.println("0");
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
		mCheckuser = new CheckuserDao();
	}

}
