package vytrack.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CalenderEventsPage;
import pages.LoginPage;
import vytrack.testBase;
public class CreateCalenderEventTests extends testBase {
    @Test(description = "Verify owners name is equals to Stephan Haley (it works on qa1 storemenager85)")
    public void test1(){
        LoginPage loginPage = new LoginPage();
        CalenderEventsPage calendarEventsPage = new CalenderEventsPage();
        CalenderEventsPage createCalendarEventPage = new CalenderEventsPage();
        //login as Stephan Haley (storemanager85)
        loginPage.login("storemanager85", "UserUser123");
        //go to calendar events page
        loginPage.navigateTo("Activities", "Calendar Events");
        //click on create calendar event button
        calendarEventsPage.waitUntilLoaderMaskDisappear();
        calendarEventsPage.clickToCreateCalendarEvent();
        calendarEventsPage.waitUntilLoaderMaskDisappear();
        String expectedOwner = "Stephan Haley";
        String actualOwner = createCalendarEventPage.owner.getText().trim();
        Assert.assertEquals(actualOwner, expectedOwner);







    }
}