package com.sanyinchen.Contendata;

public class SellState {

	public static String getsellsate(int ch) {
		String str = "";
		ch--;
		switch (ch) {
		case 0:
			str = "等待付款";
			break;
		case 1:
			str = "买家已付款";
			break;
		case 2:
			str = "等待买家收货";
			break;
		case 3:
			str = "交易成功";
			break;
		case 4:
			str = "等待付款";
			break;
		}
		return str;
	}

	public static String getsellsate2(int ch) {
		String str = "";
		ch--;
		switch (ch) {
		case 0:
			str = "无操作";
			break;
		case 1:
			str = "发货";
			break;
		case 2:
			str = "无操作";
			break;
		case 3:
			str = "追加评论";
			break;
		case 4:
			str = "无操作";
			break;
		}
		return str;
	}
}
