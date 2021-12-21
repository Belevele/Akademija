package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AbstractObjectPage {

    protected WebDriver driver;

    public AbstractObjectPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}

//    public void clickAddToCart(String productName) {
//        driver.findElement(By.xpath("//div[contains(@class, 'product-layout') and .//a[text()='" +
//                productName + "']]//button[.//span[text()='Add To Cart']]")).click();
//        WaitUtils.waitForJS(driver);
//    }
//
//    public WebElement getItemHeader(String productName) {
//        return driver.findElement(By.xpath("//div[contains(@class, 'product-layout') and .//a[text()='" + productName + "']]//h4"));
//    }
//
//    public void openItem(String productName) {
//        driver.findElement(By.xpath("//div[contains(@class, 'product-layout') and .//a[text()='"+ productName +"']]a")).click();
//    }
//}
