package com.fxy.baidu.testCase;

import com.fxy.baidu.base.DriverBase;
import com.fxy.baidu.business.BDErgodicPro;
import com.fxy.baidu.business.BDLoginOutPro;
import com.fxy.baidu.business.BDLoginPro;
import com.fxy.baidu.util.HandleCookie;
import com.fxy.baidu.util.SendEmail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestTest extends CaseBase {
    WebDriver driver;
    HandleCookie handleCookie;
    @Test
    public void login() throws Exception {
        System.setProperty("webdriver.chrome.driver", "E:/Projects/TestBDS/src/test/java/com/fxy/baidu/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://open.qajeejio.com/");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector(".headerLogin>span")).click();
        driver.findElement(By.cssSelector("input[type='text']")).sendKeys("13126668274");
        driver.findElement(By.xpath("//div[@class = 'middle-right-box']/div/div/div[4]/input[2]")).sendKeys("1111qqqq");
        driver.findElement(By.cssSelector(".BlueLogin")).click();
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        handleCookie.writeCookie("token");
    }

    @AfterSuite
    public void Quit() throws Exception {
        Thread.sleep(2000);
        driver.quit();
        SendEmail.sendToEmail("测试结束");
    }
}
