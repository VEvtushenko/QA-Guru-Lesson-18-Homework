package guru.qa.tests;

import io.qameta.allure.*;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static guru.qa.data.TestData.authCookieName;
import static guru.qa.helpers.api.ApiRequests.*;
import static guru.qa.helpers.webDriver.DriverUtils.getAuth;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Owner("Vladimir Evtushenko")
@Feature("DemoQA")
@Link(value = "QA Guru, Lesson 18, Homework", url = "https://github.com/VEvtushenko/QA-Guru-Lesson-18-Homework")
public class DemoWebShopTests extends TestBase {

    @Test
    @Description("Login UI test with API auth")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Login UI test with API auth")
    void loginTest() {
        getAuth(getAuthCookie(authCookieName));
        step("UI check auth", () -> {
            $(".header-links-wrapper").shouldHave(text("Log out"));
        });
        addAttachments();
    }

    @Test
    @Description("Login UI test with API auth")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("API test adding product to cart")
    void addProductToCartTest() {
        Cookie authCookie = getAuthCookie(authCookieName);
        String responseMessage = addToCart(authCookie);
        step("Check confirm message", () -> {
            assertTrue(responseMessage.contains("The product has been added"));
        });
    }

    @Test
    @DisplayName("Adding new user address test")
    void addAddressTest() {

        step("Get auth on site", () -> {
            getAuth(getAuthCookie(authCookieName));
        });
        step("Add address", () -> {
            addUserAddress(getAuthCookie(authCookieName));
        });
        step("Open user address page and check new address", () -> {
            open("/customer/addresses");
            $(".center-2").shouldHave(text("Snark Boojum"));
        });
        addAttachments();
    }
}
