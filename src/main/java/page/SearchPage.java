package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends AbstractObjectPage {

    @FindBy(xpath = "//div[@class='caption'][1]/h4/a")
    private WebElement linkFirstItem;

    @FindBy(className = "product-thumb")
    List<WebElement> itemsFound;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public String getTextFromLinkFirstItem() {
        return linkFirstItem.getText();
    }

    public int numberOfFoundItems() {
        return itemsFound.size();
    }

}
