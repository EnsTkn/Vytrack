package pages;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
        //according to page object model design
//we have to create corresponded page class
//for each page of application
//login page = login page class
//every page class will store webelements and methods related to that page
public class LoginPage extends BasePage{
    @FindBy(id = "prependedInput")
    public WebElement userInput;
    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;
    @FindBy(id = "_submit")
    public WebElement logInButton;
    @FindBy(css="[class='alert alert-error']")
    public WebElement warningMessage;


    public LoginPage(){

        PageFactory.initElements(Driver.getDriver(), this);

        /*
       it's mandatory if you wont to use @FindBy annotation
       this means LoginPage class
       Driver.get() return WebDriver object
        */
    }
    public void login(String userName, String password){
        userInput.sendKeys(userName);
        passwordInput.sendKeys(password, Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        WebElement loaderMask = Driver.getDriver().findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.visibilityOf(loaderMask));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
    }
}