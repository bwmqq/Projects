package com.fxy.baidu.business;

import com.fxy.baidu.base.DriverBase;
import com.fxy.baidu.handle.BDLoginOutHandle;

public class BDLoginOutPro {
    public DriverBase driverBase;
    public BDLoginOutHandle bdLoginOutHandle;
    public BDLoginOutPro(DriverBase driverBase){
        this.driverBase = driverBase;
        bdLoginOutHandle = new BDLoginOutHandle(driverBase);
    }
    public void loginOut(){
        bdLoginOutHandle.moveToUser();
        bdLoginOutHandle.quit();
        bdLoginOutHandle.quitOut();
    }
}
