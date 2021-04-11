package pages;

import base.BasePage;
import base.MainPage;
import base.TestInitialize;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DDLoginPage extends BasePage {

    private static final By txtUserName = By.id("login-email");
    private static final By txtPassword = By.id("login-password-input");
    private static final By buttonLogin = By.xpath("//*[@class='q-primary q-fluid q-button-medium q-button submit']/span[text()='Giriş Yap']");
    private static final By errorMessage = By.xpath("//*[@class='message'][text()='E-posta adresiniz ve/veya şifreniz hatalı.']");
    private static final By myAccountArea = By.xpath("//*[@class='link-text'][text()='Hesabım']");

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private XSSFCell cell;

    public DDLoginPage()
    {

    }

    public DDLoginPage login(String email, String password) {
        sendKey(txtUserName, email);
        sendKey(txtPassword, password);
        return this;
    }

    public void readFile() throws IOException {
        File file =new File("src/main/resources/data/DDlogindata.xlsx");
        FileInputStream fis =new FileInputStream(file);
        workbook= new XSSFWorkbook(fis);
        sheet=workbook.getSheetAt(0);

    }
    public void validUsernameAndPassword() {

        cell=sheet.getRow(1).getCell(0);
        DataFormatter formatter=new DataFormatter();
           String username=formatter.formatCellValue(cell);
           cell= sheet.getRow(1).getCell(1);
            String password= formatter.formatCellValue(cell);
            sendKey(txtUserName, username);
            sendKey(txtPassword, password);
            click(buttonLogin);

    }

    public void invalidUsernameAndPassword() {

        cell=sheet.getRow(2).getCell(0);
        DataFormatter formatter=new DataFormatter();
           String username=formatter.formatCellValue(cell);
           cell= sheet.getRow(2).getCell(1);
            String password= formatter.formatCellValue(cell);
            sendKey(txtUserName, username);
            sendKey(txtPassword, password);
            click(buttonLogin);

    }

    public void validUsernameAndBlankPassword() {

        cell=sheet.getRow(3).getCell(0);
        DataFormatter formatter=new DataFormatter();
        String username=formatter.formatCellValue(cell);
        cell= sheet.getRow(3).getCell(1);
        String password= formatter.formatCellValue(cell);
        sendKey(txtUserName, username);
        sendKey(txtPassword, password);
        click(buttonLogin);

    }

    public void invalidUsernameAndValidPassword() {

        cell=sheet.getRow(4).getCell(0);
        DataFormatter formatter=new DataFormatter();
        String username=formatter.formatCellValue(cell);
        cell= sheet.getRow(4).getCell(1);
        String password= formatter.formatCellValue(cell);
        sendKey(txtUserName, username);
        sendKey(txtPassword, password);
        click(buttonLogin);

    }

//    public void readFileAndLogin() throws IOException {
//        File file =new File("src/main/resources/data/DDlogindata.xlsx");
//        FileInputStream fis =new FileInputStream(file);
//        workbook= new XSSFWorkbook(fis);
//        sheet=workbook.getSheetAt(0);
//        for (int i=1; i<=sheet.getLastRowNum(); i++)
//        {
//            cell=sheet.getRow(i).getCell(0);
//            DataFormatter formatter=new DataFormatter();
//            String username=formatter.formatCellValue(cell);
//            cell= sheet.getRow(i).getCell(1);
//            String password= formatter.formatCellValue(cell);
//            sendKey(txtUserName, username);
//            sendKey(txtPassword, password);
//            click(buttonLogin);
//        }
//    }


    public void successLoginControl() {

        Assert.assertEquals(findElement(myAccountArea).getText(),"Hesabım");
    }

    public void IncorrectEmailOrPasswordControl() {

        Assert.assertEquals(findElement(errorMessage).getText(),"E-posta adresiniz ve/veya şifreniz hatalı.");
    }

    public void blankOrInvalidPasswordControl() {
        Assert.assertEquals(findElement(errorMessage).getText(),"Lütfen şifrenizi giriniz.");
    }

    public void blankOrInvalidEmailControl() {

        Assert.assertEquals(findElement(errorMessage).getText(),"Lütfen geçerli bir e-posta adresi giriniz.");
    }

}

