package com.sanyinchen.object;

/**
 * �����ˣ�ɡ���� �������� ���ֻ������
 * 
 * @version
 */
public class IdentifyPhoneObject {
	String cur_code;// ��֤��
	String user_id;// �û�ID
	String cur_phone;// �󶨵��ֻ�

	public IdentifyPhoneObject(String cur_code, String user_id, String cur_phone) {
		super();
		this.cur_code = cur_code;
		this.user_id = user_id;
		this.cur_phone = cur_phone;
	}

	public String getCur_code() {
		return cur_code;
	}

	public void setCur_code(String cur_code) {
		this.cur_code = cur_code;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getCur_phone() {
		return cur_phone;
	}

	public void setCur_phone(String cur_phone) {
		this.cur_phone = cur_phone;
	}

}
