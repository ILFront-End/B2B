package com.sanyinchen.object;

/**
 * �����ˣ�ɡ���� ����������ҳ�Ƽ����ݶ���
 * 
 * @version
 */
public class HomeDataObject {
	String class_newprice;// ��ҳ�Ƽ��¼۸�
	String class_oldprice;// ��ҳ�Ƽ��ɵļ۸�
	String class_area;// ��ҳ�Ƽ��Ͽεص�
	String class_image;// �ÿγ�ͼƬСͼ:158*104
    int Cu_id;//����id
	public int getCu_id() {
		return Cu_id;
	}

	public void setCu_id(int cu_id) {
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

	String class_name;// ��ҳ�Ƽ��γ���

	public HomeDataObject(String class_name, String class_newprice,
			String class_oldprice, String class_area, String class_image,int cur_id) {
		super();
		this.class_name = class_name;
		this.class_newprice = class_newprice;
		this.class_oldprice = class_oldprice;
		this.class_area = class_area;
		this.class_image = class_image;
		this.Cu_id=cur_id;
	}

}
