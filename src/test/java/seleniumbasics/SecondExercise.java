package seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class SecondExercise {

    protected static WebDriver driver;

    @BeforeSuite (groups = { "UI2" })
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @BeforeMethod (groups = { "UI2" })
    public static void openHomePage() {
        driver.get("https://demo.opencart.com/");
    }

    @Test(groups = { "UI2" })
    public static void testEverything() {
        // Enter a wrong product name in Search field (F.e: MaxBook)
        WebElement searchElement = driver.findElement(By.name("search"));
        searchElement.click();
        searchElement.sendKeys("MaxBook");

        // Click [search icon] button
        // driver.findElement(By.cssSelector("#search > span > button")).click();
        driver.findElement(By.xpath("//*[@id='search']/span/button")).click();

        // Check if [search] button is displayed
        boolean btnSearchElement = driver.findElement(By.id("button-search")).isDisplayed();
        System.out.println("Is Search button displayed: " + btnSearchElement);

        // Clear first Search field and enter the correct product name (F.e.: Macbook).
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys("Macbook");

        // Click [search icon] button
        driver.findElement(By.cssSelector("#search > span > button")).click();

        // Count the number of searched items (parasiau dviem budais)
        int listOfItems = driver.findElements(By.className("product-thumb")).size();
        System.out.println("The number of searched items: " + listOfItems);
        int secondListOfItems = driver.findElements(By.tagName("h4")).size();
        System.out.println("The number of searched items in the second list: " + listOfItems);

        // Select SortBy/Price low to high, retrieve selected option text and print it
        String sortByLowToHigh = driver.findElement(By.xpath("//*[@id='input-sort']/option[4]")).getText();
        System.out.println("Selected option text: " + sortByLowToHigh);
    }

    @AfterMethod
    public static void closeBrowser() {
        driver.manage().deleteAllCookies();
        driver.close();
    }

    @AfterSuite
    public static void quitDriver() {
        driver.quit();
    }
    }


