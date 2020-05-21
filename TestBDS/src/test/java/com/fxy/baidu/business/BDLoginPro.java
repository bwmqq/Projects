package com.fxy.baidu.business;

import com.fxy.baidu.base.DriverBase;
import com.fxy.baidu.handle.BDLoginHandle;

public class BDLoginPro {
    public DriverBase driverBase;
    public BDLoginHandle bdLoginHandle;
    public BDLoginPro(DriverBase driverBase){
        this.driverBase = driverBase;
        bdLoginHandle = new BDLoginHandle(driverBase);
    }
    public void login(String userName, String passWord){
        bdLoginHandle.login();
        bdLoginHandle.QQlogin();
        bdLoginHandle.frame();
        bdLoginHandle.UPLogin();
        bdLoginHandle.userName(userName);
        bdLoginHandle.passWord(passWord);
        bdLoginHandle.submit();
    }
}
