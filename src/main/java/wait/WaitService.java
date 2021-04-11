package wait;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.TestInitialize;

public class WaitService {

    protected WebDriver webdriver = TestInitialize.getDriver();
    public Wait<WebDriver> fluentWebDriverWait;
    public WebDriverWait explicitWebDriverWait;

    /**
     * should not be used unless needed.
     * @param second
     */
    public static void threadWait(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
