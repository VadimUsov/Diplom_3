package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import user.User;

import java.time.Duration;

// Page Object для страницы "Вход"
public class SignInPage {
    private WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    // Локтор заглавия страницы с надписью "Вход"
    private By headerSignIn = By.xpath(".//*[text()='Вход']");

    // Локатор поля для ввода email
    private By emailInput = By.name("name");

    // Локатор поля для ввода пароля
    private By passwordInput = By.name("Пароль");

    // Локатор кнопки Войти
    private By signInButton = By.xpath(".//*[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");

    // Локатор кнопки Зарегистрироваться
    private By register = By.xpath(".//*[@href='/register']");

    // Локатор кнопки Восстановить пароль
    private By restorePassword = By.xpath(".//*[@href='/forgot-password']");


    // Метод для ввода email'a в поле Email
    public void enterEmail(User user) {
        driver.findElement(emailInput).sendKeys(user.getEmail());
    }

    // Метод для ввода пароля в поле Пароль
    public void enterPassword(User user) {
        driver.findElement(passwordInput).sendKeys(user.getPassword());
    }

    // Метод кликающий на кнопку Войти
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }


    // Метод объединяющий ввод email, пароля и нажатие кнопки Войти
    public void signIn(User user) {
        enterEmail(user);
        enterPassword(user);
        clickSignInButton();
    }

    // Метод кликающий на кнопку Зарегистрироваться
    public void clickRegister() {
        driver.findElement(register).click();
    }

    // Метод кликающий на кнопку Восстановить пароль
    public void clickRestorePassword() {
        driver.findElement(restorePassword).click();
    }

    // Метод проверяющий, что заглавие страницы с надписью Вход отображается на странице
    public boolean checkThatSignInIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(headerSignIn));
        return driver.findElement(headerSignIn).isDisplayed();
    }

}
