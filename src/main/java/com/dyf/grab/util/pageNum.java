package com.dyf.grab.util;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class pageNum {
	public static void main(String[] args) {

		// String url =
		// "https://s.taobao.com/search?spm=a230r.1.0.0.3d2936f0doEGnW&q=%E5%A5%B3%E8%A3%85%E5%A4%96%E5%A5%97%E5%86%AC&rs=up&rsclick=7&preq=%E5%A5%B3%E8%A3%852017%E6%96%B0%E6%AC%BE%E6%BD%AE&cps=yes&ppath=413%3A800000782%3B20000%3A123042686%3B122216562%3A47502";
		String url = "http://api.s.m.taobao.com/search.json?m=shopitemsearch&sellerId=196993935&n=40&orderType=hotsell_desc&ajax=true";
		// String url =
		// "https://s.taobao.com/search?tab=all&ppath=20000:7043912&cat=54900006&q=FLAM&spma=1513693743";

		String pageNum = HttpUtility.sendGet(url);

		Map maps = (Map) JSON.parse(pageNum);
		Map mapw = new HashMap<>();
		Object key = null;
		Object value = null;

		Object proxystring = null;
		for (Object map : maps.entrySet()) {
			key = ((Map.Entry) map).getKey();
			value = ((Map.Entry) map).getValue();
			mapw.put(key, value);
			if (key == "totalPage" || key.equals("totalPage")) {
				proxystring = value;
			}
		}
		System.out.println("-----" + proxystring);
		/*
		 * String JsonStr = RegexUtils2.regexFirst(pageNum,
		 * "g_page_config = (.*?)\\}\\};")+"}}"; // String JsonStr =
		 * RegexUtils2.regexFirst(pageNum, "jsonp873\\((.*?)\\}\\}\\);")+"}}";
		 * 
		 * 
		 * Object mods = JSON.parseObject(JsonStr).get("mods");
		 * 
		 * Object sortbar = JSON.parseObject(mods.toString()).get("sortbar");
		 * 
		 * Object data = JSON.parseObject(sortbar.toString()).get("data");
		 * 
		 * Object pager = JSON.parseObject(data.toString()).get("pager");
		 * 
		 * Object totalPage = JSON.parseObject(pager.toString()).get("totalPage");
		 */

		System.out.println(pageNum);

	}
}
