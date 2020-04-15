package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.Objects;

public final class WdExpectedConditions {

    public static ExpectedCondition<Boolean> isPageLoaded() {
        return input -> {
            JavascriptExecutor ex = (JavascriptExecutor) input;
            return ("complete").equals(Objects.requireNonNull(ex)
                    .executeScript("return document.readyState"));
        };
    }

    public static ExpectedCondition<Boolean> areAjaxCallsCompleted() {
        return input -> {
            JavascriptExecutor ex = (JavascriptExecutor) input;
            return (boolean) Objects.requireNonNull(ex).executeScript("return jQuery.active == 0");
        };
    }
}