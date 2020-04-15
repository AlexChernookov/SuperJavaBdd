package home;

import helpers.CommWebElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends CommWebElementHelper {

    @FindBy(xpath = "//button[contains(@class, 'header-search-toggle')]")
    WebElement seachIconBtn;

    @FindBy(name = "querystring")
    WebElement searchTextBox;

    @FindBy(xpath = "//button[contains(@class, 'header-search-submit')]")
    WebElement seachBtn;

    @FindBy(xpath = "//button[contains(@class,'allowAllCookies')]")
    WebElement agreeToAllBtn;

    By agreeToAll = By.xpath("//button[contains(@class,'allowAllCookies')]");

    @FindBy(xpath = "//li[contains(@class,'language-wrapper')]/a[@lang='de']")
    WebElement deIcon;

    @FindBy(xpath = "//li[contains(@class,'language-wrapper')]/a[@lang='en']")
    WebElement enIcon;

    By aboutUsDe = By.xpath("//span[@class='catNav__label']/a[contains(.,'Wir über uns')]");

    By aboutUsEng = By.xpath("//span[@class='catNav__label']/a[contains(.,'About us')]");

    By priFrame = By.className("cboxIframe");

    @FindBy(className = "cboxIframe")
    WebElement privacyFrame;
}