package page.yandex;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexMailPage extends BasePage {

    @FindBy(css = ".mail-Page-Body")
    private WebElement mailPageBody;

    public YandexMailPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public boolean isMailPageDisplayed() {
        return mailPageBody.isDisplayed();
    }
}
