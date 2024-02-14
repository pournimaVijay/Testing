package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class Login_Steps {

    private WebDriver driver;
    @Before("@Login")
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/java/drivers/chromedriver.exe");
        ChromeOptions chromeoptions=new ChromeOptions();
        chromeoptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver=new ChromeDriver(chromeoptions);
        driver.manage().window().maximize();
    }
    @After("@Login")
    public void teardown()
    {
        driver.quit();
    }

    @Given("I access the webdriver university Login Page")
    public void i_access_the_webdriver_university_url() {
       driver.get("https://www.webdriveruniversity.com/");
    }
    @When("I navigate to Login Portal")
    public void i_navigate_to_login_portal() {
        driver.findElement(By.xpath("//h1[contains(text(),'LOGIN PORTAL')]")).click();
        String parent=driver.getWindowHandle();
        Set<String> s = driver.getWindowHandles();
        Iterator<String> I1=s.iterator();
        while (I1.hasNext())
        {
            String childWindow=I1.next();
            if(!parent.equals(childWindow))
            {
                driver.switchTo().window(childWindow);
            }
        }
    }
    @And("I enter username {word}")
    public void i_enter_username(String username) {
        driver.findElement(By.xpath("//input[@id='text']")).sendKeys(username);

    }

    @When("I enter a username {word}")
    public void i_enter_a_username_webdriver(String username) {
        driver.findElement(By.xpath("//input[@id='text']")).sendKeys(username);
    }
    @And("I enter password {}")
    public void i_enter_password(String password) {
      driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
    }

    @And("I click on Login button")
    public void I_click_on_Login_button(){
        driver.findElement(By.xpath("//button[@id='login-button']")).click();
    }
    @Then("I should get successful Login message")
    public void i_should_get_successful_login_message() {
        Alert al=driver.switchTo().alert();
        Assert.assertEquals(al.getText(),"validation succeeded");
    }
    @Then("I should get unsuccessful Login message")
    public void i_should_get_unsuccessful_login_message() {
        Alert al=driver.switchTo().alert();
        Assert.assertEquals(al.getText(),"validation failed");
    }


    @Then("I should be presented with following login validation message {}")
    public void i_should_be_presented_with_following_login_validation_message(String expected_message) {
        Alert al=driver.switchTo().alert();
        Assert.assertEquals(al.getText(),expected_message);
    }


}
