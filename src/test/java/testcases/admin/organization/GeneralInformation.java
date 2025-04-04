package testcases.admin.organization;
import actions.commons.BaseTest;
import io.qameta.allure.*;
import org.testng.annotations.*;
import actions.pageObject.admin.organization.GeneralInforPageObject;
import actions.reportConfig.AllureReportListener;

@Listeners(AllureReportListener.class)
@Epic("Check General Information")
@Feature("Check demo Feature Report")
public class GeneralInformation extends BaseTest { //use all funcs in BaseTest
    //Define
    GeneralInforPageObject generalInforPage;
    String updatedName, phone, email, country;

    @BeforeClass(alwaysRun = true)
    @Description("Open Generate Information Page")
    public void beforeClass(){
        updatedName =  "Huyen Checked"+getRandomNumber();
        phone = "0934653"+getRandomNumber();
        email = "check"+getRandomNumber()+"@gmail.com";
        country = "Antigua and Barbuda";
        generalInforPage = new GeneralInforPageObject(driver);
        generalInforPage.clickToAdminSection();
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
