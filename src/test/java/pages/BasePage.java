package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    // This line declares a variable named 'driver' that will be used to control the web driver,
// such as ChromeDriver, FirefoxDriver, etc. The variable is declared with the 'protected' modifier,
// which means it is accessible in this class and its subclasses.
    protected WebDriverWait wait;
    // This line declares a variable named 'wait' that represents a WebDriverWait
// and is used to wait for certain conditions on a web page before continuing the test execution.
// It is also declared with the 'protected' modifier to be accessible in the class and its subclasses.
    protected Actions actions;
    // This line declares a variable named 'actions' that represents Actions
// and is used to perform various interactions with page elements, such as key presses, dragging, etc.
// It is also declared with the 'protected' modifier to be accessible in the class and its subclasses.
    private int timeSeconds = 5;
// This line declares a variable named 'timeSeconds' with the type int and sets it to 5.
// This value is used to determine the waiting time in seconds in some waiting or delay operations.
// This variable is private and only accessible within this class.

    public BasePage(WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeSeconds));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
        //PageFactory.initElements(new AjaxElementLocatorFactory(driver, timeSeconds), this);
    }
// The BasePage constructor initializes the driver, wait, and actions variables,
// as well as performs the initialization of page elements using PageFactory.

    protected void doubleClick(WebElement locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        actions.doubleClick(locator).perform();
    }
// The doubleClick method performs a double click on the specified element.
// First, the method waits for the element to be clickable using wait.until(ExpectedConditions.elementToBeClickable(locator)).
// Then, the method performs a double click on the element using the actions object (actions.doubleClick(locator).perform()).

    protected void contextClickSong(WebElement locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        actions.contextClick(locator).perform();
    }
// The contextClickSong method performs a context click on the specified element.
// It also waits for the element to be clickable, then performs a context click using actions.contextClick(locator).perform().

    protected void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
// The click method performs a click on the element identified by the given By locator.
// It waits for the element to be clickable using wait.until(ExpectedConditions.elementToBeClickable(locator)).

    protected WebElement findElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
// The findElement method finds the specified element on the page, waiting for its visibility
// using wait.until(ExpectedConditions.visibilityOf(element)). Then, it returns the fou

}
