package tests;

import dataprovider.DataProvider;
import dataprovider.LoginDataModel;
import org.testng.annotations.Test;
import pages.HomePage;
import base.TestInitialize;

public class DataDrivenLoginTest extends TestInitialize {

    /**
     * CaseNo	Steps	                                        Expected Result
     * Case1	Doğru Kullanıcı adı ve Şifre girilir.	        Login olunduğu görülür
     * Case2	Yanlış Kullanıcı adı ve Şifre girilir.	        Hatalı E-Posta / Şifre. Tekrar Deneyin." mesajı geldiği görülür
     * Case3	Doğru Kullanıcı ad ve Boş şifre girilir.	    Lütfen şifre giriniz." mesajının geldiği görülür
     * Case4	Boş Kullanıcı adı ve Doğru şifre girilir.	    Lütfen email adresinizi giriniz." mesajının geldiği görülür
     *
     * @param loginData
     * @throws InterruptedException
     */

    @Test(dataProvider = "logindata", dataProviderClass = DataProvider.class)
    public void loginTest(LoginDataModel loginData) {

        TestInitialize.caseNo = loginData.getCaseNo();
        new HomePage()
                .closePopUp()
                .clickSignInIconButton()
                .login(loginData.getUsername(), loginData.getPassword())
                .clickLoginButton(loginData.getCaseNo());
    }
}
