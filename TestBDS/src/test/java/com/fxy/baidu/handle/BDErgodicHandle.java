package com.fxy.baidu.handle;

import com.fxy.baidu.base.DriverBase;
import com.fxy.baidu.page.BDErgodicPage;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BDErgodicHandle {
    public DriverBase driverBase;
    public BDErgodicPage bdErgodic;
    public BDErgodicHandle(DriverBase driverBase){
        this.driverBase = driverBase;
        bdErgodic = new BDErgodicPage(driverBase);
    }
    public void ergodic(){
        List<WebElement> ergodic = bdErgodic.ergodic();
        for (WebElement el : ergodic) {
            driverBase.click(el);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void postBar(){
        driverBase.switchWindows("百度贴吧——全球最大的中文社区");
    }
}
