package com.sanyinchen.object;

/**
 * �����ˣ�ɡ���� �������� �γ���
 * 
 * @version
 */
public class ClassDataObject {
	int mc_id;// �γ�ID
	String mc_newprice;// �γ̵��ּ�
	String mc_oldprice;// �γ�ԭ��
	String mc_people;// �ÿγ��ж����˱���
	String mc_simplec;// �ÿγ̼��
	String mc_c;// �ÿγ̽���
	String mc_image;// �ÿγ�URl��ͼ600*235
	String class_area;// �γ��Ͽεص�
	String class_image;// �ÿγ�ͼƬСͼ:158*104
	String class_time;// �Ͽ�ʱ��
	String class_phone;// ��ϵ�绰
	String class_areashcool;// �ڿ�ѧУ
	String class_name;// �γ�����

	public ClassDataObject(int mc_id, String mc_newprice, String mc_oldprice,
			String mc_people, String mc_simplec, String mc_c, String mc_image,
			String class_area, String class_image, String class_time,
			String class_phone, String class_areashcool, String class_name) {
		super();
		this.mc_id = mc_id;
		this.mc_newprice = mc_newprice;
		this.mc_oldprice = mc_oldprice;
		this.mc_people = mc_people;
		this.mc_simplec = mc_simplec;
		this.mc_c = mc_c;
		this.mc_image = mc_image;
		this.class_area = class_area;
		this.class_image = class_image;
		this.class_time = class_time;
		this.class_phone = class_phone;
		this.class_areashcool = class_areashcool;
		this.class_name = class_name;
	}

	public int getMc_id() {
		return mc_id;
	}

	public void setMc_id(int mc_id) {
		this.mc_id = mc_id;
	}

	public String getMc_newprice() {
		return mc_newprice;
	}

	public void setMc_newprice(String mc_newprice) {
		this.mc_newprice = mc_newprice;
	}

	public String getMc_oldprice() {
		return mc_oldprice;
	}

	public void setMc_oldprice(String mc_oldprice) {
		this.mc_oldprice = mc_oldprice;
	}

	public String getMc_people() {
		return mc_people;
	}

	public void setMc_people(String mc_people) {
		this.mc_people = mc_people;
	}

	public String getMc_simplec() {
		return mc_simplec;
	}

	public void setMc_simplec(String mc_simplec) {
		this.mc_simplec = mc_simplec;
	}

	public String getMc_c() {
		return mc_c;
	}

	public void setMc_c(String mc_c) {
		this.mc_c = mc_c;
	}

	public String getMc_image() {
		return mc_image;
	}

	public void setMc_image(String mc_image) {
		this.mc_image = mc_image;
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

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

}
