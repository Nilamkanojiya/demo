import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class firstTest {
    WebDriver driver;
    @BeforeTest
    void setup(){
        WebDriverManager.chromedriver().setup();
    }

    @Test
    void  selectEchoDot(){
        driver= new ChromeDriver();
        driver.get("https://www.amazon.co.uk/");
        driver.manage().window().maximize();


        //accept cookies
        WebElement cookiesCheck = driver.findElement(By.className("a-spacing-small"));
        boolean flag = cookiesCheck.isDisplayed();
        if (flag == true) {
            WebElement acceptCookiesButton = driver.findElement(By.id("sp-cc-accept"));
            acceptCookiesButton.click();
        }

        //search a keyword
        WebElement keyword = driver.findElement(By.id("twotabsearchtextbox"));
        keyword.sendKeys("Alexa");
        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        searchButton.click();
        WebElement echoDot = driver.findElement(By.linkText("Echo Dot (3rd Gen) - Compact Bluetooth Speaker with Alexa - Charcoal Fabric"));
        echoDot.click();
    }



    @AfterTest
    void cleanUp(){
        driver.close();
    }

}
