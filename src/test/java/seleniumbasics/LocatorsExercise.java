package seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsExercise {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/");

        // Start registration
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.partialLinkText("Regist")).click();

        // Print count of input fields
        int numOfInputFields = driver.findElements(By.tagName("input")).size();
        System.out.println("The number of input fields is: " + numOfInputFields);

        // Print count of elements with class attribute = "form-control"
        int numberOfElementsFormControl = driver.findElements(By.className("form-control")).size();
        System.out.println("Count of elements with specified class attribute: " + numberOfElementsFormControl);

        int numOfInputPersonalDetails = driver.findElement(By.id("account")).findElements(By.className("form-control")).size();
        System.out.println("The number of input fields in Your Personal Details is: " + numOfInputPersonalDetails);

        // Fill in your personal details
        WebElement firstNameElement = driver.findElement(By.cssSelector("#input-firstname"));
        firstNameElement.sendKeys("Vardenis");

        WebElement lastNameElement = driver.findElement(By.name("lastname"));
        lastNameElement.sendKeys("Pavardenis");

        WebElement emailElement = driver.findElement(By.id("input-email"));
        String userName = ""+(int)(Math.random()*Integer.MAX_VALUE);
        String emailID = "User"+userName+"@example.com";
        emailElement.sendKeys(emailID);

        WebElement phoneElement = driver.findElement(By.id("input-telephone"));
        phoneElement.sendKeys("+37061111111");

        // Fill in personal details (trumpiau; destytojo variantas)
        //        driver.findElement(By.id("input-firstname")).sendKeys("First Name");
        //        driver.findElement(By.name("lastname")).sendKeys("Last Name");
        //        driver.findElement(By.id("input-email")).sendKeys(randomAlphabetic(10) + "@email.email");
        //        driver.findElement(By.name("telephone")).sendKeys("123456789");

        // Fill in Your Password (trumpiau, destytojo variantas)
        WebElement passwordElement = driver.findElement(By.name("password"));
        passwordElement.sendKeys("a1+A");

        WebElement confirmPasswordElement = driver.findElement(By.name("confirm"));
        confirmPasswordElement.sendKeys("a1+A");

        // Fill in Your Password (trumpiau, destytojo variantas)
        driver.findElement(By.id("input-password")).sendKeys("password123");
        driver.findElement(By.name("confirm")).sendKeys("password123");

        // Check "I have read and agree to the Privacy Policy" and Click continue
        driver.findElement(By.xpath("//input[@type='checkbox' and @name='agree']")).click();
        driver.findElement(By.cssSelector("input[value='Continue']")).click();
        driver.findElement(By.xpath("//a[text()='Continue']")).click();

        driver.close();
    }
}
