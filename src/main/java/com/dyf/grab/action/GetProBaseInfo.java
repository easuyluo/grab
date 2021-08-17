package com.dyf.grab.action;

import com.dyf.grab.action.service.GetProBaseInfoService;

public class GetProBaseInfo {
	public static void main(String[] args) {
		GetProBaseInfoService.getTop100PagesBySaleDesc();//返回json：销量，价格，图片，url等
	}
}
