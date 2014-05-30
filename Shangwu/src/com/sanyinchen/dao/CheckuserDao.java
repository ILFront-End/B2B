package com.sanyinchen.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sanyinchen.jdbc.JdbcUtils;


public class CheckuserDao {
	private JdbcUtils jdbcUtils = null;

	public CheckuserDao() {
		// TODO Auto-generated constructor stub
		jdbcUtils = new JdbcUtils();
	}

	public List<Map<String, Object>> datalist(List<Object> params) {
		// TODO Auto-generated method stub
		String sql = "select * from userinfo where user_id=?";
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			jdbcUtils.getConnection();
			Map<String, Object> result = jdbcUtils
					.findSimpleResult(sql, params);
			if (!result.isEmpty())
				list.add(result);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			jdbcUtils.releaseConn();
		}
		return list;
	}

}
