package com.sanyinchen.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sanyinchen.jdbc.JdbcUtils;

public class GetAllPinLunDao {
	private JdbcUtils jdbcUtils = null;

	public GetAllPinLunDao() {
		// TODO Auto-generated constructor stub
		jdbcUtils = new JdbcUtils();
	}

	public List<Map<String, Object>> datalist(List<Object> p) {
		// TODO Auto-generated method stub

		String sql = "select * from pinlun where product_name=?";
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			jdbcUtils.getConnection();
			list = jdbcUtils.findMoreResult(sql, p);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			jdbcUtils.releaseConn();
		}
		return list;
	}

}
