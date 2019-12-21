package vytrack.Tests;

import Utilities.BrowserFactory;
import Utilities.BrowserUtills;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCases {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void start() {
        driver = BrowserFactory.getDriver("chrome");
        driver.get("https://qa1.vytrack.com/");
        driver.manage().window().fullscreen();
        wait = new WebDriverWait(driver, 10);


        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        BrowserUtills.wait(2);
        driver.findElement(By.cssSelector("[type=\"submit\"]")).click();

        BrowserUtills.wait(5);

        WebElement activities = driver.findElement(By.linkText("Activities"));
        activities.click();

       // BrowserUtills.wait(3);

        wait.until(ExpectedConditions.visibilityOf(activities));
        wait.until(ExpectedConditions.elementToBeClickable(activities));
        activities.click();

       // BrowserUtills.wait(3);

        WebElement ClndrAct = driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.visibilityOf(ClndrAct));
        wait.until(ExpectedConditions.elementToBeClickable(ClndrAct));
        ClndrAct.click();
    }

    @Test(description = "Verify that “view”, “edit” and “delete” options are available")
    public void test1()  {

        BrowserUtills.wait(5);

        //Actions action1 = new Actions(driver);
       // WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        //wait.until(ExpectedConditions.invisibilityOf(loaderMask));

        Actions action1 = new Actions(driver);

        WebElement Elmnt1 = driver.findElement(By.xpath("//table//tr[15]//td[9]"));

        action1.moveToElement(Elmnt1).perform();

        WebElement elementview = driver.findElement(By.cssSelector("[href=\"/calendar/event/view/186\"]\n"));
        WebElement elementuptade = driver.findElement(By.cssSelector("[href=\"/calendar/event/update/186\"]\n"));
        WebElement elementDelete = driver.findElement(By.cssSelector("a[href='#']"));

        Assert.assertTrue(elementDelete.isDisplayed(), "None!");
        Assert.assertTrue(elementuptade.isDisplayed(), "None!");
        Assert.assertTrue(elementview.isDisplayed(),"None!");




    }

    @Test(description = "Verify page subtitle")
    public void test2() {


        WebElement web = driver.findElement(By.cssSelector("[title=\"Grid Settings\"]"));
        wait.until(ExpectedConditions.visibilityOf(web));
        web.click();

        BrowserUtills.wait(5);


        driver.findElement(By.xpath("//table//tbody//tr[2]//td[3]")).click();
        BrowserUtills.wait(1);
        driver.findElement(By.xpath("//table//tbody//tr[3]//td[3]")).click();
        BrowserUtills.wait(1);
        driver.findElement(By.xpath("//table//tbody//tr[4]//td[3]")).click();
        BrowserUtills.wait(1);
        driver.findElement(By.xpath("//table//tbody//tr[5]//td[3]")).click();
        BrowserUtills.wait(1);
        driver.findElement(By.xpath("//table//tbody//tr[6]//td[3]")).click();
        BrowserUtills.wait(1);
        driver.findElement(By.xpath("//table//tbody//tr[7]//td[3]")).click();

        WebElement elementRow = driver.findElement(By.xpath("//table//tbody//tr[1]\n"));
        BrowserUtills.wait(2);

        //WebElement elementClick = driver.findElement(By.xpath("//table//tbody//tr[1]//td[3]"));
        //Assert.assertTrue(elementClick.isSelected(), "!!!");


        Assert.assertTrue(elementRow.isDisplayed(), "!!!");
       // BrowserUtills.wait(2);



    }

    @Test(description = "Verify that “Save And Close”, “Save And New and “Save” options are available")
    public void Test3() {

        BrowserUtills.wait(2);

        WebElement element2 = driver.findElement(By.cssSelector("[title=\"Create Calendar event\"]"));
        wait.until(ExpectedConditions.visibilityOf(element2));
        element2.click();

        BrowserUtills.wait(2);

        WebElement element1 = driver.findElement(By.cssSelector("[class=\"btn-success btn dropdown-toggle\"]"));
        wait.until(ExpectedConditions.visibilityOf(element1));
        element1.click();

        for(int i =0; i < 3; i++) {

            WebElement option = driver.findElement(By.xpath("//li[1]//button[contains(text(), 'Save')]"));
            Assert.assertTrue(option.isDisplayed(), "None!!!");
            Assert.assertTrue(option.isEnabled(), "None!!!");
        }


    }

    @Test(description = "Verify that “All Calendar Events” page subtitle is displayed")
    public void test4() {

        BrowserUtills.wait(2);

        WebElement element2 = driver.findElement(By.cssSelector("[title=\"Create Calendar event\"]"));
        wait.until(ExpectedConditions.visibilityOf(element2));
        element2.click();

        BrowserUtills.wait(2);

        WebElement cancel = driver.findElement(By.cssSelector("[title=\"Cancel\"]"));
        wait.until(ExpectedConditions.visibilityOf(cancel));
        wait.until(ExpectedConditions.elementToBeClickable(cancel));
        cancel.click();

        BrowserUtills.wait(2);

        WebElement AllCalendarEvents = driver.findElement(By.xpath("//h1[contains(text(),'All')]"));
        wait.until(ExpectedConditions.visibilityOf(AllCalendarEvents));

        Assert.assertTrue(AllCalendarEvents.isDisplayed(), "None!!!");


    }

    @Test(description = "Verify that difference between end and start time is exactly 1 hour")
    public void test5() {

        BrowserUtills.wait(2);

        WebElement element2 = driver.findElement(By.cssSelector("[title=\"Create Calendar event\"]"));
        wait.until(ExpectedConditions.visibilityOf(element2));
        element2.click();

//        BrowserUtills.wait(2);
//
//        WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
//        wait.until(ExpectedConditions.invisibilityOf(loaderMask));

        BrowserUtills.wait(2);

        driver.findElement(By.cssSelector("[class=\"input-small timepicker-input start ui-timepicker-input\"]")).click();
        BrowserUtills.wait(2);
        driver.findElement(By.xpath("//li[contains(text(), '7:00 PM')]")).click();
//        WebElement start = driver.findElement(By.xpath("//li[contains(text(), '7:00 PM')]"));
//        String startText = start.getText();

        BrowserUtills.wait(3);

        driver.findElement(By.cssSelector("[class=\"input-small timepicker-input end ui-timepicker-input\"]")).click();
        BrowserUtills.wait(4);
        //driver.findElement(By.xpath("//li[contains(text(), '8:00 PM')]")).click();
        WebElement end = driver.findElement(By.cssSelector("[class=\"ui-timepicker-pm ui-timepicker-selected\"]:nth-of-type(3)"));
        String endText = end.getText();


        String expectedEndTime = "8:00 PM";

        System.out.println(endText);
       // System.out.println(expectedEndTime);

        BrowserUtills.wait(2);

        Assert.assertEquals(expectedEndTime, endText, "Start time and end time are not equals!!!");



        BrowserUtills.wait(2);





    }

    @Test(description = "Verify that end time is equals to “10:00 PM”")
    public void test6() {

        BrowserUtills.wait(2);

        WebElement element2 = driver.findElement(By.cssSelector("[title=\"Create Calendar event\"]"));
        wait.until(ExpectedConditions.visibilityOf(element2));
        element2.click();

        BrowserUtills.wait(2);

        driver.findElement(By.cssSelector("[class=\"input-small timepicker-input start ui-timepicker-input\"]")).click();
        BrowserUtills.wait(2);
        driver.findElement(By.xpath("//li[contains(text(), '9:00 PM')]")).click();

        BrowserUtills.wait(2);

        driver.findElement(By.cssSelector("[class=\"input-small timepicker-input end ui-timepicker-input\"]")).click();
        BrowserUtills.wait(1);
        WebElement end2 = driver.findElement(By.cssSelector("[class=\"ui-timepicker-pm ui-timepicker-selected\"]:nth-of-type(3)"));
        String endText = end2.getText();

        String expectedEndTime = "10:00 PM";

        System.out.println(endText);



        Assert.assertEquals(expectedEndTime, endText, "Start time and end time are not equals!!!");

    }

    @Test(description = "")
    public void test7() {

        BrowserUtills.wait(2);

//        WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
//        wait.until(ExpectedConditions.invisibilityOf(loaderMask));

        WebElement element2 = driver.findElement(By.cssSelector("[title=\"Create Calendar event\"]"));
        wait.until(ExpectedConditions.visibilityOf(element2));
        element2.click();

        BrowserUtills.wait(3);

        WebElement checked = driver.findElement(By.cssSelector("[name=\"oro_calendar_event_form[allDay]\"]"));
        checked.click();
        BrowserUtills.wait(2);
        Assert.assertTrue(checked.isSelected(),"It's not selected!");

        WebElement startTime = driver.findElement(By.cssSelector("[class=\"input-small timepicker-input start ui-timepicker-input\"]"));
        WebElement endTime = driver.findElement(By.cssSelector("[class=\"input-small timepicker-input end ui-timepicker-input\"]"));
        Assert.assertFalse(startTime.isDisplayed(), "it's displayed!");
        Assert.assertFalse(endTime.isDisplayed(),"It's displayed!");

        BrowserUtills.wait(2);

        WebElement startDate = driver.findElement(By.cssSelector("[class=\"input-small datepicker-input start hasDatepicker\"]"));
        WebElement endDate = driver.findElement(By.cssSelector("[class=\"input-small datepicker-input end hasDatepicker\"]"));
        Assert.assertTrue(startDate.isDisplayed(),"It's not displayed!");
        Assert.assertTrue(endDate.isDisplayed(),"It's not displayed!");


    }

    @Test
    public void test8() {

        BrowserUtills.wait(2);

        WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));

        WebElement CalendarEvent = driver.findElement(By.cssSelector("[class=\"btn main-group btn-primary pull-right \"]"));
        wait.until(ExpectedConditions.visibilityOf(CalendarEvent));
        CalendarEvent.click();

        BrowserUtills.wait(3);

        WebElement selectCheckbox = driver.findElement(By.cssSelector("[data-name=\"recurrence-repeat\"]"));
        wait.until(ExpectedConditions.visibilityOf(selectCheckbox));
        wait.until(ExpectedConditions.elementToBeClickable(selectCheckbox));
        selectCheckbox.click();
        BrowserUtills.wait(2);
        Assert.assertTrue(selectCheckbox.isSelected(),"It's not selected!!");

        BrowserUtills.wait(3);

        WebElement actualSelected = driver.findElement(By.cssSelector("[data-name=\"recurrence-repeats\"]"));
        String actualSelectedText = actualSelected.getText();
        String expectedSelected = "Daily";
        Assert.assertEquals(actualSelectedText, expectedSelected, "They are not equal!!");

        BrowserUtills.wait(2);

        Select timeOptions = new Select(selectCheckbox);

        //String actualSelectedText = timeOptions.getFirstSelectedOption().getText();
        List<WebElement> allOptions = timeOptions.getOptions();

        BrowserUtills.wait(2);

        ArrayList<String> actualOptions = new ArrayList<>();
        ArrayList<String> expectedOptions = new ArrayList<>();

        expectedOptions.addAll(Arrays.asList("Daily","Weekly","Monthly","Yearly"));

        BrowserUtills.wait(2);

        for(WebElement each: allOptions){
            actualOptions.add(each.getText());
        }
        Assert.assertEquals(expectedOptions, actualOptions,"ExpectedOptions and actualOptions are not same!");

    }

    @Test
    public void test9() {

        BrowserUtills.wait(2);

        WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));

        WebElement CalendarEvent = driver.findElement(By.cssSelector("[class=\"btn main-group btn-primary pull-right \"]"));
        wait.until(ExpectedConditions.visibilityOf(CalendarEvent));
        CalendarEvent.click();

        BrowserUtills.wait(3);

        WebElement repeatCheckbox = driver.findElement(By.cssSelector("[data-name=\"recurrence-repeat\"]"));
        wait.until(ExpectedConditions.visibilityOf(repeatCheckbox));
        wait.until(ExpectedConditions.elementToBeClickable(repeatCheckbox));
        repeatCheckbox.click();
        BrowserUtills.wait(2);
        Assert.assertTrue(repeatCheckbox.isSelected(),"It's not selected!!");

        WebElement repeatEvery = driver.findElement(By.cssSelector("[type=\"radio\"][checked=\"checked\"]"));
        Assert.assertTrue(repeatEvery.isSelected(), "It's not selected!!");

        WebElement neverButton = driver.findElement(By.cssSelector("[type='radio'][checked=\"\"]"));
        Assert.assertTrue(neverButton.isSelected(), "It's not selected!");

        WebElement message = driver.findElement(By.xpath("//*[contains(text(), 'Daily every')]"));
        Assert.assertTrue(message.isDisplayed(),"Message is not displayed!");

    }

    @Test
    public void test10() {

        BrowserUtills.wait(2);

        WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));

        WebElement CalendarEvent = driver.findElement(By.cssSelector("[class=\"btn main-group btn-primary pull-right \"]"));
        wait.until(ExpectedConditions.visibilityOf(CalendarEvent));
        CalendarEvent.click();

        BrowserUtills.wait(3);

        WebElement repeatCheckbox = driver.findElement(By.cssSelector("[data-name=\"recurrence-repeat\"]"));
        wait.until(ExpectedConditions.visibilityOf(repeatCheckbox));
        wait.until(ExpectedConditions.elementToBeClickable(repeatCheckbox));
        repeatCheckbox.click();
        BrowserUtills.wait(2);
        Assert.assertTrue(repeatCheckbox.isSelected(),"It's not selected!!");

        WebElement after = driver.findElement(By.xpath("//*[contains(text(), 'After')]"));
        after.click();

        WebElement occurence = driver.findElement(By.cssSelector("[data-related-field=\"occurrences\"]"));
        occurence.click();
        occurence.sendKeys("10", Keys.ENTER);

        WebElement message2 = driver.findElement(By.cssSelector("[data-name=\"recurrence-summary\"]"));
        String actuallmessage2 = message2.getText();
        String expectedMessage2 = "Daily every 1 day, end after 10 occurrences";

        Assert.assertEquals(actuallmessage2,expectedMessage2,"It's not displayed correctly!");

    }

    @Test
    public void test11() {


        BrowserUtills.wait(2);

        WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));

        WebElement CalendarEvent = driver.findElement(By.cssSelector("[class=\"btn main-group btn-primary pull-right \"]"));
        wait.until(ExpectedConditions.visibilityOf(CalendarEvent));
        CalendarEvent.click();

        BrowserUtills.wait(3);

        WebElement repeatCheckbox = driver.findElement(By.cssSelector("[data-name=\"recurrence-repeat\"]"));
        wait.until(ExpectedConditions.visibilityOf(repeatCheckbox));
        wait.until(ExpectedConditions.elementToBeClickable(repeatCheckbox));
        repeatCheckbox.click();
        BrowserUtills.wait(2);
        Assert.assertTrue(repeatCheckbox.isSelected(),"It's not selected!!");
