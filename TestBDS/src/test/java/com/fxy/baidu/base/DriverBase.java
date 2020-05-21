package com.fxy.baidu.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class DriverBase {
    public WebDriver driver;
    //获取driver
    public DriverBase(String browser){
        SelectDriver selectDriver = new SelectDriver();
        this.driver = selectDriver.driverName(browser);
    }


    //模态框切换
    public void awitchToMode(){
        driver.switchTo().activeElement();
    }






























    //获取Cookie
    public List<Cookie> getCookie(){
        Set<Cookie> cookies = driver.manage().getCookies();
        List<Cookie> cookie = new ArrayList<Cookie>(cookies);
        return cookie;
    }
    //设置Cookie
    public void setCookies(Cookie cookies){
        driver.manage().addCookie(cookies);
        driver.navigate().refresh();
    }
    //删除Cookie
    public void deleteCookies(Cookie cookie){
        driver.manage().deleteCookie(cookie);
    }
    //刷新界面
    public void refresh(){
        driver.navigate().refresh();
    }
    //获取driver
    public WebDriver getDriver(){
        return driver;
    }
    //截图
    public void takeScreenShot() {
        //格式化时间
        SimpleDateFormat sf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        //等于Date date = new Date();
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        //时间转换为字符串
        String dateStr = sf.format(date);
        //当前类名 + 时间字符串 + .png
        String path = this.getClass().getSimpleName() + "_" + dateStr + ".png";
        //因为截图需要用到driver, 所以获取driver
        takeScreenShot((TakesScreenshot) this.getDriver(), path);
    }
    //传入截图参数
    public void takeScreenShot(TakesScreenshot drivername, String path) {
        //获取当前工作空间路径
        String currentPath = System.getProperty("user.dir"); // get current work
        //截图
        File scrFile = drivername.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(currentPath + "\\" + path));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("截图成功");
        }
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
    //获取title
    public String getTitle(){
        return driver.getTitle();
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
    //等待时间
    public void timeouts(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
            System.out.println("元素没有定位到,输入失败!");
        }
    }
    //封装点击
    public void click(WebElement element){
        if (element != null){
            element.click();
        }else {
            System.out.println("元素没有定位到,点击失败!");
        }
    }
    //清除当前文本框
    public void clear(WebElement element){
        element.clear();
    }
    //关闭驱动
    public void close(){
        System.out.println("close webdriver");
        driver.close();
    }
    //退出浏览器
    public void quit(){
        System.out.println("quit webdriver");
        driver.quit();
    }
    //访问地址
    public void get(String url){
        driver.get(url);
    }
    //网页最大化
    public void max(){
        driver.manage().window().maximize();
    }
    //点击返回
    public void back(){
        driver.navigate().back();
    }
    //获取当前url
    public String getUrl(){
        return driver.getCurrentUrl();
    }
}
