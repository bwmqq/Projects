package com.test.TestEC;

import com.test.baseTest.DriverElement;
import com.test.util.*;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestS {
    public WebDriver driver;
    /*public DriverElement driverElement = new DriverElement();*/
    //定义dataprovider,并命名为testData
    @DataProvider(name="testData")
    public static Object[][] data() throws IOException {
        /*
         *调用ExcelUtil类中的getTestData静态方法，获取Excel数据文件中倒数第二列
         *标记为y的测试数据行，函数参数为常量Constant.TestDataExcelFilePath和常量
         *Constant.TestDataExcelFileSheet,指定数据文件的路径和Sheet名称
         */

//		System.out.println(Constant.TestDataExcelFilePath);
//		System.out.println(Constant.TestDataExcelFileSheet);
		log.info("调用ExcelUtil类中的getTestData静态方法获取Excel中标记为yes的测试数据");
		return ExcelUtil.getTestData(Constant.TestDataExcelFilePath,Constant.TestDataExcelFileSheet);
    }
    //使用名称为testData的dataProvider作为测试方法的测试数据集
    //测试方法一个使用了9个参数，对应到Excel数据文件的1~9列
    @Test(dataProvider="testData")
    public void testEC(String CaseRow, String CaseName, String Preconditions, String elementName, String mode, String objects,
                       String actions, String parameters) throws Exception {
        log.startTestCase(CaseName);
        log.info("调用DriverElement类的execute方法");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        try {
            DriverElement.execute(driver, Preconditions, elementName, mode, objects, actions, parameters);
        } catch (Exception e) {
            /*
             * 执行AddContactPersonAction类的execute方法失败时，catch语句可以捕获AssertionError类型
             * 的异常，并设置Excel中测试数据行的执行结果为“测试失败”。由于Excel中的序号格式被默认设定
             * 为带有一位小数点，所以使用 split("[.]"[0]) 语句获取序号的整数部分，并传给setCellData函
             * 数在对应序号的测试数据行的最后一列设定“测试失败”
             */
            ExcelUtil.setCellData(Integer.parseInt(CaseRow.split("[.]")[0]), ExcelUtil.getLastColumnNum(),"测试失败");
            log.info(CaseName + "失败");
            Screenshot.method(driver,CaseName + "失败");
            log.info("调用Screenshot.method方法进行截图");
            log.endTestCase(CaseName);
            //调用Assert.fail方法将此测试用例设定为执行失败，后续测试代码将不被执行
            Assert.fail("执行DriverElement类的execute方法失败");
        }
        /*if (actions.equals("newDriver")){
            try {
                DriverElement.execute(driver, Preconditions, elementName, mode, objects, actions, parameters);
                Thread.sleep(3000);
            } catch (Exception e) {
                *//*
                 * 执行AddContactPersonAction类的execute方法失败时，catch语句可以捕获AssertionError类型
                 * 的异常，并设置Excel中测试数据行的执行结果为“测试失败”。由于Excel中的序号格式被默认设定
                 * 为带有一位小数点，所以使用 split("[.]"[0]) 语句获取序号的整数部分，并传给setCellData函
                 * 数在对应序号的测试数据行的最后一列设定“测试失败”
                 *//*
                ExcelUtil.setCellData(Integer.parseInt(CaseRow.split("[.]")[0]), ExcelUtil.getLastColumnNum(),"测试失败");
                log.info(CaseName + "失败");
                Screenshot.method(driver,CaseName + "失败");
                log.endTestCase(CaseName);
                //调用Assert.fail方法将此测试用例设定为执行失败，后续测试代码将不被执行
                Assert.fail("执行DriverElement类的execute方法失败");
            }
        }else {
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            try {
                DriverElement.execute(driver, Preconditions, elementName, mode, objects, actions, parameters);
            } catch (Exception e) {
                *//*
                 * 执行AddContactPersonAction类的execute方法失败时，catch语句可以捕获AssertionError类型
                 * 的异常，并设置Excel中测试数据行的执行结果为“测试失败”。由于Excel中的序号格式被默认设定
                 * 为带有一位小数点，所以使用 split("[.]"[0]) 语句获取序号的整数部分，并传给setCellData函
                 * 数在对应序号的测试数据行的最后一列设定“测试失败”
                 *//*
                ExcelUtil.setCellData(Integer.parseInt(CaseRow.split("[.]")[0]), ExcelUtil.getLastColumnNum(),"测试失败");
                log.info(CaseName + "失败");
                Screenshot.method(driver,CaseName + "失败");
                log.info("调用Screenshot.method方法进行截图");
                log.endTestCase(CaseName);
                //调用Assert.fail方法将此测试用例设定为执行失败，后续测试代码将不被执行
                Assert.fail("执行DriverElement类的execute方法失败");
            }
        }*/
    }

    @BeforeClass
    public void beforeClass() throws Exception{
        //读取Log4j.xml配置文件信息
        DOMConfigurator.configure("Log4j.xml");
        //使用Constant类中的常量，设定测试数据的文件路径和Sheet名称
        ExcelUtil.setExcelFile(Constant.TestDataExcelFilePath,Constant.TestDataExcelFileSheet);
        log.info("使用Constant类中的常量，设定测试数据的文件路径："+Constant.TestDataExcelFilePath);
        log.info("使用Constant类中的常量，设定测试数据的Sheet名称："+Constant.TestDataExcelFileSheet);
    }
    @BeforeTest
    @Parameters({"driverName"})
    public void beforeMethod(String driverName){
        if (driverName.equalsIgnoreCase("fireFox")){
            System.setProperty("webdriver.chrome.driver","../TestExcel/driver/chromedriver.exe");
            driver = new FirefoxDriver();
            log.info("启动火狐浏览器");
        }else {
            System.setProperty("webdriver.chrome.driver","../TestExcel/driver/chromedriver.exe");
            driver = new ChromeDriver();
            log.info("启动谷歌浏览器");
        }
    }
    @AfterTest
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
        log.info("关闭浏览器");
        /*SendEmail.sendToEmail("测试用例执行结束");
        log.info("邮箱发送成功");*/
    }
}
