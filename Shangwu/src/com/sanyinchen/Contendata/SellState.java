package com.sanyinchen.Contendata;

public class SellState {

	public static String getsellsate(int ch) {
		String str = "";
		ch--;
		switch (ch) {
		case 0:
			str = "�ȴ�����";
			break;
		case 1:
			str = "����Ѹ���";
			break;
		case 2:
			str = "�ȴ�����ջ�";
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
			str = "�޲���";
			break;
		case 1:
			str = "����";
			break;
		case 2:
			str = "�޲���";
			break;
		case 3:
			str = "׷������";
			break;
		case 4:
			str = "�޲���";
			break;
		}
		return str;
	}
}
