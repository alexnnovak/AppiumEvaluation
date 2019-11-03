package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;


public class AddNetwork {

    private static AndroidDriver driver;

    public void setDriver(AndroidDriver driver)
    {
        this.driver = driver;
    }


    public static MobileElement errorMessage(){
        return (MobileElement) driver.findElement(By.id("com.techtask.androidapp.wifisettings:id/errorText"));
    }

    public static MobileElement ssidLabel(){
        return (MobileElement) driver.findElement(By.id("com.techtask.androidapp.wifisettings:id/textView"));
    }

    public static MobileElement ssidInputField(){
        return (MobileElement) driver.findElement(By.id("com.techtask.androidapp.wifisettings:id/typeNetworkName"));
    }
     public static MobileElement createNetworkButton(){
        return (MobileElement) driver.findElement(By.id("com.techtask.androidapp.wifisettings:id/createwifibutton"));
    }
     public static MobileElement dismissButton(){
        return (MobileElement) driver.findElement(By.id("com.techtask.androidapp.wifisettings:id/closePopup"));
    }

    public static boolean checkErrorMessageIsDisplayed(){
        return (errorMessage().getText().length() > 1);
    }

    public static void setSsidText(String text) {
        ssidInputField().sendKeys(text);
    }

    public static boolean isPageLoad(){
        return (ssidLabel().isDisplayed() && dismissButton().isDisplayed());
    }

}
