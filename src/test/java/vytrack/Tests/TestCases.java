package vytrack.Tests;

import Utilities.BrowserFactory;
import Utilities.BrowserUtills;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TestCases {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void start() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://qa1.vytrack.com/");
        driver.manage().window().fullscreen();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void test1()  {


        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        BrowserUtills.wait(2);
        driver.findElement(By.cssSelector("[type=\"submit\"]")).click();

        BrowserUtills.wait(3);

        WebElement activities = driver.findElement(By.linkText("Activities"));
        //BrowserUtills.wait(2);
        wait.until(ExpectedConditions.visibilityOf(activities));
        wait.until(ExpectedConditions.elementToBeClickable(activities));
        activities.click();

        BrowserUtills.wait(2);

        WebElement ClndrAct = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(ClndrAct));
        wait.until(ExpectedConditions.elementToBeClickable(ClndrAct));
        ClndrAct.click();


        BrowserUtills.wait(2);

        //Actions action1 = new Actions(driver);
        WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));

    }

    @Test(description = "Verify page subtitle")
    public void test2() {
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        BrowserUtills.wait(2);
        driver.findElement(By.cssSelector("[type=\"submit\"]")).click();

        BrowserUtills.wait(3);

        WebElement activities = driver.findElement(By.linkText("Activities"));
        activities.click();

        BrowserUtills.wait(2);

        wait.until(ExpectedConditions.visibilityOf(activities));
        wait.until(ExpectedConditions.elementToBeClickable(activities));
        activities.click();

        BrowserUtills.wait(3);

        WebElement ClndrAct = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(ClndrAct));
        wait.until(ExpectedConditions.elementToBeClickable(ClndrAct));
        ClndrAct.click();

        BrowserUtills.wait(3);

        WebElement web = driver.findElement(By.cssSelector("[title=\"Grid Settings\"]"));
        wait.until(ExpectedConditions.visibilityOf(web));
        web.click();

        BrowserUtills.wait(5);


        driver.findElement(By.cssSelector("[id=\"column-c103\"]")).click();
        BrowserUtills.wait(1);
        driver.findElement(By.id("column-c104")).click();
        BrowserUtills.wait(1);
        driver.findElement(By.id("column-c105")).click();
        BrowserUtills.wait(1);
        driver.findElement(By.id("column-c106")).click();
        BrowserUtills.wait(1);
        driver.findElement(By.id("column-c107")).click();
        BrowserUtills.wait(1);
        driver.findElement(By.id("column-c108")).click();
        BrowserUtills.wait(3);

        WebElement web2 = driver.findElement(By.xpath("//*[@id=\"grid-calendar-event-grid-178837601\"]/div[2]/div[1]/div/div[3]/div[1]/div/div/div/div[4]/div[2]/table/tbody/tr[1]"));

        Assert.assertTrue(web2.isDisplayed(), "Not displyaed!");







    }




    @AfterMethod
    public void tearDown(){

        driver.quit();
    }


}
