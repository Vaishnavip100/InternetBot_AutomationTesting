package tests;

import base.BaseTest;
import utils.ConfigReader;
import utils.ExcelUtil;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

	@DataProvider(name="loginData")
	public Object[][] loginData() {
	    return ExcelUtil.getData("src/test/resources/testdata/LoginData.xlsx","Login");
	}

	@Test(dataProvider="loginData")
	public void verifyLogin(String user,String pass,String expectedStr) {
	    boolean expected=Boolean.parseBoolean(expectedStr);

	    LoginPage lp=new LoginPage(getDriver());
	    lp.navigateToLogin();
	    lp.login(user,pass);

	    String msg=lp.getMessage();

	    if (expected) {
	        Assert.assertTrue(msg.contains("You logged into a secure area!"),"Valid login failed");
	    } else {
	        Assert.assertTrue(msg.contains("Your password is invalid!") || msg.contains("Your username is invalid!"),"Invalid login not handled properly");
	    }
	}

    //Verify success message
    @Test
    public void verifySuccessMessage() {
        LoginPage lp=new LoginPage(getDriver());
        lp.navigateToLogin();
        lp.login(ConfigReader.get("username"),ConfigReader.get("password"));

        String msg=lp.getMessage();

        Assert.assertTrue(msg.contains("You logged into a secure area!"));
    }

    //Verify logout functionality
    @Test
    public void verifyLogout() {
        LoginPage lp=new LoginPage(getDriver());
        lp.navigateToLogin();
        lp.login(ConfigReader.get("username"),ConfigReader.get("password"));

        lp.logout();

        String msg=lp.getMessage();

        Assert.assertTrue(msg.contains("You logged out of the secure area!"),"Logout failed");
    }
}