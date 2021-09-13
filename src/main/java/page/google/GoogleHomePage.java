package page.google;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePage extends BasePage {

    @FindBy(css = "input[name='q']")
    private WebElement searchField;

    @FindBy(css = ".aajZCb [name='btnK']")
    private WebElement searchButton;

    public GoogleHomePage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public GoogleSearchResultPage search(String key) {
        searchField.sendKeys(key);
        searchButton.click();
        return new GoogleSearchResultPage();
    }
}
