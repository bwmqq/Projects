package com.test.util;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class HandleCookie {
	public WebDriver driver;
	public ProUtil pro;
	public HandleCookie(WebDriver driver){
		this.driver = driver;
		pro = new ProUtil("../TestExcel/cookie.properties");
	}
	public void setCookie(String token, String domain){
		String value = pro.getPro(token);
		Cookie cookie = new Cookie(token, value, domain, "/", null);
		driver.manage().addCookie(cookie);
		driver.navigate().refresh();
	}
	//获取cookie
	public void writeCookie(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Set<Cookie> cookieSet = driver.manage().getCookies();
		List<Cookie> cookieList = new ArrayList<Cookie>(cookieSet);
		log.info("获取Cookie成功，并写入cookie.properties");
		pro.writePro(cookieList);
	}
}
