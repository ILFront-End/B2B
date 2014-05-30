package com.sanyinchen.mobiledao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sanyinchen.jdbc.JdbcUtils;
import com.sanyinchen.object.ClassDataObject;

public class GetProductDao {
	private JdbcUtils jdbcUtils = null;

	public GetProductDao() {
		// TODO Auto-generated constructor stub
		jdbcUtils = new JdbcUtils();
	}

	public List<Object> datalist(List<Object> params) {
		// TODO Auto-generated method stub
		List<Object> list2 = new ArrayList<Object>();
		for (int i = 0; i < params.size(); i++) {
			System.out.println(i + params.get(i).toString() + "end");
		}
		String sql = "select * from product where id=?";
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			jdbcUtils.getConnection();
			list = jdbcUtils.findMoreResult(sql, params);

			String[] imagepath = list.get(0).get("product_path").toString()
					.split(",");
			// ClassDataObject dataObject = new ClassDataObject(0, "大学英语四级",
			// "998", "1000", "200", "大学英语四级啊", "只要998，大学英语四级抱回家",
			// imagepath[0]);
			ClassDataObject dataObject = new ClassDataObject(0, ""
					+ Integer.valueOf(list.get(0).get("product_price")
							.toString()), Integer.valueOf(list.get(0)
					.get("product_price").toString())
					* 2 + "", list.get(0).get("buynumber").toString(), list
					.get(0).get("product_other").toString(), list.get(0)
					.get("product_other").toString(), imagepath[0], "",
					imagepath[1], list.get(0).get("data").toString(), "", "",
					list.get(0).get("product_name").toString());
			list2.add(dataObject);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			jdbcUtils.releaseConn();
		}
		return list2;
	}

}
