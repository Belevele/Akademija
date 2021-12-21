//package Asserts;
//
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//
//import static org.hamcrest.MatcherAssert.*;
//import static org.hamcrest.CoreMatchers.*;
//import static org.hamcrest.Matchers.hasSize;
//
//public class TestHamcrest {
//    private static WebDriver driver;
//    @BeforeAll
//    static void setUp() {
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://demo.opencart.com/index.php?route=account/forgotten");
//    }
//    @AfterAll
//    static void tearDown() {
//        driver.close();
//    }
//    @Test
//    public void test() {
//        driver.findElement(By.id("wishlist-total")).click();
//        //TODO: (1) Change it to compare size using hasSize() matcher
//        assertThat("Search Box/es number is incorrect: ", driver.findElements(By.id("search")),hasSize(1));
////        System.out.println("Number of Search Box/es:" + driver.findElements(By.id("search")).size());
//        String listElement =  driver.findElement(By.id("wishlist-total")).getText();
//        //TODO: (2) Change it to compare text using is(equalTo()) matcher and compare with expected "Wish List (0)" (Hamcrest)
//        assertThat("Wishlist text is displayed incorrectly ", listElement, is(equalTo("Wish List (0)")));
////        System.out.println("Element name is: " + listElement);
//        WebElement emailElement = driver.findElement(By.id("input-email"));
//        String email = "testing123";
//        emailElement.sendKeys(email);
//        driver.findElement(By.xpath("//input[@value='Login']")).click();
//        emailElement = driver.findElement(By.id("input-email"));
//        String emailElementValue = emailElement.getAttribute("value");
//        //TODO: (3) Change it to use allOf( is(equalTo()) and containsString()) matchers
//        assertThat("Password field text is: ", emailElementValue, allOf(is(equalTo(email)), containsString("test")));
////        System.out.println("Password field text is: " + emailElement);
//        boolean cartElement = driver.findElement(By.id("cart")).isDisplayed();
//        //TODO: (4) Change it to compare boolean value with is() matcher
//        assertThat("Is Cart button not displayed: ", cartElement, is(cartElement));
////        System.out.println("Is Cart button displayed: " + cartElement);
//        driver.findElement(By.linkText("Register")).click();
//        boolean agreeElement = driver.findElement(By.name("agree")).isSelected();
//        //TODO: (5) Change it to is(not()) matcher
//        assertThat("Agree checkbox is not selected",agreeElement, is(not(true)));
////        System.out.println("Is Agree checkbox selected: " + agreeElement);
//    }
//}
