package google_chrome;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import setup.ChromeSetup;

public class ConstructorChromeTest extends ChromeSetup {

    @Test
    @DisplayName("Работает переход к разделу «Начинки»")
    public void checkThatIngredientsSectionCanBeSelected() {
        clickIngredientsBlock();
        checkThatIngredientsBlockSelected();
    }

    @Step("Нажать на секцию Начинки")
    public void clickIngredientsBlock() {
        startPage.clickPartOfBurgerBlock(startPage.getIngredientsBlockUnselected());
    }

    @Step("Проверить, что работает переход к разделу Начинки")
    public void checkThatIngredientsBlockSelected() {
        Assert.assertEquals(startPage.INGREDIENTS, startPage.checkThatPartOfBurgerBlockSelected());

    }

    @Test
    @DisplayName("Работает переход к разделу «Соусы»")
    public void checkThatSauceSectionCanBeSelected() {
        clickSauceBlock();
        checkThatSauceBlockSelected();
    }

    @Step("Нажать на секцию Соусы")
    public void clickSauceBlock() {
        startPage.clickPartOfBurgerBlock(startPage.getSauceBlockUnselected());
    }

    @Step("Проверить, что работает переход к разделу Соусы")
    public void checkThatSauceBlockSelected() {
        Assert.assertEquals(startPage.SAUCE, startPage.checkThatPartOfBurgerBlockSelected());
    }

    @Test
    @DisplayName("Работает переход к разделу «Булки»")
    public void checkThatBunsSectionCanBeSelected() {
        clickSauceBlock();
        clickBunsBlock();
        checkThatBunsBlockSelected();
    }

    @Step("Нажать на секцию Булки")
    public void clickBunsBlock() {
        startPage.clickPartOfBurgerBlock(startPage.getBunsBlockUnselected());
    }

    @Step("Проверить, что работает переход к разделу Булки")
    public void checkThatBunsBlockSelected() {
        Assert.assertEquals(startPage.BUNS, startPage.checkThatPartOfBurgerBlockSelected());
    }
}
