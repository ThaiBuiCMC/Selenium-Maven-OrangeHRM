package actions.pageObject.admin.qualification;

import actions.commons.BasePage;
import interfaces.pageUIs.admin.qualification.EducationPageUI;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class EducationPageObject extends BasePage {
    private WebDriver driver;
    public EducationPageObject(WebDriver driver){
        this.driver = driver;
    }
    public void clickToAdminSection() {
        waitForElementClickable(driver, EducationPageUI.ADMIN_MENU);
        clickToElement(driver, EducationPageUI.ADMIN_MENU);
    }
    public void clickToQualification() {
        waitForElementClickable(driver, EducationPageUI.QUALIFICATIONS_MENU);
        clickToElement(driver, EducationPageUI.QUALIFICATIONS_MENU);
    }
    public void clickToEducationOption() {
        waitForElementClickable(driver, EducationPageUI.EDUCATION_MENU);
        clickToElement(driver, EducationPageUI.EDUCATION_MENU);
    }
    private boolean isTextDisplayed(String locator){
        try {
            return isElementDisplayed(driver, locator);
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean isMainTitleDisplayed(){
        return isTextDisplayed(EducationPageUI.MAIN_TITLE);
    }
    public boolean isAddButtonDisplayed(){
        return isElementDisplayed(driver, EducationPageUI.ADD_LEVEL_BUTTON);
    }
    public void clickToAddBtn() {
        waitForElementClickable(driver, EducationPageUI.ADD_LEVEL_BUTTON);
        clickToElement(driver, EducationPageUI.ADD_LEVEL_BUTTON);
    }
    public boolean isAddEducationLabelDisplayed(){
        return isTextDisplayed(EducationPageUI.ADD_MAIN_TITLE);
    }
    public void enterName(String value){
        waitForElementClickable(driver, EducationPageUI.LEVEL_INPUT);
        sendkeyToElement(driver, EducationPageUI.LEVEL_INPUT, value);
    }
    public void changeName(String value){
        waitForElementClickable(driver, EducationPageUI.LEVEL_INPUT);
        waitForStableInputValue(driver, EducationPageUI.LEVEL_INPUT);
        clickToElement(driver, EducationPageUI.LEVEL_INPUT);
        clearValueInField(driver, EducationPageUI.LEVEL_INPUT);
        sendkeyToElement(driver, EducationPageUI.LEVEL_INPUT, value);
    }
    public void clickToSaveButton() {
        waitForElementClickable(driver, EducationPageUI.SAVE_LEVEL_BUTTON);
        clickToElement(driver, EducationPageUI.SAVE_LEVEL_BUTTON);
    }
    public String getMainSuccessMessage() {
        waitForElementVisible(driver, SUCCESS_TOAST);
        waitForElementVisible(driver, SUCCESS_MAIN_TOAST);
        return getElementText(driver, SUCCESS_MAIN_TOAST);
    }

    public String getSubSuccessMessage(){
        waitForElementVisible(driver, SUCCESS_SUB_TOAST);
        return getElementText(driver, SUCCESS_SUB_TOAST);
    }
    public boolean isEducationDisplayed(String name){
        try {
            return isElementDisplayed(driver, getDynamicLocator(EducationPageUI.NEW_EDUCATION, name));
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public void clickToEditIcon(String education){
        waitForElementClickable(driver, getDynamicLocator(EducationPageUI.EDIT_ICON, education));
        clickToElement(driver, getDynamicLocator(EducationPageUI.EDIT_ICON, education));
    }
    public boolean isEditLableDisplayed(){
        return isTextDisplayed(EducationPageUI.EDIT_MAIN_TITLE);
    }
    public void changeName(){

    }

    public void clickToDeleteIcon(String education) {
        waitForElementClickable(driver, getDynamicLocator(EducationPageUI.DELETE_ICON, education));
        clickToElement(driver, getDynamicLocator(EducationPageUI.DELETE_ICON, education));
    }

    public boolean isDeleteDialogDisplayed() {
        try{
            waitForElementVisible(driver, EducationPageUI.DELETE_DIALOG);
            return isElementDisplayed(driver, EducationPageUI.DELETE_DIALOG);
        }catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickToYesButton() {
        waitForElementClickable(driver, EducationPageUI.YES_DELETE_BUTTON);
        clickToElement(driver, EducationPageUI.YES_DELETE_BUTTON);
    }

    public void checkToCheckBox(String name) {
        waitForElementClickable(driver, getDynamicLocator(EducationPageUI.CHECK_BOX_EDUCATION, name));
        System.out.println(getDynamicLocator(EducationPageUI.CHECK_BOX_EDUCATION, name));
        clickToElement(driver, getDynamicLocator(EducationPageUI.CHECK_BOX_EDUCATION, name));
    }

    public void clickToDeleteBtn() {
        waitForElementClickable(driver, EducationPageUI.DELETE_SELECTED_BUTTON);
        clickToElement(driver, EducationPageUI.DELETE_SELECTED_BUTTON);
    }
    public String getErrorUnderInputField(){
        waitForElementVisible(driver, EducationPageUI.ERROR_UNDER_INPUT_NAME);
        return getElementText(driver, EducationPageUI.ERROR_UNDER_INPUT_NAME);
    }
}
