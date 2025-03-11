package loginTest.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class RegistrationPage {
    private SelenideElement
        mailField = $("[name=identifier]"),
        passwordPageButton = $(".TNTaPb"),
        passwordField = $("[name=Passwd]"),
        loginButton = $(".TNTaPb"),
        waitLoadingSite = $("body");

    public RegistrationPage openPage() {
        open("https://gmail.com");

        return this;
    }

    public RegistrationPage setMail(String value) {
        mailField.setValue(value);

        return this;
    }

    public RegistrationPage nextPageEntryPassword() {
        passwordPageButton.click();

        return this;
    }

    public RegistrationPage setPassword(String value) {
//        webdriver().shouldHave(urlContaining("https://accounts.google.com/v3/signin/challenge/pwd?"));
        passwordField.shouldBe(Condition.appear, Duration.ofSeconds(10)).setValue(value);

        return this;
    }

    public RegistrationPage clickLoginButton() {
        loginButton.click();

        return this;
    }

    public RegistrationPage waitLoadingSite() {
        waitLoadingSite.shouldBe(visible);

        return this;
    }

    public RegistrationPage checkURL(String value) {
        webdriver().shouldHave(url(value));

        return this;
    }


}
