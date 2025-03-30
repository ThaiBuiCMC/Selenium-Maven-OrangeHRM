package actions.pageObject.admin.organization;
import actions.commons.BasePage;
import interfaces.pageUIs.admin.organization.LocationsPageUI;
import org.openqa.selenium.WebDriver;
import java.util.Arrays;

public class LocationsPageObject extends BasePage {
    private WebDriver driver;

    public LocationsPageObject(WebDriver driver){
        this.driver = driver;
    }

    public void clickToAdminSection() {
        waitForElementClickable(driver, LocationsPageUI.ADMIN_SECTION);
        clickToElement(driver, LocationsPageUI.ADMIN_SECTION);
    }

    public void clickToOrganization() {
        waitForElementClickable(driver, LocationsPageUI.ORGANIZATION_ITEM);
        clickToElement(driver, LocationsPageUI.ORGANIZATION_ITEM);
    }

    public void clickToLocationOption() {
        waitForElementClickable(driver, LocationsPageUI.LOCATIONS_ITEM);
        clickToElement(driver, LocationsPageUI.LOCATIONS_ITEM);
    }

    public String getLabel() {
        waitForElementVisible(driver, LocationsPageUI.LOCATIONS_LABEL);
        return getElementText(driver,LocationsPageUI.LOCATIONS_LABEL);
    }

    public boolean isAddButtonDisplayed() {
        waitForElementVisible(driver, LocationsPageUI.ADD_BTN);
        if (!isElementDisplayed(driver,LocationsPageUI.ADD_BTN)){
            return false;
        };
        return true;
    }

    public void enterName(String valueToFill) {
        waitForElementClickable(driver, LocationsPageUI.NAME_INPUT);
        sendkeyToElement(driver,LocationsPageUI.NAME_INPUT,valueToFill);
    }

    public void clickToSearchBtn() {
        waitForElementVisible(driver, LocationsPageUI.SEARCH_BTN);
        waitForElementClickable(driver, LocationsPageUI.SEARCH_BTN);
        clickToElement(driver, LocationsPageUI.SEARCH_BTN);
    }

    private boolean isTextSearchContained(String textSearched, String locator) {
        //if no results --> stop right away
        if (!getListWebElements(driver, LocationsPageUI.NO_RESULTS_TEXT).isEmpty()) {
            return false;
        }
        //if element is not displayed --> stop right away
        if (!isElementDisplayed(driver, locator)) {
            return false;
        }

        //check in list
        String allNames = getAllTextsInList(driver, locator);

        //case 1 result
        if (!allNames.contains(";")) {  // Chỉ có 1 phần tử
            return allNames.contains(textSearched);
        }
        //case >1 results
        return Arrays.stream(allNames.split(";"))
                .allMatch(name -> name.contains(textSearched));
    }

    public boolean isNameSearchContained(String textSearched){
        return isTextSearchContained(textSearched,LocationsPageUI.NAME_COLUMN_DATA);
    }

    public void enterCity(String valueToSend) {
        waitForElementClickable(driver, LocationsPageUI.CITY_INPUT);
        sendkeyToElement(driver, LocationsPageUI.CITY_INPUT, valueToSend);
    }

    public  boolean isCitySearchContained(String textToSend){
        return isTextSearchContained(textToSend, LocationsPageUI.CITY_COLUMN_DATA);
    }

    public void selectCountry(String textToSearch) {
        selectItemInCustomDropdown(driver, LocationsPageUI.COUNTRY_DROPDOWN,LocationsPageUI.COUNTRY_VALUES, textToSearch);
    }

    public boolean isCountrySearchContained(String countryToSearch) {
        return isTextSearchContained(countryToSearch, LocationsPageUI.COUNTRY_COLUMN_DATA);
    }

    public void clickToAddBtn() {
        waitForElementClickable(driver, LocationsPageUI.ADD_BTN);
        clickToElement(driver, LocationsPageUI.ADD_BTN);
    }

