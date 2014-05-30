package com.sanyinchen.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sanyinchen.jdbc.JdbcUtils;

public class ProductShopDao {
	private JdbcUtils jdbcUtils = null;

	public ProductShopDao() {
		// TODO Auto-generated constructor stub
		jdbcUtils = new JdbcUtils();
	}

	public boolean datalist(Map<String, Object> map) {
		boolean flag = false;
		try {// TODO Auto-generated method stub
			jdbcUtils.getConnection();

			String product_name = map.get("poduct_name").toString().trim();
			System.out.println("key= " + product_name);
			String sql = "select * from product where product_name=? and flag=1";
			List<Object> l = new ArrayList<Object>();
			l.add(product_name);
			Map<String, Object> m_map = jdbcUtils.findSimpleResult(sql, l);
			System.out.println(m_map.toString());
			String[] path = m_map.get("product_path").toString().split(",");
			List<Object> params = new ArrayList<Object>();
			params.add(product_name);
			params.add(m_map.get("user_name").toString());
			params.add(map.get("buyer").toString());
			params.add(path[0]);
			params.add(map.get("product_oher").toString());
			params.add(map.get("product_price").toString());
			params.add("0");
			params.add("0");
			params.add("0");
			params.add("0");
			params.add("0");
			params.add("0");
			
			System.out.println(params.size());
			String sql_insert = "insert into product_shop(product_name,product_name_seller,product_name_buy,product_path,product_other,product_price,product_number,product_money,product_dingdan,product_action,flag,product_data) values(?,?,?,?,?,?,?,?,?,?,?,?)";
			flag = jdbcUtils.updateByPreparedStatement(sql_insert, params);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			jdbcUtils.releaseConn();
		}
		return flag;
	}

}
