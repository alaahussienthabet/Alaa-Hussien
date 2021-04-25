package GoogleTest;

import Moduls.FilesReaders.ExcelFileReader;
import Pages.LandingPage;
import Pages.SecondResultPage;
import Pages.ThirdResultPage;
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
    ThirdResultPage thirdResultPage = new ThirdResultPage(); //Instantiation of thirdPage object
    SecondResultPage secondResultPage = new SecondResultPage(); //Instantiation of SecondPage object

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


        landingPage.enterkeywordToSearch(getDataFromExcel()[0][0]); //enter Keyword to search for;
        Allure.addAttachment("Page Screenshot",
                new ByteArrayInputStream(((TakesScreenshot) UiActions.driver).getScreenshotAs(OutputType.BYTES)));


        Assert.assertTrue(landingPage.assertTheSearchKeywordIsDisplayed());
    }
    

    /**
     * <p> Test Scenario </p>
     * <p> Step.1) Open Url </p>
     * <p> Step.2) Type Keyword "instaBug" to search for </p>
     * <p> Step.3) Scroll down  </p>
     * <p> Step.4) Click on next button </p>
     * <p> Step.5) Scroll down  </p>
     * <p> Step.6) Click on next button </p>
     * <p> Step.7) Validate if the number of results in page 2 equal to page 3 equal 10 or not" </p>
     * <p> Step.4) Close the browser window </p>
     */
    @Attachment(value = "Screenshot", type = "image/png")
    @Test
    public void test_SearchForInstabugAndAssertOnSearchResultsNumber() {

        landingPage.enterkeywordToSearch(getDataFromExcel()[0][0]); //enter Keyword to search for;
        landingPage.scrollDownFirst_Page();
        landingPage.clickOnNextButtonFirst_Page();
        int countSecondPage = secondResultPage.countNumberOfResultsInSecond_Page(); //Count number of results displayed
        secondResultPage.scrollDownSecond_Page();
        secondResultPage.clickOnNextButtonSecondPage();
        int countThirdPage = thirdResultPage.countNumberOfResultsInThird_Page();
        Allure.addAttachment("Page Screenshot",
                new ByteArrayInputStream(((TakesScreenshot) UiActions.driver).getScreenshotAs(OutputType.BYTES)));


        Assert.assertEquals(countSecondPage, countThirdPage,10, "Result Number didn't match"); //Validate if the number of results in page 2 equal to page 3 equal 10 or not    }
    }
    /**
     * <p> Test Scenario </p>
     * <p> Step.1) Open Url </p>
     * <p> Step.2) Type Keyword "instaBug logo" to search for </p>
     * <p> Step.3) Validate if the first result contains image related to the search keyword "instaBug logo" </p>
     * <p> Step.4) Close the browser window </p>
     */
    @Attachment(value = "Screenshot", type = "image/png")
    @Test
    public void test_SearchForInstabugLogoAndAssertOnSearchResultsPhoto() {

        landingPage.enterkeywordToSearch(getDataFromExcel()[0][1]); //enter Keyword to search for;

        Allure.addAttachment("Page Screenshot",
                new ByteArrayInputStream(((TakesScreenshot) UiActions.driver).getScreenshotAs(OutputType.BYTES)));



        Assert.assertTrue(landingPage.assertTheSearchImageIsDisplayed());
    }

    /**
     * to get test data from excel file (external file )
     *
     * @return test data of test
     */
         String [][] getDataFromExcel() {
        String data [][]=ExcelFileReader.excelReader("src\\test\\resources\\DataDriven\\testdata.xlsx");
        return data;
    }
}


