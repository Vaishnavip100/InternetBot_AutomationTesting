package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckboxPage extends BasePage {
    private By checkbox1=By.xpath("(//input[@type='checkbox'])[1]");
    private By checkbox2=By.xpath("(//input[@type='checkbox'])[2]");
    
    public CheckboxPage(WebDriver driver) {
        super(driver);
    }

    public void clickCheckbox1() {
        click(checkbox1);
    }

    public void clickCheckbox2() {
        click(checkbox2);
    }

    public boolean isCheckbox1Selected() {
        return driver.findElement(checkbox1).isSelected();
    }

    public boolean isCheckbox2Selected() {
        return driver.findElement(checkbox2).isSelected();
    }
}