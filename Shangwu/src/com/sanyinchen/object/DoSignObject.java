package com.sanyinchen.object;

/**
 * �����ˣ�ɡ���� �������� ��������
 * 
 * @version
 */
public class DoSignObject {
	String cur_id;// �γ�ID
	String cur_code;// �ÿγ���֤��
	String cur_name;// �ÿγ�����

	public DoSignObject(String cur_id, String cur_code, String cur_name) {
		super();
		this.cur_id = cur_id;
		this.cur_code = cur_code;
		this.cur_name = cur_name;
	}

	public String getCur_id() {
		return cur_id;
	}

	public void setCur_id(String cur_id) {
		this.cur_id = cur_id;
	}

	public String getCur_code() {
		return cur_code;
	}

	public void setCur_code(String cur_code) {
		this.cur_code = cur_code;
	}

	public String getCur_name() {
		return cur_name;
	}

	public void setCur_name(String cur_name) {
		this.cur_name = cur_name;
	}

}
