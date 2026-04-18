package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage extends BasePage {
    private By example1=By.xpath("//a[contains(text(),'Example 1')]");
    private By startBtn=By.xpath("//button[text()='Start']");
    private By loadingText=By.id("loading");
    private By resultText=By.id("finish");
    
    public DynamicLoadingPage(WebDriver driver) {
        super(driver);
    }

    public void openExample1() {
        click(example1);
    }

    public void clickStart() {
        waitForVisible(startBtn);
        click(startBtn);
    }

    public String waitForResultText() {
        waitForVisible(resultText);
        return getText(resultText);
    }

    public boolean isLoadingVisible() {
        return driver.findElement(loadingText).isDisplayed();
    }
}