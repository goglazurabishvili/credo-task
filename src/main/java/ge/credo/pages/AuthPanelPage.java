package ge.credo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthPanelPage {

    @FindBy(id = "bankLogo")
    public WebElement bankLogo;

    @FindBy(id = "userName")
    public WebElement userNameField;

    @FindBy(id = "newPass")
    public WebElement passwordField;

    @FindBy(id = "submitAuth")
    public WebElement submitButton;

    @FindBy(id = "placeHolderAuth")
    public WebElement userHolder;

    @FindBy(id = "placeholderPass")
    public WebElement passwordHolder;

    public AuthPanelPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
