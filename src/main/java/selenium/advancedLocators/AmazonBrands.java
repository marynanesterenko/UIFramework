package selenium.advancedLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class AmazonBrands {
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @Test
    public void printAllBrands() throws InterruptedException {
        driver.get("https://www.amazon.com");

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iPhone", Keys.ENTER);

        Thread.sleep(2000);
        WebElement seeMore = driver.findElement(By.xpath("//a[@aria-label='See more, Brand']/span"));
        seeMore.click();

        List <WebElement> allBrands = driver.findElements(By.cssSelector("li[id^='p_89']"));

        for (WebElement brand : allBrands){
            System.out.println(brand.getText());
        }
    }
}
