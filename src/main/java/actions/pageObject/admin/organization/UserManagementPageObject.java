package actions.pageObject.admin.organization;

import actions.commons.BasePage;
import org.openqa.selenium.WebDriver;
import actions.commons.GlobalConstants;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import interfaces.pageUIs.admin.organization.UserManagementPageUI;

import java.util.Scanner;
public class UserManagementPageObject extends BasePage {
    private WebDriver driver;
    public UserManagementPageObject(WebDriver driver) {
        this.driver = driver;
    }
    //manage actions in the page

    public void clickToAdminSection(){
        waitForElementClickable(driver, interfaces.pageUIs.admin.organization.UserManagementPageUI.ADMIN_SECTION);
        clickToElement(driver, interfaces.pageUIs.admin.organization.UserManagementPageUI.ADMIN_SECTION);
    }
}
