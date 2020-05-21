package com.fxy.baidu.page;

import com.fxy.baidu.base.DriverBase;
import com.fxy.baidu.util.GetLocator;
import org.openqa.selenium.WebElement;

public class BDLoginPage{
    public DriverBase driverBase;
    public BDLoginPage(DriverBase driverBase){
        this.driverBase = driverBase;
    }
    //获取登录
    public WebElement login(){
        return driverBase.findElement(GetLocator.GetLocator("Login"));
    }
    //点击QQ登录
    public WebElement QQlogin(){
        return driverBase.nodeElement(GetLocator.GetLocator("QQul"), GetLocator.GetLocator("QQui"));
    }
    //切换第三方登录
    public WebElement frmae(){
        return driverBase.findElement(GetLocator.GetLocator("nFrame"));
    }
    //点击账号密码登录
    public WebElement UPLogin(){
        return driverBase.findElement(GetLocator.GetLocator("UPLogin"));
    }
    //点击账号
    public WebElement userName(){
        return driverBase.findElement(GetLocator.GetLocator("userName"));
    }
    //点击密码
    public WebElement passWord(){
        return driverBase.findElement(GetLocator.GetLocator("passWord"));
    }
    //点击登录
    public WebElement submit(){
        return driverBase.findElement(GetLocator.GetLocator("submit"));
    }
}
