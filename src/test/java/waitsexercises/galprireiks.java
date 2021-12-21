//getTestData("src/test/resources/text.txt");

//String actualCartText = driver.findElement(By.id("cart-total")).getText();
//        String expectedCartText = String.format(cartTextFormat, 3);
//        assertTrue(actualCartText.contains(expectedCartText), "Cart text does not contain expected text: " + expectedCartText);

//        productsPage.clickButtonCart();
//        productsPage.clickRemoveFromCart();
//
////        actualCartText = driver.findElement(By.id("cart-total")).getText();
////        expectedCartText = String.format(cartTextFormat, 0);
////        assertTrue(actualCartText.contains("expectedCartText"), "Cart text does not contains expected text: " + expectedCartText);
//
//    }
//
//
//
//        private void addProductsToCart () {
//            for (String product : products) {
//                productsPage.clickAddProductToCart();
//            }
//        }

//    private void removeProductsFromCart(List<WebElement> list) {
//        for (WebElement button : list) {
//            driver.findElement(By.id("cart-total")).click();
//            driver.findElements(By.xpath("//button[@title = 'Remove']")).get(0).click();
//            WaitUtils.waitForJS(driver);
//    }
//


//
////        productPage.getCartText();
////
//
////
////        productPage.clickCartText();
////        productPage.clickRemoveFromCart();
////
////
////
////        //driver.findElement(By.id("cart-total")).click();
////       // driver.findElement(By.xpath("//button[@title = 'Remove']")).click();
////        //driver.findElement(By.xpath("//div[@class = 'product-thumb'] and .//a[text()='iPhone']]//button[.//span[text()='Add to Cart']]")).click();
////        waitForJS();
////
////
////
//
////
////    }
////
////
//
////}
////
//
////
//
////    }
////
////
//////        driver.findElement(By.linkText("Desktops")).click();
//////        driver.findElement(By.linkText("Show All Desktops")).click();
////
////  //  List<String> list = List.of("iPhone", "MacBook", "Sony VAIO");
////
////    // for (String productName: list) {
////    //   driver.findElement(By.xpath("//div[@class = 'product-thumb'] and .//a[text()='" + productName + "']]//button[.//span[text()='Add to Cart']]")).click();
////
//////        WebElement searchElement = driver.findElement(By.name("search"));
//////        searchElement.click();
//////        searchElement.sendKeys("MacBook");
//////        driver.findElement(By.xpath("//*[@id='search']/span/button")).click();
////
//////        WebElement macBookToCart = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/div[1]/div/div[2]/div[2]/button[1]"));
//////        macBookToCart.click();
////
////       // assertEquals(driver.findElement(By.xpath("//*[@id=\"cart-total\"]/text()")), "1 item(s) - $602.00", "Number of the items in the cart is not correct");
////
////      //  driver.findElement(By.xpath("//*[@id=\"cart\"]/button")).click();
////
////     //.Aa   driver.findElement(By.cssSelector("#cart > ul > li:nth-child(1) > table > tbody > tr > td:nth-child(5) > button > i")).click();
////
////
////
////    }
////
//////    @AfterTest
//////    public void tearDown() {
//////        driver.close();
//////    }
//////}
////
////
////// galim naudoti startswith vietoje contains
////
////// driver.findElement(By.id("cart-total")).click();
////// List<WebElement> xButtons = driver.findElements(By.xpath("//button[@title= 'Remove']"));
//////removeProductsFromC
//
////driver.findElement(By.xpath("//div[@class = 'product-thumb' and .//a[text() = '" + list.get(i) + "']]//button[.//span[text()='Add to Cart']]")).click();
//
////    private void waitForJS() {
////        new WebDriverWait(driver, Duration.ofSeconds(5)).until(new Function<>() {
////            public Boolean apply(WebDriver driver) {
////                return ((Long) ((JavascriptExecutor) driver).executeScript("return JQuery.active") == 0);
////            }
////        });

//    @FindBy(xpath = "//ul[@class='list-inline']/li/span")
//    private List<WebElement> labelPhone;

//    @FindBy(linkText = "MP3 Players")
//    private WebElement buttonMp3Players;
//
//    @FindBy(linkText = "Show All MP3 Players")
//    private WebElement buttonShowAllMp3Players;
//    public void openCart() {
//        if (! listItemsInCart.isDisplayed()) {
//            buttonCart.click();
//            WaitUtils.waitForJS(driver);
//        }
//    }
//    public void clickButtonMp3Players() {
//        buttonMp3Players.click();
//    }
//
//    public void clickButtonShowAllMp3Players() {
//        buttonShowAllMp3Players.click();
//    }

//
//@FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[2]/div/div[3]/button[1]/span")
//private WebElement buttonAddToCart;


//@FindBy(xpath = "//table[@class='table table-striped']//button[@class='btn btn-danger btn-xs']")
//public List<WebElement> buttonRemoveItems;
//
//public void getTextFromCart() {
//        buttonCart.getText();
//        }