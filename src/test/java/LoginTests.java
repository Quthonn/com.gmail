import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginTests { //Добавить везде этапы проверок
    @BeforeAll
    public static void BeforeAll() { //Для обхода проблемы со входом в Gmail при переходе на страницу ввода пароля
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
        open("https://gmail.com");
        $("[name=identifier]").setValue("MAIL");
        $(".TNTaPb").click(); //Нажатие по кнопке перехода на страницу ввода пароля
        $("[name=Passwd]").shouldBe(visible).setValue("PASSWORD");
        $(".TNTaPb").click();

        // Ожидание загрузки страницы
        $("body").shouldBe(Condition.visible);

        // Проверка URL после загрузки страницы
        webdriver().shouldHave(url("https://mail.google.com/mail/u/0/#inbox"));
    }
}

