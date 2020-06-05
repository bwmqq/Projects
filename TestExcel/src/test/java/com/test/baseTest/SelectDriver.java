package com.test.baseTest;

import com.test.util.log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelectDriver {
    //封装驱动
    public WebDriver driverName(String browser){
        //不区分大小写
        if (browser.equalsIgnoreCase("fireFox")){
            System.setProperty("webdriver.firefox.marionette", "../TestExcel/driver/chromedriver.exe");
            log.info("启动火狐浏览器");
            return new FirefoxDriver();
        }else {
            System.setProperty("webdriver.chrome.driver", "../TestExcel/driver/chromedriver.exe");
            log.info("启动谷歌浏览器");
            return new ChromeDriver();
        }
    }
}
