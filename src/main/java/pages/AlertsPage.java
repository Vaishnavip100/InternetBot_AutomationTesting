package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage extends BasePage {
    private By jsAlertBtn=By.xpath("//button[text()='Click for JS Alert']");
    private By jsConfirmBtn=By.xpath("//button[text()='Click for JS Confirm']");
    private By jsPromptBtn=By.xpath("//button[text()='Click for JS Prompt']");
    private By resultText=By.id("result");
    
    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    public void clickJsAlert() {
        click(jsAlertBtn);
    }

    public void clickJsConfirm() {
        click(jsConfirmBtn);
    }

    public void clickJsPrompt() {
        click(jsPromptBtn);
    }
    
    public void acceptAlert() {
    	handleAlert().accept();
    }

    public void dismissAlert() {
    	handleAlert().dismiss();
    }
    
    public void sendTextToAlert(String text) {
        handleAlertSendKeys(text);
    }
    
    public String getResultText() {
        return getText(resultText);
    }
}