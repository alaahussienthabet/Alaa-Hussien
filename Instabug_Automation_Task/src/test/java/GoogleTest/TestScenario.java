package GoogleTest;

import Moduls.FilesReaders.ExcelFileReader;
import Pages.LandingPage;
import UI.UiActions;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.util.concurrent.TimeUnit;

/**
 * test scenario to validate the search function
 */
public class TestScenario extends BaseClass {

    LandingPage landingPage = new LandingPage(); //Instantiation of LandPage object

    /**
     * <p> Test Scenario </p>
     * <p> Step.1) Open Url </p>
     * <p> Step.2) Type Keyword "instaBug" to search for </p>
     * <p> Step.3) Validate if the first result contains keyword "instaBug" </p>
     * <p> Step.4) Close the browser window </p>
     */
    @Attachment(value = "Screenshot", type = "image/png")
    @Test
    public void test_SearchForInstabugAndAssertOnSearchResults() {


        landingPage.enterkeywordToSearch(getDataFromExcel()); //enter Keyword to search for;
        Allure.addAttachment("Page Screenshot",
                new ByteArrayInputStream(((TakesScreenshot) UiActions.driver).getScreenshotAs(OutputType.BYTES)));


        Assert.assertTrue(landingPage.assertTheSearchKeywordIsDisplayed());
    }

    /**
     * to get test data from excel file (external file )
     *
     * @return test data of test
     */
    public String getDataFromExcel() {
        String keyword = ExcelFileReader.excelReader("src\\test\\resources\\DataDriven\\testdata.xlsx")[0][0];
        return keyword;

    }
}


