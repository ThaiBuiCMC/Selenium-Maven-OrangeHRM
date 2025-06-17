package interfaces.pageUIs.admin.qualification;

public class LanguagePageUI {
    public static final String SAVE_BUTTON = "//button[@type='submit']";
    public static final String LANGUAGE_INPUT = "//label[text()='Name']//ancestor::div[@class='oxd-form-row']//descendant::input";
    public static final String ADD_BUTTON = "//button[normalize-space()='Add']";
    public static final String ADD_MAIN_TITLE = "//h6[contains(@class,'orangehrm-main-title') and text() = 'Add Language']";
    public static final String MAIN_TITLE = "//h6[contains(@class,'orangehrm-main-title') and text() = 'Languages']";
    public static final String LANGUAGE_MENU = "//a[text()='Languages']";
    public static final String QUALIFICATION_MENU = "//span[normalize-space()='Qualifications']";
    public static final String ADMIN_MENU = "//span[text()='Admin']";
    public static final String ERROR_MESSAGE = "//span[contains(@class,'oxd-input-field-error-message')]";
    public static final String NEW_LANGUAGE = "//div[text()='%s']";
}
