package com.fxy.baidu.util;

import com.fxy.baidu.base.DriverBase;
import org.openqa.selenium.Cookie;

import java.util.List;

public class HandleCookie {
	public DriverBase driver;
	public ProUtil pro;
	public HandleCookie(DriverBase driver){
		this.driver = driver;
		pro = new ProUtil("../TestBDS/cookie.properties");
	}
	public void setCookie(String token, String domain){
		String value = pro.getPro(token);
		Cookie cookie = new Cookie(token, value, domain, "/", null);
		driver.setCookies(cookie);
	}
	//获取cookie
	public void writeCookie(String cookie){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<Cookie> cookies = driver.getCookie();
		pro.writePro(cookies);
	}
}
