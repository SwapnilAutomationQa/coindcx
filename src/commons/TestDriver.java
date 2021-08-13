package commons;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

public class TestDriver {

    private WebDriver driver;


    public void launchBrowser(String url) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","./lib/chromedriver");
        driver = new ChromeDriver();
      //  driver.manage().deleteAllCookies();
        openPage(url);
        driver.manage().window().setSize(new Dimension(1920, 1080));
    }

    public WebElement getElement(String locator)

    {
       return driver.findElement(By.xpath(locator));

    }

    public void closeBrowser()

    {
        driver.quit();

    }


    public void openPage(String url)

    {
        driver.get(url);
    }

    public void sendValues(String element, CharSequence value)

    {

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        getElement(element).clear();
        getElement(element).sendKeys(value);
    }

    public void clickElement(String element)

    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
        getElement(element).click();
    }

public void switchToFrame(String frameName)

{

    new WebDriverWait(driver, 20).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.name(frameName)));

}
        public void verifyMessage(String locator,String message)

        {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.textToBePresentInElement(getElement(locator),message));
            Assert.assertEquals(getElement(locator).getText(),message);
        }

}


