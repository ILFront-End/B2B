package com.sanyinchen.dao;

import java.util.List;

import com.sanyinchen.jdbc.JdbcUtils;

public class Resiger {
	private JdbcUtils jdbcUtils = null;

	public Resiger() {
		// TODO Auto-generated constructor stub
		jdbcUtils = new JdbcUtils();
	}

	public boolean datalist(List<Object> params) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			jdbcUtils.getConnection();
			String sql = "insert into userinfo(user_id,pswd,name,company,e_mail,phone,photo,companyarea) values(?,?,?,?,?,?,?,?)";
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
