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

	private static final Logger logger = LoggerFactory.getLogger(GetProBaseInfoService.class);

	static String searchUrl = "https://s.taobao.com/search?spm=a21bo.21814703.201867-links-0.1.5b8b11d931gM0G&q=%E5%B0%8F%E9%BB%91%E8%A3%99";
	static String searchUrlOld = "https://s.taobao.com/search?q=%E9%A5%BC%E5%B9%B2&imgfile=&commend=all&ssid=s5-e&search_type=item&sourceId=tb.index&spm=a21bo.2017.201856-taobao-item.1&ie=utf8&initiative_id=tbindexz_20170306";
	static String detailUrl = "https://item.taobao.com/item.htm?spm=a21bo.21814703.201876.23.5af911d93AR81c&id=636080914441&scm=1007.34127.211940.0&pvid=6320062f-8778-4914-9320-13750427afbb";

	static String searchUrlSortBySaleDesc = "https://s.taobao.com/search?q=%E5%B0%8F%E9%BB%91%E8%A3%99&sort=sale-desc";
	//https://s.taobao.com/search?q=小黑裙&&sort=sale-desc&s=88
	
	
	/***
	 * HttpURLConnection 返回json：销量，价格，图片，url等
	 */
	public static void getTop100PagesBySaleDesc() {
		for(int i =0;i<100;i++) {
			if(i!=0) {
				boolean next = getSearchData(searchUrlSortBySaleDesc+"&s="+i*44);
				if(next==false) {
					logger.info("*************异常，不能继续抓取，结束循环*************");
					return ;
				}
				try {
					Thread.sleep(60000);//每分钟抓取一页
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/***
	 * HttpURLConnection 返回json：销量，价格，图片，url等
	 */
	public static boolean getSearchData(String url) {
		try {
			URL realUrl = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("Referer",url);
			connection.setRequestProperty("user-agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
			connection.setRequestProperty("Cookie", "cookie2=1772d44461105d34559ca430eb3a55d9; t=23378de00289acc495460242593650d4; _tb_token_=e0e3fe66534bd; _samesite_flag_=true; xlly_s=2; _m_h5_tk=0d06d24d73e4a527a862f9e7f0826613_1629145853758; _m_h5_tk_enc=7de6410b0a0f2887d8c5f57c0b65637c; thw=cn; cna=lJGhGVBI1QgCAXjlAX3msmew; sgcookie=E100VjipqFRWM2SM8GNR%2FUcGaXrt9CNnukrrh%2BKVnEe6eXB05Hyy55J%2BHIoZ5nINEbL%2FpkB6njiqGOqTGz0s5DDG0cRutoqT1eq63IftU6IkXVk%3D; unb=390575254; uc3=id2=UNk3DRz9%2BLcm&vt3=F8dCujL0kbzPctBSaHQ%3D&nk2=oeDiV1Ry1KsgwA%3D%3D&lg2=VFC%2FuZ9ayeYq2g%3D%3D; csg=69a8f9cb; lgc=%5Cu7F57%5Cu4E16%5Cu662D1917; cancelledSubSites=empty; cookie17=UNk3DRz9%2BLcm; dnk=%5Cu7F57%5Cu4E16%5Cu662D1917; skt=8102301eb4232f16; existShop=MTYyOTEzNjE2OA%3D%3D; uc4=nk4=0%40o6hbTkkexr7h4Hf0h%2FnTikfDUJlX&id4=0%40Ug49tzaXyHx3tbGOaUvekcCeHGs%3D; tracknick=%5Cu7F57%5Cu4E16%5Cu662D1917; _cc_=Vq8l%2BKCLiw%3D%3D; _l_g_=Ug%3D%3D; sg=74b; _nk_=%5Cu7F57%5Cu4E16%5Cu662D1917; cookie1=W8nd1fnMBD4uRacUMbCSu%2BvA6rhfJrDUq0FOxDlH3YA%3D; mt=ci=89_1; uc1=existShop=false&cookie21=U%2BGCWk%2F7owY3j65jYmjW9Q%3D%3D&cookie15=V32FPkk%2Fw0dUvg%3D%3D&pas=0&cookie14=Uoe2xMLaTu0o%2FQ%3D%3D&cookie16=U%2BGCWk%2F74Mx5tgzv3dWpnhjPaQ%3D%3D; enc=H9%2F4e3ZPsTRruOvdhpWepUikDONwNDkTrDI%2BiSbS1CgiNg0GFq4KtXnd0ixFkfF6VSN2qjd875OT1POnI87QtA%3D%3D; _uab_collina=162913686637000062919453; hng=CN%7Czh-CN%7CCNY%7C156; v=0; x5sec=7b227365617263686170703b32223a223535623337336463646538623130386262333936386661306532643337363731434b7a66366f6747454a7a536e70574c3974653045786f4c4d7a6b774e5463314d6a55304f7a456f676f41434d4b6546677037382f2f2f2f2f77453d227d; JSESSIONID=4CF59E97A6BB639EFED55F3F2457DC97; isg=BFBQDbzABcmyANiSXBFcQ3saIZ6iGTRj-VI2ZEohMKt-hfEv8ir-87_zXU1lVew7; tfstk=cPqOBwvz06fg2akLUPQhGJ4Y3yXlaafxOdGDDO0L_5xAV9xvcs39qacuu4WZFbf..; l=eBakzK9HjYUjXdMfBOfZlurza77TRIRfguPzaNbMiOCPOLfH5BGGW6HNYoLMCnGVHsNWR3J4RKM8BbTw-yCqJxpsw3k_J_Vn3dC..");
			// 建立连接
			connection.connect();
			// 请求成功
			logger.info("请求状态：" + connection.getResponseCode());
			if (connection.getResponseCode() == 200) {
				if("".contains("逻辑自行实现")) {
					logger.info("*************逻辑自行实现，被淘宝拦截*************");
					connection.disconnect();
					logger.info("关闭HttpURLConnection连接");
					return false;
				}
				
				InputStream is = connection.getInputStream();
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				// 10MB的缓存
				byte[] buffer = new byte[604857600];
				int len = 0;
				while ((len = is.read(buffer)) != -1) {
					baos.write(buffer, 0, len);
				}
				String jsonString = baos.toString();
				baos.close();
				is.close();
				connection.disconnect();
				if(jsonString.contains("g_page_config")) {
					jsonString = jsonString.split("g_page_config = ")[1].split("g_srp_loadCss")[0].replace("};", "}");
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
						logger.info(iterator.next()+" ");//逐行打印对象信息
					}
					logger.info(i+"");
					
					//TODO list批量入库
				}
			}else {
				//非200 返回异常
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("getLocalizedMessage="+e.getLocalizedMessage()+",getStackTrace="+ e.getStackTrace()+",getMessage="+ e.getMessage()+",getCause="+ e.getCause());
		}
		return true;
	}
	
	

}
