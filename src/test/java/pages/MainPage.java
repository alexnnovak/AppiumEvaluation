package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;


public class MainPage {

    private AndroidDriver driver;

    public void setDriver(AndroidDriver driver)
    {
        this.driver = driver;
    }


    public MobileElement addWifiNetworkButton (){
        return (MobileElement) driver.findElement(By.id("com.techtask.androidapp.wifisettings:id/addWIFIButton"));
    }

    public MobileElement selectedNetworksLabel (){
        return (MobileElement) driver.findElement(By.id("com.techtask.androidapp.wifisettings:id/selectedNetwork"));
    }

    public List<MobileElement> availableNetworksList (){
        List<MobileElement> elements = (List<MobileElement>) driver.findElementsByClassName("android.widget.CheckedTextView");
        return elements;
    }

    public MobileElement getSelectedNetworkFromList(){
        MobileElement element = null;
        for (MobileElement el: availableNetworksList()) {
            if (el.isSelected()){
                element = el;
            }
        }
        return element;
    }

    public MobileElement getNetworkByName(String name){
        MobileElement element = null;
        for (MobileElement el: availableNetworksList()) {
            if(el.getText().contains(name)){
                element = el;
            }
        }
        return element;
    }

    public String getSelectedNetworkNameFromList(){
        return getSelectedNetworkFromList().getText();
    }

    public String getSelectedNetworkNameFromLabel(){
        return selectedNetworksLabel().getText();
    }

    public boolean isOnMainPage(){
        return addWifiNetworkButton().isDisplayed();
    }

    public void createNetwork(String name){
        addWifiNetworkButton().click();
        Assert.assertTrue(AddNetwork.isPageLoad());
        AddNetwork.setSsidText(name);
        AddNetwork.createNetworkButton().click();
    }

}
