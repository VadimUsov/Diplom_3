package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import user.User;
import java.time.Duration;

public class RegisterPage {

    private WebDriver driver;

    User user;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    private By nameInput = By.xpath(".//fieldset[1]/div/div/input");

    private By emailInput = By.xpath((".//fieldset[2]/div/div/input"));

    private By passwordInput = By.xpath((".//fieldset[3]/div/div/input"));

    private By registrationButton = By.xpath(".//*[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");

    private By errorMessage = By.xpath(".//*[@class='input__error text_type_main-default']");

    private By registration = By.linkText("Регистрация");

    private By signInButton = By.className("Auth_link__1fOlj");

    public void clickSignIn() {
        driver.findElement(signInButton).click();
    }

    public void sendName(User user) {
        driver.findElement(nameInput).sendKeys(user.getName());
    }

    public void sendEmail(User user) {
        driver.findElement(emailInput).sendKeys(user.getEmail());
    }

    public void sendPassword(User user) {
        driver.findElement(passwordInput).sendKeys(user.getPassword());
    }

    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    public void registration(User user) {
        sendName(user);
        sendEmail(user);
        sendPassword(user);
        clickRegistrationButton();
    }

    public boolean checkThatErrorMessageIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(errorMessage));
        return driver.findElement(errorMessage).isDisplayed();
    }


}
