import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {


    @Test(dataProvider = "LoginData")
    public void loginTests(String email, String password) throws InterruptedException {
        navigateToLoginPage();
        provideEmail(email);
        providePassword(password);
        clickSubmit();
        Thread.sleep(2000);
        //https://qa.koel.app/#!/home
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void loginValidEmailPassword(){
        //Steps
        navigateToLoginPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));
        //Expected Result
        Assert.assertTrue(avatar.isDisplayed());
    }

    @Test
    public void loginInvalidEmailValidPassword(){
        navigateToLoginPage();
        provideEmail("invalidemail@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));
        //Expected Result
        Assert.assertTrue(avatar.isDisplayed());
    }

    @Test
    public void loginValidEmailNoPassword() throws InterruptedException{
        //Pr-Conditions

        navigateToLoginPage();
        provideEmail("invalidemail@class.com");
        clickSubmit();

        WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));
        //Expected Result
        Assert.assertTrue(avatar.isDisplayed());
    }

    @Test(dataProvider = "excel-data")
    public void search(String keyword1, String keyword2){
        WebElement txtBox = driver.findElement(By.tagName("//input[@class='gLFYf gsfi']"));
        txtBox.sendKeys(keyword1,keyword2);
        Reporter.log("KeyWord Entered is: "+keyword1+ " " +keyword2);
        txtBox.sendKeys(Keys.ENTER);
        Reporter.log("Search results are displayed.");
    }


}
