package com.fxy.baidu.testCase;

import com.fxy.baidu.base.DriverBase;

public class CaseBase {
    public DriverBase InitDriver(String browser){
        return new DriverBase(browser);
    }
}
