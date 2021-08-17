package com.dyf.grab.test;

import java.net.URLDecoder;

public class TESTURL {
	public static void main(String[] args) {
		//实际的url：
		//https://s.taobao.com/search?spm=a21bo.21814703.201867-links-0.1.5b8b11d931gM0G&q=%E5%B0%8F%E9%BB%91%E8%A3%99&bcoffset=4&p4ppushleft=2%2C48&s=44&ntoffset=4
		//https://s.taobao.com/search?spm=a21bo.21814703.201867-links-0.1.5b8b11d931gM0G&q=小黑裙&bcoffset=4&p4ppushleft=2,48&s=44&ntoffset=4
		
		String url = "s.taobao.com/search?spm\\u003da21bo.21814703.201867-links-0.1.5b8b11d931gM0G\\u0026q\\u003d%E5%B0%8F%E9%BB%91%E8%A3%99\\u0026bcoffset\\u003d4\\u0026p4ppushleft\\u003d2%2C48";
		String urlDecode = URLDecoder.decode(url);
		System.out.println(urlDecode);
		//s.taobao.com/search?spm\u003da21bo.21814703.201867-links-0.1.5b8b11d931gM0G\u0026q\u003d小黑裙\u0026bcoffset\u003d4\u0026p4ppushleft\u003d2,48
		
		url = "https://s.taobao.com/search?spm=a21bo.21814703.201867-links-0.1.5b8b11d931gM0G&q=%E5%B0%8F%E9%BB%91%E8%A3%99&bcoffset=4&p4ppushleft=2%2C48&s=44&ntoffset=4";
		urlDecode = URLDecoder.decode(url);
		System.out.println(urlDecode);
		//https://s.taobao.com/search?spm=a21bo.21814703.201867-links-0.1.5b8b11d931gM0G&q=小黑裙&bcoffset=4&p4ppushleft=2,48&s=44&ntoffset=4
		
		url = "s.taobao.com/search?spm\\u003da21bo.21814703.201867-links-0.1.5b8b11d931gM0G\\u0026q\\u003d%E5%B0%8F%E9%BB%91%E8%A3%99";
		urlDecode = URLDecoder.decode(url);
		System.out.println(urlDecode);
		System.out.println("******************");
		//s.taobao.com/search?spm\u003da21bo.21814703.201867-links-0.1.5b8b11d931gM0G\u0026q\u003d小黑裙
		
		//https://s.taobao.com/search?spm=a21bo.21814703.201867-links-0.1.5b8b11d931gM0G&q=%E5%B0%8F%E9%BB%91%E8%A3%99&bcoffset=4&p4ppushleft=2%2C48&s=44&ntoffset=4
		//s.taobao.com/search?spm=u003da21bo.21814703.201867-links-0.1.5b8b11d931gM0G&q=小黑裙&bcoffset=4&p4ppushleft\u003d2,48
		
		
		String	currentUrl="//s.taobao.com/search?spm\u003da21bo.21814703.201867-links-0.1.5b8b11d931gM0G\u0026q\u003d%E5%B0%8F%E9%BB%91%E8%A3%99";		
		urlDecode = URLDecoder.decode(currentUrl);
		System.out.println(urlDecode);
		String	filter="//s.taobao.com/search?spm\u003da21bo.21814703.201867-links-0.1.5b8b11d931gM0G\u0026q\u003d%E5%B0%8F%E9%BB%91%E8%A3%99\u0026fs\u003d1";
		urlDecode = URLDecoder.decode(filter);
		System.out.println(urlDecode);
		String	sdefault="//s.taobao.com/search?spm\u003da21bo.21814703.201867-links-0.1.5b8b11d931gM0G\u0026q\u003d%E5%B0%8F%E9%BB%91%E8%A3%99";
		urlDecode = URLDecoder.decode(sdefault);
		System.out.println(urlDecode);
		String	nav="//s.taobao.com/search?spm\u003da21bo.21814703.201867-links-0.1.5b8b11d931gM0G\u0026q\u003d%E5%B0%8F%E9%BB%91%E8%A3%99\u0026cps\u003dyes";
		urlDecode = URLDecoder.decode(nav);
		System.out.println(urlDecode);
		String	breadcrumb="//s.taobao.com/search?spm\u003da21bo.21814703.201867-links-0.1.5b8b11d931gM0G\u0026q\u003d%E5%B0%8F%E9%BB%91%E8%A3%99";
		urlDecode = URLDecoder.decode(breadcrumb);
		System.out.println(urlDecode);
		
		String	pager="//s.taobao.com/search?spm\u003da21bo.21814703.201867-links-0.1.5b8b11d931gM0G\u0026q\u003d%E5%B0%8F%E9%BB%91%E8%A3%99\u0026bcoffset\u003d4\u0026p4ppushleft\u003d2%2C48";
		urlDecode = URLDecoder.decode(pager);
		System.out.println(urlDecode);
		pager="https://s.taobao.com/search?spm=a21bo.21814703.201867-links-0.1.5b8b11d931gM0G&q=%E5%B0%8F%E9%BB%91%E8%A3%99&bcoffset=1&p4ppushleft=2%2C48&ntoffset=1&s=88";
		urlDecode = URLDecoder.decode(pager);
		System.out.println(urlDecode);
		//        s.taobao.com/search?spm=a21bo.21814703.201867-links-0.1.5b8b11d931gM0G&q=小黑裙&bcoffset=4&p4ppushleft=2,48
//第二页：https://s.taobao.com/search?spm=a21bo.21814703.201867-links-0.1.5b8b11d931gM0G&q=小黑裙&bcoffset=4&p4ppushleft=2,48&s=44&ntoffset=4
		//第三页：https://s.taobao.com/search?spm=a21bo.21814703.201867-links-0.1.5b8b11d931gM0G&q=%E5%B0%8F%E9%BB%91%E8%A3%99&bcoffset=1&p4ppushleft=2%2C48&ntoffset=1&s=88
//bcoffset=1可以去掉错的也可以的
//ntoffset=1和bcoffset=1是一样的
//s=88 此是页面 第一页的s为44，第二页的s为88，第三页为132，第四页为176，依次类推
		
		//**********销量******************
		System.out.println("**********销量******************");
		String	tab="https://s.taobao.com/search?spm=a21bo.21814703.201867-links-0.1.5b8b11d931gM0G&q=%E5%B0%8F%E9%BB%91%E8%A3%99&bcoffset=268&p4ppushleft=2%2C48&ntoffset=268&sort=sale-desc";
		urlDecode = URLDecoder.decode(tab);
		System.out.println(urlDecode);
		String	sortbar="https://s.taobao.com/search?spm=a21bo.21814703.201867-links-0.1.5b8b11d931gM0G&q=%E5%B0%8F%E9%BB%91%E8%A3%99&bcoffset=0&p4ppushleft=%2C44&ntoffset=268&sort=sale-desc&s=44";
		urlDecode = URLDecoder.decode(sortbar);
		System.out.println(urlDecode);
		sortbar="https://s.taobao.com/search?spm=a21bo.21814703.201867-links-0.1.5b8b11d931gM0G&q=%E5%B0%8F%E9%BB%91%E8%A3%99&bcoffset=0&p4ppushleft=%2C44&ntoffset=268&sort=sale-desc&s=88";
		urlDecode = URLDecoder.decode(sortbar);
		System.out.println(urlDecode);
		// 追加sort=sale-desc即可按销量排序
		//https://s.taobao.com/search?q=%E5%B0%8F%E9%BB%91%E8%A3%99&imgfile=&js=1&stats_click=search_radio_all%3A1&initiative_id=staobaoz_20210817&ie=utf8
		sortbar="https://s.taobao.com/search?q=%E5%B0%8F%E9%BB%91%E8%A3%99&imgfile=&js=1&stats_click=search_radio_all%3A1&initiative_id=staobaoz_20210817&ie=utf8";
		urlDecode = URLDecoder.decode(sortbar);
		System.out.println(urlDecode);
		//https://s.taobao.com/search?q=小黑裙&sort=sale-desc&s=88
		
		System.out.println(false==false);
	}
}
