package testdatapreparation;

import basetest.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.CommonPage;
import page.SearchPage;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class TestParameterizeData extends BaseTest {

    private CommonPage commonPage;
    private SearchPage searchPage;

    @Test(dataProvider = "parameters")
    public void testData(String productName) {

        commonPage = new CommonPage(driver);
        searchPage = new SearchPage(driver);

        commonPage.enterInputSearch(productName);
        commonPage.clickButtonSearch();

        //assertEquals(driver.findElement(By.xpath("//div[@class='caption'][1]/h4/a")).getText(), productName, "The first item in search list is not Canon");
        System.out.println("Number of found items: " + searchPage.numberOfFoundItems());
        assertNotEquals(searchPage.numberOfFoundItems(), 0, "Did you find any items with name:" + productName);
        assertEquals(searchPage.getTextFromLinkFirstItem(), productName, "The first item in search list is not correct");

        //getTextFromLinkFirstItem - kodel butent toks xpath??
       }


    @DataProvider
    public Object[][] parameters() {
        return new Object[][]{
                {"iPod Nano"},
                {"MacBook"},
                {"Canon EOS 5D"},
                {"sm other item"},
        };
    }
}