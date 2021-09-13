package page.yandex;

import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YandexLoginPage extends BasePage {

    @FindBy(css = ".HeadBanner-Button-Enter")
    private WebElement signInButton;

    @FindBy(css = "[id='passp-field-login']")
    private WebElement userNameField;

    @FindBy(css = "[class *='has-social-block'] [type='submit']")
    private WebElement userNameLoginButton;

    @FindBy(css = "[name ='passwd']")
    private WebElement passwordField;

    @FindBy(css = ".passp-route-forward [type='submit']")
    private WebElement passwordLoginButton;

    public YandexLoginPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public void inputUserName(String userName) {
        userNameField.sendKeys(userName);
    }

    public void clickUserNameLoginButton() {
        userNameLoginButton.click();
    }

    public void inputPassword(String password) {
        passwordField.sendKeys(password);
    }

    public YandexMailPage clickPasswordLoginButton() {
        passwordLoginButton.click();
        return new YandexMailPage();
    }

    public void goToLoginForm() {
        signInButton.click();
    }
}
