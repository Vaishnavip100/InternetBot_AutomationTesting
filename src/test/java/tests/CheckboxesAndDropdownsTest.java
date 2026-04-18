package tests;

import base.BaseTest;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckboxPage;
import pages.DropdownPage;
import pages.HomePage;

public class CheckboxesAndDropdownsTest extends BaseTest {

    //Checkbox 1 check/uncheck
    @Test
    public void verifyCheckbox1Toggle() {
        HomePage home=new HomePage(getDriver());
        home.openHomePage();
        home.goToCheckboxes();

        CheckboxPage page=new CheckboxPage(getDriver());
        if (!page.isCheckbox1Selected()) {
            page.clickCheckbox1();
        }
        Assert.assertTrue(page.isCheckbox1Selected());

        //Uncheck
        page.clickCheckbox1();
        Assert.assertFalse(page.isCheckbox1Selected());
    }

    //Checkbox 2 toggle
    @Test
    public void verifyCheckbox2Toggle() {
        HomePage home=new HomePage(getDriver());
        home.openHomePage();
        home.goToCheckboxes();

        CheckboxPage page=new CheckboxPage(getDriver());

        boolean initialState=page.isCheckbox2Selected();
        page.clickCheckbox2();

        Assert.assertNotEquals(page.isCheckbox2Selected(), initialState);
    }

    //Dropdown selection
    @Test
    public void verifyDropdownSelection() {
        HomePage home=new HomePage(getDriver());
        home.openHomePage();
        home.goToDropdown();

        DropdownPage dropdown=new DropdownPage(getDriver());
        List<String> options=dropdown.getAllOptions();
        for (String option : options) {
            if (option.equals("Please select an option")) continue;
            dropdown.selectByVisibleText(option);

            Assert.assertEquals(dropdown.getSelectedOption(),option);
        }
    }

    //Dropdown options count
    @Test
    public void verifyDropdownOptionsCount() {
        HomePage home=new HomePage(getDriver());
        home.openHomePage();
        home.goToDropdown();

        DropdownPage dropdown=new DropdownPage(getDriver());
        int count=dropdown.getOptionsCount();

        Assert.assertEquals(count, 3, "Dropdown options count is incorrect");
    }
}