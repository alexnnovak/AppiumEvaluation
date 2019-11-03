package appiumUtils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {
    private static AndroidDriver driver;

    public static AndroidDriver getDriver(){
        return driver;
    }


    private static final DriverFactory instance = new DriverFactory();

    public void setDriver(){
        ReadProperties readProperties = new ReadProperties();
        String url = readProperties.readProperties("android.wd.hub.url");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", readProperties.readProperties("android.device.name"));
        caps.setCapability("udid", readProperties.readProperties("android.udid"));
        caps.setCapability("platformName", readProperties.readProperties("android.platform.name"));
        caps.setCapability("platformVersion", readProperties.readProperties("android.platform.version"));
        caps.setCapability("skipUnlock","true");
        caps.setCapability("noReset","false");
        caps.setCapability("appPackage", readProperties.readProperties("android.app.package"));
        caps.setCapability("appActivity",readProperties.readProperties("android.app.activity"));

        try {
            this.driver = new AndroidDriver(new URL(url), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
