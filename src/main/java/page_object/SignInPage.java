package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import user.User;

import java.time.Duration;

public class SignInPage {
    private WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    private By headerSignIn = By.xpath(".//*[text()='Вход']");

    private By emailInput = By.name("name");

    private By passwordInput = By.name("Пароль");

    private By signInButton = By.xpath(".//*[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");

    private By register = By.xpath(".//*[@href='/register']");

    private By restorePassword = By.xpath(".//*[@href='/forgot-password']");

    public void enterEmail(User user) {
        driver.findElement(emailInput).sendKeys(user.getEmail());
    }

    public void enterPassword(User user) {
        driver.findElement(passwordInput).sendKeys(user.getPassword());
    }

    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    public void signIn(User user) {
        enterEmail(user);
        enterPassword(user);
        clickSignInButton();
    }

    public void clickRegister() {
        driver.findElement(register).click();
    }

    public void clickRestorePassword() {
        driver.findElement(restorePassword).click();
    }

    public boolean checkThatSignInIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(headerSignIn));
        return driver.findElement(headerSignIn).isDisplayed();
    }

}
