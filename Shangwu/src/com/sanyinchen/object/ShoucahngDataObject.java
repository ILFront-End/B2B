package com.sanyinchen.object;

/**
 * �����ˣ�ɡ���� ���������ղض�����
 * 
 * @version
 */
public class ShoucahngDataObject {
	String imagepath;// ͼƬ��URL (97*64)
	String cur_newprice;// �γ��¼�
	String cur_oldprice;// �γ�ԭ��
	String cur_name;// �γ̵�����
	int cur_id;// �γ�ID

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
