package selenium.basicLocators;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BasicLocatorsTest {

    static WebDriver driver; // here we declared the instance variable "driver"

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); // initialization of the instance variable "driver"
    }

    @Before
    public void goToHomePage(){
        driver.get("https://google.com");
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void findByName() {
        WebElement searchButton = driver.findElement(By.name("btnK"));
        Assert.assertEquals("Wrong text value on feelingLucky Button", "Google Search", searchButton.getAttribute("value"));
    }

    @Test
    public void findByLink(){
        WebElement gmailLink = driver.findElement(By.linkText("Gmail"));
        Assert.assertEquals("Gmail", gmailLink.getText());
        gmailLink.click();
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals("Gmail link on Google is not taking to the right page", "https://www.google.com/gmail/about/#", driver.getCurrentUrl());
    }

    @Test
    public void partialLinkText(){
        WebElement howSearchWorks = driver.findElement(By.partialLinkText("How Search "));
        howSearchWorks.click();
        Assert.assertEquals("Google Search - Discover How Google Search Works", driver.getTitle());
    }

    @Test
    // when we are using the "className" locator, we have to make sure that it is a unique className, which is used by
    // just one element, otherwise - it won't work
    public void className(){
        WebElement youtubeShorts = driver.findElement(By.className("NKcBbd"));
        youtubeShorts.click();
        Assert.assertEquals("Introducing the shorter side of YouTube - YouTube Shorts", driver.getTitle());
    }
}
