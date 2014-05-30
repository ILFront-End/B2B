package com.sanyinchen.object;

/**
 * 创建人：伞银晨 类描述： 评价类对象
 * 
 * @version
 */
public class AppraiseDataObject {
	int cur_id;// 给课程ID
	String app_author;// 评价人
	String app_content;// 评价内容
	String app_date;// 评价时间（格式:2014-2-15 3:30）

	public int getCur_id() {
		return cur_id;
	}

	public void setCur_id(int cur_id) {
		this.cur_id = cur_id;
	}

	public String getApp_author() {
		return app_author;
	}

	public void setApp_author(String app_author) {
		this.app_author = app_author;
	}

	public String getApp_content() {
		return app_content;
	}

	public void setApp_content(String app_content) {
		this.app_content = app_content;
	}

	public String getApp_date() {
		return app_date;
	}

	public void setApp_date(String app_date) {
		this.app_date = app_date;
	}

	public AppraiseDataObject(int cur_id, String app_author,
			String app_content, String app_date) {
		super();
		this.cur_id = cur_id;
		this.app_author = app_author;
		this.app_content = app_content;
		this.app_date = app_date;
	}

}
