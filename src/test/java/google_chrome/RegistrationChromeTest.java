package google_chrome;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import setup.ChromeSetup;
import user.User;

public class RegistrationChromeTest extends ChromeSetup {

    @Test
    @DisplayName("Регистрация проходит успешно при заполнении всех полей валидными значениями")
    public void checkThatRegistrationIsOkWithAllData() {
        clickSignIn();
        clickRegistration();
        sendValidData();
        checkThatSignInDisplayed();
    }

    @Step("Нажать кнопку Войти в аккаунт")
    public void clickSignIn() {
        startPage.clickElementOfStartPage(startPage.getSignInButton());
    }

    @Step("Нажать кнопку Зарегистрироваться")
    public void clickRegistration() {
        signInPage.clickRegister();
    }

    @Step("Ввести валидные данные во все поля")
    public void sendValidData() {
        registerPage.registration(User.getRandomUser());
    }

    @Step("Проверить, что заголовок Войти отображается на странице")
    public void  checkThatSignInDisplayed() {
        Assert.assertTrue(signInPage.checkThatSignInIsDisplayed());
    }

    @Test
    @DisplayName("При вводе короткого пароля при регистрации появляется сообщение об ошибке")
    public void checkThatRegistrationFailedWithShortPassword() {
        clickSignIn();
        clickRegistration();
        sendDataWithShortPassword();
        checkErrorMessage();
    }

    @Step("Ввести данные. Задать пароль из 5 символов.")
    public void sendDataWithShortPassword() {
        registerPage.registration(User.getRandomUserWithShortPassword());
    }

    @Step("Проверить, что появилось сообщение")
    public void checkErrorMessage() {
        Assert.assertTrue(registerPage.checkThatErrorMessageIsDisplayed());
    }
}
