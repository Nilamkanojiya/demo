import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;


public class firstTest {
    WebDriver driver;
    @BeforeTest
    void setup(){
        WebDriverManager.chromedriver().setup();
    }

    @Test
    void  solicitorJourneyCaseCreation() {
        driver= new ChromeDriver();
        driver.get("https://manage-case.demo.platform.hmcts.net/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.manage().window().maximize();


//        //accept cookies
//        WebElement cookiesCheck = driver.findElement(By.id("cookie-accept-submit"));
//        boolean flag = cookiesCheck.isDisplayed();
//        if (flag == true) {
//            WebElement acceptCookiesButton = driver.findElement(By.id("cookie-accept-submit"));
//            acceptCookiesButton.click();
//        }

        //login
        WebElement username= driver.findElement(By.id("username"));
        username.sendKeys("fr_applicant_solicitor1@mailinator.com");

        WebElement password= driver.findElement(By.id("password"));
        password.sendKeys("Testing1234");

        WebElement sigInButton= driver.findElement(By.name("save"));
       sigInButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        driver.findElement(By.linkText("Create case"));

    }



    @AfterTest
    void cleanUp(){
        driver.close();
    }

}
