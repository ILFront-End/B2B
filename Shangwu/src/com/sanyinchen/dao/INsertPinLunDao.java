package com.sanyinchen.dao;

import java.util.List;

import com.sanyinchen.jdbc.JdbcUtils;

public class INsertPinLunDao {
	private JdbcUtils jdbcUtils = null;

	public INsertPinLunDao() {
		// TODO Auto-generated constructor stub
		jdbcUtils = new JdbcUtils();
	}

	public boolean datalist(List<Object> params) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			jdbcUtils.getConnection();
			String sql = "insert into pinlun(user_name,user_photo,product_name,product_content,flag,data) values(?,?,?,?,?,?)";
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
