package com.dyf.grab.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import java.io.File;
import java.util.Random;

public class TestCase2 {
	public static void main(String[] args) {
		System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\18431\\IdeaProjects\\SeleniumDemo\\bin\\geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		FirefoxProfile profile = new FirefoxProfile(
				new File("C:\\Users\\18431\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\efzu2oem.default"));
		options.setProfile(profile);
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://login.m.taobao.com/login.htm");
		// 下面开始完全模拟正常人的操作，所以你会看到很多 sleep 操作
		WebElement usernameElement = driver.findElement(By.id("username"));
		// 模拟用户点击用户名输入框
		usernameElement.click();
		String username = "18588260144";// 你的手机号
		String password = "xxxxxxxxxxx";// 你的密码
		Random rand = new Random();
		try {
			for (int i = 0; i < username.length(); i++) {
				Thread.sleep(rand.nextInt(1000));// 随机睡眠0-1秒
				// 逐个输入单个字符
				usernameElement.sendKeys("" + username.charAt(i));
			}
			WebElement passwordElement = driver.findElement(By.id("password"));
			passwordElement.click();
			// 输入完成用户名后，随机睡眠0-3秒
			Thread.sleep(rand.nextInt(3000));
			for (int i = 0; i < password.length(); i++) {
				Thread.sleep(rand.nextInt(1000));
				passwordElement.sendKeys("" + password.charAt(i));
			}
			driver.findElement(By.id("btn-submit")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(300000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		driver.quit();
	}
}
