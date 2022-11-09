package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import user.User;

import java.time.Duration;

// Page object страницы регистрации
public class RegisterPage {

    private WebDriver driver;

    User user;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // Локатор текстового поля для ввода имени
    private By nameInput = By.xpath(".//fieldset[1]/div/div/input");

    // Локатор текстового поля для ввода email'a
    private By emailInput = By.xpath((".//fieldset[2]/div/div/input"));

    // Локатор текстового поля для ввода пароля
    private By passwordInput = By.xpath((".//fieldset[3]/div/div/input"));

    // Локатор кнопки "Зарегистрироваться"
    private By registrationButton = By.xpath(".//*[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");

    // Локатор сообщения об ошибке с текстом "Некорректный пароль"
    private By errorMessage = By.xpath(".//*[@class='input__error text_type_main-default']");

    // Локатор кнопки "Войти"
    private By signInButton = By.className("Auth_link__1fOlj");

    // Метод кликающий на кнопку "Войти"
    public void clickSignIn() {
        driver.findElement(signInButton).click();
    }

    // Метод для ввода имени в поле Имя
    public void sendName(User user) {
        driver.findElement(nameInput).sendKeys(user.getName());
    }

    // Метод для ввода email в поле Email
    public void sendEmail(User user) {
        driver.findElement(emailInput).sendKeys(user.getEmail());
    }

    // Метод для ввода пароля в поле Пароль
    public void sendPassword(User user) {
        driver.findElement(passwordInput).sendKeys(user.getPassword());
    }

    // Метод для клика на кнопку Зарегистрироваться
    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    // Метод объединяющий ввод имени, email, пароля и клика на кнопку Зарегистрироваться
    public void registration(User user) {
        sendName(user);
        sendEmail(user);
        sendPassword(user);
        clickRegistrationButton();
    }

    // Метод проверяющий, что сообщения об ошибке "Некорректный пароль" видимо на странице
    public boolean checkThatErrorMessageIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(errorMessage));
        return driver.findElement(errorMessage).isDisplayed();
    }


}
