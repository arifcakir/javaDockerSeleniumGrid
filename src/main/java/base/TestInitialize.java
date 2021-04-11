package base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import java.net.MalformedURLException;
import java.net.URL;


public class TestInitialize {

    public static String caseNo;
    public static String localPath = System.getProperty("user.dir");
    public static String companyUrl = "https://www.trendyol.com/";
    protected static RemoteWebDriver driver;
    protected DesiredCapabilities caps;

    @BeforeMethod
    //@Parameters("browser")
    @Parameters(value = {"browser"})
    public void setup (String br) throws MalformedURLException {

        URL url = new URL("http://localhost:4444/wd/hub");
        caps =new DesiredCapabilities();
        if (br.equals("chrome"))
        {
            caps.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
            caps.setCapability("zal:name", "Trendyol");
            caps.setCapability("zal:recordVideo", true);
            caps.setCapability("autoAcceptAlerts", true);
        }
        else if (br.equals("firefox"))
        {
            caps.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
            caps.setCapability("zal:name", "Trendyol");
            caps.setCapability("zal:recordVideo", true);
            caps.setCapability("autoAcceptAlerts", true);
        }

        driver = new RemoteWebDriver(url,caps);
        driver.manage().window().maximize();
        driver.get(companyUrl);

    }

    public static WebDriver getDriver() {
        return driver;
    }


    @AfterMethod
    void tearDown()
    {
        driver.close();
    }

}
