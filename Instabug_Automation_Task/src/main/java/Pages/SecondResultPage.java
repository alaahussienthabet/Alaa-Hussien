package Pages;

import UI.UiActions;
import org.openqa.selenium.By;

public class SecondResultPage {

    UiActions action = new UiActions();


    private final By listResultLocator = By.xpath("//div[@id='rso']//div[@class='g']");
    private final By nextButtonLocator = By.xpath("//td//span[contains(.,'التالية')]");


    /**
     * Scroll Down to Bottom of the page
     */

    public void scrollDownSecond_Page() {
        action.scrollDownToBottom();
    }
    /**
     * Wait for the element locator to be clickable
     * <p>Click On Next Button to navigate the next result page</p>
     */
    public void clickOnNextButtonSecondPage() {
        action.waitFunction(nextButtonLocator, "waitClick");
        action.findElement(nextButtonLocator).actionOnElement("click");

    }

    /**
     * Get Number of Results in the page
     *
     * @return number of elements
     */
    public int countNumberOfResultsInSecond_Page() {
        return action.findListOfElements(listResultLocator).getSizeOfElements();
    }
}
