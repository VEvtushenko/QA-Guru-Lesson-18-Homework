package guru.qa.tests;

import guru.qa.helpers.apiRequests.Product;
import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static guru.qa.data.TestData.authCookieName;
import static guru.qa.helpers.apiRequests.GetAuth.getAuth;
import static guru.qa.helpers.apiRequests.GetAuth.getAuthCookie;
import static io.qameta.allure.Allure.step;

public class LoginTest extends TestBase {

    @Test
    @Owner("Vladimir Evtushenko")
    @Description("Login UI test with API auth")
    @Severity(SeverityLevel.NORMAL)
    @Feature("DemoQA")
    @Link(value = "QA Guru, Lesson 18, Homework", url = "https://github.com/VEvtushenko/QA-Guru-Lesson-18-Homework")
    @DisplayName("Login UI test with API auth")
    void loginTest() {
        step("Open site for authorization by cookie", () -> {
            open("/favicon.ico");
        });
        step("Get auth cookie and send to site", () -> {
            getAuth(getAuthCookie(authCookieName));
            open("/");
        });
        step("Check auth", () -> {
            $(".header-links-wrapper").shouldHave(text("Log out"));
        });
    }

    @Test
    @Owner("Vladimir Evtushenko")
    @Description("Login UI test with API auth")
    @Severity(SeverityLevel.NORMAL)
    @Feature("DemoQA")
    @Link(value = "QA Guru, Lesson 18, Homework", url = "https://github.com/VEvtushenko/QA-Guru-Lesson-18-Homework")
    @DisplayName("Add product to cart UI test with API adding")
    void addProductToCartTest() {
        step("Open site for authorization by cookie", () -> {
            open("/favicon.ico");
        });
        step("Get auth cookie and send to site", () -> {
            getAuth(getAuthCookie(authCookieName));
            open("/");
        });
        Product.addToCart();
    }
}
