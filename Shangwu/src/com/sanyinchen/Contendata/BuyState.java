package com.sanyinchen.Contendata;

import com.sanyinchen.dao.GetProductShopDao;

public class BuyState {

	public static String getsellsate(int ch) {
		String str = "";
		ch--;
		switch (ch) {
		case 0:
			str = "�����ύ";
			break;
		case 1:
			str = "�ȴ�����";
			break;
		case 2:
			str = "�����ѷ���";
			break;
		case 3:
			str = "���׳ɹ�";
			break;
		case 4:
			str = "�ȴ�����";
			break;
		}
		return str;
	}

	public static String getsellsate2(int ch) {
		String str = "";
		ch--;
		switch (ch) {
		case 0:
			str = "����";
			break;
		case 1:
			str = "���ѷ���";
			break;
		case 2:
			str = "ȷ���ջ�";
			break;
		case 3:
			str = "׷������";
			break;
		case 4:
			str = "���ѷ���";
			break;
		}
		return str;
	}
}
