import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }

    @Test
    public void loginValidEmailPassword(){
        //Pr-Conditions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Steps
        String url = "https://qa.koel.app";
        driver.get(url);

        //Actions
        //Step 2
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("demo@class.com");

        //Step 3
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");

        //Step 4
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();

        WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));

        //Expected Result
        Assert.assertTrue(avatar.isDisplayed());
        //Quit Browser
        driver.quit();
    }

    @Test
    public void loginInvalidEmailValidPassword(){
        //Pr-Conditions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Steps
        String url = "https://qa.koel.app";
        driver.get(url);

        //Actions
        //Step 2
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("invalidemail@class.com");

        //Step 3
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");

        //Step 4
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();

        WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));

        //Expected Result
        Assert.assertTrue(avatar.isDisplayed());
    }

    @Test
    public void loginValidEmailNoPassword() throws InterruptedException{
        //Pr-Conditions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Steps
        String url = "https://qa.koel.app";
        driver.get(url);

        //Actions
        //Step 2
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("invalidemail@class.com");

        //Step 3
       /* WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        //passwordField.sendKeys("te$t$tudent");*/

        //Step 4
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();


        WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));

        //Expected Result
        Assert.assertTrue(avatar.isDisplayed());

        //Quit Browser
        driver.quit();
    }

}
