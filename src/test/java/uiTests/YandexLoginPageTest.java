package uiTests;

import config.TestConfig;
import driver.Driver;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.yandex.YandexHomePage;
import page.yandex.YandexLoginPage;
import page.yandex.YandexMailPage;
import utils.TestListener;

@Listeners(TestListener.class)
public class YandexLoginPageTest {

    private static final String YANDEX_URL = TestConfig.get("yandexUrl");
    private static final String USER_NAME = TestConfig.get("login");
    private static final String PASSWORD = TestConfig.get("password");

    private YandexLoginPage yandexLoginPage;
    private YandexHomePage yandexHomePage;

    @BeforeMethod
    public void openBrowser() {
        Driver.getDriver().get(YANDEX_URL);
        yandexHomePage = new YandexHomePage();
        yandexLoginPage = yandexHomePage.navigateToYandexLoginPage();
    }

    @Test
    @Description("The test checks that the mailbox can be accessed")
    public void loginTest() {
        yandexLoginPage.goToLoginForm();
        yandexLoginPage.inputUserName(USER_NAME);
        yandexLoginPage.clickUserNameLoginButton();
        yandexLoginPage.inputPassword(PASSWORD);
        YandexMailPage yandexMailPage = yandexLoginPage.clickPasswordLoginButton();
        Assert.assertTrue(yandexMailPage.isMailPageDisplayed(),
                String.format("Failed to sign in to mailbox with login '%s' and password '%s'",
                        USER_NAME, PASSWORD));
    }

    @AfterMethod
    public void closeBrowser() {
        Driver.tearDown();
    }
}