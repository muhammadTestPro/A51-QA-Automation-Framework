import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.HomePage;
import pages.LoginPage;

import java.util.List;

public class HomeTest extends BaseTest{

    String newPlaylistName = "Sample Edited Playlist";


    //Tests Start here
/*    @Test
    public void playSongWithContextClick() throws InterruptedException {
        // Login
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        //Choose All Songs List
        chooseAllSongsList();
        //Right/Context Click
        contextClickFirstSong();
        //Choose Play
        choosePlayOption();
        //Assertion
        Assert.assertTrue(isSongPlaying());
    }*/

    @Test
    public void playSong() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage songsPage = new AllSongsPage(driver);
        // Login
        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmit();
        Thread.sleep(2000);
        homePage.chooseAllSongsList();
        songsPage.contextClickFirstSong();
        songsPage.choosePlayOption();
        //Assertion
        Assert.assertTrue(songsPage.isSongPlaying());
    }

/*    @Test
    public void hoverOverPlayButton() throws InterruptedException {
        //Login
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        //Thread.sleep(2000);
        //Assertion
        Assert.assertTrue(hoverPlay().isDisplayed());
    }*/

    @Test
    public void hoverOverPlayBtn() throws InterruptedException {
        //Login
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("demo@class.com");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmit();
        Thread.sleep(2000);
        //Assertion
        Assert.assertTrue(homePage.hoverPlay().isDisplayed());
    }

    @Test
    public void countSongsInPlaylist() throws InterruptedException {
        //Login
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);
        //choose playlist by name
        choosePlaylistByName("DEMO PLAYLIST");
        Thread.sleep(2000);
        //display all songs
        displayAllSongs();
        Thread.sleep(2000);
        //Assert
        Assert.assertTrue(getPlaylistDetails().contains(String.valueOf(countSongs())));

    }

    @Test
    public void renamePlayList() throws InterruptedException {

        String updatedPlaylistMsg = "Updated playlist \"Sample Edited Playlist.\"";

        //Login
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
        Thread.sleep(2000);
        //double click
        doubleClickPlaylist();
        Thread.sleep(2000);
        //Enter New Name for Playlist
        enterNewPlaylistName();
        Thread.sleep(2000);
        //Assert
        Assert.assertEquals(getRenamePlaylistSuccessMsg(),updatedPlaylistMsg);
    }

    //Tests End here


    //Helper Methods start here

    public void doubleClickPlaylist(){
        WebElement playlistElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playlistElement).perform();
    }

    public void enterNewPlaylistName(){
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        playlistInputField.sendKeys(Keys.chord(Keys.CONTROL,"A", Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public String getRenamePlaylistSuccessMsg(){
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return  notification.getText();
    }


    public void choosePlaylistByName(String playlistName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'"+playlistName+"')]"))).click();
    }

    public int countSongs(){
        return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size();
    }

    public String getPlaylistDetails(){
        return driver.findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();
    }

    public void displayAllSongs(){
        List<WebElement> songList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
        System.out.println("Number of Soungs found: "+countSongs());
        for (WebElement e: songList){
            System.out.println(e.getText());
        }
    }





}
