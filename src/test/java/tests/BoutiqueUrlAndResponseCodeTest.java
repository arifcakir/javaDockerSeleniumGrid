package tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import base.TestInitialize;

import java.io.IOException;
public class BoutiqueUrlAndResponseCodeTest extends TestInitialize {

    @Test
    @Parameters("browser")
    public void urlAndResponseCodeTest() throws IOException
    {
        HomePage hp =new HomePage();
        hp.closePopUp();
        hp.urlAndResponseCode();
    }
}
