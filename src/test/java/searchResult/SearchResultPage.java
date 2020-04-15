package searchResult;

import helpers.CommWebElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends CommWebElementHelper {
    @FindBy(xpath = "//p[contains(@class,'alert-warning')]")
    WebElement waringMessage;

    @FindBy(id = "pagesearchfield")
    WebElement searchTxtBox;

    @FindBy(xpath = "//span[contains(@class, 'actionbutton__search')]/..")
    WebElement searchBtn;

    @FindBy(className = "searchresults__messagetxt")
    WebElement noResult;

    By loadingSpinner = By.className("loading__spinner--big");

    @FindBy(xpath = "//li[contains(@class, 'categoryswitch__item--active')]//span[@class='categoryswitch__total']")
    WebElement allCount;

    @FindBy(xpath = "//li[@class='categoryswitch__item']//span[@class='categoryswitch__total']")
    WebElement newsCount;

    @FindBy(className = "searchresults__itemWrapper")
    List<WebElement> searchResultOnPage;

}