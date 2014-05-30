package com.sanyinchen.mobileaction;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sanyinchen.mobiledao.SimpleUserDataDao;
import com.sanyinchen.utils.GsonTools;

public class mLoginAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public mLoginAction() {
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

		SimpleUserDataDao mDataDao = new SimpleUserDataDao();
		String LoginError = "LoginError";
		String action_name = request.getParameter("user_name");// 获取分页的页数
		String action_password = request.getParameter("user_password");// 获取条件显示标签:课程的种类

		System.out.println("name------------->" + action_name);
		System.out.println("password------------->" + action_password);
		List<Object> parms = new ArrayList<Object>();
		parms.add(action_name);
		parms.add(action_password);
		List<Object> ll = mDataDao.paramsdata(parms);
		if (ll.size() == 1) {
			String testresult = GsonTools.GsonString(ll);
			System.out.println(testresult);
			out.print(testresult);
		} else {
			out.print(LoginError);// 失败返回信息
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
