package com.dyf.grab.test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.dyf.grab.util.HTMLUtils;
import com.dyf.grab.util.HttpUtility;

public class test {
	
	private static final Logger logger  = LoggerFactory.getLogger(test.class);
	
	/***
	 *HttpURLConnection 
	 * 抓取详情，返回详情html  
	 *GBK编码
	 */
	static void getDetailData() {
		try {
			String rs = HTMLUtils.
					getHtml("https://item.taobao.com/item.htm?spm=a21bo.21814703.201876.23.5af911d93AR81c&id=636080914441&scm=1007.34127.211940.0&pvid=6320062f-8778-4914-9320-13750427afbb",
					"GBK");
			logger.info(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/***
	 * HttpURLConnection 
	 * 抓取搜索，跳转到登录页面
	 * UTF8编码
	 */
	static void getSearchData() {
		try {
			String rs = HTMLUtils.
					getHtml("https://s.taobao.com/search?spm=a21bo.21814703.201867-links-0.15.5af911d902RNc9&q=%E8%BF%9E%E8%A1%A3%E8%A3%99%E5%A5%B3",
							"UTF-8");
			logger.info(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static String searchUrl="https://s.taobao.com/search?spm=a21bo.21814703.201867-links-0.1.5b8b11d931gM0G&q=%E5%B0%8F%E9%BB%91%E8%A3%99";
	static String searchUrlOld="https://s.taobao.com/search?q=%E9%A5%BC%E5%B9%B2&imgfile=&commend=all&ssid=s5-e&search_type=item&sourceId=tb.index&spm=a21bo.2017.201856-taobao-item.1&ie=utf8&initiative_id=tbindexz_20170306";
	static String detailUrl="https://item.taobao.com/item.htm?spm=a21bo.21814703.201876.23.5af911d93AR81c&id=636080914441&scm=1007.34127.211940.0&pvid=6320062f-8778-4914-9320-13750427afbb";
	
	public static void main(String[] args) {
		logger.info("开始.........");
		
//		getDetailData();//抓取详情，返回详情html 
		
		getSearchDataOk();//返回json：销量，价格，图片，url等
		
//		String rs;
//		try {
//			rs = HTMLUtils.
//					getHtml(detailUrl,
//							"GBK");
//			logger.info(rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		getSearchData();//抓取搜索，跳转到登录页面
//		test3();//URLConnection 需要登录

		logger.info("结束.........");
	}

	/***
	 * HttpURLConnection 返回json：销量，价格，图片，url等
	 */
	static void getSearchDataOk() {
		try {
			//搜索饼干
//			String url = searchUrlOld;//饼干
			String url = searchUrl;
			URL realUrl = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("Referer",
					      //搜索饼干 和上面相同url
//					     "https://s.taobao.com/search?q=%E9%A5%BC%E5%B9%B2&imgfile=&commend=all&ssid=s5-e&search_type=item&sourceId=tb.index&spm=a21bo.2017.201856-taobao-item.1&ie=utf8&initiative_id=tbindexz_20170306");
					searchUrlOld);
			connection.setRequestProperty("user-agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:83.0) Gecko/20100101 Firefox/83.0");
			connection.setRequestProperty("Cookie",
					"_samesite_flag_=TRUE; " + 
					"cookie2=1a63c00c07d4a6500d4a4e64ef2d1c03; " + 
					"v=0; " + 
					"_tb_token_=f71f8e87df34; " + 
					"cookie1=W8nd1fnMBD4uRacUMbCSu%2BvA6rhfJrDUq0FOxDlH3YA%3D; " + 
					"_nk_=%5Cu7F57%5Cu4E16%5Cu662D1917; " + 
					"sg=74b; " + 
					"existShop=MTYyOTAzNDg5Mg%3D%3D; " + 
					"skt=96c7e2bb900036d8; " + 
					"cookie17=UNk3DRz9%2BLcm; " + 
					"cancelledSubSites=empty; " + 
					"csg=26f43eab; " + 
					"tk_trace=oTRxOWSBNwn9evfHtXQifmafmYzSU80EW6dedixskcJ%2Bc8J0R27pVpwR009bxUw3pJYMDEOjj9VTZncJdZFFzzCuQZlwGMRx96hX7Qgs%2B8WvnGGEKg0iVSZgQ9ZswwCA5PFM1WdX%2F1h0B9fxFwjXPklRzA%2F7B%2BKmzb306wRMMEiONCPQMPreyvSyseVTjowL%2F8SFD5mKxGb58nynEq1jef6njBhkqTgTHr2wVc70yM6sUZVJV1pq4QNlI4%2FjYu1rFJvb2DvdZ5d3NFyXVseoK5TEepAVF%2B3PUYZmmOBE5rf8V1STEo0WyHWzEZH4VPX29bxe2yQxzH8mu2fZCLxp3R0NbombH3FtJdis%2FgwNWZpFfPKRCTvQ; " + 
					"unb=390575254; " + 
					"uc1=cookie16=WqG3DMC9UpAPBHGz5QBErFxlCA%3D%3D&cookie21=VT5L2FSpdet1EftGlDZ1Vg%3D%3D&cookie14=Uoe2xMNFr4PGqw%3D%3D&cookie15=WqG3DMC9VAQiUQ%3D%3D&existShop=false&pas=0; " + 
					"_l_g_=Ug%3D%3D; " + 
					"dnk=%5Cu7F57%5Cu4E16%5Cu662D1917; " + 
					"enc=pl3dGg9vuGUe3VyRku4taA8m%2Bz7hGmj3Q7b5Gj0S4WgN2PGNS3QK8Wx72AyzMTjJuBUrTrRI6H2STGP59UCg5A%3D%3D; " + 
					"cna=tOTyEwSd2AECAXF2u/62EilU; " + 
					"miid=2.94754E+17; " + 
					"_cc_=W5iHLLyFfA%3D%3D; " + 
					"tracknick=%5Cu7F57%5Cu4E16%5Cu662D1917; " + 
					"sgcookie=E100GT5%2B9xie5ko2G%2BESO%2BvXJEx%2Fym3c%2BrO7F0LFfo4OtKtWoJ6S%2BfkTFq5ay6Bt63kAUEeUZeoeoE4RrHsz8w3a573qGoUX5W1BkAynQ1vHHXo%3D; " + 
					"hng=CN%7Czh-CN%7CCNY%7C156; " + 
					"thw=cn; " + 
					"l=eBakzK9HjYUjXO6kBOfanurza77OSIRYYuPzaNbMiOCPOkCB5PJhW6Hsim86C3GRh6DvR37Edj_DBeYBqQAonxv9w8VMULkmn; " + 
					"isg=BN_f4mZowo8nZsfPx1z75pBfbjNpRDPmjjvZenEseg7CAP2CeRUHNh7CxJZ-gwte; " + 
					"tfstk=cftfBF0HsSVf5U3a0KMzgFvqwBsONi7mcw1CjB4TisXdksKeYpRYk74GMTf..; " + 
					"t=e4d8d8db956e40c446a2c91e51c99b83; " + 
					"uc4=id4=0%40Ug49tzaXyHx3tbGOaUvfl0%2Bga2Y%3D&nk4=0%40o6hbTkkexr7h4Hf0h%2FnTi%2F6pQlsG; " + 
					"lgc=%5Cu7F57%5Cu4E16%5Cu662D1917; " + 
					"uc3=nk2=oeDiV1Ry1KsgwA%3D%3D&vt3=F8dCujL1txpKa3UCKbc%3D&id2=UNk3DRz9%2BLcm&lg2=UtASsssmOIJ0bQ%3D%3D; " + 
					"mt=ci=89_1; " + 
					"_m_h5_tk_enc=c511251f502f3f099f6abf08fd9b40e5; " + 
					"_m_h5_tk=7f596e05c7f31ba1d10510f4948035ef_1629044223006; " + 
					"xlly_s=2; " + 
					""
					
//					"isg=BKSkHbPtmFr5u-wWzetE4qH9dqKWPcinA1Zw6L7EtW8yaUcz4Ek0N7OLKUHxqgD_; "
//					+ "l=eBIUYKLVjRUD9zzEBO5Cnurza77TzIOV1kPzaNbMiInca6NC1FZm8NCQO6rkRdtfgtfXHFxyyIVnedeDy64dg2HvCbH_7qCkixJ6-; "
//					+ "tfstk=cBiVBPgX1nK2IgrLmoZN1SAldg2Aa_DmIgyQo40dN8ZvHBUu_sYR68XEN8y1WhUc.; cna=RoBIFSzrQFoCAdOQevvZwOn8; miid=518745632110493350; thw=cn; "
//					+ "UM_distinctid=17608fd033d2db-057cbf7fac634f8-4c3f2779-1fa400-17608fd033e412; t=d31becaca80987bb75837c77484d2d98; "
//					+ "_m_h5_tk=e7afd812cbf21125ef802b63c8df94c6_1615710111436; _m_h5_tk_enc=fd3a73ffa66e2b2242…e390a0d829; existShop=MTYxNTcwMDg4Nw%3D%3D; "
//					+ "uc4=id4=0%40U2LDagxTFgkHppc9r9oGtNL7iNUp&nk4=0%40oijaZ6LWXvj5TA1rnr%2B24BPd4g%3D%3D; tracknick=%5Cu7F8E%5Cu4E3E%5Cu7684%5Cu4E8C; "
//					+ "_cc_=Vq8l%2BKCLiw%3D%3D; enc=ZxiYLYwbwjFjE%2F9z8Ry2Ak9smH38MLEK%2Fw6nAKoUZE5RDeYeor0cyWVYpncyvKZHSGpS3MKKCsx6hyn%2FNoJqfg%3D%3D; "
//					+ "JSESSIONID=250725228E4A009D0FBF207D59D02264; hng=CN%7Czh-CN%7CCNY%7C156; mt=ci=0_1; "
//					+ "uc1=pas=0&cookie16=VT5L2FSpNgq6fDudInPRgavC%2BQ%3D%3D&cookie14=Uoe1hx5b4Yrf5A%3D%3D&cookie21=Vq8l%2BKCLjA%2Bl&existShop=false"
					
					);
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
			e.printStackTrace();
			logger.info(e.getLocalizedMessage()+"");
		}
	}
	
	
	/***
	 * URLConnection 需要登录
	 */
	static void test3() {
		// String url =
				// "https://s.taobao.com/search?spm=a230r.1.0.0.3d2936f0doEGnW&q=%E5%A5%B3%E8%A3%85%E5%A4%96%E5%A5%97%E5%86%AC&rs=up&rsclick=7&preq=%E5%A5%B3%E8%A3%852017%E6%96%B0%E6%AC%BE%E6%BD%AE&cps=yes&ppath=413%3A800000782%3B20000%3A123042686%3B122216562%3A47502";
				String url = "https://s.taobao.com/search?spm=a21bo.21814703.201867-links-0.15.5af911d902RNc9&q=%E8%BF%9E%E8%A1%A3%E8%A3%99%E5%A5%B3";
				// String url =
				// "https://s.taobao.com/search?tab=all&ppath=20000:7043912&cat=54900006&q=FLAM&spma=1513693743";

				String rs = HttpUtility.sendGet(url);
				logger.info("返回/r" + rs);
				
//				Map maps = (Map) JSON.parse(rs);
//				Map mapw = new HashMap<>();
//				Object key = null;
//				Object value = null;
//
//				Object proxystring = null;
//				for (Object map : maps.entrySet()) {
//					key = ((Map.Entry) map).getKey();
//					value = ((Map.Entry) map).getValue();
//					mapw.put(key, value);
//					if (key == "totalPage" || key.equals("totalPage")) {
//						proxystring = value;
//					}
//				}
//				logger.info("-----" + proxystring);
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

				logger.info(rs);
	}

}
