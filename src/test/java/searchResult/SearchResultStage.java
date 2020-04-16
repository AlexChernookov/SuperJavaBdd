package searchResult;

import com.tngtech.jgiven.CurrentStep;
import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.As;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ExpectedScenarioState;
import com.tngtech.jgiven.annotation.ScenarioState;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SearchResultStage extends Stage<SearchResultStage> {

    private static String searchUrl = "https://www.ubs.com/search/en.global.html";
    @ScenarioState
    private WebDriver wd;


    private SearchResultPage searchResult;

    @BeforeStage
    void setup() {
        searchResult = PageFactory.initElements(wd, SearchResultPage.class);
    }

    @As("Search by $")
    public SearchResultStage perform_search(String s){
        searchResult.searchTxtBox.clear();
        searchResult.searchTxtBox.sendKeys(s);
        searchResult.searchBtn.click();
        searchResult.waitPageToLoad(wd);
        searchResult.waitForElementsToDisappear(wd, searchResult.loadingSpinner);
        return this;
    }

    @As("Check $ is in search result")
    public SearchResultStage check_search_results(String s){
        searchResult.waitForElementToBePresent(wd, searchResult.searchResultOnPage.get(0));
        searchResult.searchResultOnPage.forEach( e -> assertThat(e.getText().toLowerCase()).contains(s.toLowerCase()));
        return this;
    }

    @As("Check No result was found for $")
    public SearchResultStage check_no_result_found(String s){
        searchResult.waitForElementToBePresent(wd, searchResult.noResult);
        assertThat(searchResult.noResult.getText()).contains("No results matched with \""+ s +"\"");
        return this;
    }

    public SearchResultStage open_search_page(){
        wd.navigate().to(searchUrl);
        return this;
    }
}