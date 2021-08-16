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
		//s.taobao.com/search?spm\u003da21bo.21814703.201867-links-0.1.5b8b11d931gM0G\u0026q\u003d小黑裙
		
		//https://s.taobao.com/search?spm=a21bo.21814703.201867-links-0.1.5b8b11d931gM0G&q=%E5%B0%8F%E9%BB%91%E8%A3%99&bcoffset=4&p4ppushleft=2%2C48&s=44&ntoffset=4
		//s.taobao.com/search?spm=u003da21bo.21814703.201867-links-0.1.5b8b11d931gM0G&q=小黑裙&bcoffset=4&p4ppushleft\u003d2,48
	}
}
