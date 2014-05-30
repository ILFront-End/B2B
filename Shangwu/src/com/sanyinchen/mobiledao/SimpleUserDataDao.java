package com.sanyinchen.mobiledao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.AbstractDocument.Content;

import com.sanyinchen.Contendata.ContentData;
import com.sanyinchen.jdbc.JdbcUtils;
import com.sanyinchen.object.SimplUserDataObject;

/**
 * 创建人：伞银晨 类描述：手机团课list数据接口
 * 
 * @version
 */
public class SimpleUserDataDao {
	private JdbcUtils jdbcUtils = null;

	public List<Object> paramsdata(List<Object> params) {
		// TODO Auto-generated method stub
		List<Object> list2 = new ArrayList<Object>();
		String imagepath = ContentData.IP_path;
		// SimplUserDataObject object = new SimplUserDataObject("yangchangshu",
		// imagepath, "1888888888");
		// for (int i = 0; i < 5; i++) {
		// list.add(object);
		// }
		jdbcUtils = new JdbcUtils();
		String sql = "select * from userinfo where user_id=? and pswd=?";
		// List<Map<String, Object>> list = new ArrayList<Map<String,
		// Object>>();
		try {
			jdbcUtils.getConnection();
			Map<String, Object> result = jdbcUtils
					.findSimpleResult(sql, params);
			if (!result.isEmpty()) {
				SimplUserDataObject object = new SimplUserDataObject(result
						.get("user_id").toString(),
						ContentData.IP_path
								+ result.get("photo")
										.toString()
										.substring(
												2,
												result.get("photo").toString()
														.length()), result.get(
								"phone").toString());
				list2.add(object);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			jdbcUtils.releaseConn();
		}
		return list2;
	}

}
