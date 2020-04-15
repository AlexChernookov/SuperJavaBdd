package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommWebElementHelper {

    private long _30_sec  = 30L;
    public void waitPageToLoad(WebDriver d) {
        new FluentWait(d).withTimeout(Duration.ofSeconds(_30_sec)).until(WdExpectedConditions.isPageLoaded());
    }

    public void selectByText(WebElement e, String txt){
        new Select(e).selectByVisibleText(txt);
    }

    public void waitForElementToBePresent(WebDriver d, WebElement e){
        new FluentWait(d).withTimeout(Duration.ofSeconds(_30_sec)).until(ExpectedConditions.visibilityOf(e));
    }

    public void waitForElementToDisappeared(WebDriver d, WebElement e){
        new FluentWait(d).withTimeout(Duration.ofSeconds(_30_sec)).until(ExpectedConditions.invisibilityOf(e));
    }

    public void waitForElementsToDisappear(WebDriver driver, By locator) {
        new WebDriverWait(driver, _30_sec).until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public boolean isElementDisplayed(WebDriver d, By by){
        int s = d.findElements(by).size();
        if(s == 0){
            return false;
        }
        return true;
    }
}