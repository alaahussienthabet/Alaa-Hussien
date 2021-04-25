package Pages;

import UI.UiActions;
import org.openqa.selenium.By;

/**
 * navigate in google landing page and search about specific keyword in google search bar
 */
public class LandingPage {


    UiActions action = new UiActions();


    private final By searchBar = By.cssSelector("input[name='q']");
    private final By assertionValue = By.xpath("//a[@href='https://instabug.com/']");

    private final By nextButtonLocator = By.xpath("//td//span[contains(.,'التالية')]");
    private final By imageAssertion = By.xpath("//img[@id='dimg_37']");


    /**
     * write searchKeyword to search in google search bar
     *
     * @param searchKeyword
     */
    public void enterkeywordToSearch(String searchKeyword) {


        action.waitFunction(searchBar, "waitVisibility");
        action.findElement(searchBar).sendKeyToElement(searchKeyword)
                .actionOnElement("enter");


    }
    /**
     * Scroll Down to Bottom of the page
     */

    public void scrollDownFirst_Page() {
        action.scrollDownToBottom();
    }

    /**
     * Wait for the element locator to be clickable
     * <p>Click On Next Button to navigate the next result page</p>
     */
    public void clickOnNextButtonFirst_Page() {
        action.waitFunction(nextButtonLocator, "waitClick");
        action.findElement(nextButtonLocator).actionOnElement("click");
    }

    /**
     * to make true or false assertion about specific value
     * @return
     */
    public boolean assertTheSearchKeywordIsDisplayed() {
        return action.assertTrue(assertionValue);
    }

    /**
     * to make true or false assertion about image value
     * @return
     */
    public boolean assertTheSearchImageIsDisplayed() {
        return action.assertTrue(imageAssertion);
    }
}
