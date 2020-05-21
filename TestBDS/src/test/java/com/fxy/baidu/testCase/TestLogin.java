package com.fxy.baidu.testCase;

import com.fxy.baidu.base.DriverBase;
import com.fxy.baidu.util.HandleCookie;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLogin extends CaseBase {
    public DriverBase driver;
    public HandleCookie handleCookie;
    @BeforeClass
    public void Login(){
        this.driver = InitDriver("chrome");
        handleCookie = new HandleCookie(driver);
    }
    /*@Test
    public void login(){
        driver.get("http://www.gacjc.com/login");
        driver.max();
        driver.timeouts();
        driver.findElement(By.name("name")).sendKeys("13611360924");
        driver.findElement(By.name("password")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@id=\"loginForm1\"]/div/a")).click();
        handleCookie.writeCookie("token");
    }*/
    @Test
    public void ziliao(){
        driver.get("http://www.gacjc.com/user/acc_info");
        handleCookie.setCookie("token", ".gacjc.com");
        driver.max();
        driver.timeouts();
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[1]/ul/li/ul/li[2]/a")).click();
    }
    @AfterClass
    public void Quit() throws Exception {
        Thread.sleep(5000);
        driver.quit();
    }
}
