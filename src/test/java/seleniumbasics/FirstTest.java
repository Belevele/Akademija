package seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;
import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

public class FirstTest {

    protected static WebDriver driver;

    @BeforeSuite (groups = { "UI" })
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod (groups = { "UI" })
    public static void openHomePage() {
        driver.get("https://demo.opencart.com/");
    }

    @Test(groups = { "UI" })
    public static void testEverything() {
        driver.findElement(By.id("wishlist-total")).click();
        int actualSize = driver.findElements(By.name("search")).size();
        assertEquals(actualSize, 1, "Number of Search Boxes is not correct");
        //System.out.println("Number of Search Boxes:" + driver.findElements(By.name("search")).size());

        WebElement emailElement = driver.findElement(By.id("input-email"));
        String email = "email@email.com";
        emailElement.sendKeys(email);
        emailElement.clear();
        emailElement.submit();

        driver.findElement(By.linkText("Register")).click();

        boolean passwordElement = driver.findElement(By.id("input-password")).isEnabled();
        assertTrue(passwordElement, "Password is not enabled");
        // System.out.println("Is Password field enabled: " + passwordElement);

        boolean cartElement = driver.findElement(By.id("cart")).isDisplayed();
        assertTrue(cartElement, "Cart is not displayed");
        // System.out.println("Is Cart button displayed: " + cartElement);

        boolean agreeElement = driver.findElement(By.name("agree")).isSelected();
        assertFalse(agreeElement, "Agree checkbox is selected");
        // System.out.println("Is Agree checkbox selected: " + agreeElement);

        driver.findElement(By.linkText("Desktops")).click();
        driver.findElement(By.linkText("Show All Desktops")).click();

        Select dropDown = new Select(driver.findElement(By.id("input-limit")));
        dropDown.selectByVisibleText("25");

        dropDown = new Select(driver.findElement(By.id("input-limit")));
        String selectedValue = dropDown.getFirstSelectedOption().getText();
        //System.out.println("Number of items shown per page: " + selectedValue);

        dropDown.selectByIndex(4);
        dropDown = new Select(driver.findElement(By.id("input-limit")));
        selectedValue = dropDown.getFirstSelectedOption().getText();
        assertNotNull(selectedValue, "Selected option enabled.");
        //System.out.println("Number of items shown per page: " + selectedValue);
    }

    @AfterMethod (groups = { "UI" })
    public void goToHomePage() {
        driver.close();
    }

    @AfterSuite (groups = { "UI" })
    public static void quitDriver() {
        driver.quit();
    }
}

//    @AfterClass
//    public void closeBrowser() {
//        driver.manage().deleteAllCookies();
//        driver.close();
//    }

//    @Test
//    public void countSearchBoxes() {
//        driver.findElement(By.id("wishlist-total")).click();
//        int actualSize = driver.findElements(By.name("search")).size();
//        assertEquals(actualSize, 1, "Number of Search Boxes is not correct");
//        //System.out.println("Number of Search Boxes:" + driver.findElements(By.name("search")).size());
//    }
//
//    @Test
//    public void enterEmailAndSubmit() {
//        WebElement emailElement = driver.findElement(By.id("input-email"));
//        String email = "email@email.com";
//        emailElement.sendKeys(email);
//        emailElement.clear();
//        emailElement.submit();
//    }
//
//    @Test
//    public static void checkBooleans() {
//        driver.findElement(By.linkText("Register")).click();
//
//        boolean passwordElement = driver.findElement(By.id("input-password")).isEnabled();
//        assertTrue(passwordElement, "Password is not enabled");
//        //System.out.println("Is Password field enabled: " + passwordElement);
//
//        boolean cartElement = driver.findElement(By.id("cart")).isDisplayed();
//        assertTrue(cartElement, "Cart is not displayed");
//        //System.out.println("Is Cart button displayed: " + cartElement);
//
//        boolean agreeElement = driver.findElement(By.name("agree")).isSelected();
//        assertFalse(agreeElement, "Agree checkbox is selected");
//        //System.out.println("Is Agree checkbox selected: " + agreeElement);
//    }
//
//    @Test
//    public static void checkSelectedOptions() {
//
//        driver.findElement(By.linkText("Desktops")).click();
//        driver.findElement(By.linkText("Show All Desktops")).click();
//
//        Select dropDown = new Select(driver.findElement(By.id("input-limit")));
//        dropDown.selectByVisibleText("25");
//
//        dropDown = new Select(driver.findElement(By.id("input-limit")));
//        String selectedValue = dropDown.getFirstSelectedOption().getText();
//        //System.out.println("Number of items shown per page: " + selectedValue);
//
//        dropDown.selectByIndex(4);
//        dropDown = new Select(driver.findElement(By.id("input-limit")));
//        selectedValue = dropDown.getFirstSelectedOption().getText();
//        assertNotNull(selectedValue, "Selected option enabled.");
//        //System.out.println("Number of items shown per page: " + selectedValue);
//    }


