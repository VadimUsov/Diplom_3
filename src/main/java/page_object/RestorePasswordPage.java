package page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RestorePasswordPage {

    private WebDriver driver;

    public RestorePasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    private By signInButton = By.className("Auth_link__1fOlj");

    public void clickSignIn() {
        driver.findElement(signInButton).click();
    }
}
