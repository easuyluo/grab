package com.dyf.grab.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

/**
 * chromeDriver是谷歌的浏览器驱动，用来适配Selenium,有图形页面存在，在调试爬虫下载运行的功能的时候会相对方便
 * 
 * @author zhuangj
 * @date 2017/11/14
 */
public class TestChromeDriver {

	private static ChromeDriverService service;

	public static WebDriver getChromeDriver() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
		// 创建一个 ChromeDriver 的接口，用于连接 Chrome（chromedriver.exe
		// 的路径可以任意放置，只要在newFile（）的时候写入你放的路径即可）
		// 指定浏览器驱动路径
		String chromePath = "D:\\\\Users\\\\Administrator\\\\AppData\\\\Local\\\\Google\\\\Chrome\\\\Application\\\\chromedriver76.exe";
		service = new ChromeDriverService.Builder()
				.usingDriverExecutable(
						new File("E:\\soft\\chromedriver_win32\\chromedriver.exe"))
				.usingAnyFreePort().build();
		service.start();
		// 创建一个 Chrome 的浏览器实例
		return new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
	}

	public static void main(String[] args) throws IOException {

		WebDriver driver = TestChromeDriver.getChromeDriver();
		// 让浏览器访问 Baidu
		driver.get("https://login.taobao.com/");
		// 用下面代码也可以实现
		// driver.navigate().to("http://www.baidu.com");
		// 获取 网页的 title
		System.out.println(" Page title is: " + driver.getTitle());
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 通过 id 找到 input 的 DOM
		WebElement element = driver.findElement(By.id("q"));
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 输入关键字
		element.sendKeys("东鹏瓷砖");
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 提交 input 所在的 form
		element.submit();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		test.getSearchDataOk();//返回json：销量，价格，图片，url等
		// 通过判断 title 内容等待搜索页面加载完毕，间隔秒
//		new WebDriverWait(driver, 10).until( (Object input) ->
//		{ return ((WebDriver) input).getTitle().toLowerCase().startsWith("东鹏瓷砖");}
//			);
//		() -> System.out.println("method1执行")
//		new WebDriverWait(driver, 10).until(new ExpectedCondition() {
//			@Override
//			public Object apply(Object input) {
//				return ((WebDriver) input).getTitle().toLowerCase().startsWith("东鹏瓷砖");
//			}
//		});
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// 显示搜索结果页面的 title
		System.out.println(" Page title is: " + driver.getTitle());
		// 关闭浏览器
		driver.quit();
		
		
		// 关闭 ChromeDriver 接口
		service.stop();
	}

}