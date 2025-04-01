package testcases.admin.job;


import actions.commons.BaseTest;
import actions.pageObject.admin.job.JobTitlesPageObject;
import actions.reportConfig.AllureReportListener;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;

import static actions.commons.GlobalConstants.uploadFolderPath;

@Listeners(AllureReportListener.class)
@Epic("Check Job Titles")
@Feature("Check demo Feature Job Titles")
public class JobTitles extends BaseTest {
    JobTitlesPageObject jobTitlesPage;
    String name, des, note, name2;
    String specFileName = "8888.png";
    String specFilePath = uploadFolderPath + specFileName;

    @BeforeClass(alwaysRun = true)
    @Description("Open Job Titles Page")
    public void beforeClass() {
        jobTitlesPage = new JobTitlesPageObject(driver);
        jobTitlesPage.clickToAdminMenu();
    }

    @BeforeMethod(alwaysRun = true)
    @Description("For independent Testcases")
    public void beforeTestcases(){
        jobTitlesPage.clickToJobMenu();
        jobTitlesPage.clickToJobTitlesMenu();
    }
    @Test
    public void JT_01_CheckUI() {
        verifyEquals(jobTitlesPage.getJobTitlesLabel(),"Job Titles");
        verifyTrue(jobTitlesPage.isAddBtnDisplayed());
    }

    @Test
    public void JT_02_User_Create_New_Job_Title() {
        name = generateRandomName();
        des = generateRandomName() + " check Des";
        note = generateRandomName() + " check Note";
        jobTitlesPage.clickToAddJobTitleButton();
        verifyEquals(jobTitlesPage.getAddJobTitlesLabel(), "Add Job Title");
        jobTitlesPage.enterName(name);
        jobTitlesPage.enterJobDescription(des);
        jobTitlesPage.uploadJobSpecification(specFilePath);
        jobTitlesPage.enterNote(note);
        jobTitlesPage.clickToSaveJobTitleButton();
        //Verify
        verifyEquals(jobTitlesPage.getMainSuccessMessage(),"Success");
        verifyEquals(jobTitlesPage.getSubSuccessMessage(),"Successfully Saved");
        verifyEquals(jobTitlesPage.getJobTitlesLabel(),"Job Titles");
        verifyTrue(jobTitlesPage.isJobTitleDisplayed(name));
        verifyTrue(jobTitlesPage.isJobDescriptionDisplayed(des));
    }

    @Test
    public void JT_03_User_Update_Job_Title() {
        name = generateRandomName();
        des = generateRandomName() + " check Update";
        name2 = name + "Updated";
        jobTitlesPage.clickToAddJobTitleButton();
        jobTitlesPage.enterName(name);
        jobTitlesPage.clickToSaveJobTitleButton();
        verifyTrue(jobTitlesPage.isJobTitleDisplayed(name));

        // Edit
        jobTitlesPage.clickToEditJobTitle(name);
        jobTitlesPage.enterName(name2);
        jobTitlesPage.enterJobDescription(des);
        jobTitlesPage.clickToSaveJobTitleButton();
        //Verify
        verifyEquals(jobTitlesPage.getMainSuccessMessage(),"Success");
        verifyEquals(jobTitlesPage.getSubSuccessMessage(),"Successfully Updated");
        verifyEquals(jobTitlesPage.getJobTitlesLabel(),"Job Titles");
        verifyTrue(jobTitlesPage.isJobTitleDisplayed(name2));
        verifyTrue(jobTitlesPage.isJobDescriptionDisplayed(des));
    }

    @Test
    public void JT_04_User_Delete_Job_Title() {
        //Create
        name = generateRandomName();
        jobTitlesPage.clickToAddJobTitleButton();
        jobTitlesPage.enterName(name);
        jobTitlesPage.clickToSaveJobTitleButton();
        verifyTrue(jobTitlesPage.isJobTitleDisplayed(name));
        //Delete
        jobTitlesPage.clickToDeleteJobTitle(name);
        jobTitlesPage.confirmDelete();
        //Verify
        verifyEquals(jobTitlesPage.getMainSuccessMessage(),"Success");
        verifyEquals(jobTitlesPage.getSubSuccessMessage(),"Successfully Deleted");
        verifyFalse(jobTitlesPage.isJobTitleDisplayed(name));
    }

    @Test(groups = "runnow")
    public void JT_05_User_Delete_Multiple_Job_Titles() {
        //Create data
        name = generateRandomName();
        jobTitlesPage.clickToAddJobTitleButton();
        jobTitlesPage.enterName(name);
        jobTitlesPage.clickToSaveJobTitleButton();
        verifyTrue(jobTitlesPage.isJobTitleDisplayed(name));

        name2 = generateRandomName();
        jobTitlesPage.clickToAddJobTitleButton();
        jobTitlesPage.enterName(name2);
        jobTitlesPage.clickToSaveJobTitleButton();
        verifyTrue(jobTitlesPage.isJobTitleDisplayed(name2));

        //Checked
        jobTitlesPage.selectOnCheckbox(name);
        jobTitlesPage.selectOnCheckbox(name2);
        jobTitlesPage.clickToDeleteSelectedButton();
        jobTitlesPage.confirmDelete();

        //Verify
        verifyFalse(jobTitlesPage.isJobTitleDisplayed(name));
        verifyFalse(jobTitlesPage.isJobTitleDisplayed(name2));
    }
    
}
