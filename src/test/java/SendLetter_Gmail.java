import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SendLetter_Gmail {
    @BeforeAll
    public static void BeforeAll() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("user-data-dir=C:\\Users\\Genri\\AppData\\Local\\Google\\Chrome\\User Data");

        Configuration.browser = "chrome";
        Configuration.browserCapabilities = options;
        Configuration.holdBrowserOpen = true;
    }

    @Test
    public void SendMail_Gmail() { //доделать
        Configuration.holdBrowserOpen = true;
        open("https://gmail.com");
        $(".z0").shouldBe(visible).click();
        $("[name=Текст письма").setValue("q@gmail.com");

    }
}
