package tests;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.jgiven.annotation.CaseAs;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.junit.ScenarioTest;
import helpers.BrowserFactory;
import helpers.Utils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import searchResult.SearchResultStage;

@RunWith( DataProviderRunner.class )
public class SearchTests extends ScenarioTest<SearchResultStage, SearchResultStage, SearchResultStage> {
    @ProvidedScenarioState
    static WebDriver webDriver;

    @BeforeClass
    public static void createWebDriver() {
        webDriver = BrowserFactory.getDriver();
    }

    @AfterClass
    public static void closeWebDriver() {
        webDriver.quit();
    }

    @Test
    @DataProvider({
            "Australia",
            "United Kingdom",
            "USA"
    })
    @CaseAs("$1")
    public void search_by_existing_keyword(String search){
        given().open_search_page();
        when().perform_search(search);
        then().check_search_results(search);
    }

    @Test
    public void search_by_not_existing_keyword(){
        String someNotExisting = Utils.randomString(22);
        given().open_search_page();
        when().perform_search(someNotExisting);
        then().check_no_result_found(someNotExisting);
    }
}
