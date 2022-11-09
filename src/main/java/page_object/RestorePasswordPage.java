package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Page object для страницы восстановления пароля
public class RestorePasswordPage {

    private WebDriver driver;

    public RestorePasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    // Локатор кнопки "Войти"
    private By signInButton = By.className("Auth_link__1fOlj");

    // Метод кликающий на кнопку "Войти"
    public void clickSignIn() {
        driver.findElement(signInButton).click();
    }
}
