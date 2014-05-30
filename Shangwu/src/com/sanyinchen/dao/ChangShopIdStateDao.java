package com.sanyinchen.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sanyinchen.jdbc.JdbcUtils;

public class ChangShopIdStateDao {
	private JdbcUtils jdbcUtils = null;

	public ChangShopIdStateDao() {
		// TODO Auto-generated constructor stub
		jdbcUtils = new JdbcUtils();
	}

	public boolean datalist(List<Object> params) {
		// TODO Auto-generated method stub
		boolean flag = false;
		System.out.println("size: "+params.size());
		for (int i = 0; i < params.size(); i++)
			System.out.println("params: " + params.get(i).toString().trim());
		List<Object> p=new ArrayList<Object>();
		p.add("yangchangshu");
		try {
			jdbcUtils.getConnection();
//			String sql = "select * from product_shop where product_name_buy=? and product_name=? and flag=?";
//			List<Map<String, Object>> list = jdbcUtils.findMoreResult(sql, params);;
//			System.out.println(list.size());
//			System.out.println(list.get(0).toString());
			String sql = "update product_shop set flag=? , product_action=? , product_data=? , product_dingdan=? , product_money=? , product_number=? where product_name_buy=? and product_name=? and flag=?";
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
