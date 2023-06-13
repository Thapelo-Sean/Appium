import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

public class ScrollingVertically
{
    public static AndroidDriver driver;

    @Test
    public void AppiumTest() throws URISyntaxException, MalformedURLException
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Android 10s");
        capabilities.setCapability("udid", "R9AMA0D3BDJ");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "11");
        capabilities.setCapability("appPackage","com.android.settings");
        capabilities.setCapability("appActivity", "com.android.settings.Settings");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("noReset", "true");

        URI uri = new URI("http://localhost:4723/wd/hub").toURL().toURI();
        driver = new AndroidDriver(uri.toURL(),capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        System.out.println("<<<<<<<<Application launched>>>>>>>>");

        try
        {
            driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().textContains(\"Remote support\"))"));
            WebElement softwareUpdate = driver.findElement(By.xpath(".//*[(@text=\"Software update\")]"));
            softwareUpdate.click();
            driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
            driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"Thapelo Sean\"))"));
            //System.out.println("Scrolled to element and clicked");
            WebElement display = driver.findElement(By.xpath("//*[(@text = \"Display\")]"));
            display.click();
            driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().textContains(\"Screen saver\"))"));
            driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"Dark mode settings\"))"));
            WebElement navigateUp = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"));
            Thread.sleep(1000);
            navigateUp.click();
            Thread.sleep(2000);
            driver.closeApp();

        } catch (Exception e) {
            (e).printStackTrace();
        }
        System.out.println("<<<<<<<<Execution completed>>>>>>>>");
    }
}