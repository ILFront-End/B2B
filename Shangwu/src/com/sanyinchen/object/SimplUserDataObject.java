package com.sanyinchen.object;

public class SimplUserDataObject {
	String user_id;// 用户名
	String user_imagepath;// 用户头像
	String user_phone;// 用户手机

	public SimplUserDataObject(String user_id, String user_imagepath,
			String user_phone) {
		super();
		this.user_id = user_id;
		this.user_imagepath = user_imagepath;
		this.user_phone = user_phone;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_imagepath() {
		return user_imagepath;
	}

	public void setUser_imagepath(String user_imagepath) {
		this.user_imagepath = user_imagepath;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

}
