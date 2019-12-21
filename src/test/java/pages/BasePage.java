package pages;


import Utilities.BrowserUtills;
import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//everything that is in common among pages
//can go here
//for example top menu elements don't belong to specific page
//top menu appears on every single page
//so we can keep them here
public class BasePage {
    @FindBy(css = "div[class='loader-mask shown']")
    public WebElement loaderMask;
    @FindBy(css = "h1[class='oro-subtitle']")
    public WebElement pageSubTitle;
    @FindBy(css = "#user-menu > a")
    public WebElement userName;
    @FindBy(linkText = "Logout")
    public WebElement logOutLink;
    @FindBy(linkText = "My User")
    public WebElement myUser;
    public BasePage() {
        //this method requires to provide webdriver object for @FindBy
        //and page class
        //this means this page class
        PageFactory.initElements(Driver.getDriver(), this);
    }
    /**
     * While this loading screen present, html code is a not complete
     * Some elements can be missing
     * Also, you won't be able to interact with any elements
     * All actions will be intercepted
     * Waits until loader mask (loading bar, spinning wheel) disappears
     *
     * @return true if loader mask is gone, false if something went wrong
     */
    public boolean waitUntilLoaderMaskDisappear() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
        try {
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("Loader mask not found!");
            e.printStackTrace();
            return true; // no loader mask, all good, return true
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
        return false;
    }
    /**
     * This method stands for navigation in vytrack app
     * provide tab name, for example "Fleet" as a String
     * and module name, for example "Vehicles" as a String as well
     * then based on these values, locators will be created
     *
     * @param moduleName
     * @param subModuleName normalize-space() same line .trim() in java
     */
    public void navigateTo(String moduleName, String subModuleName) {
        String moduleLocator = "//*[normalize-space()='" + moduleName + "' and @class='title title-level-1']";
        String subModuleLocator = "//*[normalize-space()='" + subModuleName + "' and @class='title title-level-2']";
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(moduleLocator)));
        WebElement module = Driver.getDriver().findElement(By.xpath(moduleLocator));
        wait.until(ExpectedConditions.visibilityOf(module));
        wait.until(ExpectedConditions.elementToBeClickable(module));
        waitUntilLoaderMaskDisappear();
        module.click(); //once we clicked on module, submodule should be visible
        WebElement subModule = Driver.getDriver().findElement(By.xpath(subModuleLocator));
        wait.until(ExpectedConditions.visibilityOf(subModule));
        subModule.click();
    }
    /**
     * @return page name, for example: Dashboard
     */
    public String getPageSubTitle() {
        //ant time we are verifying page name, or page subtitle, loader mask appears
        waitUntilLoaderMaskDisappear();
        BrowserUtills.waitForStaleElement(pageSubTitle);
        return pageSubTitle.getText();
    }
    public String getUserName() {
        waitUntilLoaderMaskDisappear();
        BrowserUtills.waitForVisibility(userName, 5);
        return userName.getText();
    }
    public void logOut() {
        BrowserUtills.wait(2);
        BrowserUtills.clickWithJS(userName);
        BrowserUtills.clickWithJS(logOutLink);
    }
    public void goToMyUser() {
        waitUntilLoaderMaskDisappear();
        BrowserUtills.waitForClickablility(userName, 5).click();
        BrowserUtills.waitForClickablility(myUser, 5).click();
    }

    public void clickToCreateCalendarEvent() {
    }
}
