package com.fxy.baidu.base;

import com.fxy.baidu.util.Constant;
import com.fxy.baidu.util.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class SelectDriver {
    //封装驱动
    public WebDriver driverName(String driverName){
        //不区分大小写
        if (driverName.equalsIgnoreCase("fireFox")){
            System.setProperty("webdriver.firefox.driver", Constant.TestDatageckodiverPath);
            Log.info("启动火狐浏览器");
            return new FirefoxDriver();
        }else if (driverName.equalsIgnoreCase("Opera")){
            System.setProperty("webdriver.opera.driver", Constant.TestDataoperadriverPath);
            Log.info("启动欧朋浏览器");
            return new OperaDriver();
        }else {
            System.setProperty("webdriver.chrome.driver", Constant.TestDatachromedriverPath);
            Log.info("启动谷歌浏览器");
            return new ChromeDriver();
        }
    }
}
