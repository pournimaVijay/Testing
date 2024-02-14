package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Contact_Us_Steps {
    private WebDriver driver;
    @Before("@contact_us")
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/java/drivers/chromedriver.exe");
        ChromeOptions chromeoptions=new ChromeOptions();
        chromeoptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver=new ChromeDriver(chromeoptions);
        driver.manage().window().maximize();
    }

    @After("@contact_us")
    public void teardown()
    {
        driver.quit();
    }

    public String generateRandomNumber(int length)
    {
        return RandomStringUtils.randomNumeric(length);
    }
    @Given("I access the webdriver university contact us page")
    public void accessContactUsPage() {
        driver.get("https://www.webdriveruniversity.com/Contact-Us/contactus.html");
    }
    public String generateRandomString(int length)
    {
        return RandomStringUtils.randomAlphabetic( length);
    }

    @When("I enter a unique first name")
    public void enterUniqueFirstName() {

        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("autoFn"+generateRandomNumber(5));
    }

    @And("I enter a unique last name")
    public void enterUniqueLastName() {

        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("autoLn"+generateRandomNumber(5));
    }

    @And("I enter a unique email address")
    public void enterUniqueEmailAddress() {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("autoMail"+generateRandomNumber(10)+"@gmail.com");

    }

    @And("I enter a unique comment")
    public void enterUniqueComment() {

        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("autoCmt"+generateRandomString(20));
    }

    @When("I enter a Specific first name {word}")
    public void i_enter_a_specific_first_name_pournima(String firstName) {
        System.out.println(firstName);
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(firstName);
    }
    @When("I enter a Specific last name {word}")
    public void i_enter_a_specific_last_name_c(String lastName) {
        System.out.println(lastName);
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(lastName);
    }
    @When("I enter a Specific email address {word}")
    public void i_enter_a_specific_email_address_pc_gmail_com(String email) {
        System.out.println(email);
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
    }
    @When("I enter a Specific comment {string}")
    public void i_enter_a_specific_comment(String string) {
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys(string);
    }

    @And("I click on the submit button")
    public void clickSubmitButton() {
       driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
    }

    @Then("I should be presented with a successful contact us submission message")
    public void validateSuccessfulSubmissionMessage() {
        WebElement contactUs_Submission_Message=driver.findElement(By.xpath("//div[@id='contact_reply']/h1"));
        Assert.assertEquals(contactUs_Submission_Message.getText(),"Thank You for your Message!");
    }
}
