package tests;

import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.annotation.ScenarioStage;
import com.tngtech.jgiven.junit.SimpleScenarioTest;
import helpers.BrowserFactory;
import home.HomeStage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import searchResult.SearchResultStage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HomePageTest extends SimpleScenarioTest<HomeStage> {
    @ProvidedScenarioState
    static WebDriver webDriver;

    @ScenarioStage
    SearchResultStage searchResult;

    @BeforeClass
    public static void createWebDriver() {
        webDriver = BrowserFactory.getDriver();
    }

    @AfterClass
    public static void closeWebDriver() {
        webDriver.quit();
    }

    @Test
    public void check_change_language_to_german(){
        given().open_home_page();
        when().click_de_icon();
        then().check_language_has_changed_to_german();
    }
}