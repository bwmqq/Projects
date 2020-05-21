package com.fxy.baidu.business;

import com.fxy.baidu.base.DriverBase;
import com.fxy.baidu.handle.BDErgodicHandle;

public class BDErgodicPro {
    public DriverBase driverBase;
    public BDErgodicHandle bdErgodic;
    public BDErgodicPro(DriverBase driverBase){
        this.driverBase = driverBase;
        bdErgodic = new BDErgodicHandle(driverBase);
    }
    public void ergodic(){
        bdErgodic.ergodic();
        bdErgodic.postBar();
    }
}
