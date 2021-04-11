package pages;

import base.BasePage;
import base.MainPage;
import base.TestInitialize;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage extends BasePage {

    private static final By txtUserName = By.id("email");
    private static final By txtPassword = By.id("password");
    private static final By buttonLogin = By.id("loginSubmit");
    private static final By errorBox = By.id("errorBox");
    private static final By myAccountArea = By.id("logged-in-container");

    private String expectedInvalidMailOrPasswordMessage = "Hatalı E-Posta - Şifre girdiniz. Tekrar Deneyiniz.";
    private String expextedInvalidPasswordMessage = "Lütfen şifre giriniz.";
    private String expetedInvalidMailMessage = "Lütfen email adresinizi giriniz.";


    public LoginPage login(String email, String password) {
        sendKey(txtUserName, email);
        sendKey(txtPassword, password);
        return this;
    }

    public MainPage clickLoginButton(String dataNo) {
        click(buttonLogin);
        loginControl(dataNo);
        return new MainPage();
    }

    /**
     * 4 case'i 7 data ile çoğaltarak yapılan kontrol.
     * @param caseNo
     */
    public void loginControl(String caseNo) {

        switch (caseNo) {
            case "Data1":
                successLoginControl(); //Case 1
                break;
            case "Data5":
            case "Data6":
            case "Data2":
                IncorrectEmailOrPasswordControl(); // Case 2
                break;
            case "Data3":
                blankOrInvalidPasswordControl(); // Case 3
                break;
            case "Data4":
            case "Data7":
                blankOrInvalidEmailControl(); // Case 4
                break;
            default:
                break;
        }

    }

    /**
     * @apiNote Testler paralel ve aynı anda koştuğu için
     */
    private void successLoginControl() {

        Assert.assertTrue(isExistElement(myAccountArea), "-> " + TestInitialize.caseNo + "Hesabım Alanı Gözükmüyor, Başarılı Login Olunamamış. ");
        // logger.info("Login is Successful.");
    }

    private void IncorrectEmailOrPasswordControl() {

        Assert.assertTrue(expectedInvalidMailOrPasswordMessage.equalsIgnoreCase(findElement(errorBox).getText()), "Yanlış Hata Mesajı." +
                TestInitialize.caseNo + " -> Beklenen Mesaj: " + expectedInvalidMailOrPasswordMessage + " , Gelen Mesaj: " + findElement(errorBox).getText());
    }

    private void blankOrInvalidPasswordControl() {
        Assert.assertTrue(expextedInvalidPasswordMessage.equalsIgnoreCase(findElement(errorBox).getText()), "Yanlış Hata Mesajı. " +
                TestInitialize.caseNo + " -> Beklenen Mesaj: " + expextedInvalidPasswordMessage
                + ",Gelen Mesaj: " + findElement(errorBox).getText());
    }

    private void blankOrInvalidEmailControl() {
        Assert.assertTrue(expetedInvalidMailMessage.equalsIgnoreCase(findElement(errorBox).getText()), "Yanlış Hata Mesajı. " +
                TestInitialize.caseNo + " -> Beklenen Mesaj: " + expetedInvalidMailMessage + ",Gelen Mesaj: " + findElement(errorBox).getText());
    }

}

