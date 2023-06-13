import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class scrollingHorizontally {
    AndroidDriver driver;

    @Test
    public void scrollTest() throws URISyntaxException, MalformedURLException {
        try
        {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName","Galaxy A10s");
            capabilities.setCapability("udid", "R9AMA0D3BDJ");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("platformVersion", "11");
            capabilities.setCapability("appPackage", "com.samsung.android.calendar");
            capabilities.setCapability("appActivity", "com.samsung.android.app.calendar.activity.MainActivity");
            capabilities.setCapability("automationName","UiAutomator2");
            capabilities.setCapability("noReset", "true");

            URI uri = new URI("http://127.0.0.1:4723/wd/hub").toURL().toURI();
            driver = new AndroidDriver(uri.toURL(), capabilities);
            System.out.println("<<<<<<<<<<<<<<<Application launched>>>>>>>>>>>>>>>");

        } catch (URISyntaxException e) {
             (e).printStackTrace();
        } catch (MalformedURLException e) {
             (e).printStackTrace();
        }

        try
        {
            Dimension screenSize = driver.manage().window().getSize();
            System.out.println("Screen size is: "+ screenSize);

            int startX = (int) (screenSize.width * 0.8);
            int endX = (int) (screenSize.width * 0.2);
            int startY = screenSize.height / 2;

            TouchAction action = new TouchAction(driver);
            action
                    .press(PointOption.point(startX,startY))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                    .moveTo(PointOption.point(endX,startY))
                    .release().perform();
            System.out.println("<<<<<<<<<<<<<<<Test complete>>>>>>>>>>>>>>>");
        } catch (Exception e) {
            new RuntimeException(e).printStackTrace();
        }
    }
}