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

import com.sanyinchen.dao.GetAllPinLunDao;
import com.sanyinchen.dao.GetSomePinLunDao;

public class GetSomePinLun extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public GetSomePinLun() {
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
		String str = request.getParameter("product_name");
		String flag = request.getParameter("flag");
		System.out.println("str->" + str);
		System.out.println("flag->" + flag);
		List<Object> list2 = new ArrayList<Object>();
		list2.add(str.trim());
		list2.add(flag.trim());
		GetSomePinLunDao m = new GetSomePinLunDao();
		List<Map<String, Object>> list = m.datalist(list2);
		if (list != null) {
			String Str = "";
			for (int i = 0; i < list.size(); i++) {
				Str += list.get(i).get("user_photo").toString() + ","
						+ list.get(i).get("user_name").toString() + ","
						+ list.get(i).get("data").toString() + ","
						+ list.get(i).get("product_content").toString();
				if (i != list.size() - 1)
					Str += ",";
			}
			System.out.println(Str);
			out.print(Str);
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
