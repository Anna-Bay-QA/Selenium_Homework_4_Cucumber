package Pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class AddCustomerPage {
    private final WebDriver driver;
    Faker faker = new Faker();
    public String firstNameValue = faker.name().firstName();
    public String lastNameValue = faker.name().lastName();
    public String postCodeValue = faker.address().zipCode();

    private final By addCustomerBtn = By.cssSelector("[ng-click='addCust()']");
    private final By firstName = By.cssSelector("[ng-model='fName']");
    private final By lastName = By.cssSelector("[ng-model='lName']");
    private final By postCode = By.cssSelector("[ng-model='postCd']");
    private final By addCustomerBtnForm = By.cssSelector("form[ng-submit='addCustomer()'] button");


    public AddCustomerPage(WebDriver driver){this.driver = driver;};


    public void clickAddCustomerButton(){
        driver.findElement(addCustomerBtn).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
        wait.until(ExpectedConditions.urlContains("addCust"));
    }


    public void addCustomer() {
        driver.findElement(firstName).sendKeys(firstNameValue);
        driver.findElement(lastName).sendKeys(lastNameValue);
        driver.findElement(postCode).sendKeys(postCodeValue);
        driver.findElement(addCustomerBtnForm).click();
        driver.switchTo().alert().accept();

    }

}



