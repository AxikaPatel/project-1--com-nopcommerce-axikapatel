package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest
{
    String baseURL = "https://demo.nopcommerce.com/";

    @Before
    public void setUp()
    {
        openBrowser(baseURL);
    }

    @Test
    public void userShouldNavigateToComputerPageSuccessfully()
    {
        //click on the ‘Computers’ Tab
        driver.findElement(By.xpath("//a[@href='/computers']")).click();


        String expectedMessage = "Computers";

        //Verify the text ‘Computers’
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[contains(text(),'Computers')]"));
        String actualMessage = actualTextElement.getText();

        //checking actual and expected result
        Assert.assertEquals("Not Match with Computers",expectedMessage,actualMessage);

    }

    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully()
    {
        //click on the ‘Electronics’ Tab
        driver.findElement(By.xpath("//a[@href='/electronics']")).click();

        String expectedMessage = "Electronics" ;

        //Verify the text ‘Electronics’
        WebElement actualTextElement =  driver.findElement(By.xpath("//h1[text()='Electronics']"));
        String actualMessage = actualTextElement.getText();

        //checking actual and expected result
        Assert.assertEquals("Not Match with Electronics",expectedMessage,actualMessage);

    }

    @Test
    public void  userShouldNavigateToApparelPageSuccessfully()
    {
        // click on the ‘Apparel’ Tab
        driver.findElement(By.xpath("//a[contains(@href,'/apparel')]")).click();

        String expectedMessage = "Apparel";

        //Verify the text ‘Apparel’
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[text()='Apparel']"));
        String actualMessage = actualTextElement.getText();

        //checking actual and expected result
        Assert.assertEquals("Not Match with Apparel",expectedMessage,actualMessage);

    }

    @Test
    public void userShouldNavigateToDigitalDownloadsPageSuccessfully()
    {
        // click on the ‘Apparel’ Tab
        driver.findElement(By.xpath("//a[contains(@href,'/digital-downloads')]")).click();

        String expectedMessage = "Digital downloads";

        //Verify the text ‘Apparel’
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[contains(text(),'Digital downloads')]"));
        String actualMessage = actualTextElement.getText();

        //checking actual and expected result
        Assert.assertEquals("Not Match with Digital downloads ",expectedMessage,actualMessage);



    }

    @Test
    public void userShouldNavigateToBooksPageSuccessfully()
    {
        // click on the ‘Books’ Tab
        driver.findElement(By.xpath("//a[@href='/books']/..")).click();

        String expectedMesssage = "Books";

        //Verify the text ‘Books’
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[text()='Books']"));
        String actualMessage = actualTextElement.getText();

        //checking actual and expected result
        Assert.assertEquals("Not Match with Books ",expectedMesssage,actualMessage);

    }

    @Test
    public void userShouldNavigateToJewelryPageSuccessfully()
    {
        //click on the ‘Jewelry’ Tab
        driver.findElement(By.xpath("//a[@href = '/jewelry']")).click();

        String expectedMessage = "Jewelry";

        //Verify the text ‘Jewelry’
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[contains(text(),'Jewelry')]"));
        String actualMessage = actualTextElement.getText();

        //checking actual and expected result
        Assert.assertEquals("Not Match with Jewelry",expectedMessage,actualMessage);

    }

    @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully()
    {
        //click on the ‘Gift Cards’ Tab
        driver.findElement(By.xpath("//a[@href = '/gift-cards']")).click();

        String expectedMessage = "Gift Cards";

        //Verify the text ‘Gift Cards’
        WebElement actualTextElement = driver.findElement(By.xpath("//h1[text()='Gift Cards']"));
        String actualMessage = actualTextElement.getText();

        //checking actual and expected result
        Assert.assertEquals("Not Match with Gift Cards ",expectedMessage,actualMessage);
    }


    @After
    public void tearDown()
    {
        closeBrowser();
    }



}
