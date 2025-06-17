package actions.pageObject.admin.qualification;

import actions.commons.BasePage;
import interfaces.pageUIs.BasePageUI;
import interfaces.pageUIs.admin.qualification.EducationPageUI;
import interfaces.pageUIs.admin.qualification.LanguagePageUI;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class LanguagePageObject extends BasePage {
    private WebDriver driver;
    public LanguagePageObject(WebDriver driver){
        this.driver = driver;
    }


    public void clickToAdminSection() {
        waitForElementClickable(driver, LanguagePageUI.ADMIN_MENU);
        clickToElement(driver, LanguagePageUI.ADMIN_MENU);
    }

    public void clickToQualification() {
        waitForElementClickable(driver, LanguagePageUI.QUALIFICATION_MENU);
        clickToElement(driver, LanguagePageUI.QUALIFICATION_MENU);
    }

    public void clickToLanguageOption() {
        waitForElementClickable(driver, LanguagePageUI.LANGUAGE_MENU);
        clickToElement(driver, LanguagePageUI.LANGUAGE_MENU);
    }

    public boolean isMainTitleDisplayed() {
        try{
            waitForElementVisible(driver, LanguagePageUI.MAIN_TITLE);
            return isElementDisplayed(driver, LanguagePageUI.MAIN_TITLE);
        }catch (NoSuchElementException e){
            return false;
        }
    }

    public void clickToAddBtn() {
        waitForElementClickable(driver, LanguagePageUI.ADD_BUTTON);
        clickToElement(driver, LanguagePageUI.ADD_BUTTON);
    }

    public void enterNewLanguage(String language) {
        waitForElementVisible(driver, LanguagePageUI.ADD_MAIN_TITLE);
        waitForElementClickable(driver, LanguagePageUI.LANGUAGE_INPUT);
        sendkeyToElement(driver, LanguagePageUI.LANGUAGE_INPUT, language);
    }

    public void clickToSaveBtn() {
        waitForElementClickable(driver, LanguagePageUI.SAVE_BUTTON);
        clickToElement(driver, LanguagePageUI.SAVE_BUTTON);
    }

    public String getMainSuccessMessage() {
        waitForElementVisible(driver, BasePageUI.SUCCESS_MAIN_TOAST);
        return getElementText(driver, BasePageUI.SUCCESS_MAIN_TOAST);
    }

    public String getSubSuccessMessage() {
        waitForElementVisible(driver, BasePageUI.SUCCESS_SUB_TOAST);
        return getElementText(driver, BasePageUI.SUCCESS_SUB_TOAST);
    }

    public boolean isNewLanguageDisplayed(String language) {
        try {
            return isElementDisplayed(driver, getDynamicLocator(LanguagePageUI.NEW_LANGUAGE, language));
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public String getErrorMessage(){
        try {
            return getElementText(driver, LanguagePageUI.ERROR_MESSAGE);
        }catch (NoSuchElementException e){
            return null;
        }
    }
    public boolean isLanguageExist(String language) {
        return false;
    }

    public void deleteLanguageByName(String language) {
    }
}
