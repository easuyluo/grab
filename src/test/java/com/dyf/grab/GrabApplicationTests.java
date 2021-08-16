package com.dyf.grab;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import com.alibaba.fastjson.JSON;
import com.dyf.grab.test.test;
import com.dyf.grab.util.HTMLUtils;
import com.dyf.grab.util.HttpUtility;

@SpringBootTest
class GrabApplicationTests {

	@Test
	void contextLoads() {
		
	}
	
	private static final Logger logger  = LoggerFactory.getLogger(GrabApplicationTests.class);
	
	public static void main(String[] args) {
		logger.info("开始.........");
		
//		test1();//HttpURLConnection方式失败 javax.net.ssl.SSLException: Received fatal alert: internal_error
		test2();//HttpURLConnection
//		test3();//URLConnection方式失败 java.net.ConnectException: Connection refused: connect

		logger.info("结束.........");
	}
	
	/***
	 * URLConnection方式失败
	 */
	static void test3() {
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
				logger.info("-----" + proxystring);
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

				logger.info(pageNum);
	}
	
	/***
	 * HttpURLConnection方式失败
	 */
	static void test1() {
		try {
			String rs = HTMLUtils.getHtml("https://detail.tmall.com/item.htm?id=619932533738&spm=a21bo.21814703.201876.15.5af911d9KcTytz&scm=1007.34127.211940.0&pvid=256e3b7e-82b9-435a-9564-7acf019d0e5e","UTF-8");
			logger.info(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/***
	 * HttpURLConnection
	 */
	@Test
	static void test2() {
		try {
			String url = "https://s.taobao.com/search?q=%E9%A5%BC%E5%B9%B2&imgfile=&commend=all&ssid=s5-e&search_type=item&sourceId=tb.index&spm=a21bo.2017.201856-taobao-item.1&ie=utf8&initiative_id=tbindexz_20170306";
			URL realUrl = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("Referer",
					"https://s.taobao.com/search?q=%E9%A5%BC%E5%B9%B2&imgfile=&commend=all&ssid=s5-e&search_type=item&sourceId=tb.index&spm=a21bo.2017.201856-taobao-item.1&ie=utf8&initiative_id=tbindexz_20170306");
			connection.setRequestProperty("user-agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:83.0) Gecko/20100101 Firefox/83.0");
			connection.setRequestProperty("Cookie",
					"isg=BKSkHbPtmFr5u-wWzetE4qH9dqKWPcinA1Zw6L7EtW8yaUcz4Ek0N7OLKUHxqgD_; l=eBIUYKLVjRUD9zzEBO5Cnurza77TzIOV1kPzaNbMiInca6NC1FZm8NCQO6rkRdtfgtfXHFxyyIVnedeDy64dg2HvCbH_7qCkixJ6-; tfstk=cBiVBPgX1nK2IgrLmoZN1SAldg2Aa_DmIgyQo40dN8ZvHBUu_sYR68XEN8y1WhUc.; cna=RoBIFSzrQFoCAdOQevvZwOn8; miid=518745632110493350; thw=cn; UM_distinctid=17608fd033d2db-057cbf7fac634f8-4c3f2779-1fa400-17608fd033e412; t=d31becaca80987bb75837c77484d2d98; _m_h5_tk=e7afd812cbf21125ef802b63c8df94c6_1615710111436; _m_h5_tk_enc=fd3a73ffa66e2b2242…e390a0d829; existShop=MTYxNTcwMDg4Nw%3D%3D; uc4=id4=0%40U2LDagxTFgkHppc9r9oGtNL7iNUp&nk4=0%40oijaZ6LWXvj5TA1rnr%2B24BPd4g%3D%3D; tracknick=%5Cu7F8E%5Cu4E3E%5Cu7684%5Cu4E8C; _cc_=Vq8l%2BKCLiw%3D%3D; enc=ZxiYLYwbwjFjE%2F9z8Ry2Ak9smH38MLEK%2Fw6nAKoUZE5RDeYeor0cyWVYpncyvKZHSGpS3MKKCsx6hyn%2FNoJqfg%3D%3D; JSESSIONID=250725228E4A009D0FBF207D59D02264; hng=CN%7Czh-CN%7CCNY%7C156; mt=ci=0_1; uc1=pas=0&cookie16=VT5L2FSpNgq6fDudInPRgavC%2BQ%3D%3D&cookie14=Uoe1hx5b4Yrf5A%3D%3D&cookie21=Vq8l%2BKCLjA%2Bl&existShop=false");
			// 建立实际的连接
			connection.connect();
			// 请求成功
			logger.info("请求状态：" + connection.getResponseCode());
//	        if (connection.getResponseCode() == 200) {
			InputStream is = connection.getInputStream();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			// 10MB的缓存
			byte[] buffer = new byte[604857600];
			int len = 0;
			while ((len = is.read(buffer)) != -1) {
				baos.write(buffer, 0, len);
			}
			String jsonString = baos.toString();
			logger.info("jsonString:" + jsonString);
			baos.close();
			is.close();
			// 转换成json数据处理
//	        }
		} catch (Exception e) {
			logger.info(e.getMessage()+"");
		}
	}
}
