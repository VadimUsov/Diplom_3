package yandex_browser;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import setup.YandexSetup;
import user.User;

public class SignInYandexTest extends YandexSetup {

    @Test
    @DisplayName("Можно войти через кнопку Войти в аккаунт на главной странице")
    public void SignInThroughSignInAccountButton() {
        clickSignInStartPage();
        sendUserData();
        checkThatButtonChanged();
    }

    @Step("Нажать на кнопку Войти в аккаунт на главной странице")
    public void clickSignInStartPage() {
        startPage.clickElementOfStartPage(startPage.getSignInButton());
    }

    @Step("Заполнить форму для логина валидными данными")
    public void sendUserData() {
        signInPage.signIn(User.getRealUser());
    }

    @Step("Проверить, что кнопка Войти в аккаунт сменилась на Оформить заказ")
    public void checkThatButtonChanged() {
        Assert.assertEquals(startPage.CREATE_ORDER, startPage.checkThatButtonChange());
    }

    @Test
    @DisplayName("Можно войти через кнопку Личный кабинет в шапке страницы")
    public void SignInThroughPersonalCabinet() {
        clickPersonalCabinetInHeader();
        sendUserData();
        checkThatButtonChanged();
    }

    @Step("Нажать на кнопку Личный кабинет в шапке страницы")
    public void clickPersonalCabinetInHeader() {
        startPage.clickElementOfStartPage(startPage.getPersonalCabinetInHeader());
    }

    @Test
    @DisplayName("Можно войти через кнопку Войти на странице регистрации")
    public void SignInThroughRegistration() {
        clickPersonalCabinetInHeader();
        clickRegistration();
        clickSignInRegistrationPage();
        sendUserData();
        checkThatButtonChanged();
    }

    @Step("Нажать на кнопку Зарегистрироваться")
    public void clickRegistration() {
        signInPage.clickRegister();
    }

    @Step("Нажать кнопку Войти на странице регистрации")
    public void clickSignInRegistrationPage() {
        registerPage.clickSignIn();
    }

    @Test
    @DisplayName("Можно войти через кнопку Войти на странице восстановления пароля")
    public void SignInThroughRestorePassword() {
        clickPersonalCabinetInHeader();
        clickRestorePassword();
        clickSignInRestorePasswordPage();
        sendUserData();
        checkThatButtonChanged();
    }

    @Step("Нажать на кнопку Восстановить пароль")
    public void clickRestorePassword() {
        signInPage.clickRestorePassword();
    }

    @Step("Нажать кнопку Войти на странице восстановления пароля")
    public void clickSignInRestorePasswordPage() {
        restorePassword.clickSignIn();
    }
}