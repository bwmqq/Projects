package com.fxy.baidu.testCase;

import com.fxy.baidu.base.DriverBase;
import com.fxy.baidu.business.BDErgodicPro;
import com.fxy.baidu.business.BDLoginOutPro;
import com.fxy.baidu.business.BDLoginPro;
import com.fxy.baidu.util.HandleCookie;
import org.apache.log4j.xml.DOMConfigurator;
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
        handleCookie = new HandleCookie(driver.getDriver());
    }
    @BeforeTest
    @Parameters({"userName", "passWord", "url"})
    public void login(String userName, String passWord, String url) throws Exception {
        DOMConfigurator.configure("Log4j.xml");
        driver.get(url);
        driver.maxmize("null");
        driver.timeouts();
        bdLogin.login(userName, passWord);
        Thread.sleep(5000);
        driver.getCookie();
    }
    @Test
    public void cergodic(){
        driver.defaultWindouws();
        bdErgodic.ergodic();
    }
    @Test
    public void loginOut(){
        driver.defaultWindouws();
        bdLoginOutPro.loginOut();
    }
    @AfterSuite
    public void Quit() throws Exception {
        Thread.sleep(2000);
        driver.quit();
        //SendEmail.sendToEmail("测试结束");
    }
}