//
//        driver.findElement(By.cssSelector("[class=\"input-small datepicker-input end hasDatepicker ui-datepicker-dialog-is-below\"]")).click();
//
//        Select selects = new Select(driver.findElement(By.cssSelector("[class=\"ui-datepicker-month\"]")));
//        selects.selectByIndex(10);
//
//        Select selects2 = new Select(driver.findElement(By.cssSelector("[class=\"ui-datepicker-year\"]")));
//        selects2.selectByIndex(12);
//
//        driver.findElement(By.xpath("//a[contains(text(), '18')]")).click();

        driver.findElement(By.xpath("//*[text()='By']")).click();

        WebElement date = driver.findElement(By.cssSelector("[class='datepicker-input hasDatepicker']"));
        date.sendKeys("Nov 18, 2021", Keys.ESCAPE);
        WebElement message3 = driver.findElement(By.cssSelector("[data-name='recurrence-summary']"));
        String actualMessage3 = message3.getText();
        String expectedMessage3= "Daily every 1 day, end by Nov 18, 2021";
        Assert.assertEquals(actualMessage3,expectedMessage3,"Summary message is not displayed correctly");

    }

    @Test
    public void test12() {


        BrowserUtills.wait(2);

        WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));

        WebElement CalendarEvent = driver.findElement(By.cssSelector("[class=\"btn main-group btn-primary pull-right \"]"));
        wait.until(ExpectedConditions.visibilityOf(CalendarEvent));
        CalendarEvent.click();

        BrowserUtills.wait(3);

        WebElement repeatCheckbox = driver.findElement(By.cssSelector("[data-name=\"recurrence-repeat\"]"));
        wait.until(ExpectedConditions.visibilityOf(repeatCheckbox));
        wait.until(ExpectedConditions.elementToBeClickable(repeatCheckbox));
        repeatCheckbox.click();
        BrowserUtills.wait(2);
        Assert.assertTrue(repeatCheckbox.isSelected(),"It's not selected!!");

        WebElement Options = driver.findElement(By.cssSelector("[data-name='recurrence-repeats']"));
        Select OptionS = new Select(Options);
        OptionS.selectByIndex(1);

        WebElement mondayCheckButton = driver.findElement(By.cssSelector("[type='checkbox'][value='monday']"));
        WebElement fridayCheckButton = driver.findElement(By.cssSelector("[type='checkbox'][value='friday']"));
        mondayCheckButton.click();
        fridayCheckButton.click();
        Assert.assertTrue(mondayCheckButton.isSelected(),"Monday checkbox is not selected");
        Assert.assertTrue(fridayCheckButton.isSelected(),"Friday checkbox is not selected");

        WebElement message = driver.findElement(By.cssSelector("[data-name='recurrence-summary']"));
        String actualMessage = message.getText();
        String expectedMessage= "Weekly every 1 week on Monday, Friday";
        Assert.assertEquals(actualMessage,expectedMessage,"Summary message is not displayed correctly");

    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
