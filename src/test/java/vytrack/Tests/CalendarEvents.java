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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalendarEvents {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://qa1.vytrack.com/");
        driver.manage().window().fullscreen();
        wait = new WebDriverWait(driver, 10);

    }

    @Test
    public void test1() {

        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        BrowserUtills.wait(2);
        driver.findElement(By.cssSelector("[type=\"submit\"]")).click();

        BrowserUtills.wait(10);


        WebElement activities = driver.findElement(By.linkText("Activities"));
        wait.until(ExpectedConditions.visibilityOf(activities));
        wait.until(ExpectedConditions.elementToBeClickable(activities));
        activities.click();

        //BrowserUtills.wait(2);

        WebElement ClndrAct = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(ClndrAct));
        wait.until(ExpectedConditions.elementToBeClickable(ClndrAct));
        ClndrAct.click();

        BrowserUtills.wait(6);

        WebElement elmnt = driver.findElement(By.xpath("//div[contains(text(), 'Options')]"));
        wait.until(ExpectedConditions.visibilityOf(elmnt));
        wait.until(ExpectedConditions.elementToBeClickable(elmnt));
        Assert.assertTrue(elmnt.isDisplayed(), "Not displayed!");


    }
    @Test
    public void test2 () {


        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        BrowserUtills.wait(2);
        driver.findElement(By.cssSelector("[type=\"submit\"]")).click();

        BrowserUtills.wait(10);


        WebElement activities = driver.findElement(By.linkText("Activities"));
        wait.until(ExpectedConditions.visibilityOf(activities));
        wait.until(ExpectedConditions.elementToBeClickable(activities));
        activities.click();

        //BrowserUtills.wait(2);

        WebElement ClndrAct = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(ClndrAct));
        wait.until(ExpectedConditions.elementToBeClickable(ClndrAct));
        ClndrAct.click();

        BrowserUtills.wait(6);

        WebElement elmnt2 = driver.findElement(By.cssSelector("[type=\"number\"][value=\"1\"]"));
        String elmnt2attrbt = elmnt2.getAttribute("value");
        System.out.println(elmnt2attrbt);
        Assert.assertEquals(elmnt2attrbt, "1");


    }

    @Test
    public void test3() {

        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        BrowserUtills.wait(2);
        driver.findElement(By.cssSelector("[type=\"submit\"]")).click();

        BrowserUtills.wait(10);


        WebElement activities = driver.findElement(By.linkText("Activities"));
        wait.until(ExpectedConditions.visibilityOf(activities));
        wait.until(ExpectedConditions.elementToBeClickable(activities));
        activities.click();

        //BrowserUtills.wait(2);

        WebElement ClndrAct = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(ClndrAct));
        wait.until(ExpectedConditions.elementToBeClickable(ClndrAct));
        ClndrAct.click();

        BrowserUtills.wait(6);

        WebElement elmnt3 = driver.findElement(By.xpath("//button[@class=\"btn dropdown-toggle \"]"));
        String elmnt3text = elmnt3.getText();
        Assert.assertEquals(elmnt3text, "25", "Not 25!");
        System.out.println(elmnt3text);
    }

    @Test
    public void test4() {

        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        BrowserUtills.wait(2);
        driver.findElement(By.cssSelector("[type=\"submit\"]")).click();

        BrowserUtills.wait(10);


        WebElement activities = driver.findElement(By.linkText("Activities"));
        wait.until(ExpectedConditions.visibilityOf(activities));
        wait.until(ExpectedConditions.elementToBeClickable(activities));
        activities.click();

        //BrowserUtills.wait(2);

        WebElement ClndrAct = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(ClndrAct));
        wait.until(ExpectedConditions.elementToBeClickable(ClndrAct));
        ClndrAct.click();

        BrowserUtills.wait(6);

        int expectedcount = 20;
        int elmnt4 = driver.findElements(By.cssSelector("tr[class='grid-row row-click-action']")).size();
        WebElement elmnt5 = driver.findElement(By.xpath("//label[text()='Total of 20 records']"));
        String elmnt5str = elmnt5.getText();
        String elmnt5num = elmnt5str.substring(9, 11);

        System.out.println(elmnt5num);
        System.out.println(elmnt4);

        Assert.assertTrue(elmnt5str.contains(elmnt4+""), "None!!");

    }

    @Test(description = "After clicking top checkbox, Verify that all calendar events were selected")
    public void test5() {


        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        BrowserUtills.wait(2);
        driver.findElement(By.cssSelector("[type=\"submit\"]")).click();

        BrowserUtills.wait(10);


        WebElement activities = driver.findElement(By.linkText("Activities"));
        wait.until(ExpectedConditions.visibilityOf(activities));
        wait.until(ExpectedConditions.elementToBeClickable(activities));
        activities.click();

        //BrowserUtills.wait(2);

        WebElement ClndrAct = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(ClndrAct));
        wait.until(ExpectedConditions.elementToBeClickable(ClndrAct));
        ClndrAct.click();

        BrowserUtills.wait(6);

        int sizeofrows = driver.findElements(By.cssSelector("tr[class='grid-row row-click-action']")).size();

        BrowserUtills.wait(1);

        WebElement elmnt6 = driver.findElement(By.cssSelector("[class='btn btn-default btn-small dropdown-toggle']>input"));
        wait.until(ExpectedConditions.visibilityOf(elmnt6));
        elmnt6.click();
        wait.until(ExpectedConditions.elementToBeSelected(elmnt6));
        BrowserUtills.wait(2);

        int selectedrows = driver.findElements(By.cssSelector("tr[class=\"grid-row row-click-action row-selected\"]")).size();

        Assert.assertEquals(sizeofrows, selectedrows, "Not equall!");


    }
    @Test(description= "Verify that following data is displayed:")
    public void test6() {

        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        BrowserUtills.wait(2);
        driver.findElement(By.cssSelector("[type=\"submit\"]")).click();

        BrowserUtills.wait(10);


        WebElement activities = driver.findElement(By.linkText("Activities"));
        wait.until(ExpectedConditions.visibilityOf(activities));
        wait.until(ExpectedConditions.elementToBeClickable(activities));
        activities.click();

        //BrowserUtills.wait(2);

        WebElement ClndrAct = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(ClndrAct));
        wait.until(ExpectedConditions.elementToBeClickable(ClndrAct));
        ClndrAct.click();

        BrowserUtills.wait(6);

        driver.findElement(By.cssSelector("[class=\"grid-row row-click-action\"]:nth-of-type(14)")).click();

        BrowserUtills.wait(5);

        //WebElement mask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        //wait.until(ExpectedConditions.invisibilityOf(mask));

        List<String> List = new ArrayList<String>(Arrays.asList(
                "Testers Meeting",
                "This is a a weekly testers meeting",
                "Nov 27, 2019, 9:30 PM",
                "Nov 27, 2019, 10:30 PM",
                "No",
                "Stephan Haley",
                "Tom Smith",
                "Weekly every 1 week on Wednesday",
                "No" ));

        for(int i =0; i<List.size(); i++) {
            String actualones = driver.findElements(By.cssSelector("[class='responsive-block']>div>div>div")).get(i).getText();
            if(i==6){
                Assert.assertEquals(actualones.replace(" - Required", ""), (List.get(i)));
                System.out.println(actualones.replace(" - Required", ""));
            }else{
                Assert.assertEquals(actualones, List.get(i));
                System.out.println(actualones);
            }
        }


    }

    @AfterMethod
    public void tearDown()  {
        driver.quit();
    }


}
