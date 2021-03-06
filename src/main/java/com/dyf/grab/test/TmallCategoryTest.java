//package com.dyf.grab.test;
//
//import java.text.MessageFormat;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
// 
//import javax.script.ScriptException;
// 
//import org.apache.commons.lang.StringEscapeUtils;
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
// 
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
//import com.pengjunlee.common.utils.SpiderHttpUtils;
//import com.pengjunlee.tmall.dao.CategoryDao;
//import com.pengjunlee.tmall.domain.CategoryEntity;
// 
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class TmallCategoryTest {
// 
//	private static final Gson gson = new Gson();
// 
//	@Autowired
//	private CategoryDao dao;
// 
//	/**
//	 * 爬取天猫一级分类
//	 */
//	@Test
//	public void getFirstLevelCategories() throws ScriptException, JSONException {
// 
//		// 分类爬取地址
//		String requestUrl = "http://open.taobao.com/apitools/apiPropTools.htm";
// 
//		// 构造请求头
//		Map<String, String> headers = new HashMap<String, String>();
//		headers.put("Host", "open.taobao.com");
//		headers.put("Connection", "keep-alive");
//		headers.put("Cache-Control", "max-age=0");
//		headers.put("Upgrade-Insecure-Requests", "1");
//		headers.put("User-Agent",
//				"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36");
//		headers.put("Cookie", "你的Cookie");
// 
//		// 发送请求
//		String htmlStr = SpiderHttpUtils.sendGet(false, requestUrl, null, headers, "utf-8");
//		// 打印响应内容
//		System.out.println(htmlStr);
// 
//		// 使用正则截取有用信息
//		String regEx = "var cid1_api = '0\\|([\\s\\S]*)\\|0';";
//		Pattern pat = Pattern.compile(regEx);
//		Matcher mat = pat.matcher(htmlStr);
//		if (mat.find()) {
//			String jsonstr = mat.group(1);
// 
//			// 转义特殊字符
//			String newStr = jsonstr.replaceAll("\\\\\"", "\"").replaceAll("\\\\\\\\\\/", "\\/");
//			String finalJsonStr = StringEscapeUtils.unescapeJava(newStr);
// 
//			// 转化成JSON对象
//			JSONObject jsonObj = new JSONObject(finalJsonStr);
//			JSONObject jsonObject1 = jsonObj.getJSONObject("itemcats_get_response");
//			JSONObject jsonObject2 = jsonObject1.getJSONObject("item_cats");
//			JSONArray itemList = jsonObject2.getJSONArray("item_cat");
// 
//			// 将json字符串还原为对象集合
//			List<CategoryEntity> cats = gson.fromJson(itemList.toString(), new TypeToken<List<CategoryEntity>>() {
//			}.getType());
//			for (CategoryEntity cat : cats) {
// 
//				cat.setLevel(1); // 为分类设置层级
//				dao.saveCategory(cat); // 更新或者保存分类
//			}
//		}
//	}
// 
//	/*
//	 * 获取二级分类
//	 */
//	@Test
//	public void getFollowedLevelCategories() throws JSONException {
//		// 请求地址
//		String requestUrl = "http://open.taobao.com/apitools/ajax_props.do?_tb_token_=3b54e6e53e65e&cid={0}&act=childCid&restBool=false";
// 
//		// 构造请求头
//		Map<String, String> headers = new HashMap<String, String>();
//		headers.put("Host", "open.taobao.com");
//		headers.put("Connection", "keep-alive");
//		headers.put("Cache-Control", "max-age=0");
//		headers.put("Upgrade-Insecure-Requests", "1");
//		headers.put("User-Agent",
//				"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36");
//		headers.put("Cookie", "你的Cookie");
// 
//		// 逐层获取isParent=true的各级分类的子分类
//		for (int i = 1; i < 10; i++) {
//			List<CategoryEntity> allCategory = dao.findCategories(true, i);
//			if (allCategory.size() > 0) {
//				for (CategoryEntity cat : allCategory) {
//					saveChildrenCategories(cat, dao, requestUrl, headers, i + 1);
//				}
//			} else {
//				break;
//			}
//		}
//	}
// 
//	/*
//	 * 获取当前目录的下一级分类
//	 */
//	public void saveChildrenCategories(CategoryEntity parent, CategoryDao dao, String requestUrl,
//			Map<String, String> headers, int level) throws JSONException {
//		// 请求地址
//		String formatUrl = MessageFormat.format(requestUrl, parent.getCid());
//		// 发送请求
//		String htmlStr = SpiderHttpUtils.sendGet(false, formatUrl, null, headers, "utf-8");
//		// 打印响应内容
//		System.out.println(htmlStr);
//		// 转义特殊字符
//		String newStr = htmlStr.replaceAll("\\\\\"", "\"").replaceAll("\\\\\\\\\\/", "\\/");
//		String finalJsonStr = StringEscapeUtils.unescapeJava(newStr);
//		// 转化成JSON对象
//		JSONObject jsonObj = new JSONObject(finalJsonStr);
//		JSONObject jsonObject1 = jsonObj.getJSONObject("itemcats_get_response");
//		JSONObject jsonObject2 = jsonObject1.getJSONObject("item_cats");
//		JSONArray itemList = jsonObject2.getJSONArray("item_cat");
//		// 将json字符串还原为对象集合
//		List<CategoryEntity> cats = gson.fromJson(itemList.toString(), new TypeToken<List<CategoryEntity>>() {
//		}.getType());
//		for (CategoryEntity cate : cats) {
//			cate.setLevel(1); // 为分类设置层级
//			dao.saveCategory(cate); // 更新或者保存分类
//		}
//	}
// 
//}
