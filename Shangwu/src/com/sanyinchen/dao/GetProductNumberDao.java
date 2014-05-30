package com.sanyinchen.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sanyinchen.jdbc.JdbcUtils;

public class GetProductNumberDao {
	private JdbcUtils jdbcUtils = null;

	public GetProductNumberDao() {
		// TODO Auto-generated constructor stub
		jdbcUtils = new JdbcUtils();
	}

	public List<Map<String, Object>> datalist(List<Object> params) {
		// TODO Auto-generated method stub
		for (int i = 0; i < params.size(); i++) {
			System.out.println(i +params.get(i).toString()+"end");
		}
		String sql = "select * from product where product_name=?";
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			jdbcUtils.getConnection();
			list = jdbcUtils.findMoreResult(sql, params);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			jdbcUtils.releaseConn();
		}
		return list;
	}

}
