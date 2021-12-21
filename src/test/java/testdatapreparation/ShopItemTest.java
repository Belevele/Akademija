package testdatapreparation;

import basetest.BaseTest;
import com.thoughtworks.xstream.XStream;
import models.ShopItem;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import page.CommonPage;
import page.SearchPage;

import java.io.File;
import java.io.IOException;
import static org.testng.Assert.assertEquals;

public class ShopItemTest extends BaseTest {

    private ShopItem item;
    private CommonPage commonPage;
    private SearchPage searchPage;

    @Test
    public void test() throws IOException {
        commonPage = new CommonPage(driver);
        searchPage = new SearchPage(driver);

        XStream xstream = new XStream();

        item = new ShopItem();
        item.setName("MacBook");
        item.setBrand("Apple");
        item.setPrice("$602");
        item.setProductCode("product 16");

        FileUtils.writeStringToFile(new File("src/test/resources/MacBook.xml"), xstream.toXML(item));

        ShopItem MacBook = (ShopItem) xstream.fromXML(FileUtils.readFileToString(new File("src/test/resources/MacBook.xml")));

        commonPage.enterInputSearch(MacBook.getName());
        commonPage.clickButtonSearch();

        //assertEquals(searchPage.getTextFromLinkFirstItem(), MacBook.getName(), "The name is not correct");
        assertEquals(driver.findElement(By.id("content")).getText(), MacBook.getPrice(), "The name is not correct");
    }


}
