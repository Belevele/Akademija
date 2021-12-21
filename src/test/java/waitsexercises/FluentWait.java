//package Waits;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//import static org.testng.Assert.assertTrue;
//
//import java.time.Duration;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//
//public class FluentWait {
//      protected static WebDriver driver;
//      String expectedMessage = "Warning: The E-Mail Address was not found in our records, please try again!";
//
//        @BeforeTest
//        public void setUp() {
//            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
//            driver.get("https://demo.opencart.com/index.php?route=account/forgotten");
//        }
//
//        @AfterTest
//        public void close() {
//            driver.close();
//        }
//
//        @Test
//                public void close() {
//
//
//    FluentWait wait = new FluentWait(driver)
//            .withTimeout(Duration.ofSeconds(20))
//            .pollingEvery(Duration.ofMillis(500));
//            wait.ignoring(NoSuchElementException.class);
//
//        Boolean isElementWithTextDisplayed = (Boolean) wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//*[@id=\"account-forgotten\"]/div[1]")), expectedMessage);
//        assertTrue(isElementWithTextDisplayed, "Some message");
//        }
//}
//
////        public void testFluentWait () {
////            Wait<WebDriver> wait = new FluentWait<>(driver)
////                    .withTimeout(Duration.ofSeconds(20))
////                    .pollingEvery(Duration.ofMillis(500))
////                    .ignoring(NoSuchElementException.class);
////
////            WebElement alertElement = wait.until(new Function<>() {
////                public WebElement apply(WebDriver driver) {
////                    return driver.findElement(By.xpath("//*[@id=\"account-forgotten\"]/div[1]"));
////                }
////            });
////
////            driver.findElement(By.xpath("//input[@value='Continue']")).click();
////            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
////            Boolean isElementWithTextDisplayed = wait.until(ExpectedConditions.textToBePresentInElement(
////                    driver.findElement(By.xpath("//*[@id=\"account-forgotten\"]/div[1]")), expectedMessage));
////            assertTrue(isElementWithTextDisplayed, "Some message");
////        }
////    }