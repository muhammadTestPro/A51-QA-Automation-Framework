package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(css = ".avatar")
    private WebElement userAvatarIcon;
    // userAvatarIcon: Represents the user avatar element on the page.

    @FindBy(css = ".playlist:nth-child(3)")
    private WebElement firsPlaylist;
    // firsPlaylist: Represents the first playlist item on the page.

    @FindBy(css = "input[name='name']")
    private WebElement playlistInputField;
    // playlistInputField: Represents the input field on the page used for entering the playlist name.

    @FindBy(css = ".fa-plus-circle")
    private WebElement addNewPlaylist;
    // addNewPlaylist: Represents the element on the page indicating the addition of a new playlist.

    @FindBy(css = ".btn-delete-playlist")
    private WebElement deletePlaylistBtn;
    // deletePlaylistBtn: Represents the button on the page used for deleting a playlist.

    @FindBy(css = ".show.success")
    private WebElement notification;
    // notification: Represents the element on the page displaying a notification or message.

    @FindBy(css = ".songs")
    private WebElement allSongs;
    // allSongs: Represents the block or container containing all songs.

    @FindBy(css = "[data-testid='playlist-context-menu-create-simple']")
    private WebElement chooseCreateNewPlaylist;
    // chooseCreateNewPlaylist: Represents the element on the page used for selecting to create a new playlist.


    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
// This is the constructor of the "HomePage" class that takes a WebDriver object as a parameter
// and invokes the constructor of the superclass (parent class) with this parameter.
// The constructor is used to initialize the object of the class when an instance is created.

    public boolean getUserAvatar() {
        return userAvatarIcon.isEnabled();
    }
// The "getUserAvatar" method returns a boolean value (true or false)
// depending on whether the "userAvatarIcon" element is enabled.
// If the element is enabled, the method returns true; otherwise, it returns false.

    public HomePage chooseFirstPlaylist() {
        firsPlaylist.click();
        return this;
    }
// The "chooseFirstPlaylist" method performs an action to select the first playlist.
// It clicks on the "firstPlaylist" element (link corresponding to the first playlist)
// and returns an instance of the current "HomePage" class.

    public HomePage deletePlaylist() {
        deletePlaylistBtn.click();
        return this;
    }
// The "deletePlaylist" method performs an action to delete the playlist.
// It clicks on the "deletePlaylistBtn" element
// and returns an instance of the current "HomePage" class.

    public boolean notificationText() {
        findElement(notification);
        return notification.isDisplayed();
    }
// It uses the "findElement" method to locate the "notification" element.
// It returns a boolean value (true or false) depending on whether the "notification" element is displayed on the page.
// If the element is displayed, the method returns true; otherwise, it returns false.
}

    By userAvatarIcon = By.cssSelector("img.avatar");

    public WebElement getUserAvatar(){
        return findElement(userAvatarIcon);
    }

    public WebElement hoverPlay() throws InterruptedException {
        //WebElement play = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='play-btn']")));
        WebElement play = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        actions.moveToElement(play).perform();
        return  wait.until(ExpectedConditions.visibilityOf(play));
    }


}
