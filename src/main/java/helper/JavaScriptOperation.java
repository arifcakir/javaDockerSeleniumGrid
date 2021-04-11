package helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import base.TestInitialize;

public class JavaScriptOperation extends TestInitialize {
    WebDriver jsDriver = driver;

    public JavascriptExecutor getJSExecutor() {
        return (JavascriptExecutor) this.jsDriver;
    }

    public Object executeJS(String jsStmt) {
        return this.getJSExecutor().executeScript(jsStmt, new Object[0]);
    }

    public Object executeJS(String script, Object... obj) {
        return this.getJSExecutor().executeScript(script, obj);
    }
}
