package actions.pageObject.admin.organization;
import actions.commons.BasePage;
import org.openqa.selenium.WebDriver;
import interfaces.pageUIs.admin.organization.GeneralInforPageUI;

public class GeneralInforPageObject extends BasePage {
    private WebDriver driver;
    public GeneralInforPageObject(WebDriver driver) {
        this.driver = driver;
    }

    //manage actions in the page
    public void clickToAdminSection(){
        waitForElementClickable(driver,GeneralInforPageUI.ADMIN_SECTION);
        clickToElement(driver, GeneralInforPageUI.ADMIN_SECTION);
    }

    public void clickToOrganization(){
        waitForElementClickable(driver,GeneralInforPageUI.ORGANIZATION_ITEM);
        clickToElement(driver, GeneralInforPageUI.ORGANIZATION_ITEM);
    }

    public void clickToGenerateInformationOption(){
        waitForElementClickable(driver,GeneralInforPageUI.GENERAL_INFORMATION_OPTION);
        clickToElement(driver, GeneralInforPageUI.GENERAL_INFORMATION_OPTION);
    }

    public void clickToEditToggle() {
        waitForElementClickable(driver, GeneralInforPageUI.EDIT_TOGGLE);
        clickToElement(driver,GeneralInforPageUI.EDIT_TOGGLE);
    }

    public void enterOrganizationNameTextbox(String organizationName) {
        waitForElementVisible(driver,GeneralInforPageUI.ORGANIZATION_NAME_TEXTBOX);
        clickToElement(driver, GeneralInforPageUI.ORGANIZATION_NAME_TEXTBOX);
        clearValueInField(driver,GeneralInforPageUI.ORGANIZATION_NAME_TEXTBOX);
        sendkeyToElement(driver, GeneralInforPageUI.ORGANIZATION_NAME_TEXTBOX, organizationName);
    }

    public void enterPhoneTextbox(String phone) {
        waitForElementVisible(driver,GeneralInforPageUI.PHONE_TEXTBOX);
        clickToElement(driver, GeneralInforPageUI.PHONE_TEXTBOX);
        clearValueInField(driver,GeneralInforPageUI.PHONE_TEXTBOX);
        sendkeyToElement(driver, GeneralInforPageUI.PHONE_TEXTBOX, phone);
    }

    public void enterEmailTextbox(String email) {
        waitForElementVisible(driver,GeneralInforPageUI.EMAIL_TEXTBOX);
        clickToElement(driver, GeneralInforPageUI.EMAIL_TEXTBOX);
        clearValueInField(driver,GeneralInforPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, GeneralInforPageUI.EMAIL_TEXTBOX, email);
    }

    public void changeCountryDropdown(String country) {
        waitForElementVisible(driver,GeneralInforPageUI.COUNTRY_DROPDOWN);
        selectItemInCustomDropdown(driver,GeneralInforPageUI.COUNTRY_DROPDOWN, GeneralInforPageUI.COUNTRY_LISTVALUE,country);
    }

    public void clickTosaveEditedData() {
        waitForElementClickable(driver, GeneralInforPageUI.SAVE_BUTTON);
        clickToElement(driver,GeneralInforPageUI.SAVE_BUTTON);
    }

    public String getSuccessMessage() {
        waitForElementVisible(driver,GeneralInforPageUI.SUCCESS_MESSAGE);
        return getElementText(driver,GeneralInforPageUI.SUCCESS_MESSAGE);
    }

    public String getUpdatedOrganizationName() {
        return getElementAttribute(driver,GeneralInforPageUI.ORGANIZATION_NAME_TEXTBOX, "value");
    }

    public String getUpdatedPhone() {
        return getElementAttribute(driver,GeneralInforPageUI.PHONE_TEXTBOX, "value");
    }

    public String getUpdatedEmail() {
        return getElementAttribute(driver,GeneralInforPageUI.EMAIL_TEXTBOX, "value");
    }

    public String getUpdatedCountry() {
        return getElementText(driver, GeneralInforPageUI.COUNTRY_DROPDOWN);
    }

    public boolean checkTitleDisplayed() {
        waitForElementVisible(driver, GeneralInforPageUI.GENERAL_INFORMATION_TITLE);
        return isElementDisplayed(driver, GeneralInforPageUI.GENERAL_INFORMATION_TITLE);
    }

    public boolean checkEditToggleDisplayed() {
        waitForElementVisible(driver, GeneralInforPageUI.EDIT_TOGGLE);
        return isElementDisplayed(driver, GeneralInforPageUI.EDIT_TOGGLE);
    }

    public boolean checkNumberOfEmployeeDisplayed() {
        waitForElementVisible(driver, GeneralInforPageUI.NUMBER_LABEL);
        return isElementDisplayed(driver, GeneralInforPageUI.NUMBER_LABEL);
    }
}
