package Pages;

import UI.UiActions;
import org.openqa.selenium.By;

public class ThirdResultPage {

    UiActions action = new UiActions();

    private final By listResultLocator = By.xpath("//div[@id='rso']//div[@class='g']");

    /**
     * Get Number of Results in the page
     *
     * @return number of elements
     */
    public int countNumberOfResultsInThird_Page() {
        return action.findListOfElements(listResultLocator).getSizeOfElements();
    }
}
