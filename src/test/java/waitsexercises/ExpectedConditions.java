package waitsexercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.*;

import java.time.Duration;

import static org.testng.Assert.*;

public class ExpectedConditions {
    protected WebDriver driver;
    String EXPECTED_MESSAGE = "Warning: The E-Mail Address was not found in our records, please try again!";

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/index.php?route=account/forgotten");
    }

    @AfterTest
    public void tearDown() {
        driver.close();
    }

    @Test
    public void testGoodWait() {
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Boolean isElementWithTextDisplayed = wait.until(org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElement(
                driver.findElement(By.xpath("//*[@id=\"account-forgotten\"]/div[1]")), EXPECTED_MESSAGE));
        assertTrue(isElementWithTextDisplayed, "Some message");
    }
}




// Aurimo sprendimo budas
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement warning = wait.until(
//                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"account-forgotten\"]/div[1]"))
//        );
//
//        assertEquals(warning.getText(), ("Warning: The E-Mail Address was not found in our records, please try again!"), "Some message");
//
//        driver.close();

//package Waits;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.testng.annotations.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import java.time.Duration;
//
//import static org.testng.Assert.assertEquals;
//
//public class ExerciseExpectedConditions {
//
//    protected static WebDriver driver;
//
//    @Test
//    public void testExpectedConditions() {
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.get("https://demo.opencart.com/index.php?route=account/forgotten");
//
//        driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div[2]/input")).click();
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement warning = wait.until(
//                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"account-forgotten\"]/div[1]"))
//        );
//
//        assertEquals(warning.getText(), ("Warning: The E-Mail Address was not found in our records, please try again!"), "Some message");
//
//        driver.close();
//    }
//}
