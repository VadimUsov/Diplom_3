package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


// Page object для стартовой страницы
public class StartPage {

    private WebDriver driver;

    public StartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Константы для проверки названий некоторых элементов стартовой страницы
    public final String CREATE_ORDER = "Оформить заказ";

    public final String BUNS = "Булки";

    public final String SAUCE = "Соусы";

    public final String INGREDIENTS = "Начинки";

    // Локтор кнопки Личный кабинет в шапке страницы
    private By personalCabinetInHeader = By.linkText("Личный Кабинет");

    // Локатор кнопки Конструктор в шапке страницы
    private By constructorInHeader = By.linkText("Конструктор");

    // Локатор лого "stellar burger" в шапке страницы
    private By logoInHeader = By.xpath(".//*[@fill='none']");

    // Локтатор надписи Соберите бургер над конструктором
    private By makeBurger = By.xpath(".//*[@class='text text_type_main-large mb-5 mt-10']");

    // Локатор блока конструктора Начинки при выбранном другом блоке
    private By ingredientsBlockUnselected = By.xpath(".//div[@style='display: flex;']/div[3]");

    // Локатор блока Соус начинки при выбранном другом блоке
    private By sauceBlockUnselected = By.xpath(".//div[@style='display: flex;']/div[2]");

    // Локатор блока конструктора Булки при выбранном другом блоке
    private By bunsBlockUnselected = By.xpath(".//div[@style='display: flex;']/div[1]");

    // Локатор выбранного блока конструктора
    private By partOfBurgerBlockSelected = By.xpath(".//*[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");

    // Локатор кнопки Войти
    private By signInAccountButton = By.xpath(".//*[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");


    // Метод для клика на элемент стартовой страницы.
    // Принимает в качестве аргумента локатор элемента страницы.
    public void clickElementOfStartPage(By element) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }

    // Метод для клика на блок в конструкторе.
    // Прнимает в качестве аргумента локатор элемента страницы.
    public void clickPartOfBurgerBlock(By partOfBurger) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(partOfBurger));
        driver.findElement(partOfBurger).click();
    }

    // Метод получающий текст выбранного блока в конструкторе.
    public String checkThatPartOfBurgerBlockSelected() {
        return driver.findElement(partOfBurgerBlockSelected).getText();
    }

    // Метод проверяющий, что надпись "Соберите бургер" отображается на странице
    public boolean checkThatMakeBurgerIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(makeBurger));
        return driver.findElement(makeBurger).isDisplayed();
    }

    // Метод получающий текст кнопки с локатором кнопки Войти.
    // Так как после авторизации юзером текст меняется на "Оформить заказ"
    public String checkThatButtonChange() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(signInAccountButton));
        return driver.findElement(signInAccountButton).getText();
    }

    // Геттеры для локаторов элементов страницы
    public By getPersonalCabinetInHeader() {
        return personalCabinetInHeader;
    }

    public By getConstructorInHeader() {
        return constructorInHeader;
    }

    public By getLogoInHeader() {
        return logoInHeader;
    }

    public By getIngredientsBlockUnselected() {
        return ingredientsBlockUnselected;
    }

    public By getSauceBlockUnselected() {
        return sauceBlockUnselected;
    }

    public By getBunsBlockUnselected() {
        return bunsBlockUnselected;
    }

    public By getSignInButton() {
        return signInAccountButton;
    }

}
