package com.fxy.baidu.handle;

import com.fxy.baidu.base.DriverBase;
import com.fxy.baidu.page.BDLoginPage;

public class BDLoginHandle {
    public DriverBase driverBase;
    public BDLoginPage bdLoginPage;
    public BDLoginHandle(DriverBase driverBase){
        this.driverBase = driverBase;
        bdLoginPage = new BDLoginPage(driverBase);
    }
    public void login(){
        driverBase.click(bdLoginPage.login());
    }
    public void QQlogin(){
        driverBase.click(bdLoginPage.QQlogin());
    }
    public void frame(){
        driverBase.switchWindows("QQ帐号安全登录");
        driverBase.frame(bdLoginPage.frmae());
    }
    public void UPLogin(){
        driverBase.click(bdLoginPage.UPLogin());
    }
    public void userName(String userName){
        driverBase.clear(bdLoginPage.userName());
        driverBase.sendKeys(bdLoginPage.userName(), userName);
    }
    public void passWord(String passWord){
        driverBase.clear(bdLoginPage.passWord());
        driverBase.sendKeys(bdLoginPage.passWord(), passWord);
    }
    public void submit(){
        driverBase.click(bdLoginPage.submit());
    }
}
