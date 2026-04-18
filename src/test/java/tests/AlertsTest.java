package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsPage;
import pages.HomePage;

public class AlertsTest extends BaseTest {

    //JS Alert-Accept
    @Test
    public void verifyJsAlertAccept() {
        HomePage home=new HomePage(getDriver());
        home.openHomePage();
        home.goToAlerts();

        AlertsPage alerts=new AlertsPage(getDriver());
        alerts.clickJsAlert();
        alerts.acceptAlert();

        String result=alerts.getResultText();

        Assert.assertTrue(result.contains("You successfully clicked an alert"));
    }

    //JS Confirm-Dismiss
    @Test
    public void verifyJsConfirmDismiss() {
        HomePage home=new HomePage(getDriver());
        home.openHomePage();
        home.goToAlerts();

        AlertsPage alerts=new AlertsPage(getDriver());
        alerts.clickJsConfirm();

        alerts.dismissAlert();

        String result=alerts.getResultText();

        Assert.assertTrue(result.contains("You clicked: Cancel"));
    }

    //JS Prompt-Send Text
    @Test
    public void verifyJsPromptInput() {
        HomePage home=new HomePage(getDriver());
        home.openHomePage();
        home.goToAlerts();

        AlertsPage alerts=new AlertsPage(getDriver());
        alerts.clickJsPrompt();

        String inputText="Hello Test";

        alerts.sendTextToAlert(inputText);

        String result=alerts.getResultText();

        Assert.assertTrue(result.contains(inputText));
    }

    //Verify result text changes correctly
    @Test
    public void verifyResultTextUpdates() {
        HomePage home=new HomePage(getDriver());
        home.openHomePage();
        home.goToAlerts();

        AlertsPage alerts=new AlertsPage(getDriver());
        alerts.clickJsAlert();
        alerts.acceptAlert();
        String alertMsg=alerts.getResultText();

        alerts.clickJsConfirm();
        alerts.dismissAlert();
        String confirmMsg=alerts.getResultText();

        alerts.clickJsPrompt();
        alerts.sendTextToAlert("Test");
        String promptMsg=alerts.getResultText();

        Assert.assertNotEquals(alertMsg,confirmMsg);
        Assert.assertNotEquals(confirmMsg,promptMsg);
    }
}