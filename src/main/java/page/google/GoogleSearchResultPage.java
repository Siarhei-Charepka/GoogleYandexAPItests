package page.google;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleSearchResultPage extends BasePage {

    @FindBy(css = "#search a[data-ved]:not(a[aria-haspopup])")
    private List<WebElement> searchResults;

    public GoogleSearchResultPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public int getSearchResultsQuantity() {
        return searchResults.size();
    }

    public boolean checkSearchResultsContain(String key) {
        return searchResults.stream()
                .anyMatch(searchResult -> searchResult.getText().contains(key));
    }
}
