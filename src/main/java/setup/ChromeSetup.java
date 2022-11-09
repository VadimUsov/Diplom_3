package setup;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page_object.*;


public class ChromeSetup {
    protected WebDriver driver;
    protected StartPage startPage;
    protected SignInPage signInPage;
    protected RegisterPage registerPage;
    protected RestorePasswordPage restorePassword;
    protected PersonalCabinetPage personalCabinetPage;

    //Метод для открытия создания драйвера и открытия Google Chrome на странице "https://stellarburgers.nomoreparties.site/"
    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site/");
        startPage = new StartPage(driver);
        signInPage = new SignInPage(driver);
        registerPage = new RegisterPage(driver);
        restorePassword = new RestorePasswordPage(driver);
        personalCabinetPage = new PersonalCabinetPage(driver);
    }

    // Метод закрывающий браузер после теста
    @After
    public void tearDown() {
        driver.quit();
    }
}
