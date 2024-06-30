package ge.credo.steps;

import ge.credo.pages.PopUpPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PopUpStep extends PopUpPage {
    private final WebDriverWait wait;
    private final WebDriver driver;

    public PopUpStep(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.driver = driver;
    }

    @Step("Wait for pop up to be visible")
    public void waitForPopUp(){
        wait.until(ExpectedConditions.visibilityOf(popupHeader));
    }

    @Step("Change language to {language}")
    public void setLanguage(String lang) {
        WebElement language = driver.findElement(By.xpath("//div[@class='sub-language']//p[text()='"+lang+"']"));
        language.click();
    }
}
