package com.sanyinchen.dao;

import java.util.List;

import com.sanyinchen.jdbc.JdbcUtils;

public class ProductDao {
	private JdbcUtils jdbcUtils = null;

	public ProductDao() {
		// TODO Auto-generated constructor stub
		jdbcUtils = new JdbcUtils();
	}

	public boolean datalist(List<Object> params) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			jdbcUtils.getConnection();
			String sql = "insert into product(product_name,product_price,product_1,product_2,product_3,product_title,product_number,product_other,product_path,user_name,user_rename,user_company,user_phone,user_email,flag,buynumber,data) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
