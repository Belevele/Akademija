//package utils;
//
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//import java.util.function.Function;
//
//public class WaitUtils {
//
//    public static void waitForJS(WebDriver driver) {
//        new WebDriverWait(driver, Duration.ofSeconds(5)).until(new Function<>() {
//            public Boolean apply(WebDriver driver) {
//                return ((Long) ((JavascriptExecutor) driver).executeScript( "return JQuery.active") == 0);
//                }
//        });
//        }
//
////public static void waitForElement(WebDriver driver, WebElement element) {
////    WebDriverWait wait = new WebDriverWait(driver, 10);
////    wait.until(ExpectedConditions.visibilityOf(element));
////}
//}
