package com.sanyinchen.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sanyinchen.jdbc.JdbcUtils;

public class GetKindProductDao {
	private JdbcUtils jdbcUtils = null;

	public GetKindProductDao() {
		// TODO Auto-generated constructor stub
		jdbcUtils = new JdbcUtils();
	}

	public List<Map<String, Object>> datalist(int ch,List<Object> params) {
		// TODO Auto-generated method stub
		for (int i = 0; i < params.size(); i++) {
			System.out.println(i +params.get(i).toString()+"end");
		}
		String sql="";
		switch(ch)
		{
		case 1:
			sql = "select * from product where product_1=?";
			break;
		case 2:
			sql = "select * from product where product_2=?";
			break;
		case 3:
			sql = "select * from product where product_3=?";
			break;
		}
		
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
