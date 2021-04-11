package tests;


import org.testng.annotations.Test;
import pages.HomePage;
import base.TestInitialize;
import java.io.IOException;

public class ImgResponseCodeAndLoadTimeTest extends TestInitialize {


    @Test
    public void imgResponseCodeAndResponseTimeTest() throws IOException
    {
        HomePage hp =new HomePage();
        hp.closePopUp();
        hp.imgResponseTimeAndResponseCode();
    }

}
