package guru.qa.tests;

import jdk.jfr.Description;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;
import static guru.qa.data.TestData.authCookieName;
import static guru.qa.helpers.GetAuth.getAuth;
import static guru.qa.helpers.GetAuth.getAuthCookie;

public class LoginTest extends TestBase {

    @Test
    @Description("Login test with API auth")
    void loginTest() {
        open("/favicon.ico");
        getAuth(getAuthCookie(authCookieName));
        open("/");
        $(".header-links-wrapper").shouldHave(text("Log out"));
    }
}