package com.sanyinchen.object;

/**
 * 创建人：伞银晨 类描述：收藏对象类
 * 
 * @version
 */
public class ShoucahngDataObject {
	String imagepath;// 图片的URL (97*64)
	String cur_newprice;// 课程新价
	String cur_oldprice;// 课程原价
	String cur_name;// 课程的名称
	int cur_id;// 课程ID

	public int getCur_id() {
		return cur_id;
	}

	public void setCur_id(int cur_id) {
		this.cur_id = cur_id;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public String getCur_newprice() {
		return cur_newprice;
	}

	public void setCur_newprice(String cur_newprice) {
		this.cur_newprice = cur_newprice;
	}

	public String getCur_oldprice() {
		return cur_oldprice;
	}

	public void setCur_oldprice(String cur_oldprice) {
		this.cur_oldprice = cur_oldprice;
	}

	public String getCur_name() {
		return cur_name;
	}

	public void setCur_name(String cur_name) {
		this.cur_name = cur_name;
	}

	public ShoucahngDataObject(String imagepath, String cur_newprice,
			String cur_oldprice, String cur_name, int ID) {
		super();
		this.imagepath = imagepath;
		this.cur_newprice = cur_newprice;
		this.cur_oldprice = cur_oldprice;
		this.cur_name = cur_name;
		this.cur_id = ID;
	}

	public ShoucahngDataObject() {

	}
}
