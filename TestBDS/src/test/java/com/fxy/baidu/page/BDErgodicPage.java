package com.fxy.baidu.page;

import com.fxy.baidu.base.DriverBase;
import com.fxy.baidu.util.GetLocator;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BDErgodicPage{
    public DriverBase driverBase;
    public BDErgodicPage(DriverBase driverBase){
        this.driverBase = driverBase;
    }
    //遍历导航
    public List<WebElement> ergodic(){
        return driverBase.findElements(GetLocator.GetLocator("Ergodic"));
    }
}
