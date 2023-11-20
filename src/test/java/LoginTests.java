import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    //

    @Test
    public void loginSuccessTest() {

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("demo@class.com")
                .providePassword("te$t$tudent")
                .clickSubmitBtn();
//        WebElement avatar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
//        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
        Assert.assertTrue(homePage.getUserAvatar());
    }
    @Test
    public void loginInvalidCredentials(){
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.provideEmail("")
                .providePassword("te$t$tudent")
                .clickSubmitBtn();
        Assert.assertTrue(loginPage.getRegistrationLink().isDisplayed());
    }

    /*@Test(dataProvider = "LoginData")
    public void loginTests(String email, String password) throws InterruptedException {
        //navigateToLoginPage();
        provideEmail(email);
        providePassword(password);
        Thread.sleep(2000);
        clickSubmit();
        Thread.sleep(2000);
        //https://qa.koel.app/#!/home

        Assert.assertEquals(driver.getCurrentUrl(), url);
    }*/

    }


    /*@Test
    public void loginValidEmailPassword(){
        //Steps
        //navigateToLoginPage();
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        WebElement avatar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
        //WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));
        //Expected Result
        Assert.assertTrue(avatar.isDisplayed());
    }*/

  /*  @Test
    public void loginInvalidEmailValidPassword(){
//        navigateToLoginPage();
//        provideEmail("invalidemail@class.com");
//        providePassword("te$t$tudent");
//        clickSubmit();
//        WebElement avatar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class='avatar']")));
//        //Expected Result
//        Assert.assertTrue(avatar.isDisplayed());

        LoginPage loginPage = new LoginPage(getDriver());
    }*/

    //@Test
  /*  public void loginValidEmailNoPassword() throws InterruptedException{
    /*@Test
    public void loginInvalidEmailValidPassword(){
        //navigateToLoginPage();
        provideEmail("invalidemail@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));
        //Expected Result
        Assert.assertTrue(avatar.isDisplayed());
    }*/

 /*   @Test
    public void loginValidEmailNoPassword() throws InterruptedException{
        //Pr-Conditions

        //navigateToLoginPage();
        provideEmail("invalidemail@class.com");
        clickSubmit();

        WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));
        //Expected Result
        Assert.assertTrue(avatar.isDisplayed());
    }*/

    /*@Test(dataProvider = "excel-data")
    public void loginWithExcelData(String email, String password){
        try{
        //Step 1 Enter EMail
        Thread.sleep(2000);
        provideEmail(email);
        //Step 2: Enter Password
        providePassword(password);
        Thread.sleep(2000);
        //Step 3: Click on Submit.
        clickSubmit();
        Thread.sleep(2000);
        WebElement avatar = driver.findElement(By.cssSelector("img[class='avatar']"));
        //Expected Result
        Assert.assertTrue(avatar.isDisplayed());
        } catch(Exception e){
            Reporter.log("Unable to login with Excel Data for an unknown reason." +e);
        }
    }*/

    @Test
    public void LoginValidEmailPasswordTest(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmit();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    /**
     * With Fluent Interface and Selenium Page Factory
     * @throws InterruptedException
     */
    @Test
    public void LoginValidEmailPasswordTestByPageFactory() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        
        loginPage.provideEmailToLogin("demo@class.com")
                .providePasswordToLogin("te$t$tudent")
                .clickSubmitBtnToLogin();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }




}
