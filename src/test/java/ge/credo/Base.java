package ge.credo;

import ge.credo.pages.AuthPanelPage;
import ge.credo.steps.AuthPanelStep;
import ge.credo.steps.MainPanelStep;
import ge.credo.steps.PopUpStep;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static ge.credo.data.Urls.MAIN_URL;

public class Base {

    protected AuthPanelPage authPanelPage;
    protected AuthPanelStep authPanelStep;
    protected PopUpStep popUpStep;
    protected MainPanelStep mainPanelStep;

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected SoftAssert softAssert;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        authPanelPage = new AuthPanelPage(driver);
        authPanelStep = new AuthPanelStep(driver);
        popUpStep = new PopUpStep(driver);
        mainPanelStep = new MainPanelStep(driver);
        softAssert = new SoftAssert();

        driver.get(MAIN_URL);
        wait.until(ExpectedConditions.visibilityOf(authPanelPage.bankLogo));
    }

    @AfterMethod
    void teardown() {
        driver.quit();
    }
}
