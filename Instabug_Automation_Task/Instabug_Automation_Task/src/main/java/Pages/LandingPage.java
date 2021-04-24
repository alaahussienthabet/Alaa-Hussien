package Pages;

import UI.UiActions;
import org.openqa.selenium.By;

/**
 * navigate in google landing page and search about specific keyword in google search bar
 */
public class LandingPage {


    UiActions action = new UiActions();


    By searchBar = By.cssSelector("input[name='q']");
    By assertionValue = By.xpath("//a[@href='https://instabug.com/']");


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
     * to make true or false assertion about specific value
     * @return
     */
    public boolean assertTheSearchKeywordIsDisplayed() {
        return action.assertTrue(assertionValue);
    }


}
