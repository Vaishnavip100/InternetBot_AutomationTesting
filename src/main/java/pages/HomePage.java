package pages;

import base.BasePage;
import utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private By formAuthLink=By.linkText("Form Authentication");
    private By alertsLink=By.linkText("JavaScript Alerts");
    private By checkboxesLink=By.linkText("Checkboxes");
    private By dropdownLink=By.linkText("Dropdown");
    private By fileUploadLink=By.linkText("File Upload");
    private By dynamicLoadingLink=By.linkText("Dynamic Loading");
    
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage() {
        driver.get(ConfigReader.get("baseUrl"));
    }

    public void goToFormAuthentication() {
        click(formAuthLink);
    }

    public void goToAlerts() {
        click(alertsLink);
    }

    public void goToCheckboxes() {
        click(checkboxesLink);
    }

    public void goToDropdown() {
        click(dropdownLink);
    }

    public void goToFileUpload() {
        click(fileUploadLink);
    }

    public void goToDynamicLoading() {
        click(dynamicLoadingLink);
    }
}