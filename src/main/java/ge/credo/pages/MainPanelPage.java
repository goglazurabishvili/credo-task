package ge.credo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPanelPage {

    @FindBy(id = "languageSwitcherBtn")
    public WebElement languageSwitcherButton;

    @FindBy(css = ".notification-container.error")
    public WebElement errorNotification;

    @FindBy(id = "growlText")
    public WebElement growlText;

    public MainPanelPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
