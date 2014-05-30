package com.sanyinchen.Contendata;

import com.sanyinchen.dao.GetProductShopDao;

public class BuyState {

	public static String getsellsate(int ch) {
		String str = "";
		ch--;
		switch (ch) {
		case 0:
			str = "订单提交";
			break;
		case 1:
			str = "等待发货";
			break;
		case 2:
			str = "卖家已发货";
			break;
		case 3:
			str = "交易成功";
			break;
		case 4:
			str = "等待发货";
			break;
		}
		return str;
	}

	public static String getsellsate2(int ch) {
		String str = "";
		ch--;
		switch (ch) {
		case 0:
			str = "付款";
			break;
		case 1:
			str = "提醒发货";
			break;
		case 2:
			str = "确认收货";
			break;
		case 3:
			str = "追加评论";
			break;
		case 4:
			str = "提醒发货";
			break;
		}
		return str;
	}
}
