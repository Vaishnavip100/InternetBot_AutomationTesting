package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicLoadingPage;
import pages.HomePage;

public class DynamicLoadingTest extends BaseTest {

    //Verify dynamic loading text
    @Test
    public void verifyDynamicLoadingText() {
        HomePage home=new HomePage(getDriver());
        home.openHomePage();
        home.goToDynamicLoading();

        DynamicLoadingPage page=new DynamicLoadingPage(getDriver());
        page.openExample1();
        page.clickStart();

        String result=page.waitForResultText();

        Assert.assertTrue(result.contains("Hello World!"),"Dynamic text not loaded correctly");
    }

    //Verify disappearing element reload
    @Test
    public void verifyElementReappearsOnRefresh() {
        HomePage home=new HomePage(getDriver());
        home.openHomePage();
        home.goToDynamicLoading();

        DynamicLoadingPage page=new DynamicLoadingPage(getDriver());
        page.openExample1();
        page.clickStart();
        page.waitForResultText();

        getDriver().navigate().refresh();
        page=new DynamicLoadingPage(getDriver());
        page.clickStart();

        String result=page.waitForResultText();

        Assert.assertTrue(result.contains("Hello World!"),"Element did not reappear after refresh");
    }
}