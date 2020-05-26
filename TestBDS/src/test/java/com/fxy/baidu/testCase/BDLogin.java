package com.fxy.baidu.testCase;

import com.fxy.baidu.base.DriverBase;
import com.fxy.baidu.business.BDErgodicPro;
import com.fxy.baidu.business.BDLoginOutPro;
import com.fxy.baidu.business.BDLoginPro;
import com.fxy.baidu.util.HandleCookie;
import com.fxy.baidu.util.SendEmail;
import org.testng.annotations.*;

public class BDLogin extends CaseBase {
    public DriverBase driver;
    public BDLoginPro bdLogin;
    public BDErgodicPro bdErgodic;
    public BDLoginOutPro bdLoginOutPro;
    public HandleCookie handleCookie;
    @BeforeSuite
    @Parameters({"driverName"})
    public void Login(String driverName){
        this.driver = InitDriver(driverName);
        bdLogin = new BDLoginPro(driver);
        bdErgodic = new BDErgodicPro(driver);
        bdLoginOutPro = new BDLoginOutPro(driver);
        handleCookie = new HandleCookie(driver);
    }
    @BeforeTest
    @Parameters({"userName", "passWord", "url"})
    public void login(String userName, String passWord, String url) throws Exception {
        driver.get(url);
        driver.max();
        driver.timeouts();
        bdLogin.login(userName, passWord);
        Thread.sleep(5000);
        driver.timeouts();
        //handleCookie.writeCookie("token");
    }
    @Test
    public void cergodic(){
        driver.defaultWindouws();
        driver.timeouts();
        bdErgodic.ergodic();
    }
    @Test
    public void loginOut(){
        driver.defaultWindouws();
        driver.timeouts();
        bdLoginOutPro.loginOut();
    }
    @AfterSuite
    public void Quit() throws Exception {
        Thread.sleep(2000);
        driver.quit();
        SendEmail.sendToEmail("测试结束");
    }
}