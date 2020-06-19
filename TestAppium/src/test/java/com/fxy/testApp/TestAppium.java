package com.fxy.testApp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TestAppium {
    public AppiumDriver driver;
    public Boolean isElement;
    @Test
    public void TestApp() throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.BROWSER_NAME, "");
        cap.setCapability("platformName", "Android");
        cap.setCapability("deviceName", "66J5T19A30000037");
        cap.setCapability("platformVersion", "10");
//        cap.setCapability("deviceName", "127.0.0.1:21503");
//        cap.setCapability("platformVersion", "5.1.1");
        cap.setCapability("appPackage", "com.jeejio.controller");
        cap.setCapability("appActivity", "com.jeejio.controller.view.appImpl.SplashActivity");
        //cap.setCapability("appActivity", "com.jeejio.controller.view.appImpl.LoginActivity");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), cap);
        Thread.sleep(5000);
        for (int i=0; i <= 10; i++) {
            if (driver.getPageSource().contains("允许") || driver.getPageSource().contains("禁止")
                    || driver.getPageSource().contains("授权")) {// 出现权限提示
                try {
                    driver.findElementByXPath("//android.widget.Button[contains(@text,'允许')]").click();// 点击允许
                } catch (NoSuchElementException e1) {
                    driver.findElementByXPath("//android.widget.Button[contains(@text,'授权')]").click();// 点击授权
                }
            } else {
                break;
            }
        }
        for (int i = 0; i <= 10; i++) {
            try {
                driver.findElementById("com.jeejio.controller:id/btn_guide_jump");
                isElement = true;
            } catch (Exception e) {
                System.out.println("还有引导页！");
                isElement = false;
            }
            if(isElement == true){
                driver.findElementById("com.jeejio.controller:id/btn_guide_jump").click();
            }else {
                driver.swipe(1000, 1000, 200, 1000, 1000);
            }
        }
        //driver.findElementByXPath("//*[@text = '始终允许']").click();
        /*driver.findElementById("com.jeejio.controller:id/et_username").sendKeys("13126668274");
        driver.findElementById("com.jeejio.controller:id/et_password").sendKeys("1111qqqq");
        driver.findElementById("com.jeejio.controller:id/btn_login").click();*/
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        /*driver.findElementByXPath("//android.widget.TextView[@text='水杯']").click();*/
        /*driver.findElementById("com.jeejio.controller:id/iv_app_img").click();
        driver.findElementById("android.view.View").click();*/
        Thread.sleep(5000);
        //driver.quit();
    }
}
