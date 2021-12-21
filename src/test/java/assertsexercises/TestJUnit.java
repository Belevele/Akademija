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
//import static org.junit.jupiter.api.Assertions.*;
//
//public class TestJUnit {
//
//    private static WebDriver driver;
//
//    @BeforeAll
//    static void setUp() {
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://demo.opencart.com/");
//    }
//
//    @AfterAll
//    static void tearDown() {
//        driver.close();
//    }
//
//    @Test
//    public void test() {
//        driver.findElement(By.id("wishlist-total")).click();
//        //TODO: (1) Change it to AssertSame
//        assertSame(1, driver.findElements(By.id("search")).size(), "Number of Search Box/es");
//        // System.out.println("Number of Search Box/es:" + driver.findElements(By.id("search")).size());
//
//        String listElement = driver.findElement(By.id("wishlist-total")).getText();
//        //TODO: (2) Change it to AssertEquals and compare with expected "Wish List (0)"
//        assertEquals("Wish List (0)", listElement, "Element name is");
//        //System.out.println("Element name is: " + listElement);
//
//        driver.findElement(By.linkText("Register")).click();
//
//        WebElement passwordElement = driver.findElement(By.id("input-password"));
//        String password = "testing123";
//        passwordElement.sendKeys(password);
//        //TODO: (3) Change it to AssertNotNull
//        assertNotNull(passwordElement, "Password field text is");
//        // System.out.println("Password field text is: " + passwordElement.getText());
//
//        boolean cartElement = driver.findElement(By.id("cart")).isDisplayed();
//        //TODO: (4) Change it to AssertTrue
//        assertTrue(cartElement, "Is Cart button displayed: ");
//        //System.out.println("Is Cart button displayed: " + cartElement);
//
//        boolean agreeElement = driver.findElement(By.name("agree")).isSelected();
//        //TODO: (5) Change it to AssertFalse
//        assertFalse(agreeElement, "Is Agree checkbox selected: ");
//        //System.out.println("Is Agree checkbox selected: " + agreeElement);
//    }
//}
