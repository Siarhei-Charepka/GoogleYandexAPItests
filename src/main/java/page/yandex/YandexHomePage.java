package page.yandex;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexHomePage extends BasePage {

    @FindBy(css = "a[title*='yandex.com']")
    private WebElement yandexHomePageLink;

    @FindBy(css = "#tab-mail")
    private WebElement mailButton;

    public YandexHomePage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public YandexLoginPage navigateToYandexLoginPage() {
        yandexHomePageLink.click();
        mailButton.click();
        return new YandexLoginPage();
    }
}
