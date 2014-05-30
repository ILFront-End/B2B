package com.sanyinchen.object;

/**
 * 创建人：伞银晨 类描述：我的团课对象
 * 
 * @version
 */
public class MyTuankeDataObject {
	String cur_shoucang;// 收藏
	String user_id;// 用户ID
	String cur_buy;// 已报名
	String cur_youhui;// 已获得优惠
	String user_phone;// 电话号码
	String user_name;// 用户昵称
	boolean cur_message;// 是否有消息

	public MyTuankeDataObject(String cur_shoucang, String user_id,
			String cur_buy, String cur_youhui, String user_phone,
			String user_name, boolean cur_message) {
		super();
		this.cur_shoucang = cur_shoucang;
		this.user_id = user_id;
		this.cur_buy = cur_buy;
		this.cur_youhui = cur_youhui;
		this.user_phone = user_phone;
		this.user_name = user_name;
		this.cur_message = cur_message;
	}

	public String getCur_shoucang() {
		return cur_shoucang;
	}

	public void setCur_shoucang(String cur_shoucang) {
		this.cur_shoucang = cur_shoucang;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getCur_buy() {
		return cur_buy;
	}

	public void setCur_buy(String cur_buy) {
		this.cur_buy = cur_buy;
	}

	public String getCur_youhui() {
		return cur_youhui;
	}

	public void setCur_youhui(String cur_youhui) {
		this.cur_youhui = cur_youhui;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public boolean isCur_message() {
		return cur_message;
	}

	public void setCur_message(boolean cur_message) {
		this.cur_message = cur_message;
	}

}
