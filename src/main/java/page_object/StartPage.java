package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StartPage {

    private WebDriver driver;

    public StartPage(WebDriver driver) {
        this.driver = driver;
    }

    public final String CREATE_ORDER = "Оформить заказ";

    public final String BUNS = "Булки";

    public final String SAUCE = "Соусы";

    public final String INGREDIENTS = "Начинки";

    private By personalCabinetInHeader = By.linkText("Личный Кабинет");

    private By constructorInHeader = By.linkText("Конструктор");

    private By logoInHeader = By.xpath(".//*[@fill='none']");

    private By makeBurger = By.xpath(".//*[@class='text text_type_main-large mb-5 mt-10']");

    private By ingredientsBlockUnselected = By.xpath(".//div[@style='display: flex;']/div[3]");

    private By sauceBlockUnselected = By.xpath(".//div[@style='display: flex;']/div[2]");

    private By bunsBlockUnselected = By.xpath(".//div[@style='display: flex;']/div[1]");

    private By partOfBurgerBlockSelected = By.xpath(".//*[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");

    private By signInAccountButton = By.xpath(".//*[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_large__G21Vg']");


    public void clickElementOfStartPage(By element) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }

    public void clickPartOfBurgerBlock(By partOfBurger) {
        driver.findElement(partOfBurger).click();
    }

    public String checkThatPartOfBurgerBlockSelected() {
        return driver.findElement(partOfBurgerBlockSelected).getText();
    }

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

    public boolean checkThatMakeBurgerIsDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(makeBurger));
        return driver.findElement(makeBurger).isDisplayed();
    }

    public String checkThatButtonChange() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(signInAccountButton));
        return driver.findElement(signInAccountButton).getText();
    }
}
