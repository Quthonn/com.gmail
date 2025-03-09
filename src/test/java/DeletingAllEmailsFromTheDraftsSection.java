import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class DeletingAllEmailsFromTheDraftsSection {
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
    public void DeletingAllEmailsFromTheDraftsSection() {
        String expectedUrl = "https://mail.google.com/mail/u/0/#drafts";

        open("https://gmail.com");
        $(".aHS-bnq").click();
        webdriver().shouldHave(url(expectedUrl));
        $("[gh='mtb']").$("[role='checkbox']").click();
        $(".Bn").click();
        $(".aeF").shouldHave(exactText("Нет сохраненных черновиков. Черновики позволяют хранить " +
                "письма, еще не готовые к отправке."));
    }
}
