package tests;


import base.TestInitialize;
import org.testng.annotations.Test;
import pages.DDLoginPage;
import pages.HomePage;
import java.io.IOException;

public class DDLoginTest extends TestInitialize {

    /**
     * CaseNo	Steps	                                        Expected Result
     * Case1	Doğru Kullanıcı adı ve Şifre girilir.	        Login olunduğu görülür
     * Case2	Yanlış Kullanıcı adı ve Şifre girilir.	        Hata mesajı kontrol edilir.
     * Case3	Doğru Kullanıcı ad ve Boş şifre girilir.	    Hata mesajı kontrol edilir.
     * Case4	Yanlış Kullanıcı adı ve Doğru şifre girilir.	Hata mesajı kontrol edilir.
     * Bu Temel senaryolar dısında farklı senaryolarda yazılabilir.
     */

    @Test(priority = 3)
    public void validUsernameAndPasswordTest() throws IOException {

        HomePage hp =new HomePage();
        hp.closePopUp();
        hp.clickSignInIconButton();
        DDLoginPage ddl=new DDLoginPage();
        ddl.readFile();
        ddl.validUsernameAndPassword();
        ddl.successLoginControl();

    }

    @Test(priority = 0)
    public void invalidUsernameAndInvalidPasswordTest() throws IOException {

        HomePage hp =new HomePage();
        hp.closePopUp();
        hp.clickSignInIconButton();
        DDLoginPage ddl=new DDLoginPage();
        ddl.readFile();
        ddl.invalidUsernameAndPassword();
        ddl.IncorrectEmailOrPasswordControl();
    }

    @Test(priority = 1)
    public void validUsernameAndBlankPasswordTest() throws IOException {

        HomePage hp =new HomePage();
        hp.closePopUp();
        hp.clickSignInIconButton();
        DDLoginPage ddl=new DDLoginPage();
        ddl.readFile();
        ddl.validUsernameAndBlankPassword();
        ddl.blankOrInvalidPasswordControl();
    }
    @Test(priority = 2)
    public void invalidUsernameAndValidPasswordTest() throws IOException {

        HomePage hp =new HomePage();
        hp.closePopUp();
        hp.clickSignInIconButton();
        DDLoginPage ddl=new DDLoginPage();
        ddl.readFile();
        ddl.invalidUsernameAndValidPassword();
        ddl.blankOrInvalidPasswordControl();
    }
}
