package com.fxy.baidu.testCase;

import com.fxy.baidu.util.*;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestTest extends CaseBase {
    WebDriver driver;
    HandleSession handleSession;

    @Test
    public void login() throws Exception {
        System.setProperty("webdriver.chrome.driver", Constant.TestDatachromedriverPath);
        driver = new ChromeDriver();
        DOMConfigurator.configure("Log4j.xml");
        driver.get("https://open.qajeejio.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".headerLogin>span")).click();
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("13126668274");
        driver.findElement(By.xpath("//div[@class = 'middle-right-box']/div/div/div[4]/input[2]")).sendKeys("1111qqqq");
        driver.findElement(By.cssSelector(".BlueLogin")).click();
        Thread.sleep(2000);
        handleSession = new HandleSession(driver);
        handleSession.writeSession();
    }

    @AfterSuite
    public void Quit() throws Exception {
        Thread.sleep(2000);
        driver.quit();
        //SendEmail.sendToEmail("测试结束");
    }
}
