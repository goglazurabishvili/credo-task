package ge.credo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PopUpPage {

    @FindBy(xpath = "//div[@class='popup-wrapper']//div[@class='header']")
    public WebElement popupHeader;

    public PopUpPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
