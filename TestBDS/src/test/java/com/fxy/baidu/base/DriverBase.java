package com.fxy.baidu.base;

import com.fxy.baidu.util.HandleCookie;
import com.fxy.baidu.util.HandleSession;
import com.fxy.baidu.util.Log;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class DriverBase {
    public WebDriver driver;
    //获取driver
    public DriverBase(String browser){
        SelectDriver selectDriver = new SelectDriver();
        this.driver = selectDriver.driverName(browser);
    }




    //等待时间
    public void timeouts(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    //退出浏览器
    public void quit(){
        System.out.println("quit webdriver");
        driver.quit();
    }
    //获取文案
    public String getText(WebElement element) {
        return element.getText();
    }
    //获取Cookie
    public void getCookie(){
        HandleCookie handleCookie = new HandleCookie(driver);
        handleCookie.writeCookie();
    }
    //获取Session
    public void getSeesion() throws Exception {
        HandleSession handleSession = new HandleSession(driver);
        handleSession.writeSession();
    }
    //设置Session
    public void setSeesion(String parameters) {
        HandleSession handleSession = new HandleSession(driver);
        handleSession.setSession(parameters);
    }
    //设置Cookie
    public void setCookies(String parameters){
        HandleCookie handleCookie = new HandleCookie(driver);
        handleCookie.setCookie(parameters);
    }
    //删除Cookie
    public void deleteCookies(Cookie cookie){
        driver.manage().deleteCookie(cookie);
    }
    //封装Element
    public WebElement findElement(By by){
        return driver.findElement(by);
    }
    //封装定位一组elements的方法
    public List<WebElement> findElements(By by){
        return driver.findElements(by);
    }
    //层级定位, 通过父节点定位子节点
    //需要传入父节点和子节点的By
    public WebElement nodeElement(By by, By nodeBy){
        WebElement element = this.findElement(by);
        return element.findElement(nodeBy);
    }
    //判断元素是否显示
    public boolean assertElement(WebElement element){
        return element.isDisplayed();
    }
    //刷新界面
    public void refresh(){
        driver.navigate().refresh();
    }
    //获取title
    public String getTitle(){
        return driver.getTitle();
    }
    //获取driver
    public WebDriver getDriver(){
        return driver;
    }
    //根据指定名称获取title
    public String getNameTitle(String win){
        return driver.switchTo().window(win).getTitle();
    }
    //获取当前窗口
    public String getWindowHandle(){
        return driver.getWindowHandle();
    }
    //切换windows窗口
    public void switchWindows(String name){
        List<String> windowsHandles = this.getWindowsHandles();
        Iterator<String> iterator = windowsHandles.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            String title = driver.switchTo().window(next).getTitle();
            if (title.equals(name)){
                driver.switchTo().window(next);
                break;
            }else {
                continue;
            }
        }
    }
    //切换默认窗口
    public void defaultWindouws(){
        List<String> windowsHandles = this.getWindowsHandles();
        driver.switchTo().window(windowsHandles.get(0));
    }
    //获取当前系统窗口list
    public List<String> getWindowsHandles(){
        Set<String> winHandels = driver.getWindowHandles();
        List<String> handles = new ArrayList<String>(winHandels);
        return handles;
    }
    //移动鼠标
    public void moveToElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
    //切换alert窗口
    public void switchAlert(){
        driver.switchTo().alert();
    }
    //切换frame窗口
    public void frame(WebElement element){
        driver.switchTo().frame(element);
    }
    //封装输入
    public void sendKeys(WebElement element, String value){
        if (element != null){
            element.sendKeys(value);
        }else {
            Log.info("元素没有定位到,输入失败!");
        }
    }
    //封装点击
    public void click(WebElement element){
        if (element != null){
            element.click();
        }else {
            Log.info("元素没有定位到,输入失败!");
        }
    }
    //清除当前文本框
    public void clear(WebElement element){
        element.clear();
    }
    //关闭驱动
    public void close(){
        Log.info("close webdriver");
        driver.close();
    }
    //获取当前url
    public String getUrl(){
        return driver.getCurrentUrl();
    }
    //点击返回
    public void back(){
        driver.navigate().back();
    }
    //自定义浏览器大小
    //网页最大化
    public void maxmize(String vlues){
        if ("null".equals(vlues)){
            driver.manage().window().maximize();
        }else {
            String[] split = vlues.split(",");
            Dimension dimension = new Dimension(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            driver.manage().window().setSize(dimension);
        }
    }
    //访问地址
    public void get(String url){
        driver.get(url);
    }
}
