package com.test.baseTest;

import com.test.pageTest.DriverElementPage;
import com.test.util.log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DriverElement {
    /*//获取当前系统窗口list
    public List<String> getWindowsHandles(WebDriver driver){
        Set<String> winHandels = driver.getWindowHandles();
        List<String> handles = new ArrayList<String>(winHandels);
        return handles;
    }*/
    public static void execute (WebDriver driver, String elementName, String mode, String objects, String actions, String parameters) throws Exception {
        DriverElementPage driverElementPage = new DriverElementPage(driver);
        if (objects.equals("element")){
            if (actions.equals("click")){
                //点击
                driverElementPage.DrElement(mode, elementName).click();
            }else if (actions.equals("clear")){
                //清除
                driverElementPage.DrElement(mode, elementName).clear();
            }else if (actions.equals("sendKeys")){
                //输入
                driverElementPage.DrElement(mode, elementName).sendKeys(parameters);
            }else if (actions.equals("perform")){
                //鼠标移至
                Actions actions1 = new Actions(driver);
                actions1.moveToElement(driverElementPage.DrElement(mode, elementName)).perform();
            }else if (actions.equals("frame")){
                //切换iframa
                driver.switchTo().frame(driverElementPage.DrElement(mode, elementName));
            }
        }else {
            if (actions.equals("get")){
                //打开网页
                log.info("访问网页" + parameters);
                driver.get(parameters);
                driver.manage().window().maximize();
            }else if (actions.equals("refresh")){
                //刷新
                driver.navigate().refresh();
            }else if (actions.equals("getTitle")){
                //获取网页名称
                driver.getTitle();
            }else if (actions.equals("getCurrentUrl")){
                //获取网页地址
                driver.getCurrentUrl();
            }else if (actions.equals("back")){
                //返回
                driver.navigate().back();
            }else if (actions.equals("alert")){
                //切换至alert弹窗
                driver.switchTo().alert();
            }else if (actions.equals("getWindowHandle")){
                //获取当前窗口
                driver.getWindowHandle();
            }
        }
    }
}
