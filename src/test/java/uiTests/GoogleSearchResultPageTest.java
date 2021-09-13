package uiTests;

import config.TestConfig;
import driver.Driver;
import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.google.GoogleHomePage;
import page.google.GoogleSearchResultPage;
import utils.TestListener;

@Listeners(TestListener.class)
public class GoogleSearchResultPageTest {

    private static final String GOOGLE_URL = TestConfig.get("googleUrl");
    private static final String REQUEST = "купить кофемашину bork c804";
    private static final String KEY = "Shop.by";//"mvideo.ru"; // Shop.by keyword is available for the Belorussian location

    private GoogleHomePage googleHomePage;

    @BeforeMethod
    public void openBrowser() {
        Driver.getDriver().get(GOOGLE_URL);
        googleHomePage = new GoogleHomePage();
    }

    @AfterMethod
    public void closeBrowser() {
        Driver.tearDown();
    }

    @Description("The test checks the availability of search results for the query")
    @Test
    public void checkSearchResultsTest() {
        GoogleSearchResultPage googleSearchResultPage = googleHomePage.search(REQUEST);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(googleSearchResultPage.getSearchResultsQuantity() > 10,
                "Search Result list size is less than 10");
        softAssert.assertTrue(googleSearchResultPage.checkSearchResultsContain(KEY),
                "There are no any Search Results with keyword - " + KEY);
        softAssert.assertAll();
    }
}