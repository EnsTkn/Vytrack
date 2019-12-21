package Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
/*
/*
            in OOP we have design patterns:
                It's a proven for specific task
                One of the most popular design pattern for WebDriver in Selenium is SingleTon
                    SingleTon means single object of something for entire project
                           --> This Object will be static and we can ensure that all tests use same driver object
                                So we can create Test suits
                                Also whenever we need to use driver, we will just call it from Driver class.
                                The same driver will be used in every class
                                the alternative is to create a new driver for each class
 */
public class Driver {
    private static WebDriver driver;
    //no object creation by making private constructor
    //you cannot do like this, if constructor is private Driver obj = new Driver
    private Driver(){
    }
    //if switch statements complains on string parameter
    //change java version 7+, better at least 8
    public  static WebDriver getDriver(){
        //if webdriver object was not created yet
        if(driver==null){
            //create webdriver object based on browser value from properties file
            String browser = ConfigurationReader.getProperty("browser");
            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver= new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    driver = new SafariDriver();
                    break;
                default:
                    //if browser type is wrong, stop tests and throw exception
                    //no browser will be opened
                    throw new RuntimeException("Wrong browser type!");
            }
        }
        //if webdriver object was created - you cab use it
        return driver;
    }
    public static void close(){
        //if driver still exist
        if (driver !=null){
            //close all browser
            driver.quit();
            //destroy driver object ready for garbage collector
            driver =null;
        }
    }
}