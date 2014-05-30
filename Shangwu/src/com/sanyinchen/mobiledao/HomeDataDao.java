package com.sanyinchen.mobiledao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.AbstractDocument.Content;

import com.sanyinchen.jdbc.JdbcUtils;
import com.sanyinchen.object.HomeDataObject;

/**
 * 创建人：伞银晨 类描述：手机首页list数据接口
 * 
 * @version
 */
public class HomeDataDao {
	private JdbcUtils jdbcUtils = null;

	public List<Object> paramsdata() {
		// TODO Auto-generated method stub
		List<Object> listdata = new ArrayList<Object>();
		jdbcUtils = new JdbcUtils();

		String sql = "select * from product where flag=1";
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			jdbcUtils.getConnection();
			list = jdbcUtils.findMoreResult(sql, null);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			jdbcUtils.releaseConn();
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + " " + list.get(i).toString());
			String[] path = list.get(i).get("product_path").toString()
					.split(",");
			String class_name = list.get(i).get("product_name").toString();
			String class_newprice = list.get(i).get("product_price").toString();
			String class_oldprice = Integer.valueOf(list.get(i)
					.get("product_price").toString())
					* 2 + "";
			String class_area = list.get(i).get("user_name").toString();
			String class_image = path[0];
			int cur_id = Integer.valueOf(list.get(i).get("id").toString());
			HomeDataObject mDataObject = new HomeDataObject(class_name,
					class_newprice, class_oldprice, class_area, class_image,
					cur_id);
			listdata.add(mDataObject);

		}
		// String imagepath = content.IP + "test_class_image.png";
		//
		// for (int i = 0; i < 10; i++) {
		// HomeDataObject dataObject = new HomeDataObject("大学英语四级", "400",
		// "800", "金石滩A区501", imagepath, i);
		// list.add(dataObject);
		// }

		return listdata;
	}

}
