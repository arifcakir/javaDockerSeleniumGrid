package pages;


import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import helper.RestAssuredHelper;
import wait.ExplicitWaitServiceServices;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    private static final By homePagePopUp = By.xpath("//a[@title='Close']");
    private static final By signInIcon = By.xpath("//*[@class='link-text'][text()='Giriş Yap']");
    private static final By boutiqueUrl = By.xpath("//article/a[contains(@href,'/')]");
    private static final By imgUrl = By.xpath("//article/a/span/img[contains(@src,'/')]");
    private static String href;
    private static String src;
    private static String statusCode;
    private static String imgResponseTime;

    public HomePage closePopUp() {
        if (isExistElement(homePagePopUp)) {
            findElement(homePagePopUp).click();
        } else {
        }
        return this;
    }

    public void urlAndResponseCode() throws IOException {
        File file = new File("CSVFiles\\BoutiqueUrlAndResponseCode.csv");
        FileWriter output = new FileWriter(file);
        PrintWriter out = new PrintWriter(output);

        List<WebElement> myList=findElements(boutiqueUrl);

        List<String> all_elements=new ArrayList<>();

        for(int i=0; i<myList.size(); i++){
            all_elements.add(href=myList.get(i).getAttribute("href"));
            // scrollToWebElement(myList.get(i));
            statusCode = String.valueOf(RestAssuredHelper.getStatusCodeForGetRequest(href));
            out.print(href);
            out.print(" , ");
            out.print(statusCode);
            out.print("\n");

        }
        out.flush();
        out.close();
        output.close();
    }

    public void imgResponseTimeAndResponseCode() throws IOException {
        File file = new File("CSVFiles\\BoutiqueImgUrlResponseTimeAndResponseCode.csv");
        FileWriter output = new FileWriter(file);
        PrintWriter out = new PrintWriter(output);

         List<WebElement> imgList=findElements(imgUrl);
        List<String> all_elements=new ArrayList<>();

        for(int i=0; i<imgList.size(); i++){
            all_elements.add(src=imgList.get(i).getAttribute("src"));
            scrollToWebElement(imgList.get(i));
            new ExplicitWaitServiceServices().attributeToBeNotEmptyBy(imgList.get(i), "src");
            imgResponseTime=String.valueOf(RestAssuredHelper.getResponseTimeForGetRequest(src));
            statusCode = String.valueOf(RestAssuredHelper.getStatusCodeForGetRequest(src));
            out.print(src);
            out.print(" , ");
            out.print(imgResponseTime);
            out.print(" , ");
            out.print(statusCode);
            out.print("\n");
        }
        out.flush();
        out.close();
        output.close();
    }

    public LoginPage clickSignInIconButton() {
        click(signInIcon);
        return new LoginPage();
    }

}