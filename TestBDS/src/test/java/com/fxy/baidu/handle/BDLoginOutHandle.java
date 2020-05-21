package com.fxy.baidu.handle;

import com.fxy.baidu.base.DriverBase;
import com.fxy.baidu.page.BDLoginOutPage;
import com.fxy.baidu.util.GetLocator;
import org.openqa.selenium.WebElement;

public class BDLoginOutHandle {
    public DriverBase driverBase;
    public BDLoginOutPage bdLoginOutPage;
    public BDLoginOutHandle(DriverBase driverBase){
        this.driverBase = driverBase;
        bdLoginOutPage = new BDLoginOutPage(driverBase);
    }
    public void moveToUser(){
        driverBase.moveToElement(bdLoginOutPage.moveToUser());
    }
    public void quit(){
        driverBase.click(bdLoginOutPage.quit());
    }
    public void quitOut(){
        driverBase.click(bdLoginOutPage.quitOut());
    }
}
