package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final By bankManagerLoginBtn = By.cssSelector("[ng-click='manager()']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickBankManagerLoginBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bankManagerLoginBtn));
        driver.findElement(bankManagerLoginBtn).click();
    }

}


