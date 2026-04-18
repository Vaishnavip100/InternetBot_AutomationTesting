package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private By username=By.id("username");
    private By password=By.id("password");
    private By loginBtn=By.cssSelector("button[type='submit']");
    private By message=By.id("flash");
    private By logoutBtn=By.cssSelector(".icon-2x.icon-signout");
    
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToLogin() {
    	HomePage home=new HomePage(driver);
    	home.openHomePage();
    	home.goToFormAuthentication();
    }

    public void login(String user,String pass) {
        type(username,user);
        type(password,pass);
        click(loginBtn);
    }

    public String getMessage() {
        return getText(message);
    }

    public void logout() {
        click(logoutBtn);
    }

    public boolean isLogoutVisible() {
        return driver.findElement(logoutBtn).isDisplayed();
    }
}
