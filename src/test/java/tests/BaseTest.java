package tests;


import appiumUtils.DriverFactory;
import appiumUtils.ReadProperties;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class BaseTest {


    protected AndroidDriver driver(){
        return DriverFactory.getDriver();
    }

    @BeforeSuite
    void setUpClass(){
        DriverFactory df = new DriverFactory();
        df.setDriver();
        driver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @AfterSuite
    void tearDownClass(){
        driver().quit();
    }

}
