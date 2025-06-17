package testcases.admin.qualification;

import actions.commons.BaseTest;
import actions.commons.DataProviderFactory;
import actions.pageObject.admin.qualification.LanguagePageObject;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Language extends BaseTest {
    LanguagePageObject languagePageObject;

    @BeforeClass(alwaysRun = true)
    @Description("Open Admin Page")
    public void beforeClass(ITestContext context) {
        //driver = (WebDriver) context.getAttribute("WebDriver"); // get driver from Context
        WebDriver driver = getDriver();
        languagePageObject = new LanguagePageObject(driver);
        languagePageObject.clickToAdminSection();
    }
    @BeforeMethod(alwaysRun = true)
    @Description("For independent Testcases")
    public void beforeTestcases(){
            languagePageObject.clickToQualification();
            languagePageObject.clickToLanguageOption();
    }
    @Test
    @Step("LG_01_CheckUI")
    public void LG_01_CheckUI(){
        verifyTrue(languagePageObject.isMainTitleDisplayed());
    }
    @Test(dataProvider = "Validate input 1 Language", dataProviderClass = DataProviderFactory.class)
    @Step("LG_02_CheckValidation_AddNew")
    public void LG_02_CheckValidation(String language){
        languagePageObject.clickToAddBtn();
        languagePageObject.enterNewLanguage(language);
        languagePageObject.clickToSaveBtn();
        //Verify
        verifyEquals(languagePageObject.getMainSuccessMessage(),"Success");
        verifyEquals(languagePageObject.getSubSuccessMessage(),"Successfully Saved");
        verifyTrue(languagePageObject.isMainTitleDisplayed());
        verifyTrue(languagePageObject.isNewLanguageDisplayed(language));
        //Verify DB
        //languagePageObject.isLanguageExist(language);
        //Clear data test
        //languagePageObject.deleteLanguageByName(language);
    }
    @Test(dataProvider = "Validate input 1 Language - SwitchCase", dataProviderClass = DataProviderFactory.class, groups = "runnow")
    @Step("LG_03b_CheckValidation_AddNew_LeaveBlank_SwitchCase")
    public void LG_03a_CheckValidation_AddNew_SwitchCase(String language){
        languagePageObject.clickToAddBtn();
        languagePageObject.enterNewLanguage(language);
        languagePageObject.clickToSaveBtn();
        //Verify
        verifyEquals(languagePageObject.getMainSuccessMessage(),"Success");
        verifyEquals(languagePageObject.getSubSuccessMessage(),"Successfully Saved");
        verifyTrue(languagePageObject.isMainTitleDisplayed());
        verifyTrue(languagePageObject.isNewLanguageDisplayed(language));
    }
    @Test(dataProvider = "Validate input 1 Language - SwitchCase", dataProviderClass = DataProviderFactory.class, groups = "runnow")
    @Step("LG_03b_CheckValidation_AddNew_LeaveBlank_SwitchCase")
    public void LG_03b_CheckValidation_AddNew_LeaveBlank_SwitchCase(String language){
        languagePageObject.clickToAddBtn();
        languagePageObject.enterNewLanguage(language);
        languagePageObject.clickToSaveBtn();
        //Verify
        verifyEquals(languagePageObject.getErrorMessage(),"Required");
    }
//    @Test()
//    @Step("LG_02_Employee_CheckValidation_ExcelFile")
//    public void LG_02_Employee_CheckValidation_ExcelFile(){
//
//    }
//    @Test()
//    @Step("LG_02_Employee_CheckValidation_ExcelFile_HashTable")
//    public void LG_02_Employee_CheckValidation_ExcelFile_HashTable(){
//
//    }
}
