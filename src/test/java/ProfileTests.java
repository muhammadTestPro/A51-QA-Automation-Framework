import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

public class ProfileTests extends BaseTest {

    @Test
    public void changeProfileName() throws InterruptedException {
        //navigateToLoginPage();
        //Login
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        //Wait for 2 Seconds
        Thread.sleep(2000);
        //Click on Avatar to go to Profile Page
        clickAvatar();
        provideCurrentPassword("te$t$tudent");
        //Enter Random Name
        String randomName = generateRandomName();
        provideProfileName(randomName);
        clickSave();
        //Wait
        Thread.sleep(2000);
        //Comparison
        WebElement actualProfileName = driver.findElement(By.cssSelector("a.view-profile>span"));
        Assert.assertEquals(actualProfileName.getText(), randomName);
    }

    public void clickAvatar(){
        WebElement avatarIcon = driver.findElement(By.cssSelector("img.avatar"));
        avatarIcon.click();
    }

    public void provideCurrentPassword(String password){
        WebElement currentPassword = driver.findElement(By.cssSelector("[name='current_password']"));
        currentPassword.clear();
        currentPassword.sendKeys(password);
    }

    public String generateRandomName(){
        return UUID.randomUUID().toString().replace("-","");
    }

    public void provideProfileName(String name){
        WebElement profileName = driver.findElement(By.cssSelector("[name='name']"));
        profileName.clear();
        profileName.sendKeys(name);
    }

    public void clickSave(){
        WebElement saveButton = driver.findElement(By.cssSelector("button.btn-submit"));
        saveButton.click();
    }


}
