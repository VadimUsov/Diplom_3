package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//Page object для страницы "Личный кабинет"
public class PersonalCabinetPage {
    WebDriver driver;

    public PersonalCabinetPage(WebDriver driver) {
        this.driver = driver;
    }

    // Локатор кнопки "Выйти"
    private By exitButton = By.xpath(".//*[@class='Account_button__14Yp3 text text_type_main-medium text_color_inactive']");

    // Метод кликающий на кнопку выйти
    public void clickExit() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(exitButton));
        driver.findElement(exitButton).click();
    }

    // Метод проверяющий, что кнопка "Выйти" есть на странице
    public boolean checkThatExitButtonIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(exitButton));
        return driver.findElement(exitButton).isDisplayed();
    }
}
