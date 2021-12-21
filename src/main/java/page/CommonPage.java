package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CommonPage extends AbstractObjectPage {

    //click Desktops
    @FindBy(linkText = "Desktops")
    private WebElement buttonDesktops;

    @FindBy(linkText = "Show All Desktops")
    private WebElement buttonShowAllDesktops;

    //search
    @FindBy(name = "search")
    private WebElement inputSearch;

    @FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
    private WebElement searchButton;


    public CommonPage(WebDriver driver) {
        super(driver);
    }

    public void clickDesktops() {
        buttonDesktops.click();
    }

    public void clickShowAllDesktops() {
        buttonShowAllDesktops.click();
    }

    public void clickButtonSearch() {
        searchButton.click();
    }

    public void enterInputSearch(String value) {
        inputSearch.sendKeys(value);
    }

}









