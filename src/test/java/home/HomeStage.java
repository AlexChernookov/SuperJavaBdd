package home;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HomeStage extends Stage<HomeStage> {
    private final static String baseURL = "https://www.ubs.com/";

    @ExpectedScenarioState(required = true)
    private WebDriver wd;

    private HomePage home;

    @BeforeStage
    void setup() {
        home = PageFactory.initElements(wd, HomePage.class);
    }

    public HomeStage open_home_page() {
        wd.navigate().to(baseURL);
        home.waitPageToLoad(wd);
        if(home.isElementDisplayed(wd, home.priFrame)){
            wd.switchTo().frame(home.privacyFrame);
            home.agreeToAllBtn.click();
            wd.switchTo().defaultContent();
        }
        return this;
    }

    @As("Click 'DE' icon")
    public HomeStage click_de_icon() {
        home.deIcon.click();
        home.waitPageToLoad(wd);
        return this;
    }

    @As("Check language switched to German")
    public HomeStage check_language_has_changed_to_german() {
        assertThat(wd.getCurrentUrl()).as("Current url").contains("de.html");
        assertThat(home.enIcon.isDisplayed()).as("EN icon").isTrue();
        assertThat(home.isElementDisplayed(wd, home.aboutUsDe)).as("About us in German").isTrue();
        assertThat(home.isElementDisplayed(wd, home.aboutUsEng)).as("About us in English").isFalse();
        return this;
    }

    public HomeStage navigate_to_search_page() {
        home.seachIconBtn.click();
        home.waitForElementToBePresent(wd, home.searchTextBox);
        home.seachBtn.click();
        home.waitPageToLoad(wd);
        return this;
    }
}