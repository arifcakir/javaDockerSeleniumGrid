package base;


import helper.JavaScriptOperation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import wait.ExplicitWaitServiceServices;

import java.util.List;

public class BasePage {

    JavaScriptOperation javaScriptOperation = new JavaScriptOperation();
    protected WebDriver webDriver;

    public BasePage() {
        this.webDriver = TestInitialize.getDriver();
    }

    protected WebElement findElement(By by) {
        try {
            return new ExplicitWaitServiceServices().waitVisibleOfElementLocatedBy(by);
        } catch (Exception ex) {
            throw ex;
        }
    }

    protected List<WebElement> findElements(By by) {
        try {
            return new ExplicitWaitServiceServices().waitPresenceOfAllElementLocatedBy(by);
        } catch (Exception ex) {
            throw ex;
        }
    }

    protected void click(By by) {
        try {
            new ExplicitWaitServiceServices().waitElementToBeClickableBy(by).click();
        } catch (Exception ex) {
            throw ex;
        }
    }

    protected void sendKey(By by, String text) {
        try {
            new ExplicitWaitServiceServices().waitVisibleOfElementLocatedBy(by).sendKeys(text);
        } catch (Exception ex) {
            throw ex;
        }
    }

    protected Boolean isExistElement(By by) {
        try {
            new ExplicitWaitServiceServices().waitPresenceOfElementLocatedBy(by);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    protected void scrollToElementWithLocation(int elementLocationX, int elementLocationy) {
        String script = String.format("window.scrollTo(%d, %d);", elementLocationX, elementLocationy);
        javaScriptOperation.executeJS(script, true);
    }

    public void scrollToWebElement(WebElement webElement) {
        String script = String.format("window.scrollTo(%d, %d);", webElement.getLocation().getX(), webElement.getLocation().getY());
        javaScriptOperation.executeJS(script, true);
    }
//    protected void scrollToElementBy(By by) {
//        WebElement webElement = findElement(by);
//        scrollToElementWithLocation(webElement.getLocation().getX(), webElement.getLocation().getY());
//        }
//
//    protected void moveToElement(By by) {
//        Actions actions = new Actions(driver);
//        actions.moveToElement(findElement(by)).build().perform();
//          }
//
//    protected void scrollToBottomPageWithJs(){
//        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
//        }

}
