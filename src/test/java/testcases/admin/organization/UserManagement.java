package testcases.admin.organization;

import actions.commons.BasePage;
import actions.commons.BaseTest;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;
import actions.pageObject.admin.organization.GeneralInforPageObject;
import actions.reportConfig.AllureReportListener;

@Listeners(AllureReportListener.class)
@Epic("Check demo Epic")
@Feature("Check demo Feature Report")
public class UserManagement extends BasePage {
    UserManagementPageObject userManagementPage;
    @BeforeClass
    @Description("Open User management Page")
    public void beforeClass(){

        userManagementPage = new UserManagementPageObject(driver);
        userManagementPage.clickToAdminSection();
        userManagementPage.clickToOrganization();
        userManagementPage.clickToGenerateInformationOption();
    }
    @Test
    @Step("Create new User")
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
