package com.sanyinchen.dao;

import java.util.List;

import com.sanyinchen.jdbc.JdbcUtils;

public class ChangStateDao {
	private JdbcUtils jdbcUtils = null;

	public ChangStateDao() {
		// TODO Auto-generated constructor stub
		jdbcUtils = new JdbcUtils();
	}

	public boolean datalist(List<Object> params) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			jdbcUtils.getConnection();
			String sql = "update product set flag=? where product_title=?";
			flag = jdbcUtils.updateByPreparedStatement(sql, params);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			jdbcUtils.releaseConn();
		}
		return flag;
	}
}
