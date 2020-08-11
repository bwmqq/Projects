package com.fxy.baidu.util;

import org.openqa.selenium.By;

public class GetLocator {
    //封装By
    public static By GetLocator(String key){
        ProUtil proUtil = new ProUtil(Constant.TestDataExcelFilePath);
        String locator = proUtil.getPro(key);
        String locatorType = locator.split(">")[0];
        String locatorValue = locator.split(">")[1];
        if (locatorType.equals("id")){
            return By.id(locatorValue);
        }else if (locatorType.equals("name")){
            return By.name(locatorValue);
        }else if (locatorType.equals("className")){
            return By.className(locatorValue);
        }else if (locatorType.equals("xpath")){
            return By.xpath(locatorValue);
        }else if (locatorType.equals("cssSelector")){
            return By.cssSelector(locatorValue);
        }else if (locatorType.equals("linkText")){
            return By.linkText(locatorValue);
        }else if (locatorType.equals("partialLinkText")){
            return By.partialLinkText(locatorValue);
        }else {
            return By.tagName(locatorValue);
        }
    }
}
