package interfaces.pageUIs.admin.organization;

public class LocationsPageUI {
    public static final String ADMIN_SECTION = "//span[text()='Admin']";
    public static final String ORGANIZATION_ITEM = "//span[text()='Organization ']";
    public static final String LOCATIONS_ITEM = "//a[text()='Locations']";
    public static final String LOCATIONS_LABEL = "//h5[text()='Locations']";
    public static final String NAME_INPUT = "//label[text()='Name']//parent::div//following-sibling::div/input";
    public static final String CITY_INPUT = "//label[text()='City']//parent::div//following-sibling::div/input";
    public static final String COUNTRY_DROPDOWN = "//div[@class='oxd-select-text oxd-select-text--active']";
    public static final String COUNTRY_VALUES = "//div[@role='option']/span";
    public static final String SEARCH_BTN = "//button[@type='submit']";
    public static final String NO_RESULTS_TEXT = "//span[text()='No Records Found']";
    public static final String NAME_COLUMN_DATA = "//div[@class='oxd-table-card']//div[2]/div";
    public static final String CITY_COLUMN_DATA = "//div[@class='oxd-table-card']//div[3]/div";
    public static final String COUNTRY_COLUMN_DATA = "//div[@class='oxd-table-card']//div[4]/div";
    public static final String ADD_BTN = "//div[@class='orangehrm-header-container']//button[@type='button']";
    public static final String ADD_NAME = "//label[text()='Name']//parent::div/following-sibling::div/input";
    public static final String ADD_CITY = "//label[text()='City']//parent::div/following-sibling::div/input";
    public static final String ADD_COUNTRY_LIST = "//div[@class='oxd-select-text-input']";
    public static final String SAVE_BTN = "//button[@type='submit']";
    public static final String SUCCESS_TOAST = "//div[@class='oxd-toast-start']";
    public static final String SUCCESS_MAIN_TOAST = "//div[@class='oxd-toast-start']/div/p[1]";
    public static final String SUCCESS_SUB_TOAST = "//div[@class='oxd-toast-start']/div/p[2]";
    public static final String EDIT_ICON = "//div[text()='%s']//ancestor::div[@class='oxd-table-card']//i[@class='oxd-icon bi-pencil-fill']";
    public static final String EDIT_LOCATION_TITLE = "//h6[text()='Edit Location']";
    public static final String DELETE_ICON = "//div[text()='%s']//ancestor::div[@class='oxd-table-card']//i[@class='oxd-icon bi-trash']";
    public static final String YES_DELETE_BTN = "//button[text()=' Yes, Delete ']";
    public static final String SINGLE_CHECKBOX = "//div[text()='%s']//ancestor::div[@role='row']//div[@class='oxd-table-card-cell-checkbox']";
    public static final String DELETE_BTN = "//button[text()=' Delete Selected ']";
}
