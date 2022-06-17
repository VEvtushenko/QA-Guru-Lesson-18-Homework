package guru.qa.tests;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static guru.qa.data.TestData.authCookieName;
import static guru.qa.helpers.DriverUtils.getAuth;
import static guru.qa.helpers.ApiRequests.addToCart;
import static guru.qa.helpers.ApiRequests.getAuthCookie;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class demoWebShopTests extends TestBase {

    @Test
    @Owner("Vladimir Evtushenko")
    @Description("Login UI test with API auth")
    @Severity(SeverityLevel.NORMAL)
    @Feature("DemoQA")
    @Link(value = "QA Guru, Lesson 18, Homework", url = "https://github.com/VEvtushenko/QA-Guru-Lesson-18-Homework")
    @DisplayName("Login UI test with API auth")
    void loginTest() {
        getAuth(getAuthCookie(authCookieName));
        step("UI check auth", () -> {
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
        getAuth(getAuthCookie(authCookieName));
        step("Check confirm success adding product to cart in response", () -> {
            assertTrue(addToCart().contains("The product has been added"));
        });
    }
}
