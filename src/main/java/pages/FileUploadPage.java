package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage extends BasePage {
    private By fileInput=By.id("file-upload");
    private By uploadBtn=By.id("file-submit");
    private By uploadedFileName=By.id("uploaded-files");
    private By pageTitle=By.tagName("h3");
    
    public FileUploadPage(WebDriver driver) {
        super(driver);
    }

    public void uploadFile(String filePath) {
        driver.findElement(fileInput).sendKeys(filePath);
        click(uploadBtn);
    }

    public String getUploadedFileName() {
        return getText(uploadedFileName);
    }

    public String getPageTitle() {
        return getText(pageTitle);
    }

    public boolean isUploadFormVisible() {
        return driver.findElement(fileInput).isDisplayed();
    }
}