    public void addName(String name) {
        waitForElementClickable(driver, LocationsPageUI.ADD_NAME);
        sendkeyToElement(driver, LocationsPageUI.ADD_NAME, name);
    }

    public void addCity(String city) {
        waitForElementClickable(driver, LocationsPageUI.ADD_CITY);
        sendkeyToElement(driver, LocationsPageUI.ADD_CITY, city);
    }

    public void addCountry(String country) {
        selectItemInCustomDropdown(driver,LocationsPageUI.ADD_COUNTRY_LIST, LocationsPageUI.COUNTRY_VALUES, country);
    }

    public void clickToSaveBtn() {
        waitForElementClickable(driver, LocationsPageUI.SAVE_BTN);
        clickToElement(driver, LocationsPageUI.SAVE_BTN);
    }

    public String getMainSuccessMessage() {
        waitForElementVisible(driver, LocationsPageUI.SUCCESS_TOAST);
        waitForElementVisible(driver, LocationsPageUI.SUCCESS_MAIN_TOAST);
        return getElementText(driver, LocationsPageUI.SUCCESS_MAIN_TOAST);
    }

    public String getSubSuccessMessage(){
        waitForElementVisible(driver, LocationsPageUI.SUCCESS_SUB_TOAST);
        return getElementText(driver, LocationsPageUI.SUCCESS_SUB_TOAST);
    }

    public void clickToEditBtn(String name) {
        waitForElementClickable(driver, getDynamicLocator(LocationsPageUI.EDIT_ICON, name));
        clickToElement(driver, getDynamicLocator(LocationsPageUI.EDIT_ICON, name));

    }

    public String getEditTitle() {
        waitForElementVisible(driver, LocationsPageUI.EDIT_LOCATION_TITLE);
        return getElementText(driver, LocationsPageUI.EDIT_LOCATION_TITLE);
    }

    public void changeName(String updatedName) {
        waitForStableInputValue(driver, LocationsPageUI.ADD_NAME);
        waitForElementClickable(driver, LocationsPageUI.ADD_NAME);
        sendkeyToElement(driver, LocationsPageUI.ADD_NAME,updatedName);
    }

    public void changeCity(String updatedCity) {
        waitForStableInputValue(driver, LocationsPageUI.ADD_CITY);
        waitForElementClickable(driver, LocationsPageUI.ADD_CITY);
        sendkeyToElement(driver, LocationsPageUI.ADD_CITY,updatedCity);
    }

    public void selectOtherCountry(String updatedCountry) {
        selectItemInCustomDropdown(driver,LocationsPageUI.ADD_COUNTRY_LIST, LocationsPageUI.COUNTRY_VALUES, updatedCountry);
    }

    public boolean isDisplayedNoResultText() {
        return isElementDisplayed(driver, LocationsPageUI.NO_RESULTS_TEXT);
    }

    public void clickToDeleteIcon(String name) {
        waitForElementClickable(driver, getDynamicLocator(LocationsPageUI.DELETE_ICON, name));
        clickToElement(driver, getDynamicLocator(LocationsPageUI.DELETE_ICON, name));
    }

    public void clickYesToDelete() {
        waitForElementClickable(driver, LocationsPageUI.YES_DELETE_BTN);
        clickToElement(driver, LocationsPageUI.YES_DELETE_BTN);
    }

    public void checkOnCheckbox(String locationName){
        waitForElementClickable(driver,getDynamicLocator(LocationsPageUI.SINGLE_CHECKBOX, locationName));
        clickToElement(driver,getDynamicLocator(LocationsPageUI.SINGLE_CHECKBOX, locationName));
    }

    public void clickToDeleteBtn() {
        waitForElementClickable(driver, LocationsPageUI.DELETE_BTN);
        clickToElement(driver, LocationsPageUI.DELETE_BTN);
    }
}
