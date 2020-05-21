package com.fxy.baidu.page;

import com.fxy.baidu.base.DriverBase;
import com.fxy.baidu.util.GetLocator;
import org.openqa.selenium.WebElement;

public class BDLoginOutPage {
    public DriverBase driverBase;
    public BDLoginOutPage(DriverBase driverBase){
        this.driverBase = driverBase;
    }
    //移动到用户名显示选项
    public WebElement moveToUser(){
        return driverBase.findElement(GetLocator.GetLocator("user"));
    }
    //点击退出用户
    public WebElement quit(){
        return driverBase.findElement(GetLocator.GetLocator("quit"));
    }
    //点击确定按钮
    public WebElement quitOut(){
        return driverBase.findElement(GetLocator.GetLocator("tureOut"));
    }
}
