package com.sanyinchen.object;

/**
 * 创建人：伞银晨 类描述：报名对象类
 * 
 * @version
 */
public class ClassSignDataObject {
	String class_newprice;// 课程新价格
	String class_oldprice;// 课程旧的价格
	String class_area;// 课程上课地点
	String class_image;// 该课程图片小图:158*104
	String class_time;// 上课时间
	String class_phone;// 联系电话
	String class_areashcool;// 授课学校
	String class_name;// 课程名称
	int Cu_id;// 课程id

	public ClassSignDataObject(String class_newprice, String class_oldprice,
			String class_area, String class_image, String class_time,
			String class_phone, String class_areashcool, String class_name,
			int cu_id) {
		super();
		this.class_newprice = class_newprice;
		this.class_oldprice = class_oldprice;
		this.class_area = class_area;
		this.class_image = class_image;
		this.class_time = class_time;
		this.class_phone = class_phone;
		this.class_areashcool = class_areashcool;
		this.class_name = class_name;
		Cu_id = cu_id;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public String getClass_newprice() {
		return class_newprice;
	}

	public void setClass_newprice(String class_newprice) {
		this.class_newprice = class_newprice;
	}

	public String getClass_oldprice() {
		return class_oldprice;
	}

	public void setClass_oldprice(String class_oldprice) {
		this.class_oldprice = class_oldprice;
	}

	public String getClass_area() {
		return class_area;
	}

	public void setClass_area(String class_area) {
		this.class_area = class_area;
	}

	public String getClass_image() {
		return class_image;
	}

	public void setClass_image(String class_image) {
		this.class_image = class_image;
	}

	public String getClass_time() {
		return class_time;
	}

	public void setClass_time(String class_time) {
		this.class_time = class_time;
	}

	public String getClass_phone() {
		return class_phone;
	}

	public void setClass_phone(String class_phone) {
		this.class_phone = class_phone;
	}

	public String getClass_areashcool() {
		return class_areashcool;
	}

	public void setClass_areashcool(String class_areashcool) {
		this.class_areashcool = class_areashcool;
	}

	public int getCu_id() {
		return Cu_id;
	}

	public void setCu_id(int cu_id) {
		Cu_id = cu_id;
	}

}
