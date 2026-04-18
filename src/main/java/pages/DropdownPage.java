package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage {
    private By dropdown=By.id("dropdown");
    
    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    public void selectByVisibleText(String text) {
        Select select=new Select(driver.findElement(dropdown));
        select.selectByVisibleText(text);
    }

    public String getSelectedOption() {
        Select select=new Select(driver.findElement(dropdown));
        return select.getFirstSelectedOption().getText();
    }

    public int getOptionsCount() {
        Select select=new Select(driver.findElement(dropdown));
        return select.getOptions().size();
    }
    
    public java.util.List<String> getAllOptions() {
        Select select=new Select(driver.findElement(dropdown));
        java.util.List<String> optionsText=new java.util.ArrayList<>();

        for (org.openqa.selenium.WebElement option : select.getOptions()) {
            optionsText.add(option.getText());
        }

        return optionsText;
    }
}