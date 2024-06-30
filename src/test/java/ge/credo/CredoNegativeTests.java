package ge.credo;

import ge.credo.data.DataProviders;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static ge.credo.data.Constants.RED_LINE_CLASS;

@Feature("Negative Login Scenarios")
public class CredoNegativeTests extends Base {

    @Test(
            description = "Verify that User is not able to login with invalid username and password",
            dataProvider = "InvalidData",
            dataProviderClass = DataProviders.class,
            priority = 1
    )
    public void loginInvalidUsernameTest(String language, String name, String password, String errorMessage, String nameHolder, String passwordHolder) {
        mainPanelStep.clickOnLanguageSwitcher();
        popUpStep.waitForPopUp();
        popUpStep.setLanguage(language);

        boolean submitButtonEnabled = authPanelStep.submitEnabled();
        softAssert.assertFalse(submitButtonEnabled, "Submit button should not be enabled");
        softAssert.assertEquals(authPanelStep.getUserHolderText(nameHolder), nameHolder);
        softAssert.assertEquals(authPanelStep.getPasswordHolderText(passwordHolder), passwordHolder);

        authPanelStep.fillUserName(name);
        authPanelStep.fillPassword(password);

        submitButtonEnabled = authPanelStep.submitEnabled();
        softAssert.assertTrue(submitButtonEnabled, "Submit button should be enabled");

        authPanelStep.clickOnSubmit();

        softAssert.assertEquals(mainPanelStep.getGrowlText(), errorMessage, "Error message should match");
        softAssert.assertTrue(mainPanelStep.errorNotificationDisplayed(), "Error notification should be displayed");

        softAssert.assertAll();
    }

    @Test(
            description = "Verify that User is not able to login with missing username and password",
            dataProvider = "MissingData",
            dataProviderClass = DataProviders.class,
            priority = 2
    )
    public void missingUsernamePasswordTest(String language, String name, String password, String nameHolder, String passwordHolder) {
        mainPanelStep.clickOnLanguageSwitcher();
        popUpStep.waitForPopUp();
        popUpStep.setLanguage(language);

        boolean submitButtonEnabled = authPanelStep.submitEnabled();
        softAssert.assertFalse(submitButtonEnabled, "Submit button should not be enabled");
        softAssert.assertEquals(authPanelStep.getUserHolderText(nameHolder), nameHolder);
        softAssert.assertEquals(authPanelStep.getPasswordHolderText(passwordHolder), passwordHolder);

        authPanelStep.fillUserName(name);
        authPanelStep.fillPassword(password);

        submitButtonEnabled = authPanelStep.submitEnabled();
        softAssert.assertFalse(submitButtonEnabled, "Submit button should not be enabled");
        softAssert.assertTrue(authPanelStep.getUserNameAttribute().contains(RED_LINE_CLASS), "Username field should contain red line class");
        softAssert.assertTrue(authPanelStep.getPasswordAttribute().contains(RED_LINE_CLASS), "Password field should contain red line class");

        softAssert.assertAll();
    }

    @Test(
            description = "Verify that User is not able to login with missing password",
            dataProvider = "MissingPassword",
            dataProviderClass = DataProviders.class,
            priority = 3
    )
    public void missingPasswordTest(String language, String name, String password, String nameHolder, String passwordHolder) {
        mainPanelStep.clickOnLanguageSwitcher();
        popUpStep.waitForPopUp();
        popUpStep.setLanguage(language);

        boolean submitButtonEnabled = authPanelStep.submitEnabled();
        softAssert.assertFalse(submitButtonEnabled, "Submit button should not be enabled");
        softAssert.assertEquals(authPanelStep.getUserHolderText(nameHolder), nameHolder);
        softAssert.assertEquals(authPanelStep.getPasswordHolderText(passwordHolder), passwordHolder);

        authPanelStep.fillUserName(name);
        authPanelStep.fillPassword(password);

        submitButtonEnabled = authPanelStep.submitEnabled();
        softAssert.assertFalse(submitButtonEnabled, "Submit button should not be enabled");
        softAssert.assertTrue(authPanelStep.getPasswordAttribute().contains(RED_LINE_CLASS), "Password field should contain red line class");

        softAssert.assertAll();
    }

    @Test(
            description = "Verify that User is not able to login with missing username",
            dataProvider = "MissingUsername",
            dataProviderClass = DataProviders.class,
            priority = 4
    )
    public void missingUsernameTest(String language, String name, String password, String nameHolder, String passwordHolder) {
        mainPanelStep.clickOnLanguageSwitcher();
        popUpStep.waitForPopUp();
        popUpStep.setLanguage(language);

        boolean submitButtonEnabled = authPanelStep.submitEnabled();
        softAssert.assertFalse(submitButtonEnabled, "Submit button should not be enabled");
        softAssert.assertEquals(authPanelStep.getUserHolderText(nameHolder), nameHolder);
        softAssert.assertEquals(authPanelStep.getPasswordHolderText(passwordHolder), passwordHolder);

        authPanelStep.fillUserName(name);
        authPanelStep.fillPassword(password);

        submitButtonEnabled = authPanelStep.submitEnabled();
        softAssert.assertFalse(submitButtonEnabled, "Submit button should not be enabled");
        softAssert.assertTrue(authPanelStep.getUserNameAttribute().contains(RED_LINE_CLASS), "Username field should contain red line class");

        softAssert.assertAll();
    }
}
