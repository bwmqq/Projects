package com.fxy.baidu.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelectDriver {
    //封装驱动
    public WebDriver driverName(String browser){
        //不区分大小写
        if (browser.equalsIgnoreCase("fireFox")){
            System.setProperty("webdriver.firefox.marionette", "D:/Install/driver/geckodriver.exe");
            return new FirefoxDriver();
        }else {
            System.setProperty("webdriver.chrome.driver", "../TestBDS/src/test/java/com/fxy/baidu/driver/chromedriver.exe");
            return new ChromeDriver();
        }
    }
}
