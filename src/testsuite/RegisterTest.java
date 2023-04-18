package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class RegisterTest extends BaseTest
{
    String baseURL = "https://demo.nopcommerce.com/register";

    @Before
    public void setup()
    {
        openBrowser(baseURL);
    }

    @Test
    public void  userShouldNavigateToRegisterPageSuccessfully()
    {
        //click on the ‘Register’ link
        driver.findElement(By.xpath("//a[@class='ico-register']")).click();

        String exepctedMessage = "Register";

        //Verify the text ‘Register’
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[contains(text(),'Register')]"));
        String actualMessage = actualTextElement.getText();

        Assert.assertEquals("Not match with Register",exepctedMessage,actualMessage);

    }

    @Test
    public void userSholdRegisterAccountSuccessfully()
    {
        // click on the ‘Register’ link
        userShouldNavigateToRegisterPageSuccessfully();

        // Select gender radio button
        driver.findElement(By.xpath("//input[@id='gender-female']")).click();

        //Enter First name
        WebElement firstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstName.sendKeys("Axika");

        //
        WebElement lastName = driver.findElement(By.xpath("//input[@id='LastName']"));
        lastName.sendKeys("Patel");

        //
        driver.findElement(By.xpath("//div[@class='date-picker-wrapper']/select/option[text()='6']")).click();

        // Select Month from dropdown
         driver.findElement(By.xpath("//div[@class='date-picker-wrapper']/select/option[text()='January']")).click();

        // select year from dropdown
        WebElement year = driver.findElement(By.xpath("//div[@class='date-picker-wrapper']/select/option[text()='1991']"));
        year.click();

        //Enter email address
        WebElement emailField = driver.findElement(By.id("Email"));
        emailField.click();

        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        emailField.sendKeys("Ram" + randomInt + "Axika12@gmail.com");// creating random email generator

        // Enter password
        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        password.sendKeys("Axika123");

        // Enter confirm Password
        WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        confirmPassword.sendKeys("Axika123");

        //  Click on REGISTER button
        WebElement registerButton = driver.findElement(By.id("register-button"));
        registerButton.click();

        String expectedMessage = "Your registration completed";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@class='result']"));
        String actualMessage = actualTextElement.getText();

        //checking actual and expected result
        Assert.assertEquals(expectedMessage, actualMessage);
    }



    @After
    public void tearDown()
    {
       closeBrowser();
    }




}
