package loginTest;

import com.codeborne.selenide.Configuration;
import io.github.cdimascio.dotenv.Dotenv;
import loginTest.Pages.RegistrationPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginTest {

    private static String MAIL;
    private static String PASSWORD;

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    public static void BeforeAll() {
        Dotenv dotenv = Dotenv.load();
        MAIL = dotenv.get("MAIL");
        PASSWORD = dotenv.get("PASSWORD");

        //Для обхода проблемы со входом в Gmail при переходе на страницу ввода пароля
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--disable-blink-features=AutomationControlled");

        // Настраиваем Selenide использовать наши ChromeOptions:
        Configuration.browser = "chrome";
        Configuration.browserCapabilities = options;
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void successfulLogin_Gmail() {
        registrationPage.openPage()
                        .setMail(MAIL)
                        .nextPageEntryPassword()
                        .setPassword(PASSWORD)
                        .clickLoginButton()
                        .waitLoadingSite()
                        .checkURL("https://mail.google.com/mail/u/0/#inbox");

    }
}

