package com.dyf.grab.action.service;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dyf.grab.entity.TBSearchRsInfo;
import com.dyf.grab.test.test;

public class GetProBaseInfoService {

	private static final Logger logger = LoggerFactory.getLogger(test.class);

	static String searchUrl = "https://s.taobao.com/search?spm=a21bo.21814703.201867-links-0.1.5b8b11d931gM0G&q=%E5%B0%8F%E9%BB%91%E8%A3%99";
	static String searchUrlOld = "https://s.taobao.com/search?q=%E9%A5%BC%E5%B9%B2&imgfile=&commend=all&ssid=s5-e&search_type=item&sourceId=tb.index&spm=a21bo.2017.201856-taobao-item.1&ie=utf8&initiative_id=tbindexz_20170306";
	static String detailUrl = "https://item.taobao.com/item.htm?spm=a21bo.21814703.201876.23.5af911d93AR81c&id=636080914441&scm=1007.34127.211940.0&pvid=6320062f-8778-4914-9320-13750427afbb";

	/***
	 * HttpURLConnection 返回json：销量，价格，图片，url等
	 */
	public static void getSearchDataOk() {
		try {
			String url = searchUrl;
			URL realUrl = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("Referer",searchUrl);
			connection.setRequestProperty("user-agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:83.0) Gecko/20100101 Firefox/83.0");
			connection.setRequestProperty("Cookie", "_cc_=U%2BGCWk%2F7og%3D%3D;" + 
					"_l_g_=Ug%3D%3D;" + 
					"_nk_=%5Cu7F57%5Cu4E16%5Cu662D1917;" + 
					"_samesite_flag_=TRUE;" + 
					"_tb_token_=f33de6837d37e;" + 
					"atpsida=366ab72c8fae715764dd4cdd_1629114720_2;" + 
					"atpsidas=c9b8bbb40dcd460dbe7bf052_1629114702_1;" + 
					"aui=390575254;" + 
					"cancelledSubSites=empty;" + 
					"cna=tOTyEwSd2AECAXF2u/62EilU;" + 
					"cna=tOTyEwSd2AECAXF2u/62EilU;" + 
					"cna=tOTyEwSd2AECAXF2u/62EilU;" + 
					"cnaui=390575254;" + 
					"cnaui=390575254;" + 
					"cookie1=W8nd1fnMBD4uRacUMbCSu%2BvA6rhfJrDUq0FOxDlH3YA%3D;" + 
					"cookie17=UNk3DRz9%2BLcm;" + 
					"cookie2=19a05c85935ee38270744a99cd8aafba;" + 
					"csg=0d1a3f4d;" + 
					"dnk=%5Cu7F57%5Cu4E16%5Cu662D1917;" + 
					"existShop=MTYyOTExNDcxOQ%3D%3D;" + 
					"isg=BL6-xZBRU3MVTIYIPjfKKXkUD9QA_4J5u2yIXmjHKoH8C17l0I_SieTph9fHKHqR;" + 
					"l=eBakzK9HjYUjX-ISBOfanurza77OSIRYYuPzaNbMiOCPO35B5UJPW6HasE86C3GVh6D6R3J4RKMJBeYBqQAonxv9w8VMULkmn;" + 
					"lgc=%5Cu7F57%5Cu4E16%5Cu662D1917;" + 
					"mt=ci=89_1;" + 
					"sca=b41e96a3;" + 
					"sg=74b;" + 
					"sgcookie=E100G4ynAVLA3xFsAsCpMgXf6nhQ2Vn4ZHZKXxBMCiWv54ZNHyRBWx%2B0BDjOq79uT5Bd42Dm2msOWabOMz8scLt%2B3OGgHaU%2FJ6BtEz4%2BKRyQj1c%3D;" + 
					"skt=16dce4f9eabc6e26;" + 
					"t=93cc5b4cd83e54338a7d80349f34b4bd;" + 
					"tbsa=6d517a5c2575584e1b62fb02_1629114720_2;" + 
					"tfstk=c00PB_sqrULzvMzBXzaePkhOJccRwRlotZP_qmF1p32s-7fAXvHAEdOQ1Tsd.;" + 
					"thw=cn;" + 
					"tracknick=%5Cu7F57%5Cu4E16%5Cu662D1917;" + 
					"ubn=p;" + 
					"uc1=cookie16=UtASsssmPlP%2Ff1IHDsDaPRu%2BPw%3D%3D&existShop=false&cookie15=W5iHLLyFOGW7aA%3D%3D&cookie21=WqG3DMC9Edo1SB5NB6Qtng%3D%3D&cookie14=Uoe2xMLYETsfBw%3D%3D&pas=0;" + 
					"uc3=vt3=F8dCujL0kxKRi%2FMP%2F2w%3D&lg2=VT5L2FSpMGV7TQ%3D%3D&nk2=oeDiV1Ry1KsgwA%3D%3D&id2=UNk3DRz9%2BLcm;" + 
					"uc4=id4=0%40Ug49tzaXyHx3tbGOaUvekydIvCk%3D&nk4=0%40o6hbTkkexr7h4Hf0h%2FnTikUEtE7C;" + 
					"ucn=center;" + 
					"unb=390575254;" + 
					"xlly_s=2;" + 
					"");
			// 建立连接
			connection.connect();
			// 请求成功
			logger.info("请求状态：" + connection.getResponseCode());
			if (connection.getResponseCode() == 200) {
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
				if(jsonString.contains("g_page_config")) {
					// 转换成json数据处理
					JSONObject object = JSONObject.parseObject(jsonString);
					JSONObject mods = (JSONObject) object.get("mods");
					JSONObject itemlist = (JSONObject) mods.get("itemlist");
					JSONObject data = (JSONObject) itemlist.get("data");
					JSONArray jsonArray = data.getJSONArray("auctions");
					
					List<TBSearchRsInfo> result;
					result = JSON.parseArray(jsonArray.toJSONString(), TBSearchRsInfo.class);
					int i =0;
					for (Iterator iterator = result.iterator(); iterator.hasNext(); ) {
						i++;
						logger.info(iterator.next()+" ");
					}
					logger.info(i+"");
					
					//TODO list批量入库
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info(e.getLocalizedMessage() + "");
		}
	}

}
