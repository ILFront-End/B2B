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

import com.sanyinchen.dao.ChangShopIdStateDao;
import com.sanyinchen.dao.ChangeProductIdDap;
import com.sanyinchen.dao.GetProductNumberDao;
import com.sanyinchen.object.ProductSendObject;

public class SenProductAction extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SenProductAction() {
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
		GetProductNumberDao mGetProductNumberDao;
		ChangeProductIdDap mChangeProductIdDap;
		ChangShopIdStateDao mChangShopIdStateDao;
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String message = request.getParameter("message");
		System.out.println("message--->" + message);
		String[] id = message.split(",");
		for (int i = 0; i < id.length; i++)
			System.out.println(i + id[i]);
		ProductSendObject[] products = new ProductSendObject[id.length / 7];
		List<Object> parms = new ArrayList<Object>();
		List<Map<String, Object>> list = null;
		// boolean flag=false;
		for (int i = 0, t = 0; i < id.length; i += 7, t++) {
			products[t] = new ProductSendObject(id[i].trim(), id[i + 1].trim(),
					id[i + 2].trim(), id[i + 3].trim(), id[i + 4].trim(),
					id[i + 5].trim(), id[i + 6].trim());
		}

		for (int i = 0; i < products.length; i++)
			System.out.println("products---->" + products[i].toString());
		for (int t = 0; t < products.length; t++) {
			mGetProductNumberDao = new GetProductNumberDao();
			parms.clear();
			parms.add(products[t].getProduct_name().trim());
			System.out.println("获取商品数量");
			list = mGetProductNumberDao.datalist(parms);
			int number = Integer.valueOf(list.get(0).get("product_number")
					.toString());
			System.out.println("数量为:" + number);
			if (number - Integer.valueOf(products[t].getProduct_number()) >= 0) {

				number = number
						- Integer.valueOf(products[t].getProduct_number());

				parms.clear();
				parms.add(number + "");
				parms.add(Integer.valueOf(products[t].getProduct_number()));
				parms.add(products[t].getProduct_name());
				System.out.println("修改元产品表数量");
				mChangeProductIdDap = new ChangeProductIdDap();

				Boolean f = mChangeProductIdDap.datalist(parms);
				if (f)
					System.out.println("数量修改成功");
				else
					System.out.println("数量修改失败");
				parms.clear();
				String product_id = System.currentTimeMillis() + "";
				Date date = new Date();
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String data = formatter.format(date);
				parms.add("1");
				parms.add("付款");
				parms.add(data);
				parms.add(product_id);
				parms.add(products[t].getProduct_money());
				parms.add(products[t].getProduct_number());
				parms.add(products[t].getUser_name());
				parms.add(products[t].getProduct_name());
				parms.add("0");
				mChangShopIdStateDao = new ChangShopIdStateDao();
				if (mChangShopIdStateDao.datalist(parms)) {
					System.out.println("订单修改成功");
				} else {
					System.out.println("订单修改失败");
				}

			} else {
				System.out.println("产品数量错误");
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
