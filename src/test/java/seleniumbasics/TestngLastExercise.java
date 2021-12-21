package seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import static org.testng.Assert.*;
import static org.testng.Assert.assertNotNull;

public class TestngLastExercise {

    protected static WebDriver driver;

    @BeforeSuite
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeClass
    public static void openHomePage() {
        driver.get("https://demo.opencart.com/");
    }

    @Test (priority = 1)
    public static void testEverything() {
        driver.findElement(By.id("wishlist-total")).click();
        int actualSize = driver.findElements(By.name("search")).size();
        assertEquals(actualSize, 1, "Number of Search Boxes is not correct");

        WebElement emailElement = driver.findElement(By.id("input-email"));
        String email = "email@email.com";
        emailElement.sendKeys(email);
        emailElement.clear();
        emailElement.submit();

        driver.findElement(By.linkText("Register")).click();

        boolean passwordElement = driver.findElement(By.id("input-password")).isEnabled();
        assertTrue(passwordElement, "Password is not enabled");

        boolean cartElement = driver.findElement(By.id("cart")).isDisplayed();
        assertTrue(cartElement, "Cart is not displayed");

        boolean agreeElement = driver.findElement(By.name("agree")).isSelected();
        assertFalse(agreeElement, "Agree checkbox is selected");

        driver.findElement(By.linkText("Desktops")).click();
        driver.findElement(By.linkText("Show All Desktops")).click();

        Select dropDown = new Select(driver.findElement(By.id("input-limit")));
        dropDown.selectByVisibleText("25");

        dropDown = new Select(driver.findElement(By.id("input-limit")));
        String selectedValue = dropDown.getFirstSelectedOption().getText();

        dropDown.selectByIndex(4);
        dropDown = new Select(driver.findElement(By.id("input-limit")));
        selectedValue = dropDown.getFirstSelectedOption().getText();
        assertNotNull(selectedValue, "Selected option enabled.");
    }

    @Test (priority = 2)
    public static void testEverythingSecondEx() {
        WebElement searchElement = driver.findElement(By.name("search"));
        searchElement.click();
        searchElement.sendKeys("MaxBook");

        driver.findElement(By.xpath("//*[@id='search']/span/button")).click();

        boolean btnSearchElement = driver.findElement(By.id("button-search")).isDisplayed();
        System.out.println("Is Search button displayed: " + btnSearchElement);

        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("Macbook");

        driver.findElement(By.cssSelector("#search > span > button")).click();

        int listOfItems = driver.findElements(By.className("product-thumb")).size();
        System.out.println("The number of searched items: " + listOfItems);

        String sortByLowToHigh = driver.findElement(By.xpath("//*[@id='input-sort']/option[4]")).getText();
        System.out.println("Selected option text: " + sortByLowToHigh);
    }

    @AfterClass
    public static void closeBrowser() {
        driver.manage().deleteAllCookies();
        driver.close();
    }

    @AfterSuite
    public static void quitDriver() {
        driver.quit();
    }
}
