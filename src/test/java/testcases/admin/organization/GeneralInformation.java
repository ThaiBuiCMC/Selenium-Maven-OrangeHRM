package testcases.admin.organization;
import actions.commons.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import actions.pageObject.admin.organization.GeneralInforPageObject;
import actions.reportConfig.AllureReportListener;

@Listeners(AllureReportListener.class)
@Epic("Check General Information")
@Feature("Check demo Feature Report")
public class GeneralInformation extends BaseTest { //use all funcs in BaseTest
    //Define
    GeneralInforPageObject generalInforPage;
    String updatedName =  "Huyen Checked"+getRandomNumber();
    String phone = "0934653"+getRandomNumber();
    String email = "check"+getRandomNumber()+"@gmail.com";
    String country = "Antigua and Barbuda";

    @BeforeClass(alwaysRun = true)
    @Description("Open Generate Information Page")
    public void beforeClass(ITestContext context){
        //driver = (WebDriver) context.getAttribute("WebDriver"); // get driver from Context
        WebDriver driver = getDriver();
        generalInforPage = new GeneralInforPageObject(driver);
        generalInforPage.clickToAdminSection();
    }
    @BeforeMethod(alwaysRun = true)
    @Description("For independent Testcases")
    public void beforeTestcases(){
        generalInforPage.clickToOrganization();
        generalInforPage.clickToGenerateInformationOption();
    }
    @Test
    @Step("Check UI")//mandtory for report
    public void GI_01_CheckUI(){
        verifyTrue(generalInforPage.checkTitleDisplayed());
        verifyTrue(generalInforPage.checkEditToggleDisplayed());
        verifyTrue(generalInforPage.checkNumberOfEmployeeDisplayed());
        //verifyEquals(generalInforPage.getSuccessMessage(),"Successfully Updated"); //- For testing failed
    }
    @Test
    @Step("Edit General Information")
    @Severity(SeverityLevel.TRIVIAL)
    public void GI_01_EditGeneralInformation() {
        generalInforPage.clickToEditToggle();
        generalInforPage.enterOrganizationNameTextbox(updatedName);
        generalInforPage.enterPhoneTextbox(phone);
        generalInforPage.enterEmailTextbox(email);
        generalInforPage.changeCountryDropdown(country);
        generalInforPage.clickTosaveEditedData();
        verifyEquals(generalInforPage.getSuccessMessage(),"Successfully Updated");
        verifyEquals(generalInforPage.getUpdatedOrganizationName(),updatedName);
        verifyEquals(generalInforPage.getUpdatedPhone(),phone);
        verifyEquals(generalInforPage.getUpdatedEmail(),email);
        verifyEquals(generalInforPage.getUpdatedCountry(),country);
    }
}
