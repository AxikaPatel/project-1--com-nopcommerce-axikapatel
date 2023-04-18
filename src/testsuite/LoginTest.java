package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest
{
    String baseURL = "https://demo.nopcommerce.com/";

    @Before
    public void setUp()
    {
        openBrowser(baseURL);
    }



    @Test
    public void userShouldNavigateToLoginPageSuccessfully()
    {
         //click on the ‘Login’ link
         driver.findElement(By.xpath("//a[@href='/login?returnUrl=%2F']")).click();

        String expectedMessage = "Welcome, Please Sign In!";

         //Verify the text ‘Welcome, Please Sign In!’
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        String actualMessage = actualTextElement.getText();

        //checking actual and expected result
        Assert.assertEquals("Not redirected to login page",expectedMessage,actualMessage);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials()
    {
        //click on the ‘Login’ link
        this.userShouldNavigateToLoginPageSuccessfully();

        //Enter valid username
        WebElement emalIdField = driver.findElement(By.xpath("//input[@class='email']"));
        emalIdField.sendKeys("axika4387@yahoo.com");
        emalIdField.click();

        //Enter valid password
        WebElement passwordField = driver.findElement(By.xpath("//input[@id='Password']"));
        passwordField.sendKeys("axika4387");
        emalIdField.click();

        //Click on ‘LOGIN’ button
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='button-1 login-button']"));
        loginButton.click();

        //Verify the ‘Log out’ text is display
        String expectedMessage = "Log out";
        WebElement actualTextElement = driver.findElement(By.xpath("//a[@href='/logout']"));
        String actualMessage = actualTextElement.getText();

        //checking actual and expected result
        Assert.assertEquals("Login successful",expectedMessage,actualMessage);

    }

    @Test
    public void verifyTheErrorMessage()
    {
        //click on the ‘Login’ link
        userShouldNavigateToLoginPageSuccessfully();

        //Find login link and click on login link
        WebElement loginLink = driver.findElement(By.linkText("Log in"));
        loginLink.click();

        //Find the Email Field Element
        WebElement emailField = driver.findElement(By.id("Email"));
        // Type the Email address to email field element
        emailField.sendKeys("axika438.com");

        //Find the Password Field Element and send password on password field
        driver.findElement(By.name("Password")).sendKeys("Axika43");

        //Find the Login btn Element and click
        WebElement loginBtn = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        loginBtn.click();

        String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found1";

        //Verify the error message
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
        String actualMessage = actualTextElement.getText();

        //checking actual and expected result
        Assert.assertEquals("Error message not displayed", expectedMessage, actualMessage);

    }

    @After
    public void tearDown()
    {
        closeBrowser();
    }

}
