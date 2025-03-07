import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import org.openqa.selenium.chrome.ChromeOptions;

public class SendLetterGmail {
    @BeforeAll
    public static void BeforeAll() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("user-data-dir=C:\\Users\\Genri\\AppData\\Local\\Google\\Chrome\\User Data\\Test");

        Configuration.browser = "chrome";
        Configuration.browserCapabilities = options;

        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void SendMail_Gmail() {
        open("https://gmail.com");
        $(".z0").shouldBe(visible).click();
        $("[peoplekit-id='BbVjBd']").setValue("hejen62000@dwriters.com").pressEnter();
        $("[name='subjectbox']").setValue("Тема тестового письма");
        $(".Am").setValue("Если ты это читаешь из электронной почты, значит автотест правильно " +
                "делает все");
        $("[id=':o0']").click();
        $(".bAq").shouldBe(text("Сообщение отправлено."));

    }
}
