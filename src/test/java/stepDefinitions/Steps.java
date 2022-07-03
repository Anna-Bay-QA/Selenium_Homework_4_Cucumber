package stepDefinitions;

import Pages.AddCustomerPage;
import Pages.CustomersPage;
import Pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;


public class Steps {
    WebDriver driver;
    LoginPage loginPage;
    AddCustomerPage addCustomerPage;
    CustomersPage customerPage;

    @Before
    public void browser_setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        driver.quit();
    }


    @Given("I open login page")
    public void i_open_login_page() {
        driver.get(utils.Constants.HOME_PAGE_URL);
        driver.manage().window().maximize();
    }

    @When("I click Bank Manager Login button")
    public void i_click_bank_manager_login_button() {
        loginPage = new LoginPage(driver);
        loginPage.clickBankManagerLoginBtn();

    }

    @When("I click Add Customer button")
    public void i_click_add_customer_button() {
        addCustomerPage = new AddCustomerPage(driver);
        addCustomerPage.clickAddCustomerButton();

    }

    @When("I fill the FirstName LastName PostCode inputs and click Add Customer button")
    public void i_fill_the_first_name_last_name_post_code_inputs_and_click_add_customer_button() {
       addCustomerPage.addCustomer();
    }

    @When("I search new customer on customers list")
    public void i_search_new_customer_on_customers_list()  {
        customerPage = new CustomersPage(driver);
        customerPage.clickCustomerBtn();
        customerPage.searchCustomer(addCustomerPage.firstNameValue);
        //System.out.println(addCustomerPage.firstNameValue);

    }

    @When("I check that new customer is added with correct info")
    public void i_check_that_new_customer_is_added_with_correct_info() {
        List<WebElement> tr = customerPage.getRowsOfTable();
        boolean countTR = tr.size()!=0;
        Assert.assertTrue(countTR);
    }

    @When("I delete the newly created customer")
    public void i_delete_the_newly_created_customer() {
        customerPage.deleteCustomer();

    }

    @Then("I check that newly created customer is deleted")
    public void i_check_that_newly_created_customer_is_deleted() {
        customerPage.clearSearchValue();
        customerPage.searchCustomer(addCustomerPage.firstNameValue);
        List<WebElement> tr = customerPage.getRowsOfTable();
        boolean countTR = tr.size() == 0;
        Assert.assertTrue(countTR);

    }

}



