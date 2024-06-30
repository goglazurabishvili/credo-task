package ge.credo.steps;

import ge.credo.pages.AuthPanelPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthPanelStep extends AuthPanelPage {
    private final WebDriverWait wait;

    public AuthPanelStep(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Step("Fill username field with {userName}")
    public void fillUserName(String userName) {
        wait.until(ExpectedConditions.visibilityOf(userNameField));
        userNameField.sendKeys(userName);
    }

    @Step("Fill password field with {password}")
    public void fillPassword(String password) {
        passwordField.sendKeys(password);
    }

    @Step("Get username field class values")
    public String  getUserNameAttribute() {
        return userNameField.getAttribute("class");
    }

    @Step("Get username field placeholder text")
    public String  getUserHolderText(String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(userHolder, text));
        return userHolder.getText();
    }

    @Step("Get password field placeholder text")
    public String  getPasswordHolderText(String text) {
        wait.until(ExpectedConditions.textToBePresentInElement(passwordHolder, text));
        return passwordHolder.getText();
    }

    @Step("Get password field class values")
    public String getPasswordAttribute() {
        return passwordField.getAttribute("class");
    }

    @Step("Click on auth submit button")
    public void clickOnSubmit() {
        submitButton.click();
    }

    @Step("Check that submit button is enabled")
    public boolean submitEnabled() {
        return submitButton.isEnabled();
    }
}
