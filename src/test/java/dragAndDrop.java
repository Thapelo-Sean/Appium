import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import java.net.URI;
import java.time.Duration;

public class dragAndDrop {

    public static AndroidDriver driver;
    @Test
    public void test()
    {
        try
        {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName", "Galaxy A10s");
            capabilities.setCapability("udid", "emulator-5554");
            capabilities.setCapability("platformName","Android");
            capabilities.setCapability("platformVersion", "11");
            capabilities.setCapability("appPackage", "");
            capabilities.setCapability("appActivity", "");
            capabilities.setCapability("automationName", "UiAutomator2");

            URI uri = new URI("http://127.0.0.1:4723/wd/hub").toURL().toURI();
            driver = new AndroidDriver(uri.toURL(),capabilities);
            System.out.println("<<<<<<<<<<Application Started>>>>>>>>>>");
        } catch (Exception e) {
            (e).printStackTrace();
            (e).getMessage();
        }

        try
        {
            WebElement sourceElement = driver.findElement(By.id(""));
            WebElement destinationElement = driver.findElement(By.id(""));

            TouchAction action = new TouchAction(driver);
            action.longPress(ElementOption.element(sourceElement))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                    .moveTo(ElementOption.element(destinationElement))
                    .release().perform();

        } catch (Exception e) {
            (e).printStackTrace();
        }
    }
}
