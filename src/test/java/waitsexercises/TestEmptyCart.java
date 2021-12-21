package waitsexercises;

import basetest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import page.CommonPage;
import page.ProductPage;

public class TestEmptyCart extends BaseTest {

    List<String> products = List.of("iPhone", "MacBook", "Sony VAIO");

    private CommonPage commonPage;
    private ProductPage productsPage;

    @Test
    public void testCart() throws IOException {
        String cartTextFormat = "%s item(s)";

        commonPage = new CommonPage(driver);
        productsPage = new ProductPage(driver);

        commonPage.clickDesktops();
        commonPage.clickShowAllDesktops();

        getTestData("src/test/resources/ThreeItems.txt");
        productsPage.addProductsToCart(products);

        assertTrue(productsPage.getTextFromButtonCart().contains("3 item"), "Cart contains 0 items");

        String actualCartText = productsPage.getTextFromButtonCart();
        String expectedCartText = String.format(cartTextFormat, products.size());
        assertTrue(actualCartText.contains(expectedCartText), "Cart text does not contain expected text" + expectedCartText);

        List<WebElement> xButtons = driver.findElements(By.xpath("//button[@title='Remove']"));
        removeProductsFromCart(xButtons);
        assertTrue(productsPage.getTextFromButtonCart().contains("0 item"), "Cart contains 0 items");
    }

//    public void addProductsToCart(List<String> list) {
//        for (int i = 0; i < list.size(); i++) {
//            driver.findElement(By.xpath("//div[@class = 'product-thumb' and .//a[text()='" + list.get(i) + "']]/button[.//span[text()='Add to Cart']]"));
//            waitForJS(driver);
//        }
//    }

    public void removeProductsFromCart(List<WebElement> list) {
        for (WebElement button : list) {
            productsPage.clickButtonCart();
            driver.findElements(By.xpath("//button[@title='Remove']")).get(0).click();
            waitForJS(driver);
        }
    }


    public static void waitForJS(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(new Function<>() {
            public Boolean apply(WebDriver driver) {
                return ((Long) ((JavascriptExecutor) driver).executeScript("return JQuery.active") == 0);
            }
        });
    }

        private List<String> getTestData (String fileName) throws IOException {
            List<String> records = new ArrayList<String>();
            String record;

            try (BufferedReader file = new BufferedReader(new FileReader(fileName))) {
                while ((record = file.readLine()) != null) {
                    records.add(record);
                }
            }
            return records;
        }
    }

