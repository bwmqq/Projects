package com.test.pageTest;

import com.test.util.ObjectMap;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DriverElementPage {
    private ObjectMap objectMap = new ObjectMap("E:/Projects/TestExcel/Excel/SeleniumTest.xlsx");
    private WebDriver driver;
    public DriverElementPage(WebDriver driver){
        this.driver = driver;
    }
    public WebElement DrElement(String elementName, String elementValue) throws Exception {
        return driver.findElement(objectMap.getLocator(elementName, elementValue));
    }
}
