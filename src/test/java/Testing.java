import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Testing {

    public static void main(String [] args) throws MalformedURLException, URISyntaxException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","Galaxy A10s");
        capabilities.setCapability("udid", "R9AMA0D3BDJ");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "11");
        capabilities.setCapability("appPackage", "com.arlosoft.macrodroid");
        capabilities.setCapability("appActivity", "com.arlosoft.macrodroid.intro.IntroActivity");
        capabilities.setCapability("automationName","UiAutomator2");
        capabilities.setCapability("noReset", "true");

        java.net.URI uri = new URI("http://localhost:4723/wd/hub").toURL().toURI();
        AndroidDriver driver = new AndroidDriver(uri.toURL(), capabilities);
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        System.out.println("Application started");

        try
        {
            WebElement nextButton = driver.findElement(By.id("com.arlosoft.macrodroid:id/button_next"));
            for(int x = 0; x < 5; x++)
            {
                nextButton.click();
            }
            System.out.println("Next button clicked");

            //Dismiss info
            driver.findElement(By.id("com.arlosoft.macrodroid:id/infoBarDismissButton")).click();

            //Get text of all elements
            List<WebElement> elements = driver.findElements(By.className("android.widget.TextView"));
            int sizeOfElements = elements.size();

            for(int y = 0; y < sizeOfElements; y++)
            {
                System.out.println(elements.get(y).getText());
            }
            System.out.println("<<<<<<<<<Elements found>>>>>>>>>");

            driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Categories\"));"));

            for(WebElement addMacro : elements)
            {
                if(addMacro.getText().equalsIgnoreCase("Add Macro"))
                {
                    addMacro.click();
                }
            }
            System.out.println("Add Macro button clicked");
            driver.findElement(By.id("com.arlosoft.macrodroid:id/actionBack")).click();

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.print("Execution complete!!!");
        //driver.configuratorSetWaitForIdleTimeout(Duration.ofMinutes(2));
    }
}