package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.attachments.AllureAttachments;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase  {
    @BeforeAll
    static void setupAPITest() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "http://demowebshop.tricentis.com";
        RestAssured.baseURI = "http://demowebshop.tricentis.com";
    }

    @BeforeEach
    void allureListeners() {
        SelenideLogger.addListener("AllureListener", new AllureSelenide());
    }

    @AfterAll
    static void addAttachments() {
        AllureAttachments.addPageSource();
        AllureAttachments.addScreenshotAs("Final screenshot");
        AllureAttachments.addBrowserLogs();
        Selenide.closeWebDriver();
    }
}
