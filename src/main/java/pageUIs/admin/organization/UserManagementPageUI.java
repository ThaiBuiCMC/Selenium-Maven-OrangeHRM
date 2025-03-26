package interfaces.pageUIs.admin.organization;

public class UserManagementPageUI {
    public static final String ADMIN_SECTION = "//span[text()='Admin']";
    public static final String ADD_BUTTON = "//button[normalize-space()='Add']";
    public static final String LOGIN_BUTTON = "//button[@type='submit']";
    public static final String USER_MANAGEMENT = "//span[normalize-space()='User Management']";
    public static final String RESET_BUTTON = "//button[normalize-space()='Reset']";
    public static final String SEARCH_BUTTON = "//button[@type='submit']";

    // User Creation Elements
    public static final String USER_ROLE_DROPDOWN = "//label[text()='User Role']//ancestor::div[contains(@class,'oxd-grid-item--gutters')]//descendant::div[@class='oxd-select-wrapper']";
    public static final String STATUS_DROPDOWN = "//label[text()='Status']//ancestor::div[contains(@class,'oxd-grid-item--gutters')]//descendant::div[@class='oxd-select-wrapper']";
    public static final String EMPLOYEE_NAME_INPUT = "//input[@placeholder='Type for hints...']";
    public static final String USERNAME_INPUT = "//div[contains(@class,'user-password-cell')]//descendant::input[@type='password']";
    public static final String PASSWORD_INPUT = "//div[contains(@class,'user-password-cell')]//descendant::input[@type='password']";
    public static final String CONFIRM_PASSWORD_INPUT = "//label[normalize-space()='Confirm Password']//ancestor::div[@class='oxd-grid-item oxd-grid-item--gutters']//descendant::input[@type='password']";

    // Status Options
    public static final String STATUS_ENABLED = "Enabled";

    // Page Titles and Labels
    public static final String SYSTEM_USERS_TITLE = "//h5[text()='System Users']";
    public static final String USERNAME_LABEL = "//label[text()='Username']";
    public static final String USER_ROLE_LABEL = "//label[text()='User Role']";
    public static final String EMPLOYEE_NAME_LABEL = "//label[text()='Employee Name']";
    public static final String STATUS_LABEL = "//label[text()='Status']";

    // Table Columns
    public static final String USERNAME_COLUMN = "//div[text()='Username']";
    public static final String USER_ROLE_COLUMN = "//div[text()='User Role']";
    public static final String EMPLOYEE_NAME_COLUMN = "//div[text()='Employee Name']";
    public static final String STATUS_COLUMN = "//div[text()='Status']";
    public static final String ACTION_COLUMN = "//div[text()='Actions']";
    // Result and Action Elements
    public static final String USER_RESULT_ROW = "//div[@class='oxd-table-row oxd-table-row--with-border']//parent::div[@class='oxd-table-card']";
    public static final String SUCCESS_TOAST = "//div[@class='oxd-toast-container oxd-toast-container--bottom']//p[text()='Success']";
    public static final String CREDENTIAL_WARNING = "//p[text()='Credential Required']";

    // Dynamic Locators
    public static String getUpdatedAccountLocator(String updateText) {
        return String.format("//div[text()='%s']", updateText);
    }

    public static String getEditIconLocator(String text) {
        return String.format("//div[text()='%s']//ancestor::div[@role='row']//descendant::i[@class='oxd-icon bi-pencil-fill']", text);
    }

    public static String getDeleteIconLocator(String text) {
        return String.format("//div[text()='%s']//ancestor::div[@role='row']//descendant::i[@class='oxd-icon bi-trash']", text);
    }

    public static String getValidationMessageLocator(String validation) {
        return String.format("//label[text()='%s']//ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//descendant::span", validation);
    }
}
