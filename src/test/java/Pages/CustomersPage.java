package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

public class CustomersPage {
    private final WebDriver driver;
    private final By customersBtn = By.cssSelector("[ng-click='showCust()']");
    private final By searchCustomerBar = By.cssSelector("[ng-model='searchCustomer']");
    private final By tableRows = By.cssSelector("div .table tbody tr");
    private final By deleteBtn = By.cssSelector("[ng-click='deleteCust(cust)']");


    public CustomersPage(WebDriver driver){this.driver = driver;};


    public void clickCustomerBtn(){
        driver.findElement(customersBtn).click();
    }

    public void searchCustomer(String firstName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchCustomerBar));
        WebElement searchBar = driver.findElement(searchCustomerBar);
        searchBar.sendKeys(firstName);
        searchBar.sendKeys(Keys.RETURN);
    }

    public List<WebElement> getRowsOfTable(){
        return driver.findElements(tableRows);
    }

    public void deleteCustomer(){
       driver.findElement(deleteBtn).click();

    }

    public void clearSearchValue(){
        driver.findElement(searchCustomerBar).clear();
    }

}


