package appiumUtils;

import io.appium.java_client.android.AndroidDriver;

public class ActionsHelper {

    private AndroidDriver driver;

    public void setDriver(AndroidDriver driver)
    {
        this.driver = driver;
    }

    public void hideKeyboard(){
        driver.hideKeyboard();
    }
}
