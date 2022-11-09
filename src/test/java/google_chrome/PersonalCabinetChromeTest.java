package google_chrome;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import setup.ChromeSetup;
import user.User;

public class PersonalCabinetChromeTest extends ChromeSetup {

    @Before
    public void signIn() {
        startPage.clickElementOfStartPage(startPage.getPersonalCabinetInHeader());
        signInPage.signIn(User.getRealUser());
        startPage.clickElementOfStartPage(startPage.getPersonalCabinetInHeader());
    }

    @Test
    @DisplayName("Работает переход из личного кабинета в конструктор через Конструктор в шапке страницы")
    public void goToConstructorThroughConstructor() {
        clickConstructorInHeader();
        checkMakeBurgerInscription();
    }

    @Step("Нажать на Конструктор в шапке страницы")
    public void clickConstructorInHeader() {
        startPage.clickElementOfStartPage(startPage.getConstructorInHeader());
    }

    @Step("Проверить, что надпись \"Соберите бургер\" отображается на странице")
    public void checkMakeBurgerInscription() {
        Assert.assertTrue(startPage.checkThatMakeBurgerIsDisplayed());
    }

    @Test
    @DisplayName("Работает переход из личного кабинета в конструктор через логотип Stellar Burgers в шапке страницы")
    public void goToConstructorThroughLogo() {
        clickLogoInHeader();
        checkMakeBurgerInscription();
    }

    @Step("Нажать на логотип Stellar Burgers в шапке страницы")
    public void clickLogoInHeader() {
        startPage.clickElementOfStartPage(startPage.getLogoInHeader());
    }

    @Test
    @DisplayName("Работает выход из личного кабинета по кнопке Выйти")
    public void exitFromPersonalCabinet() {
        clickExit();
        checkSignInInscription();
    }

    @Step("Нажать на кнопку Выйти в личном кабинете")
    public void clickExit() {
        personalCabinetPage.clickExit();
    }

    @Step("Проверить что отображается надпись Войти на странице")
    public void checkSignInInscription() {
        Assert.assertTrue(signInPage.checkThatSignInIsDisplayed());
    }
}
