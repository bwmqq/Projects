package fan.selenium.testMode.TestSC;

import fan.selenium.testMode.util.log;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.SessionStorage;
import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class TestSession {
    @Test
    public void Test() throws Exception {
        System.setProperty("webdriver.chrome.driver", "../TestExcel/driver/chromedriver.exe");
        log.info("启动谷歌浏览器");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://healthpc.qajeejio.com/");
        driver.manage().window().maximize();
        /*driver.findElementByCssSelector("input[type='text']").sendKeys("17701333349");
        driver.findElementByCssSelector("input[type='password']").sendKeys("1234qwer");
        Thread.sleep(500);
        driver.findElementByCssSelector(".BlueLogin").click();
        Thread.sleep(3000);
        SessionStorage sessionStorage = driver.getSessionStorage();
        Set<String> strings = sessionStorage.keySet();
        List<String> strings1 = new ArrayList<String>(strings);
        Properties pro = new Properties();
        FileOutputStream file = new FileOutputStream("../TestExcel/src/test/resources/session.properties");
        for (String key : strings1) {
            pro.setProperty(key, sessionStorage.getItem(key));
        }
        pro.store(file, "Session");
        sessionStorage.setItem("1111", "22222");
        driver.navigate().refresh();*/

        /*System.setProperty("webdriver.chrome.driver", "../TestExcel/driver/chromedriver.exe");
        log.info("启动谷歌浏览器");
        ChromeDriver driver1 = new ChromeDriver();
        driver1.get("https://healthpc.qajeejio.com/index");
        Thread.sleep(3000);
        String session = "token,sessionId";
        ProUtil proUtil = new ProUtil("../TestExcel/session.properties");
        String[] split = session.split(",");
        SessionStorage sessionStorage1 = driver1.getSessionStorage();
        for (int i = 0; i < split.length; i++) {
            String value = proUtil.getPro(split[i]);
            sessionStorage1.setItem(split[i], value);
        }
        driver1.navigate().refresh();
        Thread.sleep(20000);
        driver1.quit();*/
    }
}
