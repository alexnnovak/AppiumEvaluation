package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddNetwork;
import pages.MainPage;

public class AppTest extends BaseTest {

    MainPage mainPage = new MainPage();
    AddNetwork addNetwork = new AddNetwork();


    @BeforeClass
    void initializePages(){
        addNetwork.setDriver(driver());
        mainPage.setDriver(driver());
    }

    @Test(priority = 0)
    public void creteAndSelectJustCreatedNetwork(){
        String networkName = "test network name";
        mainPage.createNetwork(networkName);
        mainPage.getNetworkByName(networkName).click();
        Assert.assertTrue(mainPage.getSelectedNetworkNameFromLabel().contains(networkName));
    }

    @Test(priority = 0)
    public void createNetworkNotUniqueName(){
        String networkName = "noUnique";
        mainPage.createNetwork(networkName);
        mainPage.addWifiNetworkButton().click();
        addNetwork.setSsidText(networkName);
        addNetwork.createNetworkButton().click();
        Assert.assertTrue(addNetwork.checkErrorMessageIsDisplayed());
        addNetwork.dismissButton().click();


    }

    @DataProvider(name = "Data")
    Object [][] data(){
        return new Object[][]{
                {"123"},
                {"-123"},
                {"ABCabc"},
                {"º"},
                {""}
        };
    }

    @Test(priority = 1, dataProvider = "Data")
    public void createMultipleNewNetwork(String data){
        Assert.assertTrue(mainPage.isOnMainPage());
        mainPage.createNetwork(data);
        Assert.assertTrue(mainPage.isOnMainPage());
        Assert.assertTrue(mainPage.getNetworkByName(data).isDisplayed());

    }

}
