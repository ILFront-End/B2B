package com.sanyinchen.object;

/**
 * �����ˣ�ɡ���� ������������������
 * 
 * @version
 */
public class ClassSignDataObject {
	String class_newprice;// �γ��¼۸�
	String class_oldprice;// �γ̾ɵļ۸�
	String class_area;// �γ��Ͽεص�
	String class_image;// �ÿγ�ͼƬСͼ:158*104
	String class_time;// �Ͽ�ʱ��
	String class_phone;// ��ϵ�绰
	String class_areashcool;// �ڿ�ѧУ
	String class_name;// �γ�����
	int Cu_id;// �γ�id

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
