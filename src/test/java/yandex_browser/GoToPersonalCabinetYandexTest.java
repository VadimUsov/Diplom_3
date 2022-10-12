package yandex_browser;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import setup.ChromeSetup;
import setup.YandexSetup;
import user.User;

public class GoToPersonalCabinetYandexTest extends YandexSetup {

    @Before
    public void signIn() {
        startPage.clickElementOfStartPage(startPage.getPersonalCabinetInHeader());
        signInPage.signIn(User.getRealUser());
    }

    @Test
    @DisplayName("Работает переход в личный кабинет")
    public void getToPersonalCabinet() {
        clickPersonalCabinet();
        checkThatExitButtonIsDisplayed();
    }

    @Step("Нажать на Личный кабинет в шапке страницы")
    public void clickPersonalCabinet() {
        startPage.clickElementOfStartPage(startPage.getPersonalCabinetInHeader());
    }

    @Step("Проверить, что кнопка Выйти отобразилась на экране")
    public void checkThatExitButtonIsDisplayed() {
        Assert.assertTrue(personalCabinetPage.checkThatExitButtonIsDisplayed());
    }
}
