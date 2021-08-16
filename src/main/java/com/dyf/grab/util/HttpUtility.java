package com.dyf.grab.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class HttpUtility {
	/**
	 * 向指定URL发送GET方法的请求
	 * 
	 * @param taskurl 发送请求的URL
	 * @param param   请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return URL 所代表远程资源的响应结果
	 */
	public static String sendGet(String taskurl) {
		String result = "";
		BufferedReader in = null;
		try {
			URL realUrl = new URL(taskurl);
// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
//connection.setRequestProperty("referer", "https://item.taobao.com/item.htm?spm=a219r.lm874.14.1.7FfR2G&id=531878100031&ns=1&abbucket=17");
// connection.setRequestProperty("referer", "https://www.taobao.com");
			connection.setRequestProperty("Content-type", "text/html");
			connection.setRequestProperty("upgrade-insecure-requests", "1");
//connection.setRequestProperty("projectId", "1318");
//connection.setRequestProperty("target", "_blank");
			connection.setRequestProperty("Cookie",
					"UM_distinctid=15ce85940eeb6-0ededb7ab12ab7-714d2542-1fa400-15ce85940f03a3; thw=cn; l=AoeH71vtTJplFHodyW9Km6LWlzBRNFtu; ali_apache_id=11.131.220.163.150770215638.249204.2; miid=542152054597054537; _cc_=UtASsssmfA%3D%3D; tg=0; ali_ab=180.172.239.236.1504257044497.3; cna=qj6tEaUwR2gCAbSs7+wVMbzj; t=449d46ab83aeedc87c00dd3445b7c1a1; _m_h5_tk=9848cddbcb8e9e9fbcba777beaf178e3_1513319477951; _m_h5_tk_enc=098be3ca7eefbf0d0dc4ca8d4373a416; hng=CN%7Czh-CN%7CCNY%7C156; mt=ci=0_0; cookie2=2d568166cf6798789cb6dfe308656172; v=0; _tb_token_=55e8bbe9576ed; alitrackid=www.taobao.com; lastalitrackid=www.taobao.com; ctoken=lD359uPelBrHdgHqQMaXp4p-render; isg=Av7-BVfyKJPOGn86hKhLA9_JTxSAl8CtYYz2VqgGYcE8S58lEM0MyDpptyF8; JSESSIONID=47BB19E15ADB5FD76C986F288B1DA2BE");
// connection.setRequestProperty("Accept-Charset", "utf-8");
			connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8");
			connection.setRequestProperty("cache-control", "max-age=0");

			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
// connection
// .setRequestProperty(
// "user-agent",
// "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.7 Safari/537.36");

// connection
// .setRequestProperty(
// "user-agent",
// "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.221 Safari/537.36 SE 2.X MetaSr 1.0");

// 建立实际的连接
			connection.connect();

// 获取所有响应头字段
			Map<String, List<String>> map = connection.getHeaderFields();

// 遍历所有的响应头字段
			/*
			 * for (String key : map.keySet()) { //System.out.println(key + "--->" +
			 * map.get(key)); }
			 */
// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
//System.out.println(line);
			}

		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return result;
	}

	/**
	 * 向指定 URL 发送POST方法的请求
	 * 
	 * @param url   发送请求的 URL
	 * @param param 请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return 所代表远程资源的响应结果
	 */
	public static String sendPost(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
// 发送请求参数
			out.print(param);
// flush输出流的缓冲
			out.flush();
// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}
}
