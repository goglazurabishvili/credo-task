package ge.credo.steps;

import ge.credo.pages.MainPanelPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPanelStep extends MainPanelPage {
    private final WebDriverWait wait;

    public MainPanelStep(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Click on language switcher button")
    public void clickOnLanguageSwitcher() {
        languageSwitcherButton.click();
    }

    @Step("Error notification is displayed")
    public boolean errorNotificationDisplayed(){
        return errorNotification.isDisplayed();
    }


    @Step("Get error message element text")
    public String getGrowlText() {
        wait.until(ExpectedConditions.visibilityOf(growlText));
        return growlText.getText();
    }
}
