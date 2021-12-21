package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends CommonPage {

    @FindBy(id = "cart")
    private WebElement buttonCart;

    @FindBy(id = "cart-total")
    private WebElement buttonCartText;

    @FindBy(xpath = "//div[@class='button-group']/button[1]")
    private List<WebElement> buttonsAddToCart;

    @FindBy(xpath = "//button[@title = 'Remove']")
    private WebElement removeFromCart;

    @FindBy(xpath = "//ul[@class='dropdown-menu pull-right']")
    public WebElement listItemsInCart;


    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickButtonCart() {
        buttonCart.click();
    }

    public String getTextFromButtonCart() {
        String text = buttonCartText.getText();
        return text;
    }

    public void clickRemoveFromCart() {
        removeFromCart.click();
    }

    public void clickButtonAddToCart (String productName) {
        driver.findElement(By.xpath("//div[@class = 'product-thumb' and .//a[text() = '" + productName + "']]//button[.//span[text()='Add to Cart']]")).click();
    }

    public void addProductsToCart(List<String> products) {
        for (String product : products) {
            clickButtonAddToCart(product);
        }
        }


    }







//        for (int i = 0; i < list.size(); i++) {
//            driver.findElement(By.xpath("//div[@class = 'product-thumb' and .//a[text() = '" + list.get(i) + "']]//button[.//span[text()='Add to Cart']]")).click();
//            WaitUtils.waitForJS(driver);
//    public void clickAddToWishList() {
//        buttonAddToWishList.click();
//        WaitUtils.waitForJS(driver);
//    }

//    @Override
//    public void clickAddToCart(String productName) {
//        buttonAddToCart.click();
//        WaitUtils.waitForJS(driver);
//    }
//
//    @FindBy(xpath = "//button[@data-original-title='Add to Wish List']")
//    private WebElement buttonAddToWishList;
//}
//
//    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
//    public WebElement infoMessage;

//    @FindBy(id = "button-cart")
//    private WebElement buttonAddToCart;