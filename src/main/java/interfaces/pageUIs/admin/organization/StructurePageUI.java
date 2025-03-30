package interfaces.pageUIs.admin.organization;

public class StructurePageUI {
    public static final String ADMIN_SECTION = "//span[text()='Admin']";
    public static final String ORGANIZATION_ITEM = "//span[text()='Organization ']";
    public static final String STRUCTURE_ITEM = "//a[@class='oxd-topbar-body-nav-tab-link' and text()='Structure']";
    public static final String MAIN_TITLE = "//h6[text()='Organization Structure']";
    public static final String EDIT_TOGGLE = "//div[@class='oxd-switch-wrapper']";
    public static final String ADD_BTN = "//button[contains(@class, 'org-structure-add')]";
    public static final String ADD_ORG_DIALOG = "//div[@role='document']";
    public static final String INPUT_UNIT_ID = "//label[text()='Unit Id']/following::input[1]";
    public static final String INPUT_NAME = "//label[text()='Name']/following::input[1]";
    public static final String INPUT_DESCRIPTION = "//label[text()='Name']/following::textarea";
    public static final String SAVE_BTN = "//button[@type='submit']";
    public static final String SUCCESS_TOAST = "//div[@class='oxd-toast-start']";
    public static final String SUCCESS_MAIN_TOAST = "//div[@class='oxd-toast-start']/div/p[1]";
    public static final String SUCCESS_SUB_TOAST = "//div[@class='oxd-toast-start']/div/p[2]";

    //public static final String TREE_NODES = "div.oxd-tree-node-content div.org-structure-card";
    public static final String EDIT_ORG_DIALOG = "//div[@class='orangehrm-modal-header']/p[text()='Edit Organization Unit']";
    public static final String UNIT = "//div[@class='org-name' and text()='%s']";
    public static final String EDIT_ICON = "//div[@class='org-name' and text()='%s']//parent::div//i[@class='oxd-icon bi-pencil-fill']";
    public static final String DELETE_ICON = "//div[@class='org-name' and text()='%s']//parent::div//i[@class='oxd-icon bi-trash-fill']";
    public static final String PLUS_ICON = "//div[@class='org-name' and text()='%s']//parent::div//i[@class='oxd-icon bi-plus']";
    public static final String EXTEND_ICON = "//div[@class='org-name' and text()='%s']/ancestor::div[contains(@class, 'oxd-tree-node-wrapper')]/span/button";
    public static final String YES_BTN = "//button[text()=' Yes, Delete ']";
    public static final String ERROR_REQUIRED_NAME = "//span[contains(@class, 'oxd-input-field-error-message')]";

}
